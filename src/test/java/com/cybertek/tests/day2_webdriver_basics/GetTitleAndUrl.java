package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {

    public static void main(String[] args) {

        // task open chrome and navigate to http://practice.cybertekscholl.com

        WebDriverManager.chromedriver().setup();

        WebDriver driver  = new ChromeDriver();

        driver.get("http://hepsiburada.com");

        //getting title with selenium
        //shortcut for creating variable
        //alt +enter enter
        //getTitle()-->get you the title of page
        String title = driver.getTitle();

        //System.out.println("title:"+ title); uzun uzun yazmak yerine soutv yapınca gelir

        System.out.println("title = " + title);

        //System.out.println(driver.getTitle());

        //getCurrentUrl -->get the url from browser
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //getPageSource() -->get the source of the page
       //driver.getPageSource()-->yazarak alt+enter enter yapınca alttaki otomatik yazar
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);
        


    }
}
