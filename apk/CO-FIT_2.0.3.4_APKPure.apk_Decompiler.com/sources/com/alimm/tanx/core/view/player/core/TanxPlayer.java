package com.alimm.tanx.core.view.player.core;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.alimm.tanx.core.request.TanxPlayerError;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.Map;

public class TanxPlayer implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener, ITanxPlayer {
    private static final String TAG = "TanxPlayer";
    private int bufferPercent;
    private final MediaPlayer mediaPlayer;
    private float mediaPlayerVolume = 1.0f;
    private OnVideoBufferingListener onVideoBufferingListener;
    private OnVideoErrorListener onVideoErrorListener;
    private OnVideoSizeChangeListener onVideoSizeChangeListener;
    private OnVideoStateChangeListener onVideoStateChangeListener;
    private boolean playWhenReady = true;
    private PlayerState playerState = PlayerState.IDLE;
    private String url = "";

    public TanxPlayer() {
        MediaPlayer mediaPlayer2 = new MediaPlayer();
        this.mediaPlayer = mediaPlayer2;
        mediaPlayer2.setScreenOnWhilePlaying(true);
        mediaPlayer2.setOnPreparedListener(this);
        mediaPlayer2.setOnCompletionListener(this);
        mediaPlayer2.setOnBufferingUpdateListener(this);
        mediaPlayer2.setOnSeekCompleteListener(this);
        mediaPlayer2.setOnErrorListener(this);
        mediaPlayer2.setOnInfoListener(this);
        mediaPlayer2.setOnVideoSizeChangedListener(this);
    }

    private void setPlayerState(PlayerState playerState2) {
        LogUtils.d(TAG, playerState2.name());
        this.playerState = playerState2;
        if (playerState2 == PlayerState.PREPARED) {
            this.mediaPlayer.setVideoScalingMode(1);
        }
        OnVideoStateChangeListener onVideoStateChangeListener2 = this.onVideoStateChangeListener;
        if (onVideoStateChangeListener2 != null) {
            onVideoStateChangeListener2.onStateChange(this, playerState2);
        }
    }

    public ITanxPlayer create() {
        return new TanxPlayer();
    }

    public int getBufferPercent() {
        return this.bufferPercent;
    }

    public long getCurrentPosition() {
        try {
            return (long) this.mediaPlayer.getCurrentPosition();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public long getDuration() {
        try {
            return (long) this.mediaPlayer.getDuration();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public PlayerState getState() {
        return this.playerState;
    }

    public String getUrl() {
        return this.url;
    }

    public int getVideoHeight() {
        try {
            return this.mediaPlayer.getVideoHeight();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getVideoWidth() {
        try {
            return this.mediaPlayer.getVideoWidth();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public float getVolume() {
        return this.mediaPlayerVolume;
    }

    public boolean isPlayWhenReady() {
        return this.playWhenReady;
    }

    public boolean isPlaying() {
        try {
            return this.mediaPlayer.isPlaying();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer2, int i) {
        this.bufferPercent = i;
    }

    public void onCompletion(MediaPlayer mediaPlayer2) {
        setPlayerState(PlayerState.COMPLETED);
    }

    public boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
        setPlayerState(PlayerState.ERROR);
        OnVideoErrorListener onVideoErrorListener2 = this.onVideoErrorListener;
        if (onVideoErrorListener2 == null) {
            return true;
        }
        onVideoErrorListener2.onError(this, new TanxPlayerError("playerError", i, i2));
        return true;
    }

    public boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
        OnVideoBufferingListener onVideoBufferingListener2 = this.onVideoBufferingListener;
        if (onVideoBufferingListener2 == null) {
            return false;
        }
        if (i == 701) {
            onVideoBufferingListener2.OnBufferStateChanged(PlayerBufferingState.BUFFERING_START);
            return false;
        }
        onVideoBufferingListener2.OnBufferStateChanged(PlayerBufferingState.BUFFERING_END);
        return false;
    }

    public void onPrepared(MediaPlayer mediaPlayer2) {
        setPlayerState(PlayerState.PREPARED);
    }

    public void onSeekComplete(MediaPlayer mediaPlayer2) {
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer2, int i, int i2) {
        OnVideoSizeChangeListener onVideoSizeChangeListener2 = this.onVideoSizeChangeListener;
        if (onVideoSizeChangeListener2 != null) {
            onVideoSizeChangeListener2.onVideoSizeChanged(this, i, i2);
        }
    }

    public void pause() {
        try {
            this.mediaPlayer.pause();
            setPlayerState(PlayerState.PAUSED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void prepare() {
        try {
            this.mediaPlayer.prepare();
            setPlayerState(PlayerState.PREPARED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void prepareAsync() {
        try {
            this.mediaPlayer.prepareAsync();
            setPlayerState(PlayerState.PREPARING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void release() {
        try {
            this.mediaPlayer.release();
            setPlayerState(PlayerState.END);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reset() {
        try {
            this.mediaPlayer.reset();
            setPlayerState(PlayerState.IDLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void seekTo(long j) {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mediaPlayer.seekTo(j, 3);
            } else {
                this.mediaPlayer.seekTo((int) j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDataSource(Context context, String str) {
        setDataSource(context, Uri.parse(str));
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        try {
            this.mediaPlayer.setDisplay(surfaceHolder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLooping(boolean z) {
        try {
            this.mediaPlayer.setLooping(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setOnVideoBufferingStateChangeListener(OnVideoBufferingListener onVideoBufferingListener2) {
        this.onVideoBufferingListener = onVideoBufferingListener2;
    }

    public void setOnVideoErrorListener(OnVideoErrorListener onVideoErrorListener2) {
        this.onVideoErrorListener = onVideoErrorListener2;
    }

    public void setOnVideoSizeChangeListener(OnVideoSizeChangeListener onVideoSizeChangeListener2) {
        this.onVideoSizeChangeListener = onVideoSizeChangeListener2;
    }

    public void setOnVideoStateChangeListener(OnVideoStateChangeListener onVideoStateChangeListener2) {
        this.onVideoStateChangeListener = onVideoStateChangeListener2;
    }

    public void setPlayWhenReady(boolean z) {
        this.playWhenReady = z;
    }

    public void setSurface(Surface surface) {
        try {
            this.mediaPlayer.setSurface(surface);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setVolume(float f) {
        try {
            this.mediaPlayer.setVolume(f, f);
            this.mediaPlayerVolume = f;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            this.mediaPlayer.start();
            setPlayerState(PlayerState.STARTED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            this.mediaPlayer.stop();
            setPlayerState(PlayerState.STOPPED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDataSource(Context context, Uri uri) {
        setDataSource(context, uri, (Map<String, String>) null);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        try {
            this.mediaPlayer.setDataSource(context, uri, map);
            setPlayerState(PlayerState.INITIALIZED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
