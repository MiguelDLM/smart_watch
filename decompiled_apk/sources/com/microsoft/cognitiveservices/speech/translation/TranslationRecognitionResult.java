package com.microsoft.cognitiveservices.speech.translation;

import com.microsoft.cognitiveservices.speech.RecognitionResult;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.StringMapRef;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes11.dex */
public class TranslationRecognitionResult extends RecognitionResult {
    private Map<String, String> translations;

    public TranslationRecognitionResult(long j) {
        super(j);
        Contracts.throwIfNull(super.getImpl(), "resultHandle");
        StringMapRef stringMapRef = new StringMapRef();
        Contracts.throwIfFail(getTranslations(super.getImpl(), stringMapRef));
        this.translations = new HashMap();
        if (stringMapRef.getValue().isEmpty()) {
            return;
        }
        this.translations.putAll(stringMapRef.getValue());
    }

    private final native long getTranslations(SafeHandle safeHandle, StringMapRef stringMapRef);

    public final Map<String, String> getTranslations() {
        return this.translations;
    }

    public String toString() {
        String str = "ResultId:" + getResultId() + " Reason:" + getReason() + ", Recognized text:<" + getText() + ">.\n";
        for (String str2 : this.translations.keySet()) {
            str = str + "    Translation in " + str2 + ": <" + this.translations.get(str2) + ">.\n";
        }
        return str;
    }
}
