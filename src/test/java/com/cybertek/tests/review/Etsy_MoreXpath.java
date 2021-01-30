package com.cybertek.tests.review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Etsy_MoreXpath {

    /*
    * open etsy.com
    * click clothing&shoes button upperside bar
    * string manupilation and change to home & living button
    * */

    @Test
            public void test1 (){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.etsy.com");

        String menuName ="  Home & Living";  // "  Home & Living";  //"  Clothing & Shoes";

        String XpathLocator ="//li//a//*[contains(text(),'  "+menuName+"')]";

        WebElement menu = driver.findElement(By.xpath(XpathLocator));
        menu.click();
    }


}
