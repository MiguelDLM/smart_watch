package com.microsoft.cognitiveservices.speech.dialog;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.microsoft.cognitiveservices.speech.util.Contracts;
import com.microsoft.cognitiveservices.speech.util.IntRef;

/* loaded from: classes11.dex */
public final class BotFrameworkConfig extends DialogServiceConfig {
    private BotFrameworkConfig(long j) {
        super(j);
    }

    private static final native long fromAuthorizationToken(IntRef intRef, String str, String str2, String str3);

    public static BotFrameworkConfig fromAuthorizationToken(String str, String str2) {
        Contracts.throwIfNullOrWhitespace(str, "authorizationToken");
        Contracts.throwIfNullOrWhitespace(str2, TtmlNode.TAG_REGION);
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromAuthorizationToken(intRef, str, str2, null));
        return new BotFrameworkConfig(intRef.getValue());
    }

    private static final native long fromSubscription(IntRef intRef, String str, String str2, String str3);

    public static BotFrameworkConfig fromSubscription(String str, String str2) {
        Contracts.throwIfNull(str, "subscription");
        Contracts.throwIfNull(str2, TtmlNode.TAG_REGION);
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromSubscription(intRef, str, str2, null));
        return new BotFrameworkConfig(intRef.getValue());
    }

    public static BotFrameworkConfig fromAuthorizationToken(String str, String str2, String str3) {
        Contracts.throwIfNullOrWhitespace(str, "authorizationToken");
        Contracts.throwIfNullOrWhitespace(str2, TtmlNode.TAG_REGION);
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromAuthorizationToken(intRef, str, str2, str3));
        return new BotFrameworkConfig(intRef.getValue());
    }

    public static BotFrameworkConfig fromSubscription(String str, String str2, String str3) {
        Contracts.throwIfNull(str, "subscription");
        Contracts.throwIfNull(str2, TtmlNode.TAG_REGION);
        IntRef intRef = new IntRef(0L);
        Contracts.throwIfFail(fromSubscription(intRef, str, str2, str3));
        return new BotFrameworkConfig(intRef.getValue());
    }
}
