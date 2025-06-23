package com.baidu.navisdk.pronavi.ui.bucket.item.concrete.fullview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.pronavi.ui.bucket.config.d;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.map.h;

/* loaded from: classes7.dex */
public class b extends com.baidu.navisdk.pronavi.ui.bucket.item.a {
    private h f;
    private final com.baidu.navisdk.ui.util.h g;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.g != null && b.this.g.a()) {
                g gVar = g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("MiniMapWindow", "mMapSwitchlayout.onClick() -> fast click, return!!!");
                    return;
                }
                return;
            }
            g gVar2 = g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("MiniMapWindow", "onClick: " + com.baidu.navisdk.ui.routeguide.model.g.h().a());
            }
            k u = ((com.baidu.navisdk.pronavi.ui.bucket.item.a) b.this).f7853a.u();
            com.baidu.navisdk.ui.routeguide.subview.a w = ((com.baidu.navisdk.pronavi.ui.bucket.item.a) b.this).f7853a.w();
            if (com.baidu.navisdk.ui.routeguide.model.g.h().a()) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.3", "1", null, null);
                if (w != null) {
                    if (u != null) {
                        u.e(false);
                    }
                    w.a(3, 0, 0, null);
                    RouteGuideFSM.getInstance().setFullViewByUser(false);
                    com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_fullview_exit"));
                    return;
                }
                return;
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.3", "2", null, null);
            if (w != null) {
                boolean b = w.b(true);
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("MiniMapWindow", "onClick onFullViewAction: " + b);
                }
                if (b) {
                    RouteGuideFSM.getInstance().setFullViewByUser(true);
                    if (u != null) {
                        u.e(true);
                    }
                }
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_fullview"));
            }
        }
    }

    public b(com.baidu.navisdk.pronavi.ui.base.b bVar, d dVar) {
        super(bVar, dVar);
        this.g = new com.baidu.navisdk.ui.util.h();
    }

    private int d(int i) {
        if (i == 2) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_10dp);
        }
        return JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_9dp);
    }

    private int e(int i) {
        if (i == 2) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_96dp);
        }
        return JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_96dp);
    }

    private boolean v() {
        int isShowMapSwitch = BNCommSettingManager.getInstance().getIsShowMapSwitch();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("MiniMapWindow", "isSettingMiniMap:mapSwitch " + isShowMapSwitch);
        }
        if (isShowMapSwitch == 0) {
            return true;
        }
        return false;
    }

    private void w() {
        removeFromParent();
        h hVar = this.f;
        if (hVar != null) {
            hVar.unInit();
            this.f = null;
        }
        setView(null);
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public View.OnClickListener getOnClickListener() {
        return new a();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean h() {
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean i() {
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onDestroy() {
        super.onDestroy();
        w();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onRefreshViewStyle(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        super.onRefreshViewStyle(i);
        View view = getView();
        if (view != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) != null) {
            int e = e(i);
            marginLayoutParams.width = e;
            marginLayoutParams.height = e;
            marginLayoutParams.bottomMargin = d(i);
            view.requestLayout();
        }
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onVisibleChange(int i) {
        super.onVisibleChange(i);
        if (i == 8 && !v()) {
            w();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public String[] r() {
        return new String[]{RGFSMTable.FsmState.BrowseMap, RGFSMTable.FsmState.EnlargeRoadmap, RGFSMTable.FsmState.Voice, RGFSMTable.FsmState.NaviReady, RGFSMTable.FsmState.NearbySearch, RGFSMTable.FsmState.DynamicLayer, RGFSMTable.FsmState.ArriveDest};
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public View a(@NonNull ViewGroup viewGroup, int i, @NonNull Context context) {
        w();
        this.f = com.baidu.nplatform.comapi.map.b.f9495a.a(context);
        int e = e(i);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(e, e);
        marginLayoutParams.bottomMargin = d(i);
        ((View) this.f).setLayoutParams(marginLayoutParams);
        return (View) this.f;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("MiniMapWindow", "onVisibility: " + this.f7853a.m());
        }
        if (x.b().D0) {
            if (gVar.d()) {
                gVar.e("MiniMapWindow", "visibility: mIsForceSwitchPanelShow");
            }
            return 8;
        }
        if (!v()) {
            if (gVar.d()) {
                gVar.e("MiniMapWindow", "visibility: isSettingMiniMap");
            }
            return 8;
        }
        if (k()) {
            if (gVar.d()) {
                gVar.e("MiniMapWindow", "visibility: isHideRoadConditionMiniMap");
            }
            return 8;
        }
        if (!a0.I().D() && !a0.I().r() && !this.f7853a.N()) {
            if (!com.baidu.navisdk.ui.routeguide.b.V().x()) {
                if (gVar.d()) {
                    gVar.e("MiniMapWindow", "showMapSwitchOrRoadBar: hasCalcRoute not ok");
                }
                return 8;
            }
            if (x.b().f2()) {
                if (gVar.d()) {
                    gVar.e("MiniMapWindow", "visibility:isFuzzyMode ");
                }
                return 8;
            }
            if (!x.b().N2()) {
                return 0;
            }
            if (gVar.d()) {
                gVar.e("MiniMapWindow", "visibility: isVdrFuzzyMode");
            }
            return 8;
        }
        if (gVar.d()) {
            gVar.e("MiniMapWindow", "showMapSwitchOrRoadBar-> return ! isBrowseState: " + RouteGuideFSM.getInstance().isBrowseState() + ", isEnlargeOrColladaShow:" + x.b().b2() + ", isYawing: " + a0.I().D() + ", isFakeYawing: " + a0.I().r() + ", isRoused: " + this.f7853a.N());
        }
        return 8;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int a(int i, boolean z) {
        if (i != 2) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_guide_panel_shadow_left);
        }
        return 0;
    }
}
