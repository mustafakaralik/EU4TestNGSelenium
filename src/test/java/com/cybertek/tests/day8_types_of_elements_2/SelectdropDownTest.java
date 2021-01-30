package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectdropDownTest {

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
        driver.get("http://practice.cybertekschool.com/dropdown");

        //1.Locate your dropdown just like any other webelement with unique locator
        WebElement dropdwnElement = driver.findElement(By.id("state"));

        //2.create Select object by passing that element as a constructor
        Select stateDropDown = new Select(dropdwnElement);

        //getoptions --> returns all the available options from the dropdown
        List<WebElement> options = stateDropDown.getOptions();
        //print size of the options
        System.out.println("options.size() = " + options.size());
        //print options one by one
        for (WebElement option : options) {
            System.out.println(option.getText());
        }


    }
    @Test
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dropdown");

        //1.Locate your dropdown just like any other webelement with unique locator
        WebElement dropdwnElement = driver.findElement(By.id("state"));

        //2.create -Select object- by passing that element as a constructor
        Select stateDropDown = new Select(dropdwnElement);

        //verify that first selection is select a state
        String expectedoption ="Select a State";
        String actualOption = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedoption,"verify first selection");

        //HOW TO SELECT OPTIONS FROM DROPDOWN ?
        //1.SELECET USİNG VİSİBLE TEXT
        stateDropDown.selectByVisibleText("Virginia");

        //how we can verify true one selected or not
        expectedoption ="Virginia";
        actualOption = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedoption,"verify first selection");

        //2. SELECT USING INDEX
        Thread.sleep(1000);
        stateDropDown.selectByIndex(51);

        expectedoption ="Wyoming";
        actualOption = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedoption,"verify first selection");

        //3.SELECT BY VALUE
        Thread.sleep(1000);
        stateDropDown.selectByValue("TX");
        actualOption = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedoption,"verify first selection");




    }
}
