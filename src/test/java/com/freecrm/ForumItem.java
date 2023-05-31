package com.freecrm;

import com.team6.base.CommonAPI;
import com.team6.pages.freecrm.ForumPage;
import com.team6.pages.freecrm.LoginPage;
import com.team6.utility.ExcelReader;
import com.team6.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.sql.DriverManager.getDriver;

public class ForumItem extends CommonAPI {
    String currentDir = System.getProperty("user.dir");
    String path = currentDir+ File.separator+"data"+File.separator+"freecrm.xlsx";
    ExcelReader excelReader = new ExcelReader(path);
    Properties prop = Utility.loadProperties();
    String validEmail = prop.getProperty("freecrm.email");
    String validPassword = prop.getProperty("freecrm.password");
    String validName = excelReader.getDataFromCell("ForumItem", 0, 0);
    String simpleIntro = excelReader.getDataFromCell("ForumItem" , 1, 0);
    String simpleOutro = excelReader.getDataFromCell("ForumItem" , 2 , 0);

//-------------------------------------------------------------------------------------------------------------
//**********************************(Test Case to add notes to the forum)**************************************


    @Test
    public void addFormsWithName() {
        LoginPage loginPage = new LoginPage(getDriver());
        ForumPage forumPage = new ForumPage(getDriver());

        //user will click on login link
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

        //user will click on forms button on the left column to access forms page
        forumPage.clickOnFormsButton();
        //user will click on add button to create a new form
        forumPage.clickOnFormsAddButton();
        //user will type in the desired name for form on name field
        forumPage.typeOnFormsNameField(validName);
        //user will click on save button to save form
        forumPage.clickOnFormSaveButton();
    }

    //-----------------------------------------------------------------------------------------------------------
    //****************************(Test Case to add Form with only an Intro)*********************************
    @Test
    public void addFormsWithIntro(){
        LoginPage loginPage = new LoginPage(getDriver());
        ForumPage forumPage = new ForumPage(getDriver());

        //user will click on login link
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

        //user will click on forms button on the left column to access forms page
        forumPage.clickOnFormsButton();
        //user will click on add button to create new form
        forumPage.clickOnFormsAddButton();
        //user will type in desired intro for new form
        forumPage.typeOnFormsIntroField(simpleIntro);
        //user will click on save button to save new form
        forumPage.clickOnFormSaveButton();

    }

    //-----------------------------------------------------------------------------------------------------------
    //****************************(Test Case to add Form with only an Outro)************************************
    @Test
    public void addFormsWithOutro(){
        LoginPage loginPage = new LoginPage(getDriver());
        ForumPage forumPage = new ForumPage(getDriver());

        //user will click on login link
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

        //user will click on forms button on the left column to access forms page
        forumPage.clickOnFormsButton();
        //user will click on add button to create new form
        forumPage.clickOnFormsAddButton();
        //user will type in desired intro for new form
        forumPage.typeOnFormsOutroField(simpleOutro);
        //user will click on save button to save new form
        forumPage.clickOnFormSaveButton();
    }
}
