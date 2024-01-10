package pages.apps.osm.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;
import utilities.CommonBranchFunctions;
import utilities.WaitFunctions;

public class CompanyPage extends Base {

    private CommonBranchFunctions branchFunctions;
    private WaitFunctions waitFunctions;
    private String clientMainNode= "Clients";
    private String companyMainNode = "Companies";
    private By newCompanyDiv = By.xpath("//div[contains(text(),'New Company') or contains(text(),'Nueva Compañia') ]");
    private By deleteCompanyDiv = By.xpath("//div[contains(text(),'Delete Company') or contains(text(),'Borrar Compañia') ]");
    private By taxNumberInput = By.xpath("//input[contains(@id,'companyTaxNumber')]");

    public CompanyPage (WebDriver driver){
        super(driver);
        this.branchFunctions = new CommonBranchFunctions(driver);
        this.waitFunctions = new WaitFunctions(driver);
    }

    // Actions Main Node Clients
    public void clickArrowMainClients(){
        branchFunctions.clickBranchElement(clientMainNode);
    }

    // Actions Main Node Company
    public void rightClickNodeCompany(){
        branchFunctions.rightClickElementMainTree(companyMainNode);
    }
    public void clickArrowNodeCompany(){
        branchFunctions.clickBranchElement(companyMainNode);
        waitFunctions.waitForMainTreeToFinishLoading();
    }
    public void clickNewCompany(){
        click(newCompanyDiv);
    }
    public void clickDeleteCompany(){
        click(deleteCompanyDiv);
    }

    // Actions in any Company node
    public void clickCompanySelect(String selectCompany){
        branchFunctions.clickElementMainTree(selectCompany);
    }
    public void rightClickCompanySelect(String selectCompany){
        branchFunctions.rightClickElementMainTree(selectCompany);
    }
    public void clickArrowCompanySelect(String selectedCompany){
        boolean isReleaseVisible = branchFunctions.isDisplayBranchElement(selectedCompany).contains("false");
        if(isReleaseVisible){
            branchFunctions.clickBranchElement(selectedCompany);
        }
    }

    // Actions Form Company
    public void fillCompanyForm(String taxNumber) {
        enterTaxNumber(taxNumber);
    }
    public void enterTaxNumber(String taxNumber){
        sendKeys(taxNumber,taxNumberInput);
    }

}
