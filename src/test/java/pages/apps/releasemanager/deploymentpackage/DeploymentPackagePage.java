package pages.apps.releasemanager.deploymentpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;

public class DeploymentPackagePage extends Base {

    private By deploymentPackagesNode = By.xpath("//td[contains(@id,'mainTree')]//span[contains(text(),'Deployment Packages') ]");

    public DeploymentPackagePage(WebDriver driver){
        super(driver);
    }

    public void rightClickNodeDeploymentPackages(){
        rightClick(deploymentPackagesNode);
    }
}
