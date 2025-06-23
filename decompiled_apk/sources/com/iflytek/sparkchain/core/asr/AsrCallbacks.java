package com.iflytek.sparkchain.core.asr;

import com.iflytek.sparkchain.core.asr.ASR;

/* loaded from: classes10.dex */
public interface AsrCallbacks {
    void onBeginOfSpeech();

    void onEndOfSpeech();

    void onError(ASR.ASRError aSRError, Object obj);

    void onResult(ASR.ASRResult aSRResult, Object obj);
}
