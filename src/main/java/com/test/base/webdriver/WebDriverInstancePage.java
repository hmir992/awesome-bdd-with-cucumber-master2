package com.test.base.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class WebDriverInstancePage {

    private static WebDriverInstancePage instance=null;
    private WebDriver driver;


    private WebDriverInstancePage(){
        System.setProperty("webdriver.gecko.driver", "C://geckodriver//geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("marionette", true);
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public WebDriver openBrowser(){

        System.setProperty("webdriver.gecko.driver", "C://geckodriver//geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("marionette", true);
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriverInstancePage getInstance(){
        if(instance==null){
            instance = new WebDriverInstancePage();
        }
        return instance;
    }
}


/*public class InstanPage {

    private static InstanPage instance=null;
    private WebDriver driver;


    private InstanPage(){

    }

    public WebDriver openBrowser(){

        driver=new FirefoxDriver();

    }
        driver.manage().window().maximize();
        return driver;
}

    public static InstanPage getInstance(){
        if(instance==null){
            instance = new InstanPage();
        }
        return instance;
    }

} */