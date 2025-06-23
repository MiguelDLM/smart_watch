package com.iflytek.sparkchain.core.rtasr;

import com.iflytek.sparkchain.core.rtasr.RTASR;

/* loaded from: classes10.dex */
public interface RTASRCallbacks {
    void onBeginOfSpeech();

    void onEndOfSpeech();

    void onError(RTASR.RtAsrError rtAsrError, Object obj);

    void onResult(RTASR.RtAsrResult rtAsrResult, Object obj);
}
