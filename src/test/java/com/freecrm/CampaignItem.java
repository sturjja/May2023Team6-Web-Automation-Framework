package com.freecrm;

import com.team6.base.CommonAPI;
import com.team6.pages.freecrm.CampaignPage;
import com.team6.pages.freecrm.HomePage;
import com.team6.pages.freecrm.LoginPage;
import com.team6.utility.ExcelReader;
import com.team6.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Properties;

public class CampaignItem extends CommonAPI {
    Logger log = LogManager.getLogger(CampaignItem.class.getName());
    Properties prop = Utility.loadProperties();
    String currentDir = System.getProperty("user.dir");
    String path = currentDir+ File.separator+"data"+File.separator+"freecrm.xlsx";
    ExcelReader excelReader = new ExcelReader(path);

    String validEmail = Utility.decode(prop.getProperty("freecrm.email"));
    String validPassword = Utility.decode(prop.getProperty("freecrm.password"));
    String campaignName = excelReader.getDataFromCell("CampaignItem", 0, 0);

    //-------------------------------------------------------------------------------------------------------------
//*****************************(Test Case to create a campaign in Campaign section)*********************************

    @Test
    public void createCampaign(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        CampaignPage campaignPage = new CampaignPage(getDriver());
        String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        loginPage.clickOnloginLink();
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();
        String expectedHeader = "Cogmento CRM";
        String actualHeader = getCurrentTitle();
        Assert.assertEquals(actualHeader, expectedHeader);

        campaignPage.clickOnCampaignButton();
        waitFor(3);
        campaignPage.clickOnNewCampaignButton();
        waitFor(2);
        campaignPage.typeOnCampaignNameField(campaignName);
        campaignPage.clickOnSaveCampaignButton();




    }
    //-------------------------------------------------------------------------------------------------------------
//*************************************(Test Case to edit a Campaign)*****************************************
    @Test
    public void editCampaign(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        CampaignPage campaignPage = new CampaignPage(getDriver());
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

        //user will click on the campaign button to access the campaign page
        campaignPage.clickOnCampaignButton();
        waitFor(4);
        //user will click on the edit button assigned to the created campaign
        campaignPage.clickOnEditCampaignButton();

    }

    //-------------------------------------------------------------------------------------------------------------
//***********************************(Test Case to delete a Campaign)*****************************************

    @Test
    public void deleteCampaign(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        CampaignPage campaignPage = new CampaignPage(getDriver());
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

        //user will click on the campaign button to access the campaign page
        campaignPage.clickOnCampaignButton();
        //user will click on the delete button assigned to this created campaign
        campaignPage.clickOnCampaignDeleteButton();
        //user will confirm by clicking the confirm delete button the completion of the deletion
        campaignPage.clickOnConfirmCampaignDeletion();


    }

}
