package com.alimm.tanx.core.view.player;

/* loaded from: classes.dex */
public interface ITanxPlayerListener {
    void onVideoCached();

    void onVideoComplete();

    void onVideoError();

    void onVideoInit();

    void onVideoLoading();

    void onVideoPause();

    void onVideoReady(int i);

    void onVideoStart();
}
