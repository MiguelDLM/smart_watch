package com.microsoft.cognitiveservices.speech.transcription;

import com.microsoft.cognitiveservices.speech.RecognitionEventArgs;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;

/* loaded from: classes11.dex */
public class ConversationTranslationEventArgs extends RecognitionEventArgs {
    private ConversationTranslationResult result;

    public ConversationTranslationEventArgs(long j) {
        super(j);
        storeEventData(false);
    }

    private void storeEventData(boolean z) {
        Contracts.throwIfNull(this.eventHandle, "eventHandle");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getRecognitionResult(this.eventHandle, intRef));
        this.result = new ConversationTranslationResult(intRef.getValue());
        Contracts.throwIfNull(getSessionId(), "SessionId");
        if (z) {
            super.close();
        }
    }

    public final ConversationTranslationResult getResult() {
        return this.result;
    }

    @Override // com.microsoft.cognitiveservices.speech.RecognitionEventArgs, com.microsoft.cognitiveservices.speech.SessionEventArgs
    public String toString() {
        return "SessionId:" + getSessionId() + " ResultId:" + this.result.getResultId() + " Reason:" + this.result.getReason() + " OriginalLang:" + this.result.getOriginalLang() + " ParticipantId:" + this.result.getParticipantId() + " Recognized text:<" + this.result.getText() + ">.";
    }

    public ConversationTranslationEventArgs(long j, boolean z) {
        super(j);
        storeEventData(z);
    }
}
