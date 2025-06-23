package com.baidu.navisdk.pronavi.newenergy.ui.bucket;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.style.f;
import com.baidu.navisdk.pronavi.ui.bucket.config.d;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.i;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.XIxXXX0x0;

/* loaded from: classes7.dex */
public final class a extends com.baidu.navisdk.pronavi.ui.bucket.item.a {
    private ConstraintLayout f;
    private View g;
    private ImageView h;
    private TextView i;
    private final ConstraintSet j;
    private View k;
    private View l;
    private ImageView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private View r;
    private final com.baidu.navisdk.pronavi.newenergy.logic.tips.a s;
    private com.baidu.navisdk.pronavi.style.view.a t;
    private com.baidu.navisdk.pronavi.style.view.a u;
    private int v;

    /* renamed from: com.baidu.navisdk.pronavi.newenergy.ui.bucket.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0330a {
        private C0330a() {
        }

        public /* synthetic */ C0330a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View it) {
            a aVar = a.this;
            IIX0o.oO(it, "it");
            aVar.a(it);
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends com.baidu.navisdk.pronavi.style.c {
        public c(Integer[] numArr, Integer[] numArr2) {
            super(numArr2);
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        @OOXIXo
        public String a() {
            return "RGBucketItem" + a.this.getId() + '-' + ((com.baidu.navisdk.pronavi.ui.bucket.item.a) a.this).c;
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void b(@oOoXoXO String str) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(a.this.d(), "useDefaultStyle: ");
            }
            a.this.w();
        }

        @Override // com.baidu.navisdk.pronavi.style.i.a
        public void c() {
            if (a.this.t == null) {
                a.this.t = new com.baidu.navisdk.pronavi.style.view.a();
            }
            com.baidu.navisdk.pronavi.style.view.a aVar = a.this.t;
            IIX0o.ooOOo0oXI(aVar);
            aVar.setBgView(a.this.g);
            aVar.a("RGChargeStationBtnTxtBg", (View) a.this.i);
            aVar.a("RGChargeStationBtnIcBg", a.this.h);
            a("RGChargeStationBtn", (String) a.this.t);
            if (a.this.u == null) {
                a.this.u = new com.baidu.navisdk.pronavi.style.view.a();
            }
            com.baidu.navisdk.pronavi.style.view.a aVar2 = a.this.u;
            IIX0o.ooOOo0oXI(aVar2);
            aVar2.setBgView(a.this.k);
            aVar2.setImageView(a.this.m);
            aVar2.setColorTextView(a.this.n);
            aVar2.a("RGCSTipCBg", (View) a.this.o);
            aVar2.a("RGCSTipViewBg", a.this.l);
            aVar2.a("RGCSTipOtherTxtC", a.this.p);
            a("RGChargeStationTipView", (String) a.this.u);
        }

        @Override // com.baidu.navisdk.pronavi.style.c
        @oOoXoXO
        public String d(@oOoXoXO String str) {
            if (IIX0o.Oxx0IOOO("RGChargeStationTipView", str)) {
                switch (a.this.s.o()) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        return "RGChargeStationTipGreen";
                    case 5:
                        return "RGChargeStationTipOrange";
                    case 6:
                        return "RGChargeStationTipRed";
                    default:
                        return str;
                }
            }
            return str;
        }
    }

    static {
        new C0330a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b uiContext, @OOXIXo d itemData) {
        super(uiContext, itemData);
        IIX0o.x0xO0oo(uiContext, "uiContext");
        IIX0o.x0xO0oo(itemData, "itemData");
        this.j = new ConstraintSet();
        this.s = new com.baidu.navisdk.pronavi.newenergy.logic.tips.a();
    }

    private final void v() {
        if (!isVisible()) {
            return;
        }
        int o = 1 << this.s.o();
        int i = this.v;
        if ((o & i) == 0) {
            this.v = o | i;
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.17.3.1", String.valueOf(this.s.o()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        if (this.k != null && this.g != null && getView() != null) {
            if (this.s.o() == 0) {
                com.baidu.navisdk.ui.util.b.a(this.g, R.drawable.bnav_rg_btn_bg);
                com.baidu.navisdk.ui.util.b.a((View) this.i, R.drawable.nsdk_rg_ne_charge_station_btn_text_bg);
                com.baidu.navisdk.ui.util.b.a((View) this.h, R.drawable.nsdk_rg_ne_charge_station_btn_bg);
                return;
            }
            com.baidu.navisdk.ui.util.b.a(this.k, R.drawable.bnav_rg_btn_bg);
            com.baidu.navisdk.ui.util.b.a(this.l, this.s.h());
            com.baidu.navisdk.ui.util.b.a(this.n, this.s.n());
            if (this.s.g() != 0) {
                com.baidu.navisdk.ui.util.b.a(this.m, this.s.g());
            }
            com.baidu.navisdk.ui.util.b.a((View) this.o, this.s.c());
            com.baidu.navisdk.ui.util.b.a(this.p, this.s.j());
            com.baidu.navisdk.ui.util.b.a(this.q, this.s.l());
        }
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    @OOXIXo
    public View.OnClickListener getOnClickListener() {
        return new b();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onDestroy() {
        super.onDestroy();
        this.t = null;
        this.u = null;
        this.v = 0;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onRefreshViewStyle(int i) {
        super.onRefreshViewStyle(i);
        d(i);
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onVisibleChange(int i) {
        com.baidu.navisdk.apicenter.a aVar;
        super.onVisibleChange(i);
        if (i == 0) {
            com.baidu.navisdk.pronavi.ui.base.b bVar = this.f7853a;
            if (bVar != null) {
                aVar = bVar.j();
            } else {
                aVar = null;
            }
            IIX0o.ooOOo0oXI(aVar);
            aVar.e("RGBucketGroupComponent").a(2016).a();
            v();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    @OOXIXo
    public String[] r() {
        return new String[]{RGFSMTable.FsmState.BrowseMap, RGFSMTable.FsmState.EnlargeRoadmap, RGFSMTable.FsmState.Voice, RGFSMTable.FsmState.NaviReady, RGFSMTable.FsmState.NearbySearch, RGFSMTable.FsmState.DynamicLayer, RGFSMTable.FsmState.ArriveDest};
    }

    private final void d(int i) {
        float dimension;
        float dimension2;
        float dimension3;
        float dimension4;
        int dimensionPixelSize;
        float f;
        int i2;
        int i3;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("NewEnergyChargeStationBtn", "changeViewSize: " + i);
        }
        Resources resources = JarUtils.getResources();
        IIX0o.oO(resources, "JarUtils.getResources()");
        if (i == 2) {
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_width);
            int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_height);
            int i4 = R.dimen.navi_dimens_10dp;
            dimension = resources.getDimension(i4);
            dimension2 = resources.getDimension(R.dimen.navi_dimens_11dp);
            dimension3 = resources.getDimension(i4);
            dimension4 = resources.getDimension(i4);
            f = resources.getDimension(i4);
            i2 = dimensionPixelSize3;
            i3 = dimensionPixelSize2;
            dimensionPixelSize = 0;
        } else {
            int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_width_new);
            int dimensionPixelSize5 = resources.getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_height_new);
            dimension = resources.getDimension(R.dimen.nsdk_rg_control_panel_btn_text_size_new);
            dimension2 = resources.getDimension(R.dimen.navi_dimens_13dp);
            int i5 = R.dimen.navi_dimens_11dp;
            dimension3 = resources.getDimension(i5);
            dimension4 = resources.getDimension(i5);
            float dimension5 = resources.getDimension(i5);
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.navi_dimens_6dp);
            f = dimension5;
            i2 = dimensionPixelSize5;
            i3 = dimensionPixelSize4;
        }
        View view = this.g;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.width = i3;
                marginLayoutParams.height = i2;
                int dimensionPixelSize6 = i == 2 ? 0 : JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_14dp);
                if (this.d) {
                    marginLayoutParams.leftMargin = dimensionPixelSize6;
                } else {
                    marginLayoutParams.rightMargin = dimensionPixelSize6;
                }
                TextView textView = this.i;
                if (textView != null) {
                    textView.setTextSize(0, dimension);
                }
                view.requestLayout();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
        }
        View view2 = this.k;
        if (view2 != null) {
            view2.getLayoutParams().height = i2;
            TextView textView2 = this.n;
            if (textView2 != null) {
                textView2.setTextSize(0, dimension2);
            }
            TextView textView3 = this.o;
            if (textView3 != null) {
                textView3.setTextSize(0, dimension3);
            }
            TextView textView4 = this.p;
            if (textView4 != null) {
                textView4.setTextSize(0, dimension4);
            }
            TextView textView5 = this.q;
            if (textView5 != null) {
                textView5.setTextSize(0, f);
            }
            ImageView imageView = this.m;
            ViewGroup.LayoutParams layoutParams2 = imageView != null ? imageView.getLayoutParams() : null;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) (layoutParams2 instanceof ViewGroup.MarginLayoutParams ? layoutParams2 : null);
            if (marginLayoutParams2 != null) {
                if (this.d) {
                    marginLayoutParams2.leftMargin = dimensionPixelSize;
                } else {
                    marginLayoutParams2.rightMargin = dimensionPixelSize;
                }
                ImageView imageView2 = this.m;
                if (imageView2 != null) {
                    imageView2.requestLayout();
                }
            }
            view2.requestLayout();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        com.baidu.navisdk.ui.routeguide.asr.c n = com.baidu.navisdk.ui.routeguide.asr.c.n();
        IIX0o.oO(n, "RGAsrProxy.getInstance()");
        if (n.i()) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("NewEnergyChargeStationBtn", "visibility: isWakeUp");
            }
            return 8;
        }
        a0 I = a0.I();
        IIX0o.oO(I, "RGSimpleGuideModel.getInstance()");
        if (I.D()) {
            g gVar2 = g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("NewEnergyChargeStationBtn", "visibility: isYawing");
            }
            return 8;
        }
        if (com.baidu.navisdk.ui.routeguide.b.V().x()) {
            return 0;
        }
        g gVar3 = g.PRO_NAV;
        if (gVar3.d()) {
            gVar3.e("NewEnergyChargeStationBtn", "visibility: not hasCalcRouteOk");
        }
        return 8;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    @OOXIXo
    public View a(@OOXIXo ViewGroup parentView, int i, @OOXIXo Context context) {
        IIX0o.x0xO0oo(parentView, "parentView");
        IIX0o.x0xO0oo(context, "context");
        View view = com.baidu.navisdk.ui.util.b.a(context, R.layout.nsdk_layout_rg_ne_charge_station_tip, parentView, false);
        IIX0o.oO(view, "view");
        a(view, context);
        d(i);
        t();
        return view;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int a(int i, boolean z) {
        if (i == 2) {
            return super.a(i, z);
        }
        return 0 - JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_10dp);
    }

    private final void a(View view, Context context) {
        this.f = (ConstraintLayout) view.findViewById(R.id.bnav_rg_charge_station_ly);
        int i = R.id.bnav_rg_charge_station_btn;
        this.g = view.findViewById(i);
        this.h = (ImageView) view.findViewById(R.id.bnav_rg_charge_station_btn_ic);
        this.i = (TextView) view.findViewById(R.id.bnav_rg_charge_station_btn_text);
        int i2 = R.id.bnav_rg_charge_station_tip_layout;
        this.k = view.findViewById(i2);
        this.l = view.findViewById(R.id.bnav_rg_charge_station_tip_layout_bg);
        this.m = (ImageView) view.findViewById(R.id.bnav_rg_charge_station_tip_ic);
        this.n = (TextView) view.findViewById(R.id.bnav_rg_charge_station_tip_title);
        this.o = (TextView) view.findViewById(R.id.bnav_rg_charge_station_tip_count);
        this.p = (TextView) view.findViewById(R.id.bnav_rg_charge_station_tip_optional);
        this.q = (TextView) view.findViewById(R.id.bnav_rg_charge_station_tip_no_enough_tip);
        this.r = view.findViewById(R.id.bnav_rg_charge_station_tip_count_optional_ly);
        if (this.d) {
            this.j.connect(i, 6, 0, 6);
            this.j.connect(i, 3, 0, 3);
            this.j.connect(i2, 6, 0, 6);
            this.j.connect(i2, 3, 0, 3);
        } else {
            this.j.connect(i, 7, 0, 7);
            this.j.connect(i, 3, 0, 3);
            this.j.connect(i2, 7, 0, 7);
            this.j.connect(i2, 3, 0, 3);
        }
        this.j.applyTo(this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(View view) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("NewEnergyChargeStationBtn", "handleOnClick:" + this.s);
        }
        if (com.baidu.navisdk.ui.util.g.a()) {
            if (gVar.d()) {
                gVar.e("NewEnergyChargeStationBtn", "handleOnClick: isFastDoubleClick");
                return;
            }
            return;
        }
        boolean b2 = com.baidu.navisdk.ui.routeguide.utils.b.b("chargeStation", false);
        if (gVar.d()) {
            gVar.e("NewEnergyChargeStationBtn", "handleOnClick : exitHDNavi: " + b2);
        }
        if (!b2) {
            i s = i.s();
            IIX0o.oO(s, "RGEnlargeRoadMapModel.getInstance()");
            if (s.k()) {
                com.baidu.navisdk.ui.routeguide.b.V().w();
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
            }
            RouteGuideFSM routeGuideFSM = RouteGuideFSM.getInstance();
            IIX0o.oO(routeGuideFSM, "RouteGuideFSM.getInstance()");
            if (IIX0o.Oxx0IOOO(RGFSMTable.FsmState.BrowseMap, routeGuideFSM.getTopState())) {
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BROWSER_STATE_EXIT);
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("uid", this.s.e());
        bundle.putInt("key_type_show_views", 6);
        bundle.putInt("src", 0);
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.ENTRY_DYNAMIC_LAYER, bundle);
        com.baidu.navisdk.util.statistic.userop.b.r().d("3.17.3.2", String.valueOf(this.s.o()));
    }

    public final void a(@OOXIXo com.baidu.navisdk.pronavi.newenergy.logic.tips.a tipData) {
        int i;
        IIX0o.x0xO0oo(tipData, "tipData");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("NewEnergyChargeStationBtn", "changeState new: " + tipData + ", old:" + this.s);
        }
        int o = this.s.o();
        this.s.a(tipData);
        int i2 = 0;
        if (this.s.o() == 0) {
            View view = this.g;
            if (view != null) {
                view.setVisibility(0);
            }
            View view2 = this.k;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        } else {
            View view3 = this.g;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            View view4 = this.k;
            if (view4 != null) {
                view4.setVisibility(0);
            }
            String m = this.s.m();
            String f = this.s.f();
            if (f != null && f.length() != 0) {
                m = m + XIxXXX0x0.f29547XxX0x0xxx + this.s.f();
            }
            TextView textView = this.n;
            if (textView != null) {
                textView.setText(m);
            }
            if (this.s.o() == 6) {
                String k = this.s.k();
                if (k != null && k.length() != 0) {
                    TextView textView2 = this.o;
                    if (textView2 != null) {
                        textView2.setVisibility(8);
                    }
                    TextView textView3 = this.p;
                    if (textView3 != null) {
                        textView3.setVisibility(8);
                    }
                    TextView textView4 = this.q;
                    if (textView4 != null) {
                        textView4.setText(this.s.k());
                    }
                    TextView textView5 = this.q;
                    if (textView5 != null) {
                        textView5.setVisibility(0);
                    }
                    View view5 = this.r;
                    if (view5 != null) {
                        view5.setVisibility(0);
                    }
                } else {
                    View view6 = this.r;
                    if (view6 != null) {
                        view6.setVisibility(8);
                    }
                }
            } else {
                TextView textView6 = this.q;
                if (textView6 != null) {
                    textView6.setVisibility(8);
                }
                String b2 = this.s.b();
                if (b2 != null && b2.length() != 0) {
                    TextView textView7 = this.o;
                    if (textView7 != null) {
                        textView7.setText(this.s.b());
                    }
                    TextView textView8 = this.o;
                    if (textView8 != null) {
                        textView8.setVisibility(0);
                    }
                    TextView textView9 = this.o;
                    if (textView9 != null) {
                        textView9.setTextColor(com.baidu.navisdk.ui.util.b.b(this.s.d()));
                    }
                    i = 0;
                } else {
                    TextView textView10 = this.o;
                    if (textView10 != null) {
                        textView10.setVisibility(8);
                    }
                    i = 8;
                }
                String i3 = this.s.i();
                if (i3 != null && i3.length() != 0) {
                    TextView textView11 = this.p;
                    if (textView11 != null) {
                        textView11.setText(this.s.i());
                    }
                    TextView textView12 = this.p;
                    if (textView12 != null) {
                        textView12.setVisibility(0);
                    }
                } else {
                    TextView textView13 = this.p;
                    if (textView13 != null) {
                        textView13.setVisibility(8);
                    }
                    i2 = i;
                }
                View view7 = this.r;
                if (view7 != null) {
                    view7.setVisibility(i2);
                }
            }
        }
        if (o != this.s.o()) {
            com.baidu.navisdk.pronavi.style.i.a aVar = this.e;
            if (aVar != null) {
                aVar.a("RGChargeStation");
            } else {
                w();
            }
        }
        v();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean a(@OOXIXo Integer... integers) {
        IIX0o.x0xO0oo(integers, "integers");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            String d = d();
            StringBuilder sb = new StringBuilder();
            sb.append("registerStyleChangeHelper: ");
            String arrays = Arrays.toString(integers);
            IIX0o.oO(arrays, "java.util.Arrays.toString(this)");
            sb.append(arrays);
            gVar.e(d, sb.toString());
        }
        if (this.e == null) {
            this.e = new c(integers, (Integer[]) Arrays.copyOf(integers, integers.length));
        }
        f.b.a(this.e, "RGChargeStation");
        return true;
    }
}
