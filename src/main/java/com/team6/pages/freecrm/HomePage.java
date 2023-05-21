package com.team6.pages.freecrm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.team6.base.CommonAPI;

public class HomePage extends CommonAPI {
    Logger log = LogManager.getLogger(HomePage.class.getName());
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[contains(text(), 'Save')]")
    WebElement clickOnSaveButton;

    @FindBy(xpath = "//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
    WebElement NewTaskTitleField;

    @FindBy(xpath = "//button[contains(text(), 'Create')]")
    WebElement clickOnCreateButton;

    @FindBy(xpath = "//span[contains(text(), 'Tasks')]")
    WebElement clickOnTaskMenuItem;



    @FindBy(xpath = "//span[@class=\"user-display\" and text()=\"Ibna Zaman\"]\n")
    WebElement homePageHeader;

    @FindBy(xpath = "//body/div[@id='ui']/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/i[1]")
    WebElement clickOnSettingButton;

    @FindBy(xpath = "//span[contains(text(),'Log Out')]")
    WebElement clickOnLogoutButton;

    @FindBy(xpath = "//input[@type=\"text\" and @placeholder=\"Search\"]\n")
    WebElement searchField;

    @FindBy(xpath = "//a[@href=\"/contacts/220a97ab-5b94-4c07-bbb9-d91d08055b44\" and text()=\"Lionel Messi\"]\n")
    WebElement actualContactNameTitle;

    public String getActualContactNameTitle(){
        String text = getElementText(actualContactNameTitle);
        return text;
    }

    public void typeOnSearchField(String searchContact){
        type(searchField , searchContact);
    }




    public void ClickOnSaveButton(){
        clickOn(clickOnSaveButton);
        log.info("clicked on save button");
    }

    public void enterTitle(String newtask){
        type(NewTaskTitleField, newtask);

    }



    public void clickOnCreateButton(){
        clickOn(clickOnCreateButton);
        log.info("clicked on create button");
    }

    public void clickOnSettingButton(){
        clickOn(clickOnSettingButton);
        log.info("clicked on settings button");
    }
    public void clickOnLogOutButton(){
        clickOn(clickOnLogoutButton);
        log.info("Click on logout button success");
    }
    public void clickOnTaskMenuItem(){
        clickOn(clickOnTaskMenuItem);
        log.info("clicked on task menu item");
    }



    public String getHomePageHeader(){
        String text = getElementText(homePageHeader);
        log.info("User login success");
        return text;
    }
}
