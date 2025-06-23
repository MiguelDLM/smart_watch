package com.tenmeter.smlibrary.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes13.dex */
public class PreferencesUtils {
    public static String DAILY_ACTIVE_REPORT_TIME = "DAILY_ACTIVE_REPORT_TIME";
    public static String ENTRY_EXPOSURE_DAILY_TIME = "ENTRY_EXPOSURE_DAILY_TIME";
    public static String GAME_EXPOSURE_DAILY_TIME = "GAME_EXPOSURE_DAILY_TIME";
    public static final String H5_GAME_RESOURCE_URL_PRE = "h5_game_resource_url_pre";
    public static final String H5_GAME_VERSION_PRE = "h5_game_version_pre";
    private static final String PREFERENCE_NAME = "common_spf";
    public static String SAVE_AD_POP_TIME = "SAVE_AD_POP_TIME";
    public static String SAVE_THIRD_DEVICE_ID = "SAVE_THIRD_DEVICE_ID";
    public static String SAVE_THIRD_HEAD = "SAVE_THIRD_HEAD";
    public static String SAVE_THIRD_PART_KEY = "SAVE_THIRD_PART_KEY";
    public static String SAVE_THIRD_PART_NAME = "SAVE_THIRD_PART_NAME";
    public static String SAVE_THIRD_UID = "SAVE_THIRD_UID";
    public static String SAVE_THIRD_USER_NAME = "SAVE_THIRD_USER_NAME";
    public static String SECRET_VALID = "SECRET_VALID_SHI_MI";
    public static String SECRET_VALID_TIME = "SECRET_VALID_TIME_SHI_MI";
    private static final String TAG = "PreferencesUtils";
    private static final String USER_PREFERENCE_NAME = "common_spf_";

    private PreferencesUtils() {
        throw new AssertionError();
    }

    public static boolean getBoolean(Context context, String str) {
        return getBoolean(context, str, false);
    }

    public static boolean getBooleanUser(Context context, String str, String str2, boolean z) {
        return context.getSharedPreferences(USER_PREFERENCE_NAME + str2, 0).getBoolean(str, z);
    }

    public static boolean getBooleanUserAndVersion(Context context, String str, String str2, String str3, boolean z) {
        return context.getSharedPreferences(USER_PREFERENCE_NAME + str2 + "_" + str3, 0).getBoolean(str, z);
    }

    public static float getFloat(Context context, String str) {
        return getFloat(context, str, -1.0f);
    }

    public static String getH5GameResourceURL(Context context, int i) {
        return getString(context, H5_GAME_RESOURCE_URL_PRE + i, "");
    }

    public static int getH5GameVersion(Context context, int i) {
        return getInt(context, H5_GAME_VERSION_PRE + i, 0);
    }

