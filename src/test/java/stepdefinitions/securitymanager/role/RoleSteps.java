package stepdefinitions.securitymanager.role;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.apps.securitymanager.role.RolePage;
import stepdefinitions.TestConfig;
import utilities.Asserts;
import utilities.CommonFormsFunctions;
import utilities.WaitFunctions;

import java.util.Map;

public class RoleSteps {

    private WebDriver driver = TestConfig.getDriver();
    private RolePage rolePage = new RolePage(driver);
    private CommonFormsFunctions commonFormsPage = new CommonFormsFunctions(driver);
    private Asserts asserts = new Asserts(driver);
    private WaitFunctions waitFunctions = new WaitFunctions(driver);

    //------------------------------ Background ----------------------------------
    @When("el usuario selecciona la opción Role en el menú lateral")
    public void el_usuario_selecciona_la_opción_role_en_el_menú_lateral(){
        rolePage.clickMenuUserAndRole();
        rolePage.clickLiRole();
        waitFunctions.waitForMainPageToFinishLoading();
    }
    //------------------------------ End Background -------------------------------


    //------------------------------ Scenario: TCR-39 Crear un Role ------------------------------
    @Given("el usuario hace clic en el botón de Agregar un rol")
    public void el_usuario_hace_clic_en_el_botón_de_agregar_un_rol() {
        commonFormsPage.clickBtnAdd();
    }
    @When("llena el formulario del rol con los siguientes valores:")
    public void llena_el_formulario_del_rol_con_los_siguientes_valores(Map<String, String> roleFields) {
        String nameRole = roleFields.get("name");
        String displayNameRole = roleFields.get("displayName");
        String descriptionRole = roleFields.get("description");
        String useAttributesRole = roleFields.get("useAttributes");
        String isCompositeRole = roleFields.get("isComposite");

        commonFormsPage.fillGeneralForm(nameRole,displayNameRole,descriptionRole);
        rolePage.fillRoleDataForm(useAttributesRole,isCompositeRole);
    }
    @Then("se muestra un mensaje confirmando que se ha creado el rol")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_creado_el_rol() {
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-39 Crear un Role ---------------------------



    //------------------------------ Scenario: TCR-40 Editar un Role ------------------------------
    @Given("el usuario selecciona el role {string} de la lista de roles y hace clic en el botón de editar")
    public void el_usuario_selecciona_el_role_de_la_lista_de_roles_y_hace_clic_en_el_botón_de_editar(String rol) {
        commonFormsPage.clickBtnMore();
        rolePage.clickRoleSelect(rol);

        commonFormsPage.clickBtnEdit();
    }
    @When("llena el formulario del role con los siguientes valores:")
    public void llena_el_formulario_del_role_con_los_siguientes_valores(Map<String, String> roleFields) {
        String nameRole = roleFields.get("name");
        String displayNameRole = roleFields.get("displayName");
        String descriptionRole = roleFields.get("description");

        commonFormsPage.clearName();
        commonFormsPage.clearDisplayName();
        commonFormsPage.clearDescription();
        commonFormsPage.fillGeneralForm(nameRole,displayNameRole,descriptionRole);
    }
    @Then("se muestra un mensaje confirmando que se ha editado el role")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_editado_el_role() {
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-40 Editar un Role ---------------------------

    //------------------------------ Scenario: TCR-41 Eliminar un Role ------------------------------
    @When("el usuario hace clic en el botón de eliminar del role {string}")
    public void el_usuario_hace_clic_en_el_botón_de_eliminar_del_role(String rol) {
        commonFormsPage.clickBtnMore();
        commonFormsPage.clickBtnDeleteItem(rol);
    }
    @Then("se muestra un mensaje confirmando la eliminación del role")
    public void se_muestra_un_mensaje_confirmando_la_eliminación_del_role() {
        commonFormsPage.confirmDeleteObject();

        commonFormsPage.confirmSuccessOperation();
        String textMessage = commonFormsPage.textMessageDialog();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-41 Eliminar un Role ---------------------------
}
