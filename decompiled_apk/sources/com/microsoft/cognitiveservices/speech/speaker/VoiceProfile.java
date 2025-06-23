package com.microsoft.cognitiveservices.speech.speaker;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import com.microsoft.cognitiveservices.speech.util.StringRef;

/* loaded from: classes11.dex */
public final class VoiceProfile implements AutoCloseable {
    private boolean disposed = false;
    private SafeHandle voiceProfileHandle;

    public VoiceProfile(long j) {
        this.voiceProfileHandle = null;
        Contracts.throwIfNull(j, "handle");
        this.voiceProfileHandle = new SafeHandle(j, SafeHandleType.VoiceProfile);
    }

    private final native long createVoiceProfileFromIdAndType(String str, int i, IntRef intRef);

    private final native long getId(SafeHandle safeHandle, StringRef stringRef);

    private final native long getType(SafeHandle safeHandle, IntRef intRef);

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.disposed) {
            return;
        }
        SafeHandle safeHandle = this.voiceProfileHandle;
        if (safeHandle != null) {
            safeHandle.close();
            this.voiceProfileHandle = null;
        }
        this.disposed = true;
    }

    public String getId() {
        StringRef stringRef = new StringRef("");
        Contracts.throwIfFail(getId(this.voiceProfileHandle, stringRef));
        return stringRef.getValue();
    }

    public SafeHandle getImpl() {
        return this.voiceProfileHandle;
    }

    public VoiceProfileType getType() {
        Contracts.throwIfFail(getType(this.voiceProfileHandle, new IntRef(0L)));
        return VoiceProfileType.values()[((int) r0.getValue()) - 1];
    }

    public VoiceProfile(String str, VoiceProfileType voiceProfileType) {
        this.voiceProfileHandle = null;
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createVoiceProfileFromIdAndType(str, voiceProfileType.getValue(), intRef));
        this.voiceProfileHandle = new SafeHandle(intRef.getValue(), SafeHandleType.VoiceProfile);
    }
}
