package com.test.base.steps;

import com.test.base.pages.Google;
import com.test.base.pages.GuardianPage;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;


public class ThenSteps {

    private final static Logger log = Logger.getLogger(ThenSteps.class);

    //Page setup
    Google google = new Google(EnvSetup.driver);

    @Then("^verify the article is true$")
    public void verifyTheArticleIsTrue() {

       int wordMatchesLink  =  google.calculateArticleIsTrue();
        if(wordMatchesLink>60) {
            log.info("THIS TEST IS A PASS");
        }
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }
}
