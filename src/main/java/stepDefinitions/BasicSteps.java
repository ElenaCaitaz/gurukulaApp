package stepDefinitions;

import commons.DataKeys;
import commons.PageElements;
import commons.ScenarioContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fixtures.InputData;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.*;
import utils.PropertyManager;
import utils.Utility;
import utils.ValuesGeneration;

import java.util.List;

public class BasicSteps {
    private ScenarioContext context = ScenarioContext.getInstance();
    private String baseURL = PropertyManager.getInstance().getURL();
    private String loginURL = PropertyManager.getInstance().getLoginUrl();
    private String registerURL = PropertyManager.getInstance().getRegisterUrl();
    private String branchURL = PropertyManager.getInstance().getBranchUrl();
    private String staffURL = PropertyManager.getInstance().getStaffUrl();

    @When("^user navigates to Welcome page$")
    public void userNavigatesToWelcomePage() {
        context.getDriver().get(baseURL);
        WelcomePage welcomePage = (WelcomePage) context.getPage(WelcomePage.class);
        Assert.assertTrue("Welcome page is opened", welcomePage.onThePage());
    }

    @Then("^Welcome page has the following elements$")
    public void welcomePageHasTheFollowingElements(List<String> elements) {
        WelcomePage page = (WelcomePage) context.getPage(WelcomePage.class);
        for (String element : elements) {
            PageElements enumElement = PageElements.getByDescription(element);
            WebElement webElement = page.getElements(enumElement);
            Assert.assertEquals("Element is displayed", enumElement.getDescription(), webElement.getText().trim());
        }
    }

    @When("^user clicks on Login link$")
    public void userClicksOnLogin() {
        WelcomePage page = (WelcomePage) context.getPage(WelcomePage.class);
        page.loginLink().click();
    }

    @Then("^user is redirected to Home page$")
    public void userIsRedirectedToHomePage() {
        HomePage homePage = (HomePage) context.getPage(HomePage.class);
        Assert.assertTrue("User is on page", homePage.onThePage());
    }

    @When("^user logs in with '(.*)' username and '(.*)' password$")
    public void userLogsInWithAdminUsernameAndAdminPassword(String name, String password) {
        LoginPage loginPage = (LoginPage) context.getPage(LoginPage.class);
        loginPage.userLogin(name, password);
    }

    @Then("^alert message is displayed '(.*)'$")
    public void alertMessageIsDisplayed(String message) {
        HomePage homePage = (HomePage) context.getPage(HomePage.class);
        WebElement alertMessage = homePage.alertMsg();
        Assert.assertTrue("Message is displayed", alertMessage.isDisplayed());
        Assert.assertEquals("Correct message is displayed", alertMessage.getText(), message);
        Utility.takeScreenshot(context.getDriver(), "Alert message is displayed");
    }

    @Given("^user navigates to Login page$")
    public void userNavigatesToLoginPage() {
        context.getDriver().get(loginURL);
        LoginPage loginPage = (LoginPage) context.getPage(LoginPage.class);
        Assert.assertTrue("Login page opened", loginPage.onThePage());
    }

    @When("^user clicks on Account menu and logs out$")
    public void userClicksOnAccountMenuAndLogsOut() {
        HomePage page = (HomePage) context.getPage(HomePage.class);
        page.getMainMenu().accountDropdown().click();
        page.getMainMenu().logoutButton().click();
    }

    @Then("^user is redirected to Welcome page$")
    public void userIsRedirectedToWelcomePage() {
        WelcomePage welcomePage = (WelcomePage) context.getPage(WelcomePage.class);
        Assert.assertTrue("Welcome page is opened", welcomePage.onThePage());
    }

    @Then("^error message is displayed '(.*)'$")
    public void errorMessageIsDisplayed(String expectedErrorMessage) {
        LoginPage loginPage = (LoginPage) context.getPage(LoginPage.class);
        Assert.assertTrue("Welcome page is opened", loginPage.onThePage());
        WebElement actualErrorMessage = loginPage.errorMessage();
        Assert.assertTrue("Message is displayed", actualErrorMessage.isDisplayed());
        Assert.assertTrue("Correct message is displayed", actualErrorMessage.getText().contains(expectedErrorMessage));
    }

    @When("^user clicks on Register a new account$")
    public void userClicksOnRegisterANewAccount() {
        WelcomePage welcomePage = (WelcomePage) context.getPage(WelcomePage.class);
        welcomePage.registerLink().click();
    }

