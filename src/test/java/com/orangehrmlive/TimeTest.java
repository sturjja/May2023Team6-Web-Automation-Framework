package com.orangehrmlive;

import com.team6.base.CommonAPI;
import com.team6.pages.orangehrmlive.HomepagePage;
import com.team6.pages.orangehrmlive.LoginPage;
import com.team6.pages.orangehrmlive.TimeTestPage;
import com.team6.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Properties;

public class TimeTest extends CommonAPI {
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

    @Test(priority = 1)
    public void timesheetsCheck() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());

        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();
        String MenuTab = "Time";

        homepagePage.clickonMainMenuOptions(MenuTab);

        TimeTestPage timeTestPage = new TimeTestPage(getDriver());
        timeTestPage.checkTimeSheets();
    }

    @Test(priority = 2)
    public void checkAttendanceRecord() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());


        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();
        String MenuTab = "Time";

        homepagePage.clickonMainMenuOptions(MenuTab);

        TimeTestPage timeTestPage = new TimeTestPage(getDriver());
        boolean flag = timeTestPage.showAttendanceRecords();

        Assert.assertFalse(flag, "No Records Found");
        log.info("Check attendance record success");

    }

    @Test(priority = 3)
    public void viewProjectReport() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());


        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();
        String MenuTab = "Time";

        homepagePage.clickonMainMenuOptions(MenuTab);

        TimeTestPage timeTestPage = new TimeTestPage(getDriver());

        timeTestPage.clickOnReports();
        timeTestPage.clickOnProjectReports();
        timeTestPage.enterProjectNameHints("ACME");
        timeTestPage.clickOnView();

        timeTestPage.checkForRecords();
        Assert.assertTrue(timeTestPage.checkForRecords());
        log.info("View Project Report Success");
    }

    @Test(priority = 4)
    public void checkAttendanceSummary() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());


        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();
        String MenuTab = "Time";

        homepagePage.clickonMainMenuOptions(MenuTab);

        TimeTestPage timeTestPage = new TimeTestPage(getDriver());

        timeTestPage.clickOnReports();
        timeTestPage.clickOnAttendance();
        timeTestPage.employeeStatusDropdown();
        timeTestPage.clickOnView();

    }

}