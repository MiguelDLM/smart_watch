package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.core.video.a.e;
import com.kwad.sdk.core.video.a.f;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.i;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.y;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@Deprecated
/* loaded from: classes11.dex */
public final class a extends AdBasePvFrameLayout implements TextureView.SurfaceTextureListener, c {
    private static AtomicBoolean aCM = new AtomicBoolean(false);
    private int UA;
    private long UB;
    private com.kwad.sdk.contentalliance.a.a.b UD;
    private c.e UN;
    private c.i UO;
    private c.b UP;
    private c.InterfaceC0859c UQ;
    private c.d UR;
    private c.a US;
    private int Uy;
    private com.kwad.sdk.core.video.a.c Uz;
    private SurfaceTexture Va;
    private Surface Vb;
    private AudioManager aCI;
    private com.kwad.sdk.core.video.a aCJ;
    private b aCK;
    private boolean aCL;
    private boolean aCN;
    private boolean aCO;
    private ImageView aCP;
    private com.kwad.sdk.contentalliance.a.a.a dd;
    private FrameLayout hR;
    private Context mContext;
    private Map<String, String> mHeaders;
    private String mUrl;

    public a(Context context) {
        this(context, null);
    }

    private ImageView GR() {
        ImageView imageView = new ImageView(this.mContext);
        addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        return imageView;
    }

    private boolean GS() {
        if (this.Uy == 6) {
            return true;
        }
        return false;
    }

    private void GU() {
        boolean z;
        if (this.Uz == null) {
            f fVar = (f) ServiceProvider.get(f.class);
            boolean z2 = true;
            if (fVar != null && fVar.yT()) {
                z = true;
            } else {
                z = false;
            }
            if (fVar == null || !fVar.yU()) {
                z2 = false;
            }
            com.kwad.sdk.core.video.a.c a2 = e.a(this.mContext, false, z, z2, 0);
            this.Uz = a2;
            a2.setAudioStreamType(3);
            if (!this.aCN) {
                this.Uz.setVolume(0.0f, 0.0f);
            }
        }
    }

