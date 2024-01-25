package stepdefinitions.securitymanager.usergroup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.apps.securitymanager.usergroup.UserGroupPage;
import stepdefinitions.TestConfig;
import utilities.Asserts;
import utilities.CommonFormsFunctions;
import utilities.WaitFunctions;

import java.util.Map;

public class UserGroupSteps {

    private WebDriver driver = TestConfig.getDriver();
    private UserGroupPage userGroupPage = new UserGroupPage(driver);
    private CommonFormsFunctions commonFormsFunctions = new CommonFormsFunctions(driver);
    private Asserts asserts= new Asserts(driver);
    private WaitFunctions waitFunctions = new WaitFunctions(driver);


    //------------------------------ Background ----------------------------------
    @When("el usuario selecciona la opción User Group en el menú lateral")
    public void el_usuario_selecciona_la_opción_user_group_en_el_menú_lateral(){
        userGroupPage.clickMenuUserAndRole();
        userGroupPage.clickLiUserGroup();
    }
    //------------------------------ End Background -------------------------------

    //------------------------------ Scenario: TCR-42 Crear un User Group -------------------------------
    @Given("el usuario hace click en el botón de Agregar un user group")
    public void el_usuario_hace_click_en_el_botón_de_agregar_un_user_group() {
        commonFormsFunctions.clickBtnAdd();
    }
    @When("llena el formulario del user group con los siguientes valores:")
    public void llena_el_formulario_del_user_group_con_los_siguientes_valores(Map<String, String> userGroupFields) {
        String name = userGroupFields.get("name");
        String displayName = userGroupFields.get("displayName");
        String description = userGroupFields.get("description");

        commonFormsFunctions.fillGeneralForm(name,displayName,description);
    }
    @Then("se muestra un mensaje confirmando que se ha creado el User Group")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_creado_el_user_group() {
        String textMessage = commonFormsFunctions.textMessageSection();
        commonFormsFunctions.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }

    //------------------------------ End Scenario: TCR-42 Crear un User Group ---------------------------


    //------------------------------ Scenario: TCR-43 Editar un User Group -------------------------------
    @Given("el usuario selecciona el User Group {string} de la lista de Grupo de Usuarios y hace click en el botón de editar")
    public void el_usuario_selecciona_el_user_group_de_la_lista_de_grupo_de_usuarios_y_hace_click_en_el_botón_de_editar(String userGroup) {
        commonFormsFunctions.clickBtnMore();
        userGroupPage.clickUserSelect(userGroup);

        commonFormsFunctions.clickBtnEdit();
    }
    @When("llena el formulario del user group con los siguientes valores actualizados:")
    public void llena_el_formulario_del_user_group_con_los_siguientes_valores_actualizados(Map<String,String> userGroupFields) {
        String name = userGroupFields.get("name");
        String displayName = userGroupFields.get("displayName");
        String description = userGroupFields.get("description");

        commonFormsFunctions.clearName();
        commonFormsFunctions.clearDisplayName();
        commonFormsFunctions.clearDescription();
        commonFormsFunctions.fillGeneralForm(name,displayName,description);
    }
    @Then("se muestra un mensaje confirmando que se ha editado el User Group")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_editado_el_user_group() {
        String textMessage = commonFormsFunctions.textMessageSection();
        commonFormsFunctions.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-43 Editar un User Group ---------------------------


    //------------------------------ Scenario: TCR-44 Eliminar un User Group -------------------------------
    @When("el usuario hace clic en el botón de eliminar del user group {string}")
    public void el_usuario_hace_clic_en_el_botón_de_eliminar_del_usergroup(String userGroup) {
        commonFormsFunctions.clickBtnMore();
        commonFormsFunctions.clickBtnDeleteItem(userGroup);
    }
    @Then("se muestra un mensaje confirmando la eliminación del user group")
    public void se_muestra_un_mensaje_confirmando_la_eliminación_del_user() {
        commonFormsFunctions.confirmDeleteObject();

        commonFormsFunctions.confirmSuccessOperation();
        String textMessage = commonFormsFunctions.textMessageDialog();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-44 Eliminar un User Group ---------------------------
}
