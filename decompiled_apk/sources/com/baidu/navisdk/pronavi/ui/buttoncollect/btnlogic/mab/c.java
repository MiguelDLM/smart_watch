package com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class c extends b {
    private int d = R.drawable.nsdk_drawable_switch_main_road;
    private int e = R.drawable.nsdk_drawable_switch_auxiliary_road;

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

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.b
    public int a(int i) {
        if (i == 1) {
            return 1;
        }
        if (i != 2) {
            if (i == 5) {
                return 1;
            }
            if (i != 6 && i != 10) {
                return 0;
            }
        }
        return 2;
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.b
    public boolean b(int i) {
        return i == 1 || i == 2;
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.b
    @oOoXoXO
    public String j() {
        if (h() == 1) {
            return "3.v.1.1";
        }
        if (h() == 2) {
            return "3.v.2.1";
        }
        return null;
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.b
    public void k() {
        com.baidu.navisdk.pronavi.ui.buttoncollect.data.a b = b();
        if (b != null) {
            if (h() == 1) {
                b.a(this.d);
                String string = JarUtils.getResources().getString(R.string.nsdk_string_rg_in_main_road);
                IIX0o.oO(string, "JarUtils.getResources().…k_string_rg_in_main_road)");
                b.b(string);
                return;
            }
            if (h() == 2) {
                b.a(this.e);
                String string2 = JarUtils.getResources().getString(R.string.nsdk_string_rg_in_auxiliary_road);
                IIX0o.oO(string2, "JarUtils.getResources().…ing_rg_in_auxiliary_road)");
                b.b(string2);
            }
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.mab.b
    public boolean a(@oOoXoXO com.baidu.navisdk.ui.routeguide.subview.a aVar, @OOXIXo com.baidu.navisdk.pronavi.ui.base.b uiContext) {
        IIX0o.x0xO0oo(uiContext, "uiContext");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMainAuxiliaryBtnLogic", "handleClick: " + h());
        }
        if (h() == 1) {
            com.baidu.navisdk.util.statistic.userop.b.r().c("3.v.1.2");
        } else if (h() == 2) {
            com.baidu.navisdk.util.statistic.userop.b.r().c("3.v.2.2");
        }
        if (aVar != null && h() != -1) {
            aVar.a(h());
        }
        c(-1);
        uiContext.j().e("RGBucketGroupComponent").a(1001).a();
        return true;
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
