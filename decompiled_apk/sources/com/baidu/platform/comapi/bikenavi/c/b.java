package com.baidu.platform.comapi.bikenavi.c;

import XXO0.oIX0oI;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import com.baidu.R;
import com.baidu.mapapi.bikenavi.adapter.IBNaviStatusListener;
import com.baidu.mapapi.bikenavi.model.BikeNaviDisplayOption;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.wnplatform.i.e;
import com.baidu.platform.comapi.wnplatform.p.g;
import com.garmin.fit.xOxOoo;
import com.google.android.exoplayer2.C;
import java.math.BigDecimal;

/* loaded from: classes8.dex */
public class b extends com.baidu.platform.comapi.wnplatform.o.a {

    /* renamed from: a, reason: collision with root package name */
    LatLng f9542a;
    LatLng b;
    final Runnable c;
    final Runnable d;
    private View e;
    private Activity f;
    private com.baidu.platform.comapi.bikenavi.widget.a g;
    private com.baidu.platform.comapi.bikenavi.widget.h h;
    private com.baidu.platform.comapi.walknavi.widget.b i;
    private com.baidu.platform.comapi.walknavi.widget.b j;
    private boolean l;
    private long n;
    private boolean o;
    private double p;
    private Bitmap q;
    private BitmapDescriptor r;
    private Bitmap s;
    private BitmapDescriptor t;
    private Handler u;
    private Runnable v;
    private int w;
    private a x;
    private com.baidu.platform.comapi.wnplatform.walkmap.c y;
    private com.baidu.platform.comapi.walknavi.h.c.a k = null;
    private IBNaviStatusListener m = null;

    /* loaded from: classes8.dex */
    public class a extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        Activity f9543a;
        com.baidu.platform.comapi.walknavi.widget.b b;

        public a(long j, long j2, Activity activity, com.baidu.platform.comapi.walknavi.widget.b bVar) {
            super(j, j2);
            this.f9543a = activity;
            this.b = bVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            b.this.t();
            Activity activity = this.f9543a;
            if (activity != null && !activity.isFinishing()) {
                this.b.dismiss();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            com.baidu.platform.comapi.walknavi.widget.b bVar = this.b;
            if (bVar != null) {
                ((Button) bVar.c()).setText("确定(" + ((j / 1000) - 1) + oIX0oI.I0Io.f4095I0Io);
            }
        }
    }

