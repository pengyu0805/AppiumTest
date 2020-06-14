package wework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

public class dailyReportPage extends BasePage{
    private final By todayworkcontext =By.xpath("//android.webkit.WebView[@content-desc=\"日报\"]/android.widget.EditText[1]");
    private final By planworkcontext =By.xpath("//android.webkit.WebView[@content-desc=\"日报\"]/android.widget.EditText[2]");
    private final By othercontext =By.xpath("//android.webkit.WebView[@content-desc=\"日报\"]/android.widget.EditText[3]");

    private final By setting=By.id("gym");
    private final By submit=By.id("提交");
    private final By sure=By.id("b_o");

    private final By deletebutton= By.xpath("//*[@text='删除']");
    private final By delsurebutton= By.xpath("//*[@text='确定']");
    private final By modifybutton=By.xpath("//*[@text='修改']");


    public dailyReportPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public dailyReportPage adddailyReport(String todaywork,String planwork,String otherwork){
        click(todayworkcontext);
        senkeys(todayworkcontext,todaywork);
        senkeys(planworkcontext,planwork);
        senkeys(othercontext,otherwork);
        click(submit);
        click(sure);
        return this;
    }

    public platfromPage deletedailyreport(){
        click(setting);
        click(deletebutton);
        click(sure);
        return new platfromPage(driver);
    }

    public dailyReportPage modifydailyreport(String todaycontent,String plancontent,String othercontent){
        click(setting);
        click(modifybutton);
        adddailyReport(todaycontent,plancontent,othercontent);
        return this;
    }

    //todo:完成转发周报
    public dailyReportPage transmit(){
        return this;
    }

    public List<MobileElement> getdailyContent(String todaycontent){
        return driver.findElementsByXPath("//android.view.View[@content-desc=todaycontent]");
    }

}
