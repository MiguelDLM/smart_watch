package com.microsoft.cognitiveservices.speech.transcription;

import com.microsoft.cognitiveservices.speech.SpeechRecognitionResult;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.StringRef;

/* loaded from: classes11.dex */
public class ConversationTranscriptionResult extends SpeechRecognitionResult {
    private String speakerId;

    public ConversationTranscriptionResult(long j) {
        super(j);
        if (j != 0) {
            StringRef stringRef = new StringRef("");
            Contracts.throwIfFail(getSpeakerId(super.getImpl(), stringRef));
            this.speakerId = stringRef.getValue();
        }
    }

    private final native long getSpeakerId(SafeHandle safeHandle, StringRef stringRef);

    @Override // com.microsoft.cognitiveservices.speech.SpeechRecognitionResult, com.microsoft.cognitiveservices.speech.RecognitionResult, java.lang.AutoCloseable
    public void close() {
        super.close();
    }

    public String getSpeakerId() {
        return this.speakerId;
    }

    @Override // com.microsoft.cognitiveservices.speech.SpeechRecognitionResult
    public String toString() {
        return "ResultId:" + getResultId() + " Status:" + getReason() + " SpeakerId:" + this.speakerId + " Recognized text:<" + getText() + ">.";
    }
}
