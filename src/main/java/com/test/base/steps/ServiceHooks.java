package com.test.base.steps;

import com.test.base.pages.GuardianPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ServiceHooks {

    public static WebDriver driver;

 /*   public ServiceHooks ()
    {
    }

    public ServiceHooks(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
*/
    @Before
    public void initializeTest() throws Exception{
        System.setProperty("webdriver.gecko.driver", "C://geckodriver//geckodriver.exe");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setCapability("marionette", true);
            driver = new FirefoxDriver(firefoxOptions);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
           // constructPages();

    }

   // private static void constructPages (){
   //     PageFactory.initElements(driver, GuardianPage.class);


    //}

    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                // Code to capture and embed images in test reports (if scenario fails)
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
