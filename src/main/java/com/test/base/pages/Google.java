package com.test.base.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Google extends BasePage {

    private WebDriver driver;
    private String example = "";
    private String toRemove = "– live!";
    private String toRemove2 = "https://www.";
    private String words;
    private String[] arrOfStr2 = example.split(" ");
    //List<String> arrOfStr = new ArrayList<String>();
    private int wordMatchesLink = 0;

    public Google(WebDriver driver) {

        this.setDriver(driver);

        // this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void googleSearch(String searchValue, List<String> arrOfStr) {

        getDriver().get("https://www.google.com");
        //driver.get("https://www.google.com");
        getDriver().findElement(By.name("q")).click();
        getDriver().findElement(By.name("q")).sendKeys(searchValue);
        getDriver().findElement(By.name("q")).sendKeys(Keys.RETURN);
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // String text = driver.findElement(By.xpath("(//*[@class='HF9Klc iJddsb'])[1]")).getText();
        // System.out.println(text);
        //System.out.println("lol5");

        new WebDriverWait(getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.linkText("News"))).click();
        List<WebElement> googleTitlesPerPage = new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h3.r.dO0Ag>a")));
        List<WebElement> googleTitlesPerPage_webElements = googleTitlesPerPage;
        List<String> my_list4 = new ArrayList<String>();
        List<String> googleTitlesPerPage_stringArray = new ArrayList<String>();
//        List<String> myCompleteList = new ArrayList<String>();
        System.out.println("The list of href links are : ");



            for (WebElement element : googleTitlesPerPage_webElements) {
                //String[] my_list3 = element.getAttribute("href").split("-");
                // links of strings (on google) split into words
                googleTitlesPerPage_stringArray = Arrays.asList(element.getAttribute("href").replaceAll(toRemove2, "").split("-|/"));
//                compare(originalArticleTitle, googlkeNewName); // returns how many words from google tilte exist in original
                //googleNewNameMatchedWordsNumber / number of words in current title
                //array [index of title (0..9)] = compare Value
                // if comparePercentage > 75% then index = true
                //count number of articles that are true
//                int percentage =
//                myCompleteList.addAll(googleTitlesPerPage_stringArray);
                //example.replaceAll(toRemove2, "");
                //my_list4 = Arrays.asList(googleTitlesPerPage_stringArray);
                System.out.println(googleTitlesPerPage_stringArray);
                System.out.println(googleTitlesPerPage_stringArray.get(0));
                System.out.println("lol8");

                //if(arrOfStr.get(i) = my_list4.get(j)  )
            }

        for (int i = 0; i < arrOfStr.size(); i++) {
            System.out.print(arrOfStr.get(i) + " ");


            for (int j =0; j<myCompleteList.size(); j++ ) {
                System.out.println("lol111@");
                System.out.println("VALUE OF mycompletelist  " + myCompleteList.get(j));
                System.out.println("GOOGLE SEARCH " + searchValue);
                System.out.println(wordMatchesLink);
                System.out.println("value of titlelist " + arrOfStr.get(i));
                if (myCompleteList.get(j).equals(arrOfStr.get(i))) {
                    wordMatchesLink++;
                    System.out.println("WORDCOUNT MATCH");
                    System.out.println(wordMatchesLink);
                }
                System.out.println("myCompleteList: " + myCompleteList);
                System.out.println(myCompleteList.get(0));
                System.out.println("lol8");

                //if(arrOfStr.get(i) = my_list4.get(j)  )
            }



        }
    }
}
