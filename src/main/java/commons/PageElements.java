package commons;

import java.util.Arrays;

public enum PageElements {
    LOGIN("login"),
    REGISTER_A_NEW_ACCOUNT("Register a new account"),
    ACCOUNT("Account"),
    HOME("Home"),
    ENTITIES("Entities"),
    LOGIN_LABEL("Login"),
    EMAIL("E-mail"),
    NEW_PASSWORD("New password"),
    NEW_PASSWORD_CONFIRMATION("New password confirmation"),
    REGISTER("Register"),
    CREATE_A_NEW_BRANCH("Create a new Branch"),
    SEARCH_A_BRANCH("Search a Branch"),
    NAME("Name"),
    CODE("Code"),
    BACK("Back"),
    CREATE_A_NEW_STAFF("Create a new Staff"),
    SEARCH_A_STAFF("Search a Staff"),
    BRANCH("Branch");

    private final String description;

    PageElements(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static PageElements getByDescription(String description) {
        return Arrays.stream(PageElements.values()).filter(r -> r.getDescription().equals(description)).findFirst().orElse(null);
    }
}
