package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.Base;

public class AccessBranch extends Base {

    private JavascriptExecutor js;
    public AccessBranch(WebDriver driver){
        super(driver);
        this.js = (JavascriptExecutor)driver;
    }

    public void clickBranches(int position){
        By branch = By.xpath("//span[contains(@id,'-mainTree-rows-row"+position+"-treeicon')]");
        click(branch);
        try {
            String next ;
            do{
                next = getTextContent(js,position);
            }while (next.contains("Loading..."));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public Boolean isExpandedBranch(int position){
        By parentBranchLocator = By.xpath("//span[contains(@id,'-mainTree-rows-row"+position+"-treeicon')]//..//..//..");
        String ariaExpanded = getAttribute(parentBranchLocator,"aria-expanded");
        return  ariaExpanded.contains("true") ? true : false;
    }
    public String  getTextContent(JavascriptExecutor js, int position) {
        int pos = position++;
        WebElement nextBranch = findElement(By.xpath("//span[contains(@id,'-mainTree-rows-row"+pos+"-treeicon')]"));
        String textContent = js.executeScript("return arguments[0].textContent", nextBranch).toString();
        return textContent;
    }

}
