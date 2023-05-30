package com.team6.pages.automation.scaledupit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.team6.base.CommonAPI;
public class AddressesPage extends CommonAPI {
    Logger log = LogManager.getLogger(AddressesPage.class.getName());
    public AddressesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //locators
    @FindBy(xpath = "//*[@id=\"post-9\"]/header/h1")
    WebElement addressesPageHeader ;
    @FindBy(xpath = "//*[@id=\"post-9\"]/div/div/div/div[2]/div[1]/header/a")
    WebElement editBtnBilling;
    @FindBy(xpath = "//*[@id=\"billing_first_name\"]")
    WebElement firstNameFieldBilling ;
    @FindBy(xpath = "//*[@id=\"billing_last_name\"]")
    WebElement lastNameFieldBilling;
    @FindBy(xpath = "//*[@id=\"billing_address_1\"]")
    WebElement streetAddressFieldBilling;
    @FindBy(xpath = "//*[@id=\"billing_address_2\"]")
    WebElement apartmentNumberFieldBilling;
    @FindBy(xpath = "//*[@id=\"billing_city\"]")
    WebElement cityFieldBilling;
    @FindBy(xpath = "//*[@id=\"billing_postcode\"]")
    WebElement zipCodeFieldBilling;
    @FindBy(css = "input[class='select2-search__field']")
    WebElement countryFieldBilling;
    @FindBy(css = "ul[class='select2-results__options']")
    WebElement countryKeysBilling;
    @FindBy(xpath = "//*[@id=\"billing_phone\"]")
    WebElement phoneNumberFieldBilling;
    @FindBy(xpath = "//*[@id=\"billing_country_field\"]/span/span/span[1]/span/span[2]")
    WebElement countryDropdownBilling;
    @FindBy(xpath = "//*[@id=\"billing_state_field\"]/span/span/span[1]/span/span[2]")
    WebElement stateDropdownBilling;
    @FindBy(xpath = "//*[@id=\"post-9\"]/div/div/div/form/div/p/button")
    WebElement saveAddressBtnBilling;
    @FindBy(css = "input[class='select2-search__field']")
    WebElement stateFieldBilling;
    @FindBy(css = "ul[class='select2-results__options']")
    WebElement stateKeysBilling;
    @FindBy(xpath = "//*[@id=\"post-9\"]/div/div/div/div[1]/div")
    WebElement confirmationMessage;
    @FindBy(xpath = "//*[@id=\"post-9\"]/div/div/div/div[2]/div[2]/header/a")
    WebElement editBtnShipping ;
    @FindBy(xpath = "//*[@id=\"billing_first_name\"]")
    WebElement firstNameFieldShipping ;
    @FindBy(xpath = "//*[@id=\"billing_last_name\"]")
    WebElement lastNameFieldShipping;
    @FindBy(xpath = "//*[@id=\"shipping_address_1\"]")
    WebElement streetAddressFieldShipping;
    @FindBy(xpath = "//*[@id=\"shipping_address_2\"]")
    WebElement apartmentNumberFieldShipping;
    @FindBy(xpath = "//*[@id=\"shipping_city\"]")
    WebElement cityFieldShipping;
    @FindBy(xpath = "//*[@id=\"shipping_postcode\"]")
    WebElement zipCodeFieldShipping;
    @FindBy(css = "input[class='select2-search__field']")
    WebElement countryFieldShipping;
    @FindBy(css = "ul[class='select2-results__options']")
    WebElement countryKeysShipping;
    @FindBy(xpath = "//*[@id=\"shipping_country_field\"]/span/span")
    WebElement countryDropdownShipping;
    @FindBy(xpath = "//*[@id=\"shipping_state_field\"]/span/span")
    WebElement stateDropdownShipping;
    @FindBy(xpath = "//*[@id=\"post-9\"]/div/div/div/form/div/p/button")
    WebElement saveAddressBtnShipping;
    @FindBy(css = "input[class='select2-search__field']")
    WebElement stateFieldShipping;
    @FindBy(css = "ul[class='select2-results__options']")
    WebElement stateKeysShipping;
    @FindBy(xpath = "//*[@id=\"post-9\"]/div/div/div/div/ul/li")
    WebElement errorDisplay;
    @FindBy(xpath = "//*[@id=\"post-9\"]/div/div/div/div/ul/li")
    WebElement errorDisplayShipping;




