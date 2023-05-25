package com.orangehrmlive;

import com.team6.base.CommonAPI;
import com.team6.pages.orangehrmlive.DashboardPage;
import com.team6.pages.orangehrmlive.HomePage;
import com.team6.pages.orangehrmlive.LoginPage;
import com.team6.utility.Utility;
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

    @BeforeMethod
    @Override
    public void setUp(@Optional("false") String useCloudEnv, @Optional("browserstack") String envName, @Optional("windows") String os, @Optional("10") String osVersion, @Optional("chrome") String browserName, @Optional("110") String browserVersion, @Optional("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login") String url) throws MalformedURLException {
        super.setUp(useCloudEnv, envName, os, osVersion, browserName, browserVersion, url);
    }

    @Test
    public void verifyLogout() {
        LoginPage lp = new LoginPage(getDriver());
        HomePage hp = new HomePage(getDriver());

        lp.enteringUserNamePassWord();
        lp.clickOnLoginBtn();
        hp.clickOnLogoutButton();

        Assert.assertTrue(lp.checkPresenceOfLoginPageHeader());
    }

    @Test
    public void validateSidebarMenuButton() {
        LoginPage lp = new LoginPage(getDriver());
        HomePage hp = new HomePage(getDriver());

        lp.enteringUserNamePassWord();
        lp.clickOnLoginBtn();
        hp.clickOnSidebarMenuIcon();

    }

    @Test
    public void verifyLogoutNegative() {
        LoginPage lp = new LoginPage(getDriver());
        HomePage hp = new HomePage(getDriver());

        lp.enteringUserNamePassWord();
        lp.clickOnLoginBtn();
        hp.clickOnLogoutButton();

        // Wait for 5 seconds to simulate a delay in the logout process
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Check if the login page header is displayed
        boolean isLoginPageHeaderDisplayed = lp.checkPresenceOfLoginPageHeader();
        Assert.assertFalse(isLoginPageHeaderDisplayed, "Login page header is displayed after logout.");
    }


    @Test
    public void verifyQuickLaunchMenuVisible() {
        LoginPage lp = new LoginPage(getDriver());
        DashboardPage dP = new DashboardPage(getDriver());

        lp.enteringUserNamePassWord();
        lp.clickOnLoginBtn();
        Assert.assertEquals(dP.QuickLaunchText(), "Quick Launch");


    }

    @Test
    public void supportText() {
        LoginPage lp = new LoginPage(getDriver());
        DashboardPage dP = new DashboardPage(getDriver());

        lp.enteringUserNamePassWord();
        lp.clickOnLoginBtn();

        dP.clickOnSupport();

        Assert.assertEquals(dP.GetSupportText(), "Should you experience any issues, please do not hesitate to contact us on ossupport@orangehrm.com We will be delighted to help.");

    }

}
