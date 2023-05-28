package com.team6.pages.freecrm;

import com.team6.base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentsPage extends CommonAPI {
    Logger log = LogManager.getLogger(DocumentsPage.class.getName());

    public DocumentsPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//a[@class=\"item\" and @href=\"/documents\"]\n")
    WebElement documentsButton;
    @FindBy(xpath = "//a[@href=\"/documents/new\"]/button[@class=\"ui linkedin button\"]\n")
    WebElement newDocumentButton;
    @FindBy(xpath = "//input[@autocomplete=\"new-password\" and @name=\"title\" and @type=\"text\"]\n")
    WebElement documentTitleField;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"save icon\"]\n")
    WebElement saveDocumentButton;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"add icon\"]\n")
    WebElement addNotesButton;
    @FindBy(xpath = "//textarea[@rows=\"3\"]\n")
    WebElement noteTextField;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"checkmark icon\"]\n")
    WebElement saveDocumentNoteButton;
    @FindBy(xpath = "//a[@href=\"/documents/folder/204a68bb-b66f-434d-b1cc-245c6263c7a3\"]\n")
    WebElement exportFolder;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"download icon\"]\n")
    WebElement downloadContactDocumentButton;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"folder icon\"]\n")
    WebElement newFolderButton;
    @FindBy(xpath = "//input[@name=\"addFolderName\" and @type=\"text\"]\n")
    WebElement folderNameField;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"checkmark icon\"]\n")
    WebElement saveFolderButton;
    @FindBy(xpath = "//i[@aria-hidden=\"true\" and @class=\"file icon\"]\n")
    WebElement addFileButton;

    public void clickOnAddFileButton(){
        clickOn(addFileButton);
        log.info("file can be added");
    }

    public void clickOnSaveFolderButton(){
        clickOn(saveFolderButton);
    }

    public void typeOnFolderNameField(String folderName){
        type(folderNameField, folderName);
    }

    public void clickOnNewFolderButton(){
        clickOn(newFolderButton);
        log.info("new folder is initiated");
    }

    public void clickOnDownloadContactDocumentButton(){
        clickOn(downloadContactDocumentButton);
        log.info("contact document is downloaded");
    }

    public void clickOnExportFolder(){
        clickOn(exportFolder);
        log.info("export folder is accessed");
    }

    public void clickOnSaveDocumentNoteButton(){
        clickOn(saveDocumentNoteButton);
        log.info("document note is saved");
    }

    public void typeOnNoteTextField(String documentNote){
        type(noteTextField,documentNote );
    }

    public void clickOnAddNotesButton(){
        clickOn(addNotesButton);
        log.info("notes initiated");
    }

    public void clickOnSaveDocumentButton(){
        clickOn(saveDocumentButton);
        log.info("document is saved");
    }

    public void typeOnDocumentTitleField(String documentTitle){
        type(documentTitleField, documentTitle);
    }

    public void clickOnNewDocumentButton(){
        clickOn(newDocumentButton);
        log.info("new document initiated");
    }

    public void clickOnDocumentsButton(){
        clickOn(documentsButton);
        log.info("documents section accessed");
    }
}
