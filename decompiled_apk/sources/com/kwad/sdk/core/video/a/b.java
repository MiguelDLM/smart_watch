package com.kwad.sdk.core.video.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.media.TimedText;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.google.android.exoplayer2.audio.OxI;
import com.kwad.sdk.service.ServiceProvider;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes11.dex */
public final class b extends com.kwad.sdk.core.video.a.a {
    private final MediaPlayer aCo;
    private final a aCp;
    private String aCq;
    private MediaDataSource aCr;
    private final Object aCs;
    private boolean aCt;
    private boolean aCu;

    /* loaded from: classes11.dex */
    public static class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnTimedTextListener, MediaPlayer.OnVideoSizeChangedListener {
        final WeakReference<b> mWeakMediaPlayer;

        public a(b bVar) {
            this.mWeakMediaPlayer = new WeakReference<>(bVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnBufferingUpdate(i);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnCompletion();
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null && bVar.notifyOnError(i, i2)) {
                return true;
            }
            return false;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar == null) {
                return false;
            }
            if (i == 3) {
                if (bVar.aCu) {
                    return false;
                }
                b.a(bVar, true);
                return bVar.notifyOnInfo(i, i2);
            }
            return bVar.notifyOnInfo(i, i2);
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnPrepared();
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnSeekComplete();
            }
        }

        @Override // android.media.MediaPlayer.OnTimedTextListener
        public final void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.b(timedText);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.w(i, i2);
            }
        }
    }

    public b() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.aCs = obj;
        this.aCu = false;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.aCo = mediaPlayer;
        }
        mediaPlayer.setAudioStreamType(3);
        this.aCp = new a(this);
        GK();
        setLooping(false);
    }

    private void GI() {
        MediaDataSource mediaDataSource = this.aCr;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.aCr = null;
        }
    }

    private void GK() {
        this.aCo.setOnPreparedListener(this.aCp);
        this.aCo.setOnBufferingUpdateListener(this.aCp);
        this.aCo.setOnCompletionListener(this.aCp);
        this.aCo.setOnSeekCompleteListener(this.aCp);
        this.aCo.setOnVideoSizeChangedListener(this.aCp);
        this.aCo.setOnErrorListener(this.aCp);
        this.aCo.setOnInfoListener(this.aCp);
        this.aCo.setOnTimedTextListener(this.aCp);
    }

    private void GL() {
        this.aCo.setOnPreparedListener(null);
        this.aCo.setOnBufferingUpdateListener(null);
        this.aCo.setOnCompletionListener(null);
        this.aCo.setOnSeekCompleteListener(null);
        this.aCo.setOnVideoSizeChangedListener(null);
        this.aCo.setOnErrorListener(null);
        this.aCo.setOnInfoListener(null);
        this.aCo.setOnTimedTextListener(null);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean GJ() {
        this.aCo.prepareAsync();
        GH();
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getAudioSessionId() {
        return this.aCo.getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getCurrentPlayingUrl() {
        return "";
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getCurrentPosition() {
        try {
            return this.aCo.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getDataSource() {
        return this.aCq;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getDuration() {
        try {
            return this.aCo.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getMediaPlayerType() {
        return 1;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoHeight() {
        return this.aCo.getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoWidth() {
        return this.aCo.getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isLooping() {
        return this.aCo.isLooping();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isPlaying() {
        try {
            return this.aCo.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void pause() {
        this.aCo.pause();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean prepareAsync() {
        this.aCo.prepareAsync();
        GH();
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void release() {
        try {
            this.aCt = true;
            this.aCo.release();
            GI();
            resetListeners();
            GL();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void reset() {
        try {
            this.aCo.reset();
            this.aCu = false;
        } catch (IllegalStateException unused) {
        }
        GI();
        resetListeners();
        GK();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void seekTo(long j) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.aCo.seekTo((int) j, 3);
        } else {
            this.aCo.seekTo((int) j);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setAudioStreamType(int i) {
        this.aCo.setAudioStreamType(i);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri) {
        this.aCo.setDataSource(context, uri);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.aCs) {
            try {
                if (!this.aCt) {
                    this.aCo.setDisplay(surfaceHolder);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setLooping(boolean z) {
        this.aCo.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setScreenOnWhilePlaying(boolean z) {
        this.aCo.setScreenOnWhilePlaying(z);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSpeed(float f) {
        PlaybackParams playbackParams;
        if (Build.VERSION.SDK_INT >= 23) {
            playbackParams = this.aCo.getPlaybackParams();
            if (playbackParams == null) {
                playbackParams = OxI.oIX0oI();
            }
            playbackParams.setSpeed(f);
            this.aCo.setPlaybackParams(playbackParams);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public final void setSurface(Surface surface) {
        this.aCo.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setVolume(float f, float f2) {
        this.aCo.setVolume(f, f2);
        com.kwad.sdk.core.video.a.a.h(f);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void start() {
        this.aCo.start();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void stop() {
        this.aCo.stop();
    }

    public static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.aCu = true;
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
        this.aCo.setDataSource(context, uri, map);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar) {
        if (bVar.isNoCache) {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "video/mp4");
            hashMap.put("Accept-Ranges", "bytes");
            hashMap.put(JNISearchConst.JNI_SHOP_OPEN_TIME_COLOR, "206");
            hashMap.put("Cache-control", "no-cache");
            setDataSource(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext(), Uri.parse(bVar.videoUrl), hashMap);
            return;
        }
        setDataSource(bVar.videoUrl);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(FileDescriptor fileDescriptor) {
        this.aCo.setDataSource(fileDescriptor);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(String str) {
        this.aCq = str;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase("file")) {
            this.aCo.setDataSource(parse.getPath());
        } else {
            this.aCo.setDataSource(str);
        }
    }
}
