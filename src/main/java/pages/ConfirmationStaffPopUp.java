package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationStaffPopUp extends PageObject {

    @FindBy(xpath = "//*[@id='deleteStaffConfirmation']//div[3]/button[2]")
    private WebElement deleteButton;

    @FindBy(xpath = "//*[@id='deleteStaffConfirmation']//div[3]/button[1]")
    private WebElement cancelButton;

    @FindBy(xpath = "//*[@id='deleteStaffConfirmation']//div[1]/button")
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
