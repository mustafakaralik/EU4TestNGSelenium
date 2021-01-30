package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {
    //iframe içinde bir baby html olduğu için onun içindeki webelemente
    // ulaşamıyor o nedenle  no such element diyor
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
       driver.get("http://practice.cybertekschool.com/iframe");

       //how we gonna switch other html
        //1.switch using by name or ID attribute of İframe
        //alttaki switch kodu ile iframe içindeki baby htmle gidiyoruz
        driver.switchTo().frame("mce_0_ifr");

        //cleare before send keys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(1000);

       driver.findElement(By.cssSelector("#tinymce")).sendKeys("mustafa Karalık");
       //no such elemenet but webelement is over there

        // FIRST WAY goes back to first  frame (main html )
        //goes back to first  frame ,useful when we have switched multiple frames
        driver.switchTo().defaultContent();

        //2.switching with index mean baby html after switching main html
        driver.switchTo().frame(0); //index num 0 because we have only one iframe
        Thread.sleep(1000);

        //cleare before send keys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("mustafa Karalık with index");

        //SECOND WAY switch back to the main/ PARENT html is
        driver.switchTo().parentFrame();

        //3.using Webelement to switch child html
        //locating iframe with any valid locator
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframeElement);

        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("mustafa Karalık with WEBELEMENT");
    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");

        //not possible dirctly goes to the lover level frames we need to go bottom first than goes to below
        //switchinbg to frame top
        driver.switchTo().frame("frame-top");
        //top has 3 frame under left middle and right
        //switch to frame middle
        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());

        //need to goes back to top frame
        driver.switchTo().parentFrame();

        //switching to right with index
        driver.switchTo().frame(2);

        System.out.println(driver.findElement(By.tagName("body")).getText());

        //go to main html to switch bottom
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.tagName("body")).getText());

    }
}
