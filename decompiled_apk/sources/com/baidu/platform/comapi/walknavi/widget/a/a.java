package com.baidu.platform.comapi.walknavi.widget.a;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.R;
import com.baidu.ar.marker.IMarkerStateListener;
import com.baidu.ar.marker.PositioningModuleAddListener;
import com.baidu.mapapi.walknavi.model.WalkNaviDisplayOption;
import com.baidu.platform.comapi.basestruct.Point;
import java.util.Timer;

/* loaded from: classes8.dex */
public class a extends ao {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f9843a = false;
    private static final String b = "a";
    private boolean c;
    private ViewGroup d;
    private final com.baidu.platform.comapi.walknavi.h.b e;
    private ImageView f;
    private View g;
    private RelativeLayout h;
    private CheckBox i;
    private RelativeLayout k;
    private RelativeLayout l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private ImageView s;
    private TextView t;
    private RelativeLayout u;
    private RelativeLayout w;
    private Timer y;
    private boolean v = false;
    private Handler x = new Handler(Looper.getMainLooper());
    private IMarkerStateListener z = new g(this);
    private boolean A = false;
    private PositioningModuleAddListener B = new h(this);
    private boolean j = com.baidu.platform.comapi.walknavi.b.a().O().a("six_dof_ar_auto", false);

