package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.roadcondition.view.BNSmartRoadConditionLayout;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.List;

/* loaded from: classes8.dex */
public class m1 extends com.baidu.navisdk.ui.routeguide.widget.d {
    private BNSmartRoadConditionLayout i;
    private com.baidu.navisdk.ui.roadcondition.i.a j;
    private int k;

    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f8827a;
        final /* synthetic */ List b;
        final /* synthetic */ double c;

        public b(List list, List list2, double d) {
            this.f8827a = list;
            this.b = list2;
            this.c = d;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m1.this.i != null) {
                m1.this.i.a(this.f8827a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f8828a;

        public c(List list) {
            this.f8828a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m1.this.i != null) {
                m1.this.i.b(this.f8828a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f8829a;

        public d(List list) {
            this.f8829a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m1.this.i != null) {
                m1.this.i.a(this.f8829a);
            }
        }
    }

    public m1(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.k = 0;
        t0();
    }

    private void s0() {
        if (this.j == null) {
            this.j = new a();
        }
        this.i.setClickListener(this.j);
    }

    private void t0() {
        this.i = (BNSmartRoadConditionLayout) this.b.findViewById(R.id.bnav_rg_cp_roadconditionbar_layout);
        s0();
    }

    public void c(List<com.baidu.navisdk.model.datastruct.m> list) {
        BNSmartRoadConditionLayout bNSmartRoadConditionLayout = this.i;
        if (bNSmartRoadConditionLayout != null) {
            if (bNSmartRoadConditionLayout.getRoadConditionHeight() > 0) {
                this.i.b(list);
                return;
            }
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGRoadConditionView", "updateRoadCondition run: getRoadConditionHeight <= 0 ");
            }
            this.i.post(new c(list));
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        BNSmartRoadConditionLayout bNSmartRoadConditionLayout = this.i;
        if (bNSmartRoadConditionLayout != null) {
            bNSmartRoadConditionLayout.a();
        }
    }

    public View n0() {
        BNSmartRoadConditionLayout bNSmartRoadConditionLayout = this.i;
        if (bNSmartRoadConditionLayout != null) {
            return bNSmartRoadConditionLayout.getRoadConditionView();
        }
        return null;
    }

    public BNSmartRoadConditionLayout o0() {
        return this.i;
    }

    public int p0() {
        BNSmartRoadConditionLayout bNSmartRoadConditionLayout = this.i;
        if (bNSmartRoadConditionLayout != null) {
            return bNSmartRoadConditionLayout.getVisibility();
        }
        return 8;
    }

    public void q0() {
        BNSmartRoadConditionLayout bNSmartRoadConditionLayout = this.i;
        if (bNSmartRoadConditionLayout != null) {
            bNSmartRoadConditionLayout.a();
        }
    }

    public void r0() {
        BNSmartRoadConditionLayout bNSmartRoadConditionLayout = this.i;
        if (bNSmartRoadConditionLayout != null) {
            bNSmartRoadConditionLayout.b();
        }
    }

    public boolean v(int i) {
        Object obj;
        BNSmartRoadConditionLayout bNSmartRoadConditionLayout = this.i;
        if (bNSmartRoadConditionLayout != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) bNSmartRoadConditionLayout.getLayoutParams();
            if (LogUtil.LOGGABLE) {
                StringBuilder sb = new StringBuilder();
                sb.append("setRoadConditionBarMarginTop-> marginTop= ");
                sb.append(i);
                sb.append(",params.topMargin= ");
                if (marginLayoutParams != null) {
                    obj = Integer.valueOf(marginLayoutParams.topMargin);
                } else {
                    obj = "null";
                }
                sb.append(obj);
                LogUtil.e("RGRoadConditionView", sb.toString());
            }
            if (marginLayoutParams != null && marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                this.i.setLayoutParams(marginLayoutParams);
                return true;
            }
        }
        return false;
    }

    public void w(int i) {
        BNSmartRoadConditionLayout bNSmartRoadConditionLayout = this.i;
        if (bNSmartRoadConditionLayout != null) {
            bNSmartRoadConditionLayout.setVisibility(i);
        }
    }

    public void b(List<com.baidu.navisdk.module.pronavi.model.c> list) {
        BNSmartRoadConditionLayout bNSmartRoadConditionLayout = this.i;
        if (bNSmartRoadConditionLayout != null) {
            if (bNSmartRoadConditionLayout.getRoadConditionHeight() > 0) {
                this.i.a(list);
                return;
            }
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGRoadConditionView", "updateJamLabel run: getRoadConditionHeight <= 0 ");
            }
            this.i.post(new d(list));
        }
    }

    public m1(Context context, BNSmartRoadConditionLayout bNSmartRoadConditionLayout) {
        super(context, null);
        this.k = 0;
        this.i = bNSmartRoadConditionLayout;
        s0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        i();
        t0();
        BNSmartRoadConditionLayout bNSmartRoadConditionLayout = this.i;
        if (bNSmartRoadConditionLayout != null) {
            bNSmartRoadConditionLayout.a(this.k);
        }
    }

    /* loaded from: classes8.dex */
    public class a implements com.baidu.navisdk.ui.roadcondition.i.a {
        public a() {
        }

        @Override // com.baidu.navisdk.ui.roadcondition.i.a
        public void a(int i, int i2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGRoadConditionView", "onClickSwitchType: " + i + ",currentType: " + i2);
            }
            m1.this.k = i2;
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.16.1", String.valueOf(m1.this.k), String.valueOf(i));
        }

        @Override // com.baidu.navisdk.ui.roadcondition.i.a
        public boolean a(com.baidu.navisdk.module.pronavi.model.c cVar) {
            return m1.this.b(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(com.baidu.navisdk.module.pronavi.model.c cVar) {
        if (com.baidu.navisdk.ui.routeguide.b.V().j() != null) {
            return com.baidu.navisdk.ui.routeguide.b.V().j().k().a(cVar);
        }
        return false;
    }

    public void a(List<com.baidu.navisdk.model.datastruct.m> list, List<com.baidu.navisdk.module.pronavi.model.c> list2, double d2) {
        BNSmartRoadConditionLayout bNSmartRoadConditionLayout = this.i;
        if (bNSmartRoadConditionLayout != null) {
            if (bNSmartRoadConditionLayout.getRoadConditionHeight() > 0) {
                this.i.a(list, list2, d2);
                return;
            }
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGRoadConditionView", "updateWhenLoadRoadConditionDone run: getRoadConditionHeight <= 0 ");
            }
            this.i.post(new b(list, list2, d2));
        }
    }

    public void a(double d2) {
        BNSmartRoadConditionLayout bNSmartRoadConditionLayout = this.i;
        if (bNSmartRoadConditionLayout != null) {
            bNSmartRoadConditionLayout.a(d2);
        }
    }

    public void a(com.baidu.navisdk.module.pronavi.model.c cVar) {
        BNSmartRoadConditionLayout bNSmartRoadConditionLayout = this.i;
        if (bNSmartRoadConditionLayout != null) {
            bNSmartRoadConditionLayout.a(cVar);
        }
    }

    public void a(Rect rect) {
        BNSmartRoadConditionLayout bNSmartRoadConditionLayout = this.i;
        if (bNSmartRoadConditionLayout != null) {
            bNSmartRoadConditionLayout.a(rect);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        BNSmartRoadConditionLayout bNSmartRoadConditionLayout = this.i;
        if (bNSmartRoadConditionLayout != null) {
            bNSmartRoadConditionLayout.c();
        }
    }
}
