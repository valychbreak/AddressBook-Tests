package net.addressbook.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.internal.Streams;
import org.openqa.selenium.support.FindBy;


public class AddNewPage extends AbstractPage{
    @FindBy(name = "firstname")
    private WebElement firstNameLocator;

    @FindBy(name = "lastname")
    private WebElement lastNameLocator;

    @FindBy(name = "address")
    private WebElement addressPrimaryLocator;

    @FindBy(name = "home")
    private WebElement homeTelLocator;

    @FindBy(name = "mobile")
    private WebElement mobileTelLocator;

    @FindBy(name = "work")
    private WebElement workTelLocator;

    @FindBy(name = "email")
    private WebElement email1Locator;

    @FindBy(name = "email2")
    private WebElement email2Locator;

    @FindBy(name = "bday")
    private WebElement dayBirthLocator;

    @FindBy(name = "bmonth")
    private WebElement monthBirthLocator;

    @FindBy(name = "byear")
    private WebElement yearBirthLocator;

    @FindBy(name = "new_group")
    private WebElement groupLocator;

    @FindBy(name = "address2")
    private WebElement addressSecondaryLocator;

    @FindBy(name = "phone2")
    private WebElement homeSecondaryLocator;

    @FindBy(name = "submit")
    private WebElement submitBtn;


    public AddNewPage(WebDriver driver) {
        super(driver);

        if(driver.findElement(By.name("work")) == null) {
            throw new IllegalStateException("This is not Adding page!");
        }
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

        /*
        dayBirthLocator.clear();
        dayBirthLocator.sendKeys(dayBirth);

        monthBirthLocator.clear();
        monthBirthLocator.sendKeys(monthBirth);

        yearBirthLocator.clear();
        yearBirthLocator.sendKeys(yearBirth);

        groupLocator.clear();
        groupLocator.sendKeys(group);
        */
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

        submitBtn.click();
    }

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

    public WebElement getSubmitBtn() {
        return submitBtn;
    }
}