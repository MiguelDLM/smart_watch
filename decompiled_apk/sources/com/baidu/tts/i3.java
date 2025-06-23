package com.baidu.tts;

import com.baidu.tts.aop.tts.TtsError;

/* loaded from: classes8.dex */
public interface i3 {
    TtsError create();

    void destroy();

    void pause();

    void resume();

    void start();

    void stop();
}
