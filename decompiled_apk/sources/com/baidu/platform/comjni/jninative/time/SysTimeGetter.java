package com.baidu.platform.comjni.jninative.time;

import android.os.SystemClock;

/* loaded from: classes8.dex */
public class SysTimeGetter {
    public static long getSysTime() {
        return SystemClock.elapsedRealtime() / 1000;
    }
}
