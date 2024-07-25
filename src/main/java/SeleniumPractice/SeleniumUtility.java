package SeleniumPractice;


import org.openqa.selenium.*;
import java.util.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumUtility {
    private WebDriver driver;
    private WebDriverWait wait;

    public SeleniumUtility(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //Getter for variables
    public WebDriver getDriver() {return driver;}
    public WebDriverWait getWait() {return wait;}

    public void clickOnItem(By locator){
                getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void writingOnField(By locator, String text){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    public String getTheTextOfElement(By locator){
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public List<WebElement> getElements(By locator){
        return getDriver().findElements(locator);
    }

}
