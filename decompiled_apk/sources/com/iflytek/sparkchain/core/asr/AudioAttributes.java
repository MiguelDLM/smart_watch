package com.iflytek.sparkchain.core.asr;

/* loaded from: classes10.dex */
public class AudioAttributes {
    private int sampleRate = 16000;
    private String encoding = "raw";
    private int channels = 1;
    private int bitdepth = 16;
    private int frameSize = 0;

    public int getBitdepth() {
        return this.bitdepth;
    }

    public int getChannels() {
        return this.channels;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public int getFrameSize() {
        return this.frameSize;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public void setBitdepth(int i) {
        this.bitdepth = i;
    }

    public void setChannels(int i) {
        this.channels = i;
    }

    public void setEncoding(String str) {
        this.encoding = str;
    }

    public void setFrameSize(int i) {
        this.frameSize = i;
    }

    public void setSampleRate(int i) {
        this.sampleRate = i;
    }
}
