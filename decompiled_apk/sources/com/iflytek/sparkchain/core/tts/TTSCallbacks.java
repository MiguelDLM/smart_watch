package com.iflytek.sparkchain.core.tts;

import com.iflytek.sparkchain.core.tts.TTS;

/* loaded from: classes10.dex */
public interface TTSCallbacks {
    void onError(TTS.TTSError tTSError, Object obj);

    void onEvent(TTS.TTSEvent tTSEvent, Object obj);

    void onResult(TTS.TTSResult tTSResult, Object obj);
}
