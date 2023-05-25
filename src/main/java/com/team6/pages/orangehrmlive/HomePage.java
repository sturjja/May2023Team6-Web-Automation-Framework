package com.team6.pages.orangehrmlive;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends CommonAPI {
    Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //locators
    @FindBy(xpath = "//span[contains(text(),'Products')]")
    WebElement mainHeader;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/button")
    WebElement sideBarMenu;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")
    WebElement logoutLink;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")
    WebElement adminText;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[3]/div/div[2]/div/div[2]/button/svg")
    WebElement leaveList;

    @FindBy(css = "#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(1) > a")
    WebElement adminButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
    WebElement userNameTextFieldAdmin;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/input")
    WebElement EmployeeNameTextFieldAdmin;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[1]")
    WebElement resetButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span")
    WebElement accountButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[3]/div/div[1]/div/p")
    WebElement quickLaunchText;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/button")
    WebElement AssignLeaveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div/div[2]/div/div[1]")
    WebElement leaveRequest;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[2]/a")
    WebElement SupportButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div/div[2]/p[2]")
    WebElement SupportText;
    // maintanancePage
    @FindBy(css = "#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(10) > a")
    WebElement maintenance;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/form/div[3]/div/div[2]/input")
    WebElement passFieldMaintence;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/form/div[4]/button[2]")
    WebElement confirmButtonMaintenance;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/h6")
    WebElement purgeText;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/form/div[2]/div[1]/p")
    WebElement invalidCredentials;

    @FindBy(css = "#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(2) > a")
    WebElement PIM;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[1]/div/label/span")
    WebElement selectAllEmployees;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div/button")
    WebElement deleteSelected;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")
    WebElement confirmDeleteRecords;

    //Leave
    @FindBy(css = "#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(3) > a")
    WebElement Leave;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div[1]/div/div[1]/div/label")
    WebElement selectAllPendingLeaveRequest;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/div/button[1]")
    WebElement approveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")
    WebElement confirmApprove;

    @FindBy(xpath = "//span[text()='Admin']")
    WebElement admin;

    @FindBy(xpath = "//li[@class='oxd-main-menu-item-wrapper']")
    List<WebElement> optionsList;

    @FindBy(css = ".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module")
    WebElement FieldConfi;

    private void waitFor(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            log.error("InterruptedException occurred while waiting", e);
        }
    }

    public void clickOnLeave() {
        clickOn(Leave);
    }

    public void selectPendingApprovals() {
        selectAllPendingLeaveRequest.click();
    }

    public void approve() {
        waitFor(2);
        approveButton.click();
        waitFor(2);
        confirmApprove.click();
    }

    public void reject() {

    }

    public void clickOnSidebarMenuIcon() {
        waitFor(5000);
        clickOn(sideBarMenu);

    }

    public void clickMaintenance() {
        clickOn(maintenance);
    }

    public void enterPassForMaintenance(String password) {
        passFieldMaintence.sendKeys(password);
        confirmButtonMaintenance.click();
    }

    public void clickOnAssignLeaveTab() {
        waitFor(5000);
        clickOn(leaveList);
        log.info("click on sideBar menu success");
    }

    public void enterUsernameAndEmployeeName(String userName, String employeeName) {
        userNameTextFieldAdmin.sendKeys(userName);
        EmployeeNameTextFieldAdmin.sendKeys(employeeName);
    }

    public void clickOnPIM() {
        clickOn(PIM);
    }

    public void SelectAll() {
        clickOn(selectAllEmployees);
    }

    public void clickOnDelete() {
        clickOn(deleteSelected);
        waitFor(5);
    }

    public void clickResetButton() {
        resetButton.click();
        waitFor(5);
    }

    public void hoverOverOnAndClickLogoutLink() {
        waitFor(5000);
        hoverOverAndClickOn(logoutLink);
        log.info("click on logout link success");
    }

    public void clickOnLogoutButton() {
        accountButton.click();
        waitFor(5);
        logoutLink.click();
    }

    public void clickOnAdmin() {
        adminButton.click();
    }

    public void clickOnAccountTab() {
        accountButton.click();
    }

    public void clickOnSupport() {
        accountButton.click();
        SupportButton.click();
    }

    public boolean confirmDelete() {
        waitFor(3);
        clickOn(confirmDeleteRecords);
        return true;
    }

    public boolean verifyTextBoxEmpty() {
        return userNameTextFieldAdmin.getText().isEmpty() || EmployeeNameTextFieldAdmin.getText().isEmpty();
    }

    public boolean isMenuOptionsVisible() {
        waitFor(5);
        return isVisible(adminText);
    }

    public boolean adminIsVisible() {
        return isVisible(adminButton);
    }


    public String getHeaderText() {
        waitFor(5000);
        String text = getElementText(mainHeader);
        log.info("user logged in success");
        return text;
    }


    public String FieldConfirmation() {
        String txt = FieldConfi.getText().toLowerCase();
        return txt;
    }

    public void clickOnMenuField(String Field) {
        List<WebElement> list = optionsList;
        for (WebElement element : optionsList) {
            String FieldText = element.getText();
            if (FieldText.equalsIgnoreCase(Field)) {
                element.click();
                log.info("Click on " + Field + " successful");
                break;

            }


        }
    }
}