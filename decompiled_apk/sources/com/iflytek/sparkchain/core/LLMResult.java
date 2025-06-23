package com.iflytek.sparkchain.core;

/* loaded from: classes10.dex */
public interface LLMResult extends LLMBaseOutput {
    int getCompletionTokens();

    String getContent();

    String getFunctionCall();

    byte[] getImage();

    int getPromptTokens();

    String getRaw();

    String getRole();

    int getStatus();

    int getTotalTokens();
}
