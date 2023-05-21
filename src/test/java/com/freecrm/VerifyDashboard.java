package com.freecrm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.team6.base.CommonAPI;
import com.team6.pages.freecrm.HomePage;
import com.team6.pages.freecrm.LoginPage;

public class VerifyDashboard extends CommonAPI {
    Logger log = LogManager.getLogger(VerifyDashboard.class.getName());
    String validEmail = "awafzaman@gmail.com";
    String validPassword = "Takeover2022";
    String titleName = "newtask";
    String searchContact = "Lionel";
    @Test
    public void testDashboardLoadPage(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
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
        log.info("Validate dashboard success");



    }

    @Test
    public void createNewTask(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
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
        log.info("Validate dashboard success");

        waitFor(10);
        homePage.clickOnTaskMenuItem();
        waitFor(10);
        homePage.clickOnCreateButton();
        waitFor(5);
        homePage.enterTitle(titleName);
        homePage.ClickOnSaveButton();



    }

    @Test
    public void searchContact(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
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
        log.info("Validate dashboard success");

        homePage.typeOnSearchField(searchContact);
        String expectedContactName = "Lionel Messi";
        String actualContactName = homePage.getActualContactNameTitle();
        Assert.assertEquals(expectedContactName,actualContactName);
        log.info("desired contact found");

    }



}


