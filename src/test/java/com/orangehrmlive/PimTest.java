package com.orangehrmlive;

import com.team6.base.CommonAPI;
import com.team6.pages.orangehrmlive.HomepagePage;
import com.team6.pages.orangehrmlive.LoginPage;
import com.team6.pages.orangehrmlive.PimPage;
import com.team6.utility.ExcelReader;
import com.team6.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Properties;

public class PimTest extends CommonAPI {

    Properties prop = Utility.loadProperties();
    String validUsername = Utility.decode(prop.getProperty("orangeHRM.username"));
    String validPassword = Utility.decode(prop.getProperty("orangeHRM.password"));

    @BeforeMethod
    @Override
    public void setUp(@Optional("false") String useCloudEnv, @Optional("browserstack") String envName, @Optional("windows") String os,
                      @Optional("10") String osVersion, @Optional("chrome") String browserName, @Optional("110") String browserVersion,
                      @Optional("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login") String url) throws MalformedURLException {
        super.setUp(useCloudEnv, envName, os, osVersion, browserName, browserVersion, url);
    }

    Logger log = LogManager.getLogger(PimTest.class.getName());
    SoftAssert softAssert = new SoftAssert();

    @Test(priority = 1)
    public void verifyAddEmployee() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());
        PimPage PIM = new PimPage(getDriver());
        String tabName = "PIM";

        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();

        homepagePage.clickonMainMenuOptions(tabName);

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

        lp.enteringUserNamePassWord("Admin", "admin123");
        lp.clickOnLoginBtn();
        PIM.clickOnPIM();
        PIM.SelectAll();
        PIM.clickOnDelete();

        Assert.assertTrue(PIM.confirmDelete());
    }

    @Test(dataProviderClass = Utility.class, dataProvider = "info")
    public void verifyAddEmployeePersonalDetail(String firstName, String lastName, String employeeID, String driverID, String sin, String ssn, String sex, String militaryBranch, String smokerCheckbox) {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());
        PimPage PIM = new PimPage(getDriver());
        String tabName = "PIM";

        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();
        homepagePage.clickonMainMenuOptions(tabName);

        PIM.clickAddEmployeeButton();
        PIM.enterFirstName(firstName);
        PIM.enterLastName(lastName);
        PIM.enterEmployeeID(employeeID);
        PIM.clickSaveButton();

        waitFor(10);
        // Personal Info Page
        PIM.enterDriversID(driverID);
        PIM.enterSSN(ssn);
        PIM.enterSIN(sin);
        PIM.selectGender(sex);
        PIM.enterMilitaryBranch(militaryBranch);
        PIM.smokeerCheckbox(smokerCheckbox);
        waitFor(5);
        PIM.clickSaveInfo();

    }
}

