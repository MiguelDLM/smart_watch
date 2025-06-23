package com.jieli.jl_rcsp.model.device;

/* loaded from: classes10.dex */
public class ChannelInfo {
    private float freq;
    private int index;

    public ChannelInfo() {
    }

    public float getFreq() {
        return this.freq;
    }

    public int getIndex() {
        return this.index;
    }

    public void setFreq(float f) {
        this.freq = f;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public String toString() {
        return "ChannelInfo{index=" + this.index + ", freq=" + this.freq + '}';
    }

    public ChannelInfo(int i, float f) {
        setIndex(i);
        setFreq(f);
    }
}
