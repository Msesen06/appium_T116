package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class ReusableMethods {

    public static void koordinatTiklama(int x, int y,int bekleme){
        TouchAction action =new TouchAction<>(Driver.getAndroidDriver());

        action.press(PointOption.point(x,y)).release().perform();
        try {
            Thread.sleep(bekleme);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void screenScrollDownToUp(int xPress,int yPress,int wait,int moveX,int moveY){
        TouchAction action =new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(xPress,yPress))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(moveX,moveY))
                .release()
                .perform();
    }
    public static void screenScrollDown(int wait){
        TouchAction action =new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(471,1371))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(471,187))
                .release()
                .perform();
    }

    public static void screenScrollUp(int wait){
        TouchAction action =new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(471,187))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(471,1371))
                .release()
                .perform();
    }

    public static void screenScrollRight(int wait){
        TouchAction action =new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(1052,1016))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(31,1016))
                .release()
                .perform();
    }

    public static void screenScrollLeft(int wait){
        TouchAction action =new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(31,1016))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(1052,1016))
                .release()
                .perform();
    }

    public static void scrollWithUiScrollable(String elementText) {
        AndroidDriver driver = (AndroidDriver)  Driver.getAndroidDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))");
        driver.findElementByXPath("//*[@text='" + elementText + "']").click();
    }
    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot)Driver.getAndroidDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return target;
    }

}
