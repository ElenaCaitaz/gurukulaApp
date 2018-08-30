package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Utility {

    public static void takeScreenshot(WebDriver webDriver, String name) {
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
            File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./screenshot/"+ name +".png"));
        } catch (Exception e) {
            System.out.println("Exception when taking screenshot" + e.getMessage());
        }
    }
}
