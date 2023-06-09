package com.orangehrmlive;

import com.team6.base.CommonAPI;
import com.team6.pages.orangehrmlive.BuzzPage;
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

public class BuzzTest extends CommonAPI {
    Properties prop = Utility.loadProperties();
    String validUsername = Utility.decode(prop.getProperty("orangeHRM.username"));
    String validPassword = Utility.decode(prop.getProperty("orangeHRM.password"));
    String invalidUsername = Utility.decode(prop.getProperty("orangeHRM.invalidUserName"));
    String invalidPassword = Utility.decode(prop.getProperty("orangeHRM.invalidPassword"));

//    @BeforeMethod
//    @Override
//    public void setUp(@Optional("false") String useCloudEnv, @Optional("browserstack") String envName, @Optional("windows") String os,
//                      @Optional("10") String osVersion, @Optional("chrome") String browserName, @Optional("110") String browserVersion,
//                      @Optional("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login") String url) throws MalformedURLException {
//        super.setUp(useCloudEnv, envName, os, osVersion, browserName, browserVersion, url);
//    }

    Logger log = LogManager.getLogger(BuzzTest.class.getName());

    @Test(dataProviderClass = Utility.class, dataProvider = "info", priority = 1)
    public void postStatusOnBuzzFeed(String StatusText) {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());
        String tabName = "Buzz";

        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();
        homepagePage.clickonMainMenuOptions(tabName);

        BuzzPage bp = new BuzzPage(getDriver());

        bp.enterText(StatusText);
        bp.clickOnShareBtn();

        String actualMessage = bp.getToastMessage();
        String expectedMessage = "Success";

        Assert.assertEquals(actualMessage, expectedMessage);
        log.info("Successfully published a status");

    }

    @Test(priority = 2)
    public void addCommentToMostRecentPost() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());
        String tabName = "Buzz";

        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();

        homepagePage.clickonMainMenuOptions(tabName);

        BuzzPage buzzpage = new BuzzPage(getDriver());
        buzzpage.clickOnMostRecentPost();
        buzzpage.clickOnCommentIcon();
        buzzpage.publishComment("Hello World");

        String ToastMessage = buzzpage.getToastMessage();
        String ExpectedResult = "Success";

        Assert.assertEquals(ToastMessage, ExpectedResult);
        log.info("Successfully published a comment");

    }

}