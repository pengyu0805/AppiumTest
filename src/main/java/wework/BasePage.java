package wework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasePage {
    String platfromName;
    String deviceName;
    String packageName;
    String activityName;

    //使用AppiumDriver可以同时支持andriod和iOS的自动化，且AndroidDriver是继承AppiumDriver并实现了一些接口
    //<WebElement> 是Java的泛型使用
    public AppiumDriver<MobileElement> driver;

    public BasePage(String platfromName,String deviceName,String packageName,String activityName){
        this.platfromName=platfromName;
        this.deviceName=deviceName;
        this.packageName=packageName;
        this.activityName=activityName;
        startApp(platfromName,deviceName,packageName,activityName);
    }

    public BasePage(AppiumDriver<MobileElement> driver){
        this.driver=driver;
    }

    public void startApp(String platfromName,String deviceName,String packageName,String activityName){
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability("platfromName",platfromName);
        desiredCapabilities.setCapability("deviceName",deviceName);
        desiredCapabilities.setCapability("packageName",packageName);
        desiredCapabilities.setCapability("activityName",activityName);
        desiredCapabilities.setCapability("noReset","True");
        desiredCapabilities.setCapability("dontStopAppNoReset","true");
        desiredCapabilities.setCapability("skipLogcatCapture","true");

        try {
            URL remoteUrl=new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if(platfromName == "Android"){
            driver=new AndroidDriver(desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        else if (platfromName =="Ios"){
            driver =new IOSDriver<MobileElement>(desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        }

    }

    public void quit(){
        driver.quit();
    }

    public By byText(String text){
        //存疑？？？
        return By.linkText(text);
    }

    public MobileElement find(By by){
        return driver.findElement(by);
    }

    public MobileElement find(String text){
        return driver.findElement(byText(text));
    }

    public void click(By by){
        find(by).click();
    }

    public void click(String text){
        find(text).click();
    }

    public void senkeys(By by,String content){
        driver.findElement(by).sendKeys(content);
    }

}
