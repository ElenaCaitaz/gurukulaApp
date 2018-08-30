package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageObject;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private static ScenarioContext scenarioContext;
    private WebDriver driver;

    private HashMap<Class<? extends PageObject>, PageObject> pages;

    private ScenarioContext() {
        pages = new HashMap<>();
    }

    private static final Map<DataKeys, Object> data = new HashMap<>();

    public static ScenarioContext getInstance() {
        if (scenarioContext == null) {
            scenarioContext = new ScenarioContext();
        }
        return scenarioContext;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public PageObject getPage(Class page) {
        if (pages.containsKey(page))
            return pages.get(page);
        else
            return (PageObject) PageFactory.initElements(driver, page);
    }

    public void save(DataKeys key, Object value){
        data.put(key, value);
    }

    public Object getData(DataKeys key){
        return data.get(key);
    }

}
