package com.baidu.navisdk.b4nav.framework.service;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.navisdk.b4nav.c;
import com.baidu.navisdk.logicframe.LogicService;
import com.baidu.navisdk.util.common.LogUtil;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public abstract class CoreService extends LogicService<c> {
    private volatile boolean k;

    public final void a(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.g, this.g + "::Lifecycle: earlyStopFunc --> isEarlyStop = " + this.k);
        }
        if (!this.k) {
            Object lock = this.b;
            IIX0o.oO(lock, "lock");
            synchronized (lock) {
                try {
                    if (!this.k) {
                        if (LogUtil.LOGGABLE) {
                            c("onEarlyStop");
                        }
                        b(z);
                        this.k = true;
                        if (LogUtil.LOGGABLE) {
                            b("onEarlyStop");
                        }
                    }
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void b(boolean z) {
    }

    @Override // com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.framework.func.BaseFunc
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void create() {
        super.create();
    }

    @Override // com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.framework.func.BaseFunc
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void destroy() {
        super.destroy();
    }

    @Override // com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        ((c) this.i).a(this.h, this);
    }

    @Override // com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
    }

    @Override // com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void i() {
    }

    @Override // com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void j() {
    }

    @Override // com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void k() {
    }

    @Override // com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void l() {
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void pause() {
        super.pause();
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void resume() {
        super.resume();
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void start() {
        super.start();
        this.k = false;
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void stop() {
        if (!this.k) {
            a(false);
        }
        super.stop();
    }
}
