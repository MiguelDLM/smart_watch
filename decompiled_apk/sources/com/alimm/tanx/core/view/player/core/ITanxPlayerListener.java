package com.alimm.tanx.core.view.player.core;

/* loaded from: classes.dex */
public interface ITanxPlayerListener {
    void onComplete();

    void onEndBuffering();

    void onError(Exception exc);

    void onPause();

    void onRelease();

    void onStart();

    void onStartBuffering();

    void onStop();
}
