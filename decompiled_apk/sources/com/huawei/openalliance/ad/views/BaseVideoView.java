package com.huawei.openalliance.ad.views;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.kw;
import com.huawei.openalliance.ad.constant.cu;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.media.IMultiMediaPlayingManager;
import com.huawei.openalliance.ad.media.MediaPlayerAgent;
import com.huawei.openalliance.ad.media.listener.MediaStateListener;
import com.huawei.openalliance.ad.utils.am;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.bh;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@com.huawei.openalliance.ad.annotations.b
/* loaded from: classes10.dex */
public abstract class BaseVideoView extends AutoScaleSizeRelativeLayout implements TextureView.SurfaceTextureListener, kw {
    private static final String V = "BaseVideoView";
    private boolean A;
    private IMultiMediaPlayingManager B;
    private final Set<com.huawei.openalliance.ad.views.e> C;
    private com.huawei.openalliance.ad.media.listener.g Code;
    private final Set<com.huawei.openalliance.ad.media.listener.f> D;
    private boolean E;
    private final Set<com.huawei.openalliance.ad.media.listener.b> F;
    private boolean G;
    private boolean H;
    private int I;
    private g J;
    private String K;
    private final Set<com.huawei.openalliance.ad.media.listener.c> L;
    private com.huawei.openalliance.ad.media.e M;
    private MediaStateListener N;
    private com.huawei.openalliance.ad.media.listener.b O;
    private com.huawei.openalliance.ad.media.listener.c P;
    private com.huawei.openalliance.ad.media.listener.f Q;
    private com.huawei.openalliance.ad.media.listener.d R;
    private final Set<MediaStateListener> S;
    private e T;
    private b U;
    private c W;

    /* renamed from: a, reason: collision with root package name */
    private final Set<com.huawei.openalliance.ad.media.listener.d> f17416a;
    private f aa;
    private d ab;
    private BroadcastReceiver ac;
    protected TextureView b;
    protected boolean c;
    protected boolean d;
    protected MediaPlayerAgent e;
    protected MediaPlayerAgent f;
    protected Surface g;
    protected SurfaceTexture h;
    protected boolean i;
    protected int j;
    protected boolean k;
    protected MediaPlayer.OnVideoSizeChangedListener l;
    protected int m;
    protected int n;
    protected j o;
    private final Set<com.huawei.openalliance.ad.media.listener.i> p;
    private final Set<com.huawei.openalliance.ad.media.listener.i> q;
    private final Set<com.huawei.openalliance.ad.media.listener.g> r;
    private boolean s;
    private boolean t;
    private boolean u;
    private String v;
    private String[] w;
    private int x;
    private SparseBooleanArray y;
    private h z;

    @SuppressLint({"NewApi"})
    /* loaded from: classes10.dex */
    public static class a extends ConnectivityManager.NetworkCallback {
        private WeakReference<BaseVideoView> Code;

