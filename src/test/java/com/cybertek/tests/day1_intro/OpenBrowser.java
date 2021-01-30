package com.cybertek.tests.day1_intro;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {

    public static void main(String[] args) {

    //we have to enter this line every time  we want to open chrome
    //Hey Webdrivermenager, can you make chrome ready for me for automation

       // WebDriverManager.chromedriver().setup();

        //this line will allow selenium to automate firefox browser

       WebDriverManager.firefoxdriver().setup();

       WebDriver drivers =new FirefoxDriver();
     drivers.get("https://www.google.com");

        //webdriver represent the browser
        //we are creating driver for chrome browser
        //new chromeDriver ()--> this part will open chrome browser
      // WebDriver driver = new ChromeDriver();

    // driver.get("https://cybertekschool.com");

    }
}
