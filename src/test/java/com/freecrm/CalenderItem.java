package com.freecrm;

import com.team6.pages.freecrm.CalendarPage;
import com.team6.pages.freecrm.HomePage;
import com.team6.pages.freecrm.LoginPage;
import com.team6.utility.ExcelReader;
import com.team6.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.team6.base.CommonAPI;

import java.io.File;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class CalenderItem extends CommonAPI {
    Properties prop = Utility.loadProperties();
    String currentDir = System.getProperty("user.dir");
    String path = currentDir+ File.separator+"data"+File.separator+"freecrm.xlsx";
    ExcelReader excelReader = new ExcelReader(path);
    String validEmail = prop.getProperty("freecrm.email");
    String validPassword = prop.getProperty("freecrm.password");
    String validCalendarTitle = "Test Event" ;

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

        // user will click on login link
        loginPage.clickOnloginLink();
        //user will enter a valid email on the email field in the center of the page
        loginPage.enterEmail(validEmail);
        //user will enter a valid password on the password field right below email field
        loginPage.enterPassword(validPassword);
        //user will click on the login button to enter the home page
        loginPage.clickOnLoginButton();
        String expectedHeader = "Cogmento CRM";
        String actualHeader = getCurrentTitle();
        Assert.assertEquals(actualHeader, expectedHeader);

        waitFor(10);




        //user will click on calendar section button on the left column to enter calendar page
        calendarPage.clickOnCalendarButton();
        waitFor(3);
        //user will click on the new button in the calendar page
        calendarPage.clickOnNewCalendarButton();
        waitFor(3);
        //user will set their desired Title name for the new calendar
        calendarPage.setCalendarTitleField(validCalendarTitle);
        //user will save this new calendar
        calendarPage.setCalendarSaveButton();




    }
//----------------------------------------------------------------------------------------------------------
//********************************(Test Case to delete a calendar)*****************************************


    @Test(priority = 1)
    public void deleteCalenderDate(){
        LoginPage loginPage = new LoginPage(getDriver());
        CalendarPage calendarPage = new CalendarPage(getDriver());
        String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //user will click on the login link
        loginPage.clickOnloginLink();
        //user will enter a valid email on the email field on the center of the page
        loginPage.enterEmail(validEmail);
        //user will enter a valid password on the password field right below email field
        loginPage.enterPassword(validPassword);
        //user will click on the login button to enter the home page
        loginPage.clickOnLoginButton();
        String expectedHeader = "Cogmento CRM";
        String actualHeader = getCurrentTitle();
        Assert.assertEquals(actualHeader, expectedHeader);

        //user will click on calendar section button on the left column to enter calendar page
        calendarPage.clickOnCalendarButton();
        waitFor(7);
        //user will click on the created calender from calendar table
        calendarPage.clickOnCreatedCalendar();
        waitFor(3);
        //user will click on the delete button assigned to this created calendar
        calendarPage.clickOnCalendarDeleteButton();
        waitFor(3);
        //user will confirm that they are about to delete this created calendar
        calendarPage.clickOnConfirmDeleteButton();




    }
}
