package net.addressbook.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GroupsPage extends AbstractPage {

    @FindBy(name = "new")
    private WebElement newGroup;


    @FindBy(name = "group_name")
    private WebElement groupNameField;

    @FindBy(name = "group_header")
    private WebElement groupHeaderField;

    @FindBy(name = "group_footer")
    private WebElement groupFooterField;

    @FindBy(name = "submit")
    private WebElement submitBtn;


    @FindBy(className = "msgbox")
    private WebElement msgBox;

    @FindBy(xpath = "//*[@id=\"content\"]/div/i/a")
    private WebElement returnHref;


    @FindBy(xpath = "//*[@id=\"content\"]/form[2]")
    private WebElement groupsForm;


    public GroupsPage(WebDriver driver) {
        super(driver);

        // WebElement newGroup = driver.findElement(By.name("new"));
        PageFactory.initElements(driver, this);
        if (newGroup == null || !"New group".equals(newGroup.getAttribute("value"))) {
            throw new IllegalStateException("This is not add Groups page.");
        }
    }

    public WebElement getNewGroupBtn() {
        return newGroup;
    }

    public void clickNewGroupBtn() {
        newGroup.click();
    }

    public void addNewGroup(String name, String header, String footer) {
        groupNameField.clear();
        groupNameField.sendKeys(name);

        groupHeaderField.clear();
        groupHeaderField.sendKeys(header);

        groupFooterField.clear();
        groupFooterField.sendKeys(footer);

        submitBtn.click();
    }

    public boolean checkResult(String grpName) {
        boolean result = msgBox.isDisplayed() && msgBox.getText().contains("A new group has been entered into the address book");
        returnHref.click();
        return result && groupsForm.getText().contains(grpName);
    }
}
