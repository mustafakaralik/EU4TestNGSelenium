package com.cybertek.tests.day6_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cssLocator {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement dontclick = driver.findElement(By.cssSelector("#disappearing_button"));
        Thread.sleep(3000);
        System.out.println(dontclick.getText());

        driver.quit();

        //button[id^='button_']<--> css ^ means "static text start with"
        //button[starts-with(@id,'button_']<-->xpath
        //starting part is static

    }

}
