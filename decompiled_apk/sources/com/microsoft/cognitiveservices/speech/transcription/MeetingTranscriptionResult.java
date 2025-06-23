package com.microsoft.cognitiveservices.speech.transcription;

import com.microsoft.cognitiveservices.speech.SpeechRecognitionResult;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.StringRef;

/* loaded from: classes11.dex */
public class MeetingTranscriptionResult extends SpeechRecognitionResult {
    private String userId;
    private String utteranceId;

    public MeetingTranscriptionResult(long j) {
        super(j);
        if (j != 0) {
            StringRef stringRef = new StringRef("");
            Contracts.throwIfFail(getUserId(super.getImpl(), stringRef));
            this.userId = stringRef.getValue();
            StringRef stringRef2 = new StringRef("");
            Contracts.throwIfFail(getUtteranceId(super.getImpl(), stringRef2));
            this.utteranceId = stringRef2.getValue();
        }
    }

    private final native long getUserId(SafeHandle safeHandle, StringRef stringRef);

    private final native long getUtteranceId(SafeHandle safeHandle, StringRef stringRef);

    @Override // com.microsoft.cognitiveservices.speech.SpeechRecognitionResult, com.microsoft.cognitiveservices.speech.RecognitionResult, java.lang.AutoCloseable
    public void close() {
        super.close();
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUtteranceId() {
        return this.utteranceId;
    }

    @Override // com.microsoft.cognitiveservices.speech.SpeechRecognitionResult
    public String toString() {
        return "ResultId:" + getResultId() + " Status:" + getReason() + " UserId:" + this.userId + " UtteranceId:" + this.utteranceId + " Recognized text:<" + getText() + ">.";
    }
}
