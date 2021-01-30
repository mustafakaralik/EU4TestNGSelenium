package com.cybertek.tests.day10_fileUpLoad;

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

public class HoverTest {
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


    /*
     * hover over each image in teh website
     * verify eaCH İMAGE name; user text is displayed
     * */
    @Test
    public void test1() throws InterruptedException {
        //eğer resim sayısı belli değil ise
        driver.get("http://practice.cybertekschool.com/hovers");
        driver.manage().window().maximize();

        List<WebElement> user = driver.findElements(By.xpath("//div[@class='figure']"));

        Actions actions = new Actions(driver);

        for (WebElement obj : user) {
            int dummy = 0;
            dummy++;
            WebElement userNames = driver.findElement(By.xpath("//*/h5[.='name: user" + dummy + "']"));

            actions.moveToElement(obj).perform();

            System.out.println("userNames.getText() = " + obj.getText());

            Thread.sleep(1000);
            // WebElement text1 = driver.findElement(By.linkText("View profile"));
            // Assert.assertTrue(text1.isDisplayed(),"verify view link is displayed");
        }
    }

    @Test
    public void oneImage() throws InterruptedException {
        //tek resim üzerine hover over
        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement img1 =driver.findElement(By.tagName("img"));
        Actions actions=new Actions(driver);
        Thread.sleep(1000);
        actions.moveToElement(img1).perform();
        WebElement text1 =driver.findElement(By.xpath("//h5[.='name: user1']"));
    }

    @Test
    public void allImage() throws InterruptedException {
        //tüm resim üzerine hover over
        driver.get("http://practice.cybertekschool.com/hovers");

        for (int i = 1; i <=3; i++) { //eğer resim sayısı belli ise
            String xpathimg ="(//img)["+i+"]";
            WebElement img1 =driver.findElement(By.xpath(xpathimg));
            System.out.println(xpathimg);
            Actions actions=new Actions(driver);

            Thread.sleep(1000);
            actions.moveToElement(img1).perform();

            //verification part
            String textXpath ="//h5[.='name: user"+i+"']";
            WebElement text1 =driver.findElement(By.xpath(textXpath));
            Assert.assertTrue(text1.isDisplayed(),"verify text "+i+" is displayed");
        }

    }

}