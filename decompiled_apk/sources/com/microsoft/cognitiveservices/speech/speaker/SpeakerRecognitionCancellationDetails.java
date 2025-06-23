package com.microsoft.cognitiveservices.speech.speaker;

import com.microsoft.cognitiveservices.speech.CancellationErrorCode;
import com.microsoft.cognitiveservices.speech.CancellationReason;
import com.microsoft.cognitiveservices.speech.PropertyId;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;

/* loaded from: classes11.dex */
public class SpeakerRecognitionCancellationDetails {
    private CancellationErrorCode errorCode;
    private String errorDetails;
    private CancellationReason reason;

    private SpeakerRecognitionCancellationDetails(SpeakerRecognitionResult speakerRecognitionResult) {
        Contracts.throwIfNull(speakerRecognitionResult, "result");
        Contracts.throwIfNull(speakerRecognitionResult.getImpl(), "resultHandle");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getCanceledReason(speakerRecognitionResult.getImpl(), intRef));
        this.reason = CancellationReason.values()[((int) intRef.getValue()) - 1];
        Contracts.throwIfFail(getCanceledErrorCode(speakerRecognitionResult.getImpl(), intRef));
        this.errorCode = CancellationErrorCode.values()[(int) intRef.getValue()];
        this.errorDetails = speakerRecognitionResult.getProperties().getProperty(PropertyId.SpeechServiceResponse_JsonErrorDetails);
    }

    public static SpeakerRecognitionCancellationDetails fromResult(SpeakerRecognitionResult speakerRecognitionResult) {
        return new SpeakerRecognitionCancellationDetails(speakerRecognitionResult);
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
