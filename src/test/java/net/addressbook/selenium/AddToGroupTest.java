package net.addressbook.selenium;

import net.addressbook.selenium.util.TestUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static junit.framework.TestCase.assertTrue;


/**
 * Created by strel on 10.05.2016.
 */
public class AddToGroupTest {

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
    public void testAddToGroup() throws Exception {
        mainPage.addEntriesToGroup("Slayer");
        assertTrue(mainPage.checkAddingToGroup());
    }
}
