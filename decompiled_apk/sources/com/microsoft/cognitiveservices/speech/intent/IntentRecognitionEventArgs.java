package com.microsoft.cognitiveservices.speech.intent;

import com.microsoft.cognitiveservices.speech.PropertyId;
import com.microsoft.cognitiveservices.speech.RecognitionEventArgs;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;

/* loaded from: classes11.dex */
public class IntentRecognitionEventArgs extends RecognitionEventArgs {
    private IntentRecognitionResult result;

    public IntentRecognitionEventArgs(long j) {
        super(j);
        storeEventData(false);
    }

    private void storeEventData(boolean z) {
        Contracts.throwIfNull(this.eventHandle, "eventHandle");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getRecognitionResult(this.eventHandle, intRef));
        this.result = new IntentRecognitionResult(intRef.getValue());
        Contracts.throwIfNull(getSessionId(), "SessionId");
        if (z) {
            super.close();
        }
    }

    public final IntentRecognitionResult getResult() {
        return this.result;
    }

    @Override // com.microsoft.cognitiveservices.speech.RecognitionEventArgs, com.microsoft.cognitiveservices.speech.SessionEventArgs
    public String toString() {
        return "SessionId:" + getSessionId() + " ResultId:" + this.result.getResultId() + " Reason:" + this.result.getReason() + " IntentId:<" + this.result.getIntentId() + "> Recognized text:<" + this.result.getText() + "> Recognized json:<" + this.result.getProperties().getProperty(PropertyId.SpeechServiceResponse_JsonResult) + "> LanguageUnderstandingJson <" + this.result.getProperties().getProperty(PropertyId.LanguageUnderstandingServiceResponse_JsonResult) + ">.";
    }

    public IntentRecognitionEventArgs(long j, boolean z) {
        super(j);
        storeEventData(z);
    }
}
