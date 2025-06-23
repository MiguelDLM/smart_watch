package com.jieli.jl_rcsp.model;

/* loaded from: classes10.dex */
public class RecordParam {
    public static final int SAMPLE_RATE_16K = 16;
    public static final int SAMPLE_RATE_8K = 8;
    public static final int VAD_WAY_DEVICE = 0;
    public static final int VAD_WAY_SDK = 1;
    public static final int VOICE_TYPE_OPUS = 2;
    public static final int VOICE_TYPE_PCM = 0;
    public static final int VOICE_TYPE_SPEEX = 1;
    private final int sampleRate;
    private final int vadWay;
    private final int voiceType;

    public RecordParam(int i, int i2, int i3) {
        this.voiceType = i;
        this.sampleRate = i2;
        this.vadWay = i3;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public int getVadWay() {
        return this.vadWay;
    }

    public int getVoiceType() {
        return this.voiceType;
    }

    public String toString() {
        return "RecordParam{voiceType=" + this.voiceType + ", sampleRate=" + this.sampleRate + ", vadWay=" + this.vadWay + '}';
    }
}
