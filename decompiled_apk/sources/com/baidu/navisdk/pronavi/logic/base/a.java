package com.baidu.navisdk.pronavi.logic.base;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.app.Activity;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.c;
import com.baidu.navisdk.model.modelfactory.f;
import com.baidu.navisdk.pageframe.store.b;
import com.baidu.navisdk.ui.routeguide.control.l;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public class a extends com.baidu.navisdk.pageframe.logic.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public a(@OOXIXo Activity activity, @OOXIXo com.baidu.navisdk.framework.data.a dataCenter, @OOXIXo b modelStore) {
        super(activity, "RGLogicContext", dataCenter, modelStore);
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(dataCenter, "dataCenter");
        IIX0o.x0xO0oo(modelStore, "modelStore");
    }

    @oOoXoXO
    public RoutePlanNode k() {
        com.baidu.navisdk.model.modelfactory.a a2 = c.a().a("RoutePlanModel");
        if (a2 != null) {
            f fVar = (f) a2;
            com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V, "BNavigator.getInstance()");
            com.baidu.navisdk.module.pronavi.model.f n = V.n();
            IIX0o.oO(n, "BNavigator.getInstance().navigatorModel");
            RoutePlanNode a3 = n.a();
            if (a3 == null) {
                com.baidu.navisdk.ui.routeguide.b V2 = com.baidu.navisdk.ui.routeguide.b.V();
                IIX0o.oO(V2, "BNavigator.getInstance()");
                com.baidu.navisdk.module.pronavi.model.f n2 = V2.n();
                IIX0o.oO(n2, "BNavigator.getInstance().navigatorModel");
                a3 = n2.b();
            }
            if (a3 == null) {
                l l = l.l();
                IIX0o.oO(l, "RGEngineControl.getInstance()");
                a3 = l.d();
            }
            if (a3 == null) {
                return fVar.g();
            }
            return a3;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.navisdk.model.modelfactory.RoutePlanModel");
    }

    @oOoXoXO
    public final k l() {
        return com.baidu.navisdk.framework.interfaces.c.p().k();
    }
}
