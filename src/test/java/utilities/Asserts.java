package utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pom.Base;

public class Asserts extends Base {

    public Asserts(WebDriver driver){
        super(driver);
    }

    public void assertSuccessOperation(String message){
        String language = getLanguage();
        if(language.contains("en")){ Assert.assertEquals("The Operation has been Completed Successfully.",message); }
        if(language.contains("es")){ Assert.assertEquals("La operación se ha completado con éxito.",message);}
    }

}
