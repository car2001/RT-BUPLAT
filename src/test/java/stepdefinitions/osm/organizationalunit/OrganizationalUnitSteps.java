package stepdefinitions.osm.organizationalunit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.apps.osm.company.CompanyPage;
import pages.apps.osm.organizationalunit.OrganizationalUnitPage;
import stepdefinitions.TestConfig;
import utilities.Asserts;
import utilities.CommonFormsFunctions;
import utilities.WaitFunctions;

import java.util.Map;

public class OrganizationalUnitSteps {
    private WebDriver driver = TestConfig.getDriver();
    private CompanyPage companyPage = new CompanyPage(driver);
    private OrganizationalUnitPage organizationalUnitPage = new OrganizationalUnitPage(driver);
    private CommonFormsFunctions commonFormsPage = new CommonFormsFunctions(driver);
    private Asserts asserts = new Asserts(driver);
    private WaitFunctions waitFunctions = new WaitFunctions(driver);


    //------------------------------ Scenario: TCR-29 Crear un Organizational Unit -------------------------------
    @Given("se tiene el company {string} y hace clic en la opción de New Organizational Unit")
    public void se_tiene_el_company_y_hace_clic_en_la_opción_de_new_organizational_unit(String company) {
        companyPage.clickArrowMainClients();
        companyPage.clickArrowNodeCompany();

        companyPage.clickArrowCompanySelect(company);

        organizationalUnitPage.rightClickNodeOrganizationalUnit();
        organizationalUnitPage.clickNewOrganizationalUnit();
    }
    @When("llena el formulario de organizational unit con los siguientes valores:")
    public void llena_el_formulario_de_organizational_unit_con_los_siguientes_valores(Map<String, String> organizationalUnitFields) {
        String nameOrganizationalUnit = organizationalUnitFields.get("name");
        String displayOrganizationalUnit = organizationalUnitFields.get("displayName");
        String descriptionOrganizationalUnit = organizationalUnitFields.get("description");

        commonFormsPage.fillGeneralForm(nameOrganizationalUnit,displayOrganizationalUnit,descriptionOrganizationalUnit);
    }
    @Then("se muestra un mensaje confirmando que se ha creado el Organizational Unit")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_creado_el_organizational_unit() {
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }

    //------------------------------ End Scenario: TCR-29 Crear un Organizational Unit ---------------------------


    //------------------------------ Scenario: TCR-30 Editar un Organizational Unit -------------------------------
    @Given("se tiene el company {string} y el usuario selecciona el organizational unit {string}")
    public void se_tiene_el_company_y_el_usuario_selecciona_el_organizational_unit(String company, String organizationalUnit) {
        companyPage.clickArrowMainClients();
        companyPage.clickArrowNodeCompany();

        companyPage.clickArrowCompanySelect(company);


        organizationalUnitPage.clickArrowNodeOrganizationalUnit();
        organizationalUnitPage.clickOrganizationalUnitSelect(organizationalUnit);
    }
    @When("el usuario hace clic en el botón de editar para el organizational unit seleccionado")
    public void el_usuario_hace_clic_en_el_botón_de_editar_para_el_organizational_unit_seleccionado() {
        commonFormsPage.clickBtnEdit();
    }
    @When("realiza la edición del formulario del Organizational Unit con los siguientes valores:")
    public void realiza_la_edición_del_formulario_del_organizational_unit_con_los_siguientes_valores(Map<String, String> organizationalUnitFields) {
        String nameOrganizationalUnit = organizationalUnitFields.get("name");
        String displayOrganizationalUnit = organizationalUnitFields.get("displayName");
        String descriptionOrganizationalUnit = organizationalUnitFields.get("description");

        commonFormsPage.clearName();
        commonFormsPage.clearDisplayName();
        commonFormsPage.clearDescription();
        commonFormsPage.fillGeneralForm(nameOrganizationalUnit,displayOrganizationalUnit,descriptionOrganizationalUnit);
    }
    @Then("se muestra un mensaje confirmando que se ha editado el Organizational Unit")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_editado_el_organizational_unit() {
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }

    //------------------------------ End Scenario: TCR-30 Editar un Organizational Unit ---------------------------


    //------------------------------ Scenario: TCR-31 Ver dependencias de un Organizational Unit ------------------
    @When("el usuario hace click en el botón de ver dependencias del Organizational Unit")
    public void el_usuario_hace_click_en_el_botón_de_ver_dependencias_del_organizational_unit() {
        commonFormsPage.clickBtnViewDependencies();
    }
    @Then("se muestra la tabla con la lista de dependencias asociadas al Organizational Unit")
    public void se_muestra_la_tabla_con_la_lista_de_dependencias_asociadas_al_organizational_unit() {
        String titleDependencies = commonFormsPage.getTitleListDependencies();
        asserts.assertTableDependencies(titleDependencies);;
    }
    //------------------------------ End Scenario: TCR-31 Ver dependencias de un Organizational Unit --------------


    //------------------------------ Scenario: TCR-32 Eliminar un Organizational Unit -----------------------------
    @Given("se tiene el company {string} y el usuario hace click derecho en el organizational unit {string}")
    public void se_tiene_el_company_y_el_usuario_hace_click_derecho_en_el_organizational_unit(String company, String organizationalUnit) {
        companyPage.clickArrowMainClients();
        companyPage.clickArrowNodeCompany();

        companyPage.clickArrowCompanySelect(company);

        organizationalUnitPage.clickArrowNodeOrganizationalUnit();
        organizationalUnitPage.rightClickOrganizationalUnitSelect(organizationalUnit);
    }
    @When("el usuario hace click derecho en la opción Delete Organizational Unit")
    public void el_usuario_hace_click_derecho_en_la_opción_delete_organizational_unit() {
        organizationalUnitPage.clickDeleteOrganizationalUnit();
    }
    @Then("se muestra un mensaje confirmando que se ha eliminado el Organizational Unit")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_eliminado_el_organizational_unit() {
        commonFormsPage.confirmDeleteObject();

        commonFormsPage.confirmSuccessOperation();
        String textMessage = commonFormsPage.textMessageDialog();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-32 Eliminar un Organizational Unit -------------------------

}
