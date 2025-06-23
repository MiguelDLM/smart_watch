package com.baidu.ar;

import java.lang.reflect.Constructor;

/* loaded from: classes7.dex */
public class ix implements io {
    private io zq;

    public ix() {
        Constructor<?> a2 = kr.a("com.baidu.ar.statistic.performance.PerformanceStatisticApi", (Class<?>[]) new Class[0]);
        if (a2 != null) {
            this.zq = (io) kr.a(a2, new Object[0]);
        }
    }

    @Override // com.baidu.ar.io
    public void onFrameIn() {
        io ioVar = this.zq;
        if (ioVar != null) {
            ioVar.onFrameIn();
        }
    }

    @Override // com.baidu.ar.io
    public void onFrameOut() {
        io ioVar = this.zq;
        if (ioVar != null) {
            ioVar.onFrameOut();
        }
    }
}
