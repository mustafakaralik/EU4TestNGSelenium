package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import jdk.swing.interop.SwingInterOpUtils;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {

    /*
    Verify confirmation message
    open browser
    go to http://practice.cybertekschool.com/forgot_password Links to external site
    enter any email
    verify that email is displayed in the input box
    click on Retrieve password
    verify that confirmation message says "your e-mail's been sent!"
    */
    public static void main(String[] args) throws InterruptedException {


        //-open chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //-go to http://practice.cybertekschool.com/forgot_password links to an external site

        driver.get("http://practice.cybertekschool.com/forgot_password");

        //-enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));

        String expectedEmail = "mustafakaralik@gmail.com";

        //sendKeys()--> send keyboard action to the webelement
        emailInputBox.sendKeys(expectedEmail);

        // verify that email is displayed in the input box

        //somehow we should get text from web elements
        //two main ways to get txt from webelements
        //1.getText-->will work %99 and it will return string
        //2.getAttribute("value")-->second way of getting text especially input boxes

        String actualEmail = emailInputBox.getAttribute("value");
        System.out.println("actualEmail ="+ actualEmail);

        //verify that email is displayed in the input box

        if(expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
        //CLİCK ON RETRİEVE PASSWORD
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        //verify that confirmation message says "your e-mail's been sent!"
        WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));

        System.out.println(actualConfirmationMessage.getText());

        //save expected message
        String expectedMessage = "Your e-mail's been sent!";

        Thread.sleep(5000);
        //save actual message to variable
        String actualMessage = actualConfirmationMessage.getText();

        if (expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("expectedMessage = "+ expectedMessage);
            System.out.println("actualMessage = "+ actualMessage);
        }

       // close browser
        driver.quit();

    }
}