package com.baidu.ar.ihttp;

import com.baidu.ar.fb;
import com.baidu.ar.kr;

/* loaded from: classes7.dex */
public final class HttpFactory {
    private static Object sLock = new Object();
    private static volatile fb sm;
    private static volatile int sn;

    private static fb dP() {
        if (sm != null) {
            return sm;
        }
        if (isAvailable()) {
            synchronized (sLock) {
                try {
                    if (sm == null) {
                        sm = (fb) kr.cq("com.baidu.ar.http.HttpRequestFactory");
                    }
                } finally {
                }
            }
        }
        return sm;
    }

    public static boolean isAvailable() {
        if (sn == 1) {
            return true;
        }
        if (sn == -1) {
            return false;
        }
        synchronized (sLock) {
            sn = 1;
        }
        return true;
    }

    public static IHttpRequest newRequest() {
        fb dP = dP();
        if (dP != null) {
            return dP.newRequest();
        }
        return null;
    }

    public static void release() {
        if (sm != null) {
            sm.release();
            sm = null;
        }
    }
}
