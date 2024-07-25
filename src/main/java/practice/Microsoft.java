package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Microsoft {

    public static void main(String[] args)  {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.microsoft.com/en-us/");
        driver.findElement(By.cssSelector("#mectrl_main_trigger:first-child >div >div:first-child")).click();

        By loginInput = By.xpath("//input[contains(@name, 'loginfmt')]");
        WebElement element = driver.findElement(loginInput);
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys("abc@gmail.com");

        By clickOnNext = By.xpath("//button[@type = 'submit']");
        WebElement clickElement = driver.findElement(clickOnNext);
        wait.until(ExpectedConditions.elementToBeClickable(clickElement)).click();

        By passwordLocator = By.xpath("//input[@name= 'passwd']");
        WebElement passwordElement = driver.findElement(passwordLocator);
        wait.until(ExpectedConditions.visibilityOf(passwordElement)).sendKeys("WrongPassword");

        By loginBtn = By.cssSelector("#idSIButton9");
        WebElement loginElement = driver.findElement(loginBtn);
        wait.until(ExpectedConditions.elementToBeClickable(loginElement)).click();

        String text = driver.findElement(By.xpath("//div[contains(text() , 'Your account or password')]")).getText();
        System.out.println(text);

        driver.quit();

    }
}
