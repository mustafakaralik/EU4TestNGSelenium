package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchanged {

    public static void main(String[] args) throws InterruptedException {
          /*Verify URL not changed
        -open chrome browser
        -go to http://practice.cybertekschool.com/forgot_password links to an external site
        -enter any email
        -click on Retrieve password
        -verify that URL chsnged to http://practice.cybertekschool.com/email_sent
         */

        //-open chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");

       //-go to http://practice.cybertekschool.com/forgot_password links to an external site

        driver.get("http://practice.cybertekschool.com/forgot_password");

        //-enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));

        //sendKeys()--> send keyboard action to the webelement
        emailInputBox.sendKeys("mustafakaralik@gmail.com");

        //-click on Retrieve password button
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();
        Thread.sleep(5000);
        //TASK
        //-verify that URL changed to http://practice.cybertekschool.com/email_sent

        //create expectedURL
        String expectedUrl = "http://practice.cybertekschool.com/email_sent";

        //saving actual url from browser after we enter any email and click retrieve password button
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("PASS");

        }else {
            System.out.println( "FAIL");
            System.out.println("expectedUrl = "+ expectedUrl);
            System.out.println("actualUrl = "+ actualUrl);
        }

        //CLOSE BOWSER
        driver.quit();

    }
}
