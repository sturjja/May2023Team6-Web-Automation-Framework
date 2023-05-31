package com.freecrm;

import com.team6.base.CommonAPI;
import com.team6.pages.freecrm.CasePage;
import com.team6.pages.freecrm.HomePage;
import com.team6.pages.freecrm.LoginPage;
import com.team6.utility.ExcelReader;
import com.team6.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class CaseItem extends CommonAPI {
    Properties prop = Utility.loadProperties();
    String currentDir = System.getProperty("user.dir");
    String path = currentDir+ File.separator+"data"+File.separator+"freecrm.xlsx";
    ExcelReader excelReader = new ExcelReader(path);
    String validEmail = prop.getProperty("freecrm.email");
    String validPassword = prop.getProperty("freecrm.password");
    String newCaseTitle = excelReader.getDataFromCell("CaseItem", 0, 0);
    String caseNote = excelReader.getDataFromCell("CaseItem", 1, 0);

 //----------------------------------------------------------------------------------------------------------
 //*****************************(Test Case to create a Case)******************************************

    @Test(priority = 2)
    public void createCase(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        CasePage casePage = new CasePage(getDriver());

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

        //user will click on the case button on the left column to access case page
        casePage.clickOnCaseButton();
        //uer will click on the new button to create a new case
        casePage.clickOnNewCaseButton();
        //user will set a desired case title name
        casePage.setNewCaseTitle(newCaseTitle);
        //user will save this new case
        casePage.clickOnCaseSaveButton();










    }

//-----------------------------------------------------------------------------------------------------------
//*******************************(Test Case to add note to case)**************************************

    @Test(priority = 1)
    public void addNoteToCase(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        CasePage casePage = new CasePage(getDriver());

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

        waitFor(3);

        //user will click on the case button on the left column to access case page
        casePage.clickOnCaseButton();
        //user will click the unhide button assigned to created case to view its details
        casePage.clickOnCaseUnhideButton();
        waitFor(5);
        //user will click on the add button assigned to notes to write a note in case page
        casePage.clickOnCaseNoteButton();
        //user will type a desired note assigned to note field in the created case page
        casePage.typeOnCaseNoteField(caseNote);
        //user will click on save button to save this note to the case
        casePage.clickOnCaseNoteSaveButton();





    }

 //----------------------------------------------------------------------------------------------------------
 //*****************************(Test Case to delete a case)*******************************************


    @Test(priority = 0)
    public void deleteCase(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        CasePage casePage = new CasePage(getDriver());

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

        //user will click on the case button on the left column to access case page
        casePage.clickOnCaseButton();
        waitFor(3);
        //user will click on the unhide button assigned to created case to view its details
        casePage.clickOnCaseUnhideButton();
        waitFor(3);
        //user will click on the delete button assigned to this created case
        casePage.clickOnCaseDeleteButton();
        waitFor(3);
        //user will confirm deletion of case by clicking confirm delete button
        casePage.clickOnCaseDeleteConfirmButon();





    }
}
