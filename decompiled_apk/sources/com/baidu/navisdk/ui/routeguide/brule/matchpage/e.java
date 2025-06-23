package com.baidu.navisdk.ui.routeguide.brule.matchpage;

import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.navicenter.BNavigatorLogic;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    List<g> f8520a = new ArrayList();
    g b = new a(this);
    g c = new b(this);
    g d = new c(this);
    g e = new d(this);
    g f = new C0434e(this);

    /* loaded from: classes8.dex */
    public class a implements g {
        public a(e eVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.brule.matchpage.e.g
        public com.baidu.navisdk.behavrules.d a() {
            return com.baidu.navisdk.behavrules.d.SUCCESS;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements g {
        public b(e eVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.brule.matchpage.e.g
        public com.baidu.navisdk.behavrules.d a() {
            if (com.baidu.navisdk.ui.routeguide.asr.c.n().i()) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.BRULE;
                if (gVar.d()) {
                    gVar.e("BNRGMatchPageConstructor", "isAllMatched(), 小度唤醒中");
                }
                return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
            }
            return com.baidu.navisdk.behavrules.d.SUCCESS;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements g {
        public c(e eVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.brule.matchpage.e.g
        public com.baidu.navisdk.behavrules.d a() {
            if (com.baidu.navisdk.ui.routeguide.b.V().z()) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.BRULE;
                if (gVar.d()) {
                    gVar.e("BNRGMatchPageConstructor", "isAllMatched() 在后台运行中");
                }
                return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
            }
            if (com.baidu.navisdk.module.pronavi.a.j == 2) {
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.BRULE;
                if (gVar2.d()) {
                    gVar2.e("BNRGMatchPageConstructor", "isAllMatched() 模拟导航中");
                }
                return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
            }
            if (!BNavigatorLogic.z0) {
                com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.BRULE;
                if (gVar3.d()) {
                    gVar3.e("BNRGMatchPageConstructor", "isAllMatched() error, 不在导航中");
                }
                return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
            }
            if (!com.baidu.navisdk.ui.routeguide.b.V().x()) {
                com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.BRULE;
                if (gVar4.d()) {
                    gVar4.e("BNRGMatchPageConstructor", "isAllMatched() error, 还没算路成功");
                }
                return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
            }
            if (RGFSMTable.FsmState.NearbySearch.equals(RouteGuideFSM.getInstance().getCurrentState())) {
                com.baidu.navisdk.util.common.g gVar5 = com.baidu.navisdk.util.common.g.BRULE;
                if (gVar5.d()) {
                    gVar5.e("BNRGMatchPageConstructor", "isAllMatched() error, 在沿途搜态");
                }
                return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
            }
            if (RGFSMTable.FsmState.ArriveDest.equals(RouteGuideFSM.getInstance().getCurrentState())) {
                com.baidu.navisdk.util.common.g gVar6 = com.baidu.navisdk.util.common.g.BRULE;
                if (gVar6.d()) {
                    gVar6.e("BNRGMatchPageConstructor", "isAllMatched() error, 在终点到达态");
                }
                return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
            }
            if (RGFSMTable.FsmState.DynamicLayer.equals(RouteGuideFSM.getInstance().getCurrentState())) {
                com.baidu.navisdk.util.common.g gVar7 = com.baidu.navisdk.util.common.g.BRULE;
                if (gVar7.d()) {
                    gVar7.e("BNRGMatchPageConstructor", "isAllMatched() error, 在动态图层状态");
                }
                return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
            }
            if (2 == BNCommSettingManager.getInstance().getVoiceMode()) {
                com.baidu.navisdk.util.common.g gVar8 = com.baidu.navisdk.util.common.g.BRULE;
                if (gVar8.d()) {
                    gVar8.e("BNRGMatchPageConstructor", "isAllMatched(), 当前为静音模式");
                }
                return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
            }
            if (a0.I().q()) {
                com.baidu.navisdk.util.common.g gVar9 = com.baidu.navisdk.util.common.g.BRULE;
                if (gVar9.d()) {
                    gVar9.e("BNRGMatchPageConstructor", "isAllMatched(), 现在是车标自由态");
                }
                return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
            }
            if (a0.I().D()) {
                com.baidu.navisdk.util.common.g gVar10 = com.baidu.navisdk.util.common.g.BRULE;
                if (gVar10.d()) {
                    gVar10.e("BNRGMatchPageConstructor", "isAllMatched(), 偏航中");
                }
                return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
            }
            if (com.baidu.navisdk.ui.routeguide.utils.b.s()) {
                com.baidu.navisdk.util.common.g gVar11 = com.baidu.navisdk.util.common.g.BRULE;
                if (gVar11.d()) {
                    gVar11.e("BNRGMatchPageConstructor", "isAllMatched(), ar导航中");
                }
                return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
            }
            return com.baidu.navisdk.behavrules.d.SUCCESS;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements g {
        public d(e eVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.brule.matchpage.e.g
        public com.baidu.navisdk.behavrules.d a() {
            if (!com.baidu.navisdk.ui.routeguide.asr.c.n().h()) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.BRULE;
                if (gVar.d()) {
                    gVar.e("BNRGMatchPageConstructor", "isAllMatched(), 小度不可唤醒");
                }
                return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
            }
            if (!com.baidu.navisdk.asr.f.a()) {
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.BRULE;
                if (gVar2.d()) {
                    gVar2.e("BNRGMatchPageConstructor", "isAllMatched(), 小度没有麦克风权限等");
                }
                return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
            }
            if (com.baidu.navisdk.module.dynamicui.a.f.a().c()) {
                com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.BRULE;
                if (gVar3.d()) {
                    gVar3.e("BNRGMatchPageConstructor", "isAllMatched(), Dialog展示中");
                }
                return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
            }
            if (!com.baidu.navisdk.function.b.FUNC_XIAODU_SCENEAID.a()) {
                com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.BRULE;
                if (gVar4.d()) {
                    gVar4.e("BNRGMatchPageConstructor", "isAllMatched() error, BNFunc开关是关的");
                }
                return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
            }
            return com.baidu.navisdk.behavrules.d.SUCCESS;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.brule.matchpage.e$e, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0434e implements g {
        public C0434e(e eVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.brule.matchpage.e.g
        public com.baidu.navisdk.behavrules.d a() {
            if (!com.baidu.navisdk.ui.routeguide.b.V().D()) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.BRULE;
                if (gVar.d()) {
                    gVar.e("BNRGMatchPageConstructor", "isAllMatched() 不是新能源场景");
                }
                return com.baidu.navisdk.behavrules.d.ERROR_RESETVALUE;
            }
            return com.baidu.navisdk.behavrules.d.SUCCESS;
        }
    }

    /* loaded from: classes8.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private boolean f8521a;
        private boolean b;
        private boolean c;

        public f a(boolean z) {
            this.c = z;
            return this;
        }

        public f b(boolean z) {
            this.f8521a = z;
            return this;
        }

        public f c(boolean z) {
            this.b = z;
            return this;
        }

        public e a() {
            e eVar = new e();
            eVar.f8520a.add(eVar.b);
            eVar.f8520a.add(eVar.d);
            if (this.b) {
                eVar.f8520a.add(eVar.f);
            }
            if (this.f8521a) {
                eVar.f8520a.add(eVar.c);
            }
            if (this.c) {
                eVar.f8520a.add(eVar.e);
            }
            return eVar;
        }
    }

    /* loaded from: classes8.dex */
    public interface g {
        com.baidu.navisdk.behavrules.d a();
    }

    public com.baidu.navisdk.behavrules.d a() {
        for (g gVar : this.f8520a) {
            if (gVar.a() != com.baidu.navisdk.behavrules.d.SUCCESS) {
                return gVar.a();
            }
        }
        return com.baidu.navisdk.behavrules.d.SUCCESS;
    }
}
