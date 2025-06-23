package com.baidu.navisdk.module.trucknavi.view.support.module.perimeter.views;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.b0;
import com.baidu.navisdk.module.trucknavi.view.support.module.perimeter.views.PerimeterPageTabs;
import com.baidu.navisdk.ui.util.g;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public class a implements b0, View.OnClickListener, PerimeterPageTabs.b {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.module.trucknavi.view.support.module.perimeter.interfaces.a f7587a;
    private Activity b;

    private boolean C() {
        return g.a(300L);
    }

    @Override // com.baidu.navisdk.module.trucknavi.view.support.module.perimeter.views.PerimeterPageTabs.b
    public void a(int i, int i2, boolean z) {
        com.baidu.navisdk.module.trucknavi.view.support.module.perimeter.interfaces.a aVar = this.f7587a;
        if (aVar != null) {
            aVar.a(i, i2, z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.navisdk.module.trucknavi.view.support.module.perimeter.interfaces.a aVar;
        int id = view.getId();
        if (C()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("TruckPerimeterPage", "onMapClickedBackground,FastDoubleClick");
                return;
            }
            return;
        }
        if (id == R.id.back_arrow) {
            com.baidu.navisdk.module.trucknavi.view.support.module.perimeter.interfaces.a aVar2 = this.f7587a;
            if (aVar2 != null) {
                aVar2.a((Bundle) null);
                return;
            }
            return;
        }
        if (id == R.id.location_btn) {
            com.baidu.navisdk.module.trucknavi.view.support.module.perimeter.interfaces.a aVar3 = this.f7587a;
            if (aVar3 != null) {
                aVar3.a();
                return;
            }
            return;
        }
        if (id == R.id.truck_ugc_report_btn && (aVar = this.f7587a) != null) {
            aVar.a(this.b);
        }
    }
}
