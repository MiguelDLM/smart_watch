package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class i1 extends com.baidu.navisdk.ui.routeguide.widget.d {
    private View i;
    private TextView j;
    private ImageView k;
    private boolean l;
    private boolean m;
    private ViewStub n;
    private View o;
    private com.baidu.navisdk.util.worker.f<String, String> p;
    private boolean q;
    private boolean r;
    private boolean s;
    private View.OnClickListener t;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i1.this.P();
        }
    }

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.util.worker.f<String, String> {
        public b(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            i1.this.p = null;
            i1.this.P();
            return null;
        }
    }

    public i1(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.l = false;
        this.m = false;
        this.q = false;
        this.r = false;
        this.s = false;
    }

    private void q0() {
        ViewGroup viewGroup = this.b;
        if (viewGroup != null && !this.s) {
            this.s = true;
            this.i = viewGroup.findViewById(R.id.bnav_rg_cp_weather_btn);
            this.k = (ImageView) this.b.findViewById(R.id.bnav_rg_cp_weather_iv);
            this.j = (TextView) this.b.findViewById(R.id.bnav_rg_cp_weather_tv);
            this.n = (ViewStub) this.b.findViewById(R.id.bnav_rg_cp_weather_first_tips_stub);
            View view = this.i;
            if (view != null) {
                view.setOnClickListener(this.t);
            }
            a(false);
        }
    }

    public static boolean r0() {
        if (com.baidu.navisdk.util.common.x.s()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMWeatherBtnView", "isOpen is mock guide");
                return false;
            }
            return false;
        }
        return com.baidu.navisdk.ui.routeguide.model.t.s().l();
    }

    private void s0() {
        if (!this.q && !BNCommSettingManager.getInstance().isShowNaviWeatherTips()) {
            if (this.o == null) {
                try {
                    this.o = this.n.inflate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.o == null) {
                return;
            }
            BNCommSettingManager.getInstance().setShowNaviWeatherTips();
            this.q = true;
            this.o.setVisibility(0);
            this.o.setOnClickListener(new a());
            this.p = new b("RGMMWeatherBtnView-mAutoClearTipsTask", null);
            com.baidu.navisdk.util.worker.c.a().a(this.p, new com.baidu.navisdk.util.worker.e(2, 0), 20000L);
        }
    }

    private void t0() {
        if (this.m && this.l) {
            q0();
        }
        View view = this.i;
        if (view != null) {
            if (this.m && this.l) {
                if (view.getVisibility() != 0 && com.baidu.navisdk.function.b.FUNC_WEATHER.a()) {
                    this.i.setVisibility(0);
                    p0();
                    s0();
                    return;
                }
                return;
            }
            if (view.getVisibility() != 8) {
                this.i.setVisibility(8);
                P();
            }
        }
    }

    public void P() {
        if (!this.q) {
            return;
        }
        this.q = false;
        if (this.p != null) {
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.p, false);
            this.p = null;
        }
        View view = this.o;
        if (view != null && view.getVisibility() == 0) {
            this.o.setVisibility(8);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.t = onClickListener;
        View view = this.i;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void c(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMWeatherBtnView", "setWeatherBtnVisibility4StateChange isShow: " + z + ",isShow4NaviState: " + this.m);
        }
        if (this.m == z) {
            return;
        }
        this.m = z;
        t0();
        if (gVar.d()) {
            gVar.e("RGMMWeatherBtnView", "setWeatherBtnVisibility4StateChange isOpen: " + r0() + ", isShow4NaviState: " + this.m + ",isHasWeatherData: " + this.l);
        }
    }

    public void g(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMWeatherBtnView", "setWeatherBtnVisibility4DataChange: " + z + ", last isHasWeatherData: " + this.l);
        }
        if (this.l == z) {
            return;
        }
        this.l = z;
        t0();
        if (gVar.d()) {
            gVar.e("RGMMWeatherBtnView", "setWeatherBtnVisibility4DataChange isOpen: " + r0() + ", isShow4NaviState: " + this.m + ",isHasWeatherData: " + z);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        if (this.p != null) {
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.p, false);
            this.p = null;
        }
    }

    public View n0() {
        return this.i;
    }

    public boolean o0() {
        View view = this.i;
        if (view != null && view.isShown()) {
            return true;
        }
        return false;
    }

    public void p0() {
        int b2;
        Drawable f;
        boolean j = com.baidu.navisdk.ui.routeguide.model.t.s().j();
        if (this.r == j) {
            return;
        }
        this.r = j;
        ImageView imageView = this.k;
        if (imageView != null) {
            if (j) {
                f = JarUtils.getResources().getDrawable(R.drawable.nsdk_drawable_common_ic_weather_selected);
            } else {
                f = com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_common_ic_weather);
            }
            imageView.setImageDrawable(f);
        }
        TextView textView = this.j;
        if (textView != null) {
            if (j) {
                b2 = JarUtils.getResources().getColor(R.color.nsdk_cl_text_g);
            } else {
                b2 = com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_text_h);
            }
            textView.setTextColor(b2);
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMWeatherBtnView", "updateWeatherState isSelected: " + j);
        }
        if (j) {
            P();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        View view = this.i;
        if (view != null) {
            view.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_rg_selector_common_control_btn_bg));
        }
        ImageView imageView = this.k;
        if (imageView != null && !this.r) {
            imageView.setImageDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_common_ic_weather));
        }
        TextView textView = this.j;
        if (textView == null || this.r) {
            return;
        }
        textView.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_text_h));
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        P();
        this.s = false;
        this.r = false;
        this.i = null;
        this.k = null;
        this.j = null;
        t0();
    }
}
