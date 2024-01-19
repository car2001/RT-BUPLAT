package pages.apps.securitymanager.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;
import utilities.CommonFormsFunctions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UserPage extends Base {

    private CommonFormsFunctions commonFormsFunctions;
    private By menuUserAndRole = By.xpath("//div[@title='User & Role Management' or @title='Gestión de Usuarios y Roles']");
    private By listItemUser = By.xpath("//div[@title='User' or @title='Usuario']");
    private By listItemUserGroup = By.xpath("//div[@title='User Group' or @title='Grupo de Usuario']");

    private By userNameInput = By.xpath("//input[contains(@id,'buserUsername')]");
    private By passwordInput = By.xpath("//input[contains(@id,'buserPassword')]");
    private By confirmPasswordInput = By.xpath("//input[contains(@id,'buserConfirmPassword')]");
    private By contactEmailInput = By.xpath("//input[contains(@id,'buserEmail')]");

    private String validityStartDateId = "buserValidityStartDate";
    private String validityEndDateId   = "buserValidityEndDate";

    private By nameInput = By.xpath("//input[contains(@id,'buserName')]");
    private By lastNameInput = By.xpath("//input[contains(@id,'buserLastName')]");

    private By companyArrowInput = By.xpath("//span[contains(@id,'buserCorporation-arrow')]");
    private By orgUnitArrowInput = By.xpath("//span[contains(@id,'buserOrgUnit-arrow')]");
    private By positionArrowInput = By.xpath("//span[contains(@id,'buserPosition-arrow')]");

    private By licenseCategoryArrowInput = By.xpath("//bdi[text()='License Category' or text()='Categoría de Licencia']//..//..//..//..//span[contains(@id,'arrow') and @role='button']");

    private By yesSendNotificationBtn = By.xpath("//div[contains(@id,'confirm')]//footer//bdi[text()='Sí' or text()='Yes']");
    private By noSendNotificationBtn = By.xpath("//div[contains(@id,'confirm')]//footer//bdi[text()='No' or text()='No']");

    public UserPage(WebDriver driver){
        super(driver);
        this.commonFormsFunctions = new CommonFormsFunctions(driver);
    }

    public void clickMenuUserAndRole(){
        click(menuUserAndRole);
    }
    public void clickLiUser(){
        click(listItemUser);
    }
    public void clickUserSelect(String user){
        By userSelect = By.xpath("//li//div[text()='"+user+"']");
        click(userSelect);
    }

    public void fillUserDataForm(String username,String password, String email, String startDate, String endDate, String name, String lastName, String company, String orgUnit,String position, String licenseCategory) throws ParseException {
        enterUserName(username);
        enterPassword(password);
        enterConfirmPassword(password);
        enterContactEmail(email);
        enterValidityStartDateField(startDate);
        enterValidityEndDateField(endDate);
        enterName(name);
        enterLastName(lastName);
        selectCompany(company);
        selectOrgUnit(orgUnit);
        selectPosition(position);
        selectLicenseCategory(licenseCategory);
    }

    public void enterUserName(String username){
        sendKeys(username,userNameInput);
    }
    public void clearUserName(){
        clear(userNameInput);
    }
    public void enterPassword(String password){
        sendKeys(password,passwordInput);
    }
    public void enterConfirmPassword(String password){
        sendKeys(password,confirmPasswordInput);
    }
    public void enterContactEmail(String email){
        sendKeys(email,contactEmailInput);
    }
    public void enterValidityStartDateField(String startDate) throws ParseException {
        commonFormsFunctions.enterDateField(validityStartDateId,startDate);
    }
    public void enterValidityEndDateField(String endDate) throws ParseException {
        commonFormsFunctions.enterDateField(validityEndDateId,endDate);
    }
    public void enterName(String name){
        sendKeys(name,nameInput);
    }
    public void clearName(){
        clear(nameInput);
    }
    public void enterLastName(String lastName){
        sendKeys(lastName,lastNameInput);
    }
    public void clearLastName(){
        clear(lastNameInput);
    }
    public void selectCompany(String company){
        By liCompany = By.xpath("//li//span[text()='"+company+"']");
        click(companyArrowInput);
        click(liCompany);
    }
    public void selectOrgUnit(String orgUnit){
        By liOrgUnit = By.xpath("//li//span[text()='"+orgUnit+"']");
        click(orgUnitArrowInput);
        click(liOrgUnit);
    }
    public void selectPosition(String position){
        By liPosition = By.xpath("//li//span[text()='"+position+"']");
        click(positionArrowInput);
        click(liPosition);
    }
    public void selectLicenseCategory(String category){
        By liCategory = By.xpath("//li//span[text()='"+category+"']");
        click(licenseCategoryArrowInput);
        click(liCategory);
    }
    public void clickBtnNoSendEmail(){
        click(noSendNotificationBtn);
    }
}
