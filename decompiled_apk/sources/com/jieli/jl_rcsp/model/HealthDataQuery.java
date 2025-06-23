package com.jieli.jl_rcsp.model;

import java.util.Arrays;

/* loaded from: classes10.dex */
public class HealthDataQuery {
    private final int mask;
    private final byte[] param;
    private final int version;

    public HealthDataQuery(int i, int i2, byte[] bArr) {
        this.version = i;
        this.mask = i2;
        this.param = bArr;
    }

    public int getMask() {
        return this.mask;
    }

    public byte[] getParam() {
        return this.param;
    }

    public int getVersion() {
        return this.version;
    }

    public String toString() {
        return "HealthDataQuery{version=" + this.version + ", mask=" + this.mask + ", param=" + Arrays.toString(this.param) + '}';
    }
}
