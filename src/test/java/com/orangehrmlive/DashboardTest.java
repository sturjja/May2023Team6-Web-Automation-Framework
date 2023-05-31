package com.orangehrmlive;

import com.team6.base.CommonAPI;
import com.team6.pages.orangehrmlive.DashboardPage;
import com.team6.pages.orangehrmlive.HomepagePage;
import com.team6.pages.orangehrmlive.LoginPage;
import com.team6.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Properties;

public class DashboardTest extends CommonAPI {
    Properties prop = Utility.loadProperties();
    String validUsername = Utility.decode(prop.getProperty("orangeHRM.username"));
    String validPassword = Utility.decode(prop.getProperty("orangeHRM.password"));
    String invalidUsername = Utility.decode(prop.getProperty("orangeHRM.invalidUserName"));
    String invalidPassword = Utility.decode(prop.getProperty("orangeHRM.invalidPassword"));
    String supportTextMessage = Utility.decode(prop.getProperty("orangeHRM.supportText"));
    Logger log = LogManager.getLogger(LeaveTest.class.getName());

    @BeforeMethod
    @Override
    public void setUp(@Optional("false") String useCloudEnv, @Optional("browserstack") String envName, @Optional("windows") String os, @Optional("10") String osVersion, @Optional("chrome") String browserName, @Optional("110") String browserVersion, @Optional("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login") String url) throws MalformedURLException {
        super.setUp(useCloudEnv, envName, os, osVersion, browserName, browserVersion, url);
    }

    @Test(priority = 1)
    public void verifyLogout() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());
        String tabName = "Dashboard";

        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();

        homepagePage.clickonMainMenuOptions(tabName);

        HomepagePage hp = new HomepagePage(getDriver());
        hp.clickOnLogoutButton();

        Assert.assertTrue(loginPage.checkPresenceOfLoginPageHeader());

    }

    @Test(priority = 2)
    public void validateSidebarMenuButton() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage hp = new HomepagePage(getDriver());

        loginPage.enteringUserNamePassWord(validUsername, validPassword);

        loginPage.clickOnLoginBtn();
        hp.clickOnSidebarMenuIcon();

    }

    @Test(priority = 3)
    public void verifyLogoutNegative() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());

        String tabName = "Dashboard";

        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();

        homepagePage.clickonMainMenuOptions(tabName);
        homepagePage.clickOnLogoutButton();

        // Check if the login page header is displayed
        boolean displayHeader = loginPage.checkPresenceOfLoginPageHeader();
        Assert.assertFalse(displayHeader, "Login page header is displayed after logout.");
    }


    @Test(priority = 4)
    public void verifyQuickLaunchMenuVisible() {
        LoginPage loginPage = new LoginPage(getDriver());
        DashboardPage dP = new DashboardPage(getDriver());

        loginPage.enteringUserNamePassWord(validUsername, validPassword);

        loginPage.clickOnLoginBtn();

        String actualText = "Quick Launch";
        String expectedText = dP.QuickLaunchText();

        Assert.assertEquals(actualText, expectedText);
        log.info("Quick Launch Menu accessible success");


    }

    @Test(priority = 5)
    public void supportText() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        String tabName = "Dashboard";

        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();

        homepagePage.clickonMainMenuOptions(tabName);
        loginPage.clickOnLoginBtn();
        dashboardPage.clickOnSupport();

        String actualMessage = supportTextMessage;
        String expectedMessage = dashboardPage.GetSupportText();

        Assert.assertEquals(actualMessage, expectedMessage);
        log.info("Support Text Visible success");

    }

    @Test
    public void navigateToUserManual() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        String tabName = "Dashboard";

        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();

        homepagePage.clickonMainMenuOptions(tabName);

        dashboardPage.clickOnHelp();

        String ActualText = getCurrentUrl();
        String ExpectedText = "starter";
        log.info(ActualText);

        Assert.assertTrue(ActualText.contains(ExpectedText));
    }


}
