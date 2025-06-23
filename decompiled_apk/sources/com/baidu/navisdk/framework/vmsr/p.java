package com.baidu.navisdk.framework.vmsr;

/* loaded from: classes7.dex */
public class p extends com.baidu.navisdk.util.common.n {
    private static p f;

    private p(String str) {
        super(str);
    }

    public static p d() {
        if (f == null) {
            synchronized (p.class) {
                try {
                    if (f == null) {
                        f = new p("BNSensorHandlerThread");
                    }
                } finally {
                }
            }
        }
        return f;
    }
}
