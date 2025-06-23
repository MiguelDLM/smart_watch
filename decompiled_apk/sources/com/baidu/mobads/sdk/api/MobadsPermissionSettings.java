package com.baidu.mobads.sdk.api;

import android.os.Bundle;
import com.baidu.mobads.sdk.internal.aa;
import com.baidu.mobads.sdk.internal.ay;
import com.baidu.mobads.sdk.internal.az;
import com.baidu.mobads.sdk.internal.bd;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class MobadsPermissionSettings {
    private static final String PERMISSION_APP_LIST = "permission_app_list";
    private static final String PERMISSION_APP_UPDATE = "permission_app_update";
    private static final String PERMISSION_DEVICE_INFO = "permission_device_info";
    private static final String PERMISSION_LIMIT_STATE = "permission_limitpersonalads";
    private static final String PERMISSION_LOCATION = "permission_location";
    private static final String PERMISSION_OAID = "permission_oaid";
    private static final String PERMISSION_PHONE_STATE = "permission_read_phone_state";
    private static final String PERMISSION_RUNNING_APP = "permission_running_app";
    private static final String PERMISSION_STORAGE = "permission_storage";
    private static boolean mAccessAppListGranted = false;
    private static boolean mAccessLocationGranted = false;
    private static boolean mAppUpdateGranted = true;
    private static boolean mCheckSPLimit = false;
    private static boolean mDeviceInfoGranted = true;
    private static boolean mExternalStorageGranted = false;
    private static boolean mLimitPrivacyAds = false;
    private static boolean mOAIDGranted = true;
    private static boolean mReadPhoneStateGranted = false;
    private static boolean mRunningAppGranted = true;

    public static JSONObject getLimitInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PERMISSION_LIMIT_STATE, mLimitPrivacyAds);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static boolean getLimitPersonalAdsStatus() {
        updateSPLimitTag();
        return mLimitPrivacyAds;
    }

    public static JSONObject getPermissionInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PERMISSION_LOCATION, "" + mAccessLocationGranted);
            jSONObject.put(PERMISSION_STORAGE, "" + mExternalStorageGranted);
            jSONObject.put(PERMISSION_APP_LIST, "" + mAccessAppListGranted);
            jSONObject.put(PERMISSION_PHONE_STATE, "" + mReadPhoneStateGranted);
            jSONObject.put(PERMISSION_OAID, "" + mOAIDGranted);
            jSONObject.put(PERMISSION_APP_UPDATE, "" + mAppUpdateGranted);
            jSONObject.put(PERMISSION_RUNNING_APP, "" + mRunningAppGranted);
            jSONObject.put(PERMISSION_DEVICE_INFO, "" + mDeviceInfoGranted);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private static boolean handleIntegrationInfo(Bundle bundle) {
        try {
            switchDebugLog(bundle);
            IXAdContainerFactory c = aa.a().c();
            if (c != null) {
                c.getRemoteParam("integrationInfo", bundle);
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    private static void postLimitInfoRemote() {
        IXAdContainerFactory c = aa.a().c();
        if (c != null) {
            c.onTaskDistribute(bd.b, getLimitInfo());
        }
    }

    private static void postPermissionInfoRemote() {
        IXAdContainerFactory c = aa.a().c();
        if (c != null) {
            c.onTaskDistribute(bd.f6243a, getPermissionInfo());
        }
    }

    public static void setLimitPersonalAds(boolean z) {
        mLimitPrivacyAds = z;
        postLimitInfoRemote();
    }

    public static void setPermissionAppList(boolean z) {
        mAccessAppListGranted = z;
        postPermissionInfoRemote();
    }

    public static void setPermissionAppUpdate(boolean z) {
        mAppUpdateGranted = z;
        postPermissionInfoRemote();
    }

    public static void setPermissionDeviceInfo(boolean z) {
        mDeviceInfoGranted = z;
        postPermissionInfoRemote();
    }

    public static void setPermissionLocation(boolean z) {
        mAccessLocationGranted = z;
        postPermissionInfoRemote();
    }

    public static void setPermissionOAID(boolean z) {
        mOAIDGranted = z;
        postPermissionInfoRemote();
    }

    public static void setPermissionReadDeviceID(boolean z) {
        mReadPhoneStateGranted = z;
        postPermissionInfoRemote();
    }

    public static void setPermissionRunningApp(boolean z) {
        mRunningAppGranted = z;
        postPermissionInfoRemote();
    }

    public static void setPermissionStorage(boolean z) {
        mExternalStorageGranted = z;
        postPermissionInfoRemote();
    }

    private static void switchDebugLog(Bundle bundle) {
        if (bundle != null && bundle.containsKey("debug_mode")) {
            if (bundle.getBoolean("debug_mode")) {
                az.a(true);
                return;
            } else {
                az.a();
                return;
            }
        }
        if (bundle != null && bundle.containsKey(ay.b)) {
            if (bundle.getBoolean(ay.b)) {
                az.a((az.a) new ay());
            } else {
                az.i(ay.b);
            }
        }
    }

    private static void updateSPLimitTag() {
        aa a2;
        IXAdContainerFactory c;
        try {
            if (!mCheckSPLimit && (a2 = aa.a()) != null && (c = a2.c()) != null) {
                Object remoteParam = c.getRemoteParam("limitPersonalAds", new Object[0]);
                if (remoteParam instanceof Boolean) {
                    mLimitPrivacyAds = ((Boolean) remoteParam).booleanValue();
                    mCheckSPLimit = true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
