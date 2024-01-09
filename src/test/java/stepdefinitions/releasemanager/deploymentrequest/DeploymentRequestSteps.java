package stepdefinitions.releasemanager.deploymentrequest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.apps.releasemanager.deploymentpackage.DeploymentPackagePage;
import pages.apps.releasemanager.deploymentrequest.DeploymentRequestPage;
import stepdefinitions.TestConfig;
import utilities.Asserts;
import utilities.CommonFormsFunctions;
import utilities.WaitFunctions;

import java.util.Map;

public class DeploymentRequestSteps {

    private WebDriver driver = TestConfig.getDriver();
    private DeploymentRequestPage deploymentRequestPage = new DeploymentRequestPage(driver);
    private CommonFormsFunctions commonFormsPage = new CommonFormsFunctions(driver);
    private Asserts asserts = new Asserts(driver);
    private WaitFunctions waitFunctions = new WaitFunctions(driver);

    //------------------------------ Scenario: TCR-19 Crear un Deployment Request desde el árbol -------------------------------
    @Given("el usuario hace click en la opción New Deployment Request")
    public void el_usuario_hace_click_en_la_opción_new_deployment_request() {
        deploymentRequestPage.clickArrowMainDeploymentRequest();
        deploymentRequestPage.rightClickNodeOpen();
        deploymentRequestPage.clickNewDeploymentRequest();
    }
    @When("llena el formulario del deployment request con los siguientes valores:")
    public void llena_el_formulario_del_deployment_request_con_los_siguientes_valores(Map<String, String> deploymentRequestFields) {
        String displayNameDeploymentRequest = deploymentRequestFields.get("displayName");
        String descriptionDeploymentRequest= deploymentRequestFields.get("description");
        String projectDeploymentRequest = deploymentRequestFields.get("project");
        String releaseDeploymentRequest = deploymentRequestFields.get("release");

        commonFormsPage.fillGeneralForm(displayNameDeploymentRequest,descriptionDeploymentRequest);
        deploymentRequestPage.fillChangeContainerForm(projectDeploymentRequest,releaseDeploymentRequest);
    }
    @Then("se muestra un mensaje confirmando que se ha creado el deployment request")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_creado_el_deployment_request() {
        String textMessage = commonFormsPage.textMessageSection();
        String valueNameInput = commonFormsPage.getValueName();

        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessDeploymentRequest(textMessage,valueNameInput);
    }
    //------------------------------ End Scenario: TCR-19 Crear un Deployment Request desde el árbol ---------------------------


    //------------------------------ Scenario: TCR-20 Crear un Deployment Request desde la tabla -------------------------------
    @Given("el usuario hace click en el botón de agregar de la tabla de Deployment Request")
    public void el_usuario_hace_click_en_el_botón_de_agregar_de_la_tabla_de_deployment_request() {
        deploymentRequestPage.clickArrowMainDeploymentRequest();
        deploymentRequestPage.clickNodeOpen();

        commonFormsPage.clickBtnAddTable();
        waitFunctions.waitForMainPageToFinishLoading();
    }

    @Then("se muestra un mensaje confirmando que se ha creado el deployment request desde la tabla")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_creado_el_deployment_request_desde_la_tabla() {
        String textMessage = commonFormsPage.textMessageSection();
        String valueNameInput = deploymentRequestPage.getTextFirstDRTable();

        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessDeploymentRequest(textMessage,valueNameInput);
    }
    //------------------------------ End Scenario: TCR-20 Crear un Deployment Request desde la tabla ---------------------------



