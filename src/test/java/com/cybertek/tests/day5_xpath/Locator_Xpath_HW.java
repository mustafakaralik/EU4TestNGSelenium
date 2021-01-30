package com.cybertek.tests.day5_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locator_Xpath_HW {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement HomeBtn =driver.findElement(By.xpath("//body/nav/ul/li/a"));
        String textHomeBtn= driver.findElement(By.xpath("//body/nav/ul/li/a")).getText();
        System.out.println(textHomeBtn+ " button");

        WebElement header =driver.findElement(By.xpath("//h2"));
        String textheader= driver.findElement(By.xpath("//h2")).getText();
        System.out.println(textheader+" header");

        WebElement emailtext =driver.findElement(By.xpath("//label"));
        String textemailtext= driver.findElement(By.xpath("//label")).getText();
        System.out.println(textemailtext+ " email text");

        WebElement emailbox =driver.findElement(By.xpath("//input"));
        emailbox.sendKeys("mustafakara@gmail.com");

        WebElement retrieve =driver.findElement(By.xpath("//button"));
        String retrievebtn= driver.findElement(By.xpath("//button")).getText();
        System.out.println(retrievebtn+  " retrieve button");




    }
}
