package com.team6.pages.orangehrmlive;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeavePage extends CommonAPI {
    Logger log = LogManager.getLogger(HomePage.class.getName());

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

    public boolean noApprovalsNeeded()
    {
        return noRecordsFound.isDisplayed();
    }
    public boolean EmptyListIsDisplayed() {
        return blankElement.isDisplayed();
    }

}