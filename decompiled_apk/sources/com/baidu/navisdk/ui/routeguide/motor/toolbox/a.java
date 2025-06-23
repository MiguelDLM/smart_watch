package com.baidu.navisdk.ui.routeguide.motor.toolbox;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.module.routepreference.c;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.toolbox.f;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.y;

/* loaded from: classes8.dex */
public class a extends com.baidu.navisdk.ui.routeguide.toolbox.a {

    /* renamed from: com.baidu.navisdk.ui.routeguide.motor.toolbox.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0470a implements Runnable {
        public RunnableC0470a(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            Bundle bundle = new Bundle();
            bundle.putString("pageSrc", NotificationCompat.CATEGORY_NAVIGATION);
            bundle.putInt("vehicleType", 2);
            com.baidu.navisdk.framework.b.c(bundle);
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_location_share"));
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.a, com.baidu.navisdk.ui.routeguide.toolbox.e
    public boolean a(View view, int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMotorToolboxOptionsPresenter", "RGToolBoxPresent onClick key :" + i);
        }
        if (super.a(view, i)) {
            return true;
        }
        if (i == 0) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("2.i.5", null, "3", null);
            e();
            com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().e(c.a(2));
            com.baidu.navisdk.ui.routeguide.subview.a aVar = this.b;
            if (aVar != null) {
                aVar.p();
            }
            return true;
        }
        if (i == 3) {
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
                a(new RunnableC0470a(this));
            } else {
                TipTool.onCreateToastDialog(this.f9108a.a(), "服务暂不可用，敬请期待");
            }
            return true;
        }
        if (i != 7) {
            return false;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.j.4");
        if (!y.d(com.baidu.navisdk.framework.a.c().a())) {
            e();
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "网络连接不可用");
            return true;
        }
        if (BNRoutePlaner.getInstance().B()) {
            e();
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "离线导航车牌限行不可用");
            return true;
        }
        com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().e(com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().f());
        if (TextUtils.isEmpty(com.baidu.navisdk.module.motorbike.a.a())) {
            a(false);
            com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().b(true);
            com.baidu.navisdk.module.motorbike.a.b();
            return true;
        }
        if (!com.baidu.navisdk.module.motorbike.preferences.a.u0().V()) {
            a(true);
            com.baidu.navisdk.module.motorbike.logic.calcroute.a.j().b(true);
            com.baidu.navisdk.ui.routeguide.subview.a aVar2 = this.b;
            if (aVar2 != null) {
                a0.G = 3;
                aVar2.h();
            }
            a(i);
        }
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.e
    public String c() {
        return com.baidu.navisdk.module.motorbike.a.a();
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.a, com.baidu.navisdk.ui.routeguide.toolbox.e
    public boolean a(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMotorToolboxOptionsPresenter", "updateToolBoxItemState index :" + i);
        }
        if (super.a(i)) {
            return true;
        }
        if (i != 7) {
            return false;
        }
        if (com.baidu.navisdk.module.motorbike.preferences.a.u0().V() && !TextUtils.isEmpty(com.baidu.navisdk.module.motorbike.a.a())) {
            this.f9108a.a(i, 1);
            return true;
        }
        this.f9108a.a(i, 2);
        return true;
    }
}
