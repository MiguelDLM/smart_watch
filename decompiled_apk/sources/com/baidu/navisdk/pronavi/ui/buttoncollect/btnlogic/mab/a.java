package com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class a extends b {
    private int d = R.drawable.nsdk_drawable_switch_on_bridge;
    private int e = R.drawable.nsdk_drawable_switch_under_bridge;

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.b
    public boolean a(@oOoXoXO com.baidu.navisdk.ui.routeguide.subview.a aVar, @OOXIXo com.baidu.navisdk.pronavi.ui.base.b uiContext) {
        IIX0o.x0xO0oo(uiContext, "uiContext");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(i(), "handleClick: " + h());
        }
        if (h() == 4) {
            com.baidu.navisdk.util.statistic.userop.b.r().c("3.v.3.2");
        } else if (h() == 8) {
            com.baidu.navisdk.util.statistic.userop.b.r().c("3.v.4.2");
        }
        IIX0o.ooOOo0oXI(aVar);
        aVar.a(h());
        c(-1);
        uiContext.j().e("RGBucketGroupComponent").a(1002).a();
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.b
    public boolean b(int i) {
        return i == 4 || i == 8;
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.b
    @oOoXoXO
    public String j() {
        if (h() == 4) {
            return "3.v.3.1";
        }
        if (h() == 8) {
            return "3.v.4.1";
        }
        return null;
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.b
    public void k() {
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b = b();
        if (b != null) {
            if (h() == 4) {
                b.a(this.d);
                String string = JarUtils.getResources().getString(R.string.nsdk_string_rg_on_bridge);
                IIX0o.oO(string, "JarUtils.getResources().…nsdk_string_rg_on_bridge)");
                b.b(string);
                return;
            }
            if (h() == 8) {
                b.a(this.e);
                String string2 = JarUtils.getResources().getString(R.string.nsdk_string_rg_under_bridge);
                IIX0o.oO(string2, "JarUtils.getResources().…k_string_rg_under_bridge)");
                b.b(string2);
            }
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.b
    public int a(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(i(), "convertToCorrespondingType: " + i);
        }
        if (i == 4 || i == 5 || i == 6) {
            return 4;
        }
        return (i == 8 || i == 10) ? 8 : 0;
    }

    public final void a(int i, int i2) {
        if (i != 0) {
            this.d = i;
        }
        if (i2 != 0) {
            this.e = i2;
        }
        k();
    }
}
