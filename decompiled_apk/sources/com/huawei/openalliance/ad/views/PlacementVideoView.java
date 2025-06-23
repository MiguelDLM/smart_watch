package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.fr;
import com.huawei.hms.ads.gf;
import com.huawei.hms.ads.gj;
import com.huawei.hms.ads.gv;
import com.huawei.hms.ads.ih;
import com.huawei.hms.ads.iu;
import com.huawei.hms.ads.kr;
import com.huawei.hms.ads.placement.R;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.inter.data.p;
import com.huawei.openalliance.ad.media.MediaPlayerAgent;
import com.huawei.openalliance.ad.media.listener.MediaStateListener;

/* loaded from: classes10.dex */
public class PlacementVideoView extends PlacementMediaView implements gf, kr {
    private iu D;
    private VideoView L;

    /* renamed from: a, reason: collision with root package name */
    private boolean f17431a;
    private p b;
    private boolean c;
    private boolean d;
    private long e;
    private long f;
    private boolean g;
    private boolean h;
    private int i;
    private fr j;
    private gv k;
    private com.huawei.openalliance.ad.media.e l;
    private com.huawei.openalliance.ad.media.listener.b m;
    private MediaStateListener n;
    private com.huawei.openalliance.ad.media.listener.f o;
    private com.huawei.openalliance.ad.media.listener.c p;

