package com.microsoft.cognitiveservices.speech.intent;

import com.microsoft.cognitiveservices.speech.PropertyId;
import com.microsoft.cognitiveservices.speech.ResultReason;
import com.microsoft.cognitiveservices.speech.SpeechRecognitionResult;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.JsonValue;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.StringRef;
import java.util.Dictionary;
import java.util.Hashtable;

/* loaded from: classes11.dex */
public final class IntentRecognitionResult extends SpeechRecognitionResult {
    private Dictionary<String, String> entities;
    private String intentId;

    public IntentRecognitionResult(long j) {
        super(j);
        Contracts.throwIfNull(super.getImpl(), "resultHandle");
        StringRef stringRef = new StringRef("");
        Contracts.throwIfFail(getIntentId(super.getImpl(), stringRef));
        String value = stringRef.getValue();
        this.intentId = value;
        Contracts.throwIfNull(value, "IntentId");
        if (getReason() == ResultReason.RecognizedIntent) {
            String property = getProperties().getProperty("LanguageUnderstandingSLE_JsonResult");
            this.entities = new Hashtable();
            if (property != null) {
                JsonValue Parse = JsonValue.Parse(property);
                int count = Parse.count();
                for (int i = 0; i < count; i++) {
                    this.entities.put(Parse.getName(i), Parse.get(i).asString());
                }
            }
        }
    }

    private final native long getIntentId(SafeHandle safeHandle, StringRef stringRef);

    @Override // com.microsoft.cognitiveservices.speech.SpeechRecognitionResult, com.microsoft.cognitiveservices.speech.RecognitionResult, java.lang.AutoCloseable
    public void close() {
        super.close();
    }

    public Dictionary<String, String> getEntities() {
        return this.entities;
    }

    public String getIntentId() {
        return this.intentId;
    }

    @Override // com.microsoft.cognitiveservices.speech.SpeechRecognitionResult
    public String toString() {
        return "ResultId:" + getResultId() + " Reason:" + getReason() + " IntentId:<" + this.intentId + "> Recognized text:<" + getText() + "> Recognized json:<" + getProperties().getProperty(PropertyId.SpeechServiceResponse_JsonResult) + "> LanguageUnderstandingJson <" + getProperties().getProperty(PropertyId.LanguageUnderstandingServiceResponse_JsonResult) + ">.";
    }
}
