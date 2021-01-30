package com.cybertek.tests.day7_testNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionDemo { //instead of us'ng if else we can use assertion in testNG

    @BeforeMethod  //optional but you can add
    public void setUp(){
        System.out.println("Open Browser");
    }

    @Test
    public void test1(){

        Assert.assertEquals("title","tiTle");
        System.out.println("First Assertion");

        Assert.assertEquals("url","url");
        System.out.println("Second Assertion");

    //after method kullandığımızda  Assert methodlardan biri fail olsa bile
        // hemen codu sonlandırmaz ve after method varsa uygular
    // testNg direk kapanmadan sonrasındaki Codu uygular burada "close browser"


    }

    @Test
    public void test2(){
      Assert.assertEquals("test2","test22","Verify Test2");
    }

    @Test
    public void test3 (){
        String expectedTitle ="Cyt";
        String actualTitle = "Cybertek";

     // if  (actualTitle.startsWith(expectedTitle)){ //if ile yapsaydık sonucu true false alacaktık

        Assert.assertTrue(actualTitle.startsWith(expectedTitle), "verify title starts with Cyb");

    }

    @Test
    public void test4 () {
        //verify email contains @ sign
        String email = "mike@smith.com";

    //    Assert.assertEquals(email, "@");
        //iki verinin eşit olup olamdığını test eden assertEqual
    /*
    * if (email.contains("@")){
    * System.out.println("PASS");
    * }else{                        //***YERİNE  A
    * System.out.println("FAIL");
    * }*/

        Assert.assertTrue(email.contains("@"),"Verify email contains @");
        //bir test sonucu true false olarak isteniyorsa assertTrue kullanırız
    }

    @Test
    public void test5(){
        Assert.assertFalse(0>1,"verify that 0 is not greater than 1");
    }
    @Test
    public void test6(){
        Assert.assertNotEquals("one","two");

    }

    @AfterMethod
    public void tearDown (){
        System.out.println("Close Browser");
    }
}
