package com.cybertek.tests.day9_popups_tabs_frames.Day9_Waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitwaitExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        //  Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        driver.findElement(By.tagName("button")).click();

        WebElement usernameInput =driver.findElement(By.id("username"));

        //how to explicitly  ?
       // create Explicit wait object

        WebDriverWait wait = new WebDriverWait(driver,100);

        wait.until(ExpectedConditions.visibilityOf(usernameInput));

        usernameInput.sendKeys("mustafa karalık");

    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        driver.findElement(By.xpath("//*[.='Enable']")).click();

        // finding inputbox
        //buton enabled yapılır yapılmaz code inputBox a yazmaya çalışıyor bulamadığı için hata veriyor

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        WebDriverWait wait = new WebDriverWait(driver,10); //1.step create webDriverWait class wait object
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));   //2.step wait obj içinden until methodunu çağır


        inputBox.sendKeys("Mustafa Karalık");
    }
}