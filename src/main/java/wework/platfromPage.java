package wework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class platfromPage extends BasePage{
    public platfromPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public schedulePage toschedulePage(){
        //填写具体的xpath路径
        click(By.xpath("//*[@text='日程']"));
        return new schedulePage(driver);
    }

    public dailyReportPage todailyPage(){
        //增加具体的操作进入日报页面
        return new dailyReportPage(driver);
    }
    /*
    public weeklyReportPage toweeklyPage(){
        //增加具体的操作进入周报页面
        return new weeklyReportPage(driver);
    }
    */


    public reportPage toreportPage(){
        //滑动屏幕找到日程按钮，点击进入日程页面

        swipedown();
        find(By.xpath("//*[@text='汇报']"));

        return new reportPage(driver);
    }


}
