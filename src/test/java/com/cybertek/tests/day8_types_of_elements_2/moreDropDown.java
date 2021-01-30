package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class moreDropDown {

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
    public void test1() {
        driver.get("http://practice.cybertekschool.com/dropdown");

        //1.Locate the drop downwith name
        WebElement dropDownElement = driver.findElement(By.name("Languages"));

        //2. create select object
        Select langDropdown = new Select(dropDownElement);

        // get the default selection

        langDropdown.selectByIndex(1);
        System.out.println("selected = " + langDropdown.getFirstSelectedOption().getText());

        langDropdown.selectByIndex(0);
        langDropdown.selectByIndex(3);
        langDropdown.selectByIndex(4);

        System.out.println("selected = " + langDropdown.getFirstSelectedOption().getText());

        //GET ALL SELECTED OPTİONS
        List<WebElement> allSelectedOptions = langDropdown.getAllSelectedOptions();

        for (WebElement option : allSelectedOptions) {
            System.out.println(option.getText());

        }

        //DESELECT ALL OPTİONS
        langDropdown.deselectAll();




    }

    }
