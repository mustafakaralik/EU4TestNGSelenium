package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

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
    public void test1(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //save our web element inside the list
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        System.out.println("buttons.size() = " + buttons.size());

        //verify button size
        Assert.assertEquals(buttons.size(),6,"verify buttons size");

        //iter+ enter to get each loop with shortcut
        for (WebElement button : buttons) {
            //name of all buttons on screen
            System.out.println(button.getText());
            //which buttons are dhown in screed .isdisplayed
            System.out.println("button.isDisplayed() = " + button.isDisplayed());
            //testcase de assert ile yapmalıyız bu işlemi -->görünen butonlar
            //bu sayede butonlardan biri görünmüyor ise fail alırız
            Assert.assertTrue(button.isDisplayed(),"verify buttons are displayed");

        }

        //click second button //index start from 0
        buttons.get(1).click();

        }
         @Test
            public void test2(){
            driver.get("http://practice.cybertekschool.com/multiple_buttons");

            //when web element couldnt find by compiler no such element when regular find element method
            //driver.findElement(By.tagName("buttonldksssdsddaf"));

             //same way passing locator which does not exist it will not trow NoSuchelement NSE
            //benzer şekilde buton olmamasına webelement olmamasına rağmen no error oldu
             List<WebElement> buttons = driver.findElements(By.tagName("buttontryhrhh")); //Alt+EEnter one more Enter to shortcut

            //bu yüzden daima button size control edilmeli
             System.out.println("buttons.size() = " + buttons.size());

         }

    }

