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

public class Tc8 {
        /*
        * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        Step 2. And click on “Autocomplete”.
        Step 3. Enter “United States of America” into country input box.
        Step 4. Verify that following message is displayed: “You selected: United States of America”
*/
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void TC8() throws InterruptedException {

        //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. And click on “Autocomplete”.
        driver.findElement(By.xpath("(//*[.='Autocomplete'])[2]")).click();
        //Step 3. Enter “United States of America” into country input box.
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        //Step 4. Verify that following message is displayed: “You selected: United States of America”
        WebElement resul =driver.findElement(By.id("result"));
        Assert.assertTrue(resul.isDisplayed(),"You selected: United States of America");


    }
}