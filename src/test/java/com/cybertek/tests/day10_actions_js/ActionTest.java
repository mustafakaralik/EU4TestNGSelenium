package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionTest {
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
    public void hovertest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));
        //Actions -->class that contains all the user interactions
        //how to create actions objects-->passing driver as a constructor
        Actions actions = new Actions(driver);
        //perform() --> perform the action, complete the action
        //moveToElement--> move you mouse to webelement(hover over)
        Thread.sleep(2000);
        actions.moveToElement(img1).perform();


        WebElement viewLink = driver.findElement(By.linkText("View profile"));
        Assert.assertTrue(viewLink.isDisplayed(),"Verify viewlink is displayed");

    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("http://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();


        Actions actions =new Actions(driver);

        List<WebElement> acceptAndClose = driver.findElements(By.xpath("//*[.='Accept and Close']"));
        List<WebElement> acceptCookies = driver.findElements(By.xpath("//*[.='Accept Cookies']"));
        Thread.sleep(1000);
        if (acceptAndClose.size()>0){
            acceptAndClose.get(0).click();

        }else if(acceptCookies.size()>0){
            acceptCookies.get(0).click();
        }

        WebElement source =driver.findElement(By.id("draggable"));
        WebElement target =driver.findElement(By.id("droptarget"));

        //if you see accept and close message use this-->
        // driver.findElement(By.xpath("//*[.='Accept Cookies']")).click();

       // driver.findElement(By.xpath("//*[.='Accept Cookies']")).click();

        Thread.sleep(1000);
        actions.dragAndDrop(source,target).perform();
    }

    @Test
    public  void dragAndDropChaining() throws InterruptedException {
        driver.get("http://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();


        Actions actions =new Actions(driver);

        List<WebElement> acceptAndClose = driver.findElements(By.xpath("//*[.='Accept and Close']"));
        List<WebElement> acceptCookies = driver.findElements(By.xpath("//*[.='Accept Cookies']"));
        Thread.sleep(1000);
        if (acceptAndClose.size()>0){
            acceptAndClose.get(0).click();

        }else if(acceptCookies.size()>0){
            acceptCookies.get(0).click();
        }

        WebElement source =driver.findElement(By.id("draggable"));
        WebElement target =driver.findElement(By.id("droptarget"));


        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();
    }
}