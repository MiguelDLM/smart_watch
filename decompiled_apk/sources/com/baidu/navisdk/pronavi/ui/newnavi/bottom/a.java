package com.baidu.navisdk.pronavi.ui.newnavi.bottom;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.newguide.viewmodels.a;
import com.baidu.navisdk.ui.util.j;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;

/* loaded from: classes7.dex */
public final class a extends com.baidu.navisdk.module.newguide.subviews.c {
    private ImageView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private TextView E;
    private com.baidu.navisdk.module.newguide.viewmodels.a F;
    private boolean G;
    private Animation H;
    private Animation I;
    private AnimationSet J;
    private Handler K;
    private Runnable L;
    private Runnable M;
    private C0355a N;
    private C0355a O;
    private View.OnClickListener P;
    private View Q;
    private ImageView R;
    private boolean S;
    private FrameLayout T;
    private final String s;
    private final int t;
    private View u;
    private View v;
    private TextView w;
    private TextView x;
    private TextView y;
    private View z;

    /* renamed from: com.baidu.navisdk.pronavi.ui.newnavi.bottom.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0355a {

        /* renamed from: a, reason: collision with root package name */
        private int f7922a;

        @oOoXoXO
        private String b;

        public final void a(int i) {
            this.f7922a = i;
        }

        public final void a(@oOoXoXO String str) {
            this.b = str;
        }

        public final boolean a(@oOoXoXO String str, int i) {
            if (!TextUtils.isEmpty(this.b) && i <= this.f7922a) {
                if (!TextUtils.isEmpty(str)) {
                    IIX0o.ooOOo0oXI(str);
                    int length = str.length();
                    String str2 = this.b;
                    IIX0o.ooOOo0oXI(str2);
                    if (length > str2.length()) {
                    }
                }
                return false;
            }
            return true;
        }

