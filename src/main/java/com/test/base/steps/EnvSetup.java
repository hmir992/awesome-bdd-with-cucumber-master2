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

public class EnvSetup {

    protected static WebDriver driver;

    @Before
    public void initializeTest() throws Exception{
        System.setProperty("webdriver.gecko.driver", "C://geckodriver//geckodriver.exe");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setCapability("marionette", true);
            driver = new FirefoxDriver(firefoxOptions);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
           // constructPages();

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
