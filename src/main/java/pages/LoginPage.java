package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement userPassword;

    @FindBy(xpath = "//form/button")
    private WebElement authenticate;

    @FindBy(xpath = "//div/div/div/div[2]/a")
    private WebElement forgetPassLink;

    @FindBy(xpath = "//div/div/div/div[3]/a")
    private WebElement registerNewAccountLink;

    @FindBy(xpath = "//div[3]/div[1]/div/div/div/div[1]")
    private WebElement errorMessage;

    public WebElement errorMessage() {
        return errorMessage;
    }

    public WebElement forgetPassLink() {
        return forgetPassLink;
    }

    public HomePage userLogin(String name, String password) {
        userName.sendKeys(name);
        userPassword.sendKeys(password);
        authenticate.click();
        return new HomePage();
    }

    public boolean onThePage() {
        return super.onThePage(userName);
    }

}
