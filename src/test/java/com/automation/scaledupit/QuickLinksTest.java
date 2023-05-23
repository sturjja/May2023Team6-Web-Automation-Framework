package com.automation.scaledupit;

import com.team6.base.CommonAPI;
import com.team6.pages.automation.scaledupit.LinksPage;
import com.team6.pages.automation.scaledupit.HomePage;
import com.team6.pages.automation.scaledupit.LoginPage;
import com.team6.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Properties;

public class QuickLinksTest extends CommonAPI {
    Logger log = LogManager.getLogger(QuickLinksTest.class.getName());
    Properties prop = Utility.loadProperties();
    String validUsername = Utility.decode(prop.getProperty("scaledupit.username"));
    String validPassword = Utility.decode(prop.getProperty("scaledupit.password"));
    @Test
    public void linkToHomePage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        LinksPage linksPage = new LinksPage(getDriver());
        //land on home page
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        waitFor(3);
        //enter  username, password, and click on login button
        loginPage.clickOnMyAccountBtn();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();
        //check user is logged in
        String expectedHomePageHeader = "My account";
        String actualHomePageHeader = homePage.getHeaderText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        waitFor(3);
        //scroll down the page
        linksPage.scrollDownPage();
        waitFor(3);
        //click on account details button
        linksPage.clickOnHomePageLink();
        //check user is in correct place
        String expectedHomePageTitle = "Automation – Automate eCommerce";
        String actualHomePageTitle = getCurrentTitle();
        Assert.assertEquals(expectedHomePageTitle, actualHomePageTitle);
        waitFor(3);
    }
    @Test
    public void linkToShopPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        LinksPage linksPage = new LinksPage(getDriver());
        //land on home page
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        waitFor(3);
        //enter  username, password, and click on login button
        loginPage.clickOnMyAccountBtn();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();
        //check user is logged in
        String expectedHomePageHeader = "My account";
        String actualHomePageHeader = homePage.getHeaderText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        waitFor(3);
        //scroll down the page
        linksPage.scrollDownPage();
        waitFor(3);
        //click on account details button
        linksPage.clickOnShopPageLink();
        //check user is in correct place
        String expectedShopPageTitle = "Products – Automation";
        String actualShopPageTitle = getCurrentTitle();
        Assert.assertEquals(expectedShopPageTitle, actualShopPageTitle);
        waitFor(3);
    }
    @Test
    public void linkToMenCollectionPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        LinksPage linksPage = new LinksPage(getDriver());
        //land on home page
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        waitFor(3);
        //enter  username, password, and click on login button
        loginPage.clickOnMyAccountBtn();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();
        //check user is logged in
        String expectedHomePageHeader = "My account";
        String actualHomePageHeader = homePage.getHeaderText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        waitFor(3);
        //scroll down the page
        linksPage.scrollDownPage();
        waitFor(3);
        //click on account details button
        linksPage.clickOnMenCollectionPageLink();
        //check user is in correct place
        String expectedMenCollectionPageTitle = "Men Collection – Automation";
        String actualMenCollectionPageTitle = getCurrentTitle();
        Assert.assertEquals(expectedMenCollectionPageTitle, actualMenCollectionPageTitle);
        waitFor(3);

    }
    @Test
    public void linkToWomenCollectionPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        LinksPage linksPage = new LinksPage(getDriver());
        //land on home page
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        waitFor(3);
        //enter  username, password, and click on login button
        loginPage.clickOnMyAccountBtn();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();
        //check user is logged in
        String expectedHomePageHeader = "My account";
        String actualHomePageHeader = homePage.getHeaderText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        waitFor(3);
        //scroll down the page
        linksPage.scrollDownPage();
        waitFor(3);
        //click on account details button
        linksPage.clickOnWomenCollectionPageLink();
        //check user is in correct place
        String expectedWomenCollectionPageTitle = "Women Collection – Automation";
        String actualWomenCollectionPageTitle = getCurrentTitle();
        Assert.assertEquals(expectedWomenCollectionPageTitle, actualWomenCollectionPageTitle);
        waitFor(3);

    }
    @Test
    public void linkToMyaccountPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        LinksPage linksPage = new LinksPage(getDriver());
        //land on home page
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        waitFor(3);
        //enter  username, password, and click on login button
        loginPage.clickOnMyAccountBtn();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();
        //check user is logged in
        String expectedHomePageHeader = "My account";
        String actualHomePageHeader = homePage.getHeaderText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        waitFor(3);
        //scroll down the page
        linksPage.scrollDownPage();
        waitFor(3);
        //click on account details button
        linksPage.clickOnMyaccountPageLink();
        //check user is in correct place
        String expectedMyaccountPageTitle = "My account – Automation";
        String actualMyaccountPageTitle = getCurrentTitle();
        Assert.assertEquals(expectedMyaccountPageTitle, actualMyaccountPageTitle);
        waitFor(3);

    }
    @Test
    public void linkToCartPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        LinksPage linksPage = new LinksPage(getDriver());
        //land on home page
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        waitFor(3);
        //enter  username, password, and click on login button
        loginPage.clickOnMyAccountBtn();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();
        //check user is logged in
        String expectedHomePageHeader = "My account";
        String actualHomePageHeader = homePage.getHeaderText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        waitFor(3);
        //scroll down the page
        linksPage.scrollDownPage();
        waitFor(3);
        //click on account details button
        linksPage.clickOnCartPageLink();
        //check user is in correct place
        String expectedCartPageTitle = "Cart – Automation";
        String actualCartPageTitle = getCurrentTitle();
        Assert.assertEquals(expectedCartPageTitle, actualCartPageTitle);
        waitFor(3);

    }
    @Test
    public void linkToCheckoutPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        LinksPage linksPage = new LinksPage(getDriver());
        //land on home page
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        waitFor(3);
        //enter  username, password, and click on login button
        loginPage.clickOnMyAccountBtn();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();
        //check user is logged in
        String expectedHomePageHeader = "My account";
        String actualHomePageHeader = homePage.getHeaderText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        waitFor(3);
        //scroll down the page
        linksPage.scrollDownPage();
        waitFor(3);
        //click on account details button
        linksPage.clickOnCheckoutPageLink();
        //check user is in correct place
        String expectedCheckoutPageTitle = "Checkout – Automation";
        String actualCheckoutPageTitle = getCurrentTitle();
        Assert.assertEquals(expectedCheckoutPageTitle, actualCheckoutPageTitle);
        waitFor(3);

    }
    @Test
    public void linkToBlogPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        LinksPage linksPage = new LinksPage(getDriver());
        //land on home page
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        waitFor(3);
        //enter  username, password, and click on login button
        loginPage.clickOnMyAccountBtn();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();
        //check user is logged in
        String expectedHomePageHeader = "My account";
        String actualHomePageHeader = homePage.getHeaderText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        waitFor(3);
        //scroll down the page
        linksPage.scrollDownPage();
        waitFor(3);
        //click on account details button
        linksPage.clickOnBlogPageLink();
        //check user is in correct place
        String expectedBlogPageTitle = "Blog – Automation";
        String actualBlogPageTitle = getCurrentTitle();
        Assert.assertEquals(expectedBlogPageTitle, actualBlogPageTitle);
        waitFor(3);

    }
    @Test
    public void linkToLoginSlashRegisterPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        LinksPage linksPage = new LinksPage(getDriver());
        //land on home page
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        waitFor(3);
        //enter  username, password, and click on login button
        loginPage.clickOnMyAccountBtn();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();
        //check user is logged in
        String expectedHomePageHeader = "My account";
        String actualHomePageHeader = homePage.getHeaderText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        waitFor(3);
        //scroll down the page
        linksPage.scrollDownPage();
        waitFor(3);
        //click on account details button
        linksPage.clickOnLoginSlashRegisterPageLink();
        //check user is in correct place
        String expectedLoginSlashRegisterPageTitle = "My account – Automation";
        String actualLoginSlashRegisterPageTitle = getCurrentTitle();
        Assert.assertEquals(expectedLoginSlashRegisterPageTitle, actualLoginSlashRegisterPageTitle);
        waitFor(3);

    }
}
