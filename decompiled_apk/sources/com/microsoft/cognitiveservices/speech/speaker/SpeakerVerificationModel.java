package com.microsoft.cognitiveservices.speech.speaker;

import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;

/* loaded from: classes11.dex */
public class SpeakerVerificationModel implements AutoCloseable {
    private boolean disposed = false;
    private SafeHandle speakerVerificationModelHandle;

    static {
        Class<?> cls = SpeechConfig.speechConfigClass;
    }

    public SpeakerVerificationModel(IntRef intRef) {
        this.speakerVerificationModelHandle = null;
        Contracts.throwIfNull(intRef, "modelHandle");
        this.speakerVerificationModelHandle = new SafeHandle(intRef.getValue(), SafeHandleType.SpeakerVerificationModel);
    }

    private static final native long createSpeakerVerificationModel(IntRef intRef, SafeHandle safeHandle);

    public static SpeakerVerificationModel fromProfile(VoiceProfile voiceProfile) {
        Contracts.throwIfNull(voiceProfile, "profile cannot be null");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createSpeakerVerificationModel(intRef, voiceProfile.getImpl()));
        return new SpeakerVerificationModel(intRef);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.disposed) {
            return;
        }
        SafeHandle safeHandle = this.speakerVerificationModelHandle;
        if (safeHandle != null) {
            safeHandle.close();
            this.speakerVerificationModelHandle = null;
        }
        this.disposed = true;
    }

    public SafeHandle getImpl() {
        return this.speakerVerificationModelHandle;
    }
}
