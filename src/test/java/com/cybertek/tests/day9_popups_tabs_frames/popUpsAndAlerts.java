package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

    public class popUpsAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
       // driver.quit();
    }
    @Test
    public void test1() {
        driver.get("http://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        //click the destroy the World button
        driver.findElement(By.xpath("//button[.='Destroy the World']")).click();

        //click No button with text on the popup
        driver.findElement(By.xpath("//button[.='No']")).click();

    }
    @Test
        public void  test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        //click For JS alert button
        driver.findElement(By.xpath("//button[1]")).click();
        //switch to JS alert pop up
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();// yes pop-up
       // alert.dismiss(); // no pop-up

        //click for JS prompt
        driver.findElement(By.xpath("//button[3]")).click();
        //send keys to JS propmt
        alert.sendKeys("mustafakaralık");
        Thread.sleep(2000);
        //click OK
        alert.getText();
        alert.accept();

        //google browser notificationları JS İLE YAPILMADIĞI İÇİN ALERT CLASS KULLANAMYIZ

    }
}

