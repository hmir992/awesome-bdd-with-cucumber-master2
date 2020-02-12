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

    private String toRemove = "– live!";
    private String toRemove2 = "https://www.";
    private int wordMatchesLink = 0;
    private int sizeOfOriginalTiteArray=0;

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

       sizeOfOriginalTiteArray= wordsOfOriginalTitleArray.size();

        //Click the google news link and get the 10 tiles from google news
        // First Get as web elements then convert as strings array with just the words of the titles
        // Then populate the array with all the strings in an array So this complete list contains all the words from all the titles
        // ready to be compared with the original title from Original Title On Google Guardian.co.uk
        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.linkText("News"))).click();
        List<WebElement> googleTitlesPerPage = new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h3.r.dO0Ag>a")));
        List<WebElement> googleTitlesPerPage_webElements = googleTitlesPerPage;
        List<String> googleTitlesPerPage_stringArray = new ArrayList<String>();
        List<String> myCompleteList = new ArrayList<String>();
        log.info("The list of href links are : ");

            for (WebElement element : googleTitlesPerPage_webElements) {
                // links of strings (on google) split into words
                googleTitlesPerPage_stringArray = Arrays.asList(element.getAttribute("href").replaceAll(toRemove, "").replaceAll(toRemove2, "").split("-|/"));
//                compare(originalArticleTitle, googlkeNewName); // returns how many words from google tilte exist in original
//                int percentage =
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
                if (myCompleteList.get(j).equals(wordsOfOriginalTitleArray.get(i))) {
                    wordMatchesLink++;
                    log.info("WORDCOUNT MATCH");
                    log.info("current wordcount: " + wordMatchesLink);
                }
                log.info("myCompleteList: " + myCompleteList);
            }
        }
    }

        public int calculateArticleIsTrue()
        {
            log.info("% of correct words in title compared to orignal wordcount: " + wordMatchesLink);
            return sizeOfOriginalTiteArray/wordMatchesLink*100;
        }
}
