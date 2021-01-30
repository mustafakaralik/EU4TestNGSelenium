package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLnotChanged {

    public static void main(String[] args) throws InterruptedException {
        /*Verify URL not changed
        -open chrome browser
        -go to http://practice.cybertekschool.com/forgot_password links to an external site
        -click on Retrieve password
        -verify that URL did not change
         */

        //open chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //-go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //save expected url before clicking button
        String expectedUrl = driver.getCurrentUrl();

        //click on Retrieve password
        //webElement -->Interface that represent element ob the web page
        //findElement -->method used to find element on a page

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        Thread.sleep(3000);
        //save actual url after clicking button
        String actualUrl = driver.getCurrentUrl();

        //verify that URL did not change
        if(expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        //CLOSE YOUR BROWSER
        driver.quit();
    }




}
