package com.baidu.navisdk.ui.routeguide.toolbox;

import android.view.View;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.l;

/* loaded from: classes8.dex */
public abstract class a implements e {

    /* renamed from: a, reason: collision with root package name */
    protected f f9108a;
    protected com.baidu.navisdk.ui.routeguide.subview.a b;

    /* renamed from: com.baidu.navisdk.ui.routeguide.toolbox.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0478a implements Runnable {
        public RunnableC0478a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.navisdk.ui.routeguide.subview.a aVar = a.this.b;
            if (aVar != null) {
                aVar.a(5, 3, 0, null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.navisdk.ui.routeguide.b.V().a();
        }
    }

    private void b(int i) {
        a(false);
        a(new b(this));
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.e
    public void a(f fVar) {
        this.f9108a = fVar;
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.e
    public void d() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("ARGToolboxOptionsPresenter", "initViewStatus");
        }
        a(4);
        a(6);
        a(7);
        a(17);
        if (BNCommSettingManager.getInstance().isVoiceBtnNeedNewTag()) {
            this.f9108a.b(0);
        }
        if (BNCommSettingManager.getInstance().isOrientationBtnNeedNewTag()) {
            this.f9108a.a(0);
        }
        if (BNCommSettingManager.getInstance().isLocationShareBtnNeedNewTag()) {
            this.f9108a.c(0);
        }
    }

    public void e() {
        a(true);
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.e
    public void a(com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        this.b = aVar;
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.e
    public boolean a(View view, int i) {
        com.baidu.navisdk.ui.routeguide.subview.a aVar;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("ARGToolboxOptionsPresenter", "RGToolBoxPresent onClick key :" + i);
        }
        if (i == 1) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.j.2");
            com.baidu.navisdk.ui.routeguide.subview.a aVar2 = this.b;
            if (aVar2 != null) {
                aVar2.b();
            }
            e();
            return true;
        }
        if (i == 2) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.j.7");
            a(false);
            BNCommSettingManager.getInstance().setFirstVoiceGuide(true);
            f fVar = this.f9108a;
            if (fVar != null) {
                fVar.b(8);
            }
            BNCommSettingManager.getInstance().setVoiceBtnNeedNewTag(false);
            if (com.baidu.navisdk.function.b.FUNC_CUSTOM_VOICE.a()) {
                a(new RunnableC0478a());
            }
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_star_voice"));
            return true;
        }
        if (i == 4) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.j.5");
            f fVar2 = this.f9108a;
            if (fVar2 != null) {
                fVar2.a(8);
            }
            BNCommSettingManager.getInstance().setOrientationBtnNeedNewTag();
            com.baidu.navisdk.ui.routeguide.utils.g.m();
            b(i);
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_landscape_navi"));
            return true;
        }
        if (i == 6) {
            e();
            RouteGuideFSM.getInstance().setFullViewByUser(false);
            if (BNCommSettingManager.getInstance().getMapMode() != 1 && BNCommSettingManager.getInstance().getMapMode() != 3) {
                RouteGuideFSM.getInstance().cacheBackMapState(RGFSMTable.FsmState.Car3D);
                BNCommSettingManager.getInstance().setMapMode(1);
                s.T().a(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_switch_car3d_success), true);
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_2d"));
            } else {
                RouteGuideFSM.getInstance().cacheBackMapState(RGFSMTable.FsmState.North2D);
                BNCommSettingManager.getInstance().setMapMode(2);
                s.T().a(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_switch_north2_success), true);
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_3d"));
            }
            com.baidu.navisdk.ui.routeguide.b.V().r().l();
            a(i);
            return true;
        }
        if (i == 8) {
            com.baidu.navisdk.ui.routeguide.subview.a aVar3 = this.b;
            if (aVar3 != null) {
                aVar3.j();
            }
            e();
            return true;
        }
        if (i == 17) {
            int isShowMapSwitch = BNCommSettingManager.getInstance().getIsShowMapSwitch();
            if (isShowMapSwitch == 0) {
                com.baidu.navisdk.ui.routeguide.b.V().b(1);
            } else if (isShowMapSwitch == 1) {
                com.baidu.navisdk.ui.routeguide.b.V().b(0);
            }
            x.b().I().b(true);
            x.b().Y2();
            if (RouteGuideParams.NavState.NAV_STATE_OPERATE.equals(com.baidu.navisdk.ui.routeguide.model.g.h().b()) && (aVar = this.b) != null) {
                aVar.a(3, 0, 0, null);
            }
            e();
            a(i);
            if (isShowMapSwitch == 1) {
                s.T().a(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_notification_mini_map_mode), true);
            } else {
                s.T().a(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_notification_roadbar_mode), true);
            }
            return true;
        }
        if (i != 18) {
            return false;
        }
        e();
        if (!com.baidu.navisdk.function.b.FUNC_POWER_SAVE_MODE.a()) {
            s.T().m(2);
        } else {
            int powerSaveMode = BNSettingManager.getPowerSaveMode();
            boolean c = l.c(com.baidu.navisdk.ui.routeguide.b.V().b());
            if (!c) {
                powerSaveMode = 2;
            }
            if (powerSaveMode == 2 && !c) {
                x.b().t4();
                return true;
            }
            if (powerSaveMode == 0) {
                BNSettingManager.setPowerSaveMode(2);
                s.T().m(1);
            } else if (powerSaveMode == 2) {
                BNSettingManager.setPowerSaveMode(0);
                s.T().m(0);
            }
            a(i);
        }
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.e
    public void b() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("ARGToolboxOptionsPresenter", "updateViewStatus");
        }
        a(4);
        a(6);
        a(7);
        a(17);
    }

    public void a(Runnable runnable) {
        f fVar;
        if (runnable == null || (fVar = this.f9108a) == null || fVar.e() == null) {
            return;
        }
        this.f9108a.e().postDelayed(runnable, 70L);
    }

    public void a(boolean z) {
        f fVar = this.f9108a;
        if (fVar != null) {
            if (z) {
                fVar.d();
            } else {
                fVar.c();
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.e
    public boolean a(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("ARGToolboxOptionsPresenter", "updateToolBoxItemState index :" + i);
        }
        if (i == 4) {
            this.f9108a.a(i, -1);
            return true;
        }
        if (i == 6) {
            this.f9108a.a(i, (BNCommSettingManager.getInstance().getMapMode() == 1 || BNCommSettingManager.getInstance().getMapMode() == 3) ? 1 : 2);
            return true;
        }
        if (i != 17) {
            return false;
        }
        this.f9108a.a(i, BNCommSettingManager.getInstance().getIsShowMapSwitch() == 0 ? 1 : 2);
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.e
    public void a() {
        f fVar = this.f9108a;
        if (fVar != null) {
            fVar.b(0);
        }
    }
}
