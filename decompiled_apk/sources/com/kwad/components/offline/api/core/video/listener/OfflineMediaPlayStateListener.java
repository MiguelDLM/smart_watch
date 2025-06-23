package com.kwad.components.offline.api.core.video.listener;

/* loaded from: classes11.dex */
public interface OfflineMediaPlayStateListener {
    void onMediaPlayCompleted();

    void onMediaPlayError(int i, int i2);

    void onMediaPlayPaused();

    void onMediaPlayProgress(long j, long j2);

    void onMediaPlayStart();

    void onMediaPlaying();

    void onMediaPrepared();

    void onMediaPreparing();
}
