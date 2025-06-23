package com.microsoft.cognitiveservices.speech.audio;

import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;

/* loaded from: classes11.dex */
public final class PullAudioOutputStream extends AudioOutputStream {
    static {
        try {
            Class.forName(SpeechConfig.class.getName());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    public PullAudioOutputStream(IntRef intRef) {
        super(intRef);
    }

    public static PullAudioOutputStream create() {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createPullAudioOutputStream(intRef));
        return new PullAudioOutputStream(intRef);
    }

    private static final native long createPullAudioOutputStream(IntRef intRef);

    private final native long pullAudioOutputStreamRead(SafeHandle safeHandle, byte[] bArr, IntRef intRef);

    public long read(byte[] bArr) {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(pullAudioOutputStreamRead(getImpl(), bArr, intRef));
        return intRef.getValue();
    }
}
