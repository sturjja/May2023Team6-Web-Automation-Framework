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
    WebElement editBtn ;
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
    @FindBy(xpath = "//*[@id=\"billing_email\"]")
    WebElement emailAddressFieldBilling;
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



    public String getHeaderText(){
        String text = getElementText(addressesPageHeader);
        log.info("user navigated to addresses page success");
        return text;
    }
    public void clickOnEditBtn(){
        clickOn(editBtn);
        log.info("click on edit Button success");
    }
    public void clickOnCountryDropdown(){
        clickOn(countryDropdownBilling);
        log.info("click on Country Dropdown Button success");
    }
    public void enterPartialCountryName(String partialCountryName){
        type(countryFieldBilling, partialCountryName);
        log.info("enter partial country name success");
    }
    public void keyDownTwiceAndSelect(){
        pressEnter(countryKeysBilling);
        log.info("arrow down and enter success");
    }
    public void enterStreetAddressBilling(String partialCountryName){
        type(streetAddressFieldBilling, partialCountryName);
        log.info("enter street address success");
    }
    public void enterApartmentNumberBilling(String partialCountryName){
        type(apartmentNumberFieldBilling, partialCountryName);
        log.info("enter apartment number success");
    }
    public void enterCityBilling(String city){
        type(cityFieldBilling, city);
        log.info("enter city name success");
    }
    public void enterPartialStateName(String partialStateName){
        type(stateFieldBilling, partialStateName);
        log.info("enter partial state name success");
    }
    public void clickOnStateDropdown(){
        clickOn(stateDropdownBilling);
        log.info("click on State Dropdown Button success");
    }
    public void keyDownThriceAndSelect(){
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
    public void clearStreetAddressField(){
        streetAddressFieldBilling.clear();
        log.info("clear street address field success");
    }
    public void clearApartmentNumberField(){
        apartmentNumberFieldBilling.clear();
        log.info("clear apartment number field success");
    }
    public void clearCityField(){
        cityFieldBilling.clear();
        log.info("clear city field success");
    }
    public void clearZipCodeField(){
        zipCodeFieldBilling.clear();
        log.info("clear Zip Code field success");
    }
    public void clearPhoneNumberField(){
        phoneNumberFieldBilling.clear();
        log.info("clear phone number field success");
    }

}
