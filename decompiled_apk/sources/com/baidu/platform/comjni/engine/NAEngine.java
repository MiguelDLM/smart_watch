package com.baidu.platform.comjni.engine;

import android.content.Context;
import android.os.Bundle;
import com.baidu.platform.comapi.exception.ComInitException;
import com.baidu.platform.comapi.longlink.LongLinkClient;
import com.baidu.platform.comjni.NativeComponent;

/* loaded from: classes8.dex */
public class NAEngine extends NativeComponent {

    /* renamed from: a, reason: collision with root package name */
    private static LongLinkClient f9978a = null;
    private static boolean b = false;

    public NAEngine() {
        create();
    }

    public static void a() {
        nativeInitClass(new Bundle(), 0);
        b = true;
    }

    public static boolean b() {
        try {
            LongLinkClient longLinkClient = f9978a;
            if (longLinkClient != null) {
                longLinkClient.unRegister(null);
                f9978a.release();
                f9978a = null;
            }
            return nativeUninitEngine();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean c() {
        return nativeStartSocketProc();
    }

    public static String getIP(String str) {
        return nativeGetIP(str);
    }

    public static boolean initLongLinkClient() {
        if (f9978a == null) {
            try {
                f9978a = LongLinkClient.create();
            } catch (ComInitException unused) {
            }
        }
        if (f9978a != null) {
            return true;
        }
        return false;
    }

    private native long nativeCreate();

    private static native void nativeEnableMonitor(boolean z);

    private static native boolean nativeGetFlaxLength(Bundle bundle);

    private static native String nativeGetIP(String str);

    private static native void nativeInitCVLogFilePath(String str);

    private static native int nativeInitClass(Object obj, int i);

    private static native boolean nativeInitEngine(Object obj, String str);

    private static native void nativeInitMonitor(String str);

    private static native void nativeMonitorAddLog(int i, String str, String str2);

    private static native void nativeMonitorSetLogPriority(int i);

    private static native void nativeMonitorSetOutPutType(int i);

    private native int nativeRelease(long j);

    private static native void nativeSetHttpsEnable(boolean z);

    private static native void nativeSetMonitorLogFilter(String[] strArr);

    private static native void nativeSetNewDomainEnable(boolean z);

    private static native void nativeSetProxyInfo(String str, int i);

    private static native void nativeStartRunningRequest();

    private static native boolean nativeStartSocketProc();

    private static native boolean nativeStartSocketProcByCache(String str);

    private static native void nativeSyncAppRuntime(String str);

    private static native void nativeUninitCVLogFilePath();

    private static native boolean nativeUninitEngine();

    public static void restartLongLink() {
        LongLinkClient longLinkClient = f9978a;
        if (longLinkClient != null) {
            try {
                longLinkClient.start();
            } catch (Exception unused) {
            }
        }
    }

    public static void startRunningRequest() {
        nativeStartRunningRequest();
    }

    public static void stopLongLink() {
        LongLinkClient longLinkClient = f9978a;
        if (longLinkClient != null) {
            try {
                longLinkClient.stop();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public long create() {
        this.mNativePointer = nativeCreate();
        return this.mNativePointer;
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public int dispose() {
        return nativeRelease(this.mNativePointer);
    }

    public static boolean a(Context context, String str) {
        if (!b) {
            a();
        }
        try {
            return nativeInitEngine(context, str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void b(int i) {
        nativeMonitorSetLogPriority(i);
    }

    public static void a(String str) {
        nativeInitMonitor(str);
    }

    public static void a(int i) {
        nativeMonitorSetOutPutType(i);
    }

    public static void a(boolean z) {
        nativeEnableMonitor(z);
    }

    public static void a(String[] strArr) {
        nativeSetMonitorLogFilter(strArr);
    }

    public static void a(int i, String str, String str2) {
        nativeMonitorAddLog(i, str, str2);
    }
}
