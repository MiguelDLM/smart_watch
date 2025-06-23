package com.microsoft.cognitiveservices.speech;

/* loaded from: classes11.dex */
public enum PronunciationAssessmentGranularity {
    Phoneme(1),
    Word(2),
    FullText(3);

    private final int id;

    PronunciationAssessmentGranularity(int i) {
        this.id = i;
    }

    public int getValue() {
        return this.id;
    }
}
