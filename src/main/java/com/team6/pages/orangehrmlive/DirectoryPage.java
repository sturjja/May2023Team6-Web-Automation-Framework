package com.team6.pages.orangehrmlive;


import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DirectoryPage extends CommonAPI {
    Logger log = LogManager.getLogger(HomepagePage.class.getName());

    public DirectoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeNameHintField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-directory-card-subtitle --break-words']")
    WebElement directoryCard;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-directory-card-header --break-words']")
    WebElement ceoNameCard;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-directory-card-header --break-words']")
    WebElement cfoNameCard;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[6]/div[1]/p[2]")
    WebElement ctoEmailAddress;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]")
    WebElement jobTitleDropdown;

    @FindBy(xpath = "//span[contains(text(),'Account Assistant')]")
    WebElement accountAssistant;

    @FindBy(xpath = "//span[contains(text(),'Chief Financial Officer')]")
    WebElement CEO;

    @FindBy(xpath = "//span[contains(text(),'Chief Financial Officer')]")
    WebElement CFO;


    //methods

    public void enterHints(String initials) {

        employeeNameHintField.sendKeys(initials);
        waitFor(1);
        employeeNameHintField.sendKeys(Keys.DOWN);
        employeeNameHintField.sendKeys(Keys.RETURN);
        waitFor(1);
    }

    public void clickSearch() {
        clickOn(searchButton);
        waitFor(2);
    }

    public String checkCeoName() {
        clickOn(ceoNameCard);
        return getElementText(ceoNameCard);
    }

    public String checkCfoName() {
        return getElementText(cfoNameCard);
    }

    public String checkCtoEmailAddress() {
        clickOn(cfoNameCard);
        return ctoEmailAddress.getText();


    }

    public void clickJobTitleDropDown() {
        jobTitleDropdown.click();
        accountAssistant.click();
    }
}
