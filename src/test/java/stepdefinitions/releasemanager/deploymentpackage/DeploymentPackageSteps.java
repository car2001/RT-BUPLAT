package stepdefinitions.releasemanager.deploymentpackage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.apps.releasemanager.deploymentpackage.DeploymentPackagePage;
import stepdefinitions.TestConfig;
import utilities.Asserts;
import utilities.CommonFormsFunctions;
import utilities.WaitFunctions;

import java.util.Map;

public class DeploymentPackageSteps {
    private WebDriver driver = TestConfig.getDriver();
    private DeploymentPackagePage deploymentPackagePage = new DeploymentPackagePage(driver);
    private CommonFormsFunctions commonFormsPage = new CommonFormsFunctions(driver);
    private Asserts asserts = new Asserts(driver);
    private WaitFunctions waitFunctions = new WaitFunctions(driver);

    //------------------------------ Scenario: TCR-13 Crear un Deployment Package desde el árbol -------------------------------
    @Given("el usuario hace click en la opción New Deployment Package")
    public void el_usuario_hace_click_en_la_opción_new_deployment_package() {
        deploymentPackagePage.clickArrowMainDeploymentPackage();
        deploymentPackagePage.rightClickNodeOpen();
        deploymentPackagePage.clickNewDeploymentPackage();
    }
    @When("llena el formulario del deployment package con los siguientes valores:")
    public void llena_el_formulario_del_deployment_package_con_los_siguientes_valores(Map<String, String> deploymentPackageFields) {
        String displayNameDeploymentPackage = deploymentPackageFields.get("displayName");
        String descriptionDeploymentPackage= deploymentPackageFields.get("description");
        String projectDeploymentPackage = deploymentPackageFields.get("project");
        String releaseDeploymentPackage = deploymentPackageFields.get("release");

        commonFormsPage.fillGeneralForm(displayNameDeploymentPackage,descriptionDeploymentPackage);
        deploymentPackagePage.fillChangeContainerForm(projectDeploymentPackage,releaseDeploymentPackage);
    }
    @Then("se muestra un mensaje confirmando que se ha creado el Deployment Package")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_creado_el_deployment_package() {
        String textMessage = commonFormsPage.textMessageSection();
        String valueNameInput = commonFormsPage.getValueName();

        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessDeploymentPackage(textMessage,valueNameInput);
    }
    //------------------------------ End Scenario: TCR-13 Crear un Deployment Package desde el árbol ---------------------------


    //------------------------------ Scenario: TCR-14 Crear un Deployment Package desde la tabla -------------------------------
    @Given("el usuario hace click en el botón de agregar de la tabla de Deployment Packages")
    public void el_usuario_hace_click_en_el_botón_de_agregar_de_la_tabla_de_deployment_packages() {
        deploymentPackagePage.clickArrowMainDeploymentPackage();
        deploymentPackagePage.clickNodeOpen();

        commonFormsPage.clickBtnAddTable();
    }
    @Then("se muestra un mensaje confirmando que se ha creado el Deployment Package desde la tabla")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_creado_el_Deployment_Package_desde_la_tabla(){
        waitFunctions.waitForMainPageToFinishLoading();
        String textMessage = commonFormsPage.textMessageSection();
        String valueNameInput = deploymentPackagePage.getTextFirstDPTable();

        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessDeploymentPackage(textMessage,valueNameInput);
    }
    //------------------------------ End Scenario: TCR-14 Crear un Deployment Package desde la tabla ---------------------------


