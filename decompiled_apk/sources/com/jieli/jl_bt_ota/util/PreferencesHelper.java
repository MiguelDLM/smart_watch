package com.jieli.jl_bt_ota.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Set;

/* loaded from: classes10.dex */
public class PreferencesHelper {

    /* renamed from: a, reason: collision with root package name */
    private static String f17815a = "ji_bluetooth_ota_preferences";

    public static String getPreferencesName() {
        return f17815a;
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(f17815a, 0);
    }

    public static void putBooleanValue(Context context, String str, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences(f17815a, 0).edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static void putIntValue(Context context, String str, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences(f17815a, 0).edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public static void putLongValue(Context context, String str, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences(f17815a, 0).edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public static void putStringSetValue(Context context, String str, Set<String> set) {
        SharedPreferences.Editor edit = context.getSharedPreferences(f17815a, 0).edit();
        edit.putStringSet(str, set);
        edit.apply();
    }

    public static void putStringValue(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(f17815a, 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void remove(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences(f17815a, 0).edit();
        edit.remove(str);
        edit.apply();
    }

    public void setPreferencesName(String str) {
        f17815a = str;
    }
}
