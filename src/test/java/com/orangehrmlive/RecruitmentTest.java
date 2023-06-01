package com.orangehrmlive;

import com.team6.base.CommonAPI;
import com.team6.pages.orangehrmlive.HomepagePage;
import com.team6.pages.orangehrmlive.LoginPage;
import com.team6.pages.orangehrmlive.RecruitmentPage;
import com.team6.utility.Utility;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Properties;

public class RecruitmentTest extends CommonAPI {
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
//
//    }

    @Test(dataProviderClass = Utility.class, dataProvider = "info")
    public void VerifyAddCandidate(String first, String last, String number, String email, String notes) {

        LoginPage loginPage = new LoginPage(getDriver());
        HomepagePage homepagePage = new HomepagePage(getDriver());

        String tabName = "Recruitment";

        loginPage.enteringUserNamePassWord(validUsername, validPassword);
        loginPage.clickOnLoginBtn();
        homepagePage.clickonMainMenuOptions(tabName);

        RecruitmentPage recruitmentPage = new RecruitmentPage(getDriver());

        recruitmentPage.clickAddCandidateButton();

        recruitmentPage.enterFirstName(first);
        recruitmentPage.enterLastName(last);
        recruitmentPage.enterContactNumber(number);
        recruitmentPage.enterEmail(email);
        recruitmentPage.typeNotes(notes);

        recruitmentPage.clickOnConsent();
        recruitmentPage.clickSaveButton();

    }
}