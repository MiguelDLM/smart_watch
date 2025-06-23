package com.baidu.platform.comapi.bikenavi.c;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.R;
import com.baidu.mapapi.bikenavi.model.BikeNaviDisplayOption;
import java.math.BigDecimal;

/* loaded from: classes8.dex */
public class l extends com.baidu.platform.comapi.wnplatform.o.a {

    /* renamed from: a, reason: collision with root package name */
    private Activity f9553a;
    private View b;
    private boolean d;
    private double f;
    private com.baidu.platform.comapi.walknavi.h.c.a c = null;
    private int e = -1;

    public l(Activity activity) {
        this.b = null;
        this.f9553a = activity;
        this.b = com.baidu.platform.comapi.wnplatform.p.a.a.a(activity, R.layout.wsdk_light_bike_ui_layout, null);
        com.baidu.platform.comapi.walknavi.b.a().c(100);
        m();
    }

    private void s() {
        com.baidu.platform.comapi.walknavi.b.a().J().a(this);
        com.baidu.platform.comapi.walknavi.b.a().L().a((com.baidu.platform.comapi.wnplatform.i.a) this);
        com.baidu.platform.comapi.walknavi.b.a().L().a((com.baidu.platform.comapi.wnplatform.i.b) this);
        com.baidu.platform.comapi.walknavi.b.a().X().a(this);
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.g
    public void a() {
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void b(int i) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.g
    public void c() {
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.a
    public void d(int i) {
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
        return 0;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public int i() {
        return 0;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public View j() {
        return this.b;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void k() {
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public int l() {
        return 0;
    }

    public void m() {
        com.baidu.platform.comapi.walknavi.b.a().N().a().showScaleControl(false);
        com.baidu.platform.comapi.walknavi.b.a().N().a().showZoomControls(false);
        com.baidu.platform.comapi.walknavi.b.a().N().a().getMap().getUiSettings().setAllGesturesEnabled(true);
        com.baidu.platform.comapi.walknavi.b.a().N().a().getMap().getUiSettings().setOverlookingGesturesEnabled(false);
        a(this.f9553a, com.baidu.platform.comapi.walknavi.b.a().N().a(), 0, 0, 0, 0);
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void n() {
    }

    public void o() {
        com.baidu.platform.comapi.walknavi.h.c.a aVar = this.c;
        if (aVar != null) {
            aVar.E();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public int p() {
        return 0;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public int q() {
        return 0;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void r() {
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a, com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        s();
        return true;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a, com.baidu.platform.comapi.walknavi.a
    public void release() {
        d();
        this.f9553a = null;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void t() {
        BikeNaviDisplayOption q;
        o();
        View view = this.b;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeAllViews();
            }
            this.b = null;
        }
        Activity activity = this.f9553a;
        if (activity != null && !activity.isFinishing() && ((q = com.baidu.platform.comapi.walknavi.b.a().q()) == null || !q.isIsRunInFragment())) {
            this.f9553a.finish();
        }
        com.baidu.platform.comapi.walknavi.b.a().r();
        this.f9553a = null;
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

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public Handler z() {
        return null;
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.g
    public void a(int i) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void b(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void c(int i) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void d(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void e(Message message) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void f(Message message) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void g() {
        this.d = true;
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.a
    public void a(Message message) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void b(Message message) {
        com.baidu.platform.comapi.wnplatform.m.a.a().a("BikeNaviPG.farAway");
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void c(Bundle bundle) {
    }

    public void d() {
        com.baidu.platform.comapi.walknavi.b.a().J().b(this);
        com.baidu.platform.comapi.walknavi.b.a().L().b((com.baidu.platform.comapi.wnplatform.i.a) this);
        com.baidu.platform.comapi.walknavi.b.a().L().b((com.baidu.platform.comapi.wnplatform.i.b) this);
        com.baidu.platform.comapi.walknavi.b.a().X().b(this);
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public boolean e() {
        return this.b == null || this.f9553a == null;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void f() {
        this.d = false;
        m();
        com.baidu.platform.comapi.walknavi.b.a().M().run("[查看全览]按钮点击");
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void a(String str) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.g
    public void b() {
        com.baidu.platform.comapi.walknavi.b.a().K().r();
        com.baidu.platform.comapi.walknavi.b.a().K().h();
        com.baidu.platform.comapi.walknavi.b.a().z();
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void c(Message message) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void a(boolean z) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a(byte[] bArr) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a(Bundle bundle) {
        try {
            BigDecimal.valueOf((bundle.getFloat("curSpeed") * 3600.0f) / 1000.0f).setScale(1, 4).doubleValue();
            BigDecimal.valueOf((bundle.getFloat("maxSpeed") * 3600.0f) / 1000.0f).setScale(1, 4).doubleValue();
            BigDecimal.valueOf((bundle.getFloat("avgSpeed") * 3600.0f) / 1000.0f).setScale(1, 4).doubleValue();
            this.e = bundle.getInt("AddDist");
            double doubleValue = BigDecimal.valueOf(bundle.getInt("AddDist") / 1000.0f).setScale(1, 4).doubleValue();
            double doubleValue2 = BigDecimal.valueOf(bundle.getInt("RouteDist") / 1000.0f).setScale(1, 4).doubleValue();
            BigDecimal.valueOf(bundle.getFloat("realDistance")).setScale(1, 4).doubleValue();
            bundle.getLong("secTime");
            float f = bundle.getFloat("calorie");
            com.baidu.platform.comapi.wnplatform.d.a.b("bike cal:" + f + "or:" + bundle.getFloat("calorie"));
            BigDecimal.valueOf((double) f).setScale(1, 4).doubleValue();
            bundle.getFloat("altidiff");
            bundle.getFloat("altitude");
            this.f = doubleValue / doubleValue2;
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void d(Message message) {
        com.baidu.platform.comapi.wnplatform.m.a.a().a("BikeNaviPG.reRoute");
        com.baidu.platform.comapi.wnplatform.d.a.a("yang13", "call onReRouteComplete");
        if (this.d) {
            return;
        }
        com.baidu.platform.comapi.walknavi.b.a().M().run("[查看全览]按钮点击");
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void a(com.baidu.platform.comapi.walknavi.h.c.a aVar) {
        this.c = aVar;
    }
}
