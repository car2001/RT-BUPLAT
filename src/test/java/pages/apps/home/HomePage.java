package pages.apps.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import pom.Base;

public class HomePage extends Base {

    private By collaborationWorkspaceApp = By.xpath("//span[@class='sapMTextMaxLine sapMTextLineClamp' and normalize-space()='Collaboration Workspace']");
    private By processManagerApp = By.xpath("//span[@class='sapMTextMaxLine sapMTextLineClamp' and normalize-space()='Process Manager']");
    private By securityManagerApp = By.xpath("//span[@class='sapMTextMaxLine sapMTextLineClamp' and normalize-space()='Security Manager']");
    private By organizationalStructureManagerApp = By.xpath("//span[@class='sapMTextMaxLine sapMTextLineClamp' and normalize-space()='Organizational Structure Manager']");
    private By configurationManagerApp = By.xpath("//span[@class='sapMTextMaxLine sapMTextLineClamp' and normalize-space()='Configuration Manager']");
    private By releaseManagerApp = By.xpath("//span[@class='sapMTextMaxLine sapMTextLineClamp' and normalize-space()='Release Manager']");
    private By dataEntityManagerApp = By.xpath("//span[@class='sapMTextMaxLine sapMTextLineClamp' and normalize-space()='Data Entity Manager']");
    private By dataRecordManagerApp = By.xpath("//span[@class='sapMTextMaxLine sapMTextLineClamp' and normalize-space()='Data Record Manager']");


    public HomePage(WebDriver driver){
        super(driver);
    }

    public void clickBtnCollaborationWorkspace(){
        click(collaborationWorkspaceApp);
    }

    public void clickBtnProcessManager(){
        click(processManagerApp);
    }

    public void clickBtnSecurityManager(){
        click(securityManagerApp);
    }

    public void clickBtnOrganizationalStructureManager(){
        click(organizationalStructureManagerApp);
    }

    public void clickBtnConfigurationManager(){
        click(configurationManagerApp);
    }

    public void clickBtnReleaseManager(){
        click(releaseManagerApp);
    }

    public void clickBtnDataEntityManager(){
        click(dataEntityManagerApp);
    }

    public void clickBtnDataRecordManagerApp(){
        click(dataRecordManagerApp);
    }

}
