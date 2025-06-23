package com.jieli.jl_rcsp.model.device;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes10.dex */
public class EqPresetInfo {
    private List<EqInfo> eqInfos;
    private int[] freqs;
    private int number;

    public List<EqInfo> getEqInfos() {
        return this.eqInfos;
    }

    public int[] getFreqs() {
        return this.freqs;
    }

    public int getNumber() {
        return this.number;
    }

    public void setEqInfos(List<EqInfo> list) {
        this.eqInfos = list;
    }

    public void setFreqs(int[] iArr) {
        this.freqs = iArr;
    }

    public void setNumber(int i) {
        this.number = i;
    }

    public String toString() {
        return "EqPresetInfo{number=" + this.number + ", eqInfos=" + this.eqInfos + ", freqs=" + Arrays.toString(this.freqs) + '}';
    }
}
