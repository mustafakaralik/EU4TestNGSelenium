package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest {

    @Test
    public void test1(){
        //ConfigurationReader clas'ımız içinden config.prop.file  içindeki Key Name browser alınır
        String browserType = ConfigurationReader.get("browser");

        //bu frameworku oluşturmadan her bir class için şunu yazmıştık her defasımda
        // WebDriver driver = WebDriverFactory.getDriver(browserType);
        System.out.println("browserType = " + browserType); //  chrome here

        //siteyi çağırmak için herbir class içine şunu yazmıştık her defasında
        //driver.get("https://cybertexschool.com");
        String url = ConfigurationReader.get("url");

         System.out.println("url = " + url);// config.prop.file  içind  hangi site varsa o gelir


    }

    @Test
    public void OpenBrowserWithConf(){

        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));

        driver.get(ConfigurationReader.get("url"));

        String username = ConfigurationReader.get("driver_username");//these green word is key name
        String password = ConfigurationReader.get("driver_password");//from config.prop.file dan

        //driver.findElement(By.id("prependedInput")).sendKeys("User1");
        // ile buradan kullanıcı adını değişitirmek yerine  from config.prop.file dan aldık
        //birden çok kullanıcı password olsa idi dataproviderkullanacaktık
        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password+ Keys.TAB);
                                                          //submit mause ile click yerine klayve enter
                                                    //böylece  buton yerini web element ile aramadık


        WebDriver driver1 = WebDriverFactory.getDriver("chrome");
        driver1.get("http://google.com");
        //WebDriver driver2 = WebDriverFactory.getDriver("chrome");
        //driver2.findElement() -->ERROR
        //but there is a way to create a class which returns all th time same object SİNGLETON
    }


}
