package com.kwad.components.core.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes11.dex */
public final class b {
    private static boolean Uw = false;
    private static final AtomicInteger Ux = new AtomicInteger(0);
    private final String TAG;
    private int UA;
    private long UB;
    private Runnable UC;
    private com.kwad.sdk.contentalliance.a.a.b UD;
    private int UE;
    private List<c.d> UF;
    private final AtomicBoolean UG;
    private boolean UH;
    private final int UI;
    private volatile List<k> UJ;
    private volatile List<com.kwad.components.core.video.a.c> UK;
    private volatile List<c.e> UL;
    private final c.f UM;
    private c.e UN;
    private c.i UO;
    private c.b UP;
    private c.InterfaceC0859c UQ;
    private c.d UR;
    private c.a US;
    private int Ug;
    private int Uh;
    private volatile int Uy;
    private com.kwad.sdk.core.video.a.c Uz;
    private Handler fS;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private long mStartTime;

    /* loaded from: classes11.dex */
    public interface a {
        @WorkerThread
        void onReleaseSuccess();
    }

    public b(@Nullable DetailVideoView detailVideoView) {
        this(detailVideoView, 0);
    }

    private void aM(int i) {
        for (com.kwad.components.core.video.a.c cVar : this.UK) {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        try {
                            cVar.onRelease();
                        } catch (Exception e) {
                            com.kwad.sdk.core.e.c.printStackTrace(e);
                        }
                    }
                } else {
                    cVar.onReset();
                }
            } else {
                cVar.onStart();
            }
        }
    }

    private void aP(final boolean z) {
        if (this.Uz == null) {
            return;
        }
        com.kwad.sdk.core.e.c.i(this.TAG, "start prepareAsync");
        if (this.UH) {
            if (!this.UG.compareAndSet(false, true)) {
                return;
            }
            com.kwad.sdk.utils.g.execute(new az() { // from class: com.kwad.components.core.video.b.10
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    com.kwad.sdk.core.e.c.i(b.this.TAG, "prepareAsync now:" + b.getStateString(b.this.Uy));
                    if (b.this.Uz == null) {
                        return;
                    }
                    try {
                        synchronized (b.this.Uz) {
                            b.this.aQ(z);
                        }
                    } finally {
                        try {
                        } finally {
                        }
                    }
                    try {
                        synchronized (b.this.UG) {
                            b.this.UG.notifyAll();
                        }
                    } catch (Exception e) {
                        com.kwad.sdk.core.e.c.printStackTrace(e);
                    }
                }
            });
            return;
        }
        try {
            aQ(z);
        } catch (Throwable th) {
            if (getMediaPlayerType() != 2) {
                int i = this.UE;
                this.UE = i + 1;
                if (i <= 4) {
                    rZ();
                }
            }
            com.kwad.sdk.core.e.c.i(this.TAG, "prepareAsync Exception:" + getStateString(this.Uy));
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(boolean z) {
        boolean prepareAsync;
        a(this.UD);
        if (z) {
            prepareAsync = this.Uz.GJ();
        } else {
            prepareAsync = this.Uz.prepareAsync();
        }
        com.kwad.sdk.core.e.c.i(this.TAG, "prepareAsync forcePrepare: " + z + ", result: " + prepareAsync);
    }

    public static String getStateString(int i) {
        switch (i) {
            case -1:
                return "STATE_ERROR";
            case 0:
                return "STATE_IDLE";
            case 1:
                return "STATE_PREPARING";
            case 2:
                return "STATE_PREPARED";
            case 3:
                return "STATE_STARTED";
            case 4:
                return "STATE_PLAYING";
            case 5:
                return "STATE_PAUSED";
            case 6:
                return "STATE_BUFFERING_PLAYING";
            case 7:
                return "STATE_BUFFERING_PAUSED";
            case 8:
                return "PLAYER_STATE_STOPPED";
            case 9:
                return "STATE_COMPLETED";
            default:
                return "STATE_UNKNOWN";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rU() {
        long currentPosition = getCurrentPosition();
        long duration = getDuration();
        if (this.UJ != null) {
            Iterator<k> it = this.UJ.iterator();
            while (it.hasNext()) {
                it.next().onMediaPlayProgress(duration, currentPosition);
            }
        }
    }

    private void rX() {
        this.Uz.a(this.UM);
        this.Uz.b(this.UN);
        this.Uz.a(this.UO);
        this.Uz.a(this.UP);
        this.Uz.a(this.UQ);
        this.Uz.c(this.UR);
        this.Uz.a(this.US);
    }

    private void rY() {
        com.kwad.sdk.core.video.a.c cVar = this.Uz;
        if (cVar == null) {
            return;
        }
        cVar.a((c.InterfaceC0859c) null);
        this.Uz.a((c.b) null);
        this.Uz.b(null);
        this.Uz.a((c.i) null);
        this.Uz.c(null);
        this.Uz.a((c.g) null);
        this.Uz.a((c.a) null);
    }

    private void reset() {
        com.kwad.sdk.core.e.c.i(this.TAG, "reset:" + getStateString(this.Uy) + "->STATE_IDLE");
        aM(1);
        this.Uz.reset();
        this.Uy = 0;
    }

    private void sa() {
        sb();
        if (this.UC == null) {
            this.UC = new az() { // from class: com.kwad.components.core.video.b.3
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    b.this.rU();
                    if (b.this.UC != null) {
                        b.this.fS.postDelayed(b.this.UC, 500L);
                    }
                }
            };
        }
        this.fS.post(this.UC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sb() {
        Runnable runnable = this.UC;
        if (runnable != null) {
            this.fS.removeCallbacks(runnable);
            this.UC = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeepScreenOn(boolean z) {
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setKeepScreenOn(z);
        }
    }

    private void setPlayType(int i) {
        VideoPlayerStatus videoPlayerStatus;
        com.kwad.sdk.contentalliance.a.a.b bVar = this.UD;
        if (bVar != null && (videoPlayerStatus = bVar.videoPlayerStatus) != null) {
            videoPlayerStatus.mVideoPlayerType = i;
        }
    }

    public final void clear() {
        this.UJ.clear();
        this.UK.clear();
    }

    public final int getBufferPercentage() {
        return this.UA;
    }

    public final String getCurrentPlayingUrl() {
        com.kwad.sdk.core.video.a.c cVar = this.Uz;
        if (cVar == null) {
            return "";
        }
        return cVar.getCurrentPlayingUrl();
    }

    public final long getCurrentPosition() {
        com.kwad.sdk.core.video.a.c cVar = this.Uz;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    public final long getDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.Uz;
        if (cVar != null) {
            return cVar.getDuration();
        }
        return 0L;
    }

    public final int getMediaPlayerType() {
        com.kwad.sdk.core.video.a.c cVar = this.Uz;
        if (cVar != null) {
            return cVar.getMediaPlayerType();
        }
        return 0;
    }

    public final long getPlayDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.Uz;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    public final int getVideoHeight() {
        com.kwad.sdk.core.video.a.c cVar = this.Uz;
        if (cVar != null) {
            return cVar.getVideoHeight();
        }
        return 0;
    }

    public final int getVideoWidth() {
        com.kwad.sdk.core.video.a.c cVar = this.Uz;
        if (cVar != null) {
            return cVar.getVideoWidth();
        }
        return 0;
    }

    public final boolean isPlaying() {
        com.kwad.sdk.core.video.a.c cVar = this.Uz;
        if (cVar != null) {
            return cVar.isPlaying();
        }
        return false;
    }

    @Deprecated
    public final boolean isPrepared() {
        if (this.Uy != 2 && this.Uy != 3 && this.Uy != 5 && this.Uy != 8 && this.Uy != 9) {
            return false;
        }
        return true;
    }

    @Deprecated
    public final boolean isPreparing() {
        if (this.Uy == 1) {
            return true;
        }
        return false;
    }

    public final void onPlayStateChanged(final int i) {
        if (this.UJ == null) {
            return;
        }
        bo.runOnUiThread(new az() { // from class: com.kwad.components.core.video.b.2
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                for (k kVar : b.this.UJ) {
                    switch (i) {
                        case -1:
                            b.this.setKeepScreenOn(false);
                            b.this.sb();
                            kVar.onMediaPlayError(b.this.Ug, b.this.Uh);
                            break;
                        case 1:
                            kVar.onMediaPreparing();
                            break;
                        case 2:
                            kVar.onMediaPrepared();
                            break;
                        case 3:
                            b.this.setKeepScreenOn(true);
                            kVar.onMediaPlayStart();
                            break;
                        case 4:
                            b.this.setKeepScreenOn(true);
                            kVar.onMediaPlaying();
                            break;
                        case 5:
                            b.this.setKeepScreenOn(false);
                            kVar.onMediaPlayPaused();
                            break;
                        case 6:
                            kVar.onVideoPlayBufferingPlaying();
                            break;
                        case 7:
                            kVar.onVideoPlayBufferingPaused();
                            break;
                        case 9:
                            if (b.this.Uz != null && !b.this.Uz.isLooping()) {
                                b.this.setKeepScreenOn(false);
                                b.this.sb();
                            }
                            kVar.onMediaPlayCompleted();
                            break;
                    }
                }
            }
        });
    }

    public final boolean pause() {
        boolean z;
        com.kwad.sdk.core.e.c.i(this.TAG, "pause mCurrentState: " + getStateString(this.Uy));
        if (this.Uy == 4) {
            this.Uz.pause();
            com.kwad.sdk.core.e.c.i(this.TAG, "pause STATE_PLAYING->STATE_PAUSED");
            this.Uy = 5;
            onPlayStateChanged(this.Uy);
            com.kwad.sdk.core.video.a.a.a.eF("videoPausePlay");
            z = true;
        } else {
            z = false;
        }
        if (this.Uy == 6) {
            this.Uz.pause();
            com.kwad.sdk.core.e.c.i(this.TAG, "pause STATE_BUFFERING_PLAYING->STATE_PAUSED");
            this.Uy = 7;
            onPlayStateChanged(this.Uy);
            z = true;
        }
        if (this.Uy == 3) {
            this.Uz.pause();
            com.kwad.sdk.core.e.c.i(this.TAG, "pause STATE_STARTED->STATE_PAUSED");
            this.Uy = 5;
            onPlayStateChanged(this.Uy);
            com.kwad.sdk.core.video.a.a.a.eF("videoPausePlay");
            z = true;
        }
        if (this.Uy == 9 && this.Uz.isLooping()) {
            this.Uz.pause();
            com.kwad.sdk.core.e.c.i(this.TAG, "pause " + getStateString(this.Uy) + "->STATE_PAUSED");
            this.Uy = 5;
            onPlayStateChanged(this.Uy);
            return true;
        }
        return z;
    }

    public final void prepareAsync() {
        aP(false);
    }

    public final com.kwad.sdk.core.video.a.c rW() {
        return this.Uz;
    }

    public final void rZ() {
        if (this.Uz == null) {
            com.kwad.sdk.core.e.c.w("resetAndPlay", "mMediaPlayer is null");
            return;
        }
        if (this.Uy != 2 && this.Uy != 3 && this.Uy != 4 && this.Uy != 5) {
            reset();
            rY();
            rX();
            prepareAsync();
            return;
        }
        com.kwad.sdk.core.e.c.w("resetAndPlay", "can not resetAndPlay in state:");
    }

    public final void release() {
        a((a) null);
    }

    public final void releaseAsync() {
        a((a) null, true);
    }

    public final void restart() {
        if (this.Uz != null && this.Uy == 9) {
            start();
        }
        setPlayType(3);
    }

    public final void resume() {
        try {
            if (this.Uz == null) {
                com.kwad.sdk.core.e.c.e(this.TAG, "resume but mMediaPlayer is null");
                return;
            }
            com.kwad.sdk.core.e.c.i(this.TAG, "resume state: " + getStateString(this.Uy));
            if (this.Uy != 2 && this.Uy != 3 && this.Uy != 0) {
                if (this.Uy == 5) {
                    this.Uz.start();
                    com.kwad.sdk.core.e.c.i(this.TAG, "resume:" + getStateString(this.Uy) + "->STATE_PLAYING");
                    this.Uy = 4;
                    onPlayStateChanged(this.Uy);
                    setPlayType(2);
                    com.kwad.sdk.core.video.a.a.a.eF("videoResumePlay");
                    return;
                }
                if (this.Uy == 7) {
                    this.Uz.start();
                    com.kwad.sdk.core.e.c.i(this.TAG, "resume:" + getStateString(this.Uy) + "->STATE_BUFFERING_PLAYING");
                    this.Uy = 6;
                    onPlayStateChanged(this.Uy);
                    return;
                }
                if (this.Uy != 1) {
                    com.kwad.sdk.core.e.c.w(this.TAG, "resume: " + getStateString(this.Uy) + " 此时不能调用resume()方法.");
                    return;
                }
                return;
            }
            com.kwad.sdk.core.e.c.i(this.TAG, "resume:" + getStateString(this.Uy) + "->start()");
            start();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void seekTo(long j) {
        com.kwad.sdk.core.video.a.c cVar = this.Uz;
        if (cVar != null) {
            cVar.seekTo(j);
        }
    }

    public final void setAudioEnabled(boolean z) {
        if (z) {
            setVolume(1.0f, 1.0f);
        } else {
            setVolume(0.0f, 0.0f);
        }
    }

    public final void setRadius(float f, float f2, float f3, float f4) {
        this.mDetailVideoView.setRadius(f, f2, f3, f4);
    }

    public final void setSpeed(float f) {
        com.kwad.sdk.core.video.a.c cVar = this.Uz;
        if (cVar == null) {
            return;
        }
        cVar.setSpeed(f);
    }

    public final void setSurface(Surface surface) {
        com.kwad.sdk.core.video.a.c cVar = this.Uz;
        if (cVar != null) {
            cVar.setSurface(surface);
        }
    }

    public final void setVolume(float f, float f2) {
        com.kwad.sdk.core.video.a.c cVar = this.Uz;
        if (cVar == null) {
            return;
        }
        try {
            cVar.setVolume(f, f2);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    public final void start() {
        try {
            if (this.Uz == null) {
                return;
            }
            com.kwad.sdk.core.e.c.i(this.TAG, "start state: " + getStateString(this.Uy));
            aM(0);
            if (this.Uy == 0) {
                com.kwad.sdk.core.e.c.i(this.TAG, "start still not prepared well forcePrepare");
                aP(true);
                return;
            }
            if (this.Uy != 2 && this.Uy != 9) {
                if (this.Uy == 3) {
                    this.Uz.start();
                    return;
                }
                return;
            }
            this.mStartTime = System.currentTimeMillis();
            this.Uz.start();
            com.kwad.sdk.core.video.a.a.a.eF("videoStartPlay");
            if (this.UB != 0) {
                this.Uz.seekTo((int) r5);
            }
            com.kwad.sdk.core.e.c.i(this.TAG, "start:" + getStateString(this.Uy) + "->STATE_STARTED");
            com.kwad.sdk.contentalliance.a.a.b bVar = this.UD;
            if (bVar != null && bVar.videoPlayerStatus != null) {
                if (this.Uy == 2) {
                    if (this.UD.videoPlayerStatus.mVideoPlayerType == 0) {
                        setPlayType(1);
                    } else {
                        setPlayType(3);
                    }
                } else if (this.Uy == 9) {
                    setPlayType(3);
                }
            }
            this.Uy = 3;
            onPlayStateChanged(this.Uy);
            sa();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void stopAndPrepareAsync() {
        com.kwad.sdk.core.e.c.i(this.TAG, "stopAndPrepareAsync state: " + getStateString(this.Uy));
        if (this.Uy != 1 && this.Uy != 2) {
            if (this.Uy == 3 || this.Uy == 4 || this.Uy == 5 || this.Uy == 6 || this.Uy == 7 || this.Uy == 8 || this.Uy == 9) {
                try {
                    this.Uz.stop();
                    this.Uy = 8;
                    onPlayStateChanged(this.Uy);
                    prepareAsync();
                    return;
                } catch (Exception unused) {
                }
            }
            release();
        }
    }

    private b(@Nullable DetailVideoView detailVideoView, int i) {
        this.Uy = 0;
        this.fS = new Handler(Looper.getMainLooper());
        this.mStartTime = 0L;
        this.UE = 0;
        this.UF = new CopyOnWriteArrayList();
        this.UG = new AtomicBoolean(false);
        this.UH = false;
        this.UJ = new CopyOnWriteArrayList();
        this.UK = new CopyOnWriteArrayList();
        this.UL = new CopyOnWriteArrayList();
        this.UM = new c.f() { // from class: com.kwad.components.core.video.b.1
            @Override // com.kwad.sdk.core.video.a.c.f
            public final void sc() {
                b.this.Uy = 1;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.Uy);
            }
        };
        this.UN = new c.e() { // from class: com.kwad.components.core.video.b.4
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    com.kwad.sdk.core.e.c.i(b.this.TAG, "onPrepared:" + b.getStateString(b.this.Uy) + "->STATE_PREPARED");
                    b.this.Uy = 2;
                    b bVar = b.this;
                    bVar.onPlayStateChanged(bVar.Uy);
                    Iterator it = b.this.UL.iterator();
                    while (it.hasNext()) {
                        ((c.e) it.next()).a(b.this.Uz);
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
        this.UO = new c.i() { // from class: com.kwad.components.core.video.b.5
            @Override // com.kwad.sdk.core.video.a.c.i
            public final void k(int i2, int i3) {
                if (b.this.mDetailVideoView != null) {
                    b.this.mDetailVideoView.adaptVideoSize(i2, i3);
                }
                com.kwad.sdk.core.e.c.i(b.this.TAG, "onVideoSizeChanged ——> width：" + i2 + "， height：" + i3);
            }
        };
        this.UP = new c.b() { // from class: com.kwad.components.core.video.b.6
            @Override // com.kwad.sdk.core.video.a.c.b
            public final void py() {
                b.this.Uy = 9;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.Uy);
                com.kwad.sdk.core.video.a.a.a.eF("videoFinishPlay");
            }
        };
        this.UQ = new c.InterfaceC0859c() { // from class: com.kwad.components.core.video.b.7
            @Override // com.kwad.sdk.core.video.a.c.InterfaceC0859c
            public final boolean l(int i2, int i3) {
                if (i2 != -38) {
                    b.this.Uy = -1;
                    b.this.Ug = i2;
                    b.this.Uh = i3;
                    b bVar = b.this;
                    bVar.onPlayStateChanged(bVar.Uy);
                    com.kwad.sdk.core.e.c.i(b.this.TAG, "onError ——> STATE_ERROR ———— what：" + i2 + ", extra: " + i3);
                    return true;
                }
                return true;
            }
        };
        this.UR = new c.d() { // from class: com.kwad.components.core.video.b.8
            @Override // com.kwad.sdk.core.video.a.c.d
            public final boolean m(int i2, int i3) {
                if (i2 == 3) {
                    b.this.Uy = 4;
                    b bVar = b.this;
                    bVar.onPlayStateChanged(bVar.Uy);
                    com.kwad.sdk.core.e.c.i(b.this.TAG, "onInfo:" + b.getStateString(b.this.Uy) + "->STATE_PLAYING, time: " + (System.currentTimeMillis() - b.this.mStartTime));
                } else if (i2 == 701) {
                    if (b.this.Uy == 5 || b.this.Uy == 7) {
                        b.this.Uy = 7;
                        com.kwad.sdk.core.e.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED");
                    } else {
                        b.this.Uy = 6;
                        com.kwad.sdk.core.e.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING");
                    }
                    b bVar2 = b.this;
                    bVar2.onPlayStateChanged(bVar2.Uy);
                } else if (i2 == 702) {
                    if (b.this.Uy == 6) {
                        b.this.Uy = 4;
                        b bVar3 = b.this;
                        bVar3.onPlayStateChanged(bVar3.Uy);
                        com.kwad.sdk.core.e.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (b.this.Uy == 7) {
                        b.this.Uy = 5;
                        b bVar4 = b.this;
                        bVar4.onPlayStateChanged(bVar4.Uy);
                        com.kwad.sdk.core.e.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED");
                    }
                } else if (i2 != 10001) {
                    if (i2 != 801) {
                        com.kwad.sdk.core.e.c.i(b.this.TAG, "onInfo ——> what：" + i2);
                    } else {
                        com.kwad.sdk.core.e.c.i(b.this.TAG, "视频不能seekTo，为直播视频");
                    }
                }
                b bVar5 = b.this;
                bVar5.a(bVar5.Uz, i2, i3);
                return true;
            }
        };
        this.US = new c.a() { // from class: com.kwad.components.core.video.b.9
            @Override // com.kwad.sdk.core.video.a.c.a
            public final void av(int i2) {
                b.this.UA = i2;
            }
        };
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView != null) {
            this.mContext = detailVideoView.getContext().getApplicationContext();
        }
        this.UI = 0;
        String str = "DetailMediaPlayerImpl[0]";
        this.TAG = str;
        com.kwad.sdk.core.e.c.i(str, "create DetailMediaPlayerImpl");
    }

    public final void c(k kVar) {
        this.UJ.add(kVar);
    }

    public final void d(k kVar) {
        this.UJ.remove(kVar);
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, @NonNull DetailVideoView detailVideoView) {
        a(bVar, true, false, detailVideoView);
    }

    public final void b(c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.UF.remove(dVar);
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, boolean z, boolean z2, @NonNull DetailVideoView detailVideoView) {
        com.kwad.sdk.core.e.c.i(this.TAG, "initMediaPlayer enablePreLoad:" + z);
        if (bVar == null || detailVideoView == null) {
            return;
        }
        com.kwad.sdk.core.video.a.c a2 = com.kwad.sdk.core.video.a.e.a(this.mContext, z, com.kwad.sdk.core.config.d.yT(), com.kwad.sdk.core.config.d.yU(), this.UI);
        a2.setLooping(false);
        a(bVar, z2, detailVideoView, a2);
    }

    private void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, boolean z, @NonNull DetailVideoView detailVideoView, @NonNull com.kwad.sdk.core.video.a.c cVar) {
        com.kwad.sdk.core.e.c.i(this.TAG, "initMediaPlayer " + this.Uz);
        if (bVar == null || detailVideoView == null || cVar == null) {
            return;
        }
        if (this.mContext == null) {
            this.mContext = detailVideoView.getContext().getApplicationContext();
        }
        this.UH = z;
        this.UD = bVar;
        com.kwad.components.core.video.a.a a2 = com.kwad.components.core.video.a.d.a(bVar.adTemplate, this.mAdTemplate, bVar.videoUrl);
        c(a2);
        a(a2);
        DetailVideoView detailVideoView2 = this.mDetailVideoView;
        if (detailVideoView2 != detailVideoView) {
            com.kwad.sdk.core.e.c.i(this.TAG, "initMediaPlayer videoView changed");
            if (detailVideoView2 != null) {
                detailVideoView2.setMediaPlayer(null);
                detailVideoView.setKeepScreenOn(detailVideoView2.getKeepScreenOn());
                detailVideoView2.setKeepScreenOn(false);
            }
            this.mDetailVideoView = detailVideoView;
        }
        detailVideoView.setMediaPlayer(this);
        if (this.Uz != cVar) {
            com.kwad.sdk.core.e.c.i(this.TAG, "initMediaPlayer mediaPlayer changed");
            com.kwad.sdk.core.video.a.c cVar2 = this.Uz;
            if (cVar2 != null) {
                cVar.setLooping(cVar2.isLooping());
                rY();
                this.Uz.release();
            }
            this.Uz = cVar;
            reset();
            rX();
            cVar.setAudioStreamType(3);
        } else {
            com.kwad.sdk.core.e.c.i(this.TAG, "initMediaPlayer mediaPlayer not changed");
            reset();
            rY();
            rX();
        }
        this.Uz.setSurface(detailVideoView.Vb);
    }

    public b(@Nullable DetailVideoView detailVideoView, @NonNull AdTemplate adTemplate) {
        this(detailVideoView);
        this.mAdTemplate = adTemplate;
    }

    public final void start(long j) {
        this.UB = j;
        start();
    }

    public final void a(c.e eVar) {
        this.UL.add(eVar);
    }

    public final void a(c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.UF.add(dVar);
    }

    public final void a(com.kwad.sdk.core.video.a.c cVar, int i, int i2) {
        Iterator<c.d> it = this.UF.iterator();
        while (it.hasNext()) {
            c.d next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.m(i, i2);
            }
        }
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar) {
        try {
            if (!TextUtils.isEmpty(bVar.videoUrl)) {
                com.kwad.sdk.core.e.c.d(this.TAG, "videoUrl=" + bVar.videoUrl);
                this.Uz.a(bVar);
                return;
            }
            com.kwad.sdk.core.e.c.e(this.TAG, "videoUrl is null");
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
    }

    public final void a(final a aVar, boolean z) {
        if (this.Uz == null) {
            return;
        }
        com.kwad.sdk.core.e.c.i(this.TAG, "release:" + getStateString(this.Uy) + "->STATE_IDLE");
        setKeepScreenOn(false);
        this.fS.removeCallbacksAndMessages(null);
        sb();
        rY();
        this.mDetailVideoView = null;
        final com.kwad.sdk.core.video.a.c cVar = this.Uz;
        if (cVar != null) {
            if (z) {
                com.kwad.sdk.utils.g.execute(new az() { // from class: com.kwad.components.core.video.b.11
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        b.this.a(cVar, aVar);
                    }
                });
            } else {
                a(cVar, aVar);
            }
            this.Uz = null;
        }
        this.Uy = 0;
        this.UE = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.a.c cVar, a aVar) {
        if (cVar == null) {
            return;
        }
        com.kwad.sdk.core.e.c.i(this.TAG, "releaseMediaPlayer:" + getStateString(this.Uy) + "->STATE_IDLE");
        try {
            aM(2);
            cVar.release();
            if (aVar != null) {
                aVar.onReleaseSuccess();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }

    public final void a(a aVar) {
        a(aVar, true);
    }

    private void a(com.kwad.components.core.video.a.c cVar) {
        this.UK.add(cVar);
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.a aVar) {
        com.kwad.sdk.core.video.a.c cVar = this.Uz;
        if (cVar instanceof com.kwad.sdk.core.video.a.d) {
            ((com.kwad.sdk.core.video.a.d) cVar).a(aVar);
        }
    }
}
