package day2;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class arabamCom {
    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities =new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");

       // capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\HP\\Desktop\\appium_T116\\Apps\\arabam.com_4.8.0_Apkpure.apk");
        capabilities.setCapability("appPackage","com.dogan.arabam");
        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void arabamComTesti() throws InterruptedException {
        //uygulamanın yuklendigini dogrulayalım
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));
        //uygulamanın anasayfada acıldıgını test edelim
        AndroidElement headerKontrol=driver.findElementById("com.dogan.arabam:id/tvShowroomInfo");
        Assert.assertTrue(headerKontrol.isDisplayed());
        // Arabam kac para bolumune tiklayalim
        driver.findElementByXPath("//*[@text='Arabam kaç para?']").click();

        // Aracimin fiyatini merak ediyorum bolumunetiklayalim
        driver.findElementByXPath("//*[@text='Aracımın fiyatını merak ediyorum']").click();

        // Wolkswagen markasini secelim
        TouchAction action =new TouchAction<>(driver);
        action.press(PointOption.point(535,1726))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(535,240))
                .release()
                .perform();

        Thread.sleep(1500);

        driver.findElementByXPath("//*[@text='Volkswagen']").click();

        // yil secimi yapalim
        driver.findElementByXPath("//*[@text='2018']").click();
        // model secimi yapalim
        driver.findElementByXPath("//*[@text='Passat']").click();
        // govde tipini secelim
        driver.findElementByXPath("//*[@text='Sedan']").click();
        // yakit tipini secelim
        driver.findElementByXPath("//*[@text='Benzin']").click();
        // vites tipini secelim
        driver.findElementByXPath("//*[@text='Düz']").click();
        // Versiyon secimi yapalim
       //493,622
        Thread.sleep(1000);
        action.press(PointOption.point(493,622))
                .release()
                .perform();
        // aracin km bilgilerini girelim
        AndroidElement kmBox=driver.findElementById("com.dogan.arabam:id/et_km");
        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("150000");
        } else {
            kmBox.sendKeys("150000");
        }
        driver.findElementByXPath("//*[@text='Devam']").click();
        Thread.sleep(1000);
        // aracin rengini secelim
        driver.findElementByXPath("(//*[@class='android.widget.LinearLayout'])[17]").click();

        // opsiyel donanim (varsa) seecelim
        driver.findElementByXPath("//*[@text='Devam']").click();
        // degisen bilgisi ekleyerek tramer kaydi belirtelim
        Thread.sleep(1000);
        action.press(PointOption.point(538,795)).release().perform();
        action.press(PointOption.point(233,1609)).release().perform();

        Thread.sleep(1000);
        driver.findElementByXPath("//*[@text='Devam']").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//*[@text='Tramer kaydı yok']").click();

        driver.findElementByXPath("//*[@text='Devam']").click();

        // aracimizin fiyatinin 500.000 tl den fazla oldugunu test edelim
        AndroidElement ortalamaFiyatElementi=driver.findElementById("com.dogan.arabam:id/tvAveragePrice");
        String ortalamaFiyatStr=ortalamaFiyatElementi.getText();//1.026.500 TL
        System.out.println(ortalamaFiyatStr);
        ortalamaFiyatStr=ortalamaFiyatStr.replace("\\D","");
        System.out.println(ortalamaFiyatStr);
        Assert.assertTrue(Integer.parseInt(ortalamaFiyatStr)>500000);
        // uygulamayi kapatalim
        driver.closeApp();

    }
}
