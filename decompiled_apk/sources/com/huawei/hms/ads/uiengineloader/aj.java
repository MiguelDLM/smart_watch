package com.huawei.hms.ads.uiengineloader;

import java.io.Closeable;

/* loaded from: classes10.dex */
public abstract class aj {

    /* renamed from: a, reason: collision with root package name */
    public static final String f17339a = "StreamUtil";

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
                af.c(f17339a, "close exception");
            }
        }
    }
}
