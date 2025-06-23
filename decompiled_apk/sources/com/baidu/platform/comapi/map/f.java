package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.opengl.GLDebugHelper;
import android.opengl.GLException;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.platform.comapi.map.ah;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.jieli.jl_bt_ota.constant.ErrorCode;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class f implements ag {
    private static final j c = new j();

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<SurfaceView> f9655a;
    private int b = 60;
    private final WeakReference<f> d = new WeakReference<>(this);
    private i e;
    private SurfaceRenderer f;
    private boolean g;
    private e h;
    private InterfaceC0529f i;
    private g j;
    private k k;
    private int l;
    private int m;
    private boolean n;

    /* loaded from: classes8.dex */
    public interface e {
        EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* renamed from: com.baidu.platform.comapi.map.f$f, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0529f {
        EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* loaded from: classes8.dex */
    public interface g {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* loaded from: classes8.dex */
    public static class i extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private boolean f9659a;
        private boolean b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean q;
        private h u;
        private WeakReference<f> v;
        private ArrayList<Runnable> r = new ArrayList<>();
        private boolean s = true;
        private Runnable t = null;
        private int l = 0;
        private int m = 0;
        private boolean o = true;
        private int n = 1;
        private boolean p = false;

        public i(WeakReference<f> weakReference) {
            this.v = weakReference;
            setPriority(10);
        }

        private void i() {
            if (this.i) {
                this.i = false;
                this.u.e();
            }
        }

        private void j() {
            if (this.h) {
                this.u.f();
                this.h = false;
                f.c.b(this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:217:0x029b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void k() throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 678
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.map.f.i.k():void");
        }

        private boolean l() {
            if (!this.d && this.e && !this.f && this.l > 0 && this.m > 0 && (this.o || this.n == 1)) {
                return true;
            }
            return false;
        }

        public int b() {
            int i;
            synchronized (f.c) {
                i = this.n;
            }
            return i;
        }

        public void c() {
            synchronized (f.c) {
                this.o = true;
                f.c.notifyAll();
            }
        }

        public void d() {
            synchronized (f.c) {
                this.e = true;
                this.j = false;
                f.c.notifyAll();
                while (this.g && !this.j && !this.b) {
                    try {
                        f.c.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void e() {
            synchronized (f.c) {
                this.e = false;
                f.c.notifyAll();
                while (!this.g && !this.b) {
                    try {
                        f.c.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void f() {
            synchronized (f.c) {
                this.c = true;
                f.c.notifyAll();
                while (!this.b && !this.d) {
                    try {
                        f.c.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void g() {
            synchronized (f.c) {
                this.c = false;
                this.o = true;
                this.q = false;
                f.c.notifyAll();
                while (!this.b && this.d && !this.q) {
                    try {
                        f.c.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void h() {
            synchronized (f.c) {
                this.f9659a = true;
                f.c.notifyAll();
                while (!this.b) {
                    try {
                        f.c.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                k();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                f.c.a(this);
                throw th;
            }
            f.c.a(this);
        }

        public boolean a() {
            return this.h && this.i && l();
        }

        public void a(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (f.c) {
                    this.n = i;
                    f.c.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public void b(Runnable runnable) {
            if (runnable != null) {
                synchronized (f.c) {
                    this.r.add(runnable);
                    f.c.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }

        public void a(Runnable runnable) {
            synchronized (f.c) {
                try {
                    if (Thread.currentThread() == this) {
                        return;
                    }
                    this.p = true;
                    this.o = true;
                    this.q = false;
                    this.t = runnable;
                    f.c.notifyAll();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void a(int i, int i2) {
            synchronized (f.c) {
                try {
                    this.l = i;
                    this.m = i2;
                    this.s = true;
                    this.o = true;
                    this.q = false;
                    if (Thread.currentThread() == this) {
                        return;
                    }
                    f.c.notifyAll();
                    while (!this.b && !this.d && !this.q && a()) {
                        try {
                            f.c.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        private static String f9660a = "GLThreadManager";

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.b = true;
            notifyAll();
        }

        public void b(i iVar) {
            notifyAll();
        }
    }

    /* loaded from: classes8.dex */
    public interface k {
        GL a(GL gl);
    }

    /* loaded from: classes8.dex */
    public static class l extends Writer {

        /* renamed from: a, reason: collision with root package name */
        private StringBuilder f9661a = new StringBuilder();

        private void a() {
            if (this.f9661a.length() > 0) {
                Log.v("GLSurfaceView26", this.f9661a.toString());
                StringBuilder sb = this.f9661a;
                sb.delete(0, sb.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            a();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == '\n') {
                    a();
                } else {
                    this.f9661a.append(c);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m extends b {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public m(boolean r12) {
            /*
                r10 = this;
                com.baidu.platform.comapi.map.f.this = r11
                if (r12 == 0) goto L9
                r12 = 16
                r6 = 16
                goto Lb
            L9:
                r12 = 0
                r6 = 0
            Lb:
                r8 = 1
                r9 = 4
                r2 = 8
                r3 = 8
                r4 = 8
                r5 = 0
                r7 = 0
                r0 = r10
                r1 = r11
                r0.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.map.f.m.<init>(com.baidu.platform.comapi.map.f, boolean):void");
        }
    }

    public f(SurfaceView surfaceView) {
        this.f9655a = new WeakReference<>(surfaceView);
    }

    private void n() {
        if (this.e == null) {
        } else {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    public void finalize() throws Throwable {
        try {
            i iVar = this.e;
            if (iVar != null) {
                iVar.h();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void i() {
        this.e.f();
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void j() {
        this.e.g();
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void k() {
        int i2;
        if (this.g && this.f != null) {
            i iVar = this.e;
            if (iVar != null) {
                i2 = iVar.b();
            } else {
                i2 = 1;
            }
            i iVar2 = new i(this.d);
            this.e = iVar2;
            if (i2 != 1) {
                iVar2.a(i2);
            }
            this.e.start();
        }
        this.g = false;
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void l() {
        i iVar = this.e;
        if (iVar != null) {
            iVar.h();
        }
        this.g = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.e.a(i3, i4);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.e.d();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.e.e();
    }

    @Override // android.view.SurfaceHolder.Callback2
    @Deprecated
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        i iVar = this.e;
        if (iVar != null) {
            iVar.a(runnable);
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements g {
        private d() {
        }

        @Override // com.baidu.platform.comapi.map.f.g
        public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLRenderControl", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // com.baidu.platform.comapi.map.f.g
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    public SurfaceHolder a() {
        SurfaceView surfaceView = this.f9655a.get();
        if (surfaceView != null) {
            return surfaceView.getHolder();
        }
        return null;
    }

    @Override // com.baidu.platform.comapi.map.ag
    public ah.a b() {
        return ah.a.OPENGL_ES;
    }

    public int c() {
        SurfaceView surfaceView = this.f9655a.get();
        if (surfaceView != null) {
            return surfaceView.getWidth();
        }
        return 0;
    }

    public int d() {
        SurfaceView surfaceView = this.f9655a.get();
        if (surfaceView != null) {
            return surfaceView.getHeight();
        }
        return 0;
    }

    @Override // com.baidu.platform.comapi.map.ag
    public int e() {
        return this.b;
    }

    @Override // com.baidu.platform.comapi.map.ag
    public int f() {
        return this.l;
    }

    @Override // com.baidu.platform.comapi.map.ag
    public int g() {
        return this.e.b();
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void h() {
        this.e.c();
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void b(int i2) {
        this.l = i2;
    }

    /* loaded from: classes8.dex */
    public class c implements InterfaceC0529f {
        private int b;

        private c() {
            this.b = 12440;
        }

        @Override // com.baidu.platform.comapi.map.f.InterfaceC0529f
        public EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.b, f.this.m, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (f.this.m == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.platform.comapi.map.f.InterfaceC0529f
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            h.a("eglDestroyContex", egl10.eglGetError());
        }
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void a(int i2) {
        if (i2 <= 0) {
            return;
        }
        if (i2 > 60) {
            i2 = 60;
        }
        this.b = i2;
    }

    public void b(boolean z) {
        a(new m(this, z));
    }

    public void c(int i2) {
        n();
        this.m = i2;
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void d(int i2) {
        this.e.a(i2);
    }

    public void a(boolean z) {
        this.n = z;
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void a(SurfaceRenderer surfaceRenderer) {
        n();
        if (this.h == null) {
            this.h = new m(this, true);
        }
        if (this.i == null) {
            this.i = new c();
        }
        if (this.j == null) {
            this.j = new d();
        }
        this.f = surfaceRenderer;
        i iVar = new i(this.d);
        this.e = iVar;
        iVar.start();
    }

    /* loaded from: classes8.dex */
    public abstract class a implements e {

        /* renamed from: a, reason: collision with root package name */
        protected int[] f9656a;

        public a(int[] iArr) {
            this.f9656a = a(iArr);
        }

        @Override // com.baidu.platform.comapi.map.f.e
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.f9656a, null, 0, iArr)) {
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    if (egl10.eglChooseConfig(eGLDisplay, this.f9656a, eGLConfigArr, i, iArr)) {
                        EGLConfig a2 = a(egl10, eGLDisplay, eGLConfigArr);
                        if (a2 != null) {
                            return a2;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        private int[] a(int[] iArr) {
            if (f.this.m != 2 && f.this.m != 3) {
                return iArr;
            }
            if (f.this.m == 3) {
                int length = iArr.length;
                int[] iArr2 = new int[length + 2];
                int i = length - 1;
                System.arraycopy(iArr, 0, iArr2, 0, i);
                iArr2[i] = 12352;
                iArr2[length] = 64;
                iArr2[length + 1] = 12344;
                return iArr2;
            }
            int length2 = iArr.length;
            int[] iArr3 = new int[length2 - 2];
            int i2 = length2 - 5;
            System.arraycopy(iArr, 0, iArr3, 0, i2);
            iArr3[i2] = 12352;
            iArr3[length2 - 4] = 4;
            iArr3[length2 - 3] = 12344;
            return iArr3;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends a {
        protected int c;
        protected int d;
        protected int e;
        protected int f;
        protected int g;
        protected int h;
        protected int i;
        protected int j;
        private int[] l;

        public b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12338, i7, 12337, i8, 12344});
            this.l = new int[1];
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.h = i6;
            this.i = i7;
            this.j = i8;
        }

        @Override // com.baidu.platform.comapi.map.f.a
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            EGLConfig eGLConfig = null;
            for (EGLConfig eGLConfig2 : eGLConfigArr) {
                int a2 = a(egl10, eGLDisplay, eGLConfig2, 12325, 0);
                int a3 = a(egl10, eGLDisplay, eGLConfig2, 12326, 0);
                if (a2 >= this.g && a3 >= this.h) {
                    int a4 = a(egl10, eGLDisplay, eGLConfig2, 12324, 0);
                    int a5 = a(egl10, eGLDisplay, eGLConfig2, 12323, 0);
                    int a6 = a(egl10, eGLDisplay, eGLConfig2, 12322, 0);
                    int a7 = a(egl10, eGLDisplay, eGLConfig2, 12321, 0);
                    if (a4 == this.c && a5 == this.d && a6 == this.e && a7 == this.f) {
                        if (eGLConfig == null) {
                            eGLConfig = eGLConfig2;
                        }
                        if (a(egl10, eGLDisplay, eGLConfig2, 12337, 0) == this.j) {
                            return eGLConfig2;
                        }
                    }
                }
            }
            return eGLConfig;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.l) ? this.l[0] : i2;
        }
    }

    /* loaded from: classes8.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        EGL10 f9658a;
        EGLDisplay b;
        EGLSurface c;
        EGLConfig d;
        EGLContext e;
        private WeakReference<f> f;

        public h(WeakReference<f> weakReference) {
            this.f = weakReference;
        }

        private void g() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.c;
            if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                this.f9658a.eglMakeCurrent(this.b, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                f fVar = this.f.get();
                if (fVar != null) {
                    fVar.j.a(this.f9658a, this.b, this.c);
                }
                this.c = null;
            }
        }

        public void a() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f9658a = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.b = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.f9658a.eglInitialize(eglGetDisplay, new int[2])) {
                    f fVar = this.f.get();
                    if (fVar != null) {
                        this.d = fVar.h.a(this.f9658a, this.b);
                        this.e = fVar.i.a(this.f9658a, this.b, this.d);
                    } else {
                        this.d = null;
                        this.e = null;
                    }
                    EGLContext eGLContext = this.e;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.e = null;
                        a("createContext");
                    }
                    this.c = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public boolean b() {
            if (this.f9658a != null) {
                if (this.b != null) {
                    if (this.d != null) {
                        g();
                        f fVar = this.f.get();
                        if (fVar != null) {
                            this.c = fVar.j.a(this.f9658a, this.b, this.d, fVar.a());
                        } else {
                            this.c = null;
                        }
                        EGLSurface eGLSurface = this.c;
                        if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                            if (this.f9658a.eglMakeCurrent(this.b, eGLSurface, eGLSurface, this.e)) {
                                return true;
                            }
                            a("EGLHelper", "eglMakeCurrent", this.f9658a.eglGetError());
                            return false;
                        }
                        if (this.f9658a.eglGetError() == 12299) {
                            Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                        }
                        return false;
                    }
                    throw new RuntimeException("mEglConfig not initialized");
                }
                throw new RuntimeException("eglDisplay not initialized");
            }
            throw new RuntimeException("egl not initialized");
        }

        public GL c() {
            l lVar;
            GL gl = this.e.getGL();
            f fVar = this.f.get();
            if (fVar != null) {
                if (fVar.k != null) {
                    gl = fVar.k.a(gl);
                }
                if ((fVar.l & 3) != 0) {
                    int i = 1;
                    if ((fVar.l & 1) == 0) {
                        i = 0;
                    }
                    if ((fVar.l & 2) != 0) {
                        lVar = new l();
                    } else {
                        lVar = null;
                    }
                    return GLDebugHelper.wrap(gl, i, lVar);
                }
                return gl;
            }
            return gl;
        }

        public int d() {
            if (!this.f9658a.eglSwapBuffers(this.b, this.c)) {
                return this.f9658a.eglGetError();
            }
            return 12288;
        }

        public void e() {
            g();
        }

        public void f() {
            if (this.e != null) {
                f fVar = this.f.get();
                if (fVar != null) {
                    fVar.i.a(this.f9658a, this.b, this.e);
                }
                this.e = null;
            }
            EGLDisplay eGLDisplay = this.b;
            if (eGLDisplay != null) {
                this.f9658a.eglTerminate(eGLDisplay);
                this.b = null;
            }
        }

        private void a(String str) {
            a(str, this.f9658a.eglGetError());
        }

        public static void a(String str, int i) {
            throw new RuntimeException(b(str, i));
        }

        public static String b(String str, int i) {
            return str + " failed: " + a(i);
        }

        private static String b(int i) {
            return HexStringBuilder.DEFAULT_PREFIX + Integer.toHexString(i);
        }

        public static void a(String str, String str2, int i) {
            Log.w(str, b(str2, i));
        }

        private static String a(int i) {
            switch (i) {
                case 12288:
                    return "EGL_SUCCESS";
                case 12289:
                    return "EGL_NOT_INITIALIZED";
                case 12290:
                    return "EGL_BAD_ACCESS";
                case 12291:
                    return "EGL_BAD_ALLOC";
                case 12292:
                    return "EGL_BAD_ATTRIBUTE";
                case 12293:
                    return "EGL_BAD_CONFIG";
                case 12294:
                    return "EGL_BAD_CONTEXT";
                case ErrorCode.SUB_ERR_SEND_TIMEOUT /* 12295 */:
                    return "EGL_BAD_CURRENT_SURFACE";
                case ErrorCode.SUB_ERR_RESPONSE_BAD_STATUS /* 12296 */:
                    return "EGL_BAD_DISPLAY";
                case 12297:
                    return "EGL_BAD_MATCH";
                case ErrorCode.SUB_ERR_RESPONSE_BAD_RESULT /* 12298 */:
                    return "EGL_BAD_NATIVE_PIXMAP";
                case ErrorCode.SUB_ERR_WAITING_COMMAND_TIMEOUT /* 12299 */:
                    return "EGL_BAD_NATIVE_WINDOW";
                case 12300:
                    return "EGL_BAD_PARAMETER";
                case 12301:
                    return "EGL_BAD_SURFACE";
                case 12302:
                    return "EGL_CONTEXT_LOST";
                default:
                    return b(i);
            }
        }
    }

    public void a(InterfaceC0529f interfaceC0529f) {
        n();
        this.i = interfaceC0529f;
    }

    public void a(e eVar) {
        n();
        this.h = eVar;
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        a(new b(i2, i3, i4, i5, i6, i7, i8, i9));
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void a(Runnable runnable) {
        this.e.b(runnable);
    }

    @Override // com.baidu.platform.comapi.map.ag
    public Bitmap a(int i2, int i3, int i4, int i5, Object obj, Bitmap.Config config) {
        return a(i2, i3, i4, i5, (GL10) obj, config);
    }

    private Bitmap a(int i2, int i3, int i4, int i5, GL10 gl10, Bitmap.Config config) {
        int i6 = i4 * i5;
        int[] iArr = new int[i6];
        int[] iArr2 = new int[i6];
        IntBuffer wrap = IntBuffer.wrap(iArr);
        wrap.position(0);
        try {
            gl10.glReadPixels(i2, i3, i4, i5, 6408, 5121, wrap);
            for (int i7 = 0; i7 < i5; i7++) {
                int i8 = i7 * i4;
                int i9 = ((i5 - i7) - 1) * i4;
                for (int i10 = 0; i10 < i4; i10++) {
                    int i11 = iArr[i8 + i10];
                    iArr2[i9 + i10] = (i11 & (-16711936)) | ((i11 << 16) & 16711680) | ((i11 >> 16) & 255);
                }
            }
            if (config == null) {
                return Bitmap.createBitmap(iArr2, i4, i5, Bitmap.Config.ARGB_8888);
            }
            return Bitmap.createBitmap(iArr2, i4, i5, config);
        } catch (GLException unused) {
            return null;
        } catch (OutOfMemoryError e2) {
            Log.e("OutOfMemoryError", " createBitmap cause OutOfMemoryError : " + e2.getMessage());
            return null;
        }
    }
}
