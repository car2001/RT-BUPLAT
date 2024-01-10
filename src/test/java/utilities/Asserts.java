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
    public void assertSaveDeploymentPackage(String message, String nameDP){
        String language = getLanguage();
        if(language.contains("en")){ Assert.assertEquals("The DP has been created with Name ´"+nameDP+"´",message); }
        if(language.contains("es")){ Assert.assertEquals("El paquete de instalación ha sido creado con el nombre ´"+nameDP+"´.",message);}
    }
    public void assertSaveDeploymentRequest(String message, String nameDP){
        String language = getLanguage();
        if(language.contains("en")){ Assert.assertEquals("The DR has been created with Name ´"+nameDP+"´",message); }
        if(language.contains("es")){ Assert.assertEquals("El paquete de instalación ha sido creado con el nombre ´"+nameDP+"´.",message);}
    }
    public void assertTableDependencies(String tableTitle){
        String language = getLanguage();
        if(language.contains("en")){ Assert.assertEquals("Dependencies List",tableTitle); }
        if(language.contains("es")){ Assert.assertEquals("Lista de Dependencias",tableTitle);}
    }
    public void assertSuccessSaveDiagram(String message){
        String language = getLanguage();
        if(language.contains("en")){ Assert.assertEquals("The diagram was successfully saved",message); }
        if(language.contains("es")){ Assert.assertEquals("El diagrama se guardó con éxito.",message);}
    }
    public void assertElementMainTree(String nameElement){
        Assert.assertEquals("Si hay el elemento "+nameElement+" buscado","No hay el elemento "+nameElement+" buscado");
    }
}
