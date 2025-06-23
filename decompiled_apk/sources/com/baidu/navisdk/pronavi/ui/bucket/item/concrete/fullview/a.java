package com.baidu.navisdk.pronavi.ui.bucket.item.concrete.fullview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.ui.bucket.config.d;
import com.baidu.navisdk.pronavi.widget.RGImageTextBtn;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.i;
import com.baidu.navisdk.ui.util.h;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public class a extends com.baidu.navisdk.pronavi.ui.bucket.item.c {
    private final h k;

    public a(com.baidu.navisdk.pronavi.ui.base.b bVar, d dVar) {
        super(bVar, dVar, R.drawable.nsdk_drawable_common_ic_fullview_mode, "全览");
        this.k = new h();
    }

    private void y() {
        RGImageTextBtn v = v();
        if (v != null) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("FullViewBtn", "updateBtnContent: " + com.baidu.navisdk.ui.routeguide.model.g.h().a());
            }
            if (com.baidu.navisdk.ui.routeguide.model.g.h().a()) {
                v.setTextContent("退出全览");
            } else {
                v.setTextContent("全览");
            }
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public void a(View view) {
        boolean z;
        super.a(view);
        h hVar = this.k;
        if (hVar != null && hVar.a()) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("FullViewBtn", "mFullViewModeBtn.onClick() -> fast click, return!!!");
                return;
            }
            return;
        }
        g gVar2 = g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("FullViewBtn", "mFullViewModeBtn.onClick() -> getFullViewState = " + com.baidu.navisdk.ui.routeguide.model.g.h().a());
        }
        if (i.s().k()) {
            if (gVar2.d()) {
                gVar2.e("FullViewBtn", "mFullViewModeBtn.onClick() -> isAnyEnlargeRoadMapShowing,return!");
                return;
            }
            return;
        }
        if (gVar2.d()) {
            gVar2.e("FullViewBtn", "onClicked: " + com.baidu.navisdk.ui.routeguide.model.g.h().a());
        }
        com.baidu.navisdk.ui.routeguide.subview.a w = this.f7853a.w();
        if (com.baidu.navisdk.ui.routeguide.model.g.h().a()) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.3.1", "1", null, null);
            if (w != null) {
                w.a(3, 0, 0, null);
                RouteGuideFSM.getInstance().setFullViewByUser(false);
                if (this.f7853a.u() != null) {
                    this.f7853a.u().i(false);
                }
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_fullview_exit"));
            }
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.3.1", "2", null, null);
            if (w != null) {
                z = w.b(true);
            } else {
                z = false;
            }
            if (gVar2.d()) {
                gVar2.e("FullViewBtn", "onFullViewBtnClicked: " + z);
            }
            if (z) {
                x.b().u(0);
                RouteGuideFSM.getInstance().setFullViewByUser(true);
                if (this.f7853a.u() != null) {
                    this.f7853a.u().i(true);
                }
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_fullview"));
            }
        }
        y();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("FullViewBtn", "onVisibility: " + this.f7853a.m());
        }
        if (x.b().D0) {
            if (gVar.d()) {
                gVar.e("FullViewBtn", "visibility: mIsForceSwitchPanelShow");
            }
            return 8;
        }
        if (k()) {
            if (gVar.d()) {
                gVar.e("FullViewBtn", "visibility: isHideRoadConditionMiniMap");
            }
            return 8;
        }
        if (!a0.I().D() && !a0.I().r() && !this.f7853a.N()) {
            if (!com.baidu.navisdk.ui.routeguide.b.V().x()) {
                if (gVar.d()) {
                    gVar.e("FullViewBtn", "showMapSwitchOrRoadBar: hasCalcRoute not ok");
                }
                return 8;
            }
            if (x.b().f2()) {
                if (gVar.d()) {
                    gVar.e("FullViewBtn", "visibility:isFuzzyMode ");
                }
                return 0;
            }
            if (x.b().N2()) {
                if (gVar.d()) {
                    gVar.e("FullViewBtn", "visibility: isVdrFuzzyMode");
                }
                return 0;
            }
            int p = this.f7853a.p();
            if (gVar.d()) {
                gVar.e("FullViewBtn", "visibility hdNaviState: " + p);
            }
            if (p == 2) {
                if (gVar.d()) {
                    gVar.e("FullViewBtn", "visibility: is isHDDoubleMapNavi");
                }
                y();
                return 0;
            }
            if (this.f7853a.D()) {
                if (gVar.d()) {
                    gVar.e("FullViewBtn", "visibility: isNormalHDMapShowed");
                }
                y();
                return 0;
            }
            int isShowMapSwitch = BNCommSettingManager.getInstance().getIsShowMapSwitch();
            if (gVar.d()) {
                gVar.e("FullViewBtn", "visibility:mapSwitch " + isShowMapSwitch);
            }
            if (isShowMapSwitch == 0) {
                return 8;
            }
            y();
            return 0;
        }
        if (gVar.d()) {
            gVar.e("FullViewBtn", "showMapSwitchOrRoadBar-> return ! isBrowseState: " + RouteGuideFSM.getInstance().isBrowseState() + ", isEnlargeOrColladaShow:" + x.b().b2() + ", isYawing: " + a0.I().D() + ", isFakeYawing: " + a0.I().r() + ", isRoused: " + this.f7853a.N());
        }
        return 8;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean g() {
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void loadBucketItem(ViewGroup viewGroup, int i, Context context) {
        super.loadBucketItem(viewGroup, i, context);
        y();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean o() {
        return true;
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onVisibleChange(int i) {
        super.onVisibleChange(i);
        if (i == 0) {
            y();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public String[] r() {
        return new String[]{RGFSMTable.FsmState.BrowseMap, RGFSMTable.FsmState.EnlargeRoadmap, RGFSMTable.FsmState.Voice, RGFSMTable.FsmState.NaviReady, RGFSMTable.FsmState.NearbySearch, RGFSMTable.FsmState.DynamicLayer, RGFSMTable.FsmState.ArriveDest};
    }
}
