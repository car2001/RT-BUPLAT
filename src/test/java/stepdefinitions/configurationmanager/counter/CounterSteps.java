package stepdefinitions.configurationmanager.counter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.apps.configurationmanager.counter.CounterPage;
import pages.apps.securitymanager.usergroup.UserGroupPage;
import stepdefinitions.TestConfig;
import utilities.Asserts;
import utilities.CommonFormsFunctions;
import utilities.WaitFunctions;

import java.util.Map;

public class CounterSteps {

    private WebDriver driver = TestConfig.getDriver();
    private CounterPage counterPage = new CounterPage(driver);
    private CommonFormsFunctions commonFormsFunctions = new CommonFormsFunctions(driver);
    private Asserts asserts= new Asserts(driver);
    private WaitFunctions waitFunctions = new WaitFunctions(driver);

    //------------------------------ Background ----------------------------------
    @When("el usuario selecciona la opción Counter en el menú lateral")
    public void el_usuario_selecciona_la_opción_counter_en_el_menú_lateral() {
        counterPage.clickMenuReusableComp();
        counterPage.clickLiCounter();
        waitFunctions.waitForMainPageToFinishLoading();
    }
    //------------------------------ End Background -------------------------------


    //------------------------------ Scenario: TCR-48 Crear un Counter -------------------------------
    @Given("el usuario hace clic en el botón de agregar un counter")
    public void el_usuario_hace_clic_en_el_botón_de_agregar_un_counter() {
        commonFormsFunctions.clickBtnAdd();
    }
    @When("llena el formulario del counter con los siguientes valores:")
    public void llena_el_formulario_del_counter_con_los_siguientes_valores(Map<String, String> counterFields) {
        String name = counterFields.get("name");
        String displayName = counterFields.get("displayName");
        String description = counterFields.get("description");
        String startAt = counterFields.get("startAt");
        String increment = counterFields.get("increment");

        commonFormsFunctions.fillGeneralForm(name,displayName,description);
        counterPage.fillCounterDataForm(startAt,increment);
    }
    @Then("se muestra un mensaje confirmando que se ha creado el counter")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_creado_el_counter() {
        String textMessage = commonFormsFunctions.textMessageSection();
        commonFormsFunctions.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-48 Crear un Counter  ---------------------------


    //------------------------------ Scenario: TCR-49 Editar un Counter -------------------------------
    @Given("el usuario selecciona el counter {string} de la lista de contadores y hace clic en el botón de editar")
    public void el_usuario_selecciona_el_counter_de_la_lista_de_contadores_y_hace_clic_en_el_botón_de_editar(String counter) {
        commonFormsFunctions.clickBtnMore();
        counterPage.clickCounterSelect(counter);

        commonFormsFunctions.clickBtnEdit();
    }
    @When("llena el formulario del counter con los siguientes valores actualizados:")
    public void llena_el_formulario_del_counter_con_los_siguientes_valores_actualizados(Map<String, String> counterFields) {
        String name = counterFields.get("name");
        String displayName = counterFields.get("displayName");
        String description = counterFields.get("description");

        commonFormsFunctions.clearName();
        commonFormsFunctions.clearDisplayName();
        commonFormsFunctions.clearDescription();
        commonFormsFunctions.fillGeneralForm(name,displayName,description);
    }
    @Then("se muestra un mensaje confirmando que se ha editado el counter")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_editado_el_counter() {
        String textMessage = commonFormsFunctions.textMessageSection();
        commonFormsFunctions.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-49 Editar un Counter -----------------------------


    //------------------------------ Scenario: TCR-50 Eliminar un counter --------------------------------
    @When("el usuario hace clic en el botón de eliminar del counter {string}")
    public void el_usuario_hace_clic_en_el_botón_de_eliminar_del_counter(String counter) {
        commonFormsFunctions.clickBtnMore();
        commonFormsFunctions.clickBtnDeleteItem(counter);
    }
    @Then("se muestra un mensaje confirmando la eliminación del counter")
    public void se_muestra_un_mensaje_confirmando_la_eliminación_del_counter() {
        commonFormsFunctions.confirmDeleteObject();

        commonFormsFunctions.confirmSuccessOperation();
        String textMessage = commonFormsFunctions.textMessageDialog();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-50 Eliminar un counter -----------------------------
}
