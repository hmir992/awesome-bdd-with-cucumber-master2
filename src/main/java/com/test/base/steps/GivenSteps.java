package com.test.base.steps;

import com.test.base.pages.GuardianPage;
import cucumber.api.java.en.Given;
import org.apache.log4j.Logger;

public class GivenSteps {

    private final static Logger log = Logger.getLogger(GivenSteps.class);

    //Page Setup
    GuardianPage guardianPage = new GuardianPage(EnvSetup.driver);

    @Given("^Open the Firefox and launch theguardian website$")
    public void openTheFirefoxAndLaunchTheguardianWebsite() throws Exception {
        log.info("Going to Guardian Page");
        guardianPage.gotoPage();
    }
}
