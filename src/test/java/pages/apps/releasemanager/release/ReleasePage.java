package pages.apps.releasemanager.release;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;
import utilities.CommonBranchFunctions;
import utilities.WaitFunctions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReleasePage extends Base {

    private CommonBranchFunctions branchFunctions;
    private WaitFunctions waitFunctions;
    private String releaseMainNode= "Releases";
    private By newDivRelease = By.xpath("//div[contains(text(),'New Release') or contains(text(),'Nueva Liberación') ]");
    private By deleteDivRelease = By.xpath("//div[contains(text(),'Delete Release') or contains(text(),'Borrar Liberación') ]");
    private By releaseStateArrow = By.xpath("//span[contains(@id,'selectReleaseState-arrow')]");
    private By openStateLi = By.xpath("//li[contains(@id,'selectReleaseState') and text()='Open']");
    private By closedStateLi = By.xpath("//li[contains(@id,'selectReleaseState') and text()='Closed']");
    private By inProgressStateLi = By.xpath("//li[contains(@id,'selectReleaseState') and text()='In Progress']");
    private By readyForDeploymentStateLi = By.xpath("//li[contains(@id,'selectReleaseState') and text()='Ready for Deployment']");
    private By idReleaseInput = By.xpath("//input[contains(@id,'ReleaseID')]");
    private By startDateReleaseIcon = By.xpath("//span[contains(@id,'ReleaseStartDate-icon')]");
    private By endDateReleaseIcon = By.xpath("//span[contains(@id,'ReleaseEndDate-icon')]");
    private By btnReleaseStartYearCalendar = By.xpath("//button[contains(@id,'ReleaseStartDate-cal--Head-B2')]");
    private By btnReleaseStartMonthCalendar = By.xpath("//button[contains(@id,'ReleaseStartDate-cal--Head-B1')]");
    private By btnReleaseEndYearCalendar  = By.xpath("//button[contains(@id,'ReleaseEndDate-cal--Head-B2')]");
    private By btnReleaseEndMonthCalendar = By.xpath("//button[contains(@id,'ReleaseEndDate-cal--Head-B1')]");


    public ReleasePage(WebDriver driver){
        super(driver);
        this.branchFunctions = new CommonBranchFunctions(driver);
        this.waitFunctions = new WaitFunctions(driver);
    }

    // Actions Main Node Release
    public void clickMainRelease(){
        branchFunctions.clickElementMainTree(releaseMainNode);
    }
    public void rightClickMainRelease(){
        branchFunctions.rightClickElementMainTree(releaseMainNode);
    }
    public void clickArrowMainRelease(){
        branchFunctions.clickBranchElement(releaseMainNode);
        waitFunctions.waitForMainTreeToFinishLoading();
    }
    public void clickNewRelease(){
        click(newDivRelease);
    }
    public void clickDeleteRelease(){
        click(deleteDivRelease);
    }

    // Actions in any release node
    public void clickReleaseSelect(String selectRelease){
        branchFunctions.clickElementMainTree(selectRelease);
    }
    public void rightClickReleaseSelect(String selectRelease){
        branchFunctions.rightClickElementMainTree(selectRelease);
    }
    public void clickArrowReleaseSelect(String selectRelease){
        boolean isReleaseVisible = branchFunctions.isDisplayBranchElement(selectRelease).contains("false");
        if(isReleaseVisible){
            branchFunctions.clickBranchElement(selectRelease);
        }
    }

    // Actions Form Release
    public void fillReleaseDataForm(String startDate, String endDate, String releaseId, String state) throws ParseException {
        enterReleaseStartDateField(startDate);
        enterReleaseEndDateField(endDate);
        enterIdRelease(releaseId);
        selectStateRelease(state);
    }

    public void enterReleaseStartDateField(String startDate) throws ParseException {
        String[] dateParts = getDateParts(startDate);
        String day = dateParts[0];
        String month = dateParts[1];
        String year = dateParts[2];

        clickStartDateReleaseIcon();
        // Select Year
        clickReleaseStartYearButton();
        clickReleaseStartDateYearElement(year);
        //Select Month
        clickReleaseStartMonthButton();
        clickReleaseStartDateMonthElement(month);
        // Select Day
        clickReleaseStartDateDayElement(day);
    }

    public void enterReleaseEndDateField(String endDate) throws ParseException {
        String[] dateParts = getDateParts(endDate);
        String day = dateParts[0];
        String month = dateParts[1];
        String year = dateParts[2];

        clickEndDateReleaseIcon();
        // Select Year
        clickReleaseEndYearButton();
        clickReleaseEndDateYearElement(year);
        //Select Month
        clickReleaseEndMonthButton();
        clickReleaseEndDateMonthElement(month);
        // Select Day
        clickReleaseEndDateDayElement(day);
    }

    public void enterIdRelease(String releaseId){
        sendKeys(releaseId,idReleaseInput);
    }

    public void selectStateRelease(String stateRelease){
        clickReleaseStateArrow();
        if(stateRelease.contains("Closed")){ clickClosedState(); }
        if(stateRelease.contains("In Progress")){ clickInProgressState(); }
        if(stateRelease.contains("Open")){ clickOpenState();}
        if(stateRelease.contains("Ready for Deployment")){clickReadyForDeploymentState();}
    }

    // Actions State Release
    public void clickReleaseStateArrow(){ click(releaseStateArrow); }
    public void clickOpenState(){ click(openStateLi); }
    public void clickClosedState(){ click(closedStateLi); }
    public void clickInProgressState(){ click(inProgressStateLi); }
    public void clickReadyForDeploymentState(){ click(readyForDeploymentStateLi); }

    // Actions Button Calendar Start Release
    public void clickStartDateReleaseIcon() {
        click(startDateReleaseIcon);
    }
    public void clickReleaseStartYearButton(){
        click(btnReleaseStartYearCalendar);
    }
    public void clickReleaseStartMonthButton(){
        click(btnReleaseStartMonthCalendar);
    }
    public void clickReleaseStartDateYearElement(String year){
        By divReleaseStartYear = By.xpath("//div[contains(@id,'ReleaseStartDate-cal')]//div[text()='"+year+"']");
        click(divReleaseStartYear);
    }
    public void clickReleaseStartDateMonthElement(String month){
        By divReleaseStartMonth = By.xpath("//div[contains(@id,'ReleaseStartDate-cal--MP-m"+ month +"')]");
        click(divReleaseStartMonth);
    }
    public void clickReleaseStartDateDayElement(String day){
        By divReleaseStartDay = By.xpath("//div[contains(@id,'ReleaseStartDate-cal')]//span[text()='"+day+"']");
        click(divReleaseStartDay);
    }

    // Actions Button Calendar End Release
    public void clickEndDateReleaseIcon() {
        click(endDateReleaseIcon);
    }
    public void clickReleaseEndYearButton(){
        click(btnReleaseEndYearCalendar);
    }
    public void clickReleaseEndMonthButton(){
        click(btnReleaseEndMonthCalendar);
    }
    public void clickReleaseEndDateYearElement(String year){
        By divReleaseEndYear = By.xpath("//div[contains(@id,'ReleaseEndDate-cal')]//div[text()='"+year+"']");
        click(divReleaseEndYear);
    }
    public void clickReleaseEndDateMonthElement(String month){
        By divReleaseEndMonth = By.xpath("//div[contains(@id,'ReleaseEndDate-cal--MP-m"+ month +"')]");
        click(divReleaseEndMonth);
    }
    public void clickReleaseEndDateDayElement(String day){
        By divReleaseEndDay = By.xpath("//div[contains(@id,'ReleaseEndDate-cal')]//span[text()='"+day+"']");
        click(divReleaseEndDay);
    }

    private String[] getDateParts(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date parsedDate = dateFormat.parse(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parsedDate);

        String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String month = String.valueOf(calendar.get(Calendar.MONTH)); // Los meses en Java van de 0 a 11
        String year = String.valueOf(calendar.get(Calendar.YEAR));

        return new String[]{day, month, year};
    }

}
