package pages.apps.configurationmanager.ins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;

public class INSPage extends Base {
    private By itemMenuReusableComp = By.xpath("//div[@title='Reusable Component']");
    private By itemMenuINS = By.xpath("//div[@title='Instance Numbering Schema']");
    private By separatorInput = By.xpath("//input[contains(@id,'txtCounterStartAt')]");
    private By btnAddComponent = By.xpath("//div[contains(@id,'operationsTable')]//button[contains(@id,'addItem')]");


    public INSPage(WebDriver driver) {
        super(driver);
    }

    public void clickMenuReusableComp() {
        click(itemMenuReusableComp);
    }

    public void clickLiCounter() {
        click(itemMenuINS);
    }

    public void clickCounterSelect(String counter) {
        By counterSelect = By.xpath("//li//div[text()='" + counter + "']");
        click(counterSelect);
    }
}
