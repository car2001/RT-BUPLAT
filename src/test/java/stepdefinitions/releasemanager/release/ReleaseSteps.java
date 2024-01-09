package stepdefinitions.releasemanager.release;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.apps.releasemanager.project.ProjectPage;
import pages.apps.releasemanager.release.ReleasePage;
import stepdefinitions.TestConfig;
import utilities.Asserts;
import utilities.CommonFormsFunctions;

import java.text.ParseException;
import java.util.Map;

public class ReleaseSteps {
    private WebDriver driver = TestConfig.getDriver();
    private ProjectPage projectPage = new ProjectPage(driver);
    private ReleasePage releasePage = new ReleasePage(driver);
    private CommonFormsFunctions commonFormsPage = new CommonFormsFunctions(driver);
    private Asserts asserts = new Asserts(driver);


    //------------------------------ Scenario: TCR-04 Crear Release -----------------------------
    @Given("se crea un proyecto que permita usar release:$")
    public void se_crea_un_proyecto_que_permita_usar_release(Map<String, String> projectFields) {
        projectPage.rightClickNodeProject();
        projectPage.clickNewProject();
        projectPage.clickArrowMainProject();

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

        projectPage.clickProjectSelect(nameProject);
        projectPage.clickArrowProjectSelect(nameProject);
    }
    @When("hace clic en el botón de Nueva Liberación")
    public void hace_clic_en_el_botón_de_Nueva_Liberación(){
        releasePage.clickMainRelease();
        releasePage.rightClickMainRelease();
        releasePage.clickNewRelease();
    }
    @And("llena el formulario de release con los siguientes valores:$")
    public void llena_el_formulario_de_release_con_los_siguientes_valores(Map<String, String> releaseFields) throws ParseException {
        String nameRelease = releaseFields.get("name");
        String displayNameRelease = releaseFields.get("displayName");
        String descriptionRelease= releaseFields.get("description");
        String startDateRelease = releaseFields.get("startDateRelease");
        String endDateRelease = releaseFields.get("endDateRelease");
        String idRelease = releaseFields.get("idRelease");
        String stateProject = releaseFields.get("stateRelease");

        commonFormsPage.fillGeneralForm(nameRelease,displayNameRelease,descriptionRelease);
        releasePage.fillReleaseDataForm(startDateRelease,endDateRelease,idRelease,stateProject);
    }
    @Then("se muestra un mensaje confirmando que se ha creado el release")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_creado_el_release(){
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-04 Crear Release ------------------------------


    //------------------------------ Scenario: TCR-05 Editar Release -----------------------------
    @Given("se tiene el proyecto {string} y el release {string} creado")
    public void se_tiene_un_proyecto_y_release_creado(String nameProject, String nameRelease) {
        projectPage.clickArrowMainProject();
        projectPage.clickProjectSelect(nameProject);
        projectPage.clickArrowProjectSelect(nameProject);

        releasePage.clickMainRelease();
        releasePage.clickArrowMainRelease();

        releasePage.clickReleaseSelect(nameRelease);
    }

    @When("el usuario realiza la edición del release existente con los siguientes valores:")
    public void el_usuario_realiza_la_edición_del_release_existente_con_los_siguientes_valores(Map<String, String> releaseFields) {
        String nameRelease = releaseFields.get("name");
        String displayNameRelease = releaseFields.get("displayName");
        String descriptionRelease= releaseFields.get("description");

        commonFormsPage.clickBtnEdit();

        commonFormsPage.clearName();
        commonFormsPage.clearDisplayName();
        commonFormsPage.clearDescription();

        commonFormsPage.fillGeneralForm(nameRelease,displayNameRelease,descriptionRelease);

        commonFormsPage.clickBtnSave();
    }

    @Then("se muestra un mensaje confirmando la edición exitosa")
    public void se_muestra_un_mensaje_confirmando_la_edición_exitosa() {
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-05 Editar Release ------------------------------


    //------------------------------ Scenario: TCR-06 Eliminar Release ---------------------------------
    @When("el usuario elimina el release {string} y el proyecto {string} existente")
    public void el_usuario_elimina_el_release_y_el_proyecto_existente( String nameRelease,String nameProject) {
        releasePage.rightClickReleaseSelect(nameRelease);
        releasePage.clickDeleteRelease();

        commonFormsPage.confirmDeleteObject();

        commonFormsPage.confirmSuccessOperation();
        String textMessage = commonFormsPage.textMessageDialog();
        asserts.assertSuccessOperation(textMessage);

        projectPage.clickArrowProjectSelect(nameProject);
        projectPage.rightClickProjectSelect(nameProject);

        projectPage.clickDeleteProject();
        commonFormsPage.confirmDeleteObject();

    }
    @Then("se muestra un mensaje confirmando la eliminación del release")
    public void se_muestra_un_mensaje_confirmando_la_eliminación_del_release() {
        commonFormsPage.confirmSuccessOperation();
        String textMessage = commonFormsPage.textMessageDialog();
        asserts.assertSuccessOperation(textMessage);
    }

    //------------------------------ End Scenario: TCR-06 Eliminar Release ------------------------------

}
