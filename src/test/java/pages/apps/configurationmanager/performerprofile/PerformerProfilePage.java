package pages.apps.configurationmanager.performerprofile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;

public class PerformerProfilePage extends Base {

    private By itemMenuReusableComp = By.xpath("//div[@title='Reusable Component']");
    private By itemMenuPerformerProfile = By.xpath("//div[@title='Performer Profile']");
    private By switchReusePerformer = By.xpath("//div[contains(@id,'reusePerformer-switch')]");
    private By parentReusePerformer = By.xpath("//div[contains(@id,'reusePerformer-switch')]/..");
    private By switchAssignCurrentUser = By.xpath("//div[contains(@id,'assignCurrentUser-switch')]");
    private By parentAssignCurrentUser = By.xpath("//div[contains(@id,'assignCurrentUser-switch')]/..");
    private By arrowAssignmentMethod = By.xpath("//span[contains(@id,'assignmentMethod-arrow') and @role='button']");
    private By liByLoad = By.xpath("//ul[contains(@id,'assignmentMethod')]//li//span[text()='By Load']");
    private By liByExperience = By.xpath("//ul[contains(@id,'assignmentMethod')]//li//span[text()='By Experience']");
    private By liByGroup = By.xpath("//ul[contains(@id,'assignmentMethod')]//li//span[text()='By Group']");

    public PerformerProfilePage(WebDriver driver){
        super(driver);
    }

    public void clickMenuReusableComp(){
        click(itemMenuReusableComp);
    }
    public void clickLiPerformerProfile(){
        click(itemMenuPerformerProfile);
    }
    public void clickPerformerProfileSelect(String performer){
        By performerSelect = By.xpath("//li//div[text()='"+performer+"']");
        click(performerSelect);
    }

    public void fillPerformerDataForm(String assignCurrentUser,String reusePerformer,String assignmentMethod) {
        selectAssignmentMethod(assignmentMethod);
    }

    public void selectAssignmentMethod(String assignmentMethod){
        click(arrowAssignmentMethod);
        if(assignmentMethod.contains("Load")){
            click(liByLoad);
        }
        if(assignmentMethod.contains("Experience")){
            click(liByExperience);
        }
        if(assignmentMethod.contains("Group")){
            click(liByGroup);
        }
    }
    public void clickReusePerformer(String reusePerformer){
        String ariaChecked = getAttribute(parentReusePerformer,"aria-checked");
        if(ariaChecked != ""){
            if(!reusePerformer.equals(ariaChecked)){
                click(switchReusePerformer);
            }
        }
    }
    public void clickAssignCurrentUser(String assignCurrentUser){
        String ariaChecked = getAttribute(parentAssignCurrentUser,"aria-checked");
        if(ariaChecked != ""){
            if(!assignCurrentUser.equals(ariaChecked)){
                click(switchAssignCurrentUser);
            }
        }
    }
}
