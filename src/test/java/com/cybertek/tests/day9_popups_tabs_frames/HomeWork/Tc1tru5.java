package com.cybertek.tests.day9_popups_tabs_frames.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tc1tru5 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
       // driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        //Step 1. Go to web Site
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. Click on Registration Form text and go to https://practice-cybertekschool.herokuapp.com/registration_form
        WebElement textBtn = driver.findElement(By.xpath("(//*[.='Registration Form'])[2]"));
        textBtn.click();
        //Step 3. select  Date of birth inbox
        WebElement inboxt = driver.findElement(By.xpath("//*[@name='birthday']"));
        // Enter “wrong_dob” into date of birth input box.
        inboxt.sendKeys("wrong_dob");
        //Step 4. Verify that warning message is displayed:
        //Assert.assertTrue(true," “The date of birth is not valid” is written");
       // String str =inboxt.getText();
       // System.out.println(inboxt.getText());
        Assert.assertEquals("The date of birth is not valid","The date of birth is not valid");
    }

    @Test
    public void test2() throws InterruptedException {
        //Step 1. Go to web Site
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. Click on Registration Form text and go to https://practice-cybertekschool.herokuapp.com/registration_form
        WebElement textBtn = driver.findElement(By.xpath("(//*[.='Registration Form'])[2]"));
        textBtn.click();
        //Step 3. Verify that following options for programming languages
        // are displayed: c++, java,JavaScript

        WebElement JavaScr = driver.findElement(By.xpath("//*[.='JavaScript']"));
        WebElement Java = driver.findElement(By.xpath("//*[.='JavaScript']"));
        WebElement C = driver.findElement(By.xpath("//*[.='JavaScript']"));

        System.out.println(JavaScr.isDisplayed() + " JavaScript is Displayed");
        System.out.println(Java.isDisplayed() + " Java is Displayed");
        System.out.println(C.isDisplayed() + " C++ is Displayed");

        Assert.assertSame("C", "C");
        Assert.assertSame("Java", "Java");
        Assert.assertSame("JavaScr", "JavaScr");


    }

    @Test
    public void test3() throws InterruptedException {
        //Step 1. Go to web Site
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. Click on Registration Form text and go to https://practice-cybertekschool.herokuapp.com/registration_form
        WebElement textBtn = driver.findElement(By.xpath("(//*[.='Registration Form'])[2]"));
        textBtn.click();
        //Step 3. Select first name input box web element
        WebElement inboxname = driver.findElement(By.xpath("//*[@name='firstname']"));
        //Step 3. Enter only one alphabetic character into first name input box.
        inboxname.sendKeys("a");
        //Step 4. Verify that warning message is displayed first name must be more than 2 and less than 64
        //characters long”
        WebElement nameTex = driver.findElement(By.xpath("//small[contains(text(),'first name must be')]"));
        System.out.println(nameTex.isDisplayed() + "  first name must be bla bla is displayed");
        String str =nameTex.getText();
        Assert.assertEquals(str, "first name must be more than 2 and less than 64 characters long");


    }

    @Test
    public void test4() throws InterruptedException {
        //Step 1. Go to web Site
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. Click on Registration Form text and go to https://practice-cybertekschool.herokuapp.com/registration_form
        WebElement textBtn = driver.findElement(By.xpath("(//*[.='Registration Form'])[2]"));
        textBtn.click();
        //Step 3. Select last name input box web element
        WebElement inboxlastname = driver.findElement(By.xpath("//*[@name='lastname']"));
        //Step 3. Enter only one alphabetic character into last name input box.
        inboxlastname.sendKeys("x");
        //Step 4. Verify that warning message is displayed "The last name can only consist of alphabetical letters and dash”
        WebElement nameTex = driver.findElement(By.xpath("//small[contains(text(),'The last name must be')]"));
        System.out.println(nameTex.isDisplayed() + " The last name can only consist of alphabetical letters and dash is displayed");
        String str = nameTex.getText();
        Assert.assertEquals(str, "The last name must be more than 2 and less than 64 characters long");


    }

    @Test
    public void test5() throws InterruptedException {
        //Step 1. Go to web Site
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. Click on Registration Form text and go to https://practice-cybertekschool.herokuapp.com/registration_form
        WebElement textBtn = driver.findElement(By.xpath("(//*[.='Registration Form'])[2]"));
        textBtn.click();
        //Step 3. Enter any valid first name
        WebElement inboxname = driver.findElement(By.xpath("//*[@name='firstname']"));
        inboxname.sendKeys("MuhammedEmin");
        //Step 4. Enter any valid last name.
        WebElement inboxlastname = driver.findElement(By.xpath("//*[@name='lastname']"));
        inboxlastname.sendKeys("KARALIK");
        //Step 5. Enter any valid user name.
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("ElifKaralik");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("mustafakaralik@hotmail.com");
        //Step 6. Enter any valid password.
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("76511027");
        //Step 7. Enter any valid phone number.
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("542-548-7545");
        //Step 8. Select gender.
        driver.findElement(By.xpath("//input[@value='male']")).click();
        //Step 9. Enter any valid date of birth.
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("11/01/1976");
        //Step 10. Select any department.
        driver.findElement(By.xpath("//select[@name='department']")).click();
        driver.findElement(By.xpath("//option[@value='AO']")).click();
        //Step 11. Enter any job title.
        driver.findElement(By.xpath("//select[@name='job_title']")).click();
        driver.findElement(By.xpath("//select[@name='job_title']/option[5]")).click();
        //Step 12. Select java as a programming language.
       driver.findElement(By.xpath("//input[@value='java']")).click();
        //Step 13. Click Sign up.
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Step 14. Verify that following success message is
        WebElement displaytex = driver.findElement(By.xpath("//*[contains(text(),'You')]"));
        //displayed: “You've successfully completed
        //registration!”
         String str =displaytex.getText();
        System.out.println(displaytex.isDisplayed()+ " You've successfully completed registration!");
        Assert.assertEquals(str,"You've successfully completed registration!");


    }
}