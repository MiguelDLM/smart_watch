package com.jieli.jl_rcsp.model.device;

import com.jieli.jl_rcsp.constant.RcspConstant;
import java.util.Arrays;

/* loaded from: classes10.dex */
public class EqInfo {
    private int count;
    private boolean dynamic;
    private int[] freqs;
    private int mode;
    private byte[] value;

    public EqInfo() {
        this.value = new byte[10];
        this.freqs = RcspConstant.DEFAULT_EQ_FREQS;
        this.count = 10;
    }

    public EqInfo copy() {
        EqInfo eqInfo = new EqInfo(this.mode, this.value, getFreqs());
        eqInfo.count = this.count;
        eqInfo.setDynamic(this.dynamic);
        return eqInfo;
    }

    public int getCount() {
        return this.count;
    }

    public int[] getFreqs() {
        return this.freqs;
    }

    public int getMode() {
        return this.mode;
    }

    public byte[] getValue() {
        return this.value;
    }

    public boolean isDynamic() {
        return this.dynamic;
    }

    public void setDynamic(boolean z) {
        this.dynamic = z;
    }

    public void setFreqs(int[] iArr) {
        this.freqs = iArr;
        this.count = iArr.length;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public void setValue(byte[] bArr) {
        this.value = bArr;
    }

    public String toString() {
        return "EqInfo{mode=" + this.mode + ", isNew=" + this.dynamic + ", value=" + Arrays.toString(this.value) + ", freqs=" + Arrays.toString(this.freqs) + '}';
    }

    public EqInfo(int i, byte[] bArr) {
        this.value = new byte[10];
        this.freqs = RcspConstant.DEFAULT_EQ_FREQS;
        this.count = 10;
        setMode(i);
        setValue(bArr);
    }

    public EqInfo(int i, byte[] bArr, int[] iArr) {
        this.value = new byte[10];
        this.freqs = RcspConstant.DEFAULT_EQ_FREQS;
        this.count = 10;
        setMode(i);
        setValue(bArr);
        setFreqs(iArr);
    }
}
