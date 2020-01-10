package com.test.base.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverSetup {
    public WebDriver startDriver(String startURL) {
        //Opens the startURL in the selected browser
        WebDriver localDriver = null;

        Setup properties = new Setup();
        try {
            properties.getConfigPropValues();
            String propertyName;
            String driverPath;
            if (properties.usedBrowser.equals("chrome")) {
                propertyName = "webdriver.chrome.driver";
                driverPath = properties.chromeDriver;
                System.setProperty(propertyName, driverPath);
                localDriver = new ChromeDriver();
            } else if (properties.usedBrowser.equals("ie")) {
                propertyName = "webdriver.ie.driver";
                driverPath = properties.ieDriver;
                System.setProperty(propertyName, driverPath);
                localDriver = new InternetExplorerDriver();
            } else {
                //use Firefox as default (doesn't matter the value of the string)
                String binaryPath = properties.firefoxPath;
                FirefoxOptions options = new FirefoxOptions();
                options.setBinary(binaryPath);
                propertyName = "webdriver.gecko.driver";
                driverPath = properties.firefoxDriver;
                System.setProperty(propertyName, driverPath);
                propertyName = "webdriver.firefox.bin";
                driverPath = properties.firefoxPath;
                System.setProperty(propertyName, driverPath);
//            ProfilesIni profile = new ProfilesIni();
                options.setProfile(new FirefoxProfile());
                localDriver = new FirefoxDriver(options);
            }
            localDriver.manage().window().maximize();
            this.loadPage(localDriver, startURL);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return localDriver;
    }

    private void loadPage(WebDriver driver, String startURL) {
        String site = startURL.replaceAll("^\"|\"$", "");
        driver.get(site);
    }

    public void closeDriver(WebDriver driver) {
        try {
            driver.close();
            driver.quit();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
