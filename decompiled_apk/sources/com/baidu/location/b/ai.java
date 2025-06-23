package com.baidu.location.b;

import android.os.HandlerThread;

/* loaded from: classes7.dex */
public class ai {

    /* renamed from: a, reason: collision with root package name */
    private static HandlerThread f5621a;

    public static synchronized HandlerThread a() {
        HandlerThread handlerThread;
        synchronized (ai.class) {
            try {
                if (f5621a == null) {
                    try {
                        HandlerThread handlerThread2 = new HandlerThread("ServiceStartArguments", 10);
                        f5621a = handlerThread2;
                        handlerThread2.start();
                    } catch (Throwable th) {
                        th.printStackTrace();
                        f5621a = null;
                    }
                }
                handlerThread = f5621a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return handlerThread;
    }
}
