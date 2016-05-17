package net.addressbook.selenium;

import net.addressbook.selenium.util.TestUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


public class LanguageTest {
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
        driver.close();
    }

    @Test
    public void ensure() {
        mainPage.getExtendedLanguages().click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        TestUtil.sleep();

        WebElement current_language = driver.findElement(By.cssSelector("#top > a:nth-child(18) > img:nth-child(1)"));
        current_language.click();
        TestUtil.sleep();

        WebElement assureHome = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#nav > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")));
        TestUtil.sleep();
        
        assertTrue(!assureHome.getText().equals("home"));
    }
}
