package com.microsoft.cognitiveservices.speech.dialog;

import com.microsoft.cognitiveservices.speech.PropertyId;
import com.microsoft.cognitiveservices.speech.ServicePropertyChannel;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;

/* loaded from: classes11.dex */
public class DialogServiceConfig extends SpeechConfig implements AutoCloseable {
    private boolean disposed;

    static {
        try {
            Class.forName(SpeechConfig.class.getName());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    public DialogServiceConfig(long j) {
        super(j);
        this.disposed = false;
    }

    @Override // com.microsoft.cognitiveservices.speech.SpeechConfig, java.lang.AutoCloseable
    public void close() {
        if (this.disposed) {
            return;
        }
        super.close();
        this.disposed = true;
    }

    @Override // com.microsoft.cognitiveservices.speech.SpeechConfig
    public SafeHandle getImpl() {
        return super.getImpl();
    }

    public String getLanguage() {
        return getSpeechRecognitionLanguage();
    }

    @Override // com.microsoft.cognitiveservices.speech.SpeechConfig
    public String getProperty(PropertyId propertyId) {
        return super.getProperty(propertyId);
    }

    public void setLanguage(String str) {
        setSpeechRecognitionLanguage(str);
    }

    @Override // com.microsoft.cognitiveservices.speech.SpeechConfig
    public void setProperty(PropertyId propertyId, String str) {
        super.setProperty(propertyId, str);
    }

    @Override // com.microsoft.cognitiveservices.speech.SpeechConfig
    public void setProxy(String str, int i, String str2, String str3) {
        super.setProxy(str, i, str2, str3);
    }

    @Override // com.microsoft.cognitiveservices.speech.SpeechConfig
    public void setServiceProperty(String str, String str2, ServicePropertyChannel servicePropertyChannel) {
        super.setServiceProperty(str, str2, servicePropertyChannel);
    }

    @Override // com.microsoft.cognitiveservices.speech.SpeechConfig
    public String getProperty(String str) {
        return super.getProperty(str);
    }

    @Override // com.microsoft.cognitiveservices.speech.SpeechConfig
    public void setProperty(String str, String str2) {
        super.setProperty(str, str2);
    }
}
