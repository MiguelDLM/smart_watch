package com.baidu.ar.bean;

/* loaded from: classes7.dex */
public class DuMixARConfig {
    private static String mAPIKey;
    private static String mAipAppId;
    private static String mPackageName;
    private static String mSecretKey;

    public static String getAPIKey() {
        return mAPIKey;
    }

    public static String getAipAppId() {
        return mAipAppId;
    }

    public static String getPackageName() {
        return mPackageName;
    }

    public static String getSecretKey() {
        return mSecretKey;
    }

    public static void setAPIKey(String str) {
        mAPIKey = str;
    }

    public static void setAppId(String str) {
        mAipAppId = str;
    }

    public static void setCuid(String str) {
        ARConfig.setCUID(str);
    }

    public static void setPackageName(String str) {
        mPackageName = str;
    }

    public static void setSecretKey(String str) {
        mSecretKey = str;
    }
}
