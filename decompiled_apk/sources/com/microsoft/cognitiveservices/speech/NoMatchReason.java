package com.microsoft.cognitiveservices.speech;

/* loaded from: classes11.dex */
public enum NoMatchReason {
    NotRecognized(1),
    InitialSilenceTimeout(2),
    InitialBabbleTimeout(3),
    KeywordNotRecognized(4),
    EndSilenceTimeout(5);

    private final int id;

    NoMatchReason(int i) {
        this.id = i;
    }

    public int getValue() {
        return this.id;
    }
}
