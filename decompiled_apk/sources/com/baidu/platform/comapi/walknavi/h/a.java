package com.baidu.platform.comapi.walknavi.h;

import XIXIX.OOXIXo;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.R;
import com.baidu.mapapi.walknavi.model.WalkNaviDisplayOption;
import java.math.BigDecimal;
import org.eclipse.paho.android.service.MqttServiceConstants;

/* loaded from: classes8.dex */
public class a extends com.baidu.platform.comapi.wnplatform.o.a {

    /* renamed from: a, reason: collision with root package name */
    private Activity f9763a;
    private View b;
    private float e;
    private double g;
    private com.baidu.platform.comapi.walknavi.h.c.a c = null;
    private boolean d = true;
    private int f = -1;

    public a(Activity activity) {
        this.b = null;
        this.f9763a = activity;
        this.b = com.baidu.platform.comapi.wnplatform.p.a.a.a(activity, R.layout.wsdk_light_nav_ui_layout, null);
        com.baidu.platform.comapi.walknavi.b.a().c(100);
        m();
    }

    private void o() {
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
        if (com.baidu.platform.comapi.wnplatform.f.a().f()) {
            com.baidu.platform.comapi.walknavi.b.a().N().a().showScaleControl(false);
            com.baidu.platform.comapi.walknavi.b.a().N().a().showZoomControls(false);
            com.baidu.platform.comapi.walknavi.b.a().N().a().getMap().getUiSettings().setAllGesturesEnabled(true);
            com.baidu.platform.comapi.walknavi.b.a().N().a().getMap().getUiSettings().setOverlookingGesturesEnabled(false);
            a(this.f9763a, com.baidu.platform.comapi.walknavi.b.a().N().a(), 0, 0, 0, 0);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void n() {
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
        o();
        return true;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a, com.baidu.platform.comapi.walknavi.a
    public void release() {
        d();
        this.f9763a = null;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void t() {
        WalkNaviDisplayOption o;
        com.baidu.platform.comapi.walknavi.h.c.a aVar = this.c;
        if (aVar != null) {
            aVar.E();
        }
        View view = this.b;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                int i = 0;
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    if (i >= viewGroup.getChildCount()) {
                        break;
                    }
                    viewGroup.removeView(viewGroup.getChildAt(i));
                    i++;
                }
            }
            this.b = null;
        }
        Activity activity = this.f9763a;
        if (activity != null && !activity.isFinishing() && ((o = com.baidu.platform.comapi.walknavi.b.a().o()) == null || !o.isIsRunInFragment())) {
            this.f9763a.finish();
        }
        com.baidu.platform.comapi.walknavi.b.a().p();
        this.f9763a = null;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public float u() {
        return this.e;
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
        com.baidu.platform.comapi.wnplatform.m.a.a().a("FootNaviPG.farAway");
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
        return this.b == null || this.f9763a == null;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void f() {
        this.d = false;
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
        double d = OOXIXo.f3760XO;
        float f = 0.0f;
        try {
            this.e = bundle.getFloat("curSpeed");
            this.f = bundle.getInt("AddDist");
            d = BigDecimal.valueOf(bundle.getInt("AddDist") / 1000.0f).setScale(1, 4).doubleValue();
            f = bundle.getInt("RouteDist") / 1000.0f;
            float f2 = bundle.getFloat("calorie");
            com.baidu.platform.comapi.wnplatform.d.a.b("walk cal:" + f2 + "or:" + bundle.getFloat("calorie"));
            BigDecimal.valueOf((double) f2).setScale(1, 4).doubleValue();
        } catch (Exception e) {
            com.baidu.platform.comapi.wnplatform.d.a.b(MqttServiceConstants.TRACE_EXCEPTION + e.getMessage());
        }
        this.g = d / f;
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void d(Message message) {
        com.baidu.platform.comapi.wnplatform.m.a.a().a("FootNaviPG.reRoute");
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
