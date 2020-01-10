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

    private WebDriver driver;
    private String linkString ="";
    private String toRemove ="– live!";
    private String toRemove2 ="https://www.";
    private String toRemove3 ="– business live";
    //private String toRemove4 ="– live!";

    private String words;
    private String[] arrOfStr2 = linkString.split(" ");
    //List<String> arrOfStr = new ArrayList<String>();
    private int wordMatchesLink = 0;


    private final static Logger log = Logger.getLogger(GivenSteps.class);

    @FindBy(xpath = "//button[@data-link-name='first-pv-consent : agree'][1]")
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
    private String pageUrl = "https://www.theguardian.com/tone/news";
    public void gotoPage() {
        this.getDriver().get(pageUrl);
    }

    public String clickOnFirstArticle(String linkString) {
        firstArticle.click();
        linkString = firstArticleHeadline.getText();
        System.out.println(linkString);
        // if(example.contains(toRemove) || example.contains(toRemove2))
        // {

        //string formatting heading
        linkString = linkString.replaceAll(toRemove, "").replaceAll(toRemove2, "").replaceAll(toRemove3, "");
//        linkString = linkString.replaceAll(toRemove2, "");
//        linkString = linkString.replaceAll(toRemove3, "");
        //linkString = linkString.replaceAll(toRemove4, "");
        System.out.println("lol7");
        return linkString;

    }
    // splitting heading into words
    public List<String> splitStringIntoWords(String linkString, List<String> arrOfStr ) {
        arrOfStr= Arrays.asList(linkString.split(" "));
        System.out.println(linkString);
        System.out.println("lol5");

        //  }
        System.out.println("lol4");

        return arrOfStr;
    }

    public void clickOnPravicyCookiesPopup() {
        try {
            pravicyCookiesPopupAgreeButton.click();
            Thread.sleep(5000);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.info("accept button not found. Continuing with test", e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
