package com.iflytek.sparkchain.media.record;

import com.iflytek.sparkchain.media.speech.SpeechError;

/* loaded from: classes10.dex */
public interface b {
    void onBuffer(byte[] bArr, int i, int i2);

    void onDecibel(int i);

    void onError(SpeechError speechError);

    void onRelease();

    void onStart(boolean z);
}
