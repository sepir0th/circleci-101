package com.example.lenovo.myapplication.Activities.EarnPointDetails;

import com.example.excitemobilesdk.CustomGridView.GridViewMenuAdapter;

/**
 * Created by erwinlim on 07/03/18.
 */

public class ListEarnPointsMenuProperties {
    private int intListIcon;
    private String strListTitle;
    private String strListSubtitle;
    private String strListDistance;

    public ListEarnPointsMenuProperties(int intListIcon, String strListTitle, String strListSubtitle, String strListDistance) {
        this.intListIcon = intListIcon;
        this.strListTitle = strListTitle;
        this.strListSubtitle = strListSubtitle;
        this.strListDistance = strListDistance;
    }

    /*Getters and setters to access the private members*/
    public int getListIcon() { return intListIcon; }
    public String getListSubtitle() {
        return strListSubtitle;
    }
    public String getListDistance() { return this.strListDistance; }
    public String getListTitle() { return this.strListTitle; }

    public void setListIcon(int intListIcon) { this.intListIcon = intListIcon; }
    public void setListSubtitle(String strListSubtitle) {
        this.strListSubtitle = strListSubtitle;
    }
    public void setListDistance(String strListDistance) { this.strListDistance = strListDistance; }
    public void setListTitle(String strListTitle) { this.strListTitle = strListTitle; }

}