package net.addressbook.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class NextBirthPage extends AbstractPage {
    @FindBy(id = "birthdays")
    private WebElement birthdaysTable;

    public NextBirthPage(WebDriver driver) {
        super(driver);

        if(driver.findElement(By.id("birthdays")) == null) {
            throw new IllegalStateException("This is not Next Birthdays page!");
        }
    }

    public WebElement getBirthdaysTable() {
        return birthdaysTable;
    }
}
