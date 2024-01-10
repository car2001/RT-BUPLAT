package stepdefinitions.osm.location;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.apps.osm.company.CompanyPage;
import pages.apps.osm.location.LocationPage;
import stepdefinitions.TestConfig;
import utilities.Asserts;
import utilities.CommonFormsFunctions;
import utilities.WaitFunctions;

import java.util.Map;

public class LocationSteps {

    private WebDriver driver = TestConfig.getDriver();
    private CompanyPage companyPage = new CompanyPage(driver);
    private LocationPage locationPage = new LocationPage(driver);
    private CommonFormsFunctions commonFormsPage = new CommonFormsFunctions(driver);
    private Asserts asserts = new Asserts(driver);
    private WaitFunctions waitFunctions = new WaitFunctions(driver);

    //------------------------------ Scenario: TCR-36 Crear un Location -------------------------------
    @Given("se tiene el company {string} y hace clic en la opción de New Location")
    public void el_usuario_hace_clic_en_la_opción_de_new_location(String company) {
        companyPage.clickArrowMainClients();
        companyPage.clickArrowNodeCompany();

        companyPage.clickArrowCompanySelect(company);

        locationPage.rightClickNodeLocations();
        locationPage.clickNewLocation();
    }
    @When("llena el formulario de location con los siguientes valores:")
    public void llena_el_formulario_de_location_con_los_siguientes_valores(Map<String, String> locationFields) {
        String nameLocation = locationFields.get("name");
        String displayNameLocation = locationFields.get("displayName");
        String descriptionLocation = locationFields.get("description");

        commonFormsPage.fillGeneralForm(nameLocation,displayNameLocation,descriptionLocation);
    }
    @Then("se muestra un mensaje confirmando que se ha creado el location")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_creado_el_location() {
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }

    //------------------------------ End Scenario: TCR-36 Crear un Location ---------------------------


    //------------------------------ Scenario: TCR-37 Editar un Location -------------------------------
    @Given("se tiene el company {string} y el usuario selecciona el location {string}")
    public void se_tiene_el_company_y_el_usuario_selecciona_el_location(String company, String location) {
        companyPage.clickArrowMainClients();
        companyPage.clickArrowNodeCompany();

        companyPage.clickArrowCompanySelect(company);

        locationPage.clickArrowNodeLocation();
        locationPage.clickLocationSelect(location);
    }
    @When("hace clic en el botón de editar para el location seleccionado")
    public void hace_clic_en_el_botón_de_editar_para_el_location_seleccionado() {
        commonFormsPage.clickBtnEdit();
    }
    @And("realiza la edición del formulario del location con los siguientes valores:")
    public void realiza_la_edición_del_formulario_del_location_con_los_siguientes_valores(Map<String, String> locationFields) {
        String nameLocation = locationFields.get("name");
        String displayNameLocation = locationFields.get("displayName");
        String descriptionLocation = locationFields.get("description");

        commonFormsPage.clearName();
        commonFormsPage.clearDisplayName();
        commonFormsPage.clearDescription();
        commonFormsPage.fillGeneralForm(nameLocation,displayNameLocation,descriptionLocation);
    }
    @Then("se muestra un mensaje confirmando que se ha editado el location")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_editado_el_location() {
        String textMessage = commonFormsPage.textMessageSection();
        commonFormsPage.clickBtnCloseMessage();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-37 Editar un Location ---------------------------


    //------------------------------ Scenario: TCR-38 Eliminar un Location -------------------------------
    @Given("se tiene el company {string} y el usuario hace click derecho en el location {string}")
    public void se_tiene_el_company_y_el_usuario_hace_click_derecho_en_el_location(String company, String location) {
        companyPage.clickArrowMainClients();
        companyPage.clickArrowNodeCompany();

        companyPage.clickArrowCompanySelect(company);

        locationPage.clickArrowNodeLocation();
        locationPage.rightClickLocationSelect(location);
    }
    @When("el usuario hace click en la opción Delete Location")
    public void el_usuario_hace_click_en_la_opción_delete_location() {
        locationPage.clickDeleteLocation();
    }
    @Then("se muestra un mensaje confirmando que se ha eliminado el Location")
    public void se_muestra_un_mensaje_confirmando_que_se_ha_eliminado_el_location() {
        commonFormsPage.confirmDeleteObject();

        commonFormsPage.confirmSuccessOperation();
        String textMessage = commonFormsPage.textMessageDialog();
        asserts.assertSuccessOperation(textMessage);
    }
    //------------------------------ End Scenario: TCR-38 Eliminar un Location ---------------------------

}
