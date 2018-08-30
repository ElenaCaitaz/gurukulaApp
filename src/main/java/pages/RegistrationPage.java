package pages;

import commons.PageElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegistrationPage extends PageObject {

    @FindBy(xpath = "//form/div[1]/input")
    private WebElement loginInput;

    @FindBy(xpath = "//form/div[1]/label")
    private WebElement loginLabel;

    @FindBy(xpath = "//form/div[2]/input")
    private WebElement emailInput;

    @FindBy(xpath = "//form/div[2]/label")
    private WebElement emailLabel;

    @FindBy(xpath = "//form/div[3]/input")
    private WebElement newPasswordInput;

    @FindBy(xpath = "//form/div[3]/label")
    private WebElement newPasswordLabel;

    @FindBy(xpath = "//form/div[4]/input")
    private WebElement NewPasswordConfirmInput;

    @FindBy(xpath = "//form/div[4]/label")
    private WebElement NewPasswordConfirmLabel;

    @FindBy(xpath = "//form[@ng-show]//button")
    private WebElement registerButton;

    @FindBy(xpath = "//div[6]/a")
    private WebElement loginLink;

    @FindBy(xpath = "//div[@class='alert alert-danger ng-scope']")
    private WebElement errorMessage;

    @FindBy(xpath = "//p[contains(@ng-show, 'error.') and @class='help-block ng-scope']")
    private List<WebElement> validationErrors;

    public WebElement loginInput() {
        return loginInput;
    }

    public WebElement emailInput() {
        return emailInput;
    }

    public WebElement newPasswordInput() {
        return newPasswordInput;
    }

    public WebElement newPasswordConfirmInput() {
        return NewPasswordConfirmInput;
    }

    public WebElement registerButton() {
        return registerButton;
    }

    public WebElement loginLabel() {
        return loginLabel;
    }

    public WebElement emailLabel() {
        return emailLabel;
    }

    public WebElement newPasswordLabel() {
        return newPasswordLabel;
    }

    public WebElement newPasswordConfirmLabel() {
        return NewPasswordConfirmLabel;
    }

    public List<WebElement> validationErrors() {
        return validationErrors;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public boolean onThePage() {
        return super.onThePage(registerButton);
    }

    public WebElement getElements(PageElements element) {
        switch (element) {
            case LOGIN_LABEL:
                return loginLabel();
            case EMAIL:
                return emailLabel();
            case NEW_PASSWORD:
                return newPasswordLabel();
            case NEW_PASSWORD_CONFIRMATION:
                return newPasswordConfirmLabel();
            case REGISTER:
                return registerButton();
        }
        return null;
    }

}
