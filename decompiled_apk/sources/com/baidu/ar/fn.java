package com.baidu.ar;

import android.content.Context;
import com.baidu.ar.libloader.ILibLoader;
import com.baidu.ar.libloader.ILibLoaderPlugin;

/* loaded from: classes7.dex */
public final class fn {
    private static Object sLock = new Object();
    private static volatile ILibLoader tx = null;
    private static boolean ty = false;
    private static volatile boolean tz = false;

    public static void a(ILibLoader iLibLoader) {
        synchronized (sLock) {
            tx = iLibLoader;
            ty = true;
        }
        tz = false;
    }

    private static ILibLoader ef() {
        if (tx == null) {
            synchronized (sLock) {
                try {
                    if (tx == null) {
                        tx = new fo();
                    }
                } finally {
                }
            }
        }
        return tx;
    }

    public static void eg() {
        tz = false;
    }

    public static boolean isRegistered() {
        boolean z;
        synchronized (sLock) {
            z = ty;
        }
        return z;
    }

    public static void load(Context context, ILibLoader.b bVar) {
        if (tz) {
            return;
        }
        ef().load(context, bVar);
    }

    public static void prepareCaseRes(ARType aRType, String str, String str2, ILibLoader.a aVar) {
        if (tz) {
            return;
        }
        ef().prepareCaseRes(aRType, str, str2, aVar);
    }

    public static void release() {
        tz = true;
        ty = false;
        if (tx != null) {
            tx.release();
            tx = null;
        }
    }

    public static void require(String str) {
        if (tz) {
            return;
        }
        ef().require(str);
    }

    public static void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin) {
        ef().setLibLoadPlugin(iLibLoaderPlugin);
    }

    public static void setLibReadyListener(String str, ILibLoader.c cVar) {
        ef().setLibReadyListener(str, cVar);
    }
}
