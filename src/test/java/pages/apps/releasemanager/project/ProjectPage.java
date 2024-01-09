package pages.apps.releasemanager.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;
import utilities.CommonBranchFunctions;
import utilities.WaitFunctions;

public class ProjectPage extends Base {

    private CommonBranchFunctions branchCommon;
    private WaitFunctions waitFunctions;
    private String projectMainNode= "Projects";
    private By newProjectDiv = By.xpath("//div[contains(text(),'New Project') or contains(text(),'Nuevo Proyecto') ]");
    private By deleteProjectDiv = By.xpath("//div[contains(text(),'Delete Project') or contains(text(),'Borrar Proyecto') ]");
    private By startDateIcon = By.xpath("//span[contains(@id,'ProjectStartDate-icon')]");
    private By endDateIcon = By.xpath("//span[contains(@id,'ProjectEndDate-icon')]");
    private By stateArrowField = By.xpath("//span[contains(@id,'selectProjectState-arrow')]");
    private By stateOpenLi = By.xpath("//li[contains(@id,'selectProjectState') and text()='Open']");
    private By stateClosedLi = By.xpath("//li[contains(@id,'selectProjectState') and text()='Closed']");
    private By stateInProgressLi = By.xpath("//li[contains(@id,'selectProjectState') and text()='In Progress']");
    private By btnYearCalendarEnd = By.xpath("//button[contains(@id,'ProjectEndDate-cal--Head-B2')]");
    private By switchUseProject = By.xpath("//div[contains(@id,'useInProcess-switch')]");
    private By parentUseProject = By.xpath("//div[contains(@id,'useInProcess-switch')]//..");
    private By switchUseRelease = By.xpath("//div[contains(@id,'useInReleases-switch')]");
    private By parentUseRelease = By.xpath("//div[contains(@id,'useInReleases-switch')]//..");
    private By btnYesDelete = By.xpath("//bdi[text()='Sí' or text()='Yes']");

    public ProjectPage(WebDriver driver){
        super(driver);
        this.branchCommon = new CommonBranchFunctions(driver);
        this.waitFunctions = new WaitFunctions(driver);
    }

    public void rightClickNodeProject(){
        branchCommon.rightClickElementMainTree(projectMainNode);
    }
    public void clickArrowMainProject(){
        branchCommon.clickBranchElement(projectMainNode);
        waitFunctions.waitForMainTreeToFinishLoading();
    }
    public void clickProjectSelect(String selectProject){
        branchCommon.clickElementMainTree(selectProject);
    }
    public void rightClickProjectSelect(String selectProject){
        branchCommon.rightClickElementMainTree(selectProject);
    }
    public void clickArrowProjectSelect(String selectProject){
        boolean isReleaseVisible = branchCommon.isDisplayBranchElement(selectProject).contains("false");
        if(isReleaseVisible){
            branchCommon.clickBranchElement(selectProject);
        }
    }
    public void clickNewProject() { click(newProjectDiv); }
    public void clickDeleteProject(){click(deleteProjectDiv);}
    public void clickYesDelete(){ click(btnYesDelete);}
    public void fillProjectDataForm(String startDay,String endDay, String endYear, String state, String useProject, String useReleases){
        enterStartDateField(startDay);
        enterEndDateField(endDay,endYear);
        if(state.contains("Closed")){ enterStateClosed(); }
        if(state.contains("In Progress")){ enterStateInProgress(); }
        if(state.contains("Open")){ enterStateOpen();}
        // Use Project
        clickUseProjectWithState(useProject.contains("true") ? "true" : "false");
        // Use Release
        clickUseReleasesWithState(useReleases.contains("true") ? "true" : "false");
    }

    public void enterStartDateField(String startDay){
        clickStartDate();
        clickDayStartProject(startDay);
    }
    public void enterEndDateField(String endDay, String endYear){
        clickEndDate();
        clickBtnYearCalendarEnd();
        clickYearEndProject(endYear);
        clickDayEndProject(endDay);
    }
    public void enterStateOpen(){
        clickState();
        clickOpenState();
    }
    public void enterStateClosed(){
        clickState();
        clickClosedState();
    }
    public void enterStateInProgress(){
        clickState();
        clickInProgressState();
    }
    public void clickStartDate(){ click(startDateIcon); }
    public void clickDayStartProject(String day){
        By dayStartProject = By.xpath("//div[contains(@id,'ProjectStartDate-cal')]//span[text()='"+day+"']");
        click(dayStartProject);
    }
    public void clickEndDate(){ click(endDateIcon); }
    public void clickBtnYearCalendarEnd(){
        click(btnYearCalendarEnd);
    }
    public void clickYearEndProject(String year){
        By yearEndProject = By.xpath("//div[contains(@id,'ProjectEndDate-cal')]//div[text()="+year+"]");
        click(yearEndProject);
    }
    public void clickDayEndProject(String day){
        By dayStartProject = By.xpath("//div[contains(@id,'ProjectEndDate-cal')]//span[text()='"+day+"']");
        click(dayStartProject);
    }
    public void clickState(){ click(stateArrowField); }
    public void clickOpenState(){ click(stateOpenLi); }
    public void clickClosedState(){ click(stateClosedLi); }
    public void clickInProgressState(){ click(stateInProgressLi); }
    public void clickUseProjectWithState(String stateSwitch){
        String ariaChecked = getAttribute(parentUseProject,"aria-checked");
        if(ariaChecked != ""){
            if(!stateSwitch.equals(ariaChecked)){
                click(switchUseProject);
            }
        }
    }
    public void clickUseReleasesWithState(String stateSwitch){
        String ariaChecked = getAttribute(parentUseRelease,"aria-checked");
        if(ariaChecked != ""){
            if(!stateSwitch.equals(ariaChecked)){
                click(switchUseRelease);
            }
        }
    }


}
