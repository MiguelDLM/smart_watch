package com.baidu.navisdk.logicframe;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.baidu.navisdk.framework.func.Func;
import com.baidu.navisdk.logicframe.b;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public class LogicFrame<C extends b> extends Func<C> {

    @OOXIXo
    private final a<C> j;

    @OOXIXo
    private final a<C> k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogicFrame(@OOXIXo C context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
        this.j = new a<>();
        this.k = new a<>();
    }

    public final void a(@oOoXoXO LogicService<C> logicService) {
        if (logicService == null) {
            return;
        }
        logicService.a(this.j);
        a<C> aVar = this.k;
        String o = logicService.o();
        IIX0o.oO(o, "service.funcName");
        aVar.a(o, logicService);
    }

    @Override // com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.framework.func.BaseFunc
    public void create() {
        Iterator<Map.Entry<String, Func<C>>> it = this.k.b().entrySet().iterator();
        while (it.hasNext()) {
            getLifecycle().addObserver(it.next().getValue());
        }
        Iterator<Map.Entry<String, Func<C>>> it2 = this.j.b().entrySet().iterator();
        while (it2.hasNext()) {
            getLifecycle().addObserver(it2.next().getValue());
        }
        super.create();
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        Iterator<Map.Entry<String, Func<C>>> it = this.k.b().entrySet().iterator();
        while (it.hasNext()) {
            getLifecycle().removeObserver(it.next().getValue());
        }
        Iterator<Map.Entry<String, Func<C>>> it2 = this.j.b().entrySet().iterator();
        while (it2.hasNext()) {
            getLifecycle().removeObserver(it2.next().getValue());
        }
        this.j.a();
        this.k.a();
        ((b) n()).d();
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public void i() {
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public void j() {
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public void k() {
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public void l() {
    }

    @Override // com.baidu.navisdk.framework.func.Func
    @OOXIXo
    public String o() {
        return "LogicFrame";
    }

    @OOXIXo
    public final a<C> p() {
        return this.j;
    }

    @OOXIXo
    public final a<C> q() {
        return this.k;
    }
}
