package com.baidu.navisdk.logicframe;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.baidu.navisdk.framework.func.Func;
import com.baidu.navisdk.logicframe.b;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public abstract class LogicService<C extends b> extends Func<C> {

    @OOXIXo
    private a<C> j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogicService(@OOXIXo C context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
        this.j = new a<>();
    }

    public final void a(@OOXIXo a<C> aVar) {
        IIX0o.x0xO0oo(aVar, "<set-?>");
        this.j = aVar;
    }

    @oOoXoXO
    public final <T extends LogicFunc<C>> T d(@OOXIXo String tag) {
        IIX0o.x0xO0oo(tag, "tag");
        return (T) this.j.a(tag);
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
    }

    @Override // com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
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
}
