package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.DOMStringList;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BBCBrokenLink {
    public static void main(String[] args) {
        String SiteLinkToOpen = "https://bbc.com";
        var driver = new ChromeDriver();
        var utility = new SeleniumUtility(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.get(SiteLinkToOpen);


        List<WebElement> allLinks = utility.getElements(By.xpath("//a[@href]"));
        System.out.println(allLinks.size());
        List<String> brokenLinks = new ArrayList<>();

        for (WebElement link : allLinks) {
            String url = link.getAttribute("href");
            if (isLinkBroken(url)) {
                brokenLinks.add(url);
               // System.out.println("Broken link: " + url);
            }
        }
        System.out.println("Broken Lists are: ");
        for (String list : brokenLinks) {
            System.out.println(list);
        }
        System.out.println("quantity of Broken link in "+SiteLinkToOpen+" is :" + brokenLinks.size());
        driver.quit();
    }

    public static boolean isLinkBroken(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int responseCode = connection.getResponseCode();
            return responseCode != 200;
        } catch (IOException e) {
            return true;
        }
    }
}
