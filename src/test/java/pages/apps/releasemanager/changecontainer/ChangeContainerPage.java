package pages.apps.releasemanager.changecontainer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;
import utilities.CommonBranchFunctions;
import utilities.WaitFunctions;

public class ChangeContainerPage extends Base {

    private CommonBranchFunctions branchFunctions;
    private WaitFunctions waitFunctions;
    private String changeContainerMainNode= "Change Containers";
    private String openNodeCC = "Open";
    private By newDivChangeContainer = By.xpath("//div[contains(text(),'New Change Container') or contains(text(),'Nuevo Contenedor de Cambios') ]");
    private By deleteDivChangeContainer = By.xpath("//div[contains(text(),'Delete Change Container') or contains(text(),'Borrar Contenedor de Cambios') ]");
    private By projectArrow = By.xpath("//span[contains(@id,'selectCCProject-arrow') and contains(@class,'sapUiIcon')]");
    private By releaseArrow = By.xpath("//span[contains(@id,'selectCCRelease-arrow') and contains(@class,'sapUiIcon')]");
    private By ownerArrow = By.xpath("//span[contains(@id,'selectCCOwner-arrow') and contains(@class,'sapUiIcon')]");

    public ChangeContainerPage(WebDriver driver){
        super(driver);
        this.branchFunctions = new CommonBranchFunctions(driver);
        this.waitFunctions = new WaitFunctions(driver);
    }

    // Actions Main Node Change Container
    public void clickMainChangeContainer(){
        branchFunctions.clickElementMainTree(changeContainerMainNode);
    }
    public void clickArrowMainChangeContainer(){
        branchFunctions.clickBranchElement(changeContainerMainNode);
    }

    // Actions Node Open
    public void clickNodeOpen(){
        branchFunctions.clickElementMainTree(openNodeCC);
    }
    public void rightClickNodeOpen(){
        branchFunctions.rightClickElementMainTree(openNodeCC);
    }
    public void clickArrowNodeOpen(){
        branchFunctions.clickBranchElement(openNodeCC);
        waitFunctions.waitForMainTreeToFinishLoading();
    }
    public void clickNewChangeContainer(){
        click(newDivChangeContainer);
    }
    public void clickDeleteChangeContainer(){
        click(deleteDivChangeContainer);
    }

    // Actions in any Change Container node
    public void clickChangeContainerSelect(String selectChangeContainer){
        branchFunctions.clickElementMainTree(selectChangeContainer);
    }
    public void rightClickChangeContainerSelect(String selectChangeContainer){
        branchFunctions.rightClickElementMainTree(selectChangeContainer);
    }

    // Actions Form Change Container
    public void fillChangeContainerForm(String project, String release, String owner) {
        selectProjectCC(project);
        selectReleaseCC(release);
        selectOwnerCC(owner);
    }
    public void selectProjectCC(String nameProject){
        By projectLi = By.xpath("//ul[contains(@id,'selectCCProject')]//li//span[text()='"+nameProject+"']");
        clickProjectArrowCC();
        click(projectLi);
    }
    public void selectReleaseCC(String nameRelease){
        By releaseLi = By.xpath("//ul[contains(@id,'selectCCRelease')]//li//span[text()='"+nameRelease+"']");
        clickReleaseArrowCC();
        click(releaseLi);
    }
    public void selectOwnerCC(String owner){
        By ownerLi = By.xpath("//ul[contains(@id,'selectCCOwner')]//li//span[text()='"+owner+"']");
        clickOwnerArrowCC();
        click(ownerLi);
    }
    public void clickProjectArrowCC(){click(projectArrow);}
    public void clickReleaseArrowCC(){click(releaseArrow);}
    public void clickOwnerArrowCC(){click(ownerArrow);}

    // Table Change Container
    public void selectChangeContainerTable(String changeContainer){
        By changeContainerTd = By.xpath("//tr[contains(@id,'tblComponentList')]//td[contains(@id,'col1')]//span[text()='"+changeContainer+"']");
        click(changeContainerTd);
    }

}
