package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import com.microsoft.cognitiveservices.speech.util.StringRef;

/* loaded from: classes11.dex */
public class SpeechSynthesisResult implements AutoCloseable {
    private byte[] audioData;
    private long audioDuration;
    private long audioLength;
    private PropertyCollection properties;
    private ResultReason reason;
    private SafeHandle resultHandle;
    private String resultId;

    public SpeechSynthesisResult(IntRef intRef) {
        this.resultHandle = null;
        Contracts.throwIfNull(intRef, "result");
        this.resultHandle = new SafeHandle(intRef.getValue(), SafeHandleType.SynthesisResult);
        StringRef stringRef = new StringRef("");
        Contracts.throwIfFail(getResultId(this.resultHandle, stringRef));
        this.resultId = stringRef.getValue();
        IntRef intRef2 = new IntRef(0L);
        Contracts.throwIfFail(getResultReason(this.resultHandle, intRef2));
        this.reason = ResultReason.values()[(int) intRef2.getValue()];
        IntRef intRef3 = new IntRef(0L);
        IntRef intRef4 = new IntRef(0L);
        Contracts.throwIfFail(getAudioLength(this.resultHandle, intRef3, intRef4));
        this.audioLength = intRef3.getValue();
        this.audioDuration = intRef4.getValue() * 10000;
        this.audioData = null;
        IntRef intRef5 = new IntRef(0L);
        Contracts.throwIfFail(getPropertyBagFromResult(this.resultHandle, intRef5));
        this.properties = new PropertyCollection(intRef5);
    }

    private final native byte[] getAudio(SafeHandle safeHandle, IntRef intRef);

    private final native long getAudioLength(SafeHandle safeHandle, IntRef intRef, IntRef intRef2);

    private final native long getPropertyBagFromResult(SafeHandle safeHandle, IntRef intRef);

    private final native long getResultId(SafeHandle safeHandle, StringRef stringRef);

    private final native long getResultReason(SafeHandle safeHandle, IntRef intRef);

    @Override // java.lang.AutoCloseable
    public void close() {
        SafeHandle safeHandle = this.resultHandle;
        if (safeHandle != null) {
            safeHandle.close();
            this.resultHandle = null;
        }
        PropertyCollection propertyCollection = this.properties;
        if (propertyCollection != null) {
            propertyCollection.close();
            this.properties = null;
        }
    }

    public byte[] getAudioData() {
        if (this.audioData == null) {
            IntRef intRef = new IntRef(0L);
            this.audioData = getAudio(this.resultHandle, intRef);
            Contracts.throwIfFail(intRef.getValue());
        }
        return this.audioData;
    }

    public long getAudioDuration() {
        return this.audioDuration;
    }

    public long getAudioLength() {
        return this.audioLength;
    }

    public SafeHandle getImpl() {
        return this.resultHandle;
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
}
