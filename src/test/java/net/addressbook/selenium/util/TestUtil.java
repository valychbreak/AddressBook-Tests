package net.addressbook.selenium.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;


public class TestUtil {
    public static final String WEBSITE_LINK = "http://localhost/addressbookv4.1.4/";


    public static WebDriver initializeDriver() {
        return initializeDriver(WEBSITE_LINK);
    }

    public static WebDriver initializeDriver(String url) {
        WebDriver driver = new FirefoxDriver();
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void sleep() {
        sleep(3000);
    }
}
