package stepdefinitions.configurationmanager.notificationprofile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.apps.configurationmanager.counter.CounterPage;
import pages.apps.configurationmanager.notificationprofile.NotificationProfilePage;
import stepdefinitions.TestConfig;
import utilities.Asserts;
import utilities.CommonFormsFunctions;
import utilities.WaitFunctions;

import java.util.Map;

public class NotificationProfileSteps {

    private WebDriver driver = TestConfig.getDriver();
    private NotificationProfilePage notificationProfilePage = new NotificationProfilePage(driver);
    private CommonFormsFunctions commonFormsFunctions = new CommonFormsFunctions(driver);
    private Asserts asserts= new Asserts(driver);
    private WaitFunctions waitFunctions = new WaitFunctions(driver);

    //------------------------------ Background ----------------------------------
    @When("el usuario selecciona la opción Notification Profile en el menú lateral")
    public void el_usuario_selecciona_la_opción_notification_profile_en_el_menú_lateral() {
        notificationProfilePage.clickMenuReusableComp();
        notificationProfilePage.clickLiNP();
        waitFunctions.waitForMainPageToFinishLoading();
    }
    //------------------------------ End Background -------------------------------

    //------------------------------ Scenario: TCR-63 Crear un Notification Profile -----------------------------------
    @Given("el usuario hace clic en el botón de agregar un Notification Profile")
    public void el_usuario_hace_clic_en_el_botón_de_agregar_un_notification_profile() {
        commonFormsFunctions.clickBtnAdd();
    }
    @When("llena el formulario del Notification Profile con los siguientes valores:")
    public void llena_el_formulario_del_notification_profile_con_los_siguientes_valores(Map<String, String> notificationFields) {
        String name = notificationFields.get("name");
        String displayName = notificationFields.get("displayName");
        String description = notificationFields.get("description");

        commonFormsFunctions.fillGeneralForm(name,displayName,description);
        notificationProfilePage.selectEventType();
    }
    @Then("se muestra un mensaje confirmando que se ha creado el Notification Profile")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_creado_el_notification_profile() {
        String textMessage = commonFormsFunctions.textMessageSection();
        commonFormsFunctions.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-63 Crear un Notification Profile --------------------------------


    //------------------------------ Scenario: TCR-64 Editar un Notification Profile ----------------------------------
    @Given("el usuario selecciona el Notification Profile {string} de la lista y hace clic en el botón de editar")
    public void el_usuario_selecciona_el_notification_profile_de_la_lista_y_hace_clic_en_el_botón_de_editar(String notificationProfile) {
        commonFormsFunctions.clickBtnMore();
        notificationProfilePage.clickNotificationSelect(notificationProfile);

        commonFormsFunctions.clickBtnEdit();
    }
    @When("llena el formulario del Notification Profile con los siguientes valores actualizados:")
    public void llena_el_formulario_del_notification_profile_con_los_siguientes_valores_actualizados(Map<String, String> notificationFields) {
        String name = notificationFields.get("name");
        String displayName = notificationFields.get("displayName");
        String description = notificationFields.get("description");

        commonFormsFunctions.clearName();
        commonFormsFunctions.clearDisplayName();
        commonFormsFunctions.clearDescription();
        commonFormsFunctions.fillGeneralForm(name,displayName,description);
    }
    @Then("se muestra un mensaje confirmando que se ha editado el Notification Profile")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_editado_el_notification_profile() {
        String textMessage = commonFormsFunctions.textMessageSection();
        commonFormsFunctions.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ Scenario: TCR-64 Editar un Notification Profile ----------------------------------


    //------------------------------ Scenario: TCR-65 Eliminar un Notification Profile ----------------------------------
    @When("el usuario hace clic en el botón de eliminar del Notification Profile {string}")
    public void el_usuario_hace_clic_en_el_botón_de_eliminar_del_notification_profile(String notificationProfile) {
        commonFormsFunctions.clickBtnMore();
        commonFormsFunctions.clickBtnDeleteItem(notificationProfile);
    }
    @Then("se muestra un mensaje confirmando la eliminación del Notification Profile")
    public void se_muestra_un_mensaje_confirmando_la_eliminación_del_notification_profile() {
        commonFormsFunctions.confirmDeleteObject();

        commonFormsFunctions.confirmSuccessOperation();
        String textMessage = commonFormsFunctions.textMessageDialog();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ Scenario: TCR-65 Eliminar un Notification Profile ----------------------------------


}
