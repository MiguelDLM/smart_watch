package com.iflytek.sparkchain.core;

import java.util.List;

/* loaded from: classes10.dex */
public interface AiListener {
    void onError(int i, int i2, String str, Object obj);

    void onEvent(int i, int i2, List<AiResponse> list, Object obj);

    void onResult(int i, List<AiResponse> list, Object obj);
}
