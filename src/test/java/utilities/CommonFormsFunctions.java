package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;

public class CommonFormsFunctions extends Base {

    //Forms
    private By nameField= By.xpath("//input[contains(@id,'txtName')]");
    private By displayNameField= By.xpath("//input[contains(@id,'txtDisplayName')]");
    private By descriptionField= By.xpath("//textarea[contains(@id,'txtDescription')]");

    // Buttons in Forms
    private By saveButton = By.xpath("//button[contains(@id,'save')]");
    private By editButton = By.xpath("//button[contains(@id,'edit')]");

    // Buttons in Table
    private By btnEditTable = By.xpath("//div[contains(@id,'toolbarButtons')]//button[@title='Editar' or @title='Edit']");
    private By btnAddTable = By.xpath("//div[contains(@id,'toolbarButtons')]//button[@title='Agregar' or @title='Add']");
    private By btnDeleteTable = By.xpath("//div[contains(@id,'toolbarButtons')]//button[@title='Borrar' or @title='Delete']");
    private By inputFilerTable = By.xpath("//input[contains(@id,'sfFilterTable')]");
    private By btnSearchTable = By.xpath("//div[contains(@id,'sfFilterTable') and contains(@id,'search')]");

    // Section Message Form
    private By messageSectionContent = By.xpath("//div[contains(@id,'messageSection-content')]/span");
    private By closeMessageButton = By.xpath("//button[@title='Cerrar' or @title='Close']");

    // Message in Dialog
    private By messageDialog = By.xpath("//div[contains(@class,'sapMDialogScrollCont')]//span");
    private By parentMessageDialog = By.xpath("//div[contains(@class,'sapMDialogScrollCont')]//span/..");
    private By buttonOKSuccessMessage = By.xpath("//div[contains(@id,'success')]//footer//bdi[text()='OK']");
    private By btnYesConfirmation = By.xpath("//div[contains(@id,'warning')]//footer//bdi[text()='Sí' or text()='Yes']");
    private By btnCloseErrorMessage  = By.xpath("//div[contains(@id,'error')]//footer//bdi[text()='Cerrar' or text()='Close']");

    public CommonFormsFunctions(WebDriver driver){
        super(driver);
    }
    public void fillGeneralForm(String name,String displayName, String description){
        enterName(name);
        enterDisplayName(displayName);
        enterDescription(description);
    }
    public void fillGeneralForm(String displayName, String description){
        enterDisplayName(displayName);
        enterDescription(description);
    }
    // Forms
    public void enterName(String name){ sendKeys(name, nameField); }
    public void clearName(){ clear(nameField); }
    public String getValueName(){ return getAttribute(nameField,"value"); }
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

    // Buttons in Forms
    public void clickBtnSave(){ click(saveButton); }
    public void clickBtnEdit(){ click(editButton); }

    // Buttons in Table
    public void clickBtnAddTable(){click(btnAddTable);}
    public void clickBtnEditTable(){click(btnEditTable);}
    public void clickBtnDeleteTable(){click(btnDeleteTable);}
    public void enterInputFilerTable(String nameElement){
        sendKeys(nameElement,inputFilerTable);
    }
    public void clickBtnSearchTable(){
        click(btnSearchTable);
    }

    // Section Message Form
    public String textMessageSection(){return getText(messageSectionContent);}
    public void clickBtnCloseMessage(){ click(closeMessageButton); }

    // Message in Dialog
    public String textMessageDialog(){ return getText(messageDialog); }
    public void confirmSuccessOperation(){ click(buttonOKSuccessMessage); }
    public void confirmDeleteObject(){ click(btnYesConfirmation); }
    public void closeErrorOperation(){click(btnCloseErrorMessage);}
}
