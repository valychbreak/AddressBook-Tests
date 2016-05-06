package net.addressbook.selenium;

import org.openqa.selenium.WebDriver;

/**
 * Created by Valeriy on 6/5/2016.
 */
public abstract class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
