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

/* loaded from: classes.dex */
public class TanxPlayerView extends TanxAdView implements TextureView.SurfaceTextureListener, NotConfused, ITanxPlayerView {
    private static final String TAG = "TanxPlayerView";
    private IAudioManager audioManager;
    private String coverUrl;
    private ImageView coverView;
    private Bitmap firstFrame;
    private ITanxPlayer iTanxPlayer;
    private Matrix matrix;
    private OnVideoBufferingListener onVideoBufferingListener;
    private OnVideoErrorListener onVideoErrorListener;
    private OnVideoStateChangeListener onVideoStateChangeListener;
    private Surface surface;
    private boolean surfaceIsDestroy;
    private SurfaceTexture surfaceTexture;
    private TextureView textureView;
    private VideoScaleMode videoScaleMode;
    private String videoUrl;

    /* loaded from: classes.dex */
    public interface IVideoThumb {
        void getBitmap(Bitmap bitmap);
    }

    public TanxPlayerView(@NonNull Context context) {
        this(context, null);
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
        TextureView textureView = new TextureView(getContext());
        this.textureView = textureView;
        textureView.setSurfaceTextureListener(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        addView(this.textureView, layoutParams);
        addView(this.coverView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadImg(boolean z) {
        final long currentTimeMillis = System.currentTimeMillis();
        final ImageConfig build = ImageManager.with(getContext()).url(this.coverUrl).scaleMode(ScaleMode.FIT_CENTER).build();
        if (z) {
            loadFrameImg(this.videoUrl, new IVideoThumb() { // from class: com.alimm.tanx.core.view.player.ui.TanxPlayerView.5
                @Override // com.alimm.tanx.core.view.player.ui.TanxPlayerView.IVideoThumb
                public void getBitmap(final Bitmap bitmap) {
                    if (bitmap != null) {
                        TanxPlayerView.this.coverView.post(new Runnable() { // from class: com.alimm.tanx.core.view.player.ui.TanxPlayerView.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                TanxPlayerView.this.coverView.setImageDrawable(new TanxDrawable(bitmap, build.getImageConfig()));
                                LogUtils.d(TanxPlayerView.TAG, "耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                            }
                        });
                    }
                }
            });
        } else if (!TextUtils.isEmpty(this.coverUrl) && ImageManager.getLoader() != null) {
            ImageManager.getLoader().load(build, new ImageConfig.ImageBitmapCallback() { // from class: com.alimm.tanx.core.view.player.ui.TanxPlayerView.6
                @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
                public void onFailure(String str) {
                    TanxPlayerView.this.coverView.setVisibility(8);
                }

                @Override // com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback
                public void onSuccess(Bitmap bitmap) {
                    TanxPlayerView.this.coverView.setImageDrawable(new TanxDrawable(bitmap, build.getImageConfig()));
                }
            });
        }
    }

    private void registerMediaPlayerObserver(final ITanxPlayer iTanxPlayer) {
        iTanxPlayer.setOnVideoStateChangeListener(new OnVideoStateChangeListener() { // from class: com.alimm.tanx.core.view.player.ui.TanxPlayerView.1
            @Override // com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener
            public void onStateChange(ITanxPlayer iTanxPlayer2, PlayerState playerState) {
                LogUtils.d(TanxPlayerView.TAG, "onStateChange:" + playerState.name());
                if (playerState == PlayerState.PREPARED) {
                    TanxPlayerView.this.loadImg(true);
                    TanxPlayerView.this.coverView.setVisibility(8);
                    ITanxPlayer iTanxPlayer3 = iTanxPlayer;
                    iTanxPlayer3.seekTo(iTanxPlayer3.getCurrentPosition());
                    if (iTanxPlayer.isPlayWhenReady()) {
                        iTanxPlayer.start();
                    }
                    TanxPlayerView.this.setBackgroundResource(R.color.transparent);
                } else if (playerState == PlayerState.STARTED) {
                    TanxPlayerView.this.coverView.setVisibility(8);
                    TanxPlayerView.this.loadWeb();
                    ITanxPlayer iTanxPlayer4 = iTanxPlayer;
                    if (iTanxPlayer4 != null && iTanxPlayer4.getVolume() > 0.0f && TanxPlayerView.this.audioManager != null) {
                        TanxPlayerView.this.audioManager.requestAudioFocus();
                    }
                    LogUtils.d(TanxPlayerView.TAG, " getVolume:" + iTanxPlayer.getVolume());
                } else if (playerState == PlayerState.COMPLETED) {
                    TanxPlayerView.this.loadImg(false);
                    TanxPlayerView.this.coverView.setVisibility(0);
                } else if (playerState != PlayerState.STOPPED && playerState != PlayerState.END) {
                    if (playerState == PlayerState.ERROR) {
                        TanxPlayerView.this.audioManager.abandonAudioFocus();
                        TanxPlayerView.this.loadImg(false);
                        TanxPlayerView.this.coverView.setVisibility(0);
                    }
                } else {
                    TanxPlayerView.this.audioManager.abandonAudioFocus();
                }
                if (TanxPlayerView.this.onVideoStateChangeListener != null) {
                    TanxPlayerView.this.onVideoStateChangeListener.onStateChange(iTanxPlayer2, playerState);
                }
            }
        });
        iTanxPlayer.setOnVideoBufferingStateChangeListener(new OnVideoBufferingListener() { // from class: com.alimm.tanx.core.view.player.ui.TanxPlayerView.2
            @Override // com.alimm.tanx.core.view.player.core.OnVideoBufferingListener
            public void OnBufferStateChanged(PlayerBufferingState playerBufferingState) {
                if (TanxPlayerView.this.onVideoBufferingListener != null) {
                    TanxPlayerView.this.onVideoBufferingListener.OnBufferStateChanged(playerBufferingState);
                }
            }
        });
        iTanxPlayer.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.alimm.tanx.core.view.player.ui.TanxPlayerView.3
            @Override // com.alimm.tanx.core.view.player.core.OnVideoErrorListener
            public boolean onError(ITanxPlayer iTanxPlayer2, TanxPlayerError tanxPlayerError) {
                if (TanxPlayerView.this.onVideoErrorListener != null) {
                    TanxPlayerView.this.onVideoErrorListener.onError(iTanxPlayer2, tanxPlayerError);
                    return false;
                }
                return false;
            }
        });
        iTanxPlayer.setOnVideoSizeChangeListener(new OnVideoSizeChangeListener() { // from class: com.alimm.tanx.core.view.player.ui.TanxPlayerView.4
            @Override // com.alimm.tanx.core.view.player.core.OnVideoSizeChangeListener
            public void onVideoSizeChanged(ITanxPlayer iTanxPlayer2, int i, int i2) {
                Log.d(TanxPlayerView.TAG, "onVideoSizeChanged, width=" + i + ",height=" + i2);
                TanxPlayerView.this.transformVideo(i, i2);
            }
        });
    }

    private void removeMediaPlayerObserver(ITanxPlayer iTanxPlayer) {
        iTanxPlayer.setOnVideoStateChangeListener(null);
        iTanxPlayer.setOnVideoBufferingStateChangeListener(null);
        iTanxPlayer.setOnVideoErrorListener(null);
        iTanxPlayer.setOnVideoSizeChangeListener(null);
        this.audioManager.abandonAudioFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transformVideo(int i, int i2) {
        if (getHeight() != 0 && getWidth() != 0) {
            Log.d(TAG, "transformVideo, getMeasuredWidth=" + getMeasuredWidth() + " getMeasuredHeight=" + getMeasuredHeight());
            Log.d(TAG, "transformVideo, getWidth=" + getWidth() + " getHeight=" + getHeight());
            float f = (float) i;
            float measuredWidth = ((float) getMeasuredWidth()) / f;
            float f2 = (float) i2;
            float measuredHeight = ((float) getMeasuredHeight()) / f2;
            Log.d(TAG, "transformVideo, sx=" + measuredWidth + " sy=" + measuredHeight);
            Matrix matrix = this.matrix;
            if (matrix == null) {
                this.matrix = new Matrix();
            } else {
                matrix.reset();
            }
            this.matrix.preTranslate((getWidth() - i) / 2, (getHeight() - i2) / 2);
            this.matrix.preScale(f / getWidth(), f2 / getHeight());
            VideoScaleMode videoScaleMode = this.videoScaleMode;
            if (videoScaleMode == VideoScaleMode.CENTER_CROP) {
                this.matrix.postScale(measuredWidth, measuredWidth, getWidth() / 2, getHeight() / 2);
            } else if (videoScaleMode == VideoScaleMode.FIT_CENTER) {
                this.matrix.postScale(Math.min(measuredWidth, measuredHeight), Math.min(measuredWidth, measuredHeight), getWidth() / 2, getHeight() / 2);
            }
            LogUtils.d(TAG, "transformVideo, maxScale=" + measuredWidth);
            this.textureView.setTransform(this.matrix);
            postInvalidate();
            LogUtils.d(TAG, "transformVideo, videoWidth=" + i + ",videoHeight=" + i2);
            return;
        }
        Log.d(TAG, "transformVideo, getHeight=" + getHeight() + ",getWidth=" + getWidth());
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void attach() {
        if (this.surfaceTexture != null) {
            Surface surface = this.surface;
            if (surface != null) {
                surface.release();
            }
            Surface surface2 = new Surface(this.surfaceTexture);
            this.surface = surface2;
            ITanxPlayer iTanxPlayer = this.iTanxPlayer;
            if (iTanxPlayer != null) {
                iTanxPlayer.setSurface(surface2);
            }
        }
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public long currentPosition() {
        ITanxPlayer iTanxPlayer = this.iTanxPlayer;
        if (iTanxPlayer == null) {
            return 0L;
        }
        return iTanxPlayer.getCurrentPosition();
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public long duration() {
        ITanxPlayer iTanxPlayer;
        if (!inState(PlayerState.STARTED, PlayerState.PAUSED, PlayerState.STOPPED, PlayerState.COMPLETED) || (iTanxPlayer = this.iTanxPlayer) == null) {
            return 0L;
        }
        return iTanxPlayer.getDuration();
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public int getCurrentPosition() {
        ITanxPlayer iTanxPlayer;
        if (!inState(PlayerState.PREPARED, PlayerState.STARTED, PlayerState.PAUSED, PlayerState.STOPPED, PlayerState.COMPLETED) || (iTanxPlayer = this.iTanxPlayer) == null) {
            return 0;
        }
        return (int) iTanxPlayer.getCurrentPosition();
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public int getDuration() {
        ITanxPlayer iTanxPlayer;
        if (!inState(PlayerState.PREPARED, PlayerState.STARTED, PlayerState.PAUSED, PlayerState.STOPPED, PlayerState.COMPLETED) || (iTanxPlayer = this.iTanxPlayer) == null) {
            return 0;
        }
        return (int) iTanxPlayer.getDuration();
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public PlayerState getState() {
        ITanxPlayer iTanxPlayer = this.iTanxPlayer;
        if (iTanxPlayer == null) {
            return PlayerState.IDLE;
        }
        return iTanxPlayer.getState();
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public boolean isPlaying() {
        ITanxPlayer iTanxPlayer = this.iTanxPlayer;
        if (iTanxPlayer != null && iTanxPlayer.isPlaying()) {
            return true;
        }
        return false;
    }

    public void loadFrameImg(final String str, final IVideoThumb iVideoThumb) {
        Bitmap bitmap = this.firstFrame;
        if (bitmap != null) {
            iVideoThumb.getBitmap(bitmap);
        }
        VideoSizeThreadPool.post(new Runnable() { // from class: com.alimm.tanx.core.view.player.ui.TanxPlayerView.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        String proxyUrl = TanxCoreSdk.getProxy(TanxPlayerView.this.getContext()).getProxyUrl(str);
                        LogUtils.d(TanxPlayerView.TAG, "loadFrameImg:" + proxyUrl);
                        if (Build.VERSION.SDK_INT < 30) {
                            if (proxyUrl.contains(".mp4.download")) {
                                mediaMetadataRetriever.setDataSource(proxyUrl, new HashMap());
                            } else {
                                mediaMetadataRetriever.setDataSource(new FileInputStream(Uri.parse(proxyUrl).getEncodedPath()).getFD());
                            }
                        } else {
                            mediaMetadataRetriever.setDataSource(proxyUrl);
                        }
                        TanxPlayerView.this.firstFrame = mediaMetadataRetriever.getFrameAtTime(1L, 2);
                        mediaMetadataRetriever.release();
                    }
                    IVideoThumb iVideoThumb2 = iVideoThumb;
                    if (iVideoThumb2 != null) {
                        iVideoThumb2.getBitmap(TanxPlayerView.this.firstFrame);
                    }
                } catch (Exception e) {
                    LogUtils.e(TanxPlayerView.TAG, e);
                }
            }
        });
    }

    public void loadWeb() {
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void mute() {
        IAudioManager iAudioManager;
        ITanxPlayer iTanxPlayer = this.iTanxPlayer;
        if (iTanxPlayer != null) {
            iTanxPlayer.setVolume(0.0f);
            if (this.iTanxPlayer != null && (iAudioManager = this.audioManager) != null) {
                iAudioManager.abandonAudioFocus();
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Log.d(TAG, "onSizeChanged, w=" + i + ",h=" + i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        SurfaceTexture surfaceTexture2 = this.surfaceTexture;
        if (surfaceTexture2 == null) {
            this.surfaceTexture = surfaceTexture;
            attach();
        } else if (surfaceTexture2 != null) {
            this.textureView.setSurfaceTexture(surfaceTexture2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.surfaceTexture = null;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.textureView.getSurfaceTexture() != surfaceTexture) {
            this.textureView.setSurfaceTexture(surfaceTexture);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        if (this.textureView.getSurfaceTexture() != surfaceTexture) {
            this.textureView.setSurfaceTexture(surfaceTexture);
        }
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void pause() {
        ITanxPlayer iTanxPlayer;
        if (inState(PlayerState.STARTED, PlayerState.PAUSED) && (iTanxPlayer = this.iTanxPlayer) != null) {
            iTanxPlayer.pause();
        }
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void prepare() {
        ITanxPlayer iTanxPlayer;
        attach();
        if (inState(PlayerState.INITIALIZED, PlayerState.STOPPED) && (iTanxPlayer = this.iTanxPlayer) != null) {
            iTanxPlayer.prepareAsync();
        }
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void release() {
        SurfaceTexture surfaceTexture = this.surfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.surfaceTexture = null;
        }
        Surface surface = this.surface;
        if (surface != null) {
            surface.release();
            this.surface = null;
        }
        ITanxPlayer iTanxPlayer = this.iTanxPlayer;
        if (iTanxPlayer != null) {
            iTanxPlayer.release();
            this.iTanxPlayer = null;
            IAudioManager iAudioManager = this.audioManager;
            if (iAudioManager != null) {
                iAudioManager.abandonAudioFocus();
            }
        }
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void replay() {
        ITanxPlayer iTanxPlayer;
        if (inState(PlayerState.PREPARED, PlayerState.STARTED, PlayerState.PAUSED, PlayerState.COMPLETED) && (iTanxPlayer = this.iTanxPlayer) != null) {
            iTanxPlayer.seekTo(0L);
            this.iTanxPlayer.start();
        }
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void reset() {
        ITanxPlayer iTanxPlayer = this.iTanxPlayer;
        if (iTanxPlayer != null) {
            iTanxPlayer.reset();
        }
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void resumeVolume() {
        IAudioManager iAudioManager;
        ITanxPlayer iTanxPlayer = this.iTanxPlayer;
        if (iTanxPlayer != null) {
            iTanxPlayer.setVolume(1.0f);
        }
        ITanxPlayer iTanxPlayer2 = this.iTanxPlayer;
        if (iTanxPlayer2 != null && iTanxPlayer2.getVolume() > 0.0f && (iAudioManager = this.audioManager) != null) {
            iAudioManager.requestAudioFocus();
        }
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void seekTo(long j) {
        ITanxPlayer iTanxPlayer;
        if (inState(PlayerState.PREPARED, PlayerState.STARTED, PlayerState.PAUSED, PlayerState.COMPLETED) && (iTanxPlayer = this.iTanxPlayer) != null) {
            iTanxPlayer.seekTo(j);
        }
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void setCover(String str) {
        this.coverUrl = str;
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void setDataSource(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.videoUrl = str;
        setDataSource(Uri.parse(str));
    }

    public void setOnVideoBufferingListener(OnVideoBufferingListener onVideoBufferingListener) {
        this.onVideoBufferingListener = onVideoBufferingListener;
    }

    public void setOnVideoErrorListener(OnVideoErrorListener onVideoErrorListener) {
        this.onVideoErrorListener = onVideoErrorListener;
    }

    public void setOnVideoStateChangeListener(OnVideoStateChangeListener onVideoStateChangeListener) {
        this.onVideoStateChangeListener = onVideoStateChangeListener;
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void setTanxPlayer(ITanxPlayer iTanxPlayer) {
        removeMediaPlayerObserver(iTanxPlayer);
        this.iTanxPlayer = iTanxPlayer;
        registerMediaPlayerObserver(iTanxPlayer);
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void setVideoScaleMode(VideoScaleMode videoScaleMode) {
        this.videoScaleMode = videoScaleMode;
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void setVolume(int i) {
        ITanxPlayer iTanxPlayer = this.iTanxPlayer;
        if (iTanxPlayer != null) {
            iTanxPlayer.setVolume(i);
            ITanxPlayer iTanxPlayer2 = this.iTanxPlayer;
            if (iTanxPlayer2 != null && this.audioManager != null) {
                if (iTanxPlayer2.getVolume() > 0.0f) {
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

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void start() {
        ITanxPlayer iTanxPlayer;
        if (inState(PlayerState.PREPARED, PlayerState.STARTED, PlayerState.PAUSED, PlayerState.COMPLETED) && (iTanxPlayer = this.iTanxPlayer) != null) {
            iTanxPlayer.start();
        }
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void stop() {
        ITanxPlayer iTanxPlayer;
        if (inState(PlayerState.STARTED, PlayerState.PAUSED, PlayerState.STOPPED, PlayerState.COMPLETED) && (iTanxPlayer = this.iTanxPlayer) != null) {
            iTanxPlayer.pause();
        }
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public int videoHeight() {
        ITanxPlayer iTanxPlayer = this.iTanxPlayer;
        if (iTanxPlayer == null) {
            return 0;
        }
        return iTanxPlayer.getVideoHeight();
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public int videoWidth() {
        ITanxPlayer iTanxPlayer = this.iTanxPlayer;
        if (iTanxPlayer == null) {
            return 0;
        }
        return iTanxPlayer.getVideoWidth();
    }

    public TanxPlayerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public TanxPlayerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.videoScaleMode = VideoScaleMode.CENTER_CROP;
        init();
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
    public void setDataSource(Uri uri) {
        setDataSource(uri, null);
    }

    @Override // com.alimm.tanx.core.view.player.ui.ITanxPlayerView
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
