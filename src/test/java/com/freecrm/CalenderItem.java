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
    String validEmail = "awafzaman@gmail.com";
    String validPassword = "Takeover2022";
    String validCalendarTitle = "Test event";
    String validCalendarStart = "2023-05-19";
    String validEndDate = "2023-05-20";

//-------------------------------------------------------------------------------------------------------------
//***************************(Test Case to create a new calendar)*********************************************

    @Test(priority = 0)
    public void createCalenderDate(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        CalendarPage calendarPage = new CalendarPage(getDriver());
        String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        loginPage.clickOnloginLink();
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        waitFor(10);


        String expectedHeader = "Cogmento CRM";
        String actualHeader = getCurrentTitle();
        Assert.assertEquals(actualHeader, expectedHeader);

        calendarPage.clickOnCalendarButton();
        waitFor(3);
        calendarPage.clickOnNewCalendarButton();
        waitFor(3);
        calendarPage.setCalendarTitleField(validCalendarTitle);
        calendarPage.setCalendarSaveButton();




    }
//----------------------------------------------------------------------------------------------------------
//********************************(Test Case to delete a calendar)*****************************************


    @Test(priority = 1)
    public void deleteCalenderDate(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        CalendarPage calendarPage = new CalendarPage(getDriver());
        String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        loginPage.clickOnloginLink();
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        calendarPage.clickOnCalendarButton();
        waitFor(6);
        calendarPage.clickOnCreatedCalendar();
        waitFor(3);
        calendarPage.clickOnCalendarDeleteButton();
        waitFor(3);
        calendarPage.clickOnConfirmDeleteButton();




    }
}
