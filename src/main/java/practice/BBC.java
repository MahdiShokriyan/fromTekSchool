package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BBC {
    public static void main(String[] args) {

        ChromeDriver bbcDriver = new ChromeDriver();
        bbcDriver.manage().window().maximize();

        bbcDriver.get("https://www.bbc.com/");

        By anchorElement = By.tagName("a");
       List< WebElement > anchorElements = bbcDriver.findElements(anchorElement);
     System.out.println(anchorElements.size());

    }
}
