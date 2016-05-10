package net.addressbook.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by Nostalex on 10.05.2016.
 */
public class NextBirthTest {
    private WebDriver driver;

    private MainPage mainPage;

    @Before
    public void openBrowser() {
        driver = TestUtil.initializeDriverOther("http://localhost/addressbookv4.1.4/");
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @After
    public void end() {
        driver.close();
    }

    @Test
    public void newBirthday(){
        try {
            NextBirthPage nextBirthPage = mainPage.clickNextBirthday();
            assertTrue(nextBirthPage.getBirthdaysTable() != null);
        } catch(IllegalStateException e) {
            assertTrue(false);
        }
    }
}
