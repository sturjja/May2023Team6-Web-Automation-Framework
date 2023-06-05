package com.orangehrmlive;

//import com.sun.source.tree.AssertTree;

import com.team6.base.CommonAPI;
import com.team6.pages.orangehrmlive.HomepagePage;
import com.team6.pages.orangehrmlive.LoginPage;
import com.team6.pages.orangehrmlive.MaintenancePage;
import com.team6.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Properties;

public class MaintenanceTest extends CommonAPI {
    Properties prop = Utility.loadProperties();
    String validUsername = Utility.decode(prop.getProperty("orangeHRM.username"));
    String validPassword = Utility.decode(prop.getProperty("orangeHRM.password"));
    String invalidUsername = Utility.decode(prop.getProperty("orangeHRM.invalidUserName"));
    String invalidPassword = Utility.decode(prop.getProperty("orangeHRM.invalidPassword"));
    Logger log = LogManager.getLogger(HomepageTest.class.getName());

//    @BeforeMethod
//    @Override
//    public void setUp(@Optional("false") String useCloudEnv, @Optional("browserstack") String envName, @Optional("windows") String os,
//                      @Optional("10") String osVersion, @Optional("chrome") String browserName, @Optional("110") String browserVersion,
//                      @Optional("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login") String url) throws MalformedURLException {
//        super.setUp(useCloudEnv, envName, os, osVersion, browserName, browserVersion, url);
//    }

    @Test(priority = 1)
    public void accessMaintenanceTab() {
        LoginPage lp = new LoginPage(getDriver());
        MaintenancePage mP = new MaintenancePage(getDriver());
        String tabVerifyMessage = "Purge Employee Records";

        lp.enteringUserNamePassWord(validUsername, validPassword);
        lp.clickOnLoginBtn();
        mP.clickMaintenance();
        mP.enterPassForMaintenance(validPassword);
        mP.clickConfirm();
        String ActualTitleName = mP.maintenanceHeaderText();
        String ExpectedTitleName = tabVerifyMessage.toLowerCase();

        Assert.assertEquals(ActualTitleName, ExpectedTitleName);
        log.info("Maintenance Tab Access with correct credentials success");


    }

    @Test(priority = 2)
    public void accessDeniedMaintenanceTab() {
        LoginPage lp = new LoginPage(getDriver());
        HomepagePage hp = new HomepagePage(getDriver());
        MaintenancePage mP = new MaintenancePage(getDriver());

        lp.enteringUserNamePassWord(validUsername, validPassword);
        lp.clickOnLoginBtn();

        //navigating to Maintenance page
        mP.clickMaintenance();
        mP.enterPassForMaintenance(invalidPassword);
        mP.clickConfirm();

        boolean DenyMessage = mP.showDenyMessage();
        Assert.assertTrue(DenyMessage);

        log.info("Deny access with incorrect credentials success ");
    }

    @Test(priority = 3)
    public void downloadPersonalData() {
        LoginPage lp = new LoginPage(getDriver());
        MaintenancePage mP = new MaintenancePage(getDriver());

        lp.enteringUserNamePassWord(validUsername, validPassword);
        lp.clickOnLoginBtn();

        //navigating to Maintenance page
        mP.clickMaintenance();
        mP.enterPassForMaintenance(validPassword);
        mP.clickConfirm();

        //go to Access Records tab
        mP.clickOnAccessRecords();
        mP.enterHints("a");
        mP.clickSearch();
        mP.downloadRecords();
        mP.waitFor(10);

        log.info("Download personal data Success");
    }

    @Test(priority = 4)
    public void deletingCandidateRecords() {
        LoginPage lp = new LoginPage(getDriver());
        MaintenancePage mP = new MaintenancePage(getDriver());

        lp.enteringUserNamePassWord(validUsername, validPassword);
        lp.clickOnLoginBtn();

        //navigating to Maintenance page
        mP.clickMaintenance();
        mP.enterPassForMaintenance(validPassword);
        mP.clickConfirm();
        mP.clickOnPurgeRecordsMenu();
        mP.clickOncandidateRecords();
        mP.selectCandidateRoleByName("QA");
        mP.clickSearchByJobTitle();
        mP.purgeIfRecordsFound();

        boolean PurgeComplete = mP.purgeIfRecordsFound();
        Assert.assertFalse(PurgeComplete);

        log.info("Delete Candidate records success");

    }
}