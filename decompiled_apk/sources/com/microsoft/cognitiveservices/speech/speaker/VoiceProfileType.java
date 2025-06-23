package com.microsoft.cognitiveservices.speech.speaker;

/* loaded from: classes11.dex */
public enum VoiceProfileType {
    TextIndependentIdentification(1),
    TextDependentVerification(2),
    TextIndependentVerification(3);

    private final int id;

    VoiceProfileType(int i) {
        this.id = i;
    }

    public int getValue() {
        return this.id;
    }
}
