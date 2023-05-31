package com.freecrm;

import com.team6.base.CommonAPI;
import com.team6.pages.freecrm.CompanyPage;
import com.team6.pages.freecrm.LoginPage;
import com.team6.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class CompanyItem extends CommonAPI {
    Properties prop = Utility.loadProperties();
    String validEmail = prop.getProperty("freecrm.email");
    String validPassword = prop.getProperty("freecrm.password");
    String contactName = "Hillary Clinton";
    String dealName = "HarryKaneDeal";

//------------------------------------------------------------------------------------------------------------
//******************************(Test Case to link a contact to a company)*************************************



    @Test
    public void linkContactToCompany(){
        LoginPage loginPage = new LoginPage(getDriver());
        CompanyPage companyPage = new CompanyPage(getDriver());
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

        waitFor(3);

        //user will click on company button on the left column to enter company page
        companyPage.clickOnCompaniesButton();
        waitFor(3);
        //user will click on unhide button to access created companies details
        companyPage.clickOnCompaniesUnhideIcon();
        waitFor(3);
        //user will click on link button to link a contact to the created company
        companyPage.clickOnLinkCompanyContactButton();
        //user will type the desired contact name on the contact field
        companyPage.typeOnCompanyContactField(contactName);
        //user will confirm link of contact by clicking confirm button
        companyPage.clickOnConfirmCompanyContactButton();




    }
//-----------------------------------------------------------------------------------------------------------
    //******************************(Test case to link a deal to a company)*******************************





    @Test
    public void linkDealToCompany(){
        LoginPage loginPage = new LoginPage(getDriver());
        CompanyPage companyPage = new CompanyPage(getDriver());
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

        //user will click on company button on the left column to enter company page
        companyPage.clickOnCompaniesButton();
        waitFor(3);
        //user will click on unhide button to access company details
        companyPage.clickOnCompaniesUnhideIcon();
        waitFor(3);
        //user will click on link deal button assigned to this company
        companyPage.clickOnLinkCompanyDealInitiate();
        //user will type the desired deal name on deal field
        companyPage.typeOnLinkCompanyDealField(dealName);
        //user will confirm deal link by clicking confirm button
        companyPage.clickOnLinkCompanyDealsButton();






    }

}
