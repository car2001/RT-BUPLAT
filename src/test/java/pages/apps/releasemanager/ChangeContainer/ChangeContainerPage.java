package pages.apps.releasemanager.ChangeContainer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;

public class ChangeContainerPage extends Base {

    private By changeContainerNode = By.xpath("//td[contains(@id,'mainTree')]//span[contains(text(),'Change Containers') ]");

    public ChangeContainerPage(WebDriver driver){
        super(driver);
    }

    public void rightClickNodeChangeContainers(){
        rightClick(changeContainerNode);
    }
}
