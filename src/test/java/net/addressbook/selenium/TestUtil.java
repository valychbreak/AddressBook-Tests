package net.addressbook.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

/**
 * Created by Valeriy on 6/5/2016.
 */
public class TestUtil {
    public static WebDriver initializeDriver(String url) {
        File pathToBinary = new File("D:\\Programs\\Mozilla Firefox\\firefox.exe");
        FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        WebDriver driver = new FirefoxDriver(ffBinary,firefoxProfile);
        driver.get(url);
        return driver;
    }
}
