package com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.view.View;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.t;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class l extends com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a {
    private boolean b;
    private boolean c;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new a(null);
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.i.a
    public boolean a(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b uiContext, @OOXIXo View view, @oOoXoXO Object obj) {
        IIX0o.x0xO0oo(uiContext, "uiContext");
        IIX0o.x0xO0oo(view, "view");
        t s = t.s();
        IIX0o.oO(s, "RGMeteorModel.getInstance()");
        if (s.j()) {
            t.s().f();
        } else {
            t.s().a(uiContext.a());
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.e.2", null, null, null);
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a
    public boolean f() {
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.a
    public void g() {
        int i;
        int i2;
        t s = t.s();
        IIX0o.oO(s, "RGMeteorModel.getInstance()");
        boolean j = s.j();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGWeatherBtnWrap", "updateWeatherState need: " + j + ",last:" + this.b);
        }
        if (this.b == j) {
            return;
        }
        this.b = j;
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b = b();
        if (b != null) {
            if (j) {
                i2 = R.drawable.nsdk_drawable_common_ic_weather_selected;
            } else {
                i2 = R.drawable.nsdk_drawable_common_ic_weather;
            }
            b.a(i2);
        }
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b2 = b();
        if (b2 != null) {
            if (j) {
                i = R.color.nsdk_cl_text_g;
            } else {
                i = R.color.nsdk_cl_text_h;
            }
            b2.d(i);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.i.b
    public boolean a(@oOoXoXO com.baidu.navisdk.pronavi.ui.base.b bVar) {
        if (!com.baidu.navisdk.function.b.FUNC_WEATHER.a()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGWeatherBtnWrap", "visibility: not enable");
            }
            return false;
        }
        if (bVar != null && bVar.C()) {
            return false;
        }
        if (!this.c) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGWeatherBtnWrap", "not isHasWeatherData");
            }
            return false;
        }
        t s = t.s();
        IIX0o.oO(s, "RGMeteorModel.getInstance()");
        if (!s.l()) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGWeatherBtnWrap", "visibility: not open");
            }
            return false;
        }
        com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar4.d()) {
            gVar4.e("RGWeatherBtnWrap", "visibility: " + this.c);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a b = x.b();
        IIX0o.oO(b, "RGViewController.getInstance()");
        if (b.O2()) {
            if (gVar4.d()) {
                gVar4.e("RGWeatherBtnWrap", "visibility: isVdrGuide");
            }
            return false;
        }
        a0 I = a0.I();
        IIX0o.oO(I, "RGSimpleGuideModel.getInstance()");
        if (I.D()) {
            if (gVar4.d()) {
                gVar4.e("RGWeatherBtnWrap", "visibility: isYawing");
            }
            return false;
        }
        int p = bVar != null ? bVar.p() : 0;
        if (gVar4.d()) {
            gVar4.e("RGWeatherBtnWrap", "visibility: " + p);
        }
        if (p == 3) {
            return false;
        }
        if ((bVar != null && bVar.z()) || bVar == null || !bVar.d(RGFSMTable.FsmState.Fullview)) {
            return false;
        }
        if (gVar4.d()) {
            gVar4.e("RGWeatherBtnWrap", "visibility visible:" + bVar.n());
        }
        return true;
    }

    public final boolean a(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGWeatherBtnWrap", "updateByDataChangehasWeatherData: " + z + ", " + this.c);
        }
        if (this.c == z) {
            return false;
        }
        this.c = z;
        return true;
    }
}
