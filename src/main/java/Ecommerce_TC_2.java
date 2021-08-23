import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Ecommerce_TC_2 extends HybridBaseEcommerce {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Anne");
        //driver.hideKeyboard();
        driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"));").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

        //name attribute for toast messages will have content

        String messageToast = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
        System.out.println(messageToast);
        Assert.assertEquals("Please enter your name", messageToast);
    }
}
