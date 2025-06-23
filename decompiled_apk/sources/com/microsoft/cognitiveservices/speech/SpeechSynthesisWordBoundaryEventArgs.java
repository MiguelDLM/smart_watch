package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import com.microsoft.cognitiveservices.speech.util.StringRef;

/* loaded from: classes11.dex */
public class SpeechSynthesisWordBoundaryEventArgs {
    private long audioOffset;
    private SpeechSynthesisBoundaryType boundaryType;
    private long duration;
    private String resultId;
    private String text;
    private long textOffset;
    private long wordLength;

    public SpeechSynthesisWordBoundaryEventArgs(long j) {
        Contracts.throwIfNull(j, "eventArgs");
        SafeHandle safeHandle = new SafeHandle(j, SafeHandleType.SynthesisEvent);
        StringRef stringRef = new StringRef("");
        Contracts.throwIfFail(getResultId(safeHandle, stringRef));
        this.resultId = stringRef.getValue();
        IntRef intRef = new IntRef(0L);
        IntRef intRef2 = new IntRef(0L);
        IntRef intRef3 = new IntRef(0L);
        IntRef intRef4 = new IntRef(0L);
        IntRef intRef5 = new IntRef(0L);
        Contracts.throwIfFail(getWordBoundaryEventValues(safeHandle, intRef, intRef2, intRef3, intRef4, intRef5));
        this.audioOffset = intRef.getValue();
        this.duration = intRef2.getValue();
        long value = intRef3.getValue();
        this.textOffset = value;
        if (value > 2147483647L) {
            this.textOffset = -1L;
        }
        this.wordLength = intRef4.getValue();
        this.boundaryType = SpeechSynthesisBoundaryType.values()[(int) intRef5.getValue()];
        this.text = getTextFromHandle(safeHandle);
        safeHandle.close();
    }

    private final native long getResultId(SafeHandle safeHandle, StringRef stringRef);

    private final native String getTextFromHandle(SafeHandle safeHandle);

    private final native long getWordBoundaryEventValues(SafeHandle safeHandle, IntRef intRef, IntRef intRef2, IntRef intRef3, IntRef intRef4, IntRef intRef5);

    public long getAudioOffset() {
        return this.audioOffset;
    }

    public SpeechSynthesisBoundaryType getBoundaryType() {
        return this.boundaryType;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getResultId() {
        return this.resultId;
    }

    public String getText() {
        return this.text;
    }

    public long getTextOffset() {
        return this.textOffset;
    }

    public long getWordLength() {
        return this.wordLength;
    }
}
