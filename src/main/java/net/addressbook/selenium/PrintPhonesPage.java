package net.addressbook.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class PrintPhonesPage extends AbstractPage {
    public PrintPhonesPage(WebDriver driver) {
        super(driver);

        WebElement header = driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/h1"));
        if (header == null || !"Address book".equals(header.getText()) || driver.findElement(By.id("view")) == null) {
            throw new IllegalStateException("This is not Print Phones page.");
        }
    }

    public boolean checkPhones() {
        List<WebElement> users = driver.findElements(By.cssSelector("#view > tbody > tr > td"));
        for (WebElement user : users) {
            if (!user.getText().matches("(H:|M:|W:)"))
                return false;
        }

        return true;
    }
}
