package com.baidu.navisdk.module.ar;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.view.View;
import com.baidu.navisdk.module.ar.jni.JNIBNArService;
import com.baidu.navisdk.module.ar.listener.a;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;

/* loaded from: classes7.dex */
public final class e implements a.InterfaceC0216a, Observer {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f6985a;
    private final com.baidu.navisdk.module.ar.d b;
    private final com.baidu.navisdk.module.ar.msg.b c;
    private com.baidu.navisdk.module.ar.view.e d;
    private JNIBNArService e;
    private com.baidu.navisdk.module.ar.record.a f;
    private com.baidu.navisdk.module.ar.model.a g;
    private com.baidu.navisdk.module.ar.utils.a h;
    private String i;
    private ThreadPoolExecutor j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;

    /* loaded from: classes7.dex */
    public static final class a implements RejectedExecutionHandler {
        public a(int i) {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(@oOoXoXO Runnable runnable, @oOoXoXO ThreadPoolExecutor threadPoolExecutor) {
            b a2;
            if (!(runnable instanceof c)) {
                runnable = null;
            }
            c cVar = (c) runnable;
            if (cVar != null && (a2 = cVar.a()) != null) {
                a2.a(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private boolean f6986a;
        private boolean b;

        @OOXIXo
        private final byte[] c;

        @OOXIXo
        private final com.baidu.navisdk.module.ar.listener.a d;

        public b(@OOXIXo byte[] byteArray, @OOXIXo com.baidu.navisdk.module.ar.listener.a camera) {
            IIX0o.x0xO0oo(byteArray, "byteArray");
            IIX0o.x0xO0oo(camera, "camera");
            this.c = byteArray;
            this.d = camera;
            this.f6986a = true;
        }

        private final void b() {
            if (!this.f6986a && !this.b) {
                this.d.a(this.c);
                this.b = true;
            }
        }

        @OOXIXo
        public final byte[] a() {
            return this.c;
        }

        public final synchronized void a(boolean z) {
            this.f6986a = z;
            b();
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        @OOXIXo
        private final b f6987a;

        public c(@OOXIXo b data) {
            IIX0o.x0xO0oo(data, "data");
            this.f6987a = data;
        }

        @OOXIXo
        public final b a() {
            return this.f6987a;
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends c {
        final /* synthetic */ b c;
        final /* synthetic */ Ref.ObjectRef d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b bVar, Ref.ObjectRef objectRef, b bVar2) {
            super(bVar2);
            this.c = bVar;
            this.d = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (!e.this.l) {
                e.c(e.this).a(1);
                e.c(e.this).b(1);
                e.c(e.this).a(256);
                e.c(e.this).b(256);
                e.this.l = true;
            }
            if (!e.this.m) {
                e.c(e.this).a(16);
                e.c(e.this).b(16);
                e.this.m = true;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            JNIBNArService c = e.c(e.this);
            byte[] a2 = this.c.a();
            a.b bVar = (a.b) this.d.element;
            c.a(a2, bVar.c, bVar.d, bVar.j, 273);
            this.c.a(false);
            com.baidu.navisdk.module.ar.util.a.a("BNAr", "object time :" + (SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    /* renamed from: com.baidu.navisdk.module.ar.e$e, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class RunnableC0215e implements Runnable {
        final /* synthetic */ Bitmap b;

        public RunnableC0215e(Bitmap bitmap) {
            this.b = bitmap;
        }

        @Override // java.lang.Runnable
        public final void run() {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (!e.this.l) {
                e.c(e.this).a(1);
                e.c(e.this).b(1);
                e.c(e.this).a(256);
                e.c(e.this).b(256);
                e.this.l = true;
            }
            if (!e.this.m) {
                e.c(e.this).a(16);
                e.c(e.this).b(16);
                e.this.m = true;
            }
            e.c(e.this).a(this.b, 273, (String) null);
            com.baidu.navisdk.module.ar.util.a.a("BNAr", "object time :" + (SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    public e(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        this.f6985a = activity;
        this.b = new com.baidu.navisdk.module.ar.d(activity);
        this.c = new com.baidu.navisdk.module.ar.msg.b();
        this.j = a("object-detector", 1);
        a("laneseg", 16);
        this.n = true;
    }

    public static final /* synthetic */ JNIBNArService c(e eVar) {
        JNIBNArService jNIBNArService = eVar.e;
        if (jNIBNArService == null) {
            IIX0o.XOxIOxOx("mArEngine");
        }
        return jNIBNArService;
    }

    private final void j() {
        String b2;
        if (this.g == null) {
            String str = this.f6985a.getFilesDir().toString() + "/models";
            com.baidu.navisdk.module.ar.utils.c.f7009a.a(this.f6985a, "models", str);
            com.baidu.navisdk.module.ar.model.a aVar = new com.baidu.navisdk.module.ar.model.a();
            this.g = aVar;
            aVar.e(str + "/ar.nb");
            com.baidu.navisdk.module.ar.model.a aVar2 = this.g;
            if (aVar2 == null) {
                IIX0o.XOxIOxOx("mArConfig");
            }
            aVar2.c(str + "/laneseg29.nb");
            com.baidu.navisdk.module.ar.model.a aVar3 = this.g;
            if (aVar3 == null) {
                IIX0o.XOxIOxOx("mArConfig");
            }
            aVar3.g(str + "/ar.rs");
            com.baidu.navisdk.module.ar.model.a aVar4 = this.g;
            if (aVar4 == null) {
                IIX0o.XOxIOxOx("mArConfig");
            }
            aVar4.a(257);
        }
        if (this.n) {
            com.baidu.navisdk.module.ar.model.a aVar5 = this.g;
            if (aVar5 == null) {
                IIX0o.XOxIOxOx("mArConfig");
            }
            b2 = aVar5.a();
        } else {
            com.baidu.navisdk.module.ar.model.a aVar6 = this.g;
            if (aVar6 == null) {
                IIX0o.XOxIOxOx("mArConfig");
            }
            b2 = aVar6.b();
        }
        JNIBNArService jNIBNArService = this.e;
        if (jNIBNArService == null) {
            IIX0o.XOxIOxOx("mArEngine");
        }
        jNIBNArService.a(b2);
        this.l = false;
        this.m = false;
    }

    public void d() {
        com.baidu.navisdk.module.ar.utils.a aVar = this.h;
        if (aVar == null) {
            IIX0o.XOxIOxOx("mDayNightLooper");
        }
        aVar.c();
        JNIBNArService jNIBNArService = this.e;
        if (jNIBNArService == null) {
            IIX0o.XOxIOxOx("mArEngine");
        }
        jNIBNArService.c();
    }

    public void e() {
        com.baidu.navisdk.module.ar.view.e eVar = this.d;
        if (eVar == null) {
            IIX0o.XOxIOxOx("mArView");
        }
        eVar.b();
    }

    public void f() {
        com.baidu.navisdk.module.ar.view.e eVar = this.d;
        if (eVar == null) {
            IIX0o.XOxIOxOx("mArView");
        }
        eVar.a(this);
    }

    public boolean g() {
        if (this.f == null) {
            this.f = new com.baidu.navisdk.module.ar.record.a(this.b);
        }
        com.baidu.navisdk.module.ar.record.a aVar = this.f;
        if (aVar == null) {
            IIX0o.XOxIOxOx("mCameraRecorder");
        }
        aVar.a();
        return true;
    }

    public void h() {
        com.baidu.navisdk.module.ar.view.e eVar = this.d;
        if (eVar == null) {
            IIX0o.XOxIOxOx("mArView");
        }
        eVar.a((a.InterfaceC0216a) null);
    }

    public boolean i() {
        com.baidu.navisdk.module.ar.record.a aVar = this.f;
        if (aVar != null) {
            aVar.b();
            return true;
        }
        return false;
    }

    @Override // java.util.Observer
    public void update(@oOoXoXO Observable observable, @oOoXoXO Object obj) {
        com.baidu.navisdk.module.ar.utils.a aVar = this.h;
        if (aVar == null) {
            IIX0o.XOxIOxOx("mDayNightLooper");
        }
        if (IIX0o.Oxx0IOOO(observable, aVar)) {
            if (obj != null) {
                a(((Boolean) obj).booleanValue());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        }
    }

    public void c() {
        this.e = new JNIBNArService();
        com.baidu.navisdk.module.ar.utils.a aVar = new com.baidu.navisdk.module.ar.utils.a(this.b);
        this.h = aVar;
        aVar.addObserver(this);
        com.baidu.navisdk.module.ar.utils.a aVar2 = this.h;
        if (aVar2 == null) {
            IIX0o.XOxIOxOx("mDayNightLooper");
        }
        aVar2.b();
        com.baidu.navisdk.module.ar.utils.a aVar3 = this.h;
        if (aVar3 == null) {
            IIX0o.XOxIOxOx("mDayNightLooper");
        }
        this.n = aVar3.a();
        if (this.i != null) {
            JNIBNArService jNIBNArService = this.e;
            if (jNIBNArService == null) {
                IIX0o.XOxIOxOx("mArEngine");
            }
            String str = this.i;
            if (str == null) {
                IIX0o.XOxIOxOx("mCloudData");
            }
            jNIBNArService.b(str);
        }
        j();
        JNIBNArService jNIBNArService2 = this.e;
        if (jNIBNArService2 == null) {
            IIX0o.XOxIOxOx("mArEngine");
        }
        com.baidu.navisdk.module.ar.msg.b bVar = this.c;
        if (bVar != null) {
            jNIBNArService2.a(bVar);
            JNIBNArService jNIBNArService3 = this.e;
            if (jNIBNArService3 == null) {
                IIX0o.XOxIOxOx("mArEngine");
            }
            a(jNIBNArService3);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
    }

    private final ThreadPoolExecutor a(String str, int i) {
        return new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(2), new com.baidu.navisdk.module.ar.util.b(str), new a(i));
    }

    public final void b(@OOXIXo String folder) {
        IIX0o.x0xO0oo(folder, "folder");
        this.b.a(folder);
    }

    @OOXIXo
    public View b() {
        if (this.d == null) {
            this.d = new com.baidu.navisdk.module.ar.view.e(this.b);
        }
        com.baidu.navisdk.module.ar.view.e eVar = this.d;
        if (eVar == null) {
            IIX0o.XOxIOxOx("mArView");
        }
        View a2 = eVar.a();
        IIX0o.oO(a2, "mArView.view");
        return a2;
    }

    public final void a(@oOoXoXO com.baidu.navisdk.module.ar.model.a aVar) {
        if (aVar != null) {
            this.g = aVar;
        }
    }

    public final void a(@oOoXoXO String str) {
        if (str != null) {
            this.i = str;
        }
    }

    public final void a(@OOXIXo com.baidu.navisdk.module.ar.tracker.e proxy) {
        IIX0o.x0xO0oo(proxy, "proxy");
        this.b.a(proxy);
    }

    private final void a(boolean z) {
        if (this.n == z || this.e == null) {
            return;
        }
        this.n = z;
        j();
    }

    @OOXIXo
    public com.baidu.navisdk.module.ar.msg.b a() {
        return this.c;
    }

    private final void a(com.baidu.navisdk.module.ar.jni.a aVar) {
        com.baidu.navisdk.module.ar.view.e eVar = this.d;
        if (eVar == null) {
            IIX0o.XOxIOxOx("mArView");
        }
        eVar.a(aVar);
    }

    public void a(int i) {
        com.baidu.navisdk.module.ar.view.e eVar = this.d;
        if (eVar == null) {
            IIX0o.XOxIOxOx("mArView");
        }
        eVar.a(i);
    }

    public boolean a(int i, int i2, int i3) {
        JNIBNArService jNIBNArService = this.e;
        if (jNIBNArService == null) {
            IIX0o.XOxIOxOx("mArEngine");
        }
        return jNIBNArService.a(i, i2, i3);
    }

    public boolean a(double d2, double d3, float f) {
        this.b.b(d2);
        this.b.a(d3);
        JNIBNArService jNIBNArService = this.e;
        if (jNIBNArService == null) {
            IIX0o.XOxIOxOx("mArEngine");
        }
        return jNIBNArService.a(d2, d3, f);
    }

    public void a(@OOXIXo boolean[] lanes) {
        IIX0o.x0xO0oo(lanes, "lanes");
        JNIBNArService jNIBNArService = this.e;
        if (jNIBNArService == null) {
            IIX0o.XOxIOxOx("mArEngine");
        }
        jNIBNArService.a(lanes);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [T, com.baidu.navisdk.module.ar.listener.a$b] */
    @Override // com.baidu.navisdk.module.ar.listener.a.InterfaceC0216a
    public void a(@OOXIXo byte[] data, long j, @OOXIXo com.baidu.navisdk.module.ar.listener.a camera) {
        IIX0o.x0xO0oo(data, "data");
        IIX0o.x0xO0oo(camera, "camera");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? bVar = new a.b();
        objectRef.element = bVar;
        camera.a((a.b) bVar);
        com.baidu.navisdk.module.ar.record.a aVar = this.f;
        if (aVar != null) {
            a.b bVar2 = (a.b) objectRef.element;
            aVar.a(data, bVar2.c, bVar2.d, bVar2.j);
        }
        if (!this.k) {
            JNIBNArService jNIBNArService = this.e;
            if (jNIBNArService == null) {
                IIX0o.XOxIOxOx("mArEngine");
            }
            a.b bVar3 = (a.b) objectRef.element;
            jNIBNArService.a(bVar3.h, bVar3.g);
            this.k = true;
        }
        b bVar4 = new b(data, camera);
        this.j.execute(new d(bVar4, objectRef, bVar4));
    }

    @Override // com.baidu.navisdk.module.ar.listener.a.InterfaceC0216a
    public void a(@OOXIXo Bitmap data, long j) {
        IIX0o.x0xO0oo(data, "data");
        if (!this.k) {
            JNIBNArService jNIBNArService = this.e;
            if (jNIBNArService == null) {
                IIX0o.XOxIOxOx("mArEngine");
            }
            jNIBNArService.a(51.5f, 65.5f);
            this.k = true;
        }
        this.j.execute(new RunnableC0215e(data));
    }
}
