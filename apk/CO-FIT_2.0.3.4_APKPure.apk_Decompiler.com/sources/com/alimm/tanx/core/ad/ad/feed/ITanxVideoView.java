package com.alimm.tanx.core.ad.ad.feed;

import android.view.View;

public interface ITanxVideoView {
    void destroy();

    View getVideoAdView(ITanxFeedVideoAdListener iTanxFeedVideoAdListener);

    boolean isMute();

    void mute();

    void pause();

    void play();

    void replay();

    void resumeVolume();

    void setVolume(int i);
}
