package com.baidu.navisdk.b4nav.framework;

import androidx.lifecycle.Lifecycle;
import com.baidu.navisdk.b4nav.framework.context.a;
import com.baidu.navisdk.b4nav.framework.func.CoreFunc;
import com.baidu.navisdk.b4nav.framework.service.CoreService;
import com.baidu.navisdk.framework.interfaces.b;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.framework.message.bean.u;
import com.baidu.navisdk.logicframe.LogicFrame;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public class B4NavEngine<C extends com.baidu.navisdk.b4nav.framework.context.a> extends LogicFrame<C> {
    private volatile boolean l;
    private final ArrayList<Object> m;
    private final ArrayList<com.baidu.navisdk.framework.interfaces.b4nav.a> n;
    private final b o;
    private final com.baidu.navisdk.util.worker.lite.b p;
    private final a.InterfaceC0201a q;

    /* JADX WARN: Multi-variable type inference failed */
    private final void b(boolean z) {
        g gVar = g.B4NAV;
        if (gVar.e()) {
            gVar.g(this.g, this.g + "::Lifecycle::earlyStop!");
        }
        if (gVar.b()) {
            gVar.f(this.g + "::Lifecycle::onEarlyStop");
        }
        if (gVar.b()) {
            com.baidu.navisdk.b4nav.framework.context.a aVar = (com.baidu.navisdk.b4nav.framework.context.a) n();
            String TAG = this.g;
            IIX0o.oO(TAG, "TAG");
            aVar.b(TAG, "Lifecycle", "onEarlyStop");
        }
        com.baidu.navisdk.util.worker.lite.a.a(this.p);
        c(z);
        a(z);
        d(z);
        if (gVar.b()) {
            com.baidu.navisdk.b4nav.framework.context.a aVar2 = (com.baidu.navisdk.b4nav.framework.context.a) n();
            String TAG2 = this.g;
            IIX0o.oO(TAG2, "TAG");
            aVar2.a(TAG2, "Lifecycle", "onEarlyStop");
        }
    }

    private final void c(boolean z) {
        for (Map.Entry entry : q().b().entrySet()) {
            if (entry.getValue() instanceof CoreService) {
                Object value = entry.getValue();
                if (value != null) {
                    ((CoreService) value).a(z);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.navisdk.b4nav.framework.service.CoreService");
                }
            }
        }
        for (Map.Entry entry2 : p().b().entrySet()) {
            if (entry2.getValue() instanceof CoreFunc) {
                Object value2 = entry2.getValue();
                if (value2 != null) {
                    ((CoreFunc) value2).a(z);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.navisdk.b4nav.framework.func.CoreFunc<*>");
                }
            }
        }
    }

    private final void d(boolean z) {
        ArrayList arrayList;
        synchronized (this.n) {
            arrayList = new ArrayList(this.n);
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((com.baidu.navisdk.framework.interfaces.b4nav.a) it.next()).a();
        }
    }

    private final void e(boolean z) {
        if (!this.l) {
            synchronized (this) {
                try {
                    if (!this.l) {
                        b(z);
                        this.l = true;
                    }
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private final void r() {
        com.baidu.navisdk.framework.message.a.a().a(this.q, u.class, new Class[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s() {
        if (com.baidu.navisdk.module.init.a.a()) {
            com.baidu.navisdk.util.worker.lite.a.a(this.p, 10002);
            return;
        }
        com.baidu.navisdk.b4nav.a aVar = (com.baidu.navisdk.b4nav.a) ((com.baidu.navisdk.b4nav.framework.context.a) n()).a(com.baidu.navisdk.b4nav.a.class);
        if (aVar != null) {
            com.baidu.navisdk.b4nav.framework.context.a context = (com.baidu.navisdk.b4nav.framework.context.a) n();
            IIX0o.oO(context, "context");
            aVar.a(context.a(), this.o);
        } else {
            com.baidu.navisdk.b4nav.framework.context.a context2 = (com.baidu.navisdk.b4nav.framework.context.a) n();
            IIX0o.oO(context2, "context");
            com.baidu.navisdk.framework.b.a(context2.a(), this.o);
        }
    }

    private final void t() {
        com.baidu.navisdk.framework.message.a.a().a(this.q);
    }

    public void a(boolean z) {
    }

    @Override // com.baidu.navisdk.logicframe.LogicFrame, com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.framework.func.BaseFunc
    public final void create() {
        super.create();
    }

    @Override // com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.framework.func.BaseFunc
    public final void destroy() {
        synchronized (this.m) {
            this.m.clear();
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        }
        synchronized (this.n) {
            this.n.clear();
        }
        super.destroy();
    }

    @Override // com.baidu.navisdk.logicframe.LogicFrame, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
    }

    @Override // com.baidu.navisdk.logicframe.LogicFrame, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
    }

    @Override // com.baidu.navisdk.logicframe.LogicFrame, com.baidu.navisdk.framework.func.BaseFunc
    public void i() {
        super.i();
    }

    @Override // com.baidu.navisdk.logicframe.LogicFrame, com.baidu.navisdk.framework.func.BaseFunc
    public void j() {
        super.j();
    }

    @Override // com.baidu.navisdk.logicframe.LogicFrame, com.baidu.navisdk.framework.func.BaseFunc
    public void k() {
        super.k();
    }

    @Override // com.baidu.navisdk.logicframe.LogicFrame, com.baidu.navisdk.framework.func.BaseFunc
    public void l() {
        super.l();
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public final void pause() {
        super.pause();
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public final void resume() {
        super.resume();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public final void start() {
        if (!this.d) {
            create();
        }
        com.baidu.navisdk.framework.message.a.a().d(new u(((com.baidu.navisdk.b4nav.framework.context.a) n()).o(), ((com.baidu.navisdk.b4nav.framework.context.a) n()).n(), this));
        if (!this.e) {
            g gVar = g.B4NAV;
            if (gVar.e()) {
                gVar.g(this.g, this.g + "::Lifecycle::start!");
            }
            if (gVar.b()) {
                gVar.f(this.g + "::Lifecycle::onStart");
            }
            if (LogUtil.LOGGABLE) {
                com.baidu.navisdk.b4nav.framework.context.a aVar = (com.baidu.navisdk.b4nav.framework.context.a) n();
                String TAG = this.g;
                IIX0o.oO(TAG, "TAG");
                aVar.b(TAG, "Lifecycle", "onStart");
            }
            this.l = false;
            r();
            k();
            a(Lifecycle.Event.ON_START);
            this.e = true;
            if (LogUtil.LOGGABLE) {
                com.baidu.navisdk.b4nav.framework.context.a aVar2 = (com.baidu.navisdk.b4nav.framework.context.a) n();
                String TAG2 = this.g;
                IIX0o.oO(TAG2, "TAG");
                aVar2.a(TAG2, "Lifecycle", "onStart");
            }
            s();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public final void stop() {
        if (this.f) {
            pause();
        }
        if (this.e) {
            e(false);
            g gVar = g.B4NAV;
            if (gVar.e()) {
                gVar.g(this.g, this.g + "::Lifecycle::stop!");
            }
            if (gVar.b()) {
                gVar.f(this.g + "::Lifecycle::onStop");
            }
            if (LogUtil.LOGGABLE) {
                com.baidu.navisdk.b4nav.framework.context.a aVar = (com.baidu.navisdk.b4nav.framework.context.a) n();
                String TAG = this.g;
                IIX0o.oO(TAG, "TAG");
                aVar.b(TAG, "Lifecycle", "onStop");
            }
            a(Lifecycle.Event.ON_STOP);
            l();
            t();
            this.e = false;
            if (LogUtil.LOGGABLE) {
                com.baidu.navisdk.b4nav.framework.context.a aVar2 = (com.baidu.navisdk.b4nav.framework.context.a) n();
                String TAG2 = this.g;
                IIX0o.oO(TAG2, "TAG");
                aVar2.a(TAG2, "Lifecycle", "onStop");
            }
        }
    }
}