    @Then("^user is redirected to Registration page$")
    public void userIsRedirectedToRegistrationPage() {
        RegistrationPage registrationPage = (RegistrationPage) context.getPage(RegistrationPage.class);
        Assert.assertTrue("Registration page is opened", registrationPage.onThePage());
    }

    @Given("^user navigates to Registration page$")
    public void userNavigatesToRegistrationPage() {
        context.getDriver().get(registerURL);
        RegistrationPage registrationPage = (RegistrationPage) context.getPage(RegistrationPage.class);
        Assert.assertTrue("Registration page is opened", registrationPage.onThePage());
    }

    @When("^user clicks on Register$")
    public void userClicksOnRegister() {
        RegistrationPage registrationPage = (RegistrationPage) context.getPage(RegistrationPage.class);
        Assert.assertTrue(registrationPage.onThePage());
        registrationPage.registerButton().click();
    }

    @When("^user fills in new user details with the following data$")
    public void userFillsInNewUserDetailsWithTheFollowingData(List<InputData> inputData) {
        InputData data = inputData.get(0);

        RegistrationPage registerUser = (RegistrationPage) context.getPage(RegistrationPage.class);
        registerUser.loginInput().sendKeys(data.getLogin());
        registerUser.emailInput().sendKeys(data.getEmail());
        registerUser.newPasswordInput().sendKeys(data.getNewPassword());
        registerUser.newPasswordConfirmInput().sendKeys(data.getConfirmPassword());
    }

    @Then("^validation error is displayed '(.*)'$")
    public void messagetypeIsDisplayedMessage(String message) {
        RegistrationPage page = (RegistrationPage) context.getPage(RegistrationPage.class);
        List<WebElement> errors = page.validationErrors();
        Assert.assertFalse("is displayed", errors.isEmpty());
        String actualMessage = errors.stream().filter(p -> p.getText().equals(message)).findAny().orElse(null).getText();
        Assert.assertEquals("messages match", actualMessage, message);
        Utility.takeScreenshot(context.getDriver(), "Validation error is displayed");
    }

    @When("^user clicks on forget password link$")
    public void userClicksOnForgetPasswordLink() {
        LoginPage loginPage = (LoginPage) context.getPage(LoginPage.class);
        loginPage.forgetPassLink().click();
    }

    @Then("^user is redirected to Reset Password page$")
    public void userIsRedirectedToResetPasswordPage() {
        ResetPasswordPage resetPasswordPage = (ResetPasswordPage) context.getPage(ResetPasswordPage.class);
        Assert.assertTrue("Reset Password page is opened", resetPasswordPage.onThePage());
    }

    @When("^user fills in the email input field with '(.*)'$")
    public void userFillsInTheEmailInputFieldWithEmail(String email) {
        ResetPasswordPage resetPasswordPage = (ResetPasswordPage) context.getPage(ResetPasswordPage.class);
        Assert.assertTrue("Email input is displayed", resetPasswordPage.getEmailInput().isDisplayed());
        resetPasswordPage.getEmailInput().sendKeys(email);
    }

    @When("^user clicks on Entities and selects (.*)$")
    public void userClicksOnEntitiesAndSelectsElement(String type) {
        HomePage page = (HomePage) context.getPage(HomePage.class);
        if (type.equals("Branch")) {
            page.getMainMenu().entitiesDropdown().click();
            page.getMainMenu().branch().click();
        } else {
            page.getMainMenu().entitiesDropdown().click();
            page.getMainMenu().staff().click();
        }
    }

    @Then("^user is redirected to Branch page$")
    public void userIsRedirectedToBranchPage() {
        BranchPage branchPage = (BranchPage) context.getPage(BranchPage.class);
        Assert.assertTrue("Branch page is opened", branchPage.onThePage());
    }

    @When("^user navigates to Branch page$")
    public void userNavigatesToBranchPage() {
        context.getDriver().get(branchURL);
        BranchPage branchPage = (BranchPage) context.getPage(BranchPage.class);
        Assert.assertTrue("Branch page is opened", branchPage.onThePage());
    }

    @When("^user clicks on Create a new Branch$")
    public void userClicksOnCreateANewBranch() {
        BranchPage branchPage = (BranchPage) context.getPage(BranchPage.class);
        branchPage.createButton().click();
    }

