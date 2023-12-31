package stepdefinitions.releasemanager;

import io.cucumber.java.en.And;
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

import java.util.Map;

public class ProjectSteps {
    private WebDriver driver = TestConfig.getDriver();
    private HomePage homePage = new HomePage(driver);
    private LoginPage loginPage = new LoginPage(driver);
    private ProjectPage projectPage = new ProjectPage(driver);
    private CommonFormsPage  commonFormsPage = new CommonFormsPage(driver);
    private Asserts asserts = new Asserts(driver);


    //------------------------------ Background --------------------------------------------------

    @Given("el usuario ha iniciado sesión y esta en la aplicación Release Manager")
    public void el_usuario_ha_iniciado_sesión_y_esta_en_la_aplicación_release_manager() {
        loginPage.get("http://wedox.sytes.net/BUPLAT_config");
        loginPage.loginUser("tester","1234");
        homePage.clickBtnReleaseManager();
    }

    //------------------------------ End Background --------------------------------------------------

    //------------------------------ Scenario: TCR-01 Crear Proyecto -----------------------------

    @When("el usuario hace click en Nuevo Proyecto")
    public void el_usuario_hace_click_en_nuevo_proyecto() {
        projectPage.rightClickNodeProject();
        projectPage.clickNewProject();
    }
    @When("llena el formulario de proyecto con los siguientes valores:$")
    public void llena_el_formulario_de_proyecto_con_los_siguientes_valores(Map<String, String> projectFields) {

        String nameProject = projectFields.get("name");
        String displayNameProject = projectFields.get("displayName");
        String descriptionProject = projectFields.get("description");
        String startDayProject = projectFields.get("startDay");
        String endDayProject = projectFields.get("endDay");
        String endYearProject = projectFields.get("endYear");
        String stateProject = projectFields.get("state");
        String useProject = projectFields.get("useProject");
        String useReleases = projectFields.get("useReleases");

        commonFormsPage.fillGeneralForm(nameProject,displayNameProject,descriptionProject);
        projectPage.fillProjectDataForm(startDayProject,endDayProject,endYearProject,stateProject, useProject, useReleases);
    }
    @And("hace clic en el botón de guardar")
    public void hace_clic_en_el_botón_de_guardar(){
        commonFormsPage.clickBtnSave();
    }
    @Then("se muestra un mensaje confirmando que se ha creado el proyecto")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_creado_el_proyecto() {
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }

    //------------------------------ End Scenario: TCR-01 Crear Proyecto ------------------------------



    //------------------------------ Scenario: TCR-02 Editar Proyecto ---------------------------------

    @When("el usuario hace click en el proyecto {string} para editarlo")
    public void el_usuario_hace_click_en_un_proyecto_a_editar(String nameProject) {
        projectPage.clickArrowProject();
        projectPage.clickProjectSelect(nameProject);
    }
    @When("hace clic en el botón editar y se editan los campos del formulario con los siguientes valores:$")
    public void hace_clic_en_el_botón_editar_y_se_cambian_los_campos_del_formulario_de_proyecto(Map<String, String> projectFields) {

        String nameProject = projectFields.get("name");
        String displayNameProject = projectFields.get("displayName");
        String descriptionProject = projectFields.get("description");

        commonFormsPage.clickBtnEdit();
        commonFormsPage.clearName();
        commonFormsPage.clearDisplayName();
        commonFormsPage.clearDescription();
        commonFormsPage.fillGeneralForm(nameProject,displayNameProject,descriptionProject);
        commonFormsPage.clickBtnSave();
    }
    @Then("se muestra un mensaje confirmando que se ha editado el proyecto")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_editado_el_proyecto() {
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }

    //------------------------------ END Scenario: TCR-02 Editar Proyecto --------------------------------



    //--------------------- Scenario: TCR-03 Crear un proyecto con release -------------------------------

    @When("se crea un proyecto que use release con los siguientes valores:$")
    public void se_crea_un_proyecto_que_use_release_con_los_siguientes_valores(Map<String, String> projectFields){

        projectPage.rightClickNodeProject();
        projectPage.clickNewProject();
        projectPage.clickArrowProject();

        String nameProject = projectFields.get("name");
        String displayNameProject = projectFields.get("displayName");
        String descriptionProject = projectFields.get("description");
        String startDayProject = projectFields.get("startDay");
        String endDayProject = projectFields.get("endDay");
        String endYearProject = projectFields.get("endYear");
        String stateProject = projectFields.get("state");
        String useProject = projectFields.get("useProject");
        String useReleases = projectFields.get("useReleases");

        commonFormsPage.fillGeneralForm(nameProject,displayNameProject,descriptionProject);
        projectPage.fillProjectDataForm(startDayProject,endDayProject,endYearProject,stateProject, useProject, useReleases);

        commonFormsPage.clickBtnSave();
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);

        projectPage.clickBranchProjectSelect(displayNameProject);
    }

    @And("se verifica que se cree la carpeta release dentro del proyecto")
    public void se_verifica_que_se_cree_la_carpeta_release_dentro_del_proyecto(){

    }

    //--------------------- End Scenario: TCR-03 Crear un proyecto con release -----------------------------


    //----------------------- Scenario: TCR-04: Crear un proyecto sin release  -----------------------------

    @When("se crea un proyecto que no use release con los siguientes valores:$")
    public void se_crea_un_proyecto_que_no_use_release_con_los_siguientes_valores(Map<String, String> projectFields){
        projectPage.rightClickNodeProject();
        projectPage.clickNewProject();
        projectPage.clickArrowProject();

        String nameProject = projectFields.get("name");
        String displayNameProject = projectFields.get("displayName");
        String descriptionProject = projectFields.get("description");
        String startDayProject = projectFields.get("startDay");
        String endDayProject = projectFields.get("endDay");
        String endYearProject = projectFields.get("endYear");
        String stateProject = projectFields.get("state");
        String useProject = projectFields.get("useProject");
        String useReleases = projectFields.get("useReleases");

        commonFormsPage.fillGeneralForm(nameProject,displayNameProject,descriptionProject);
        projectPage.fillProjectDataForm(startDayProject,endDayProject,endYearProject,stateProject, useProject, useReleases);

        commonFormsPage.clickBtnSave();
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);

        projectPage.clickBranchProjectSelect(displayNameProject);
    }

    @And("se verifica que no se cree la carpeta release dentro del proyecto")
    public void  se_verifica_que_no_se_cree_la_carpeta_release_dentro_del_proyecto(){

    }

    //----------------------- End Scenario: TCR-04: Crear un proyecto sin release ----------------------


    //------------------------------ Scenario: TCR-05 Eliminar Proyecto --------------------------------

    @When("el usuario hace click en el proyecto {string} para eliminar")
    public void el_usuario_hace_click_en_un_proyecto_a_eliminar(String nameProject) {
        projectPage.clickArrowProject();
        projectPage.rightClickProjectSelect(nameProject);
    }
    @And("hace clic en el botón eliminar")
    public void hace_clic_en_el_botón_eliminar(){
        projectPage.clickDeleteProject();
        projectPage.clickYesDelete();
    }

    @Then("se muestra un mensaje confirmando que se ha eliminado el proyecto")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_eliminado_el_proyecto() {
        commonFormsPage.clickBtnOkDialog();
        String textMessage = commonFormsPage.textMessageDialog();
        asserts.assertSuccessOperation(textMessage);
    }

    //---------------------------- End Scenario: TCR-05 Eliminar Proyecto ----------------------
}
