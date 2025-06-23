package com.baidu.navisdk.b4nav.func.aoi;

import com.baidu.navisdk.b4nav.framework.func.CoreFunc;
import com.baidu.navisdk.framework.func.Func;

/* loaded from: classes7.dex */
public class AoiFunc extends CoreFunc<com.baidu.navisdk.b4nav.framework.repository.a> {

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public a() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        public int a(int i) {
            return Integer.MAX_VALUE;
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        public String a() {
            return ((Func) AoiFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public b() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        public int a(int i) {
            return Integer.MAX_VALUE;
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        public String a() {
            return ((Func) AoiFunc.this).g;
        }
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        a(1000, new a());
        a(4001, new b());
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void k() {
        super.k();
        this.k.i();
        throw null;
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void l() {
        super.l();
        this.k.n();
        throw null;
    }

    @Override // com.baidu.navisdk.framework.func.Func
    public String o() {
        return "AoiFunc";
    }
}