    @When("^name and code are inserted$")
    public void nameBranchOneAndCodeAreInserted() {
        CreateEditBranchPopUp createBranchPopUp = (CreateEditBranchPopUp) context.getPage(CreateEditBranchPopUp.class);
        Assert.assertTrue("Pop up is opened", createBranchPopUp.onThePage());

        String name = ValuesGeneration.generateValue("[5alphabeticWithSpaces]");
        String code = ValuesGeneration.generateValue("[6alphaNumericRandomCase]");
        createBranchPopUp.branchNameInput().sendKeys(name);
        createBranchPopUp.codeInput().sendKeys(code);

        context.save(DataKeys.BRANCH_NAME, name);
        context.save(DataKeys.CODE, code);
    }

    @Then("^user clicks on (Save|Cancel)$")
    public void userClicksOnSave(String button) {
        CreateEditBranchPopUp createBranchPopUp = (CreateEditBranchPopUp) context.getPage(CreateEditBranchPopUp.class);
        if (button.equals("Save")) {
            createBranchPopUp.saveButton().click();
        } else {
            createBranchPopUp.cancelButton().click();
        }
    }

    @Then("^branch is(| not) (created|updated)$")
    public void branchIsCreated(String param, String type) {
        BranchPage branchPage = (BranchPage) context.getPage(BranchPage.class);
        String branchName = (String) context.getData(DataKeys.BRANCH_NAME);
        String branchCode = (String) context.getData(DataKeys.CODE);
        if (param.equals(" not")) {
            Assert.assertTrue("branch is not created", !branchPage.isPresent(branchName, branchCode));
            Utility.takeScreenshot(context.getDriver(), "Branch is not created");
        } else {
            Assert.assertTrue("branch is created", branchPage.isPresent(branchName, branchCode));
            Utility.takeScreenshot(context.getDriver(), "Branch is created");
        }
    }

    @When("^user selects first element and clicks on Delete$")
    public void userSelectsFirstelementAndClicksOnDelete() {
        BranchPage branchPage = (BranchPage) context.getPage(BranchPage.class);
        WebElement row = branchPage.branchRows().get(0);
        context.save(DataKeys.ROW, row);
        branchPage.deleteButton().click();
    }

    @Then("^user clicks on '(.*)' on displayed Pop up$")
    public void userClicksOnDeleteOnPopUp(String buttonType) {
        ConfirmationPopUp confirmationPopUp = (ConfirmationPopUp) context.getPage(ConfirmationPopUp.class);
        Assert.assertTrue("Confirmation pop up is displayed", confirmationPopUp.onThePage());
        if (buttonType.equals("Delete")) {
            confirmationPopUp.deleteButton().click();
        } else {
            confirmationPopUp.cancelButton().click();
        }
    }

    @Then("^(branch|staff) is(| not) deleted$")
    public void elementIsDeleted(String type, String param) {
        BranchPage branchPage = (BranchPage) context.getPage(BranchPage.class);
        List<WebElement> allRows = branchPage.branchRows();
        WebElement savedRow = (WebElement) context.getData(DataKeys.ROW);
        if (param.equals(" not")) {
            Assert.assertTrue("Branch is not deleted", allRows.contains(savedRow));
        } else {
            Assert.assertTrue("Branch is deleted", !allRows.contains(savedRow));
        }
    }

    @When("^user selects first element and clicks on Edit$")
    public void userSelectsFirstBranchAndClicksOnEdit() {
        BranchPage branchPage = (BranchPage) context.getPage(BranchPage.class);
        Assert.assertTrue("Branch list is not empty", !branchPage.branchRows().isEmpty());
        WebElement row = branchPage.branchRows().get(0);
        context.save(DataKeys.ROW, row);
        branchPage.editButton().click();
    }

    @When("^all input fields are cleared$")
    public void allInputFieldsAreCleared() {
        CreateEditBranchPopUp createBranchPopUp = (CreateEditBranchPopUp) context.getPage(CreateEditBranchPopUp.class);
        Assert.assertTrue("Pop up is opened", createBranchPopUp.onThePage());
        createBranchPopUp.branchNameInput().clear();
        createBranchPopUp.codeInput().clear();
    }

    @When("^user selects first element and clicks on View$")
    public void userSelectsFirstBranchAndClicksOnView() {
        BranchPage branchPage = (BranchPage) context.getPage(BranchPage.class);
        Assert.assertTrue("Branch list is not empty", !branchPage.branchRows().isEmpty());
        WebElement row = branchPage.branchRows().get(0);
        context.save(DataKeys.ROW, row);
        branchPage.viewButton().click();
    }

