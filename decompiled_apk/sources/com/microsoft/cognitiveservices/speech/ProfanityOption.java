package com.microsoft.cognitiveservices.speech;

/* loaded from: classes11.dex */
public enum ProfanityOption {
    Masked(0),
    Removed(1),
    Raw(2);

    private final int profanity;

    ProfanityOption(int i) {
        this.profanity = i;
    }

    public int getValue() {
        return this.profanity;
    }
}
