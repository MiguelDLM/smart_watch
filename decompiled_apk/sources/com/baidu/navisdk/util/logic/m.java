package com.baidu.navisdk.util.logic;

/* loaded from: classes8.dex */
public class m extends com.baidu.navisdk.util.common.n {
    private static m f;

    private m(String str) {
        super(str);
    }

    public static m d() {
        if (f == null) {
            synchronized (m.class) {
                try {
                    if (f == null) {
                        f = new m("BNLocationHandlerThread");
                    }
                } finally {
                }
            }
        }
        return f;
    }
}
