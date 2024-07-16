package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SearchTekSchoolGoogle {
    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

        driver.manage().window().maximize();

        By nameLocator = By.name("q");
        driver.findElement(nameLocator).sendKeys("TekSchool");
        Thread.sleep(1000);
        driver.findElement(By.name("btnK")).click();
        Thread.sleep(1000);
        driver.findElement(By.partialLinkText("TEK SCHOOL Modern Workforce")).click();



        By anchorTag = By.tagName("a");
        List<WebElement> anchorElement = driver.findElements(anchorTag);
        System.out.println("Quantity of Link available in the TekSchool Website is: " + anchorElement.size());

        By imageTag = By.tagName("img");
        List<WebElement> imageLocator = driver.findElements(imageTag);
        System.out.println("Quantity of image available in the TekSchool Website is: " + imageLocator.size());


        driver.quit();
    }
}
