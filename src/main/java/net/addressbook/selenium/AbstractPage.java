package net.addressbook.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage goToHome() {
        driver.get("http://localhost/addressbookv4.1.4/");
        return PageFactory.initElements(driver, MainPage.class);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
