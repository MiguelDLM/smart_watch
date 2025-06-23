package com.baidu.nplatform.comjni.engine;

import android.os.Bundle;
import com.baidu.navisdk.vi.VMsg;

/* loaded from: classes8.dex */
public class AppEngine {
    private static final int eBundle = 0;

    public static boolean GetFlaxLength(Bundle bundle) {
        return JNIEngine.GetFlaxLength(bundle);
    }

    public static boolean InitEngine(Bundle bundle) {
        try {
            JNIEngine.initClass(new Bundle(), 0);
            return JNIEngine.InitEngine(bundle);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean StartSocketProc() {
        return JNIEngine.StartSocketProc();
    }

    public static boolean UnInitEngine() {
        try {
            return JNIEngine.UnInitEngine();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void despatchMessage(int i, int i2, int i3) {
        VMsg.dispatchMessage(i, i2, i3);
    }
}
