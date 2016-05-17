package net.addressbook.selenium;

import net.addressbook.selenium.util.TestDataManager;
import net.addressbook.selenium.util.TestUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import sun.applet.Main;

import java.io.File;
import java.io.FileInputStream;


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

        try {
            File dataFile = new TestDataManager().getDataFile();
            FileInputStream file = new FileInputStream(dataFile);

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(TestDataManager.ADD_NEW_DATA_SHEET);

            boolean isFirstRow = true;
            for (Row row : sheet) {
                // Skip column headers
                if(isFirstRow) {
                    isFirstRow = false;
                    continue;
                }

                String firstName = row.getCell(0).getStringCellValue();
                String lastName = row.getCell(1).getStringCellValue();
                String addressPrim = row.getCell(2).getStringCellValue();
                String homeTel = row.getCell(3).getStringCellValue();
                String mobileTel = row.getCell(4).getStringCellValue();
                String workTel = row.getCell(5).getStringCellValue();
                String email1 = row.getCell(6).getStringCellValue();
                String email2 = row.getCell(7).getStringCellValue();
                String dayBirth = row.getCell(8).getStringCellValue();
                String monthBirth = row.getCell(9).getStringCellValue();
                String yearBirth = row.getCell(10).getStringCellValue();
                String group = row.getCell(11).getStringCellValue();
                String addressSec = row.getCell(12).getStringCellValue();
                String homeSecondary = row.getCell(13).getStringCellValue();

                addNewPage.addNewAddressBookEntry(firstName, lastName, addressPrim, homeTel, mobileTel, workTel, email1,
                        email2, dayBirth, monthBirth, yearBirth, group, addressSec, homeSecondary);

                this.mainPage = addNewPage.goToHome();

                Assert.assertTrue(this.mainPage.getMainTable().getText().contains(firstName));
            }
        } catch(Exception e) {
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }
}
