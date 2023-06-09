package com.automation.scaledupit;

import com.team6.base.CommonAPI;
import com.team6.pages.automation.scaledupit.AddressesPage;
import com.team6.pages.automation.scaledupit.HomePage;
import com.team6.pages.automation.scaledupit.LoginPage;
import com.team6.utility.ConnectDB;
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
    ConnectDB connectDB = new ConnectDB();

    String streetAddress = connectDB.getTableColumnDataString("select * from address;","Address1");
    String apartmentNumber = connectDB.getTableColumnDataString("select * from address;","Address2");
    String city = connectDB.getTableColumnDataString("select * from address;","City");
    String CountryName = connectDB.getTableColumnDataString("select * from address;","Country");
    String StateName = connectDB.getTableColumnDataString("select * from address;","State");
    String zipcode = connectDB.getTableColumnDataString("select * from address;","ZipCode");
    String phoneNumber = connectDB.getTableColumnDataString("select * from address;","PhoneNumber");
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
        addressesPage.enterCountryNameBilling(CountryName);
        waitFor(3);
        addressesPage.enterKeyBilling();
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
        addressesPage.enterStateNameBilling(StateName);
        addressesPage.enterStateKeyBilling();
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
        addressesPage.enterCountryNameShipping(CountryName);
        waitFor(3);
        addressesPage.enterKeyShipping();
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
        addressesPage.enterStateNameShipping(StateName);
        addressesPage.enterStateKeyShipping();
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
    @Test
    public void setBillingAddressWithMissingFields() throws InterruptedException {
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
        addressesPage.enterCountryNameBilling(CountryName);
        waitFor(3);
        addressesPage.enterKeyBilling();
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
        addressesPage.enterStateNameBilling(StateName);
        addressesPage.enterStateKeyBilling();
        //enter Zip Code
        addressesPage.clearZipCodeFieldBilling();
        waitFor(3);
        addressesPage.enterZipCodeBilling(zipcode);
        //enter Phone Number
        addressesPage.clearPhoneNumberFieldBilling();
        waitFor(3);
        addressesPage.enterPhoneNumberBilling("");
        //click on save address button
        addressesPage.clickOnSaveAddressBtn();
        //validate the error message
        String expectedError = "Phone is a required field.";
        String actualError = addressesPage.getErrorMessage();
        Assert.assertEquals(expectedError, actualError);
    }
    @Test
    public void setShippingAddressWithMissingFields() throws InterruptedException {
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
        addressesPage.enterCountryNameShipping(CountryName);
        waitFor(3);
        addressesPage.enterKeyShipping();
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
        addressesPage.enterStateNameShipping(StateName);
        addressesPage.enterStateKeyShipping();
        //enter Zip Code
        addressesPage.clearZipCodeFieldShipping();
        waitFor(3);
        addressesPage.enterZipCodeShipping("");
        //click on save address button
        addressesPage.clickOnSaveAddressBtnShipping();
        //validate the error message
        String expectedError = "ZIP Code is a required field.";
        String actualError = addressesPage.getErrorMessage();
        Assert.assertEquals(expectedError, actualError);
    }
}

