package com.iflytek.sparkchain.media;

import android.content.Context;
import com.iflytek.sparkchain.media.player.c;

/* loaded from: classes10.dex */
public interface MediaPlayerHelper {
    void init(Context context, c cVar);

    boolean isPlaying();

    void pause();

    void play();

    void release();

    void resume();

    void stop();
}
