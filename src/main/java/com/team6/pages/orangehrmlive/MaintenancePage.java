package com.team6.pages.orangehrmlive;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MaintenancePage extends CommonAPI {
    Logger log = LogManager.getLogger(LoginPage.class.getName());

    public MaintenancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //locators
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
    WebElement usernameField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
    public WebElement passwordField;

    @FindBy(css = "#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(10) > a")
    WebElement maintenance;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/form/div[3]/div/div[2]/input")
    WebElement passFieldMaintence;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/form[1]/div[4]/button[2]")
    WebElement confirmButtonMaintenance;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/h6[1]")
    WebElement maintenanceHeaderText;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/form[1]/div[2]/div[1]/p[1]")
    WebElement invalidCredentialsText;

    @FindBy(xpath = "//a[contains(text(),'Access Records')]")
    WebElement accessRecordButton;

    @FindBy(xpath = "//input[@placeholder=\"Type for hints...\"]")
    WebElement EmployeeNameHintField;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/form[1]/div[2]/button[1]")
    WebElement searchButton;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[2]/div[1]/form[1]/div[2]/button[1]")
    WebElement downloadButton;

    @FindBy(xpath = "//header/div[2]/nav[1]/ul[1]/li[1]")
    WebElement purgeRecordsDropdown;

    @FindBy(xpath = "//a[contains(text(),'Candidate Records')]")
    WebElement candidateRecords;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchByJobTitle;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement vacancyTextfield;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span']")
    WebElement searchResult;

    @FindBy(xpath = "//button[normalize-space()='Purge All']")
    WebElement purgeAll;

    @FindBy(xpath = "//button[normalize-space()='Yes, Purge']")
    WebElement confirmPurge;


    // methods

    public void clickMaintenance() {
        clickOn(maintenance);
        log.info("Click on maintenance enter Success");
    }

    public void enterPassForMaintenance(String password) {
        passFieldMaintence.sendKeys(password);
        log.info("Enter password for maintenance tab Success");
    }

    public void clickConfirm() {
        confirmButtonMaintenance.click();
        log.info("Click on confirm button Success");
    }

    public String maintenanceHeaderText() {
        return maintenanceHeaderText.getText().toLowerCase();
    }

    public boolean showDenyMessage() {
        return invalidCredentialsText.isDisplayed();
    }

    public void clickOnAccessRecords() {
        clickOn(accessRecordButton);
    }

    public void enterHints(String initials) {

        EmployeeNameHintField.sendKeys(initials);
        waitFor(2);
        EmployeeNameHintField.sendKeys(Keys.DOWN);
        EmployeeNameHintField.sendKeys(Keys.RETURN);
        waitFor(2);
    }

    public void clickSearch() {
        clickOn(searchButton);
        waitFor(3);
    }

    public void downloadRecords() {
        waitFor(3);
        clickOn(downloadButton);
    }

    public void clickOnPurgeRecordsMenu() {
        clickOn(purgeRecordsDropdown);
    }

    public void clickOncandidateRecords() {
        clickOn(candidateRecords);
    }

    public void selectCandidateRoleByName(String jobTitile) {
        vacancyTextfield.sendKeys(jobTitile);
        waitFor(3);
        vacancyTextfield.sendKeys(Keys.DOWN);
        waitFor(3);
        vacancyTextfield.sendKeys(Keys.RETURN);
    }

    public void clickSearchByJobTitle() {
        clickOn(searchByJobTitle);
    }

    public boolean purgeIfRecordsFound() {
        if (purgeAll.isDisplayed()) {
            clickOn(purgeAll);
            clickOn(confirmPurge);
            log.info("Records found, Purge Confirmed");
            return true;
        } else {
            log.info("No records found");
            return false;
        }


    }


}

//No Records Found