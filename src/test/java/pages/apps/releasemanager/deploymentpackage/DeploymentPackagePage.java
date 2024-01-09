package pages.apps.releasemanager.deploymentpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.Base;
import utilities.CommonBranchFunctions;
import utilities.WaitFunctions;

public class DeploymentPackagePage extends Base {

    private CommonBranchFunctions branchFunctions;
    private WaitFunctions waitFunctions;
    private String deploymentPackageMainNode= "Deployment Packages";
    private String openNodeDP = "Open";
    private By newDivDeploymentPackage = By.xpath("//div[contains(text(),'New Deployment Package') or contains(text(),'Nuevo Paquete de Despliegue') ]");
    private By deleteDivDeploymentPackage = By.xpath("//div[contains(text(),'Delete Deployment Package') or contains(text(),'Borrar Paquete de Despliegue') ]");
    private By projectArrowDP = By.xpath("//span[contains(@id,'selectDPProject-arrow') and contains(@class,'sapUiIcon')]");
    private By releaseArrowDP = By.xpath("//span[contains(@id,'selectDPRelease-arrow') and contains(@class,'sapUiIcon')]");
    private By firstItemNameDP = By.xpath("//tr[contains(@id,'tblComponentList')]//td[contains(@id,'col1')]//span");

    public DeploymentPackagePage(WebDriver driver){
        super(driver);
        this.branchFunctions = new CommonBranchFunctions(driver);
        this.waitFunctions = new WaitFunctions(driver);
    }

    // Actions Main Node Deployment Package
    public void clickArrowMainDeploymentPackage(){
        branchFunctions.clickBranchElement(deploymentPackageMainNode);
    }

    // Actions Node Open
    public void clickNodeOpen(){
        branchFunctions.clickElementMainTree(openNodeDP);
        waitFunctions.waitForMainPageToFinishLoading();
    }
    public void rightClickNodeOpen(){
        branchFunctions.rightClickElementMainTree(openNodeDP);
    }
    public void clickArrowNodeOpen(){
        branchFunctions.clickBranchElement(openNodeDP);
        waitFunctions.waitForMainTreeToFinishLoading();
    }
    public void clickNewDeploymentPackage(){
        click(newDivDeploymentPackage);
    }
    public void clickDeleteDeploymentPackage(){
        click(deleteDivDeploymentPackage);
    }

    // Actions in any Deployment Package node
    public void clickDeploymentPackageSelect(String selectDeploymentPackage){
        branchFunctions.clickElementMainTree(selectDeploymentPackage);
    }
    public void rightClickDeploymentPackageSelect(String selectDeploymentPackage){
        branchFunctions.rightClickElementMainTree(selectDeploymentPackage);
    }

    // Actions Form Change Container
    public void fillChangeContainerForm(String project, String release) {
        selectProjectDP(project);
        selectReleaseDP(release);
    }
    public void selectProjectDP(String nameProject){
        By projectLi = By.xpath("//ul[contains(@id,'selectDPProject')]//li//span[text()='"+nameProject+"']");
        clickProjectArrowDP();
        click(projectLi);
    }
    public void selectReleaseDP(String nameRelease){
        By releaseLi = By.xpath("//ul[contains(@id,'selectDPRelease')]//li//span[text()='"+nameRelease+"']");
        clickReleaseArrowDP();
        click(releaseLi);
    }
    public void clickProjectArrowDP(){click(projectArrowDP);}
    public void clickReleaseArrowDP(){click(releaseArrowDP);}

    // Table Deployment Package
    public String getTextFirstDPTable(){
        return getText(firstItemNameDP);
    }
    public void selectDeploymentPackageTable(String changeContainer){
        By changeContainerTd = By.xpath("//tr[contains(@id,'tblComponentList')]//td[contains(@id,'col7')]//span[text()='"+changeContainer+"']");
        click(changeContainerTd);
    }
}
