package com.baidu.navisdk.b4nav.func.newengowner;

import com.baidu.navisdk.b4nav.framework.func.CoreFunc;
import com.baidu.navisdk.b4nav.framework.repository.a;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.framework.message.bean.o;
import com.baidu.navisdk.framework.message.bean.p;
import com.baidu.navisdk.util.worker.lite.b;

/* loaded from: classes7.dex */
public class NewEngOwnerFunc extends CoreFunc<a> {
    private final a.InterfaceC0201a m;
    private final b n;

    private void r() {
        com.baidu.navisdk.util.worker.lite.a.a(this.n, 10002);
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void k() {
        super.k();
        com.baidu.navisdk.framework.message.a.a().b(this.m, o.class, p.class);
        r();
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void l() {
        super.l();
        com.baidu.navisdk.framework.message.a.a().a(this.m);
        com.baidu.navisdk.util.worker.lite.a.a(this.n);
    }

    @Override // com.baidu.navisdk.framework.func.Func
    public String o() {
        return "NewEngOwnerFunc";
    }
}
