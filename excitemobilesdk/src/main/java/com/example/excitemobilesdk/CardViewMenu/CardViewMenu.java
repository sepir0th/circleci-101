package com.example.excitemobilesdk.CardViewMenu;


import com.example.excitemobilesdk.CustomGridView.GridViewMenuAdapter;

/**
 * Created by erwinlim on 23/02/18.
 */
public class CardViewMenu {
    private String strCardViewMenuTitle;
    private String strCardViewMenuSubitle;
    private GridViewMenuAdapter subMenu;
    private int intColumnNum = 0;

    public CardViewMenu(String employeeName, String employeeEmail, GridViewMenuAdapter subMenu) {
        this.strCardViewMenuTitle = employeeName;
        this.strCardViewMenuSubitle = employeeEmail;
        this.subMenu = subMenu;
    }

    public CardViewMenu(String employeeName, String employeeEmail, GridViewMenuAdapter subMenu, int intColumnNum) {
        this.strCardViewMenuTitle = employeeName;
        this.strCardViewMenuSubitle = employeeEmail;
        this.subMenu = subMenu;
        this.intColumnNum = intColumnNum;
    }

    /*Getters and setters to access the private members*/
    public String getEmployeeName() {
        return strCardViewMenuTitle;
    }

    public void setCardViewMenuTitle(String employeeName) {
        this.strCardViewMenuTitle = employeeName;
    }

    public String getEmployeeEmail() {
        return strCardViewMenuSubitle;
    }

    public int getColumnNum() {
        return this.intColumnNum;
    }

    public void setCardViewMenuSubitle(String employeeEmail) {
        this.strCardViewMenuSubitle = employeeEmail;
    }

    public GridViewMenuAdapter getGridViewMenu() {
        return subMenu;
    }

    public void setSubMenu(GridViewMenuAdapter subMenu) {
        this.subMenu = subMenu;
    }
}