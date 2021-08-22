import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class HybridBase {
    public static AndroidDriver<AndroidElement> capabilities(String device) throws MalformedURLException {
        File apk = new File("C:\\Users\\anicolle\\eclipse-workspace\\Tutorial\\src\\main\\java\\ApiDemos-debug.apk");
        DesiredCapabilities cap = new DesiredCapabilities();

        if(device.equals("emulator")){
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "device");

        }
        else if(device.equals("real")){
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device"); //to run from real smarthphone
        }
        cap.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);

        return driver;
    }
}