    public a(Context context, ViewGroup viewGroup, com.baidu.platform.comapi.wnplatform.o.a aVar) {
        this.c = false;
        this.d = viewGroup;
        this.e = (com.baidu.platform.comapi.walknavi.h.b) aVar;
        this.f = (ImageView) viewGroup.findViewById(R.id.ar_setting_btn);
        this.h = (RelativeLayout) viewGroup.findViewById(R.id.setting_mask);
        this.g = viewGroup.findViewById(R.id.fake_touch_view);
        viewGroup.findViewById(R.id.guide_back).setOnClickListener(new b(this));
        viewGroup.findViewById(R.id.user_guide).setOnClickListener(new o(this));
        g();
        CheckBox checkBox = (CheckBox) viewGroup.findViewById(R.id.ar_switch_check);
        this.i = checkBox;
        if (this.j) {
            checkBox.setChecked(true);
        } else {
            checkBox.setChecked(false);
        }
        this.i.setOnCheckedChangeListener(new s(this));
        viewGroup.findViewById(R.id.setting_panel).setOnClickListener(new t(this));
        viewGroup.findViewById(R.id.setting_mask_quit).setOnClickListener(new u(this));
        this.f.setOnClickListener(new v(this));
        TextView textView = (TextView) viewGroup.findViewById(R.id.goto_guide);
        textView.getPaint().setFlags(8);
        textView.getPaint().setAntiAlias(true);
        textView.setOnClickListener(new w(this));
        RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(R.id.error_mask);
        this.k = relativeLayout;
        relativeLayout.setOnTouchListener(new x(this));
        this.l = (RelativeLayout) viewGroup.findViewById(R.id.loading_mask);
        TextView textView2 = (TextView) viewGroup.findViewById(R.id.exit_nav);
        this.m = textView2;
        textView2.setOnClickListener(new y(this, aVar));
        TextView textView3 = (TextView) viewGroup.findViewById(R.id.go_normal_nav);
        this.n = textView3;
        textView3.setOnClickListener(new c(this, aVar));
        this.o = (TextView) viewGroup.findViewById(R.id.test);
        this.p = (TextView) viewGroup.findViewById(R.id.test2);
        RelativeLayout relativeLayout2 = (RelativeLayout) viewGroup.findViewById(R.id.ar_guide_mask);
        this.u = relativeLayout2;
        relativeLayout2.setOnTouchListener(new d(this));
        this.q = (TextView) viewGroup.findViewById(R.id.guide_text1);
        this.r = (TextView) viewGroup.findViewById(R.id.guide_text2);
        this.s = (ImageView) viewGroup.findViewById(R.id.guide_image);
        this.t = (TextView) viewGroup.findViewById(R.id.bottom_btn);
        this.w = (RelativeLayout) viewGroup.findViewById(R.id.six_dof_guide);
        String str = Build.BRAND;
        if ("huawei".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str)) {
            this.c = true;
        }
    }

    private void h() {
    }

    private void i() {
        Timer timer;
        if (this.c && (timer = this.y) != null) {
            timer.cancel();
        }
    }

    private void j() {
        com.baidu.platform.comapi.walknavi.b.a().b("initNavController");
        com.baidu.platform.comapi.wnplatform.a.a().a(this.z);
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Point w = com.baidu.platform.comapi.walknavi.b.a().K().w();
        if (w != null && w.getIntX() != 0 && w.getIntY() != 0) {
            float[] fArr = {(float) w.getDoubleX(), (float) w.getDoubleY()};
            com.baidu.platform.comapi.walknavi.b.a().b("updateLocation DEFAULT !!!" + ((int) w.getDoubleX()) + "|" + ((int) w.getDoubleY()));
            com.baidu.platform.comapi.wnplatform.a.a().e().updateLocation(fArr, 1, true);
        }
    }

    private void l() {
        this.v = false;
        f9843a = false;
        if (com.baidu.platform.comapi.wnplatform.a.a().e() == null) {
            return;
        }
        com.baidu.platform.comapi.wnplatform.a.a().e().setOnReciveShakeListener(new i(this));
        com.baidu.platform.comapi.wnplatform.a.a().e().setOnSetupComplete(new j(this));
        com.baidu.platform.comapi.wnplatform.a.a().e().setOnReciveFootBridgeFormLuaListener(new k(this));
        com.baidu.platform.comapi.wnplatform.a.a().e().setOnReciveTunnelFormLuaListener(new m(this));
        com.baidu.platform.comapi.wnplatform.a.a().e().setOnReciveCrossStreetFormLuaListener(new p(this));
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.ao
    public void a(int i) {
    }

    private void g() {
        WalkNaviDisplayOption o = com.baidu.platform.comapi.walknavi.b.a().o();
        if (o != null) {
            a(o.isAutoChaneNaviMode());
        }
    }

    public void c() {
        RelativeLayout relativeLayout = this.w;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.ao
    public boolean d() {
        RelativeLayout relativeLayout = this.w;
        return relativeLayout == null || relativeLayout.getVisibility() == 8 || this.w.getVisibility() != 0;
    }

    public void e() {
        i();
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.ao
    public void f() {
        if (com.baidu.platform.comapi.wnplatform.f.a().c()) {
            ImageView imageView = this.f;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            h();
            return;
        }
        if (com.baidu.platform.comapi.wnplatform.f.a().b()) {
            b(false);
            ImageView imageView2 = this.f;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            RelativeLayout relativeLayout = this.h;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            com.baidu.platform.comapi.walknavi.h.b bVar = this.e;
            if (bVar != null) {
                bVar.B();
                this.e.b(false);
            }
            e();
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.ao
    public boolean b() {
        return this.v;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.ao
    public void b(boolean z) {
        RelativeLayout relativeLayout = this.l;
        if (relativeLayout == null) {
            return;
        }
        if (z) {
            relativeLayout.setVisibility(0);
        } else {
            relativeLayout.setVisibility(8);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.ao
    public void c(boolean z) {
        if (z) {
            if (com.baidu.platform.comapi.walknavi.b.a().O().a("six_dof_ar_new_guide", true)) {
                b(0);
                j();
                return;
            } else {
                j();
                b(true);
                return;
            }
        }
        if (com.baidu.platform.comapi.walknavi.b.a().O().a("six_dof_ar_new_guide", true)) {
            b(0);
        }
        if (!this.v) {
            j();
        }
        b(true);
        this.A = com.baidu.platform.comapi.wnplatform.a.a().f();
        com.baidu.platform.comapi.walknavi.b.a().b("ArEngine resume:" + this.A);
    }

    public void a(boolean z) {
        this.j = z;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.ao
    public boolean a() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (i != 0) {
            if (i == 1) {
                TextView textView = this.q;
                if (textView != null) {
                    textView.setText("放下手机");
                }
                TextView textView2 = this.r;
                if (textView2 != null) {
                    textView2.setText("使用普通导航");
                }
                TextView textView3 = this.t;
                if (textView3 != null) {
                    textView3.setText("立即体验");
                    this.t.setOnClickListener(new f(this));
                }
                ImageView imageView = this.s;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.wsdk_horizontal);
                    return;
                }
                return;
            }
            return;
        }
        TextView textView4 = this.q;
        if (textView4 != null) {
            textView4.setText("抬起手机");
        }
        TextView textView5 = this.r;
        if (textView5 != null) {
            textView5.setText("跟随AR路线行走");
        }
        TextView textView6 = this.t;
        if (textView6 != null) {
            textView6.setText("下一页");
            this.t.setOnClickListener(new e(this));
        }
        ImageView imageView2 = this.s;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.wsdk_vertical);
        }
        RelativeLayout relativeLayout = this.u;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
    }
}
