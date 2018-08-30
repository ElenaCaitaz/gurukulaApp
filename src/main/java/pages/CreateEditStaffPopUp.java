package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class CreateEditStaffPopUp extends PageObject {

    @FindBy(xpath = "//form/div[2]/div[2]/input")
    private WebElement staffName;

    @FindBy(xpath = "//form/div[2]/div[3]/select")
    private WebElement branchDropDown;

    @FindBy(xpath = "//*[@id='saveStaffModal']//button[1]/span[2]")
    private WebElement cancelButton;

    @FindBy(xpath = "//*[@id='saveStaffModal']//button[2]/span[2]")
    private WebElement saveButton;

    @FindBy(xpath = "//div[2]/div[2]/div/p[2]")
    private WebElement errorMessage;

    @FindBy(xpath = "//p[contains(@ng-show, 'error.') and @class='help-block ng-scope']")
    private List<WebElement> validationErrors;

    public WebElement staffName() {
        return staffName;
    }

    public WebElement branchDropDown() {
        return branchDropDown;
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
        return super.onThePage(staffName);
    }

    public List<WebElement> getOptionsWebelements(){
        return (new Select(this.branchDropDown)).getOptions();
    }
}
