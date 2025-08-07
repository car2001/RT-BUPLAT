package pages.apps.configurationmanager.counter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;

public class CounterPage extends Base {

    private By itemMenuReusableComp = By.xpath("//div[@title='Reusable Component']");
    private By itemMenuCounter = By.xpath("//li[@title='Counter' or @title='Contador']");
    private By startAtInput = By.xpath("//input[contains(@id,'txtCounterStartAt')]");
    private By incrementInput = By.xpath("//input[contains(@id,'txtCounterIncrement')]");

    public CounterPage(WebDriver driver){
        super(driver);
    }

    public void clickMenuReusableComp(){
        click(itemMenuReusableComp);
    }
    public void clickLiCounter(){
        click(itemMenuCounter);
    }
    public void clickCounterSelect(String counter){
        By counterSelect = By.xpath("//li//div[text()='"+counter+"']");
        click(counterSelect);
    }
    public void fillCounterDataForm(String startAt, String increment){
        enterStartAt(startAt);
        enterIncrement(increment);
    }
    public void enterStartAt(String startAt){
        sendKeys(startAt,startAtInput);
    }
    public void enterIncrement(String increment){
        sendKeys(increment,incrementInput);
    }

}
