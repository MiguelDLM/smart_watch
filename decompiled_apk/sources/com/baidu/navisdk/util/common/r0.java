package com.baidu.navisdk.util.common;

/* loaded from: classes8.dex */
public class r0 extends n {
    private static r0 f;

    private r0(String str) {
        super(str);
    }

    public static r0 d() {
        if (f == null) {
            synchronized (r0.class) {
                try {
                    if (f == null) {
                        f = new r0("VMsgHandlerThread");
                    }
                } finally {
                }
            }
        }
        return f;
    }
}
