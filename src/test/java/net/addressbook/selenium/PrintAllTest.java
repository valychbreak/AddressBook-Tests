package net.addressbook.selenium;

import net.addressbook.selenium.util.TestUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

/**
 * Created by Valeriy on 10/5/2016.
 */
public class PrintAllTest {

    private WebDriver driver;
    private MainPage mainPage;


    @Before
    public void setUp() throws Exception {
        driver = TestUtil.initializeDriver();
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void printAllPrintsAllContacts() {
        try {
            PrintAllPage printAllPage = mainPage.clickPrintAll();
            assertTrue(printAllPage.getTableView() != null);
        } catch(IllegalStateException e) {
            assertTrue(false);
        }
    }
}
