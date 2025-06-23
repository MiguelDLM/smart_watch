package com.baidu.nplatform.comapi.map;

/* loaded from: classes8.dex */
public class d extends com.baidu.navisdk.util.common.n {
    private static d f;

    public d(String str) {
        super(str);
    }

    public static d d() {
        if (f == null) {
            synchronized (com.baidu.navisdk.util.logic.m.class) {
                try {
                    if (f == null) {
                        f = new d("EnlargeHandlerThread");
                    }
                } finally {
                }
            }
        }
        return f;
    }
}
