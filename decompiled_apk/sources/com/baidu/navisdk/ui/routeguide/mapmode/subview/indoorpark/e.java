package com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.f;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.a;
import com.baidu.navisdk.ui.routeguide.model.o;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.List;

/* loaded from: classes8.dex */
public class e extends com.baidu.navisdk.ui.routeguide.widget.d implements b, View.OnClickListener {
    private ViewGroup i;
    private ViewGroup j;
    private ViewGroup k;
    private ViewGroup l;
    private TextView m;
    private d n;
    private c o;
    private com.baidu.navisdk.ui.routeguide.control.indoorpark.a p;

    public e(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.control.indoorpark.a aVar) {
        super(context, viewGroup);
        if (this.f9165a == null) {
            LogUtil.e("RGMMIndoorParkView", "------3");
            LogUtil.printCallStack();
        }
        this.p = aVar;
        r0();
        q0();
    }

    private void q0() {
        this.l.setOnClickListener(this);
    }

    private void r0() {
        ViewGroup viewGroup = (ViewGroup) JarUtils.inflate(this.f9165a, R.layout.bnav_layout_indoor_park_layout, null);
        this.i = viewGroup;
        this.j = (ViewGroup) viewGroup.findViewById(R.id.indoor_park_floor_filter_container);
        this.k = (ViewGroup) this.i.findViewById(R.id.indoor_park_bottombar_container);
        this.l = (ViewGroup) this.i.findViewById(R.id.bnav_rg_indoor_fullview_group);
        this.m = (TextView) this.i.findViewById(R.id.bnav_rg_indoor_fullview_tv);
        ViewGroup viewGroup2 = this.b;
        if (viewGroup2 != null) {
            ((ViewGroup) viewGroup2.findViewById(R.id.bnav_rg_indoor_park_container)).addView(this.i);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.b
    public void D() {
        c cVar = this.o;
        if (cVar != null) {
            cVar.f(JarUtils.getResources().getString(R.string.nsdk_string_indoor_nav_bottombar_yawing_text));
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.b
    public void K() {
        if (this.p.b()) {
            p0();
            b(this.p.a().j());
        } else {
            n0();
        }
        o0();
        c cVar = this.o;
        if (cVar != null) {
            cVar.o0();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.b
    public void M() {
        n0();
        o0();
        c cVar = this.o;
        if (cVar != null) {
            cVar.n0();
            w();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.b
    public void R() {
        this.l.setVisibility(0);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.b
    public void W() {
        w();
    }

    public void a(ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        this.b = viewGroup;
        if (viewGroup == null || (viewGroup2 = this.i) == null) {
            return;
        }
        if (viewGroup2.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.i.getParent()).removeView(this.i);
        }
        viewGroup.addView(this.i);
    }

    public void b(List<String> list) {
        d dVar = this.n;
        if (dVar != null) {
            dVar.b(list);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.b
    public void b0() {
        this.l.setVisibility(8);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        LogUtil.e("RGMMIndoorParkView", "dispose");
        d dVar = this.n;
        if (dVar != null) {
            dVar.i();
            this.n = null;
        }
        c cVar = this.o;
        if (cVar != null) {
            cVar.i();
            this.o = null;
        }
    }

    public void n0() {
        d dVar = this.n;
        if (dVar != null) {
            dVar.c();
        }
    }

    public void o0() {
        if (this.o == null) {
            this.o = new c(this.f9165a, this.k, this.p);
        }
        this.o.y();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.bnav_rg_indoor_fullview_group) {
            this.p.c();
        }
    }

    public void p0() {
        if (this.n == null) {
            this.n = new d(this.f9165a, this.j, this.p);
        }
        this.n.y();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.b
    public void t(boolean z) {
        if (z) {
            this.m.setTextSize(0, JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_9dp));
            this.m.setText("退出全览");
        } else {
            this.m.setTextSize(0, JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_11dp));
            this.m.setText("全览");
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.b
    public void w() {
        RoutePlanNode routePlanNode;
        String string;
        o.a g = this.p.a().g();
        f fVar = (f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (fVar != null) {
            routePlanNode = fVar.g();
        } else {
            routePlanNode = null;
        }
        if (g != null && !TextUtils.isEmpty(g.a())) {
            string = g.a();
        } else if (routePlanNode != null && !TextUtils.isEmpty(routePlanNode.getName())) {
            string = routePlanNode.getName();
        } else {
            string = JarUtils.getResources().getString(R.string.nsdk_string_indoor_nav_bottombar_yawing_text);
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMIndoorParkView", "updateStallName-> " + string);
        }
        this.o.f(string);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.b
    public void b(String str) {
        d dVar = this.n;
        if (dVar != null) {
            dVar.b(str);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.indoorpark.b
    public void a(a.c cVar) {
        d dVar = this.n;
        if (dVar != null) {
            dVar.a(cVar);
        }
    }
}
