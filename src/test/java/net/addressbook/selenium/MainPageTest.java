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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.assertTrue;


public class MainPageTest {
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
}
