package com.cybertek.tests.day5_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class LocatorHW2 {

    public static void main(String[] args) throws InterruptedException {


     WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();

        driver.get("https://www.ebay.com");
        Thread.sleep(1000);
        WebElement araBtnn =driver.findElement(By.id("gh-ac")); //ebaya armak istene ürünü gir
        araBtnn.sendKeys("selenium");

        WebElement srch =driver.findElement(By.id("gh-btn")); //ara butonuna bas
        srch.click();

        String title= driver.getTitle();
        System.out.println("title = " + title+ " contains selenium");

        String text = driver.findElement(By.xpath("//h1/span[1]")).getText();
        System.out.println(text+ " result for "+ " selenium");
    }
}