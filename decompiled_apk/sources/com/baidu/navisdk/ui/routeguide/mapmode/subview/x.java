package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.adapter.a;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.n;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.utils.a;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class x extends com.baidu.navisdk.ui.routeguide.widget.d implements a.e, View.OnClickListener, com.baidu.navisdk.framework.interfaces.pronavi.hd.c {
    private final int i;
    private final int j;
    private View k;
    private View l;
    private TextView m;
    private RecyclerView n;
    private com.baidu.navisdk.ui.routeguide.adapter.a o;
    private boolean p;
    boolean q;
    private final com.baidu.navisdk.util.worker.f<String, String> r;
    private final RecyclerView.OnScrollListener s;

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.f<String, String> {
        public a(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "mAutoHideTask-> auto hide!");
            }
            if (x.this.a()) {
                x.this.c();
            }
            x.this.p = false;
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            String str;
            super.onScrollStateChanged(recyclerView, i);
            if (i != 0) {
                if ((i == 1 || i == 2) && x.this.p) {
                    if (LogUtil.LOGGABLE) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("mAutoHideTask-> newState = ");
                        if (i == 1) {
                            str = "SCROLL_STATE_DRAGGING";
                        } else {
                            str = "SCROLL_STATE_SETTLING";
                        }
                        sb.append(str);
                        sb.append("cancelAutoHideTimer!");
                        LogUtil.e("RGMMHighwaySubscribeView", sb.toString());
                    }
                    x.this.o0();
                    return;
                }
                return;
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMMHighwaySubscribeView", "mAutoHideTask-> newState = SCROLL_STATE_IDLE startAutoHideTimer!");
            }
            x.this.y0();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements n.e {
        public c() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.model.n.e
        public void a() {
            if (x.this.p0() != null && !x.this.p0().s() && com.baidu.navisdk.ui.routeguide.model.t.s().i()) {
                x.this.n0();
            }
            if (x.this.n != null) {
                x.this.n.scrollToPosition(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Animation.AnimationListener {
        public d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            x.this.t0();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public x(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.i = com.baidu.navisdk.h.c();
        this.j = com.baidu.navisdk.ui.util.b.b(R.color.nsdk_rg_transparent);
        this.p = false;
        this.q = false;
        this.r = new a("RGMMHighwaySubscribeView-mAutoHideTask", null);
        this.s = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.r, true);
        this.p = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.navisdk.ui.routeguide.model.n p0() {
        return com.baidu.navisdk.ui.routeguide.b.V().i().c();
    }

    private void q0() {
        View view = this.l;
        if (view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        com.baidu.navisdk.framework.interfaces.pronavi.hd.f h0 = h0();
        int i = 0;
        if (h0.f6817a == 2) {
            i = com.baidu.navisdk.ui.routeguide.utils.b.a(false, h0);
        }
        Pair<Integer, Integer> d2 = d(h0.f6817a, i);
        if (marginLayoutParams.leftMargin == ((Integer) d2.first).intValue() && marginLayoutParams.rightMargin == ((Integer) d2.second).intValue()) {
            return;
        }
        marginLayoutParams.leftMargin = ((Integer) d2.first).intValue();
        marginLayoutParams.rightMargin = ((Integer) d2.second).intValue();
        this.l.requestLayout();
    }

    private void r0() {
        if (this.l != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            if (this.f == 1) {
                layoutParams.topMargin = com.baidu.navisdk.module.newguide.a.e().c();
                Resources resources = JarUtils.getResources();
                int i = R.dimen.nsdk_rg_toolbox_margin_left;
                layoutParams.leftMargin = resources.getDimensionPixelOffset(i);
                layoutParams.bottomMargin = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_8dp);
                layoutParams.rightMargin = JarUtils.getResources().getDimensionPixelOffset(i);
            } else {
                layoutParams.leftMargin = com.baidu.navisdk.ui.routeguide.control.x.b().V();
                layoutParams.topMargin = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_guide_panel_shadow_top);
                layoutParams.bottomMargin = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_guide_panel_shadow_bottom);
                layoutParams.rightMargin = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_toolbox_margin_left);
                if (com.baidu.navisdk.ui.routeguide.mapmode.subview.a.c().b()) {
                    int statusBarHeight = ScreenUtil.getInstance().getStatusBarHeight(com.baidu.navisdk.ui.routeguide.b.V().b());
                    layoutParams.leftMargin += statusBarHeight;
                    layoutParams.rightMargin += statusBarHeight;
                }
            }
            this.l.setLayoutParams(layoutParams);
        }
    }

    private void s0() {
        ViewStub viewStub = (ViewStub) this.b.findViewById(R.id.navi_rg_highway_subscript_stub);
        if (viewStub != null) {
            com.baidu.navisdk.ui.util.b.a(viewStub);
        }
        View findViewById = this.b.findViewById(R.id.navi_rg_highway_subscript_layout);
        this.k = findViewById;
        findViewById.setBackgroundColor(com.baidu.navisdk.h.c());
        this.k.setOnClickListener(this);
        View findViewById2 = this.b.findViewById(R.id.hw_subscript_content_view);
        this.l = findViewById2;
        findViewById2.setOnClickListener(this);
        r0();
        this.m = (TextView) this.k.findViewById(R.id.hw_subscript_title);
        RecyclerView recyclerView = (RecyclerView) this.k.findViewById(R.id.hw_subscript_list_view);
        this.n = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f9165a));
        com.baidu.navisdk.ui.routeguide.adapter.a aVar = new com.baidu.navisdk.ui.routeguide.adapter.a(this.f9165a, this.l);
        this.o = aVar;
        aVar.a(this);
        this.n.setAdapter(this.o);
        this.n.addOnScrollListener(this.s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        View view = this.l;
        if (view != null && this.k != null) {
            view.clearAnimation();
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            if (p0() != null) {
                p0().v();
            }
            o0();
        }
    }

    private void u0() {
        if (p0() != null) {
            p0().a(true, (n.e) new c());
        }
    }

    private void w0() {
        View view = this.k;
        if (view != null) {
            ObjectAnimator ofInt = ObjectAnimator.ofInt(view, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, this.j, this.i);
            ofInt.setDuration(200L);
            ofInt.setEvaluator(new ArgbEvaluator());
            ofInt.start();
        }
    }

    private void x0() {
        View view = this.k;
        if (view != null) {
            ObjectAnimator ofInt = ObjectAnimator.ofInt(view, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, this.i, this.j);
            ofInt.setDuration(200L);
            ofInt.setEvaluator(new ArgbEvaluator());
            ofInt.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMHighwaySubscribeView", "startAutoHideTimer()-> mAutoHideTiming= " + this.p);
        }
        o0();
        com.baidu.navisdk.util.worker.c.a().a(this.r, new com.baidu.navisdk.util.worker.e(2, 0), 10000L);
        this.p = true;
    }

    public void n0() {
        String str;
        Object valueOf;
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateData-> isVisibility= ");
            sb.append(a());
            sb.append(", isServicePanelCanShow= ");
            if (p0() == null) {
                valueOf = "null";
            } else {
                valueOf = Boolean.valueOf(p0().s());
            }
            sb.append(valueOf);
            LogUtil.e("RGMMHighwaySubscribeView", sb.toString());
        }
        if (p0() == null) {
            return;
        }
        if (!p0().s() && !com.baidu.navisdk.ui.routeguide.model.t.s().i()) {
            if (a()) {
                LogUtil.e("RGMMHighwaySubscribeView", "updateData-> 列表数据不满足显示条件，收起全程信息面板！");
                c();
                return;
            }
            return;
        }
        if (a()) {
            TextView textView = this.m;
            if (textView != null) {
                if (com.baidu.navisdk.ui.routeguide.b.V().D()) {
                    str = "全程信息";
                } else {
                    str = "高速全程信息";
                }
                textView.setText(str);
            }
            if (this.o != null && p0() != null) {
                List<com.baidu.navisdk.module.pronavi.model.d> m = p0().m();
                com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
                if (k != null && !k.m()) {
                    Iterator<com.baidu.navisdk.module.pronavi.model.d> it = m.iterator();
                    while (it.hasNext()) {
                        if (it.next().p() == 6) {
                            it.remove();
                        }
                    }
                }
                ArrayList<com.baidu.navisdk.model.datastruct.h> b2 = com.baidu.navisdk.ui.routeguide.model.t.s().b();
                this.o.a(com.baidu.navisdk.ui.routeguide.model.t.s().e(), com.baidu.navisdk.ui.routeguide.model.t.s().d());
                this.o.a(m, b2);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.navi_rg_highway_subscript_layout) {
            c();
        } else if (view.getId() == R.id.hw_subscript_content_view) {
            y0();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        if (this.q) {
            return false;
        }
        super.y();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMHighwaySubscribeView", "show()->");
        }
        if (this.k == null) {
            s0();
        }
        if (this.k != null && this.l != null) {
            com.baidu.navisdk.asr.d.B().a(1);
            u0();
            this.l.clearAnimation();
            this.k.setVisibility(0);
            this.l.setVisibility(0);
            if (!j0() && com.baidu.navisdk.ui.routeguide.utils.b.A()) {
                q0();
            }
            this.l.startAnimation(com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_IN, 0L, 300L));
            w0();
            if (!this.p) {
                y0();
            }
        }
        return true;
    }

    private void b(int i, int i2, com.baidu.navisdk.module.pronavi.model.d dVar) {
        com.baidu.navisdk.model.datastruct.chargestation.b bVar = (com.baidu.navisdk.model.datastruct.chargestation.b) dVar.a("charge_station_info", null);
        o0();
        c();
        Bundle bundle = new Bundle();
        bundle.putString("uid", dVar.g());
        if (com.baidu.navisdk.ui.routeguide.b.V().D()) {
            if (bVar == null) {
                return;
            }
            bundle.putInt("key_type_show_views", 3);
            bundle.putSerializable("charge_station_info", bVar);
        } else {
            if (dVar.q()) {
                return;
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.p.3.5", dVar.i(), null, null);
            bundle.putInt("key_type_show_views", 5);
            bundle.putSerializable("service_area_info", dVar);
        }
        e(bundle);
    }

    private void d(int i, int i2, com.baidu.navisdk.module.pronavi.model.d dVar) {
        y0();
        p0().a(i);
        com.baidu.navisdk.ui.routeguide.adapter.a aVar = this.o;
        if (aVar != null) {
            aVar.notifyItemChanged(i2 + 1);
        }
        if (com.baidu.navisdk.ui.routeguide.control.x.b().m0() != null && p0() != null) {
            if (p0().m().size() > i) {
                com.baidu.navisdk.ui.routeguide.control.x.b().m0().a(p0().m().get(i));
            } else {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("RGMMHighwaySubscribeView", "itemClick-> position= " + i + ", getServiceAreaData().size()" + p0().m().size());
                }
            }
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().F(p0().n().size());
    }

    private void e(Bundle bundle) {
        if (com.baidu.navisdk.ui.routeguide.model.i.s().k()) {
            com.baidu.navisdk.ui.routeguide.b.V().w();
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
        }
        if (RGFSMTable.FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getTopState())) {
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BROWSER_STATE_EXIT);
        }
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.ENTRY_DYNAMIC_LAYER, bundle);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        LogUtil.e("RGMMHighwaySubscribeView", "hide->");
        super.c();
        if (this.k == null || this.l == null) {
            return;
        }
        Animation a2 = com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_OUT, 0L, 300L);
        a2.setFillAfter(true);
        a2.setAnimationListener(new d());
        this.l.clearAnimation();
        this.l.startAnimation(a2);
        x0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        this.k = null;
        if (a()) {
            y();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.adapter.a.e
    public void a(int i, int i2, com.baidu.navisdk.module.pronavi.model.d dVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMHighwaySubscribeView", "onClickSubscribeItem --> beanIndex = " + i + ", itemPosition = " + i2 + ", bean = " + dVar);
        }
        if (p0() == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMMHighwaySubscribeView", "itemClick --> getServiceAreaModel() == null,return !");
                return;
            }
            return;
        }
        boolean z = dVar.p() == 6 || dVar.p() == 7;
        int b2 = dVar.b();
        if (b2 == 1) {
            if (z) {
                com.baidu.navisdk.util.statistic.userop.b.r().b("3.17.1.5");
            }
            b(i, i2, dVar);
        } else {
            if (b2 == 2) {
                c(i, i2, dVar);
                if (z) {
                    com.baidu.navisdk.util.statistic.userop.b.r().b("3.17.1.7");
                    return;
                }
                return;
            }
            if (z) {
                if (dVar.s()) {
                    com.baidu.navisdk.util.statistic.userop.b.r().d("3.17.1.3", "1");
                } else {
                    com.baidu.navisdk.util.statistic.userop.b.r().d("3.17.1.3", "0");
                }
            }
            if (i >= 0) {
                d(i, i2, dVar);
            }
        }
    }

    private void c(int i, int i2, com.baidu.navisdk.module.pronavi.model.d dVar) {
        com.baidu.navisdk.model.datastruct.chargestation.b bVar = (com.baidu.navisdk.model.datastruct.chargestation.b) dVar.a("charge_station_info", null);
        if (bVar == null) {
            return;
        }
        o0();
        c();
        Bundle bundle = new Bundle();
        bundle.putInt("key_type_show_views", 4);
        bundle.putString("uid", dVar.g());
        bundle.putSerializable("charge_station_info", bVar);
        e(bundle);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> d(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        return a(3, z, i2);
    }

    private Pair<Integer, Integer> d(int i, int i2) {
        int l;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMHighwaySubscribeView", "getLandContentViewLeftRight: " + i + "," + i2);
        }
        if (i == 2) {
            l = com.baidu.navisdk.ui.routeguide.utils.b.q();
        } else if (i == 3) {
            i2 = com.baidu.navisdk.ui.routeguide.utils.b.k();
            l = com.baidu.navisdk.ui.routeguide.utils.b.q() + i2;
        } else {
            i2 = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_toolbox_margin_left);
            l = com.baidu.navisdk.ui.routeguide.utils.b.l();
        }
        if (com.baidu.navisdk.ui.routeguide.mapmode.subview.a.c().b()) {
            int statusBarHeight = ScreenUtil.getInstance().getStatusBarHeight(com.baidu.navisdk.ui.routeguide.b.V().b());
            l += statusBarHeight;
            if (i != 2) {
                i2 += statusBarHeight;
            }
        }
        return new Pair<>(Integer.valueOf(l), Integer.valueOf(i2));
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> c(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        return a(0, z, i2);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> a(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        return a(2, z, i2);
    }

    private List<Animator> a(int i, boolean z, int i2) {
        View view;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMHighwaySubscribeView", "getHDStateSwitchAnimator: " + i + ",isPort: " + z);
        }
        if (z || (view = this.k) == null || this.l == null || view.getVisibility() != 0 || this.l.getVisibility() != 0) {
            return null;
        }
        Pair<Integer, Integer> d2 = d(i, i2);
        return com.baidu.navisdk.pronavi.hd.d.f7723a.b(this.l, ((Integer) d2.first).intValue(), ((Integer) d2.second).intValue());
    }
}
