package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Base {

    private static WebDriver driver;
    private static Actions action;

    public Base(WebDriver driver){
        this.driver = driver;
        this.action = new Actions(driver);
    }

    public void get(String url){
        driver.get(url);
    }

    public static WebElement findElement(By locator){
        waitVisibilityElement(locator);
        isDisplayed(locator);
        return driver.findElement(locator);
    }

    public static List<WebElement> findElements(By locator){
        List<WebElement> elements = new ArrayList<>();
        waitVisibilityElement(locator);
        if(isDisplayed(locator)){
            elements = driver.findElements(locator);
        }
        return elements;
    }

    public static void sendKeys(String inputText, By locator){
        waitVisibilityElement(locator);
        if(isDisplayed(locator)){
            waitClickableElement(locator);
            driver.findElement(locator).sendKeys(inputText);
        }
    }

    public static void click(By locator){
        waitVisibilityElement(locator);
        if(isDisplayed(locator)){
            waitClickableElement(locator);
            driver.findElement(locator).click();
        }
    }

    public static void rightClick(By locator){
        waitVisibilityElement(locator);
        if(isDisplayed(locator)){
            waitClickableElement(locator);
            action.contextClick(driver.findElement(locator)).perform();
        }
    }

    public static void clear(By locator){
        waitVisibilityElement(locator);
        if(isDisplayed(locator)){
            waitClickableElement(locator);
            driver.findElement(locator).clear();
        }
    }

    public static Boolean isDisplayed(By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
           return false;
        }
    }

    public static String getText(By locator){
        String textElement = "";
        waitVisibilityElement(locator);
        if(isDisplayed(locator)){
            textElement = driver.findElement(locator).getText();
        }
        return textElement;
    }

    public static String getAttribute(By locator, String nameAttribute){
        String valueAttribute = "";
        waitVisibilityElement(locator);
        if(isDisplayed(locator)){
            valueAttribute =  driver.findElement(locator).getAttribute(nameAttribute);
        }
        return  valueAttribute;
    }
    public static void waitVisibilityElement(By locator){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch (NoSuchElementException e){
            System.out.println(e);
        }
    }

    public static void waitInvisibilityElement(By locator){
        try{
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        }catch (NoSuchElementException e){
            System.out.println(e);
        }
    }

    public static void waitClickableElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getCause());
        }
    }
    public static String getLanguage(){
        String language = findElement(By.xpath("//html")).getAttribute("lang");
        return language;
    }
    public static String getXmlView() {
        String xmlViewXpath = "//div[contains(@id,'xmlview') and contains(@class,'sapUiView sapUiXMLView sapMNavItem') and not(contains(@class,'sapMNavItemHidden'))]";
        String idXMLView = findElement(By.xpath(xmlViewXpath)).getAttribute("id");
        return idXMLView;
    }
    public static void scrollElementTo(JavascriptExecutor js, By element, int position) {
        js.executeScript("arguments[0].scroll(0,'" + position + "')", findElement(element));
    }

}
