package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import com.microsoft.cognitiveservices.speech.util.StringRef;

/* loaded from: classes11.dex */
public class SpeechSynthesisBookmarkEventArgs {
    private long audioOffset;
    private String resultId;
    private String text;

    public SpeechSynthesisBookmarkEventArgs(long j) {
        Contracts.throwIfNull(j, "eventArgs");
        SafeHandle safeHandle = new SafeHandle(j, SafeHandleType.SynthesisEvent);
        StringRef stringRef = new StringRef("");
        Contracts.throwIfFail(getResultId(safeHandle, stringRef));
        this.resultId = stringRef.getValue();
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getBookmarkEventValues(safeHandle, intRef));
        this.audioOffset = intRef.getValue();
        Contracts.throwIfFail(getTextFromHandle(safeHandle, stringRef));
        this.text = stringRef.getValue();
        safeHandle.close();
    }

    private final native long getBookmarkEventValues(SafeHandle safeHandle, IntRef intRef);

    private final native long getResultId(SafeHandle safeHandle, StringRef stringRef);

    private final native long getTextFromHandle(SafeHandle safeHandle, StringRef stringRef);

    public long getAudioOffset() {
        return this.audioOffset;
    }

    public String getResultId() {
        return this.resultId;
    }

    public String getText() {
        return this.text;
    }
}
