package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BBCTagLocator {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://bbc.com");
        Thread.sleep(3000);
        By anchorTag = By.tagName("a");
        List< WebElement > anchorElement = driver.findElements(anchorTag);

        System.err.println("Quantity of Link available in the BBC Website is: " + anchorElement.size());

        By imageTag = By.tagName("img");
        List<WebElement> imageLocator = driver.findElements(imageTag);
        System.err.println("Quantity of image available in the BBC Website is: " + imageLocator.size());

        By buttons = By.tagName("button");
        List<WebElement> buttonLocator = driver.findElements(buttons);
        System.err.println("Quantity of Button available in the BBC Website is: " + buttonLocator.size());
        for (WebElement element : buttonLocator){
            String text = element.getText();
            if (!text.isEmpty()){
                System.out.println(text);
            }
        }

        driver.quit();
    }
}
