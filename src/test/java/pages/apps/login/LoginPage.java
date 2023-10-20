package pages.apps.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import pom.Base;

public class LoginPage extends Base {
    private By usernameField = By.xpath("//input[contains(@id,'inputUserName-inner')]");
    private By passwordField = By.xpath("//input[contains(@id,'--inputPassword-inner')]");
    private By loginButton = By.xpath("//button[contains(@id,'--btnSubmit')]");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void loginUser(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickBtnLogin();
    }

    public void enterUsername(String username){
        sendKeys(username, usernameField);
    }

    public void enterPassword(String password){
        sendKeys(password, passwordField);
    }

    public void clickBtnLogin(){
        click(loginButton);
    }

}
