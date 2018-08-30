package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenu extends PageObject{

    @FindBy(xpath = "//ul/li[3]/a/span/span[2]")
    private WebElement accountDropdown;

    @FindBy(xpath = "//ul/li[2]/a/span/span[2]")
    private WebElement entitiesDropdown;

    @FindBy(xpath = "//ul/li[2]/ul/li[1]/a")
    private WebElement branch;

    @FindBy(xpath = "//li[2]/ul/li[2]/a/span[2]")
    private WebElement staff;

    @FindBy(xpath = "//ul/li[3]/ul/li[4]/a")
    private WebElement logout;

    public WebElement logoutButton() {
        return logout;
    }

    public WebElement accountDropdown() {
        return accountDropdown;
    }

    public WebElement entitiesDropdown() {
        return entitiesDropdown;
    }

    public WebElement branch() {
        return branch;
    }

    public WebElement staff() {
        return staff;
    }
}
