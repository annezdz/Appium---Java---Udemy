import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Ecommerce_TC_3 extends HybridBaseEcommerce {
    public static void main(String[] args) throws MalformedURLException {
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
                ".scrollIntoView(new UiSelector().textMatches(\"Jordan Lift Off\").instance(0))"));

        int count = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
        for (int i = 0 ; i < count ; i++){
            String name = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();

            if(Objects.equals(name, "Jordan Lift Off"))
            {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                break;
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
    }
}
