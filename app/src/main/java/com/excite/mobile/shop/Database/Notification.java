package com.excite.mobile.shop.Database;

/**
 * Created by erwinlim on 14/03/18.
 */


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "notification")
public class Notification {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "notificationID")
    private String notificationID;

    @ColumnInfo(name = "notificationTitle")
    private String notificationTitle;

    @ColumnInfo(name = "notificationSubtitle")
    private String notificationSubtitle;


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(String notificationID) {
        this.notificationID = notificationID;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String  getNotificationSubtitle() {
        return notificationSubtitle;
    }

    public void setNotificationSubtitle(String  notificationSubtitle) {
        this.notificationSubtitle = notificationSubtitle;
    }

}