package com.baidu.mapapi;

import android.content.Context;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;

/* loaded from: classes7.dex */
public class SDKInitializer {
    public static final String SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR = "network error";
    public static final String SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR = "permission check error";
    public static final String SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_OK = "permission check ok";
    public static final String SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE = "error_code";
    public static final String SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_MESSAGE = "error_message";

    /* renamed from: a, reason: collision with root package name */
    private static CoordType f5754a = CoordType.BD09LL;

    private SDKInitializer() {
    }

    public static boolean getAgreePrivacy() {
        return com.baidu.mapsdkplatform.comapi.b.c();
    }

    public static CoordType getCoordType() {
        return f5754a;
    }

    public static void initialize(Context context) {
        com.baidu.mapsdkplatform.comapi.b.a(context, false, null, null, null, null);
    }

    public static boolean isHttpsEnable() {
        return HttpClient.isHttpsEnable;
    }

    public static boolean isInitialized() {
        return com.baidu.mapsdkplatform.comapi.b.a();
    }

    public static void onBackground() {
        com.baidu.mapsdkplatform.comapi.b.e();
    }

    public static void onForeground() {
        com.baidu.mapsdkplatform.comapi.b.d();
    }

    public static void setAgreePrivacy(Context context, boolean z) {
        com.baidu.mapsdkplatform.comapi.b.a(context, z);
    }

    public static void setApiKey(String str) {
        PermissionCheck.setApiKey(str);
    }

    public static void setCommonInfo(CommonInfo commonInfo) {
        com.baidu.mapsdkplatform.comapi.b.a(commonInfo);
    }

    public static void setCoordType(CoordType coordType) {
        f5754a = coordType;
    }

    public static void setHttpsEnable(boolean z) {
    }

    public static void initialize(Context context, ISDKInitializerListener iSDKInitializerListener) {
        com.baidu.mapsdkplatform.comapi.b.a(context, false, null, null, null, iSDKInitializerListener);
    }

    public static void initialize(String str, Context context) {
        com.baidu.mapsdkplatform.comapi.b.a(context, false, null, str, null, null);
    }

    public static void initialize(Context context, boolean z, String str, String str2) {
        com.baidu.mapsdkplatform.comapi.b.a(context, z, str, str2, null, null);
    }
}
