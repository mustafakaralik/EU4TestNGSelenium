package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNamelocator {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //maximize window
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        //SEND KEYS TO FULLNAME
        WebElement fullNameInput = driver.findElement(By.tagName("input"));
        fullNameInput.sendKeys("Mike Smith With TagName");

        //sendKeys to email
        //WebElement emailInput =driver.findElement(By.name("email")); //if we use same tagname fore inputname and email it gives error
        //emailInput.sendKeys("mike@smith.com");

        //lazy way to click button
        driver.findElement(By.tagName("button")).click();

        Thread.sleep(3000);


        //CLOSE BROWSER
        driver.quit();
    }
}
