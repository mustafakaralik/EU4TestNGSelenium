package com.cybertek.tests.inheritance;

public class Employee_Single_inheritance_child extends Person_Single_inheritance_Parent {
    private String EmployeeNumber;
    public void setEmployeeNumber(String emp){
        EmployeeNumber=emp;

    }
    public String getEmployeeNumber(){
        return (EmployeeNumber);
    }


}
