package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class activity04 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bbc.com");
        Thread.sleep(1000);
        By partialLink = By.partialLinkText("Bandaged Trump gets rapturous wel");
        driver.findElement(partialLink).click();

    }
}
