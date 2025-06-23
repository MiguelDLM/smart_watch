package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.TelemetryManager;

/* loaded from: classes11.dex */
public final class HybridSpeechConfig implements AutoCloseable {
    SpeechConfig config;
    private boolean disposed = false;

    static {
        try {
            Class.forName(SpeechConfig.class.getName());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    public HybridSpeechConfig(long j) {
        this.config = null;
        this.config = new SpeechConfig(j);
        TelemetryManager.getSingleton();
    }

    private static final native long createHybridSpeechConfig(IntRef intRef, SafeHandle safeHandle, SafeHandle safeHandle2);

    public static final HybridSpeechConfig fromConfigs(SpeechConfig speechConfig, EmbeddedSpeechConfig embeddedSpeechConfig) {
        Contracts.throwIfNull(speechConfig, "cloudSpeechConfig");
        Contracts.throwIfNull(embeddedSpeechConfig, "embeddedSpeechConfig");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createHybridSpeechConfig(intRef, speechConfig.getImpl(), embeddedSpeechConfig.config.getImpl()));
        return new HybridSpeechConfig(intRef.getValue());
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        if (this.disposed) {
            return;
        }
        SpeechConfig speechConfig = this.config;
        if (speechConfig != null) {
            speechConfig.close();
            this.config = null;
        }
        this.disposed = true;
    }

    public SafeHandle getImpl() {
        Contracts.throwIfNull(this.config, "config");
        return this.config.getImpl();
    }

    public String getProperty(PropertyId propertyId) {
        return this.config.getProperty(propertyId);
    }

    public final OutputFormat getSpeechRecognitionOutputFormat() {
        return this.config.getOutputFormat();
    }

    public final String getSpeechSynthesisOutputFormat() {
        return this.config.getSpeechSynthesisOutputFormat();
    }

    public void setProperty(PropertyId propertyId, String str) {
        this.config.setProperty(propertyId, str);
    }

    public final void setSpeechRecognitionOutputFormat(OutputFormat outputFormat) {
        this.config.setOutputFormat(outputFormat);
    }

    public final void setSpeechSynthesisOutputFormat(SpeechSynthesisOutputFormat speechSynthesisOutputFormat) {
        this.config.setSpeechSynthesisOutputFormat(speechSynthesisOutputFormat);
    }

    public String getProperty(String str) {
        return this.config.getProperty(str);
    }

    public void setProperty(String str, String str2) {
        this.config.setProperty(str, str2);
    }
}
