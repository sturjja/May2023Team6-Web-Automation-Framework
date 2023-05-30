package com.freecrm;

import com.team6.utility.ExcelReader;
import com.team6.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.team6.base.CommonAPI;
import com.team6.pages.freecrm.HomePage;
import com.team6.pages.freecrm.LoginPage;

import java.io.File;
import java.util.Properties;

public class VerifyDashboard extends CommonAPI {
    Logger log = LogManager.getLogger(VerifyDashboard.class.getName());
    String currentDir = System.getProperty("user.dir");
    String path = currentDir+ File.separator+"data"+File.separator+"freecrm.xlsx";
    ExcelReader excelReader = new ExcelReader(path);
    Properties prop = Utility.loadProperties();
    String validEmail = prop.getProperty("freecrm.email");
    String validPassword = prop.getProperty("freecrm.password");
    String titleName = excelReader.getDataFromCell("VerifyDashboard", 0, 0);
    String companyName = excelReader.getDataFromCell("VerifyDashboard", 0 , 1);

 //-----------------------------------------------------------------------------------------------------------
 //****************************(Test Case to verify the visibility of the Dashboard)*************************
    @Test
    public void testDashboardLoadPage(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

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




    }

//-------------------------------------------------------------------------------------------------------------
//*******************************(Test to create a new task through Dashboard)*********************************

    @Test
    public void createNewTask(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

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

        waitFor(10);
        //user will click on task button on the left column to access task page
        homePage.clickOnTaskMenuItem();
        waitFor(10);
        //user will click on create button to create a new task
        homePage.clickOnCreateButton();
        waitFor(5);
        //user will type in a desired title name
        homePage.enterTitle(titleName);
        //user to click on save button to save new task
        homePage.ClickOnSaveButton();
        String expectedCompletionText = "Complete";
        String actualCompletionText = homePage.getActualCompletionText();
        Assert.assertEquals(expectedCompletionText, actualCompletionText);




    }

//------------------------------------------------------------------------------------------------------------
//*******************************(Test case to search for a company)*****************************************

    @Test
    public void searchCompany(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

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
        log.info("Validate dashboard success");

        homePage.typeOnSearchField(companyName);
    }



}


