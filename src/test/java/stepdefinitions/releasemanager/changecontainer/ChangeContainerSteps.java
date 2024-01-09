package stepdefinitions.releasemanager.changecontainer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.apps.releasemanager.changecontainer.ChangeContainerPage;
import stepdefinitions.TestConfig;
import utilities.Asserts;
import utilities.CommonFormsFunctions;

import java.util.Map;

public class ChangeContainerSteps {
    private WebDriver driver = TestConfig.getDriver();
    private ChangeContainerPage changeContainerPage = new ChangeContainerPage(driver);
    private CommonFormsFunctions commonFormsPage = new CommonFormsFunctions(driver);
    private Asserts asserts = new Asserts(driver);

    //------------------------------ Scenario: TCR-07 Crear change container desde el árbol -----------------------------
    @Given("el usuario hace click en la opción New Change Container")
    public void el_usuario_hace_click_en_la_opción_new_change_container() {
        changeContainerPage.clickArrowMainChangeContainer();
        changeContainerPage.rightClickNodeOpen();
        changeContainerPage.clickNewChangeContainer();
    }
    @When("llena el formulario del change container con los siguientes valores:$")
    public void llena_el_formulario_del_change_container_con_los_siguientes_valores(Map<String, String> changeContainerFields) {
        String nameChangeContainer = changeContainerFields.get("name");
        String displayNameChangeContainer = changeContainerFields.get("displayName");
        String descriptionChangeContainer = changeContainerFields.get("description");
        String projectChangeContainer = changeContainerFields.get("project");
        String releaseChangeContainer = changeContainerFields.get("release");
        String ownerChangeContainer = changeContainerFields.get("owner");

        commonFormsPage.fillGeneralForm(nameChangeContainer,displayNameChangeContainer,descriptionChangeContainer);
        changeContainerPage.fillChangeContainerForm(projectChangeContainer,releaseChangeContainer,ownerChangeContainer);
    }
    @Then("se muestra un mensaje confirmando que se ha creado el change container")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_creado_el_change_container() {
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }

    //------------------------------ End Scenario: TCR-07 Crear change container desde el árbol ----------------------------


    //------------------------------ Scenario: TCR-08 Crear change container desde la tabla --------------------------------
    @Given("el usuario hace click en el botón de agregar de la tabla de Change Containers")
    public void el_usuario_hace_click_en_el_botón_de_agregar_de_la_tabla_de_change_containers() {
        changeContainerPage.clickArrowMainChangeContainer();
        changeContainerPage.clickNodeOpen();

        commonFormsPage.clickBtnAddTable();

    }
    //------------------------------ End Scenario: TCR-08 Crear change container desde la tabla ----------------------------

    //------------------------------ Scenario: TCR-09 Editar change container desde el árbol --------------------------------
    @Given("el usuario selecciona el {string} existente desde el árbol y hace hace click en el botón editar")
    public void el_usuario_selecciona_al_existente_desde_el_árbol_y_hace_hace_click_en_el_botón_editar(String changeContainer) {
        changeContainerPage.clickArrowMainChangeContainer();
        changeContainerPage.clickArrowNodeOpen();

        changeContainerPage.clickChangeContainerSelect(changeContainer);
        commonFormsPage.clickBtnEdit();
    }
    @When("realiza la edición del formulario del change container con los siguientes valores actualizados:")
    public void realiza_la_edición_del_formulario_del_change_container_con_los_siguientes_valores_actualizados(Map<String, String> releaseFields) {
        String nameRelease = releaseFields.get("name");
        String displayNameRelease = releaseFields.get("displayName");
        String descriptionRelease= releaseFields.get("description");

        commonFormsPage.clearName();
        commonFormsPage.clearDisplayName();
        commonFormsPage.clearDescription();
        commonFormsPage.fillGeneralForm(nameRelease,displayNameRelease,descriptionRelease);
    }
    @Then("se muestra un mensaje confirmando que se ha editado el change container")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_editado_el_change_container() {
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-09 Editar change container desde el árbol ----------------------------


    //------------------------------ Scenario: TCR-10 Editar change container desde la tabla --------------------------------
    @Given("el usuario selecciona el {string} desde la tabla y hace hace click en el botón editar")
    public void el_usuario_selecciona_el_change_container_desde_la_tabla_y_hace_hace_click_en_el_botón_editar(String changeContainer) {
        changeContainerPage.clickArrowMainChangeContainer();
        changeContainerPage.clickNodeOpen();

        commonFormsPage.enterInputFilerTable(changeContainer);
        commonFormsPage.clickBtnSearchTable();

        changeContainerPage.selectChangeContainerTable(changeContainer);
        commonFormsPage.clickBtnEditTable();
    }
    //------------------------------ End Scenario: TCR-10 Editar change container desde la tabla ----------------------------

    //------------------------------ Scenario: TCR-11 Eliminar change container desde el árbol -------------------------------
    @Given("el usuario realiza clic derecho en el {string} desde el árbol")
    public void el_usuario_realiza_clic_derecho_en_el_desde_el_árbol(String changeContainer) {
        changeContainerPage.clickArrowMainChangeContainer();
        changeContainerPage.clickArrowNodeOpen();

        changeContainerPage.rightClickChangeContainerSelect(changeContainer);
    }
    @When("selecciona la opción Delete Change Container")
    public void selecciona_la_opción_delete_change_container() {
        changeContainerPage.clickDeleteChangeContainer();
    }
    @Then("se muestra un mensaje confirmando que se ha eliminado el change container del árbol")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_eliminado_el_change_container() {
        commonFormsPage.confirmDeleteObject();

        commonFormsPage.confirmSuccessOperation();
        String textMessage = commonFormsPage.textMessageDialog();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-11 Eliminar change container desde el árbol ---------------------------

    //------------------------------ Scenario: TCR-12 Eliminar change container desde la tabla -------------------------------
    @Given("el usuario selecciona el {string} desde la tabla")
    public void el_usuario_selecciona_el_desde_la_tabla(String changeContainer) {
        changeContainerPage.clickArrowMainChangeContainer();
        changeContainerPage.clickNodeOpen();

        commonFormsPage.enterInputFilerTable(changeContainer);
        commonFormsPage.clickBtnSearchTable();

        changeContainerPage.selectChangeContainerTable(changeContainer);
    }
    @When("hace clic en el botón de eliminar de la tabla de Change Containers")
    public void hace_clic_en_el_botón_de_eliminar_de_la_tabla_de_change_containers() {
        commonFormsPage.clickBtnDeleteTable();
        commonFormsPage.confirmDeleteObject();
    }
    @Then("se muestra un mensaje confirmando que se ha eliminado el change container de la tabla")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_eliminado_el_change_container_de_la_tabla() {
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-12 Eliminar change container desde la tabla ---------------------------
}
