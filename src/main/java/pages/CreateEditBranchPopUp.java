package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreateEditBranchPopUp extends PageObject {

    @FindBy(xpath = "//*[@id='saveBranchModal']//div[2]/input")
    private WebElement branchName;

    @FindBy(xpath = "//*[@id='saveBranchModal']//div[3]/input")
    private WebElement code;

    @FindBy(xpath = "//*[@id='saveBranchModal']//div[3]/button[1]")
    private WebElement cancelButton;

    @FindBy(xpath = "//*[@id='saveBranchModal']//div[3]/button[2]")
    private WebElement saveButton;

    @FindBy(xpath = "//p[contains(@ng-show, 'error.') and @class='help-block ng-scope']")
    private List<WebElement> validationErrors;

    public WebElement branchNameInput() {
        return branchName;
    }

    public WebElement codeInput() {
        return code;
    }

    public WebElement saveButton() {
        return saveButton;
    }

    public WebElement cancelButton() {
        return cancelButton;
    }

    public List<WebElement> validationErrors() {
        return validationErrors;
    }

    public boolean onThePage() {
        return super.onThePage(branchName);
    }

}

