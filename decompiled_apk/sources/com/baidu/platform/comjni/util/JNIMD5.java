package com.baidu.platform.comjni.util;

import com.baidu.platform.comjni.JNIBaseApi;

@Deprecated
/* loaded from: classes8.dex */
public class JNIMD5 extends JNIBaseApi {
    public static native String EncodeUrlParamsValue(String str);

    public static native String GetSignMD5String(String str);

    public static native String GetWebSignMD5String(String str);

    public static native String SignOpra(String str);
}
