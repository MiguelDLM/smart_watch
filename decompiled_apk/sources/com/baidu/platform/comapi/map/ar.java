package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.platform.comapi.map.ah;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class ar implements ag {
    protected boolean b;
    private int c;
    private a d;
    private WeakReference<SurfaceView> g;
    private boolean e = true;
    private final WeakReference<ar> f = new WeakReference<>(this);

    /* renamed from: a, reason: collision with root package name */
    protected SurfaceRenderer f9637a = null;
    private int h = 60;

    public ar(SurfaceView surfaceView) {
        this.g = new WeakReference<>(surfaceView);
    }

    private void c() {
        if (this.d == null) {
        } else {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    @Override // com.baidu.platform.comapi.map.ag
    public Bitmap a(int i, int i2, int i3, int i4, Object obj, Bitmap.Config config) {
        return null;
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void d(int i) {
        this.d.a(i);
    }

    @Override // com.baidu.platform.comapi.map.ag
    public int e() {
        return this.h;
    }

    @Override // com.baidu.platform.comapi.map.ag
    public int f() {
        return this.c;
    }

    public void finalize() throws Throwable {
        try {
            a aVar = this.d;
            if (aVar != null) {
                aVar.e();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.baidu.platform.comapi.map.ag
    public int g() {
        return this.d.a();
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void h() {
        this.d.b();
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void i() {
        this.d.c();
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void j() {
        this.d.d();
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void k() {
        int i;
        if (this.b && this.f9637a != null) {
            a aVar = this.d;
            if (aVar != null) {
                i = aVar.a();
            } else {
                i = 1;
            }
            a aVar2 = new a(this.f);
            this.d = aVar2;
            if (i != 1) {
                aVar2.a(i);
            }
            this.d.start();
        }
        this.b = false;
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void l() {
        a aVar = this.d;
        if (aVar != null) {
            aVar.e();
        }
        this.b = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.d.a(surfaceHolder, i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.d.a(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.d.b(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback2
    @Deprecated
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.a(runnable);
        }
    }

    @Override // com.baidu.platform.comapi.map.ag
    public ah.a b() {
        return ah.a.VULKAN;
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void b(int i) {
        this.c = i;
    }

    /* loaded from: classes8.dex */
    public class a extends Thread {
        private WeakReference<ar> b;
        private boolean e;
        private boolean g;
        private SurfaceRenderer m;
        private SurfaceHolder n;
        private Runnable p;
        private long r;
        private Object c = new Object();
        private boolean f = false;
        private boolean h = false;
        private ArrayList<Runnable> o = new ArrayList<>();
        private AtomicBoolean q = new AtomicBoolean(false);
        private boolean d = false;
        private int i = 0;
        private int j = 0;
        private boolean l = true;
        private int k = 1;

        public a(WeakReference<ar> weakReference) {
            this.r = 0L;
            this.b = weakReference;
            ar arVar = weakReference.get();
            this.m = arVar.f9637a;
            SurfaceHolder a2 = arVar.a();
            this.n = a2;
            this.r = VulkanDetect.getNativeWindow(a2.getSurface());
            setPriority(10);
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x0068, code lost:
        
            r0 = r7.p;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x006b, code lost:
        
            if (r0 == null) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x006d, code lost:
        
            r7.p = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0073, code lost:
        
            if (r1 <= 0) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0075, code lost:
        
            if (r2 <= 0) goto L78;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0077, code lost:
        
            r1 = java.lang.System.currentTimeMillis();
            r7.m.onDrawFrame(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0080, code lost:
        
            if (r0 == null) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0082, code lost:
        
            r0.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0085, code lost:
        
            r0 = ((com.baidu.platform.comapi.map.ar) r7.f9638a.f.get()).e();
            r3 = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x009b, code lost:
        
            if (r0 >= 60) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x009d, code lost:
        
            if (r0 <= 0) goto L80;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x009f, code lost:
        
            r5 = (1000 / r0) - (r3 - r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00a9, code lost:
        
            if (r5 <= 1) goto L81;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00ab, code lost:
        
            r0 = r7.c;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00ad, code lost:
        
            monitor-enter(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00ae, code lost:
        
            r7.c.wait(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00b3, code lost:
        
            monitor-exit(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0000, code lost:
        
            continue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x0000, code lost:
        
            continue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x0000, code lost:
        
            continue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0000, code lost:
        
            continue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x0072, code lost:
        
            r0 = null;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void f() throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 203
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.map.ar.a.f():void");
        }

        private boolean g() {
            if (this.d) {
                return false;
            }
            if (!this.e && this.f && !ar.this.e && this.i > 0 && this.j > 0 && (this.l || this.k == 1)) {
                return false;
            }
            return true;
        }

        private Runnable h() {
            synchronized (this) {
                try {
                    if (this.o.size() > 0) {
                        return this.o.remove(0);
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void a(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (this.c) {
                    try {
                        this.k = i;
                        if (i == 1) {
                            this.c.notifyAll();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public void b() {
            synchronized (this.c) {
                this.l = true;
                this.c.notifyAll();
            }
        }

        public void c() {
            synchronized (this.c) {
                this.e = true;
            }
        }

        public void d() {
            synchronized (this.c) {
                this.e = false;
                this.c.notifyAll();
            }
        }

        public void e() {
            synchronized (this.c) {
                this.d = true;
                this.c.notifyAll();
            }
            try {
                join();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("VkThread " + getId());
            try {
                f();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void b(SurfaceHolder surfaceHolder) {
            synchronized (this.c) {
                this.f = false;
                this.c.notifyAll();
                while (!this.g && isAlive()) {
                    try {
                        this.c.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                this.m.onSurfaceDestroyed(surfaceHolder);
            }
        }

        public int a() {
            int i;
            synchronized (this.c) {
                i = this.k;
            }
            return i;
        }

        public void a(SurfaceHolder surfaceHolder) {
            synchronized (this.c) {
                try {
                    long nativeWindow = VulkanDetect.getNativeWindow(surfaceHolder.getSurface());
                    if (this.r != nativeWindow) {
                        this.r = nativeWindow;
                        this.q.set(true);
                        this.m.onSurfaceCreated(surfaceHolder, 1, 1, 1);
                    }
                    this.f = true;
                    this.c.notifyAll();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void b(Runnable runnable) {
            synchronized (this) {
                this.o.add(runnable);
            }
        }

        public void a(Runnable runnable) {
            synchronized (this.c) {
                try {
                    if (Thread.currentThread() == this) {
                        return;
                    }
                    this.l = true;
                    this.p = runnable;
                    this.c.notifyAll();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void a(SurfaceHolder surfaceHolder, int i, int i2) {
            synchronized (this.c) {
                this.i = i;
                this.j = i2;
                ar.this.e = true;
                this.c.notifyAll();
                while (!this.h && isAlive()) {
                    try {
                        this.c.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                this.m.onSurfaceChanged(i, i2);
                ar.this.e = false;
                this.c.notifyAll();
            }
        }
    }

    public SurfaceHolder a() {
        return this.g.get().getHolder();
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void a(int i) {
        if (i <= 0) {
            return;
        }
        if (i > 60) {
            i = 60;
        }
        this.h = i;
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void a(SurfaceRenderer surfaceRenderer) {
        c();
        this.f9637a = surfaceRenderer;
        a aVar = new a(this.f);
        this.d = aVar;
        aVar.start();
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void a(Runnable runnable) {
        this.d.b(runnable);
    }
}
