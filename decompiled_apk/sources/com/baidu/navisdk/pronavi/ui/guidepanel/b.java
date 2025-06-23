package com.baidu.navisdk.pronavi.ui.guidepanel;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.indoorpark.c;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.util.j;
import com.baidu.navisdk.ui.widget.BNDrawableTextView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.d;
import com.baidu.navisdk.util.common.g;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private TextView f7916a;
    private ViewGroup b;
    private ImageView c;
    private ImageView d;
    private TextView e;
    private ImageView f;
    private ViewGroup g;
    private View h;
    private TextView i;
    private BNDrawableTextView j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private ImageView o;
    private com.baidu.navisdk.pronavi.data.vm.devicestate.b p;
    private Observer<com.baidu.navisdk.pronavi.data.vm.devicestate.a> q;
    private boolean r;

    @oOoXoXO
    private Context s;

    @oOoXoXO
    private ViewGroup t;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* renamed from: com.baidu.navisdk.pronavi.ui.guidepanel.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0353b<T> implements Observer<com.baidu.navisdk.pronavi.data.vm.devicestate.a> {
        public C0353b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(com.baidu.navisdk.pronavi.data.vm.devicestate.a aVar) {
            b.this.a(aVar);
        }
    }

    static {
        new a(null);
    }

    public b(@oOoXoXO Context context, @oOoXoXO ViewGroup viewGroup, @oOoXoXO com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        this.s = context;
        this.t = viewGroup;
        l();
    }

    private final void k() {
        com.baidu.navisdk.pronavi.data.vm.devicestate.b bVar;
        com.baidu.navisdk.framework.lifecycle.a<com.baidu.navisdk.pronavi.data.vm.devicestate.a> c;
        if (!this.r) {
            com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V, "BNavigator.getInstance()");
            com.baidu.navisdk.pronavi.ui.base.b s = V.s();
            if (s != null) {
                bVar = (com.baidu.navisdk.pronavi.data.vm.devicestate.b) s.c(com.baidu.navisdk.pronavi.data.vm.devicestate.b.class);
            } else {
                bVar = null;
            }
            this.p = bVar;
            com.baidu.navisdk.ui.routeguide.b V2 = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V2, "BNavigator.getInstance()");
            LifecycleOwner f = V2.f();
            if (f != null && this.p != null) {
                if (this.q == null) {
                    this.q = new C0353b();
                }
                this.r = true;
                com.baidu.navisdk.pronavi.data.vm.devicestate.b bVar2 = this.p;
                if (bVar2 != null && (c = bVar2.c()) != null) {
                    Observer<com.baidu.navisdk.pronavi.data.vm.devicestate.a> observer = this.q;
                    IIX0o.ooOOo0oXI(observer);
                    c.observe(f, observer);
                }
            }
        }
    }

    private final void l() {
        ViewGroup viewGroup = this.t;
        if (viewGroup == null) {
            LogUtil.e("RGSimpleDeviceStateView", "mRootViewGroup == null");
            return;
        }
        this.g = (ViewGroup) viewGroup.findViewById(R.id.bnav_rg_device_status_container);
        this.b = (ViewGroup) viewGroup.findViewById(R.id.bnav_rg_sg_satelite_panel);
        this.f7916a = (TextView) viewGroup.findViewById(R.id.bnav_rg_sg_satelite_num);
        this.c = (ImageView) viewGroup.findViewById(R.id.bnav_rg_sg_satelite_icon);
        this.d = (ImageView) viewGroup.findViewById(R.id.bnav_rg_indoor_park_bluetooth_icon);
        this.e = (TextView) viewGroup.findViewById(R.id.bnav_rg_indoor_park_bluetooth_desc);
        this.f = (ImageView) viewGroup.findViewById(R.id.bnav_rg_sg_volume_icon);
        this.h = viewGroup.findViewById(R.id.bnav_rg_service_area_panel);
        this.i = (TextView) viewGroup.findViewById(R.id.bnav_rg_service_area_subscribed_num);
        this.j = (BNDrawableTextView) viewGroup.findViewById(R.id.bnav_rg_vdr_signal_view);
        this.o = (ImageView) viewGroup.findViewById(R.id.bnav_rg_cur_area_state_label);
        ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setTag(null);
        }
    }

    private final void m() {
        com.baidu.navisdk.pronavi.data.vm.devicestate.b bVar;
        if (this.q != null && (bVar = this.p) != null) {
            this.r = false;
            com.baidu.navisdk.framework.lifecycle.a<com.baidu.navisdk.pronavi.data.vm.devicestate.a> c = bVar.c();
            if (c != null) {
                Observer<com.baidu.navisdk.pronavi.data.vm.devicestate.a> observer = this.q;
                IIX0o.ooOOo0oXI(observer);
                c.removeObserver(observer);
            }
        }
    }

    private final void n() {
        if (!this.k) {
            ImageView imageView = this.f;
            IIX0o.ooOOo0oXI(imageView);
            imageView.setVisibility(0);
        }
        ImageView imageView2 = this.f;
        IIX0o.ooOOo0oXI(imageView2);
        Object tag = imageView2.getTag();
        if (!(tag instanceof CharSequence)) {
            tag = null;
        }
        if (!TextUtils.equals("JustPlayWarning", (CharSequence) tag)) {
            ImageView imageView3 = this.f;
            IIX0o.ooOOo0oXI(imageView3);
            imageView3.setTag("JustPlayWarning");
            ImageView imageView4 = this.f;
            IIX0o.ooOOo0oXI(imageView4);
            imageView4.setImageResource(R.drawable.nsdk_rg_ic_play_warning_volume);
        }
    }

    private final void o() {
        if (!this.k) {
            ImageView imageView = this.f;
            IIX0o.ooOOo0oXI(imageView);
            imageView.setVisibility(0);
        }
        ImageView imageView2 = this.f;
        IIX0o.ooOOo0oXI(imageView2);
        Object tag = imageView2.getTag();
        if (!(tag instanceof CharSequence)) {
            tag = null;
        }
        if (!TextUtils.equals("Quiet", (CharSequence) tag)) {
            ImageView imageView3 = this.f;
            IIX0o.ooOOo0oXI(imageView3);
            imageView3.setTag("Quiet");
            ImageView imageView4 = this.f;
            IIX0o.ooOOo0oXI(imageView4);
            imageView4.setImageResource(R.drawable.nsdk_rg_ic_no_volume);
        }
    }

    private final void p() {
        if (!this.k) {
            ImageView imageView = this.f;
            IIX0o.ooOOo0oXI(imageView);
            imageView.setVisibility(0);
        }
        ImageView imageView2 = this.f;
        IIX0o.ooOOo0oXI(imageView2);
        Object tag = imageView2.getTag();
        if (!(tag instanceof CharSequence)) {
            tag = null;
        }
        if (!TextUtils.equals("ZeroVolume", (CharSequence) tag)) {
            ImageView imageView3 = this.f;
            IIX0o.ooOOo0oXI(imageView3);
            imageView3.setTag("ZeroVolume");
            ImageView imageView4 = this.f;
            IIX0o.ooOOo0oXI(imageView4);
            imageView4.setImageResource(R.drawable.nsdk_rg_ic_zero_volume);
        }
    }

    public final void b(int i) {
        TextView textView;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSimpleDeviceStateView", "updateServiceAreaSubscribeNum: " + i);
        }
        this.m = i > 0;
        if (this.h == null || (textView = this.i) == null) {
            return;
        }
        if (i > 0) {
            IIX0o.ooOOo0oXI(textView);
            textView.setText(String.valueOf(i) + "");
        }
        if (this.k) {
            return;
        }
        View view = this.h;
        IIX0o.ooOOo0oXI(view);
        view.setVisibility(i <= 0 ? 8 : 0);
    }

    public final void c() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGSimpleDeviceStateView", "default simple exitVdrLowPrecisionGuide: ");
        }
        this.n = false;
    }

    public final void d() {
    }

    public final void e() {
        ViewGroup viewGroup = this.g;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public final void f() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGSimpleDeviceStateView", "default simple intoVdrLowPrecisionGuide: " + this.n);
        }
        this.n = true;
    }

    public final boolean g() {
        return this.n;
    }

    public final void h() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGSimpleDeviceStateView", "simple default openVdrLocationMode: " + this.k + ", " + this.j);
        }
        if (!this.k && this.j != null) {
            this.k = true;
            View view = this.h;
            if (view != null) {
                IIX0o.ooOOo0oXI(view);
                if (view.getVisibility() != 8) {
                    View view2 = this.h;
                    IIX0o.ooOOo0oXI(view2);
                    view2.setVisibility(8);
                }
            }
            ImageView imageView = this.f;
            if (imageView != null) {
                IIX0o.ooOOo0oXI(imageView);
                if (imageView.getVisibility() != 8) {
                    ImageView imageView2 = this.f;
                    IIX0o.ooOOo0oXI(imageView2);
                    imageView2.setVisibility(8);
                }
            }
            BNDrawableTextView bNDrawableTextView = this.j;
            IIX0o.ooOOo0oXI(bNDrawableTextView);
            bNDrawableTextView.setVisibility(0);
            ViewGroup viewGroup = this.b;
            if (viewGroup != null) {
                IIX0o.ooOOo0oXI(viewGroup);
                viewGroup.setVisibility(8);
            }
        }
    }

    public final void i() {
        k();
    }

    public final void j() {
        ViewGroup viewGroup = this.g;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    public final void a(@oOoXoXO ViewGroup viewGroup, int i) {
        this.t = viewGroup;
        l();
    }

    public final void a(@OOXIXo Animation anim) {
        IIX0o.x0xO0oo(anim, "anim");
        ViewGroup viewGroup = this.g;
        if (viewGroup != null) {
            IIX0o.ooOOo0oXI(viewGroup);
            if (viewGroup.isShown()) {
                ViewGroup viewGroup2 = this.g;
                IIX0o.ooOOo0oXI(viewGroup2);
                viewGroup2.startAnimation(anim);
            }
        }
    }

    public final void a(@oOoXoXO Drawable drawable, @oOoXoXO String str, int i) {
        ViewGroup viewGroup;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSimpleDeviceStateView", "updateSatelliteSignal: ");
        }
        if (this.b != null && drawable != null && str != null && this.g != null) {
            c F = c.F();
            IIX0o.oO(F, "RGIndoorParkC.getInstance()");
            if (F.l()) {
                LogUtil.e("RGSimpleDeviceStateView", "updateSatelliteSignal-> isIndoorParkState return");
                ViewGroup viewGroup2 = this.b;
                IIX0o.ooOOo0oXI(viewGroup2);
                viewGroup2.setVisibility(8);
                return;
            }
            if (!com.baidu.navisdk.ui.routeguide.b.V().x()) {
                LogUtil.e("RGSimpleDeviceStateView", "!BNavigator.getInstance().hasCalcRouteOk(), return");
                return;
            }
            if (LogUtil.LOGGABLE) {
                StringBuilder sb = new StringBuilder();
                sb.append("mSatelliteIcon.isShown() : ");
                ImageView imageView = this.c;
                sb.append(imageView != null ? Boolean.valueOf(imageView.isShown()) : null);
                sb.append(", mSatelliteNumTV.isShown() : ");
                TextView textView = this.f7916a;
                IIX0o.ooOOo0oXI(textView);
                sb.append(textView.isShown());
                sb.append(", signalText = ");
                sb.append(str);
                LogUtil.e("RGSimpleDeviceStateView", sb.toString());
            }
            TextView textView2 = this.e;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            ImageView imageView2 = this.d;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            ImageView imageView3 = this.c;
            if (imageView3 != null) {
                imageView3.setImageDrawable(drawable);
            }
            TextView textView3 = this.f7916a;
            if (textView3 != null) {
                textView3.setTextColor(i);
            }
            TextView textView4 = this.f7916a;
            if (textView4 != null) {
                textView4.setText(str);
            }
            if (this.k || (viewGroup = this.b) == null) {
                return;
            }
            IIX0o.ooOOo0oXI(viewGroup);
            if (viewGroup.getVisibility() != 0) {
                ViewGroup viewGroup3 = this.b;
                IIX0o.ooOOo0oXI(viewGroup3);
                viewGroup3.setVisibility(0);
                return;
            }
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGSimpleDeviceStateView", "mSatelliteLayout = " + this.b + ",gpsIcon = " + drawable + ", signalText = " + str);
        }
    }

    public final void b(boolean z) {
        if (this.f == null) {
            return;
        }
        this.l = z;
        c F = c.F();
        IIX0o.oO(F, "RGIndoorParkC.getInstance()");
        boolean l = F.l();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSimpleDeviceStateView", "updateVolumeView:indoorIParkState = " + l);
        }
        if (z && !l) {
            a0.I().s = true;
            if (d.c(this.s) <= 0) {
                p();
                return;
            }
            BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
            IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
            if (bNCommSettingManager.getVoiceMode() == 3) {
                n();
                return;
            } else {
                o();
                return;
            }
        }
        a0.I().s = false;
        if (this.k) {
            return;
        }
        ImageView imageView = this.f;
        IIX0o.ooOOo0oXI(imageView);
        if (imageView.getVisibility() != 8) {
            ImageView imageView2 = this.f;
            IIX0o.ooOOo0oXI(imageView2);
            imageView2.setVisibility(8);
        }
    }

    public final void b() {
        View view;
        ImageView imageView;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGSimpleDeviceStateView", "simple default exitVdrLocationMode: " + this.k);
        }
        if (this.k) {
            this.k = false;
            BNDrawableTextView bNDrawableTextView = this.j;
            if (bNDrawableTextView != null) {
                IIX0o.ooOOo0oXI(bNDrawableTextView);
                bNDrawableTextView.setVisibility(8);
            }
            if (this.l && (imageView = this.f) != null) {
                IIX0o.ooOOo0oXI(imageView);
                imageView.setVisibility(0);
            }
            if (this.m && (view = this.h) != null) {
                IIX0o.ooOOo0oXI(view);
                view.setVisibility(0);
            }
            if (this.b != null) {
                c F = c.F();
                IIX0o.oO(F, "RGIndoorParkC.getInstance()");
                if (F.l()) {
                    return;
                }
                ViewGroup viewGroup = this.b;
                IIX0o.ooOOo0oXI(viewGroup);
                viewGroup.setVisibility(0);
            }
        }
    }

    public final void a(boolean z) {
        ImageView imageView = this.d;
        if (imageView != null) {
            IIX0o.ooOOo0oXI(imageView);
            imageView.setVisibility(z ? 0 : 8);
        }
        TextView textView = this.e;
        if (textView == null || z) {
            return;
        }
        IIX0o.ooOOo0oXI(textView);
        textView.setVisibility(8);
    }

    public final void a(int i) {
        g gVar = g.INDOOR_PARK;
        if (gVar.d()) {
            gVar.e("RGSimpleDeviceStateView", "mBluetoothIcon == " + this.d + ", mBluetoothText = " + this.e + ", signal = " + i);
        }
        ImageView imageView = this.d;
        if (imageView != null) {
            IIX0o.ooOOo0oXI(imageView);
            boolean z = imageView.getVisibility() == 0;
            if (gVar.d()) {
                StringBuilder sb = new StringBuilder();
                sb.append("mBluetoothIcon is show == ");
                sb.append(z);
                sb.append(", is indoorParkState = ");
                c F = c.F();
                IIX0o.oO(F, "RGIndoorParkC.getInstance()");
                sb.append(F.l());
                gVar.e("RGSimpleDeviceStateView", sb.toString());
            }
            TextView textView = this.e;
            if (textView != null) {
                if (z) {
                    c F2 = c.F();
                    IIX0o.oO(F2, "RGIndoorParkC.getInstance()");
                    if (F2.l() && i > 0) {
                        if (i >= 3) {
                            textView.setTextColor(Color.parseColor("#FFFFFF"));
                            textView.setText("定位信号强");
                        } else if (i >= 2) {
                            textView.setTextColor(Color.parseColor("#FFBC3C"));
                            textView.setText("定位信号中");
                        } else {
                            textView.setTextColor(Color.parseColor("#E15240"));
                            textView.setText("定位信号弱");
                        }
                        textView.setVisibility(0);
                        return;
                    }
                }
                textView.setVisibility(8);
            }
        }
    }

    public final void a() {
        this.n = false;
        j.a(this.c);
        j.a(this.f);
        ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setTag(null);
        }
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(com.baidu.navisdk.pronavi.data.vm.devicestate.a aVar) {
        ImageView imageView = this.o;
        if (imageView != null) {
            if (aVar != null && aVar.c() && aVar.d()) {
                imageView.setVisibility(0);
                imageView.setImageResource(aVar.a());
            } else {
                imageView.setVisibility(8);
            }
        }
    }
}
