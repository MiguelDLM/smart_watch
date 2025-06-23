package com.baidu.navisdk.b4nav.func.exttab;

import androidx.annotation.NonNull;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.b4nav.framework.func.CoreFunc;
import com.baidu.navisdk.framework.func.Func;

/* loaded from: classes7.dex */
public class RouteExtTabFunc extends CoreFunc<Object> {

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public a() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        public String a() {
            return ((Func) RouteExtTabFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public b() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        public String a() {
            return ((Func) RouteExtTabFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public c() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        public String a() {
            return ((Func) RouteExtTabFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class d extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public d() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        public String a() {
            return ((Func) RouteExtTabFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class e extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public e() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        public String a() {
            return ((Func) RouteExtTabFunc.this).g;
        }
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        a(1000, new a());
        a(1002, new b());
        a(1001, new c());
        a(1003, new d());
        a(4007, new e());
    }

    @Override // com.baidu.navisdk.framework.func.Func
    public String o() {
        return "RouteExtTab";
    }

    public void a(int i) {
        this.k.e();
        throw null;
    }

    @Override // com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.apicenter.c
    public h a(@NonNull com.baidu.navisdk.apicenter.a aVar) {
        if (aVar.d() != 1) {
            return super.a(aVar);
        }
        a(aVar.c("paramA"));
        throw null;
    }
}