    private void GV() {
        this.hR.removeView(this.aCJ);
        this.hR.addView(this.aCJ, 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    private void GW() {
        com.kwad.sdk.contentalliance.a.a.a aVar;
        this.hR.setKeepScreenOn(true);
        this.Uz.b(this.UN);
        this.Uz.a(this.UO);
        this.Uz.a(this.UP);
        this.Uz.a(this.UQ);
        this.Uz.c(this.UR);
        this.Uz.a(this.US);
        try {
            com.kwad.sdk.contentalliance.a.a.b bVar = this.UD;
            if (bVar != null && (aVar = this.dd) != null) {
                bVar.apW = aVar;
            }
            this.Uz.a(bVar);
            if (this.Vb == null) {
                this.Vb = new Surface(this.Va);
            }
            this.Uz.setSurface(this.Vb);
            if (this.Uz.prepareAsync()) {
                this.Uy = 1;
                this.aCK.onPlayStateChanged(1);
                com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "STATE_PREPARING");
            }
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            com.kwad.sdk.core.e.c.e("KSVideoPlayerViewView", "打开播放器发生错误", e);
        }
    }

    private void GX() {
        AudioManager audioManager = this.aCI;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
            this.aCI = null;
        }
        com.kwad.sdk.core.video.a.c cVar = this.Uz;
        if (cVar != null) {
            cVar.release();
            this.Uz = null;
            com.kwad.sdk.core.video.a.a.a.eF("videoFinishPlay");
        }
        bo.runOnUiThread(new az() { // from class: com.kwad.sdk.core.video.videoview.a.7
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                a.this.hR.removeView(a.this.aCJ);
            }
        });
        Surface surface = this.Vb;
        if (surface != null) {
            surface.release();
            this.Vb = null;
        }
        SurfaceTexture surfaceTexture = this.Va;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.Va = null;
        }
        this.Uy = 0;
    }

    private void ej(AdTemplate adTemplate) {
        i iVar = (i) ServiceProvider.get(i.class);
        if (iVar != null) {
            iVar.load(this.aCP, com.kwad.sdk.core.response.b.e.dW(adTemplate), adTemplate);
        }
    }

    private void init() {
        this.aCP = GR();
        this.hR = new FrameLayout(this.mContext);
        addView(this.hR, new FrameLayout.LayoutParams(-1, -1));
    }

    private void sd() {
        if (this.aCJ == null) {
            com.kwad.sdk.core.video.a aVar = new com.kwad.sdk.core.video.a(this.mContext);
            this.aCJ = aVar;
            aVar.setSurfaceTextureListener(this);
        }
    }

    private void setPlayType(int i) {
        VideoPlayerStatus videoPlayerStatus;
        com.kwad.sdk.contentalliance.a.a.b bVar = this.UD;
        if (bVar != null && (videoPlayerStatus = bVar.videoPlayerStatus) != null) {
            videoPlayerStatus.mVideoPlayerType = i;
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean GT() {
        if (this.Uy == 7) {
            return true;
        }
        return false;
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.a.a.b bVar, Map<String, String> map) {
        this.UD = bVar;
        this.mUrl = bVar.videoUrl;
        this.mHeaders = null;
        ej(bVar.adTemplate);
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final int getBufferPercentage() {
        return this.UA;
    }

    public final b getController() {
        return this.aCK;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final long getCurrentPosition() {
        com.kwad.sdk.core.video.a.c cVar = this.Uz;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final long getDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.Uz;
        if (cVar != null) {
            return cVar.getDuration();
        }
        return 0L;
    }

    public final int getMaxVolume() {
        AudioManager audioManager = this.aCI;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return 0;
    }

    public final b getVideoController() {
        return this.aCK;
    }

    public final int getVolume() {
        AudioManager audioManager = this.aCI;
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    public final boolean isCompleted() {
        if (this.Uy == 9) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean isIdle() {
        if (this.Uy == 0) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean isPaused() {
        if (this.Uy == 5) {
            return true;
        }
        return false;
    }

    public final boolean isPlaying() {
        if (this.Uy == 4) {
            return true;
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        SurfaceTexture surfaceTexture2 = this.Va;
        if (surfaceTexture2 == null) {
            this.Va = surfaceTexture;
            GW();
        } else {
            this.aCJ.setSurfaceTexture(surfaceTexture2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void pause() {
        com.kwad.sdk.core.video.a.c cVar = this.Uz;
        if (cVar == null) {
            return;
        }
        int i = this.Uy;
        if (i == 4) {
            cVar.pause();
            com.kwad.sdk.core.video.a.a.a.eF("videoPausePlay");
            this.Uy = 5;
            this.aCK.onPlayStateChanged(5);
            com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "STATE_PAUSED");
            return;
        }
        if (i == 6) {
            cVar.pause();
            com.kwad.sdk.core.video.a.a.a.eF("videoPausePlay");
            this.Uy = 7;
            this.aCK.onPlayStateChanged(7);
            com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "STATE_BUFFERING_PAUSED");
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void release() {
        if (this.aCL) {
            if (!isPlaying() && !GS() && !GT() && !isPaused()) {
                if (isCompleted()) {
                    y.e(this.mContext, this.mUrl, 0L);
                }
            } else {
                y.e(this.mContext, this.mUrl, getCurrentPosition());
            }
        }
        GX();
        b bVar = this.aCK;
        if (bVar != null) {
            bVar.reset();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void restart() {
        int i = this.Uy;
        if (i == 5) {
            this.Uz.start();
            com.kwad.sdk.core.video.a.a.a.eF("videoResumePlay");
            this.Uy = 4;
            this.aCK.onPlayStateChanged(4);
            setPlayType(2);
            com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "STATE_PLAYING");
            return;
        }
        if (i == 7) {
            this.Uz.start();
            com.kwad.sdk.core.video.a.a.a.eF("videoResumePlay");
            this.Uy = 6;
            this.aCK.onPlayStateChanged(6);
            com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "STATE_BUFFERING_PLAYING");
            return;
        }
        if (i != 9 && i != -1) {
            com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "KSVideoPlayer在状态为 " + this.Uy + " 时不能调用restart()方法.");
            return;
        }
        this.Uz.reset();
        GW();
        setPlayType(3);
    }

    public final void seekTo(int i) {
        com.kwad.sdk.core.video.a.c cVar = this.Uz;
        if (cVar != null) {
            cVar.seekTo(i);
        }
    }

    public final void setController(b bVar) {
        this.hR.removeView(this.aCK);
        this.aCK = bVar;
        bVar.reset();
        this.hR.addView(this.aCK, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void setKsPlayLogParam(@NonNull com.kwad.sdk.contentalliance.a.a.a aVar) {
        this.dd = aVar;
    }

    public final void setLooping(boolean z) {
        com.kwad.sdk.core.video.a.c cVar = this.Uz;
        if (cVar != null) {
            cVar.setLooping(z);
        }
    }

    public final void setPortraitFullscreen(boolean z) {
        this.aCO = z;
    }

    public final void setVideoSoundEnable(boolean z) {
        this.aCN = z;
        com.kwad.sdk.core.video.a.c cVar = this.Uz;
        if (cVar != null) {
            if (z) {
                cVar.setVolume(1.0f, 1.0f);
            } else {
                cVar.setVolume(0.0f, 0.0f);
            }
        }
    }

    public final void setVolume(int i) {
        AudioManager audioManager = this.aCI;
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i, 0);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void start() {
        VideoPlayerStatus videoPlayerStatus;
        if (this.Uy == 0) {
            GU();
            sd();
            GV();
            com.kwad.sdk.contentalliance.a.a.b bVar = this.UD;
            if (bVar != null && (videoPlayerStatus = bVar.videoPlayerStatus) != null) {
                if (videoPlayerStatus.mVideoPlayerType == 0) {
                    setPlayType(1);
                } else {
                    setPlayType(3);
                }
            }
            com.kwad.sdk.core.video.a.a.a.eF("videoStartPlay");
            return;
        }
        com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "KSVideoPlayer只有在状态为STATE_IDLE时才能调用start方法.");
    }

    private a(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.Uy = 0;
        this.aCL = false;
        this.aCN = false;
        this.aCO = false;
        this.UN = new c.e() { // from class: com.kwad.sdk.core.video.videoview.a.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    a.this.Uy = 2;
                    a.this.aCK.onPlayStateChanged(a.this.Uy);
                    com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onPrepared ——> STATE_PREPARED");
                    cVar.start();
                    if (a.this.aCL) {
                        cVar.seekTo((int) y.U(a.this.mContext, a.this.mUrl));
                    }
                    if (a.this.UB != 0) {
                        cVar.seekTo((int) a.this.UB);
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
        this.UO = new c.i() { // from class: com.kwad.sdk.core.video.videoview.a.2
            @Override // com.kwad.sdk.core.video.a.c.i
            public final void k(int i, int i2) {
                if (a.this.aCO && i2 > i) {
                    return;
                }
                a.this.aCJ.adaptVideoSize(i, i2);
                com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onVideoSizeChanged ——> width：" + i + "， height：" + i2);
            }
        };
        this.UP = new c.b() { // from class: com.kwad.sdk.core.video.videoview.a.3
            @Override // com.kwad.sdk.core.video.a.c.b
            public final void py() {
                if (a.this.Uy != 9) {
                    a.this.Uy = 9;
                    a.this.aCK.onPlayStateChanged(a.this.Uy);
                    com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onCompletion ——> STATE_COMPLETED");
                    a.this.hR.setKeepScreenOn(false);
                }
            }
        };
        this.UQ = new c.InterfaceC0859c() { // from class: com.kwad.sdk.core.video.videoview.a.4
            @Override // com.kwad.sdk.core.video.a.c.InterfaceC0859c
            public final boolean l(int i, int i2) {
                if (i != -38) {
                    a.this.Uy = -1;
                    a.this.aCK.n(i, i2);
                    a.this.aCK.onPlayStateChanged(a.this.Uy);
                    com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onError ——> STATE_ERROR ———— what：" + i + ", extra: " + i2);
                    return true;
                }
                return true;
            }
        };
        this.UR = new c.d() { // from class: com.kwad.sdk.core.video.videoview.a.5
            @Override // com.kwad.sdk.core.video.a.c.d
            public final boolean m(int i, int i2) {
                if (i == 3) {
                    a.this.Uy = 4;
                    a.this.aCK.onPlayStateChanged(a.this.Uy);
                    com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING");
                    return true;
                }
                if (i == 701) {
                    if (a.this.Uy == 5 || a.this.Uy == 7) {
                        a.this.Uy = 7;
                        com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED");
                    } else {
                        a.this.Uy = 6;
                        com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING");
                    }
                    a.this.aCK.onPlayStateChanged(a.this.Uy);
                    return true;
                }
                if (i == 702) {
                    if (a.this.Uy == 6) {
                        a.this.Uy = 4;
                        a.this.aCK.onPlayStateChanged(a.this.Uy);
                        com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (a.this.Uy == 7) {
                        a.this.Uy = 5;
                        a.this.aCK.onPlayStateChanged(a.this.Uy);
                        com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED");
                        return true;
                    }
                    return true;
                }
                if (i == 10001) {
                    if (a.this.aCJ != null) {
                        a.this.aCJ.setRotation(i2);
                        com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "视频旋转角度：" + i2);
                        return true;
                    }
                    return true;
                }
                if (i == 801) {
                    com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "视频不能seekTo，为直播视频");
                    return true;
                }
                com.kwad.sdk.core.e.c.i("KSVideoPlayerViewView", "onInfo ——> what：" + i);
                return true;
            }
        };
        this.US = new c.a() { // from class: com.kwad.sdk.core.video.videoview.a.6
            @Override // com.kwad.sdk.core.video.a.c.a
            public final void av(int i) {
                a.this.UA = i;
            }
        };
        this.mContext = context;
        init();
    }
}
