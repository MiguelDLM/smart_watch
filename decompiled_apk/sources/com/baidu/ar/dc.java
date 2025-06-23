package com.baidu.ar;

/* loaded from: classes7.dex */
public abstract class dc {
    private String aj;
    private long mTimestamp;
    private Object oy = null;
    private long oz = 0;

    public void Z(String str) {
        this.aj = str;
    }

    public String cN() {
        return this.aj;
    }

    public long cO() {
        return this.oz;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }
}
