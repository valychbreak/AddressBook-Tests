package net.addressbook.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by strel on 10.05.2016.
 */
public class PrintPhonesTest {

    private WebDriver driver;
    private MainPage mainPage;


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.get("http://localhost/addressbook/");

        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testPrintPhones() throws Exception {
        PrintPhonesPage page = mainPage.clickPrintPhonesPage();
        assertTrue("Some users doesn't contain any number.", page.checkPhones());
    }
}
