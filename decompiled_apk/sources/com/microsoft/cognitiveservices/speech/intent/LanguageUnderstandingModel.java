package com.microsoft.cognitiveservices.speech.intent;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.openalliance.ad.uriaction.i;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;
import com.microsoft.cognitiveservices.speech.util.KeyedItem;
import com.microsoft.cognitiveservices.speech.util.SafeHandle;
import com.microsoft.cognitiveservices.speech.util.SafeHandleType;

/* loaded from: classes11.dex */
public class LanguageUnderstandingModel implements KeyedItem {
    private SafeHandle modelHandle;
    protected String modelId;

    static {
        try {
            Class.forName(SpeechConfig.class.getName());
        } catch (ClassNotFoundException unused) {
        }
    }

    public LanguageUnderstandingModel() {
        this.modelHandle = null;
    }

    private static final native long createModelFromAppId(IntRef intRef, String str);

    private static final native long createModelFromSubscription(IntRef intRef, String str, String str2, String str3);

    private static final native long createModelFromUri(IntRef intRef, String str);

    public static LanguageUnderstandingModel fromAppId(String str) {
        Contracts.throwIfNullOrWhitespace(str, i.Code);
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createModelFromAppId(intRef, str));
        return new LanguageUnderstandingModel(intRef);
    }

    public static LanguageUnderstandingModel fromEndpoint(String str) {
        Contracts.throwIfNullOrWhitespace(str, "uri");
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createModelFromUri(intRef, str));
        return new LanguageUnderstandingModel(intRef);
    }

    public static LanguageUnderstandingModel fromSubscription(String str, String str2, String str3) {
        Contracts.throwIfNullOrWhitespace(str, "subscriptionKey");
        Contracts.throwIfNullOrWhitespace(str2, i.Code);
        Contracts.throwIfNullOrWhitespace(str3, TtmlNode.TAG_REGION);
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(createModelFromSubscription(intRef, str, str2, str3));
        return new LanguageUnderstandingModel(intRef);
    }

    private static final native String languageUnderstandingModelGetModelId(SafeHandle safeHandle);

    @Override // com.microsoft.cognitiveservices.speech.util.KeyedItem
    public String getId() {
        return this.modelId;
    }

    public SafeHandle getImpl() {
        return this.modelHandle;
    }

    public void setId(String str) {
        this.modelId = str;
    }

    public LanguageUnderstandingModel(IntRef intRef) {
        this.modelHandle = null;
        Contracts.throwIfNull(intRef, "model");
        SafeHandle safeHandle = new SafeHandle(intRef.getValue(), SafeHandleType.LanguageUnderstandingModel);
        this.modelHandle = safeHandle;
        this.modelId = languageUnderstandingModelGetModelId(safeHandle);
    }
}
