package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes11.dex */
public class MultiProcessFlag {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f19406a;
    private static boolean b;

    public static boolean isMultiProcess() {
        return f19406a;
    }

    public static void setMultiProcess(boolean z) {
        if (b) {
            GDTLogger.w("MultiProcessFlag已经设置过，再次设置无效");
        } else {
            b = true;
            f19406a = z;
        }
    }
}
