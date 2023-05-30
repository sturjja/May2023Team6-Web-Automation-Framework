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
    Properties prop = Utility.loadProperties();

 //-----------------------------------------------------------------------------------------------------------
 //********************************(Logout Function Test)**************************************************

    String validEmail = prop.getProperty("freecrm.email");

    String validPassword = prop.getProperty("freecrm.password");
    @Test
    public void logOut() {


        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());


        //user will click on login link
        loginPage.clickOnloginLink();
        log.info("enter login page");
        //user will enter a valid email on the email field in the center of the page
        loginPage.enterEmail(validEmail);
        //user will enter a valid password on the password field right below email field
        loginPage.enterPassword(validPassword);
        //user will click on the login button to enter the home page
        loginPage.clickOnLoginButton();


        String expectedHomePageHeader = "Ibna Zaman";
        String actualHomePageHeader= homePage.getHomePageHeader();
        Assert.assertEquals(expectedHomePageHeader,actualHomePageHeader);
        log.info("User login success");

        waitFor(3);

        //user will click on settings button on top right corner of homepage
        homePage.clickOnSettingButton();
        //user will click on log out button to successfully log out of profile
        homePage.clickOnLogOutButton();



        String expectedLoginPageHeader = "Forgot your password?";
        String actualLoginPageHeader = loginPage.getActualPageHeaderText();
        Assert.assertEquals(expectedLoginPageHeader, actualLoginPageHeader);
        log.info("Forgot password button is displayed");
    }
}