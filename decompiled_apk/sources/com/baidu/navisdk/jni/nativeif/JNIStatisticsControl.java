package com.baidu.navisdk.jni.nativeif;

import android.os.Bundle;

/* loaded from: classes7.dex */
public class JNIStatisticsControl {
    private static final String KEY_LOG_HEAD_CHANNEL = "channel";
    private static final String KEY_LOG_HEAD_UID = "duid";
    public static JNIStatisticsControl sInstance = new JNIStatisticsControl();

    private JNIStatisticsControl() {
    }

    private int setLogHeaderParam(String str, String str2) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString(KEY_LOG_HEAD_CHANNEL, str);
            bundle.putString(KEY_LOG_HEAD_UID, str2);
            return setLogHeaderParam(bundle);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public native void clearOldNetWorkDataRecord();

    public void exit() {
        try {
            writeTmpLogFile();
        } catch (Throwable unused) {
        }
    }

    public native void getAllNetWorkDataSize(Bundle bundle);

    public native int getStatisticsResult(String str, Bundle bundle);

    public void init(String str, String str2) {
        setLogHeaderParam(str, str2);
    }

    public native int recordStatisticsItem(String str);

    public native int setLogHeaderParam(Bundle bundle);

    public native void setMapClientPageStatistics(String str);

    public native int setTTSTextPlayResult(String str, String str2);

    public native int upLoadStatistics();

    public native int writeTmpLogFile();
}
