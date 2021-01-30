package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class WebDriverFactory {
    //Task:
    //Write a static method that takes a string parameter name : browserType
    //based on the value of parameter
    //it will set up the browser and
    //the method will return chromedriver or firefoxdriver object
    //name  of the method: getDriver

    //SOLUTION at 2:47
    public static WebDriver getDriver(String browserType){
        WebDriver driver = null;

        //ChromeDriver driver;
        switch (browserType.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;




        }
        return driver;
    }



}
