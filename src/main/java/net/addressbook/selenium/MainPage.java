package net.addressbook.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class MainPage extends AbstractPage {
    @FindBy(name = "searchstring")
    private WebElement searchField;

    @FindBy(css = "#top > a:nth-child(1)")
    private WebElement extendedLanguages;

    @FindBy(css = "#nav > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)")
    private WebElement nextBirthdays;

    @FindBy(xpath = "//*[@id=\"nav\"]/ul/li[3]/a")
    private WebElement groupsLocator;

    @FindBy(xpath = "//*[@id=\"nav\"]/ul/li[6]/a")
    private WebElement printPhonesLocator;

    @FindBy(xpath = "//*[@id=\"content\"]/form[2]/div[3]/input")
    private WebElement addToGroupBtn;

    @FindBy(name = "to_group")
    private WebElement  groupSelect;
    private Select      toGroupSelect;

    @FindBy(id = "MassCB")
    private WebElement selectAllBtn;

    @FindBy(id = "maintable")
    private WebElement mainTable;

    private By searchCountLocator = By.id("search_count");

    public MainPage(WebDriver driver) {
        super(driver);

        if(!driver.getTitle().equals("Address book")) {
            throw new IllegalStateException("This is not the Main page!");
        }
    }

    public MainPage typeInSearchField(String searchString) {
        searchField.sendKeys(searchString);
        searchField.submit();
        return this;
    }

    public MainPage clearSearchField() {
        searchField.clear();
        return this;
    }

    @Override
    public MainPage goToHome() {
        driver.findElement(By.linkText("home")).click();
        return this;
    }

    public AddNewPage clickAddNew() {
        driver.findElement(By.linkText("add new")).click();
        return PageFactory.initElements(driver, AddNewPage.class);
    }

    public PrintAllPage clickPrintAll() {
        driver.findElement(By.linkText("print all")).click();
        return PageFactory.initElements(driver, PrintAllPage.class);
    }

    public NextBirthPage clickNextBirthday() {
        driver.findElement(By.linkText("next birthdays")).click();
        return PageFactory.initElements(driver, NextBirthPage.class);
    }

    public GroupsPage clickGroupsPage() {
        groupsLocator.click();
        return PageFactory.initElements(driver, GroupsPage.class);
    }

    public PrintPhonesPage clickPrintPhonesPage() {
        printPhonesLocator.click();
        return PageFactory.initElements(driver, PrintPhonesPage.class);
    }

    public void addEntriesToGroup(String groupName) {
        toGroupSelect = new Select(groupSelect);
        toGroupSelect.selectByVisibleText(groupName);
        addToGroupBtn.click();
    }

    public boolean checkAddingToGroup() {
        WebElement msgBox = driver.findElement(By.className("msgbox"));
        return msgBox.getText().contains("Users added");
    }

    public Select getToGroupSelect() {
        return toGroupSelect;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getExtendedLanguages() {
        return extendedLanguages;
    }

    public WebElement getNextBirthdays() {
        return nextBirthdays;
    }

    public By getSearchCountLocator() {
        return searchCountLocator;
    }

    public WebElement getGroupsLocator() {
        return groupsLocator;
    }

    public WebElement getMainTable() {
        return mainTable;
    }
}
