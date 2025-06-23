package com.microsoft.cognitiveservices.speech.audio;

/* loaded from: classes11.dex */
public enum AudioStreamWaveFormat {
    PCM(1),
    ALAW(6),
    MULAW(7),
    G722(655);

    private final int id;

    AudioStreamWaveFormat(int i) {
        this.id = i;
    }

    public int getValue() {
        return this.id;
    }
}
