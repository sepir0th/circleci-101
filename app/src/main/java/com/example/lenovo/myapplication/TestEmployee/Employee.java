package com.example.lenovo.myapplication.TestEmployee;

import android.widget.GridView;

import com.example.lenovo.myapplication.CustomGridview.BooksAdapter;

/**
 * Created by erwinlim on 23/02/18.
 */
public class Employee {
    private String employeeName;
    private String employeeEmail;
    private BooksAdapter subMenu;

    public Employee(String employeeName, String employeeEmail, BooksAdapter subMenu) {
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.subMenu = subMenu;
    }

    /*Getters and setters to access the private members*/
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public BooksAdapter getGridViewMenu() {
        return subMenu;
    }

    public void setSubMenu(BooksAdapter subMenu) {
        this.subMenu = subMenu;
    }
}