        public a(BaseVideoView baseVideoView) {
            this.Code = new WeakReference<>(baseVideoView);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            final BaseVideoView baseVideoView = this.Code.get();
            if (baseVideoView == null) {
                return;
            }
            final boolean I = am.I(baseVideoView.getContext());
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.a.1
                @Override // java.lang.Runnable
                public void run() {
                    baseVideoView.V(I);
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            final BaseVideoView baseVideoView = this.Code.get();
            if (baseVideoView == null) {
                return;
            }
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.a.2
                @Override // java.lang.Runnable
                public void run() {
                    baseVideoView.k();
                }
            });
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements com.huawei.openalliance.ad.media.listener.b {
        private WeakReference<com.huawei.openalliance.ad.media.listener.b> Code;

        public b(com.huawei.openalliance.ad.media.listener.b bVar) {
            this.Code = new WeakReference<>(bVar);
        }

        @Override // com.huawei.openalliance.ad.media.listener.b
        public void Code() {
            com.huawei.openalliance.ad.media.listener.b bVar = this.Code.get();
            if (bVar != null) {
                bVar.Code();
            }
        }

        @Override // com.huawei.openalliance.ad.media.listener.b
        public void V() {
            com.huawei.openalliance.ad.media.listener.b bVar = this.Code.get();
            if (bVar != null) {
                bVar.V();
            }
        }

        @Override // com.huawei.openalliance.ad.media.listener.b
        public void Code(int i) {
            com.huawei.openalliance.ad.media.listener.b bVar = this.Code.get();
            if (bVar != null) {
                bVar.Code(i);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class c implements com.huawei.openalliance.ad.media.listener.c {
        private WeakReference<com.huawei.openalliance.ad.media.listener.c> Code;

        public c(com.huawei.openalliance.ad.media.listener.c cVar) {
            this.Code = new WeakReference<>(cVar);
        }

        @Override // com.huawei.openalliance.ad.media.listener.c
        public void Code(MediaPlayerAgent mediaPlayerAgent, int i, int i2, int i3) {
            com.huawei.openalliance.ad.media.listener.c cVar = this.Code.get();
            if (cVar != null) {
                cVar.Code(mediaPlayerAgent, i, i2, i3);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class d implements com.huawei.openalliance.ad.media.listener.d {
        private WeakReference<com.huawei.openalliance.ad.media.listener.d> Code;

        public d(com.huawei.openalliance.ad.media.listener.d dVar) {
            this.Code = new WeakReference<>(dVar);
        }

        @Override // com.huawei.openalliance.ad.media.listener.d
        public void Code(int i) {
            com.huawei.openalliance.ad.media.listener.d dVar = this.Code.get();
            if (dVar != null) {
                dVar.Code(i);
            }
        }

        @Override // com.huawei.openalliance.ad.media.listener.d
        public void V(int i) {
            com.huawei.openalliance.ad.media.listener.d dVar = this.Code.get();
            if (dVar != null) {
                dVar.V(i);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class e implements MediaStateListener {
        private WeakReference<MediaStateListener> Code;

        public e(MediaStateListener mediaStateListener) {
            this.Code = new WeakReference<>(mediaStateListener);
        }

        @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
        public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i) {
            fb.Code(BaseVideoView.V, "onMediaCompletion %s", Integer.valueOf(i));
            MediaStateListener mediaStateListener = this.Code.get();
            if (mediaStateListener != null) {
                mediaStateListener.onMediaCompletion(mediaPlayerAgent, i);
            }
        }

        @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
        public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i) {
            fb.Code(BaseVideoView.V, "onMediaPause %s", Integer.valueOf(i));
            MediaStateListener mediaStateListener = this.Code.get();
            if (mediaStateListener != null) {
                mediaStateListener.onMediaPause(mediaPlayerAgent, i);
            }
        }

        @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
        public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i) {
            fb.Code(BaseVideoView.V, "onMediaStart %s", Integer.valueOf(i));
            MediaStateListener mediaStateListener = this.Code.get();
            if (mediaStateListener != null) {
                mediaStateListener.onMediaStart(mediaPlayerAgent, i);
            }
        }

        @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
        public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i) {
            fb.Code(BaseVideoView.V, "onMediaStop %s", Integer.valueOf(i));
            MediaStateListener mediaStateListener = this.Code.get();
            if (mediaStateListener != null) {
                mediaStateListener.onMediaStop(mediaPlayerAgent, i);
            }
        }

        @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
        public void onProgress(int i, int i2) {
            MediaStateListener mediaStateListener = this.Code.get();
            if (mediaStateListener != null) {
                mediaStateListener.onProgress(i, i2);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class f implements com.huawei.openalliance.ad.media.listener.f {
        private WeakReference<com.huawei.openalliance.ad.media.listener.f> Code;

        public f(com.huawei.openalliance.ad.media.listener.f fVar) {
            this.Code = new WeakReference<>(fVar);
        }

        @Override // com.huawei.openalliance.ad.media.listener.f
        public void Code() {
            com.huawei.openalliance.ad.media.listener.f fVar = this.Code.get();
            if (fVar != null) {
                fVar.Code();
            }
        }

        @Override // com.huawei.openalliance.ad.media.listener.f
        public void V() {
            com.huawei.openalliance.ad.media.listener.f fVar = this.Code.get();
            if (fVar != null) {
                fVar.V();
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class g implements com.huawei.openalliance.ad.media.listener.g {
        WeakReference<com.huawei.openalliance.ad.media.listener.g> Code;

        public g(com.huawei.openalliance.ad.media.listener.g gVar) {
            this.Code = new WeakReference<>(gVar);
        }

        @Override // com.huawei.openalliance.ad.media.listener.g
        public void Code() {
            com.huawei.openalliance.ad.media.listener.g gVar = this.Code.get();
            if (gVar != null) {
                gVar.Code();
            }
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    /* loaded from: classes10.dex */
    public interface h {
        void I();
    }

    /* loaded from: classes10.dex */
    public static class i implements MediaPlayer.OnVideoSizeChangedListener {
        private WeakReference<MediaPlayer.OnVideoSizeChangedListener> Code;

        public i(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
            this.Code = new WeakReference<>(onVideoSizeChangedListener);
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this.Code.get();
            if (onVideoSizeChangedListener != null) {
                onVideoSizeChangedListener.onVideoSizeChanged(mediaPlayer, i, i2);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class j implements MediaPlayer.OnVideoSizeChangedListener {
        float Code = 0.0f;
        float V = 0.0f;

        public j() {
        }

        public void Code(int i, int i2) {
            fb.V(BaseVideoView.V, "video size changed - w: %d h: %d", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 0 || i2 == 0) {
                return;
            }
            BaseVideoView baseVideoView = BaseVideoView.this;
            baseVideoView.m = i;
            baseVideoView.n = i2;
            float f = (i * 1.0f) / i2;
            float abs = Math.abs(f - this.Code);
            if (fb.Code()) {
                fb.Code(BaseVideoView.V, "video ratio: %f oldRatio: %f diff: %f", Float.valueOf(f), Float.valueOf(this.Code), Float.valueOf(abs));
            }
            this.Code = f;
            if (BaseVideoView.this.E) {
                if (abs > 0.01f) {
                    BaseVideoView.this.setRatio(Float.valueOf(f));
                    BaseVideoView.this.requestLayout();
                    return;
                }
                return;
            }
            int width = BaseVideoView.this.getWidth();
            int height = BaseVideoView.this.getHeight();
            fb.V(BaseVideoView.V, "resizeVideo view width: %d height: %d", Integer.valueOf(width), Integer.valueOf(height));
            if (height == 0 || width == 0) {
                return;
            }
            float f2 = (width * 1.0f) / height;
            float abs2 = Math.abs(f2 - this.V);
            if (fb.Code()) {
                fb.Code(BaseVideoView.V, "view ratio: %f oldRatio: %f diff: %f", Float.valueOf(f2), Float.valueOf(this.V), Float.valueOf(abs2));
            }
            this.V = f2;
            if (abs2 > 0.01f) {
                BaseVideoView.this.Code(f, f2, width, height);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, final int i, final int i2) {
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.Code(i, i2);
                }
            });
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public BaseVideoView(Context context) {
        super(context);
        this.Code = new com.huawei.openalliance.ad.media.listener.g() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.1
            @Override // com.huawei.openalliance.ad.media.listener.g
            public void Code() {
                BaseVideoView.this.j();
            }
        };
        this.I = 0;
        this.C = new CopyOnWriteArraySet();
        this.S = new CopyOnWriteArraySet();
        this.F = new CopyOnWriteArraySet();
        this.D = new CopyOnWriteArraySet();
        this.L = new CopyOnWriteArraySet();
        this.f17416a = new CopyOnWriteArraySet();
        this.p = new CopyOnWriteArraySet();
        this.q = new CopyOnWriteArraySet();
        this.r = new CopyOnWriteArraySet();
        this.s = true;
        this.t = false;
        this.u = false;
        this.y = new SparseBooleanArray(3);
        this.A = false;
        this.j = 1;
        this.E = true;
        this.k = true;
        this.G = false;
        this.J = new g(this.Code);
        this.o = new j();
        this.N = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.2
            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i2) {
                BaseVideoView.this.C(i2);
                if (BaseVideoView.this.C()) {
                    return;
                }
                BaseVideoView.this.n();
                BaseVideoView.this.Z(mediaPlayerAgent, i2);
                if (BaseVideoView.this.M != null) {
                    BaseVideoView.this.M.Code(i2);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i2) {
                BaseVideoView.this.n();
                BaseVideoView.this.Z(i2);
                BaseVideoView.this.V(mediaPlayerAgent, i2);
                if (BaseVideoView.this.M != null) {
                    BaseVideoView.this.M.V(i2);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i2) {
                if (BaseVideoView.this.u) {
                    BaseVideoView.this.setKeepScreenOn(true);
                }
                BaseVideoView.this.Code();
                BaseVideoView.this.I(i2);
                BaseVideoView.this.Code(mediaPlayerAgent, i2);
                if (BaseVideoView.this.M != null) {
                    BaseVideoView.this.M.Code();
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i2) {
                BaseVideoView.this.n();
                BaseVideoView.this.B(i2);
                BaseVideoView.this.I(mediaPlayerAgent, i2);
                if (BaseVideoView.this.M != null) {
                    BaseVideoView.this.M.Code(i2);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onProgress(int i2, int i3) {
                BaseVideoView.this.V(i2, i3);
                BaseVideoView.this.Code(i2, i3);
            }
        };
        this.O = new com.huawei.openalliance.ad.media.listener.b() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.3
            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code() {
                BaseVideoView.this.h();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void V() {
                BaseVideoView.this.i();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code(int i2) {
                BaseVideoView.this.V(i2);
            }
        };
        this.P = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.4
            @Override // com.huawei.openalliance.ad.media.listener.c
            public void Code(MediaPlayerAgent mediaPlayerAgent, int i2, int i3, int i4) {
                BaseVideoView.this.n();
                BaseVideoView.this.Code(i2, i3, i4);
                BaseVideoView.this.Code(mediaPlayerAgent, i2, i3, i4);
            }
        };
        this.Q = new com.huawei.openalliance.ad.media.listener.f() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.5
            @Override // com.huawei.openalliance.ad.media.listener.f
            public void Code() {
                BaseVideoView.this.G = true;
                BaseVideoView.this.l();
            }

            @Override // com.huawei.openalliance.ad.media.listener.f
            public void V() {
                BaseVideoView.this.G = false;
                BaseVideoView.this.m();
            }
        };
        this.R = new com.huawei.openalliance.ad.media.listener.d() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.6
            @Override // com.huawei.openalliance.ad.media.listener.d
            public void Code(int i2) {
                BaseVideoView.this.S(i2);
            }

            @Override // com.huawei.openalliance.ad.media.listener.d
            public void V(int i2) {
                BaseVideoView.this.F(i2);
            }
        };
        this.T = new e(this.N);
        this.U = new b(this.O);
        this.W = new c(this.P);
        this.aa = new f(this.Q);
        this.ab = new d(this.R);
        this.ac = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.8
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (TextUtils.equals("android.net.conn.CONNECTIVITY_CHANGE", intent.getAction())) {
                    try {
                        ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
                        if (connectivityManager == null) {
                            return;
                        }
                        String str = BaseVideoView.V;
                        int i2 = Build.VERSION.SDK_INT;
                        fb.V(str, "Build.VERSION: %s", Integer.valueOf(i2));
                        if (i2 < 29) {
                            NetworkInfo Code = am.Code(connectivityManager);
                            if (Code == null || !Code.isConnected()) {
                                BaseVideoView.this.k();
                            } else {
                                BaseVideoView.this.V(am.I(context2));
                            }
                        } else {
                            connectivityManager.registerDefaultNetworkCallback(new a(BaseVideoView.this));
                        }
                    } catch (Throwable unused) {
                        fb.I(BaseVideoView.V, "fail to get networkChangeReceiver");
                    }
                }
            }
        };
        V(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(int i2) {
        Iterator<com.huawei.openalliance.ad.media.listener.i> it = this.q.iterator();
        while (it.hasNext()) {
            it.next().Z(getContentId(), getCurrentVideoUrl(), i2);
        }
        Iterator<com.huawei.openalliance.ad.media.listener.i> it2 = this.p.iterator();
        while (it2.hasNext()) {
            it2.next().Z(getContentId(), getCurrentVideoUrl(), i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i2) {
        Iterator<com.huawei.openalliance.ad.media.listener.i> it = this.q.iterator();
        while (it.hasNext()) {
            it.next().Code(getContentId(), getCurrentVideoUrl(), i2);
        }
        Iterator<com.huawei.openalliance.ad.media.listener.i> it2 = this.p.iterator();
        while (it2.hasNext()) {
            it2.next().Code(getContentId(), getCurrentVideoUrl(), i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i2) {
        Iterator<com.huawei.openalliance.ad.media.listener.b> it = this.F.iterator();
        while (it.hasNext()) {
            it.next().Code(i2);
        }
    }

    private String getCurrentVideoUrl() {
        if (this.x < getVideoFileUrlArrayLength()) {
            return this.w[this.x];
        }
        return null;
    }

    private MediaPlayerAgent getNextPlayerAgent() {
        if (this.f == null) {
            MediaPlayerAgent mediaPlayerAgent = new MediaPlayerAgent(getContext());
            this.f = mediaPlayerAgent;
            mediaPlayerAgent.c();
        }
        return this.f;
    }

    private String getNextVideoUrl() {
        int i2 = this.x + 1;
        if (i2 < getVideoFileUrlArrayLength()) {
            return this.w[i2];
        }
        return null;
    }

    private int getVideoFileUrlArrayLength() {
        String[] strArr = this.w;
        if (strArr != null) {
            return strArr.length;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Iterator<com.huawei.openalliance.ad.media.listener.b> it = this.F.iterator();
        while (it.hasNext()) {
            it.next().Code();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Iterator<com.huawei.openalliance.ad.media.listener.b> it = this.F.iterator();
        while (it.hasNext()) {
            it.next().V();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Iterator<com.huawei.openalliance.ad.media.listener.g> it = this.r.iterator();
        while (it.hasNext()) {
            it.next().Code();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (fb.Code()) {
            fb.Code(V, "notifyNetworkDisconnected");
        }
        Iterator<com.huawei.openalliance.ad.views.e> it = this.C.iterator();
        while (it.hasNext()) {
            it.next().Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        Iterator<com.huawei.openalliance.ad.media.listener.f> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().Code();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Iterator<com.huawei.openalliance.ad.media.listener.f> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().V();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.u) {
            setKeepScreenOn(false);
        }
    }

    public void B() {
        TextureView textureView = this.b;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(null);
            ViewParent parent = this.b.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.b);
            }
            TextureView textureView2 = new TextureView(getContext());
            this.b = textureView2;
            textureView2.setSurfaceTextureListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            addView(this.b, layoutParams);
        }
    }

    public MediaPlayerAgent Code(MediaPlayerAgent mediaPlayerAgent) {
        if (mediaPlayerAgent == null) {
            fb.I(V, "no agent to switch");
            return null;
        }
        MediaPlayerAgent mediaPlayerAgent2 = this.e;
        if (mediaPlayerAgent2 != null) {
            mediaPlayerAgent2.V(this.T);
            mediaPlayerAgent2.V(this.U);
            mediaPlayerAgent2.V(this.W);
            mediaPlayerAgent2.V(this.aa);
            mediaPlayerAgent2.I(this.J);
            mediaPlayerAgent2.V(this.ab);
            mediaPlayerAgent2.Code((Surface) null);
        }
        mediaPlayerAgent.Code(this.T);
        mediaPlayerAgent.Code(this.U);
        mediaPlayerAgent.Code(this.W);
        mediaPlayerAgent.Code(this.aa);
        mediaPlayerAgent.V(this.J);
        mediaPlayerAgent.Code(this.ab);
        mediaPlayerAgent.Code(this.H);
        mediaPlayerAgent.Z(this.I);
        Surface surface = this.g;
        if (surface != null) {
            mediaPlayerAgent.Code(surface);
        }
        this.e = mediaPlayerAgent;
        return mediaPlayerAgent2;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void D() {
        fb.V(V, "stop standalone " + this.s);
        this.c = false;
        if (this.s) {
            this.e.Code();
        } else {
            this.B.I(this.v, this.e);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void F() {
        Code(false);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void L() {
        fb.V(V, "pause standalone " + this.s);
        this.c = false;
        if (this.s) {
            this.e.Z();
        } else {
            this.B.Z(this.v, this.e);
        }
    }

    public void S() {
        IMultiMediaPlayingManager iMultiMediaPlayingManager;
        fb.V(V, "resetVideoView");
        if (this.e.d() <= 1) {
            this.e.Code((Surface) null);
            this.e.b();
            if (!this.s && (iMultiMediaPlayingManager = this.B) != null) {
                iMultiMediaPlayingManager.Code(this.e);
            }
        }
        MediaPlayerAgent mediaPlayerAgent = this.f;
        if (mediaPlayerAgent != null) {
            mediaPlayerAgent.Code((Surface) null);
            this.f.b();
        }
        Surface surface = this.g;
        if (surface != null) {
            surface.release();
            this.g = null;
        }
        SurfaceTexture surfaceTexture = this.h;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        this.h = null;
        this.c = false;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void b() {
        fb.V(V, cu.C);
        this.e.D();
    }

    @com.huawei.openalliance.ad.annotations.b
    public void c() {
        fb.V(V, cu.S);
        this.e.L();
    }

    public void d() {
        h hVar = this.z;
        if (hVar != null) {
            hVar.I();
        }
    }

    public void destroyView() {
        this.e.I(this.l);
        if (!this.s) {
            this.B.Code(this.e);
        }
        this.e.a();
        MediaPlayerAgent mediaPlayerAgent = this.f;
        if (mediaPlayerAgent != null) {
            mediaPlayerAgent.a();
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void e() {
        this.e.I();
    }

    public void f() {
        MediaPlayerAgent mediaPlayerAgent = this.e;
        if (mediaPlayerAgent != null) {
            mediaPlayerAgent.a();
        }
    }

    public String getContentId() {
        return this.K;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int getCurrentPosition() {
        return this.e.B();
    }

    @com.huawei.openalliance.ad.annotations.b
    public com.huawei.openalliance.ad.media.b getCurrentState() {
        return this.e.C();
    }

    public MediaPlayerAgent getMediaPlayerAgent() {
        return this.e;
    }

    public com.huawei.openalliance.ad.media.b getMediaState() {
        MediaPlayerAgent mediaPlayerAgent = this.e;
        if (mediaPlayerAgent == null) {
            return null;
        }
        return mediaPlayerAgent.C();
    }

    public int getVideoHeight() {
        return this.n;
    }

    public int getVideoWidth() {
        return this.m;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isHardwareAccelerated()) {
            fb.Z(V, "hardware acceleration is off");
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        HiAd.Code(getContext()).Code(this.ac, intentFilter);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        String str;
        String str2;
        super.onDetachedFromWindow();
        try {
            HiAd.Code(getContext()).Code(this.ac);
        } catch (IllegalStateException unused) {
            str = V;
            str2 = "unregisterReceiver IllegalArgumentException";
            fb.I(str, str2);
        } catch (Exception unused2) {
            str = V;
            str2 = "unregisterReceiver Exception";
            fb.I(str, str2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        if (fb.Code()) {
            fb.Code(V, "onSurfaceTextureSizeChanged width: %d height: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                BaseVideoView baseVideoView = BaseVideoView.this;
                baseVideoView.o.Code(baseVideoView.m, baseVideoView.n);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.huawei.hms.ads.kw
    public void pauseView() {
        this.t = true;
        this.e.e();
    }

    @Override // com.huawei.hms.ads.kw
    public void resumeView() {
        this.t = false;
    }

    public void setAudioFocusType(int i2) {
        this.I = i2;
        this.e.Z(i2);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void setAutoScaleResizeLayoutOnVideoSizeChange(boolean z) {
        this.E = z;
    }

    public void setContentId(String str) {
        this.K = str;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void setDefaultDuration(int i2) {
        this.e.V(i2);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void setMediaPlayerAgent(MediaPlayerAgent mediaPlayerAgent) {
        if (mediaPlayerAgent == null) {
            return;
        }
        mediaPlayerAgent.c();
        MediaPlayerAgent Code = Code(mediaPlayerAgent);
        if (Code != null) {
            Code.a();
        }
    }

    public void setMediaPlayerReleaseListener(com.huawei.openalliance.ad.media.listener.e eVar) {
        MediaPlayerAgent mediaPlayerAgent = this.e;
        if (mediaPlayerAgent != null) {
            mediaPlayerAgent.Code(eVar);
        }
    }

    public void setMuteOnlyOnLostAudioFocus(boolean z) {
        this.H = z;
        this.e.Code(z);
    }

    public void setNeedPauseOnSurfaceDestory(boolean z) {
        this.k = z;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void setPreferStartPlayTime(int i2) {
        this.e.I(i2);
    }

    public void setRemediate(boolean z) {
        this.A = z;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void setScreenOnWhilePlaying(boolean z) {
        this.u = z;
        setKeepScreenOn(z && getCurrentState().Code(com.huawei.openalliance.ad.media.d.PLAYING));
    }

    public void setSoundVolume(float f2) {
        this.e.Code(f2);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void setStandalone(boolean z) {
        this.s = z;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void setSurfaceListener(h hVar) {
        this.z = hVar;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void setVideoFileUrl(String str) {
        setVideoFileUrls(new String[]{str});
    }

    @com.huawei.openalliance.ad.annotations.b
    public void setVideoFileUrls(String[] strArr) {
        String[] strArr2 = strArr != null ? (String[]) Arrays.copyOf(strArr, strArr.length) : null;
        this.w = strArr2;
        this.x = 0;
        this.y.clear();
        if (strArr2 == null || strArr2.length <= 0) {
            this.v = null;
            fb.I(V, "setVideoFileUrls - url array is empty");
        } else {
            fb.V(V, "setVideoFileUrls - size: %d", Integer.valueOf(strArr2.length));
            String str = strArr2[this.x];
            this.v = str;
            this.e.Z(str);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void setVideoScaleMode(int i2) {
        if (i2 == 1 || i2 == 2) {
            this.j = i2;
            return;
        }
        throw new IllegalArgumentException("Not supported video scale mode: " + i2);
    }

    @com.huawei.openalliance.ad.annotations.b
    public BaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Code = new com.huawei.openalliance.ad.media.listener.g() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.1
            @Override // com.huawei.openalliance.ad.media.listener.g
            public void Code() {
                BaseVideoView.this.j();
            }
        };
        this.I = 0;
        this.C = new CopyOnWriteArraySet();
        this.S = new CopyOnWriteArraySet();
        this.F = new CopyOnWriteArraySet();
        this.D = new CopyOnWriteArraySet();
        this.L = new CopyOnWriteArraySet();
        this.f17416a = new CopyOnWriteArraySet();
        this.p = new CopyOnWriteArraySet();
        this.q = new CopyOnWriteArraySet();
        this.r = new CopyOnWriteArraySet();
        this.s = true;
        this.t = false;
        this.u = false;
        this.y = new SparseBooleanArray(3);
        this.A = false;
        this.j = 1;
        this.E = true;
        this.k = true;
        this.G = false;
        this.J = new g(this.Code);
        this.o = new j();
        this.N = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.2
            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i2) {
                BaseVideoView.this.C(i2);
                if (BaseVideoView.this.C()) {
                    return;
                }
                BaseVideoView.this.n();
                BaseVideoView.this.Z(mediaPlayerAgent, i2);
                if (BaseVideoView.this.M != null) {
                    BaseVideoView.this.M.Code(i2);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i2) {
                BaseVideoView.this.n();
                BaseVideoView.this.Z(i2);
                BaseVideoView.this.V(mediaPlayerAgent, i2);
                if (BaseVideoView.this.M != null) {
                    BaseVideoView.this.M.V(i2);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i2) {
                if (BaseVideoView.this.u) {
                    BaseVideoView.this.setKeepScreenOn(true);
                }
                BaseVideoView.this.Code();
                BaseVideoView.this.I(i2);
                BaseVideoView.this.Code(mediaPlayerAgent, i2);
                if (BaseVideoView.this.M != null) {
                    BaseVideoView.this.M.Code();
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i2) {
                BaseVideoView.this.n();
                BaseVideoView.this.B(i2);
                BaseVideoView.this.I(mediaPlayerAgent, i2);
                if (BaseVideoView.this.M != null) {
                    BaseVideoView.this.M.Code(i2);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onProgress(int i2, int i3) {
                BaseVideoView.this.V(i2, i3);
                BaseVideoView.this.Code(i2, i3);
            }
        };
        this.O = new com.huawei.openalliance.ad.media.listener.b() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.3
            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code() {
                BaseVideoView.this.h();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void V() {
                BaseVideoView.this.i();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code(int i2) {
                BaseVideoView.this.V(i2);
            }
        };
        this.P = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.4
            @Override // com.huawei.openalliance.ad.media.listener.c
            public void Code(MediaPlayerAgent mediaPlayerAgent, int i2, int i3, int i4) {
                BaseVideoView.this.n();
                BaseVideoView.this.Code(i2, i3, i4);
                BaseVideoView.this.Code(mediaPlayerAgent, i2, i3, i4);
            }
        };
        this.Q = new com.huawei.openalliance.ad.media.listener.f() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.5
            @Override // com.huawei.openalliance.ad.media.listener.f
            public void Code() {
                BaseVideoView.this.G = true;
                BaseVideoView.this.l();
            }

            @Override // com.huawei.openalliance.ad.media.listener.f
            public void V() {
                BaseVideoView.this.G = false;
                BaseVideoView.this.m();
            }
        };
        this.R = new com.huawei.openalliance.ad.media.listener.d() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.6
            @Override // com.huawei.openalliance.ad.media.listener.d
            public void Code(int i2) {
                BaseVideoView.this.S(i2);
            }

            @Override // com.huawei.openalliance.ad.media.listener.d
            public void V(int i2) {
                BaseVideoView.this.F(i2);
            }
        };
        this.T = new e(this.N);
        this.U = new b(this.O);
        this.W = new c(this.P);
        this.aa = new f(this.Q);
        this.ab = new d(this.R);
        this.ac = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.8
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (TextUtils.equals("android.net.conn.CONNECTIVITY_CHANGE", intent.getAction())) {
                    try {
                        ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
                        if (connectivityManager == null) {
                            return;
                        }
                        String str = BaseVideoView.V;
                        int i2 = Build.VERSION.SDK_INT;
                        fb.V(str, "Build.VERSION: %s", Integer.valueOf(i2));
                        if (i2 < 29) {
                            NetworkInfo Code = am.Code(connectivityManager);
                            if (Code == null || !Code.isConnected()) {
                                BaseVideoView.this.k();
                            } else {
                                BaseVideoView.this.V(am.I(context2));
                            }
                        } else {
                            connectivityManager.registerDefaultNetworkCallback(new a(BaseVideoView.this));
                        }
                    } catch (Throwable unused) {
                        fb.I(BaseVideoView.V, "fail to get networkChangeReceiver");
                    }
                }
            }
        };
        V(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(int i2) {
        Iterator<com.huawei.openalliance.ad.media.listener.i> it = this.q.iterator();
        while (it.hasNext()) {
            it.next().I(getContentId(), getCurrentVideoUrl(), i2);
        }
        Iterator<com.huawei.openalliance.ad.media.listener.i> it2 = this.p.iterator();
        while (it2.hasNext()) {
            it2.next().I(getContentId(), getCurrentVideoUrl(), i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code() {
        String nextVideoUrl = getNextVideoUrl();
        if (nextVideoUrl == null) {
            fb.V(V, "no next video url need to prepare, current: %d", Integer.valueOf(this.x));
            return;
        }
        int i2 = this.x + 1;
        if (this.y.get(i2)) {
            fb.V(V, "player for url %d is already set", Integer.valueOf(i2));
            return;
        }
        fb.V(V, "prepare to set next player[%d]", Integer.valueOf(i2));
        MediaPlayerAgent nextPlayerAgent = getNextPlayerAgent();
        nextPlayerAgent.Z(nextVideoUrl);
        nextPlayerAgent.I();
        this.y.put(i2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(int i2) {
        Iterator<com.huawei.openalliance.ad.media.listener.d> it = this.f17416a.iterator();
        while (it.hasNext()) {
            it.next().V(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i2) {
        Iterator<com.huawei.openalliance.ad.media.listener.d> it = this.f17416a.iterator();
        while (it.hasNext()) {
            it.next().Code(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i2, int i3) {
        Iterator<com.huawei.openalliance.ad.media.listener.i> it = this.q.iterator();
        while (it.hasNext()) {
            it.next().Code(getContentId(), getCurrentVideoUrl(), i2, i3);
        }
        Iterator<com.huawei.openalliance.ad.media.listener.i> it2 = this.p.iterator();
        while (it2.hasNext()) {
            it2.next().Code(getContentId(), getCurrentVideoUrl(), i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i2) {
        Iterator<com.huawei.openalliance.ad.media.listener.i> it = this.q.iterator();
        while (it.hasNext()) {
            it.next().V(getContentId(), getCurrentVideoUrl(), i2);
        }
        Iterator<com.huawei.openalliance.ad.media.listener.i> it2 = this.p.iterator();
        while (it2.hasNext()) {
            it2.next().V(getContentId(), getCurrentVideoUrl(), i2);
        }
    }

    public void I(int i2, int i3) {
        this.e.Code(i2, i3);
    }

    @com.huawei.openalliance.ad.annotations.b
    public boolean a() {
        return this.e.S();
    }

    public BaseVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Code = new com.huawei.openalliance.ad.media.listener.g() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.1
            @Override // com.huawei.openalliance.ad.media.listener.g
            public void Code() {
                BaseVideoView.this.j();
            }
        };
        this.I = 0;
        this.C = new CopyOnWriteArraySet();
        this.S = new CopyOnWriteArraySet();
        this.F = new CopyOnWriteArraySet();
        this.D = new CopyOnWriteArraySet();
        this.L = new CopyOnWriteArraySet();
        this.f17416a = new CopyOnWriteArraySet();
        this.p = new CopyOnWriteArraySet();
        this.q = new CopyOnWriteArraySet();
        this.r = new CopyOnWriteArraySet();
        this.s = true;
        this.t = false;
        this.u = false;
        this.y = new SparseBooleanArray(3);
        this.A = false;
        this.j = 1;
        this.E = true;
        this.k = true;
        this.G = false;
        this.J = new g(this.Code);
        this.o = new j();
        this.N = new MediaStateListener() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.2
            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaCompletion(MediaPlayerAgent mediaPlayerAgent, int i22) {
                BaseVideoView.this.C(i22);
                if (BaseVideoView.this.C()) {
                    return;
                }
                BaseVideoView.this.n();
                BaseVideoView.this.Z(mediaPlayerAgent, i22);
                if (BaseVideoView.this.M != null) {
                    BaseVideoView.this.M.Code(i22);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaPause(MediaPlayerAgent mediaPlayerAgent, int i22) {
                BaseVideoView.this.n();
                BaseVideoView.this.Z(i22);
                BaseVideoView.this.V(mediaPlayerAgent, i22);
                if (BaseVideoView.this.M != null) {
                    BaseVideoView.this.M.V(i22);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStart(MediaPlayerAgent mediaPlayerAgent, int i22) {
                if (BaseVideoView.this.u) {
                    BaseVideoView.this.setKeepScreenOn(true);
                }
                BaseVideoView.this.Code();
                BaseVideoView.this.I(i22);
                BaseVideoView.this.Code(mediaPlayerAgent, i22);
                if (BaseVideoView.this.M != null) {
                    BaseVideoView.this.M.Code();
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onMediaStop(MediaPlayerAgent mediaPlayerAgent, int i22) {
                BaseVideoView.this.n();
                BaseVideoView.this.B(i22);
                BaseVideoView.this.I(mediaPlayerAgent, i22);
                if (BaseVideoView.this.M != null) {
                    BaseVideoView.this.M.Code(i22);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.MediaStateListener
            public void onProgress(int i22, int i3) {
                BaseVideoView.this.V(i22, i3);
                BaseVideoView.this.Code(i22, i3);
            }
        };
        this.O = new com.huawei.openalliance.ad.media.listener.b() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.3
            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code() {
                BaseVideoView.this.h();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void V() {
                BaseVideoView.this.i();
            }

            @Override // com.huawei.openalliance.ad.media.listener.b
            public void Code(int i22) {
                BaseVideoView.this.V(i22);
            }
        };
        this.P = new com.huawei.openalliance.ad.media.listener.c() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.4
            @Override // com.huawei.openalliance.ad.media.listener.c
            public void Code(MediaPlayerAgent mediaPlayerAgent, int i22, int i3, int i4) {
                BaseVideoView.this.n();
                BaseVideoView.this.Code(i22, i3, i4);
                BaseVideoView.this.Code(mediaPlayerAgent, i22, i3, i4);
            }
        };
        this.Q = new com.huawei.openalliance.ad.media.listener.f() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.5
            @Override // com.huawei.openalliance.ad.media.listener.f
            public void Code() {
                BaseVideoView.this.G = true;
                BaseVideoView.this.l();
            }

            @Override // com.huawei.openalliance.ad.media.listener.f
            public void V() {
                BaseVideoView.this.G = false;
                BaseVideoView.this.m();
            }
        };
        this.R = new com.huawei.openalliance.ad.media.listener.d() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.6
            @Override // com.huawei.openalliance.ad.media.listener.d
            public void Code(int i22) {
                BaseVideoView.this.S(i22);
            }

            @Override // com.huawei.openalliance.ad.media.listener.d
            public void V(int i22) {
                BaseVideoView.this.F(i22);
            }
        };
        this.T = new e(this.N);
        this.U = new b(this.O);
        this.W = new c(this.P);
        this.aa = new f(this.Q);
        this.ab = new d(this.R);
        this.ac = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.views.BaseVideoView.8
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (TextUtils.equals("android.net.conn.CONNECTIVITY_CHANGE", intent.getAction())) {
                    try {
                        ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
                        if (connectivityManager == null) {
                            return;
                        }
                        String str = BaseVideoView.V;
                        int i22 = Build.VERSION.SDK_INT;
                        fb.V(str, "Build.VERSION: %s", Integer.valueOf(i22));
                        if (i22 < 29) {
                            NetworkInfo Code = am.Code(connectivityManager);
                            if (Code == null || !Code.isConnected()) {
                                BaseVideoView.this.k();
                            } else {
                                BaseVideoView.this.V(am.I(context2));
                            }
                        } else {
                            connectivityManager.registerDefaultNetworkCallback(new a(BaseVideoView.this));
                        }
                    } catch (Throwable unused) {
                        fb.I(BaseVideoView.V, "fail to get networkChangeReceiver");
                    }
                }
            }
        };
        V(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C() {
        String nextVideoUrl;
        int i2 = this.x + 1;
        if (!this.y.get(i2) || (nextVideoUrl = getNextVideoUrl()) == null) {
            fb.V(V, "no next player to switch, current: %d", Integer.valueOf(this.x));
            return false;
        }
        this.v = nextVideoUrl;
        this.f = Code(getNextPlayerAgent());
        if (!TextUtils.equals(nextVideoUrl, this.e.F())) {
            this.e.Z(nextVideoUrl);
        }
        if (this.G) {
            this.e.D();
        } else {
            this.e.L();
        }
        this.e.V();
        this.x = i2;
        fb.V(V, "switch to next player [%d] and play", Integer.valueOf(i2));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(MediaPlayerAgent mediaPlayerAgent, int i2) {
        Iterator<MediaStateListener> it = this.S.iterator();
        while (it.hasNext()) {
            it.next().onMediaStop(mediaPlayerAgent, i2);
        }
    }

    private void V(Context context) {
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        Code(context);
        this.B = HiAd.Code(context).V();
        setMediaPlayerAgent(new MediaPlayerAgent(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(MediaPlayerAgent mediaPlayerAgent, int i2) {
        Iterator<MediaStateListener> it = this.S.iterator();
        while (it.hasNext()) {
            it.next().onMediaCompletion(mediaPlayerAgent, i2);
        }
    }

    public void Code(float f2) {
        fb.V(V, "unmute, volume: %s", Float.valueOf(f2));
        this.e.V(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(MediaPlayerAgent mediaPlayerAgent, int i2) {
        Iterator<MediaStateListener> it = this.S.iterator();
        while (it.hasNext()) {
            it.next().onMediaPause(mediaPlayerAgent, i2);
        }
    }

    public void Code(float f2, float f3, int i2, int i3) {
        Matrix matrix;
        float f4;
        float f5 = 1.0f;
        float f6 = (i2 * 1.0f) / 2.0f;
        float f7 = (i3 * 1.0f) / 2.0f;
        int i4 = this.j;
        if (i4 == 1) {
            fb.V(V, "set video scale mode as fit");
            matrix = new Matrix();
            matrix.setScale(1.0f, 1.0f, f6, f7);
        } else {
            if (i4 != 2) {
                return;
            }
            String str = V;
            fb.V(str, "set video scale mode as fit with cropping");
            if (f3 < f2) {
                f5 = f2 / f3;
                f4 = 1.0f;
            } else {
                f4 = f3 / f2;
            }
            fb.Code(str, "calculateScaleMatrix scaleX: %s scaleY: %s pivotPointX: %s pivotPointY: %s", Float.valueOf(f5), Float.valueOf(f4), Float.valueOf(f6), Float.valueOf(f7));
            matrix = new Matrix();
            matrix.setScale(f5, f4, f6, f7);
        }
        this.b.setTransform(matrix);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void I(com.huawei.openalliance.ad.media.listener.i iVar) {
        if (iVar != null) {
            this.q.add(iVar);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Z(com.huawei.openalliance.ad.media.listener.i iVar) {
        if (iVar != null) {
            this.q.remove(iVar);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(int i2) {
        this.e.Code(i2);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(MediaStateListener mediaStateListener) {
        if (mediaStateListener == null) {
            return;
        }
        this.S.remove(mediaStateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i2, int i3) {
        Iterator<MediaStateListener> it = this.S.iterator();
        while (it.hasNext()) {
            it.next().onProgress(i2, i3);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(com.huawei.openalliance.ad.media.listener.b bVar) {
        if (bVar == null) {
            return;
        }
        this.F.remove(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i2, int i3, int i4) {
        Iterator<com.huawei.openalliance.ad.media.listener.i> it = this.p.iterator();
        while (it.hasNext()) {
            it.next().Code(getContentId(), getCurrentVideoUrl(), i2, i3, i4);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(com.huawei.openalliance.ad.media.listener.c cVar) {
        if (cVar == null) {
            return;
        }
        this.L.remove(cVar);
    }

    @Override // com.huawei.openalliance.ad.views.AutoScaleSizeRelativeLayout
    public boolean Z() {
        return this.A;
    }

    public void Code(Context context) {
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(com.huawei.openalliance.ad.media.listener.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f17416a.remove(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(MediaPlayerAgent mediaPlayerAgent, int i2) {
        Iterator<MediaStateListener> it = this.S.iterator();
        while (it.hasNext()) {
            it.next().onMediaStart(mediaPlayerAgent, i2);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(com.huawei.openalliance.ad.media.listener.f fVar) {
        if (fVar == null) {
            return;
        }
        this.D.remove(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(MediaPlayerAgent mediaPlayerAgent, int i2, int i3, int i4) {
        Iterator<com.huawei.openalliance.ad.media.listener.c> it = this.L.iterator();
        while (it.hasNext()) {
            it.next().Code(mediaPlayerAgent, i2, i3, i4);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(com.huawei.openalliance.ad.media.listener.g gVar) {
        if (gVar == null) {
            return;
        }
        this.r.remove(gVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(MediaStateListener mediaStateListener) {
        if (mediaStateListener == null) {
            return;
        }
        this.S.add(mediaStateListener);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(com.huawei.openalliance.ad.media.listener.i iVar) {
        if (iVar != null) {
            this.p.remove(iVar);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(com.huawei.openalliance.ad.media.listener.b bVar) {
        if (bVar == null) {
            return;
        }
        this.F.add(bVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(com.huawei.openalliance.ad.media.listener.c cVar) {
        if (cVar == null) {
            return;
        }
        this.L.add(cVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(com.huawei.openalliance.ad.media.listener.d dVar) {
        if (dVar == null) {
            return;
        }
        this.f17416a.add(dVar);
    }

    public void Code(com.huawei.openalliance.ad.media.listener.e eVar) {
        MediaPlayerAgent mediaPlayerAgent = this.e;
        if (mediaPlayerAgent != null) {
            mediaPlayerAgent.I(eVar);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(com.huawei.openalliance.ad.media.listener.f fVar) {
        if (fVar == null) {
            return;
        }
        this.D.add(fVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(com.huawei.openalliance.ad.views.e eVar) {
        if (eVar == null) {
            return;
        }
        this.C.remove(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(boolean z) {
        if (fb.Code()) {
            fb.Code(V, "notifyNetworkConnectedOrChanged wifi: %s", Boolean.valueOf(z));
        }
        Iterator<com.huawei.openalliance.ad.views.e> it = this.C.iterator();
        while (it.hasNext()) {
            it.next().Code(z);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(com.huawei.openalliance.ad.media.listener.g gVar) {
        if (gVar == null) {
            return;
        }
        this.r.add(gVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(com.huawei.openalliance.ad.media.listener.h hVar) {
        if (this.M == null) {
            this.M = new com.huawei.openalliance.ad.media.e(getContext().getApplicationContext());
        }
        this.M.Code(hVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(com.huawei.openalliance.ad.media.listener.i iVar) {
        if (iVar != null) {
            this.p.add(iVar);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(com.huawei.openalliance.ad.views.e eVar) {
        if (eVar == null) {
            return;
        }
        this.C.add(eVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(boolean z) {
        if (this.t) {
            fb.I(V, "play action is not performed - view paused");
            return;
        }
        fb.V(V, "play auto: %s surfaceAvailable: %s standalone: %s url: %s", Boolean.valueOf(z), Boolean.valueOf(this.d), Boolean.valueOf(this.s), bh.Code(this.v));
        if (!this.d) {
            this.c = true;
            this.i = z;
            return;
        }
        Surface surface = this.g;
        if (surface != null) {
            this.e.Code(surface);
        }
        if (this.s) {
            this.e.V();
        } else if (z) {
            this.B.Code(this.v, this.e);
        } else {
            this.B.V(this.v, this.e);
        }
    }
}
