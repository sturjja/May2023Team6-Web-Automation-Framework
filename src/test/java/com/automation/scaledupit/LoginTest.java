package com.automation.scaledupit;

import com.team6.base.CommonAPI;
import com.team6.pages.automation.scaledupit.HomePage;
import com.team6.pages.automation.scaledupit.LoginPage;
import com.team6.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.PageFactory;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends CommonAPI {
    Logger log = LogManager.getLogger(LoginTest.class.getName());
    Properties prop = Utility.loadProperties();
    String validUsername = Utility.decode(prop.getProperty("scaledupit.username"));
    String validPassword = Utility.decode(prop.getProperty("scaledupit.password"));

    @Test
    public void validCredential() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        //land on home page
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        waitFor(3);
        //enter  username, password, and click on login button
        loginPage.clickOnMyAccountBtn();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();
        //check user is logged in
        String expectedHomePageHeader = "My account";
        String actualHomePageHeader = homePage.getHeaderText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        waitFor(3);

    }

    @Test
    public void missingUsername() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        //land on home page
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        waitFor(3);
        //enter  username, password, and click on login button
        loginPage.clickOnMyAccountBtn();
        loginPage.enterUsername("");
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();

        //validate the error message
        String expectedError = "Error: Username is required.";
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(expectedError, actualError);
    }

    @Test
    public void missingPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        //land on home page
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        waitFor(3);
        //enter  username, password, and click on login button
        loginPage.clickOnMyAccountBtn();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword("");
        loginPage.clickOnLoginBtn();

        //validate the error message
        String expectedError = "Error: The password field is empty.";
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(expectedError, actualError);
    }
    @Test
    public void incorrectPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        //land on home page
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        waitFor(3);
        //enter  username, password, and click on login button
        loginPage.clickOnMyAccountBtn();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword("Incorrect");
        loginPage.clickOnLoginBtn();
        //validate the error message
        String expectedError = "Error: The password you entered for the email address Samtur@example.com is incorrect. Lost your password?";
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(expectedError, actualError);
    }
    @Test
    public void noCredentials() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        //land on home page
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        waitFor(3);
        //enter  username, password, and click on login button
        loginPage.clickOnMyAccountBtn();
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickOnLoginBtn();

        //validate the error message
        String expectedError = "Error: Username is required.";
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(expectedError, actualError);
    }
}