package com.test.base.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GuardianPage extends BasePage{

    public GuardianPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String isAt(){
        return driver.getCurrentUrl();
    }

    public void gotoPage (){
        driver.get("https://www.theguardian.com/tone/news");
    }





}
