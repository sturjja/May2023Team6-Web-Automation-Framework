package com.team6.pages.orangehrmlive;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PimPage extends CommonAPI {
    Logger log = LogManager.getLogger(HomepagePage.class.getName());

    public PimPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //locators
    @FindBy(xpath = "//a[normalize-space()='']")
    WebElement PIM;

    @FindBy(css = "div.oxd-layout div.oxd-layout-container div.oxd-layout-context div.orangehrm-background-container div.orangehrm-paper-container:nth-child(3) div.orangehrm-container:nth-child(3) div.oxd-table.orangehrm-employee-list div.oxd-table-header div.oxd-table-row.oxd-table-row--with-border div.oxd-table-header-cell.oxd-padding-cell.oxd-table-th:nth-child(1) div.oxd-checkbox-wrapper label:nth-child(1) span.oxd-checkbox-input.oxd-checkbox-input--active.--label-right.oxd-checkbox-input:nth-child(2) > i.oxd-icon.bi-check.oxd-checkbox-input-icon")
    WebElement selectAllEmployees;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div/button")
    WebElement deleteSelected;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")
    WebElement confirmDeleteRecords;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/button[1]")
    WebElement addEmployeeBtn;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input")
    WebElement firstNameField;

    @FindBy(name = "lastName")
    WebElement lastNameField;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/input[1]")
    WebElement employeeIdField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")
    WebElement saveButton;

    @FindBy(xpath = "//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']")
    WebElement ToastMessageText;


    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div[1]/h6")
    WebElement firstNameLastName;


    //Employee details locators
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[2]/div[1]/div[1]/div[2]/input[1]")
    WebElement driversLicenseID;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[2]/div[1]/div[1]/div[2]/input[1]")
    WebElement SSNnumber;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[3]/div[2]/div[1]/div[2]/input[1]")
    WebElement SINnumber;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/label[1]/span[1]")
    WebElement genderMale;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/label[1]/span[1]")
    WebElement genderFemale;

    @FindBy(xpath = "//div[@class='oxd-select-text-input']")
    WebElement nationalityDropdown;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/label[1]/span[1]/i[1]")
    WebElement smoker;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[2]/input[1]")
    WebElement militaryService;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[5]/button[1]")
    WebElement savePersonalInfo;


    //methods
    public void clickOnPIM() {
        PIM.click();
        waitFor(5);
        log.info("Click on PIM tab Success");

    }

    public void SelectAll() {
        clickOn(selectAllEmployees);
        log.info("Select all employees Success");
    }

    public void clickOnDelete() {
        clickOn(deleteSelected);
        waitFor(5);
        log.info("Click on delete success");

    }

    public boolean confirmDelete() {
        waitFor(3);
        clickOn(confirmDeleteRecords);
        log.info("Delete confirmation success");
        return true;
    }

    public void clickAddEmployeeButton() {
        clickOn(addEmployeeBtn);
        log.info("Add Employee Success");

    }

    //Personal info page methods
    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        log.info("Enter first name Success");

    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        log.info("Enter last name Success");

    }

    public void enterEmployeeID(String id) {
        ClearText(employeeIdField);
        employeeIdField.sendKeys(id);

    }

    public void clickSaveButton() {
        saveButton.click();
        waitFor(5);
        log.info("Click on save button Success");
    }


    public void enterSSN(String ssn) {
        SSNnumber.sendKeys(ssn);
    }

    public void enterSIN(String sin) {
        SINnumber.sendKeys(sin);
    }

    public void enterDriversID(String driverID) {
        driversLicenseID.sendKeys(driverID);
    }

    public void enterMilitaryBranch(String branch) {
        militaryService.sendKeys(branch);
    }

    //Radio buttons
    public void selectGender(String sex) {
        if (sex.equalsIgnoreCase("Male")) {
            genderMale.click();
        } else if (sex.equalsIgnoreCase("Female")) {
            genderFemale.click();
        }
    }

    public void smokeerCheckbox(String YesNo) {
        if (YesNo.equalsIgnoreCase("Yes")) {
            smoker.click();
        }
    }
    public void clickSaveInfo(){
        savePersonalInfo.click();
    }

    public void ClearText(WebElement element) {
        int length = element.getAttribute("value").length();
        for (int i = 0; i < length; i++) {
            employeeIdField.sendKeys(Keys.BACK_SPACE);
        }
    }


    public String showsFirstAndLastName() {
        return firstNameLastName.getText();

    }

    public String getToastMessage() {
        String toastMessage = ToastMessageText.getText();
        log.info("Toast message successfully captured");

        return toastMessage;
    }

}
