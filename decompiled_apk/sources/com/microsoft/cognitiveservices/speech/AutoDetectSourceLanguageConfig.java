package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import java.util.List;

/* loaded from: classes11.dex */
public final class AutoDetectSourceLanguageConfig implements AutoCloseable {
    private SafeHandle configHandle;
    private boolean disposed = false;

    static {
        try {
            Class.forName(SpeechConfig.class.getName());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    private AutoDetectSourceLanguageConfig(long j) {
        this.configHandle = null;
        Contracts.throwIfNull(j, "handleValue");
        this.configHandle = new SafeHandle(j, SafeHandleType.AutoDetectSourceLanguageConfig);
    }

    private static final native long addSourceLangConfigToAutoDetectSourceLangConfig(IntRef intRef, SafeHandle safeHandle);

    private static final native long createFromSourceLangConfig(IntRef intRef, SafeHandle safeHandle);

    private static final native long fromLanguages(IntRef intRef, String str);

    public static AutoDetectSourceLanguageConfig fromLanguages(List<String> list) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("languages cannot be null or empty");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(",");
            }
        }
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromLanguages(intRef, sb.toString()));
        return new AutoDetectSourceLanguageConfig(intRef.getValue());
    }

    private static final native long fromOpenRange(IntRef intRef);

    public static AutoDetectSourceLanguageConfig fromOpenRange() {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromOpenRange(intRef));
        return new AutoDetectSourceLanguageConfig(intRef.getValue());
    }

    public static AutoDetectSourceLanguageConfig fromSourceLanguageConfigs(List<SourceLanguageConfig> list) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("sourceLanguageConfigs cannot be null or empty");
        }
        IntRef intRef = new IntRef(0L);
        boolean z = true;
        for (SourceLanguageConfig sourceLanguageConfig : list) {
            Contracts.throwIfNull(sourceLanguageConfig, "sourceLanguageConfig cannot be null");
            if (z) {
                Contracts.throwIfFail(createFromSourceLangConfig(intRef, sourceLanguageConfig.getImpl()));
                z = false;
            } else {
                Contracts.throwIfFail(addSourceLangConfigToAutoDetectSourceLangConfig(intRef, sourceLanguageConfig.getImpl()));
            }
        }
        return new AutoDetectSourceLanguageConfig(intRef.getValue());
    }

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
}
