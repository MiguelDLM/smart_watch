package com.microsoft.cognitiveservices.speech.speaker;

import com.microsoft.cognitiveservices.speech.PropertyCollection;
import com.microsoft.cognitiveservices.speech.PropertyId;
import com.microsoft.cognitiveservices.speech.ResultReason;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import com.microsoft.cognitiveservices.speech.util.StringRef;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes11.dex */
public final class VoiceProfilePhraseResult implements AutoCloseable {
    private List<String> phrases;
    private PropertyCollection properties;
    private ResultReason reason;
    private SafeHandle resultHandle;
    private String resultId;

    public VoiceProfilePhraseResult(long j) {
        this.resultHandle = null;
        this.properties = null;
        this.resultId = "";
        this.resultHandle = new SafeHandle(j, SafeHandleType.VoiceProfilePhraseResult);
        StringRef stringRef = new StringRef("");
        Contracts.throwIfFail(getResultId(this.resultHandle, stringRef));
        this.resultId = stringRef.getValue();
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getResultReason(this.resultHandle, intRef));
        this.reason = ResultReason.values()[(int) intRef.getValue()];
        IntRef intRef2 = new IntRef(0L);
        Contracts.throwIfFail(getPropertyBagFromResult(this.resultHandle, intRef2));
        PropertyCollection propertyCollection = new PropertyCollection(intRef2);
        this.properties = propertyCollection;
        String property = propertyCollection.getProperty("speakerrecognition.phrases");
        if (property.isEmpty()) {
            return;
        }
        this.phrases = Arrays.asList(property.split("\\|"));
    }

    private final native long getPropertyBagFromResult(SafeHandle safeHandle, IntRef intRef);

    private final native long getResultId(SafeHandle safeHandle, StringRef stringRef);

    private final native long getResultReason(SafeHandle safeHandle, IntRef intRef);

    @Override // java.lang.AutoCloseable
    public void close() {
        PropertyCollection propertyCollection = this.properties;
        if (propertyCollection != null) {
            propertyCollection.close();
            this.properties = null;
        }
        SafeHandle safeHandle = this.resultHandle;
        if (safeHandle != null) {
            safeHandle.close();
            this.resultHandle = null;
        }
    }

    public SafeHandle getImpl() {
        Contracts.throwIfNull(this.resultHandle, "result");
        return this.resultHandle;
    }

    public List<String> getPhrases() {
        return this.phrases;
    }

    public PropertyCollection getProperties() {
        return this.properties;
    }

    public ResultReason getReason() {
        return this.reason;
    }

    public String getResultId() {
        return this.resultId;
    }

    public String toString() {
        return "ResultId:" + getResultId() + " Reason:" + getReason() + " Json:" + this.properties.getProperty(PropertyId.SpeechServiceResponse_JsonResult);
    }
}
