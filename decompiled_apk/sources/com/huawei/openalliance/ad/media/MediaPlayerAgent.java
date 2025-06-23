package com.huawei.openalliance.ad.media;

import O0xOxO.Oxx0IOOO;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import androidx.media.II0xO0;
import com.google.android.exoplayer2.I0Io;
import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.hms.ads.dq;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.constant.ca;
import com.huawei.openalliance.ad.media.listener.MediaStateListener;
import com.huawei.openalliance.ad.media.listener.f;
import com.huawei.openalliance.ad.media.listener.g;
import com.huawei.openalliance.ad.media.listener.h;
import com.huawei.openalliance.ad.utils.ax;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.bh;
import com.huawei.openalliance.ad.utils.t;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;

@com.huawei.openalliance.ad.annotations.b
/* loaded from: classes10.dex */
public class MediaPlayerAgent {
    private static final int B = 20;
    private static final int C = 805;
    private static final int F = 2;
    private static final String I = "MediaPlayerAgent";
    private static final int L = 100;
    private static final int S = 300;
    private static final int Z = -10000;

    /* renamed from: a, reason: collision with root package name */
    private static final int f17404a = 0;
    private static final String b = "progress_task";
    private static final int c = 100;
    private static final int d = 200;
    private static final int e = 0;
    private Object A;
    private MediaPlayer D;
    private WeakReference<Surface> E;
    private int G;
    private e J;
    private Context K;
    private volatile String h;
    private boolean i;
    private int n;
    private int o;
    private AudioManager u;
    private static final String Code = "thread_media_player_ctrl";
    private static final t V = new t(Code);
    private int f = 0;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private int m = 0;
    private final b p = new b();
    private final byte[] q = new byte[0];
    private final byte[] r = new byte[0];
    private final byte[] s = new byte[0];
    private int t = 0;
    private boolean v = false;
    private boolean w = false;
    private int x = 0;
    private boolean y = false;
    private volatile int z = 0;
    private boolean H = false;
    private final CopyOnWriteArraySet<MediaStateListener> M = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<com.huawei.openalliance.ad.media.listener.b> N = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<com.huawei.openalliance.ad.media.listener.c> O = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<f> P = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<com.huawei.openalliance.ad.media.listener.d> Q = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<MediaPlayer.OnVideoSizeChangedListener> R = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<g> T = new CopyOnWriteArraySet<>();
    private final CopyOnWriteArraySet<com.huawei.openalliance.ad.media.listener.e> U = new CopyOnWriteArraySet<>();
    private final MediaPlayer.OnVideoSizeChangedListener W = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.1
        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            MediaPlayerAgent.this.Code(mediaPlayer, i, i2);
        }
    };
    private MediaPlayer.OnCompletionListener X = new MediaPlayer.OnCompletionListener() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.12
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (MediaPlayerAgent.this.p.Code(d.ERROR)) {
                return;
            }
            b bVar = MediaPlayerAgent.this.p;
            d dVar = d.PLAYBACK_COMPLETED;
            if (bVar.Code(dVar)) {
                return;
            }
            MediaPlayerAgent.this.p.I(dVar);
            int currentPosition = mediaPlayer.getCurrentPosition();
            int l = MediaPlayerAgent.this.l();
            fb.V(MediaPlayerAgent.I, "onCompletion " + currentPosition + " duration: " + l);
            int max = Math.max(currentPosition, l);
            MediaPlayerAgent.this.V(100, max);
            MediaPlayerAgent.this.B(max);
            MediaPlayerAgent.this.u();
            MediaPlayerAgent.F(MediaPlayerAgent.this.g);
            MediaPlayerAgent.this.m = 0;
            MediaPlayerAgent.this.t = 0;
        }
    };
    private MediaPlayer.OnInfoListener Y = new MediaPlayer.OnInfoListener() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.23
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0025, code lost:
        
            if (r5 != 702) goto L15;
         */
        @Override // android.media.MediaPlayer.OnInfoListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onInfo(android.media.MediaPlayer r4, int r5, int r6) {
            /*
                r3 = this;
                java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
                java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
                r1 = 2
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r2 = 0
                r1[r2] = r4
                r4 = 1
                r1[r4] = r0
                java.lang.String r0 = "MediaPlayerAgent"
                java.lang.String r2 = "onInfo what: %d extra: %d"
                com.huawei.hms.ads.fb.V(r0, r2, r1)
                r0 = 3
                if (r5 == r0) goto L3a
                r0 = 805(0x325, float:1.128E-42)
                if (r5 == r0) goto L34
                r6 = 701(0x2bd, float:9.82E-43)
                if (r5 == r6) goto L2e
                r6 = 702(0x2be, float:9.84E-43)
                if (r5 == r6) goto L28
                goto L40
            L28:
                com.huawei.openalliance.ad.media.MediaPlayerAgent r5 = com.huawei.openalliance.ad.media.MediaPlayerAgent.this
                com.huawei.openalliance.ad.media.MediaPlayerAgent.I(r5)
                goto L40
            L2e:
                com.huawei.openalliance.ad.media.MediaPlayerAgent r5 = com.huawei.openalliance.ad.media.MediaPlayerAgent.this
                com.huawei.openalliance.ad.media.MediaPlayerAgent.B(r5)
                goto L40
            L34:
                com.huawei.openalliance.ad.media.MediaPlayerAgent r5 = com.huawei.openalliance.ad.media.MediaPlayerAgent.this
                com.huawei.openalliance.ad.media.MediaPlayerAgent.Z(r5, r6)
                goto L40
            L3a:
                com.huawei.openalliance.ad.media.MediaPlayerAgent r5 = com.huawei.openalliance.ad.media.MediaPlayerAgent.this
                com.huawei.openalliance.ad.media.MediaPlayerAgent.C(r5)
                goto L28
            L40:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.media.MediaPlayerAgent.AnonymousClass23.onInfo(android.media.MediaPlayer, int, int):boolean");
        }
    };
    private MediaPlayer.OnPreparedListener aa = new MediaPlayer.OnPreparedListener() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.34
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            fb.V(MediaPlayerAgent.I, "onPrepared");
            MediaPlayerAgent.this.k = false;
            mediaPlayer.setOnInfoListener(MediaPlayerAgent.this.Y);
            if (MediaPlayerAgent.this.l || MediaPlayerAgent.this.p.V(d.PREPARING)) {
                MediaPlayerAgent.this.p.I(d.PREPARED);
                MediaPlayerAgent mediaPlayerAgent = MediaPlayerAgent.this;
                mediaPlayerAgent.L(mediaPlayerAgent.l());
                return;
            }
            try {
                MediaPlayerAgent.this.p.I(d.PREPARED);
                mediaPlayer.start();
                MediaPlayerAgent.V(mediaPlayer, MediaPlayerAgent.this.o, 3);
                MediaPlayerAgent.this.p.I(d.PLAYING);
                if (fb.Code()) {
                    fb.Code(MediaPlayerAgent.I, "seek to prefer pos: %d", Integer.valueOf(MediaPlayerAgent.this.o));
                }
                MediaPlayerAgent.this.S(mediaPlayer.getCurrentPosition());
                MediaPlayerAgent mediaPlayerAgent2 = MediaPlayerAgent.this;
                mediaPlayerAgent2.L(mediaPlayerAgent2.l());
                MediaPlayerAgent.this.x();
            } catch (IllegalStateException unused) {
                fb.I(MediaPlayerAgent.I, "onPrepared - IllegalStateException");
                MediaPlayerAgent.this.p.I(d.ERROR);
                MediaPlayerAgent.this.Code(0, -1, -1);
            }
        }
    };
    private MediaPlayer.OnErrorListener ab = new MediaPlayer.OnErrorListener() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.38
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            fb.I(MediaPlayerAgent.I, "onError - what: %d extra: %d currentState: %s - agent: %s", Integer.valueOf(i), Integer.valueOf(i2), MediaPlayerAgent.this.p, MediaPlayerAgent.this);
            MediaPlayerAgent.this.u();
            b bVar = MediaPlayerAgent.this.p;
            d dVar = d.ERROR;
            if (bVar.Code(dVar)) {
                return true;
            }
            MediaPlayerAgent.this.p.I(dVar);
            MediaPlayerAgent.this.Code(mediaPlayer.getCurrentPosition(), i, i2);
            return true;
        }
    };
    private MediaPlayer.OnBufferingUpdateListener ac = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.39
        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (MediaPlayerAgent.this.p.Code()) {
                if (i < 0) {
                    i = 0;
                }
                if (i > 100) {
                    i = 100;
                }
                MediaPlayerAgent.this.C(i);
            }
        }
    };
    private Callable<Boolean> ad = new Callable<Boolean>() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.7
        @Override // java.util.concurrent.Callable
        /* renamed from: Code, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            return Boolean.valueOf(MediaPlayerAgent.this.n());
        }
    };
    private Runnable ae = new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.30
        @Override // java.lang.Runnable
        public void run() {
            int l;
            MediaPlayerAgent.F(MediaPlayerAgent.this.g);
            if (MediaPlayerAgent.this.p.V(d.PREPARING) && MediaPlayerAgent.this.p.V(d.PLAYING) && MediaPlayerAgent.this.p.V(d.PREPARED)) {
                return;
            }
            int B2 = MediaPlayerAgent.this.B();
            if (MediaPlayerAgent.this.M.size() > 0 && (l = MediaPlayerAgent.this.l()) > 0) {
                int ceil = (int) Math.ceil((B2 * 100.0f) / l);
                if (ceil > 100) {
                    ceil = 100;
                }
                MediaPlayerAgent.this.V(ceil, B2);
                if (B2 >= l) {
                    MediaPlayerAgent.p(MediaPlayerAgent.this);
                    if (MediaPlayerAgent.this.t > 2) {
                        fb.V(MediaPlayerAgent.I, "reach end count exceeds");
                        MediaPlayerAgent.this.X.onCompletion(MediaPlayerAgent.this.f());
                        return;
                    }
                }
            }
            if (MediaPlayerAgent.this.i && MediaPlayerAgent.this.N.size() > 0 && MediaPlayerAgent.this.t == 0) {
                if (Math.abs(B2 - MediaPlayerAgent.this.m) < 100) {
                    MediaPlayerAgent.this.r();
                } else {
                    MediaPlayerAgent.this.u();
                    MediaPlayerAgent.this.m = B2;
                }
            }
            MediaPlayerAgent.V(MediaPlayerAgent.this.ae, MediaPlayerAgent.this.g, 200L);
        }
    };
    private AudioManager.OnAudioFocusChangeListener af = new AudioManager.OnAudioFocusChangeListener() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.36
        /* JADX INFO: Access modifiers changed from: private */
        public void Code() {
            if (MediaPlayerAgent.this.H) {
                fb.V(MediaPlayerAgent.I, "handleAudioFocusLoss muteOnlyOnLostAudioFocus: " + MediaPlayerAgent.this.H);
                V();
                return;
            }
            boolean n = MediaPlayerAgent.this.n();
            fb.V(MediaPlayerAgent.I, "handleAudioFocusLoss isPlaying: %s", Boolean.valueOf(n));
            if (n) {
                MediaPlayerAgent.this.Z();
                MediaPlayerAgent.this.v = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void I() {
            fb.V(MediaPlayerAgent.I, "handleAudioFocusGain - muteOnlyOnLostAudioFocus: " + MediaPlayerAgent.this.H);
            if (!MediaPlayerAgent.this.H) {
                if (MediaPlayerAgent.this.x == -2 || MediaPlayerAgent.this.x == -1) {
                    if (MediaPlayerAgent.this.v) {
                        MediaPlayerAgent.this.g();
                        MediaPlayerAgent.this.v = false;
                        return;
                    }
                    return;
                }
                if (MediaPlayerAgent.this.x == -3 && MediaPlayerAgent.this.w) {
                    MediaPlayerAgent.this.q();
                    return;
                }
                return;
            }
            if (MediaPlayerAgent.this.w) {
                MediaPlayerAgent.this.q();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V() {
            fb.V(MediaPlayerAgent.I, "handleAudioFocusLossTransientCanDuck soundMuted: " + MediaPlayerAgent.this.y);
            if (MediaPlayerAgent.this.y) {
                return;
            }
            MediaPlayerAgent.this.p();
            MediaPlayerAgent.this.w = true;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            MediaPlayerAgent.V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.36.1
                @Override // java.lang.Runnable
                public void run() {
                    fb.V(MediaPlayerAgent.I, "onAudioFocusChange %d previous: %d", Integer.valueOf(i), Integer.valueOf(MediaPlayerAgent.this.x));
                    int i2 = i;
                    if (i2 == -3) {
                        V();
                    } else if (i2 == -2 || i2 == -1) {
                        Code();
                    } else if (i2 == 1 || i2 == 2) {
                        I();
                    }
                    MediaPlayerAgent.this.x = i;
                }
            });
        }
    };
    private String g = b + hashCode();

    @com.huawei.openalliance.ad.annotations.b
    public MediaPlayerAgent(Context context) {
        this.K = context.getApplicationContext();
        this.u = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        V.Code();
    }

    private void A() {
        String str;
        AudioFocusRequest.Builder onAudioFocusChangeListener;
        AudioFocusRequest build;
        if (!G()) {
            fb.I(I, "audio focus is not needed");
            return;
        }
        try {
            fb.V(I, "requestAudioFocus");
            if (Build.VERSION.SDK_INT < 26) {
                this.u.requestAudioFocus(this.af, 3, 2);
            } else {
                I0Io.oIX0oI();
                onAudioFocusChangeListener = Oxx0IOOO.oIX0oI(2).setOnAudioFocusChangeListener(this.af);
                build = onAudioFocusChangeListener.build();
                this.A = build;
                this.u.requestAudioFocus(build);
            }
        } catch (IllegalStateException unused) {
            str = "requestAudioFocus IllegalStateException";
            fb.I(I, str);
        } catch (Exception e2) {
            str = "requestAudioFocus " + e2.getClass().getSimpleName();
            fb.I(I, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        String str;
        try {
            try {
                fb.V(I, "abandonAudioFocus");
                if (Build.VERSION.SDK_INT < 26) {
                    this.u.abandonAudioFocus(this.af);
                } else {
                    if (oIX0oI.oIX0oI(this.A)) {
                        this.u.abandonAudioFocusRequest(II0xO0.oIX0oI(this.A));
                    }
                    this.A = null;
                }
            } catch (IllegalStateException unused) {
                str = "abandonAudioFocus IllegalStateException";
                fb.I(I, str);
                this.w = false;
                this.v = false;
                this.x = 0;
            } catch (Exception e2) {
                str = "abandonAudioFocus " + e2.getClass().getSimpleName();
                fb.I(I, str);
                this.w = false;
                this.v = false;
                this.x = 0;
            }
            this.w = false;
            this.v = false;
            this.x = 0;
        } catch (Throwable th) {
            this.w = false;
            this.v = false;
            this.x = 0;
            throw th;
        }
    }

    private boolean G() {
        fb.V(I, "isNeedAudioFocus type: %s soundMute: %s", Integer.valueOf(this.z), Boolean.valueOf(this.y));
        if (this.z == 0) {
            return true;
        }
        if (this.z == 2) {
            return false;
        }
        return (this.z == 1 && this.y) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer f() {
        MediaPlayer mediaPlayer;
        synchronized (this.q) {
            try {
                if (this.D == null) {
                    MediaPlayer mediaPlayer2 = new MediaPlayer();
                    mediaPlayer2.setOnCompletionListener(this.X);
                    mediaPlayer2.setOnPreparedListener(this.aa);
                    mediaPlayer2.setOnErrorListener(this.ab);
                    mediaPlayer2.setOnBufferingUpdateListener(this.ac);
                    mediaPlayer2.setOnVideoSizeChangedListener(this.W);
                    mediaPlayer2.setLooping(false);
                    mediaPlayer2.setAudioStreamType(3);
                    this.D = mediaPlayer2;
                }
                mediaPlayer = this.D;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaPlayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.p.Code(d.END)) {
            fb.V(I, "play - current state: %s - agent: %s", this.p, this);
            return;
        }
        fb.Code(I, "play file: %s", bh.Code(this.h));
        this.l = false;
        if (!this.p.Code(d.ERROR) && !this.p.Code(d.IDLE)) {
            b bVar = this.p;
            d dVar = d.PLAYING;
            if (!bVar.Code(dVar)) {
                MediaPlayer f = f();
                fb.V(I, "play - state before play: %s - agent: %s", this.p, this);
                if (this.k || !(this.p.Code(d.PAUSED) || this.p.Code(d.PLAYBACK_COMPLETED) || this.p.Code(d.PREPARED))) {
                    try {
                        C(this.h);
                        if (this.p.Code(d.INITIALIZED)) {
                            V(true);
                        }
                    } catch (dq e2) {
                        fb.Code(I, "set media file error:%s", e2.getMessage());
                        fb.I(I, "set media file error:" + e2.getClass().getSimpleName());
                        this.p.I(d.ERROR);
                        Code(0, -1, -1);
                    }
                } else {
                    try {
                        f.start();
                        if (this.p.Code(d.PREPARED)) {
                            if (Build.VERSION.SDK_INT >= 26) {
                                f.seekTo(this.o, 3);
                            } else {
                                f.seekTo(this.o);
                            }
                        }
                        int currentPosition = this.p.Code(d.PLAYBACK_COMPLETED) ? 0 : f.getCurrentPosition();
                        this.p.I(dVar);
                        S(currentPosition);
                        x();
                    } catch (IllegalStateException unused) {
                        fb.I(I, "play - start IllegalStateException");
                        this.p.I(d.ERROR);
                        Code(f.getCurrentPosition(), -100, 0);
                        u();
                    }
                }
                fb.V(I, "play - current state: %s", this.p);
                return;
            }
        }
        fb.V(I, "play - current state: %s - agent: %s", this.p, this);
        if (this.p.Code(d.PLAYING)) {
            S(f().getCurrentPosition());
            x();
            return;
        }
        try {
            C(this.h);
            fb.V(I, "play - current state after set file: %s", this.p);
            if (this.p.Code(d.INITIALIZED)) {
                V(true);
            }
        } catch (dq e3) {
            fb.Code(I, "set media file error:%s", e3.getMessage());
            fb.I(I, "set media file error:" + e3.getClass().getSimpleName());
            this.p.I(d.ERROR);
            Code(0, -1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        fb.V(I, "prepareInternal - current state: %s - agent: %s", this.p, this);
        if (this.p.Code(d.END)) {
            return;
        }
        fb.V(I, "prepareInternal - current state after set file: %s", this.p);
        if (this.p.Code(d.INITIALIZED)) {
            this.l = true;
            V(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l() {
        MediaPlayer mediaPlayer;
        int duration;
        if (this.p.Code(d.END)) {
            return 0;
        }
        int m = m();
        if (!this.p.Code() || this.k) {
            return m;
        }
        try {
            synchronized (this.q) {
                mediaPlayer = this.D;
            }
            return (mediaPlayer == null || (duration = mediaPlayer.getDuration()) <= 0) ? m : duration;
        } catch (IllegalStateException unused) {
            fb.I(I, "getDuration IllegalStateException");
            return m;
        }
    }

    private int m() {
        int i;
        synchronized (this.r) {
            i = this.n;
        }
        return i;
    }

    private Surface o() {
        WeakReference<Surface> weakReference = this.E;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static /* synthetic */ int p(MediaPlayerAgent mediaPlayerAgent) {
        int i = mediaPlayerAgent.t;
        mediaPlayerAgent.t = i + 1;
        return i;
    }

    private void t() {
        CopyOnWriteArraySet<com.huawei.openalliance.ad.media.listener.e> copyOnWriteArraySet = this.U;
        if (copyOnWriteArraySet == null || copyOnWriteArraySet.size() == 0) {
            return;
        }
        fb.V(I, "notify player release");
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.19
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaPlayerAgent.this.U.iterator();
                while (it.hasNext()) {
                    com.huawei.openalliance.ad.media.listener.e eVar = (com.huawei.openalliance.ad.media.listener.e) it.next();
                    if (eVar != null) {
                        eVar.Code();
                    }
                }
            }
        });
    }

    private void w() {
        if (!this.y) {
            fb.V(I, "already unmuted, don't notify");
            return;
        }
        fb.V(I, "notifyUnmute");
        this.y = false;
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.27
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaPlayerAgent.this.P.iterator();
                while (it.hasNext()) {
                    f fVar = (f) it.next();
                    if (fVar != null) {
                        fVar.V();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        F(this.g);
        if (this.M.size() > 0) {
            V(this.ae);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.media.MediaPlayer, android.media.MediaPlayer$OnVideoSizeChangedListener] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public void y() {
        synchronized (this.q) {
            try {
                b bVar = this.p;
                d dVar = d.END;
                if (bVar.Code(dVar)) {
                    return;
                }
                this.p.I(dVar);
                fb.V(I, "release - agent: %s", this);
                V.V();
                z();
                MediaPlayer mediaPlayer = this.D;
                if (mediaPlayer != null) {
                    ?? r2 = 0;
                    r2 = 0;
                    try {
                        try {
                            mediaPlayer.setSurface(null);
                            this.D.setOnVideoSizeChangedListener(null);
                            this.D.release();
                            this.D = null;
                            fb.V(I, "release media player");
                            r2 = "release media player";
                        } catch (IllegalStateException unused) {
                            fb.I(I, "media player reset surface IllegalStateException");
                            this.D.setOnVideoSizeChangedListener(null);
                            this.D.release();
                            this.D = null;
                            fb.V(I, "release media player");
                            r2 = "release media player";
                        }
                        t();
                    } catch (Throwable th) {
                        this.D.setOnVideoSizeChangedListener(r2);
                        this.D.release();
                        this.D = r2;
                        fb.V(I, "release media player");
                        t();
                        throw th;
                    }
                }
                this.M.clear();
                this.N.clear();
                this.O.clear();
                this.P.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public int B() {
        MediaPlayer mediaPlayer;
        if (!this.p.Code(d.END) && !this.p.Code(d.ERROR) && !this.p.Code(d.IDLE)) {
            try {
                synchronized (this.q) {
                    mediaPlayer = this.D;
                }
                if (mediaPlayer != null) {
                    return mediaPlayer.getCurrentPosition();
                }
            } catch (IllegalStateException unused) {
                fb.I(I, "getCurrentPlayPosition IllegalStateException");
            }
        }
        return 0;
    }

    @com.huawei.openalliance.ad.annotations.b
    public b C() {
        return this.p;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void L() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.11
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.q();
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void a() {
        synchronized (this.s) {
            try {
                int i = this.f - 1;
                this.f = i;
                if (i < 0) {
                    this.f = 0;
                }
                if (fb.Code()) {
                    fb.Code(I, "release - instanceRefCount: %d - agent: %s", Integer.valueOf(this.f), this);
                }
                if (this.f == 0) {
                    V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.31
                        @Override // java.lang.Runnable
                        public void run() {
                            MediaPlayerAgent.this.y();
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void c() {
        synchronized (this.s) {
            try {
                this.f++;
                if (fb.Code()) {
                    fb.Code(I, "acquire - instanceRefCount: %d - agent: %s", Integer.valueOf(this.f), this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public int d() {
        int i;
        synchronized (this.s) {
            i = this.f;
        }
        return i;
    }

    public void e() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.35
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.E();
            }
        });
    }

    public void finalize() {
        super.finalize();
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.32
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.y();
            }
        });
    }

    public String toString() {
        return "MediaPlayerAgent@" + Integer.toHexString(hashCode()) + " [" + bh.Code(this.h) + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(final int i) {
        fb.V(I, "notifyMediaCompletion playTime: %d", Integer.valueOf(i));
        e();
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.15
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaPlayerAgent.this.M.iterator();
                while (it.hasNext()) {
                    MediaStateListener mediaStateListener = (MediaStateListener) it.next();
                    if (mediaStateListener != null) {
                        mediaStateListener.onMediaCompletion(MediaPlayerAgent.this, i);
                    }
                }
            }
        });
        e eVar = this.J;
        if (eVar != null) {
            eVar.Code(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(final int i) {
        if (this.i) {
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.16
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = MediaPlayerAgent.this.N.iterator();
                    while (it.hasNext()) {
                        com.huawei.openalliance.ad.media.listener.b bVar = (com.huawei.openalliance.ad.media.listener.b) it.next();
                        if (bVar != null) {
                            bVar.Code(i);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(final int i) {
        fb.V(I, "notifyDurationReady: %d", Integer.valueOf(i));
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.28
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaPlayerAgent.this.Q.iterator();
                while (it.hasNext()) {
                    com.huawei.openalliance.ad.media.listener.d dVar = (com.huawei.openalliance.ad.media.listener.d) it.next();
                    if (dVar != null) {
                        dVar.Code(i);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(final int i) {
        fb.V(I, "notifyMediaStart playTime: %d", Integer.valueOf(i));
        A();
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.21
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaPlayerAgent.this.M.iterator();
                while (it.hasNext()) {
                    MediaStateListener mediaStateListener = (MediaStateListener) it.next();
                    if (mediaStateListener != null) {
                        mediaStateListener.onMediaStart(MediaPlayerAgent.this, i);
                    }
                }
            }
        });
        e eVar = this.J;
        if (eVar != null) {
            eVar.Code();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"InlinedApi"})
    public void a(final int i) {
        fb.V(I, "notifyVideoPictureNotPlaying");
        if (i < Z) {
            int i2 = this.G;
            if (i2 < 20) {
                this.G = i2 + 1;
                Code();
                V();
            } else {
                Code();
                this.ab.onError(f(), C, i);
            }
        }
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.29
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaPlayerAgent.this.Q.iterator();
                while (it.hasNext()) {
                    com.huawei.openalliance.ad.media.listener.d dVar = (com.huawei.openalliance.ad.media.listener.d) it.next();
                    if (dVar != null) {
                        dVar.V(i);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.p.Code(d.END) || this.p.Code(d.ERROR) || this.p.Code(d.IDLE)) {
            return;
        }
        if (this.p.Code() || this.p.Code(d.PREPARING)) {
            try {
                MediaPlayer f = f();
                int currentPosition = f.getCurrentPosition();
                if (this.p.Code() && !this.k) {
                    f.stop();
                }
                if (this.p.Code(d.PLAYBACK_COMPLETED)) {
                    currentPosition = 0;
                }
                F(currentPosition);
                V(0, 0);
                this.p.I(d.INITIALIZED);
            } catch (IllegalStateException unused) {
                fb.I(I, "stop IllegalStateException");
                this.p.I(d.ERROR);
            }
        }
        this.m = 0;
        this.t = 0;
        u();
        F(this.g);
        fb.V(I, "stop - agent: %s", this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        fb.V(I, "pauseInternal before State: %s - agent: %s", this.p, this);
        this.v = false;
        if (k()) {
            return;
        }
        try {
            MediaPlayer f = f();
            if (f.isPlaying()) {
                f.pause();
            }
            this.p.I(d.PAUSED);
            D(f.getCurrentPosition());
        } catch (IllegalStateException unused) {
            fb.I(I, "pause IllegalStateException");
            this.p.I(d.ERROR);
        }
        u();
        F(this.g);
        fb.V(I, "pause");
    }

    private boolean k() {
        return this.p.Code(d.END) || this.p.Code(d.ERROR) || this.p.Code(d.PAUSED) || this.p.Code(d.INITIALIZED) || this.p.Code(d.IDLE) || this.p.Code(d.PLAYBACK_COMPLETED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        MediaPlayer mediaPlayer;
        if (!this.p.Code()) {
            return false;
        }
        try {
            synchronized (this.q) {
                mediaPlayer = this.D;
            }
            if (mediaPlayer != null) {
                return mediaPlayer.isPlaying();
            }
            return false;
        } catch (IllegalStateException unused) {
            fb.I(I, "isPlaying IllegalStateException");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.w = false;
        if (I(0.0f)) {
            v();
        }
        if (this.z == 1 && n()) {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.w = false;
        if (I(1.0f)) {
            w();
        }
        if (this.z == 1 && n()) {
            A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (!this.j && this.i && this.N.size() > 0) {
            if (this.p.Code(d.PLAYING) || this.p.Code(d.PREPARING)) {
                fb.V(I, "notifyBufferingStart currentState: %s", this.p);
                this.j = true;
                bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.17
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = MediaPlayerAgent.this.N.iterator();
                        while (it.hasNext()) {
                            com.huawei.openalliance.ad.media.listener.b bVar = (com.huawei.openalliance.ad.media.listener.b) it.next();
                            if (bVar != null) {
                                bVar.Code();
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        CopyOnWriteArraySet<g> copyOnWriteArraySet = this.T;
        if (copyOnWriteArraySet == null || copyOnWriteArraySet.size() == 0) {
            return;
        }
        fb.V(I, "notifyRenderStart");
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.18
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaPlayerAgent.this.T.iterator();
                while (it.hasNext()) {
                    g gVar = (g) it.next();
                    if (gVar != null) {
                        gVar.Code();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.j && this.i) {
            this.j = false;
            fb.V(I, "notifyBufferingEnd currentState: %s", this.p);
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.20
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = MediaPlayerAgent.this.N.iterator();
                    while (it.hasNext()) {
                        com.huawei.openalliance.ad.media.listener.b bVar = (com.huawei.openalliance.ad.media.listener.b) it.next();
                        if (bVar != null) {
                            bVar.V();
                        }
                    }
                }
            });
        }
    }

    private void v() {
        if (this.y) {
            fb.V(I, "already muted, don't notify");
            return;
        }
        fb.V(I, "notifyMute");
        this.y = true;
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.26
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaPlayerAgent.this.P.iterator();
                while (it.hasNext()) {
                    f fVar = (f) it.next();
                    if (fVar != null) {
                        fVar.Code();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        synchronized (this.q) {
            try {
                fb.V(I, "resetInternal - agent: %s", this);
                try {
                    try {
                        if (this.D != null) {
                            if (this.p.Code()) {
                                int currentPosition = this.D.getCurrentPosition();
                                this.D.stop();
                                if (this.p.Code(d.PLAYBACK_COMPLETED)) {
                                    currentPosition = 0;
                                }
                                F(currentPosition);
                                V(0, 0);
                                C(0);
                            }
                            this.D.reset();
                        }
                    } catch (IllegalStateException unused) {
                        fb.I(I, "media player reset IllegalStateException");
                    }
                } catch (Throwable th) {
                    fb.I(I, "media player reset exception: %s", th.getClass().getSimpleName());
                }
                this.m = 0;
                this.t = 0;
                this.k = false;
                this.w = false;
                this.v = false;
                this.x = 0;
                this.G = 0;
                this.p.I(d.IDLE);
                u();
                F(this.g);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.2
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.i();
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void D() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.10
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.p();
            }
        });
    }

    public String F() {
        return this.h;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void I() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.42
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.h();
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Z() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.4
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.j();
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void b() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.33
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.z();
            }
        });
    }

    private void D(final int i) {
        fb.V(I, "notifyMediaPause playTime: %d", Integer.valueOf(i));
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.24
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaPlayerAgent.this.M.iterator();
                while (it.hasNext()) {
                    MediaStateListener mediaStateListener = (MediaStateListener) it.next();
                    if (mediaStateListener != null) {
                        mediaStateListener.onMediaPause(MediaPlayerAgent.this, i);
                    }
                }
            }
        });
        e eVar = this.J;
        if (eVar != null) {
            eVar.V(i);
        }
    }

    private void F(final int i) {
        fb.V(I, "notifyMediaStop playTime: %d", Integer.valueOf(i));
        e();
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.22
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaPlayerAgent.this.M.iterator();
                while (it.hasNext()) {
                    MediaStateListener mediaStateListener = (MediaStateListener) it.next();
                    if (mediaStateListener != null) {
                        mediaStateListener.onMediaStop(MediaPlayerAgent.this, i);
                    }
                }
            }
        });
        e eVar = this.J;
        if (eVar != null) {
            eVar.Code(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(float f) {
        this.w = false;
        if (I(f)) {
            w();
        }
        if (this.z == 1 && n()) {
            A();
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(final float f) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.13
            @Override // java.lang.Runnable
            public void run() {
                fb.Code(MediaPlayerAgent.I, "setSoundVolume %f result: %s", Float.valueOf(f), Boolean.valueOf(MediaPlayerAgent.this.I(f)));
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void I(int i) {
        fb.Code(I, "setPreferStartPlayTime %s", Integer.valueOf(i));
        this.o = i;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V() {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.40
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.g();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void F(String str) {
        V.Code(str);
    }

    private void S(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MediaPlayer f = f();
        if (Uri.parse(str).getScheme() != null) {
            ca caVar = ca.FILE;
            if (str.startsWith(caVar.toString())) {
                str = str.substring(caVar.toString().length());
            } else {
                if (str.startsWith(ca.CONTENT.toString())) {
                    if (!Code(str, f)) {
                        fb.I(I, "set remote media fail");
                        throw new dq();
                    }
                    f.setVideoScalingMode(1);
                    this.p.I(d.INITIALIZED);
                }
                if (str.startsWith(ca.HTTP.toString()) || str.startsWith(ca.HTTPS.toString())) {
                    this.i = true;
                }
            }
        }
        f.setDataSource(str);
        f.setVideoScalingMode(1);
        this.p.I(d.INITIALIZED);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(int i) {
        Code(i, 0);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void I(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener == null) {
            return;
        }
        this.R.remove(onVideoSizeChangedListener);
    }

    public void V(final float f) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.37
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.Z(f);
            }
        });
    }

    public void Z(int i) {
        this.z = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(String str) {
        if (this.p.Code(d.END)) {
            return;
        }
        fb.Code(I, "setMediaFileUrl: %s", bh.Code(str));
        MediaPlayer f = f();
        try {
            if (this.p.Code()) {
                f.stop();
            }
        } catch (IllegalStateException unused) {
            fb.I(I, "setMediaFileUrl stop IllegalStateException");
        } catch (Throwable th) {
            fb.I(I, "setMediaFileUrl exception: %s", th.getClass().getSimpleName());
        }
        try {
            f.reset();
            this.p.I(d.IDLE);
        } catch (Throwable th2) {
            fb.I(I, "mediaPlayer reset exception: %s", th2.getClass().getSimpleName());
        }
        this.G = 0;
        this.h = str;
        if (TextUtils.isEmpty(str)) {
            fb.I(I, "media file url is empty");
            this.p.I(d.ERROR);
            throw new dq("media file url is empty");
        }
        try {
            S(str);
        } catch (Exception unused2) {
            fb.I(I, "setMediaFileUrl Exception");
            this.p.I(d.ERROR);
            throw new dq("setMediaFileUrl Exception");
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(int i, int i2) {
        MediaPlayer mediaPlayer;
        try {
            if (!this.p.Code() || this.k) {
                return;
            }
            synchronized (this.q) {
                mediaPlayer = this.D;
            }
            int l = (l() * i) / 100;
            V(mediaPlayer, l, i2);
            V(i, l);
        } catch (IllegalStateException unused) {
            fb.I(I, "seekTo IllegalStateException");
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public boolean S() {
        if (this.p.Code(d.END)) {
            return false;
        }
        return ((Boolean) ba.Code(this.ad, 300L, Boolean.valueOf(this.p.Code(d.PLAYING)))).booleanValue();
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(int i) {
        synchronized (this.r) {
            this.n = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final int i, final int i2, final int i3) {
        fb.V(I, "notifyError playTime: %d", Integer.valueOf(i));
        e();
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.25
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaPlayerAgent.this.O.iterator();
                while (it.hasNext()) {
                    com.huawei.openalliance.ad.media.listener.c cVar = (com.huawei.openalliance.ad.media.listener.c) it.next();
                    if (cVar != null) {
                        cVar.Code(MediaPlayerAgent.this, i, i2, i3);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(final int i, final int i2) {
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.14
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaPlayerAgent.this.M.iterator();
                while (it.hasNext()) {
                    MediaStateListener mediaStateListener = (MediaStateListener) it.next();
                    if (mediaStateListener != null) {
                        mediaStateListener.onProgress(i, i2);
                    }
                }
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void I(com.huawei.openalliance.ad.media.listener.e eVar) {
        if (eVar == null) {
            return;
        }
        this.U.remove(eVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Z(final String str) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MediaPlayerAgent.this.C(str);
                } catch (dq e2) {
                    fb.Code(MediaPlayerAgent.I, "set media file error:%s", e2.getMessage());
                    fb.I(MediaPlayerAgent.I, "set media file error:" + e2.getClass().getSimpleName());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(long j, int i) {
        MediaPlayer mediaPlayer;
        try {
            fb.V(I, "seekToMillis " + j);
            if (this.p.Code()) {
                synchronized (this.q) {
                    mediaPlayer = this.D;
                }
                V(mediaPlayer, j, i);
                long l = l();
                if (l > 0) {
                    V((int) ((100 * j) / l), (int) j);
                }
            }
        } catch (IllegalStateException unused) {
            fb.I(I, "seekTo IllegalStateException");
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(final long j, final int i) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.6
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.V(j, i);
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void I(g gVar) {
        if (gVar == null) {
            return;
        }
        this.T.remove(gVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        V(onVideoSizeChangedListener);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void I(final String str) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.5
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (str2 == null || !TextUtils.equals(str2, MediaPlayerAgent.this.h)) {
                    return;
                }
                MediaPlayerAgent.this.j();
            }
        });
    }

    public void V(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener == null) {
            return;
        }
        this.R.add(onVideoSizeChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(MediaPlayer mediaPlayer, int i, int i2) {
        Iterator<MediaPlayer.OnVideoSizeChangedListener> it = this.R.iterator();
        while (it.hasNext()) {
            it.next().onVideoSizeChanged(mediaPlayer, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I(float f) {
        if (this.p.Code(d.END)) {
            return false;
        }
        try {
            f().setVolume(f, f);
            return true;
        } catch (IllegalStateException unused) {
            fb.I(I, "mute IllegalStateException");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(MediaPlayer mediaPlayer, long j, int i) {
        if (mediaPlayer != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                mediaPlayer.seekTo(j, i);
            } else {
                mediaPlayer.seekTo((int) j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(Surface surface) {
        String str;
        if (this.p.Code(d.END)) {
            return;
        }
        if (surface != null && !surface.isValid()) {
            fb.I(I, "setSurfaceInternal - surface is invalid");
            return;
        }
        if (surface == o()) {
            fb.V(I, "setSurfaceInternal - pass-in surface is the same as currentSurface");
            return;
        }
        this.E = new WeakReference<>(surface);
        try {
            fb.V(I, "setSurfaceInternal");
            f().setSurface(surface);
        } catch (IllegalArgumentException unused) {
            str = "setSurface IllegalArgumentException";
            fb.I(I, str);
        } catch (IllegalStateException unused2) {
            str = "setSurface IllegalStateException";
            fb.I(I, str);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(final Surface surface) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.9
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayerAgent.this.V(surface);
            }
        });
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(MediaStateListener mediaStateListener) {
        if (mediaStateListener == null) {
            return;
        }
        this.M.remove(mediaStateListener);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(com.huawei.openalliance.ad.media.listener.b bVar) {
        if (bVar == null) {
            return;
        }
        this.N.remove(bVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(com.huawei.openalliance.ad.media.listener.c cVar) {
        if (cVar == null) {
            return;
        }
        this.O.remove(cVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(com.huawei.openalliance.ad.media.listener.d dVar) {
        if (dVar == null) {
            return;
        }
        this.Q.remove(dVar);
    }

    public void V(com.huawei.openalliance.ad.media.listener.e eVar) {
        if (eVar == null) {
            return;
        }
        this.U.add(eVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(MediaStateListener mediaStateListener) {
        if (mediaStateListener == null) {
            return;
        }
        this.M.add(mediaStateListener);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(f fVar) {
        if (fVar == null) {
            return;
        }
        this.P.remove(fVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(com.huawei.openalliance.ad.media.listener.b bVar) {
        if (bVar == null) {
            return;
        }
        this.N.add(bVar);
    }

    public void V(g gVar) {
        if (gVar == null) {
            return;
        }
        this.T.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Runnable runnable) {
        V.Code(runnable);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(com.huawei.openalliance.ad.media.listener.c cVar) {
        if (cVar == null) {
            return;
        }
        this.O.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Runnable runnable, String str, long j) {
        V.Code(runnable, str, j);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(com.huawei.openalliance.ad.media.listener.d dVar) {
        if (dVar == null) {
            return;
        }
        this.Q.add(dVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(com.huawei.openalliance.ad.media.listener.e eVar) {
        V(eVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void V(final String str) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.3
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (str2 == null || !TextUtils.equals(str2, MediaPlayerAgent.this.h)) {
                    return;
                }
                MediaPlayerAgent.this.i();
            }
        });
    }

    private void V(boolean z) {
        if (this.p.Code(d.END)) {
            return;
        }
        try {
            fb.V(I, "prepareMediaPlayer");
            this.p.I(d.PREPARING);
            this.k = true;
            f().prepareAsync();
            if (z) {
                r();
            }
        } catch (IllegalStateException unused) {
            fb.I(I, "prepareMediaPlayer IllegalStateException");
            this.p.I(d.ERROR);
            Code(0, -1, -1);
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(f fVar) {
        if (fVar == null) {
            return;
        }
        this.P.add(fVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(g gVar) {
        V(gVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(h hVar) {
        if (this.J == null) {
            this.J = new e(this.K);
        }
        this.J.Code(hVar);
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(final String str) {
        V(new Runnable() { // from class: com.huawei.openalliance.ad.media.MediaPlayerAgent.41
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (str2 == null || !TextUtils.equals(str2, MediaPlayerAgent.this.h)) {
                    fb.V(MediaPlayerAgent.I, "playWhenUrlMatchs - url not match");
                } else {
                    MediaPlayerAgent.this.g();
                }
            }
        });
    }

    public void Code(boolean z) {
        this.H = z;
    }

    public boolean Code(String str, MediaPlayer mediaPlayer) {
        AssetFileDescriptor openTypedAssetFileDescriptor = this.K.getContentResolver().openTypedAssetFileDescriptor(Uri.parse(str), "*/*", null);
        if (openTypedAssetFileDescriptor == null) {
            ax.Code(openTypedAssetFileDescriptor);
            return false;
        }
        try {
            if (openTypedAssetFileDescriptor.getDeclaredLength() < 0) {
                mediaPlayer.setDataSource(openTypedAssetFileDescriptor.getFileDescriptor());
            } else {
                mediaPlayer.setDataSource(openTypedAssetFileDescriptor.getFileDescriptor(), openTypedAssetFileDescriptor.getStartOffset(), openTypedAssetFileDescriptor.getDeclaredLength());
            }
            ax.Code(openTypedAssetFileDescriptor);
            return true;
        } catch (Throwable th) {
            ax.Code(openTypedAssetFileDescriptor);
            throw th;
        }
    }
}
