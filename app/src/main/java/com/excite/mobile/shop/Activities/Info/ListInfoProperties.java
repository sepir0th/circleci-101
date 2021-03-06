package com.excite.mobile.shop.Activities.Info;

import com.excite.mobile.shop.Activities.Home.EarnPointDetails.ShopOnline.ShopOnlineProperties;

/**
 * Created by erwinlim on 16/03/18.
 */

public class ListInfoProperties extends ShopOnlineProperties {

    private String strNotificationID;

    public ListInfoProperties(int intListIcon, String strListTitle, String strListSubtitle, String strNotificationID) {
        super(intListIcon, strListTitle, strListSubtitle, "");
        setNotificationID(strNotificationID);
    }

    /*Getters and setters to access the private members*/
    public String getNotificationID() {
        return strNotificationID;
    }
    public void setNotificationID(String strListSubtitle) {
        this.strNotificationID = strListSubtitle;
    }
}
