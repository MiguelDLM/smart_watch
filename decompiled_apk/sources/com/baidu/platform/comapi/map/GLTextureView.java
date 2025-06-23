package com.baidu.platform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLException;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import com.baidu.platform.comapi.util.EglConfigUtils;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.nio.IntBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes8.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    private static final g c = new g(null);

    /* renamed from: a, reason: collision with root package name */
    private int f9600a;
    private final View.OnLayoutChangeListener b;
    private final WeakReference<GLTextureView> d;
    private f e;
    private SurfaceRenderer f;
    private boolean g;
    private GLSurfaceView.EGLConfigChooser h;
    private GLSurfaceView.EGLContextFactory i;
    private GLSurfaceView.EGLWindowSurfaceFactory j;
    private GLSurfaceView.GLWrapper k;
    private int l;
    private int m;
    private boolean n;

    /* loaded from: classes8.dex */
    public abstract class a implements GLSurfaceView.EGLConfigChooser {

        /* renamed from: a, reason: collision with root package name */
        protected int[] f9601a;

        public a(int[] iArr) {
            this.f9601a = a(iArr);
        }

        private int[] a(int[] iArr) {
            if (GLTextureView.this.m != 2 && GLTextureView.this.m != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            if (GLTextureView.this.m == 2) {
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
            if (egl10.eglChooseConfig(eGLDisplay, this.f9601a, null, 0, iArr)) {
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    if (egl10.eglChooseConfig(eGLDisplay, this.f9601a, eGLConfigArr, i, iArr)) {
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
    public static class d implements GLSurfaceView.EGLWindowSurfaceFactory {
        private d() {
        }

        @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLTextureView", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }

        public /* synthetic */ d(com.baidu.platform.comapi.map.h hVar) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        EGL10 f9603a;
        EGLDisplay b;
        EGLSurface c;
        EGLConfig d;
        EGLContext e;
        private WeakReference<GLTextureView> f;

        public e(WeakReference<GLTextureView> weakReference) {
            this.f = weakReference;
        }

        public static void a(String str, String str2, int i) {
        }

        private void g() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.c;
            if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                this.f9603a.eglMakeCurrent(this.b, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                GLTextureView gLTextureView = this.f.get();
                if (gLTextureView != null) {
                    gLTextureView.j.destroySurface(this.f9603a, this.b, this.c);
                }
                this.c = null;
            }
        }

        public boolean b() {
            Log.w("EglHelper", "createSurface()  tid=" + Thread.currentThread().getId());
            if (this.f9603a != null) {
                if (this.b != null) {
                    if (this.d != null) {
                        g();
                        GLTextureView gLTextureView = this.f.get();
                        if (gLTextureView != null) {
                            this.c = gLTextureView.j.createWindowSurface(this.f9603a, this.b, this.d, gLTextureView.getSurfaceTexture());
                        } else {
                            this.c = null;
                        }
                        EGLSurface eGLSurface = this.c;
                        if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                            if (this.f9603a.eglMakeCurrent(this.b, eGLSurface, eGLSurface, this.e)) {
                                return true;
                            }
                            a("EGLHelper", "eglMakeCurrent", this.f9603a.eglGetError());
                            return false;
                        }
                        if (this.f9603a.eglGetError() == 12299) {
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
            h hVar;
            GL gl = this.e.getGL();
            GLTextureView gLTextureView = this.f.get();
            if (gLTextureView != null) {
                if (gLTextureView.k != null) {
                    gl = gLTextureView.k.wrap(gl);
                }
                if ((gLTextureView.l & 3) != 0) {
                    int i = 1;
                    if ((gLTextureView.l & 1) == 0) {
                        i = 0;
                    }
                    if ((gLTextureView.l & 2) != 0) {
                        hVar = new h();
                    } else {
                        hVar = null;
                    }
                    return GLDebugHelper.wrap(gl, i, hVar);
                }
                return gl;
            }
            return gl;
        }

        public int d() {
            if (!this.f9603a.eglSwapBuffers(this.b, this.c)) {
                return this.f9603a.eglGetError();
            }
            return 12288;
        }

        public void e() {
            Log.w("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
            g();
        }

        public void f() {
            Log.w("EglHelper", "finish() tid=" + Thread.currentThread().getId());
            if (this.e != null) {
                GLTextureView gLTextureView = this.f.get();
                if (gLTextureView != null) {
                    gLTextureView.i.destroyContext(this.f9603a, this.b, this.e);
                }
                this.e = null;
            }
            EGLDisplay eGLDisplay = this.b;
            if (eGLDisplay != null) {
                this.f9603a.eglTerminate(eGLDisplay);
                this.b = null;
            }
        }

        public void a() {
            Log.w("EglHelper", "start() tid=" + Thread.currentThread().getId());
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f9603a = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.b = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.f9603a.eglInitialize(eglGetDisplay, new int[2])) {
                    GLTextureView gLTextureView = this.f.get();
                    if (gLTextureView != null) {
                        this.d = gLTextureView.h.chooseConfig(this.f9603a, this.b);
                        this.e = gLTextureView.i.createContext(this.f9603a, this.b, this.d);
                    } else {
                        this.d = null;
                        this.e = null;
                    }
                    EGLContext eGLContext = this.e;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.e = null;
                        a("createContext");
                    }
                    Log.w("EglHelper", "createContext " + this.e + " tid=" + Thread.currentThread().getId());
                    this.c = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public static String b(String str, int i) {
            return str + " EGL failed code: " + i;
        }

        private void a(String str) {
            a(str, this.f9603a.eglGetError());
        }

        public static void a(String str, int i) {
            throw new RuntimeException(b(str, i));
        }
    }

    /* loaded from: classes8.dex */
    public static class f extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private boolean f9604a;
        private boolean b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean o;
        private e r;
        private WeakReference<GLTextureView> s;
        private ArrayList<Runnable> p = new ArrayList<>();
        private boolean q = true;
        private int k = 0;
        private int l = 0;
        private boolean n = true;
        private int m = 1;

        public f(WeakReference<GLTextureView> weakReference) {
            this.s = weakReference;
        }

        private void j() {
            if (this.i) {
                this.i = false;
                this.r.e();
            }
        }

        private void k() {
            if (this.h) {
                this.r.f();
                this.h = false;
                GLTextureView.c.c(this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:112:0x035b  */
        /* JADX WARN: Removed duplicated region for block: B:118:0x0373 A[Catch: all -> 0x0257, TryCatch #2 {all -> 0x0257, blocks: (B:4:0x001c, B:5:0x001e, B:151:0x0251, B:76:0x025c, B:137:0x026b, B:138:0x026d, B:148:0x027a, B:81:0x027e, B:83:0x0291, B:85:0x02a2, B:88:0x02c2, B:90:0x02ef, B:92:0x02f7, B:94:0x0305, B:95:0x0313, B:99:0x0321, B:100:0x032a, B:108:0x0337, B:110:0x0338, B:113:0x035c, B:116:0x0366, B:118:0x0373, B:119:0x0375, B:127:0x037d, B:184:0x039e, B:7:0x001f, B:171:0x0023, B:9:0x0035, B:169:0x003d, B:73:0x024e, B:11:0x0049, B:13:0x004f, B:14:0x0087, B:16:0x008b, B:18:0x00b1, B:20:0x00ba, B:22:0x00be, B:24:0x00dd, B:26:0x00e1, B:28:0x00eb, B:30:0x00f1, B:32:0x00fb, B:34:0x011a, B:36:0x0124, B:37:0x0143, B:39:0x0147, B:41:0x014b, B:43:0x0169, B:44:0x016c, B:45:0x0177, B:47:0x017b, B:49:0x017f, B:51:0x01a3, B:52:0x01c7, B:54:0x01cd, B:58:0x01fb, B:60:0x01ff, B:62:0x0203, B:63:0x020c, B:69:0x0210, B:71:0x0214, B:72:0x0243, B:67:0x0392, B:154:0x01d7, B:157:0x01e1, B:159:0x01e7, B:162:0x01f1, B:163:0x01f8, B:103:0x032c, B:104:0x0331, B:141:0x026f, B:142:0x0274, B:121:0x0376, B:122:0x0379), top: B:3:0x001c, inners: #0, #1, #3, #6 }] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0385  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0210 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void l() throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 941
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.map.GLTextureView.f.l():void");
        }

        private boolean m() {
            if (!this.d && this.e && !this.f && this.k > 0 && this.l > 0 && (this.n || this.m == 1)) {
                return true;
            }
            return false;
        }

        public int b() {
            int i;
            synchronized (com.baidu.platform.a.a.f9524a) {
                i = this.m;
            }
            return i;
        }

        public void c() {
            Object obj = com.baidu.platform.a.a.f9524a;
            synchronized (obj) {
                this.n = true;
                obj.notifyAll();
            }
        }

        public void d() {
            Object obj = com.baidu.platform.a.a.f9524a;
            synchronized (obj) {
                this.e = true;
                obj.notifyAll();
                while (this.g && !this.b) {
                    try {
                        com.baidu.platform.a.a.f9524a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void e() {
            Object obj = com.baidu.platform.a.a.f9524a;
            synchronized (obj) {
                this.e = false;
                obj.notifyAll();
                while (!this.g && !this.b) {
                    try {
                        com.baidu.platform.a.a.f9524a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void f() {
            Object obj = com.baidu.platform.a.a.f9524a;
            synchronized (obj) {
                Log.i("GLThread", "onPause tid=" + getId());
                this.c = true;
                obj.notifyAll();
                while (!this.b && !this.d) {
                    Log.i("Main thread", "onPause waiting for mPaused.");
                    try {
                        com.baidu.platform.a.a.f9524a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void g() {
            Object obj = com.baidu.platform.a.a.f9524a;
            synchronized (obj) {
                Log.i("GLThread", "onResume tid=" + getId());
                this.c = false;
                this.n = true;
                this.o = false;
                obj.notifyAll();
                while (!this.b && this.d && !this.o) {
                    Log.i("Main thread", "onResume waiting for !mPaused.");
                    try {
                        com.baidu.platform.a.a.f9524a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void h() {
            Object obj = com.baidu.platform.a.a.f9524a;
            synchronized (obj) {
                this.f9604a = true;
                obj.notifyAll();
                while (!this.b) {
                    try {
                        com.baidu.platform.a.a.f9524a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void i() {
            this.j = true;
            com.baidu.platform.a.a.f9524a.notifyAll();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                l();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                GLTextureView.c.a(this);
                throw th;
            }
            GLTextureView.c.a(this);
        }

        public boolean a() {
            return this.h && this.i && m();
        }

        public void a(int i) {
            if (i >= 0 && i <= 1) {
                Object obj = com.baidu.platform.a.a.f9524a;
                synchronized (obj) {
                    this.m = i;
                    obj.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public void a(int i, int i2) {
            Object obj = com.baidu.platform.a.a.f9524a;
            synchronized (obj) {
                this.k = i;
                this.l = i2;
                this.q = true;
                this.n = true;
                this.o = false;
                obj.notifyAll();
                while (!this.b && !this.d && !this.o && a()) {
                    Log.i("Main thread", "onWindowResize waiting for render complete from tid=" + getId());
                    try {
                        com.baidu.platform.a.a.f9524a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void a(Runnable runnable) {
            if (runnable != null) {
                Object obj = com.baidu.platform.a.a.f9524a;
                synchronized (obj) {
                    this.p.add(runnable);
                    obj.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }
    }

    /* loaded from: classes8.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        private static String f9605a = "GLThreadManager";
        private static final Class b;
        private static final Method c;
        private boolean d;
        private int e;
        private boolean f;
        private boolean g;
        private boolean h;
        private f i;

        static {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                b = cls;
                Method declaredMethod = cls.getDeclaredMethod("getInt", String.class, Integer.TYPE);
                c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private g() {
        }

        public void a(f fVar) {
            Object obj = com.baidu.platform.a.a.f9524a;
            synchronized (obj) {
                try {
                    fVar.b = true;
                    if (this.i == fVar) {
                        this.i = null;
                    }
                    obj.notifyAll();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public boolean b(f fVar) {
            f fVar2 = this.i;
            if (fVar2 != fVar && fVar2 != null) {
                c();
                if (this.g) {
                    return true;
                }
                f fVar3 = this.i;
                if (fVar3 == null) {
                    return false;
                }
                fVar3.i();
                return false;
            }
            this.i = fVar;
            com.baidu.platform.a.a.f9524a.notifyAll();
            return true;
        }

        public void c(f fVar) {
            if (this.i == fVar) {
                this.i = null;
            }
            com.baidu.platform.a.a.f9524a.notifyAll();
        }

        public /* synthetic */ g(com.baidu.platform.comapi.map.h hVar) {
            this();
        }

        private void c() {
            if (this.d) {
                return;
            }
            try {
                this.e = ((Integer) c.invoke(null, "ro.opengles.version", 0)).intValue();
            } catch (Exception unused) {
                this.e = 65536;
            }
            if (this.e >= 131072) {
                this.g = true;
            }
            Log.w(f9605a, "checkGLESVersion mGLESVersion = " + this.e + " mMultipleGLESContextsAllowed = " + this.g);
            this.d = true;
        }

        public boolean a() {
            boolean z;
            synchronized (com.baidu.platform.a.a.f9524a) {
                z = this.h;
            }
            return z;
        }

        public boolean b() {
            boolean z;
            synchronized (com.baidu.platform.a.a.f9524a) {
                c();
                z = !this.g;
            }
            return z;
        }

        public void a(GL10 gl10) {
            Object obj = com.baidu.platform.a.a.f9524a;
            synchronized (obj) {
                try {
                    if (!this.f) {
                        c();
                        String glGetString = gl10.glGetString(7937);
                        if (this.e < 131072) {
                            this.g = !glGetString.startsWith("Q3Dimension MSM7500 ");
                            obj.notifyAll();
                        }
                        this.h = !this.g;
                        Log.w(f9605a, "checkGLDriver renderer = \"" + glGetString + "\" multipleContextsAllowed = " + this.g + " mLimitedGLESContexts = " + this.h);
                        this.f = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class h extends Writer {

        /* renamed from: a, reason: collision with root package name */
        private StringBuilder f9606a = new StringBuilder();

        private void a() {
            if (this.f9606a.length() > 0) {
                StringBuilder sb = this.f9606a;
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
                    this.f9606a.append(c);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i extends b {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public i(boolean r10) {
            /*
                r8 = this;
                com.baidu.platform.comapi.map.GLTextureView.this = r9
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
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.map.GLTextureView.i.<init>(com.baidu.platform.comapi.map.GLTextureView, boolean):void");
        }
    }

    public GLTextureView(Context context) {
        super(context);
        this.f9600a = 60;
        this.b = new com.baidu.platform.comapi.map.h(this);
        this.d = new WeakReference<>(this);
        b();
    }

    public Bitmap captureImageFromSurface(int i2, int i3, int i4, int i5, Object obj, Bitmap.Config config) {
        return a(i2, i3, i4, i5, (GL10) obj, config);
    }

    public void finalize() throws Throwable {
        try {
            f fVar = this.e;
            if (fVar != null) {
                fVar.h();
            }
        } finally {
            super.finalize();
        }
    }

    public int getDebugFlags() {
        return this.l;
    }

    public int getFPS() {
        return this.f9600a;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.n;
    }

    public int getRenderMode() {
        return this.e.b();
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        int i2;
        super.onAttachedToWindow();
        Log.d("GLTextureView", "onAttachedToWindow reattach =" + this.g);
        if (this.g && this.f != null) {
            f fVar = this.e;
            if (fVar != null) {
                i2 = fVar.b();
            } else {
                i2 = 1;
            }
            f fVar2 = new f(this.d);
            this.e = fVar2;
            if (i2 != 1) {
                fVar2.a(i2);
            }
            this.e.start();
        }
        this.g = false;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Log.d("GLTextureView", "onDetachedFromWindow");
        f fVar = this.e;
        if (fVar != null) {
            fVar.h();
        }
        this.g = true;
        super.onDetachedFromWindow();
    }

    public void onPause() {
        f fVar = this.e;
        if (fVar != null) {
            fVar.f();
        }
    }

    public void onResume() {
        f fVar = this.e;
        if (fVar != null) {
            fVar.g();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        surfaceCreated(surfaceTexture);
        surfaceChanged(surfaceTexture, 0, i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        surfaceDestroyed(surfaceTexture);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        surfaceChanged(surfaceTexture, 0, i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void queueEvent(Runnable runnable) {
        f fVar = this.e;
        if (fVar != null) {
            fVar.a(runnable);
        }
    }

    public void requestRender() {
        f fVar = this.e;
        if (fVar != null) {
            fVar.c();
        }
    }

    public void setDebugFlags(int i2) {
        this.l = i2;
    }

    public void setEGLConfigChooser(GLSurfaceView.EGLConfigChooser eGLConfigChooser) {
        c();
        this.h = eGLConfigChooser;
    }

    public void setEGLContextClientVersion(int i2) {
        c();
        this.m = i2;
    }

    public void setEGLContextFactory(GLSurfaceView.EGLContextFactory eGLContextFactory) {
        c();
        this.i = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(GLSurfaceView.EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        c();
        this.j = eGLWindowSurfaceFactory;
    }

    public void setFPS(int i2) {
        this.f9600a = i2;
    }

    public void setGLWrapper(GLSurfaceView.GLWrapper gLWrapper) {
        this.k = gLWrapper;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.n = z;
    }

    public void setRenderMode(int i2) {
        this.e.a(i2);
    }

    public void setRenderer(SurfaceRenderer surfaceRenderer) {
        c();
        if (this.h == null) {
            try {
                if (EglConfigUtils.isSupportConfig(8, 8, 8, 0, 24, 8)) {
                    setEGLConfigChooser(8, 8, 8, 0, 24, 8);
                } else {
                    setEGLConfigChooser(true);
                }
            } catch (IllegalArgumentException unused) {
                setEGLConfigChooser(true);
            }
        }
        com.baidu.platform.comapi.map.h hVar = null;
        if (this.i == null) {
            this.i = new c(this, hVar);
        }
        if (this.j == null) {
            this.j = new d(hVar);
        }
        this.f = surfaceRenderer;
        f fVar = new f(this.d);
        this.e = fVar;
        fVar.start();
    }

    public void surfaceChanged(SurfaceTexture surfaceTexture, int i2, int i3, int i4) {
        f fVar = this.e;
        if (fVar != null) {
            fVar.a(i3, i4);
        }
    }

    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        f fVar = this.e;
        if (fVar != null) {
            fVar.d();
        }
    }

    public void surfaceDestroyed(SurfaceTexture surfaceTexture) {
        f fVar = this.e;
        if (fVar != null) {
            fVar.e();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements GLSurfaceView.EGLContextFactory {
        private int b;

        private c() {
            this.b = 12440;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.b, GLTextureView.this.m, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.m == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                e.a("eglDestroyContex", egl10.eglGetError());
            }
        }

        public /* synthetic */ c(GLTextureView gLTextureView, com.baidu.platform.comapi.map.h hVar) {
            this();
        }
    }

    private void b() {
        setSurfaceTextureListener(this);
        addOnLayoutChangeListener(this.b);
    }

    private void c() {
        if (this.e != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
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

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new i(this, z));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7, i8));
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9600a = 60;
        this.b = new com.baidu.platform.comapi.map.h(this);
        this.d = new WeakReference<>(this);
        b();
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
        private int[] k;

        public b(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.k = new int[1];
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.h = i6;
            this.i = 1;
        }

        @Override // com.baidu.platform.comapi.map.GLTextureView.a
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
                        if (a(egl10, eGLDisplay, eGLConfig2, 12337, 0) == this.i) {
                            return eGLConfig2;
                        }
                    }
                }
            }
            return eGLConfig;
        }

        public b(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12338, 1, 12337, i7, 12344});
            this.k = new int[1];
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.h = i6;
            this.i = i7;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.k) ? this.k[0] : i2;
        }
    }

    public GLTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f9600a = 60;
        this.b = new com.baidu.platform.comapi.map.h(this);
        this.d = new WeakReference<>(this);
        b();
    }
}
