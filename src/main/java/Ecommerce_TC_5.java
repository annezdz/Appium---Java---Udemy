import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Ecommerce_TC_5 extends HybridBaseEcommerce {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AndroidDriver<AndroidElement> driver = capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Anne");
        driver.hideKeyboard();
        driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
        driver.findElementById("android:id/text1").click();

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"));").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()" +
                ".resourceId(\"com.androidsample.generalstore:id/rvProductList\"))" +
                ".scrollIntoView(new UiSelector().textMatches(\"Air Jordan 4 Retro\").instance(0))"));

        int count = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
        for (int i = 0 ; i < count ; i++){
            String name = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();

            if(Objects.equals(name, "Air Jordan 4 Retro"))
            {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                break;
            }
        }
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()" +
                ".resourceId(\"com.androidsample.generalstore:id/rvProductList\"))" +
                ".scrollIntoView(new UiSelector().textMatches(\"Air Jordan 1 Mid SE\").instance(0))"));

        for (int i = 0 ; i < count ; i++){
            String name = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();

            if(Objects.equals(name, "Air Jordan 1 Mid SE"))
            {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                break;
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        Thread.sleep(4000);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"$160.97\"));");




        //Mobile Gestures

        //driver.findElement(By.className("android.widget.CheckBox")).click();
        WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));

        TouchAction action = new TouchAction(driver);
        action.tap(tapOptions().withElement(element(checkbox))).perform();

        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

        Thread.sleep(6000);
        Set<String> contexts = driver.getContextHandles();

        for(String contextName : contexts){
            System.out.println(contextName);
        }

        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("Appium Lovers");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }


}
