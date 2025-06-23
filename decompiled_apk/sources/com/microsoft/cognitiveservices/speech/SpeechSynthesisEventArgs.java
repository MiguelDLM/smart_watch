package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;

/* loaded from: classes11.dex */
public class SpeechSynthesisEventArgs implements AutoCloseable {
    private SafeHandle eventHandle;
    private SpeechSynthesisResult result;

    public SpeechSynthesisEventArgs(long j) {
        Contracts.throwIfNull(j, "eventArgs");
        this.eventHandle = new SafeHandle(j, SafeHandleType.SynthesisEvent);
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getSynthesisResult(this.eventHandle, intRef));
        this.result = new SpeechSynthesisResult(intRef);
    }

    private final native long getSynthesisResult(SafeHandle safeHandle, IntRef intRef);

    @Override // java.lang.AutoCloseable
    public void close() {
        SafeHandle safeHandle = this.eventHandle;
        if (safeHandle != null) {
            safeHandle.close();
            this.eventHandle = null;
        }
        SpeechSynthesisResult speechSynthesisResult = this.result;
        if (speechSynthesisResult != null) {
            speechSynthesisResult.close();
            this.result = null;
        }
    }

    public SpeechSynthesisResult getResult() {
        return this.result;
    }
}
