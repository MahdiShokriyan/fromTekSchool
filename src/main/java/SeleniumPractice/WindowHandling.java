package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class WindowHandling {
    public static void main(String[] args) throws InterruptedException {

        var driver = new ChromeDriver();
        var utility = new SeleniumUtility(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://retail.tekschool-students.com/");
        Thread.sleep(2000);
        String currentTabID = driver.getWindowHandle();
        utility.clickOnItem(By.linkText("Test Selenium"));


        Thread.sleep(2000);
        Set<String> allTabs = driver.getWindowHandles();
        for (String list : allTabs) System.out.println(list);
        for (String tab : allTabs) {
            if (!tab.equals(currentTabID)) {
                driver.switchTo().window(tab);
            }
        }
        Thread.sleep(2000);
        utility.clickOnItem(By.linkText("Inputs"));
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(currentTabID);
        Thread.sleep(1000);
        utility.clickOnItem(By.id("signinLink"));

        driver.quit();

    }
}
