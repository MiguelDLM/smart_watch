package com.iflytek.sparkchain.media.player;

import com.iflytek.sparkchain.media.speech.SpeechError;

/* loaded from: classes10.dex */
public interface c {
    void onError(SpeechError speechError);

    void onPause();

    void onPercent(int i, int i2, int i3);

    void onResume();

    void onStop();
}
