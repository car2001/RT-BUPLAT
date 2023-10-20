package pages.apps.releasemanager.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;

public class ProjectPage extends Base {
    private By projectNode= By.xpath("//td[contains(@id,'mainTree')]//span[contains(text(),'Projects') ]");
    private By newProjectDiv = By.xpath("//div[contains(text(),'New Project') or contains(text(),'Nuevo Proyecto') ]");
    private By startDateIcon = By.xpath("//span[contains(@id,'ProjectStartDate-icon')]");
    private By endDateIcon = By.xpath("//span[contains(@id,'ProjectEndDate-icon')]");
    private By stateArrowField = By.xpath("//span[contains(@id,'selectProjectState-arrow')]");
    private By stateOpenLi = By.xpath("//li[contains(@id,'selectProjectState-0')]");
    private By stateClosedLi = By.xpath("//li[contains(@id,'selectProjectState-1')]");
    private By stateInProgressLi = By.xpath("//li[contains(@id,'selectProjectState-2')]");
    private By btnYearCalendarEnd = By.xpath("//button[contains(@id,'ProjectEndDate-cal--Head-B2')]");

    public ProjectPage(WebDriver driver){
        super(driver);
    }
    public void rightClickNodeProject(){
        rightClick(projectNode);
    }
    public void clickNewProject(){ click(newProjectDiv); }
    public void fillProjectDataForm(String startDay,String endDay, String endYear, String state){
        enterStartDateField(startDay);
        enterEndDateField(endDay,endYear);
        if(state == "Closed"){ enterStateClosed(); }
        if(state == "In Progress"){ enterStateInProgress(); }
        if(state == "Open"){ enterStateOpen();}
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
