package com.test.base.steps;

import com.test.base.pages.GuardianPage;
import cucumber.api.java.en.Given;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GivenSteps {


    private String example ="";
    private String toRemove ="– live!";
    private String toRemove2 ="https://www.";
    private String words;
    private String[] arrOfStr2 = example.split(" ");
    List<String> arrOfStr = new ArrayList<String>();
    private int wordMatchesLink = 0;


    GuardianPage guardianPage = new GuardianPage(EnvSetup.driver);



   // GuardianPage page = PageFactory.initElements(driver, GuardianPage.class);
    private final static Logger log = Logger.getLogger(GivenSteps.class);

//    public GivenSteps(WebDriver driver) {
//      //  this.driver = ServiceHooks.driver;
    //}
    @Given("^Open the Firefox and launch theguardian website$")
    public void openTheFirefoxAndLaunchTheguardianWebsite() throws Exception {
     //   try {
     //       GuardianPage.initializeTest();
     //   } catch (Exception e) {
       //     e.printStackTrace();
      //  }
        //serviceHooks = new ServiceHooks(driver);
        //serviceHooks.initializeTest();
//        System.setProperty("webdriver.gecko.driver", "C://geckodriver//geckodriver.exe");
//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
        //driver.get("https://www.theguardian.com/tone/news");
        System.out.println("lol");
        //li[@class='fc-slice__item l-row__item l-row__item--span-1 u-faux-block-link'][1]

        //guardianPage = new GuardianPage(EnvSetup.driver);
        guardianPage.gotoPage();
        //assertEquals(guardianPage.isAt(), "https://www.theguardian.com/tone/news");
    }
}
