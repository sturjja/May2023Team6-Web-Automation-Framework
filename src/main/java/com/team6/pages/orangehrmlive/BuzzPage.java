package com.team6.pages.orangehrmlive;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuzzPage extends CommonAPI {
    Logger log = LogManager.getLogger(HomePage.class.getName());

    public BuzzPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()=' Share Photos']")
    WebElement SharePhotosButton;
    @FindBy(xpath = "(//textarea[@rows='1'])[2]")
    WebElement TextArea;
    @FindBy(xpath = "//input[@type='file']")
    WebElement AddPhoto;
    @FindBy(xpath = "(//div[@id='app']//button[@type=\"submit\"])[2]")
    WebElement ShareBtn;
    @FindBy(xpath = "//p[text()='Success']")
    WebElement ToastMessage;
    @FindBy(xpath = "//button[text()=' Most Recent Posts ']")
    WebElement MostRecentPostBtn;
    @FindBy(xpath = "(//div[@class='orangehrm-buzz-post-actions']//button)[1]")
    WebElement CommentIcon;
    @FindBy(xpath = "//input[@placeholder='Write your comment...']")
    WebElement CommentText;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[11]/a")
    WebElement BuzzPageButton;

    // click on Share Photo button
    // write text
    //upload the pic
    // click on Share
    //catch success message
    public void typeAndEnter(WebElement element, String text) {
        element.sendKeys(text, Keys.ENTER);
    }

    public void clickOnSharePhotosButton() {
        clickOn(SharePhotosButton);
        log.info("Share Photos Button clicked");
    }

    public void clickOnBuzzFeed(){
        clickOn(BuzzPageButton);
    }

    public void typeText(String text) {
        type(TextArea, text);
        log.info("Text set to What's on your mind");
    }

    public void uploadImage(String ImagePath) {
        AddPhoto.sendKeys(ImagePath);
        log.info("Image successfully uploaded");
    }

    public void clickOnShareBtn() {
        clickOn(ShareBtn);
        log.info("Share button clicked");
    }

    public String toastMessage() {
        String toastMessage = ToastMessage.getText();
        log.info("Toast message successfully captured");
        return toastMessage;
    }

    public void clickOnMostRecentPost() {
        clickOn(MostRecentPostBtn);
        log.info("Most recent post button clicked");
    }

    public void clickOnCommentIcon() {
        clickOn(CommentIcon);
        log.info("Comment icon clicked");
    }

    public void publishComment(String text) {
        typeAndEnter(CommentText, text);
    }

}
