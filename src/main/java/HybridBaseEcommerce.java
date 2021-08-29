import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class HybridBaseEcommerce {
    private static Object ChromeDriver;

    public static AndroidDriver<AndroidElement> capabilities(String device) throws MalformedURLException {
        File apk = new File("C:\\Users\\anicolle\\eclipse-workspace\\Tutorial\\src\\main\\apps\\General-Store.apk");
        DesiredCapabilities cap = new DesiredCapabilities();


        if(device.equals("emulator")){
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "device");

        }
        else if(device.equals("real")){
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device"); //to run from real smarthphone
        }
        cap.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
        //cap.setCapability("chromedriverExecutable","C:\\Users\\anicolle\\AppData\\Roaming\\npm\\node_modules\\appium\\node_modules\\appium-chromedriver\\chromedriver\\win\\chromedriver.exe");


        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);

        return driver;

    }
}
