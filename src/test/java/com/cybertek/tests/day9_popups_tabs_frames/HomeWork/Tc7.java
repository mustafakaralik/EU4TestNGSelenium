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

public class Tc7 {
    /*
    * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    Step 2. And click on “File Upload".
    Step 3. Upload any ﬁle with .txt extension from yourcomputer.
    Step 4. Click “Upload” button.
    Step 5. Verify that subject is: “File Uploaded!”

    Step 6. Verify that uploaded ﬁle name is displayed.
    */
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void TC7() throws InterruptedException {
          //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com");
         //Step 2. And click on “File Upload".
        driver.findElement(By.xpath("//a[@href='/upload']")).click();
        //Step 3. Upload any ﬁle with .txt extension from yourcomputer.
        WebElement fileupload = driver.findElement(By.id("file-upload"));
        fileupload.sendKeys("C:\\Users\\Blacness\\Desktop\\uploadtest.txt");
       // Step 4. Click “Upload” button.
        driver.findElement(By.id("file-submit")).click();
      //   Step 5. Verify that subject is: “File Uploaded!”
       WebElement subj = driver.findElement(By.xpath("//*[.='File Uploaded!']"));
       String str=subj.getText();
        Assert.assertEquals(str,"File Uploaded!");
      //  Step 6. Verify that uploaded ﬁle name is displayed.
        WebElement uplodfilename= driver.findElement(By.id("uploaded-files"));
        String str3= uplodfilename.getText();
        Assert.assertTrue(uplodfilename.isDisplayed(),str3);
    }
}
