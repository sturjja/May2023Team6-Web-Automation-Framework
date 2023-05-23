package com.freecrm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.team6.base.CommonAPI;
import com.team6.pages.freecrm.HomePage;
import com.team6.pages.freecrm.LoginPage;
import com.team6.utility.Utility;

import java.util.Properties;
public class LogoutTest extends CommonAPI {
    Logger log = LogManager.getLogger(LogoutTest.class.getName());

 //-----------------------------------------------------------------------------------------------------------
 //********************************(Logout Function Test)**************************************************

    String validEmail = "awafzaman@gmail.com";

    String validPassword = "Takeover2022 ";
    @Test
    public void logOut() {


        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.clickOnloginLink();
        log.info("enter login page");
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginButton();


        String expectedHomePageHeader = "No items found";
        String actualHomePageHeader= homePage.getHomePageHeader();
        Assert.assertEquals(expectedHomePageHeader,actualHomePageHeader);
        log.info("User login success");

        waitFor(3);

        homePage.clickOnSettingButton();
        homePage.clickOnLogOutButton();



        String expectedLoginPageHeader = "Forgot your password?";
        String actualLoginPageHeader = loginPage.getActualPageHeaderText();
        Assert.assertEquals(expectedLoginPageHeader, actualLoginPageHeader);
        log.info("Forgot password button is displayed");
    }
}