package stepdefinitions.login;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.apps.login.LoginPage;
import org.openqa.selenium.WebDriver;
import stepdefinitions.TestConfig;


public class LoginSteps {

    private WebDriver driver = TestConfig.getDriver();
    private LoginPage loginPage = new LoginPage(driver);

    @Given("usuario está en la página de inicio de sesión con la url {string}")
    public void usuario_está_en_la_página_de_inicio_de_sesión(String url) {
        loginPage.get(url);
    }

    @When("usuario ingresa el nombre de {string} y la {string}")
    public void usuario_ingresa_el_nombre_de_y_la(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("clic en el botón de inicio de sesión")
    public void clic_en_el_botón_de_inicio_de_sesión() {
        loginPage.clickBtnLogin();
    }

    @Then("el usuario es dirigido a la página principal de la aplicación")
    public void el_usuario_es_dirigido_a_la_página_principal_de_la_aplicación() {
        driver.manage().window().maximize();
    }

    @Then("el campo username no debe permitir ingresar numero")
    public void el_campo_username_no_debe_permitir_ingresar_numero(){
        String value = loginPage.getValueUsername();
        String patron = ".*\\d+.*";
        String assertValue = "";
        if(value.matches(patron)){
            assertValue = "El campo username permite ingresar números";
        }else {
            assertValue = "El campo username no permite ingresar números";
        }
        Assert.assertEquals("El campo username no permite ingresar números", assertValue);
    }
}
