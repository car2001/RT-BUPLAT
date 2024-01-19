package pages.apps.securitymanager.role;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;
import utilities.WaitFunctions;

public class RolePage extends Base {

    private WaitFunctions waitFunctions;
    private By menuUserAndRole = By.xpath("//div[@title='User & Role Management' or @title='Gestión de Usuarios y Roles']");
    private By listItemRole = By.xpath("//div[@title='Role' or @title='Rol']");
    private By parentUseAttributes = By.xpath("//div[contains(@id,'useAttributesRole-switch')]/..");
    private By switchUseAttributes = By.xpath("//div[contains(@id,'useAttributesRole-switch')]");
    private By parentIsComposite = By.xpath("//div[contains(@id,'isCompositeRole-switch')]/..");
    private By switchIsComposite = By.xpath("//div[contains(@id,'isCompositeRole-switch')]");


    public RolePage(WebDriver driver)  {
        super(driver);
        this.waitFunctions = new WaitFunctions(driver);
    }

     public void clickMenuUserAndRole(){
        click(menuUserAndRole);
     }
     public void clickLiRole(){
        click(listItemRole);
     }
     public void clickRoleSelect(String role){
         By roleSelect = By.xpath("//li//div[text()='"+role+"']");
         click(roleSelect);
     }
     public void fillRoleDataForm(String useAttributes, String isComposite){
         // Use Attributes
         clickUseAttributes(useAttributes.contains("true") ? "true" : "false");
         // Is Composite
         clickIsComposite(isComposite.contains("true") ? "true" : "false");
     }
    public void clickUseAttributes(String attributesSwitch){
        String ariaChecked = getAttribute(parentUseAttributes,"aria-checked");
        if(ariaChecked != ""){
            if(!attributesSwitch.equals(ariaChecked)){
                click(switchUseAttributes);
            }
        }
    }
    public void clickIsComposite(String isCompositeSwitch){
        String ariaChecked = getAttribute(parentIsComposite,"aria-checked");
        if(ariaChecked != ""){
            if(!isCompositeSwitch.equals(ariaChecked)){
                click(switchIsComposite);
            }
        }
    }
}