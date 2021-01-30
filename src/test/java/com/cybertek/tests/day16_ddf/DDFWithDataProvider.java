package com.cybertek.tests.day16_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {

  @DataProvider
    public Object  [][]  testData(){ //it returns two dimensional array
        String [][] data ={
                {"Person of Interest","10"}, // we can add here many data
                {"Sherlock","9"},
                {"Breaking Bad ","9"},
                {"The Office","8"},
                {"Friends","7"},
                {"Westworld","10"},
                {"Gotham","9"},
                {"Dark","8"}


        };
      return data;
  }

  @Test (dataProvider = "testData")
  public void test1(String tvShow,String rating){ //if data more than two add more
      System.out.println("Tv Shows: "+ tvShow + "has rating "+ rating);



  }

}
