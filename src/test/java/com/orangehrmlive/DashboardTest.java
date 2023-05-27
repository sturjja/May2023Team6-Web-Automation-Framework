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
    Logger log = LogManager.getLogger(LeaveTest.class.getName());

    @BeforeMethod
    @Override
    public void setUp(@Optional("false") String useCloudEnv, @Optional("browserstack") String envName, @Optional("windows") String os, @Optional("10") String osVersion, @Optional("chrome") String browserName, @Optional("110") String browserVersion, @Optional("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login") String url) throws MalformedURLException {
        super.setUp(useCloudEnv, envName, os, osVersion, browserName, browserVersion, url);
    }

    @Test(priority = 1)
    public void verifyLogout() {
        LoginPage lp = new LoginPage(getDriver());
        LoginPage loginpage = new LoginPage(getDriver());
        loginpage.enteringUserNamePassWord(validUsername, validPassword);

        HomepagePage hp = new HomepagePage(getDriver());
        hp.clickOnLogoutButton();
        Assert.assertTrue(lp.checkPresenceOfLoginPageHeader());
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
        HomepagePage hp = new HomepagePage(getDriver());

        loginPage.enteringUserNamePassWord(validUsername, validPassword);

        loginPage.clickOnLoginBtn();
        hp.clickOnLogoutButton();

        // Wait for 5 seconds to simulate a delay in the logout process
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Check if the login page header is displayed
        boolean isLoginPageHeaderDisplayed = loginPage.checkPresenceOfLoginPageHeader();
        Assert.assertFalse(isLoginPageHeaderDisplayed, "Login page header is displayed after logout.");
    }


    @Test(priority = 4)
    public void verifyQuickLaunchMenuVisible() {
        LoginPage loginPage = new LoginPage(getDriver());
        DashboardPage dP = new DashboardPage(getDriver());

        loginPage.enteringUserNamePassWord(validUsername, validPassword);

        loginPage.clickOnLoginBtn();
        Assert.assertEquals(dP.QuickLaunchText(), "Quick Launch");


    }

    @Test(priority = 5)
    public void supportText() {
        LoginPage lp = new LoginPage(getDriver());
        DashboardPage dP = new DashboardPage(getDriver());
        String supportText = "Should you experience any issues, please do not hesitate to contact us on ossupport@orangehrm.com We will be delighted to help.";
        lp.enteringUserNamePassWord(validUsername, validPassword);
        lp.clickOnLoginBtn();

        dP.clickOnSupport();
        Assert.assertEquals(dP.GetSupportText(), supportText);
        log.info("Support Text Visible success");

    }
}
