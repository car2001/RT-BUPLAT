package stepdefinitions.releasemanager;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.apps.home.HomePage;
import pages.apps.login.LoginPage;
import pages.apps.releasemanager.project.ProjectPage;
import stepdefinitions.TestConfig;
import utilities.Asserts;
import utilities.CommonFormsPage;

public class ProjectSteps {
    private WebDriver driver = TestConfig.getDriver();
    private HomePage homePage = new HomePage(driver);
    private LoginPage loginPage = new LoginPage(driver);
    private ProjectPage projectPage = new ProjectPage(driver);
    private CommonFormsPage  commonFormsPage = new CommonFormsPage(driver);
    private Asserts asserts = new Asserts(driver);


    @Given("el usuario ha iniciado sesión y esta en la aplicación Release Manager")
    public void el_usuario_ha_iniciado_sesión_y_esta_en_la_aplicación_release_manager() {
        loginPage.get("http://wedox.sytes.net/BUPLAT_config");
        loginPage.loginUser("tester","1234");
        homePage.clickBtnReleaseManager();
    }
    @When("el usuario hace clic derecho en Proyectos")
    public void el_usuario_hace_clic_derecho_en_proyectos() {
        projectPage.rightClickNodeProject();
    }
    @When("el usuario hace click en Nuevo Proyecto")
    public void el_usuario_hace_click_en_nuevo_proyecto() {
        projectPage.clickNewProject();
    }
    @When("llena todos los campos requeridos")
    public void llena_todos_los_campos_requeridos() {
        commonFormsPage.fillGeneralForm("Projecto Tester","Projecto Tester","Projecto Tester");
        projectPage.fillProjectDataForm("20","25","2025","Open");
    }
    @When("hace clic en el botón de guardar")
    public void hace_clic_en_el_botón_de_guardar() {
        commonFormsPage.clickBtnSave();
    }
    @Then("se muestra un mensaje confirmando que se ha creado el proyecto")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_creado_el_proyecto() {
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSave(textMessage);
        System.out.println(textMessage);
    }

}
