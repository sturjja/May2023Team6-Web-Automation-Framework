package com.team6.pages.orangehrmlive;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeavePage extends CommonAPI {
    Logger log = LogManager.getLogger(HomepagePage.class.getName());

    public LeavePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //locators
    @FindBy(css = "#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(3) > a")
    WebElement Leave;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div[1]/div/div[1]/div/label")
    WebElement selectAllPendingLeaveRequest;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/div/button[1]")
    WebElement approveButton;


    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")
    WebElement confirmApprove;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]")
    WebElement blankElement;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/span")
    WebElement noRecordsFound;

    @FindBy(xpath = "//header/div[2]/nav[1]/ul[1]/li[4]/span[1]")
    WebElement ReportsButton;

    @FindBy(xpath = "//header/div[2]/nav[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]")
    WebElement leaveUsagesReport;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[3]/button[1]")
    WebElement GenerateLeaveReport;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/span[1]")
    WebElement RecordsFoundText;


    public void clickOnLeave() {
        clickOn(Leave);

        log.info("Click on leave button Success");
    }

    public void selectPendingApprovals() {
        selectAllPendingLeaveRequest.click();
        log.info("Selecting all pending leave request Success");
    }

    public void approve() {
        waitFor(1);
        approveButton.click();
        waitFor(1);
        confirmApprove.click();
        log.info("Confirming approve Success");
    }

    public boolean noApprovalsNeeded() {
        return noRecordsFound.isDisplayed();
    }

    public void checkAndApproveLeaveRequest() {
        if (noApprovalsNeeded())
            log.info("No pending approval found");
        else log.info("Approvals found");
    }

    public void clickOnReports(){
        clickOn(ReportsButton);
    }
    public void clickOnLeaveUsagesReport(){
        clickOn(leaveUsagesReport);
    }
    public void clickOnGenerateReport(){
        clickOn(GenerateLeaveReport);
    }

    public String getRecordsFoundMessage(){
        return noRecordsFound.getText();
    }



}

