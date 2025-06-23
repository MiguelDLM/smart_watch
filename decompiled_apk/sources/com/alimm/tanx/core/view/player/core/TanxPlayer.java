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

/* loaded from: classes.dex */
public class TanxPlayer implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener, ITanxPlayer {
    private static final String TAG = "TanxPlayer";
    private int bufferPercent;
    private final MediaPlayer mediaPlayer;
    private float mediaPlayerVolume;
    private OnVideoBufferingListener onVideoBufferingListener;
    private OnVideoErrorListener onVideoErrorListener;
    private OnVideoSizeChangeListener onVideoSizeChangeListener;
    private OnVideoStateChangeListener onVideoStateChangeListener;
    private boolean playWhenReady;
    private PlayerState playerState;
    private String url;

    public TanxPlayer() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mediaPlayer = mediaPlayer;
        this.url = "";
        this.mediaPlayerVolume = 1.0f;
        this.playWhenReady = true;
        this.playerState = PlayerState.IDLE;
        mediaPlayer.setScreenOnWhilePlaying(true);
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnBufferingUpdateListener(this);
        mediaPlayer.setOnSeekCompleteListener(this);
        mediaPlayer.setOnErrorListener(this);
        mediaPlayer.setOnInfoListener(this);
        mediaPlayer.setOnVideoSizeChangedListener(this);
    }

    private void setPlayerState(PlayerState playerState) {
        LogUtils.d(TAG, playerState.name());
        this.playerState = playerState;
        if (playerState == PlayerState.PREPARED) {
            this.mediaPlayer.setVideoScalingMode(1);
        }
        OnVideoStateChangeListener onVideoStateChangeListener = this.onVideoStateChangeListener;
        if (onVideoStateChangeListener != null) {
            onVideoStateChangeListener.onStateChange(this, playerState);
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public ITanxPlayer create() {
        return new TanxPlayer();
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public int getBufferPercent() {
        return this.bufferPercent;
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public long getCurrentPosition() {
        try {
            return this.mediaPlayer.getCurrentPosition();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public long getDuration() {
        try {
            return this.mediaPlayer.getDuration();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public PlayerState getState() {
        return this.playerState;
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public String getUrl() {
        return this.url;
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public int getVideoHeight() {
        try {
            return this.mediaPlayer.getVideoHeight();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public int getVideoWidth() {
        try {
            return this.mediaPlayer.getVideoWidth();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public float getVolume() {
        return this.mediaPlayerVolume;
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public boolean isPlayWhenReady() {
        return this.playWhenReady;
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public boolean isPlaying() {
        try {
            return this.mediaPlayer.isPlaying();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.bufferPercent = i;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        setPlayerState(PlayerState.COMPLETED);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        setPlayerState(PlayerState.ERROR);
        OnVideoErrorListener onVideoErrorListener = this.onVideoErrorListener;
        if (onVideoErrorListener != null) {
            onVideoErrorListener.onError(this, new TanxPlayerError("playerError", i, i2));
            return true;
        }
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        OnVideoBufferingListener onVideoBufferingListener = this.onVideoBufferingListener;
        if (onVideoBufferingListener != null) {
            if (i == 701) {
                onVideoBufferingListener.OnBufferStateChanged(PlayerBufferingState.BUFFERING_START);
                return false;
            }
            onVideoBufferingListener.OnBufferStateChanged(PlayerBufferingState.BUFFERING_END);
            return false;
        }
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        setPlayerState(PlayerState.PREPARED);
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        OnVideoSizeChangeListener onVideoSizeChangeListener = this.onVideoSizeChangeListener;
        if (onVideoSizeChangeListener != null) {
            onVideoSizeChangeListener.onVideoSizeChanged(this, i, i2);
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void pause() {
        try {
            this.mediaPlayer.pause();
            setPlayerState(PlayerState.PAUSED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void prepare() {
        try {
            this.mediaPlayer.prepare();
            setPlayerState(PlayerState.PREPARED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void prepareAsync() {
        try {
            this.mediaPlayer.prepareAsync();
            setPlayerState(PlayerState.PREPARING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void release() {
        try {
            this.mediaPlayer.release();
            setPlayerState(PlayerState.END);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void reset() {
        try {
            this.mediaPlayer.reset();
            setPlayerState(PlayerState.IDLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
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

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void setDataSource(Context context, String str) {
        setDataSource(context, Uri.parse(str));
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        try {
            this.mediaPlayer.setDisplay(surfaceHolder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void setLooping(boolean z) {
        try {
            this.mediaPlayer.setLooping(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void setOnVideoBufferingStateChangeListener(OnVideoBufferingListener onVideoBufferingListener) {
        this.onVideoBufferingListener = onVideoBufferingListener;
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void setOnVideoErrorListener(OnVideoErrorListener onVideoErrorListener) {
        this.onVideoErrorListener = onVideoErrorListener;
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void setOnVideoSizeChangeListener(OnVideoSizeChangeListener onVideoSizeChangeListener) {
        this.onVideoSizeChangeListener = onVideoSizeChangeListener;
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void setOnVideoStateChangeListener(OnVideoStateChangeListener onVideoStateChangeListener) {
        this.onVideoStateChangeListener = onVideoStateChangeListener;
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void setPlayWhenReady(boolean z) {
        this.playWhenReady = z;
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void setSurface(Surface surface) {
        try {
            this.mediaPlayer.setSurface(surface);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void setVolume(float f) {
        try {
            this.mediaPlayer.setVolume(f, f);
            this.mediaPlayerVolume = f;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void start() {
        try {
            this.mediaPlayer.start();
            setPlayerState(PlayerState.STARTED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void stop() {
        try {
            this.mediaPlayer.stop();
            setPlayerState(PlayerState.STOPPED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void setDataSource(Context context, Uri uri) {
        setDataSource(context, uri, null);
    }

    @Override // com.alimm.tanx.core.view.player.core.ITanxPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        try {
            this.mediaPlayer.setDataSource(context, uri, map);
            setPlayerState(PlayerState.INITIALIZED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
