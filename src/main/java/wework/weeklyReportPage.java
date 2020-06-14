package wework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

public class weeklyReportPage extends BasePage{
    private final By weekcontent= By.xpath("//android.webkit.WebView[@content-desc=\"周报\"]/android.widget.EditText[1]");
    private final By nextweekcontent=By.xpath("//android.webkit.WebView[@content-desc=\"周报\"]/android.widget.EditText[2]");
    private final By otherweekcontent=By.xpath("//android.webkit.WebView[@content-desc=\"周报\"]/android.widget.EditText[3]");
    private final By setting=By.id("gym");
    private final By submit=By.id("提交");
    private final By sure=By.id("b_o");

    private final By deletebutton= By.xpath("//*[@text='删除']");
    private final By delsurebutton= By.xpath("//*[@text='确定']");
    private final By modifybutton=By.xpath("//*[@text='修改']");

    public weeklyReportPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public weeklyReportPage addweeklyreport(String todaycontent,String plancontent,String othercontent){
        senkeys(weekcontent,todaycontent);
        senkeys(nextweekcontent,plancontent);
        senkeys(otherweekcontent,othercontent);

        swipedown();
        click(submit);
        click(sure);

        return  this;
    }

    public reportPage deleteweeklyreport(){
        click(setting);
        click(deletebutton);
        click(delsurebutton);
        return new reportPage(driver);
    }

    public weeklyReportPage modifyweeklyreport(String todaycontent,String plancontent,String othercontent){
        click(setting);
        click(modifybutton);
        addweeklyreport(todaycontent,plancontent,othercontent);
        return this;
    }

    //todo:完成转发周报
    public weeklyReportPage transmit(){
        return this;
    }

    public List<MobileElement> getweeklyContent(String todaycontent){
        return driver.findElementsByXPath("//android.view.View[@content-desc=todaycontent]");
    }
}
