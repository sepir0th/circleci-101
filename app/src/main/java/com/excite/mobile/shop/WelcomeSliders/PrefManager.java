package com.excite.mobile.shop.WelcomeSliders;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by erwinlim on 13/02/18.
 */

public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "Excite-pref";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String IS_LOGGED_IN = "IsLoggedIn";
    private static final String USER_LOGIN_ACCOUNT_ID = "UserLoginAccountID";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public void setUserLoginAccountID(String UserLoginAccountID) {
        editor.putString(USER_LOGIN_ACCOUNT_ID, UserLoginAccountID);
        editor.commit();
    }

    public void setLoginSession(boolean IsLoggedIn){
        editor.putBoolean(IS_LOGGED_IN, IsLoggedIn);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
    public boolean isLoginSession() {
        return pref.getBoolean(IS_LOGGED_IN, false);
    }
    public String getUserLoginAccountID() {
        return pref.getString(USER_LOGIN_ACCOUNT_ID, "");
    }
}
