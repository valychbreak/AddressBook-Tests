package net.addressbook.selenium;

import net.addressbook.selenium.util.TestUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;


public class NextBirthTest {
    private WebDriver driver;

    private MainPage mainPage;

    @Before
    public void setUp() {
        driver = TestUtil.initializeDriver();
        mainPage = PageFactory.initElements(driver, MainPage.class);
        TestUtil.sleep();
    }

    @After
    public void tearDown() {
        TestUtil.sleep();
        driver.quit();
    }

    @Test
    public void newBirthday(){
        try {
            NextBirthPage nextBirthPage = mainPage.clickNextBirthday();
            TestUtil.sleep();
            assertTrue(nextBirthPage.getBirthdaysTable() != null);
        } catch(IllegalStateException e) {
            assertTrue(false);
        }
    }
}
