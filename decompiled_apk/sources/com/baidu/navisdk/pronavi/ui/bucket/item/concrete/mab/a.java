package com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab;

import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.ui.bucket.config.d;
import com.baidu.navisdk.pronavi.widget.RGImageTextBtn;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public class a extends b {
    public a(com.baidu.navisdk.pronavi.ui.base.b bVar, d dVar) {
        super(bVar, dVar, R.drawable.nsdk_drawable_switch_on_bridge, R.string.nsdk_string_rg_on_bridge, "BridgeOnUnderBtn");
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab.b
    public void A() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BridgeOnUnderBtn", "updateContent mType: " + this.l);
        }
        RGImageTextBtn v = v();
        if (v != null) {
            int i = this.l;
            if (i == 4) {
                v.setIcon(R.drawable.nsdk_drawable_switch_on_bridge);
                v.setTextContent(R.string.nsdk_string_rg_on_bridge);
            } else if (i == 8) {
                v.setIcon(R.drawable.nsdk_drawable_switch_under_bridge);
                v.setTextContent(R.string.nsdk_string_rg_under_bridge);
            }
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab.b
    public void a(com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BridgeOnUnderBtn", "handleClick: " + this.l);
        }
        int i = this.l;
        if (i == 4) {
            com.baidu.navisdk.util.statistic.userop.b.r().c("3.v.3.2");
        } else if (i == 8) {
            com.baidu.navisdk.util.statistic.userop.b.r().c("3.v.4.2");
        }
        aVar.a(this.l);
        this.l = -1;
        this.f7853a.j().e("RGBucketGroupComponent").a(1002).a();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab.b
    public int e(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BridgeOnUnderBtn", "convertToCorrespondingType: " + i);
        }
        if (i == 4 || i == 5 || i == 6) {
            return 4;
        }
        if (i == 8 || i == 10) {
            return 8;
        }
        return 0;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab.b
    public boolean f(int i) {
        return i == 4 || i == 8;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public String[] w() {
        return new String[]{"RGCommonWidget", "bridge"};
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public void x() {
        super.x();
        A();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab.b
    public String y() {
        int i = this.l;
        if (i == 4) {
            return "3.v.3.1";
        }
        if (i == 8) {
            return "3.v.4.1";
        }
        return null;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.concrete.mab.b
    public void z() {
        com.baidu.navisdk.pronavi.style.i.a aVar = this.e;
        if (aVar != null) {
            aVar.a("bridge");
        } else {
            A();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public String a(String str) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BridgeOnUnderBtn", "getHelperStyleViewKey mType: " + this.l + ",key: " + str);
        }
        if (!"RGAllStyleResId".equals(str)) {
            return str;
        }
        int i = this.l;
        return i == 4 ? "bridge_on" : i == 8 ? "bridge_under" : str;
    }
}
