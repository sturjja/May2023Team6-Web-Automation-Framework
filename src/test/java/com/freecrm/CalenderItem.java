package com.freecrm;

import com.team6.pages.freecrm.CalendarPage;
import com.team6.pages.freecrm.HomePage;
import com.team6.pages.freecrm.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.team6.base.CommonAPI;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class CalenderItem extends CommonAPI {
    Logger log = LogManager.getLogManager().getLogger(CalenderItem.class.getName());
    String validEmail = "awafzaman@gmail.com";
    String validPassword = "Takeover2022";
    String validCalendarTitle = "Test event";
    String validCalendarStart = "2023-05-19";
    String validEndDate = "2023-05-20";

//-------------------------------------------------------------------------------------------------------------
//***************************(Test Case to create a new calendar)*********************************************

    @Test
    public void createCalenderDate(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        CalendarPage calendarPage = new CalendarPage(getDriver());
        String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        loginPage.clickOnloginLink();
        log.info("enter login page");
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        waitFor(10);


        String expectedHeader = "Cogmento CRM";
        String actualHeader = getCurrentTitle();
        Assert.assertEquals(actualHeader, expectedHeader);
        log.info("user logged in success");

        calendarPage.clickOnCalendarButton();
        calendarPage.clickOnNewCalendarButton();
        calendarPage.setCalendarTitleField(validCalendarTitle);
        log.info("Calendar Title entered");
        calendarPage.setCalendarStartField(validCalendarStart);
        log.info("Start date selected");
        calendarPage.setCalendarEndField(validEndDate);
        log.info("End date selected");
        calendarPage.setCalendarSaveButton();
        String expectedCreatedByMessage = "Created By";
        String actualCreatedByMessage = "//div[@class=\"ui label\" and text()=\"Created By\"]\n";
        Assert.assertEquals(expectedCreatedByMessage,actualCreatedByMessage);
        log.info("successfully created a calendar");




    }
//----------------------------------------------------------------------------------------------------------
//********************************(Test Case to delete a calendar)*****************************************


    @Test
    public void deleteCalenderDate(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        CalendarPage calendarPage = new CalendarPage(getDriver());
        String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        loginPage.clickOnloginLink();
        log.info("enter login page");
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        calendarPage.clickOnCalendarButton();
        calendarPage.clickOnCreatedCalendar();
        calendarPage.clickOnCalendarDeleteButton();
        calendarPage.clickOnConfirmDeleteButton();




    }
}