    public static Map<String, Integer> getHashMapData(Context context, String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONArray jSONArray = new JSONArray(context.getSharedPreferences(PREFERENCE_NAME, 0).getString(str, ""));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                JSONArray names = jSONObject.names();
                if (names != null) {
                    for (int i2 = 0; i2 < names.length(); i2++) {
                        String string = names.getString(i2);
                        hashMap.put(string, Integer.valueOf(jSONObject.getInt(string)));
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    public static int getInt(Context context, String str) {
        return getInt(context, str, -1);
    }

    public static long getLong(Context context, String str) {
        return getLong(context, str, -1L);
    }

    public static long getLongUser(Context context, String str, String str2, long j) {
        return context.getSharedPreferences(USER_PREFERENCE_NAME + str, 0).getLong(str2, j);
    }

    public static Object getObject(Context context, String str) {
        return getObject(context, str, null);
    }

    public static String getString(Context context, String str) {
        return getString(context, str, null);
    }

    @TargetApi(11)
    public static Set<String> getStringSet(Context context, String str) {
        return context.getSharedPreferences(PREFERENCE_NAME, 0).getStringSet(str, null);
    }

    public static String getStringUser(Context context, String str, String str2, String str3) {
        return context.getSharedPreferences(USER_PREFERENCE_NAME + str, 0).getString(str2, str3);
    }

    public static boolean putBoolean(Context context, String str, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCE_NAME, 0).edit();
        edit.putBoolean(str, z);
        return edit.commit();
    }

    public static boolean putBooleanUser(Context context, String str, String str2, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences(USER_PREFERENCE_NAME + str2, 0).edit();
        edit.putBoolean(str, z);
        return edit.commit();
    }

    public static boolean putBooleanUserAndVersion(Context context, String str, boolean z, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(USER_PREFERENCE_NAME + str2 + "_" + str3, 0).edit();
        edit.putBoolean(str, z);
        return edit.commit();
    }

    public static boolean putFloat(Context context, String str, float f) {
        SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCE_NAME, 0).edit();
        edit.putFloat(str, f);
        return edit.commit();
    }

    public static void putHashMapData(Context context, String str, Map<String, Integer> map) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        jSONArray.put(jSONObject);
        SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCE_NAME, 0).edit();
        edit.putString(str, jSONArray.toString());
        edit.commit();
    }

    public static boolean putInt(Context context, String str, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCE_NAME, 0).edit();
        edit.putInt(str, i);
        return edit.commit();
    }

    public static boolean putLong(Context context, String str, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCE_NAME, 0).edit();
        edit.putLong(str, j);
        return edit.commit();
    }

    public static boolean putLongUser(Context context, String str, String str2, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences(USER_PREFERENCE_NAME + str, 0).edit();
        edit.putLong(str2, j);
        return edit.commit();
    }

    public static boolean putObject(Context context, String str, Object obj) {
        SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCE_NAME, 0).edit();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
            edit.putString(str, new String(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0)));
            return edit.commit();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return false;
        }
    }

    public static boolean putString(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCE_NAME, 0).edit();
        edit.putString(str, str2);
        return edit.commit();
    }

    @TargetApi(11)
    public static boolean putStringSet(Context context, String str, Set<String> set) {
        SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCE_NAME, 0).edit();
        edit.putStringSet(str, set);
        return edit.commit();
    }

    public static boolean putStringUser(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(USER_PREFERENCE_NAME + str, 0).edit();
        edit.putString(str2, str3);
        return edit.commit();
    }

    public static void setH5GameResourceURL(Context context, int i, String str) {
        putString(context, H5_GAME_RESOURCE_URL_PRE + i, str);
    }

    public static void setH5GameVersion(Context context, int i, int i2) {
        putInt(context, H5_GAME_VERSION_PRE + i, i2);
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        return context.getSharedPreferences(PREFERENCE_NAME, 0).getBoolean(str, z);
    }

    public static float getFloat(Context context, String str, float f) {
        return context.getSharedPreferences(PREFERENCE_NAME, 0).getFloat(str, f);
    }

    public static int getInt(Context context, String str, int i) {
        return context.getSharedPreferences(PREFERENCE_NAME, 0).getInt(str, i);
    }

    public static long getLong(Context context, String str, long j) {
        return context.getSharedPreferences(PREFERENCE_NAME, 0).getLong(str, j);
    }

    public static Object getObject(Context context, String str, Object obj) {
        try {
            return new ObjectInputStream(new ByteArrayInputStream(Base64.decode(context.getSharedPreferences(PREFERENCE_NAME, 0).getString(str, ""), 0))).readObject();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage() != null ? e.getMessage() : "spf getObject error");
            return obj;
        }
    }

    public static String getString(Context context, String str, String str2) {
        return context.getSharedPreferences(PREFERENCE_NAME, 0).getString(str, str2);
    }

    @TargetApi(11)
    public static Set<String> getStringSet(Context context, String str, Set<String> set) {
        return context.getSharedPreferences(PREFERENCE_NAME, 0).getStringSet(str, set);
    }
}
