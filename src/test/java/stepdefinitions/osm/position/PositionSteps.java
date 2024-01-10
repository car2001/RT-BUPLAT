package stepdefinitions.osm.position;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.apps.osm.company.CompanyPage;
import pages.apps.osm.organizationalunit.OrganizationalUnitPage;
import pages.apps.osm.position.PositionPage;
import stepdefinitions.TestConfig;
import utilities.Asserts;
import utilities.CommonFormsFunctions;
import utilities.WaitFunctions;

import java.util.Map;

public class PositionSteps {

    private WebDriver driver = TestConfig.getDriver();
    private CompanyPage companyPage = new CompanyPage(driver);
    private OrganizationalUnitPage organizationalUnitPage = new OrganizationalUnitPage(driver);
    private PositionPage positionPage= new PositionPage(driver);
    private CommonFormsFunctions commonFormsPage = new CommonFormsFunctions(driver);
    private Asserts asserts = new Asserts(driver);
    private WaitFunctions waitFunctions = new WaitFunctions(driver);


    //------------------------------ Scenario: TCR-33 Crear un position -------------------------------
    @Given("se tiene el company {string} y el organizational unit {string}")
    public void se_tiene_el_company_y_el_organizational_unit(String company, String organizationalUnit) {
        companyPage.clickArrowMainClients();
        companyPage.clickArrowNodeCompany();

        companyPage.clickArrowCompanySelect(company);

        organizationalUnitPage.clickArrowNodeOrganizationalUnit();
        organizationalUnitPage.clickArrowOrganizationalUnitSelect(organizationalUnit);
    }
    @And("el usuario hace clic en la opción de New Position")
    public void el_usuario_hace_clic_en_la_opción_de_new_position() {
        positionPage.rightClickNodePositions();
        positionPage.clickNewPosition();
    }
    @When("llena el formulario del position con los siguientes valores:")
    public void llena_el_formulario_del_position_con_los_siguientes_valores(Map<String, String> positionFields) {
        String namePosition = positionFields.get("name");
        String displayNamePosition = positionFields.get("displayName");
        String descriptionPosition = positionFields.get("description");

        commonFormsPage.fillGeneralForm(namePosition,displayNamePosition,descriptionPosition);
    }
    @Then("se muestra un mensaje confirmando que se ha creado el position")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_creado_el_position() {
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-33 Crear un position ---------------------------


    //------------------------------ Scenario: TCR-34 Editar un position -------------------------------
    @When("el usuario hace clic en el botón de editar para el position {string} seleccionado")
    public void el_usuario_hace_clic_en_el_botón_de_editar_para_el_position_seleccionado(String position) {
        positionPage.clickArrowNodePositions();
        positionPage.clickPositionSelect(position);
        commonFormsPage.clickBtnEdit();
    }
    @And("realiza la edición del formulario del position con los siguientes valores:")
    public void realiza_la_edición_del_formulario_del_position_con_los_siguientes_valores(Map<String, String> positionFields ) {
        String namePosition = positionFields.get("name");
        String displayNamePosition = positionFields.get("displayName");
        String descriptionPosition = positionFields.get("description");

        commonFormsPage.clearName();
        commonFormsPage.clearDisplayName();
        commonFormsPage.clearDescription();
        commonFormsPage.fillGeneralForm(namePosition,displayNamePosition,descriptionPosition);

        commonFormsPage.clickBtnSave();
    }
    @Then("se muestra un mensaje confirmando la edición exitosa del position")
    public void se_muestra_un_mensaje_confirmando_la_edición_exitosa_del_position() {
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-34 Editar un position ---------------------------


    //------------------------------ TCR-35 Eliminar un position ---------------------------------------
    @When("el usuario hace clic derecho en el position {string}")
    public void el_usuario_hace_clic_derecho_en_el_position(String position) {
        positionPage.clickArrowNodePositions();
        positionPage.rightClickPositionSelect(position);
    }
    @And("hace clic en la opción Delete Position")
    public void hace_clic_en_la_opción_delete_position() {
        positionPage.clickDeletePosition();
    }
    @Then("se muestra un mensaje confirmando que se ha eliminado el Position")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_eliminado_el_position() {
        commonFormsPage.confirmDeleteObject();

        commonFormsPage.confirmSuccessOperation();
        String textMessage = commonFormsPage.textMessageDialog();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End TCR-35 Eliminar un position -----------------------------------


}
