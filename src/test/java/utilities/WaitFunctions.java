package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.Base;

public class WaitFunctions extends Base {

    private static JavascriptExecutor js;
    private static By mainTreeBusyIndicator = By.xpath("//div[contains(@id,'mainTree-busyIndicator')]");
    private static By mainPageBusyIndicator = By.xpath("//div[@id='sapUiBusyIndicator' and contains(@class,'sapUiUserSelectable')]");
    public  WaitFunctions(WebDriver driver){
        super(driver);
        this.js = (JavascriptExecutor) driver;
    }

    public static void waitForMainTreeToFinishLoading() {
        waitInvisibilityElement(mainTreeBusyIndicator);
    }
    public static void waitForMainPageToFinishLoading(){
        do{
            waitVisibilityElement(mainPageBusyIndicator);
            waitInvisibilityElement(mainPageBusyIndicator);
            //System.out.println( js.executeScript("return window.getComputedStyle(arguments[0]).visibility;", busyIndicator));
        }while (isDisplayed(mainPageBusyIndicator));

    }
}
