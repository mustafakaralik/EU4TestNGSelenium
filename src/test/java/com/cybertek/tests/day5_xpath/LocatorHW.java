package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorHW {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver drivers =new ChromeDriver();

        //WebDriver drivers = WebDriverFactory.getDriver("chrome");

        drivers.get("http://www.google.com");
        Thread.sleep(1000);

      // WebElement googleSearch =drivers.findElement(By.name("q"));
       // googleSearch.sendKeys("www.ebay.com");     //google A yazıp gitme

     //   WebElement araBtn =drivers.findElement(By.class"iblpc");
       // araBtn.click();

        drivers.navigate().to("https://www.ebay.com"); //direk siteye gitme
        Thread.sleep(1000);

        WebElement araBtnn =drivers.findElement(By.id("gh-ac")); //ebaya armak istene ürünü gir
        araBtnn.sendKeys("nike");

        WebElement srch =drivers.findElement(By.id("gh-btn")); //ara butonuna bas
        srch.click();

       // WebElement result =drivers.findElement(By.xpath("//h1/span[1]"));

        String text = drivers.findElement(By.xpath("//h1/span[1]")).getText();
        System.out.println(text+ " result for "+ " nike");

    }



}
