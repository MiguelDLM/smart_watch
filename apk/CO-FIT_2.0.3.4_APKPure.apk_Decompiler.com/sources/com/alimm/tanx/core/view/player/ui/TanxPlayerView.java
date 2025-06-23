package com.alimm.tanx.core.view.player.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.image.ImageManager;
import com.alimm.tanx.core.image.util.ImageConfig;
import com.alimm.tanx.core.image.util.ScaleMode;
import com.alimm.tanx.core.image.util.TanxDrawable;
import com.alimm.tanx.core.request.TanxPlayerError;
import com.alimm.tanx.core.ut.core.thread.VideoSizeThreadPool;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.view.player.VideoScaleMode;
import com.alimm.tanx.core.view.player.core.ITanxPlayer;
import com.alimm.tanx.core.view.player.core.OnVideoBufferingListener;
import com.alimm.tanx.core.view.player.core.OnVideoErrorListener;
import com.alimm.tanx.core.view.player.core.OnVideoSizeChangeListener;
import com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener;
import com.alimm.tanx.core.view.player.core.PlayerBufferingState;
import com.alimm.tanx.core.view.player.core.PlayerState;
import com.alimm.tanx.core.view.player.core.audio.IAudioManager;
import com.alimm.tanx.core.view.player.core.audio.MediaPlayerAudioManager;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class TanxPlayerView extends TanxAdView implements TextureView.SurfaceTextureListener, NotConfused, ITanxPlayerView {
    private static final String TAG = "TanxPlayerView";
    /* access modifiers changed from: private */
    public IAudioManager audioManager;
    private String coverUrl;
    /* access modifiers changed from: private */
    public ImageView coverView;
    /* access modifiers changed from: private */
    public Bitmap firstFrame;
    private ITanxPlayer iTanxPlayer;
    private Matrix matrix;
    /* access modifiers changed from: private */
    public OnVideoBufferingListener onVideoBufferingListener;
    /* access modifiers changed from: private */
    public OnVideoErrorListener onVideoErrorListener;
    /* access modifiers changed from: private */
    public OnVideoStateChangeListener onVideoStateChangeListener;
    private Surface surface;
    private boolean surfaceIsDestroy;
    private SurfaceTexture surfaceTexture;
    private TextureView textureView;
    private VideoScaleMode videoScaleMode;
    private String videoUrl;

    public interface IVideoThumb {
        void getBitmap(Bitmap bitmap);
    }

    public TanxPlayerView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean inState(PlayerState... playerStateArr) {
        PlayerState state = getState();
        for (PlayerState playerState : playerStateArr) {
            if (state == playerState) {
                return true;
            }
        }
        return false;
    }

    private void init() {
        this.audioManager = new MediaPlayerAudioManager(getContext(), this.iTanxPlayer);
        ImageView imageView = new ImageView(getContext());
        this.coverView = imageView;
        imageView.setVisibility(8);
        TextureView textureView2 = new TextureView(getContext());
        this.textureView = textureView2;
        textureView2.setSurfaceTextureListener(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        addView(this.textureView, layoutParams);
        addView(this.coverView, layoutParams);
    }

    /* access modifiers changed from: private */
    public void loadImg(boolean z) {
        final long currentTimeMillis = System.currentTimeMillis();
        final ImageConfig build = ImageManager.with(getContext()).url(this.coverUrl).scaleMode(ScaleMode.FIT_CENTER).build();
        if (z) {
            loadFrameImg(this.videoUrl, new IVideoThumb() {
                public void getBitmap(final Bitmap bitmap) {
                    if (bitmap != null) {
                        TanxPlayerView.this.coverView.post(new Runnable() {
                            public void run() {
                                TanxPlayerView.this.coverView.setImageDrawable(new TanxDrawable(bitmap, build.getImageConfig()));
                                LogUtils.d(TanxPlayerView.TAG, "耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                            }
                        });
                    }
                }
            });
        } else if (!TextUtils.isEmpty(this.coverUrl) && ImageManager.getLoader() != null) {
            ImageManager.getLoader().load(build, new ImageConfig.ImageBitmapCallback() {
                public void onFailure(String str) {
                    TanxPlayerView.this.coverView.setVisibility(8);
                }

                public void onSuccess(Bitmap bitmap) {
                    TanxPlayerView.this.coverView.setImageDrawable(new TanxDrawable(bitmap, build.getImageConfig()));
                }
            });
        }
    }

    private void registerMediaPlayerObserver(final ITanxPlayer iTanxPlayer2) {
        iTanxPlayer2.setOnVideoStateChangeListener(new OnVideoStateChangeListener() {
            public void onStateChange(ITanxPlayer iTanxPlayer, PlayerState playerState) {
                LogUtils.d(TanxPlayerView.TAG, "onStateChange:" + playerState.name());
                if (playerState == PlayerState.PREPARED) {
                    TanxPlayerView.this.loadImg(true);
                    TanxPlayerView.this.coverView.setVisibility(8);
                    ITanxPlayer iTanxPlayer2 = iTanxPlayer2;
                    iTanxPlayer2.seekTo(iTanxPlayer2.getCurrentPosition());
                    if (iTanxPlayer2.isPlayWhenReady()) {
                        iTanxPlayer2.start();
                    }
                    TanxPlayerView.this.setBackgroundResource(R.color.transparent);
                } else if (playerState == PlayerState.STARTED) {
                    TanxPlayerView.this.coverView.setVisibility(8);
                    TanxPlayerView.this.loadWeb();
                    ITanxPlayer iTanxPlayer3 = iTanxPlayer2;
                    if (!(iTanxPlayer3 == null || iTanxPlayer3.getVolume() <= 0.0f || TanxPlayerView.this.audioManager == null)) {
                        TanxPlayerView.this.audioManager.requestAudioFocus();
                    }
                    LogUtils.d(TanxPlayerView.TAG, " getVolume:" + iTanxPlayer2.getVolume());
                } else if (playerState == PlayerState.COMPLETED) {
                    TanxPlayerView.this.loadImg(false);
                    TanxPlayerView.this.coverView.setVisibility(0);
                } else if (playerState == PlayerState.STOPPED || playerState == PlayerState.END) {
                    TanxPlayerView.this.audioManager.abandonAudioFocus();
                } else if (playerState == PlayerState.ERROR) {
                    TanxPlayerView.this.audioManager.abandonAudioFocus();
                    TanxPlayerView.this.loadImg(false);
                    TanxPlayerView.this.coverView.setVisibility(0);
                }
                if (TanxPlayerView.this.onVideoStateChangeListener != null) {
                    TanxPlayerView.this.onVideoStateChangeListener.onStateChange(iTanxPlayer, playerState);
                }
            }
        });
        iTanxPlayer2.setOnVideoBufferingStateChangeListener(new OnVideoBufferingListener() {
            public void OnBufferStateChanged(PlayerBufferingState playerBufferingState) {
                if (TanxPlayerView.this.onVideoBufferingListener != null) {
                    TanxPlayerView.this.onVideoBufferingListener.OnBufferStateChanged(playerBufferingState);
                }
            }
        });
        iTanxPlayer2.setOnVideoErrorListener(new OnVideoErrorListener() {
            public boolean onError(ITanxPlayer iTanxPlayer, TanxPlayerError tanxPlayerError) {
                if (TanxPlayerView.this.onVideoErrorListener == null) {
                    return false;
                }
                TanxPlayerView.this.onVideoErrorListener.onError(iTanxPlayer, tanxPlayerError);
                return false;
            }
        });
        iTanxPlayer2.setOnVideoSizeChangeListener(new OnVideoSizeChangeListener() {
            public void onVideoSizeChanged(ITanxPlayer iTanxPlayer, int i, int i2) {
                Log.d(TanxPlayerView.TAG, "onVideoSizeChanged, width=" + i + "," + "height=" + i2);
                TanxPlayerView.this.transformVideo(i, i2);
            }
        });
    }

    private void removeMediaPlayerObserver(ITanxPlayer iTanxPlayer2) {
        iTanxPlayer2.setOnVideoStateChangeListener((OnVideoStateChangeListener) null);
        iTanxPlayer2.setOnVideoBufferingStateChangeListener((OnVideoBufferingListener) null);
        iTanxPlayer2.setOnVideoErrorListener((OnVideoErrorListener) null);
        iTanxPlayer2.setOnVideoSizeChangeListener((OnVideoSizeChangeListener) null);
        this.audioManager.abandonAudioFocus();
    }

    /* access modifiers changed from: private */
    public void transformVideo(int i, int i2) {
        if (getHeight() == 0 || getWidth() == 0) {
            Log.d(TAG, "transformVideo, getHeight=" + getHeight() + "," + "getWidth=" + getWidth());
            return;
        }
        Log.d(TAG, "transformVideo, getMeasuredWidth=" + getMeasuredWidth() + " getMeasuredHeight=" + getMeasuredHeight());
        Log.d(TAG, "transformVideo, getWidth=" + getWidth() + " getHeight=" + getHeight());
        float f = (float) i;
        float measuredWidth = ((float) getMeasuredWidth()) / f;
        float f2 = (float) i2;
        float measuredHeight = ((float) getMeasuredHeight()) / f2;
        Log.d(TAG, "transformVideo, sx=" + measuredWidth + " sy=" + measuredHeight);
        Matrix matrix2 = this.matrix;
        if (matrix2 == null) {
            this.matrix = new Matrix();
        } else {
            matrix2.reset();
        }
        this.matrix.preTranslate((float) ((getWidth() - i) / 2), (float) ((getHeight() - i2) / 2));
        this.matrix.preScale(f / ((float) getWidth()), f2 / ((float) getHeight()));
        VideoScaleMode videoScaleMode2 = this.videoScaleMode;
        if (videoScaleMode2 == VideoScaleMode.CENTER_CROP) {
            this.matrix.postScale(measuredWidth, measuredWidth, (float) (getWidth() / 2), (float) (getHeight() / 2));
        } else if (videoScaleMode2 == VideoScaleMode.FIT_CENTER) {
            this.matrix.postScale(Math.min(measuredWidth, measuredHeight), Math.min(measuredWidth, measuredHeight), (float) (getWidth() / 2), (float) (getHeight() / 2));
        }
        LogUtils.d(TAG, "transformVideo, maxScale=" + measuredWidth);
        this.textureView.setTransform(this.matrix);
        postInvalidate();
        LogUtils.d(TAG, "transformVideo, videoWidth=" + i + "," + "videoHeight=" + i2);
    }

    public void attach() {
        if (this.surfaceTexture != null) {
            Surface surface2 = this.surface;
            if (surface2 != null) {
                surface2.release();
            }
            Surface surface3 = new Surface(this.surfaceTexture);
            this.surface = surface3;
            ITanxPlayer iTanxPlayer2 = this.iTanxPlayer;
            if (iTanxPlayer2 != null) {
                iTanxPlayer2.setSurface(surface3);
            }
        }
    }

    public long currentPosition() {
        ITanxPlayer iTanxPlayer2 = this.iTanxPlayer;
        if (iTanxPlayer2 == null) {
            return 0;
        }
        return iTanxPlayer2.getCurrentPosition();
    }

    public long duration() {
        ITanxPlayer iTanxPlayer2;
        if (!inState(PlayerState.STARTED, PlayerState.PAUSED, PlayerState.STOPPED, PlayerState.COMPLETED) || (iTanxPlayer2 = this.iTanxPlayer) == null) {
            return 0;
        }
        return iTanxPlayer2.getDuration();
    }

    public int getCurrentPosition() {
        ITanxPlayer iTanxPlayer2;
        if (!inState(PlayerState.PREPARED, PlayerState.STARTED, PlayerState.PAUSED, PlayerState.STOPPED, PlayerState.COMPLETED) || (iTanxPlayer2 = this.iTanxPlayer) == null) {
            return 0;
        }
        return (int) iTanxPlayer2.getCurrentPosition();
    }

    public int getDuration() {
        ITanxPlayer iTanxPlayer2;
        if (!inState(PlayerState.PREPARED, PlayerState.STARTED, PlayerState.PAUSED, PlayerState.STOPPED, PlayerState.COMPLETED) || (iTanxPlayer2 = this.iTanxPlayer) == null) {
            return 0;
        }
        return (int) iTanxPlayer2.getDuration();
    }

    public PlayerState getState() {
        ITanxPlayer iTanxPlayer2 = this.iTanxPlayer;
        if (iTanxPlayer2 == null) {
            return PlayerState.IDLE;
        }
        return iTanxPlayer2.getState();
    }

    public boolean isPlaying() {
        ITanxPlayer iTanxPlayer2 = this.iTanxPlayer;
        if (iTanxPlayer2 == null || !iTanxPlayer2.isPlaying()) {
            return false;
        }
        return true;
    }

    public void loadFrameImg(final String str, final IVideoThumb iVideoThumb) {
        Bitmap bitmap = this.firstFrame;
        if (bitmap != null) {
            iVideoThumb.getBitmap(bitmap);
        }
        VideoSizeThreadPool.post(new Runnable() {
            public void run() {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        String proxyUrl = TanxCoreSdk.getProxy(TanxPlayerView.this.getContext()).getProxyUrl(str);
                        LogUtils.d(TanxPlayerView.TAG, "loadFrameImg:" + proxyUrl);
                        if (Build.VERSION.SDK_INT >= 30) {
                            mediaMetadataRetriever.setDataSource(proxyUrl);
                        } else if (proxyUrl.contains(".mp4.download")) {
                            mediaMetadataRetriever.setDataSource(proxyUrl, new HashMap());
                        } else {
                            mediaMetadataRetriever.setDataSource(new FileInputStream(Uri.parse(proxyUrl).getEncodedPath()).getFD());
                        }
                        Bitmap unused = TanxPlayerView.this.firstFrame = mediaMetadataRetriever.getFrameAtTime(1, 2);
                        mediaMetadataRetriever.release();
                    }
                    IVideoThumb iVideoThumb = iVideoThumb;
                    if (iVideoThumb != null) {
                        iVideoThumb.getBitmap(TanxPlayerView.this.firstFrame);
                    }
                } catch (Exception e) {
                    LogUtils.e(TanxPlayerView.TAG, e);
                }
            }
        });
    }

    public void loadWeb() {
    }

    public void mute() {
        IAudioManager iAudioManager;
        ITanxPlayer iTanxPlayer2 = this.iTanxPlayer;
        if (iTanxPlayer2 != null) {
            iTanxPlayer2.setVolume(0.0f);
            if (this.iTanxPlayer != null && (iAudioManager = this.audioManager) != null) {
                iAudioManager.abandonAudioFocus();
            }
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Log.d(TAG, "onSizeChanged, w=" + i + "," + "h=" + i2);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture2, int i, int i2) {
        SurfaceTexture surfaceTexture3 = this.surfaceTexture;
        if (surfaceTexture3 == null) {
            this.surfaceTexture = surfaceTexture2;
            attach();
        } else if (surfaceTexture3 != null) {
            this.textureView.setSurfaceTexture(surfaceTexture3);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture2) {
        this.surfaceTexture = null;
        return false;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture2, int i, int i2) {
        if (this.textureView.getSurfaceTexture() != surfaceTexture2) {
            this.textureView.setSurfaceTexture(surfaceTexture2);
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture2) {
        if (this.textureView.getSurfaceTexture() != surfaceTexture2) {
            this.textureView.setSurfaceTexture(surfaceTexture2);
        }
    }

    public void pause() {
        ITanxPlayer iTanxPlayer2;
        if (inState(PlayerState.STARTED, PlayerState.PAUSED) && (iTanxPlayer2 = this.iTanxPlayer) != null) {
            iTanxPlayer2.pause();
        }
    }

    public void prepare() {
        ITanxPlayer iTanxPlayer2;
        attach();
        if (inState(PlayerState.INITIALIZED, PlayerState.STOPPED) && (iTanxPlayer2 = this.iTanxPlayer) != null) {
            iTanxPlayer2.prepareAsync();
        }
    }

    public void release() {
        SurfaceTexture surfaceTexture2 = this.surfaceTexture;
        if (surfaceTexture2 != null) {
            surfaceTexture2.release();
            this.surfaceTexture = null;
        }
        Surface surface2 = this.surface;
        if (surface2 != null) {
            surface2.release();
            this.surface = null;
        }
        ITanxPlayer iTanxPlayer2 = this.iTanxPlayer;
        if (iTanxPlayer2 != null) {
            iTanxPlayer2.release();
            this.iTanxPlayer = null;
            IAudioManager iAudioManager = this.audioManager;
            if (iAudioManager != null) {
                iAudioManager.abandonAudioFocus();
            }
        }
    }

    public void replay() {
        ITanxPlayer iTanxPlayer2;
        if (inState(PlayerState.PREPARED, PlayerState.STARTED, PlayerState.PAUSED, PlayerState.COMPLETED) && (iTanxPlayer2 = this.iTanxPlayer) != null) {
            iTanxPlayer2.seekTo(0);
            this.iTanxPlayer.start();
        }
    }

    public void reset() {
        ITanxPlayer iTanxPlayer2 = this.iTanxPlayer;
        if (iTanxPlayer2 != null) {
            iTanxPlayer2.reset();
        }
    }

    public void resumeVolume() {
        IAudioManager iAudioManager;
        ITanxPlayer iTanxPlayer2 = this.iTanxPlayer;
        if (iTanxPlayer2 != null) {
            iTanxPlayer2.setVolume(1.0f);
        }
        ITanxPlayer iTanxPlayer3 = this.iTanxPlayer;
        if (iTanxPlayer3 != null && iTanxPlayer3.getVolume() > 0.0f && (iAudioManager = this.audioManager) != null) {
            iAudioManager.requestAudioFocus();
        }
    }

    public void seekTo(long j) {
        ITanxPlayer iTanxPlayer2;
        if (inState(PlayerState.PREPARED, PlayerState.STARTED, PlayerState.PAUSED, PlayerState.COMPLETED) && (iTanxPlayer2 = this.iTanxPlayer) != null) {
            iTanxPlayer2.seekTo(j);
        }
    }

    public void setCover(String str) {
        this.coverUrl = str;
    }

    public void setDataSource(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.videoUrl = str;
            setDataSource(Uri.parse(str));
        }
    }

    public void setOnVideoBufferingListener(OnVideoBufferingListener onVideoBufferingListener2) {
        this.onVideoBufferingListener = onVideoBufferingListener2;
    }

    public void setOnVideoErrorListener(OnVideoErrorListener onVideoErrorListener2) {
        this.onVideoErrorListener = onVideoErrorListener2;
    }

    public void setOnVideoStateChangeListener(OnVideoStateChangeListener onVideoStateChangeListener2) {
        this.onVideoStateChangeListener = onVideoStateChangeListener2;
    }

    public void setTanxPlayer(ITanxPlayer iTanxPlayer2) {
        removeMediaPlayerObserver(iTanxPlayer2);
        this.iTanxPlayer = iTanxPlayer2;
        registerMediaPlayerObserver(iTanxPlayer2);
    }

    public void setVideoScaleMode(VideoScaleMode videoScaleMode2) {
        this.videoScaleMode = videoScaleMode2;
    }

    public void setVolume(int i) {
        ITanxPlayer iTanxPlayer2 = this.iTanxPlayer;
        if (iTanxPlayer2 != null) {
            iTanxPlayer2.setVolume((float) i);
            ITanxPlayer iTanxPlayer3 = this.iTanxPlayer;
            if (iTanxPlayer3 != null && this.audioManager != null) {
                if (iTanxPlayer3.getVolume() > 0.0f) {
                    this.audioManager.requestAudioFocus();
                } else {
                    this.audioManager.abandonAudioFocus();
                }
            }
        }
    }

    public void showCoverView(boolean z) {
        ImageView imageView = this.coverView;
        if (imageView != null) {
            imageView.setVisibility(0);
            loadImg(z);
        }
    }

    public void start() {
        ITanxPlayer iTanxPlayer2;
        if (inState(PlayerState.PREPARED, PlayerState.STARTED, PlayerState.PAUSED, PlayerState.COMPLETED) && (iTanxPlayer2 = this.iTanxPlayer) != null) {
            iTanxPlayer2.start();
        }
    }

    public void stop() {
        ITanxPlayer iTanxPlayer2;
        if (inState(PlayerState.STARTED, PlayerState.PAUSED, PlayerState.STOPPED, PlayerState.COMPLETED) && (iTanxPlayer2 = this.iTanxPlayer) != null) {
            iTanxPlayer2.pause();
        }
    }

    public int videoHeight() {
        ITanxPlayer iTanxPlayer2 = this.iTanxPlayer;
        if (iTanxPlayer2 == null) {
            return 0;
        }
        return iTanxPlayer2.getVideoHeight();
    }

    public int videoWidth() {
        ITanxPlayer iTanxPlayer2 = this.iTanxPlayer;
        if (iTanxPlayer2 == null) {
            return 0;
        }
        return iTanxPlayer2.getVideoWidth();
    }

    public TanxPlayerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public TanxPlayerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.videoScaleMode = VideoScaleMode.CENTER_CROP;
        init();
    }

    public void setDataSource(Uri uri) {
        setDataSource(uri, (Map<String, String>) null);
    }

    public void setDataSource(Uri uri, Map<String, String> map) {
        try {
            if (this.iTanxPlayer != null) {
                String uri2 = uri.toString();
                String proxyUrl = TanxCoreSdk.getProxy(getContext()).getProxyUrl(uri2);
                if (!TextUtils.isEmpty(uri2)) {
                    if (TextUtils.isEmpty(proxyUrl)) {
                    }
                    this.iTanxPlayer.setDataSource(getContext(), Uri.parse(proxyUrl), map);
                }
                loadImg(false);
                this.coverView.setVisibility(0);
                this.iTanxPlayer.setDataSource(getContext(), Uri.parse(proxyUrl), map);
            }
        } catch (Exception e) {
            LogUtils.e("TanxPlayerView setDataSource", e);
            loadImg(false);
            this.coverView.setVisibility(0);
        }
    }
}
