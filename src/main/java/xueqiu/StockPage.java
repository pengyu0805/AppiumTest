package xueqiu;

import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;

public class StockPage {
    private AndroidDriver driver;

    public StockPage(AndroidDriver driver){
        this.driver=driver;
    }

    public StockPage deleteAllStock(){
        //
        driver.findElementById("com.xueqiu.android:id/edit_group").click();
        driver.findElementById("com.xueqiu.android:id/check_all").click();
        driver.findElementById("com.xueqiu.android:id/cancel_follow").click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElementById("com.xueqiu.android:id/tv_right").click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElementById("com.xueqiu.android:id/action_close").click();

        return this;
    }

    public StockPage addStock(String name){
        driver.findElementById("com.xueqiu.android:id/action_search").click();
        SearchPage searchPage=new SearchPage(driver);
        searchPage.search(name).addFirstStock();
        return this;
    }

    public boolean isEmpty(){
        //todo 增加判断自选股是否为空
        return true;
    }
}
