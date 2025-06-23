package com.microsoft.cognitiveservices.speech.transcription;

import com.microsoft.cognitiveservices.speech.RecognitionEventArgs;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;

/* loaded from: classes11.dex */
public class ConversationTranscriptionEventArgs extends RecognitionEventArgs {
    private ConversationTranscriptionResult result;

    public ConversationTranscriptionEventArgs(long j) {
        super(j);
        storeEventData(false);
    }

    private void storeEventData(boolean z) {
        Contracts.throwIfNull(this.eventHandle, "eventHandle");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getRecognitionResult(this.eventHandle, intRef));
        this.result = new ConversationTranscriptionResult(intRef.getValue());
        Contracts.throwIfNull(getSessionId(), "SessionId");
        if (z) {
            super.close();
        }
    }

    public final ConversationTranscriptionResult getResult() {
        return this.result;
    }

    @Override // com.microsoft.cognitiveservices.speech.RecognitionEventArgs, com.microsoft.cognitiveservices.speech.SessionEventArgs
    public String toString() {
        return "SessionId:" + getSessionId() + " ResultId:" + this.result.getResultId() + " Reason:" + this.result.getReason() + " SpeakerId:" + this.result.getSpeakerId() + " Recognized text:<" + this.result.getText() + ">.";
    }

    public ConversationTranscriptionEventArgs(long j, boolean z) {
        super(j);
        storeEventData(z);
    }
}
