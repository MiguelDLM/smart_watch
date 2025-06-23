package com.baidu.platform.comapi.util;

import com.baidu.platform.comjni.JNIBaseApi;

/* loaded from: classes8.dex */
public final class URLEncodeUtils extends JNIBaseApi {
    public static String a(int i, String str) {
        if (i == 1) {
            return nativeMD5Sign(str);
        }
        if (i == 2) {
            return nativeWebSign(str);
        }
        if (i == 3) {
            return nativeOperSign(str);
        }
        return "";
    }

    private static native String nativeMD5Sign(String str);

    private static native String nativeOperSign(String str);

    private static native String nativeUrlEncode(String str);

    private static native String nativeWebSign(String str);
}
