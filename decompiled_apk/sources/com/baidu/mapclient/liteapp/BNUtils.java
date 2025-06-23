package com.baidu.mapclient.liteapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import com.baidu.mapclient.liteapp.activity.NaviActivity;
import com.baidu.mapclient.liteapp.activity.NaviSettingActivity;
import com.blankj.utilcode.util.Utils;
import com.szabh.navi.R;

/* loaded from: classes7.dex */
public class BNUtils {
    public static final int ANALOG = 4;
    private static final String APP_FOLDER_NAME = "BaiduNavi";
    public static final int CUSTOM = 16;
    public static final int EXTGPS = 8;
    public static final String KEY_GB_CARICONOFFSET = "gb_cariconoffset";
    public static final String KEY_GB_CARICONOFFSET_X = "gb_cariconoffset_x";
    public static final String KEY_GB_CARICONOFFSET_Y = "gb_cariconoffset_y";
    public static final String KEY_GB_CARNUM = "gb_carnum";
    public static final String KEY_GB_CARNUMTXT = "gb_carnumtxt";
    public static final String KEY_GB_ICONSET = "gb_iconset";
    public static final String KEY_GB_ICONSHOW = "gb_iconshow";
    public static final String KEY_GB_MARGIN = "gb_margin";
    public static final String KEY_GB_MORE_SETTINGS = "gb_moreSettings";
    public static final String KEY_GB_ROUTE_SEARCH = "gb_routeSearch";
    public static final String KEY_GB_ROUTE_SORT = "gb_routeSort";
    public static final String KEY_GB_SEEALL = "gb_seeall";
    public static final String KEY_GUIDE_MODE = "guide_mode";
    public static final int NORMAL = 2;

    public static boolean checkDeviceHasNavigationBar(Activity activity) {
        try {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            Point point = new Point();
            Point point2 = new Point();
            defaultDisplay.getSize(point);
            defaultDisplay.getRealSize(point2);
            if (point2.y == point.y) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String getAuth() {
        return Utils.getApp().getResources().getString(R.string.bai_du_tts_sn);
    }

    public static Boolean getBoolean(Context context, String str) {
        return Boolean.valueOf(context.getSharedPreferences(APP_FOLDER_NAME, 0).getBoolean(str, false));
    }

    public static int getInt(Context context, String str) {
        return context.getSharedPreferences(APP_FOLDER_NAME, 0).getInt(str, 0);
    }

    public static int getNavigationBarHeight(Activity activity) {
        Resources resources;
        int identifier;
        if (checkDeviceHasNavigationBar(activity) && (identifier = (resources = activity.getResources()).getIdentifier("navigation_bar_height", "dimen", "android")) > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static String getString(Context context, String str) {
        return context.getSharedPreferences(APP_FOLDER_NAME, 0).getString(str, "");
    }

    public static String getTTSAppID() {
        return Utils.getApp().getResources().getString(R.string.bai_du_app_id);
    }

    public static String getTTSAppKey() {
        return Utils.getApp().getResources().getString(R.string.bai_du_key);
    }

    public static String getTTSsecretKey() {
        return Utils.getApp().getResources().getString(R.string.bai_du_key);
    }

    public static void gotoNavi(Activity activity, boolean z) {
        Intent intent = new Intent(activity, (Class<?>) NaviActivity.class);
        intent.putExtra("isWalkAndBike", z);
        activity.startActivity(intent);
    }

    public static void gotoSettings(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) NaviSettingActivity.class));
    }

    public static void setBoolean(Context context, String str, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences(APP_FOLDER_NAME, 0).edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static void setInt(Context context, String str, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences(APP_FOLDER_NAME, 0).edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public static void setString(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(APP_FOLDER_NAME, 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static Boolean getBoolean(Context context, String str, boolean z) {
        return Boolean.valueOf(context.getSharedPreferences(APP_FOLDER_NAME, 0).getBoolean(str, z));
    }
}
