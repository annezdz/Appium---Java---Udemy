import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import java.net.MalformedURLException;

public class Browser extends BaseNavigator {

    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = capabilities();
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector(".navbar-toggler")).click();
        driver.findElement(By.cssSelector("a[href*='products']")).click();

        JavascriptExecutor rollbackScript = (JavascriptExecutor) driver;
        rollbackScript.executeScript("window.scrollBy(0,1000)","");

        String text = driver.findElement(By.xpath("(//li[@class='list-group-item'])[3]/div/div/a"))
                .getText();
        Assert.assertEquals(text,"Devops");
    }
}
