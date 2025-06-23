package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.bx;
import com.huawei.hms.ads.et;
import com.huawei.hms.ads.eu;
import com.huawei.hms.ads.ev;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.fr;
import com.huawei.hms.ads.gf;
import com.huawei.hms.ads.gj;
import com.huawei.hms.ads.gv;
import com.huawei.hms.ads.ht;
import com.huawei.hms.ads.hu;
import com.huawei.hms.ads.ia;
import com.huawei.hms.ads.in;
import com.huawei.hms.ads.ja;
import com.huawei.hms.ads.kd;
import com.huawei.hms.ads.ki;
import com.huawei.hms.ads.kw;
import com.huawei.hms.ads.nativead.MediaContent;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.hms.ads.nativead.R;
import com.huawei.hms.ads.u;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import com.huawei.openalliance.ad.inter.data.VideoInfo;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.media.MediaPlayerAgent;
import com.huawei.openalliance.ad.media.listener.MediaStateListener;
import com.huawei.openalliance.ad.utils.am;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.views.j;

/* loaded from: classes10.dex */
public class NativeVideoView extends NativeMediaView implements gf, kd, kw {
    private static final String S = "NativeVideoView";
    private a D;
    private gv F;
    private boolean L;

    /* renamed from: a, reason: collision with root package name */
    private j f17418a;
    private in b;
    private VideoInfo c;
    private ImageInfo d;
    private boolean e;
    private int f;
    private boolean g;
    private long h;
    private NativeVideoControlPanel i;
    private VideoView j;
    private ki k;
    private MediaContent l;
    private long m;
    private long n;
    private boolean o;
    private fr p;
    private boolean q;
    private final com.huawei.openalliance.ad.media.listener.b r;
    private final com.huawei.openalliance.ad.media.listener.h s;
    private final MediaStateListener t;
    private final com.huawei.openalliance.ad.media.listener.c u;
    private com.huawei.openalliance.ad.media.listener.d v;
    private com.huawei.openalliance.ad.media.listener.f w;
    private j.a x;

    /* loaded from: classes10.dex */
    public interface a {
        void Code();

        void Code(boolean z);

        void Code(boolean z, int i);

        void I();

        void V();

        void V(boolean z, int i);

        void Z();
    }

