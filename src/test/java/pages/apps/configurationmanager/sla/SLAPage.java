package pages.apps.configurationmanager.sla;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;

import java.text.ParseException;

public class SLAPage extends Base {

    private By itemMenuReusableComp = By.xpath("//div[@title='Reusable Component']");
    private By itemMenuSLA = By.xpath("//div[@title='SLA Definition']");
    private By arrowSLAType = By.xpath("//span[contains(@id,'slaType-arrow') and @role='button']");
    private By liSLAFixedValue = By.xpath("//ul[contains(@id,'slaType')]//li//span[text()='Fixed Value']");
    private By liSLADependsCondition = By.xpath("//ul[contains(@id,'slaType')]//li//span[text()='Depends on a Condition']");
    private By liSLADynamicBasedAttribute = By.xpath("//ul[contains(@id,'slaType')]//li//span[text()='Dynamic Based on Attribute']");

    private By switchUseBuplatProfile = By.xpath("//div[contains(@id,'useBupaProfile-switch')]");
    private By switchUseNumberDays = By.xpath("//div[contains(@id,'useNumberDays-switch')]");
    private By switchUseNumberHours = By.xpath("//div[contains(@id,'useNumberOfHours-switch')]");

    public SLAPage(WebDriver driver) {
        super(driver);
    }

    public void clickMenuReusableComp(){
        click(itemMenuReusableComp);
    }
    public void clickLiSLA(){
        click(itemMenuSLA);
    }
    public void clickSLASelect(String sla){
        By slaSelect = By.xpath("//li//div[text()='"+sla+"']");
        click(slaSelect);
    }
    public void fillSLADataForm(String sla) {
        selectSLAType(sla);
    }
    public void selectSLAType(String sla){
        click(arrowSLAType);
        if(sla.contains("Fixed Value")){
            click(liSLAFixedValue);
        }
        if(sla.contains("Condition")){
            click(liSLADependsCondition);
        }
        if(sla.contains("Attribute")){
            click(liSLADynamicBasedAttribute);
        }
    }
}
