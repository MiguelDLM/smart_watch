package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;

/* loaded from: classes11.dex */
public class CancellationDetails {
    private CancellationErrorCode errorCode;
    private String errorDetails;
    private CancellationReason reason;

    public CancellationDetails(RecognitionResult recognitionResult) {
        Contracts.throwIfNull(recognitionResult, "result");
        Contracts.throwIfNull(recognitionResult.getImpl(), "result.resultHandle");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getCanceledReason(recognitionResult.getImpl(), intRef));
        this.reason = CancellationReason.values()[((int) intRef.getValue()) - 1];
        Contracts.throwIfFail(getCanceledErrorCode(recognitionResult.getImpl(), intRef));
        this.errorCode = CancellationErrorCode.values()[(int) intRef.getValue()];
        this.errorDetails = recognitionResult.getProperties().getProperty(PropertyId.SpeechServiceResponse_JsonErrorDetails);
    }

    public static CancellationDetails fromResult(RecognitionResult recognitionResult) {
        return new CancellationDetails(recognitionResult);
    }

    private final native long getCanceledErrorCode(SafeHandle safeHandle, IntRef intRef);

    private final native long getCanceledReason(SafeHandle safeHandle, IntRef intRef);

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
}
