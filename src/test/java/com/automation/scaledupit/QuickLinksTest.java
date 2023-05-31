package com.automation.scaledupit;

import com.team6.base.CommonAPI;
import com.team6.pages.automation.scaledupit.LinksPage;
import com.team6.pages.automation.scaledupit.HomePage;
import com.team6.pages.automation.scaledupit.LoginPage;
import com.team6.utility.ExcelReader;
import com.team6.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Properties;
import java.io.File;


public class QuickLinksTest extends CommonAPI {
    String currentDir = System.getProperty("user.dir");
    String path = currentDir+ File.separator+"data"+File.separator+"scaledupit.xlsx";
    ExcelReader excelReader = new ExcelReader(path);
    String homeTitle =excelReader.getDataFromCell("QuickLinks",1,1);
    String shopTitle =excelReader.getDataFromCell("QuickLinks",2,1);
    String menCollectionTitle =excelReader.getDataFromCell("QuickLinks",3,1);
    String womenCollectionTitle =excelReader.getDataFromCell("QuickLinks",4,1);
    String myAccountTitle =excelReader.getDataFromCell("QuickLinks",5,1);
    String cartTitle =excelReader.getDataFromCell("QuickLinks",6,1);
    String checkoutTitle =excelReader.getDataFromCell("QuickLinks",7,1);
    String blogTitle =excelReader.getDataFromCell("QuickLinks",8,1);
    String loginSlashRegisterTitle =excelReader.getDataFromCell("QuickLinks",9,1);
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
        //click on home page link
        linksPage.clickOnHomePageLink();
        //check user is in correct place
        String expectedHomePageTitle = homeTitle;
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
        //click on shop page link
        linksPage.clickOnShopPageLink();
        //check user is in correct place
        String expectedShopPageTitle = shopTitle;
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
        //click on men collection page link
        linksPage.clickOnMenCollectionPageLink();
        //check user is in correct place
        String expectedMenCollectionPageTitle = menCollectionTitle;
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
        //click on women collection page link
        linksPage.clickOnWomenCollectionPageLink();
        //check user is in correct place
        String expectedWomenCollectionPageTitle = womenCollectionTitle;
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
        //click on my account page link
        linksPage.clickOnMyaccountPageLink();
        //check user is in correct place
        String expectedMyaccountPageTitle = myAccountTitle;
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
        //click on cart page link
        linksPage.clickOnCartPageLink();
        //check user is in correct place
        String expectedCartPageTitle = cartTitle;
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
        //click on checkout page link
        linksPage.clickOnCheckoutPageLink();
        //check user is in correct place
        String expectedCheckoutPageTitle = checkoutTitle;
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
        //click on Blog page link
        linksPage.clickOnBlogPageLink();
        //check user is in correct place
        String expectedBlogPageTitle = blogTitle;
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
        //click on Login/Register page link
        linksPage.clickOnLoginSlashRegisterPageLink();
        //check user is in correct place
        String expectedLoginSlashRegisterPageTitle = loginSlashRegisterTitle;
        String actualLoginSlashRegisterPageTitle = getCurrentTitle();
        Assert.assertEquals(expectedLoginSlashRegisterPageTitle, actualLoginSlashRegisterPageTitle);
        waitFor(3);

    }
}
