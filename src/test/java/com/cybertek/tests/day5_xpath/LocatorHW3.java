package com.cybertek.tests.day5_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorHW3 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://google.com");

        driver.get("https://tr.wikipedia.org");

        WebElement search = driver.findElement(By.name("search"));
        search.sendKeys("selenium webdriver");

        WebElement btn= driver.findElement(By.name("go"));
        btn.click();
    }
}
