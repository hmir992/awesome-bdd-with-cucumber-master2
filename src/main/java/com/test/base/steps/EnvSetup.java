package com.test.base.steps;

import com.test.base.common.DriverSetup;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class EnvSetup {

    protected static WebDriver driver;
    private DriverSetup ds = new DriverSetup();

    @Before
    public void initializeTest() throws Exception{
        String startURL = "";
        this.driver = ds.startDriver(startURL);
//        System.setProperty("webdriver.gecko.driver", "C://geckodriver//geckodriver.exe");
//            FirefoxOptions firefoxOptions = new FirefoxOptions();
//            firefoxOptions.setCapability("marionette", true);
//            driver = new FirefoxDriver(firefoxOptions);
//            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
