package stepdefinitions.securitymanager.user;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.apps.securitymanager.user.UserPage;
import stepdefinitions.TestConfig;
import utilities.Asserts;
import utilities.CommonFormsFunctions;
import utilities.WaitFunctions;

import java.text.ParseException;
import java.util.Map;

public class UserSteps {

    private WebDriver driver = TestConfig.getDriver();
    private UserPage userPage = new UserPage(driver);
    private CommonFormsFunctions commonFormsPage = new CommonFormsFunctions(driver);
    private Asserts asserts = new Asserts(driver);
    private WaitFunctions waitFunctions = new WaitFunctions(driver);

    //------------------------------ Background ----------------------------------
    @When("el usuario selecciona la opción User en el menú lateral")
    public void el_usuario_selecciona_la_opción_user_en_el_menú_lateral(){
        userPage.clickMenuUserAndRole();
        userPage.clickLiUser();
        waitFunctions.waitForMainPageToFinishLoading();
    }
    //------------------------------ End Background -------------------------------

    //------------------------------ Scenario: TCR-45 Crear un User ------------------------------
    @Given("el usuario hace click en el botón de Agregar un user")
    public void el_usuario_hace_click_en_el_botón_de_agregar_un_user() {
        commonFormsPage.clickBtnAdd();
    }
    @When("llena el formulario del user con los siguientes valores:")
    public void llena_el_formulario_del_user_group_con_los_siguientes_valores(Map<String, String> userFields) throws ParseException {
        String userName = userFields.get("userName");
        String password = userFields.get("password");
        String email = userFields.get("email");
        String startDate = userFields.get("startDate");
        String endDate = userFields.get("endDate");
        String name = userFields.get("name");
        String lastName = userFields.get("lastName");
        String company = userFields.get("company");
        String orgUnit = userFields.get("orgUnit");
        String position = userFields.get("position");
        String licenseCategory = userFields.get("licenseCategory");

        userPage.fillUserDataForm(userName,password,email,startDate,endDate,name,lastName,company,orgUnit,position,licenseCategory);
    }
    @Then("se muestra un mensaje confirmando que se ha creado el usuario")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_creado_el_user_group() {
        userPage.clickBtnNoSendEmail();
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-45 Crear un User ---------------------------



    //------------------------------ Scenario: TCR-46 Editar un User -------------------------------
    @Given("el usuario selecciona el user {string} de la lista de usuarios y hace click en el botón de editar")
    public void el_usuario_selecciona_el_user_de_la_lista_de_usuarios_y_hace_click_en_el_botón_de_editar(String user) {
        commonFormsPage.clickBtnMore();
        userPage.clickUserSelect(user);

        commonFormsPage.clickBtnEdit();
    }
    @When("llena el formulario del user con los siguientes valores actualizados:")
    public void llena_el_formulario_del_user_con_los_siguientes_valores_actualizados(Map<String, String> userFields) {
        String name = userFields.get("name");
        String lastName = userFields.get("lastName");

        userPage.clearName();
        userPage.clearLastName();

        userPage.enterName(name);
        userPage.enterLastName(lastName);
    }
    @Then("se muestra un mensaje confirmando que se ha editado el usuario")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_editado_el_usuario() {
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-46 Editar un User ---------------------------

    //------------------------------ Scenario: TCR-47 Eliminar un User -------------------------------
    @When("el usuario hace clic en el botón de eliminar del user {string}")
    public void el_usuario_hace_clic_en_el_botón_de_eliminar_del_user(String user) {
        commonFormsPage.clickBtnMore();
        commonFormsPage.clickBtnDeleteItem(user);
    }
    @Then("se muestra un mensaje confirmando la eliminación del user")
    public void se_muestra_un_mensaje_confirmando_la_eliminación_del_user() {
        commonFormsPage.confirmDeleteObject();

        commonFormsPage.confirmSuccessOperation();
        String textMessage = commonFormsPage.textMessageDialog();
        asserts.assertSuccessOperation(textMessage);
    }

    //------------------------------ End Scenario: TCR-47 Eliminar un User ---------------------------
}
