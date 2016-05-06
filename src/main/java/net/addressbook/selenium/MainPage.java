package net.addressbook.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Valeriy on 6/5/2016.
 */
public class MainPage extends AbstractPage {
    @FindBy(name = "searchstring")
    private WebElement searchField;

    private By searchCountLocator = By.id("search_count");

    public MainPage(WebDriver driver) {
        super(driver);

        if(!driver.getTitle().equals("Address book")) {
            throw new IllegalStateException("This is not the Main page!");
        }
    }

    public MainPage typeInSearchFile(String searchString) {
        searchField.sendKeys(searchString);
        searchField.submit();
        return this;
    }

    public MainPage goToMain() {
        driver.findElement(By.linkText("home")).click();
        return this;
    }

    public PrintAllPage clickPrintAll() {
        driver.findElement(By.linkText("print all")).click();
        return PageFactory.initElements(driver, PrintAllPage.class);
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public By getSearchCountLocator() {
        return searchCountLocator;
    }
}
