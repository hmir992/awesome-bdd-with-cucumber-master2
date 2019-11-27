package com.test.base.steps;

import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;


public class ThenSteps {

    private WebDriver driver;
    private String example ="";
    private String toRemove ="– live!";
    private String toRemove2 ="https://www.";
    private String words;
    private String[] arrOfStr2 = example.split(" ");
    List<String> arrOfStr = new ArrayList<String>();
    private int wordMatchesLink = 0;

    private final static Logger log = Logger.getLogger(ThenSteps.class);

    @Then("^verify the article exists$")
    public void verifyTheArticleExists() {
        if(wordMatchesLink>3) {
            System.out.println("THIS TEST IS A PASS");
        }
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }
}
