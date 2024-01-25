package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.apps.home.HomePage;
import pages.apps.login.LoginPage;
import utilities.CommonFormsFunctions;

public class CommonSteps {

    private WebDriver driver = TestConfig.getDriver();
    private LoginPage loginPage = new LoginPage(driver);
    private HomePage homePage = new HomePage(driver);
    private CommonFormsFunctions commonFormsPage = new CommonFormsFunctions(driver);
    private String urlPage = TestConfig.getUrlPage();
    private String user = TestConfig.getUser();
    private String password = TestConfig.getPassword();

    // Login y redirect an Application
    @Given("el usuario ha iniciado sesión y esta en la aplicación Release Manager")
    public void el_usuario_ha_iniciado_sesión_y_esta_en_la_aplicación_release_manager() {
        loginPage.get(urlPage);
        loginPage.loginUser(user,password);
        homePage.clickBtnReleaseManager();
    }

    @Given("el usuario ha iniciado sesión y esta en la aplicación Organizational Structure Manager")
    public void el_usuario_ha_iniciado_sesión_y_esta_en_la_aplicación_organizational_structure_manager() {
        loginPage.get(urlPage);
        loginPage.loginUser(user,password);
        homePage.clickBtnOrganizationalStructureManager();
    }
    @Given("el usuario ha iniciado sesión y esta en la aplicación Security Manager")
    public void el_usuario_ha_iniciado_sesión_y_esta_en_la_aplicación_security_manager(){
        loginPage.get(urlPage);
        loginPage.loginUser(user,password);
        homePage.clickBtnSecurityManager();
    }
    @Given("el usuario ha iniciado sesión y esta en la aplicación Configuration Manager")
    public void el_usuario_ha_iniciado_sesión_y_esta_en_la_aplicación_configuration_manager(){
        loginPage.get(urlPage);
        loginPage.loginUser(user,password);
        homePage.clickBtnConfigurationManager();
    }

    // Actions in Forms
    @And("hace clic en el botón de guardar")
    public void hace_clic_en_el_botón_de_guardar(){
        commonFormsPage.clickBtnSave();
    }

}
