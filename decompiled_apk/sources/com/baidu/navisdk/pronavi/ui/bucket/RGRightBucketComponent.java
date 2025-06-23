package com.baidu.navisdk.pronavi.ui.bucket;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.apicenter.h;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.func.Func;
import com.baidu.navisdk.framework.interfaces.pronavi.hd.f;
import com.baidu.navisdk.pronavi.ui.bucket.item.concrete.a0;
import com.baidu.navisdk.pronavi.ui.bucket.item.concrete.j;
import com.baidu.navisdk.pronavi.ui.bucket.item.concrete.l;
import com.baidu.navisdk.pronavi.ui.bucket.item.concrete.p;
import com.baidu.navisdk.pronavi.ui.bucket.item.concrete.r;
import com.baidu.navisdk.pronavi.ui.bucket.item.concrete.w;
import com.baidu.navisdk.pronavi.ui.bucket.item.concrete.y;
import com.baidu.navisdk.ui.roadcondition.view.BNSmartRoadConditionLayout;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.model.i;
import com.baidu.navisdk.ui.widget.bucket.BNViewPriorityBucket;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class RGRightBucketComponent extends RGBaseBucketComponent<com.baidu.navisdk.pronavi.ui.base.b> implements com.baidu.navisdk.framework.interfaces.pronavi.hd.c {
    private View.OnLayoutChangeListener A;
    private Rect B;
    private Runnable C;

    /* loaded from: classes7.dex */
    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9 = i4 - i2;
            if (i9 != i8 - i6 && RGRightBucketComponent.this.P()) {
                g gVar = g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e(((Func) RGRightBucketComponent.this).g, "onLayoutChange: updateRoadConditionHeight:" + i9);
                }
                RGRightBucketComponent.this.T();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RGRightBucketComponent.this.W();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(((Func) RGRightBucketComponent.this).g, "refreshBucketMarginTop run: ");
            }
            RGRightBucketComponent.this.V();
        }
    }

    public RGRightBucketComponent(@NonNull com.baidu.navisdk.pronavi.ui.base.b bVar) {
        super(bVar, false, false);
        this.C = null;
    }

    private void K() {
        R();
        O();
        if (this.k != null) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(this.g, "addBucketLayoutListener: ");
            }
            this.k.addOnLayoutChangeListener(this.A);
        }
    }

    private void L() {
        View view;
        Runnable runnable = this.C;
        if (runnable != null && (view = this.k) != null) {
            view.removeCallbacks(runnable);
        }
    }

    private void M() {
        w wVar = (w) a(12, w.class);
        if (wVar != null) {
            wVar.v();
        }
    }

    private ViewGroup N() {
        r rVar = (r) a(19, r.class);
        if (rVar != null) {
            return rVar.v();
        }
        return null;
    }

    private void O() {
        if (this.A == null) {
            this.A = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P() {
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.fullview.c cVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.fullview.c) a(23, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.fullview.c.class);
        if (cVar != null && cVar.v()) {
            return true;
        }
        return false;
    }

    private void Q() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "refreshBucketMarginTop: ");
        }
        View view = this.k;
        if (view == null) {
            return;
        }
        view.post(new c());
    }

    private void R() {
        View.OnLayoutChangeListener onLayoutChangeListener;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "removeBucketLayoutListener: ");
        }
        View view = this.k;
        if (view != null && (onLayoutChangeListener = this.A) != null) {
            view.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    private void S() {
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.a aVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.a) a(37, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.a.class);
        if (aVar != null) {
            aVar.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        if (this.C == null) {
            this.C = new b();
        } else {
            L();
        }
        View view = this.k;
        if (view != null) {
            view.post(this.C);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean U() {
        int r;
        Rect rect = this.B;
        if (rect == null) {
            this.B = new Rect();
        } else {
            rect.setEmpty();
        }
        View view = null;
        for (int i = 0; i < this.r.getChildCount(); i++) {
            view = this.r.getChildAt(i);
            if (!this.r.isSpaceView(view) && view.getVisibility() == 0) {
                break;
            }
        }
        if (view instanceof BNSmartRoadConditionLayout) {
            ((BNSmartRoadConditionLayout) view).a(this.B);
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(this.g, "topRightPanelWhetherTheCollision: 路况条：" + this.B);
            }
        } else {
            a(view, this.B);
            g gVar2 = g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e(this.g, "topRightPanelWhetherTheCollision: 其他：" + this.B);
            }
        }
        if (((com.baidu.navisdk.pronavi.ui.base.b) n()).E()) {
            r = ((com.baidu.navisdk.pronavi.ui.base.b) n()).q();
        } else {
            r = ((com.baidu.navisdk.pronavi.ui.base.b) n()).r();
        }
        if (this.B.top >= r) {
            return false;
        }
        Rect W = x.b().W();
        g gVar3 = g.PRO_NAV;
        if (gVar3.d()) {
            gVar3.e(this.g, "topRightPanelWhetherTheCollision:laneLineLocation: " + W);
        }
        if (W != null && this.B.left > 0) {
            if (W.right + JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_3dp) >= this.B.left) {
                if (gVar3.d()) {
                    gVar3.e(this.g, "topRightPanelWhetherTheCollision -> return true");
                    return true;
                }
                return true;
            }
        }
        if (gVar3.d()) {
            gVar3.e(this.g, "topRightPanelWhetherTheCollision -> return false");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        int dimensionPixelSize;
        boolean z;
        if (this.k == null) {
            return;
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "updateBucketMarginTop: ");
        }
        try {
            boolean E = ((com.baidu.navisdk.pronavi.ui.base.b) this.i).E();
            if (E) {
                dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_guide_panel_shadow_bottom);
            } else {
                dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_assist_panel_margin_top_land);
            }
            if (gVar.d()) {
                gVar.e(this.g, "refreshTopRightPanelMarginTop -> isLaneLineViewVisible : " + x.b().p2() + ",isAnyEnlargeRoadMapShowing: " + i.s().k() + ", isShowEnlargeRoadMap : " + x.b().C2());
            }
            if (x.b().p2() && (!i.s().k() || !x.b().C2())) {
                if (E && x.b().g2()) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z && !U()) {
                    if (gVar.d()) {
                        gVar.e(this.g, "refreshTopRightPanelMarginTop->车道线，高速面板出现，未发生碰撞！");
                    }
                }
                if (gVar.d()) {
                    gVar.e(this.g, "refreshTopRightPanelMarginTop-> 高速面板出现，与车道线发生碰撞！needCalcCollision : " + z);
                }
                dimensionPixelSize = dimensionPixelSize + JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_hw_simple_board_margin_top) + x.b().X();
            }
            if (gVar.d()) {
                gVar.e(this.g, "refreshTopRightPanelMarginTop --> marginTop= " + dimensionPixelSize);
            }
            ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (marginLayoutParams.topMargin != dimensionPixelSize) {
                    marginLayoutParams.topMargin = dimensionPixelSize;
                    this.k.requestLayout();
                }
            }
        } catch (Exception e) {
            LogUtil.printException("refreshTopRightPanelMarginTop()", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        if (this.k != null && P()) {
            int height = (this.k.getHeight() - this.k.getPaddingTop()) - this.k.getPaddingBottom();
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(this.g, "updateRoadConditionHeight--1: " + height);
            }
            int childCount = this.r.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.r.getChildAt(i);
                if (childAt != null && childAt.getVisibility() != 8) {
                    Object tag = childAt.getTag();
                    g gVar2 = g.PRO_NAV;
                    if (gVar2.d()) {
                        gVar2.e(this.g, "updateRoadConditionHeight tag: " + tag + ", childCount:" + childCount);
                    }
                    if (!(tag instanceof String) || (!BNViewPriorityBucket.SPACE_VIEW_TAG.equals(tag) && !"RoadConditionView".equals(tag))) {
                        int measuredHeight = childAt.getMeasuredHeight();
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                        if (marginLayoutParams != null) {
                            measuredHeight += marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                        }
                        height -= measuredHeight;
                    }
                } else {
                    g gVar3 = g.PRO_NAV;
                    if (gVar3.d()) {
                        gVar3.e(this.g, "updateRoadConditionHeight: " + childAt);
                    }
                }
            }
            int dimensionPixelSize = height - JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_5dp);
            g gVar4 = g.PRO_NAV;
            if (gVar4.d()) {
                gVar4.e(this.g, "updateRoadConditionHeight--2: " + dimensionPixelSize);
            }
            com.baidu.navisdk.pronavi.ui.bucket.item.concrete.fullview.c cVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.fullview.c) a(23, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.fullview.c.class);
            if (cVar != null) {
                cVar.d(dimensionPixelSize);
                return;
            }
            return;
        }
        g gVar5 = g.PRO_NAV;
        if (gVar5.d()) {
            gVar5.e(this.g, "updateRoadConditionHeight:mPriorityBucket null: " + P());
        }
    }

    private void X() {
        a0 a0Var = (a0) a(16, a0.class);
        if (a0Var != null) {
            a0Var.v();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.RGBaseBucketComponent
    public void G() {
        super.G();
        K();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.RGBaseBucketComponent
    public void H() {
        super.H();
        if (this.k != null && P()) {
            T();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.RGBaseBucketComponent, com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.BaseFunc
    public void h() {
        R();
        L();
        super.h();
    }

    @Override // com.baidu.navisdk.framework.func.Func
    public String o() {
        return "RGRightBucketComponent";
    }

    @Override // com.baidu.navisdk.pronavi.state.RGUiStateModule, com.baidu.navisdk.comapi.base.b
    public void update(com.baidu.navisdk.comapi.base.c cVar, int i, int i2, Object obj) {
        super.update(cVar, i, i2, obj);
        if (i == 2 && i2 == 518) {
            M();
        }
    }

    @Override // com.baidu.navisdk.uiframe.UiModule, com.baidu.navisdk.framework.func.Func, com.baidu.navisdk.apicenter.c
    public h a(@NonNull com.baidu.navisdk.apicenter.a aVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "execute: " + aVar);
        }
        int d = aVar.d();
        if (d == 1005) {
            J();
            return null;
        }
        if (d == 1017) {
            b(aVar);
            return null;
        }
        if (d == 1024) {
            j jVar = (j) a(17, j.class);
            if (jVar != null) {
                jVar.b(aVar.b("paramA"));
            }
            return null;
        }
        if (d == 2006) {
            X();
            return null;
        }
        if (d == 2013) {
            T();
            return null;
        }
        if (d != 2018) {
            switch (d) {
                case 2001:
                    l lVar = (l) a(15, l.class);
                    if (lVar != null) {
                        lVar.b(aVar.b("paramA"));
                    }
                    return null;
                case 2002:
                    p pVar = (p) a(14, p.class);
                    if (pVar != null) {
                        pVar.b(aVar.b("paramA"));
                    }
                    return null;
                case 2003:
                    com.baidu.navisdk.pronavi.ui.bucket.item.concrete.x xVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.x) a(21, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.x.class);
                    if (xVar != null) {
                        xVar.b(aVar.b("paramA"));
                    }
                    return null;
                case 2004:
                    return h.a().a(this);
                default:
                    switch (d) {
                        case 2009:
                            com.baidu.navisdk.pronavi.ui.bucket.item.concrete.g gVar2 = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.g) a(29, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.g.class);
                            if (gVar2 != null) {
                                gVar2.y();
                            }
                            return null;
                        case 2010:
                            Q();
                            return null;
                        case 2011:
                            return h.a().a(N());
                        default:
                            return null;
                    }
            }
        }
        S();
        return null;
    }

    @Override // com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule
    public View b(int i, @Nullable View view) {
        if (view != null) {
            View findViewById = view.findViewById(R.id.nsdk_rg_right_bucket);
            this.r = (BNViewPriorityBucket) findViewById.findViewById(R.id.nsdk_rg_right_top_bucket);
            if (this.x) {
                this.s = (BNViewPriorityBucket) findViewById.findViewById(R.id.nsdk_rg_right_bottom_bucket);
            }
            return findViewById;
        }
        g gVar = g.PRO_NAV;
        if (!gVar.c()) {
            return null;
        }
        gVar.c(this.g, "onContentViewCreate: parentModuleContentView is null ");
        return null;
    }

    public void d(boolean z) {
        com.baidu.navisdk.pronavi.ui.bucket.item.a aVar = (com.baidu.navisdk.pronavi.ui.bucket.item.a) a(22, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.fullview.a.class);
        if (aVar != null) {
            aVar.refreshVisible();
        }
        com.baidu.navisdk.pronavi.ui.bucket.item.a aVar2 = (com.baidu.navisdk.pronavi.ui.bucket.item.a) a(23, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.fullview.c.class);
        if (aVar2 != null) {
            aVar2.refreshVisible();
        }
        com.baidu.navisdk.pronavi.ui.bucket.item.a aVar3 = (com.baidu.navisdk.pronavi.ui.bucket.item.a) a(24, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.fullview.b.class);
        if (aVar3 != null) {
            aVar3.refreshVisible();
        }
    }

    private void b(com.baidu.navisdk.apicenter.a aVar) {
        int c2 = aVar.c("paramA");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "refreshBtnVisible: " + com.baidu.navisdk.ui.routeguide.utils.b.a(c2));
        }
        if (c2 == 18) {
            y yVar = (y) a(c2, y.class);
            if (yVar != null) {
                yVar.v();
                return;
            }
            return;
        }
        if (c2 == 19) {
            r rVar = (r) a(c2, r.class);
            if (rVar != null) {
                rVar.b(aVar.b("paramB"));
                return;
            }
            return;
        }
        if (c2 != 37) {
            switch (c2) {
                case 22:
                    com.baidu.navisdk.pronavi.ui.bucket.item.concrete.fullview.a aVar2 = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.fullview.a) a(c2, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.fullview.a.class);
                    if (aVar2 != null) {
                        aVar2.refreshVisible();
                        return;
                    }
                    return;
                case 23:
                    com.baidu.navisdk.pronavi.ui.bucket.item.concrete.fullview.c cVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.fullview.c) a(c2, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.fullview.c.class);
                    if (cVar != null) {
                        cVar.refreshVisible();
                        return;
                    }
                    return;
                case 24:
                    com.baidu.navisdk.pronavi.ui.bucket.item.concrete.fullview.b bVar = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.fullview.b) a(c2, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.fullview.b.class);
                    if (bVar != null) {
                        bVar.refreshVisible();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        com.baidu.navisdk.pronavi.ui.bucket.item.concrete.a aVar3 = (com.baidu.navisdk.pronavi.ui.bucket.item.concrete.a) a(c2, com.baidu.navisdk.pronavi.ui.bucket.item.concrete.a.class);
        if (aVar3 != null) {
            aVar3.b(aVar.b("paramB"));
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.RGBaseBucketComponent, com.baidu.navisdk.pronavi.ui.base.RGUiComponent, com.baidu.navisdk.uiframe.UiModule
    public void a(Configuration configuration) {
        R();
        L();
        super.a(configuration);
        x.b().b(configuration);
        Q();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.navisdk.pronavi.ui.bucket.RGBaseBucketComponent
    public int a(int i, int i2, f fVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.g, "getMarginBottom: " + i + "，" + fVar);
        }
        int dimensionPixelSize = com.baidu.navisdk.util.common.x.s() ? 0 : JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_new_control_panel_bottom_margin);
        if (i == 2) {
            return i2;
        }
        if (i != 3) {
            return dimensionPixelSize;
        }
        if (fVar.f != 1 || fVar.g(((com.baidu.navisdk.pronavi.ui.base.b) n()).E())) {
            return 0;
        }
        return dimensionPixelSize;
    }

    private void a(View view, Rect rect) {
        if (view == null) {
            return;
        }
        view.getGlobalVisibleRect(rect);
        while (rect.left < 100 && (view instanceof ViewGroup) && (view = ((ViewGroup) view).getChildAt(0)) != null && view.getVisibility() == 0) {
            view.getGlobalVisibleRect(rect);
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(this.g, "topRightPanelWhetherTheCollision: " + rect);
            }
        }
    }
}
