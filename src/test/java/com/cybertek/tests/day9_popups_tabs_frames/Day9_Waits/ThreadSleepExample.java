package com.cybertek.tests.day9_popups_tabs_frames.Day9_Waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadSleepExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/3");

          //this is static wait time does not care other condition just wait as much as what we enter
         // thread sleep sitenin yüklenme ve webelementin görünme süresine göre
        // yeterli gelmeye bilir yada fazla bekletebilir
        Thread.sleep(6000);
        //when we write this code without thread.sleep gives an error becaause we need to wait till loading
        driver.findElement(By.id("username")).sendKeys("mustafa karalık");

    }
}