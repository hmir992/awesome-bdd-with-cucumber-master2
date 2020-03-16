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

      // words match more than 10 words then the test passed
	int wordMatchesCounter  =  google.calculateArticleIsTrue();
       if(wordMatchesCounter>10) {
            log.info("TEST PASSED!");
        }
    }
}
