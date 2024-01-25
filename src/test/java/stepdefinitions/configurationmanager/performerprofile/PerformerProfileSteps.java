package stepdefinitions.configurationmanager.performerprofile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.apps.configurationmanager.notificationprofile.NotificationProfilePage;
import pages.apps.configurationmanager.performerprofile.PerformerProfilePage;
import stepdefinitions.TestConfig;
import utilities.Asserts;
import utilities.CommonFormsFunctions;
import utilities.WaitFunctions;

import java.util.Map;

public class PerformerProfileSteps {

    private WebDriver driver = TestConfig.getDriver();
    private PerformerProfilePage performerProfilePage = new PerformerProfilePage(driver);
    private CommonFormsFunctions commonFormsFunctions = new CommonFormsFunctions(driver);
    private Asserts asserts= new Asserts(driver);
    private WaitFunctions waitFunctions = new WaitFunctions(driver);

    //------------------------------ Background ----------------------------------
    @When("el usuario selecciona la opción Performer Profile en el menú lateral")
    public void el_usuario_selecciona_la_opción_performer_profile_en_el_menú_lateral() {
        performerProfilePage.clickMenuReusableComp();
        performerProfilePage.clickLiPerformerProfile();
        waitFunctions.waitForMainPageToFinishLoading();
    }
    //------------------------------ End Background -------------------------------

    //------------------------------ Scenario: TCR-60 Crear un Performer Profile -----------------------------------
    @Given("el usuario hace clic en el botón de agregar un Performer Profile")
    public void el_usuario_hace_clic_en_el_botón_de_agregar_un_performer_profile() {
        commonFormsFunctions.clickBtnAdd();
    }
    @When("llena el formulario del Performer Profile con los siguientes valores:")
    public void llena_el_formulario_del_performer_profile_con_los_siguientes_valores(Map<String, String> performerFields) {
        String name = performerFields.get("name");
        String displayName = performerFields.get("displayName");
        String description = performerFields.get("description");
        String assignCurrentUser = performerFields.get("assignCurrentUser");
        String reusePerformer = performerFields.get("reusePerformer");
        String assignmentMethod = performerFields.get("assignmentMethod");

        commonFormsFunctions.fillGeneralForm(name,displayName,description);
        performerProfilePage.fillPerformerDataForm(assignCurrentUser,reusePerformer,assignmentMethod);
    }
    @Then("se muestra un mensaje confirmando que se ha creado el Performer Profile")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_creado_el_performer_profile() {
        String textMessage = commonFormsFunctions.textMessageSection();
        commonFormsFunctions.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ END  Scenario: TCR-60 Crear un Performer Profile ------------------------------

    //------------------------------ Scenario: TCR-61 Editar un Performer Profile -----------------------------------
    @Given("el usuario selecciona el Performer Profile {string} de la lista y hace clic en el botón de editar")
    public void el_usuario_selecciona_el_performer_profile_de_la_lista_y_hace_clic_en_el_botón_de_editar(String performer) {
        commonFormsFunctions.clickBtnMore();
        performerProfilePage.clickPerformerProfileSelect(performer);

        commonFormsFunctions.clickBtnEdit();
    }
    @When("llena el formulario del Performer Profile con los siguientes valores actualizados:")
    public void llena_el_formulario_del_performer_profile_con_los_siguientes_valores_actualizados(Map<String, String> performerFields) {
        String name = performerFields.get("name");
        String displayName = performerFields.get("displayName");
        String description = performerFields.get("description");

        commonFormsFunctions.clearName();
        commonFormsFunctions.clearDisplayName();
        commonFormsFunctions.clearDescription();
        commonFormsFunctions.fillGeneralForm(name,displayName,description);
    }
    @Then("se muestra un mensaje confirmando que se ha editado el Performer Profile")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_editado_el_performer_profile() {
        String textMessage = commonFormsFunctions.textMessageSection();
        commonFormsFunctions.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-61 Editar un Performer Profile ------------------------------


    //------------------------------ Scenario: TCR-62 Eliminar un Performer Profile ----------------------------------
    @When("el usuario hace clic en el botón de eliminar del Performer Profile {string}")
    public void el_usuario_hace_clic_en_el_botón_de_eliminar_del_performer_profile(String performer) {
        commonFormsFunctions.clickBtnMore();
        commonFormsFunctions.clickBtnDeleteItem(performer);
    }
    @Then("se muestra un mensaje confirmando la eliminación del Performer Profile")
    public void se_muestra_un_mensaje_confirmando_la_eliminación_del_performer_profile() {
        commonFormsFunctions.confirmDeleteObject();

        commonFormsFunctions.confirmSuccessOperation();
        String textMessage = commonFormsFunctions.textMessageDialog();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-62 Eliminar un Performer Profile ------------------------------

}
