package com.cybertek.tests.day9_popups_tabs_frames.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DenemeHectorApp {
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
        driver.get("https://qa.hectorware.com");
        driver.findElement(By.id("user")).sendKeys("User1");
        driver.findElement(By.id("password")).sendKeys("Userpass123");
        driver.findElement(By.id("submit-form")).click();

        driver.findElement(By.xpath("(//a[contains(@href,'https://qa.hectorware.com/index.php/apps/spreed/')])[1]")).click();

    }
}