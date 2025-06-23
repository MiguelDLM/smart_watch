package com.microsoft.cognitiveservices.speech;

/* loaded from: classes11.dex */
public enum PronunciationAssessmentGradingSystem {
    FivePoint(1),
    HundredMark(2);

    private final int id;

    PronunciationAssessmentGradingSystem(int i) {
        this.id = i;
    }

    public int getValue() {
        return this.id;
    }
}
