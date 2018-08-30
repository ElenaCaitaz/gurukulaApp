package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static PropertyManager instance;
    private static String url;
    private static String loginUrl;
    private static String registerUrl;
    private static String branchUrl;
    private static String staffUrl;

    public static PropertyManager getInstance() {
        if (instance == null) {
            instance = new PropertyManager();
            instance.loadData();
        }
        return instance;
    }

    private void loadData() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src\\main\\resources\\config.properties"));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
        url = prop.getProperty("url");
        loginUrl = prop.getProperty("login.url");
        registerUrl = prop.getProperty("register.url");
        branchUrl = prop.getProperty("branch.url");
        staffUrl = prop.getProperty("staff.url");
    }

    public String getURL() {
        return url;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public String getRegisterUrl() {
        return registerUrl;
    }

    public String getBranchUrl() {
        return branchUrl;
    }

    public String getStaffUrl() {
        return staffUrl;
    }
}
