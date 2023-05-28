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
    Logger log = LogManager.getLogger(AddressesTest.class.getName());
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
        //click on addresses button
        homePage.clickOnAddressesBtn();
        //check user is in correct place
        String expectedAddressesPageHeader = "Addresses";
        String actualAddressesPageHeader = addressesPage.getHeaderText();
        Assert.assertEquals(expectedAddressesPageHeader, actualAddressesPageHeader);
        waitFor(3);
        //click on edit billing address button
        addressesPage.clickOnEditBtnBilling();
        //click on country dropdown menu enter partial country name and choose United States
        addressesPage.clickOnCountryDropdownBilling();
        addressesPage.enterPartialCountryNameBilling(partialCountryName);
        waitFor(3);
        addressesPage.keyDownTwiceAndSelectBilling();
        //enter Street Address
        addressesPage.clearStreetAddressFieldBilling();
        addressesPage.enterStreetAddressBilling(streetAddress);
        //enter Apartment Number
        addressesPage.clearApartmentNumberFieldBilling();
        addressesPage.enterApartmentNumberBilling(apartmentNumber);
        //enter City
        addressesPage.clearCityFieldBilling();
        waitFor(3);
        addressesPage.enterCityBilling(city);
        //click on State dropdown menu and choose New York
        addressesPage.clickOnStateDropdownBilling();
        addressesPage.enterPartialStateNameBilling(partialStateName);
        addressesPage.keyDownThriceAndSelectBilling();
        //enter Zip Code
        addressesPage.clearZipCodeFieldBilling();
        waitFor(3);
        addressesPage.enterZipCodeBilling(zipcode);
        //enter Phone Number
        addressesPage.clearPhoneNumberFieldBilling();
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
        //click on addresses button
        homePage.clickOnAddressesBtn();
        //check user is in correct place
        String expectedAddressesPageHeader = "Addresses";
        String actualAddressesPageHeader = addressesPage.getHeaderText();
        Assert.assertEquals(expectedAddressesPageHeader, actualAddressesPageHeader);
        waitFor(3);
        //click on edit shipping address button
        addressesPage.clickOnEditBtnShipping();
        //click on Country dropdown menu, enter partial country name and choose United States
        addressesPage.clickOnCountryDropdownShipping();
        addressesPage.enterPartialCountryNameShipping(partialCountryName);
        waitFor(3);
        addressesPage.keyDownTwiceAndSelectShipping();
        //enter Street Address
        addressesPage.clearStreetAddressFieldShipping();
        addressesPage.enterStreetAddressShipping(streetAddress);
        //enter Apartment Number
        addressesPage.clearApartmentNumberFieldShipping();
        addressesPage.enterApartmentNumberShipping(apartmentNumber);
        //enter City
        addressesPage.clearCityFieldShipping();
        waitFor(3);
        addressesPage.enterCityShipping(city);
        //click on State dropdown menu and choose New York
        addressesPage.clickOnStateDropdownShipping();
        addressesPage.enterPartialStateNameShipping(partialStateName);
        addressesPage.keyDownThriceAndSelectShipping();
        //enter Zip Code
        addressesPage.clearZipCodeFieldShipping();
        waitFor(3);
        addressesPage.enterZipCodeShipping(zipcode);
        //click on save address button
        addressesPage.clickOnSaveAddressBtnShipping();
        //verify confirmation message
        String expectedMessage = "Address changed successfully.";
        String actualMessage = addressesPage.getConfirmationMessageShipping();
        Assert.assertEquals(expectedMessage, actualMessage);

    }
}