    @Then("^user is redirected to Branch details page$")
    public void userIsRedirectedToBranchDetailsPage() {
        BranchDetailsPage branchDetailsPage = (BranchDetailsPage) context.getPage(BranchDetailsPage.class);
        Assert.assertTrue("Branch details is opened", branchDetailsPage.onThePage());
    }

    @When("^user sets the value '(.*)' for query input$")
    public void userSetsTheValueForQueryInput(String branchName) {
        BranchPage branchPage = (BranchPage) context.getPage(BranchPage.class);
        branchPage.searchButton().sendKeys(branchName);
    }

    @When("^user searches for the (\\d+) branch$")
    public void userSearchesForBranch(int branchNr) {
        BranchPage branchPage = (BranchPage) context.getPage(BranchPage.class);

        String branchName = branchPage.getBranchesName().get(branchNr).getText();
        branchPage.queryInput().sendKeys(branchName);
        branchPage.searchButton().click();
        context.save(DataKeys.BRANCH_NAME, branchName);
    }

    @Then("^the correct branch is displayed$")
    public void branchesWithNameBranchtwoAreDisplayed() {
        BranchPage branchPage = (BranchPage) context.getPage(BranchPage.class);
        String branchName = (String) context.getData(DataKeys.BRANCH_NAME);
        Assert.assertTrue("Searched branch is displayed", branchPage.getBranchName(branchName).isDisplayed());
    }

    @Then("^Home page has the following elements$")
    public void homePageHasTheFollowingElements(List<String> elements) {
        HomePage page = (HomePage) context.getPage(HomePage.class);
        for (String element : elements) {
            PageElements enumElement = PageElements.getByDescription(element);
            WebElement webElement = page.getElements(enumElement);
            Assert.assertEquals("Element is displayed", enumElement.getDescription(), webElement.getText().trim());
        }
    }

    @Then("^Registration page has the following elements$")
    public void registrationPageHasTheFollowingElements(List<String> elements) {
        RegistrationPage page = (RegistrationPage) context.getPage(RegistrationPage.class);
        for (String element : elements) {
            PageElements enumElement = PageElements.getByDescription(element);
            WebElement webElement = page.getElements(enumElement);
            Assert.assertEquals("Element is displayed", enumElement.getDescription(), webElement.getText().trim());
            Utility.takeScreenshot(context.getDriver(), "Elements are displayed");
        }
    }

    @Then("^Branch page has the following elements$")
    public void branchPageHasTheFollowingElements(List<String> elements) {
        BranchPage page = (BranchPage) context.getPage(BranchPage.class);
        for (String element : elements) {
            PageElements enumElement = PageElements.getByDescription(element);
            WebElement webElement = page.getElements(enumElement);
            Assert.assertEquals("Element is displayed", enumElement.getDescription(), webElement.getText().trim());
        }
    }

    @Then("^name '(.*)' and code '(.*)' are inserted$")
    public void nameNameAndCodeCodeAreInserted(String name, String code) {
        CreateEditBranchPopUp createBranchPopUp = (CreateEditBranchPopUp) context.getPage(CreateEditBranchPopUp.class);
        Assert.assertTrue("Pop up is opened", createBranchPopUp.onThePage());
        createBranchPopUp.branchNameInput().sendKeys(name);
        createBranchPopUp.codeInput().sendKeys(code);
    }

    @Then("^validation error is displayed '(.*)' on branch pop-up$")
    public void validationErrorIsDisplayedMessageOnBranchPopUp(String message) {
        CreateEditBranchPopUp createBranchPopUp = (CreateEditBranchPopUp) context.getPage(CreateEditBranchPopUp.class);
        Assert.assertTrue("Pop up is opened", createBranchPopUp.onThePage());
        List<WebElement> errors = createBranchPopUp.validationErrors();
        Assert.assertFalse("is displayed", errors.isEmpty());
        String actualMessage = errors.stream().filter(p -> p.getText().equals(message)).findAny().orElse(null).getText();
        Assert.assertEquals("messages match", actualMessage, message);
        Utility.takeScreenshot(context.getDriver(), "validation error is displayed");
    }

    @Then("^'(.*)' is displayed '(.*)' on Reset page$")
    public void errorMessageIsDisplayedOnResetPage(String messageType, String expectedError) {
        ResetPasswordPage page = (ResetPasswordPage) context.getPage(ResetPasswordPage.class);
        if (messageType.equals("error message")) {
            Assert.assertTrue("", page.getErrorMessage().isDisplayed());
            Assert.assertEquals("", page.getErrorMessage().getText(), expectedError);
        } else if (messageType.equals("validation error")) {
            Assert.assertTrue("", page.getValidationError().isDisplayed());
            Assert.assertEquals("", page.getValidationError().getText(), expectedError);
        }
    }

