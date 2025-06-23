package com.baidu.navisdk.ui.routeguide.pip;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.view.ViewGroup;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.pronavi.h;
import com.baidu.navisdk.module.pronavi.message.f;
import com.baidu.navisdk.module.roadcondition.a;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.m;
import com.baidu.navisdk.ui.routeguide.navicenter.BNavigatorLogic;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.l0;

/* loaded from: classes8.dex */
public class b extends com.baidu.navisdk.ui.routeguide.pip.a implements f {

    /* renamed from: a, reason: collision with root package name */
    private RGPipView f9081a;
    private ViewGroup b;
    private Context c;
    private float d;
    private h e;
    private boolean f;
    private int g;
    private boolean h;
    private com.baidu.navisdk.module.roadcondition.b i;
    private a.d j;
    private boolean k;
    private int l;
    private int m;
    private long n;
    private boolean o;
    private boolean q;
    private int p = 0;
    private final com.baidu.navisdk.util.worker.lite.b r = new a("pip exp");
    private final BNMapObserver s = new C0473b();

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.lite.b {
        public a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            if (b.this.p >= 4) {
                return;
            }
            b.b(b.this);
            if (!b.this.i()) {
                b.this.h();
                com.baidu.navisdk.util.worker.lite.a.a(b.this.r, 1000L);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.pip.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0473b implements BNMapObserver {
        public C0473b() {
        }

        @Override // com.baidu.navisdk.comapi.base.b
        public void update(com.baidu.navisdk.comapi.base.c cVar, int i, int i2, Object obj) {
            if (i == 1 && i2 == 256) {
                b.this.j();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements a.d {

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (BNavigatorLogic.z0 && b.this.f9081a != null) {
                    b.this.f9081a.a(b.this.i.a());
                }
            }
        }

        public c() {
        }

        @Override // com.baidu.navisdk.module.roadcondition.a.d
        public void a() {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("kpkkikkpk", "loadRoadConditionDone: ");
            }
            if (BNavigatorLogic.z0) {
                b.this.b.post(new a());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BNavigatorLogic.z0 && b.this.f9081a != null) {
                b.this.f9081a.a(com.baidu.navisdk.module.pronavi.model.g.o().a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        a("map resize");
        if (this.o && i()) {
            g();
            this.o = false;
        } else {
            BNMapController.getInstance().setMapShowScreenRect(0, 0, BNMapController.getInstance().getScreenWidth(), BNMapController.getInstance().getScreenHeight() - ScreenUtil.getInstance().dip2px(45));
        }
    }

    private void k() {
        String j = m.y().j();
        String b = a0.I().b(j);
        String a2 = a0.I().a(j);
        String a3 = m.y().a();
        boolean y = a0.I().y();
        this.f9081a.b();
        this.f9081a.setTurnIconResource(R.drawable.nsdk_drawable_rg_ic_turn_along);
        if (a3 == null) {
            this.f9081a.setRemainDistStart(b);
            this.f9081a.setRemainDistEnd(a2);
            this.f9081a.setSecondLineText(m.y().b());
            return;
        }
        if (y) {
            this.f9081a.setRemainDistStart("现在");
            this.f9081a.setRemainDistEnd("");
        } else {
            this.f9081a.setRemainDistStart(b);
            this.f9081a.setRemainDistEnd(a2 + "后");
        }
        this.f9081a.setSecondLineText(a3);
    }

    private void l() {
        if (a0.I().q()) {
            this.f9081a.a();
            this.f9081a.setTurnIcon(null);
            this.f9081a.setSingleText(this.c.getResources().getString(R.string.nsdk_string_rg_carlogo_free));
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().f2()) {
            this.f9081a.a();
            String string = this.c.getResources().getString(R.string.nsdk_string_rg_fuzzy_panel_text, a0.I().g());
            this.f9081a.setTurnIconResource(R.drawable.bnav_drawable_set_off);
            this.f9081a.setSingleText(string);
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().N2()) {
            this.f9081a.a();
            String string2 = this.c.getResources().getString(R.string.nsdk_string_rg_fuzzy_panel_text, com.baidu.navisdk.ui.routeguide.holder.a.d().b());
            this.f9081a.setTurnIconResource(R.drawable.bnav_drawable_set_off);
            this.f9081a.setSingleText(string2);
            return;
        }
        if (m.y().u()) {
            k();
        } else {
            m();
        }
    }

    private void m() {
        Bundle h = a0.I().h();
        a(h.getString("road_name"), h.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist), a0.I().d(h.getString("icon_name")));
    }

    @Override // com.baidu.navisdk.module.pronavi.message.f
    public Object b(com.baidu.navisdk.module.pronavi.message.model.c cVar) {
        return null;
    }

    public static /* synthetic */ int b(b bVar) {
        int i = bVar.p;
        bVar.p = i + 1;
        return i;
    }

    private void g() {
        if (this.f) {
            a("exitPip");
            this.f = false;
            h hVar = this.e;
            if (hVar != null) {
                hVar.b();
            }
            if (this.d != 0.0f) {
                BNMapController.getInstance().setDpiScale(this.d);
            }
            this.d = 0.0f;
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_PIP);
            if (this.k) {
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I().b(true);
                this.k = false;
            }
            b();
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().s0().setVisibility(0);
            if (this.h || this.q) {
                return;
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.x.8.3", this.g + "", "1");
            int currentTimeMillis = (int) ((System.currentTimeMillis() - this.n) / 1000);
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.x.8.4", currentTimeMillis + "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        g gVar = g.MAP;
        if (gVar.d()) {
            gVar.e("kpkkikkpk", "expand it");
        }
        try {
            Intent intent = new Intent(com.baidu.navisdk.framework.a.c().a(), Class.forName("com.baidu.baidumaps.MapsActivity"));
            intent.setFlags(268566528);
            intent.putExtra("from_pip_arrived", true);
            com.baidu.navisdk.framework.a.c().a().startActivity(intent);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        int max = Math.max(BNMapController.getInstance().getScreenWidth(), BNMapController.getInstance().getScreenHeight());
        int min = Math.min(BNMapController.getInstance().getScreenWidth(), BNMapController.getInstance().getScreenHeight());
        boolean a2 = a(max, min);
        return !a2 ? b(max, min) : a2;
    }

    public void a(Context context, ViewGroup viewGroup) {
        this.c = context;
        this.b = viewGroup;
        this.i = new com.baidu.navisdk.module.roadcondition.a();
    }

    public boolean c() {
        return this.f;
    }

    public void d() {
        g gVar = g.MAP;
        if (gVar.d()) {
            gVar.e("kpkkikkpk", "onDestroy");
        }
        this.f = false;
        if (this.d != 0.0f) {
            BNMapController.getInstance().setDpiScale(this.d);
        }
        b();
    }

    public void e() {
        if (c() && BNavigatorLogic.z0) {
            this.b.post(new d());
        }
    }

    public void f() {
        if (c() && this.i != null) {
            if (this.j == null) {
                this.j = new c();
            }
            this.i.a(this.j);
        }
    }

    private boolean b(int i, int i2) {
        int i3 = this.l / 10;
        int i4 = this.m;
        if (Math.abs(i - i4) > i4 / 10 || Math.abs(i2 - this.l) > i3) {
            return false;
        }
        g gVar = g.MAP;
        if (!gVar.d()) {
            return true;
        }
        gVar.e("kpkkikkpk", "is full surface");
        return true;
    }

    private void a(String str, int i, Drawable drawable) {
        if (c()) {
            boolean y = a0.I().y();
            this.f9081a.b();
            if (y) {
                this.f9081a.setRemainDistStart("现在");
                this.f9081a.setRemainDistEnd("");
            } else {
                String[] a2 = l0.a(i, l0.a.ZH);
                this.f9081a.setRemainDistStart(a2[0]);
                this.f9081a.setRemainDistEnd(a2[1]);
            }
            this.f9081a.setTurnIcon(drawable);
            this.f9081a.setSecondLineText(str);
        }
    }

    @Override // com.baidu.navisdk.comapi.routeguide.BNRouteGuider.c
    public void e(Message message) {
        l();
    }

    public void b() {
        RGPipView rGPipView = this.f9081a;
        if (rGPipView != null) {
            rGPipView.setVisibility(8);
        }
        BNMapController.getInstance().deleteObserver(this.s);
        BNRouteGuider.getInstance().removeRGSubStatusListener(this);
        BNRouteGuider.getInstance().removeNaviListener(this);
    }

    private void a(String str) {
        g gVar = g.MAP;
        if (gVar.d()) {
            gVar.e("kpkkikkpk", str + " screen width:" + BNMapController.getInstance().getScreenWidth() + " height:" + BNMapController.getInstance().getScreenHeight());
        }
    }

    private boolean a(int i, int i2) {
        com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
        int a2 = aVar.a(this.c);
        int b = aVar.b(this.c);
        int min = Math.min(a2, b);
        int max = Math.max(a2, b);
        int i3 = min / 2;
        if (Math.abs(i - max) > max / 2 || Math.abs(i2 - min) > i3) {
            return false;
        }
        g gVar = g.MAP;
        if (!gVar.d()) {
            return true;
        }
        gVar.e("kpkkikkpk", "is full screen");
        return true;
    }

    @Override // com.baidu.navisdk.comapi.routeguide.BNRouteGuider.c
    public void a(Message message) {
        g gVar = g.MAP;
        if (gVar.d()) {
            gVar.e("kpkkikkpk", "onArriveDest");
        }
        this.q = true;
        if (this.h) {
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.x.8.3", this.g + "", "2");
        int currentTimeMillis = (int) ((System.currentTimeMillis() - this.n) / 1000);
        com.baidu.navisdk.util.statistic.userop.b.r().d("3.x.8.4", currentTimeMillis + "");
        this.p = 0;
        h();
        com.baidu.navisdk.util.worker.lite.a.a(this.r, 500L);
    }

    @Override // com.baidu.navisdk.module.pronavi.message.f
    public int[] a() {
        return new int[]{1, 2};
    }

    @Override // com.baidu.navisdk.module.pronavi.message.f
    public void a(com.baidu.navisdk.module.pronavi.message.model.c cVar) {
        int a2 = cVar.a();
        if (a2 == 1) {
            l();
        } else if (a2 == 2) {
            l();
        }
    }
}
