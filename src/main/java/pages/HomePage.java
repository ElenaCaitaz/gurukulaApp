package pages;

import commons.PageElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends PageObject {

    @FindBy(xpath = "//li[1]/a[2]")
    private WebElement homeButton;

    @FindBy(xpath = "//li[2]/a/span/span[2]")
    private WebElement entitiesDropDown;

    @FindBy(xpath = "//li[3]/a/span/span[2]")
    private WebElement accountDropDown;

    @FindBy(xpath = "//div/div[2]/div/div")
    private WebElement alertMessage;

    public WebElement homeButton() {
        return homeButton;
    }

    public WebElement entitiesDropDown() {
        return entitiesDropDown;
    }

    public WebElement accountDropDown() {
        return accountDropDown;
    }

    public WebElement alertMsg() {
        return alertMessage;
    }

    public boolean onThePage() {
        return super.onThePage(alertMessage);
    }

    public WebElement getElements(PageElements element) {
        switch (element) {
            case HOME:
                return homeButton();
            case ENTITIES:
                return entitiesDropDown();
            case ACCOUNT:
                return accountDropDown();
        }
        return null;
    }
}
