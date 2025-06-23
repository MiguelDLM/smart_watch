package com.baidu.navisdk.uiframe;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.navisdk.apicenter.c;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.framework.func.Func;
import com.baidu.navisdk.uiframe.framework.a;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import o0oIxXOx.IXxxXO;

/* loaded from: classes8.dex */
public class ModularUiFrame<C extends com.baidu.navisdk.uiframe.framework.a> implements LifecycleOwner, LifecycleEventObserver, c {

    /* renamed from: a, reason: collision with root package name */
    protected final String f9211a;
    protected final String b;
    protected volatile boolean c;
    protected volatile boolean d;
    protected volatile boolean e;
    protected final C f;
    private final UiModuleGroup<C> g;
    private final com.baidu.navisdk.uiframe.a<C> h;
    private volatile int i = 1;
    private final LifecycleRegistry j = new LifecycleRegistry(this);
    protected final ArrayMap<String, com.baidu.navisdk.uiframe.a> k;
    protected final ArrayMap<String, UiModule> l;
    protected final ArrayMap<Class<? extends UiModule>, UiModule> m;
    protected final HashSet<String> n;

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.lite.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ UiModule f9212a;
        final /* synthetic */ com.baidu.navisdk.uiframe.a b;
        final /* synthetic */ int c;
        final /* synthetic */ String[] d;
        final /* synthetic */ boolean e;
        final /* synthetic */ Configuration f;

        /* renamed from: com.baidu.navisdk.uiframe.ModularUiFrame$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0493a extends com.baidu.navisdk.util.worker.lite.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ View f9213a;
            final /* synthetic */ ViewGroup b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0493a(String str, View view, ViewGroup viewGroup) {
                super(str);
                this.f9213a = view;
                this.b = viewGroup;
            }

