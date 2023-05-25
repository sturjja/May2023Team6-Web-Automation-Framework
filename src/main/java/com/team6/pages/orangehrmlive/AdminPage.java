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
    @FindBy(css = "#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(1) > a")
    WebElement adminButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
    WebElement userNameTextFieldAdmin;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/input")
    WebElement EmployeeNameTextFieldAdmin;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[1]")
    WebElement resetButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]")
    WebElement blankElement;

    //locator for the search button
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
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
    }

    public void enterUsernameAndEmployeeName(String userName) {
        userNameTextFieldAdmin.sendKeys(userName);
    }


    public void clickResetButton() {
        resetButton.click();
        waitFor(5);
    }

    public void clickOnAdmin() {
        adminButton.click();
    }

    public boolean verifyTextBoxEmpty() {
        return userNameTextFieldAdmin.getText().isEmpty() || EmployeeNameTextFieldAdmin.getText().isEmpty();
    }

    public void clickSearchButton() {
        clickOn(searchButton);
        waitFor(2000); // Adjust the wait
    }


    // Add the isNoRecordsFoundMessageDisplayed method
    public boolean isNoRecordsFoundMessageDisplayed() {
        return noRecordsFoundMessage.isDisplayed() && noRecordsFoundMessage.getText().equals("No Records Found");
    }
}
