package stepdefinitions.login;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.apps.login.LoginPage;
import org.openqa.selenium.WebDriver;
import stepdefinitions.TestConfig;


public class LoginSteps {

    private WebDriver driver = TestConfig.getDriver();
    private LoginPage loginPage = new LoginPage(driver);

    @Given("user is on login page")
    public void user_is_on_login_page() {
        loginPage.get("http://wedox.sytes.net/BUPLAT_config/");
    }
    @When("user enters username and password")
    public void user_enters_username_and_password() {
        loginPage.enterUsername("tester");
        loginPage.enterPassword("1234");
    }
    @When("click on login button")
    public void click_on_login_button() {
        loginPage.clickBtnLogin();
    }

    @Then("user is navigated to the applications home")
    public void user_is_navigated_to_the_applications_home() {
        driver.manage().window().maximize();
    }




}
