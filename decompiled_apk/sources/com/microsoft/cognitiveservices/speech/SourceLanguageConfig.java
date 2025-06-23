package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;

/* loaded from: classes11.dex */
public final class SourceLanguageConfig implements AutoCloseable {
    private SafeHandle configHandle;
    private boolean disposed = false;

    static {
        try {
            Class.forName(SpeechConfig.class.getName());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    private SourceLanguageConfig(long j) {
        this.configHandle = null;
        Contracts.throwIfNull(j, "handleValue");
        this.configHandle = new SafeHandle(j, SafeHandleType.SourceLanguageConfig);
    }

    private static final native long fromLanguage(IntRef intRef, String str);

    public static SourceLanguageConfig fromLanguage(String str) {
        Contracts.throwIfIllegalLanguage(str, "invalid language value");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromLanguage(intRef, str));
        return new SourceLanguageConfig(intRef.getValue());
    }

    private static final native long fromLanguageAndEndpointId(IntRef intRef, String str, String str2);

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.disposed) {
            return;
        }
        SafeHandle safeHandle = this.configHandle;
        if (safeHandle != null) {
            safeHandle.close();
            this.configHandle = null;
        }
        this.disposed = true;
    }

    public SafeHandle getImpl() {
        return this.configHandle;
    }

    public static SourceLanguageConfig fromLanguage(String str, String str2) {
        Contracts.throwIfIllegalLanguage(str, "invalid language value");
        Contracts.throwIfNullOrWhitespace(str2, "endpointId cannot be empty");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromLanguageAndEndpointId(intRef, str, str2));
        return new SourceLanguageConfig(intRef.getValue());
    }
}
