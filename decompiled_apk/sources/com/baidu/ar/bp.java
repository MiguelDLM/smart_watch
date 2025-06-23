package com.baidu.ar;

import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public interface bp {
    void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j);

    void onAudioRelease();

    void onAudioSetup(boolean z);

    void onAudioStart(boolean z);

    void onAudioStop(boolean z);
}
