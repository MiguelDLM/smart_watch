package com.baidu.navisdk.util.common;

/* loaded from: classes8.dex */
public class f0 extends n {
    private static f0 f;

    private f0(String str) {
        super(str);
    }

    public static f0 d() {
        if (f == null) {
            synchronized (f0.class) {
                try {
                    if (f == null) {
                        f = new f0("BNRouteGuideThread");
                    }
                } finally {
                }
            }
        }
        return f;
    }
}
