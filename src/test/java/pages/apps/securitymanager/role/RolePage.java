package pages.apps.securitymanager.role;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;
import utilities.WaitFunctions;

public class RolePage extends Base {

    private WaitFunctions waitFunctions;
    private By listItemUserAndRole = By.xpath("//div[@title='User & Role Management']");

    public RolePage(WebDriver driver)  {
        super(driver);
        this.waitFunctions = new WaitFunctions(driver);
    }


}