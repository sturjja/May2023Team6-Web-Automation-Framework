package com.freecrm;

import com.team6.base.CommonAPI;
import com.team6.pages.freecrm.CompanyPage;
import com.team6.pages.freecrm.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class CompanyItem extends CommonAPI {
    Logger log = LogManager.getLogManager().getLogger(CompanyItem.class.getName());
    String validEmail = "awafzaman@gmail.com";
    String validPassword = "Takeover2022";
    String contactName = "Hillary Clinton";
    String dealName = "HarryKaneDeal";



    @Test
    public void linkContactToCompany(){
        LoginPage loginPage = new LoginPage(getDriver());
        CompanyPage companyPage = new CompanyPage(getDriver());
        String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        loginPage.clickOnloginLink();
        log.info("enter login page");
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        companyPage.clickOnCompaniesButton();
        companyPage.clickOnCompaniesUnhideIcon();
        companyPage.clickOnLinkCompanyContactButton();
        companyPage.typeOnCompanyContactField(contactName);
        companyPage.clickOnConfirmCompanyContactButton();




    }






    @Test
    public void linkDealToCompany(){
        LoginPage loginPage = new LoginPage(getDriver());
        CompanyPage companyPage = new CompanyPage(getDriver());
        String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        loginPage.clickOnloginLink();
        log.info("enter login page");
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        companyPage.clickOnCompaniesButton();
        companyPage.clickOnCompaniesUnhideIcon();
        companyPage.clickOnLinkCompanyDealsButton();
        companyPage.typeOnLinkCompanyDealField(dealName);
        companyPage.clickOnLinkCompanyDealButton();






    }

}
