package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC3_HW {

    /*  TC #3: SeleniumEasy Checkbox Verification –Section 2
    1.Open Chrome browser
    2.Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
    3.Verify “Check All” button text is “Check All”
    4.Click to “Check All” button
    5.Verify all check boxes are checked
    6.Verify button text changed to “Uncheck All”
     */
    @Test
    public void test3() throws InterruptedException {
        //-->select browser driver
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        //-->maximize webpage
        driver.manage().window().maximize();
        //-->goto the web site
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        //find element that will be checked
        WebElement ChkAllBtn = driver.findElement(By.xpath("//input[@value='Check All']"));
        //web element üzerindeki değeri yazdırır
        System.out.println("checkAll.getAttribute() = " + ChkAllBtn.getAttribute("value"));
        //web elemenin şu anki  değeri ile beklenen  olması istenen değeri karşılaştırırıp
        // //verify eder yaNLIŞ İSe yazar doğru ise uyarı vermez
        Assert.assertEquals(ChkAllBtn.getAttribute("value"),"Check All","Verify Check All button text is NOT changed to Check All”");

        //click chkallbtn
        Thread.sleep(2000);
        ChkAllBtn.click();

        //-->after click chkallbtn
        //verify check All button changed to Uncheck All and verify it
        WebElement unchkallBtn =driver.findElement(By.xpath("//input[@value='Uncheck All']"));
        System.out.println("unchkallBtn.isDisplayed() = " + unchkallBtn.isDisplayed());
        Assert.assertEquals(ChkAllBtn.getAttribute("value"),"Uncheck All",
                "Verify Uncheck All button is NOT changed Uncheck All”");








        //  5.Verify all check boxes are checked

        WebElement option1=driver.findElement(By.xpath("(//input[@class='cb1-element'])[1]"));
        //click ckbutton 1
        option1.click();
        WebElement option2=driver.findElement(By.xpath("(//input[@class='cb1-element'])[2]"));
        WebElement option3=driver.findElement(By.xpath("(//input[@class='cb1-element'])[3]"));
        WebElement option4=driver.findElement(By.xpath("(//input[@class='cb1-element'])[4]"));

        Assert.assertTrue(option1.isSelected(),"Verify that option 1 is selected");
        Assert.assertTrue(option2.isSelected(),"Verify that option 2 is selected");
        Assert.assertTrue(option3.isSelected(),"Verify that option 3 is selected");
        Assert.assertTrue(option4.isSelected(),"Verify that option 4 is selected");

        driver.quit();
    }
}



/*







      /*  WebElement checkAllbtn=driver.findElement(By.xpath("(//input[@value='Check All'])"));
        Assert.assertEquals(checkAllbtn.getAttribute("value"),"Check All");

        checkAllbtn.click();

        WebElement option1=driver.findElement(By.xpath("(//input[@class='cb1-element'])[1]"));
        WebElement option2=driver.findElement(By.xpath("(//input[@class='cb1-element'])[2]"));
        WebElement option3=driver.findElement(By.xpath("(//input[@class='cb1-element'])[3]"));
        WebElement option4=driver.findElement(By.xpath("(//input[@class='cb1-element'])[4]"));

        Assert.assertTrue(option1.isSelected(),"Verify that option 1 is selected");
        Assert.assertTrue(option2.isSelected(),"Verify that option 2 is selected");
        Assert.assertTrue(option3.isSelected(),"Verify that option 3 is selected");
        Assert.assertTrue(option4.isSelected(),"Verify that option 4 is selected");

        WebElement uncheckAllBtn=driver.findElement(By.xpath("//input[@value='Uncheck All']"));
        Assert.assertEquals(uncheckAllBtn.getAttribute("value"),"Uncheck All");

        driver.quit();
        */


