package com.kwad.sdk.core.video.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.video.ksvodplayerkit.IKSVodPlayer;
import com.kwai.video.ksvodplayerkit.KSVodConstants;
import com.kwai.video.ksvodplayerkit.KSVodPlayerWrapper;
import com.kwai.video.ksvodplayerkit.KSVodVideoContext;
import com.kwai.video.player.IKwaiMediaPlayer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes11.dex */
public final class d extends com.kwad.sdk.core.video.a.a {
    private static final Queue<d> aCA = new ConcurrentLinkedQueue();
    private static volatile boolean aCz = false;
    private final String TAG;
    private com.kwad.sdk.contentalliance.a.a.b UD;
    private boolean aCB;
    private String aCq;
    private MediaDataSource aCr;
    private final Object aCs;
    private boolean aCt;
    private final KSVodPlayerWrapper aCv;
    private final a aCw;
    private boolean aCx;
    private boolean aCy;
    private int mSarDen;
    private int mSarNum;

    /* loaded from: classes11.dex */
    public static class a implements IKSVodPlayer.OnBufferingUpdateListener, IKSVodPlayer.OnErrorListener, IKSVodPlayer.OnEventListener, IKSVodPlayer.OnPreparedListener, IKSVodPlayer.OnVideoSizeChangedListener, IKSVodPlayer.OnVodPlayerReleaseListener {
        final String TAG;
        final WeakReference<d> mWeakMediaPlayer;

        public a(d dVar, String str) {
            this.mWeakMediaPlayer = new WeakReference<>(dVar);
            this.TAG = str;
        }

        private d GO() {
            return this.mWeakMediaPlayer.get();
        }

        public final void onBufferingUpdate(int i) {
            d GO = GO();
            if (GO != null) {
                GO.notifyOnBufferingUpdate(i);
            }
        }

        public final void onError(int i, int i2) {
            d GO = GO();
            if (GO != null) {
                d.a(GO, false);
                GO.notifyOnError(i, i2);
            }
        }

        public final void onEvent(@KSVodConstants.KSVodPlayerEventType int i, int i2) {
            com.kwad.sdk.core.e.c.i(this.TAG, "onEvent, what: " + i);
            try {
                d GO = GO();
                if (GO != null) {
                    if (i == 10100) {
                        GO.notifyOnSeekComplete();
                    } else {
                        if (i == 10101) {
                            GO.notifyOnCompletion();
                            return;
                        }
                        if (i == 10209) {
                            GO.GN();
                        }
                        GO.notifyOnInfo(i, i2);
                    }
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }

        public final void onPlayerRelease() {
            com.kwad.sdk.core.e.c.i(this.TAG, "onPlayerRelease");
        }

        public final void onPrepared() {
            com.kwad.sdk.core.e.c.i(this.TAG, "onPrepared");
            d GO = GO();
            if (GO != null) {
                GO.notifyOnPrepared();
            }
        }

        public final void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            com.kwad.sdk.core.e.c.i(this.TAG, "onVideoSizeChanged width: " + i + ", height: " + i2 + ", sarNum:" + i3 + ", sarDen:" + i4);
            d GO = GO();
            if (GO != null) {
                GO.w(i, i2);
                GO.mSarNum = i3;
                GO.mSarDen = i4;
            }
        }
    }

    public d(int i) {
        Object obj = new Object();
        this.aCs = obj;
        this.aCy = false;
        this.aCB = true;
        synchronized (obj) {
            this.aCv = new KSVodPlayerWrapper(l.ON());
        }
        String str = "KSMediaPlayer[" + i + "]";
        this.TAG = str;
        this.aCw = new a(this, str);
        GK();
        setLooping(false);
        com.kwad.sdk.core.e.c.i(str, "create KwaiMediaPlayer");
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
        this.aCv.setOnPreparedListener(this.aCw);
        this.aCv.setBufferingUpdateListener(this.aCw);
        this.aCv.setOnEventListener(this.aCw);
        this.aCv.setVideoSizeChangedListener(this.aCw);
        this.aCv.setOnErrorListener(this.aCw);
    }

    private void GL() {
        this.aCv.setOnPreparedListener((IKSVodPlayer.OnPreparedListener) null);
        this.aCv.setBufferingUpdateListener((IKSVodPlayer.OnBufferingUpdateListener) null);
        this.aCv.setOnEventListener((IKSVodPlayer.OnEventListener) null);
        this.aCv.setVideoSizeChangedListener((IKSVodPlayer.OnVideoSizeChangedListener) null);
        this.aCv.setOnErrorListener((IKSVodPlayer.OnErrorListener) null);
    }

