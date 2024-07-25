package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.Utilities;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableInTekInsurance {
    public static void main(String[] args) {
        var driver = new ChromeDriver();
        var utilityObj = new SeleniumUtility(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://dev.insurance.tekschool-students.com/");
        //click on login Button
        utilityObj.clickOnItem(By.xpath("//a[@href='/login']"));
        //write username in username field
        utilityObj.writingOnField(By.name("username"), "Supervisor");
        //type password in password field
        utilityObj.writingOnField(By.name("password"), "tek_supervisor");
        //click on sign in button
        utilityObj.clickOnItem(By.xpath("//button[text()='Sign In']"));
        //click on plans table
        utilityObj.clickOnItem(By.xpath("//a[@href='/csr/plans']"));
        //geting a list of webElement of all the table rows
        List<WebElement> tableRows = utilityObj.getElements(By.xpath("//table/tbody/tr"));
        //creating an empty map to put the element in it
        HashMap<String, String> myMap = new HashMap<>();
        //loop through all the rows
        for (int row = 0; row < tableRows.size(); row++) {
            String xpathForPlanType = "//table/tbody/tr[" + (row + 1) + "]/td[2]";
            String xpathForPrice = "//table/tbody/tr[" + (row + 1) + "]/td[4]";

           String keyPlan =  utilityObj.getTheTextOfElement(By.xpath(xpathForPlanType));
           String valuePrice =  utilityObj.getTheTextOfElement(By.xpath(xpathForPrice));
            myMap.put(keyPlan,valuePrice);
        }

        List< Map<String , String>> tableValues = new ArrayList<>();
        for (int row =0 ; row <= tableRows.size()-1; row++){
            Map<String,String> rowData = new HashMap<>();
            List<WebElement> column = utilityObj.getElements(By.xpath("//table/tbody/tr[1]/td"));
            for (int col= 0 ; col<column.size(); col++){
                if(col==0) continue;
                    String xpathForHeader = "//table/thead/tr/th["+(col +1)+"]";
                    String xpathCell = "//table/tbody/tr["+(row+1)+"]/td["+(col+1)+"]";

                    String key = utilityObj.getTheTextOfElement(By.xpath(xpathForHeader));
                    String value = utilityObj.getTheTextOfElement(By.xpath(xpathCell));
                    rowData.put(key,value);



            }
            tableValues.add(rowData);
        }
        System.out.println(tableValues);




driver.quit();
    }
}
