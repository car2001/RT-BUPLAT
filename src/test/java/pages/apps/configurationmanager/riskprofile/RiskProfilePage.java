package pages.apps.configurationmanager.riskprofile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;

public class RiskProfilePage extends Base {

    private By itemMenuReusableComp = By.xpath("//div[@title='Reusable Component']");
    private By itemMenuRiskProfile = By.xpath("//div[@title='Risk Profile']");
    private By arrowRiskType = By.xpath("//span[contains(@id,'typeRisk-arrow')]");
    private By liNPFixedValue = By.xpath("//li[ contains(@id,'typeRisk') and text()='Fixed Value']");
    private By liNPTimeRate = By.xpath("//li[ contains(@id,'typeRisk') and text()='Time Rate']");
    private By numberHoursInput = By.xpath("//input[contains(@id,'numberHoursRisk')]");
    private By numberMinutesInput = By.xpath("//input[contains(@id,'numberMinutesRisk')]");
    public RiskProfilePage(WebDriver driver){
        super(driver);
    }
    public void clickMenuReusableComp(){
        click(itemMenuReusableComp);
    }
    public void clickLiRiskProfile(){
        click(itemMenuRiskProfile);
    }
    public void clickRiskProfileSelect(String riskProfile){
        By riskProfileSelect = By.xpath("//li//div[text()='"+riskProfile+"']");
        click(riskProfileSelect);
    }
    public void fillRiskProfileDataForm(String riskProfile,String numberHours,String numberMinutes) {
        selectRiskType(riskProfile,numberHours,numberMinutes);
    }
    public void selectRiskType(String riskProfile, String numberHours, String numberMinutes){
        click(arrowRiskType);
        if(riskProfile.contains("Fixed Value")){
            click(liNPFixedValue);
            enterNumberHours(numberHours);
            enterNumberMinutes(numberMinutes);
        }
    }
    public void enterNumberHours(String numberHours){
        sendKeys(numberHours,numberHoursInput);
    }
    public void enterNumberMinutes(String numberMinutes){
        sendKeys(numberMinutes,numberMinutesInput);
    }
}
