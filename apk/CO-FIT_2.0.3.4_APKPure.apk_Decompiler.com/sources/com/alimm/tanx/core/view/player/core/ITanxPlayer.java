package com.alimm.tanx.core.view.player.core;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.util.Map;

public interface ITanxPlayer {
    ITanxPlayer create();

    int getBufferPercent();

    long getCurrentPosition();

    long getDuration();

    PlayerState getState();

    String getUrl();

    int getVideoHeight();

    int getVideoWidth();

    float getVolume();

    boolean isPlayWhenReady();

    boolean isPlaying();

    void pause();

    void prepare();

    void prepareAsync();

    void release();

    void reset();

    void seekTo(long j);

    void setDataSource(Context context, Uri uri);

    void setDataSource(Context context, Uri uri, Map<String, String> map);

    void setDataSource(Context context, String str);

    void setDisplay(SurfaceHolder surfaceHolder);

    void setLooping(boolean z);

    void setOnVideoBufferingStateChangeListener(OnVideoBufferingListener onVideoBufferingListener);

    void setOnVideoErrorListener(OnVideoErrorListener onVideoErrorListener);

    void setOnVideoSizeChangeListener(OnVideoSizeChangeListener onVideoSizeChangeListener);

    void setOnVideoStateChangeListener(OnVideoStateChangeListener onVideoStateChangeListener);

    void setPlayWhenReady(boolean z);

    void setSurface(Surface surface);

    void setVolume(float f);

    void start();

    void stop();
}
