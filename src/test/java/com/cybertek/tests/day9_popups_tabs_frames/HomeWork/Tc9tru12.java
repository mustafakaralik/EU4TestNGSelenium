package com.cybertek.tests.day9_popups_tabs_frames.HomeWork;

        import com.cybertek.utilities.WebDriverFactory;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.testng.Assert;
        import org.testng.annotations.BeforeTest;
        import org.testng.annotations.DataProvider;
        import org.testng.annotations.Test;
        import java.util.concurrent.TimeUnit;

public class Tc9tru12 {

    @DataProvider (name = "statusCode")

    public Object[][] dpMethod() {
        return new Object [][] {
                {"200"},
                {"301"},
                {"404"},
                {"500"}
        };
    }
    WebDriver driver;
    //String driverPath = "C:\\geckodriver.exe";

    @BeforeTest
    public void setup(){
        //Create firefox driver object
        //System.setProperty("webdriver.gecko.driver", driverPath);
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(dataProvider ="statusCode")
    public void test9(String name){
        //Step 1. Go to "https://practice-cybertekschool.herokuapp.com"
        driver.get("https://practice-cybertekschool.herokuapp.com");
        // Step 2. And click on "Status Codes".
        driver.findElement(By.partialLinkText("Status Codes")).click();
        // Step 3. Then click on "200"., 301+ 404,+ 500
        driver.findElement(By.linkText(name)).click();
        // Step 4. Verify that following message is displayed: "This page returned a 200 status code"

        String re= driver.findElement(By.xpath("//*[@id='content']/div/p")).getText();
        System.out.println(re);
        String result="This page returned a "+ name+" status code.";
        System.out.println(result);
        WebElement statusCode=driver.findElement(By.xpath("//*[@id='content']/div/p"));
        Assert.assertTrue(statusCode.isDisplayed(),"verify message is displayed");
        // Assert.assertTrue(re.contains(result));
    }
}