    @When("^user clicks on Reset Password$")
    public void userClicksOnResetPassword() {
        ResetPasswordPage resetPasswordPage = (ResetPasswordPage) context.getPage(ResetPasswordPage.class);
        resetPasswordPage.getResetButton().click();
    }

    @Then("^Branch details page has the following elements$")
    public void branchDetailsPageHasTheFollowingElements(List<String> elements) {
        BranchDetailsPage page = (BranchDetailsPage) context.getPage(BranchDetailsPage.class);
        for (String element : elements) {
            PageElements enumElement = PageElements.getByDescription(element);
            WebElement webElement = page.getElements(enumElement);
            Assert.assertEquals("Element is displayed", enumElement.getDescription(), webElement.getText().trim());
        }
    }

    @Given("^(\\d+) branches are created$")
    public void branchesAreCreated(int nrOfBranches) throws InterruptedException {
        BranchPage branchPage = (BranchPage) context.getPage(BranchPage.class);
        branchPage.createButton().click();
        branchPage.createBranches(nrOfBranches);
    }

    @Then("^user is redirected to Staff page$")
    public void userIsRedirectedToStaffPage() {
        StaffPage staffPage = (StaffPage) context.getPage(StaffPage.class);
        Assert.assertTrue("User is on page", staffPage.onThePage());
    }

    @Then("^Staff page has the following elements$")
    public void staffPageHasTheFollowingElements(List<String> elements) {
        StaffPage page = (StaffPage) context.getPage(StaffPage.class);
        for (String element : elements) {
            PageElements enumElement = PageElements.getByDescription(element);
            WebElement webElement = page.getElements(enumElement);
            Assert.assertEquals("Element is displayed", enumElement.getDescription(), webElement.getText().trim());
        }
    }

    @Given("^user navigates to Staff page$")
    public void userNavigatesToStaffPage() {
        context.getDriver().get(staffURL);
        StaffPage page = (StaffPage) context.getPage(StaffPage.class);
        Assert.assertTrue("Branch page is opened", page.onThePage());
    }

    @When("^user clicks on Create a new Staff$")
    public void userClicksOnCreateANewStaff() {
        StaffPage page = (StaffPage) context.getPage(StaffPage.class);
        page.createButton().click();
    }

    @Then("^user sets the value '(.*)' for name input$")
    public void userSetsTheValueStaffOneForNameInput(String name) {
        CreateEditStaffPopUp createStaffPopUp = (CreateEditStaffPopUp) context.getPage(CreateEditStaffPopUp.class);
        Assert.assertTrue("Pop up is opened", createStaffPopUp.onThePage());
        createStaffPopUp.staffName().sendKeys(name);
    }

    @Then("^user selects the (.*) from branch dropdown$")
    public void userSelectsBranchOneFromBranchDropdown(int nr) {
        CreateEditStaffPopUp createStaffPopUp = (CreateEditStaffPopUp) context.getPage(CreateEditStaffPopUp.class);
        createStaffPopUp.branchDropDown().click();
        List<WebElement> allValues = createStaffPopUp.getOptionsWebelements();
        Assert.assertTrue("dropdown list not empty", allValues.size() > 0);
        allValues.get(nr).click();
        String selectedElement = allValues.get(nr).getText();
        context.save(DataKeys.STAFF_BRANCH, selectedElement);
    }

    @Then("^user sets the value for name input$")
    public void userSetsTheValueForNameInput() {
        CreateEditStaffPopUp createStaffPopUp = (CreateEditStaffPopUp) context.getPage(CreateEditStaffPopUp.class);
        Assert.assertTrue("Pop up is opened", createStaffPopUp.onThePage());

        String name = ValuesGeneration.generateValue("[7alphabeticWithSpaces]");
        createStaffPopUp.staffName().sendKeys(name);
        context.save(DataKeys.STAFF_NAME, name);
    }

    @Then("^user clicks on (Save|Cancel) staff$")
    public void userClicksOnSaveStaff(String button) {
        CreateEditStaffPopUp createStaffPopUp = (CreateEditStaffPopUp) context.getPage(CreateEditStaffPopUp.class);
        if (button.equals("Save")) {
            createStaffPopUp.saveButton().click();
        } else {
            createStaffPopUp.cancelButton().click();
        }
    }

