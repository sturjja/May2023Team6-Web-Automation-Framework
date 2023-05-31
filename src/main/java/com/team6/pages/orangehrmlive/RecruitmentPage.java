package com.team6.pages.orangehrmlive;


import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RecruitmentPage extends CommonAPI {
    Logger log = LogManager.getLogger(HomepagePage.class.getName());

    public RecruitmentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/button[1]")
    WebElement AddCandidateButton;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement FirstNameField;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement LastNameField;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[2]/input[1]")
    WebElement EmailField;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[2]/input[1]")
    WebElement ContactNumberField;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[6]/div[1]/div[1]/div[1]/div[2]/textarea[1]")
    WebElement NotesField;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[7]/div[1]/div[1]/div[1]/div[2]/div[1]/label[1]/span[1]/i[1]")
    WebElement ConsentToKeepData;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[8]/button[2]")
    WebElement SaveButton;


    //methods
    public void clickAddCandidateButton() {
        clickOn(AddCandidateButton);
    }

    public void enterFirstName(String first) {
        type(FirstNameField, first);
    }

    public void enterLastName(String last) {
        type(LastNameField, last);
    }

    public void enterEmail(String email) {
        type(EmailField, email);
    }

    public void enterContactNumber(String number) {
        type(ContactNumberField, number);
    }

    public void typeNotes(String notes) {
        type(NotesField, notes);
    }

    public void clickOnConsent() {
        clickOn(ConsentToKeepData);
    }

    public void clickSaveButton() {
        clickOn(SaveButton);
    }

}
