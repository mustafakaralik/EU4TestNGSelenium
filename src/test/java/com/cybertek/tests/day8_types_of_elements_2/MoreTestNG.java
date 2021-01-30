package com.cybertek.tests.day8_types_of_elements_2;

import org.testng.annotations.Test;

public class MoreTestNG {
    @Test(priority = 1)
    public void C(){
        System.out.println("My Third Test Case");

    }

    @Test (priority = 2)
    public void A(){

        System.out.println("My First Test Case");
    }

    @Test(priority = 3)
    public void B(){
        System.out.println("My Second Test Case");
    }

}

