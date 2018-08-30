package pages;

import commons.PageElements;
import commons.ScenarioContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends PageObject {

    @FindBy(xpath = "//div[2]/div/div[1]/a")
    private WebElement loginLink;

    @FindBy(xpath = "//div[2]/div/div[2]/a")
    private WebElement registerLink;

    @FindBy(xpath = "//*[@id='navbar-collapse']/ul/li[2]")
    private WebElement accountDropDown;

    public WebElement loginLink() {
        return loginLink;
    }

    public WebElement registerLink() {
        return registerLink;
    }

    public WebElement accountDropDown() {
        return accountDropDown;
    }

    public boolean onThePage() {
        return super.onThePage(loginLink);
    }

    public WebElement getElements(PageElements element) {
        switch (element) {
            case LOGIN:
                return loginLink();
            case REGISTER_A_NEW_ACCOUNT:
                return registerLink();
            case ACCOUNT:
                return accountDropDown();
        }
        return null;
    }
}
