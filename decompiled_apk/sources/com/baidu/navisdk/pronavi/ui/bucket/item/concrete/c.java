package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import android.view.View;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.setting.SettingParams;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.c;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.util.TipTool;

/* loaded from: classes7.dex */
public class c extends com.baidu.navisdk.pronavi.ui.bucket.item.c {
    private boolean k;
    c.e l;

    /* loaded from: classes7.dex */
    public class a implements c.e {

        /* renamed from: com.baidu.navisdk.pronavi.ui.bucket.item.concrete.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0338a extends c.a {
            public C0338a() {
            }

            @Override // com.baidu.navisdk.framework.c.a
            public boolean a(c.e eVar, int i, Object obj) {
                c.this.refreshVisible();
                return true;
            }
        }

        public a() {
        }

        @Override // com.baidu.navisdk.framework.c.e
        public c.C0198c a() {
            c.C0198c c0198c = new c.C0198c(c.this.l);
            C0338a c0338a = new C0338a();
            c0198c.b((Integer) 17, (c.a) c0338a).b((Integer) 18, (c.a) c0338a).a((Integer) 11, (c.a) c0338a).a((Integer) 16, (c.a) c0338a).a((Integer) 15, (c.a) c0338a);
            return c0198c;
        }
    }

    public c(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar, R.drawable.bnav_drawable_navi_to_commute_btn, "熟路模式");
        this.k = false;
        y();
    }

    private void A() {
        int selectRouteIdx = JNIGuidanceControl.getInstance().getSelectRouteIdx();
        boolean judgeRouteInfoAllReady = JNIGuidanceControl.getInstance().judgeRouteInfoAllReady(selectRouteIdx);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("CommuteBtn", "onToCommuteBtnClick,curRouteIdx：" + selectRouteIdx + "，isReady:" + judgeRouteInfoAllReady);
        }
        if (!judgeRouteInfoAllReady) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "模式切换失败，请稍后再试");
            return;
        }
        int naviSwitchingCalcRoute = BNRouteGuider.getInstance().naviSwitchingCalcRoute(2);
        if (gVar.d()) {
            gVar.e("CommuteBtn", "onToCommuteBtnClick,witchActionRet:" + naviSwitchingCalcRoute);
        }
        if (naviSwitchingCalcRoute > 0) {
            com.baidu.navisdk.ui.routeguide.b.V().b(4, false);
        } else {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "模式切换失败，请稍后再试");
        }
    }

    private void b(int i, boolean z) {
        View view = getView();
        if ((view != null ? view.getVisibility() : 8) != i) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.v.8", i == 0 ? "0" : "1", z ? "0" : "1", null);
        }
    }

    private void y() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("CommuteBtn", "initRGMsgStateObserver: ");
        }
        this.l = new a();
        com.baidu.navisdk.framework.c.b().a(this.l);
    }

    private boolean z() {
        boolean z;
        boolean z2;
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (fVar != null && fVar.h() == 2) {
            z = true;
        } else {
            z = false;
        }
        if (fVar != null && fVar.h() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z && !z2) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public void a(View view) {
        BNSettingManager.putBoolean(SettingParams.Key.EVER_SHOW_RG_MOSS_RED_POINT, true);
        if (com.baidu.navisdk.ui.util.g.a()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("CommuteBtn", "mProNavi2CommuteGuideLayout,fastDoubleClick");
                return;
            }
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.model.a0.I().q()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("CommuteBtn", "mProNavi2CommuteGuideLayout,CarFree");
                return;
            }
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.model.a0.I().x()) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("CommuteBtn", "mProNavi2CommuteGuideLayout,isReRoutePlaning");
                return;
            }
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.model.a0.I().D()) {
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar4.d()) {
                gVar4.e("CommuteBtn", "onClicked: isYawing");
                return;
            }
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().b("3.v.8.1");
        A();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("CommuteBtn", "getVisibility: " + i);
        }
        int i2 = 8;
        if (i != 1) {
            return 8;
        }
        if (!com.baidu.navisdk.j.d()) {
            if (gVar.d()) {
                gVar.e("CommuteBtn", "getVisibility: not for map");
            }
            return 8;
        }
        if (this.f7853a.y() != 1) {
            if (gVar.d()) {
                gVar.e("CommuteBtn", "getVisibility: " + this.f7853a.y());
            }
            return 8;
        }
        if (this.f7853a.v() == 3) {
            if (gVar.d()) {
                gVar.e("CommuteBtn", "getVisibility: " + this.f7853a.v());
            }
            return 8;
        }
        if (this.f7853a.N()) {
            return 8;
        }
        if (com.baidu.navisdk.ui.routeguide.model.a0.I().q()) {
            if (gVar.d()) {
                gVar.e("CommuteBtn", "getVisibility: is car logo free ");
            }
            return 8;
        }
        if (!com.baidu.navisdk.util.common.z.b(this.f7853a.a())) {
            if (gVar.d()) {
                gVar.e("CommuteBtn", "getVisibility: not network");
            }
            return 8;
        }
        if (!com.baidu.navisdk.ui.routeguide.model.a0.I().D() && !com.baidu.navisdk.ui.routeguide.model.a0.I().x()) {
            if (BNSettingManager.getLightCommutePreferMode() == 1) {
                if (gVar.d()) {
                    gVar.e("CommuteBtn", "isForceShow: force moss");
                }
                return 0;
            }
            if (BNRoutePlaner.getInstance().B()) {
                if (gVar.d()) {
                    gVar.e("CommuteBtn", "visibility: isCurDriveRouteOnline");
                }
                return 8;
            }
            boolean z = z();
            if (gVar.d()) {
                gVar.e("CommuteBtn", "getVisibility isHitCommute: " + z);
            }
            if (z && BNSettingManager.canShowCommuteEntrance()) {
                if (gVar.d()) {
                    gVar.e("CommuteBtn", "getVisibility: + canShowCommuteEntrance");
                }
                return 0;
            }
            String m = this.f7853a.m();
            if (gVar.d()) {
                gVar.e("CommuteBtn", "getVisibility currentState:" + m);
            }
            if (RGFSMTable.FsmState.SimpleGuide.equals(m)) {
                if (gVar.d()) {
                    gVar.e("CommuteBtn", "getVisibility isAllowShow: " + this.k + ", " + BNSettingManager.canShowCommuteEntrance());
                }
                if (this.k && BNSettingManager.canShowCommuteEntrance()) {
                    i2 = 0;
                }
                b(i2, false);
            } else if (RGFSMTable.FsmState.BrowseMap.equals(m)) {
                if (z) {
                    i2 = 0;
                }
                b(i2, true);
            }
        }
        return i2;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean h() {
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c, com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onDestroy() {
        super.onDestroy();
        com.baidu.navisdk.framework.c.b().b(this.l);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("CommuteBtn", "onDestroy: ");
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public String[] r() {
        return new String[]{RGFSMTable.FsmState.Voice, RGFSMTable.FsmState.ArriveDest, RGFSMTable.FsmState.NaviReady, RGFSMTable.FsmState.NearbySearch, RGFSMTable.FsmState.DynamicLayer};
    }

    public void b(boolean z) {
        this.k = z;
        refreshVisible();
    }
}
