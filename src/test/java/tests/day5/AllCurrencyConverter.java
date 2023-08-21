package tests.day5;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllCurencyConverterPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class AllCurrencyConverter {
    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
    AllCurencyConverterPage allCurencyConverterPage =new AllCurencyConverterPage();

    @Test
    public void allCurrencyTest() throws IOException {

        // all currency uygulamasinin yuklendigi dogulanir
        Assert.assertTrue(driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter.CurrencyConverter"));
        // uygulamanin acildigi dogrulanir
        String expectedIcerik=allCurencyConverterPage.updateButton.getText();
        String actualICerik="CURRENCY" +
                "UPDATE";
        Assert.assertEquals(actualICerik,expectedIcerik);
        // cevirmek istedigimiz para birimi zloty olarak secilir
        ReusableMethods.koordinatTiklama(438,337,1000);
        ReusableMethods.scrollWithUiScrollable("PLN");
        // cevirelecek olan para birimi Tl olarak secilir
        ReusableMethods.koordinatTiklama(428,490,1000);
        ReusableMethods.scrollWithUiScrollable("Turkish Lira");
        ReusableMethods.scrollWithUiScrollable("1");
        ReusableMethods.scrollWithUiScrollable("0");
        ReusableMethods.scrollWithUiScrollable("0");
        ReusableMethods.scrollWithUiScrollable("0");
        // cevrilen tutar screenShot olarak kaydedilir
        File ekranGoruntusu =driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(ekranGoruntusu,new File("Ceviri-Sonuc.png"));
        // Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
        String exchangeResult=allCurencyConverterPage.result.getText();
        driver.sendSMS("5455454454546",exchangeResult);
        // bu islem dolar tl, sweden kron-tl, Japon yeni- tl olarak tekrarlanir ve kullaniciya sms olarak bildirilir


    }
}
