package com.automation.scaledupit;

import com.team6.base.CommonAPI;
import com.team6.pages.automation.scaledupit.AddressesPage;
import com.team6.pages.automation.scaledupit.HomePage;
import com.team6.pages.automation.scaledupit.LoginPage;
import com.team6.utility.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class AddressesTest extends CommonAPI{
    Logger log = LogManager.getLogger(LoginTest.class.getName());

    Properties prop = Utility.loadProperties();
    String validUsername = Utility.decode(prop.getProperty("scaledupit.username"));
    String validPassword = Utility.decode(prop.getProperty("scaledupit.password"));
    String streetAddress = "123 Main Street";
    String apartmentNumber = "2023K";
    String city = "Bronx";
    String partialCountryName = "United";
    String partialStateName = "New";
    String zipcode = "12221";
    String phoneNumber = "314-159-2653";
    @Test
    public void setBillingAddress() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AddressesPage addressesPage = new AddressesPage(getDriver());
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
        //click on account details button
        homePage.clickOnAddressesBtn();
        //check user is in correct place
        String expectedAddressesPageHeader = "Addresses";
        String actualAddressesPageHeader = addressesPage.getHeaderText();
        Assert.assertEquals(expectedAddressesPageHeader, actualAddressesPageHeader);
        waitFor(3);
        //click on edit Billing Address button
        addressesPage.clickOnEditBtn();
        //click on Country dropdown menu and choose United States
        addressesPage.clickOnCountryDropdown();
        addressesPage.enterPartialCountryName(partialCountryName);
        waitFor(3);
        addressesPage.keyDownTwiceAndSelect();
        //enter Street Address
        addressesPage.clearStreetAddressField();
        addressesPage.enterStreetAddressBilling(streetAddress);
        addressesPage.clearApartmentNumberField();
        addressesPage.enterApartmentNumberBilling(apartmentNumber);
        //enter City
        addressesPage.clearCityField();
        waitFor(3);
        addressesPage.enterCityBilling(city);
        //click on State dropdown menu and choose New York
        addressesPage.clickOnStateDropdown();
        addressesPage.enterPartialStateName(partialStateName);
        addressesPage.keyDownThriceAndSelect();
        //enter Zip Code
        addressesPage.clearZipCodeField();
        waitFor(3);
        addressesPage.enterZipCodeBilling(zipcode);
        //enter Phone Number
        addressesPage.clearPhoneNumberField();
        waitFor(3);
        addressesPage.enterPhoneNumberBilling(phoneNumber);
        //click on save address button
        addressesPage.clickOnSaveAddressBtn();
        //verify confirmation message
        String expectedMessage = "Address changed successfully.";
        String actualMessage = addressesPage.getConfirmationMessage();
        Assert.assertEquals(expectedMessage, actualMessage);

    }
    @Test
    public void setShippingAddress() throws InterruptedException {

    }
}
