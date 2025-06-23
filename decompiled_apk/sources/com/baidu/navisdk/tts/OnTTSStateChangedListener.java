package com.baidu.navisdk.tts;

/* loaded from: classes7.dex */
public interface OnTTSStateChangedListener {
    void onPlayEnd(String str);

    void onPlayError(int i, String str);

    void onPlayStart();
}
