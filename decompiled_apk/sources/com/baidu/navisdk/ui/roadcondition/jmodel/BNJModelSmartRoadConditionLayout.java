package com.baidu.navisdk.ui.roadcondition.jmodel;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.m;
import com.baidu.navisdk.module.pronavi.model.c;
import com.baidu.navisdk.ui.roadcondition.view.BNSmartRoadConditionLayout;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.lite.b;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class BNJModelSmartRoadConditionLayout extends BNSmartRoadConditionLayout {
    private BNJModelRoadConditionView q;
    private int r;
    private b s;

    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new a(null);
    }

    @xoIox
    public BNJModelSmartRoadConditionLayout(@OOXIXo Context context) {
        this(context, null, 0, 6, null);
    }

    private final void d() {
        this.r = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_20dp);
    }

    @Override // com.baidu.navisdk.ui.roadcondition.view.BNSmartRoadConditionLayout
    public void a(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        a(context, R.layout.nsdk_layout_rg_jmodel_road_condition_view, (ViewGroup) this, true, false);
        View findViewById = findViewById(R.id.bnav_rg_cp_roadconditionbar);
        IIX0o.oO(findViewById, "findViewById(R.id.bnav_rg_cp_roadconditionbar)");
        this.q = (BNJModelRoadConditionView) findViewById;
        c();
    }

    @Override // com.baidu.navisdk.ui.roadcondition.view.BNSmartRoadConditionLayout
    public int getRoadConditionHeight() {
        BNJModelRoadConditionView bNJModelRoadConditionView = this.q;
        if (bNJModelRoadConditionView == null) {
            IIX0o.XOxIOxOx("mRoadConditionView");
        }
        return bNJModelRoadConditionView.getViewHeight();
    }

    @Override // com.baidu.navisdk.ui.roadcondition.view.BNSmartRoadConditionLayout
    @OOXIXo
    public View getRoadConditionView() {
        BNJModelRoadConditionView bNJModelRoadConditionView = this.q;
        if (bNJModelRoadConditionView == null) {
            IIX0o.XOxIOxOx("mRoadConditionView");
        }
        return bNJModelRoadConditionView;
    }

    @Override // com.baidu.navisdk.ui.roadcondition.view.BNSmartRoadConditionLayout
    public int getRoadConditionWidth() {
        return this.r;
    }

    @Override // com.baidu.navisdk.ui.roadcondition.view.BNSmartRoadConditionLayout
    public void setClickListener(@OOXIXo com.baidu.navisdk.ui.roadcondition.i.a clickListener) {
        IIX0o.x0xO0oo(clickListener, "clickListener");
    }

    @xoIox
    public BNJModelSmartRoadConditionLayout(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ BNJModelSmartRoadConditionLayout(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public BNJModelSmartRoadConditionLayout(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        d();
    }

    @Override // com.baidu.navisdk.ui.roadcondition.view.BNSmartRoadConditionLayout
    public void a(@oOoXoXO List<? extends m> list, @oOoXoXO List<? extends c> list2, double d) {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("BNJModelSmartRoadConditionLayout", "updateRoadCondition: data = " + list);
        }
        BNJModelRoadConditionView bNJModelRoadConditionView = this.q;
        if (bNJModelRoadConditionView == null) {
            IIX0o.XOxIOxOx("mRoadConditionView");
        }
        bNJModelRoadConditionView.a(d);
        if (list != null && !list.isEmpty()) {
            BNJModelRoadConditionView bNJModelRoadConditionView2 = this.q;
            if (bNJModelRoadConditionView2 == null) {
                IIX0o.XOxIOxOx("mRoadConditionView");
            }
            bNJModelRoadConditionView2.a(list);
        } else {
            BNJModelRoadConditionView bNJModelRoadConditionView3 = this.q;
            if (bNJModelRoadConditionView3 == null) {
                IIX0o.XOxIOxOx("mRoadConditionView");
            }
            bNJModelRoadConditionView3.c();
        }
        BNJModelRoadConditionView bNJModelRoadConditionView4 = this.q;
        if (bNJModelRoadConditionView4 == null) {
            IIX0o.XOxIOxOx("mRoadConditionView");
        }
        bNJModelRoadConditionView4.invalidate();
    }

    @Override // com.baidu.navisdk.ui.roadcondition.view.BNSmartRoadConditionLayout
    public void a(double d) {
        BNJModelRoadConditionView bNJModelRoadConditionView = this.q;
        if (bNJModelRoadConditionView == null) {
            IIX0o.XOxIOxOx("mRoadConditionView");
        }
        bNJModelRoadConditionView.a(d);
        BNJModelRoadConditionView bNJModelRoadConditionView2 = this.q;
        if (bNJModelRoadConditionView2 == null) {
            IIX0o.XOxIOxOx("mRoadConditionView");
        }
        bNJModelRoadConditionView2.invalidate();
    }

    @Override // com.baidu.navisdk.ui.roadcondition.view.BNSmartRoadConditionLayout
    public void a(int i) {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("BNJModelSmartRoadConditionLayout", "updateRoadConditionType: " + i);
        }
        BNJModelRoadConditionView bNJModelRoadConditionView = this.q;
        if (bNJModelRoadConditionView == null) {
            IIX0o.XOxIOxOx("mRoadConditionView");
        }
        bNJModelRoadConditionView.a(i);
        BNJModelRoadConditionView bNJModelRoadConditionView2 = this.q;
        if (bNJModelRoadConditionView2 == null) {
            IIX0o.XOxIOxOx("mRoadConditionView");
        }
        bNJModelRoadConditionView2.invalidate();
    }

    @Override // com.baidu.navisdk.ui.roadcondition.view.BNSmartRoadConditionLayout
    public void a(@OOXIXo Rect rect) {
        IIX0o.x0xO0oo(rect, "rect");
        BNJModelRoadConditionView bNJModelRoadConditionView = this.q;
        if (bNJModelRoadConditionView == null) {
            IIX0o.XOxIOxOx("mRoadConditionView");
        }
        bNJModelRoadConditionView.getGlobalVisibleRect(rect);
    }

    @Override // com.baidu.navisdk.ui.roadcondition.view.BNSmartRoadConditionLayout
    public void a() {
        b bVar = this.s;
        if (bVar != null) {
            com.baidu.navisdk.util.worker.lite.a.a(bVar);
            this.s = null;
        }
        BNJModelRoadConditionView bNJModelRoadConditionView = this.q;
        if (bNJModelRoadConditionView == null) {
            IIX0o.XOxIOxOx("mRoadConditionView");
        }
        bNJModelRoadConditionView.setOnClickListener(null);
        BNJModelRoadConditionView bNJModelRoadConditionView2 = this.q;
        if (bNJModelRoadConditionView2 == null) {
            IIX0o.XOxIOxOx("mRoadConditionView");
        }
        bNJModelRoadConditionView2.a();
    }
}
