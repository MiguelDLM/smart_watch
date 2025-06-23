package com.baidu.navisdk.ui.routeguide.truck.toolbox;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.module.routepreference.c;
import com.baidu.navisdk.ui.routeguide.toolbox.f;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public class a extends com.baidu.navisdk.ui.routeguide.toolbox.a {

    /* renamed from: com.baidu.navisdk.ui.routeguide.truck.toolbox.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0483a implements Runnable {
        public RunnableC0483a(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            Bundle bundle = new Bundle();
            bundle.putString("pageSrc", NotificationCompat.CATEGORY_NAVIGATION);
            bundle.putInt("vehicleType", 3);
            com.baidu.navisdk.framework.b.c(bundle);
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_location_share"));
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.a, com.baidu.navisdk.ui.routeguide.toolbox.e
    public boolean a(View view, int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGTruckToolboxOptionsPresenter", "RGToolBoxPresent onClick key :" + i);
        }
        if (super.a(view, i)) {
            return true;
        }
        if (i == 0) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("2.i.5", null, "3", null);
            e();
            com.baidu.navisdk.module.trucknavi.logic.calcroute.a.j().e(c.a(3));
            com.baidu.navisdk.ui.routeguide.subview.a aVar = this.b;
            if (aVar != null) {
                aVar.p();
            }
            return true;
        }
        if (i != 3) {
            return i == 7;
        }
        if (com.baidu.navisdk.ui.util.g.a()) {
            return true;
        }
        a(false);
        f fVar = this.f9108a;
        if (fVar != null) {
            fVar.c(8);
        }
        BNCommSettingManager.getInstance().setLocationShareBtnNeedNewTag(false);
        com.baidu.navisdk.util.statistic.userop.b.r().a("y.0", "3", null, null);
        com.baidu.navisdk.framework.interfaces.locationshare.a j = com.baidu.navisdk.framework.interfaces.c.p().j();
        if (j != null && j.l()) {
            a(new RunnableC0483a(this));
        } else {
            TipTool.onCreateToastDialog(this.f9108a.a(), "服务暂不可用，敬请期待");
        }
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.e
    public String c() {
        return com.baidu.navisdk.module.trucknavi.c.a();
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.a, com.baidu.navisdk.ui.routeguide.toolbox.e
    public boolean a(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGTruckToolboxOptionsPresenter", "updateToolBoxItemState index :" + i);
        }
        if (super.a(i)) {
            return true;
        }
        if (i != 7) {
            return false;
        }
        if (com.baidu.navisdk.module.trucknavi.preferences.a.r0().S() && !TextUtils.isEmpty(com.baidu.navisdk.module.trucknavi.c.a())) {
            this.f9108a.a(i, 1);
            return true;
        }
        this.f9108a.a(i, 2);
        return true;
    }
}
