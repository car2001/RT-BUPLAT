package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.Base;

public class TestConfig {
    private static WebDriver driver;
    private static String urlPage = "http://wedox.sytes.net/BUPLAT_config";
    private static String user = "tester";
    private static String password = "1234";

    @Before
    public void setUp() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
    }

    @After
    public void tearDown() {
        //if (driver != null) {
            //driver.quit();
           // driver = null;
       // }
    }
    public static WebDriver getDriver() {
        return driver;
    }
    public static String getUrlPage() { return urlPage; }
    public static String getUser() { return user; }
    public static String getPassword() { return password; }
}
