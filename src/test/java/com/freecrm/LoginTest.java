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

 //-------------------------------------------------------------------------------------------------------------
    //***************************(Login Functionality Test Cases)**********************************************
        @Test
        public void validEmail() {
            LoginPage loginPage = new LoginPage(getDriver());
            HomePage homePage = new HomePage(getDriver());
            String expectedTitle = "#1 Free CRM App for every business customer relationship management cloud";
            String actualTitle = getCurrentTitle();
            Assert.assertEquals(expectedTitle, actualTitle);

         //Click on login link
            loginPage.clickOnloginLink();
<<<<<<< HEAD
         // enter a valid email address on the email field in the center of the page
            loginPage.enterEmail(validEmail);
         // enter a valid password on the password field beneath email field
=======
            loginPage.enterEmail(validEmail);
>>>>>>> origin/master
            loginPage.enterPassword(validPassword);
         // click on login button to enter home page
            loginPage.clickOnLoginButton();

            waitFor(10);


            String expectedHomePageHeader = "Ibna Zaman";
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


//         click on login link
            loginPage.clickOnloginLink();
        // enter a Invalid email address on the email field in the center of the page
            loginPage.enterEmail("InvalidEmail");
         // enter a valid password on password field under email field
            loginPage.enterPassword(validPassword);
         // click on login button to enter home page but expect error
            loginPage.clickOnLoginButton();
            waitFor(10);

        // get error message
            String expectedError = "Something went wrong...";
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

//         click on login link
            loginPage.clickOnloginLink();
         // enter nothing on the email field on the center of the page
            loginPage.enterEmail(" ");
         // enter a valid password on the password field under email field
            loginPage.enterPassword(validPassword);
         // click on login button to enter home page but expect error
            loginPage.clickOnLoginButton();
            waitFor(10);

            String expectedError = "Something went wrong...";
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
         // enter a valid email on the email field on the center of the page
            loginPage.enterEmail(validEmail);
         // enter nothing on the password field under email field
            loginPage.enterPassword(" ");
         // click on login button to enter home page but expect error
            loginPage.clickOnLoginButton();
            waitFor(10);

            String expectedError = "Something went wrong...";
            String actualError = loginPage.getErrorMessage();
            Assert.assertEquals(expectedError, actualError);





        }
    }

