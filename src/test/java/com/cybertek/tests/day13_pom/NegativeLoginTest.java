package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest(){
    //HOW WE CAN USE PAGE OBJECT MODULE LOCATERS İNSİDE OUR TESTCASES
        // ANSWER İS we need to create object from login page

        LoginPage loginpage = new LoginPage(); //loginpage objesi ne tutuyorsa onları çağırabiliriz

        loginpage.usernameInput.sendKeys("user1");
        loginpage.passwordInput.sendKeys("somepassword");
        loginpage.loginBtn.click();


      /*  driver.findElement(By.id("prependedInput")).sendKeys("user1");
        driver.findElement(By.id("prependedInput2")).sendKeys("somepassword");
        driver.findElement(By.id("_submit")).click(); */

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");


    }

    @Test
    public void wrongUsernameTest(){

        LoginPage loginpage =new LoginPage();//create an object

        loginpage.usernameInput.sendKeys("someusername");
        loginpage.passwordInput.sendKeys("UserUser123");
        loginpage.loginBtn.click();
    }
}
