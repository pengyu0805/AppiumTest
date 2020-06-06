package xueqiu;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MainPage {
    private AndroidDriver driver;

    public MainPage() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("deviceName","pengyu");
        desiredCapabilities.setCapability("appPackage","com.xueqiu.package");
        desiredCapabilities.setCapability("appActivity",".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("noReset","true");
        //desiredCapabilities.setCapability("");

        URL remoteUrl=new URL("http://localhost:4723/wd/hub");

        driver=new AndroidDriver(remoteUrl,desiredCapabilities);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }

    public SearchPage toSearch(){
        MobileElement el4= (MobileElement) driver.findElementById("com.xueqiu.android:id/home_search");
        el4.click();
        return new SearchPage(driver);
    }

    public StockPage toStock(){
        WebElement element=(WebElement) driver.findElementsById("com.xueqiu.android:id/tab_name").get(1);
        element.click();
        return new StockPage(driver);
    }
}
