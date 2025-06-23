package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;

/* loaded from: classes11.dex */
public final class KeywordRecognitionResult extends RecognitionResult {
    public KeywordRecognitionResult(long j) {
        super(j);
        Contracts.throwIfNull(super.getImpl(), "resultHandle");
    }

    @Override // com.microsoft.cognitiveservices.speech.RecognitionResult, java.lang.AutoCloseable
    public void close() {
        super.close();
    }

    public String toString() {
        return "ResultId:" + getResultId() + " Reason:" + getReason() + "> Recognized text:<" + getText() + ">.";
    }
}