    private void GM() {
        com.kwad.sdk.core.e.c.i(this.TAG, "realPrepare hasCallPrepare: " + this.aCy);
        if (this.aCy) {
            return;
        }
        try {
            this.aCy = true;
            int prepareAsync = this.aCv.prepareAsync();
            GH();
            com.kwad.sdk.core.e.c.i(this.TAG, "realPrepare result: " + prepareAsync);
        } catch (IllegalStateException e) {
            com.kwad.sdk.core.e.c.e(this.TAG, "realPrepare failed ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GN() {
        Iterator<d> it = aCA.iterator();
        int i = 0;
        while (true) {
            if (it.hasNext()) {
                if (it.next() == this) {
                    break;
                } else {
                    i++;
                }
            } else {
                i = 0;
                break;
            }
        }
        com.kwad.sdk.core.e.c.i(this.TAG, "preloadNextPlayer next player index: " + i);
        int i2 = i + 1;
        if (i2 < aCA.size()) {
            com.kwad.sdk.core.e.c.i(this.TAG, "----------------preloadNextPlayer prepare next player----------------");
            for (int i3 = 0; i3 < i2; i3++) {
                aCA.poll();
            }
            Queue<d> queue = aCA;
            d poll = queue.poll();
            queue.clear();
            if (poll != null) {
                poll.prepareAsync();
            } else {
                com.kwad.sdk.core.e.c.i(this.TAG, "----------------preloadNextPlayer prepareAsync next player is null----------------");
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean GJ() {
        com.kwad.sdk.core.e.c.i(this.TAG, "forcePrepareAsync");
        GM();
        return true;
    }

    public final void bn(boolean z) {
        this.aCB = z;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getAudioSessionId() {
        return this.aCv.getKwaiMediaPlayer().getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getCurrentPlayingUrl() {
        KSVodPlayerWrapper kSVodPlayerWrapper = this.aCv;
        if (kSVodPlayerWrapper == null) {
            return "";
        }
        return kSVodPlayerWrapper.getCurrentPlayUrl();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getCurrentPosition() {
        try {
            return this.aCv.getCurrentPosition();
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
            return this.aCv.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getMediaPlayerType() {
        return 2;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoHeight() {
        return this.aCv.getKwaiMediaPlayer().getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoWidth() {
        return this.aCv.getKwaiMediaPlayer().getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isLooping() {
        return this.aCx;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isPlaying() {
        try {
            return this.aCv.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void pause() {
        this.aCv.pause();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean prepareAsync() {
        if (this.aCB) {
            Queue<d> queue = aCA;
            if (!queue.contains(this)) {
                queue.offer(this);
            }
            int size = queue.size();
            if (size == 1) {
                com.kwad.sdk.core.e.c.i(this.TAG, "prepareAsync first");
                GM();
                return true;
            }
            com.kwad.sdk.core.e.c.i(this.TAG, "prepareAsync pending size: " + size);
            return false;
        }
        GM();
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void release() {
        Queue<d> queue = aCA;
        boolean remove = queue.remove(this);
        com.kwad.sdk.core.e.c.i(this.TAG, "release remote player ret: " + remove + ", player list size: " + queue.size());
        this.aCt = true;
        this.aCv.releaseAsync(new IKSVodPlayer.OnVodPlayerReleaseListener() { // from class: com.kwad.sdk.core.video.a.d.1
            public final void onPlayerRelease() {
                com.kwad.sdk.core.e.c.i(d.this.TAG, "onPlayerRelease");
            }
        });
        try {
            GI();
            resetListeners();
            GL();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void reset() {
        this.aCy = false;
        try {
            IKwaiMediaPlayer kwaiMediaPlayer = this.aCv.getKwaiMediaPlayer();
            if (kwaiMediaPlayer != null) {
                kwaiMediaPlayer.reset();
            }
        } catch (IllegalStateException unused) {
        }
        GI();
        resetListeners();
        GK();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void seekTo(long j) {
        this.aCv.seekTo((int) j);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setAudioStreamType(int i) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.aCs) {
            try {
                if (!this.aCt) {
                    this.aCv.setDisplay(surfaceHolder);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setLooping(boolean z) {
        this.aCx = z;
        this.aCv.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setScreenOnWhilePlaying(boolean z) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSpeed(float f) {
        this.aCv.setSpeed(f);
    }

    @Override // com.kwad.sdk.core.video.a.c
    @TargetApi(14)
    public final void setSurface(Surface surface) {
        this.aCv.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setVolume(float f, float f2) {
        this.aCv.setVolume(f, f2);
        com.kwad.sdk.core.video.a.a.h(f);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void start() {
        com.kwad.sdk.core.e.c.i(this.TAG, "start");
        this.aCv.start();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void stop() {
        this.aCv.stop();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
    }

    public static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.aCy = false;
        return false;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(FileDescriptor fileDescriptor) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar) {
        this.UD = bVar;
        a(bVar.apW);
        f fVar = (f) ServiceProvider.get(f.class);
        if (!TextUtils.isEmpty(bVar.manifest) && fVar != null && fVar.uf()) {
            setDataSource(bVar.manifest, (Map<String, String>) null);
        } else {
            setDataSource(bVar.videoUrl, (Map<String, String>) null);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(String str) {
        setDataSource(str, (Map<String, String>) null);
    }

    private void setDataSource(String str, Map<String, String> map) {
        this.aCq = str;
        this.aCv.setDataSource(str, (Map) null);
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.a aVar) {
        if (this.aCv == null || aVar == null) {
            return;
        }
        KSVodVideoContext kSVodVideoContext = new KSVodVideoContext();
        kSVodVideoContext.mVideoId = String.valueOf(aVar.photoId);
        kSVodVideoContext.mClickTime = aVar.clickTime;
        kSVodVideoContext.mExtra = aVar.BI();
        this.aCv.updateVideoContext(kSVodVideoContext);
    }
}
