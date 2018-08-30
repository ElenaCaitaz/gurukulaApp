package pages;

import commons.PageElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StaffDetailsPage extends PageObject {

    @FindBy(xpath = "//table/tbody/tr[1]/td[2]/input")
    private WebElement staffName;

    @FindBy(xpath = "//table/tbody/tr[2]/td[2]/input")
    private WebElement branchName;

    @FindBy(xpath = "//div[3]/div[1]/div/button/span[2]")
    private WebElement backButton;

    @FindBy(xpath = "//tbody/tr[1]/td[1]/span")
    private WebElement nameLabel;

    @FindBy(xpath = "//tbody/tr[2]/td[1]/span")
    private WebElement branchLabel;

    public WebElement branchLabel() {
        return branchLabel;
    }

    public WebElement nameLabel() {
        return nameLabel;
    }

    public WebElement backButton() {
        return backButton;
    }

    public boolean onThePage() {
        return super.onThePage(backButton);
    }

    public WebElement getElements(PageElements element) {
        switch (element) {
            case NAME:
                return nameLabel();
            case BRANCH:
                return branchLabel();
            case BACK:
                return backButton();
        }
        return null;
    }
}
