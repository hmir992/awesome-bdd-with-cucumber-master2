package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Steps {

    private WebDriver driver;
    private String example ="";
    private String toRemove ="– live!";
    private String toRemove2 ="https://www.";
    private String words;
    private String[] arrOfStr = example.split(" ");
    private int wordMatchesLink = 0;

    private final static Logger log = Logger.getLogger(Steps.class);

    @Given("^Open the Firefox and launch theguardian website$")
    public void open_the_Firefox_and_launch_the_application() throws Throwable {
        System.setProperty("webdriver.gecko.driver", "C://geckodriver//geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.theguardian.com/tone/news");
        System.out.println("lol");
        //li[@class='fc-slice__item l-row__item l-row__item--span-1 u-faux-block-link'][1]
    }

    @Then("^Reset the credential$")
    public void Reset_the_credential() throws Throwable {
        driver.findElement(By.name("btnReset")).click();
    }

    @When("^Enter the Username \"([^\"]*)\"and Password \"([^\"]*)\"$")
    public void enter_the_Username_and_Password(String username, String password) throws Throwable {
        driver.findElement(By.name("uid")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @And("^\"([^\"]*)\" to see if the article exists$")
    public void toSeeIfTheArticleExists(String search) throws Throwable {
        if (search.equals("google")) {
            driver.get("https://www.google.com");
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
            for(WebElement element:my_list2){
                //String[] my_list3 = element.getAttribute("href").split("-");
                String[] my_list3 = element.getAttribute("href").replaceAll(toRemove2, "").split("-");
                //example.replaceAll(toRemove2, "");
                my_list4 =   Arrays.asList(my_list3);
            System.out.println(Arrays.asList(my_list3));




        }

            for(String check:my_list4)
            {
                if(check.equals(example.split(" ")))
                {
                    wordMatchesLink++;
                    System.out.println(wordMatchesLink);
                }
            }
            }

        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }


    @When("^I click on the \"([^\"]*)\" news article and Analyse$")
    public void iClickOnTheNewsArticleAndAnalyse(String articleNumber) throws Throwable {
        System.out.println("lol2");
        System.out.println(articleNumber + "is article number");
        if (articleNumber.equals("first") || articleNumber.equals("1st")) {
            System.out.println("lol3");
            //content__headline
            Thread.sleep(10000);

            try {
                driver.findElement(By.className("css-e4pxoq-buttonStyles-yellowButtonStyles-PrivacySettings")).click();
                Thread.sleep(5000);
            } catch (org.openqa.selenium.NoSuchElementException e) {
                log.info("accept button not found. Continuing with test", e);
            }

            try {
                driver.findElement(By.xpath("//button[@data-link-name='first-pv-consent : agree'][1]")).click();
                Thread.sleep(5000);
            } catch (org.openqa.selenium.NoSuchElementException e) {
                log.info("accept button not found. Continuing with test", e);
            }

        }


        //driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div[3]/button/span[2]")).click();
        //Thread.sleep(5000);
        driver.findElement(By.xpath("(//li[@class='fc-slice__item l-row__item l-row__item--span-1 u-faux-block-link'])[1]")).click();
        example = driver.findElement(By.className("content__headline")).getText();
        System.out.println(example);
       // if(example.contains(toRemove) || example.contains(toRemove2))
       // {
            example=example.replaceAll(toRemove, "");
            example=example.replaceAll(toRemove2, "");
           arrOfStr= example.split(" ");
            System.out.println(example);
            System.out.println("lol5");
            for(int i =0; i<arrOfStr.length;i++) {
                System.out.println(arrOfStr[i]);
            }
      //  }
        System.out.println("lol4");
        //driver.findElement(By.xpath("uid")).sendKeys(articleNumber);
        //driver.findElement(By.name("password")).sendKeys(password);
        //throw new PendingException();

        try {
            driver.findElement(By.className("site-message--first-pv-consent__button site-message--first-pv-consent__button--main js-first-pv-consent-agree")).click();
            Thread.sleep(5000);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            log.info("accept button not found. Continuing with test", e);
        }

    }


    @Then("^verify the article exists$")
    public void verifyTheArticleExists() {

   if(wordMatchesLink>3) {
       System.out.println("THIS TEST IS A PASS");
   }
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

}
