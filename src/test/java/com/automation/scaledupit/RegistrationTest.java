package com.automation.scaledupit;

import com.team6.base.CommonAPI;
import com.team6.pages.automation.scaledupit.HomePage;
import com.team6.pages.automation.scaledupit.LoginPage;
import com.team6.pages.automation.scaledupit.RegisterPage;
import com.team6.utility.ExcelReader;
import com.team6.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class RegistrationTest extends CommonAPI {
    Logger log = LogManager.getLogger(RegistrationTest.class.getName());

    @Test(dataProvider = "getRegistrationTestData")
    public void newUserRegistration(String newEmail, String validPassword) {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        RegisterPage registerPage = new RegisterPage(getDriver());
        //land on home page
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        waitFor(3);
        //navigate to registration page, enter valid email address and password and click on register
        loginPage.clickOnMyAccountBtn();
        registerPage.enterEmail(newEmail);
        registerPage.enterPassword(validPassword);
        registerPage.clickOnRegisterBtn();
        //check user is logged in
        String expectedHomePageHeader = "My account";
        String actualHomePageHeader = homePage.getHeaderText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        waitFor(3);
        //click on logout button
        homePage.clickOnLogoutLink();
        //check user is landed to the login page
        boolean loginPageHeaderIsDisplayed = loginPage.checkPresenceOfLoginPageHeader();
        Assert.assertTrue(loginPageHeaderIsDisplayed);
        waitFor(3);
        String expectedLoginPageHeaderText = "My account";
        String actualLoginPageHeaderText = loginPage.getLoginPageHeaderText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        log.info("login page header text validation success");
    }


}
