package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.Base;

import java.util.ArrayList;
import java.util.List;

public  class DynamicSearch extends Base {

    private static JavascriptExecutor js;
    private static By MainTreeElements = By.xpath("//tr[not(contains(@class,'sapUiTableRowHidden'))]//span[contains(@class,'{Tree>class}') and contains(@class,'sapMText') ]");
    private static By ScrollMainTree = By.xpath("//div[contains(@id,'mainTree-vsb')]");
    private static final String LoadingText = "Loading...";

    public DynamicSearch(WebDriver driver){
        super(driver);
        this.js = (JavascriptExecutor)driver;
    }

    public static int searchElementMainTree(String nameElement){
        int positionFound = -1;
        boolean existScroll;

        //Obtenemos la lista de objetos
        List<WebElement> listMainTreeElements = waitUntilElementsNotLoading(MainTreeElements);
        //Pasamos los nombres de los Elementos al nuevo array
        List<String> listMainTreeTextElements = getTextMainTreeElements(listMainTreeElements);

        existScroll = existScrollMainTree();

        if(existScroll){
            try{
                int scrollHeight = getScrollHeightElement(ScrollMainTree);
                int clientHeight = getClientHeightElement(ScrollMainTree);

                int numIterations = scrollHeight/clientHeight; // Número de veces para repetir el bucle
                int iterator = -1;

                // Verificamos
                while (iterator <= numIterations+1){
                    if(listMainTreeTextElements.lastIndexOf(nameElement) != -1){
                        positionFound = listMainTreeTextElements.lastIndexOf(nameElement);
                        break;
                    }else{
                        iterator++;
                        int newPositionScroll = clientHeight * iterator ;
                        scrollElementTo(js,ScrollMainTree,newPositionScroll);
                        listMainTreeElements = waitUntilElementsNotLoading(MainTreeElements);
                        listMainTreeTextElements.clear();
                        listMainTreeTextElements = getTextMainTreeElements(listMainTreeElements);
                    }
                }

            }catch (ArithmeticException e){
                System.out.println(e);
            }
        }else {
            positionFound = listMainTreeTextElements.lastIndexOf(nameElement);
        }

        return positionFound;
    }
    private static List<WebElement> waitUntilElementsNotLoading(By locator)  {
        List<WebElement> elements;
        do {
            elements = findElements(locator);
        } while (elements.contains(LoadingText));
        return elements;
    }
    public static List<String> getTextMainTreeElements(List<WebElement> listMainTreeElements) {
        List<String> nameElements = new ArrayList<>();
        for (WebElement element : listMainTreeElements) {
            if (!element.getText().equals(LoadingText)) {
                nameElements.add(element.getText());
            }
        }
        return nameElements;
    }
    public static boolean existScrollMainTree(){
        String xmlView = getXmlView();
        int sizeScroll = js.executeScript("let bar = document.getElementById('"+xmlView+"--mainTree-vsb'); return(bar.scrollHeight);").hashCode();
        return sizeScroll > 0 ? true : false;
    }
    public static int getScrollHeightElement(By locator){
        WebElement scrollBar = findElement(locator);
        int scrollHeight = js.executeScript("let int = arguments[0].scrollHeight; return(int)",scrollBar).hashCode();
        return scrollHeight;
    }
    public static int getClientHeightElement(By locator){
        WebElement scrollBar = findElement(locator);
        int clientHeight = js.executeScript("let int = arguments[0].clientHeight; return(int)",scrollBar).hashCode();
        return clientHeight;
    }


}
