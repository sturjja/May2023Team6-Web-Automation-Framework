package com.orangehrmlive;

import com.team6.base.CommonAPI;
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

public class HomepageTest extends CommonAPI {
    Properties prop = Utility.loadProperties();
    Logger log = LogManager.getLogger(HomepageTest.class.getName());
    String validUsername = Utility.decode(prop.getProperty("orangeHRM.username"));
    String validPassword = Utility.decode(prop.getProperty("orangeHRM.password"));
    String invalidUsername = Utility.decode(prop.getProperty("orangeHRM.invalidUserName"));
    String invalidPassword = Utility.decode(prop.getProperty("orangeHRM.invalidPassword"));

    @BeforeMethod
    @Override
    public void setUp(@Optional("false") String useCloudEnv, @Optional("browserstack") String envName, @Optional("windows") String os,
                      @Optional("10") String osVersion, @Optional("chrome") String browserName, @Optional("110") String browserVersion,
                      @Optional("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login") String url) throws MalformedURLException {
        super.setUp(useCloudEnv, envName, os, osVersion, browserName, browserVersion, url);
    }

    @Test(priority = 1)
    public void navigateToAdmin() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());

        String tabName = "Admin";

        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();

        homepagePage.clickonMainMenuOptions(tabName);

        String ActualTabName = homepagePage.menuTabConfirmation();
        String ExpectedTabName = tabName.toLowerCase();

        Assert.assertEquals(ActualTabName, ExpectedTabName);

        log.info(tabName + " is clickable from menu -- Success");


    }

    @Test(priority = 2)
    public void navigateToPIM() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());

        String tabName = "PIM";

        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();

        homepagePage.clickonMainMenuOptions(tabName);

        String ActualTabName = homepagePage.menuTabConfirmation();
        String ExpectedTabName = tabName.toLowerCase();

        Assert.assertEquals(ActualTabName, ExpectedTabName);
        log.info(tabName + " is clickable from menu -- Success");

    }

    @Test(priority = 3)
    public void navigateToLeave() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());

        String tabName = "Leave";

        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();

        homepagePage.clickonMainMenuOptions(tabName);

        String ActualTabName = homepagePage.menuTabConfirmation();
        String ExpectedTabName = tabName.toLowerCase();

        Assert.assertEquals(ActualTabName, ExpectedTabName);
        log.info(tabName + " is clickable from menu -- Success");


    }

    @Test(priority = 4)
    public void navigateToTime() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());

        String tabName = "Time";

        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();

        homepagePage.clickonMainMenuOptions(tabName);

        String ActualTabName = homepagePage.menuTabConfirmation();
        String ExpectedTabName = tabName.toLowerCase();

        Assert.assertEquals(ActualTabName, ExpectedTabName);
        log.info(tabName + " is clickable from menu -- Success");

    }

    @Test(priority = 5)
    public void navigateToRecruitment() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());

        String tabName = "Recruitment";

        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();

        homepagePage.clickonMainMenuOptions(tabName);

        String ActualTabName = homepagePage.menuTabConfirmation();
        String ExpectedTabName = tabName.toLowerCase();

        Assert.assertEquals(ActualTabName, ExpectedTabName);
        log.info(tabName + " is clickable from menu -- Success");

    }

    @Test(priority = 6)
    public void navigateToMyInfo() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());
        String tabName = "My Info";

        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();

        homepagePage.clickonMainMenuOptions("My Info");
    }

    @Test(priority = 7)
    public void navigateToPerformance() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());
        String tabName = "Performance";

        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();

        homepagePage.clickonMainMenuOptions(tabName);

        String ActualTabName = homepagePage.menuTabConfirmation();
        String ExpectedTabName = tabName.toLowerCase();

        Assert.assertEquals(ActualTabName, ExpectedTabName);
        log.info(tabName + " is clickable from menu -- Success");

    }

    @Test(priority = 8)
    public void navigateToDirectory() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());
        String tabName = "Directory";

        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();

        homepagePage.clickonMainMenuOptions(tabName);

        String ActualTabName = homepagePage.menuTabConfirmation();
        String ExpectedTabName = tabName.toLowerCase();

        Assert.assertEquals(ActualTabName, ExpectedTabName);
        log.info(tabName + " is clickable from menu -- Success");
    }

    @Test(priority = 9)
    public void navigateToMaintenance() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());

        String tabName = "Maintenance";
        String maintenancePageHeader = "Administrator Access";

        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();

        homepagePage.clickonMainMenuOptions(tabName);

        String ActualTitleName = homepagePage.mainteneanceAccessTitle();
        String ExpectedTitleName = maintenancePageHeader.toLowerCase();

        Assert.assertEquals(ActualTitleName, ExpectedTitleName);
        log.info(tabName + " is clickable from menu -- Success");
    }

    @Test(priority = 10)
    public void navigateToBuzz() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());
        String tabName = "Buzz";
        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();
        homepagePage.clickonMainMenuOptions(tabName);

        String ActualTabName = homepagePage.menuTabConfirmation();
        String ExpectedTabName = tabName.toLowerCase();

        Assert.assertEquals(ActualTabName, ExpectedTabName);
        log.info(tabName + " is clickable from menu -- Success");
    }

}