package pages.apps.osm.location;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;
import utilities.CommonBranchFunctions;
import utilities.WaitFunctions;

public class LocationPage extends Base {

    private CommonBranchFunctions branchFunctions;
    private WaitFunctions waitFunctions;
    private String locationMainNode = "Locations";
    private By newLocationDiv = By.xpath("//div[contains(text(),'New Location') or contains(text(),'Nueva Ubicación') ]");
    private By deleteLocationDiv = By.xpath("//div[contains(text(),'Delete Location') or contains(text(),'Borrar Ubicación') ]");

    public LocationPage (WebDriver driver){
        super(driver);
        this.branchFunctions = new CommonBranchFunctions(driver);
        this.waitFunctions = new WaitFunctions(driver);
    }

    // Actions Main Node Locations
    public void rightClickNodeLocations(){
        branchFunctions.rightClickElementMainTree(locationMainNode);
    }
    public void clickArrowNodeLocation(){
        branchFunctions.clickBranchElement(locationMainNode);
        waitFunctions.waitForMainTreeToFinishLoading();
    }
    public void clickNewLocation(){
        click(newLocationDiv);
    }
    public void clickDeleteLocation(){
        click(deleteLocationDiv);
    }

    // Actions in any Location node
    public void clickLocationSelect(String selectLocation){
        branchFunctions.clickElementMainTree(selectLocation);
    }
    public void rightClickLocationSelect(String selectLocation){
        branchFunctions.rightClickElementMainTree(selectLocation);
    }
}
