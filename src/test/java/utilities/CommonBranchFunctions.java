package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.Base;

public class CommonBranchFunctions extends Base {

    private Asserts asserts;
    private AccessBranch accessBranch;
    private DynamicSearch dynamicSearch;

    public CommonBranchFunctions(WebDriver driver){
        super(driver);
        accessBranch = new AccessBranch(driver);
        dynamicSearch = new DynamicSearch(driver);
        asserts = new Asserts(driver);
    }

    public void clickElementMainTree(String nameElement){
        By locatorElement = By.xpath("//td[contains(@id,'mainTree')]//span[contains(text(),'"+nameElement+"') ]");
        int position = dynamicSearch.searchElementMainTree(nameElement);
        if(position != -1){
            click(locatorElement);
        }else {
            asserts.assertElementMainTree(nameElement);
        }
    }

    public void  rightClickElementMainTree(String nameElement){
        By locatorElement = By.xpath("//td[contains(@id,'mainTree')]//span[contains(text(),'"+nameElement+"') ]");
        int position = dynamicSearch.searchElementMainTree(nameElement);
        if(position != -1){
            rightClick(locatorElement);
        }else {
            asserts.assertElementMainTree(nameElement);
        }
    }
    public void clickBranchElement(String nameElement){
        int position = dynamicSearch.searchElementMainTree(nameElement);
        if(position != -1){
            accessBranch.clickBranches(position);
        }else{
           asserts.assertElementMainTree(nameElement);
        }
    }
    public void clickBranchElementWithState(String nameElement, String action){
        int position = dynamicSearch.searchElementMainTree(nameElement);
        if(position != -1){
            boolean isBranchExpanded = accessBranch.isExpandedBranch(position);
            if(action.contains("Open")){
                if (!isBranchExpanded){accessBranch.clickBranches(position);}
            }else{
                if (isBranchExpanded){accessBranch.clickBranches(position);}
            }
        }else{
            asserts.assertElementMainTree(nameElement);
        }
    }

    public String isDisplayBranchElement(String nameElement){
        String ariaHidden = "";
        int position = dynamicSearch.searchElementMainTree(nameElement);
        if(position != -1){
            By locatorBranchElement = By.xpath("//span[contains(@id,'mainTree-rows-row"+position+"-treeicon')]");
            ariaHidden = getAttribute(locatorBranchElement,"aria-hidden");
        }
        return ariaHidden;
    }


}
