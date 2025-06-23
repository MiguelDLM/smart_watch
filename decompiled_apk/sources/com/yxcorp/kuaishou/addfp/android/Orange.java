package com.yxcorp.kuaishou.addfp.android;

import android.content.Context;
import android.text.TextUtils;
import com.yxcorp.kuaishou.addfp.c.a.a;

/* loaded from: classes6.dex */
public class Orange {
    private static final int JNI_CONTROL_COMMAND_DIR_DETECT = 1114128;
    private static final int JNI_CONTROL_COMMAND_EGID = 1114139;
    private static final int JNI_CONTROL_COMMAND_GK_DETECT = 1114132;
    private static final int JNI_CONTROL_COMMAND_MANU_DETECT = 1114140;
    private static final int JNI_CONTROL_COMMAND_PROPS_DETECT = 1114131;
    private static final int JNI_CONTROL_COMMAND_SERIAL_DETECT = 1179649;
    private static boolean sLibLoadFail = true;
    private static final String sdkVersion = "1.4.1.119.06479c08";
    private static volatile Orange singleton;
    private String mEgidJson = "";

    private Orange() {
        loadSoLib();
    }

    public static String gLs(int i, String str) {
        try {
            return a.a(i, str);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static native String getClock(Context context, byte[] bArr, int i);

    public static Orange getInstance() {
        if (singleton == null) {
            synchronized (Orange.class) {
                try {
                    if (singleton == null) {
                        singleton = new Orange();
                    }
                } finally {
                }
            }
        }
        return singleton;
    }

    private static native byte[] getMagic(Context context, byte[] bArr, int i);

    public static String getVersion() {
        return sdkVersion;
    }

    private boolean isReject() {
        return sLibLoadFail;
    }

    private static native Object jniCommand(int i, Object obj, Object obj2, Object obj3);

    private void loadSoLib() {
        try {
            System.loadLibrary("sgcore");
            sLibLoadFail = false;
        } catch (Throwable th) {
            sLibLoadFail = true;
            th.printStackTrace();
        }
    }

    public byte[] dcc(byte[] bArr, byte[] bArr2) {
        try {
            isReject();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public String gKpsd() {
        try {
            return isReject() ? "" : (String) jniCommand(JNI_CONTROL_COMMAND_GK_DETECT, null, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public String gManu(Context context, String str) {
        try {
            return (isReject() || context == null) ? "" : (String) jniCommand(JNI_CONTROL_COMMAND_MANU_DETECT, str, context.getPackageName(), null);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public String gProps() {
        try {
            return isReject() ? "" : (String) jniCommand(JNI_CONTROL_COMMAND_PROPS_DETECT, null, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public String gRdi() {
        try {
            return isReject() ? "" : (String) jniCommand(JNI_CONTROL_COMMAND_DIR_DETECT, null, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public String gSer() {
        try {
            return isReject() ? "" : (String) jniCommand(JNI_CONTROL_COMMAND_SERIAL_DETECT, null, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public synchronized String getClockWrapper(Context context, byte[] bArr, int i) {
        if (isReject()) {
            return "";
        }
        return getClock(context, bArr, i);
    }

    public synchronized byte[] getMagicWrapper(Context context, byte[] bArr, int i) {
        if (isReject()) {
            return null;
        }
        return getMagic(context, bArr, i);
    }

    public synchronized String sted(String str, boolean z) {
        try {
            if (isReject()) {
                return "";
            }
            if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.mEgidJson)) {
                return this.mEgidJson;
            }
            if (!TextUtils.isEmpty(str)) {
                return (String) jniCommand(JNI_CONTROL_COMMAND_EGID, "", str, null);
            }
            String str2 = (String) jniCommand(JNI_CONTROL_COMMAND_EGID, "", str, null);
            this.mEgidJson = str2;
            return str2;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