        public final void a() {
            this.f7922a = 0;
            this.b = null;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b<T> implements Observer<a.d> {
        public b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(a.d dVar) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(a.this.s, "onChanged getClosetViaLiveData: " + dVar);
            }
            a.this.a(dVar);
        }
    }

    /* loaded from: classes7.dex */
    public static final class c<T> implements Observer<a.c> {
        public c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(a.c cVar) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(a.this.s, "onChanged getDestShowLiveData: " + cVar);
            }
            a.this.a(cVar);
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (a.this.P != null) {
                View.OnClickListener onClickListener = a.this.P;
                IIX0o.ooOOo0oXI(onClickListener);
                onClickListener.onClick(view);
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes7.dex */
    public static final class e extends com.baidu.navisdk.util.worker.loop.a {
        public e(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(@OOXIXo Message msg) {
            IIX0o.x0xO0oo(msg, "msg");
            if (msg.what == a.this.t) {
                a.this.x0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class f implements Runnable {
        final /* synthetic */ int b;

        public f(int i) {
            this.b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.f(String.valueOf(this.b) + "")) {
                a.this.x(0);
            } else {
                a.this.x(8);
            }
            a.this.L = null;
        }
    }

    /* loaded from: classes7.dex */
    public static final class g implements Runnable {
        final /* synthetic */ int b;

        public g(int i) {
            this.b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(a.this.s, "queueIdle: updateViaPointTrafficLight");
            }
            if (a.this.g(String.valueOf(this.b) + "")) {
                a.this.y(0);
            } else {
                a.this.y(8);
            }
            a.this.M = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@OOXIXo Context context, @oOoXoXO ViewGroup viewGroup, @oOoXoXO com.baidu.navisdk.ui.routeguide.subview.a aVar, @oOoXoXO LifecycleOwner lifecycleOwner, @oOoXoXO ViewModelStore viewModelStore, @oOoXoXO ViewGroup viewGroup2) {
        super(context, viewGroup, aVar, lifecycleOwner, viewModelStore, viewGroup2);
        IIX0o.x0xO0oo(context, "context");
        this.s = "RGNewBottomBarEtaView";
        this.t = 1;
    }

    @SuppressLint({"SetTextI18n"})
    private final void A(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.s, "updateViaPointTrafficLight: " + i);
        }
        TextView textView = this.B;
        if (textView != null) {
            if (this.M != null) {
                IIX0o.ooOOo0oXI(textView);
                textView.removeCallbacks(this.M);
                this.M = null;
            }
            if (i > 0) {
                TextView textView2 = this.B;
                IIX0o.ooOOo0oXI(textView2);
                textView2.setText(String.valueOf(i) + "");
                if (this.O == null) {
                    this.O = new C0355a();
                }
                if (a(this.B, this.C, i, this.O)) {
                    if (gVar.d()) {
                        gVar.e(this.s, "updateViaPointTrafficLight:isNeedCalcTrafficLightWidthEnough ");
                    }
                    C0355a c0355a = this.O;
                    IIX0o.ooOOo0oXI(c0355a);
                    c0355a.a(i);
                    if (this.C != null) {
                        C0355a c0355a2 = this.O;
                        IIX0o.ooOOo0oXI(c0355a2);
                        TextView textView3 = this.C;
                        IIX0o.ooOOo0oXI(textView3);
                        c0355a2.a(textView3.getText().toString());
                    }
                    this.M = new g(i);
                    TextView textView4 = this.B;
                    IIX0o.ooOOo0oXI(textView4);
                    textView4.postDelayed(this.M, 100L);
                    return;
                }
                return;
            }
            y(8);
        }
    }

    private final void e(ViewGroup viewGroup) {
        int i;
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.bnav_rg_toolbox_rookie_mode_tag);
        this.R = imageView;
        if (imageView != null) {
            IIX0o.ooOOo0oXI(imageView);
            if (r0()) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f(String str) {
        int i;
        View view = this.v;
        if (view == null || this.x == null) {
            return false;
        }
        IIX0o.ooOOo0oXI(view);
        int measuredWidth = view.getMeasuredWidth() - JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_4dp);
        TextView textView = this.x;
        IIX0o.ooOOo0oXI(textView);
        int a2 = a(textView, str);
        TextView textView2 = this.w;
        if (textView2 != null) {
            IIX0o.ooOOo0oXI(textView2);
            i = j.a(textView2, textView2.getText().toString()) + a2;
        } else {
            i = a2;
        }
        if (u0()) {
            ImageView imageView = this.R;
            IIX0o.ooOOo0oXI(imageView);
            i += imageView.getMeasuredWidth() + JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_5dp);
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.s, "isTrafficLightWidthEnough-> trafficLightCount= " + str + ", maxWidth= " + measuredWidth + ", needWidth" + i + ", trafficLightViewWidth= " + a2);
        }
        if (measuredWidth <= i) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g(String str) {
        int i;
        View view = this.z;
        if (view == null || this.B == null) {
            return false;
        }
        IIX0o.ooOOo0oXI(view);
        int measuredWidth = view.getMeasuredWidth() - JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_4dp);
        TextView textView = this.B;
        IIX0o.ooOOo0oXI(textView);
        int a2 = a(textView, str);
        TextView textView2 = this.C;
        if (textView2 != null) {
            IIX0o.ooOOo0oXI(textView2);
            i = j.a(textView2, textView2.getText().toString()) + a2;
        } else {
            i = a2;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.s, "isViaTrafficLightWidthEnough-> trafficLightCount= " + str + ", maxWidth= " + measuredWidth + ", needWidth" + i + ", trafficLightViewWidth= " + a2);
        }
        if (measuredWidth <= i) {
            return false;
        }
        return true;
    }

    private final boolean r0() {
        boolean z;
        int navPreferMode = BNSettingManager.getNavPreferMode();
        boolean z2 = com.baidu.navisdk.module.cloudconfig.f.c().c.f7120o0;
        boolean z3 = true;
        boolean activityMode = BNRouteGuider.getInstance().getActivityMode(1);
        if (z2 && activityMode) {
            z = true;
        } else {
            z = false;
        }
        if (!z && navPreferMode != 1) {
            z3 = false;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.s, "setRookieModeTag: " + navPreferMode + ", winterOlympicsTagEnable:" + z2 + ", isWinterOlympicsActivityModeOpen:" + activityMode + ", isWinterOlympicsOpen:" + z + "showTag:" + z3);
        }
        return z3;
    }

    private final void s0() {
        if (this.K == null) {
            this.K = new e("RGToolBoxView");
        }
    }

    private final boolean t0() {
        if (this.f == 1) {
            return true;
        }
        return false;
    }

    private final boolean u0() {
        ImageView imageView = this.R;
        if (imageView == null || imageView.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    private final void w0() {
        TextView textView = this.x;
        if (textView != null && this.L != null) {
            IIX0o.ooOOo0oXI(textView);
            textView.removeCallbacks(this.L);
            this.L = null;
        }
        TextView textView2 = this.B;
        if (textView2 != null && this.M != null) {
            IIX0o.ooOOo0oXI(textView2);
            textView2.removeCallbacks(this.M);
            this.M = null;
        }
        C0355a c0355a = this.N;
        if (c0355a != null) {
            IIX0o.ooOOo0oXI(c0355a);
            c0355a.a();
        }
        C0355a c0355a2 = this.O;
        if (c0355a2 != null) {
            IIX0o.ooOOo0oXI(c0355a2);
            c0355a2.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(int i) {
        TextView textView = this.x;
        if (textView != null) {
            IIX0o.ooOOo0oXI(textView);
            textView.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x0() {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.pronavi.ui.newnavi.bottom.a.x0():void");
    }

    private final void y0() {
        int i;
        ImageView imageView = this.A;
        if (imageView != null) {
            IIX0o.ooOOo0oXI(imageView);
            if (r0()) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    @SuppressLint({"SetTextI18n"})
    private final void z(int i) {
        boolean z;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.s, "updateDestinationTrafficLight: " + i);
        }
        if (!IIX0o.Oxx0IOOO(Looper.myLooper(), Looper.getMainLooper())) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(this.s, "updateTrafficCount not main thread, return!");
                return;
            }
            return;
        }
        TextView textView = this.x;
        if (textView != null) {
            if (this.L != null) {
                IIX0o.ooOOo0oXI(textView);
                textView.removeCallbacks(this.L);
                this.L = null;
            }
            if (i > 0) {
                TextView textView2 = this.x;
                IIX0o.ooOOo0oXI(textView2);
                textView2.setText(String.valueOf(i) + "");
                if (this.N == null) {
                    this.N = new C0355a();
                }
                if (a(this.x, this.w, i, this.N)) {
                    if (gVar.d()) {
                        gVar.e(this.s, "updateDestinationTrafficLight: isNeedCalcTrafficLightWidthEnough");
                    }
                    C0355a c0355a = this.N;
                    IIX0o.ooOOo0oXI(c0355a);
                    c0355a.a(i);
                    if (this.w != null) {
                        C0355a c0355a2 = this.N;
                        IIX0o.ooOOo0oXI(c0355a2);
                        TextView textView3 = this.w;
                        IIX0o.ooOOo0oXI(textView3);
                        c0355a2.a(textView3.getText().toString());
                    }
                    this.L = new f(i);
                    TextView textView4 = this.x;
                    IIX0o.ooOOo0oXI(textView4);
                    textView4.postDelayed(this.L, 100L);
                }
            } else {
                x(8);
            }
            if (gVar.d()) {
                String str = this.s;
                StringBuilder sb = new StringBuilder();
                sb.append("updateDestinationTrafficLight: ");
                TextView textView5 = this.x;
                IIX0o.ooOOo0oXI(textView5);
                if (textView5.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                gVar.e(str, sb.toString());
                return;
            }
            return;
        }
        if (gVar.d()) {
            gVar.e(this.s, "updateDestinationTrafficLight: mTrafficLightCount == null ");
        }
    }

    private final void z0() {
        try {
            if (this.f == 1) {
                TextView textView = this.w;
                if (textView != null) {
                    textView.setTextSize(1, 20.0f);
                }
                TextView textView2 = this.x;
                if (textView2 != null) {
                    textView2.setTextSize(1, 20.0f);
                }
                TextView textView3 = this.y;
                if (textView3 != null) {
                    textView3.setTextSize(1, 18.0f);
                }
                TextView textView4 = this.B;
                if (textView4 != null) {
                    textView4.setTextSize(1, 18.0f);
                }
                TextView textView5 = this.C;
                if (textView5 != null) {
                    textView5.setTextSize(1, 18.0f);
                }
                TextView textView6 = this.D;
                if (textView6 != null) {
                    textView6.setTextSize(1, 20.0f);
                }
                TextView textView7 = this.E;
                if (textView7 != null) {
                    textView7.setTextSize(1, 18.0f);
                    return;
                }
                return;
            }
            TextView textView8 = this.w;
            if (textView8 != null) {
                textView8.setTextSize(1, 17.0f);
            }
            TextView textView9 = this.x;
            if (textView9 != null) {
                textView9.setTextSize(1, 17.0f);
            }
            TextView textView10 = this.y;
            if (textView10 != null) {
                textView10.setTextSize(1, 15.0f);
            }
            TextView textView11 = this.B;
            if (textView11 != null) {
                textView11.setTextSize(1, 15.0f);
            }
            TextView textView12 = this.C;
            if (textView12 != null) {
                textView12.setTextSize(1, 15.0f);
            }
            TextView textView13 = this.D;
            if (textView13 != null) {
                textView13.setTextSize(1, 17.0f);
            }
            TextView textView14 = this.E;
            if (textView14 != null) {
                textView14.setTextSize(1, 15.0f);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.navisdk.module.newguide.subviews.c, com.baidu.navisdk.module.newguide.widgets.c, com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        this.G = false;
        Handler handler = this.K;
        if (handler != null) {
            IIX0o.ooOOo0oXI(handler);
            handler.removeCallbacksAndMessages(null);
            this.K = null;
        }
        w0();
    }

    @Override // com.baidu.navisdk.module.newguide.subviews.c
    public void n0() {
        if (this.F == null) {
            com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V, "BNavigator.getInstance()");
            com.baidu.navisdk.ui.routeguide.navicenter.a i = V.i();
            IIX0o.oO(i, "BNavigator.getInstance().modelManager");
            this.F = i.b();
        }
        com.baidu.navisdk.module.newguide.viewmodels.a aVar = this.F;
        if (aVar == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.c()) {
                gVar.c(this.s, "addObserver mEtaViewModel == null:");
                return;
            }
            return;
        }
        if (this.G) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e(this.s, "addObserver isAddObserver: true");
                return;
            }
            return;
        }
        this.G = true;
        IIX0o.ooOOo0oXI(aVar);
        aVar.a().observe(this.i, new b());
        com.baidu.navisdk.module.newguide.viewmodels.a aVar2 = this.F;
        IIX0o.ooOOo0oXI(aVar2);
        aVar2.b().observe(this.i, new c());
    }

    @Override // com.baidu.navisdk.module.newguide.subviews.c
    @oOoXoXO
    public ViewGroup o0() {
        View view = this.u;
        if (view == null) {
            IIX0o.XOxIOxOx("mEtaRootView");
        }
        return (ViewGroup) view;
    }

    @Override // com.baidu.navisdk.module.newguide.subviews.c
    public void p0() {
        ImageView imageView = this.R;
        if (imageView != null) {
            IIX0o.ooOOo0oXI(imageView);
            if (imageView.getVisibility() == 0) {
                ImageView imageView2 = this.R;
                IIX0o.ooOOo0oXI(imageView2);
                imageView2.setVisibility(8);
            }
        }
        ImageView imageView3 = this.A;
        if (imageView3 != null) {
            IIX0o.ooOOo0oXI(imageView3);
            if (imageView3.getVisibility() == 0) {
                ImageView imageView4 = this.A;
                IIX0o.ooOOo0oXI(imageView4);
                imageView4.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.navisdk.module.newguide.subviews.c
    public void q0() {
        int i;
        if (this.R != null) {
            int navPreferMode = BNSettingManager.getNavPreferMode();
            ImageView imageView = this.R;
            IIX0o.ooOOo0oXI(imageView);
            if (navPreferMode == 1) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.subviews.c
    public void v(int i) {
        TextView textView = this.E;
        if (textView != null) {
            IIX0o.ooOOo0oXI(textView);
            textView.setVisibility(i);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.subviews.c
    public void w(int i) {
        View view = this.u;
        if (view == null) {
            IIX0o.XOxIOxOx("mEtaRootView");
        }
        view.setVisibility(i);
        FrameLayout frameLayout = this.T;
        if (frameLayout != null) {
            frameLayout.setVisibility(i);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.subviews.c
    public void y(boolean z) {
        Handler handler;
        View view = this.z;
        if (view != null) {
            IIX0o.ooOOo0oXI(view);
            view.clearAnimation();
            View view2 = this.z;
            IIX0o.ooOOo0oXI(view2);
            view2.setVisibility(8);
        }
        View view3 = this.v;
        if (view3 != null) {
            IIX0o.ooOOo0oXI(view3);
            view3.clearAnimation();
        }
        this.H = null;
        this.I = null;
        this.J = null;
        if (!z || (handler = this.K) == null) {
            return;
        }
        IIX0o.ooOOo0oXI(handler);
        handler.removeMessages(this.t);
    }

    private final void c(ViewGroup viewGroup) {
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(R.id.bn_rg_land_setting_title_stub);
        if (viewStub != null) {
            try {
                com.baidu.navisdk.ui.util.b.a(viewStub);
            } catch (Exception e2) {
                if (com.baidu.navisdk.util.common.g.PRO_NAV.c()) {
                    com.baidu.navisdk.util.common.g.PRO_NAV.c(this.s, "loadLandViewContainer: " + e2);
                }
            }
        }
        View findViewById = viewGroup.findViewById(R.id.bn_rg_land_setting_title);
        this.Q = findViewById;
        if (findViewById != null) {
            IIX0o.ooOOo0oXI(findViewById);
            findViewById.setVisibility(0);
            View view = this.Q;
            IIX0o.ooOOo0oXI(view);
            view.setOnClickListener(this.P);
        }
    }

    private final void d(ViewGroup viewGroup) {
        View findViewById = viewGroup.findViewById(R.id.bnav_rg_bottombar_rookie_mode_tag);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.subviews.c
    public void b(@oOoXoXO View.OnClickListener onClickListener) {
        this.P = onClickListener;
        View view = this.Q;
        if (view != null) {
            IIX0o.ooOOo0oXI(view);
            view.setOnClickListener(this.P);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.subviews.c
    public void a(@oOoXoXO ViewGroup viewGroup) {
        View a2 = com.baidu.navisdk.ui.util.b.a(this.f9165a, R.layout.nsdk_layout_rg_bottombar_new_navi, null, false);
        IIX0o.oO(a2, "BNStyleManager.inflate(m… null,\n            false)");
        this.u = a2;
    }

    @Override // com.baidu.navisdk.module.newguide.subviews.c
    public void b(@OOXIXo ViewGroup settingRootView) {
        FrameLayout frameLayout;
        ImageView imageView;
        IIX0o.x0xO0oo(settingRootView, "settingRootView");
        View view = this.Q;
        if (view != null) {
            IIX0o.ooOOo0oXI(view);
            view.setVisibility(8);
            View view2 = this.Q;
            IIX0o.ooOOo0oXI(view2);
            view2.setOnClickListener(null);
            this.Q = null;
        }
        FrameLayout frameLayout2 = this.T;
        if (frameLayout2 != null) {
            frameLayout2.removeAllViews();
        }
        if (t0()) {
            frameLayout = (FrameLayout) this.b.findViewById(R.id.bn_rg_bottombar_container);
        } else {
            frameLayout = (FrameLayout) this.b.findViewById(R.id.bn_rg_bottombar_container_land);
        }
        this.T = frameLayout;
        if (frameLayout != null) {
            View view3 = this.u;
            if (view3 == null) {
                IIX0o.XOxIOxOx("mEtaRootView");
            }
            frameLayout.addView(view3);
        }
        boolean z = true;
        if (t0()) {
            View view4 = this.u;
            if (view4 == null) {
                IIX0o.XOxIOxOx("mEtaRootView");
            }
            view4.setVisibility(0);
            View view5 = this.u;
            if (view5 == null) {
                IIX0o.XOxIOxOx("mEtaRootView");
            }
            if (view5 != null) {
                e((ViewGroup) view5);
                z = h0().g(true);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
        } else {
            View view6 = this.u;
            if (view6 == null) {
                IIX0o.XOxIOxOx("mEtaRootView");
            }
            view6.setVisibility(0);
            c(settingRootView);
            View view7 = this.u;
            if (view7 == null) {
                IIX0o.XOxIOxOx("mEtaRootView");
            }
            if (view7 != null) {
                e((ViewGroup) view7);
                View view8 = this.u;
                if (view8 == null) {
                    IIX0o.XOxIOxOx("mEtaRootView");
                }
                if (view8 != null) {
                    d((ViewGroup) view8);
                    com.baidu.navisdk.framework.interfaces.pronavi.hd.f o = com.baidu.navisdk.ui.routeguide.utils.b.o();
                    IIX0o.oO(o, "BNProNaviInnerUtil.getMultiMapNaviSwitchParams()");
                    if (com.baidu.navisdk.ui.routeguide.utils.b.c(o.f6817a)) {
                        View view9 = this.u;
                        if (view9 == null) {
                            IIX0o.XOxIOxOx("mEtaRootView");
                        }
                        view9.setVisibility(8);
                    } else {
                        z = false;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
        }
        if (z && (imageView = this.R) != null) {
            IIX0o.ooOOo0oXI(imageView);
            if (imageView.getVisibility() == 0) {
                ImageView imageView2 = this.R;
                IIX0o.ooOOo0oXI(imageView2);
                imageView2.setVisibility(8);
            }
        }
        View view10 = this.u;
        if (view10 == null) {
            IIX0o.XOxIOxOx("mEtaRootView");
        }
        view10.setOnClickListener(new d());
        if (!this.S || t0()) {
            View view11 = this.u;
            if (view11 == null) {
                IIX0o.XOxIOxOx("mEtaRootView");
            }
            a(view11);
            z0();
        }
    }

    private final void a(View view) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(this.s, "initEtaView> isOrientationPortrait=" + t0());
        }
        IIX0o.ooOOo0oXI(view);
        this.v = view.findViewById(R.id.bnav_rg_toolbox_time_and_dist_ly);
        this.w = (TextView) view.findViewById(R.id.bnav_rg_toolbox_remain_time_and_dist);
        try {
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.bnav_rg_bottombar_convoy_stub);
            if (viewStub != null) {
                com.baidu.navisdk.ui.util.b.a(viewStub);
            }
        } catch (Exception e2) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e(this.s, "initEtaView ViewStub mConvoyTV exception: " + e2);
            }
            if (gVar2.b()) {
                gVar2.a("load mConvoyTV exception", e2);
            }
        }
        this.E = (TextView) view.findViewById(R.id.bnav_rg_toolbox_convoy);
        this.y = (TextView) view.findViewById(R.id.bnav_rg_toolbox_arrive_time);
        this.x = (TextView) view.findViewById(R.id.bnav_rg_toolbox_traffic_light_count);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(int i) {
        TextView textView = this.B;
        if (textView != null) {
            IIX0o.ooOOo0oXI(textView);
            textView.setVisibility(i);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.subviews.c, com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        if (!this.S || t0()) {
            return super.y();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(a.c cVar) {
        if (cVar == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.c()) {
                gVar.c(this.s, "updateDestinationEtaInfo: destEtaInfo == null ");
                return;
            }
            return;
        }
        TextView textView = this.w;
        if (textView != null) {
            IIX0o.ooOOo0oXI(textView);
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            String format = String.format("%s %s", Arrays.copyOf(new Object[]{cVar.f7358a, cVar.b}, 2));
            IIX0o.oO(format, "java.lang.String.format(format, *args)");
            textView.setText(format);
        }
        TextView textView2 = this.y;
        if (textView2 != null) {
            IIX0o.ooOOo0oXI(textView2);
            textView2.setText(cVar.c);
        }
        z(cVar.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(a.d dVar) {
        if (dVar != null && dVar.a()) {
            if (this.z == null) {
                View view = this.u;
                if (view == null) {
                    IIX0o.XOxIOxOx("mEtaRootView");
                }
                b(view);
            }
            TextView textView = this.D;
            IIX0o.ooOOo0oXI(textView);
            textView.setText(dVar.d);
            TextView textView2 = this.C;
            IIX0o.ooOOo0oXI(textView2);
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            String format = String.format("%s %s", Arrays.copyOf(new Object[]{dVar.f7359a, dVar.b}, 2));
            IIX0o.oO(format, "java.lang.String.format(format, *args)");
            textView2.setText(format);
            s0();
            Handler handler = this.K;
            IIX0o.ooOOo0oXI(handler);
            if (!handler.hasMessages(this.t)) {
                Handler handler2 = this.K;
                IIX0o.ooOOo0oXI(handler2);
                handler2.sendEmptyMessageDelayed(this.t, 5000L);
            }
            A(dVar.c);
            return;
        }
        y(true);
    }

    private final void b(View view) {
        try {
            IIX0o.ooOOo0oXI(view);
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.bnav_rg_toolbox_via_time_dist_ly_stub);
            if (viewStub != null) {
                com.baidu.navisdk.ui.util.b.a(viewStub);
            }
        } catch (Exception e2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(this.s, "initViaPointView ViewStub exception: " + e2);
            }
            if (gVar.b()) {
                gVar.a("load initViaPointView exception", e2);
            }
        }
        IIX0o.ooOOo0oXI(view);
        View findViewById = view.findViewById(R.id.bnav_rg_toolbox_via_time_and_dist_ly);
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.s + " VIA_ETA", "initViaEtaView->parent=" + findViewById);
        }
        if (findViewById != null) {
            this.z = findViewById;
            this.C = (TextView) findViewById.findViewById(R.id.bnav_rg_toolbox_via_remain_time_and_dist);
            this.D = (TextView) findViewById.findViewById(R.id.bnav_rg_toolbox_via_arrive_title);
            this.A = (ImageView) findViewById.findViewById(R.id.bnav_rg_toolbox_via_rookie_mode_tag);
            this.B = (TextView) findViewById.findViewById(R.id.bnav_rg_toolbox_via_traffic_light_count);
            View view2 = this.z;
            IIX0o.ooOOo0oXI(view2);
            view2.setVisibility(8);
        }
        z0();
        y0();
    }

    @Override // com.baidu.navisdk.module.newguide.subviews.c
    public void a(@oOoXoXO ViewGroup viewGroup, int i, @OOXIXo ViewGroup settingRootView) {
        IIX0o.x0xO0oo(settingRootView, "settingRootView");
        super.a(viewGroup, i);
        w0();
        y(false);
        b(settingRootView);
        this.z = null;
        com.baidu.navisdk.module.newguide.viewmodels.a aVar = this.F;
        if (aVar != null) {
            IIX0o.ooOOo0oXI(aVar);
            aVar.k();
        }
        z0();
    }

    private final boolean a(View view, TextView textView, int i, C0355a c0355a) {
        if ((view == null || view.getVisibility() == 0) && c0355a != null) {
            return c0355a.a(textView != null ? textView.getText().toString() : null, i);
        }
        return true;
    }

    private final int a(TextView textView, String str) {
        return j.a(textView, str) + JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_toolbox_traffic_light_margin_left) + textView.getCompoundPaddingLeft();
    }
}
