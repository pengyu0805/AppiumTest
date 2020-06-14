package wework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class schedulePage extends BasePage{
    private By add=By.id("gym");
    private final By taskName=By.id("b2k");
    private final By save=byText("保存");
    private final By taskList=By.id("gg_");

    private final By deletlist=By.id("bi1");
    private final By delete=By.id("bfi");
    private final By sure=By.id("b_o");
    private final By modify=By.id("bs2");


    public schedulePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public waittodoPage towaittodoPage(){
        find(By.xpath("//*[@text='待办']"));
        return new waittodoPage(driver);
    }


    public schedulePage addSchedule(String scheduleName,String time){
        //点击添加日程主题
        click(add);
        senkeys(taskName,scheduleName);
        click(save);
        return this;

    }

    public schedulePage deleteSchudule(){
        click(modify);
        click(delete);
        click(sure);
        return this;
    }


    public List<String> getSchedule(String day){
        if(day!=null){
        //选择日期点击
        }
        return driver.findElements(taskList).stream().map(x->x.getText()).collect(Collectors.toList());
    }

}
