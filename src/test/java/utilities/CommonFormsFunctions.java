package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.Base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommonFormsFunctions extends Base {

    //Forms
    private By nameField= By.xpath("//input[contains(@id,'txtName')]");
    private By displayNameField= By.xpath("//input[contains(@id,'txtDisplayName')]");
    private By descriptionField= By.xpath("//textarea[contains(@id,'txtDescription')]");

    // Buttons in Forms
    private By saveButton = By.xpath("//button[contains(@id,'save')]");
    private By editButton = By.xpath("//button[contains(@id,'edit')]");
    private By addButton =  By.xpath("//div[@class='sapUiView sapUiXMLView sapMNavItem']//button[contains(@id,'add')]");
    private By viewDependenciesButton = By.xpath("//button[contains(@id,'viewDependencies')]");

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
    private By buttonOKSuccessMessage = By.xpath("//div[contains(@id,'success')]//footer//bdi[text()='OK']");
    private By btnYesConfirmation = By.xpath("//div[contains(@id,'warning')]//footer//bdi[text()='Sí' or text()='Yes']");
    private By btnCloseErrorMessage  = By.xpath("//div[contains(@id,'error')]//footer//bdi[text()='Cerrar' or text()='Close']");

    // Dependencies Section
    private By dependenciesTableTitle = By.xpath("//div[contains(@id,'dependenciesTableTitle') ]");

    // Section Nav List
    private By buttonMore = By.xpath("//div[@class='sapUiView sapUiXMLView sapMNavItem']//span[(text()='Más' or text()='More')]");

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

    public void enterDateField(String id, String date) throws ParseException {
        String[] dateParts = getDateParts(date);
        String day = dateParts[0];
        String month = dateParts[1];
        String year = dateParts[2];

        clickIconDate(id);
        // Select Year
        clickBtnYearCalendar(id);
        clickYearElement(id,year);
        //Select Month
        clickBtnMonthCalendar(id);
        clickMonthElement(id,month);
        // Select Day
        clickDayElement(id,day);
    }
    public void clickIconDate(String id){
        click(By.xpath("//span[contains(@id,'"+id+"-icon')]"));
    }
    public void clickBtnYearCalendar(String id){
        click(By.xpath("//button[contains(@id,'"+id+"-cal--Head-B2')]"));
    }
    public void clickYearElement(String id,String year){
        click(By.xpath("//div[contains(@id,'"+id+"-cal')]//div[text()='"+year+"']"));
    }
    public void clickBtnMonthCalendar(String id){
        click(By.xpath("//button[contains(@id,'"+id+"-cal--Head-B1')]"));
    }
    public void clickMonthElement(String id, String month){
        click(By.xpath("//div[contains(@id,'"+id+"-cal--MP-m"+ month +"')]"));
    }
    public void clickDayElement(String id, String day){
        click(By.xpath("//div[contains(@id,'"+id+"-cal')]//span[text()='"+day+"']"));
    }
    private String[] getDateParts(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date parsedDate = dateFormat.parse(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parsedDate);

        String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String month = String.valueOf(calendar.get(Calendar.MONTH)); // Los meses en Java van de 0 a 11
        String year = String.valueOf(calendar.get(Calendar.YEAR));

        return new String[]{day, month, year};
    }

    // Buttons in Forms
    public void clickBtnSave(){ click(saveButton); }
    public void clickBtnEdit(){ click(editButton); }
    public void clickBtnAdd(){ click(addButton); }
    public void clickBtnViewDependencies(){click(viewDependenciesButton);}

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

    // Dependencies Section
    public String getTitleListDependencies(){
        return getText(dependenciesTableTitle);
    }

    // Section Nav List
    public void clickBtnMore(){
        try {
            do {
                click(buttonMore);
            } while (isDisplayed(buttonMore));
        }catch (Exception e){
            System.out.println(e.getCause());
        }
    }
    public void clickBtnDeleteItem(String nameItem){
        By buttonDeleteItem = By.xpath("//div[text()='"+nameItem+"']/parent::div/parent::div/following-sibling::button");
        click(buttonDeleteItem);
    }
}
