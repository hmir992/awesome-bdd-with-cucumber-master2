package com.test.base.steps;

import com.test.base.pages.GuardianPage;
import com.test.base.webdriver.WebDriverInstancePage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class EnvSetup {

    private WebDriver driver;
    WebDriverInstancePage webDriverInstance = WebDriverInstancePage.getInstance();


    @Before
    public void initializeTest() throws Exception{

        driver=webDriverInstance.openBrowser();
            //constructPages();
    }




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
