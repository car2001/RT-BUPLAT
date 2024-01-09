package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;

public class WaitFunctions extends Base {

    private static By mainTreeBusyIndicator = By.xpath("//div[contains(@id,'mainTree-busyIndicator')]");
    private static By mainPageBusyIndicator = By.xpath("//div[@id='sapUiBusyIndicator' and contains(@class,'sapUiUserSelectable')]");
    public  WaitFunctions(WebDriver driver){
        super(driver);
    }

    public static void waitForMainTreeToFinishLoading() {
        waitInvisibilityElement(mainTreeBusyIndicator);
    }
    public static void waitForMainPageToFinishLoading(){
        waitInvisibilityElement(mainPageBusyIndicator);
    }
}
