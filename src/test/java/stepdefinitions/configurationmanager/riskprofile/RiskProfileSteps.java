package stepdefinitions.configurationmanager.riskprofile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.apps.configurationmanager.riskprofile.RiskProfilePage;
import stepdefinitions.TestConfig;
import utilities.Asserts;
import utilities.CommonFormsFunctions;
import utilities.WaitFunctions;

import java.util.Map;

public class RiskProfileSteps {

    private WebDriver driver = TestConfig.getDriver();
    private RiskProfilePage riskProfilePage = new RiskProfilePage(driver);
    private CommonFormsFunctions commonFormsFunctions = new CommonFormsFunctions(driver);
    private Asserts asserts= new Asserts(driver);
    private WaitFunctions waitFunctions = new WaitFunctions(driver);

    //------------------------------ Background ----------------------------------
    @When("el usuario selecciona la opción Risk Profile en el menú lateral")
    public void el_usuario_selecciona_la_opción_risk_profile_en_el_menú_lateral() {
        riskProfilePage.clickMenuReusableComp();
        riskProfilePage.clickLiRiskProfile();
        waitFunctions.waitForMainPageToFinishLoading();
    }
    //------------------------------ End Background -------------------------------

    //------------------------------ Scenario: TCR-66 Crear un Risk Profile -------------------------------
    @Given("el usuario hace clic en el botón de agregar un Risk Profile")
    public void el_usuario_hace_clic_en_el_botón_de_agregar_un_risk_profile() {
        commonFormsFunctions.clickBtnAdd();
    }
    @When("llena el formulario del Risk Profile con los siguientes valores:")
    public void llena_el_formulario_del_risk_profile_con_los_siguientes_valores(Map<String, String> riskProfileFields) {
        String name = riskProfileFields.get("name");
        String displayName = riskProfileFields.get("displayName");
        String description = riskProfileFields.get("description");
        String riskType = riskProfileFields.get("riskType");
        String numberHours = riskProfileFields.get("numberHours");
        String numberMinutes = riskProfileFields.get("numberMinutes");


        commonFormsFunctions.fillGeneralForm(name,displayName,description);
        riskProfilePage.fillRiskProfileDataForm(riskType,numberHours,numberMinutes);
    }
    @Then("se muestra un mensaje confirmando que se ha creado el Risk Profile")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_creado_el_risk_profile() {
        String textMessage = commonFormsFunctions.textMessageSection();
        commonFormsFunctions.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ Scenario: TCR-66 Crear un Risk Profile -------------------------------


    //------------------------------ Scenario: TCR-67 Editar un Risk Profile -------------------------------
    @Given("el usuario selecciona el Risk Profile {string} de la lista y hace clic en el botón de editar")
    public void el_usuario_selecciona_el_risk_profile_de_la_lista_y_hace_clic_en_el_botón_de_editar(String risk) {
        commonFormsFunctions.clickBtnMore();
        riskProfilePage.clickRiskProfileSelect(risk);

        commonFormsFunctions.clickBtnEdit();
    }
    @When("llena el formulario del Risk Profile con los siguientes valores actualizados:")
    public void llena_el_formulario_del_risk_profile_con_los_siguientes_valores_actualizados(Map<String, String> riskProfileFields) {
        String name = riskProfileFields.get("name");
        String displayName = riskProfileFields.get("displayName");
        String description = riskProfileFields.get("description");

        commonFormsFunctions.clearName();
        commonFormsFunctions.clearDisplayName();
        commonFormsFunctions.clearDescription();
        commonFormsFunctions.fillGeneralForm(name,displayName,description);
    }
    @Then("se muestra un mensaje confirmando que se ha editado el Risk Profile")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_editado_el_risk_profile() {
        String textMessage = commonFormsFunctions.textMessageSection();
        commonFormsFunctions.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ Scenario: TCR-67 Editar un Risk Profile -------------------------------


    //------------------------------ Scenario: TCR-68 Eliminar un Risk Profile -------------------------------
    @When("el usuario hace clic en el botón de eliminar del Risk Profile {string}")
    public void el_usuario_hace_clic_en_el_botón_de_eliminar_del_risk_profile(String risk) {
        commonFormsFunctions.clickBtnMore();
        commonFormsFunctions.clickBtnDeleteItem(risk);
    }
    @Then("se muestra un mensaje confirmando la eliminación del Risk Profile")
    public void se_muestra_un_mensaje_confirmando_la_eliminación_del_risk_profile() {
        commonFormsFunctions.confirmDeleteObject();

        commonFormsFunctions.confirmSuccessOperation();
        String textMessage = commonFormsFunctions.textMessageDialog();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ Scenario: TCR-68 Eliminar un Risk Profile -------------------------------
}
