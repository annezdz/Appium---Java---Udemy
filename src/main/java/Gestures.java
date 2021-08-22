import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Gestures extends Base{
    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"));");
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        By expandList = MobileBy.AccessibilityId("Expandable Lists");

        TouchAction action = new TouchAction(driver);
        action.tap(tapOptions().withElement(element(driver.findElement(expandList)))).perform();
        driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
        WebElement peopleNames = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
        action.longPress(longPressOptions().withElement(element(peopleNames))
                .withDuration(Duration.ofSeconds(2))).release().perform();

        System.out.println(driver.findElementById("android:id/title").isDisplayed());


//        TouchAction t = new TouchAction(driver);
//        AndroidElement expandLinst = driver.findElementByAccessibilityId("Expandable Lists");
//        t.tap(tapOptions().withElement(element(expandLinst))).perform(); (don't work)

    }
}
