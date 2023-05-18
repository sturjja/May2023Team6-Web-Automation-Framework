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


public class LoginTest extends CommonAPI {
        Logger log = LogManager.getLogger(LoginTest.class.getName());
        Properties prop = Utility.loadProperties();

        String validEmail = prop.getProperty("freecrm.email");
        String validPassword = prop.getProperty("freecrm.password");





        @Test
        public void validEmail() {
            LoginPage loginPage = new LoginPage(getDriver());
            HomePage homePage = new HomePage(getDriver());
            String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
            String actualTitle = getCurrentTitle();
            Assert.assertEquals(expectedTitle, actualTitle);

            loginPage.clickOnloginLink();
            log.info("enter login page");
            loginPage.enterEmail(validEmail);
            loginPage.enterPassword(validPassword);
            loginPage.clickOnLoginButton();

            waitFor(10);


            String expectedHomePageHeader = "No items found";
            String actualHomePageHeader = homePage.getHomePageHeader();
            Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);


        }

        @Test
        public void inValidEmail() {
            LoginPage loginPage = new LoginPage(getDriver());
            HomePage homePage = new HomePage(getDriver());
            String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
            String actualTitle = getCurrentTitle();
            Assert.assertEquals(expectedTitle, actualTitle);


            loginPage.clickOnloginLink();
            log.info("enter login page");
            loginPage.enterEmail("InvalidEmail");
            loginPage.enterPassword(validPassword);
            loginPage.clickOnLoginButton();
            waitFor(10);

            String expectedError = "You do not have permission to perform this action";
            String actualError = loginPage.getErrorMessage();
            Assert.assertEquals(expectedError, actualError);




        }

        @Test
        public void missingEmail() {
            LoginPage loginPage = new LoginPage(getDriver());
            HomePage homePage = new HomePage(getDriver());
            String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
            String actualTitle = getCurrentTitle();
            Assert.assertEquals(expectedTitle, actualTitle);


            loginPage.clickOnloginLink();
            log.info("enter login page");
            loginPage.enterEmail(" ");
            loginPage.enterPassword(validPassword);
            loginPage.clickOnLoginButton();
            waitFor(10);

            String expectedError = "You do not have permission to perform this action";
            String actualError = loginPage.getErrorMessage();
            Assert.assertEquals(expectedError, actualError);



        }

        @Test
        public void missingPassword() {
            LoginPage loginPage = new LoginPage(getDriver());
            HomePage homePage = new HomePage(getDriver());
            String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
            String actualTitle = getCurrentTitle();
            Assert.assertEquals(expectedTitle, actualTitle);


            loginPage.clickOnloginLink();
            log.info("enter login page");
            loginPage.enterEmail(validEmail);
            loginPage.enterPassword(" ");
            loginPage.clickOnLoginButton();
            waitFor(10);

            String expectedError = "You do not have permission to perform this action";
            String actualError = loginPage.getErrorMessage();
            Assert.assertEquals(expectedError, actualError);





        }
    }

