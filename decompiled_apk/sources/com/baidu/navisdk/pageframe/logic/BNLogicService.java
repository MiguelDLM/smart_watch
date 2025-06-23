package com.baidu.navisdk.pageframe.logic;

import OXOo.OOXIXo;
import com.baidu.navisdk.logicframe.LogicService;
import com.baidu.navisdk.logicframe.b;
import com.baidu.navisdk.util.common.g;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public abstract class BNLogicService<C extends b> extends LogicService<C> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BNLogicService(@OOXIXo C context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
    }

    @Override // com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        g gVar = g.F_BASE;
        if (gVar.d()) {
            gVar.e(this.g, "onCreate");
        }
    }

    @Override // com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        g gVar = g.F_BASE;
        if (gVar.d()) {
            gVar.e(this.g, "onDestroy");
        }
    }

    @Override // com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void i() {
        g gVar = g.F_BASE;
        if (gVar.d()) {
            gVar.e(this.g, "onPause");
        }
    }

    @Override // com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void j() {
        g gVar = g.F_BASE;
        if (gVar.d()) {
            gVar.e(this.g, "onResume");
        }
    }

    @Override // com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void k() {
        g gVar = g.F_BASE;
        if (gVar.d()) {
            gVar.e(this.g, "onStart");
        }
    }

    @Override // com.baidu.navisdk.logicframe.LogicService, com.baidu.navisdk.framework.func.BaseFunc
    public void l() {
        g gVar = g.F_BASE;
        if (gVar.d()) {
            gVar.e(this.g, "onStop");
        }
    }
}
