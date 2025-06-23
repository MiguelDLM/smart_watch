package com.baidu.nplatform.comapi.map;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.baidu.navisdk.util.common.LogUtil;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.jieli.jl_bt_ota.constant.ErrorCode;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes8.dex */
public class BaiduGLSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final i n = new i();

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<BaiduGLSurfaceView> f9486a;
    private h b;
    private GLSurfaceView.Renderer c;
    private boolean d;
    private GLSurfaceView.EGLConfigChooser e;
    private GLSurfaceView.EGLContextFactory f;
    private GLSurfaceView.EGLWindowSurfaceFactory g;
    private GLSurfaceView.GLWrapper h;
    private int i;
    private int j;
    private boolean k;
    private f l;
    private boolean m;

    /* loaded from: classes8.dex */
    public abstract class b implements GLSurfaceView.EGLConfigChooser {

        /* renamed from: a, reason: collision with root package name */
        protected int[] f9487a;

        public b(int[] iArr) {
            this.f9487a = a(iArr);
        }

        private int[] a(int[] iArr) {
            if (BaiduGLSurfaceView.this.j != 2 && BaiduGLSurfaceView.this.j != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            if (BaiduGLSurfaceView.this.j == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.f9487a, null, 0, iArr)) {
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    if (egl10.eglChooseConfig(eGLDisplay, this.f9487a, eGLConfigArr, i, iArr)) {
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
    }

    /* loaded from: classes8.dex */
    public class d implements GLSurfaceView.EGLContextFactory {

        /* renamed from: a, reason: collision with root package name */
        private int f9488a;

        private d() {
            this.f9488a = 12440;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.f9488a, BaiduGLSurfaceView.this.j, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (BaiduGLSurfaceView.this.j == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            g.b("eglDestroyContex", egl10.eglGetError());
            throw null;
        }
    }

    /* loaded from: classes8.dex */
    public static class e implements GLSurfaceView.EGLWindowSurfaceFactory {
        private e() {
        }

        @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                LogUtil.e("BaiduGLSurfaceView", "eglCreateWindowSurface IllegalArgumentException: " + e);
                return null;
            }
        }

        @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* loaded from: classes8.dex */
    public interface f {
        void a(BaiduGLSurfaceView baiduGLSurfaceView);
    }

    /* loaded from: classes8.dex */
    public static class h extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private boolean f9490a;
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
        private boolean p;
        private g s;
        private WeakReference<BaiduGLSurfaceView> t;
        private ArrayList<Runnable> q = new ArrayList<>();
        private boolean r = true;
        private int l = 0;
        private int m = 0;
        private boolean o = true;
        private int n = 1;

        public h(WeakReference<BaiduGLSurfaceView> weakReference) {
            this.t = weakReference;
        }

        /* JADX WARN: Removed duplicated region for block: B:183:0x0238 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void h() throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 579
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.nplatform.comapi.map.BaiduGLSurfaceView.h.h():void");
        }

        private boolean i() {
            if (!this.d && this.e && !this.f && this.l > 0 && this.m > 0 && (this.o || this.n == 1)) {
                return true;
            }
            return false;
        }

        private void j() {
            if (this.h) {
                this.s.d();
                this.h = false;
                BaiduGLSurfaceView.n.a(this);
            }
        }

        private void k() {
            if (this.i) {
                this.i = false;
                this.s.c();
            }
        }

        public int b() {
            int i;
            synchronized (BaiduGLSurfaceView.n) {
                i = this.n;
            }
            return i;
        }

        public void c() {
            synchronized (BaiduGLSurfaceView.n) {
                this.f9490a = true;
                BaiduGLSurfaceView.n.notifyAll();
                while (!this.b) {
                    try {
                        BaiduGLSurfaceView.n.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void d() {
            this.k = true;
            BaiduGLSurfaceView.n.notifyAll();
        }

        public void e() {
            synchronized (BaiduGLSurfaceView.n) {
                this.o = true;
                BaiduGLSurfaceView.n.notifyAll();
            }
        }

        public void f() {
            synchronized (BaiduGLSurfaceView.n) {
                this.e = true;
                this.j = false;
                BaiduGLSurfaceView.n.notifyAll();
                while (this.g && !this.j && !this.b) {
                    try {
                        BaiduGLSurfaceView.n.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void g() {
            synchronized (BaiduGLSurfaceView.n) {
                this.e = false;
                BaiduGLSurfaceView.n.notifyAll();
                while (!this.g && !this.b) {
                    try {
                        BaiduGLSurfaceView.n.wait();
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
                h();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                BaiduGLSurfaceView.n.b(this);
                throw th;
            }
            BaiduGLSurfaceView.n.b(this);
        }

        public boolean a() {
            return this.h && this.i && i();
        }

        public void a(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (BaiduGLSurfaceView.n) {
                    this.n = i;
                    BaiduGLSurfaceView.n.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public void a(int i, int i2) {
            synchronized (BaiduGLSurfaceView.n) {
                this.l = i;
                this.m = i2;
                this.r = true;
                this.o = true;
                this.p = false;
                BaiduGLSurfaceView.n.notifyAll();
                while (!this.b && !this.d && !this.p && a()) {
                    try {
                        BaiduGLSurfaceView.n.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class j extends Writer {

        /* renamed from: a, reason: collision with root package name */
        private StringBuilder f9492a = new StringBuilder();

        private void a() {
            if (this.f9492a.length() > 0) {
                StringBuilder sb = this.f9492a;
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
                    this.f9492a.append(c);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k extends c {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public k(boolean r10) {
            /*
                r8 = this;
                com.baidu.nplatform.comapi.map.BaiduGLSurfaceView.this = r9
                if (r10 == 0) goto L9
                r10 = 16
                r6 = 16
                goto Lb
            L9:
                r10 = 0
                r6 = 0
            Lb:
                r7 = 0
                r2 = 8
                r3 = 8
                r4 = 8
                r5 = 0
                r0 = r8
                r1 = r9
                r0.<init>(r2, r3, r4, r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.nplatform.comapi.map.BaiduGLSurfaceView.k.<init>(com.baidu.nplatform.comapi.map.BaiduGLSurfaceView, boolean):void");
        }
    }

    public BaiduGLSurfaceView(Context context) {
        super(context);
        this.f9486a = new WeakReference<>(this);
        this.m = true;
        f();
    }

    public void finalize() throws Throwable {
        try {
            h hVar = this.b;
            if (hVar != null) {
                hVar.c();
            }
        } finally {
            super.finalize();
        }
    }

    public int getDebugFlags() {
        return this.i;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.k;
    }

    public int getRenderMode() {
        return this.b.b();
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        int i2;
        boolean z;
        super.onAttachedToWindow();
        if (this.d && this.c != null) {
            h hVar = this.b;
            if (hVar != null) {
                i2 = hVar.b();
            } else {
                i2 = 1;
            }
            if (this.b != null && !c()) {
                z = false;
            } else {
                this.b = new h(this.f9486a);
                z = true;
            }
            if (i2 != 1) {
                this.b.a(i2);
            }
            if (z) {
                this.b.start();
            }
        }
        this.d = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        h hVar;
        if (c() && (hVar = this.b) != null) {
            hVar.c();
        }
        this.d = true;
        super.onDetachedFromWindow();
    }

    public void setDebugFlags(int i2) {
        this.i = i2;
    }

    public void setEGLConfigChooser(GLSurfaceView.EGLConfigChooser eGLConfigChooser) {
        e();
        this.e = eGLConfigChooser;
    }

    public void setEGLContextClientVersion(int i2) {
        e();
        this.j = i2;
    }

    public void setEGLContextFactory(GLSurfaceView.EGLContextFactory eGLContextFactory) {
        e();
        this.f = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(GLSurfaceView.EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        e();
        this.g = eGLWindowSurfaceFactory;
    }

    public void setEglSwapListener(f fVar) {
        this.l = fVar;
    }

    public void setGLWrapper(GLSurfaceView.GLWrapper gLWrapper) {
        this.h = gLWrapper;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.k = z;
    }

    public void setRenderMode(int i2) {
        this.b.a(i2);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        e();
        if (this.e == null) {
            this.e = new k(this, true);
        }
        if (this.f == null) {
            this.f = new d();
        }
        if (this.g == null) {
            this.g = new e();
        }
        this.c = renderer;
        h hVar = new h(this.f9486a);
        this.b = hVar;
        hVar.start();
    }

    public void setRestartGLThreadOnAttach(boolean z) {
        this.m = z;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.b.a(i3, i4);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        h hVar = this.b;
        if (hVar != null) {
            hVar.f();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.b.g();
    }

    private void e() {
        if (this.b != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private void f() {
        getHolder().addCallback(this);
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new c(i2, i3, i4, i5, i6, i7));
    }

    public void b() {
        this.b.e();
    }

    public boolean c() {
        return this.m;
    }

    /* loaded from: classes8.dex */
    public static class i {
        private static final Class g;
        private static final Method h;

        /* renamed from: a, reason: collision with root package name */
        private boolean f9491a;
        private int b;
        private boolean c;
        private boolean d;
        private boolean e;
        private h f;

        static {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                g = cls;
                Method declaredMethod = cls.getDeclaredMethod("getInt", String.class, Integer.TYPE);
                h = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private i() {
        }

        public void a(h hVar) {
            if (this.f == hVar) {
                this.f = null;
            }
            notifyAll();
        }

        public synchronized void b(h hVar) {
            try {
                hVar.b = true;
                if (this.f == hVar) {
                    this.f = null;
                }
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }

        public boolean c(h hVar) {
            h hVar2 = this.f;
            if (hVar2 != hVar && hVar2 != null) {
                c();
                if (this.d) {
                    return true;
                }
                h hVar3 = this.f;
                if (hVar3 == null) {
                    return false;
                }
                hVar3.d();
                return false;
            }
            this.f = hVar;
            notifyAll();
            return true;
        }

        public synchronized boolean a() {
            return this.e;
        }

        public synchronized void a(GL10 gl10) {
            try {
                if (!this.c) {
                    c();
                    String glGetString = gl10.glGetString(7937);
                    if (this.b < 131072) {
                        this.d = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.e = !this.d;
                    this.c = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        public synchronized boolean b() {
            c();
            return !this.d;
        }

        private void c() {
            if (this.f9491a) {
                return;
            }
            try {
                this.b = ((Integer) h.invoke(null, "ro.opengles.version", 0)).intValue();
            } catch (Exception unused) {
                this.b = 65536;
            }
            if (this.b >= 131072) {
                this.d = true;
            }
            this.f9491a = true;
        }
    }

    public void a() {
        h hVar;
        if (c() || (hVar = this.b) == null) {
            return;
        }
        hVar.c();
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new k(this, z));
    }

    public BaiduGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9486a = new WeakReference<>(this);
        this.m = true;
        f();
    }

    /* loaded from: classes8.dex */
    public class c extends b {
        private int[] c;
        protected int d;
        protected int e;
        protected int f;
        protected int g;
        protected int h;
        protected int i;

        public c(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.c = new int[1];
            this.d = i;
            this.e = i2;
            this.f = i3;
            this.g = i4;
            this.h = i5;
            this.i = i6;
        }

        @Override // com.baidu.nplatform.comapi.map.BaiduGLSurfaceView.b
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int a3 = a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (a2 >= this.h && a3 >= this.i) {
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int a7 = a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (a4 == this.d && a5 == this.e && a6 == this.f && a7 == this.g) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.c) ? this.c[0] : i2;
        }
    }

    /* loaded from: classes8.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<BaiduGLSurfaceView> f9489a;
        EGL10 b;
        EGLDisplay c;
        EGLSurface d;
        EGLConfig e;
        EGLContext f;

        public g(WeakReference<BaiduGLSurfaceView> weakReference) {
            this.f9489a = weakReference;
        }

        private void g() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.d;
            if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                this.b.eglMakeCurrent(this.c, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                BaiduGLSurfaceView baiduGLSurfaceView = this.f9489a.get();
                if (baiduGLSurfaceView != null) {
                    baiduGLSurfaceView.g.destroySurface(this.b, this.c, this.d);
                }
                this.d = null;
            }
        }

        public GL a() {
            GL gl = this.f.getGL();
            BaiduGLSurfaceView baiduGLSurfaceView = this.f9489a.get();
            if (baiduGLSurfaceView == null) {
                return gl;
            }
            if (baiduGLSurfaceView.h != null) {
                gl = baiduGLSurfaceView.h.wrap(gl);
            }
            if ((baiduGLSurfaceView.i & 3) != 0) {
                return GLDebugHelper.wrap(gl, (baiduGLSurfaceView.i & 1) == 0 ? 0 : 1, (baiduGLSurfaceView.i & 2) != 0 ? new j() : null);
            }
            return gl;
        }

        public boolean b() {
            if (this.b != null) {
                if (this.c != null) {
                    if (this.e != null) {
                        g();
                        BaiduGLSurfaceView baiduGLSurfaceView = this.f9489a.get();
                        if (baiduGLSurfaceView != null) {
                            this.d = baiduGLSurfaceView.g.createWindowSurface(this.b, this.c, this.e, baiduGLSurfaceView.getHolder());
                        } else {
                            this.d = null;
                        }
                        EGLSurface eGLSurface = this.d;
                        if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                            if (this.b.eglMakeCurrent(this.c, eGLSurface, eGLSurface, this.f)) {
                                return true;
                            }
                            a("EGLHelper", "eglMakeCurrent", this.b.eglGetError());
                            return false;
                        }
                        if (this.b.eglGetError() == 12299) {
                            LogUtil.e("BaiduGLSurfaceView-EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                        }
                        return false;
                    }
                    throw new RuntimeException("mEglConfig not initialized");
                }
                throw new RuntimeException("eglDisplay not initialized");
            }
            throw new RuntimeException("egl not initialized");
        }

        public void c() {
            g();
        }

        public void d() {
            if (this.f != null) {
                BaiduGLSurfaceView baiduGLSurfaceView = this.f9489a.get();
                if (baiduGLSurfaceView != null) {
                    baiduGLSurfaceView.f.destroyContext(this.b, this.c, this.f);
                }
                this.f = null;
            }
            EGLDisplay eGLDisplay = this.c;
            if (eGLDisplay != null) {
                this.b.eglTerminate(eGLDisplay);
                this.c = null;
            }
        }

        public void e() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.b = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.c = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.b.eglInitialize(eglGetDisplay, new int[2])) {
                    BaiduGLSurfaceView baiduGLSurfaceView = this.f9489a.get();
                    if (baiduGLSurfaceView == null) {
                        this.e = null;
                        this.f = null;
                    } else {
                        this.e = baiduGLSurfaceView.e.chooseConfig(this.b, this.c);
                        this.f = baiduGLSurfaceView.f.createContext(this.b, this.c, this.e);
                    }
                    EGLContext eGLContext = this.f;
                    if (eGLContext != null && eGLContext != EGL10.EGL_NO_CONTEXT) {
                        this.d = null;
                        return;
                    } else {
                        this.f = null;
                        a("createContext");
                        throw null;
                    }
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public int f() {
            if (!this.b.eglSwapBuffers(this.c, this.d)) {
                return this.b.eglGetError();
            }
            return 12288;
        }

        private void a(String str) {
            b(str, this.b.eglGetError());
            throw null;
        }

        public static void a(String str, String str2, int i) {
            LogUtil.e(str, a(str2, i));
        }

        public static String a(String str, int i) {
            return str + " failed: " + a(i);
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

        public static void b(String str, int i) {
            throw new RuntimeException(a(str, i));
        }

        private static String b(int i) {
            return HexStringBuilder.DEFAULT_PREFIX + Integer.toHexString(i);
        }
    }
}
