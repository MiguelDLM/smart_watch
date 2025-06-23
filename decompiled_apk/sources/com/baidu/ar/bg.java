package com.baidu.ar;

/* loaded from: classes7.dex */
public class bg {
    private int ka;
    private int kb = 0;
    private long kc = 0;

    public bg(int i) {
        this.ka = 33;
        if (i > 0) {
            this.ka = 1000 / i;
        }
    }

    public boolean bH() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.kc == 0) {
            this.kc = currentTimeMillis;
        }
        long j = currentTimeMillis % 1000;
        if (currentTimeMillis / 1000 != this.kc / 1000) {
            this.kc = currentTimeMillis;
            this.kb = 0;
        }
        int i = this.kb;
        if (this.ka * i >= j) {
            return false;
        }
        this.kb = i + 1;
        return true;
    }
}
