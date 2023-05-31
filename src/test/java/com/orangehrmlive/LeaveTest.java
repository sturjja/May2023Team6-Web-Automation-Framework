package com.orangehrmlive;

import com.team6.base.CommonAPI;
import com.team6.pages.orangehrmlive.HomepagePage;
import com.team6.pages.orangehrmlive.LeavePage;
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

public class LeaveTest extends CommonAPI {
    Properties prop = Utility.loadProperties();
    Logger log = LogManager.getLogger(LeaveTest.class.getName());
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
    public void approveLeave() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());

        String tabName = "Leave";

        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();

        homepagePage.clickonMainMenuOptions(tabName);

        LeavePage leavePage = new LeavePage(getDriver());
        leavePage.checkAndApproveLeaveRequest();

        log.info("Check Leave Request Success");

    }

    @Test
    public void VerifyGenerateLeaveReport() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());

        String tabName = "Leave";

        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();

        homepagePage.clickonMainMenuOptions(tabName);

        LeavePage leavePage = new LeavePage(getDriver());
        leavePage.clickOnReports();
        leavePage.clickOnLeaveUsagesReport();
        leavePage.clickOnGenerateReport();

        String ActualMessage = leavePage.getRecordsFoundMessage();
        Assert.assertTrue(ActualMessage.contains("Records Found") || ActualMessage.contains("No records found"));
        log.info("Verify leave report generation Success");
    }


    @Test(priority = 2)
    public void rejectingLeave() {
        LoginPage lp = new LoginPage(getDriver());
        HomepagePage hp = new HomepagePage(getDriver());

        lp.enteringUserNamePassWord();
        lp.clickOnLoginBtn();
        hp.clickOnLeave();
        hp.selectPendingApprovals();

    }

}