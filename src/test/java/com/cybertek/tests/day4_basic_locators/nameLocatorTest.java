package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //make browse fullScreen
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInput = driver.findElement(By.name("full_name"));
        fullNameInput.sendKeys("Mike Smith");

        //task for 5 min
        //put some e-mail and click sign up button

        //proper way
        //WebElement email =driver.findElement(By.name("email"));
        //email.sendKeys(("mike@smith.com"));

        //lazy way or practical
        driver.findElement(By.name("email")).sendKeys("Mike@smith.com");


        //proper way
        //WebElement signUpButton =driver.findElement(By.name("wooden_spoon"));
       // signUpButton.click();

        //lazy way or practical
        driver.findElement(By.name("wooden_spoon")).click();






    }
}
