package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import com.microsoft.cognitiveservices.speech.util.StringRef;

/* loaded from: classes11.dex */
public class SpeechSynthesisVisemeEventArgs {
    private String animation;
    private long audioOffset;
    private String resultId;
    private long visemeId;

    public SpeechSynthesisVisemeEventArgs(long j) {
        Contracts.throwIfNull(j, "eventArgs");
        SafeHandle safeHandle = new SafeHandle(j, SafeHandleType.SynthesisEvent);
        StringRef stringRef = new StringRef("");
        Contracts.throwIfFail(getResultId(safeHandle, stringRef));
        this.resultId = stringRef.getValue();
        IntRef intRef = new IntRef(0L);
        IntRef intRef2 = new IntRef(0L);
        Contracts.throwIfFail(getVisemeEventValues(safeHandle, intRef, intRef2));
        this.audioOffset = intRef.getValue();
        this.visemeId = intRef2.getValue();
        Contracts.throwIfFail(getAnimationFromHandle(safeHandle, stringRef));
        this.animation = stringRef.getValue();
        safeHandle.close();
    }

    private final native long getAnimationFromHandle(SafeHandle safeHandle, StringRef stringRef);

    private final native long getResultId(SafeHandle safeHandle, StringRef stringRef);

    private final native long getVisemeEventValues(SafeHandle safeHandle, IntRef intRef, IntRef intRef2);

    public String getAnimation() {
        return this.animation;
    }

    public long getAudioOffset() {
        return this.audioOffset;
    }

    public String getResultId() {
        return this.resultId;
    }

    public long getVisemeId() {
        return this.visemeId;
    }
}