    @Then("^staff is(| not) (created|updated)$")
    public void staffIsCreated(String param, String type) {
        StaffPage staffPage = (StaffPage) context.getPage(StaffPage.class);
        String staffName = (String) context.getData(DataKeys.STAFF_NAME);
        String branchName = (String) context.getData(DataKeys.STAFF_BRANCH);
        if (param.equals(" not")) {
            Assert.assertTrue("staff is not created", !staffPage.staffIsPresent(staffName, branchName));
            Utility.takeScreenshot(context.getDriver(), "Staff is not created");
        } else {
            Assert.assertTrue("staff is created", staffPage.staffIsPresent(staffName, branchName));
            Utility.takeScreenshot(context.getDriver(), "Staff is created");
        }
    }

    @Then("^user is redirected to Staff details page$")
    public void userIsRedirectedToStaffDetailsPage() {
        StaffDetailsPage staffDetailsPage = (StaffDetailsPage) context.getPage(StaffDetailsPage.class);
        Assert.assertTrue("Staff details is opened", staffDetailsPage.onThePage());
    }

    @Then("^Staff details page has the following elements$")
    public void staffDetailsPageHasTheFollowingElements(List<String> elements) {
        StaffDetailsPage staffDetailsPage = (StaffDetailsPage) context.getPage(StaffDetailsPage.class);
        for (String element : elements) {
            PageElements enumElement = PageElements.getByDescription(element);
            WebElement webElement = staffDetailsPage.getElements(enumElement);
            Assert.assertEquals("Element is displayed", enumElement.getDescription(), webElement.getText().trim());
        }
    }

    @When("^user searches for the (\\d+) staff$")
    public void userSearchesForTheStaff(int nr) {
        StaffPage staffPage = (StaffPage) context.getPage(StaffPage.class);
        Assert.assertFalse("is displayed", staffPage.getStaffName().isEmpty());
        String staffName = staffPage.getStaffName().get(nr).getText();
        staffPage.queryInput().sendKeys(staffName);
        staffPage.searchButton().click();
        context.save(DataKeys.STAFF_NAME, staffName);
    }

    @Then("^searched staff is displayed$")
    public void searchedStaffIsDisplayed() {
        StaffPage page = (StaffPage) context.getPage(StaffPage.class);
        String staffName = (String) context.getData(DataKeys.STAFF_NAME);
        Assert.assertTrue("Searched branch is displayed", page.getStaffName(staffName).isDisplayed());
    }

    @When("^user clicks on '(.*)' on displayed Staff Pop up$")
    public void userClicksOnDeleteOnDisplayedStaffPopUp(String buttonType) {
        ConfirmationStaffPopUp confirmationPopUp = (ConfirmationStaffPopUp) context.getPage(ConfirmationStaffPopUp.class);
        Assert.assertTrue("Confirmation pop up is displayed", confirmationPopUp.onThePage());
        if (buttonType.equals("Delete")) {
            confirmationPopUp.deleteButton().click();
        } else {
            confirmationPopUp.cancelButton().click();
        }
    }

    @Then("^error message is displayed '(.*)' on Registration page$")
    public void errorMessageIsDisplayedOnRegPage(String expectedErrorMessage) {
        RegistrationPage page = (RegistrationPage) context.getPage(RegistrationPage.class);
        WebElement actualErrorMessage = page.getErrorMessage();
        Assert.assertTrue("Message is displayed", actualErrorMessage.isDisplayed());
        Assert.assertTrue("Correct message is displayed", actualErrorMessage.getText().contains(expectedErrorMessage));
        Utility.takeScreenshot(context.getDriver(), "Error message is displayed");
    }

    @Then("^validation error is displayed '(.*)' on staff pop up$")
    public void validationErrorIsDisplayedOnStaffPopUp(String message) {
        CreateEditStaffPopUp createEditStaffPopUp = (CreateEditStaffPopUp) context.getPage(CreateEditStaffPopUp.class);
        Assert.assertTrue("Pop up is opened", createEditStaffPopUp.onThePage());
        List<WebElement> errors = createEditStaffPopUp.validationErrors();
        Assert.assertFalse("is displayed", errors.isEmpty());
        String actualMessage = errors.stream().filter(p -> p.getText().equals(message)).findAny().orElse(null).getText();
        Assert.assertEquals("messages match", actualMessage, message);
        Utility.takeScreenshot(context.getDriver(), "error is displayed");
    }
}





