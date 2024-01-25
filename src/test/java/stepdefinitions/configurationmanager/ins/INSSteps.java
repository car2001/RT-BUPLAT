package stepdefinitions.configurationmanager.ins;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.apps.configurationmanager.counter.CounterPage;
import pages.apps.configurationmanager.ins.INSPage;
import stepdefinitions.TestConfig;
import utilities.Asserts;
import utilities.CommonFormsFunctions;
import utilities.WaitFunctions;

import java.util.Map;

public class INSSteps {

    private WebDriver driver = TestConfig.getDriver();
    private INSPage insPage = new INSPage(driver);
    private CommonFormsFunctions commonFormsFunctions = new CommonFormsFunctions(driver);
    private Asserts asserts= new Asserts(driver);
    private WaitFunctions waitFunctions = new WaitFunctions(driver);

    //------------------------------ Background ----------------------------------
    @When("el usuario selecciona la opción Instance Numbering Schema en el menú lateral")
    public void el_usuario_selecciona_la_opción_instance_numbering_schema_en_el_menú_lateral() {
        insPage.clickMenuReusableComp();
        insPage.clickLiINS();
        waitFunctions.waitForMainPageToFinishLoading();
    }
    //------------------------------ End Background -------------------------------


    //------------------------------ Scenario: TCR-51 Crear un Instance Numbering Schema -------------------------------
    @Given("el usuario hace clic en el botón de agregar un Instance Numbering Schema")
    public void el_usuario_hace_clic_en_el_botón_de_agregar_un_instance_numbering_schema() {
        commonFormsFunctions.clickBtnAdd();
    }
    @When("llena el formulario del Instance Numbering Schema con los siguientes valores:")
    public void llena_el_formulario_del_instance_numbering_schema_con_los_siguientes_valores(Map<String, String> insFields) {
        String name = insFields.get("name");
        String displayName = insFields.get("displayName");
        String description = insFields.get("description");
        String separator = insFields.get("separator");
        String value = insFields.get("value");

        commonFormsFunctions.fillGeneralForm(name,displayName,description);
        insPage.fillCounterDataForm(separator,value);
    }
    @Then("se muestra un mensaje confirmando que se ha creado el Instance Numbering Schema")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_creado_el_instance_numbering_schema() {
        String textMessage = commonFormsFunctions.textMessageSection();
        commonFormsFunctions.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-51 Crear un Instance Numbering Schema ---------------------------



    //------------------------------ Scenario: TCR-52 Editar un Instance Numbering Schema -------------------------------
    @Given("el usuario selecciona el Instance Numbering Schema {string} de la lista y hace clic en el botón de editar")
    public void el_usuario_selecciona_el_instance_numbering_schema_de_la_lista_y_hace_clic_en_el_botón_de_editar(String ins) {
        commonFormsFunctions.clickBtnMore();
        insPage.clickINSSelect(ins);

        commonFormsFunctions.clickBtnEdit();
    }
    @When("llena el formulario del Instance Numbering Schema con los siguientes valores actualizados:")
    public void llena_el_formulario_del_instance_numbering_schema_con_los_siguientes_valores_actualizados(Map<String, String> insFields) {
        String name = insFields.get("name");
        String displayName = insFields.get("displayName");
        String description = insFields.get("description");

        commonFormsFunctions.clearName();
        commonFormsFunctions.clearDisplayName();
        commonFormsFunctions.clearDescription();
        commonFormsFunctions.fillGeneralForm(name,displayName,description);
    }
    @Then("se muestra un mensaje confirmando que se ha editado el Instance Numbering Schema")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_editado_el_instance_numbering_schema() {
        String textMessage = commonFormsFunctions.textMessageSection();
        commonFormsFunctions.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-52 Editar un Instance Numbering Schema -----------------------------



    //------------------------------ Scenario: TCR-53 Eliminar un Instance Numbering Schema --------------------------------
    @When("el usuario hace clic en el botón de eliminar del Instance Numbering Schema {string}")
    public void el_usuario_hace_clic_en_el_botón_de_eliminar_del_instance_numbering_schema(String ins) {
        commonFormsFunctions.clickBtnMore();
        commonFormsFunctions.clickBtnDeleteItem(ins);
    }
    @Then("se muestra un mensaje confirmando la eliminación del Instance Numbering Schema")
    public void se_muestra_un_mensaje_confirmando_la_eliminación_del_instance_numbering_schema() {
        commonFormsFunctions.confirmDeleteObject();

        commonFormsFunctions.confirmSuccessOperation();
        String textMessage = commonFormsFunctions.textMessageDialog();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-53 Eliminar un Instance Numbering Schema -----------------------------
}
