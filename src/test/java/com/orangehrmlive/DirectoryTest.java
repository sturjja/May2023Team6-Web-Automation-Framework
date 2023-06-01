package com.orangehrmlive;

import com.team6.base.CommonAPI;
import com.team6.pages.orangehrmlive.DirectoryPage;
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

public class DirectoryTest extends CommonAPI {
    Properties prop = Utility.loadProperties();
    String validUsername = Utility.decode(prop.getProperty("orangeHRM.username"));
    String validPassword = Utility.decode(prop.getProperty("orangeHRM.password"));
    String invalidUsername = Utility.decode(prop.getProperty("orangeHRM.invalidUserName"));
    String invalidPassword = Utility.decode(prop.getProperty("orangeHRM.invalidPassword"));
    String CEOname = Utility.decode(prop.getProperty("orangeHRM.ceoName"));
    String CFOname = Utility.decode(prop.getProperty("orangeHRM.ctoName"));
    String Cfoemail = Utility.decode(prop.getProperty("orangeHRM.ctoEmail"));
    Logger log = LogManager.getLogger(BuzzTest.class.getName());

//    @BeforeMethod
//    @Override
//    public void setUp(@Optional("false") String useCloudEnv, @Optional("browserstack") String envName, @Optional("windows") String os,
//                      @Optional("10") String osVersion, @Optional("chrome") String browserName, @Optional("110") String browserVersion,
//                      @Optional("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login") String url) throws MalformedURLException {
//        super.setUp(useCloudEnv, envName, os, osVersion, browserName, browserVersion, url);
//    }

    @Test
    public void SearchByJobTitle() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();

        String menuTab = "Directory";
        HomepagePage homepagePage = new HomepagePage(getDriver());
        homepagePage.clickonMainMenuOptions(menuTab);

        DirectoryPage directoryPage = new DirectoryPage(getDriver());
        directoryPage.clickJobTitleDropDown();



        String ActualName = directoryPage.checkCeoName();
        String ExpectedName = CEOname;

        Assert.assertEquals(ActualName, ExpectedName);
        log.info("CEO info verification success");
    }

    @Test
    public void checkCurrentCfo() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();

        String menuTab = "Directory";
        HomepagePage homepagePage = new HomepagePage(getDriver());
        homepagePage.clickonMainMenuOptions(menuTab);

        DirectoryPage directoryPage = new DirectoryPage(getDriver());
        directoryPage.enterHints(CFOname);
        directoryPage.clickSearch();

        directoryPage.checkCfoName();

        String ActualName = directoryPage.checkCfoName();
        String ExpectedName = CFOname;

        Assert.assertTrue(ActualName.contains(ExpectedName));
        log.info("CTO name verification success");

    }
}