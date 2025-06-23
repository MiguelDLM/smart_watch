package com.baidu.navisdk.pronavi.logic.service.ihighspeed;

import OXOo.OOXIXo;
import android.os.Bundle;
import android.os.Message;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.pronavi.data.model.d;
import com.baidu.navisdk.pronavi.logic.base.RGBaseLogicService;
import com.baidu.navisdk.pronavi.logic.base.a;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.statistic.userop.b;
import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class RGIHighSpeedService<C extends a> extends RGBaseLogicService<C> {
    private final d m;
    private String n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RGIHighSpeedService(@OOXIXo C context) {
        super(context);
        IIX0o.x0xO0oo(context, "context");
        this.n = "";
        this.m = (d) context.b(d.class);
    }

    private final String r() {
        Bundle bundle = new Bundle();
        boolean routeInfoInUniform = BNRouteGuider.getInstance().getRouteInfoInUniform(47, bundle);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "getIHighSpeedId(), bundle = " + bundle + ", " + routeInfoInUniform);
        }
        String string = bundle.getString(MapBundleKey.MapObjKey.OBJ_BID, "");
        IIX0o.oO(string, "bundle.getString(RGACEConst.ModelKey.BID, \"\")");
        return string;
    }

    private final void s() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "onEnterIHighSpeed, " + this.m.a().getValue());
        }
        this.n = r();
        b.r().a("11.0.3.1483", "0", this.n);
        d.a value = this.m.a().getValue();
        d.a aVar = d.a.ENTER;
        if (value != aVar) {
            this.m.a().setValue(aVar);
        }
    }

    private final void t() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "onExitIHighSpeed, " + this.m.a().getValue());
        }
        b.r().a("11.0.3.1483", "1", this.n);
        d.a value = this.m.a().getValue();
        d.a aVar = d.a.EXIT;
        if (value != aVar) {
            this.m.a().setValue(aVar);
        }
    }

    @Override // com.baidu.navisdk.pronavi.logic.base.RGBaseLogicService
    public void c(@OOXIXo Message msg) {
        IIX0o.x0xO0oo(msg, "msg");
        super.c(msg);
        if (msg.what == 4500 && msg.arg2 == 2252) {
            if (msg.arg1 == com.baidu.navisdk.module.ace.d.Area_Enter.ordinal()) {
                s();
            } else if (msg.arg1 == com.baidu.navisdk.module.ace.d.Area_Quit.ordinal()) {
                t();
            }
        }
    }

    @Override // com.baidu.navisdk.framework.func.Func
    @OOXIXo
    public String o() {
        return "RGIHighSpeedService";
    }

    @Override // com.baidu.navisdk.pronavi.logic.base.RGBaseLogicService
    @OOXIXo
    public int[] p() {
        return new int[]{4500};
    }
}
