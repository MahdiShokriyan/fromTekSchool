package practice;

import SeleniumPractice.SeleniumUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomationOnEtsy {
    public static void main(String[] args) {
        String webSite = "https://retail.tekschool-students.com/";
        ChromeDriver driver = new ChromeDriver();
        var utility = new SeleniumUtility(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(webSite);
        driver.manage().window().maximize();

    }
}
