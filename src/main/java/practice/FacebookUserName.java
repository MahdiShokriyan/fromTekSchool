package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookUserName {
    public static void main(String[] args) {
        var driver = new ChromeDriver();
        var wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://facebook.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text() ='Create new account']")))
                .click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname"))).sendKeys("John");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastname"))).sendKeys("Alexanderia");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("reg_email__"))).sendKeys("bearufik@gmail.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("reg_email_confirmation__"))).sendKeys("bearufik1@gmail.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("reg_passwd__"))).sendKeys("Password@123");

        WebElement monthElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("month")));
        Select monthSelector = new Select(monthElement);
        monthSelector.selectByVisibleText("Feb");

        WebElement dayElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("day")));
        var daySelector = new Select(dayElement);
        daySelector.selectByValue("22");

        WebElement yearElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("birthday_year")));
        var yearSelector = new Select(yearElement);
        yearSelector.selectByValue("1991");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value = '2']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#reg_form_box > div:nth-child(11)> button"))).click();


    }
}
