package com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public abstract class b extends a {
    protected ViewGroup i;
    protected TextView j;
    protected ImageView k;
    private String l;

    public b(Context context, ViewGroup viewGroup) {
        this(context, viewGroup, null);
    }

    private void C(boolean z) {
        Drawable f;
        if (z) {
            f = com.baidu.navisdk.ui.routeguide.holder.a.d().a();
        } else {
            f = a0.I().f();
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(u0(), "disposeNextTurnVisible -> nextTurnDrawable = " + f);
        }
        if (f != null) {
            x.b().a(f);
            a0.I().i(true);
            x.b().M0();
            x.b().r(0);
            return;
        }
        x0();
    }

    private void f(String str) {
        if (this.j != null && !l0.c(str)) {
            this.l = str;
            this.j.setText(JarUtils.getResources().getString(R.string.nsdk_string_rg_fuzzy_panel_text, str));
        }
    }

    private void x0() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(u0(), "resetNextTurnVisible!");
        }
        a0.I().i(false);
        x.b().F();
    }

    private void y0() {
        Bundle h = a0.I().h();
        String string = h.getString("road_name");
        int i = h.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist);
        if (TextUtils.isEmpty(string) && i <= 0 && a0.I().s()) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(u0(), "next guide info empty, and update top panel by gfgi");
            }
            Bundle bundle = new Bundle();
            JNIGuidanceControl.getInstance().getFirstRouteGuideInfo(bundle);
            if (gVar.d()) {
                gVar.e(u0(), "bundle: " + bundle.toString());
            }
            int i2 = bundle.getInt("resid", 0);
            String string2 = bundle.getString("icon_name", "turn_back.png");
            int i3 = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist, 0);
            String string3 = bundle.getString("road_name");
            if (i2 > 0) {
                x.b().f(a0.I().a(string2, i3, string3));
            }
        }
    }

    public abstract void B(boolean z);

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        B(true);
        if (a()) {
            w0();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(u0(), "RGMMFuzzyGuideView hide()");
        }
        super.c();
        this.i.setVisibility(8);
        this.l = "";
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void d(Bundle bundle) {
        String g;
        super.d(bundle);
        boolean Q2 = x.b().Q2();
        if (Q2) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(u0(), "updateData isVdrMiddleLowInStart ");
            }
            g = com.baidu.navisdk.ui.routeguide.holder.a.d().b();
        } else {
            g = a0.I().g();
        }
        if (l0.c(g)) {
            g = this.l;
        }
        f(g);
        C(Q2);
    }

    @Override // com.baidu.navisdk.pronavi.ui.guidepanel.fuzzy.a
    public void s0() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(u0(), "switchToSimpleGuidePanel ->");
        }
        y0();
        x0();
    }

    public abstract String u0();

    public void w0() {
        d(null);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(u0(), "RGMMFuzzyGuideView show()");
        }
        super.y();
        this.i.setVisibility(0);
        C(x.b().Q2());
        return true;
    }

    public b(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        B(false);
        w0();
    }
}
