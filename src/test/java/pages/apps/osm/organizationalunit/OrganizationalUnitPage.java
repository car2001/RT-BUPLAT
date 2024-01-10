package pages.apps.osm.organizationalunit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;
import utilities.CommonBranchFunctions;
import utilities.WaitFunctions;

public class OrganizationalUnitPage extends Base {

    private CommonBranchFunctions branchFunctions;
    private WaitFunctions waitFunctions;
    private String organizationalUnitMainNode = "Organizational Units";
    private By newOrganizationalUnitDiv = By.xpath("//div[contains(text(),'New Organizational Unit') or contains(text(),'Nueva Unidad Organizacional') ]");
    private By deleteOrganizationalUnitDiv = By.xpath("//div[contains(text(),'Delete Organizational Unit') or contains(text(),'Borrar Unidad Organizacional') ]");

    public OrganizationalUnitPage (WebDriver driver){
        super(driver);
        this.branchFunctions = new CommonBranchFunctions(driver);
        this.waitFunctions = new WaitFunctions(driver);
    }

    // Actions Main Node Organizational Unit
    public void rightClickNodeOrganizationalUnit(){
        branchFunctions.rightClickElementMainTree(organizationalUnitMainNode);
    }
    public void clickArrowNodeOrganizationalUnit(){
        branchFunctions.clickBranchElement(organizationalUnitMainNode);
        waitFunctions.waitForMainTreeToFinishLoading();
    }
    public void clickNewOrganizationalUnit(){
        click(newOrganizationalUnitDiv);
    }
    public void clickDeleteOrganizationalUnit(){
        click(deleteOrganizationalUnitDiv);
    }

    // Actions in any Organizational Unit node
    public void clickOrganizationalUnitSelect(String selectOrganizationalUnit){
        branchFunctions.clickElementMainTree(selectOrganizationalUnit);
    }
    public void rightClickOrganizationalUnitSelect(String selectOrganizationalUnit){
        branchFunctions.rightClickElementMainTree(selectOrganizationalUnit);
    }
    public void clickArrowOrganizationalUnitSelect(String selectOrganizationalUnit){
        boolean isReleaseVisible = branchFunctions.isDisplayBranchElement(selectOrganizationalUnit).contains("false");
        if(isReleaseVisible){
            branchFunctions.clickBranchElement(selectOrganizationalUnit);
        }
    }
}
