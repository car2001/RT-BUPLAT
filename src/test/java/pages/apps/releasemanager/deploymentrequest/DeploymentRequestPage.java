package pages.apps.releasemanager.deploymentrequest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;
import utilities.CommonBranchFunctions;
import utilities.WaitFunctions;

public class DeploymentRequestPage extends Base {

    private CommonBranchFunctions branchFunctions;
    private WaitFunctions waitFunctions;
    private String deploymentRequestMainNode= "Deployment Requests";
    private String openNodeDR = "Open";
    private By newDivDeploymentRequest = By.xpath("//div[contains(text(),'New Deployment Request') or contains(text(),'Nueva Solicitud de Despliegue') ]");
    private By deleteDivDeploymentRequest = By.xpath("//div[contains(text(),'Delete Deployment Package') or contains(text(),'Borrar Paquete de Despliegue') ]");
    private By projectArrowDR = By.xpath("//span[contains(@id,'selectDRProject-arrow') and contains(@class,'sapUiIcon')]");
    private By releaseArrowDR = By.xpath("//span[contains(@id,'selectDRRelease-arrow') and contains(@class,'sapUiIcon')]");
    private By firstItemNameDR = By.xpath("//tr[contains(@id,'tblComponentList')]//td[contains(@id,'col1')]//span");

    public DeploymentRequestPage(WebDriver driver){
        super(driver);
        this.branchFunctions = new CommonBranchFunctions(driver);
        this.waitFunctions = new WaitFunctions(driver);
    }

    // Actions Main Node Deployment Request
    public void clickArrowMainDeploymentRequest(){
        branchFunctions.clickBranchElement(deploymentRequestMainNode);
    }

    // Actions Node Open
    public void clickNodeOpen(){
        branchFunctions.clickElementMainTree(openNodeDR);
        waitFunctions.waitForMainPageToFinishLoading();
    }
    public void rightClickNodeOpen(){
        branchFunctions.rightClickElementMainTree(openNodeDR);
    }
    public void clickArrowNodeOpen(){
        branchFunctions.clickBranchElement(openNodeDR);
        waitFunctions.waitForMainTreeToFinishLoading();
    }
    public void clickNewDeploymentRequest(){
        click(newDivDeploymentRequest);
    }
    public void clickDeleteDeploymentRequest(){
        click(deleteDivDeploymentRequest);
    }

    // Actions in any Deployment Request node
    public void clickDeploymentRequestSelect(String selectDeploymentRequest){
        branchFunctions.clickElementMainTree(selectDeploymentRequest);
    }
    public void rightClickDeploymentRequestSelect(String selectDeploymentRequest){
        branchFunctions.rightClickElementMainTree(selectDeploymentRequest);
    }

    // Actions Form Deployment Request
    public void fillChangeContainerForm(String project, String release) {
        selectProjectDR(project);
        selectReleaseDR(release);
    }
    public void selectProjectDR(String nameProject){
        By projectLi = By.xpath("//ul[contains(@id,'selectDRProject')]//li//span[text()='"+nameProject+"']");
        clickProjectArrowDR();
        click(projectLi);
    }
    public void selectReleaseDR(String nameRelease){
        By releaseLi = By.xpath("//ul[contains(@id,'selectDRRelease')]//li//span[text()='"+nameRelease+"']");
        clickReleaseArrowDR();
        click(releaseLi);
    }
    public void clickProjectArrowDR(){click(projectArrowDR);}
    public void clickReleaseArrowDR(){click(releaseArrowDR);}


    // Table Deployment Request
    public String getTextFirstDRTable(){
        return getText(firstItemNameDR);
    }
    public void selectDeploymentRequestTable(String deploymentRequest){
        By deploymentRequestTd = By.xpath("//tr[contains(@id,'tblComponentList')]//td[contains(@id,'col7')]//span[text()='"+deploymentRequest+"']");
        click(deploymentRequestTd);
    }


}
