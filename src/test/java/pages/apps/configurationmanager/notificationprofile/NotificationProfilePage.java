package pages.apps.configurationmanager.notificationprofile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;

public class NotificationProfilePage extends Base {

    private By itemMenuReusableComp = By.xpath("//div[@title='Reusable Component']");
    private By itemMenuNP = By.xpath("//div[@title='Notification Profile']");
    private By btnAdd = By.xpath("//button[contains(@id,'addItem')]");
    private By arrowEventType = By.xpath("//tbody[contains(@id,'configurationTable')]//span[contains(@id,'arrow')]");
    private By liAbort = By.xpath("//ul[contains(@class,'sapMSelectList ')]//li[text()='Abort']");

    public NotificationProfilePage(WebDriver driver){
        super(driver);
    }

    public void clickMenuReusableComp(){
        click(itemMenuReusableComp);
    }
    public void clickLiNP(){ click(itemMenuNP); }
    public void clickNotificationSelect(String notification){
        By notificationProfileSelect = By.xpath("//li//div[text()='"+notification+"']");
        click(notificationProfileSelect);
    }
    public void selectEventType(){
        clickBtnAddItem();
        click(arrowEventType);
        click(liAbort);
    }
    public void clickBtnAddItem(){
        click(btnAdd);
    }
}
