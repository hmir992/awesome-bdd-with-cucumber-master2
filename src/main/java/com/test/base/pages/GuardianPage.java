package com.test.base.pages;

import com.test.base.steps.EnvSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GuardianPage extends BasePage{

    public GuardianPage(WebDriver driver) {

        this.setDriver(driver);
        PageFactory.initElements(driver, this);
    }

    public  String isAt(){
        return this.getDriver().getCurrentUrl();
    }

    public void gotoPage (){
        this.getDriver().get("https://www.theguardian.com/tone/news");
    }





}
