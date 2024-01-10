package pages.apps.osm.position;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;
import utilities.CommonBranchFunctions;
import utilities.WaitFunctions;

public class PositionPage extends Base {

    private CommonBranchFunctions branchFunctions;
    private WaitFunctions waitFunctions;
    private String positionMainNode = "Positions";
    private By newPositionDiv = By.xpath("//div[contains(text(),'New Position') or contains(text(),'Nueva Posición') ]");
    private By deletePositionDiv = By.xpath("//div[contains(text(),'Delete Position') or contains(text(),'Borrar Posición') ]");


    public PositionPage (WebDriver driver){
        super(driver);
        this.branchFunctions = new CommonBranchFunctions(driver);
        this.waitFunctions = new WaitFunctions(driver);
    }

    // Actions Main Node Positions
    public void rightClickNodePositions(){
        branchFunctions.rightClickElementMainTree(positionMainNode);
    }
    public void clickArrowNodePositions(){
        branchFunctions.clickBranchElement(positionMainNode);
        waitFunctions.waitForMainTreeToFinishLoading();
    }
    public void clickNewPosition(){
        click(newPositionDiv);
    }
    public void clickDeletePosition(){
        click(deletePositionDiv);
    }

    // Actions in any Position node
    public void clickPositionSelect(String selectPosition){
        branchFunctions.clickElementMainTree(selectPosition);
    }
    public void rightClickPositionSelect(String selectPosition){
        branchFunctions.rightClickElementMainTree(selectPosition);
    }
}
