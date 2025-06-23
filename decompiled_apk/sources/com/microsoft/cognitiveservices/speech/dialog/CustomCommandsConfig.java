package com.microsoft.cognitiveservices.speech.dialog;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.openalliance.ad.uriaction.i;
import com.microsoft.cognitiveservices.speech.PropertyId;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;

/* loaded from: classes11.dex */
public final class CustomCommandsConfig extends DialogServiceConfig {
    private CustomCommandsConfig(long j) {
        super(j);
    }

    private static final native long fromAuthorizationToken(IntRef intRef, String str, String str2, String str3);

    public static CustomCommandsConfig fromAuthorizationToken(String str, String str2, String str3) {
        Contracts.throwIfNull(str, i.Code);
        Contracts.throwIfNullOrWhitespace(str2, "authorizationToken");
        Contracts.throwIfNullOrWhitespace(str3, TtmlNode.TAG_REGION);
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromAuthorizationToken(intRef, str, str2, str3));
        return new CustomCommandsConfig(intRef.getValue());
    }

    private static final native long fromSubscription(IntRef intRef, String str, String str2, String str3);

    public static CustomCommandsConfig fromSubscription(String str, String str2, String str3) {
        Contracts.throwIfNull(str, i.Code);
        Contracts.throwIfNull(str2, "subscription");
        Contracts.throwIfNull(str3, TtmlNode.TAG_REGION);
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromSubscription(intRef, str, str2, str3));
        return new CustomCommandsConfig(intRef.getValue());
    }

    public String getApplicationId() {
        return getProperty(PropertyId.Conversation_ApplicationId);
    }

    public void setApplicationId(String str) {
        setProperty(PropertyId.Conversation_ApplicationId, str);
    }
}
