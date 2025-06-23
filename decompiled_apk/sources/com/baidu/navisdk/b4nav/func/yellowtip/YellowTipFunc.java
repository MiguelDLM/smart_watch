package com.baidu.navisdk.b4nav.func.yellowtip;

import OXOo.OOXIXo;
import com.baidu.navisdk.b4nav.framework.func.CoreFunc;
import com.baidu.navisdk.framework.func.Func;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class YellowTipFunc extends CoreFunc<com.baidu.navisdk.b4nav.framework.repository.a> {

    /* loaded from: classes7.dex */
    public static final class a extends com.baidu.navisdk.b4nav.service.rpmsg.c {
        public a() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.c
        @OOXIXo
        public String a() {
            String TAG = ((Func) YellowTipFunc.this).g;
            IIX0o.oO(TAG, "TAG");
            return TAG;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public b() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        @OOXIXo
        public String a() {
            String TAG = ((Func) YellowTipFunc.this).g;
            IIX0o.oO(TAG, "TAG");
            return TAG;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends com.baidu.navisdk.b4nav.service.rpmsg.a {
        public c() {
        }

        @Override // com.baidu.navisdk.b4nav.service.rpmsg.a
        @OOXIXo
        public String a() {
            String TAG = ((Func) YellowTipFunc.this).g;
            IIX0o.oO(TAG, "TAG");
            return TAG;
        }
    }

    private final void r() {
        a(1000, new a());
        a(4001, new b());
        a(4007, new c());
    }

    @Override // com.baidu.navisdk.b4nav.framework.func.CoreFunc, com.baidu.navisdk.logicframe.LogicFunc, com.baidu.navisdk.framework.func.BaseFunc
    public void g() {
        super.g();
        r();
    }

    @Override // com.baidu.navisdk.framework.func.Func
    @OOXIXo
    public String o() {
        return "YellowTipFunc";
    }
}
