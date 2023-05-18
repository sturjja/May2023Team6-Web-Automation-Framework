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



    @FindBy(xpath = "//div[contains(text(),'No items found')]")
    WebElement homePageHeader;

    @FindBy(xpath = "//body/div[@id='ui']/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/i[1]")
    WebElement clickOnSettingButton;

    @FindBy(xpath = "//span[contains(text(),'Log Out')]")
    WebElement clickOnLogoutButton;

    public void ClickOnSaveButton(){
        clickOn(clickOnSaveButton);
    }

    public void enterTitle(String newtask){
        type(NewTaskTitleField, newtask);

    }



    public void clickOnCreateButton(){
        clickOn(clickOnCreateButton);
    }

    public void clickOnSettingButton(){
        clickOn(clickOnSettingButton);
    }
    public void clickOnLogOutButton(){
        clickOn(clickOnLogoutButton);
        log.info("Click on logout button success");
    }
    public void clickOnTaskMenuItem(){
        clickOn(clickOnTaskMenuItem);
    }



    public String getHomePageHeader(){
        String text = getElementText(homePageHeader);
        log.info("User login success");
        return text;
    }

}
