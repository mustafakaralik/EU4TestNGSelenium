package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    //@Test
    public void test1(){
        //Singleton OBJT =new Singleton(); private constuctor we can not create object
        String s1 = Singleton.getInstance();//s1 objecti get metodunda ne varsa string olarak çekecek
        String s2 = Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }


    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = Driver.get(); //Singleton same object
        Thread.sleep(2000);
        driver.get("https://www.google.com");

        Driver.closeDriver(); //denmediği müddetçe aynı object ile çağırılır
        //bunu dersek google açılır kapanır ve sonra amazon açılır

    }

    @Test
    public void test3(){
        WebDriver driver = Driver.get(); //Singleton same object

        driver.get("https://www.amazon.com");
    }

}
