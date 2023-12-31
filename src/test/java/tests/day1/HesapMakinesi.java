package tests.day1;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HesapMakinesi {

    AndroidDriver<MobileElement> driver;
    AppiumDriver<MobileElement> driver2;

    @Test
    public void hesapMakinesi() throws MalformedURLException {

        // kullanici gerekli kurulumlari yapar
        DesiredCapabilities capabilities =new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\HP\\Desktop\\appium_T116\\Apps\\Calculator_8.4.1 (520193683)_Apkpure.apk");

        driver =new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



        // uygulamanin yuklendigini dogrular(isInstalled)
        Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));

        // uygulamanin acildigini dogrular
        AndroidElement acButonu= (AndroidElement) driver.findElementById("com.google.android.calculator:id/clr");
        Assert.assertTrue(acButonu.isDisplayed());
        // carpma,bolme,toplama,cikarma islemleri yaparak sonuclari dogrular

        driver.findElementByAccessibilityId("2").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementByAccessibilityId("2").click();
        driver.findElementByAccessibilityId("5").click();
        driver.findElementByAccessibilityId("equals").click();

        String actualResult=driver.findElementById("com.google.android.calculator:id/result_final").getText();

        int expectedResult=500;

        Assert.assertEquals(Integer.parseInt(actualResult),expectedResult);

        // AC butonuna tiklayarak ana ekrani temizler
        acButonu.click();


    }

}
