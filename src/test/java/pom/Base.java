package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Base {

    private WebDriver driver;
    private Actions action;

    public Base(WebDriver driver){
        this.driver = driver;
    }

    public void get(String url){
        driver.get(url);
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public void sendKeys(String inputText, By locator){
        waitVisibilityElement(locator);
        if(isDisplayed(locator)){
            waitClickableElement(locator);
            driver.findElement(locator).sendKeys(inputText);
        }
    }

    public void click(By locator){
        waitVisibilityElement(locator);
        if(isDisplayed(locator)){
            waitClickableElement(locator);
            driver.findElement(locator).click();
        }
    }

    public void rightClick(By locator){
        action = new Actions(driver);
        waitVisibilityElement(locator);
        if(isDisplayed(locator)){
            waitClickableElement(locator);
            action.contextClick(driver.findElement(locator)).perform();
        }
    }

    public void clear(By locator){
        waitVisibilityElement(locator);
        if(isDisplayed(locator)){
            waitClickableElement(locator);
            driver.findElement(locator).clear();
        }
    }

    public Boolean isDisplayed(By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
           return false;
        }
    }

    public String getText(By locator){
        String textElement = "";
        waitVisibilityElement(locator);
        if(isDisplayed(locator)){
            textElement = driver.findElement(locator).getText();
        }
        return textElement;
    }

    public void waitVisibilityElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitClickableElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getCause());
        }
    }

    public String getLanguage(){
        String language = driver.findElement(By.xpath("//html")).getAttribute("lang");
        return language;
    }

}
