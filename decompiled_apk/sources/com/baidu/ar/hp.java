package com.baidu.ar;

/* loaded from: classes7.dex */
public class hp {
    private long xe;
    private int xd = 100;
    private long xf = 0;
    private boolean kQ = false;

    public hp(long j) {
        this.xe = j;
    }

    public boolean fw() {
        return this.kQ;
    }

    public void h(long j) {
        this.xf = j;
        this.kQ = true;
    }

    public int i(long j) {
        long j2 = this.xe;
        if (j2 == 0) {
            return 0;
        }
        if (this.xf == 0) {
            return 0;
        }
        return (int) (((j - r4) * this.xd) / j2);
    }
}
