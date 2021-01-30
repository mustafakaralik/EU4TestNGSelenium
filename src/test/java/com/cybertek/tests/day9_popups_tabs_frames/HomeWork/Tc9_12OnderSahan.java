package com.cybertek.tests.day9_popups_tabs_frames.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tc9_12OnderSahan {

    WebDriver driver;

    @BeforeMethod

    public void setup(){
        driver=WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);}

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();}

    @DataProvider(name="testCases")
    public Object[][] createTestCase() {
        return new Object[][]{
                {"https://practice-cybertekschool.herokuapp.com/", "Status Codes", "200", "//*[contains(text(),'returned')]"},
                {"https://practice-cybertekschool.herokuapp.com/", "Status Codes", "301", "//*[contains(text(),'returned')]"},
                {"https://practice-cybertekschool.herokuapp.com/", "Status Codes", "404", "//*[contains(text(),'returned')]"},
                {"https://practice-cybertekschool.herokuapp.com/", "Status Codes", "500", "//*[contains(text(),'returned')]"}
        };
    }
    @Test(dataProvider = "testCases" )
    public void testCases9_12(String arg1, String arg2, String arg3, String arg4){
        // Step 1. Go to
        driver.get(arg1);
        // Step 2. And click on "Status Codes"
        driver.findElement(By.linkText(arg2)).click();
        // Step 3. Then click on "200"
        driver.findElement(By.linkText(arg3)).click();
        // Step 4. Verify that following message is displayed:
        String expectedMessage= "This page returned a "+arg3+" status code";
        String actualMessage= driver.findElement(By.xpath(arg4)).getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage),"verify message");
    }
}

