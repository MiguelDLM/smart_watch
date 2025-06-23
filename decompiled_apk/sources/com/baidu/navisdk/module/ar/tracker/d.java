package com.baidu.navisdk.module.ar.tracker;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.SystemClock;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.baidu.navisdk.module.ar.listener.a;
import java.io.File;
import java.io.FilenameFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Locale;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class d implements com.baidu.navisdk.module.ar.listener.a {
    private long e;
    private long f;
    private com.baidu.navisdk.module.ar.d j;
    private f k;
    private TextureView l;
    private Surface m;
    private a.b n;
    private Queue<com.baidu.navisdk.module.ar.tracker.a> p;
    private ArrayBlockingQueue<com.baidu.navisdk.module.ar.tracker.a> q;
    private String v;
    private String w;
    private String x;
    private com.baidu.navisdk.module.ar.tracker.c y;

    /* renamed from: a, reason: collision with root package name */
    private boolean f6999a = true;
    private boolean b = false;
    private long c = 0;
    private long d = 0;
    private int g = 2;
    private int h = 0;
    private int i = 30;
    private a.InterfaceC0216a o = null;
    private C0217d r = null;
    private Timer s = null;
    private TimerTask t = null;
    private Object u = new Object();
    TextureView.SurfaceTextureListener z = new c();

    /* loaded from: classes7.dex */
    public class a implements FilenameFilter {
        public a(d dVar) {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(".mp4");
        }
    }

    /* loaded from: classes7.dex */
    public class b implements FilenameFilter {
        public b(d dVar) {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(".txt");
        }
    }

    /* loaded from: classes7.dex */
    public class c implements TextureView.SurfaceTextureListener {
        public c() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            d.this.m = new Surface(surfaceTexture);
            d.this.k.a(d.this.w, 0, d.this.m);
            d dVar = d.this;
            dVar.a(dVar.n);
            d.this.e();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            d.this.g();
            d.this.c();
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            com.baidu.navisdk.module.ar.tracker.a d;
            long a2 = d.this.d + d.this.k.a();
            d dVar = d.this;
            dVar.e = dVar.f + d.this.k.a();
            if (d.n(d.this) % d.this.g != 0 || !d.this.f6999a || (d = d.this.d()) == null) {
                return;
            }
            d.b = d.this.l.getBitmap(d.this.n.c, d.this.n.d);
            d.a(a2);
            d.this.q.add(d);
        }
    }

    /* renamed from: com.baidu.navisdk.module.ar.tracker.d$d, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0217d extends Thread {
        public C0217d() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            com.baidu.navisdk.module.ar.tracker.a aVar;
            setName("Ar Detector");
            while (d.this.f6999a) {
                try {
                    aVar = (com.baidu.navisdk.module.ar.tracker.a) d.this.q.poll(100L, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (aVar != null && d.this.o != null) {
                    if (aVar.b() != null) {
                        d.this.o.a(aVar.b(), aVar.c());
                    }
                    d.this.a(aVar);
                    com.baidu.navisdk.module.ar.util.a.b("BNVideoCamera", "AdasThread");
                }
                if (aVar != null) {
                    d.this.a(aVar);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        private long f7002a = 0;

        public e() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            synchronized (d.this.u) {
                try {
                    if (0 == this.f7002a) {
                        this.f7002a = SystemClock.elapsedRealtime();
                    }
                    if (d.this.b && d.this.f6999a) {
                        d.this.k.a((byte[]) null, (SystemClock.elapsedRealtime() - this.f7002a) + d.this.c);
                        com.baidu.navisdk.module.ar.util.a.b("BNVideoCamera", "FrameTimerTask");
                        d dVar = d.this;
                        dVar.a(dVar.e);
                    }
                } finally {
                }
            }
        }
    }

    public d(com.baidu.navisdk.module.ar.d dVar) {
        this.p = null;
        this.q = null;
        this.j = dVar;
        String str = dVar.b;
        this.v = str;
        this.w = c(str);
        this.x = b(this.v);
        f.a(this.w);
        this.n = new a.b();
        this.k = new f();
        this.p = new ArrayDeque(3);
        this.q = new ArrayBlockingQueue<>(3);
        for (int i = 0; i < 4; i++) {
            this.p.add(new com.baidu.navisdk.module.ar.tracker.a());
        }
        try {
            this.f = a(this.w);
        } catch (Exception e2) {
            com.baidu.navisdk.module.ar.util.a.a("BNAr", "" + e2.getLocalizedMessage());
        }
    }

    public static /* synthetic */ int n(d dVar) {
        int i = dVar.h;
        dVar.h = i + 1;
        return i;
    }

    @Override // com.baidu.navisdk.module.ar.listener.a
    public void a() {
    }

    private String c(String str) {
        return new File(str).listFiles(new a(this))[0].getAbsolutePath();
    }

    @Override // com.baidu.navisdk.module.ar.listener.a
    public void a(Context context, SurfaceView surfaceView, a.c cVar) {
    }

    public com.baidu.navisdk.module.ar.tracker.a d() {
        com.baidu.navisdk.module.ar.tracker.a aVar;
        synchronized (this.p) {
            try {
                aVar = this.p.remove();
                aVar.a();
            } catch (Exception unused) {
                aVar = null;
            }
        }
        return aVar;
    }

    public void e() {
        int i = this.n.e;
        this.q.clear();
        this.k.a((int) this.c);
        this.b = true;
        if (this.f6999a) {
            b();
        }
    }

    public void f() {
        this.f6999a = false;
        if (this.s != null) {
            synchronized (this.u) {
                this.s.cancel();
                this.s.purge();
                this.t.cancel();
                this.t = null;
                this.s = null;
            }
        }
        try {
            this.r.join();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.r = null;
    }

    public void g() {
        this.f6999a = false;
        f();
        this.k.g();
    }

    private String b(String str) {
        File[] listFiles = new File(str).listFiles(new b(this));
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        return listFiles[0].getAbsolutePath();
    }

    @Override // com.baidu.navisdk.module.ar.listener.a
    public void a(byte[] bArr) {
    }

    public void c() {
        g();
        f fVar = this.k;
        if (fVar != null) {
            fVar.e();
            this.k = null;
        }
        TextureView textureView = this.l;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(null);
        }
        Surface surface = this.m;
        if (surface != null) {
            surface.release();
            this.m = null;
        }
    }

    @Override // com.baidu.navisdk.module.ar.listener.a
    public void a(Context context, TextureView textureView, a.c cVar) {
        this.l = textureView;
        textureView.setSurfaceTextureListener(this.z);
        if (this.l.isAvailable()) {
            Surface surface = new Surface(textureView.getSurfaceTexture());
            this.m = surface;
            this.k.a(surface);
            e();
        }
    }

    @Override // com.baidu.navisdk.module.ar.listener.a
    public void b() {
        this.f6999a = true;
        if (this.b) {
            this.k.a(com.baidu.navisdk.module.ar.tracker.b.a().f6997a);
            this.k.f();
            C0217d c0217d = new C0217d();
            this.r = c0217d;
            c0217d.start();
            this.s = new Timer("Ar Video Timer");
            e eVar = new e();
            this.t = eVar;
            this.s.schedule(eVar, 0L, this.i);
        }
    }

    private long a(String str) throws ParseException {
        return new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).parse(new File(str).getName().replace("VID_", "").replace(".mp4", "")).getTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        com.baidu.navisdk.module.ar.tracker.e eVar = this.j.f6984a;
        if (eVar == null) {
            return;
        }
        if (this.y == null) {
            com.baidu.navisdk.module.ar.tracker.c cVar = new com.baidu.navisdk.module.ar.tracker.c(eVar, this.x);
            this.y = cVar;
            cVar.a();
        }
        this.y.a(j);
    }

    @Override // com.baidu.navisdk.module.ar.listener.a
    public void a(a.b bVar) {
        bVar.c = this.k.b();
        bVar.d = this.k.c();
        bVar.e = this.k.b();
        bVar.f = this.k.c();
        bVar.f6990a = 1;
        bVar.b = 1;
    }

    @Override // com.baidu.navisdk.module.ar.listener.a
    public void a(a.InterfaceC0216a interfaceC0216a) {
        this.o = interfaceC0216a;
    }

    public void a(com.baidu.navisdk.module.ar.tracker.a aVar) {
        if (aVar.d() == 0) {
            synchronized (this.p) {
                this.p.add(aVar);
            }
        }
    }
}