    public b(Activity activity) {
        Bitmap decodeResource = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.p.a.a.b(), R.drawable.icon_start_walk);
        this.q = decodeResource;
        this.r = BitmapDescriptorFactory.fromBitmap(decodeResource);
        Bitmap decodeResource2 = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.p.a.a.b(), R.drawable.icon_arrive_walk);
        this.s = decodeResource2;
        this.t = BitmapDescriptorFactory.fromBitmap(decodeResource2);
        this.u = new Handler();
        this.v = new c(this);
        this.c = new d(this);
        this.d = new e(this);
        this.w = -1;
        this.x = null;
        this.y = new k(this);
        this.f = activity;
        this.e = com.baidu.platform.comapi.wnplatform.p.a.a.a(activity, R.layout.wsdk_layout_bikenavi_ui_layout, null);
        B();
        A();
        d();
        this.o = true;
    }

    private void A() {
        int a2 = com.baidu.platform.comapi.walknavi.b.a().K().a();
        com.baidu.platform.comapi.wnplatform.d.a.a("yang10", "all size:" + a2);
        if (a2 > 2) {
            int i = a2 - 2;
            int[] iArr = new int[i];
            int[] iArr2 = new int[i];
            int[] iArr3 = new int[i];
            com.baidu.platform.comapi.walknavi.b.a().K().b(iArr, iArr2, iArr3);
            com.baidu.platform.comapi.wnplatform.h.c.b().a(this.f, iArr, iArr2, iArr3);
        }
    }

    private void B() {
        if (com.baidu.platform.comapi.walknavi.b.a().N().l()) {
            com.baidu.platform.comapi.walknavi.b.a().N().a().getMap().addOverlay(new MarkerOptions().position(D()).icon(this.r).zIndex(9).draggable(false));
            com.baidu.platform.comapi.walknavi.b.a().N().a().getMap().addOverlay(new MarkerOptions().position(C()).icon(this.t).zIndex(9).draggable(false));
        }
        this.g = new com.baidu.platform.comapi.bikenavi.widget.a(this.f, this, this.e);
        this.h = new com.baidu.platform.comapi.bikenavi.widget.h(this.f, this, this.e);
        a(this.f, com.baidu.platform.comapi.walknavi.b.a().N().a(), 70, 0, 0, p() + 60);
    }

    private LatLng C() {
        if (this.b == null) {
            this.b = com.baidu.platform.comapi.walknavi.b.a().U();
        }
        return this.b;
    }

    private LatLng D() {
        if (this.f9542a == null) {
            this.f9542a = com.baidu.platform.comapi.walknavi.b.a().T();
        }
        return this.f9542a;
    }

    private void E() {
        this.n = System.currentTimeMillis();
    }

    private void F() {
        Bitmap bitmap = this.q;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.q.recycle();
            this.q = null;
        }
        Bitmap bitmap2 = this.s;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.s.recycle();
            this.s = null;
        }
        BitmapDescriptor bitmapDescriptor = this.r;
        if (bitmapDescriptor != null) {
            bitmapDescriptor.recycle();
            this.r = null;
        }
        BitmapDescriptor bitmapDescriptor2 = this.t;
        if (bitmapDescriptor2 != null) {
            bitmapDescriptor2.recycle();
            this.t = null;
        }
    }

    private void G() {
        com.baidu.platform.comapi.walknavi.b.a().J().a(this);
        com.baidu.platform.comapi.walknavi.b.a().L().a((com.baidu.platform.comapi.wnplatform.i.a) this);
        com.baidu.platform.comapi.walknavi.b.a().L().a((com.baidu.platform.comapi.wnplatform.i.b) this);
        com.baidu.platform.comapi.walknavi.b.a().X().a(this);
    }

    private void H() {
        com.baidu.platform.comapi.walknavi.b.a().J().b(this);
        com.baidu.platform.comapi.walknavi.b.a().L().b((com.baidu.platform.comapi.wnplatform.i.a) null);
        com.baidu.platform.comapi.walknavi.b.a().L().b((com.baidu.platform.comapi.wnplatform.i.b) null);
        com.baidu.platform.comapi.walknavi.b.a().X().b((com.baidu.platform.comapi.wnplatform.c.a) null);
    }

    private void I() {
    }

    private void J() {
        int i = (int) (this.p * 100.0d);
        int i2 = 3;
        if (i >= 0 && i < 30) {
            com.baidu.platform.comapi.wnplatform.m.a.a().a(MapBundleKey.OfflineMapKey.OFFLINE_RATION, 0);
        } else if (i >= 30 && i < 50) {
            com.baidu.platform.comapi.wnplatform.m.a.a().a(MapBundleKey.OfflineMapKey.OFFLINE_RATION, 1);
        } else if (i >= 50 && i < 80) {
            com.baidu.platform.comapi.wnplatform.m.a.a().a(MapBundleKey.OfflineMapKey.OFFLINE_RATION, 2);
        } else if (i >= 80 && i <= 100) {
            com.baidu.platform.comapi.wnplatform.m.a.a().a(MapBundleKey.OfflineMapKey.OFFLINE_RATION, 3);
        }
        com.baidu.platform.comapi.wnplatform.m.a.a().a("BikeNaviPG.realDisAndTotalDisRatio");
        int i3 = this.w;
        if (i3 >= 0 && i3 <= 1000) {
            i2 = 0;
        } else if (i3 > 1000 && i3 <= 3000) {
            i2 = 1;
        } else if (i3 > 3000 && i3 <= 5000) {
            i2 = 2;
        } else if (i3 <= 5000 || i3 > 10000) {
            if (i3 > 10000 && i3 <= 20000) {
                i2 = 4;
            } else if (i3 > 20000 && i3 <= 30000) {
                i2 = 5;
            } else if (i3 > 30000 && i3 <= 50000) {
                i2 = 6;
            } else if (i3 > 50000) {
                i2 = 7;
            } else {
                i2 = -1;
            }
        }
        com.baidu.platform.comapi.wnplatform.m.a.a().a(xOxOoo.f15470o00, i2);
        com.baidu.platform.comapi.wnplatform.m.a.a().a("BikeNaviPG.navDistance");
    }

    private void K() {
        if (this.l) {
            return;
        }
        BikeNaviDisplayOption q = com.baidu.platform.comapi.walknavi.b.a().q();
        if (q != null && !q.getShowDialogEnable()) {
            return;
        }
        if (!com.baidu.platform.comapi.walknavi.b.a().X().c()) {
            L();
        } else {
            M();
        }
    }

    private void L() {
        try {
            if (this.j == null) {
                com.baidu.platform.comapi.walknavi.widget.b b = new com.baidu.platform.comapi.walknavi.widget.b(this.f).b(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.f, R.string.wsdk_string_rg_nav_title_tip)).a(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.f, R.string.wsdk_string_rg_gps_not_open_and_set)).c(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.f, R.string.wsdk_string_rg_alert_setting)).a().a(new i(this)).d(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.f, R.string.wsdk_string_rg_nav_dialog_cancel)).b(new h(this));
                this.j = b;
                b.setOnCancelListener(new j(this));
            }
            Activity activity = this.f;
            if (activity != null && !activity.isFinishing()) {
                this.j.show();
            }
        } catch (Exception unused) {
        }
    }

    private void M() {
        Activity activity;
        if (this.j != null && (activity = this.f) != null && !activity.isFinishing()) {
            if (this.j.isShowing()) {
                this.j.dismiss();
            }
            this.j = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.r();
        Activity activity = this.f;
        if (activity != null) {
            com.baidu.platform.comapi.walknavi.h.d.a.a(activity, com.baidu.platform.comapi.wnplatform.p.a.a.b(activity, R.string.wsdk_string_rg_open_gps));
        }
        x();
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.g
    public void a(int i) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.g
    public void c() {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void d(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void e(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void f(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void g(Message message) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public int h() {
        return (int) (com.baidu.platform.comapi.wnplatform.p.b.b.a().d() * 45.0f);
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public int i() {
        return com.baidu.platform.comapi.wnplatform.p.b.b.a().b() - ((int) (com.baidu.platform.comapi.wnplatform.p.b.b.a().d() * 30.0f));
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public View j() {
        return this.e;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void k() {
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public int l() {
        return 0;
    }

    public void m() {
        Runnable runnable;
        Handler handler = this.u;
        if (handler != null && (runnable = this.c) != null) {
            handler.removeCallbacks(runnable);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void n() {
        Runnable runnable;
        com.baidu.platform.comapi.bikenavi.widget.a aVar = this.g;
        if (aVar != null) {
            aVar.f();
        }
        Handler handler = this.u;
        if (handler != null && (runnable = this.c) != null) {
            handler.removeCallbacks(runnable);
            this.u.postDelayed(this.c, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
        }
    }

    public void o() {
        Runnable runnable;
        Handler handler = this.u;
        if (handler != null && (runnable = this.d) != null) {
            handler.removeCallbacks(runnable);
            this.u.postDelayed(this.d, 3000L);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public int p() {
        BikeNaviDisplayOption q = com.baidu.platform.comapi.walknavi.b.a().q();
        if (q != null && q.getCustomBottomView() != null) {
            return q.getBottomViewHeight();
        }
        return 0;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public int q() {
        return 0;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void r() {
        Runnable runnable;
        Handler handler = this.u;
        if (handler != null && (runnable = this.v) != null) {
            handler.removeCallbacks(runnable);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a, com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        G();
        E();
        return true;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a, com.baidu.platform.comapi.walknavi.a
    public void release() {
        H();
        Handler handler = this.u;
        if (handler != null) {
            handler.removeCallbacks(this.c);
            this.u = null;
        }
        F();
    }

    public void s() {
        com.baidu.platform.comapi.wnplatform.m.a.a().a("FootNaviAutoComplete");
        com.baidu.platform.comapi.bikenavi.widget.a aVar = this.g;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void t() {
        BikeNaviDisplayOption q;
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.r();
        J();
        x();
        View view = this.e;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeAllViews();
            }
            this.e = null;
        }
        Activity activity = this.f;
        if (activity != null && !activity.isFinishing() && ((q = com.baidu.platform.comapi.walknavi.b.a().q()) == null || !q.isIsRunInFragment())) {
            this.f.finish();
        }
        com.baidu.platform.comapi.walknavi.b.a().r();
        this.f = null;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public float u() {
        return 0.0f;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void v() {
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void w() {
    }

    public void x() {
        com.baidu.platform.comapi.wnplatform.d.a.a("yang13", "call quitNavWhenConfirm:" + this.k);
        com.baidu.platform.comapi.walknavi.h.c.a aVar = this.k;
        if (aVar != null) {
            aVar.E();
        }
    }

    public com.baidu.platform.comapi.walknavi.h.c.a y() {
        return this.k;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public Handler z() {
        return null;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void a(String str) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void b(int i) {
        Runnable runnable;
        Handler handler = this.u;
        if (handler == null || (runnable = this.v) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
        this.u.postDelayed(this.v, i);
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void c(Message message) {
    }

    public void d() {
        if (com.baidu.platform.comapi.wnplatform.f.a().b()) {
            com.baidu.platform.comapi.walknavi.b.a().N().a().showScaleControl(true);
            com.baidu.platform.comapi.walknavi.b.a().N().a().showZoomControls(false);
            com.baidu.platform.comapi.walknavi.b.a().N().a().getMap().getUiSettings().setAllGesturesEnabled(true);
            a(this.f, com.baidu.platform.comapi.walknavi.b.a().N().a(), 60, 0, 0, 75);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public boolean e() {
        return this.e == null || this.f == null;
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void f(Message message) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void g() {
        this.l = true;
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a(byte[] bArr) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void e(Message message) {
        s();
        o();
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void f() {
        this.l = false;
        K();
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void c(int i) {
        com.baidu.platform.comapi.bikenavi.widget.a aVar = this.g;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void a(IBNaviStatusListener iBNaviStatusListener) {
        this.m = iBNaviStatusListener;
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.g
    public void b() {
        com.baidu.platform.comapi.walknavi.b.a().N().a(1);
        I();
        com.baidu.platform.comapi.walknavi.b.a().K().r();
        com.baidu.platform.comapi.walknavi.b.a().K().h();
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void a(boolean z) {
        com.baidu.platform.comapi.bikenavi.widget.a aVar = this.g;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void c(Bundle bundle) {
        if (bundle.getInt("updatetype") == e.a.c) {
            int i = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalDist);
            int i2 = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalTime);
            StringBuffer stringBuffer = new StringBuffer();
            com.baidu.platform.comapi.wnplatform.p.g.a(i, g.b.ZH, stringBuffer);
            this.g.a(stringBuffer.toString(), com.baidu.platform.comapi.wnplatform.p.g.a(i2, 2));
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.a
    public void d(int i) {
        K();
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a(Bundle bundle) {
        try {
            double doubleValue = new BigDecimal((bundle.getFloat("curSpeed") * 3600.0f) / 1000.0f).setScale(1, 4).doubleValue();
            double doubleValue2 = new BigDecimal((bundle.getFloat("maxSpeed") * 3600.0f) / 1000.0f).setScale(1, 4).doubleValue();
            double doubleValue3 = new BigDecimal((bundle.getFloat("avgSpeed") * 3600.0f) / 1000.0f).setScale(1, 4).doubleValue();
            this.w = bundle.getInt("AddDist");
            double doubleValue4 = new BigDecimal(bundle.getInt("AddDist") / 1000.0f).setScale(1, 4).doubleValue();
            double doubleValue5 = new BigDecimal(bundle.getInt("RouteDist") / 1000.0f).setScale(1, 4).doubleValue();
            this.g.a(new BigDecimal(bundle.getFloat("realDistance")).setScale(1, 4).doubleValue(), bundle.getLong("secTime"));
            float f = bundle.getFloat("calorie");
            com.baidu.platform.comapi.wnplatform.d.a.b("bike cal:" + f + "or:" + bundle.getFloat("calorie"));
            double doubleValue6 = new BigDecimal((double) f).setScale(1, 4).doubleValue();
            float f2 = bundle.getFloat("altidiff");
            float f3 = bundle.getFloat("altitude");
            this.p = doubleValue4 / doubleValue5;
            this.g.a(doubleValue, doubleValue3, doubleValue2);
            this.g.a((float) doubleValue6, f2, f3);
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void d(Message message) {
        com.baidu.platform.comapi.wnplatform.m.a.a().a("BikeNaviPG.reRoute");
        com.baidu.platform.comapi.wnplatform.d.a.a("yang13", "call onReRouteComplete");
        if (this.l) {
            return;
        }
        com.baidu.platform.comapi.walknavi.b.a().M().run(RGFSMTable.FsmEvent.MSG_YAWING_REROUTED);
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void b(Message message) {
        com.baidu.platform.comapi.wnplatform.m.a.a().a("BikeNaviPG.farAway");
        com.baidu.platform.comapi.wnplatform.d.a.a("yang13", "call onRouteFarAway");
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.r();
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
        com.baidu.platform.comapi.bikenavi.widget.h hVar = this.h;
        if (hVar != null) {
            hVar.a(R.drawable.bn_faraway_route_blue, "已偏航");
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void b(Bundle bundle) {
        int i = bundle.getInt("simpleUpdateType");
        if (i == 0 || i == 3 || !bundle.containsKey("maneuverKind") || !bundle.containsKey("nDistance2GP")) {
            return;
        }
        int i2 = bundle.getInt("maneuverKind");
        int a2 = com.baidu.platform.comapi.bikenavi.c.a.a(com.baidu.platform.comapi.wnplatform.i.c.b(RouteGuideKind.values()[i2]));
        int i3 = bundle.getInt("nDistance2GP");
        int i4 = ((i3 + 5) / 10) * 10;
        if ("到达目的地".equals(bundle.getString("usGuideText"))) {
            o();
        }
        StringBuilder sb = new StringBuilder();
        if (i2 != 0) {
            com.baidu.platform.comapi.wnplatform.d.a.b("update guidance type:" + i2 + "dis:" + i3);
            StringBuffer stringBuffer = new StringBuffer();
            com.baidu.platform.comapi.wnplatform.p.g.a(i4, g.b.ZH, stringBuffer);
            sb.append(stringBuffer.toString());
            int i5 = bundle.getInt("enSpliceType");
            if (i5 == 1) {
                sb.append("前");
            } else if (i5 == 3) {
                sb.append("后");
            }
            this.h.a(a2, sb.toString());
            this.h.d();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.g
    public void a() {
        com.baidu.platform.comapi.walknavi.b.a().K().i();
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.a
    public void a(Message message) {
        if (message.arg1 == 0) {
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
            com.baidu.platform.comapi.bikenavi.widget.h hVar = this.h;
            if (hVar != null) {
                hVar.a(R.drawable.bn_gps_blue, "GPS弱");
                this.h.c();
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void a(Context context, View view, int i, int i2, int i3, int i4) {
        super.a(context, view, i, i2, i3, i4);
    }

    public void a(boolean z, int i) {
        String b;
        Activity activity;
        try {
            Activity activity2 = this.f;
            if (activity2 != null && !activity2.isFinishing()) {
                BikeNaviDisplayOption q = com.baidu.platform.comapi.walknavi.b.a().q();
                if (q != null && !q.getShowDialogEnable()) {
                    t();
                    return;
                }
                com.baidu.platform.comapi.walknavi.widget.b b2 = new com.baidu.platform.comapi.walknavi.widget.b(this.f).a(true).b(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.f, R.string.wsdk_string_rg_nav_title_tip));
                if (com.baidu.platform.comapi.walknavi.h.b.b.f9767a == 2) {
                    b = com.baidu.platform.comapi.wnplatform.p.a.a.b(this.f, i);
                } else {
                    b = com.baidu.platform.comapi.wnplatform.p.a.a.b(this.f, i);
                }
                this.i = b2.a(b).d(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.f, R.string.wsdk_string_rg_exit_check)).b().b(new g(this)).c(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.f, R.string.wsdk_string_rg_nav_dialog_cancel)).a(new f(this));
                if (z) {
                    a aVar = new a(7000L, 1000L, this.f, this.i);
                    this.x = aVar;
                    aVar.start();
                }
                if (this.i.isShowing() || (activity = this.f) == null || activity.isFinishing()) {
                    return;
                }
                this.i.show();
                return;
            }
            com.baidu.platform.comapi.wnplatform.m.a.a().a("BikeNaviPG.exitNavi");
            x();
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void a(com.baidu.platform.comapi.walknavi.h.c.a aVar) {
        this.k = aVar;
    }
}
