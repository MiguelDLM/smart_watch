package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.sma.smartv3.network.AICreateJobV2;

/* loaded from: classes11.dex */
public class SpeechSynthesisCancellationDetails {
    private CancellationErrorCode errorCode;
    private String errorDetails;
    private CancellationReason reason;

    private SpeechSynthesisCancellationDetails(AudioDataStream audioDataStream) {
        Contracts.throwIfNull(audioDataStream, AICreateJobV2.AI_Stream);
        Contracts.throwIfNull(audioDataStream.getImpl(), "streamHandle");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getCanceledReasonFromStream(audioDataStream.getImpl(), intRef));
        this.reason = CancellationReason.values()[((int) intRef.getValue()) - 1];
        Contracts.throwIfFail(getCanceledErrorCodeFromStream(audioDataStream.getImpl(), intRef));
        this.errorCode = CancellationErrorCode.values()[(int) intRef.getValue()];
        this.errorDetails = audioDataStream.getProperties().getProperty(PropertyId.CancellationDetails_ReasonDetailedText);
    }

    public static SpeechSynthesisCancellationDetails fromResult(SpeechSynthesisResult speechSynthesisResult) {
        return new SpeechSynthesisCancellationDetails(speechSynthesisResult);
    }

    public static SpeechSynthesisCancellationDetails fromStream(AudioDataStream audioDataStream) {
        return new SpeechSynthesisCancellationDetails(audioDataStream);
    }

    private final native long getCanceledErrorCodeFromStream(SafeHandle safeHandle, IntRef intRef);

    private final native long getCanceledErrorCodeFromSynthResult(SafeHandle safeHandle, IntRef intRef);

    private final native long getCanceledReasonFromStream(SafeHandle safeHandle, IntRef intRef);

    private final native long getCanceledReasonFromSynthResult(SafeHandle safeHandle, IntRef intRef);

    public void close() {
    }

    public CancellationErrorCode getErrorCode() {
        return this.errorCode;
    }

    public String getErrorDetails() {
        return this.errorDetails;
    }

    public CancellationReason getReason() {
        return this.reason;
    }

    public String toString() {
        return "CancellationReason:" + this.reason + " ErrorCode: " + this.errorCode + " ErrorDetails:" + this.errorDetails;
    }

    private SpeechSynthesisCancellationDetails(SpeechSynthesisResult speechSynthesisResult) {
        Contracts.throwIfNull(speechSynthesisResult, "result");
        Contracts.throwIfNull(speechSynthesisResult.getImpl(), "resultHandle");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getCanceledReasonFromSynthResult(speechSynthesisResult.getImpl(), intRef));
        this.reason = CancellationReason.values()[((int) intRef.getValue()) - 1];
        Contracts.throwIfFail(getCanceledErrorCodeFromSynthResult(speechSynthesisResult.getImpl(), intRef));
        this.errorCode = CancellationErrorCode.values()[(int) intRef.getValue()];
        this.errorDetails = speechSynthesisResult.getProperties().getProperty(PropertyId.CancellationDetails_ReasonDetailedText);
    }
}
