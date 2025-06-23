package com.microsoft.cognitiveservices.speech;

/* loaded from: classes11.dex */
public class SpeechRecognitionResult extends RecognitionResult {
    public SpeechRecognitionResult(long j) {
        super(j);
    }

    @Override // com.microsoft.cognitiveservices.speech.RecognitionResult, java.lang.AutoCloseable
    public void close() {
        super.close();
    }

    public String toString() {
        return "ResultId:" + getResultId() + " Status:" + getReason() + " Recognized text:<" + getText() + ">.";
    }
}
