package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {

    /*
    * goto  amazon
    *search for selenium
    *
    * */
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("java");

        driver.findElement(By.xpath("//input[@value='Go']")).click();

        WebElement result =   driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[1]"));
                                                             //span[.='1-48 of 108 results for']
                     //***all for xpad code TEXT***//-->    // span[text()='1-48 of 108 results for']
                                                           // span[contains(text(),'results for'')]
        String  resultText = result.getText();
        System.out.println("resulttext: "+ resultText);

        String expectedResult ="1-48 of 108 results for";

        if (expectedResult.equals(resultText)){
            System.out.println("PASS");

        }else {
            System.out.println("FAIL");
            System.out.println("expectedResult = "+ expectedResult);
            System.out.println("resultText = "+  resultText);
        }
             driver.quit();
    }
}
