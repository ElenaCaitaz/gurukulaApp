package hooks;

import commons.ScenarioContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class StepHooks {
    protected static WebDriver driver;
    private static String baseUrl;

    @Before
    public static void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        ScenarioContext.getInstance().setDriver(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public static void tearDown() {
        driver.close();
    }
}
