package com.kwad.components.offline.api.core.video;

/* loaded from: classes11.dex */
public interface IKsMediaPlayerView {

    /* loaded from: classes11.dex */
    public interface VideoViewClickListener {
        void onClickRootView();

        void onClickVideoView();
    }

    void adaptVideoSize(int i, int i2);

    void fixWidth(boolean z);

    int getTextureViewGravity();

    void setAd(boolean z);

    void setClickListener(VideoViewClickListener videoViewClickListener);

    void setForce(boolean z);

    void setHorizontalVideo(boolean z);

    void setMediaPlayer(IKsMediaPlayer iKsMediaPlayer);

    void setRadius(float f);

    void updateTextureViewGravity(int i);
}
