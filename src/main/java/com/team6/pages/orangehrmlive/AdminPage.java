package com.team6.pages.orangehrmlive;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends CommonAPI {
    Logger log = LogManager.getLogger(HomePage.class.getName());

    public AdminPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //locators
    @FindBy(xpath = "//a[@class='oxd-main-menu-item active']")
    WebElement adminButton;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--focus']")
    WebElement userNameTextFieldAdmin;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/input")
    WebElement EmployeeNameTextFieldAdmin;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[1]")
    WebElement resetButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]")
    WebElement blankElement;

    //locator for the search button
    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;

    //locator for the "No records found" message element
    @FindBy(xpath = "//*[@id=\"resultTable\"]/tbody/tr/td")
    WebElement noRecordsFoundMessage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")
    WebElement RecordFound;


    private void waitFor(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            log.error("InterruptedException occurred while waiting", e);
        }
    }

    public void enterUsernameAndEmployeeName(String userName, String employeeName) {
        userNameTextFieldAdmin.sendKeys(userName);
        EmployeeNameTextFieldAdmin.sendKeys(employeeName);
        log.info("Username and Employee Name enter Success");
    }

    public void enterUsernameAndEmployeeName(String userName) {
        userNameTextFieldAdmin.sendKeys(userName);
        log.info("Username enter Success");

    }

    public void clickResetButton() {
        resetButton.click();
        waitFor(5);
        log.info("Click on reset button success");

    }

    public void clickOnAdmin() {
        adminButton.click();
        log.info("click on Admin button Success");
    }

    public boolean verifyTextBoxEmpty() {
        log.info("Text field empty verification success");
        return userNameTextFieldAdmin.getText().isEmpty() || EmployeeNameTextFieldAdmin.getText().isEmpty();


    }

    public void clearUserNameandPasword() {
        if (!verifyTextBoxEmpty()) {
            userNameTextFieldAdmin.clear();
            EmployeeNameTextFieldAdmin.clear();
        }
        log.info("Text field clear success");

    }

    public void clickSearchButton() {
        clickOn(searchButton);
        waitFor(3);
        log.info("Click on search button success");

    }

    public boolean isNoRecordsFoundMessageDisplayed() {
        log.info("No records found message displayed");

        return noRecordsFoundMessage.isDisplayed();
    }

}
