package com.jieli.jl_rcsp.model.device;

/* loaded from: classes10.dex */
public class SpeechInfo {
    private int audioFormat;
    private int channel;
    private int haveVad;
    private int sampleRate;

    public int getAudioFormat() {
        return this.audioFormat;
    }

    public int getChannel() {
        return this.channel;
    }

    public int getHaveVad() {
        return this.haveVad;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public void setAudioFormat(int i) {
        this.audioFormat = i;
    }

    public void setChannel(int i) {
        this.channel = i;
    }

    public void setHaveVad(int i) {
        this.haveVad = i;
    }

    public void setSampleRate(int i) {
        this.sampleRate = i;
    }

    public String toString() {
        return "SpeechInfo{haveVad=" + this.haveVad + ", channel=" + this.channel + ", sampleRate=" + this.sampleRate + ", audioFormat=" + this.audioFormat + '}';
    }
}
