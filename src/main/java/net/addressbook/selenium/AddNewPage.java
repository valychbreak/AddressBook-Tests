package net.addressbook.selenium;

import org.openqa.selenium.WebElement;

/**
 * Created by Nostalex on 10.05.2016.
 */
public class AddNewPage {
    WebElement firstName;
    WebElement lastName;
    WebElement addressPrimary;
    WebElement homeTel;
    WebElement mobileTel;
    WebElement workTel;
    WebElement email1;
    WebElement email2;
    WebElement dayBirth;
    WebElement monthBirth;
    WebElement yearBirth;
    WebElement group;

    WebElement addressSecondary;
    WebElement homeSecondary;

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getAddressPrimary() {
        return addressPrimary;
    }

    public WebElement getHomeTel() {
        return homeTel;
    }

    public WebElement getMobileTel() {
        return mobileTel;
    }

    public WebElement getWorkTel() {
        return workTel;
    }

    public WebElement getEmail1() {
        return email1;
    }

    public WebElement getEmail2() {
        return email2;
    }

    public WebElement getDayBirth() {
        return dayBirth;
    }

    public WebElement getMonthBirth() {
        return monthBirth;
    }

    public WebElement getYearBirth() {
        return yearBirth;
    }

    public WebElement getGroup() {
        return group;
    }

    public WebElement getAddressSecondary() {
        return addressSecondary;
    }

    public WebElement getHomeSecondary() {
        return homeSecondary;
    }
}
