package net.addressbook.selenium;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by Valeriy on 6/5/2016.
 */
public class TestsByBryliov {
    private WebDriver driver;

    private MainPage mainPage;

    @Before
    public void openBrowser() {
        driver = TestUtil.initializeDriver("http://localhost/addressbookv4.1.4/");
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @After
    public void end() {
        driver.close();
    }

    /**
     * Checks whether the result value of "Number of results:" is greater than 0
     * @throws IOException
     */
    @Test
    public void searchResultGreaterThenZero() throws IOException {
        try {
            File dataFile = new TestDataManager().getDataFile();
            FileInputStream file = new FileInputStream(dataFile);

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(TestDataManager.SEARCH_FIELD_DATA_SHEET);

            for (Row row : sheet) {
                mainPage.clearSearchField();
                this.checkSearchResult(row.getCell(0).getStringCellValue());
            }
        } catch(Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    private void checkSearchResult(String str) throws Exception {
        mainPage.typeInSearchField("Nig");
        WebElement searchCount = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(mainPage.getSearchCountLocator()));
        if(Integer.parseInt(searchCount.getText()) == 0) {
            throw new Exception("Result counter equals to 0.");
        }
    }

    /**
     * Checks "print all" link on working
     */
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
