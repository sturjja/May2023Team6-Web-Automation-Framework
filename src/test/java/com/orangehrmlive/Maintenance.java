package com.orangehrmlive;

import com.team6.base.CommonAPI;
import com.team6.pages.orangehrmlive.HomePage;
import com.team6.pages.orangehrmlive.LoginPage;
import com.team6.pages.orangehrmlive.MaintenancePage;
import com.team6.utility.Utility;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Properties;

public class Maintenance extends CommonAPI {
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
    @Test
    public void accessMaintenanceTab() {
        LoginPage lp = new LoginPage(getDriver());
        HomePage hp = new HomePage(getDriver());

        lp.enteringUserNamePassWord();
        lp.clickOnLoginBtn();
        hp.clickMaintenance();
        hp.enterPassForMaintenance("admin123");

      //  Assert.assertEquals(hp.maintenanceTabHeader(), "Purge Employee Records");

    }

    @Test
    public void accessDeniedMaintenanceTab() {
        LoginPage lp = new LoginPage(getDriver());
        HomePage hp = new HomePage(getDriver());
        MaintenancePage mP = new MaintenancePage(getDriver());

        lp.enteringUserNamePassWord();
        lp.clickOnLoginBtn();

        mP.clickMaintenance();
        mP.enterPassForMaintenance("admin321");
       // Assert.assertEquals(hp.getDenyMessage(), "Invalid credentials");

    }



}