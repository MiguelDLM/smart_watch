package com.microsoft.cognitiveservices.speech.audio;

import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;

/* loaded from: classes11.dex */
public final class PushAudioOutputStream extends AudioOutputStream {
    private PushAudioOutputStreamCallback callbackHandle;

    static {
        try {
            Class.forName(SpeechConfig.class.getName());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    public PushAudioOutputStream(IntRef intRef, PushAudioOutputStreamCallback pushAudioOutputStreamCallback) {
        super(intRef);
        this.callbackHandle = pushAudioOutputStreamCallback;
        Contracts.throwIfFail(setStreamCallbacks(getImpl()));
    }

    public static PushAudioOutputStream create(PushAudioOutputStreamCallback pushAudioOutputStreamCallback) {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createPushAudioOutputStream(intRef));
        return new PushAudioOutputStream(intRef, pushAudioOutputStreamCallback);
    }

    private static final native long createPushAudioOutputStream(IntRef intRef);

    private PushAudioOutputStreamCallback getCallbackHandle() {
        return this.callbackHandle;
    }

    private final native long setStreamCallbacks(SafeHandle safeHandle);
}
