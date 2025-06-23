package com.baidu.ar;

/* loaded from: classes7.dex */
public class mb {
    private y Fk;
    private long mTimestamp;
    private boolean vW;

    public mb(long j) {
        this.mTimestamp = j;
    }

    public void D(boolean z) {
        this.vW = z;
    }

    public void a(y yVar) {
        this.Fk = yVar;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public y ii() {
        return this.Fk;
    }

    public boolean isTracked() {
        return this.vW;
    }
}
