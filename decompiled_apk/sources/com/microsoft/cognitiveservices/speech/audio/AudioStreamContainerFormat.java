package com.microsoft.cognitiveservices.speech.audio;

/* loaded from: classes11.dex */
public enum AudioStreamContainerFormat {
    OGG_OPUS(257),
    MP3(258),
    FLAC(259),
    ALAW(260),
    MULAW(261),
    AMRNB(262),
    AMRWB(263),
    ANY(264);

    private final int id;

    AudioStreamContainerFormat(int i) {
        this.id = i;
    }

    public int getValue() {
        return this.id;
    }
}
