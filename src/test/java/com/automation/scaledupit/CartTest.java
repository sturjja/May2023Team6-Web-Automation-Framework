package com.automation.scaledupit;

import com.team6.base.CommonAPI;
import com.team6.pages.automation.scaledupit.HomePage;
import com.team6.pages.automation.scaledupit.LoginPage;
import com.team6.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends CommonAPI {
    Logger log = LogManager.getLogger(CartTest.class.getName());
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
        //go to collection, click on belt and add to cart
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
        homePage.enterCouponCode("");
        homePage.clickOnApplyCouponBtn();
        //validate error message
        String expectedErrorMessage = "Please enter a coupon code.";
        String actualErrorMessage = homePage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        waitFor(3);
    }
    @Test
    public void removeFromCart() throws InterruptedException {
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
        //navigate to cart and click on the X button
        homePage.clickOnViewCartBtn();
        String expectedCurrentTitle = "Cart – Automation";
        String actualCurrentTitle = getCurrentTitle();
        Assert.assertEquals(expectedCurrentTitle, actualCurrentTitle);
        waitFor(3);
        homePage.clickOnXBtn();
        waitFor(3);
        //verify confirmation message
        String expectedConfirmationMessage = "“Belt” removed. Undo?";
        String actualConfirmationMessage = homePage.getCartsConfirmationMessage();
        Assert.assertEquals(expectedConfirmationMessage, actualConfirmationMessage);
        waitFor(3);
    }


    @Test
    public void undoRemoveFromCart() throws InterruptedException {
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
        //navigate to cart and click on the X button
        homePage.clickOnViewCartBtn();
        String expectedCurrentTitle = "Cart – Automation";
        String actualCurrentTitle = getCurrentTitle();
        Assert.assertEquals(expectedCurrentTitle, actualCurrentTitle);
        homePage.clickOnXBtn();
        waitFor(3);
        //verify confirmation message
        String expectedConfirmationMessage = "“Belt” removed. Undo?";
        String actualConfirmationMessage = homePage.getCartsConfirmationMessage();
        Assert.assertEquals(expectedConfirmationMessage, actualConfirmationMessage);
        waitFor(3);
        //Click Undo button
        homePage.clickOnUndoBtn();
        //verify Proceed to Checkout button is visible
        Assert.assertTrue(homePage.checkPresenceOfProceedToCheckoutButton());
    }
}
