package com.automation.scaledupit;

import com.team6.base.CommonAPI;
import com.team6.pages.automation.scaledupit.HomePage;
import com.team6.pages.automation.scaledupit.LoginPage;
import com.team6.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.PageFactory;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class CartTest extends CommonAPI {
    Logger log = LogManager.getLogger(LoginTest.class.getName());
    Properties prop = Utility.loadProperties();
    String validUsername = Utility.decode(prop.getProperty("scaledupit.username"));
    String validPassword = Utility.decode(prop.getProperty("scaledupit.password"));

    @Test
    public void addToCart() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
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
        //go to collection
        homePage.clickOnMenCollectionBtn();
        homePage.clickOnBelt();
        homePage.clickOnAddToCart();
        //verify confirmation message
        String expectedMessage = "View cart\n“Belt” has been added to your cart.";
        String actualMessage = homePage.getConfirmationMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
        waitFor(3);
    }
    @Test
    public void enterInvalidCouponCode() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
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
        //go to collection
        homePage.clickOnMenCollectionBtn();
        homePage.clickOnBelt();
        homePage.clickOnAddToCart();
        //verify confirmation message
        String expectedMessage = "View cart\n“Belt” has been added to your cart.";
        String actualMessage = homePage.getConfirmationMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
        waitFor(3);
        homePage.clickOnViewCartBtn();
        String expectedCurrentTitle = "Cart – Automation";
        String actualCurrentTitle = getCurrentTitle();
        Assert.assertEquals(expectedCurrentTitle, actualCurrentTitle);
        waitFor(3);
        //navigate to cart and enter invalid coupon code
        homePage.enterCouponCode("15OFF");
        homePage.clickOnApplyCouponBtn();
        //validate error message
        String expectedErrorMessage = "Coupon \"15off\" does not exist!";
        String actualErrorMessage = homePage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        waitFor(3);
    }
    @Test
    public void enterEmptyCouponCode() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
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
        //go to collection
        homePage.clickOnMenCollectionBtn();
        homePage.clickOnBelt();
        homePage.clickOnAddToCart();
        //verify confirmation message
        String expectedMessage = "View cart\n“Belt” has been added to your cart.";
        String actualMessage = homePage.getConfirmationMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
        waitFor(3);
        homePage.clickOnViewCartBtn();
        String expectedCurrentTitle = "Cart – Automation";
        String actualCurrentTitle = getCurrentTitle();
        Assert.assertEquals(expectedCurrentTitle, actualCurrentTitle);
        waitFor(3);
        //navigate to cart and enter invalid coupon code
        homePage.enterCouponCode("Please enter a coupon code.");
        homePage.clickOnApplyCouponBtn();
        //validate error message
        String expectedErrorMessage = "";
        String actualErrorMessage = homePage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        waitFor(3);
    }
}
