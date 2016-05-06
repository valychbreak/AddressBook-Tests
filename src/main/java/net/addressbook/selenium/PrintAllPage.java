package net.addressbook.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Valeriy on 6/5/2016.
 */
public class PrintAllPage extends AbstractPage {
    @FindBy(id = "view")
    private WebElement tableView;

    public PrintAllPage(WebDriver driver) {
        super(driver);

        if(driver.findElement(By.id("view")) == null) {
            throw new IllegalStateException("This is not the Print All page!");
        }
    }

    public WebElement getTableView() {
        return tableView;
    }
}
