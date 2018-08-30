package pages;

import commons.PageElements;
import commons.ScenarioContext;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ValuesGeneration;

import java.util.List;

public class BranchPage extends PageObject {
    private ScenarioContext context = ScenarioContext.getInstance();

    @FindBy(xpath = "//button[contains(@data-target,'#saveBranchModal')]")
    private WebElement createButton;

    @FindBy(xpath = "//button[contains(@ng-click,'search()')]")
    private WebElement searchButton;

    @FindBy(id = "searchQuery")
    private WebElement queryInput;

    @FindBy(xpath = "//table/tbody/tr")
    private WebElement branchTable;

    @FindBy(xpath = "//table/tbody/tr")
    private List<WebElement> branchRows;

    public WebElement createButton() {
        return createButton;
    }

    public WebElement searchButton() {
        return searchButton;
    }

    public WebElement queryInput() {
        return queryInput;
    }

    public WebElement branchTable() {
        return branchTable;
    }

    public List<WebElement> branchRows() {
        return branchRows;
    }

    public boolean onThePage() {
        return super.onThePage(createButton);
    }

    public boolean isPresent(String branchName, String code) {
        String xpathPattern = "//table//tr[td[2][contains(text(), '%s')] and td[3][contains(text(), '%s')]]";
        return ScenarioContext.getInstance()
                .getDriver()
                .findElements(By.xpath(String.format(xpathPattern, branchName, code)))
                .size() > 0;
    }

    public List<WebElement> getBranchesName() {
        String xpathPattern = "//table/tbody/tr[@ng-repeat]/td[2]";
        return ScenarioContext.getInstance()
                .getDriver()
                .findElements(By.xpath(xpathPattern));
    }

    public WebElement getBranchName(String name) {
        String xpathPattern = "//table//tr[td[2][contains(text(), '%s')]]";
        return ScenarioContext.getInstance()
                .getDriver()
                .findElement(By.xpath(String.format(xpathPattern, name)));
    }

    public WebElement deleteButton() {
        String xpathPattern = "//tr[1]//button[contains(@ng-click,'delete(branch.id)')]";
        return ScenarioContext.getInstance()
                .getDriver()
                .findElement(By.xpath(String.format(xpathPattern)));
    }

    public WebElement editButton() {
        String xpathPattern = "//table/tbody/tr[1]/td[4]/button[2]";
        return ScenarioContext.getInstance()
                .getDriver()
                .findElement(By.xpath(String.format(xpathPattern)));
    }

    public WebElement viewButton() {
        String xpathPattern = "//table/tbody/tr[1]/td[4]/button[1]";
        return ScenarioContext.getInstance()
                .getDriver()
                .findElement(By.xpath(String.format(xpathPattern)));
    }

    public WebElement getElements(PageElements element) {
        switch (element) {
            case CREATE_A_NEW_BRANCH:
                return createButton();
            case SEARCH_A_BRANCH:
                return searchButton();
        }
        return null;
    }

    public void createBranches(int n) throws InterruptedException {
        CreateEditBranchPopUp createBranchPopUp = (CreateEditBranchPopUp) context.getPage(CreateEditBranchPopUp.class);
        Assert.assertTrue("Pop up is opened", createBranchPopUp.onThePage());
        for (int i = 0; i < n; i++) {
            String name = ValuesGeneration.generateValue("[5alphabeticWithSpaces]");
            String code = ValuesGeneration.generateValue("[6alphaNumericRandomCase]");
            createBranchPopUp.branchNameInput().sendKeys(name);
            createBranchPopUp.codeInput().sendKeys(code);
            createBranchPopUp.saveButton().click();
            BranchPage branchPage = (BranchPage) context.getPage(BranchPage.class);
            branchPage.onThePage();
            branchPage.createButton().click();
        }
    }
}
