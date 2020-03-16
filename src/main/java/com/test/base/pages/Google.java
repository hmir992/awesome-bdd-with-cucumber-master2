package com.test.base.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Google extends BasePage {

    //Strings to remove from URL
    private String toRemove = "– live!";
    private String toRemove2 = "https://www.";
    // words match counter
    private int wordMatchesCounter = 0;
    
    private final static Logger log = Logger.getLogger(Google.class);

    @FindBy(name = "q")
    WebElement googleSearchBar;


    public Google(WebDriver driver) {

        this.setDriver(driver);

        // this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void googleSearch(String searchValue, List<String> wordsOfOriginalTitleArray) {

        //Search Original Title On Google Guardian.co.uk
        getDriver().get("https://www.google.com");
        //driver.get("https://www.google.com");
        googleSearchBar.click();
        googleSearchBar.sendKeys(searchValue);
        googleSearchBar.sendKeys(Keys.RETURN);
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Click the google news link and get the 10 tiles from google news
        // First Get as web elements then convert as strings array with just the words of the titles
        // Then populate the array with all the strings in an array So this complete list contains all the words from all the titles
        // ready to be compared with the original title from Original Title On Google Guardian.co.uk
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.linkText("News"))).click();
        
        //wait and then get all elements and put into WebElement Array called googleTitlesPerPage 
        List<WebElement> googleTitlesPerPage = new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h3.r.dO0Ag>a")));
        
        //googleTitlesPerPage becomes or is equal to googleTitlesPerPage_webElements
        List<WebElement> googleTitlesPerPage_webElements = googleTitlesPerPage;
        
        //create new String array googleTitlesPerPage_stringArray
        List<String> googleTitlesPerPage_stringArray = new ArrayList<String>();
        
      //create new String array myCompleteList but with some characters removed
        List<String> myCompleteList = new ArrayList<String>();
        log.info("The list of href links are : ");

            for (WebElement element : googleTitlesPerPage_webElements) {
                // list of strings (on google) split into words
                googleTitlesPerPage_stringArray = Arrays.asList(element.getAttribute("href").replaceAll(toRemove, "").replaceAll(toRemove2, "").split("-|/"));
                myCompleteList.addAll(googleTitlesPerPage_stringArray);
                log.info(googleTitlesPerPage_stringArray);
            }

            // go through the array of original title from Original Title On Google Guardian.co.uk
        for (int i = 0; i < wordsOfOriginalTitleArray.size(); i++) {
            log.info(wordsOfOriginalTitleArray.get(i) + " ");

            // go through the array of complete lists of titles
            for (int j =0; j<myCompleteList.size(); j++ ) {
                log.info("value of myCompleteList element:  " + myCompleteList.get(j));
                log.info("google search title: " + searchValue);
                log.info("value of original tile: " + wordsOfOriginalTitleArray.get(i));
                
                // Compare 2 arrays if the word match the array then increment the counter
                if (myCompleteList.get(j).equals(wordsOfOriginalTitleArray.get(i))) {
                    wordMatchesCounter++;
                    log.info("WORDCOUNT MATCH COUNTER++");
                    log.info("current wordcount counter: " + wordMatchesCounter);
                }
                log.info("myCompleteList: " + myCompleteList);
            }
        }
    }

        public int calculateArticleIsTrue()
        {
            log.info("WORDCOUNT FINAL COUNT" + wordMatchesCounter);
            return wordMatchesCounter;
        }
}
