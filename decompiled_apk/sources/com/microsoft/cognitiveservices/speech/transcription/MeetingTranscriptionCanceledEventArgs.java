package com.microsoft.cognitiveservices.speech.transcription;

import com.microsoft.cognitiveservices.speech.CancellationDetails;
import com.microsoft.cognitiveservices.speech.CancellationErrorCode;
import com.microsoft.cognitiveservices.speech.CancellationReason;
import com.microsoft.cognitiveservices.speech.util.Contracts;

/* loaded from: classes11.dex */
public final class MeetingTranscriptionCanceledEventArgs extends MeetingTranscriptionEventArgs {
    private CancellationReason cancellationReason;
    private CancellationErrorCode errorCode;
    private String errorDetails;
    private String sessionId;

    public MeetingTranscriptionCanceledEventArgs(long j) {
        super(j);
        storeEventData(false);
    }

    private void storeEventData(boolean z) {
        Contracts.throwIfNull(this.eventHandle, "eventHandle");
        String sessionId = getSessionId();
        this.sessionId = sessionId;
        Contracts.throwIfNull(sessionId, "SessionId");
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

    @Override // com.microsoft.cognitiveservices.speech.transcription.MeetingTranscriptionEventArgs, com.microsoft.cognitiveservices.speech.RecognitionEventArgs, com.microsoft.cognitiveservices.speech.SessionEventArgs
    public String toString() {
        return "SessionId:" + this.sessionId + " ResultId:" + getResult().getResultId() + " CancellationReason:" + this.cancellationReason + " CancellationErrorCode:" + this.errorCode + " Error details:<" + this.errorDetails;
    }

    public MeetingTranscriptionCanceledEventArgs(long j, boolean z) {
        super(j);
        storeEventData(z);
    }
}
