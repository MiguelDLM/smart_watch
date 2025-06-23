package com.baidu.platform.comapi.util;

import com.baidu.platform.comjni.JNIBaseApi;

/* loaded from: classes8.dex */
public final class EncryptUtil extends JNIBaseApi {
    private static native String nativeDecrypt(String str, String str2);

    private static native String nativeEncrypt(String str, String str2);
}
