package com.freecrm;

import com.team6.base.CommonAPI;
import com.team6.pages.freecrm.DealsPage;
import com.team6.pages.freecrm.HomePage;
import com.team6.pages.freecrm.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class DealsItem extends CommonAPI {
    Logger log = LogManager.getLogManager().getLogger(DealsItem.class.getName());
    String validEmail = "awafzaman@gmail.com";
    String validPassword = "Takeover2022";
    String comission = "$100000";
    String note = "Harry Kane must sign for ManUtd";

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

        loginPage.clickOnloginLink();
        log.info("enter login page");
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        dealsPage.clickOnDealsButton();
        dealsPage.clickOnEditDealsButton();
        dealsPage.setDealsCommissionField(comission);
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

        loginPage.clickOnloginLink();
        log.info("enter login page");
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();

        dealsPage.clickOnDealsButton();
        dealsPage.clickOnUnhideIcon();
        dealsPage.clickOnAddNotesButton();
        dealsPage.typeOnNotesField(note);
        dealsPage.clickOnSaveNotes();


    }
}
