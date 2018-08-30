package pages;

import commons.ScenarioContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {

    public boolean onThePage(WebElement element) {
        WebDriverWait wait = new WebDriverWait(ScenarioContext.getInstance().getDriver(), 40);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public MainMenu getMainMenu() {
        return (MainMenu) ScenarioContext.getInstance().getPage(MainMenu.class);
    }

}

