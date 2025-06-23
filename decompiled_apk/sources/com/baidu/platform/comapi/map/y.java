package com.baidu.platform.comapi.map;

import android.util.Log;

/* loaded from: classes8.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    static boolean f9677a = false;

    public static void a(String str, String str2) {
        if (f9677a) {
            Log.d("MapTrace-" + str, "thread:" + Thread.currentThread().getName() + ":" + Thread.currentThread().getId() + "," + str2);
        }
    }
}