            @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
            public void run() {
                if (a.this.f9212a.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                    a aVar = a.this;
                    aVar.b.a(aVar.c, 0);
                    return;
                }
                a aVar2 = a.this;
                if (aVar2.c != ModularUiFrame.this.i) {
                    a aVar3 = a.this;
                    aVar3.b.a(aVar3.c, 0);
                } else {
                    a aVar4 = a.this;
                    ModularUiFrame.this.a(aVar4.d, aVar4.c, aVar4.b, aVar4.e, aVar4.f, this.f9213a, this.b);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, UiModule uiModule, com.baidu.navisdk.uiframe.a aVar, int i, String[] strArr, boolean z, Configuration configuration) {
            super(str);
            this.f9212a = uiModule;
            this.b = aVar;
            this.c = i;
            this.d = strArr;
            this.e = z;
            this.f = configuration;
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            boolean z;
            UiModule<C> uiModule;
            if (this.f9212a.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                this.b.a(this.c, 0);
                return;
            }
            if (this.c != ModularUiFrame.this.i) {
                this.b.a(this.c, 0);
                return;
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                z = true;
            } else {
                z = false;
            }
            com.baidu.navisdk.uiframe.a aVar = this.b;
            if (!aVar.b && !z) {
                aVar.a(this.c, 0);
                return;
            }
            com.baidu.navisdk.uiframe.a<C> aVar2 = aVar.g;
            View view = null;
            if (aVar2 == null) {
                uiModule = null;
            } else {
                uiModule = aVar2.f9215a;
            }
            if (uiModule != null) {
                view = uiModule.k;
            }
            ViewGroup a2 = this.f9212a.a(this.c, view);
            if (uiModule != null && a2 == null && uiModule.k != null) {
                int a3 = this.f9212a.a(this.c);
                if (a3 < 0) {
                    a3 = this.f9212a.q();
                }
                a2 = (ViewGroup) uiModule.k.findViewById(a3);
            }
            if (a2 != null) {
                view = a2;
            }
            View b = this.f9212a.b(this.c, view);
            if (this.f9212a.j == null && b != null) {
                ViewParent parent = b.getParent();
                if (parent instanceof ViewGroup) {
                    a2 = (ViewGroup) parent;
                }
            }
            this.f9212a.b(b, a2);
            com.baidu.navisdk.util.worker.lite.b bVar = this.b.e;
            if (bVar != null) {
                com.baidu.navisdk.util.worker.lite.a.a(bVar);
            }
            this.b.e = new C0493a(this.f9212a.o() + "::continueLoad1", b, a2);
            if (z) {
                this.b.e.run();
            } else {
                com.baidu.navisdk.util.worker.lite.a.c(this.b.e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9214a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            f9214a = iArr;
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9214a[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9214a[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9214a[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9214a[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9214a[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ModularUiFrame(String str, @NonNull C c, View view) {
        ArrayMap<String, com.baidu.navisdk.uiframe.a> arrayMap = new ArrayMap<>();
        this.k = arrayMap;
        this.l = new ArrayMap<>();
        this.m = new ArrayMap<>();
        this.n = new HashSet<>();
        this.b = str;
        this.f = c;
        this.f9211a = c.h() + IXxxXO.f31153oxoX + str;
        UiModuleGroup<C> a2 = a(view);
        this.g = a2;
        com.baidu.navisdk.uiframe.a<C> aVar = new com.baidu.navisdk.uiframe.a<>();
        this.h = aVar;
        aVar.f9215a = a2;
        aVar.b = a2.p();
        arrayMap.put(a2.o(), aVar);
        c.a(str, this);
        getLifecycle().addObserver(a2);
    }

    private void b(String[] strArr, int i, com.baidu.navisdk.uiframe.a<C> aVar, boolean z, Configuration configuration) {
        if (aVar == null || aVar.f9215a == null) {
            return;
        }
        int a2 = aVar.a(i);
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e(this.f9211a, "loadModuleInner1 " + aVar.f9215a.o() + ":" + a2);
        }
        if (a2 == 0) {
            c(strArr, i, aVar, z, configuration);
        } else {
            if (a2 != 2) {
                return;
            }
            if (z) {
                aVar.f9215a.a(configuration);
            }
            a(strArr, i, aVar, z, configuration);
        }
    }

    private void c(String[] strArr, int i, com.baidu.navisdk.uiframe.a<C> aVar, boolean z, Configuration configuration) {
        boolean z2;
        String[] t = aVar.f9215a.t();
        boolean a2 = (t == null || t.length == 0) ? true : a(t, this.n);
        String[] w = aVar.f9215a.w();
        if (w == null) {
            z2 = false;
        } else {
            if (a(w, this.n)) {
                boolean z3 = Func.a.f6808a;
                a2 = true;
            }
            z2 = true;
        }
        aVar.b = aVar.b && z2;
        if (a2) {
            d(strArr, i, aVar, z, configuration);
        }
    }

    private void d(String[] strArr, int i, com.baidu.navisdk.uiframe.a<C> aVar, boolean z, Configuration configuration) {
        UiModule<C> uiModule = aVar.f9215a;
        if (uiModule == null) {
            return;
        }
        aVar.a(i, 1);
        com.baidu.navisdk.util.worker.lite.b bVar = aVar.d;
        if (bVar != null) {
            com.baidu.navisdk.util.worker.lite.a.a(bVar);
        }
        a aVar2 = new a(uiModule.o() + "::preload", uiModule, aVar, i, strArr, z, configuration);
        aVar.d = aVar2;
        if (aVar.b) {
            com.baidu.navisdk.util.worker.lite.a.b(aVar2, 10002);
        } else {
            aVar2.run();
        }
    }

    @Override // com.baidu.navisdk.apicenter.c
    public h a(@NonNull com.baidu.navisdk.apicenter.a aVar) {
        return null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void create() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f9211a, this.f9211a + "::Lifecycle: create --> isCreate = " + this.c);
        }
        if (!this.c) {
            if (LogUtil.LOGGABLE) {
                this.f.b(this.f9211a, "onCreate");
            }
            e();
            a(Lifecycle.Event.ON_CREATE);
            this.c = true;
            if (LogUtil.LOGGABLE) {
                this.f.a(this.f9211a, "onCreate");
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void destroy() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f9211a, this.f9211a + "::Lifecycle: destroy --> isStart = " + this.d);
        }
        if (this.d) {
            stop();
        }
        if (this.c) {
            if (LogUtil.LOGGABLE) {
                this.f.b(this.f9211a, "onDestroy");
            }
            a(Lifecycle.Event.ON_DESTROY);
            f();
            if (LogUtil.LOGGABLE) {
                this.f.a(this.f9211a, "onDestroy");
            }
            this.c = false;
        }
    }

    public void e() {
    }

    public void f() {
        this.f.a(this.b);
        a(1);
        this.l.clear();
        this.m.clear();
    }

    public void g() {
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.j;
    }

    public void h() {
    }

    public void i() {
    }

    public void j() {
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        switch (b.f9214a[event.ordinal()]) {
            case 1:
                create();
                return;
            case 2:
                start();
                return;
            case 3:
                resume();
                return;
            case 4:
                pause();
                return;
            case 5:
                stop();
                return;
            case 6:
                destroy();
                return;
            default:
                return;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void pause() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f9211a, this.f9211a + "::Lifecycle: pause --> isResume = " + this.e);
        }
        if (this.e) {
            if (LogUtil.LOGGABLE) {
                this.f.b(this.f9211a, "onPause");
            }
            a(Lifecycle.Event.ON_PAUSE);
            g();
            this.e = false;
            if (LogUtil.LOGGABLE) {
                this.f.a(this.f9211a, "onPause");
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void resume() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f9211a, this.f9211a + "::Lifecycle: resume --> isResume = " + this.e);
        }
        if (!this.d) {
            start();
        }
        if (!this.e) {
            if (LogUtil.LOGGABLE) {
                this.f.b(this.f9211a, "onResume");
            }
            h();
            a(Lifecycle.Event.ON_RESUME);
            this.e = true;
            if (LogUtil.LOGGABLE) {
                this.f.a(this.f9211a, "onResume");
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void start() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f9211a, this.f9211a + "::Lifecycle: start --> isStart = " + this.d);
        }
        if (!this.c) {
            create();
        }
        if (!this.d) {
            if (LogUtil.LOGGABLE) {
                this.f.b(this.f9211a, "onStart");
            }
            i();
            a(Lifecycle.Event.ON_START);
            this.d = true;
            if (LogUtil.LOGGABLE) {
                this.f.a(this.f9211a, "onStart");
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void stop() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f9211a, this.f9211a + "::Lifecycle: stop --> isStart = " + this.d);
        }
        if (this.e) {
            pause();
        }
        if (this.d) {
            if (LogUtil.LOGGABLE) {
                this.f.b(this.f9211a, "onStop");
            }
            a(Lifecycle.Event.ON_STOP);
            j();
            this.d = false;
            if (LogUtil.LOGGABLE) {
                this.f.a(this.f9211a, "onStop");
            }
        }
    }

    public UiModuleGroup<C> a(View view) {
        return (UiModuleGroup<C>) new UiModuleGroup<C>(this, this.f, view) { // from class: com.baidu.navisdk.uiframe.ModularUiFrame.1
            @Override // com.baidu.navisdk.framework.func.Func
            public String o() {
                return "ModularUi";
            }
        };
    }

    public final void a(UiModule uiModule) {
        this.g.a(uiModule);
        com.baidu.navisdk.uiframe.a<C> aVar = new com.baidu.navisdk.uiframe.a<>();
        aVar.f9215a = uiModule;
        aVar.b = uiModule.p();
        com.baidu.navisdk.uiframe.a<C> aVar2 = this.h;
        aVar.g = aVar2;
        aVar2.h.put(uiModule.o(), aVar);
        this.k.put(uiModule.o(), aVar);
        this.l.put(uiModule.o(), uiModule);
        this.m.put(uiModule.getClass(), uiModule);
    }

    public C b() {
        return this.f;
    }

    public <T extends UiModuleGroup<C>> T c() {
        return this.g;
    }

    public boolean d() {
        return this.g.u();
    }

    public final void a(UiModule uiModule, UiModule uiModule2) {
        if (uiModule2 instanceof UiModuleGroup) {
            ((UiModuleGroup) uiModule2).a(uiModule);
            com.baidu.navisdk.uiframe.a<C> aVar = this.k.get(uiModule2.o());
            if (aVar == null) {
                aVar = new com.baidu.navisdk.uiframe.a<>();
                aVar.f9215a = uiModule2;
                aVar.b = uiModule2.p();
                this.k.put(uiModule2.o(), aVar);
            }
            com.baidu.navisdk.uiframe.a<C> aVar2 = new com.baidu.navisdk.uiframe.a<>();
            aVar2.f9215a = uiModule;
            aVar2.b = uiModule.p();
            aVar2.g = aVar;
            aVar.h.put(uiModule.o(), aVar2);
            this.k.put(uiModule.o(), aVar2);
            this.l.put(uiModule.o(), uiModule);
            this.m.put(uiModule.getClass(), uiModule);
        }
    }

    public final void a(int i, String... strArr) {
        a(i, false, null, strArr);
    }

    public final void a(int i, boolean z, Configuration configuration, String... strArr) {
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e(this.f9211a, "loadModule: " + this.i + "->" + i);
        }
        if (this.i != i) {
            a(i);
            this.i = i;
        }
        if (strArr != null && strArr.length > 0) {
            this.n.addAll(Arrays.asList(strArr));
        }
        b(strArr, i, this.h, z, configuration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String[] strArr, int i, com.baidu.navisdk.uiframe.a<C> aVar, boolean z, Configuration configuration, View view, ViewGroup viewGroup) {
        if (aVar.a(i) == 1) {
            if (view != null) {
                aVar.f9215a.k = view;
            }
            if (viewGroup != null) {
                aVar.f9215a.j = viewGroup;
            }
            aVar.f9215a.m = i;
            if (viewGroup != null && view != null) {
                ViewParent parent = view.getParent();
                if (parent == null) {
                    viewGroup.addView(view);
                }
                if (parent != viewGroup && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(view);
                    viewGroup.addView(view);
                }
            }
            com.baidu.navisdk.uiframe.a<C> aVar2 = aVar.g;
            aVar.a(i, 2);
            if (!aVar.c) {
                UiModule<C> uiModule = aVar2 == null ? null : aVar2.f9215a;
                if (uiModule != null) {
                    uiModule.getLifecycle().addObserver(aVar.f9215a);
                } else {
                    getLifecycle().addObserver(aVar.f9215a);
                }
                aVar.f9215a.v();
            }
            aVar.c = true;
            if (z) {
                aVar.f9215a.a(configuration);
            }
            a(strArr, i, aVar, z, configuration);
        }
    }

    private void a(String[] strArr, int i, com.baidu.navisdk.uiframe.a<C> aVar, boolean z, Configuration configuration) {
        if (aVar == null || aVar.h.isEmpty()) {
            return;
        }
        Iterator<com.baidu.navisdk.uiframe.a<C>> it = aVar.h.values().iterator();
        while (it.hasNext()) {
            b(strArr, i, it.next(), z, configuration);
        }
    }

    private void a(int i) {
        if (this.h == null) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.offer(this.h);
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.baidu.navisdk.uiframe.a aVar = (com.baidu.navisdk.uiframe.a) linkedList.poll();
                if (aVar != null) {
                    aVar.b(i);
                    Iterator<com.baidu.navisdk.uiframe.a<C>> it = aVar.h.values().iterator();
                    while (it.hasNext()) {
                        linkedList.offer(it.next());
                    }
                }
            }
        }
    }

    public void a(int i, int i2, Intent intent) {
        this.g.a(i, i2, intent);
    }

    public void a(Configuration configuration, View view) {
        int i = configuration.orientation;
        this.g.k = view;
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e(this.f9211a, "onConfigurationChanged: " + configuration);
        }
        a(i, true, configuration, new String[0]);
    }

    @Nullable
    public <M extends UiModule<C>> M a(String str) {
        return (M) this.l.get(str);
    }

    private boolean a(String[] strArr, HashSet<String> hashSet) {
        if (strArr != null && strArr.length > 0 && hashSet != null && hashSet.size() != 0) {
            for (String str : strArr) {
                if (hashSet.contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(Lifecycle.Event event) {
        this.j.handleLifecycleEvent(event);
    }
}
