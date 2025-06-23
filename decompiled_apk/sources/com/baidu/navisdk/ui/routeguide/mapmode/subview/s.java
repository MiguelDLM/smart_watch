package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.baidu.mapframework.widget.MProgressDialog;
import com.baidu.navisdk.comapi.mapcontrol.BNDynamicOverlay;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.walk.a;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.pronavi.ui.park.bottom.a;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNCommonProgressDialog;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.c0;
import com.baidu.navisdk.utils.a;
import com.baidu.nplatform.comapi.map.j;
import com.baidu.platform.comapi.UIMsg;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class s extends k implements View.OnClickListener {
    private View c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private View k;
    private View l;
    private View m;
    private View n;
    private TextView o;
    private View p;
    private String q;
    private com.baidu.navisdk.module.park.a r;
    private com.baidu.navisdk.ugc.listener.b s;
    private boolean u;
    private boolean v;
    private boolean w;
    private BNCommonProgressDialog x;
    private final com.baidu.navisdk.util.worker.lite.b z;
    private int t = -1;
    private final com.baidu.navisdk.util.worker.lite.b y = new e("ace_drc_l");

    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements a.InterfaceC0200a {
        public b(s sVar) {
        }
    }

    /* loaded from: classes8.dex */
    public static final class d extends com.baidu.navisdk.util.worker.lite.b {
        public d(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            MProgressDialog.dismiss();
            com.baidu.navisdk.ui.routeguide.b.V().I();
        }
    }

    /* loaded from: classes8.dex */
    public static final class e extends com.baidu.navisdk.util.worker.lite.b {
        public e(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            s.this.z();
        }
    }

    /* loaded from: classes8.dex */
    public static final class f implements a.InterfaceC0357a {
        @Override // com.baidu.navisdk.pronavi.ui.park.bottom.a.InterfaceC0357a
        public void a(int i, @oOoXoXO String str, @oOoXoXO Throwable th) {
            a.InterfaceC0357a.C0358a.a(this, i, str, th);
            MProgressDialog.dismiss();
            TipTool.toast("保存失败，请稍后再试");
        }

        @Override // com.baidu.navisdk.pronavi.ui.park.bottom.a.InterfaceC0357a
        public void onStart() {
            com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V, "BNavigator.getInstance()");
            Activity b = V.b();
            if (b != null) {
                MProgressDialog.show((FragmentActivity) b, (String) null, "加载中", (DialogInterface.OnCancelListener) null);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }

        @Override // com.baidu.navisdk.pronavi.ui.park.bottom.a.InterfaceC0357a
        public void onSuccess() {
            MProgressDialog.dismiss();
            com.baidu.navisdk.ui.routeguide.b.V().Q();
            TipTool.toast("已保存车辆位置");
        }
    }

    /* loaded from: classes8.dex */
    public static final class g extends com.baidu.navisdk.util.worker.lite.b {
        public g(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            int dip2px = ScreenUtil.getInstance().dip2px(20);
            if (1 == com.baidu.navisdk.module.pronavi.model.h.f7469a) {
                com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
                int e = aVar.e() - dip2px;
                int statusBarHeightFullScreen = ScreenUtil.getInstance().getStatusBarHeightFullScreen(s.this.b) + dip2px;
                int d = aVar.d();
                View view = s.this.c;
                IIX0o.ooOOo0oXI(view);
                BNMapController.getInstance().setMapShowScreenRect(dip2px, statusBarHeightFullScreen, e, (d - view.getHeight()) - dip2px);
            } else {
                com.baidu.navisdk.ui.routeguide.mapmode.a b = com.baidu.navisdk.ui.routeguide.control.x.b();
                IIX0o.oO(b, "RGViewController.getInstance()");
                BNMapController.getInstance().setMapShowScreenRect(dip2px, dip2px, b.V() - dip2px, com.baidu.navisdk.ui.routeguide.utils.a.f9151a.a() - dip2px);
            }
            BNMapController.getInstance().resetRouteDetailIndex(false);
        }
    }

    /* loaded from: classes8.dex */
    public static final class h implements DialogInterface.OnCancelListener {
        public h() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            if (s.this.t != -1) {
                com.baidu.navisdk.framework.b.b(s.this.t);
                s.this.t = -1;
            }
            s.this.y();
        }
    }

    static {
        new a(null);
    }

    public s(@oOoXoXO com.baidu.navisdk.module.park.a aVar, boolean z) {
        boolean z2;
        String str;
        d dVar = new d("ace_drc_cl");
        this.z = dVar;
        this.f8808a = 1013;
        boolean e0 = com.baidu.navisdk.framework.b.e0();
        this.v = e0;
        this.r = aVar;
        if (z && e0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.u = z2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("initView mShowNotSaveBtn = ");
            sb.append(this.u);
            sb.append(',');
            sb.append(" saveParkListData -> ");
            com.baidu.navisdk.module.park.a aVar2 = this.r;
            if (aVar2 != null) {
                str = aVar2.toString();
            } else {
                str = null;
            }
            sb.append(str);
            sb.append(", userIsLogin = ");
            sb.append(this.v);
            gVar.e("RGMMDestRecommendCard", sb.toString());
        }
        l();
        x();
        w();
        v();
        m();
        com.baidu.navisdk.util.worker.lite.a.a(dVar, 20000);
    }

    private final void A() {
        com.baidu.navisdk.module.park.a aVar = this.r;
        if (aVar != null) {
            IIX0o.ooOOo0oXI(aVar);
            if (aVar.f() != null) {
                ImageView imageView = this.h;
                if (imageView != null) {
                    com.baidu.navisdk.module.park.a aVar2 = this.r;
                    IIX0o.ooOOo0oXI(aVar2);
                    imageView.setImageBitmap(aVar2.f());
                    imageView.setVisibility(0);
                    ImageView imageView2 = this.i;
                    if (imageView2 != null) {
                        imageView2.setVisibility(0);
                    }
                    ImageView imageView3 = this.j;
                    if (imageView3 != null) {
                        imageView3.setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        ImageView imageView4 = this.j;
        if (imageView4 != null) {
            imageView4.setVisibility(0);
        }
        ImageView imageView5 = this.h;
        if (imageView5 != null) {
            imageView5.setVisibility(8);
        }
        ImageView imageView6 = this.i;
        if (imageView6 != null) {
            imageView6.setVisibility(8);
        }
    }

    private final void B() {
        com.baidu.navisdk.util.worker.lite.a.a(this.z);
    }

    private final void m() {
        RoutePlanNode c2 = com.baidu.navisdk.ui.routeguide.control.d.e.c();
        if (c2 != null) {
            a();
            IIX0o.ooOOo0oXI(c2);
            int a2 = com.baidu.navisdk.framework.b.a(com.baidu.navisdk.util.common.o.a(c2.getGeoPoint()), c2.getUID(), c2.getName(), new b(this));
            this.t = a2;
            if (a2 == -1) {
                TipTool.toast(UIMsg.UI_TIP_DEFAULT_SERVER_ERROR);
                b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        com.baidu.navisdk.ugc.dialog.g.e().c();
    }

    private final com.baidu.navisdk.module.park.a o() {
        String str;
        com.baidu.navisdk.module.park.a c2 = com.baidu.navisdk.module.park.a.c(com.baidu.navisdk.framework.b.q());
        if (c2 != null && c2.n()) {
            this.r = c2;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                StringBuilder sb = new StringBuilder();
                sb.append("getSaveParkData-->saveParkListData:");
                com.baidu.navisdk.module.park.a aVar = this.r;
                if (aVar != null) {
                    str = aVar.toString();
                } else {
                    str = null;
                }
                sb.append(str);
                gVar.e("RGMMDestRecommendCard", sb.toString());
            }
        }
        return this.r;
    }

    private final int p() {
        com.baidu.navisdk.util.logic.g j = com.baidu.navisdk.util.logic.g.j();
        IIX0o.oO(j, "BNLocationManagerProxy.getInstance()");
        com.baidu.navisdk.model.datastruct.g a2 = j.a();
        RoutePlanNode c2 = com.baidu.navisdk.ui.routeguide.control.d.e.c();
        if (c2 != null && c2.getLatitudeE6() != Integer.MIN_VALUE && c2.getLongitudeE6() != Integer.MIN_VALUE && a2 != null) {
            double d2 = a2.b;
            if (d2 != -1.0d) {
                double d3 = a2.f6926a;
                if (d3 != -1.0d) {
                    double d4 = 100000;
                    double a3 = com.baidu.navisdk.util.common.l0.a(d2 * d4, d3 * d4, c2.getLongitudeE6(), c2.getLatitudeE6());
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar.d()) {
                        gVar.e("RGMMDestRecommendCard", "getSphereDisFromCurPoint2RpNodeEnd,sphereDist: " + a3);
                    }
                    return (int) a3;
                }
            }
        }
        return -1;
    }

    private final void q() {
        com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
        IIX0o.oO(V, "BNavigator.getInstance()");
        Activity b2 = V.b();
        if (b2 != null) {
            com.baidu.navisdk.ugc.dialog.g.e().a(b2, 1, this.s, 5);
        }
    }

    private final void r() {
        com.baidu.navisdk.module.park.a aVar = this.r;
        if (aVar == null) {
            return;
        }
        IIX0o.ooOOo0oXI(aVar);
        aVar.a((Bitmap) null);
        A();
    }

    private final void s() {
        com.baidu.navisdk.module.park.a aVar = this.r;
        if (aVar != null) {
            IIX0o.ooOOo0oXI(aVar);
            if (!TextUtils.isEmpty(aVar.e())) {
                ArrayList<String> arrayList = new ArrayList<>();
                com.baidu.navisdk.module.park.a aVar2 = this.r;
                IIX0o.ooOOo0oXI(aVar2);
                String e2 = aVar2.e();
                IIX0o.ooOOo0oXI(e2);
                arrayList.add(e2);
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("img_url_list", arrayList);
                com.baidu.navisdk.framework.b.a(bundle);
            }
        }
    }

    private final void t() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMDestRecommendCard", "hideCurStallPoi---");
        }
        BNMapController.getDynamicOverlay().hideAll(BNDynamicOverlay.Key.ACE_CUR_STALL_BUBBLE);
    }

    private final void u() {
        if (this.s == null) {
            this.s = new c();
        }
    }

    private final void v() {
        com.baidu.navisdk.framework.b.b();
        BNMapController.getInstance().setPreFinishStatus(true);
        BNMapController.getInstance().clearLayer(8);
        BNMapController.getInstance().showLayer(8, false);
        BNRouteGuider.getInstance().removeRoute(0);
    }

    private final void w() {
        boolean z;
        String str;
        int i;
        String str2;
        int i2;
        boolean z2 = true;
        if (this.u && this.r != null) {
            z = true;
        } else {
            z = false;
        }
        if (this.r == null || !this.v) {
            z2 = false;
        }
        b(z2);
        View view = this.l;
        if (view != null) {
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
        TextView textView = this.o;
        if (textView != null) {
            if (z) {
                str2 = "保存并结束导航";
            } else {
                str2 = "结束导航";
            }
            textView.setText(str2);
        }
        TextView textView2 = this.e;
        if (textView2 != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            textView2.setVisibility(i);
        }
        TextView textView3 = this.e;
        if (textView3 != null) {
            if (z) {
                str = "是否保存车辆位置？";
            } else {
                str = "";
            }
            textView3.setText(str);
        }
        b(this.r);
        RoutePlanNode c2 = com.baidu.navisdk.ui.routeguide.control.d.e.c();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMDestRecommendCard", "initView endNode = " + c2);
        }
        View view2 = this.m;
        IIX0o.ooOOo0oXI(view2);
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams != null) {
            ((LinearLayout.LayoutParams) layoutParams).topMargin = -com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_14dp);
            if (c2 != null) {
                if (this.f != null && !TextUtils.isEmpty(c2.getName())) {
                    TextView textView4 = this.f;
                    IIX0o.ooOOo0oXI(textView4);
                    textView4.setText(c2.getName());
                }
                View view3 = this.m;
                if (view3 != null) {
                    view3.setVisibility(0);
                }
                com.baidu.navisdk.util.statistic.userop.b.r().a("38.0.21.1479", null, null, null);
            } else {
                View view4 = this.m;
                if (view4 != null) {
                    view4.setVisibility(8);
                }
            }
            a(this.r);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    private final void x() {
        View view = this.p;
        if (view != null) {
            view.setOnClickListener(this);
        }
        View view2 = this.c;
        IIX0o.ooOOo0oXI(view2);
        View findViewById = view2.findViewById(R.id.bnav_walk_navi);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        TextView textView = this.o;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        View view3 = this.k;
        if (view3 != null) {
            view3.setOnClickListener(this);
        }
        View view4 = this.l;
        if (view4 != null) {
            view4.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        int p = p();
        if (p != -1) {
            TextView textView = this.g;
            if (textView != null) {
                textView.setText("步行" + p + "米");
            }
            TextView textView2 = this.g;
            if (textView2 != null) {
                textView2.setVisibility(0);
                return;
            }
            return;
        }
        TextView textView3 = this.g;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        if (this.x == null) {
            com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V, "BNavigator.getInstance()");
            Activity b2 = V.b();
            if (b2 != null && !b2.isFinishing()) {
                BNCommonProgressDialog bNCommonProgressDialog = new BNCommonProgressDialog(b2);
                this.x = bNCommonProgressDialog;
                IIX0o.ooOOo0oXI(bNCommonProgressDialog);
                bNCommonProgressDialog.setMessage("路线规划中...");
                BNCommonProgressDialog bNCommonProgressDialog2 = this.x;
                IIX0o.ooOOo0oXI(bNCommonProgressDialog2);
                bNCommonProgressDialog2.setOnCancelListener(new h());
            } else {
                return;
            }
        }
        BNCommonProgressDialog bNCommonProgressDialog3 = this.x;
        if (bNCommonProgressDialog3 != null) {
            bNCommonProgressDialog3.show();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void h() {
        com.baidu.navisdk.framework.b.b();
        BNMapController bNMapController = BNMapController.getInstance();
        BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
        IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
        bNMapController.setRedLineRender(bNCommSettingManager.getShowCarLogoToEnd());
        t();
        this.x = null;
        B();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void j() {
        com.baidu.navisdk.ui.routeguide.control.q.c().b();
        BNMapController.getInstance().setMap2DLook(false);
        com.baidu.navisdk.framework.b.b();
        BNMapController bNMapController = BNMapController.getInstance();
        BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
        IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
        bNMapController.setRedLineRender(bNCommSettingManager.getShowCarLogoToEnd());
        this.x = null;
        t();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void k() {
        if (this.c != null) {
            Animation a2 = com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_IN, 0L, 600L);
            View view = this.c;
            IIX0o.ooOOo0oXI(view);
            view.startAnimation(a2);
        }
        com.baidu.navisdk.util.worker.lite.a.c(new g("drc_s"));
        com.baidu.navisdk.ui.routeguide.control.b k = com.baidu.navisdk.ui.routeguide.control.b.k();
        IIX0o.oO(k, "NMapControlProxy.getInstance()");
        com.baidu.nplatform.comapi.basestruct.b c2 = k.c();
        if (c2 != null) {
            c2.i = 0L;
        }
        if (c2 != null) {
            c2.j = 0L;
        }
        BNMapController.getInstance().setMapStatus(c2, j.b.eAnimationArc, 0, true);
    }

    public final void l() {
        com.baidu.navisdk.framework.a c2 = com.baidu.navisdk.framework.a.c();
        IIX0o.oO(c2, "BNContextManager.getInstance()");
        View a2 = com.baidu.navisdk.ui.util.b.a(c2.a(), R.layout.nsdk_layout_rg_ace_dest_recommend_card);
        this.c = a2;
        IIX0o.ooOOo0oXI(a2);
        this.d = (TextView) a2.findViewById(R.id.bnav_stall_title);
        View view = this.c;
        IIX0o.ooOOo0oXI(view);
        this.e = (TextView) view.findViewById(R.id.bnav_stall_save_time);
        View view2 = this.c;
        IIX0o.ooOOo0oXI(view2);
        this.h = (ImageView) view2.findViewById(R.id.bnav_stall_photo);
        View view3 = this.c;
        IIX0o.ooOOo0oXI(view3);
        this.f = (TextView) view3.findViewById(R.id.bnav_recommend_title);
        View view4 = this.c;
        IIX0o.ooOOo0oXI(view4);
        this.g = (TextView) view4.findViewById(R.id.bnav_recommend_desc);
        View view5 = this.c;
        IIX0o.ooOOo0oXI(view5);
        this.i = (ImageView) view5.findViewById(R.id.bnav_remove_stall_photo);
        View view6 = this.c;
        IIX0o.ooOOo0oXI(view6);
        this.j = (ImageView) view6.findViewById(R.id.save_park_null_icon);
        View view7 = this.c;
        IIX0o.ooOOo0oXI(view7);
        this.k = view7.findViewById(R.id.save_park_icon_container);
        View view8 = this.c;
        IIX0o.ooOOo0oXI(view8);
        this.l = view8.findViewById(R.id.bnav_not_save);
        View view9 = this.c;
        IIX0o.ooOOo0oXI(view9);
        this.m = view9.findViewById(R.id.topContainer);
        View view10 = this.c;
        IIX0o.ooOOo0oXI(view10);
        this.n = view10.findViewById(R.id.bottomContainer);
        View view11 = this.c;
        IIX0o.ooOOo0oXI(view11);
        this.o = (TextView) view11.findViewById(R.id.bnav_quit_navi_container);
        View view12 = this.c;
        IIX0o.ooOOo0oXI(view12);
        this.p = view12.findViewById(R.id.bnav_refresh_stall);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@oOoXoXO View view) {
        Integer num;
        com.baidu.navisdk.module.park.a aVar;
        if (view != null) {
            num = Integer.valueOf(view.getId());
        } else {
            num = null;
        }
        int i = R.id.bnav_refresh_stall;
        if (num != null && num.intValue() == i) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMDestRecommendCard", "刷新当前位置");
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("38.0.21.1478", null, null, null);
            this.w = true;
            o();
            a(this.r);
            b(this.r);
            return;
        }
        int i2 = R.id.bnav_remove_stall_photo;
        if (num != null && num.intValue() == i2) {
            r();
            return;
        }
        int i3 = R.id.bnav_walk_navi;
        if (num != null && num.intValue() == i3) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGMMDestRecommendCard", "步行导航");
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("38.0.21.1480", null, null, null);
            RoutePlanNode c2 = com.baidu.navisdk.ui.routeguide.control.d.e.c();
            if (c2 != null) {
                IIX0o.ooOOo0oXI(c2);
                com.baidu.nplatform.comapi.basestruct.c point = com.baidu.navisdk.util.common.o.a(c2.getGeoPoint());
                Bundle bundle = new Bundle();
                IIX0o.oO(point, "point");
                bundle.putInt("x", point.c());
                bundle.putInt("y", point.d());
                bundle.putString("uid", c2.getUID());
                bundle.putString("name", c2.getName());
                com.baidu.navisdk.ui.routeguide.b.V().a(2, false, bundle);
                return;
            }
            return;
        }
        int i4 = R.id.bnav_not_save;
        if (num != null && num.intValue() == i4) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGMMDestRecommendCard", "DestRemind 不保存 ->");
            }
            com.baidu.navisdk.ui.routeguide.b.V().Q();
            return;
        }
        int i5 = R.id.bnav_quit_navi_container;
        if (num != null && num.intValue() == i5) {
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar4.d()) {
                gVar4.e("RGMMDestRecommendCard", "DestRemind 结束导航 ->");
            }
            if (this.u) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("38.0.21.1482", null, null, null);
            } else {
                com.baidu.navisdk.util.statistic.userop.b.r().a("38.0.21.1481", null, null, null);
            }
            if ((this.u || this.w) && (aVar = this.r) != null && this.v) {
                com.baidu.navisdk.pronavi.ui.park.bottom.a.f7950a.a(aVar, new f());
                return;
            } else {
                com.baidu.navisdk.ui.routeguide.b.V().Q();
                return;
            }
        }
        int i6 = R.id.save_park_icon_container;
        if (num != null && num.intValue() == i6) {
            ImageView imageView = this.j;
            if (imageView != null && imageView.getVisibility() == 0) {
                u();
                q();
                return;
            }
            ImageView imageView2 = this.i;
            if (imageView2 != null && imageView2.getVisibility() == 0) {
                s();
            }
        }
    }

    public final void b() {
        com.baidu.navisdk.util.worker.lite.a.a(this.y);
        BNCommonProgressDialog bNCommonProgressDialog = this.x;
        if (bNCommonProgressDialog != null) {
            IIX0o.ooOOo0oXI(bNCommonProgressDialog);
            bNCommonProgressDialog.dismiss();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    @OOXIXo
    public RelativeLayout.LayoutParams d() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        com.baidu.navisdk.ui.routeguide.mapmode.a b2 = com.baidu.navisdk.ui.routeguide.control.x.b();
        IIX0o.oO(b2, "RGViewController.getInstance()");
        if (b2.s2()) {
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            com.baidu.navisdk.ui.routeguide.mapmode.a b3 = com.baidu.navisdk.ui.routeguide.control.x.b();
            IIX0o.oO(b3, "RGViewController.getInstance()");
            layoutParams.setMargins(b3.V(), 0, 0, 0);
        }
        layoutParams.addRule(12);
        return layoutParams;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    @OOXIXo
    public View e() {
        View view = this.c;
        IIX0o.ooOOo0oXI(view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Bitmap bitmap) {
        if (this.r == null) {
            this.r = new com.baidu.navisdk.module.park.a();
        }
        com.baidu.navisdk.module.park.a aVar = this.r;
        IIX0o.ooOOo0oXI(aVar);
        aVar.a(bitmap);
        A();
    }

    private final void b(com.baidu.navisdk.module.park.a aVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMDestRecommendCard", "showRecommendPoi : recommendStallNode: " + aVar);
        }
        if (aVar == null || !aVar.n()) {
            return;
        }
        BNDynamicOverlay dynamicOverlay = BNMapController.getDynamicOverlay();
        dynamicOverlay.clear(BNDynamicOverlay.Key.ACE_CUR_STALL_BUBBLE);
        com.baidu.navisdk.model.datastruct.b bVar = new com.baidu.navisdk.model.datastruct.b();
        bVar.b(1620);
        bVar.a(TextUtils.isEmpty(aVar.c()) ? aVar.a() : aVar.c());
        bVar.a(new com.baidu.nplatform.comapi.basestruct.c(aVar.l(), aVar.j()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar);
        dynamicOverlay.setDataSet(BNDynamicOverlay.Key.ACE_CUR_STALL_BUBBLE, (List<com.baidu.navisdk.model.datastruct.b>) arrayList);
        dynamicOverlay.showAll(BNDynamicOverlay.Key.ACE_CUR_STALL_BUBBLE);
    }

    /* loaded from: classes8.dex */
    public static final class c implements com.baidu.navisdk.ugc.listener.b {
        public c() {
        }

        @Override // com.baidu.navisdk.ugc.listener.b
        public void a(@oOoXoXO c0.a aVar) {
            if (aVar == null) {
                return;
            }
            s.this.q = aVar.f9222a;
            com.baidu.navisdk.module.park.a aVar2 = s.this.r;
            if (aVar2 != null) {
                aVar2.a(aVar.f9222a);
                aVar2.a(aVar.b);
            }
            s sVar = s.this;
            Bitmap bitmap = aVar.b;
            IIX0o.oO(bitmap, "mPicProcessResInfo.bitmap");
            sVar.a(bitmap);
            s.this.n();
        }

        @Override // com.baidu.navisdk.ugc.listener.b
        public void a(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "str");
            s.this.n();
            s.this.q = null;
        }
    }

    private final void a(com.baidu.navisdk.module.park.a aVar) {
        if (aVar == null) {
            return;
        }
        this.r = aVar;
        SpannableString spannableString = new SpannableString(TextUtils.isEmpty(aVar.c()) ? aVar.a() : aVar.c());
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#3377FF")), 0, spannableString.length(), 0);
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(this.u ? "是否保存车在" : "已保存车在");
        }
        TextView textView2 = this.d;
        if (textView2 != null) {
            textView2.append(spannableString);
        }
        TextView textView3 = this.d;
        if (textView3 != null) {
            textView3.append("附近");
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.k
    public void a(boolean z) {
        super.a(z);
        TextView textView = this.d;
        if (textView != null) {
            com.baidu.navisdk.ui.util.b.a(textView, R.color.nsdk_ace_dest_recommend_text);
        }
        TextView textView2 = this.e;
        if (textView2 != null) {
            com.baidu.navisdk.ui.util.b.a(textView2, R.color.nsdk_ace_dest_recommend_text);
        }
        TextView textView3 = this.g;
        if (textView3 != null) {
            com.baidu.navisdk.ui.util.b.a(textView3, R.color.nsdk_ace_dest_walk_desc_text);
        }
        TextView textView4 = this.f;
        if (textView4 != null) {
            com.baidu.navisdk.ui.util.b.a(textView4, R.color.nsdk_ace_dest_recommend_text);
        }
        View view = this.m;
        if (view != null) {
            com.baidu.navisdk.ui.util.b.a(view, R.drawable.bnav_bg_ace_dest_card_top);
        }
        View view2 = this.n;
        if (view2 != null) {
            com.baidu.navisdk.ui.util.b.a(view2, R.drawable.bnav_bg_ace_dest_card_bottom);
        }
    }

    private final void b(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMDestRecommendCard", "setCurStallInfoVisibility showStallInfo = " + z);
        }
        int i = z ? 0 : 8;
        TextView textView = this.d;
        if (textView != null) {
            textView.setVisibility(i);
        }
        TextView textView2 = this.e;
        if (textView2 != null) {
            textView2.setVisibility(i);
        }
        View view = this.p;
        if (view != null) {
            view.setVisibility(i);
        }
        if (i == 8) {
            View view2 = this.l;
            if (view2 != null) {
                view2.setVisibility(i);
            }
            TextView textView3 = this.o;
            if (textView3 != null) {
                textView3.setText("结束导航");
            }
        }
    }

    public final synchronized void a() {
        com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
        IIX0o.oO(V, "BNavigator.getInstance()");
        if (!V.B()) {
            com.baidu.navisdk.util.worker.lite.a.a(this.y, 300L);
        }
    }
}
