package net.addressbook.selenium;

import net.addressbook.selenium.util.TestUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;


public class GroupTest {

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
    public void testAddGroup() throws Exception {
        GroupsPage page = mainPage.clickGroupsPage();
        TestUtil.sleep();
        page.clickNewGroupBtn();
        TestUtil.sleep();
        page.addNewGroup("Slayer", "Thrash Metal", "Obey your Lord Mephisto!");
        TestUtil.sleep();
        assertTrue(page.checkResult("Slayer"));
    }
}
