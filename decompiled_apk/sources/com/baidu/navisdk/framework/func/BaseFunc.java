package com.baidu.navisdk.framework.func;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.b0;

/* loaded from: classes7.dex */
public abstract class BaseFunc implements LifecycleEventObserver, LifecycleOwner {

    /* renamed from: a, reason: collision with root package name */
    private final LifecycleRegistry f6806a = new LifecycleRegistry(this);
    protected final Object b = new Object();
    private final b0 c;
    protected volatile boolean d;
    protected volatile boolean e;
    protected volatile boolean f;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6807a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            f6807a = iArr;
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6807a[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6807a[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6807a[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6807a[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6807a[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public BaseFunc(Application application, b0 b0Var) {
        this.c = b0Var;
    }

    public void a(Lifecycle.Event event) {
        this.f6806a.handleLifecycleEvent(event);
    }

    public final void b(String str) {
        b0 b0Var;
        if (LogUtil.LOGGABLE && (b0Var = this.c) != null) {
            b0Var.a(m(), str);
        }
    }

    public final void c(String str) {
        b0 b0Var;
        if (LogUtil.LOGGABLE && (b0Var = this.c) != null) {
            b0Var.b(m(), str);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void create() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(m(), m() + "::Lifecycle: createFunc --> isCreate = " + this.d);
        }
        if (!this.d) {
            synchronized (this.b) {
                try {
                    if (!this.d) {
                        if (LogUtil.LOGGABLE) {
                            c("onCreate");
                        }
                        g();
                        a(Lifecycle.Event.ON_CREATE);
                        this.d = true;
                        if (LogUtil.LOGGABLE) {
                            b("onCreate");
                        }
                    }
                } finally {
                }
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void destroy() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(m(), m() + "::Lifecycle: destroyFunc --> isStart = " + this.e);
        }
        if (this.e) {
            stop();
        }
        if (this.d) {
            synchronized (this.b) {
                try {
                    if (this.d) {
                        if (LogUtil.LOGGABLE) {
                            c("onDestroy");
                        }
                        a(Lifecycle.Event.ON_DESTROY);
                        h();
                        if (LogUtil.LOGGABLE) {
                            b("onDestroy");
                        }
                        this.d = false;
                    }
                } finally {
                }
            }
        }
    }

    public abstract void g();

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.f6806a;
    }

    public abstract void h();

    public abstract void i();

    public abstract void j();

    public abstract void k();

    public abstract void l();

    public abstract String m();

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        switch (a.f6807a[event.ordinal()]) {
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
    public void pause() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(m(), m() + "::Lifecycle: pauseFunc --> isResume = " + this.f);
        }
        if (this.f) {
            synchronized (this.b) {
                try {
                    if (this.f) {
                        if (LogUtil.LOGGABLE) {
                            c("onPause");
                        }
                        a(Lifecycle.Event.ON_PAUSE);
                        i();
                        this.f = false;
                        if (LogUtil.LOGGABLE) {
                            b("onPause");
                        }
                    }
                } finally {
                }
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void resume() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(m(), m() + "::Lifecycle: resumeFunc --> isResume = " + this.f);
        }
        if (!this.e) {
            start();
        }
        if (!this.f) {
            synchronized (this.b) {
                try {
                    if (!this.f) {
                        if (LogUtil.LOGGABLE) {
                            c("onResume");
                        }
                        j();
                        a(Lifecycle.Event.ON_RESUME);
                        this.f = true;
                        if (LogUtil.LOGGABLE) {
                            b("onResume");
                        }
                    }
                } finally {
                }
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void start() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(m(), m() + "::Lifecycle: startFunc --> isStart = " + this.e);
        }
        if (!this.d) {
            create();
        }
        if (!this.e) {
            synchronized (this.b) {
                try {
                    if (!this.e) {
                        if (LogUtil.LOGGABLE) {
                            c("onStart");
                        }
                        k();
                        a(Lifecycle.Event.ON_START);
                        this.e = true;
                        if (LogUtil.LOGGABLE) {
                            b("onStart");
                        }
                    }
                } finally {
                }
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void stop() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(m(), m() + "::Lifecycle: stopFunc --> isStart = " + this.e);
        }
        if (this.f) {
            pause();
        }
        if (this.e) {
            synchronized (this.b) {
                try {
                    if (this.e) {
                        if (LogUtil.LOGGABLE) {
                            c("onStop");
                        }
                        a(Lifecycle.Event.ON_STOP);
                        l();
                        this.e = false;
                        if (LogUtil.LOGGABLE) {
                            b("onStop");
                        }
                    }
                } finally {
                }
            }
        }
    }
}
