package com.iflytek.sparkchain.core;

/* loaded from: classes10.dex */
public interface LLMCallbacks {
    void onLLMError(LLMError lLMError, Object obj);

    void onLLMEvent(LLMEvent lLMEvent, Object obj);

    void onLLMResult(LLMResult lLMResult, Object obj);
}
