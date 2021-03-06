package net.addressbook.selenium;

import net.addressbook.selenium.util.TestDataManager;
import net.addressbook.selenium.util.TestUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.assertTrue;


public class PrintAllTest {

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
    public void printAllPrintsAllContacts() {
        try {
            PrintAllPage printAllPage = mainPage.clickPrintAll();
            TestUtil.sleep();

            File dataFile = new TestDataManager().getDataFile();
            FileInputStream file = new FileInputStream(dataFile);

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(TestDataManager.PRINT_ALL_CHECK_DATA_SHEET);

            String tableContent = printAllPage.getTableView().getText();
            for (Row row : sheet) {
                if(!tableContent.contains(row.getCell(0).getStringCellValue())) {
                    throw new IOException("Not all names were found.");
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }
}
