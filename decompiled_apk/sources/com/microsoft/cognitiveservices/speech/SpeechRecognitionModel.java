package com.microsoft.cognitiveservices.speech;

import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes11.dex */
public class SpeechRecognitionModel implements AutoCloseable {
    private List<String> locales;
    private SafeHandle modelInfoHandle;
    private String name;
    private String path;
    private String version;

    public SpeechRecognitionModel(IntRef intRef) {
        this.modelInfoHandle = null;
        Contracts.throwIfNull(intRef, "modelInfo");
        SafeHandle safeHandle = new SafeHandle(intRef.getValue(), SafeHandleType.SpeechRecognitionModel);
        this.modelInfoHandle = safeHandle;
        this.name = getName(safeHandle);
        String localesString = getLocalesString(this.modelInfoHandle);
        this.locales = localesString.isEmpty() ? new ArrayList<>() : Arrays.asList(localesString.split("\\|"));
        this.path = getPath(this.modelInfoHandle);
        this.version = getVersion(this.modelInfoHandle);
    }

    private final native String getLocalesString(SafeHandle safeHandle);

    private final native String getName(SafeHandle safeHandle);

    private final native String getPath(SafeHandle safeHandle);

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

    public List<String> getLocales() {
        return this.locales;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public String getVersion() {
        return this.version;
    }
}
