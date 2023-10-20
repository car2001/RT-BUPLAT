package utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pom.Base;

public class Asserts extends Base {

    public Asserts(WebDriver driver){
        super(driver);
    }

    public void assertSave(String message){
        String language = getLanguage();
        if(language.contains("es")){ Assert.assertEquals("The Operation has been Completed Successfully.",message); }
        if(language.contains("en")){ Assert.assertEquals("La operación se ha completado con éxito.",message);}
    }

}
