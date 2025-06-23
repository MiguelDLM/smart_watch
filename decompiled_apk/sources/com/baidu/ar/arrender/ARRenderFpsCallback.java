package com.baidu.ar.arrender;

/* loaded from: classes7.dex */
public interface ARRenderFpsCallback {
    public static final int LISTEN_RENDER_END = 2;
    public static final int LISTEN_RENDER_FPS = 4;
    public static final int LISTEN_RENDER_START = 1;

    int listenType();

    void onRenderFinished();

    void onRenderStarted();

    void renderFps(int i);
}