    public PlacementVideoView(Context context) {
        super(context);
        this.d = true;
        this.k = new gj();
        this.m = new com.huawei.openalliance.ad.media.listener.b() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.2
            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code() {
                if (fb.Code()) {
                    fb.Code(PlacementVideoView.this.getTAG(), "contentId: %s onBufferingStart", ((PlacementMediaView) PlacementVideoView.this).I);
                }
                PlacementVideoView.this.j.V();
                PlacementVideoView.this.k.b();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void V() {
                PlacementVideoView.this.k.c();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code(int i) {
            }
        };
        this.n = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.3
            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i) {
                fb.V("PlacementVideoView", "onMediaCompletion");
                PlacementVideoView.this.Code(i, true);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i) {
                fb.V("PlacementVideoView", "onMediaPause");
                PlacementVideoView.this.Code(i, false);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i) {
                if (fb.Code()) {
                    fb.Code(PlacementVideoView.this.getTAG(), "contentId: %s onMediaStart:  %s", ((PlacementMediaView) PlacementVideoView.this).I, Integer.valueOf(i));
                }
                PlacementVideoView.this.g = true;
                PlacementVideoView.this.f = i;
                PlacementVideoView.this.e = System.currentTimeMillis();
                iu iuVar = PlacementVideoView.this.D;
                if (i > 0) {
                    iuVar.V();
                } else {
                    iuVar.Code();
                    PlacementVideoView.this.D.Code(PlacementVideoView.this.j.B(), PlacementVideoView.this.j.Z(), PlacementVideoView.this.e);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i) {
                fb.V("PlacementVideoView", "onMediaStop");
                PlacementVideoView.this.Code(i, false);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onProgress(int i, int i2) {
            }
        };
        this.o = new com.huawei.openalliance.ad.media.listener.f() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.4
            @Override // com.huawei.openalliance.ad.media.listener.f
            public void Code() {
                if (PlacementVideoView.this.b != null) {
                    PlacementVideoView.this.b.Code("n");
                    PlacementVideoView.this.k.V(0.0f);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.f
            public void V() {
                if (PlacementVideoView.this.b != null) {
                    PlacementVideoView.this.b.Code("y");
                    PlacementVideoView.this.k.V(1.0f);
                }
            }
        };
        this.p = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.5
            @Override // com.huawei.openalliance.ad.media.listener.c
            public void Code(MediaPlayerAgent mediaPlayerAgent, int i, int i2, int i3) {
                PlacementVideoView.this.Code(i, false);
            }
        };
        Code(context);
    }

    private void a() {
        if (this.Code == null) {
            return;
        }
        fb.V(getTAG(), "loadVideoInfo");
        p S = this.Code.S();
        if (S == null || !S.V()) {
            return;
        }
        this.b = S;
        Float f = S.f();
        if (f != null) {
            setRatio(f);
            this.L.setRatio(f);
        }
        this.L.setDefaultDuration((int) this.b.d());
        this.D.Code(this.b);
        this.c = false;
        this.d = true;
    }

    private void b() {
        fb.V(getTAG(), "resetVideoView");
        setPreferStartPlayTime(0);
        this.f17431a = false;
        this.c = false;
        this.d = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getTAG() {
        return "PlacementVideoView_" + hashCode();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public boolean D() {
        return this.L.a();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void F() {
        this.L.D();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void S() {
        this.L.L();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView, com.huawei.hms.ads.kw
    public void destroyView() {
        fb.V(getTAG(), "destroyView");
        this.L.destroyView();
        this.k.I();
    }

    public com.huawei.openalliance.ad.media.b getCurrentState() {
        return this.L.getCurrentState();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public ImageView getLastFrame() {
        if (this.L == null) {
            return null;
        }
        ImageView imageView = new ImageView(getContext());
        imageView.setImageBitmap(this.L.getSurfaceBitmap());
        return imageView;
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public com.huawei.openalliance.ad.media.b getMediaState() {
        VideoView videoView = this.L;
        if (videoView != null) {
            return videoView.getMediaState();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView, com.huawei.hms.ads.gf
    public View getOpenMeasureView() {
        return this;
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView, com.huawei.hms.ads.kw
    public void pauseView() {
        fb.V(getTAG(), "pauseView");
        this.L.pauseView();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView, com.huawei.hms.ads.kw
    public void resumeView() {
        fb.V(getTAG(), "resumeView");
        this.L.resumeView();
        this.L.setNeedPauseOnSurfaceDestory(true);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void setAudioFocusType(int i) {
        this.L.setAudioFocusType(i);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void setMediaPlayerReleaseListener(com.huawei.openalliance.ad.media.listener.e eVar) {
        VideoView videoView = this.L;
        if (videoView != null) {
            videoView.setMediaPlayerReleaseListener(eVar);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void setPlacementAd(com.huawei.openalliance.ad.inter.data.h hVar) {
        com.huawei.openalliance.ad.media.b currentState = this.L.getCurrentState();
        if (this.Code == hVar && currentState.V(com.huawei.openalliance.ad.media.d.IDLE) && currentState.V(com.huawei.openalliance.ad.media.d.ERROR)) {
            fb.V(getTAG(), "setPlacementVideoAd - has the same ad");
            return;
        }
        super.setPlacementAd(hVar);
        String tag = getTAG();
        StringBuilder sb = new StringBuilder();
        sb.append("set placement ad:");
        sb.append(hVar == null ? "null" : hVar.a());
        fb.V(tag, sb.toString());
        b();
        this.D.Code(this.Code);
        if (this.Code != null) {
            a();
        } else {
            this.b = null;
        }
    }

    public void setPreferStartPlayTime(int i) {
        this.i = i;
        this.L.setPreferStartPlayTime(i);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void setSoundVolume(float f) {
        this.L.setSoundVolume(f);
    }

    public PlacementVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = true;
        this.k = new gj();
        this.m = new com.huawei.openalliance.ad.media.listener.b() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.2
            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code() {
                if (fb.Code()) {
                    fb.Code(PlacementVideoView.this.getTAG(), "contentId: %s onBufferingStart", ((PlacementMediaView) PlacementVideoView.this).I);
                }
                PlacementVideoView.this.j.V();
                PlacementVideoView.this.k.b();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void V() {
                PlacementVideoView.this.k.c();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code(int i) {
            }
        };
        this.n = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.3
            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i) {
                fb.V("PlacementVideoView", "onMediaCompletion");
                PlacementVideoView.this.Code(i, true);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i) {
                fb.V("PlacementVideoView", "onMediaPause");
                PlacementVideoView.this.Code(i, false);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i) {
                if (fb.Code()) {
                    fb.Code(PlacementVideoView.this.getTAG(), "contentId: %s onMediaStart:  %s", ((PlacementMediaView) PlacementVideoView.this).I, Integer.valueOf(i));
                }
                PlacementVideoView.this.g = true;
                PlacementVideoView.this.f = i;
                PlacementVideoView.this.e = System.currentTimeMillis();
                iu iuVar = PlacementVideoView.this.D;
                if (i > 0) {
                    iuVar.V();
                } else {
                    iuVar.Code();
                    PlacementVideoView.this.D.Code(PlacementVideoView.this.j.B(), PlacementVideoView.this.j.Z(), PlacementVideoView.this.e);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i) {
                fb.V("PlacementVideoView", "onMediaStop");
                PlacementVideoView.this.Code(i, false);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onProgress(int i, int i2) {
            }
        };
        this.o = new com.huawei.openalliance.ad.media.listener.f() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.4
            @Override // com.huawei.openalliance.ad.media.listener.f
            public void Code() {
                if (PlacementVideoView.this.b != null) {
                    PlacementVideoView.this.b.Code("n");
                    PlacementVideoView.this.k.V(0.0f);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.f
            public void V() {
                if (PlacementVideoView.this.b != null) {
                    PlacementVideoView.this.b.Code("y");
                    PlacementVideoView.this.k.V(1.0f);
                }
            }
        };
        this.p = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.5
            @Override // com.huawei.openalliance.ad.media.listener.c
            public void Code(MediaPlayerAgent mediaPlayerAgent, int i, int i2, int i3) {
                PlacementVideoView.this.Code(i, false);
            }
        };
        Code(context);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void B() {
        this.h = false;
        this.L.c();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void C() {
        com.huawei.openalliance.ad.media.e eVar = this.l;
        if (eVar != null) {
            eVar.Code();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void I() {
        this.h = true;
        this.L.b();
    }

    public PlacementVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = true;
        this.k = new gj();
        this.m = new com.huawei.openalliance.ad.media.listener.b() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.2
            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code() {
                if (fb.Code()) {
                    fb.Code(PlacementVideoView.this.getTAG(), "contentId: %s onBufferingStart", ((PlacementMediaView) PlacementVideoView.this).I);
                }
                PlacementVideoView.this.j.V();
                PlacementVideoView.this.k.b();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void V() {
                PlacementVideoView.this.k.c();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code(int i2) {
            }
        };
        this.n = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.3
            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i2) {
                fb.V("PlacementVideoView", "onMediaCompletion");
                PlacementVideoView.this.Code(i2, true);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i2) {
                fb.V("PlacementVideoView", "onMediaPause");
                PlacementVideoView.this.Code(i2, false);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i2) {
                if (fb.Code()) {
                    fb.Code(PlacementVideoView.this.getTAG(), "contentId: %s onMediaStart:  %s", ((PlacementMediaView) PlacementVideoView.this).I, Integer.valueOf(i2));
                }
                PlacementVideoView.this.g = true;
                PlacementVideoView.this.f = i2;
                PlacementVideoView.this.e = System.currentTimeMillis();
                iu iuVar = PlacementVideoView.this.D;
                if (i2 > 0) {
                    iuVar.V();
                } else {
                    iuVar.Code();
                    PlacementVideoView.this.D.Code(PlacementVideoView.this.j.B(), PlacementVideoView.this.j.Z(), PlacementVideoView.this.e);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i2) {
                fb.V("PlacementVideoView", "onMediaStop");
                PlacementVideoView.this.Code(i2, false);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onProgress(int i2, int i22) {
            }
        };
        this.o = new com.huawei.openalliance.ad.media.listener.f() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.4
            @Override // com.huawei.openalliance.ad.media.listener.f
            public void Code() {
                if (PlacementVideoView.this.b != null) {
                    PlacementVideoView.this.b.Code("n");
                    PlacementVideoView.this.k.V(0.0f);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.f
            public void V() {
                if (PlacementVideoView.this.b != null) {
                    PlacementVideoView.this.b.Code("y");
                    PlacementVideoView.this.k.V(1.0f);
                }
            }
        };
        this.p = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.5
            @Override // com.huawei.openalliance.ad.media.listener.c
            public void Code(MediaPlayerAgent mediaPlayerAgent, int i2, int i22, int i3) {
                PlacementVideoView.this.Code(i2, false);
            }
        };
        Code(context);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code() {
        this.L.B();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void I(int i) {
        com.huawei.openalliance.ad.media.e eVar = this.l;
        if (eVar != null) {
            eVar.V(i);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void V() {
        if (this.L != null) {
            fb.V("PlacementVideoView", "release player");
            this.L.f();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(int i) {
        Code(i, true);
        this.L.B();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void I(com.huawei.openalliance.ad.media.listener.i iVar) {
        this.L.I(iVar);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void V(int i) {
        com.huawei.openalliance.ad.media.e eVar = this.l;
        if (eVar != null) {
            eVar.Code(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i, boolean z) {
        fb.V("PlacementVideoView", "onVideoEnd, videoComplete: %s", Boolean.valueOf(z));
        this.j.I();
        if (this.g) {
            this.g = false;
            setPreferStartPlayTime(i);
            if (z) {
                this.D.Code(this.e, System.currentTimeMillis(), this.f, i);
            } else {
                this.D.V(this.e, System.currentTimeMillis(), this.f, i);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void V(long j) {
        com.huawei.openalliance.ad.media.e eVar = this.l;
        if (eVar != null) {
            eVar.Code(j);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(long j) {
        this.D.Code(j);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void V(com.huawei.openalliance.ad.media.listener.f fVar) {
        this.L.V(fVar);
    }

    private void Code(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hiad_placement_pure_video_view, this);
        this.D = new ih(context, this);
        this.j = new fr(getTAG());
        VideoView videoView = (VideoView) findViewById(R.id.hiad_id_video_view);
        this.L = videoView;
        videoView.setScreenOnWhilePlaying(true);
        this.L.setAutoScaleResizeLayoutOnVideoSizeChange(false);
        this.L.Code(this.n);
        this.L.Code(this.m);
        this.L.Code(this.p);
        this.L.Code(this.o);
        this.L.setMuteOnlyOnLostAudioFocus(true);
        this.L.setRemediate(true);
        com.huawei.openalliance.ad.media.e eVar = new com.huawei.openalliance.ad.media.e(context);
        this.l = eVar;
        eVar.Code(new com.huawei.openalliance.ad.media.listener.h() { // from class: com.huawei.openalliance.ad.views.PlacementVideoView.1
            @Override // com.huawei.openalliance.ad.media.listener.h
            public void Code(long j) {
                if (fb.Code()) {
                    fb.Code("PlacementVideoView", "reportVideoTime: %s", Long.valueOf(j));
                }
                if (PlacementVideoView.this.D != null) {
                    PlacementVideoView.this.D.Code(PlacementVideoView.this.getContext(), j);
                }
            }
        });
    }

    private void V(boolean z, boolean z2) {
        fb.V(getTAG(), "doRealPlay, auto:" + z + ", isMute:" + z2);
        this.j.Code();
        if (z2) {
            this.L.b();
        } else {
            this.L.c();
        }
        if (!this.L.getCurrentState().Code(com.huawei.openalliance.ad.media.d.PLAYBACK_COMPLETED)) {
            this.L.setPreferStartPlayTime(this.i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            this.L.I(this.i, 1);
        } else {
            this.L.Code(this.i);
        }
        this.L.Code(z);
    }

    public void Code(gv gvVar) {
        this.k = gvVar;
    }

    @Override // com.huawei.hms.ads.kr
    public void Code(p pVar, boolean z) {
        fb.V(getTAG(), "onCheckVideoHashResult sucess: %s", Boolean.valueOf(z));
        if (!z || this.b == null || pVar == null) {
            return;
        }
        this.b = pVar;
        this.f17431a = true;
        String e = pVar.e();
        if (TextUtils.isEmpty(e)) {
            e = pVar.Z();
        }
        ((PlacementMediaView) this).V = e;
        this.L.setVideoFileUrl(e);
        VideoView videoView = this.L;
        n nVar = this.Code;
        videoView.setContentId(nVar == null ? null : nVar.a());
        if (this.c) {
            fb.V(getTAG(), "play when hash check success");
            V(true, this.h);
        }
        if (this.d) {
            fb.V(getTAG(), "prefect when hash check success");
            this.L.e();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(com.huawei.openalliance.ad.media.listener.b bVar) {
        this.L.Code(bVar);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(com.huawei.openalliance.ad.media.listener.c cVar) {
        this.L.Code(cVar);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(com.huawei.openalliance.ad.media.listener.f fVar) {
        this.L.Code(fVar);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(com.huawei.openalliance.ad.media.listener.g gVar) {
        this.L.Code(gVar);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(com.huawei.openalliance.ad.media.listener.i iVar) {
        this.L.Code(iVar);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(String str) {
        this.D.Code(str);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(boolean z, boolean z2) {
        fb.V(getTAG(), "play, auto:" + z + ", isMute:" + z2);
        if (this.f17431a) {
            V(z, z2);
        } else {
            this.c = true;
            this.h = z2;
        }
    }
}
