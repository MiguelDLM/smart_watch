package com.baidu.navisdk.b4nav.func.autorefresh;

import com.baidu.navisdk.b4nav.framework.func.CoreFunc;
import com.baidu.navisdk.framework.func.Func;
import com.baidu.navisdk.util.worker.lite.b;

/* loaded from: classes7.dex */
public class AutoRefreshFunc extends CoreFunc<com.baidu.navisdk.b4nav.framework.repository.a> {
    private boolean m;
    private final b n;

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public a() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        public String a() {
            return ((Func) AutoRefreshFunc.this).g;
        }
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        a(1002, new a());
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        super.h();
        this.m = false;
        com.baidu.navisdk.util.worker.lite.a.a(this.n);
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void l() {
        super.l();
        com.baidu.navisdk.util.worker.lite.a.a(this.n);
    }

    @Override // com.baidu.navisdk.framework.func.Func
    public String o() {
        return "AutoRefreshFunc";
    }
}
