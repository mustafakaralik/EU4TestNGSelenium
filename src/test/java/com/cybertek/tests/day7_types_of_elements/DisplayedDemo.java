package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameInput = driver.findElement(By.id("username"));

        System.out.println("usernameInput.isDisplayed() = " + usernameInput.isDisplayed());
        //usernameInput.sendKeys("some keys");

        //TASK
        // verify username ınputbox is not displayed on the screen
        Assert.assertFalse(usernameInput.isDisplayed(),"verify inputbox is NOT displayed");
        //click start button
        //find start button and click
        driver.findElement(By.cssSelector("#start>button")).click();
        //wait until elements displayed
        Thread.sleep(6000); //it can be more than 6 sn there is amethod  way tod od this aother than Thread.sleep
        //VERİFY USERNAME DİSPLAYED on the screen
        Assert.assertTrue(usernameInput.isDisplayed(),"verify username inputbox is  displayed");
        
        

    }
}
