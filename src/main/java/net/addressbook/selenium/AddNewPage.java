package net.addressbook.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.internal.Streams;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Nostalex on 10.05.2016.
 */
public class AddNewPage extends AbstractPage{

    public AddNewPage(WebDriver driver) {
        super(driver);

        if(driver.findElement(By.id("work")) == null) {
            throw new IllegalStateException("This is not Adding page!");
        }
    }

    @FindBy(name = "firstname")
    WebElement firstNameLocator;

    @FindBy(name = "lastname")
    WebElement lastNameLocator;

    @FindBy(name = "address")
    WebElement addressPrimaryLocator;

    @FindBy(name = "home")
    WebElement homeTelLocator;

    @FindBy(name = "mobile")
    WebElement mobileTelLocator;

    @FindBy(name = "work")
    WebElement workTelLocator;

    @FindBy(name = "email")
    WebElement email1Locator;

    @FindBy(name = "email2")
    WebElement email2Locator;

    @FindBy(name = "bday")
    WebElement dayBirthLocator;

    @FindBy(name = "bmonth")
    WebElement monthBirthLocator;

    @FindBy(name = "byear")
    WebElement yearBirthLocator;

    @FindBy(name = "new_group")
    WebElement groupLocator;


    @FindBy(name = "address2")
    WebElement addressSecondaryLocator;

    @FindBy(name = "phone2")
    WebElement homeSecondaryLocator;


    public WebElement getFirstNameLocator() {
        return firstNameLocator;
    }

    public WebElement getLastNameLocator() {
        return lastNameLocator;
    }

    public WebElement getAddressPrimaryLocator() {
        return addressPrimaryLocator;
    }

    public WebElement getHomeTelLocator() {
        return homeTelLocator;
    }

    public WebElement getMobileTelLocator() {
        return mobileTelLocator;
    }

    public WebElement getWorkTelLocator() {
        return workTelLocator;
    }

    public WebElement getEmail1Locator() {
        return email1Locator;
    }

    public WebElement getEmail2Locator() {
        return email2Locator;
    }

    public WebElement getDayBirthLocator() {
        return dayBirthLocator;
    }

    public WebElement getMonthBirthLocator() {
        return monthBirthLocator;
    }

    public WebElement getYearBirthLocator() {
        return yearBirthLocator;
    }

    public WebElement getGroupLocator() {
        return groupLocator;
    }

    public WebElement getAddressSecondaryLocator() {
        return addressSecondaryLocator;
    }

    public WebElement getHomeSecondaryLocator() {
        return homeSecondaryLocator;
    }

    public void addNewAddressBookEntry(String firstName, String lastName, String addressPrimary,
                                       String homeTel, String mobileTel, String workTel, String email1, String email2,
                                       String dayBirth, String monthBirth, String yearBirth, String group)
    {
        firstNameLocator.clear();
        firstNameLocator.sendKeys(firstName);

        lastNameLocator.clear();
        lastNameLocator.sendKeys(lastName);

        addressPrimaryLocator.clear();
        addressPrimaryLocator.sendKeys(addressPrimary);

        homeTelLocator.clear();
        homeTelLocator.sendKeys(homeTel);

        mobileTelLocator.clear();
        mobileTelLocator.sendKeys(mobileTel);

        workTelLocator.clear();
        workTelLocator.sendKeys(workTel);

        email1Locator.clear();
        email1Locator.sendKeys(email1);

        email2Locator.clear();
        email2Locator.sendKeys(email2);

        dayBirthLocator.clear();
        dayBirthLocator.sendKeys(dayBirth);

        monthBirthLocator.clear();
        monthBirthLocator.sendKeys(monthBirth);

        yearBirthLocator.clear();
        yearBirthLocator.sendKeys(yearBirth);

        groupLocator.clear();
        groupLocator.sendKeys(group);
    }

    public void addNewAddressBookEntry(String firstName, String lastName, String addressPrimary,
                                       String homeTel, String mobileTel, String workTel, String email1, String email2,
                                       String dayBirth, String monthBirth, String yearBirth, String group,
                                       String addressSecondary, String homeSecondary)
    {
        addNewAddressBookEntry(firstName, lastName,addressPrimary, homeTel, mobileTel, workTel, email1, email2, dayBirth,
                monthBirth, yearBirth, group);

        addressSecondaryLocator.clear();
        addressSecondaryLocator.sendKeys(addressSecondary);

        homeSecondaryLocator.clear();
        homeSecondaryLocator.sendKeys(homeSecondary);
    }
}