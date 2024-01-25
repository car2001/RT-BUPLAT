package pages.apps.securitymanager.usergroup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;
import utilities.CommonFormsFunctions;

public class UserGroupPage extends Base {

    private CommonFormsFunctions commonFormsFunctions;
    private By menuUserAndRole = By.xpath("//div[@title='User & Role Management' or @title='Gestión de Usuarios y Roles']");
    private By listItemUserGroup = By.xpath("//div[@title='User Group' or @title='Grupo de Usuario']");

    public UserGroupPage(WebDriver driver){
        super(driver);
        this.commonFormsFunctions = new CommonFormsFunctions(driver);
    }

    public void clickMenuUserAndRole(){
        click(menuUserAndRole);
    }
    public void clickLiUserGroup(){
        click(listItemUserGroup);
    }
    public void clickUserSelect(String userGroup){
        By userGroupSelect = By.xpath("//li//div[text()='"+userGroup+"']");
        click(userGroupSelect);
    }


}
