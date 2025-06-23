package com.microsoft.cognitiveservices.speech.transcription;

import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import com.microsoft.cognitiveservices.speech.util.StringRef;

/* loaded from: classes11.dex */
public final class User implements AutoCloseable {
    private SafeHandle userHandle;

    static {
        try {
            Class.forName(SpeechConfig.class.getName());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    public User(long j) {
        this.userHandle = new SafeHandle(j, SafeHandleType.User);
    }

    private static final native long createFromUserId(String str, IntRef intRef);

    public static User fromUserId(String str) {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createFromUserId(str, intRef));
        return new User(intRef.getValue());
    }

    private final native long getId(SafeHandle safeHandle, StringRef stringRef);

    @Override // java.lang.AutoCloseable
    public void close() {
        SafeHandle safeHandle = this.userHandle;
        if (safeHandle != null) {
            safeHandle.close();
        }
        this.userHandle = null;
    }

    public String getId() {
        StringRef stringRef = new StringRef("");
        Contracts.throwIfFail(getId(this.userHandle, stringRef));
        return stringRef.getValue();
    }

    public SafeHandle getImpl() {
        return this.userHandle;
    }
}
