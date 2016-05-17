package net.addressbook.selenium;

import net.addressbook.selenium.util.TestUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Valeriy on 10/5/2016.
 */
public class AddPageTest {

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
    public void addNewContactTest() {
        AddNewPage addNewPage = mainPage.clickAddNew();
        TestUtil.sleep();

        String firstName = "Asdf";
        String lastName = "Asdf";
        String addressPrim = "Asdf";
        String homeTel = "Asdf";
        String mobileTel = "Asdf";
        String workTel = "Asdf";
        String email1 = "Asdf";
        String email2 = "Asdf";
        String dayBirth = "Asdf";
        String monthBirth = "Asdf";
        String yearBirth = "Asdf";
        String group = "Asdf";
        String addressSec = "Asdf";
        String homeSecondary = "Asdf";

        addNewPage.addNewAddressBookEntry(firstName, lastName, addressPrim, homeTel, mobileTel, workTel, email1,
                email2, dayBirth, monthBirth, yearBirth, group, addressSec, homeSecondary);
    }
}
