package stepdefinitions.osm.company;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.apps.osm.company.CompanyPage;
import stepdefinitions.TestConfig;
import utilities.Asserts;
import utilities.CommonFormsFunctions;
import utilities.WaitFunctions;

import java.util.Map;

public class CompanySteps {

    private WebDriver driver = TestConfig.getDriver();
    private CompanyPage companyPage = new CompanyPage(driver);
    private CommonFormsFunctions commonFormsPage = new CommonFormsFunctions(driver);
    private Asserts asserts = new Asserts(driver);
    private WaitFunctions waitFunctions = new WaitFunctions(driver);

    //------------------------------ Scenario: TCR-25 Crear un Company -------------------------------
    @Given("el usuario hace click en la opción New Company")
    public void el_usuario_hace_click_en_la_opción_new_company() {
        companyPage.clickArrowMainClients();
        companyPage.rightClickNodeCompany();

        companyPage.clickNewCompany();
    }
    @When("llena el formulario del company con los siguientes valores:")
    public void llena_el_formulario_del_company_con_los_siguientes_valores(Map<String, String> companyFields) {
        String nameCompany = companyFields.get("name");
        String displayNameCompany = companyFields.get("displayName");
        String descriptionCompany = companyFields.get("description");
        String taxNumberCompany = companyFields.get("taxNumber");

        commonFormsPage.fillGeneralForm(nameCompany,displayNameCompany,descriptionCompany);
        companyPage.fillCompanyForm(taxNumberCompany);
    }
    @Then("se muestra un mensaje confirmando que se ha creado el company")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_creado_el_company() {
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-25 Crear un Company ---------------------------


    //------------------------------ Scenario: TCR-26 Editar un Company -------------------------------
    @Given("el usuario selecciona el company {string}")
    public void el_usuario_selecciona_el_company(String company) {
        companyPage.clickArrowMainClients();
        companyPage.clickArrowNodeCompany();

        companyPage.clickCompanySelect(company);
    }
    @When("hace clic en el botón de editar para el company seleccionado")
    public void hace_clic_en_el_botón_de_editar_para_el_company_seleccionado() {
        commonFormsPage.clickBtnEdit();
    }
    @When("realiza la edición del formulario del company con los siguientes valores actualizados:")
    public void realiza_la_edición_del_formulario_del_company_con_los_siguientes_valores_actualizados(Map<String, String> companyFields) {
        String nameCompany = companyFields.get("name");
        String displayNameCompany = companyFields.get("displayName");
        String descriptionCompany = companyFields.get("description");

        commonFormsPage.clearName();
        commonFormsPage.clearDisplayName();
        commonFormsPage.clearDescription();
        commonFormsPage.fillGeneralForm(nameCompany,displayNameCompany,descriptionCompany);
    }
    @Then("se muestra un mensaje confirmando que se ha editado el company")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_editado_el_company() {
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-26 Editar un Company ---------------------------

    //------------------------------ Scenario: TCR-27 Ver dependencias de un Company -------------------------------
    @When("el usuario hace click en el botón de ver dependencias del company")
    public void el_usuario_hace_click_en_el_botón_de_ver_dependencias_del_company() {
        commonFormsPage.clickBtnViewDependencies();
    }
    @Then("se muestra la tabla con la lista de dependencias del company")
    public void se_muestra_la_tabla_con_la_lista_de_dependencias_del_company() {
        String titleDependencies = commonFormsPage.getTitleListDependencies();
        asserts.assertTableDependencies(titleDependencies);
    }
    //------------------------------ End Scenario: TCR-27 Ver dependencias de un Company ---------------------------

    //------------------------------ Scenario: TCR-28 Eliminar un Company -----------------------------------------
    @Given("el usuario hace click derecho en el company {string}")
    public void el_usuario_hace_click_derecho_en_el_company(String company) {
        companyPage.clickArrowMainClients();
        companyPage.clickArrowNodeCompany();

        companyPage.rightClickCompanySelect(company);
    }
    @When("el usuario hace click en la opción Delete Company")
    public void el_usuario_hace_click_en_la_opción_delete_company() {
        companyPage.clickDeleteCompany();
    }
    @Then("se muestra un mensaje confirmando que se ha eliminado el company")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_eliminado_el_company() {
        commonFormsPage.confirmDeleteObject();

        commonFormsPage.confirmSuccessOperation();
        String textMessage = commonFormsPage.textMessageDialog();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-28 Eliminar un Company -------------------------------------
}
