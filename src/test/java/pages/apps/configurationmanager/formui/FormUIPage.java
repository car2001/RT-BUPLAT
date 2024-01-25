package pages.apps.configurationmanager.formui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;

public class FormUIPage extends Base {

    private By itemMenuReusableComp = By.xpath("//div[@title='Reusable Component']");
    private By itemMenuFormUI = By.xpath("//div[@title='Form UI Configuration']");
    private By switchComments = By.xpath("//div[contains(@id,'comments-switch')]");
    private By parentComments= By.xpath("//div[contains(@id,'comments-switch')]/..");
    private By switchAttachments = By.xpath("//div[contains(@id,'attachments-switch')]");
    private By parentAttachments = By.xpath("//div[contains(@id,'attachments-switch')]/..");

    public FormUIPage(WebDriver driver){
        super(driver);
    }
    public void fillFormUIDataForm(String useComments, String useAttachments) {
        // Use Comments
        clickUseComments(useComments.contains("true") ? "true" : "false");
        // Use Attachments
        clickUseAttachments(useAttachments.contains("true") ? "true" : "false");
    }
    public void clickMenuReusableComp(){
        click(itemMenuReusableComp);
    }
    public void clickLiFormUI(){
        click(itemMenuFormUI);
    }
    public void clickFormUISelect(String formUI){
        By formUISelect = By.xpath("//li//div[text()='"+formUI+"']");
        click(formUISelect);
    }
    public void clickUseComments(String useComments){
        String ariaChecked = getAttribute(parentComments,"aria-checked");
        if(ariaChecked != ""){
            if(!useComments.equals(ariaChecked)){
                click(switchComments);
            }
        }
    }
    public void clickUseAttachments(String useAttachments){
        String ariaChecked = getAttribute(parentAttachments,"aria-checked");
        if(ariaChecked != ""){
            if(!useAttachments.equals(ariaChecked)){
                click(switchAttachments);
            }
        }
    }
}
