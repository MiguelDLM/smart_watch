package com.jieli.jl_rcsp.model.device;

import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class DynamicLimiterParam {
    public static final int MASK = 2;
    private int value;

    public DynamicLimiterParam() {
    }

    public static DynamicLimiterParam parseData(byte[] bArr) {
        if (bArr != null && bArr.length >= 2) {
            return new DynamicLimiterParam(CHexConver.bytesToInt(bArr, 0, 2));
        }
        return null;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int i) {
        this.value = i;
    }

    public byte[] toData() {
        return CHexConver.int2byte2(this.value);
    }

    public String toString() {
        return "DynamicLimiterParam{value=" + this.value + '}';
    }

    public DynamicLimiterParam(int i) {
        setValue(i);
    }
}
