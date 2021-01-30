package com.cybertek.tests.review;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class moreXpath {

  /*  @Test //instead of main method we will use TestNg
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

        WebElement dontChangeButton = driver.findElement(By.xpath("//*[@id=\"nav-main\"]/div[1]/div/div/div[3]/span[1]/span/input"));
        dontChangeButton.click();

        Thread.sleep(2000);
        WebElement menu = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[3]")); ////div[@id='nav-xshop']/*[.='Gift Cards']
        // Thread.sleep(2000);
        menu.click();*/

       @Test
    public void test1(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        WebElement dontChg = driver.findElement(By.xpath("//input[@data-action-params='{\"toasterType\":\"AIS_INGRESS\"}']"));
        dontChg.click();

            String menuName = "Sell";
        // WebElement menu = driver.findElement(By.xpath("//div[@id='nav-xshop']//*[.='Gift Cards']")); //parantez içi string olduğu için yerine dummy string koyabiliriz
            String XpathLocator = "//div[@id='nav-xshop']/*[.='"+menuName+"']"; //sadece dynamic olarak değişen bölümü change ediyoruz -gift card -Best seller vs
         //String XpathLocator = "//div[@id='nav-xshop']//*[.='Gift Cards']";


        WebElement menu = driver.findElement(By.xpath(XpathLocator));
        //WebElement menu2 = driver.findElement(By.xpath("//div[@id='nav-xshop']//*[.='Best Sellers']"));
        menu.click();
    }

    }