    public String getHeaderText(){
        String text = getElementText(addressesPageHeader);
        log.info("user navigated to addresses page success");
        return text;
    }
    public void clickOnEditBtnBilling(){
        clickOn(editBtnBilling);
        log.info("click on edit Button success");
    }
    public void clickOnCountryDropdownBilling(){
        clickOn(countryDropdownBilling);
        log.info("click on Country Dropdown Button success");
    }
    public void enterCountryNameBilling(String CountryName){
        type(countryFieldBilling, CountryName);
        log.info("enter partial country name success");
    }
    public void enterKeyBilling(){
        pressEnter(countryKeysBilling);
        log.info("arrow down and enter success");
    }
    public void enterStreetAddressBilling(String partialCountryName){
        type(streetAddressFieldBilling, partialCountryName);
        log.info("enter street address success");
    }
    public void enterApartmentNumberBilling(String apartmentNumber){
        type(apartmentNumberFieldBilling, apartmentNumber);
        log.info("enter apartment number success");
    }
    public void enterCityBilling(String city){
        type(cityFieldBilling, city);
        log.info("enter city name success");
    }
    public void enterStateNameBilling(String StateName){
        type(stateFieldBilling, StateName);
        log.info("enter state name success");
    }
    public void clickOnStateDropdownBilling(){
        clickOn(stateDropdownBilling);
        log.info("click on State Dropdown Button success");
    }
    public void enterStateKeyBilling(){
        pressEnter(stateKeysBilling);
        log.info("arrow down thrice and enter success");
    }
    public void enterZipCodeBilling(String zipcode){
        type(zipCodeFieldBilling, zipcode);
        log.info("enter zipcode success");
    }
    public void enterPhoneNumberBilling(String phoneNumber){
        type(phoneNumberFieldBilling, phoneNumber);
        log.info("enter phone number success");
    }
    public void clickOnSaveAddressBtn(){
        clickOn(saveAddressBtnBilling);
        log.info("click on save address Button success");
    }
    public String getConfirmationMessage(){
        String text = getElementText(confirmationMessage);
        log.info("get confirmation message text success");
        return text;
    }
    public void clearStreetAddressFieldBilling(){
        streetAddressFieldBilling.clear();
        log.info("clear street address field success");
    }
    public void clearApartmentNumberFieldBilling(){
        apartmentNumberFieldBilling.clear();
        log.info("clear apartment number field success");
    }
    public void clearCityFieldBilling(){
        cityFieldBilling.clear();
        log.info("clear city field success");
    }
    public void clearZipCodeFieldBilling(){
        zipCodeFieldBilling.clear();
        log.info("clear Zip Code field success");
    }
    public void clearPhoneNumberFieldBilling(){
        phoneNumberFieldBilling.clear();
        log.info("clear phone number field success");
    }


    public void clickOnEditBtnShipping(){
        clickOn(editBtnShipping);
        log.info("click on edit Button success");
    }
    public void clickOnCountryDropdownShipping(){
        clickOn(countryDropdownShipping);
        log.info("click on Country Dropdown Button success");
    }
    public void enterCountryNameShipping(String CountryName){
        type(countryFieldShipping, CountryName);
        log.info("enter country name success");
    }
    public void enterKeyShipping(){
        pressEnter(countryKeysShipping);
        log.info("arrow down and enter success");
    }
    public void enterStreetAddressShipping(String streetAddress){
        type(streetAddressFieldShipping, streetAddress);
        log.info("enter street address success");
    }
    public void enterApartmentNumberShipping(String apartmentNumber){
        type(apartmentNumberFieldShipping, apartmentNumber);
        log.info("enter apartment number success");
    }
    public void enterCityShipping(String city){
        type(cityFieldShipping, city);
        log.info("enter city name success");
    }
    public void enterStateNameShipping(String StateName){
        type(stateFieldShipping, StateName);
        log.info("enter partial state name success");
    }
    public void clickOnStateDropdownShipping(){
        clickOn(stateDropdownShipping);
        log.info("click on State Dropdown Button success");
    }
    public void enterStateKeyShipping(){
        pressEnter(stateKeysShipping);
        log.info("arrow down thrice and enter success");
    }
    public void enterZipCodeShipping(String zipcode){
        type(zipCodeFieldShipping, zipcode);
        log.info("enter zipcode success");
    }

    public void clickOnSaveAddressBtnShipping(){
        clickOn(saveAddressBtnBilling);
        log.info("click on save address Button success");
    }
    public String getConfirmationMessageShipping(){
        String text = getElementText(confirmationMessage);
        log.info("get confirmation message text success");
        return text;
    }
    public void clearStreetAddressFieldShipping(){
        streetAddressFieldShipping.clear();
        log.info("clear street address field success");
    }
    public void clearApartmentNumberFieldShipping(){
        apartmentNumberFieldShipping.clear();
        log.info("clear apartment number field success");
    }
    public void clearCityFieldShipping(){
        cityFieldShipping.clear();
        log.info("clear city field success");
    }
    public void clearZipCodeFieldShipping(){
        zipCodeFieldShipping.clear();
        log.info("clear Zip Code field success");
    }
    public String getErrorMessage(){
        String text = getElementText(errorDisplay);
        log.info("get error message text success");
        return text;
    }


}
