package com.test.base.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    
    // This is BasePage Where each page in POM extends from

    private WebDriver driver;

    public  void setDriver (WebDriver driver)
    {
        this.driver = driver;
    }
    public WebDriver getDriver (){
        return driver;
    }

}