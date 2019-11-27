package com.test.base.pages;

import org.openqa.selenium.WebDriver;

public class GuardianPage {
    private static WebDriver driver;

    public GuardianPage(WebDriver driver){
        GuardianPage.driver = driver;
    }

    public static String isAt(){
        return driver.getCurrentUrl();
    }

    public static void gotoPage (){
        driver.get("https://www.theguardian.com/tone/news");
    }





}
