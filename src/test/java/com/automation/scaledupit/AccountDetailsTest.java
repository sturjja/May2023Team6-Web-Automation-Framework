package com.automation.scaledupit;

import com.team6.base.CommonAPI;
import com.team6.pages.automation.scaledupit.HomePage;
import com.team6.pages.automation.scaledupit.LoginPage;
import com.team6.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Properties;

public class AccountDetailsTest extends CommonAPI{
    Logger log = LogManager.getLogger(AccountDetailsTest.class.getName());

    Properties prop = Utility.loadProperties();
    String validUsername = Utility.decode(prop.getProperty("scaledupit.username"));
    String validPassword = Utility.decode(prop.getProperty("scaledupit.password"));
    String newPassword = Utility.decode(prop.getProperty("scaledupit.newpassword"));
    String newEmail = Utility.decode(prop.getProperty("scaledupit.newemail"));
    String newAccountName = Utility.decode(prop.getProperty("scaledupit.newdisplayname"));
    @Test
    public void changeEmailAndBack() throws InterruptedException {
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
        //click on account details button
        homePage.clickOnAccountDetailBtn();
        //clear the email field, enter the new email and save changes
        homePage.clearEmailField();
        homePage.enterNewEmail(newEmail);
        homePage.clickOnSaveChangesBtn();
        //click on logout button
        homePage.clickOnLogoutLink();
        //check user is landed to the login page
        boolean loginPageHeaderIsDisplayed = loginPage.checkPresenceOfLoginPageHeader();
        Assert.assertTrue(loginPageHeaderIsDisplayed);
        waitFor(3);
        String expectedLoginPageHeaderText = "My account";
        String actualLoginPageHeaderText = loginPage.getLoginPageHeaderText();
        Assert.assertEquals(expectedLoginPageHeaderText, actualLoginPageHeaderText);
        log.info("login page header text validation success");
        //enter  new email, password, and click on login button
        loginPage.clickOnMyAccountBtn();
        loginPage.enterUsername(newEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();
        //click on account details button
        homePage.clickOnAccountDetailBtn();
        //clear the email field, reenter the original email and save changes
        homePage.clearEmailField();
        homePage.enterNewEmail(validUsername);
        homePage.clickOnSaveChangesBtn();
    }
    @Test
    public void changeAccountNameAndLogIn() throws InterruptedException {
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
        //click on account details button
        homePage.clickOnAccountDetailBtn();
        //clear the display name field, enter the new display name, and save changes
        homePage.clearDisplaynameField();
        homePage.enterNewDisplayname(newAccountName);
        homePage.clickOnSaveChangesBtn();
        //click on logout button
        homePage.clickOnLogoutLink();
        //check user is landed to the login page
        boolean loginPageHeaderIsDisplayed = loginPage.checkPresenceOfLoginPageHeader();
        Assert.assertTrue(loginPageHeaderIsDisplayed);
        waitFor(3);
        String expectedLoginPageHeaderText = "My account";
        String actualLoginPageHeaderText = loginPage.getLoginPageHeaderText();
        Assert.assertEquals(expectedLoginPageHeaderText, actualLoginPageHeaderText);
        log.info("login page header text validation success");
        //enter new account name, password, and click on login button
        loginPage.clickOnMyAccountBtn();
        loginPage.enterUsername(newAccountName);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();
    }
    @Test
    public void changePasswordAndBack() throws InterruptedException {
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
        //click on account details button
        homePage.clickOnAccountDetailBtn();
        //enter current password and new password and confirm new password, save all changes
        homePage.enterCurrentPassword(validPassword);
        homePage.enterNewPassword(newPassword);
        homePage.confirmNewPassword(newPassword);
        homePage.clickOnSaveChangesBtn();
        //click on logout button
        homePage.clickOnLogoutLink();
        //check user is landed to the login page
        boolean loginPageHeaderIsDisplayed = loginPage.checkPresenceOfLoginPageHeader();
        Assert.assertTrue(loginPageHeaderIsDisplayed);
        waitFor(3);
        String expectedLoginPageHeaderText = "My account";
        String actualLoginPageHeaderText = loginPage.getLoginPageHeaderText();
        Assert.assertEquals(expectedLoginPageHeaderText, actualLoginPageHeaderText);
        log.info("login page header text validation success");
        //navigate to my account page then enter username, password, and click on login button
        loginPage.clickOnMyAccountBtn();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(newPassword);
        loginPage.clickOnLoginBtn();
        //click on account details button
        homePage.clickOnAccountDetailBtn();
        //enter the current password, the new password, and confirm the new password and save all changes
        homePage.enterCurrentPassword(newPassword);
        homePage.enterNewPassword(validPassword);
        homePage.confirmNewPassword(validPassword);
        homePage.clickOnSaveChangesBtn();
    }
}
