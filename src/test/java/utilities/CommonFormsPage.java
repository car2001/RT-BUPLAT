package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;

public class CommonFormsPage extends Base {
    private By nameField= By.xpath("//input[contains(@id,'txtName')]");
    private By displayNameField= By.xpath("//input[contains(@id,'txtDisplayName')]");
    private By descriptionField= By.xpath("//textarea[contains(@id,'txtDescription')]");
    private By saveButton = By.xpath("//button[contains(@id,'save')]");
    private By editButton = By.xpath("//button[contains(@id,'edit')]");
    private By messageSectionContent = By.xpath("//div[contains(@id,'messageSection-content')]/span");
    private By closeMessageButton = By.xpath("//button[@title='Cerrar' or @title='Close']");
    private By messageDialog = By.xpath("//div[contains(@class,'sapMDialogScrollCont')]//span");
    private By buttonOKDialog = By.xpath("//footer//bdi[text()='OK']");
    public CommonFormsPage(WebDriver driver){
        super(driver);
    }

    public void fillGeneralForm(String name,String displayName, String description){
        enterName(name);
        enterDisplayName(displayName);
        enterDescription(description);
    }

    public void enterName(String name){ sendKeys(name, nameField); }
    public void clearName(){ clear(nameField); }
    public void enterDisplayName(String displayName){
        sendKeys(displayName, displayNameField);
    }
    public void clearDisplayName(){
        clear(displayNameField);
    }
    public void enterDescription(String description){
        sendKeys(description, descriptionField);
    }
    public void clearDescription(){
        clear(descriptionField);
    }
    public void clickBtnSave(){ click(saveButton); }
    public void clickBtnEdit(){ click(editButton); }
    public String textMessageSection(){return getText(messageSectionContent);}
    public void clickBtnCloseMessage(){ click(closeMessageButton); }
    public String textMessageDialog(){ return getText(messageDialog); }
    public void clickBtnOkDialog(){ click(buttonOKDialog); }

}
