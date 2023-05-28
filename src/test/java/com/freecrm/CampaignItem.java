package com.freecrm;

import com.team6.base.CommonAPI;
import com.team6.pages.freecrm.CampaignPage;
import com.team6.pages.freecrm.HomePage;
import com.team6.pages.freecrm.LoginPage;
import com.team6.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class CampaignItem extends CommonAPI {
    Logger log = LogManager.getLogger(CampaignItem.class.getName());
    Properties prop = Utility.loadProperties();

    String validEmail = prop.getProperty("freecrm.email");
    String validPassword = prop.getProperty("freecrm.password");
    String campaignName = "USA2026";
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

        campaignPage.clickOnCampaignButton();
        campaignPage.clickOnNewCampaignButton();
        campaignPage.typeOnCampaignNameField(campaignName);
        campaignPage.clickOnSaveCampaignButton();




    }
    @Test
    public void editCampaign(){
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

        campaignPage.clickOnCampaignButton();
        campaignPage.clickOnEditCampaignButton();
        campaignPage.clickOnCampaignActiveButton();

    }
    @Test
    public void deleteCampaign(){
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

        campaignPage.clickOnCampaignButton();
        campaignPage.clickOnCampaignDeleteButton();
        campaignPage.clickOnConfirmCampaignDeletion();


    }

}
