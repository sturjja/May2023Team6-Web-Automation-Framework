package com.orangehrmlive;

import com.team6.base.CommonAPI;
import com.team6.pages.orangehrmlive.LoginPage;
import com.team6.pages.orangehrmlive.PimPage;
import com.team6.utility.Utility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Properties;

public class PimTest extends CommonAPI {
    Properties prop = Utility.loadProperties();
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
    public void verifyAddEmployee() {
        LoginPage lp = new LoginPage(getDriver());

        PimPage PIM = new PimPage(getDriver());
        lp.enteringUserNamePassWord("Admin","admin123");
        lp.clickOnLoginBtn();

        PIM.    clickOnPIM();
        PIM.clickAddEmployeeButton();
        PIM.enterFirstName("Mohammad");
        PIM.enterLastName("Taseen");
        PIM.clickSaveButton();
        Assert.assertEquals(PIM.showsFirstAndLastName(), "Mohammad Taseen");

    }

    @Test(priority = 2)
    public void deleteEmployeeRecords() {
        LoginPage lp = new LoginPage(getDriver());
        PimPage PIM = new PimPage(getDriver());

        lp.enteringUserNamePassWord("Admin","admin123");
        lp.clickOnLoginBtn();
        PIM.clickOnPIM();
        PIM.SelectAll();
        PIM.clickOnDelete();

        Assert.assertTrue(PIM.confirmDelete());
    }

}

