package com.team6.pages.orangehrmlive;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends CommonAPI {
    Logger log = LogManager.getLogger(HomepagePage.class.getName());

    public AdminPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //locators
    @FindBy(xpath = "//a[@class='oxd-main-menu-item active']")
    WebElement adminButton;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--focus']")
    WebElement userNameTextFieldAdmin;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/input[1]")
    WebElement EmployeeNameTextFieldAdmin;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[1]")
    WebElement resetButton;

    //locator for the search button
    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;

    //locator for the "No records found" message element
    @FindBy(xpath = "//*[@id=\"resultTable\"]/tbody/tr/td")
    WebElement noRecordsFoundMessage;

    @FindBy(xpath = "(//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[text()='-- Select --'])[1]")
    WebElement userRoleDropDown;

    @FindBy(xpath = "//div[contains(text(),'-- Select --')]")//
    WebElement statusDropDown;

    //Organization tab locators
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")
    WebElement orgNameField;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]")
    WebElement orgRegistrationNumField;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[2]/input[1]")
    WebElement orgTaxIdField;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[2]/input[1]")
    WebElement orgPhoneField;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[3]/div[1]/div[2]/input[1]")
    WebElement orgEmailField;

    @FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-left']")
    WebElement editButton;

    @FindBy(xpath = "//header/div[2]/nav[1]/ul[1]/li[3]/span[1]")
    WebElement orgDropDown;

    @FindBy(xpath = "//a[contains(text(),'General Information')]")
    WebElement generalInfo;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[7]/button[1]")
    WebElement generalInfosaveButton;


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

    public void userRoleDropDown() {
        clickOn(userRoleDropDown);
        userRoleDropDown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        log.info("Admin selected from dropdown");
    } // select Admin from UsersRole drop down

    public void statusDropDown() {
        clickOn(statusDropDown);
        statusDropDown.sendKeys(Keys.ARROW_DOWN, Keys.ESCAPE);
        log.info("Enable selected from dropdown");

    }

    public void organizationDropDown() {
        clickOn(orgDropDown);
        statusDropDown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        log.info("Enable selected from dropdown");

    }

    public void clearTextField(WebElement element) {
        element.clear();
    }

    public void enterOrganizaationName(String newName) {
        orgNameField.clear();
        waitFor(5);
       // orgNameField.sendKeys(newName);
    }

    public void enterRegistrationNumber(String newNumber) {
        clearTextField(orgRegistrationNumField);
        orgEmailField.sendKeys(newNumber);
    }

    public void enterTaxId(String newTaxID) {
        clearTextField(orgTaxIdField);
        orgEmailField.sendKeys(newTaxID);
    }

    public void clickOnOrganization() {
        clickOn(orgDropDown);
    }

    public void clickOngeneralInfo() {
        clickOn(generalInfo);
    }

    public void enableEdit() {
        clickOn(editButton);
        waitFor(5);
    }
    public void saveInfo(){
        clickOn(generalInfosaveButton);
    }

}

