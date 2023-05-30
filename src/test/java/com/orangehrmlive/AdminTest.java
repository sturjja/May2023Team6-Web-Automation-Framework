package com.orangehrmlive;

import com.team6.base.CommonAPI;
import com.team6.pages.orangehrmlive.AdminPage;
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

public class AdminTest extends CommonAPI {
    Logger log = LogManager.getLogger(LoginPage.class.getName());
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
    public void verifyResetButton() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());
        AdminPage aP = new AdminPage(getDriver());
        String tabName = "Admin";

        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();

        homepagePage.clickonMainMenuOptions(tabName);

        aP.enterUsernameAndEmployeeName("Jon", "Doe");
        aP.clickResetButton();


        Assert.assertTrue(aP.verifyTextBoxEmpty());
        log.info("Verify Reset Button Success");

    }

    @Test(priority = 2)
    public void verifySearchWithValidUserDetails() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());
        AdminPage aP = new AdminPage(getDriver());
        String tabName = "Admin";
        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();
        homepagePage.clickonMainMenuOptions(tabName);


        aP.enterUsernameAndEmployeeName(validUsername);

        aP.clickSearchButton();
        Assert.assertTrue(aP.isNoRecordsFoundMessageDisplayed());

    }

    @Test(priority = 3)
    public void verifySearchWithInvalidUserDetails() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());
        AdminPage aP = new AdminPage(getDriver());
        String tabName = "Admin";
        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();
        homepagePage.clickonMainMenuOptions(tabName);

        aP.enterUsernameAndEmployeeName("admin3216");
        aP.clickSearchButton();

        Assert.assertTrue(aP.isNoRecordsFoundMessageDisplayed());
    }

    @Test(priority = 4)
    public void editOrganizationInfo() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());
        AdminPage aP = new AdminPage(getDriver());
        String tabName = "Admin";
        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();
        homepagePage.clickonMainMenuOptions(tabName);

        aP.clickOnOrganization();
        aP.clickOngeneralInfo();
        aP.enableEdit();
        aP.enterOrganizaationName("PeopleNTech");
        aP.enterRegistrationNumber("0008321");
        aP.enterTaxId("54321");
        aP.saveInfo();

    }


}