package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes11.dex */
public class SpeechTranslationModel implements AutoCloseable {
    private SafeHandle modelInfoHandle;
    private String name;
    private String path;
    private List<String> sourceLanguages;
    private List<String> targetLanguages;
    private String version;

    public SpeechTranslationModel(IntRef intRef) {
        this.modelInfoHandle = null;
        Contracts.throwIfNull(intRef, "modelInfo");
        SafeHandle safeHandle = new SafeHandle(intRef.getValue(), SafeHandleType.SpeechTranslationModel);
        this.modelInfoHandle = safeHandle;
        this.name = getName(safeHandle);
        String sourceLanguagesString = getSourceLanguagesString(this.modelInfoHandle);
        this.sourceLanguages = sourceLanguagesString.isEmpty() ? new ArrayList<>() : Arrays.asList(sourceLanguagesString.split("\\|"));
        String targetLanguagesString = getTargetLanguagesString(this.modelInfoHandle);
        this.targetLanguages = targetLanguagesString.isEmpty() ? new ArrayList<>() : Arrays.asList(targetLanguagesString.split("\\|"));
        this.path = getPath(this.modelInfoHandle);
        this.version = getVersion(this.modelInfoHandle);
    }

    private final native String getName(SafeHandle safeHandle);

    private final native String getPath(SafeHandle safeHandle);

    private final native String getSourceLanguagesString(SafeHandle safeHandle);

    private final native String getTargetLanguagesString(SafeHandle safeHandle);

    private final native String getVersion(SafeHandle safeHandle);

    @Override // java.lang.AutoCloseable
    public void close() {
        SafeHandle safeHandle = this.modelInfoHandle;
        if (safeHandle != null) {
            safeHandle.close();
            this.modelInfoHandle = null;
        }
    }

    public SafeHandle getImpl() {
        return this.modelInfoHandle;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public List<String> getSourceLanguages() {
        return this.sourceLanguages;
    }

    public List<String> getTargetLanguages() {
        return this.targetLanguages;
    }

    public String getVersion() {
        return this.version;
    }
}
