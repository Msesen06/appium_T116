package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KiwiPage {
    public KiwiPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
    }

    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement devamButonu;

    @FindBy(xpath = "//*[@class='android.widget.EditText']")
    public WebElement kalkisUlkesiTextBox;

    @FindBy(xpath = "(//*[@class='android.view.View'])[8]")
    public WebElement fromBoxIlkSecenek;

    @FindBy(xpath = "//*[@text='Choose']")
    public WebElement chooseButonu;

    @FindBy(xpath = "//*[@text='Set date']")
    public WebElement setDateButonu;

    @FindBy(xpath = "//*[@text='Search']")
    public WebElement searchButonu;

    @FindBy(xpath = "//*[@class='(//*[@class='android.widget.TextView'])[12]']")
    public WebElement fiyatSonucu;

    public void ilkSayfaGecisButonlari() throws InterruptedException {
        TouchAction action =new TouchAction<>(Driver.getAndroidDriver());
        for (int i = 0; i < 3; i++) {
            action.press(PointOption.point(538,1689)).release().perform();
            Thread.sleep(2000);
        }
    }

}
