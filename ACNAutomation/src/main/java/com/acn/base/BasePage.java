package com.acn.base;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;

public class BasePage {
    public WebDriverWait wait;
    public AndroidDriver driver;
    public static final int TIMEOUT = 60;

    public BasePage(){
    	PageFactory.initElements(DriverManager.getDriver(), this);
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT));
        driver = DriverManager.getDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
