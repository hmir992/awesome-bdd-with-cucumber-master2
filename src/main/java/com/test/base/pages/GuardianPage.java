package com.test.base.pages;

import com.test.base.steps.GivenSteps;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuardianPage extends BasePage {

    //Strings to remove from URL
    private String toRemove = "– live!";
    private String toRemove2 = "https://www.";

    private final static Logger log = Logger.getLogger(GuardianPage.class);

    @FindBy(xpath = "//button[@class='css-2ismk2-button-defaultSize-iconDefault-iconLeft'][1]")
    WebElement pravicyCookiesPopupAgreeButton;

    @FindBy(xpath = "(//li[@class='fc-slice__item l-row__item l-row__item--span-1 u-faux-block-link'])[1]")
    WebElement firstArticle;

    @FindBy(className = "content__headline")
    WebElement firstArticleHeadline;

    //@FindBy(xpath = "//button[@data-link-name='first-pv-consent : agree'][1]")
    //WebElement pravicyCookiesPopupAgreeButton;

   // @FindBy(xpath = "//button[@data-link-name='first-pv-consent : agree'][1]")
   // WebElement pravicyCookiesPopupAgreeButton;


    public GuardianPage(WebDriver driver) {

        this.setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    public String isAt() {
        return this.getDriver().getCurrentUrl();
    }

    public void gotoPage() {
        this.getDriver().get("https://www.theguardian.com/tone/news");
    }

    // clicking on the first article
    public String clickOnFirstArticle(String originalLinkString) {
        firstArticle.click();
        originalLinkString = firstArticleHeadline.getText();
        log.info("this is the original title clicked on: " + originalLinkString);
        //string formatting heading when clicking on first link
        originalLinkString = originalLinkString.replaceAll(toRemove, "").replaceAll(toRemove2, "");
        log.info("original string title formatting done! ");
        return originalLinkString;

    }
    // splitting heading into words
    public List<String> splitStringIntoWords(String originalLinkString, List<String> wordsOfOriginalTitleArray ) {
        wordsOfOriginalTitleArray= Arrays.asList(originalLinkString.split(" "));
        log.info("this is the original title being split into words and put into an arraylist: " + originalLinkString);
        return wordsOfOriginalTitleArray;
    }
    	//Click on Privacy Cookie Popup
    public void clickOnPravicyCookiesPopup() {
        try {
            pravicyCookiesPopupAgreeButton.click();
            log.info("pravicyCookiesPopupAgreeButton is clicked on ");
            Thread.sleep(5000);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.info("accept button not found. Continuing with test", e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
