package com.cybertek.tests.day10_fileUpLoad;

import org.testng.annotations.Test;

public class FilepathExample {

    @Test
    public void test1(){
      //  C:\Users\Blacness\IdeaProjects\EU4TestNGSelenium\src\test\resources\textfile.txt

        //C:\Users\Blacness\IdeaProjects\EU4TestNGSelenium
        System.out.println(System.getProperty("user.dir"));  //full path

        String projectPath = System.getProperty("user.dir");
        String filePath ="src\\test\\resources\\textfile.txt";
        String fullPath =projectPath+"\\"+ filePath;
        System.out.println(fullPath);
                }


}
