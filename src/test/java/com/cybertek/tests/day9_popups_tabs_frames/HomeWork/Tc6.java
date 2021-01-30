package com.cybertek.tests.day9_popups_tabs_frames.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tc6 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
      //  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void TC6() throws InterruptedException {

        //Step 1. Go to "https://www.tempmailaddress.com/"
        driver.get("https://www.tempmailaddress.com");

        //Step 2. Copy and save email as a string.
        WebElement emails = driver.findElement(By.id("email"));
        String str =emails.getText();

        //Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 4. And click on “Sign Up For Mailing List".
        driver.findElement(By.xpath("//a[@href='/sign_up']")).click();

        //Step 5. Enter any valid name.
        driver.findElement(By.name("full_name")).sendKeys("Mustafa Karalık");;

        //Step 6. Enter email from the Step 2.
        driver.findElement(By.name("email")).sendKeys(str);

        //Step 7. Click Sign Up
        driver.findElement(By.name("wooden_spoon")).click();;

        //Step 8. Verify that following message is displayed: “Thank you for signing up. Click the button below toreturn to the home page.”
        WebElement verifytext = driver.findElement(By.xpath("//*[contains(text(),'Thank you for')]"));
        System.out.println(verifytext.isDisplayed());
        String str2 =verifytext.getText();
        String expectedResult = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(str2,expectedResult);

        //Step 9. Navigate back to the “https://www.tempmailaddress.com/”
        driver.get("https://www.tempmailaddress.com");

        //Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
        WebElement replytext =driver.findElement(By.xpath("(//tbody/tr/td[@class='from']/span)[1]"));
        String exp ="do-not-reply@practice.cybertekschool.com";
        Assert.assertTrue(replytext.isDisplayed(),"do-not-reply@practice.cybertekschool.com");

        //Step 11. Click on that email to open it.
       driver.findElement(By.xpath("(//tbody/tr/td[@class='from']/span)[1]")).click();

        //Step 12. Verify that email is from: “do-not-reply@practice.cybertekschool.com”
        WebElement web =driver.findElement(By.id("odesilatel"));
        Assert.assertTrue(web.isDisplayed(),"do-not-reply@practice.cybertekschool.com");

        //Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!
        WebElement web2 =driver.findElement(By.id("predmet"));
        Assert.assertTrue(web2.isDisplayed(),"Thanks for subscribing to practice.cybertekschool.com!");

    }
}