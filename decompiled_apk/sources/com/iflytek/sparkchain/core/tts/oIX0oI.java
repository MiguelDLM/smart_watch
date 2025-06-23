package com.iflytek.sparkchain.core.tts;

import android.util.Log;
import com.iflytek.sparkchain.core.tts.TTS;

/* loaded from: classes10.dex */
public final /* synthetic */ class oIX0oI {
    public static void oIX0oI(TTSCallbacks tTSCallbacks, TTS.TTSEvent tTSEvent, Object obj) {
        Log.v("TTSCallbacks", "default   onEvent:" + tTSEvent.getPhoneme() + "," + tTSEvent.getType());
    }
}
