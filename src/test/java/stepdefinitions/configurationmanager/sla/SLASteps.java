package stepdefinitions.configurationmanager.sla;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.apps.configurationmanager.sla.SLAPage;
import stepdefinitions.TestConfig;
import utilities.Asserts;
import utilities.CommonFormsFunctions;
import utilities.WaitFunctions;

import java.util.Map;

public class SLASteps {
    private WebDriver driver = TestConfig.getDriver();
    private SLAPage slaPage = new SLAPage(driver);
    private CommonFormsFunctions commonFormsFunctions = new CommonFormsFunctions(driver);
    private Asserts asserts= new Asserts(driver);
    private WaitFunctions waitFunctions = new WaitFunctions(driver);

    //------------------------------ Background ----------------------------------
    @When("el usuario selecciona la opción SLA en el menú lateral")
    public void el_usuario_selecciona_la_opción_sla_en_el_menú_lateral() {
        slaPage.clickMenuReusableComp();
        slaPage.clickLiSLA();
        waitFunctions.waitForMainPageToFinishLoading();
    }
    //------------------------------ End Background -------------------------------


    //------------------------------ Scenario: TCR-54 Crear un SLA -------------------------------
    @Given("el usuario hace clic en el botón de agregar un SLA")
    public void el_usuario_hace_clic_en_el_botón_de_agregar_un_sla() {
        commonFormsFunctions.clickBtnAdd();
    }
    @When("llena el formulario del SLA con los siguientes valores:")
    public void llena_el_formulario_del_sla_con_los_siguientes_valores(Map<String, String> slaFields) {
        String name = slaFields.get("name");
        String displayName = slaFields.get("displayName");
        String description = slaFields.get("description");
        String slaType = slaFields.get("slaType");

        commonFormsFunctions.fillGeneralForm(name,displayName,description);
        slaPage.fillSLADataForm(slaType);
    }
    @Then("se muestra un mensaje confirmando que se ha creado el SLA")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_creado_el_sla() {
        String textMessage = commonFormsFunctions.textMessageSection();
        commonFormsFunctions.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-54 Crear un SLA ---------------------------


    //------------------------------ Scenario: TCR-55 Editar un SLA -------------------------------
    @Given("el usuario selecciona el SLA {string} de la lista y hace clic en el botón de editar")
    public void el_usuario_selecciona_el_sla_de_la_lista_y_hace_clic_en_el_botón_de_editar(String sla) {
        commonFormsFunctions.clickBtnMore();
        slaPage.clickSLASelect(sla);

        commonFormsFunctions.clickBtnEdit();
    }
    @When("llena el formulario del SLA con los siguientes valores actualizados:")
    public void llena_el_formulario_del_sla_con_los_siguientes_valores_actualizados(Map<String, String> slaFields) {
        String name = slaFields.get("name");
        String displayName = slaFields.get("displayName");
        String description = slaFields.get("description");

        commonFormsFunctions.clearName();
        commonFormsFunctions.clearDisplayName();
        commonFormsFunctions.clearDescription();
        commonFormsFunctions.fillGeneralForm(name,displayName,description);
    }
    @Then("se muestra un mensaje confirmando que se ha editado el SLA")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_editado_el_sla() {
        String textMessage = commonFormsFunctions.textMessageSection();
        commonFormsFunctions.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-55 Editar un SLA -----------------------------


    //------------------------------ Scenario: TCR-56 Eliminar un SLA --------------------------------
    @When("el usuario hace clic en el botón de eliminar del SLA {string}")
    public void el_usuario_hace_clic_en_el_botón_de_eliminar_del_sla(String sla) {
        commonFormsFunctions.clickBtnMore();
        commonFormsFunctions.clickBtnDeleteItem(sla);
    }
    @Then("se muestra un mensaje confirmando la eliminación del SLA")
    public void se_muestra_un_mensaje_confirmando_la_eliminación_del_sla() {
        commonFormsFunctions.confirmDeleteObject();

        commonFormsFunctions.confirmSuccessOperation();
        String textMessage = commonFormsFunctions.textMessageDialog();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-56 Eliminar un SLA -----------------------------
}
