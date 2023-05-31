package com.team6.pages.automation.scaledupit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.team6.base.CommonAPI;
public class PostsPage extends CommonAPI {
    Logger log = LogManager.getLogger(PostsPage.class.getName());
    public PostsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //locators
    @FindBy(xpath = "/html/body")
    WebElement page ;
    @FindBy(xpath = "//*[@id=\"recent-posts-5\"]/ul/li[1]/a")
    WebElement quickLinkToLaptopPost ;
    @FindBy(xpath = "//*[@id=\"recent-posts-5\"]/ul/li[2]/a")
    WebElement quickLinkToTelevisionPost ;
    @FindBy(xpath = "//*[@id=\"recent-posts-5\"]/ul/li[3]/a")
    WebElement quickLinkToFuninShopPost ;
    @FindBy(xpath = "//*[@id=\"recent-posts-5\"]/ul/li[4]/a")
    WebElement quickLinkToWinterisComingPost;
    @FindBy(xpath = "//*[@id=\"recent-posts-5\"]/ul/li[5]/a")
    WebElement quickLinkToChristmasDiscountPost;
    @FindBy(xpath = "//*[@id=\"recent-posts-5\"]/ul/li[6]/a")
    WebElement quickLinkToNewArrivalPost ;


    public void scrollDownPage() {
        scrollDownThePage(quickLinkToLaptopPost);
        log.info("Successfully scrolled down the page to laptop post");

    }
    public void clickLinkToLaptopPost(){
        clickOn(quickLinkToLaptopPost);
        log.info("click on link to laptop post success");
    }
    public void clickLinkToTelevisionPost(){
        clickOn(quickLinkToTelevisionPost);
        log.info("click on link to television post success");
    }
    public void clickLinkToFunInShopPost(){
        clickOn(quickLinkToFuninShopPost);
        log.info("click on link to fun in shop post success");
    }
    public void clickLinkToWinterIsComingPost(){
        clickOn(quickLinkToWinterisComingPost);
        log.info("click on link to winter is coming post success");
    }
    public void clickLinkToChristmasDiscountPost(){
        clickOn(quickLinkToChristmasDiscountPost);
        log.info("click on link to christmas discount post success");
    }
    public void clickLinkToNewArrivalPost(){
        clickOn(quickLinkToNewArrivalPost);
        log.info("click on link to new arrival post success");
    }
}