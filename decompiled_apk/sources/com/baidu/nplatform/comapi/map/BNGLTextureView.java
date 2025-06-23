package com.baidu.nplatform.comapi.map;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import com.baidu.navisdk.util.common.LogUtil;
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
public class BNGLTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    private static final boolean n;
    private static final boolean o;
    private static final boolean p;
    private static final h q;

    /* renamed from: a, reason: collision with root package name */
    private final View.OnLayoutChangeListener f9478a;
    private final WeakReference<BNGLTextureView> b;
    private g c;
    private GLSurfaceView.Renderer d;
    private boolean e;
    private GLSurfaceView.EGLConfigChooser f;
    private GLSurfaceView.EGLContextFactory g;
    private GLSurfaceView.EGLWindowSurfaceFactory h;
    private GLSurfaceView.GLWrapper i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;

    /* loaded from: classes8.dex */
    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BNGLTextureView bNGLTextureView = BNGLTextureView.this;
            bNGLTextureView.onSurfaceTextureSizeChanged(bNGLTextureView.getSurfaceTexture(), i3 - i, i4 - i2);
        }
    }

    /* loaded from: classes8.dex */
    public abstract class b implements GLSurfaceView.EGLConfigChooser {

        /* renamed from: a, reason: collision with root package name */
        protected int[] f9480a;

        public b(int[] iArr) {
            this.f9480a = a(iArr);
        }

        private int[] a(int[] iArr) {
            if (BNGLTextureView.this.k != 2) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            iArr2[length] = 4;
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.f9480a, null, 0, iArr)) {
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    if (egl10.eglChooseConfig(eGLDisplay, this.f9480a, eGLConfigArr, i, iArr)) {
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
        private d() {
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12440, BNGLTextureView.this.k, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (BNGLTextureView.this.k == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                if (BNGLTextureView.this.a()) {
                    LogUtil.e("BNGLTextureView", "DefaultContextFactory tid=" + Thread.currentThread().getId());
                }
                f.b("eglDestroyContex", egl10.eglGetError());
                throw null;
            }
        }

        public /* synthetic */ d(BNGLTextureView bNGLTextureView, a aVar) {
            this();
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
                LogUtil.printException(e.toString(), e);
                return null;
            }
        }

        @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<BNGLTextureView> f9482a;
        EGL10 b;
        EGLDisplay c;
        EGLSurface d;
        EGLConfig e;
        EGLContext f;

        public f(WeakReference<BNGLTextureView> weakReference) {
            this.f9482a = weakReference;
        }

        public static void a(String str, String str2, int i) {
        }

        private void g() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.d;
            if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                this.b.eglMakeCurrent(this.c, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                BNGLTextureView bNGLTextureView = this.f9482a.get();
                if (bNGLTextureView != null) {
                    bNGLTextureView.h.destroySurface(this.b, this.c, this.d);
                }
                this.d = null;
            }
        }

        private boolean h() {
            BNGLTextureView bNGLTextureView;
            WeakReference<BNGLTextureView> weakReference = this.f9482a;
            if (weakReference == null || (bNGLTextureView = weakReference.get()) == null || !bNGLTextureView.a()) {
                return false;
            }
            return true;
        }

        public boolean b() {
            if (h()) {
                LogUtil.e("BNGLTextureView", "EglHelper createSurface()  tid=" + Thread.currentThread().getId());
            }
            if (this.b != null) {
                if (this.c != null) {
                    if (this.e != null) {
                        g();
                        BNGLTextureView bNGLTextureView = this.f9482a.get();
                        if (bNGLTextureView != null) {
                            this.d = bNGLTextureView.h.createWindowSurface(this.b, this.c, this.e, bNGLTextureView.getSurfaceTexture());
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
                            LogUtil.e("BNGLTextureView", "EglHelper createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
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
            if (h()) {
                LogUtil.e("BNGLTextureView", "EglHelper destroySurface()  tid=" + Thread.currentThread().getId());
            }
            g();
        }

        public void d() {
            if (h()) {
                LogUtil.e("BNGLTextureView", "EglHelper finish() tid=" + Thread.currentThread().getId());
            }
            if (this.f != null) {
                BNGLTextureView bNGLTextureView = this.f9482a.get();
                if (bNGLTextureView != null) {
                    bNGLTextureView.g.destroyContext(this.b, this.c, this.f);
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
            if (h()) {
                LogUtil.e("BNGLTextureView", "EglHelper start() tid=" + Thread.currentThread().getId());
            }
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.b = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.c = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.b.eglInitialize(eglGetDisplay, new int[2])) {
                    BNGLTextureView bNGLTextureView = this.f9482a.get();
                    if (bNGLTextureView == null) {
                        this.e = null;
                        this.f = null;
                    } else {
                        this.e = bNGLTextureView.f.chooseConfig(this.b, this.c);
                        this.f = bNGLTextureView.g.createContext(this.b, this.c, this.e);
                    }
                    EGLContext eGLContext = this.f;
                    if (eGLContext != null && eGLContext != EGL10.EGL_NO_CONTEXT) {
                        if (h()) {
                            LogUtil.e("BNGLTextureView", "EglHelper createContext " + this.f + " tid=" + Thread.currentThread().getId());
                        }
                        this.d = null;
                        return;
                    }
                    this.f = null;
                    a("createContext");
                    throw null;
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

        public GL a() {
            GL gl = this.f.getGL();
            BNGLTextureView bNGLTextureView = this.f9482a.get();
            if (bNGLTextureView == null) {
                return gl;
            }
            if (bNGLTextureView.i != null) {
                gl = bNGLTextureView.i.wrap(gl);
            }
            if ((bNGLTextureView.j & 3) != 0) {
                return GLDebugHelper.wrap(gl, (bNGLTextureView.j & 1) == 0 ? 0 : 1, (bNGLTextureView.j & 2) != 0 ? new i() : null);
            }
            return gl;
        }

        private void a(String str) {
            b(str, this.b.eglGetError());
            throw null;
        }

        public static String a(String str, int i) {
            return str + " EGL failed code: " + i;
        }

        public static void b(String str, int i) {
            throw new RuntimeException(a(str, i));
        }
    }

    /* loaded from: classes8.dex */
    public static class g extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private volatile boolean f9483a;
        private volatile boolean b;
        private boolean c;
        private volatile boolean d;
        private boolean e;
        private boolean f;
        private volatile boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private volatile boolean o;
        private f r;
        private WeakReference<BNGLTextureView> s;
        private ArrayList<Runnable> p = new ArrayList<>();
        private boolean q = true;
        private int k = 0;
        private int l = 0;
        private volatile boolean n = true;
        private int m = 1;

        public g(WeakReference<BNGLTextureView> weakReference) {
            this.s = weakReference;
            if (c()) {
                LogUtil.e("BNGLTextureView", "GLThread: init<>");
            }
        }

        private String k() {
            String str;
            BNGLTextureView bNGLTextureView = this.s.get();
            StringBuilder sb = new StringBuilder();
            if (bNGLTextureView != null) {
                str = bNGLTextureView.getName();
            } else {
                str = "";
            }
            sb.append(str);
            sb.append("GL");
            sb.append(getId());
            return sb.toString();
        }

        /* JADX WARN: Removed duplicated region for block: B:102:0x04b7  */
        /* JADX WARN: Removed duplicated region for block: B:110:0x0305 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:181:0x04b2 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:185:0x04ae A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:97:0x02d0  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void l() throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 1413
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.nplatform.comapi.map.BNGLTextureView.g.l():void");
        }

        private boolean m() {
            if (!this.d && this.e && !this.f && this.k > 0 && this.l > 0 && (this.n || this.m == 1)) {
                return true;
            }
            return false;
        }

        private void n() {
            if (this.h) {
                this.r.d();
                this.h = false;
                BNGLTextureView.q.a(this);
            }
        }

        private void o() {
            if (this.i) {
                this.i = false;
                this.r.c();
            }
        }

        public int b() {
            int i;
            synchronized (BNGLTextureView.q) {
                i = this.m;
            }
            return i;
        }

        public boolean c() {
            BNGLTextureView bNGLTextureView;
            WeakReference<BNGLTextureView> weakReference = this.s;
            if (weakReference == null || (bNGLTextureView = weakReference.get()) == null || !bNGLTextureView.a()) {
                return false;
            }
            return true;
        }

        public void d() {
            synchronized (BNGLTextureView.q) {
                try {
                    if (BNGLTextureView.o) {
                        LogUtil.e("BNGLTextureView", "GLThread onPause tid=" + getId());
                    }
                    this.c = true;
                    BNGLTextureView.q.notifyAll();
                    while (!this.b && !this.d) {
                        if (BNGLTextureView.o) {
                            LogUtil.e("BNGLTextureView", "Main thread onPause waiting for mPaused.");
                        }
                        try {
                            BNGLTextureView.q.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void e() {
            synchronized (BNGLTextureView.q) {
                try {
                    if (BNGLTextureView.o) {
                        LogUtil.e("BNGLTextureView", "GLThread onResume tid=" + getId());
                    }
                    this.c = false;
                    this.n = true;
                    this.o = false;
                    BNGLTextureView.q.notifyAll();
                    while (!this.b && this.d && !this.o) {
                        if (BNGLTextureView.o) {
                            LogUtil.e("BNGLTextureView", "Main thread onResume waiting for !mPaused.");
                        }
                        try {
                            BNGLTextureView.q.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void f() {
            synchronized (BNGLTextureView.q) {
                try {
                    this.f9483a = true;
                    BNGLTextureView.q.notifyAll();
                    if (c()) {
                        LogUtil.e("BNGLTextureView", "requestExitAndWait");
                    }
                    while (!this.b) {
                        try {
                            BNGLTextureView.q.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void g() {
            this.j = true;
            BNGLTextureView.q.notifyAll();
        }

        public void h() {
            synchronized (BNGLTextureView.q) {
                this.n = true;
                BNGLTextureView.q.notifyAll();
            }
        }

        public void i() {
            synchronized (BNGLTextureView.q) {
                try {
                    if (c()) {
                        LogUtil.e("BNGLTextureView", "GLThread surfaceCreated tid=" + getId());
                    }
                    this.e = true;
                    BNGLTextureView.q.notifyAll();
                    while (this.g && !this.b) {
                        try {
                            BNGLTextureView.q.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void j() {
            synchronized (BNGLTextureView.q) {
                try {
                    if (c()) {
                        LogUtil.e("BNGLTextureView", "GLThread surfaceDestroyed tid=" + getId());
                    }
                    this.e = false;
                    BNGLTextureView.q.notifyAll();
                    while (!this.g && !this.b) {
                        try {
                            BNGLTextureView.q.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName(k());
            if (c()) {
                LogUtil.e("BNGLTextureView", "GLThread starting tid=" + getId());
            }
            try {
                l();
            } catch (InterruptedException unused) {
                BNGLTextureView.q.b(this);
            } catch (Throwable th) {
                BNGLTextureView.q.b(this);
                throw th;
            }
        }

        public boolean a() {
            return this.h && this.i && m();
        }

        public void a(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (BNGLTextureView.q) {
                    this.m = i;
                    BNGLTextureView.q.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public void a(int i, int i2) {
            synchronized (BNGLTextureView.q) {
                this.k = i;
                this.l = i2;
                this.q = true;
                this.n = true;
                this.o = false;
                BNGLTextureView.q.notifyAll();
                while (!this.b && !this.d && !this.o && a()) {
                    if (c()) {
                        LogUtil.e("BNGLTextureView", "Main thread onWindowResize waiting for render complete from tid=" + getId());
                    }
                    try {
                        BNGLTextureView.q.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class h {
        private static final Class g;
        private static final Method h;

        /* renamed from: a, reason: collision with root package name */
        private boolean f9484a;
        private int b;
        private boolean c;
        private boolean d;
        private boolean e;
        private g f;

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

        private h() {
        }

        public void a(g gVar) {
            if (this.f == gVar) {
                this.f = null;
            }
            notifyAll();
        }

        public synchronized void b(g gVar) {
            try {
                if (gVar.c()) {
                    LogUtil.e("BNGLTextureView-GLThreadManager", "GLThread exiting tid=" + gVar.getId());
                }
                gVar.b = true;
                if (this.f == gVar) {
                    this.f = null;
                }
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }

        public boolean c(g gVar) {
            g gVar2 = this.f;
            if (gVar2 != gVar && gVar2 != null) {
                c();
                if (this.d) {
                    return true;
                }
                g gVar3 = this.f;
                if (gVar3 == null) {
                    return false;
                }
                gVar3.g();
                return false;
            }
            this.f = gVar;
            notifyAll();
            return true;
        }

        public /* synthetic */ h(a aVar) {
            this();
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
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("BNGLTextureView-GLThreadManager", "checkGLDriver renderer = \"" + glGetString + "\" multipleContextsAllowed = " + this.d + " mLimitedGLESContexts = " + this.e);
                    }
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
            if (this.f9484a) {
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
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNGLTextureView-GLThreadManager", "checkGLESVersion mGLESVersion = " + this.b + " mMultipleGLESContextsAllowed = " + this.d);
            }
            this.f9484a = true;
        }
    }

    /* loaded from: classes8.dex */
    public static class i extends Writer {

        /* renamed from: a, reason: collision with root package name */
        private StringBuilder f9485a = new StringBuilder();

        private void a() {
            if (this.f9485a.length() > 0) {
                StringBuilder sb = this.f9485a;
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
                    this.f9485a.append(c);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j extends c {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public j(boolean r10) {
            /*
                r8 = this;
                com.baidu.nplatform.comapi.map.BNGLTextureView.this = r9
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
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.nplatform.comapi.map.BNGLTextureView.j.<init>(com.baidu.nplatform.comapi.map.BNGLTextureView, boolean):void");
        }
    }

    static {
        boolean z = LogUtil.LOGGABLE;
        n = z;
        o = z;
        p = z;
        q = new h(null);
    }

    public BNGLTextureView(Context context) {
        super(context);
        this.f9478a = new a();
        this.b = new WeakReference<>(this);
        this.m = true;
        k();
    }

    private void j() {
        if (this.c == null) {
        } else {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private void k() {
        setSurfaceTextureListener(this);
        addOnLayoutChangeListener(this.f9478a);
    }

    public boolean a() {
        return false;
    }

    public void finalize() throws Throwable {
        try {
            g gVar = this.c;
            if (gVar != null) {
                gVar.f();
            }
        } finally {
            super.finalize();
        }
    }

    public int getDebugFlags() {
        return this.j;
    }

    public String getName() {
        return "";
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.l;
    }

    public int getRenderMode() {
        return this.c.b();
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        int i2;
        boolean z;
        super.onAttachedToWindow();
        boolean z2 = n;
        if (z2) {
            LogUtil.e("BNGLTextureView", "onAttachedToWindow reattach =" + this.e + ",mGLThread name: " + this.c.getName());
        }
        if (this.e && this.d != null) {
            g gVar = this.c;
            if (gVar != null) {
                i2 = gVar.b();
            } else {
                i2 = 1;
            }
            if (this.c != null && !f()) {
                z = false;
            } else {
                this.c = new g(this.b);
                z = true;
            }
            if (i2 != 1) {
                this.c.a(i2);
            }
            if (z2) {
                LogUtil.e("BNGLTextureView", "onAttachedToWindow glThreadNewlyCreated =" + z);
            }
            if (z) {
                this.c.start();
            }
        }
        this.e = false;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        g gVar;
        if (n) {
            LogUtil.e("BNGLTextureView", "onDetachedFromWindow");
        }
        if (f() && (gVar = this.c) != null) {
            gVar.f();
        }
        this.e = true;
        super.onDetachedFromWindow();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        a(surfaceTexture);
        a(surfaceTexture, 0, i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        b(surfaceTexture);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        a(surfaceTexture, 0, i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setDebugFlags(int i2) {
        this.j = i2;
    }

    public void setEGLConfigChooser(GLSurfaceView.EGLConfigChooser eGLConfigChooser) {
        j();
        this.f = eGLConfigChooser;
    }

    public void setEGLContextClientVersion(int i2) {
        j();
        this.k = i2;
    }

    public void setEGLContextFactory(GLSurfaceView.EGLContextFactory eGLContextFactory) {
        j();
        this.g = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(GLSurfaceView.EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        j();
        this.h = eGLWindowSurfaceFactory;
    }

    public void setGLWrapper(GLSurfaceView.GLWrapper gLWrapper) {
        this.i = gLWrapper;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.l = z;
    }

    public void setRenderMode(int i2) {
        this.c.a(i2);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        j();
        if (this.f == null) {
            this.f = new j(this, true);
        }
        a aVar = null;
        if (this.g == null) {
            this.g = new d(this, aVar);
        }
        if (this.h == null) {
            this.h = new e(aVar);
        }
        this.d = renderer;
        g gVar = new g(this.b);
        this.c = gVar;
        gVar.start();
    }

    public void setRestartGLThreadOnAttach(boolean z) {
        this.m = z;
    }

    @Override // android.view.TextureView
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        super.setSurfaceTexture(surfaceTexture);
    }

    public void b(SurfaceTexture surfaceTexture) {
        g gVar = this.c;
        if (gVar != null) {
            gVar.j();
        }
    }

    public void c() {
        g gVar = this.c;
        if (gVar != null) {
            gVar.e();
        }
    }

    public void d() {
        g gVar;
        if (f() || (gVar = this.c) == null) {
            return;
        }
        gVar.f();
    }

    public void e() {
        g gVar = this.c;
        if (gVar != null) {
            gVar.h();
        }
    }

    public boolean f() {
        return this.m;
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new c(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new j(this, z));
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        setEGLConfigChooser(new c(i2, i3, i4, i5, i6, i7, i8, i9));
    }

    public void b() {
        g gVar = this.c;
        if (gVar != null) {
            gVar.d();
        }
    }

    public void a(SurfaceTexture surfaceTexture) {
        g gVar = this.c;
        if (gVar != null) {
            gVar.i();
        }
    }

    public BNGLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9478a = new a();
        this.b = new WeakReference<>(this);
        this.m = true;
        k();
    }

    public void a(SurfaceTexture surfaceTexture, int i2, int i3, int i4) {
        g gVar = this.c;
        if (gVar != null) {
            gVar.a(i3, i4);
        }
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
        protected int j;

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

        @Override // com.baidu.nplatform.comapi.map.BNGLTextureView.b
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            EGLConfig eGLConfig = null;
            for (EGLConfig eGLConfig2 : eGLConfigArr) {
                int a2 = a(egl10, eGLDisplay, eGLConfig2, 12325, 0);
                int a3 = a(egl10, eGLDisplay, eGLConfig2, 12326, 0);
                if (a2 >= this.h && a3 >= this.i) {
                    int a4 = a(egl10, eGLDisplay, eGLConfig2, 12324, 0);
                    int a5 = a(egl10, eGLDisplay, eGLConfig2, 12323, 0);
                    int a6 = a(egl10, eGLDisplay, eGLConfig2, 12322, 0);
                    int a7 = a(egl10, eGLDisplay, eGLConfig2, 12321, 0);
                    if (a4 == this.d && a5 == this.e && a6 == this.f && a7 == this.g) {
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

        public c(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12338, i7, 12337, i8, 12344});
            this.c = new int[1];
            this.d = i;
            this.e = i2;
            this.f = i3;
            this.g = i4;
            this.h = i5;
            this.i = i6;
            this.j = i8;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.c) ? this.c[0] : i2;
        }
    }

    public BNGLTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9478a = new a();
        this.b = new WeakReference<>(this);
        this.m = true;
        k();
    }
}
