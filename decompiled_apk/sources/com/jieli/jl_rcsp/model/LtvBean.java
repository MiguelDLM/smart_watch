package com.jieli.jl_rcsp.model;

import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class LtvBean {
    private final byte[] data;
    private final int len;
    private final int type;

    public LtvBean(int i, int i2, byte[] bArr) {
        this.len = i;
        this.type = i2;
        this.data = bArr;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getLen() {
        return this.len;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "LtvBean{len=" + this.len + ", type=" + this.type + ", data=" + CHexConver.byte2HexStr(this.data) + '}';
    }
}
