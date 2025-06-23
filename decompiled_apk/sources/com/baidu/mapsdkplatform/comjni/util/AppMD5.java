package com.baidu.mapsdkplatform.comjni.util;

/* loaded from: classes7.dex */
public class AppMD5 {
    public static String encodeUrlParamsValue(String str) {
        return JNIMD5.encodeUrlParamsValue(str);
    }

    public static String getSignMD5String(String str) {
        return JNIMD5.getSignMD5String(str);
    }

    public static String getUrlNeedInfo() {
        return JNIMD5.getUrlNeedInfo();
    }
}
