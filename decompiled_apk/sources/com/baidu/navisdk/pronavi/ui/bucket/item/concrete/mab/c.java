package com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab;

import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.ui.bucket.config.d;
import com.baidu.navisdk.pronavi.widget.RGImageTextBtn;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public class c extends b {
    public c(com.baidu.navisdk.pronavi.ui.base.b bVar, d dVar) {
        super(bVar, dVar, R.drawable.nsdk_drawable_switch_main_road, R.string.nsdk_string_rg_in_main_road, "MainAuxiliaryRoadBtn");
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab.b
    public void A() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("MainAuxiliaryRoadBtn", "updateContent mType: " + this.l);
        }
        RGImageTextBtn v = v();
        if (v != null) {
            int i = this.l;
            if (i == 1) {
                v.setIcon(R.drawable.nsdk_drawable_switch_main_road);
                v.setTextContent(R.string.nsdk_string_rg_in_main_road);
            } else if (i == 2) {
                v.setIcon(R.drawable.nsdk_drawable_switch_auxiliary_road);
                v.setTextContent(R.string.nsdk_string_rg_in_auxiliary_road);
            }
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab.b
    public void a(com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        int i;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("MainAuxiliaryRoadBtn", "handleClick: " + this.l);
        }
        int i2 = this.l;
        if (i2 == 1) {
            com.baidu.navisdk.util.statistic.userop.b.r().c("3.v.1.2");
        } else if (i2 == 2) {
            com.baidu.navisdk.util.statistic.userop.b.r().c("3.v.2.2");
        }
        if (aVar != null && (i = this.l) != -1) {
            aVar.a(i);
        }
        this.l = -1;
        this.f7853a.j().e("RGBucketGroupComponent").a(1001).a();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab.b
    public int e(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("MainAuxiliaryRoadBtn", "convertToCorrespondingType: " + i);
        }
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

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab.b
    public boolean f(int i) {
        return i == 1 || i == 2;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public String[] w() {
        return new String[]{"RGCommonWidget", "road"};
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public void x() {
        super.x();
        A();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab.b
    public String y() {
        int i = this.l;
        if (i == 1) {
            return "3.v.1.1";
        }
        if (i == 2) {
            return "3.v.2.1";
        }
        return null;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab.b
    public void z() {
        com.baidu.navisdk.pronavi.style.i.a aVar = this.e;
        if (aVar != null) {
            aVar.a("road");
        } else {
            A();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public String a(String str) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("MainAuxiliaryRoadBtn", "getHelperStyleViewKey mType: " + this.l + ",key: " + str);
        }
        if (!"RGAllStyleResId".equals(str)) {
            return str;
        }
        int i = this.l;
        return i == 1 ? "main_road" : i == 2 ? "road_auxiliary" : str;
    }
}
