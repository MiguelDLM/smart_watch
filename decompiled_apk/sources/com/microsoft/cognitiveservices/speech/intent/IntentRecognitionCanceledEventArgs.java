package com.microsoft.cognitiveservices.speech.intent;

import com.microsoft.cognitiveservices.speech.CancellationDetails;
import com.microsoft.cognitiveservices.speech.CancellationErrorCode;
import com.microsoft.cognitiveservices.speech.CancellationReason;
import com.microsoft.cognitiveservices.speech.util.Contracts;

/* loaded from: classes11.dex */
public final class IntentRecognitionCanceledEventArgs extends IntentRecognitionEventArgs {
    private CancellationReason cancellationReason;
    private CancellationErrorCode errorCode;
    private String errorDetails;

    public IntentRecognitionCanceledEventArgs(long j) {
        super(j);
        storeEventData(false);
    }

    private void storeEventData(boolean z) {
        Contracts.throwIfNull(this.eventHandle, "eventHandle");
        CancellationDetails fromResult = CancellationDetails.fromResult(getResult());
        this.cancellationReason = fromResult.getReason();
        this.errorCode = fromResult.getErrorCode();
        this.errorDetails = fromResult.getErrorDetails();
        if (z) {
            super.close();
        }
    }

    public CancellationErrorCode getErrorCode() {
        return this.errorCode;
    }

    public String getErrorDetails() {
        return this.errorDetails;
    }

    public CancellationReason getReason() {
        return this.cancellationReason;
    }

    @Override // com.microsoft.cognitiveservices.speech.intent.IntentRecognitionEventArgs, com.microsoft.cognitiveservices.speech.RecognitionEventArgs, com.microsoft.cognitiveservices.speech.SessionEventArgs
    public String toString() {
        return "SessionId:" + getSessionId() + " ResultId:" + getResult().getResultId() + " IntentId:" + getResult().getIntentId() + " CancellationReason:" + this.cancellationReason + " CancellationErrorCode:" + this.errorCode + " Error details:" + this.errorDetails;
    }

    public IntentRecognitionCanceledEventArgs(long j, boolean z) {
        super(j);
        storeEventData(z);
    }
}
