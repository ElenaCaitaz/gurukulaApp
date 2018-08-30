package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetPasswordPage extends PageObject {

    @FindBy(xpath = "//form/div/input")
    private WebElement emailInput;

    @FindBy(xpath = "//form/button")
    private WebElement resetButton;

    @FindBy(xpath = "//div[@ng-show='errorEmailNotExists']")
    private WebElement errorMessage;

    @FindBy(xpath = "//form/div/div/p[2]")
    private WebElement validationError;

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getResetButton() {
        return resetButton;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public WebElement getValidationError() {
        return validationError;
    }

    public boolean onThePage() {
        return super.onThePage(emailInput);
    }
}


