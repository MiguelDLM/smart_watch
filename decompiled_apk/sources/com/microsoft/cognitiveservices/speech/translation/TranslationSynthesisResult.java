package com.microsoft.cognitiveservices.speech.translation;

import com.microsoft.cognitiveservices.speech.ResultReason;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import com.tenmeter.smlibrary.utils.FileUtils;

/* loaded from: classes11.dex */
public final class TranslationSynthesisResult {
    private byte[] audioData;
    private ResultReason reason;
    private SafeHandle resultHandle;

    public TranslationSynthesisResult(long j) {
        Contracts.throwIfNull(j, "result");
        this.resultHandle = new SafeHandle(j, SafeHandleType.RecognitionResult);
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getResultReason(this.resultHandle, intRef));
        this.reason = ResultReason.values()[(int) intRef.getValue()];
        IntRef intRef2 = new IntRef(0L);
        this.audioData = getAudio(this.resultHandle, intRef2);
        Contracts.throwIfFail(intRef2.getValue());
    }

    private final native byte[] getAudio(SafeHandle safeHandle, IntRef intRef);

    private final native long getResultReason(SafeHandle safeHandle, IntRef intRef);

    public void close() {
        SafeHandle safeHandle = this.resultHandle;
        if (safeHandle != null) {
            safeHandle.close();
        }
        this.resultHandle = null;
    }

    public byte[] getAudio() {
        return this.audioData;
    }

    public ResultReason getReason() {
        return this.reason;
    }

    public String toString() {
        return "TranslationSynthesisResult Reason:" + this.reason + " Audio.length:" + this.audioData.length + FileUtils.FILE_EXTENSION_SEPARATOR;
    }
}
