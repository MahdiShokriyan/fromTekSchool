package practice;

import SeleniumPractice.SeleniumUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SiteOfeBay {
    public static void main(String[] args) {
        String webSite = "https://ebay.com";
        var driver = new ChromeDriver();
        var utility = new SeleniumUtility(driver);
        double max=0;

        driver.get(webSite);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        utility.writingOnField(By.xpath("//input[@type='text']"), "laptop");
        utility.clickOnItem(By.id("gh-btn"));

        utility.clickOnItem(By.xpath("//button/span/span[text() = 'Condition']"));
        utility.clickOnItem(By.xpath("//a[@class= 'fake-menu-button__item']/span[text()='New']"));

       // String text = utility.getTheTextOfElement(By.xpath("//a[@target = '_blank']//span[contains(text(),'FHD Intel Celeron J4105 2.8GHz')]"));

        driver.findElement(By.xpath("//span[@class='fake-menu-button srp-controls__control']")).click();
        utility.clickOnItem(By.xpath("//a[@class='fake-menu-button__item']//span[text() = 'Time: newly listed']"));


        //System.out.println(text);
        ArrayList<String> priceList = new ArrayList<>();
        ArrayList<Double> priceInDouble = new ArrayList<>();
        List<WebElement> elemetn = utility.getElements(By.xpath("//span[@class = 's-item__price']"));
        for (WebElement el : elemetn) {
            priceList.add(el.getText());
        }
        for(String s : priceList) {
            //remove all $ and , from the String and return Double number
            String cleanString = s.replace("$", "").replace(",", "");
            if (!cleanString.isEmpty()) {
                try {
                    //changing String to Double
                    double value = Double.parseDouble(cleanString);
                    //add to arraylist
                    priceInDouble.add(value);

                }catch (NumberFormatException e){
                    System.err.println("Error parsing string to double: "+ cleanString);
                }
            }
        }

        for (double price : priceInDouble){
            if (price>max){
                max = price;
            }
        }

        System.out.println("Most Expense Laptop price in the list is: " + max);
      //  driver.quit();


    }
}
