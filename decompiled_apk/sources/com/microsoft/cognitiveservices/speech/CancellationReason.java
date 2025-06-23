package com.microsoft.cognitiveservices.speech;

/* loaded from: classes11.dex */
public enum CancellationReason {
    Error(1),
    EndOfStream(2),
    CancelledByUser(3);

    private final int id;

    CancellationReason(int i) {
        this.id = i;
    }

    public int getValue() {
        return this.id;
    }
}
