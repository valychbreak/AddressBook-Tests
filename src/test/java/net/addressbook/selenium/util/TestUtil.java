package net.addressbook.selenium.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

/**
 * Created by Valeriy on 6/5/2016.
 */
public class TestUtil {
    public static WebDriver initializeDriver() {
        return initializeDriver("http://localhost/addressbookv4.1.4/");
    }

    public static WebDriver initializeDriver(String url) {
        WebDriver driver = new FirefoxDriver();
        driver.get(url);
        return driver;
    }
}
