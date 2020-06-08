package wework;

public class weworkPage extends BasePage{
    public weworkPage(){
        super("Android","test","com.tencent.wework",".launch.LaunchSplashActivity");
    }

    public platfromPage toPlatfromPage(){
        //增加
        return new platfromPage(driver);
    }

    //前往通讯录页面，增加方法 增加通讯录Page类

}