    //------------------------------ Scenario: TCR-21 Editar un Deployment Request desde el árbol ---------------------------
    @Given("el usuario hace click en el deployment request {string} desde el árbol y hace hace click en el botón editar")
    public void el_usuario_hace_click_en_el_deployment_request_desde_el_árbol_y_hace_hace_click_en_el_botón_editar(String deploymentRequest) {
        deploymentRequestPage.clickArrowMainDeploymentRequest();
        deploymentRequestPage.clickArrowNodeOpen();

        deploymentRequestPage.clickDeploymentRequestSelect(deploymentRequest);
        commonFormsPage.clickBtnEdit();
    }
    @When("realiza la edición del formulario del deployment request con los siguientes valores actualizados:")
    public void realiza_la_edición_del_formulario_del_deployment_request_con_los_siguientes_valores_actualizados(Map<String, String> deploymentRequestFields) {
        String displayNameDR = deploymentRequestFields.get("displayName");
        String descriptionDR = deploymentRequestFields.get("description");

        commonFormsPage.clearDisplayName();
        commonFormsPage.clearDescription();
        commonFormsPage.fillGeneralForm(displayNameDR,descriptionDR);
    }
    @Then("se muestra un mensaje confirmando que se ha editado el deployment request desde el árbol")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_editado_el_deployment_request_desde_el_árbol() {
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-21 Editar un Deployment Request desde el árbol ---------------------------


    //------------------------------ Scenario: TCR-22 Editar un Deployment Request desde la tabla ---------------------------
    @Given("el usuario selecciona el deployment request {string} desde la tabla y hace hace click en el botón editar")
    public void el_usuario_selecciona_el_deployment_request_desde_la_tabla_y_hace_hace_click_en_el_botón_editar(String deploymentRequest) {
        deploymentRequestPage.clickArrowMainDeploymentRequest();
        deploymentRequestPage.clickNodeOpen();
        waitFunctions.waitForMainPageToFinishLoading();

        commonFormsPage.enterInputFilerTable(deploymentRequest);
        commonFormsPage.clickBtnSearchTable();

        deploymentRequestPage.selectDeploymentRequestTable(deploymentRequest);
        commonFormsPage.clickBtnEditTable();
    }
    @Then("se muestra un mensaje confirmando que se ha editado el deployment request desde la tabla")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_editado_el_deployment_request_desde_la_tabla() {
        waitFunctions.waitForMainPageToFinishLoading();
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }

    //------------------------------ End Scenario: TCR-22 Editar un Deployment Request desde la tabla ---------------------------


    //------------------------------ Scenario: TCR-23 Eliminar un Deployment Request desde el árbol ---------------------------
    @Given("el usuario realiza clic derecho en el deployment request {string} desde el árbol")
    public void el_usuario_realiza_clic_derecho_en_el_deployment_request_desde_el_árbol(String deploymentRequest) {
        deploymentRequestPage.clickArrowMainDeploymentRequest();
        deploymentRequestPage.clickArrowNodeOpen();

        deploymentRequestPage.rightClickDeploymentRequestSelect(deploymentRequest);
    }
    @When("selecciona la opción Delete Deployment Request")
    public void selecciona_la_opción_delete_deployment_request() {
        deploymentRequestPage.clickDeleteDeploymentRequest();
    }
    @Then("se muestra un mensaje confirmando que se ha eliminado el deployment request del árbol")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_eliminado_el_deployment_request_del_árbol() {
        commonFormsPage.confirmDeleteObject();

        commonFormsPage.confirmSuccessOperation();
        String textMessage = commonFormsPage.textMessageDialog();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-23 Eliminar un Deployment Request desde el árbol---------------------------


    //------------------------------ Scenario: TCR-24 Eliminar un Deployment Request desde la tabla ---------------------------
    @Given("el usuario selecciona el deployment request {string} desde la tabla")
    public void el_usuario_selecciona_el_deployment_request_desde_la_tabla(String deploymentRequest) {
        deploymentRequestPage.clickArrowMainDeploymentRequest();
        deploymentRequestPage.clickNodeOpen();
        waitFunctions.waitForMainPageToFinishLoading();

        commonFormsPage.enterInputFilerTable(deploymentRequest);
        commonFormsPage.clickBtnSearchTable();

        deploymentRequestPage.selectDeploymentRequestTable(deploymentRequest);
    }
    @When("hace clic en el botón de eliminar de la tabla de Deployment Request")
    public void hace_clic_en_el_botón_de_eliminar_de_la_tabla_de_Deployment_Request() {
        commonFormsPage.clickBtnDeleteTable();
        commonFormsPage.confirmDeleteObject();
    }
    @Then("se muestra un mensaje confirmando que se ha eliminado el deployment request de la tabla")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_eliminado_el_deployment_request_de_la_tabla() {
        waitFunctions.waitForMainPageToFinishLoading();
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-24 Eliminar un Deployment Request desde la tabla ---------------------------


}
