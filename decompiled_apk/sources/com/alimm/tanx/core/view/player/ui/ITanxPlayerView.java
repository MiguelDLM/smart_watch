package com.alimm.tanx.core.view.player.ui;

import android.net.Uri;
import com.alimm.tanx.core.view.player.VideoScaleMode;
import com.alimm.tanx.core.view.player.core.ITanxPlayer;
import com.alimm.tanx.core.view.player.core.PlayerState;
import java.util.Map;

/* loaded from: classes.dex */
public interface ITanxPlayerView {
    void attach();

    long currentPosition();

    long duration();

    int getCurrentPosition();

    int getDuration();

    PlayerState getState();

    boolean isPlaying();

    void mute();

    void pause();

    void prepare();

    void release();

    void replay();

    void reset();

    void resumeVolume();

    void seekTo(long j);

    void setCover(String str);

    void setDataSource(Uri uri);

    void setDataSource(Uri uri, Map<String, String> map);

    void setDataSource(String str);

    void setTanxPlayer(ITanxPlayer iTanxPlayer);

    void setVideoScaleMode(VideoScaleMode videoScaleMode);

    void setVolume(int i);

    void start();

    void stop();

    int videoHeight();

    int videoWidth();
}
