package com.excite.mobile.shop.Database;

/**
 * Created by erwinlim on 14/03/18.
 */

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface NotificationDao {

    @Query("SELECT * FROM Notification")
    List<Notification> getAll();

    @Query("SELECT * FROM Notification where notificationID LIKE  :notificationID")
    Notification findByName(String notificationID);

    @Query("SELECT COUNT(*) from Notification")
    int countNotifications();

    @Insert
    void insertAll(Notification... notifications);

    @Delete
    void delete(Notification notifications);
}
