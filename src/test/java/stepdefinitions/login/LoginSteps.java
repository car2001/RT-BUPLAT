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

    @Given("usuario está en la página de inicio de sesión")
    public void usuario_está_en_la_página_de_inicio_de_sesión()  {
        loginPage.get("http://wedox.sytes.net/BUPLAT_config/");
    }
    @When("usuario ingresa el nombre de {string} y la {string}")
    public void usuario_ingresa_el_nombre_de_y_la(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }
    @When("clic en el botón de inicio de sesión")
    public void clic_en_el_botón_de_inicio_de_sesión()  {
        loginPage.clickBtnLogin();
    }
    @Then("el usuario es dirigido a la página principal de la aplicación")
    public void el_usuario_es_dirigido_a_la_página_principal_de_la_aplicación() {
        driver.manage().window().maximize();
    }





}
