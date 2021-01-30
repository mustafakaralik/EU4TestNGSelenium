package com.cybertek.tests.inheritance;

public class EmployeePersonTest_Single_inheritance {
    public static void main(String[] args) {
        Employee_Single_inheritance_child empdata = new Employee_Single_inheritance_child();
        empdata.setAge(25);
        empdata.setName("Mustafa");
        empdata.setEmployeeNumber("76511027");

        System.out.println("Name: "+empdata.getName());
        System.out.println("Age: "+ empdata.getAge());
        System.out.println("Employee Number: "+empdata.getEmployeeNumber());
    }
}
