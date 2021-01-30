package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2_HW {

    @Test
    public void test2() throws InterruptedException {
        //-->goto the web site
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
         driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

         //-->Verify that Success - Check box is checked is NOT written
        WebElement hidenText = driver.findElement(By.xpath("//*[@id='txtAge']"));
        System.out.println("hidenText.isDisplayed() = " + hidenText.isDisplayed());

       // Assert.assertFalse(hidenText.isDisplayed(),"  and Success - Check box is checked is NOT written");

        //-->Click to chcbox
        WebElement chkBox =driver.findElement(By.cssSelector(".checkbox #isAgeSelected"));
        Thread.sleep(2000);
        chkBox.click();



        //--> After click verify button checked and  Success - Check box is checked is written
        System.out.println("chkBox.isSelected() = " + chkBox.isSelected());
        //Assert.assertTrue(chkBox.isSelected(),"and Success - Check box is checked is written");
        System.out.println("hidenText.isDisplayed() = " + hidenText.isDisplayed());




    }
}

/*
*     @Test
    public void test2(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkbox=driver.findElement(By.id("txtAge"));
        Assert.assertFalse(checkbox.isDisplayed(),"verify success check box is checked msg is not displayed");

        driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();

        Assert.assertTrue(checkbox.isDisplayed(),"verify success check box is checked msg is displayed");

        driver.quit();

    }*/