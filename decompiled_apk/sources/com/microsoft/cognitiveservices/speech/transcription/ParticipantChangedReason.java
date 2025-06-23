package com.microsoft.cognitiveservices.speech.transcription;

/* loaded from: classes11.dex */
public enum ParticipantChangedReason {
    JoinedConversation(0),
    LeftConversation(1),
    Updated(2);

    private final int id;

    ParticipantChangedReason(int i) {
        this.id = i;
    }

    public int getValue() {
        return this.id;
    }
}
