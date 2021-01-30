package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

public class CheckboxDemo {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver  = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement chkbox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement chkbox2 = driver.findElement(By.xpath("//input[2]"));

        // How to verify checkbox selected or not ?
        System.out.println("chkbox1.isSelected() = " + chkbox1.isSelected());
        System.out.println("chkbox2.isSelected() = " + chkbox2.isSelected());

        //Verify checkbox 1 is not selected ,2 is selected
        Assert.assertFalse(chkbox1.isSelected(),"verify checkbox1 is NOT selected");
        Assert.assertTrue(chkbox2.isSelected(),"verify checkbox2 is selected");

        // how to check checkboxes?
        //just like a radio button we use click()method;
        Thread.sleep(2000);
        chkbox1.click();


        //verify after click
        Assert.assertTrue(chkbox1.isSelected(),"verify checkbox1 is selected");
        Assert.assertTrue(chkbox2.isSelected(),"verify checkbox2 is selected");
       Thread.sleep(3000);
        driver.quit();
    }
}