    public NativeVideoView(Context context) {
        super(context);
        this.F = new gj();
        this.L = false;
        this.e = false;
        this.f = 0;
        this.g = false;
        this.q = false;
        this.r = new com.huawei.openalliance.ad.media.listener.b() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.1
            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code() {
                if (fb.Code()) {
                    fb.Code(NativeVideoView.S, "onBufferingStart");
                }
                NativeVideoView.this.p.V();
                NativeVideoView.this.F.b();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void V() {
                NativeVideoView.this.F.c();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code(int i) {
            }
        };
        this.s = new com.huawei.openalliance.ad.media.listener.h() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.2
            @Override // com.huawei.openalliance.ad.media.listener.h
            public void Code(long j) {
                if (fb.Code()) {
                    fb.Code(NativeVideoView.S, "reportVideoTime: %s", Long.valueOf(j));
                }
                if (NativeVideoView.this.b != null) {
                    NativeVideoView.this.b.Code(NativeVideoView.this.getContext(), j);
                }
            }
        };
        this.t = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.3
            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i) {
                NativeVideoView.this.Code(i, true);
                NativeVideoView.this.m();
                if (NativeVideoView.this.b != null) {
                    long j = i;
                    NativeVideoView.this.b.Code(NativeVideoView.this.getContext(), j, j);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i) {
                NativeVideoView.this.Code(i, false);
                NativeVideoView.this.l();
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i) {
                if (fb.Code()) {
                    fb.Code(NativeVideoView.S, "onMediaStart: %s", Integer.valueOf(i));
                }
                if (NativeVideoView.this.L) {
                    return;
                }
                NativeVideoView.this.L = true;
                NativeVideoView.this.n = i;
                NativeVideoView.this.m = System.currentTimeMillis();
                NativeVideoView.this.j();
                if (i > 0) {
                    NativeVideoView.this.F.f();
                    NativeVideoView.this.b.V();
                    return;
                }
                if (NativeVideoView.this.F != null && NativeVideoView.this.c != null) {
                    NativeVideoView.this.F.Code(NativeVideoView.this.c.I(), true ^ "y".equals(NativeVideoView.this.c.a()));
                }
                NativeVideoView.this.b.Code();
                NativeVideoView.this.b.Code(NativeVideoView.this.p.B(), NativeVideoView.this.p.Z(), NativeVideoView.this.m);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i) {
                NativeVideoView.this.Code(i, false);
                NativeVideoView.this.k();
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onProgress(int i, int i2) {
                if (NativeVideoView.this.L) {
                    NativeVideoView.this.F.Code(i);
                    if (NativeVideoView.this.b != null) {
                        NativeVideoView.this.b.Code(NativeVideoView.this.getContext(), i2, NativeVideoView.this.c == null ? 0L : NativeVideoView.this.c.I());
                    }
                }
            }
        };
        this.u = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.4
            @Override // com.huawei.openalliance.ad.media.listener.c
            public void Code(MediaPlayerAgent mediaPlayerAgent, int i, int i2, int i3) {
                NativeVideoView.this.Code(i, false);
                NativeVideoView nativeVideoView = NativeVideoView.this;
                if (((NativeMediaView) nativeVideoView).I || am.Z(nativeVideoView.getContext())) {
                    return;
                }
                Toast makeText = Toast.makeText(NativeVideoView.this.getContext(), R.string.hiad_network_error, 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        };
        this.v = new com.huawei.openalliance.ad.media.listener.d() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.5
            @Override // com.huawei.openalliance.ad.media.listener.d
            public void Code(int i) {
                NativeVideoView.this.f17418a.I(i);
            }

            @Override // com.huawei.openalliance.ad.media.listener.d
            public void V(int i) {
            }
        };
        this.w = new com.huawei.openalliance.ad.media.listener.f() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.6
            @Override // com.huawei.openalliance.ad.media.listener.f
            public void Code() {
                fb.V(NativeVideoView.S, "onMute");
                if (NativeVideoView.this.c != null) {
                    NativeVideoView.this.c.Code("n");
                    if (NativeVideoView.this.o || !NativeVideoView.this.L) {
                        NativeVideoView.this.o = false;
                    } else {
                        NativeVideoView.this.b.Code(true);
                    }
                    NativeVideoView.this.F.V(0.0f);
                }
                NativeVideoView.this.f17418a.B(true);
                if (NativeVideoView.this.D != null) {
                    NativeVideoView.this.D.Code(true);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.f
            public void V() {
                fb.V(NativeVideoView.S, "onUnmute");
                if (NativeVideoView.this.c != null) {
                    NativeVideoView.this.o = false;
                    NativeVideoView.this.c.Code("y");
                    NativeVideoView.this.b.Code(false);
                    NativeVideoView.this.F.V(1.0f);
                }
                NativeVideoView.this.f17418a.B(false);
                if (NativeVideoView.this.D != null) {
                    NativeVideoView.this.D.Code(false);
                }
            }
        };
        this.x = new j.a() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.7
            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code() {
                if (NativeVideoView.this.k != null) {
                    NativeVideoView.this.k.Code(5, false);
                }
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void V(boolean z, int i) {
                NativeVideoView.this.V(z, i);
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code(boolean z) {
                fb.V(NativeVideoView.S, "doRealPlay, auto:" + z);
                NativeVideoView.this.p.Code();
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public boolean V() {
                return NativeVideoView.this.i() && !NativeVideoView.this.q;
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code(boolean z, int i) {
                NativeVideoView.this.Code(z, i);
            }
        };
        Code(context);
    }

    private void b() {
        fb.V(S, "setInnerListener");
        this.j.Code(this.u);
        this.j.Code(this.w);
        this.f17418a.Z(!g());
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0013, code lost:
    
        if ((r0 instanceof com.huawei.hms.ads.bx) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void e() {
        /*
            r2 = this;
            com.huawei.openalliance.ad.inter.data.l r0 = r2.B
            if (r0 != 0) goto L5
            return
        L5:
            com.huawei.hms.ads.nativead.MediaContent r0 = r2.l
            if (r0 == 0) goto L19
            android.graphics.drawable.Drawable r0 = r0.getImage()
            if (r0 == 0) goto L19
            com.huawei.hms.ads.nativead.MediaContent r0 = r2.l
            boolean r1 = r0 instanceof com.huawei.hms.ads.bx
            if (r1 != 0) goto L19
        L15:
            r2.Code(r0)
            goto L58
        L19:
            com.huawei.openalliance.ad.inter.data.l r0 = r2.B
            java.util.List r0 = r0.B()
            if (r0 == 0) goto L58
            int r1 = r0.size()
            if (r1 <= 0) goto L58
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.huawei.openalliance.ad.inter.data.ImageInfo r0 = (com.huawei.openalliance.ad.inter.data.ImageInfo) r0
            r2.d = r0
            if (r0 == 0) goto L58
            com.huawei.hms.ads.nativead.MediaContent r0 = r2.l
            if (r0 == 0) goto L53
            android.graphics.drawable.Drawable r0 = r0.getImage()
            if (r0 == 0) goto L53
            com.huawei.hms.ads.nativead.MediaContent r0 = r2.l
            boolean r1 = r0 instanceof com.huawei.hms.ads.bx
            if (r1 == 0) goto L15
            com.huawei.hms.ads.bx r0 = (com.huawei.hms.ads.bx) r0
            com.huawei.openalliance.ad.inter.data.ImageInfo r1 = r2.d
            java.lang.String r1 = r1.Z()
            boolean r0 = r0.Code(r1)
            if (r0 == 0) goto L53
            com.huawei.hms.ads.nativead.MediaContent r0 = r2.l
            goto L15
        L53:
            com.huawei.openalliance.ad.inter.data.ImageInfo r0 = r2.d
            r2.Code(r0)
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.views.NativeVideoView.e():void");
    }

    private void f() {
        this.e = false;
        this.f17418a.S(true);
    }

    private boolean g() {
        if (!o() || ja.d(((NativeMediaView) this).B.m_()) || h()) {
            VideoInfo videoInfo = this.c;
            return videoInfo != null && TextUtils.equals(videoInfo.a(), "y");
        }
        boolean isStartMuted = ((NativeMediaView) this).B.h_().isStartMuted();
        fb.V(S, "VideoConfig, isMute: %s", Boolean.valueOf(isStartMuted));
        return !isStartMuted;
    }

    private int getAutoPlayNetForVideoCtrlBridge() {
        l lVar = ((NativeMediaView) this).B;
        if (lVar == null) {
            return 0;
        }
        return (lVar.h_() == null || (ja.c(((NativeMediaView) this).B.m_()) && this.c != null)) ? this.c.f() : ((NativeMediaView) this).B.h_().getAutoPlayNetwork();
    }

    private int getContinuePlayTime() {
        VideoInfo videoInfo = this.c;
        if (videoInfo == null) {
            fb.Code(S, "getContinuePlayTime other");
            return 0;
        }
        int L = videoInfo.L();
        if (L >= 5000) {
            return L;
        }
        return 0;
    }

    private String getTAG() {
        return S + "_" + hashCode();
    }

    private boolean h() {
        j jVar = this.f17418a;
        return jVar != null && jVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        VideoInfo videoInfo = this.c;
        if (videoInfo == null) {
            return false;
        }
        if (videoInfo.L() >= this.c.I()) {
            this.c.Code(0);
            fb.V(S, "play progress bigger than video duration, skip autoPlay.");
            return false;
        }
        if (o() && !ja.c(((NativeMediaView) this).B.m_())) {
            int autoPlayNetwork = ((NativeMediaView) this).B.h_().getAutoPlayNetwork();
            fb.V(S, "videoConfig, auto play net: %s.", Integer.valueOf(autoPlayNetwork));
            if (autoPlayNetwork == 2) {
                return false;
            }
            if (autoPlayNetwork == 1 || (autoPlayNetwork == 0 && am.I(getContext()))) {
                return true;
            }
            if (autoPlayNetwork == 0 && !am.I(getContext())) {
                return false;
            }
        }
        return TextUtils.equals(this.c.B(), "y");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        a aVar = this.D;
        if (aVar != null) {
            aVar.Code();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        a aVar = this.D;
        if (aVar != null) {
            aVar.Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        a aVar = this.D;
        if (aVar != null) {
            aVar.V();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        a aVar = this.D;
        if (aVar != null) {
            aVar.I();
        }
    }

    private boolean n() {
        if (this.c == null || !am.Z(getContext()) || !i()) {
            return false;
        }
        if (o() && !ja.c(((NativeMediaView) this).B.m_())) {
            int autoPlayNetwork = ((NativeMediaView) this).B.h_().getAutoPlayNetwork();
            if (autoPlayNetwork == 2) {
                return false;
            }
            if (autoPlayNetwork == 1 || (autoPlayNetwork == 0 && am.I(getContext()))) {
                return true;
            }
            if (autoPlayNetwork == 0 && !am.I(getContext())) {
                return false;
            }
        }
        if (this.c.f() == 1) {
            return true;
        }
        return this.c.f() == 0 && am.I(getContext());
    }

    private boolean o() {
        l lVar = ((NativeMediaView) this).B;
        return (lVar == null || lVar.h_() == null) ? false : true;
    }

    private void p() {
        eu.Code(null);
        ev.Code(getContext()).V();
    }

    public void C() {
        this.j.b();
    }

    public void D() {
        this.f17418a.V(false);
    }

    public void F() {
        this.j.c();
    }

    public void L() {
        this.f17418a.D();
    }

    @Override // com.huawei.hms.ads.kw
    public void destroyView() {
        this.j.destroyView();
        this.l = null;
        this.F.I();
    }

    public float getAspectRatio() {
        Float g;
        VideoInfo videoInfo = this.c;
        if (videoInfo == null || (g = videoInfo.g()) == null) {
            return 0.0f;
        }
        return g.floatValue();
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView
    public int getAutoPlayAreaPercentageThresshold() {
        VideoInfo videoInfo = this.c;
        return videoInfo != null ? videoInfo.c() : super.getAutoPlayAreaPercentageThresshold();
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView
    public int getHiddenAreaPercentageThreshhold() {
        VideoInfo videoInfo = this.c;
        return videoInfo != null ? Math.max(100 - videoInfo.d(), 0) : super.getHiddenAreaPercentageThreshhold();
    }

    public MediaContent getMediaContent() {
        return this.l;
    }

    @Override // com.huawei.hms.ads.gf
    public View getOpenMeasureView() {
        return this;
    }

    public ImageView getPreviewImageView() {
        return this.i.S();
    }

    public VideoView getVideoView() {
        return this.j;
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.F.I();
    }

    @Override // com.huawei.hms.ads.kw
    public void pauseView() {
        this.f17418a.L();
    }

    @Override // com.huawei.hms.ads.kw
    public void resumeView() {
        this.f17418a.a();
        fb.V(S, "resumeView");
        b();
        ((NativeMediaView) this).V = false;
        ((NativeMediaView) this).C.onGlobalLayout();
        this.j.setNeedPauseOnSurfaceDestory(true);
    }

    public void setAudioFocusType(int i) {
        this.j.setAudioFocusType(i);
    }

    public void setCoverClickListener(View.OnClickListener onClickListener) {
        this.f17418a.Code(onClickListener);
    }

    public void setMediaContent(MediaContent mediaContent) {
        this.l = mediaContent;
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView, com.huawei.hms.ads.kd
    public void setNativeAd(com.huawei.openalliance.ad.inter.data.g gVar) {
        String str = S;
        StringBuilder sb = new StringBuilder();
        sb.append("setNativeAd ");
        sb.append(gVar != null ? gVar.a() : "null");
        fb.V(str, sb.toString());
        if (gVar == null) {
            this.l = null;
        }
        com.huawei.openalliance.ad.media.b currentState = this.j.getCurrentState();
        if (((NativeMediaView) this).B == gVar && currentState.V(com.huawei.openalliance.ad.media.d.IDLE) && currentState.V(com.huawei.openalliance.ad.media.d.ERROR)) {
            fb.V(str, "setNativeAd - has the same ad");
            return;
        }
        super.setNativeAd(gVar);
        f();
        this.b.Code(((NativeMediaView) this).B);
        if (((NativeMediaView) this).B != null) {
            e();
            d();
            this.f17418a.C(false);
        } else {
            this.f17418a.Z(true);
            this.c = null;
            this.l = null;
        }
        if (!i() || g()) {
            return;
        }
        this.o = true;
    }

    @Deprecated
    public void setNotShowDataUsageAlert(boolean z) {
    }

    @Override // com.huawei.hms.ads.kd
    public void setPpsNativeView(ki kiVar) {
        this.k = kiVar;
    }

    public void setVideoEventListener(a aVar) {
        this.D = aVar;
    }

    public NativeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = new gj();
        this.L = false;
        this.e = false;
        this.f = 0;
        this.g = false;
        this.q = false;
        this.r = new com.huawei.openalliance.ad.media.listener.b() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.1
            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code() {
                if (fb.Code()) {
                    fb.Code(NativeVideoView.S, "onBufferingStart");
                }
                NativeVideoView.this.p.V();
                NativeVideoView.this.F.b();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void V() {
                NativeVideoView.this.F.c();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code(int i) {
            }
        };
        this.s = new com.huawei.openalliance.ad.media.listener.h() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.2
            @Override // com.huawei.openalliance.ad.media.listener.h
            public void Code(long j) {
                if (fb.Code()) {
                    fb.Code(NativeVideoView.S, "reportVideoTime: %s", Long.valueOf(j));
                }
                if (NativeVideoView.this.b != null) {
                    NativeVideoView.this.b.Code(NativeVideoView.this.getContext(), j);
                }
            }
        };
        this.t = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.3
            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i) {
                NativeVideoView.this.Code(i, true);
                NativeVideoView.this.m();
                if (NativeVideoView.this.b != null) {
                    long j = i;
                    NativeVideoView.this.b.Code(NativeVideoView.this.getContext(), j, j);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i) {
                NativeVideoView.this.Code(i, false);
                NativeVideoView.this.l();
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i) {
                if (fb.Code()) {
                    fb.Code(NativeVideoView.S, "onMediaStart: %s", Integer.valueOf(i));
                }
                if (NativeVideoView.this.L) {
                    return;
                }
                NativeVideoView.this.L = true;
                NativeVideoView.this.n = i;
                NativeVideoView.this.m = System.currentTimeMillis();
                NativeVideoView.this.j();
                if (i > 0) {
                    NativeVideoView.this.F.f();
                    NativeVideoView.this.b.V();
                    return;
                }
                if (NativeVideoView.this.F != null && NativeVideoView.this.c != null) {
                    NativeVideoView.this.F.Code(NativeVideoView.this.c.I(), true ^ "y".equals(NativeVideoView.this.c.a()));
                }
                NativeVideoView.this.b.Code();
                NativeVideoView.this.b.Code(NativeVideoView.this.p.B(), NativeVideoView.this.p.Z(), NativeVideoView.this.m);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i) {
                NativeVideoView.this.Code(i, false);
                NativeVideoView.this.k();
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onProgress(int i, int i2) {
                if (NativeVideoView.this.L) {
                    NativeVideoView.this.F.Code(i);
                    if (NativeVideoView.this.b != null) {
                        NativeVideoView.this.b.Code(NativeVideoView.this.getContext(), i2, NativeVideoView.this.c == null ? 0L : NativeVideoView.this.c.I());
                    }
                }
            }
        };
        this.u = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.4
            @Override // com.huawei.openalliance.ad.media.listener.c
            public void Code(MediaPlayerAgent mediaPlayerAgent, int i, int i2, int i3) {
                NativeVideoView.this.Code(i, false);
                NativeVideoView nativeVideoView = NativeVideoView.this;
                if (((NativeMediaView) nativeVideoView).I || am.Z(nativeVideoView.getContext())) {
                    return;
                }
                Toast makeText = Toast.makeText(NativeVideoView.this.getContext(), R.string.hiad_network_error, 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        };
        this.v = new com.huawei.openalliance.ad.media.listener.d() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.5
            @Override // com.huawei.openalliance.ad.media.listener.d
            public void Code(int i) {
                NativeVideoView.this.f17418a.I(i);
            }

            @Override // com.huawei.openalliance.ad.media.listener.d
            public void V(int i) {
            }
        };
        this.w = new com.huawei.openalliance.ad.media.listener.f() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.6
            @Override // com.huawei.openalliance.ad.media.listener.f
            public void Code() {
                fb.V(NativeVideoView.S, "onMute");
                if (NativeVideoView.this.c != null) {
                    NativeVideoView.this.c.Code("n");
                    if (NativeVideoView.this.o || !NativeVideoView.this.L) {
                        NativeVideoView.this.o = false;
                    } else {
                        NativeVideoView.this.b.Code(true);
                    }
                    NativeVideoView.this.F.V(0.0f);
                }
                NativeVideoView.this.f17418a.B(true);
                if (NativeVideoView.this.D != null) {
                    NativeVideoView.this.D.Code(true);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.f
            public void V() {
                fb.V(NativeVideoView.S, "onUnmute");
                if (NativeVideoView.this.c != null) {
                    NativeVideoView.this.o = false;
                    NativeVideoView.this.c.Code("y");
                    NativeVideoView.this.b.Code(false);
                    NativeVideoView.this.F.V(1.0f);
                }
                NativeVideoView.this.f17418a.B(false);
                if (NativeVideoView.this.D != null) {
                    NativeVideoView.this.D.Code(false);
                }
            }
        };
        this.x = new j.a() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.7
            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code() {
                if (NativeVideoView.this.k != null) {
                    NativeVideoView.this.k.Code(5, false);
                }
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void V(boolean z, int i) {
                NativeVideoView.this.V(z, i);
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code(boolean z) {
                fb.V(NativeVideoView.S, "doRealPlay, auto:" + z);
                NativeVideoView.this.p.Code();
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public boolean V() {
                return NativeVideoView.this.i() && !NativeVideoView.this.q;
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code(boolean z, int i) {
                NativeVideoView.this.Code(z, i);
            }
        };
        Code(context);
    }

    private boolean c() {
        NativeAdConfiguration aq;
        l lVar = ((NativeMediaView) this).B;
        if (lVar == null || (aq = lVar.aq()) == null) {
            return false;
        }
        return aq.isReturnUrlsForImages();
    }

    private void d() {
        VideoConfiguration videoConfiguration;
        l lVar = ((NativeMediaView) this).B;
        if (lVar == null) {
            return;
        }
        this.c = lVar.C();
        if (((NativeMediaView) this).B.aq() != null && (videoConfiguration = ((NativeMediaView) this).B.aq().getVideoConfiguration()) != null) {
            if (!ja.d(((NativeMediaView) this).B.m_())) {
                Code(videoConfiguration.isStartMuted());
            }
            setAudioFocusType(videoConfiguration.getAudioFocusType());
        }
        if (this.c == null) {
            this.f17418a.B();
            return;
        }
        this.f17418a.Code(this.j);
        this.f = ((NativeMediaView) this).B.aw();
        this.f17418a.Code(this.c);
        Float g = this.c.g();
        if (g == null) {
            g = Float.valueOf(1.7777778f);
        }
        setRatio(g);
        this.f17418a.B(this.f);
        this.f17418a.Z(!g());
        this.f17418a.V(getContinuePlayTime());
        this.f17418a.I(this.c.I());
        this.f17418a.Z(getAutoPlayNetForVideoCtrlBridge());
        this.b.Code(this.c);
        this.i.setNonWifiAlertMsg(this.c.Z() > 0 ? getResources().getString(R.string.hiad_consume_data_to_play_video, ay.Code(getContext(), this.c.Z())) : getResources().getString(R.string.hiad_consume_data_to_play_video_no_data_size));
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView
    public void B() {
        fb.V(S, "onViewShownBetweenFullAndPartial");
        this.f17418a.C(true);
        b();
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView
    public void I() {
        fb.V(S, "onViewPartialHidden");
        this.g = false;
        this.j.V(this.u);
        this.j.V(this.w);
        if (this.c != null) {
            this.f17418a.C(false);
            this.f17418a.I(false);
            this.q = true;
            this.f17418a.C();
            this.f17418a.S();
        }
    }

    @Override // com.huawei.hms.ads.kd
    public void S() {
        this.f17418a.S();
    }

    public NativeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.F = new gj();
        this.L = false;
        this.e = false;
        this.f = 0;
        this.g = false;
        this.q = false;
        this.r = new com.huawei.openalliance.ad.media.listener.b() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.1
            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code() {
                if (fb.Code()) {
                    fb.Code(NativeVideoView.S, "onBufferingStart");
                }
                NativeVideoView.this.p.V();
                NativeVideoView.this.F.b();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void V() {
                NativeVideoView.this.F.c();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code(int i2) {
            }
        };
        this.s = new com.huawei.openalliance.ad.media.listener.h() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.2
            @Override // com.huawei.openalliance.ad.media.listener.h
            public void Code(long j) {
                if (fb.Code()) {
                    fb.Code(NativeVideoView.S, "reportVideoTime: %s", Long.valueOf(j));
                }
                if (NativeVideoView.this.b != null) {
                    NativeVideoView.this.b.Code(NativeVideoView.this.getContext(), j);
                }
            }
        };
        this.t = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.3
            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i2) {
                NativeVideoView.this.Code(i2, true);
                NativeVideoView.this.m();
                if (NativeVideoView.this.b != null) {
                    long j = i2;
                    NativeVideoView.this.b.Code(NativeVideoView.this.getContext(), j, j);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i2) {
                NativeVideoView.this.Code(i2, false);
                NativeVideoView.this.l();
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i2) {
                if (fb.Code()) {
                    fb.Code(NativeVideoView.S, "onMediaStart: %s", Integer.valueOf(i2));
                }
                if (NativeVideoView.this.L) {
                    return;
                }
                NativeVideoView.this.L = true;
                NativeVideoView.this.n = i2;
                NativeVideoView.this.m = System.currentTimeMillis();
                NativeVideoView.this.j();
                if (i2 > 0) {
                    NativeVideoView.this.F.f();
                    NativeVideoView.this.b.V();
                    return;
                }
                if (NativeVideoView.this.F != null && NativeVideoView.this.c != null) {
                    NativeVideoView.this.F.Code(NativeVideoView.this.c.I(), true ^ "y".equals(NativeVideoView.this.c.a()));
                }
                NativeVideoView.this.b.Code();
                NativeVideoView.this.b.Code(NativeVideoView.this.p.B(), NativeVideoView.this.p.Z(), NativeVideoView.this.m);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i2) {
                NativeVideoView.this.Code(i2, false);
                NativeVideoView.this.k();
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onProgress(int i2, int i22) {
                if (NativeVideoView.this.L) {
                    NativeVideoView.this.F.Code(i2);
                    if (NativeVideoView.this.b != null) {
                        NativeVideoView.this.b.Code(NativeVideoView.this.getContext(), i22, NativeVideoView.this.c == null ? 0L : NativeVideoView.this.c.I());
                    }
                }
            }
        };
        this.u = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.4
            @Override // com.huawei.openalliance.ad.media.listener.c
            public void Code(MediaPlayerAgent mediaPlayerAgent, int i2, int i22, int i3) {
                NativeVideoView.this.Code(i2, false);
                NativeVideoView nativeVideoView = NativeVideoView.this;
                if (((NativeMediaView) nativeVideoView).I || am.Z(nativeVideoView.getContext())) {
                    return;
                }
                Toast makeText = Toast.makeText(NativeVideoView.this.getContext(), R.string.hiad_network_error, 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        };
        this.v = new com.huawei.openalliance.ad.media.listener.d() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.5
            @Override // com.huawei.openalliance.ad.media.listener.d
            public void Code(int i2) {
                NativeVideoView.this.f17418a.I(i2);
            }

            @Override // com.huawei.openalliance.ad.media.listener.d
            public void V(int i2) {
            }
        };
        this.w = new com.huawei.openalliance.ad.media.listener.f() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.6
            @Override // com.huawei.openalliance.ad.media.listener.f
            public void Code() {
                fb.V(NativeVideoView.S, "onMute");
                if (NativeVideoView.this.c != null) {
                    NativeVideoView.this.c.Code("n");
                    if (NativeVideoView.this.o || !NativeVideoView.this.L) {
                        NativeVideoView.this.o = false;
                    } else {
                        NativeVideoView.this.b.Code(true);
                    }
                    NativeVideoView.this.F.V(0.0f);
                }
                NativeVideoView.this.f17418a.B(true);
                if (NativeVideoView.this.D != null) {
                    NativeVideoView.this.D.Code(true);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.f
            public void V() {
                fb.V(NativeVideoView.S, "onUnmute");
                if (NativeVideoView.this.c != null) {
                    NativeVideoView.this.o = false;
                    NativeVideoView.this.c.Code("y");
                    NativeVideoView.this.b.Code(false);
                    NativeVideoView.this.F.V(1.0f);
                }
                NativeVideoView.this.f17418a.B(false);
                if (NativeVideoView.this.D != null) {
                    NativeVideoView.this.D.Code(false);
                }
            }
        };
        this.x = new j.a() { // from class: com.huawei.openalliance.ad.views.NativeVideoView.7
            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code() {
                if (NativeVideoView.this.k != null) {
                    NativeVideoView.this.k.Code(5, false);
                }
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void V(boolean z, int i2) {
                NativeVideoView.this.V(z, i2);
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code(boolean z) {
                fb.V(NativeVideoView.S, "doRealPlay, auto:" + z);
                NativeVideoView.this.p.Code();
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public boolean V() {
                return NativeVideoView.this.i() && !NativeVideoView.this.q;
            }

            @Override // com.huawei.openalliance.ad.views.j.a
            public void Code(boolean z, int i2) {
                NativeVideoView.this.Code(z, i2);
            }
        };
        Code(context);
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView
    public void Code() {
        super.Code();
        this.j.setNeedPauseOnSurfaceDestory(true);
    }

    @Override // com.huawei.openalliance.ad.views.NativeMediaView
    public void V() {
        this.h = System.currentTimeMillis();
        this.f17418a.C(true);
        Code(this.c);
        b();
        String str = S;
        fb.V(str, "onViewFullShown hashCheckSuccess: %s", Boolean.valueOf(this.e));
        if (this.e) {
            boolean i = i();
            this.q = false;
            fb.V(str, "onViewFullShown autoplay: %s", Boolean.valueOf(i));
            this.f17418a.I(i);
            this.f17418a.V(getContinuePlayTime());
            if (n()) {
                this.f17418a.Code(this.c.S());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i, boolean z) {
        VideoInfo videoInfo = this.c;
        if (videoInfo != null) {
            videoInfo.Code(z ? 0 : i);
        }
        this.p.I();
        if (this.L) {
            this.L = false;
            if (z) {
                this.b.Code(this.m, System.currentTimeMillis(), this.n, i);
                this.F.a();
            } else {
                this.b.V(this.m, System.currentTimeMillis(), this.n, i);
                this.F.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(boolean z, int i) {
        a aVar = this.D;
        if (aVar != null) {
            aVar.V(z, i);
        }
    }

    @Override // com.huawei.hms.ads.kd
    public void Code(long j) {
        this.b.Code(j);
    }

    private void Code(Context context) {
        this.b = new ia(context, this);
        LayoutInflater.from(context).inflate(R.layout.hiad_native_video_view, this);
        this.j = (VideoView) findViewById(R.id.hiad_id_video_view);
        this.i = (NativeVideoControlPanel) findViewById(R.id.hiad_native_video_ctrl_panel);
        this.j.setStandalone(false);
        this.j.setScreenOnWhilePlaying(true);
        this.j.setAutoScaleResizeLayoutOnVideoSizeChange(false);
        j jVar = new j(this.j, this.i);
        this.f17418a = jVar;
        jVar.Code(this.x);
        this.j.Code(this.t);
        this.j.Code(this.r);
        this.j.Code(this.u);
        this.j.Code(this.w);
        this.j.Code(this.v);
        this.j.Code(this.s);
        this.p = new fr(getTAG());
    }

    public void Code(gv gvVar, l lVar) {
        this.F = gvVar;
        Code(lVar);
    }

    private void Code(MediaContent mediaContent) {
        this.f17418a.Code(mediaContent.getImage());
        if (mediaContent.getAspectRatio() > 0.0f) {
            setRatio(Float.valueOf(mediaContent.getAspectRatio()));
        }
    }

    private void Code(ImageInfo imageInfo) {
        if (imageInfo.B() > 0) {
            setRatio(Float.valueOf((imageInfo.C() * 1.0f) / imageInfo.B()));
        }
        if (c()) {
            return;
        }
        this.b.Code(imageInfo);
    }

    @Override // com.huawei.hms.ads.kd
    public void Code(ImageInfo imageInfo, Drawable drawable) {
        ImageInfo imageInfo2 = this.d;
        if (imageInfo2 == null || imageInfo == null || !TextUtils.equals(imageInfo2.Z(), imageInfo.Z())) {
            return;
        }
        u uVar = new u(this.d, false);
        uVar.Code(drawable);
        this.l = new bx(uVar);
        this.f17418a.Code(drawable);
    }

    private void Code(VideoInfo videoInfo) {
        et Code = eu.Code();
        if (Code == null || videoInfo == null) {
            return;
        }
        int Code2 = Code.Code();
        videoInfo.Code(Code2);
        fb.V(S, "obtain progress from linked view " + Code2);
        p();
    }

    @Override // com.huawei.hms.ads.kd
    public void Code(VideoInfo videoInfo, boolean z) {
        VideoInfo videoInfo2;
        String str = S;
        fb.V(str, "onCheckVideoResult: %s", Boolean.valueOf(z));
        if (!z || (videoInfo2 = this.c) == null || videoInfo == null || !TextUtils.equals(videoInfo2.V(), videoInfo.V())) {
            return;
        }
        this.e = true;
        this.f17418a.Code(videoInfo.V());
        if (((NativeMediaView) this).V) {
            this.f17418a.V(getContinuePlayTime());
            boolean i = i();
            fb.V(str, "onCheckVideoResult - full shown, autoPlay: %s", Boolean.valueOf(i));
            this.f17418a.I(i);
            if (n()) {
                long S2 = videoInfo.S() - (System.currentTimeMillis() - this.h);
                if (S2 < 0) {
                    S2 = 0;
                }
                this.f17418a.Code(S2);
            }
        }
    }

    private void Code(l lVar) {
        if (lVar.C() != null) {
            this.F.Code(hu.Code(0.0f, n(), ht.STANDALONE));
        }
    }

    @Override // com.huawei.hms.ads.kd
    public void Code(String str) {
        this.b.Code(str);
    }

    public void Code(boolean z) {
        fb.V(S, "customToggleVideoMute, customMuteState is " + z);
        VideoInfo videoInfo = this.c;
        if (videoInfo != null) {
            videoInfo.Code(z ? "n" : "y");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z, int i) {
        a aVar = this.D;
        if (aVar != null) {
            aVar.Code(z, i);
        }
    }
}