    //------------------------------ Scenario: TCR-15 Editar un Deployment Package desde el árbol -------------------------------
    @Given("el usuario hace click al {string} existente desde el árbol y hace hace click en el botón editar")
    public void el_usuario_hace_click_al_existente_desde_el_árbol_y_hace_hace_click_en_el_botón_editar(String deploymentPackage) {
        deploymentPackagePage.clickArrowMainDeploymentPackage();
        deploymentPackagePage.clickArrowNodeOpen();

        deploymentPackagePage.clickDeploymentPackageSelect(deploymentPackage);
        commonFormsPage.clickBtnEdit();
    }
    @When("realiza la edición del formulario del deployment package con los siguientes valores actualizados:")
    public void realiza_la_edición_del_formulario_del_deployment_package_con_los_siguientes_valores_actualizados(Map<String, String> deploymentPackageFields) {
        String displayNameDP = deploymentPackageFields.get("displayName");
        String descriptionDP = deploymentPackageFields.get("description");

        commonFormsPage.clearDisplayName();
        commonFormsPage.clearDescription();
        commonFormsPage.fillGeneralForm(displayNameDP,descriptionDP);
    }
    @Then("se muestra un mensaje confirmando que se ha editado el deployment package")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_editado_el_deployment_package() {
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-15 Editar un Deployment Package desde el árbol ---------------------------


    //------------------------------ Scenario: TCR-16 Editar un Deployment Package desde la tabla -------------------------------
    @Given("el usuario selecciona al {string} desde la tabla y hace hace click en el botón editar")
    public void el_usuario_selecciona_al_desde_la_tabla_y_hace_hace_click_en_el_botón_editar(String deploymentPackage) {
        deploymentPackagePage.clickArrowMainDeploymentPackage();
        deploymentPackagePage.clickNodeOpen();
        waitFunctions.waitForMainPageToFinishLoading();

        commonFormsPage.enterInputFilerTable(deploymentPackage);
        commonFormsPage.clickBtnSearchTable();

        deploymentPackagePage.selectDeploymentPackageTable(deploymentPackage);
        commonFormsPage.clickBtnEditTable();
    }
    @Then("se muestra un mensaje confirmando que se ha editado el deployment package desde la tabla")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_editado_el_deployment_package_desde_la_tabla() {
        waitFunctions.waitForMainPageToFinishLoading();
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-16 Editar un Deployment Package desde la tabla ---------------------------


    //------------------------------ Scenario: TCR-17 Eliminar Deployment Package desde el árbol -------------------------------
    @Given("el usuario realiza clic derecho en el deployment package {string} desde el árbol")
    public void el_usuario_realiza_clic_derecho_en_el_deployment_package_desde_el_árbol(String deploymentPackage) {
        deploymentPackagePage.clickArrowMainDeploymentPackage();
        deploymentPackagePage.clickArrowNodeOpen();

        deploymentPackagePage.rightClickDeploymentPackageSelect(deploymentPackage);
    }
    @When("selecciona la opción Delete Deployment Package")
    public void selecciona_la_opción_delete_deployment_package() {
        deploymentPackagePage.clickDeleteDeploymentPackage();
    }
    @Then("se muestra un mensaje confirmando que se ha eliminado el deployment package del árbol")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_eliminado_el_deployment_package_del_árbol() {
        commonFormsPage.confirmDeleteObject();

        commonFormsPage.confirmSuccessOperation();
        String textMessage = commonFormsPage.textMessageDialog();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-17 Eliminar Deployment Package desde el árbol ---------------------------


    //------------------------------ Scenario: TCR-18 Eliminar Deployment Package desde la tabla -------------------------------
    @Given("el usuario selecciona el deployment package {string} desde la tabla")
    public void el_usuario_selecciona_el_deployment_package_desde_la_tabla(String deploymentPackage) {
        deploymentPackagePage.clickArrowMainDeploymentPackage();
        deploymentPackagePage.clickNodeOpen();
        waitFunctions.waitForMainPageToFinishLoading();

        commonFormsPage.enterInputFilerTable(deploymentPackage);
        commonFormsPage.clickBtnSearchTable();

        deploymentPackagePage.selectDeploymentPackageTable(deploymentPackage);
    }
    @When("hace clic en el botón de eliminar de la tabla Deployment Packages")
    public void hace_clic_en_el_botón_de_eliminar_de_la_tabla_deployment_packages() {
        commonFormsPage.clickBtnDeleteTable();
        commonFormsPage.confirmDeleteObject();
    }
    @Then("se muestra un mensaje confirmando que se ha eliminado el deployment package de la tabla")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_eliminado_el_deployment_package_de_la_tabla() {
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-18 Eliminar Deployment Package desde la tabla ---------------------------
}
