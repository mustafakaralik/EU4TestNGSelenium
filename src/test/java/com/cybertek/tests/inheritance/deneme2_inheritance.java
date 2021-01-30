package com.cybertek.tests.inheritance;

public class deneme2_inheritance extends DENEME_inheritance {
    String MainSubject = "Spark";

    public static void main(String[] args) {
        deneme2_inheritance obj = new deneme2_inheritance();

        System.out.println(obj.MainSubject);
        System.out.println(obj.collegeName);
        System.out.println(obj.designation);
        obj.does();
    }
}
