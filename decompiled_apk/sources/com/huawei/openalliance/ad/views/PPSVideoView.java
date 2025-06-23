package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.ck;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.gv;
import com.huawei.hms.ads.ie;
import com.huawei.hms.ads.iq;
import com.huawei.hms.ads.kl;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.ad.constant.ah;
import com.huawei.openalliance.ad.media.MediaPlayerAgent;
import com.huawei.openalliance.ad.media.listener.MediaStateListener;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.w;

/* loaded from: classes10.dex */
public class PPSVideoView extends PPSBaseView<iq> implements kl {
    private final com.huawei.openalliance.ad.media.listener.h A;
    private com.huawei.openalliance.ad.media.listener.c E;
    private final com.huawei.openalliance.ad.media.listener.b G;
    private com.huawei.openalliance.ad.media.listener.f H;
    private VideoView b;
    private ImageView c;
    private boolean d;
    private boolean e;
    private VideoInfo f;
    private int g;
    private int h;
    private long i;
    private long j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private float v;
    private boolean w;
    private View.OnClickListener x;
    private com.huawei.openalliance.ad.media.listener.g y;
    private MediaStateListener z;

    public PPSVideoView(Context context, int i, int i2, int i3, int i4) {
        super(context);
        this.d = true;
        this.e = true;
        this.g = 0;
        this.h = Integer.MAX_VALUE;
        this.k = false;
        this.l = false;
        this.m = 1;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = true;
        this.u = false;
        this.v = 0.0f;
        this.w = false;
        this.x = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSVideoView.this.Code(!view.isSelected());
            }
        };
        this.y = new com.huawei.openalliance.ad.media.listener.g() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.2
            @Override // com.huawei.openalliance.ad.media.listener.g
            public void Code() {
                fb.Code("PPSVideoView", "onVideoRenderStart, alreadyNotified: %s", Boolean.valueOf(PPSVideoView.this.q));
                if (PPSVideoView.this.q) {
                    return;
                }
                PPSVideoView.this.q = true;
                if (PPSVideoView.this.b != null) {
                    PPSVideoView.this.b.setAlpha(1.0f);
                }
                PPSVideoView.this.Z();
                if (PPSVideoView.this.s) {
                    PPSVideoView.this.e = false;
                }
                PPSVideoView.this.c();
            }
        };
        this.z = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.3
            private void Code(int i5) {
                if (PPSVideoView.this.l) {
                    fb.V("PPSVideoView", "has reported play end event");
                    return;
                }
                PPSVideoView.this.l = true;
                PPSVideoView pPSVideoView = PPSVideoView.this;
                ((iq) pPSVideoView.B).Code(pPSVideoView.i, w.Code(), PPSVideoView.this.j, i5);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i5) {
                Code(i5, true);
                PPSVideoView pPSVideoView = PPSVideoView.this;
                P p = pPSVideoView.B;
                if (p != 0) {
                    long j = i5;
                    ((iq) p).Code(pPSVideoView.getContext(), j, j);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, final int i5) {
                bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Code(i5, false);
                    }
                }, 1000L);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i5) {
                if (PPSVideoView.this.k) {
                    return;
                }
                PPSVideoView.this.d();
                PPSVideoView.this.k = true;
                PPSVideoView.this.j = i5;
                PPSVideoView.this.i = w.Code();
                PPSVideoView pPSVideoView = PPSVideoView.this;
                if (i5 > 0) {
                    pPSVideoView.C.f();
                } else if (pPSVideoView.f != null) {
                    PPSVideoView.this.C.Code(r3.f.I(), PPSVideoView.this.d);
                }
                PPSVideoView pPSVideoView2 = PPSVideoView.this;
                ((iq) pPSVideoView2.B).Code(pPSVideoView2.i);
                PPSVideoView pPSVideoView3 = PPSVideoView.this;
                pPSVideoView3.D.Code(pPSVideoView3.i);
                ((iq) PPSVideoView.this.B).F();
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i5) {
                Code(i5, false);
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onProgress(int i5, int i6) {
                fb.Code("PPSVideoView", "onProgress, playTime: %d, alreadyNotified: %s", Integer.valueOf(i6), Boolean.valueOf(PPSVideoView.this.q));
                if (i6 > 0 && !PPSVideoView.this.q) {
                    PPSVideoView.this.q = true;
                    if (PPSVideoView.this.b != null) {
                        PPSVideoView.this.b.setAlpha(1.0f);
                    }
                    PPSVideoView.this.Z();
                    PPSVideoView.this.c();
                }
                if (PPSVideoView.this.b != null && PPSVideoView.this.b.getCurrentState().Code() && PPSVideoView.this.g > 0) {
                    int i7 = PPSVideoView.this.g - i6;
                    if (i7 < 0) {
                        i7 = 0;
                    }
                    int max = Math.max(1, (int) Math.ceil((i7 * 1.0f) / 1000.0f));
                    fb.Code("PPSVideoView", "left seconds: %d", Integer.valueOf(max));
                    if (max < PPSVideoView.this.h) {
                        PPSVideoView.this.h = max;
                        PPSVideoView.this.I(max);
                    }
                }
                if (PPSVideoView.this.k) {
                    PPSVideoView.this.C.Code(i5);
                    PPSVideoView pPSVideoView = PPSVideoView.this;
                    P p = pPSVideoView.B;
                    if (p != 0) {
                        ((iq) p).Code(pPSVideoView.getContext(), i6, PPSVideoView.this.g);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void Code(int i5, boolean z) {
                if (PPSVideoView.this.k) {
                    PPSVideoView.this.k = false;
                    Code(i5);
                    ((iq) PPSVideoView.this.B).V();
                    gv gvVar = PPSVideoView.this.C;
                    if (z) {
                        gvVar.a();
                    } else {
                        gvVar.e();
                    }
                }
            }
        };
        this.A = new com.huawei.openalliance.ad.media.listener.h() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.4
            @Override // com.huawei.openalliance.ad.media.listener.h
            public void Code(long j) {
                if (fb.Code()) {
                    fb.Code("PPSVideoView", "reportVideoTime: %s", Long.valueOf(j));
                }
                PPSVideoView pPSVideoView = PPSVideoView.this;
                P p = pPSVideoView.B;
                if (p != 0) {
                    ((iq) p).Code(pPSVideoView.getContext(), j);
                }
            }
        };
        this.E = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.5
            @Override // com.huawei.openalliance.ad.media.listener.c
            public void Code(MediaPlayerAgent mediaPlayerAgent, int i5, int i6, int i7) {
                PPSVideoView.this.V(ah.Z);
                PPSVideoView.this.Code();
            }
        };
        this.G = new com.huawei.openalliance.ad.media.listener.b() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.6
            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code() {
                PPSVideoView.this.C.b();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void V() {
                PPSVideoView.this.C.c();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code(int i5) {
            }
        };
        this.H = new com.huawei.openalliance.ad.media.listener.f() { // from class: com.huawei.openalliance.ad.views.PPSVideoView.7
            @Override // com.huawei.openalliance.ad.media.listener.f
            public void Code() {
                PPSVideoView.this.setMuteButtonState(true);
                PPSVideoView.this.C.V(0.0f);
            }

            @Override // com.huawei.openalliance.ad.media.listener.f
            public void V() {
                PPSVideoView.this.setMuteButtonState(false);
                PPSVideoView.this.C.V(1.0f);
            }
        };
        this.o = i2;
        this.n = i;
        this.p = i3;
        this.r = ck.Code(context).B();
        this.B = new ie(context, this);
    }

    private void b() {
        if (this.b == null) {
            VideoView videoView = new VideoView(getContext());
            this.b = videoView;
            videoView.setScreenOnWhilePlaying(true);
            this.b.setStandalone(true);
            this.b.setAutoScaleResizeLayoutOnVideoSizeChange(false);
            this.b.setVideoScaleMode(2);
            this.b.setMuteOnlyOnLostAudioFocus(true);
            this.b.Code(this.y);
            this.b.Code(this.z);
            this.b.Code(this.E);
            this.b.Code(this.H);
            this.b.Code(this.G);
            this.b.Code(this.A);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            addView(this.b, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.t || !this.u) {
            return;
        }
        float f = this.v;
        if (f > 0.0f) {
            this.b.setSoundVolume(f);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.km
    public void F() {
        super.F();
        VideoView videoView = this.b;
        if (videoView != null) {
            videoView.D();
        }
    }

    public void L() {
        fb.V("PPSVideoView", "unMuteCustomized");
        this.w = true;
        VideoView videoView = this.b;
        if (videoView != null) {
            float f = this.v;
            if (f > 0.0f) {
                videoView.Code(f);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView
    public void S() {
        pauseView();
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        VideoView videoView = this.b;
        if (videoView != null) {
            removeView(videoView);
            this.b.destroyView();
            this.b = null;
        }
        this.h = Integer.MAX_VALUE;
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.kw
    public void pauseView() {
        VideoView videoView = this.b;
        if (videoView != null) {
            videoView.pauseView();
            this.b.L();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.km
    public void setAudioFocusType(int i) {
        this.m = i;
        VideoView videoView = this.b;
        if (videoView != null) {
            videoView.setAudioFocusType(i);
        }
    }

    public void setHideSoundIcon(boolean z) {
        this.s = z;
    }

    public void setIgnoreSoundCtrl(boolean z) {
        this.t = z;
    }

    public void setMuteButtonState(boolean z) {
        this.d = z;
        if (this.c != null) {
            this.c.setImageResource(bc.Code(z));
            this.c.setSelected(!z);
            bc.Code(this.c);
        }
    }

    public void setStartVol(float f) {
        this.v = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00bd, code lost:
    
        if (com.huawei.openalliance.ad.utils.n.S(getContext()) != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00f6, code lost:
    
        if (r6.S.c() != 1) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c() {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.views.PPSVideoView.c():void");
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.km
    public boolean C() {
        return this.g > 0;
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.km
    public void D() {
        super.D();
        VideoView videoView = this.b;
        if (videoView != null) {
            videoView.D();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseView, com.huawei.hms.ads.km
    public void Code(int i, int i2) {
        super.Code(i, i2);
        VideoView videoView = this.b;
        if (videoView != null) {
            videoView.D();
        }
    }

    @Override // com.huawei.hms.ads.kl
    public void Code(String str) {
        VideoInfo t = this.S.t();
        this.f = t;
        if (t != null) {
            if (TextUtils.equals("n", t.f()) || this.s) {
                this.e = false;
            }
            this.g = this.f.I();
            this.u = TextUtils.equals("y", this.f.S());
        }
        MetaData S = this.S.S();
        if (S != null && S.k() > 0) {
            this.g = (int) S.k();
        }
        b();
        this.b.setAudioFocusType(this.m);
        this.b.setAlpha(0.0f);
        this.b.setVideoFileUrl(str);
        if (this.t || !this.u) {
            this.b.b();
        } else {
            this.b.c();
        }
        this.b.Code(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z) {
        fb.V("PPSVideoView", "switchSound enableSound: " + z);
        VideoView videoView = this.b;
        if (videoView == null) {
            return;
        }
        if (z) {
            videoView.c();
        } else {
            videoView.b();
        }
        ((iq) this.B).Code(!z);
    }
}
