package com.baidu.navisdk.context.life;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public class LifeContext extends com.baidu.navisdk.context.business.a implements LifecycleOwner, LifecycleEventObserver {
    private final LifecycleRegistry f;
    protected volatile boolean g;
    protected volatile boolean h;
    protected volatile boolean i;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6763a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            f6763a = iArr;
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6763a[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6763a[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6763a[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6763a[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6763a[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public void a(Lifecycle.Event event) {
        this.f.handleLifecycleEvent(event);
    }

    @MainThread
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void create() {
        g gVar = g.B4NAV;
        if (gVar.e()) {
            gVar.g(k(), k() + "::Lifecycle::create! isCreate = " + this.g);
        }
        if (!this.g) {
            if (gVar.d()) {
                b(k(), "Lifecycle", "onCreate");
            }
            if (gVar.b()) {
                gVar.f(k() + "::Lifecycle::onCreate");
            }
            l();
            a(Lifecycle.Event.ON_CREATE);
            this.g = true;
            if (gVar.d()) {
                a(k(), "Lifecycle", "onCreate");
            }
        }
    }

    @Override // com.baidu.navisdk.context.business.a, com.baidu.navisdk.context.d
    public void d() {
        super.d();
    }

    @MainThread
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void destroy() {
        g gVar = g.B4NAV;
        if (gVar.e()) {
            gVar.g(k(), k() + "::Lifecycle::destroy! isStart = " + this.h + ", isCreate = " + this.g);
        }
        if (this.h) {
            stop();
        }
        if (this.g) {
            if (LogUtil.LOGGABLE) {
                b(k(), "Lifecycle", "onDestroy");
            }
            if (gVar.b()) {
                gVar.f(k() + "::Lifecycle::onDestroy");
            }
            a(Lifecycle.Event.ON_DESTROY);
            m();
            d();
            this.g = false;
            if (LogUtil.LOGGABLE) {
                a(k(), "Lifecycle", "onDestroy");
            }
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.f;
    }

    public String k() {
        return "LifeContext";
    }

    @MainThread
    public void l() {
    }

    @MainThread
    public void m() {
    }

    @MainThread
    public void n() {
    }

    @MainThread
    public void o() {
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        switch (a.f6763a[event.ordinal()]) {
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

    @MainThread
    public void p() {
    }

    @MainThread
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void pause() {
        g gVar = g.B4NAV;
        if (gVar.e()) {
            gVar.g(k(), k() + "::Lifecycle::pause! isResume = " + this.i);
        }
        if (this.i) {
            if (LogUtil.LOGGABLE) {
                b(k(), "Lifecycle", "onPause");
            }
            if (gVar.b()) {
                gVar.f(k() + "::Lifecycle::onPause");
            }
            a(Lifecycle.Event.ON_PAUSE);
            n();
            this.i = false;
            if (LogUtil.LOGGABLE) {
                a(k(), "Lifecycle", "onPause");
            }
        }
    }

    @MainThread
    public void q() {
    }

    @MainThread
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void resume() {
        g gVar = g.B4NAV;
        if (gVar.e()) {
            gVar.g(k(), k() + "::Lifecycle::resume! isStart = " + this.h + ", isResume = " + this.i);
        }
        if (!this.h) {
            start();
        }
        if (!this.i) {
            if (LogUtil.LOGGABLE) {
                b(k(), "Lifecycle", "onResume");
            }
            if (gVar.b()) {
                gVar.f(k() + "::Lifecycle::onResume");
            }
            o();
            a(Lifecycle.Event.ON_RESUME);
            this.i = true;
            if (LogUtil.LOGGABLE) {
                a(k(), "Lifecycle", "onResume");
            }
        }
    }

    @MainThread
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void start() {
        g gVar = g.B4NAV;
        if (gVar.e()) {
            gVar.g(k(), k() + "::Lifecycle::start! isCreate = " + this.g + ", isStart = " + this.h);
        }
        if (!this.g) {
            create();
        }
        if (!this.h) {
            if (gVar.d()) {
                b(k(), "Lifecycle", "onStart");
            }
            if (gVar.b()) {
                gVar.f(k() + "::Lifecycle::onStart");
            }
            p();
            a(Lifecycle.Event.ON_START);
            this.h = true;
            if (gVar.d()) {
                a(k(), "Lifecycle", "onStart");
            }
        }
    }

    @MainThread
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void stop() {
        g gVar = g.B4NAV;
        if (gVar.e()) {
            gVar.g(k(), k() + "::Lifecycle::stop! isResume = " + this.i + ", isStart = " + this.h);
        }
        if (this.i) {
            pause();
        }
        if (this.h) {
            if (LogUtil.LOGGABLE) {
                b(k(), "Lifecycle", "onStop");
            }
            if (gVar.b()) {
                gVar.f(k() + "::Lifecycle::onStop");
            }
            a(Lifecycle.Event.ON_STOP);
            q();
            this.h = false;
            if (LogUtil.LOGGABLE) {
                a(k(), "Lifecycle", "onStop");
            }
        }
    }
}
