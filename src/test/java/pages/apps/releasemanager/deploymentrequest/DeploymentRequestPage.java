package pages.apps.releasemanager.deploymentrequest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;

public class DeploymentRequestPage extends Base {
    private By deploymentRequestsNode = By.xpath("//td[contains(@id,'mainTree')]//span[contains(text(),'Deployment Requests') ]");

    public DeploymentRequestPage(WebDriver driver){
        super(driver);
    }

    public void rightClickNodeDeploymentRequests(){
        rightClick(deploymentRequestsNode);
    }
}
