package com.baidu.tts.jni;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;

/* loaded from: classes8.dex */
public class TtsLogLoad {
    static {
        try {
            System.loadLibrary("bd_tts_log");
            LoggerProxy.d("ContentValues", "bd_tts_log load succeed");
        } catch (Throwable th) {
            LoggerProxy.e("ContentValues", "so file bd_tts_log load fail" + th.toString());
        }
    }

    public static native String getLogManagerVersion();

    public static native int initLocalTtsWpData(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5);

    public static native void setLogHeadSring(String str, int i);

    public static native void writeLocalFile(String str, int i, int i2);
}
