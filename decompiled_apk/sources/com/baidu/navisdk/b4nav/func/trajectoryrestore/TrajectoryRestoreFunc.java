package com.baidu.navisdk.b4nav.func.trajectoryrestore;

import com.baidu.navisdk.b4nav.framework.func.CoreFunc;
import com.baidu.navisdk.b4nav.framework.repository.a;
import com.baidu.navisdk.framework.func.Func;

/* loaded from: classes7.dex */
public abstract class TrajectoryRestoreFunc<R extends com.baidu.navisdk.b4nav.framework.repository.a> extends CoreFunc<R> {

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public a() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        public String a() {
            return ((Func) TrajectoryRestoreFunc.this).g;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public b() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        public String a() {
            return ((Func) TrajectoryRestoreFunc.this).g;
        }
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        a(1002, new a());
        a(1003, new b());
    }

    @Override // com.baidu.navisdk.framework.func.Func
    public String o() {
        return "TrajectoryRestoreFunc";
    }
}
