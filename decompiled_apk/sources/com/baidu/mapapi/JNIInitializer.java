package com.baidu.mapapi;

import android.app.Application;
import android.content.Context;
import com.baidu.vi.VIContext;

/* loaded from: classes7.dex */
public class JNIInitializer {

    /* renamed from: a, reason: collision with root package name */
    private static Context f5750a;

    public static Context getCachedContext() {
        return f5750a;
    }

    public static void setContext(Application application) {
        if (application != null) {
            if (f5750a == null) {
                f5750a = application;
            }
            VIContext.init(application);
            return;
        }
        throw new RuntimeException();
    }
}
