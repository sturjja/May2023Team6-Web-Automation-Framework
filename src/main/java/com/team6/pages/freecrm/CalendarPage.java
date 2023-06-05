package com.team6.pages.freecrm;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage extends CommonAPI {
    Logger log = LogManager.getLogger(CalendarPage.class.getName());
    public CalendarPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(), 'Calendar')]")
    WebElement calendarButton;
    @FindBy(xpath = "//a[@href=\"/calendar/new\"]\n")
    WebElement newCalendarButton;
    @FindBy(xpath = "//input[@autocomplete=\"new-password\" and @name=\"title\" and @type=\"text\" and @value=\"\"]\n")
    WebElement calendarTitleField;
    @FindBy(xpath = "//label[text()=\"Start Date\"]\n")
    WebElement calendarStartField;
    @FindBy(xpath = "//label[text()=\"End Date\"]\n")
    WebElement calendarEndField;
    @FindBy(xpath = "//button[contains(text(), 'Save')]")
    WebElement calendarSaveButton;
    @FindBy(xpath = "//div[@class=\"rbc-event-content\" and @title=\"Test Event\"]\n")
    WebElement createdCalendar;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"trash icon\"]\n")
    WebElement calendarDeleteButton;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"remove icon\"]\n")
    WebElement confirmDeleteButton;

    public void clickOnConfirmDeleteButton(){
        clickOn(confirmDeleteButton);
        log.info("delete button click is confirmed");
    }

    public void clickOnCalendarDeleteButton(){
        clickOn(calendarDeleteButton);
        log.info("calendar delete button is clicked");
    }

    public void clickOnCreatedCalendar(){
        clickOn(createdCalendar);
        log.info("calendar create button is clicked");
    }

    public void setCalendarSaveButton(){
        clickOn(calendarSaveButton);
        log.info("calendar is saved");
    }

    public void setCalendarEndField(String endDate){
        type(calendarEndField, endDate);
    }

    public void setCalendarStartField(String startDate){
        type(calendarStartField, startDate);
    }

    public void setCalendarTitleField(String validCalendarTitle){
        type(calendarTitleField, validCalendarTitle);
    }

    public void clickOnNewCalendarButton(){
        clickOn(newCalendarButton);
        log.info("new calendar is initialized");
    }

    public void clickOnCalendarButton(){
        clickOn(calendarButton);
        log.info("calendar section is accessed");
    }







}

