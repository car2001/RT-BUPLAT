package pages.apps.releasemanager.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;

public class ProjectPage extends Base {
    private By projectMainNode= By.xpath("//td[contains(@id,'mainTree')]//span[contains(text(),'Projects') ]");
    private By projectArrow = By.xpath("//span[contains(@id,'mainTree-rows-row0-treeicon')]");
    private By newProjectDiv = By.xpath("//div[contains(text(),'New Project') or contains(text(),'Nuevo Proyecto') ]");
    private By deleteProjectDiv = By.xpath("//div[contains(text(),'Delete Project') or contains(text(),'Borrar Proyecto') ]");
    private By startDateIcon = By.xpath("//span[contains(@id,'ProjectStartDate-icon')]");
    private By endDateIcon = By.xpath("//span[contains(@id,'ProjectEndDate-icon')]");
    private By stateArrowField = By.xpath("//span[contains(@id,'selectProjectState-arrow')]");
    private By stateOpenLi = By.xpath("//li[contains(@id,'selectProjectState') and text()='Open']");
    private By stateClosedLi = By.xpath("//li[contains(@id,'selectProjectState') and text()='Closed']");
    private By stateInProgressLi = By.xpath("//li[contains(@id,'selectProjectState') and text()='In Progress']");
    private By btnYearCalendarEnd = By.xpath("//button[contains(@id,'ProjectEndDate-cal--Head-B2')]");
    private By btnYesDelete = By.xpath("//bdi[text()='Sí' or text()='Yes']");



    public ProjectPage(WebDriver driver){
        super(driver);
    }
    public void rightClickNodeProject(){ rightClick(projectMainNode); }
    public void clickArrowProject(){click(projectArrow);}
    public void clickProjectSelect(String selectProject){
        By projectSelectPath = By.xpath("//td[contains(@id,'mainTree')]//span[contains(text(),'"+selectProject+"') ]");
        click(projectSelectPath);
    }
    public void rightClickProjectSelect(String selectProject){
        By projectSelectPath = By.xpath("//td[contains(@id,'mainTree')]//span[contains(text(),'"+selectProject+"') ]");
        rightClick(projectSelectPath);
    }
    public void clickNewProject() { click(newProjectDiv); }
    public void clickDeleteProject(){click(deleteProjectDiv);}
    public void clickYesDelete(){ click(btnYesDelete);}
    public void fillProjectDataForm(String startDay,String endDay, String endYear, String state){
        enterStartDateField(startDay);
        enterEndDateField(endDay,endYear);
        if(state.contains("Closed")){ enterStateClosed(); }
        if(state.contains("In Progress")){ enterStateInProgress(); }
        if(state.contains("Open")){ enterStateOpen();}
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

}
