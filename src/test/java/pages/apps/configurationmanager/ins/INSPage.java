package pages.apps.configurationmanager.ins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;

public class INSPage extends Base {
    private By itemMenuReusableComp = By.xpath("//div[@title='Reusable Component']");
    private By itemMenuINS = By.xpath("//div[@title='Instance Numbering Schema']");
    private By separatorInput = By.xpath("//input[contains(@id,'separatorInstance')]");
    private By btnAddComponent = By.xpath("//div[contains(@id,'operationsTable')]//button[contains(@id,'addItem')]");
    private By arrowComponentType = By.xpath("//tbody[contains(@id,'operationsTable')]//span[contains(@id,'arrow')]");
    private By liFixedValue = By.xpath("//ul//li//span[text()='Fixed Value']");
    private By valueInput = By.xpath("//tbody[contains(@id,'operationsTable')]//input[not(contains(@role,'combobox'))]");

    public INSPage(WebDriver driver) {
        super(driver);
    }

    public void clickMenuReusableComp() {
        click(itemMenuReusableComp);
    }

    public void clickLiINS() {
        click(itemMenuINS);
    }

    public void clickINSSelect(String counter) {
        By counterSelect = By.xpath("//li//div[text()='" + counter + "']");
        click(counterSelect);
    }
    public void fillCounterDataForm(String separator,String value){
        enterSeparator(separator);
        selectComponentType(value);
    }
    public void enterSeparator(String separator){
        sendKeys(separator,separatorInput);
    }
    public void clickAddComponent(){click(btnAddComponent);}

    public void selectComponentType(String value){
        click(btnAddComponent);
        click(arrowComponentType);
        click(liFixedValue);
        enterInput(value);
    }

    public void enterInput(String value){
        sendKeys(value,valueInput);
    }
}
