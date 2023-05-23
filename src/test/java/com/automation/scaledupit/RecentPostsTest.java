package com.automation.scaledupit;

import com.team6.base.CommonAPI;
import com.team6.pages.automation.scaledupit.HomePage;
import com.team6.pages.automation.scaledupit.PostsPage;
import com.team6.pages.automation.scaledupit.LoginPage;
import com.team6.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class RecentPostsTest extends CommonAPI {
    Logger log = LogManager.getLogger(RecentPostsTest.class.getName());
    Properties prop = Utility.loadProperties();
    String validUsername = Utility.decode(prop.getProperty("scaledupit.username"));
    String validPassword = Utility.decode(prop.getProperty("scaledupit.password"));
    @Test
    public void linkToLaptopPost() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PostsPage postsPage = new PostsPage(getDriver());
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
        postsPage.scrollDownPage();
        waitFor(3);
        //click on account details button
        postsPage.clickLinkToLaptopPost();
        //check user is in correct place
        String expectedLaptopPostPageTitle = "Laptop – Automation";
        String actualLaptopPostPageTitle = getCurrentTitle();
        Assert.assertEquals(expectedLaptopPostPageTitle, actualLaptopPostPageTitle);
        waitFor(3);

    }
    @Test
    public void linkToTelevisionPost() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PostsPage postsPage = new PostsPage(getDriver());
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
        postsPage.scrollDownPage();
        waitFor(3);
        //click on account details button
        postsPage.clickLinkToTelevisionPost();
        //check user is in correct place
        String expectedTelevisionPostPageTitle = "Television – Automation";
        String actualTelevisionPostPageTitle = getCurrentTitle();
        Assert.assertEquals(expectedTelevisionPostPageTitle, actualTelevisionPostPageTitle);
        waitFor(3);
    }

    @Test
    public void linkToFunInShopPost() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PostsPage postsPage = new PostsPage(getDriver());
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
        postsPage.scrollDownPage();
        waitFor(3);
        //click on account details button
        postsPage.clickLinkToFunInShopPost();
        //check user is in correct place
        String expectedFunInShopPostPageTitle = "Fun in Shop – Automation";
        String actualFunInShopPostPageTitle = getCurrentTitle();
        Assert.assertEquals(expectedFunInShopPostPageTitle, actualFunInShopPostPageTitle);
        waitFor(3);

    }
    @Test
    public void linkToWinterIsComingPost() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PostsPage postsPage = new PostsPage(getDriver());
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
        postsPage.scrollDownPage();
        waitFor(3);
        //click on account details button
        postsPage.clickLinkToWinterIsComingPost();
        //check user is in correct place
        String expectedWinterIsComingPostPageTitle = "Winter is Coming – Automation";
        String actualWinterIsComingPostPageTitle = getCurrentTitle();
        Assert.assertEquals(expectedWinterIsComingPostPageTitle, actualWinterIsComingPostPageTitle);
        waitFor(3);

    }
    @Test
    public void linkToChristmasDiscountPost() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PostsPage postsPage = new PostsPage(getDriver());
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
        postsPage.scrollDownPage();
        waitFor(3);
        //click on account details button
        postsPage.clickLinkToChristmasDiscountPost();
        //check user is in correct place
        String expectedChristmasDiscountPostPageTitle = "Christmas Discount – Automation";
        String actualChristmasDiscountPostPageTitle = getCurrentTitle();
        Assert.assertEquals(expectedChristmasDiscountPostPageTitle, actualChristmasDiscountPostPageTitle);
        waitFor(3);

    }
    @Test
    public void linkToNewArrivalPost() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PostsPage postsPage = new PostsPage(getDriver());
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
        postsPage.scrollDownPage();
        waitFor(3);
        //click on account details button
        postsPage.clickLinkToNewArrivalPost();
        //check user is in correct place
        String expectedNewArrivalPostPageTitle = "New Arrival – Automation";
        String actualNewArrivalPostPageTitle = getCurrentTitle();
        Assert.assertEquals(expectedNewArrivalPostPageTitle, actualNewArrivalPostPageTitle);
        waitFor(3);

    }
}
