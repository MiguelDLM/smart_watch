package com.iflytek.sparkchain.core;

/* loaded from: classes10.dex */
public interface ChatListener {
    void onChatError(AIChatHandle aIChatHandle, int i, String str);

    void onChatOutput(AIChatHandle aIChatHandle, String str, String str2, String str3, int i);

    void onChatToken(AIChatHandle aIChatHandle, int i, int i2, int i3);
}
