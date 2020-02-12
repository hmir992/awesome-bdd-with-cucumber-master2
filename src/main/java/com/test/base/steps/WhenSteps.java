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

            guardianPage.clickOnPravicyCookiesPopup();
            originalLinkString =  guardianPage.clickOnFirstArticle(originalLinkString);
            log.info("this is the 1st link string: " + originalLinkString);
            wordsOfOriginalTitleArray =   guardianPage.splitStringIntoWords(originalLinkString, wordsOfOriginalTitleArray);
           /* try {
                driver.findElement(By.xpath("//button[@data-link-name='first-pv-consent : agree'][1]")).click();
                Thread.sleep(5000);
            } catch (org.openqa.selenium.NoSuchElementException e) {
                log.info("accept button not found. Continuing with test", e);
            }

            */

        }

            /*

        //driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div[3]/button/span[2]")).click();
        //Thread.sleep(5000);
        driver.findElement(By.xpath("(//li[@class='fc-slice__item l-row__item l-row__item--span-1 u-faux-block-link'])[1]")).click();
        example = driver.findElement(By.className("content__headline")).getText();
        System.out.println(example);
        // if(example.contains(toRemove) || example.contains(toRemove2))
        // {
        example=example.replaceAll(toRemove, "");
        example=example.replaceAll(toRemove2, "");
        arrOfStr= Arrays.asList(example.split(" "));
        System.out.println(example);
        System.out.println("lol5");

        //  }
        System.out.println("lol4");

        */

        //driver.findElement(By.xpath("uid")).sendKeys(articleNumber);
        //driver.findElement(By.name("password")).sendKeys(password);
        //throw new PendingException();

  // this is for second ad enable cookies (not working)
      /*  try {
            driver.findElement(By.className("site-message--first-pv-consent__button site-message--first-pv-consent__button--main js-first-pv-consent-agree")).click();
            Thread.sleep(5000);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.info("accept button not found. Continuing with test", e);
        }
        */
    }


    @And("^\"([^\"]*)\" to see if the article exists$")
    public void toSeeIfTheArticleExists(String search) throws Throwable {
        if (search.equals("google")) {
            google.googleSearch(originalLinkString, wordsOfOriginalTitleArray);


         /*   driver.get("https://www.google.com");
            driver.findElement(By.name("q")).click();
            driver.findElement(By.name("q")).sendKeys(example);
            driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
            // String text = driver.findElement(By.xpath("(//*[@class='HF9Klc iJddsb'])[1]")).getText();
            // System.out.println(text);
            //System.out.println("lol5");

            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.linkText("News"))).click();
            List<WebElement> my_list = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h3.r.dO0Ag>a")));
            List<WebElement> my_list2 = my_list;
            List<String> my_list4 = new ArrayList<String>();
            System.out.println("The list of href links are : ");

            for (int i = 0; i < arrOfStr.size(); i++){
                System.out.print(arrOfStr.get(i) + " " + "VALUE OF ARROFSTR");

                for(WebElement element:my_list2) {
                    //String[] my_list3 = element.getAttribute("href").split("-");
                    List<String> my_list6 = Arrays.asList(element.getAttribute("href").replaceAll(toRemove2, "").split("-|/"));
                    //example.replaceAll(toRemove2, "");
                    //my_list4 = Arrays.asList(my_list6);
                    System.out.println(my_list6);
                    System.out.println("lol8");

                    //if(arrOfStr.get(i) = my_list4.get(j)  )
                }




            }



            for(String check:my_list4)
            {
                if(check.equals(example.split(" ")))
                {
                    wordMatchesLink++;
                    System.out.println(wordMatchesLink);
                }
            } */
        }//

        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }


}
