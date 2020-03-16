package com.test.base.steps;

import com.test.base.pages.Google;
import com.test.base.pages.GuardianPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class WhenSteps {

    private final static Logger log = Logger.getLogger(WhenSteps.class);

    //Page setup
    GuardianPage guardianPage = new GuardianPage(EnvSetup.driver);
    Google google = new Google(EnvSetup.driver);

    private String originalLinkString ="";
    List<String> wordsOfOriginalTitleArray = new ArrayList<String>();

    @When("^I click on the \"([^\"]*)\" news article and Analyse$")
    public void iClickOnTheNewsArticleAndAnalyse(String articleNumber) throws Throwable {
        log.info(articleNumber + "is article number");
        if (articleNumber.equals("first") || articleNumber.equals("1st")) {
            log.info("this is the first article");
            //content_headline
            Thread.sleep(4000);

            //Action on page
            guardianPage.clickOnPravicyCookiesPopup();
            originalLinkString =  guardianPage.clickOnFirstArticle(originalLinkString);
            log.info("this is the 1st link string: " + originalLinkString);
            wordsOfOriginalTitleArray =   guardianPage.splitStringIntoWords(originalLinkString, wordsOfOriginalTitleArray);
        }
    }
    
    @And("^\"([^\"]*)\" to see if the article exists$")
    public void toSeeIfTheArticleExists(String search) throws Throwable {
        if (search.equals("google")) {
            google.googleSearch(originalLinkString, wordsOfOriginalTitleArray);
        }
    }


}
