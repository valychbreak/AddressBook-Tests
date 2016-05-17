package net.addressbook.selenium;

import net.addressbook.selenium.util.TestUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertTrue;


public class PrintPhonesTest {

    private WebDriver driver;
    private MainPage mainPage;


    @Before
    public void setUp() throws Exception {
        driver = TestUtil.initializeDriver();
        mainPage = PageFactory.initElements(driver, MainPage.class);
        TestUtil.sleep();
    }

    @After
    public void tearDown() throws Exception {
        TestUtil.sleep();
        driver.quit();
    }

    @Test
    public void testPrintPhones() throws Exception {
        PrintPhonesPage page = mainPage.clickPrintPhonesPage();
        TestUtil.sleep();
        assertTrue("Some users doesn't contain any number.", page.checkPhones());
    }
}
