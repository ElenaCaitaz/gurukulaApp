package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPopUp extends PageObject {

    @FindBy(xpath = "//button[contains(@ng-disabled,'deleteForm.$invalid')]")
    private WebElement deleteButton;

    @FindBy(xpath = "//*[@id='deleteBranchConfirmation']//div[3]/button[1]")
    private WebElement cancelButton;

    @FindBy(xpath = "//*[@id='deleteBranchConfirmation']//div[1]/button")
    private WebElement closePopup;

    public WebElement cancelButton() {
        return cancelButton;
    }

    public WebElement deleteButton() {
        return deleteButton;
    }

    public WebElement closePopup() {
        return closePopup;
    }

    public boolean onThePage() {
        return super.onThePage(deleteButton);
    }


}
