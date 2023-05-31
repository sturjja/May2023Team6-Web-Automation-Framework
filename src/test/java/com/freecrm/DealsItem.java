package com.freecrm;

import com.team6.base.CommonAPI;
import com.team6.pages.freecrm.DealsPage;
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

public class DealsItem extends CommonAPI {
    Properties prop = Utility.loadProperties();
    String currentDir = System.getProperty("user.dir");
    String path = currentDir+ File.separator+"data"+File.separator+"freecrm.xlsx";
    ExcelReader excelReader = new ExcelReader(path);
    String validEmail = prop.getProperty("freecrm.email");
    String validPassword = prop.getProperty("freecrm.password");
    String comission = excelReader.getDataFromCell("DealsItem", 0, 0);
    String note = excelReader.getDataFromCell("DealsItem", 1, 0) ;

//-------------------------------------------------------------------------------------------------------------
//*****************************(Test Case to assign commission to a deal)***************************************

    @Test
    public void assignDealCommision(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        DealsPage dealsPage = new DealsPage(getDriver());
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

        //user will click on deals button on the left column to access deals page
        dealsPage.clickOnDealsButton();
        //user will click on edit button assigned to created deal
        dealsPage.clickOnEditDealsButton();
        //user will type in a desire comission amount to the created deal
        dealsPage.setDealsCommissionField(comission);
        //user will click on save button to save edited deal
        dealsPage.clickOnDealSaveButton();

    }

//-------------------------------------------------------------------------------------------------------------
//********************************(Test Case to add Notes to an existing Deal)********************************




    @Test
    public void addNotesToExistingDeal(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        DealsPage dealsPage = new DealsPage(getDriver());
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

        //user will click on deals button on the left column to access deal page
        dealsPage.clickOnDealsButton();
        //user will click on unhide button assigned to created deal
        dealsPage.clickOnUnhideIcon();
        waitFor(3);
        //user will click on add button assigned to subsection notes of the created deal
        dealsPage.clickOnAddNotesButton();
        //user will type in a desired note on the notes field
        dealsPage.typeOnNotesField(note);
        //user will click on save button to save edited deal
        dealsPage.clickOnSaveNotes();


    }
}
