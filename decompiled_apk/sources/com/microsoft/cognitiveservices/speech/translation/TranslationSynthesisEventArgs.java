package com.microsoft.cognitiveservices.speech.translation;

import com.microsoft.cognitiveservices.speech.SessionEventArgs;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.tenmeter.smlibrary.utils.FileUtils;

/* loaded from: classes11.dex */
public final class TranslationSynthesisEventArgs extends SessionEventArgs {
    private TranslationSynthesisResult result;

    public TranslationSynthesisEventArgs(long j) {
        super(j);
        storeEventData(false);
    }

    private final native long getSynthesisResult(SafeHandle safeHandle, IntRef intRef);

    private void storeEventData(boolean z) {
        Contracts.throwIfNull(this.eventHandle, "eventHandle");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getSynthesisResult(this.eventHandle, intRef));
        this.result = new TranslationSynthesisResult(intRef.getValue());
        Contracts.throwIfNull(getSessionId(), "SessionId");
        if (z) {
            super.close();
        }
    }

    public final TranslationSynthesisResult getResult() {
        return this.result;
    }

    @Override // com.microsoft.cognitiveservices.speech.SessionEventArgs
    public String toString() {
        return "SessionId:" + getSessionId() + " Result:" + this.result.toString() + FileUtils.FILE_EXTENSION_SEPARATOR;
    }

    public TranslationSynthesisEventArgs(long j, boolean z) {
        super(j);
        storeEventData(z);
    }
}
