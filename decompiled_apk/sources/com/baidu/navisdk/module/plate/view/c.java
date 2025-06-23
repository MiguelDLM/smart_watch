package com.baidu.navisdk.module.plate.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.module.plate.adapter.a;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.y;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class c extends com.baidu.navisdk.module.plate.view.b<d> implements a.d {
    private final Context E;
    private ArrayList<com.baidu.navisdk.module.plate.base.a> F;
    private ArrayList<com.baidu.navisdk.module.plate.base.a> G;
    private com.baidu.navisdk.module.plate.c H;
    private com.baidu.navisdk.module.plate.adapter.a I;

    /* loaded from: classes7.dex */
    public class a implements com.baidu.navisdk.module.plate.c {
        public a(c cVar) {
        }
    }

    /* loaded from: classes7.dex */
    public class b implements com.baidu.navisdk.framework.interfaces.account.a {
        public b(c cVar) {
        }
    }

    public c(Context context, d dVar) {
        super(context, dVar);
        this.E = context;
    }

    private void q() {
        this.H = new a(this);
    }

    private void r() {
        com.baidu.navisdk.framework.b.a((com.baidu.navisdk.framework.interfaces.account.a) new b(this));
    }

    private void s() {
        if (y.d(this.E)) {
            Bundle bundle = new Bundle();
            bundle.putInt("vehicle_type", 1);
            bundle.putInt("electric_plate_type", 1);
            com.baidu.navisdk.framework.b.c(bundle, this.H);
            return;
        }
        TipTool.onCreateToastDialog(this.E, "网络异常，请稍后再试");
    }

    @Override // com.baidu.navisdk.module.plate.view.b, com.baidu.navisdk.module.routeresult.ui.a
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // com.baidu.navisdk.module.plate.adapter.a.d
    public void c() {
        g gVar = g.CAR_PLATE;
        if (gVar.d()) {
            gVar.e("NewEnergyLimitSettingView", "gotoAddCarPage: ");
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("11.9.8", String.valueOf(this.q), null, null);
        if (!com.baidu.navisdk.framework.b.e0()) {
            r();
            return;
        }
        c(true);
        if (this.B != null) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("11.9.1", null, null, null);
            this.B.a(1, 0, null);
        }
    }

    @Override // com.baidu.navisdk.module.plate.view.b, com.baidu.navisdk.module.routeresult.ui.a
    public void i() {
        super.i();
        com.baidu.navisdk.module.plate.adapter.a aVar = this.I;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.baidu.navisdk.module.plate.view.b, com.baidu.navisdk.module.routeresult.ui.a
    public void k() {
        super.k();
        e(1);
        q();
        s();
        f(1);
        g(1);
    }

    @Override // com.baidu.navisdk.module.plate.adapter.a.d
    public void a(String str) {
        com.baidu.navisdk.util.statistic.userop.b.r().a("11.9.7", String.valueOf(this.q), null, null);
        if (this.B != null) {
            c(true);
            Bundle bundle = new Bundle();
            if (!com.baidu.navisdk.framework.b.e0()) {
                ArrayList<com.baidu.navisdk.module.plate.base.a> arrayList = this.G;
                if (arrayList != null && arrayList.size() > 0) {
                    bundle.putParcelable("limit_plate_info", this.G.get(0));
                }
            } else {
                for (int i = 0; i < this.F.size(); i++) {
                    com.baidu.navisdk.module.plate.base.a aVar = this.F.get(i);
                    if (TextUtils.equals(str, aVar.g())) {
                        bundle.putParcelable("limit_plate_info", aVar);
                    }
                }
            }
            this.B.a(1, 0, bundle);
        }
    }
}
