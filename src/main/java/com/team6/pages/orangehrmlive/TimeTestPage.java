package com.team6.pages.orangehrmlive;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TimeTestPage extends CommonAPI {
    Logger log = LogManager.getLogger(HomepagePage.class.getName());

    public TimeTestPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "oxd-table-cell-action-space")
    List<WebElement> ViewTimeSheets;

    @FindBy(xpath = "//button[normalize-space()='Approve']")
    WebElement Approve;

    @FindBy(xpath = "//span[normalize-space()='Timesheets']")
    WebElement Timesheet;

    @FindBy(xpath = "//span[normalize-space()='Attendance']")
    WebElement Attendance;

    @FindBy(xpath = "//li[@class='--active oxd-topbar-body-nav-tab --parent']//li[1]")
    WebElement myRecords;


    @FindBy(xpath = "//span[normalize-space()='Reports']")
    WebElement Reports;


    //Project Reports
    @FindBy(xpath = "//li[@class='--active oxd-topbar-body-nav-tab --parent']//li[1]")
    WebElement projectReports;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement projectNameTextField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement View;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-text--count']")
    WebElement RecordsFound;

    @FindBy(xpath = "//a[normalize-space()='Attendance Summary']")
    WebElement AttendanceSummary;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]")
    WebElement employeeStatusDropdown;

    @FindBy(xpath = "//a[normalize-space()='Employee Timesheets']")
    WebElement EmployeeTimeSheet;

    @FindBy(xpath = "//div[@class='oxd-toast-content oxd-toast-content--info']")
    WebElement ToasterMessage;

      @FindBy(xpath = "//div[@role='listbox' and contains(@class, 'oxd-select-dropdown')]")
    WebElement dropDown;

    HomepagePage hP = new HomepagePage(getDriver());


    public void checkTimeSheets() {
        int index = 0;
        while (index < ViewTimeSheets.size()) {
            WebElement element = ViewTimeSheets.get(index);
            waitFor(2);
            clickOn(element);
            clickOn(Timesheet);
            clickOn(EmployeeTimeSheet);
            index++;
        }

    }

    public boolean showAttendanceRecords() {
        clickOn(Attendance);
        clickOn(myRecords);

        if (ToasterMessage.getText().contains("No Records Found")) ;
        return false;
    }


    public void clickOnReports() {
        clickOn(Reports);
    }

    public void clickOnProjectReports() {
        clickOn(projectReports);
    }

    public void enterProjectNameHints(String initials) {

        projectNameTextField.sendKeys(initials);
        waitFor(2);
        projectNameTextField.sendKeys(Keys.DOWN);
        projectNameTextField.sendKeys(Keys.RETURN);
    }

    public void clickOnView() {
        clickOn(View);
    }

    public void clickOnAttendance() {
        clickOn(AttendanceSummary);
    }

    public void employeeStatusDropdown() {
        Select select = new Select(employeeStatusDropdown);
        select.selectByVisibleText("Freelance");
        log.info("Employee status selected from dropdown");
    }

    public boolean checkForRecords() {
        return RecordsFound.getText().contains("Records Found");
    }
}