package com.huawei.openalliance.ad.views;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.inter.data.VideoInfo;
import com.huawei.openalliance.ad.media.MediaPlayerAgent;
import com.huawei.openalliance.ad.media.listener.MediaStateListener;
import com.huawei.openalliance.ad.utils.am;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.bi;
import com.huawei.openalliance.ad.views.BaseVideoView;

/* loaded from: classes10.dex */
public class j implements MediaStateListener, com.huawei.openalliance.ad.media.listener.b, com.huawei.openalliance.ad.media.listener.c, BaseVideoView.h, e {
    private static final String Z = "j";
    private VideoView B;
    private NativeVideoControlPanel C;
    private View D;
    private ImageView F;
    private ImageView L;
    private ImageView S;

    /* renamed from: a, reason: collision with root package name */
    private View f17440a;
    private View b;
    private View c;
    private boolean f;
    private int h;
    private boolean i;
    private View.OnClickListener j;
    private a k;
    private int l;
    private VideoInfo n;
    private final String d = "hPlT" + hashCode();
    private final String e = "aPT" + hashCode();
    private boolean g = true;
    private boolean m = false;
    private int o = 0;
    private boolean p = false;
    private Runnable q = new Runnable() { // from class: com.huawei.openalliance.ad.views.j.1
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.B == null || !j.this.f) {
                return;
            }
            j.this.V(true);
        }
    };
    private View.OnClickListener r = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.j.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.p = true;
            j.this.L(!view.isSelected());
        }
    };
    private Runnable s = new Runnable() { // from class: com.huawei.openalliance.ad.views.j.8
        @Override // java.lang.Runnable
        public void run() {
            j.this.Code(false, true);
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void Code();

        void Code(boolean z);

        void Code(boolean z, int i);

        void V(boolean z, int i);

        boolean V();
    }

    public j(VideoView videoView, NativeVideoControlPanel nativeVideoControlPanel) {
        Code(videoView);
        Code(nativeVideoControlPanel);
    }

    private void b(boolean z) {
        if (this.B == null) {
            return;
        }
        if (z || this.l == 1 || this.m) {
            t();
        } else {
            u();
        }
    }

    private void c(boolean z) {
        VideoView videoView;
        a aVar = this.k;
        if (aVar == null || (videoView = this.B) == null) {
            return;
        }
        aVar.Code(z, videoView.getCurrentState().V());
    }

    private void e() {
        NativeVideoControlPanel nativeVideoControlPanel = this.C;
        if (nativeVideoControlPanel == null) {
            return;
        }
        this.D = nativeVideoControlPanel.C();
        this.f17440a = this.C.L();
        View F = this.C.F();
        this.b = F;
        if (F != null) {
            F.setClickable(true);
        }
        ImageView S = this.C.S();
        this.L = S;
        if (S != null) {
            S.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.o();
                }
            });
        }
        I(this.C);
        k();
        i();
        a(false);
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        bf.Code(this.e);
        i();
        if (this.o == 10) {
            q();
        }
        VideoView videoView = this.B;
        if (videoView != null && !videoView.getCurrentState().Code()) {
            g();
        }
        V(false);
    }

    private void g() {
        if (this.L == null) {
            return;
        }
        fb.Code(Z, "showPreviewView");
        Animation animation = this.L.getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        bi.Code((View) this.L, true);
        VideoView videoView = this.B;
        if (videoView != null) {
            videoView.setAlpha(0.0f);
        }
    }

    private void h() {
        VideoView videoView;
        fb.Code(Z, "hidePreviewView");
        bi.Code(this.L, 8, 300, 300);
        if (this.L == null || (videoView = this.B) == null) {
            return;
        }
        videoView.setAlpha(1.0f);
    }

    private void i() {
        View view = this.b;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void j() {
        View view = this.b;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private void k() {
        l();
        Z(this.C);
        V(this.C);
        if (this.o == 10) {
            m();
        }
    }

    private void l() {
        VideoView videoView = this.B;
        if (videoView != null) {
            videoView.Code((MediaStateListener) this);
            this.B.Code((com.huawei.openalliance.ad.media.listener.b) this);
            this.B.Code((com.huawei.openalliance.ad.media.listener.c) this);
            this.B.Code((e) this);
            this.B.setSurfaceListener(this);
            this.B.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.j.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.p();
                }
            });
        }
    }

    private void m() {
        NativeVideoControlPanel nativeVideoControlPanel = this.C;
        if (nativeVideoControlPanel != null) {
            nativeVideoControlPanel.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.j.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.q();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.B == null) {
            return;
        }
        bf.Code(this.e);
        if (this.B.a()) {
            bf.Code(this.d);
            this.B.L();
            return;
        }
        if (!am.Z(this.B.getContext())) {
            Toast.makeText(this.B.getContext(), R.string.hiad_network_no_available, 0).show();
            return;
        }
        if (this.m || this.l == 1 || am.I(this.B.getContext())) {
            V(false);
            s();
        } else {
            fb.V(Z, "non wifi, show alert");
            this.B.L();
            j();
            r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        View.OnClickListener onClickListener = this.j;
        if (onClickListener != null) {
            onClickListener.onClick(this.L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        View.OnClickListener onClickListener;
        VideoView videoView = this.B;
        if (videoView == null || (onClickListener = this.j) == null) {
            return;
        }
        onClickListener.onClick(videoView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        View.OnClickListener onClickListener;
        if (this.B == null || (onClickListener = this.j) == null) {
            return;
        }
        onClickListener.onClick(this.C);
    }

    private void r() {
        Code(false, false);
    }

    private void s() {
        bf.Code(this.d);
        bf.Code(this.s, this.d, 3000L);
    }

    private void t() {
        if (this.B == null) {
            return;
        }
        i();
        if (!this.B.getCurrentState().Code()) {
            g();
        }
        a aVar = this.k;
        if (aVar != null) {
            this.f = aVar.V();
        }
        if (this.f && !this.i) {
            V(true);
        } else {
            if (this.B.a()) {
                return;
            }
            F();
        }
    }

    private void u() {
        VideoView videoView = this.B;
        if (videoView != null) {
            if ((!videoView.getCurrentState().Code(com.huawei.openalliance.ad.media.d.PREPARING) && !this.B.a()) || this.m || this.l == 1) {
                return;
            }
            this.B.D();
            if (this.b != null) {
                j();
                r();
            }
        }
    }

    private void v() {
        VideoView videoView = this.B;
        if (videoView != null) {
            if (videoView.getCurrentState().Code(com.huawei.openalliance.ad.media.d.PREPARING) || this.B.a()) {
                this.B.L();
            }
        }
    }

    public void B() {
        fb.Code(Z, "setForImageOnly");
        Code((VideoView) null);
        Code(false, false);
        a(false);
    }

    public void C() {
        bf.Code(this.e);
    }

    public void D() {
        VideoView videoView = this.B;
        if (videoView != null) {
            videoView.L();
        }
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView.h
    public void I() {
        g();
        a(false);
    }

    public void L() {
        this.i = true;
        VideoView videoView = this.B;
        if (videoView != null) {
            videoView.pauseView();
        }
    }

    @Override // com.huawei.openalliance.ad.media.listener.b
    public void V() {
        View view = this.D;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.D.setVisibility(8);
    }

    @Override // com.huawei.openalliance.ad.views.e
    public void Z() {
        v();
    }

    public void a() {
        this.i = false;
        VideoView videoView = this.B;
        if (videoView != null) {
            videoView.resumeView();
        }
    }

    @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
    public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i) {
        Code(i, false, true);
    }

    @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
    public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i) {
        Code(i, true, false);
    }

    @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
    public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i) {
        NativeVideoControlPanel nativeVideoControlPanel;
        if (this.S != null && (nativeVideoControlPanel = this.C) != null && nativeVideoControlPanel.I() != 0) {
            this.S.setImageResource(this.C.I());
        }
        h();
        if (this.g) {
            Code(false, false);
        } else {
            s();
        }
        a(true);
    }

    @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
    public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i) {
        Code(i, false, false);
    }

    @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
    public void onProgress(int i, int i2) {
        VideoInfo videoInfo;
        if (i2 <= 0 || (videoInfo = this.n) == null) {
            return;
        }
        videoInfo.Code(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z) {
        fb.V(Z, "switchSound: " + z);
        VideoView videoView = this.B;
        if (videoView == null) {
            return;
        }
        if (z) {
            videoView.c();
        } else {
            videoView.b();
        }
        bf.Code(this.d);
        if (this.B.a()) {
            s();
        }
    }

    private void a(boolean z) {
        this.g = !z;
        NativeVideoControlPanel nativeVideoControlPanel = this.C;
        if (nativeVideoControlPanel != null) {
            nativeVideoControlPanel.Code(z);
        }
    }

    private void d(boolean z) {
        VideoView videoView;
        a aVar = this.k;
        if (aVar == null || (videoView = this.B) == null) {
            return;
        }
        aVar.V(z, videoView.getCurrentState().V());
    }

    public void B(int i) {
        fb.Code(Z, "linkedVideoMode is " + i);
        this.o = i;
    }

    @Override // com.huawei.openalliance.ad.media.listener.b
    public void Code() {
        View view = this.D;
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        this.D.setVisibility(0);
        ImageView imageView = this.S;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    public void F() {
        Code(true, false);
    }

    public void I(int i) {
        VideoView videoView = this.B;
        if (videoView != null) {
            videoView.setDefaultDuration(i);
        }
    }

    public void S() {
        VideoView videoView = this.B;
        if (videoView != null) {
            videoView.D();
        }
        i();
        a(false);
        F();
        g();
    }

    public void V(int i) {
        fb.Code(Z, "setPreferStartPlayTime " + i);
        this.h = i;
        VideoView videoView = this.B;
        if (videoView != null) {
            videoView.setPreferStartPlayTime(i);
        }
    }

    public void Z(int i) {
        this.l = i;
    }

    public boolean c() {
        return this.p;
    }

    private void D(boolean z) {
        a aVar = this.k;
        if (aVar != null) {
            aVar.Code(z);
        }
    }

    private void I(NativeVideoControlPanel nativeVideoControlPanel) {
        ImageView B = nativeVideoControlPanel.B();
        this.F = B;
        if (B != null) {
            B.setOnClickListener(this.r);
        }
    }

    private void V(NativeVideoControlPanel nativeVideoControlPanel) {
        View D = nativeVideoControlPanel.D();
        this.c = D;
        if (D != null) {
            D.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.j.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    j.this.f();
                }
            });
        }
    }

    private void Z(NativeVideoControlPanel nativeVideoControlPanel) {
        ImageView Code = nativeVideoControlPanel.Code();
        this.S = Code;
        if (Code != null) {
            Code.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.j.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.this.k != null) {
                        j.this.k.Code();
                    }
                    if (j.this.o != 10) {
                        j.this.n();
                        return;
                    }
                    fb.Code(j.Z, "linkedVideoMode is " + j.this.o);
                    j.this.q();
                }
            });
            if (nativeVideoControlPanel.V() > 0) {
                this.S.setImageResource(nativeVideoControlPanel.V());
                bc.Code(this.S);
            }
        }
    }

    public void C(boolean z) {
        if (fb.Code()) {
            fb.Code(Z, "setPlayBtn: %s", Boolean.valueOf(z));
        }
        ImageView imageView = this.S;
        if (imageView != null) {
            imageView.setEnabled(z);
        }
    }

    @Override // com.huawei.openalliance.ad.media.listener.b
    public void Code(int i) {
    }

    public void S(boolean z) {
        if (z) {
            Code((String) null);
            V(0);
            I(0);
            Code((Bitmap) null);
        }
        g();
        F();
    }

    private void Code(int i, boolean z, boolean z2) {
        NativeVideoControlPanel nativeVideoControlPanel;
        C();
        if (z2) {
            i = 0;
        }
        this.h = i;
        bf.Code(this.d);
        if (this.S != null && (nativeVideoControlPanel = this.C) != null && nativeVideoControlPanel.V() != 0) {
            this.S.setImageResource(this.C.V());
            bc.Code(this.S);
        }
        if (!z) {
            g();
            a(false);
        }
        View view = this.b;
        if (view == null || view.getVisibility() != 0) {
            Code(true, true);
        }
        ImageView imageView = this.S;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public void B(boolean z) {
        fb.V(Z, "setMuteBtn: " + z);
        ImageView B = this.C.B();
        if (B != null) {
            B.setSelected(!z);
        }
    }

    public void Code(long j) {
        VideoView videoView;
        String str = Z;
        fb.V(str, "autoPlay - delayMs: %d", Long.valueOf(j));
        bf.Code(this.e);
        if (!this.f || (videoView = this.B) == null) {
            return;
        }
        if (videoView.a()) {
            fb.Code(str, "autoPlay - video is playing");
            V(true);
        } else {
            fb.Code(str, "autoPlay - start delay runnable");
            this.B.e();
            bf.Code(this.q, this.e, j);
        }
    }

    public void I(boolean z) {
        this.f = z;
    }

    public void V(boolean z) {
        if (this.B != null) {
            D(z);
            this.B.setPreferStartPlayTime(this.h);
            this.B.Code(z);
        }
    }

    public void Z(boolean z) {
        fb.V(Z, "toggleMute: " + z);
        if (this.B == null || this.C == null) {
            return;
        }
        B(z);
        if (z) {
            this.B.b();
        } else {
            this.B.c();
        }
    }

    public void Code(Bitmap bitmap) {
        ImageView imageView = this.L;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public void Code(Drawable drawable) {
        ImageView imageView = this.L;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void Code(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    public void Code(VideoInfo videoInfo) {
        this.n = videoInfo;
    }

    @Override // com.huawei.openalliance.ad.media.listener.c
    public void Code(MediaPlayerAgent mediaPlayerAgent, int i, int i2, int i3) {
        Code(i, false, false);
    }

    public void Code(NativeVideoControlPanel nativeVideoControlPanel) {
        this.C = nativeVideoControlPanel;
        e();
    }

    public void Code(VideoView videoView) {
        this.B = videoView;
    }

    public void Code(a aVar) {
        this.k = aVar;
    }

    public void Code(String str) {
        VideoView videoView;
        if (this.C == null || (videoView = this.B) == null) {
            return;
        }
        videoView.setVideoFileUrl(str);
    }

    @Override // com.huawei.openalliance.ad.views.e
    public void Code(boolean z) {
        fb.Code(Z, "onNetworkConnectedOrChanged, isWifi= %s", Boolean.valueOf(z));
        b(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z, boolean z2) {
        boolean Code;
        View view = this.f17440a;
        if (z2) {
            Code = bi.Code(view, z ? 0 : 8);
        } else {
            Code = bi.Code(view, z);
        }
        if (Code) {
            if (z) {
                c(z2);
            } else {
                d(z2);
            }
        }
    }
}
