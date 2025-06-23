package com.baidu.navisdk.pronavi.ui.bucket.item.concrete.fullview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.m;
import com.baidu.navisdk.pronavi.data.vm.h;
import com.baidu.navisdk.ui.roadcondition.view.BNSmartRoadConditionLayout;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.m1;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.List;

/* loaded from: classes7.dex */
public class c extends com.baidu.navisdk.pronavi.ui.bucket.item.a {
    private m1 f;
    private h g;
    private LifecycleOwner h;
    private Observer i;
    private Observer j;
    private Observer k;
    private Observer l;

    /* loaded from: classes7.dex */
    public class a implements Observer<Double> {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Double d) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RoadConditionView", "bindRoadConditionVM: carProgress = " + d);
            }
            if (c.this.f != null) {
                c.this.f.a(d.doubleValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Observer<List<m>> {
        public b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<m> list) {
            if (c.this.f != null) {
                c.this.f.c(list);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.pronavi.ui.bucket.item.concrete.fullview.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0339c implements Observer<List<com.baidu.navisdk.module.pronavi.model.c>> {
        public C0339c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<com.baidu.navisdk.module.pronavi.model.c> list) {
            if (c.this.f != null) {
                c.this.f.b(list);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Observer<com.baidu.navisdk.module.pronavi.model.c> {
        public d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.baidu.navisdk.module.pronavi.model.c cVar) {
            if (c.this.f == null) {
                return;
            }
            if (cVar == null) {
                c.this.f.r0();
            } else {
                c.this.f.a(cVar);
            }
        }
    }

    public c(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar);
        this.i = new a();
        this.j = new b();
        this.k = new C0339c();
        this.l = new d();
    }

    private boolean e(int i) {
        int isShowMapSwitch = BNCommSettingManager.getInstance().getIsShowMapSwitch();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RoadConditionView", "isShowRoadBar:mapSwitch " + isShowMapSwitch);
        }
        if (isShowMapSwitch == i) {
            return true;
        }
        return false;
    }

    private void w() {
        this.g.d().observe(this.h, this.i);
        this.g.f().observe(this.h, this.j);
        this.g.g().observe(this.h, this.k);
        this.g.h().observe(this.h, this.l);
    }

    private void x() {
        this.g.d().removeObserver(this.i);
        this.g.f().removeObserver(this.j);
        this.g.g().removeObserver(this.k);
        this.g.g().removeObserver(this.l);
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RoadConditionView", "visibility start: " + this.f7853a.m());
        }
        if (x.b().D0) {
            if (gVar.d()) {
                gVar.e("RoadConditionView", "visibility: mIsForceSwitchPanelShow");
            }
            return 8;
        }
        if (k()) {
            if (gVar.d()) {
                gVar.e("RoadConditionView", "visibility: isHideRoadConditionMiniMap");
            }
            return 8;
        }
        if (!a0.I().D() && !a0.I().r() && !this.f7853a.N()) {
            if (!com.baidu.navisdk.ui.routeguide.b.V().x()) {
                if (gVar.d()) {
                    gVar.e("RoadConditionView", "showMapSwitchOrRoadBar: hasCalcRoute not ok");
                }
                return 8;
            }
            if (x.b().f2()) {
                if (gVar.d()) {
                    gVar.e("RoadConditionView", "visibility:isFuzzyMode ");
                }
                return 8;
            }
            if (x.b().N2()) {
                if (gVar.d()) {
                    gVar.e("RoadConditionView", "visibility: isVdrFuzzyMode");
                }
                return 8;
            }
            if (a(RGFSMTable.FsmState.Fullview)) {
                if (gVar.c()) {
                    gVar.c("RoadConditionView", "visibility: Fullview");
                }
                return 8;
            }
            int p = this.f7853a.p();
            if (p == 2) {
                if (gVar.d()) {
                    gVar.e("RoadConditionView", "visibility: isHDDoubleMapState");
                }
                return 8;
            }
            if (p == 3 && (e(0) || !b(i))) {
                if (gVar.d()) {
                    gVar.e("RoadConditionView", "visibility: is hd full navi state");
                }
                return 0;
            }
            if (this.f7853a.D() && (e(0) || !b(i))) {
                if (gVar.d()) {
                    gVar.e("RoadConditionView", "visibility: isNormalHDMapShowed");
                }
                return 0;
            }
            if (!e(1)) {
                return 8;
            }
            if (gVar.d()) {
                gVar.e("RoadConditionView", "visibility: set road bar");
            }
            return 0;
        }
        if (gVar.d()) {
            gVar.e("RoadConditionView", "showMapSwitchOrRoadBar-> return ! isBrowseState: " + RouteGuideFSM.getInstance().isBrowseState() + ", isEnlargeOrColladaShow:" + x.b().b2() + ", isYawing: " + a0.I().D() + ", isFakeYawing: " + a0.I().r() + ", isRoused: " + this.f7853a.N());
        }
        return 8;
    }

    public void d(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RoadConditionView", "updateHeight: " + i);
        }
        if (this.f == null) {
            if (gVar.d()) {
                gVar.e("RoadConditionView", "updateHeight: mRoadConditionView null");
                return;
            }
            return;
        }
        View view = getView();
        if (view == null) {
            if (gVar.c()) {
                gVar.c("RoadConditionView", "updateHeight: view == null");
                return;
            }
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (gVar.d()) {
            gVar.e("RoadConditionView", "updateHeight: curHeight:" + marginLayoutParams.height + ", need:" + i);
        }
        if (marginLayoutParams.height != i) {
            marginLayoutParams.height = i;
            view.requestLayout();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean o() {
        return true;
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onVisibleChange(int i) {
        super.onVisibleChange(i);
        if (i == 8) {
            if (!e(1)) {
                removeFromParent();
                m1 m1Var = this.f;
                if (m1Var != null) {
                    m1Var.i();
                    this.f = null;
                }
                setView(null);
                x();
                return;
            }
            return;
        }
        w();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public String[] r() {
        return new String[]{RGFSMTable.FsmState.BrowseMap, RGFSMTable.FsmState.EnlargeRoadmap, RGFSMTable.FsmState.Voice, RGFSMTable.FsmState.NaviReady, RGFSMTable.FsmState.NearbySearch, RGFSMTable.FsmState.DynamicLayer, RGFSMTable.FsmState.ArriveDest};
    }

    public boolean v() {
        if (this.f != null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public View a(@NonNull ViewGroup viewGroup, int i, @NonNull Context context) {
        BNSmartRoadConditionLayout bNSmartRoadConditionLayout = new BNSmartRoadConditionLayout(context);
        bNSmartRoadConditionLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f = new m1(context, bNSmartRoadConditionLayout);
        this.g = (h) this.f7853a.c(h.class);
        this.h = com.baidu.navisdk.ui.routeguide.b.V().f();
        bNSmartRoadConditionLayout.setTag("RoadConditionView");
        return bNSmartRoadConditionLayout;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int a(int i, boolean z) {
        if (i != 2) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_guide_panel_shadow_left);
        }
        return 0;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public void a(boolean z) {
        super.a(z);
        m1 m1Var = this.f;
        if (m1Var != null) {
            m1Var.a(z);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public View a() {
        m1 m1Var = this.f;
        if (m1Var != null) {
            return m1Var.n0();
        }
        return null;
    }
}
