package pages;

import commons.PageElements;
import commons.ScenarioContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StaffPage extends PageObject {

    @FindBy(xpath = "//div[1]/div/div[1]/button")
    private WebElement createButton;

    @FindBy(xpath = "//div[2]/form/button")
    private WebElement searchButton;

    @FindBy(id = "searchQuery")
    private WebElement queryInput;

    public WebElement createButton() {
        return createButton;
    }

    public WebElement searchButton() {
        return searchButton;
    }

    public WebElement queryInput() {
        return queryInput;
    }

    public boolean onThePage() {
        return super.onThePage(createButton);
    }

    public WebElement getElements(PageElements element) {
        switch (element) {
            case CREATE_A_NEW_STAFF:
                return createButton();
            case SEARCH_A_STAFF:
                return searchButton();
        }
        return null;
    }

    public boolean staffIsPresent(String staffName, String branchName) {
        String xpathPattern = "//table//tr[td[2][contains(text(), '%s')] and td[3][contains(text(), '%s')]]";
        return ScenarioContext.getInstance()
                .getDriver()
                .findElements(By.xpath(String.format(xpathPattern, staffName, branchName)))
                .size() > 0;
    }

    public List<WebElement> getStaffName() {
        String xpathPattern = "//table/tbody/tr[@ng-repeat]/td[2]";
        return ScenarioContext.getInstance()
                .getDriver()
                .findElements(By.xpath(xpathPattern));
    }

    public WebElement getStaffName(String name) {
        String xpathPattern = "//table//tr[td[2][contains(text(), '%s')]]";
        return ScenarioContext.getInstance()
                .getDriver()
                .findElement(By.xpath(String.format(xpathPattern, name)));
    }
}
