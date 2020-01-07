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
        List<WebElement> my_list = new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h3.r.dO0Ag>a")));
        List<WebElement> my_list2 = my_list;
        List<String> my_list4 = new ArrayList<String>();
        List<String> my_list6 = new ArrayList<String>();
        System.out.println("The list of href links are : ");

        for (int i = 0; i < arrOfStr.size(); i++) {
            System.out.print(arrOfStr.get(i) + " ");

            for (WebElement element : my_list2) {
                //String[] my_list3 = element.getAttribute("href").split("-");
                // links of strings (on google) split into words
                my_list6 = Arrays.asList(element.getAttribute("href").replaceAll(toRemove2, "").split("-|/"));
                //example.replaceAll(toRemove2, "");
                //my_list4 = Arrays.asList(my_list6);
                System.out.println(my_list6);
                System.out.println(my_list6.get(0));
                System.out.println("lol8");

                //if(arrOfStr.get(i) = my_list4.get(j)  )
            }


            for (String check : my_list6) {
                System.out.println("lol111@");
                System.out.println("VALUE OF LIST  " + check);
                System.out.println("GOOGLE SEARCH " + searchValue);
                System.out.println(wordMatchesLink);
                System.out.println("Search split " + searchValue.split(""));
                if (check.equals(arrOfStr.get(i))) {
                    wordMatchesLink++;
                    System.out.println("WORDCOUNT MATCH");
                    System.out.println(wordMatchesLink);
                }
            }
        }
    }
}
