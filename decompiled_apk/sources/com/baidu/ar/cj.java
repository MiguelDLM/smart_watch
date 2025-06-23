package com.baidu.ar;

/* loaded from: classes7.dex */
final class cj {
    final Object mx;
    final ch my;
    volatile boolean mz;

    public boolean equals(Object obj) {
        if (!(obj instanceof cj)) {
            return false;
        }
        cj cjVar = (cj) obj;
        return this.mx == cjVar.mx && this.my.equals(cjVar.my);
    }

    public int hashCode() {
        return this.mx.hashCode() + this.my.mq.hashCode();
    }
}
