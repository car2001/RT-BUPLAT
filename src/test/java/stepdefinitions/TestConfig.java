package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestConfig {
    private static WebDriver driver;
    private static String urlPage = "http://wedox.sytes.net/BUPLAT_config";
    private static String user = "tester";
    private static String password = "1234";


    @Before
    public void setUp() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
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
