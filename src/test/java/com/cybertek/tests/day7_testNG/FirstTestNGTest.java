package com.cybertek.tests.day7_testNG;

import org.testng.annotations.Test;

public class FirstTestNGTest {
    //do not create main method gor testNG

    @Test
    public void test1() {
        System.out.println("My first test case");
    }
    @Test
    public void test2() {
        System.out.println("My second test case");
    }
}
