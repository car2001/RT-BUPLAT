package stepdefinitions.configurationmanager.formui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.apps.configurationmanager.formui.FormUIPage;
import stepdefinitions.TestConfig;
import utilities.Asserts;
import utilities.CommonFormsFunctions;
import utilities.WaitFunctions;

import java.util.Map;

public class FormUISteps {
    private WebDriver driver = TestConfig.getDriver();
    private FormUIPage formUIPage = new FormUIPage(driver);
    private CommonFormsFunctions commonFormsFunctions = new CommonFormsFunctions(driver);
    private Asserts asserts= new Asserts(driver);
    private WaitFunctions waitFunctions = new WaitFunctions(driver);

    //------------------------------ Background ----------------------------------
    @When("el usuario selecciona la opción Form UI en el menú lateral")
    public void el_usuario_selecciona_la_opción_form_ui_en_el_menú_lateral() {
        formUIPage.clickMenuReusableComp();
        formUIPage.clickLiFormUI();
        waitFunctions.waitForMainPageToFinishLoading();
    }
    //------------------------------ End Background -------------------------------


    //------------------------------ Scenario: TCR-57 Crear un Form UI -----------------------------------
    @Given("el usuario hace clic en el botón de agregar un Form UI")
    public void el_usuario_hace_clic_en_el_botón_de_agregar_un_form_ui() {
        commonFormsFunctions.clickBtnAdd();
    }
    @When("llena el formulario del Form UI con los siguientes valores:")
    public void llena_el_formulario_del_form_ui_con_los_siguientes_valores(Map<String, String> formUIFields) {
        String name = formUIFields.get("name");
        String displayName = formUIFields.get("displayName");
        String description = formUIFields.get("description");
        String comments = formUIFields.get("comments");
        String attachments = formUIFields.get("attachments");

        commonFormsFunctions.fillGeneralForm(name,displayName,description);
        formUIPage.fillFormUIDataForm(comments,attachments);
    }
    @Then("se muestra un mensaje confirmando que se ha creado el Form UI")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_creado_el_form_ui() {
        String textMessage = commonFormsFunctions.textMessageSection();
        commonFormsFunctions.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }

    //------------------------------ End Scenario: TCR-57 Crear un Form UI -------------------------------




    //------------------------------ Scenario: TCR-58 Editar un Form UI -----------------------------------
    @Given("el usuario selecciona el Form UI {string} de la lista y hace clic en el botón de editar")
    public void el_usuario_selecciona_el_form_ui_de_la_lista_y_hace_clic_en_el_botón_de_editar(String formUI) {
        commonFormsFunctions.clickBtnMore();
        formUIPage.clickFormUISelect(formUI);

        commonFormsFunctions.clickBtnEdit();
    }
    @When("llena el formulario del Form UI con los siguientes valores actualizados:")
    public void llena_el_formulario_del_form_ui_con_los_siguientes_valores_actualizados(Map<String, String> formUIFields) {
        String name = formUIFields.get("name");
        String displayName = formUIFields.get("displayName");
        String description = formUIFields.get("description");

        commonFormsFunctions.clearName();
        commonFormsFunctions.clearDisplayName();
        commonFormsFunctions.clearDescription();
        commonFormsFunctions.fillGeneralForm(name,displayName,description);
    }
    @Then("se muestra un mensaje confirmando que se ha editado el Form UI")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_editado_el_form_ui() {
        String textMessage = commonFormsFunctions.textMessageSection();
        commonFormsFunctions.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }

    //------------------------------ End Scenario: TCR-58 Editar un Form UI -------------------------------


     //------------------------------ Scenario: TCR-59 Eliminar un Form UI ----------------------------------
     @When("el usuario hace clic en el botón de eliminar del Form UI {string}")
     public void el_usuario_hace_clic_en_el_botón_de_eliminar_del_form_ui(String formUI) {
         commonFormsFunctions.clickBtnMore();
         commonFormsFunctions.clickBtnDeleteItem(formUI);
     }
    @Then("se muestra un mensaje confirmando la eliminación del Form UI")
    public void se_muestra_un_mensaje_confirmando_la_eliminación_del_form_ui() {
        commonFormsFunctions.confirmDeleteObject();

        commonFormsFunctions.confirmSuccessOperation();
        String textMessage = commonFormsFunctions.textMessageDialog();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-59 Eliminar un Form UI -------------------------------
}
