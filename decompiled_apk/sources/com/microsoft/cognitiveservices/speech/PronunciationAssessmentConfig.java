package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;

/* loaded from: classes11.dex */
public final class PronunciationAssessmentConfig implements AutoCloseable {
    private SafeHandle configHandle;
    private boolean disposed;
    private PropertyCollection propertyHandle;

    static {
        try {
            Class.forName(SpeechConfig.class.getName());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    private PronunciationAssessmentConfig(long j) {
        this.configHandle = null;
        this.propertyHandle = null;
        this.disposed = false;
        init(j);
    }

    private final native long applyTo(SafeHandle safeHandle, SafeHandle safeHandle2);

    private static final native long create(IntRef intRef, String str, int i, int i2, boolean z);

    private static final native long fromJson(IntRef intRef, String str);

    public static PronunciationAssessmentConfig fromJson(String str) {
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromJson(intRef, str));
        return new PronunciationAssessmentConfig(intRef.getValue());
    }

    private final native long getPropertyBag(SafeHandle safeHandle, IntRef intRef);

    private void init(long j) {
        Contracts.throwIfNull(j, "handleValue");
        this.configHandle = new SafeHandle(j, SafeHandleType.PronunciationAssessmentConfig);
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(getPropertyBag(this.configHandle, intRef));
        this.propertyHandle = new PropertyCollection(intRef);
    }

    private final native String toJson(SafeHandle safeHandle);

    public void applyTo(Recognizer recognizer) {
        Contracts.throwIfNull(this.configHandle, "configHandle");
        Contracts.throwIfNull(recognizer, "recognizer");
        Contracts.throwIfNull(recognizer.getImpl(), "recoHandle");
        applyTo(this.configHandle, recognizer.getImpl());
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.disposed) {
            return;
        }
        PropertyCollection propertyCollection = this.propertyHandle;
        if (propertyCollection != null) {
            propertyCollection.close();
            this.propertyHandle = null;
        }
        SafeHandle safeHandle = this.configHandle;
        if (safeHandle != null) {
            safeHandle.close();
            this.configHandle = null;
        }
        this.disposed = true;
    }

    public void enableContentAssessmentWithTopic(String str) {
        Contracts.throwIfNull(str, "topic");
        this.propertyHandle.setProperty(PropertyId.PronunciationAssessment_ContentTopic, str);
    }

    public void enableProsodyAssessment() {
        this.propertyHandle.setProperty(PropertyId.PronunciationAssessment_EnableProsodyAssessment, "true");
    }

    public SafeHandle getImpl() {
        return this.configHandle;
    }

    public String getReferenceText() {
        return this.propertyHandle.getProperty(PropertyId.PronunciationAssessment_ReferenceText);
    }

    public void setNBestPhonemeCount(int i) {
        this.propertyHandle.setProperty(PropertyId.PronunciationAssessment_NBestPhonemeCount, String.valueOf(i));
    }

    public void setPhonemeAlphabet(String str) {
        Contracts.throwIfNull(str, "value");
        this.propertyHandle.setProperty(PropertyId.PronunciationAssessment_PhonemeAlphabet, str);
    }

    public void setReferenceText(String str) {
        Contracts.throwIfNull(str, "value");
        this.propertyHandle.setProperty(PropertyId.PronunciationAssessment_ReferenceText, str);
    }

    public String toJson() {
        Contracts.throwIfNull(this.configHandle, "configHandle");
        return toJson(this.configHandle);
    }

    public PronunciationAssessmentConfig(String str) {
        this(str, PronunciationAssessmentGradingSystem.FivePoint, PronunciationAssessmentGranularity.Phoneme);
    }

    public PronunciationAssessmentConfig(String str, PronunciationAssessmentGradingSystem pronunciationAssessmentGradingSystem, PronunciationAssessmentGranularity pronunciationAssessmentGranularity) {
        this(str, pronunciationAssessmentGradingSystem, pronunciationAssessmentGranularity, false);
    }

    public PronunciationAssessmentConfig(String str, PronunciationAssessmentGradingSystem pronunciationAssessmentGradingSystem, PronunciationAssessmentGranularity pronunciationAssessmentGranularity, boolean z) {
        this.configHandle = null;
        this.propertyHandle = null;
        this.disposed = false;
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(create(intRef, str, pronunciationAssessmentGradingSystem.getValue(), pronunciationAssessmentGranularity.getValue(), z));
        init(intRef.getValue());
    }
}
