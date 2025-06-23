package com.jieli.jl_rcsp.model.device;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes10.dex */
public class ExpandFunction {
    public static final int MASK_DYNAMIC_LIMITER = 2;
    public static final int MASK_REVERBERATION = 1;
    private final Map<Integer, byte[]> dataMap = new HashMap();
    private int mask;

    public byte[] getData(int i) {
        return this.dataMap.get(Integer.valueOf(i));
    }

    public int getMask() {
        return this.mask;
    }

    public void putData(int i, byte[] bArr) {
        this.dataMap.put(Integer.valueOf(i), bArr);
    }

    public void setMask(int i) {
        this.mask = i;
    }
}
