package tests.apkYukleme;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class apkYukleme {
    AndroidDriver<AndroidElement> driver;

    @Test
    public void apkYukleme() throws MalformedURLException {
        final String cihazIsmi="Pixel 2";
        DesiredCapabilities capabilities =new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,cihazIsmi);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\HP\\Desktop\\appium_T116\\Apps\\all-currency-converter-3-9-0 (1).apk");
        capabilities.setCapability("appPackage","com.smartwho.SmartAllCurrencyConverter.CurrencyConverter");
        capabilities.setCapability("appActivity","com.smartwho.SmartAllCurrencyConverter");

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}
