package com.baidu.navisdk.b4nav.framework.func;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.navisdk.b4nav.b;
import com.baidu.navisdk.b4nav.c;
import com.baidu.navisdk.b4nav.framework.repository.a;
import com.baidu.navisdk.logicframe.LogicFunc;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public abstract class CoreFunc<R extends a> extends LogicFunc<c> {
    protected final R j;

    @NonNull
    protected final b k;
    protected volatile boolean l;

    public final void a(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.g, this.g + "::Lifecycle: earlyStopFunc --> isEarlyStop = " + this.l);
        }
        if (this.l) {
            return;
        }
        synchronized (this.b) {
            try {
                if (!this.l) {
                    if (LogUtil.LOGGABLE) {
                        c("onEarlyStop");
                    }
                    b(z);
                    this.l = true;
                    if (LogUtil.LOGGABLE) {
                        b("onEarlyStop");
                    }
                }
            } finally {
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

    @Override // com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        ((c) this.i).a(this.h, this);
    }

    @Override // com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        ((c) this.i).a(this.h);
        this.j.a();
    }

    @Override // com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void i() {
    }

    @Override // com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void j() {
    }

    @Override // com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void k() {
    }

    @Override // com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void l() {
    }

    @NonNull
    public R p() {
        return this.j;
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void pause() {
        super.pause();
    }

    @NonNull
    public final com.baidu.navisdk.apicenter.a q() {
        return ((c) this.i).j();
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
        this.l = false;
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void stop() {
        if (!this.l) {
            a(false);
        }
        super.stop();
    }

    public void a(int i, @NonNull com.baidu.navisdk.b4nav.service.rpmsg.a aVar) {
        q().e("RpMsgService").a(1).a(Integer.valueOf(i)).b(aVar).a();
    }

    public void a(int i, @NonNull com.baidu.navisdk.b4nav.service.rpmsg.c cVar) {
        q().e("RpMsgService").a(3).a(Integer.valueOf(i)).b(cVar).a();
    }

    public void a(int i, @NonNull com.baidu.navisdk.b4nav.service.rpmsg.b bVar) {
        q().e("RpMsgService").a(5).a(Integer.valueOf(i)).b(bVar).a();
    }
}
