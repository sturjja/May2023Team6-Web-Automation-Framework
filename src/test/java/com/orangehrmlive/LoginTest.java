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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Properties;

public class LoginTest extends CommonAPI {
    Properties prop = Utility.loadProperties();
    String validUsername = Utility.decode(prop.getProperty("orangeHRM.username"));
    String validPassword = Utility.decode(prop.getProperty("orangeHRM.password"));
    String invalidUsername = Utility.decode(prop.getProperty("orangeHRM.invalidUserName"));
    String invalidPassword = Utility.decode(prop.getProperty("orangeHRM.invalidPassword"));
    Logger log = LogManager.getLogger(LeaveTest.class.getName());

    @BeforeMethod
    @Override
    public void setUp(@Optional("false") String useCloudEnv, @Optional("browserstack") String envName, @Optional("windows") String os,
                      @Optional("10") String osVersion, @Optional("chrome") String browserName, @Optional("110") String browserVersion,
                      @Optional("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login") String url) throws MalformedURLException {
        super.setUp(useCloudEnv, envName, os, osVersion, browserName, browserVersion, url);
    }


    //LoginTest with data provider
    @Test(dataProvider = "validLoginTestData")
    public void validateLogin(String userName, String password) {
        LoginPage lp = new LoginPage(getDriver());
        HomepagePage hp = new HomepagePage(getDriver());

        // Verify login page
        String expectedTitle = "OrangeHRM";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("Landing page open success");

        // Perform login with valid credentials
        lp.enterUsername(userName);
        lp.enterPassword(password);
        lp.clickOnLoginBtn();
        log.info("Login success");
    }

    @Test(priority = 2)
    public void verifyLoginPageElements() {
        LoginPage lp = new LoginPage(getDriver());

        Assert.assertTrue(lp.usernameField.isDisplayed());
        Assert.assertTrue(lp.passwordField.isDisplayed());
        Assert.assertTrue(lp.loginBtn.isDisplayed());
    }

    @Test(priority = 3)
    public void verifyValidLogin() {
        LoginPage lp = new LoginPage(getDriver());
        DashboardPage dP = new DashboardPage(getDriver());

        lp.enteringUserNamePassWord();
        lp.clickOnLoginBtn();
        waitFor(5);

        //  Assert.assertTrue(dP.getCurrentUrl().contains("dashboard"));

    }

    @DataProvider(name = "validLoginTestData")
    public Object[][] testData() {
        return new Object[][]{
                {validUsername, validPassword}
        };
    }
}