package com.baidu.platform.comapi.walknavi.h;

import XIXIX.OOXIXo;
import XXO0.oIX0oI;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.R;
import com.baidu.ar.NavigationType;
import com.baidu.entity.pb.WalkPlan;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
import com.baidu.mapapi.walknavi.model.WalkNaviDisplayOption;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.platform.comapi.walknavi.segmentbrowse.widget.g;
import com.baidu.platform.comapi.walknavi.widget.GuideContainerLinearLayout;
import com.baidu.platform.comapi.walknavi.widget.a;
import com.baidu.platform.comapi.walknavi.widget.a.ao;
import com.baidu.platform.comapi.walknavi.widget.a.z;
import com.baidu.platform.comapi.wnplatform.i.e;
import com.facebook.login.widget.ToolTipPopup;
import com.garmin.fit.xOxOoo;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.eclipse.paho.android.service.MqttServiceConstants;

/* loaded from: classes8.dex */
public class b extends com.baidu.platform.comapi.wnplatform.o.a {
    private GuideContainerLinearLayout A;
    private com.baidu.platform.comapi.walknavi.widget.e C;
    private TextView E;
    private boolean F;
    private float G;
    private double H;
    private View I;
    private ImageView J;
    private com.baidu.platform.comapi.walknavi.widget.a K;
    private Bitmap L;
    private BitmapDescriptor M;
    private Bitmap N;
    private BitmapDescriptor O;
    private long P;
    private long Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private com.baidu.platform.comapi.walknavi.segmentbrowse.widget.a V;
    private Handler W;
    private Handler X;
    private Runnable Y;
    private Runnable Z;
    private Runnable aa;
    private Runnable ab;
    private ao ac;
    private String ad;
    private View ae;
    private AnimationDrawable af;
    private TextView ag;
    private ImageView ah;
    private LinearLayout ai;
    private ImageView aj;
    private Runnable ak;
    private Runnable al;
    private Runnable am;
    private g.a an;
    private int ao;
    private final Runnable ap;
    private com.baidu.platform.comapi.wnplatform.walkmap.c aq;
    public int e;
    LatLng f;
    LatLng g;
    public com.baidu.platform.comapi.walknavi.widget.a.z h;
    public boolean i;
    final Runnable j;
    a.InterfaceC0539a k;
    private Activity l;
    private View m;
    private com.baidu.platform.comapi.walknavi.h.c.c n;
    private com.baidu.platform.comapi.walknavi.widget.b o;
    private com.baidu.platform.comapi.walknavi.widget.b p;
    private FrameLayout u;
    private com.baidu.platform.comapi.walknavi.segmentbrowse.widget.g v;
    private com.baidu.platform.comapi.walknavi.segmentbrowse.widget.h w;
    private GuideContainerLinearLayout z;
    private com.baidu.platform.comapi.walknavi.h.c.a q = null;
    private Handler r = new Handler();
    private boolean s = true;
    private a t = null;
    private int x = 0;
    private boolean y = false;
    private boolean B = false;
    private IWNaviStatusListener D = null;

    /* renamed from: a, reason: collision with root package name */
    public Bitmap f9765a = null;
    public Bitmap b = null;
    public Bitmap c = null;
    public com.baidu.platform.comapi.walknavi.h.a.a d = null;

    /* loaded from: classes8.dex */
    public class a extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        Activity f9766a;
        com.baidu.platform.comapi.walknavi.widget.b b;

        public a(long j, long j2, Activity activity, com.baidu.platform.comapi.walknavi.widget.b bVar) {
            super(j, j2);
            this.f9766a = activity;
            this.b = bVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Activity activity = this.f9766a;
            if (activity != null && !activity.isFinishing()) {
                this.b.dismiss();
            }
            b.this.t();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            com.baidu.platform.comapi.walknavi.widget.b bVar = this.b;
            if (bVar != null) {
                ((Button) bVar.c()).setText("确定(" + (j / 1000) + oIX0oI.I0Io.f4095I0Io);
            }
        }
    }

    /* renamed from: com.baidu.platform.comapi.walknavi.h.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0537b {
        void a(int i);

        void b(int i);
    }

    /* loaded from: classes8.dex */
    public static class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<b> f9769a;

        public c(b bVar) {
            this.f9769a = new WeakReference<>(bVar);
        }

        private void a(b bVar) {
            if (bVar == null) {
                return;
            }
            long j = 0;
            bVar.Q = 0L;
            bVar.S = true;
            if (bVar.R) {
                bVar.R = false;
                bVar.P = System.currentTimeMillis();
            }
            if (bVar.P > 0) {
                j = System.currentTimeMillis() - bVar.P;
            }
            if (j > 500 && com.baidu.platform.comapi.wnplatform.f.a().b() && bVar.n != null) {
                bVar.n.c();
            }
        }

        private void b(b bVar) {
            com.baidu.platform.comapi.walknavi.widget.a.z zVar;
            if (bVar == null) {
                return;
            }
            long j = 0;
            bVar.P = 0L;
            bVar.R = true;
            if (bVar.S) {
                bVar.S = false;
                bVar.Q = System.currentTimeMillis();
            }
            if (bVar.Q > 0) {
                j = System.currentTimeMillis() - bVar.Q;
            }
            if (j > 500 && com.baidu.platform.comapi.wnplatform.f.a().c() && (zVar = bVar.h) != null) {
                zVar.c();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar;
            WeakReference<b> weakReference = this.f9769a;
            if (weakReference == null || (bVar = weakReference.get()) == null) {
                return;
            }
            int i = message.what;
            if (i == 2) {
                com.baidu.platform.comapi.wnplatform.model.datastruct.a aVar = (com.baidu.platform.comapi.wnplatform.model.datastruct.a) message.obj;
                if (com.baidu.platform.comapi.wnplatform.a.a().e() != null) {
                    com.baidu.platform.comapi.wnplatform.a.a().e().updateHeading((float) aVar.d, (int) aVar.g);
                }
                if (bVar.ac != null) {
                    bVar.ac.a((int) aVar.d);
                }
                double abs = Math.abs(aVar.e) - 90.0d;
                if (bVar.e == 2 && bVar.ac != null && bVar.ac.a() && bVar.ac.b() && bVar.ac.d() && !com.baidu.platform.comapi.wnplatform.a.a().d()) {
                    if (Math.abs(Math.abs(aVar.f) - 90.0d) > 30.0d) {
                        if (Math.abs(abs) < 20.0d) {
                            a(bVar);
                            return;
                        } else {
                            if (Math.abs(abs) > 40.0d) {
                                if (!bVar.T) {
                                    bVar.T = true;
                                }
                                b(bVar);
                                return;
                            }
                            return;
                        }
                    }
                    b(bVar);
                    return;
                }
                if (com.baidu.platform.comapi.wnplatform.a.a().d()) {
                    if (Math.abs(abs) < 20.0d) {
                        bVar.U = false;
                        return;
                    } else {
                        if (Math.abs(abs) > 40.0d && !bVar.U) {
                            bVar.U = true;
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (i == 3) {
                bVar.y();
            }
        }
    }

    public b(Activity activity) {
        this.m = null;
        Bitmap decodeResource = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.p.a.a.b(), R.drawable.icon_start_walk);
        this.L = decodeResource;
        this.M = BitmapDescriptorFactory.fromBitmap(decodeResource);
        Bitmap decodeResource2 = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.p.a.a.b(), R.drawable.icon_arrive_walk);
        this.N = decodeResource2;
        this.O = BitmapDescriptorFactory.fromBitmap(decodeResource2);
        this.P = 0L;
        this.Q = 0L;
        this.R = true;
        this.S = true;
        this.T = false;
        this.U = false;
        this.W = new c(this);
        this.X = new Handler(Looper.getMainLooper());
        this.Y = null;
        this.e = 0;
        this.Z = new n(this);
        this.aa = new v(this);
        this.ab = new w(this);
        this.ad = "";
        this.i = false;
        this.j = new i(this);
        this.al = new m(this);
        this.k = new o(this);
        this.am = null;
        this.an = new p(this);
        this.ao = -1;
        this.ap = new s(this);
        this.aq = new t(this);
        this.Q = 0L;
        this.P = 0L;
        this.e = 0;
        this.l = activity;
        this.m = com.baidu.platform.comapi.wnplatform.p.a.a.a(activity, R.layout.wsdk_layout_rg_ui_layoutndof, null);
        g(0);
        P();
        L();
        this.F = true;
    }

    private LatLng F() {
        if (this.g == null) {
            this.g = com.baidu.platform.comapi.walknavi.b.a().U();
        }
        return this.g;
    }

    private LatLng G() {
        if (this.f == null) {
            this.f = com.baidu.platform.comapi.walknavi.b.a().T();
        }
        return this.f;
    }

    private void H() {
        int b = com.baidu.platform.comapi.walknavi.b.a().K().b();
        com.baidu.platform.comapi.wnplatform.d.a.a("tag", "traffic size:" + b);
        if (b != 0) {
            int[] iArr = new int[b];
            int[] iArr2 = new int[b];
            int[] iArr3 = new int[b];
            com.baidu.platform.comapi.walknavi.b.a().K().a(iArr, iArr2, iArr3);
            com.baidu.platform.comapi.wnplatform.h.a.b().a(this.l, iArr, iArr2, iArr3);
        }
    }

    private void I() {
        com.baidu.platform.comapi.walknavi.segmentbrowse.widget.a aVar;
        if (com.baidu.platform.comapi.wnplatform.f.a().b()) {
            com.baidu.platform.comapi.walknavi.segmentbrowse.widget.a aVar2 = this.V;
            if (aVar2 != null) {
                aVar2.setVisibility(0);
                return;
            }
            return;
        }
        if (com.baidu.platform.comapi.wnplatform.f.a().c() && (aVar = this.V) != null) {
            aVar.setVisibility(8);
        }
    }

    private int J() {
        int b = (int) (com.baidu.platform.comapi.wnplatform.p.h.b(this.l) / 2.9d);
        int a2 = com.baidu.platform.comapi.wnplatform.p.h.a(this.l, com.baidu.platform.comapi.wnplatform.p.h.f9956a);
        if (b > a2) {
            return a2;
        }
        return b;
    }

    private int K() {
        int b = (int) (com.baidu.platform.comapi.wnplatform.p.h.b(this.l) / 2.7d);
        int a2 = com.baidu.platform.comapi.wnplatform.p.h.a(this.l, com.baidu.platform.comapi.wnplatform.p.h.b);
        if (b > a2) {
            b = a2;
        }
        return b - a((Context) this.l);
    }

    private void L() {
        int a2 = com.baidu.platform.comapi.walknavi.b.a().K().a();
        com.baidu.platform.comapi.wnplatform.d.a.a("tag", "all size:" + a2);
        if (a2 > 2) {
            int i = a2 - 2;
            int[] iArr = new int[i];
            int[] iArr2 = new int[i];
            int[] iArr3 = new int[i];
            com.baidu.platform.comapi.walknavi.b.a().K().b(iArr, iArr2, iArr3);
            com.baidu.platform.comapi.wnplatform.h.c.b().a(this.l, iArr, iArr2, iArr3);
        }
    }

    private void M() {
        Bitmap bitmap = this.f9765a;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f9765a.recycle();
            this.f9765a = null;
        }
        Bitmap bitmap2 = this.b;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.b.recycle();
            this.b = null;
        }
        Bitmap bitmap3 = this.c;
        if (bitmap3 != null && !bitmap3.isRecycled()) {
            this.c.recycle();
            this.c = null;
        }
    }

    private void N() {
        Bitmap bitmap = this.L;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.L.recycle();
            this.L = null;
        }
        Bitmap bitmap2 = this.N;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.N.recycle();
            this.N = null;
        }
        BitmapDescriptor bitmapDescriptor = this.M;
        if (bitmapDescriptor != null) {
            bitmapDescriptor.recycle();
            this.M = null;
        }
        BitmapDescriptor bitmapDescriptor2 = this.O;
        if (bitmapDescriptor2 != null) {
            bitmapDescriptor2.recycle();
            this.O = null;
        }
    }

    private void O() {
        View view = this.m;
        if (view != null) {
            View findViewById = view.findViewById(R.id.sensor_adjust_layout);
            this.ae = findViewById;
            findViewById.setVisibility(8);
            this.ae.setOnClickListener(new y(this));
            ImageView imageView = (ImageView) this.m.findViewById(R.id.sensor_adjust_iv_close);
            if (imageView != null) {
                imageView.setOnClickListener(new z(this));
            }
            ImageView imageView2 = (ImageView) this.m.findViewById(R.id.sensor_adjust_iv);
            if (imageView2 != null) {
                this.af = (AnimationDrawable) imageView2.getBackground();
            }
        }
    }

    private void P() {
        O();
        if (com.baidu.platform.comapi.walknavi.b.a().N().l()) {
            com.baidu.platform.comapi.walknavi.b.a().N().a().getMap().addOverlay(new MarkerOptions().position(G()).icon(this.M).zIndex(9).draggable(false));
            com.baidu.platform.comapi.walknavi.b.a().N().a().getMap().addOverlay(new MarkerOptions().position(F()).icon(this.O).zIndex(9).draggable(false));
        }
        this.n = new com.baidu.platform.comapi.walknavi.h.c.c(this.l, this, this.m);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.l.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.f9832a = displayMetrics.widthPixels;
        com.baidu.platform.comapi.wnplatform.d.a.a("walk engine", "screen width" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.f9832a);
        com.baidu.platform.comapi.walknavi.h.a.a aVar = new com.baidu.platform.comapi.walknavi.h.a.a((ViewGroup) this.m, this.l);
        this.d = aVar;
        aVar.a();
        this.i = false;
        boolean z = com.baidu.platform.comapi.wnplatform.l.a.f9933a;
        this.h = new com.baidu.platform.comapi.walknavi.widget.a.z(this.l, (ViewGroup) this.m, this);
        this.l.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.f9832a = displayMetrics.widthPixels;
        com.baidu.platform.comapi.wnplatform.d.a.a("walk engine", "screen width" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.f9832a);
        this.J = (ImageView) this.m.findViewById(R.id.gps_status);
        this.I = this.m.findViewById(R.id.wnavi_page_youdao_container);
        FrameLayout frameLayout = (FrameLayout) this.m.findViewById(R.id.framelayout);
        this.u = frameLayout;
        frameLayout.setMinimumHeight(J());
        this.z = (GuideContainerLinearLayout) this.m.findViewById(R.id.normal_guide_view);
        this.A = (GuideContainerLinearLayout) this.m.findViewById(R.id.segment_guide_view);
        this.n.i().setVisibility(4);
        Bundle ac = com.baidu.platform.comapi.walknavi.b.a().ac();
        if (ac != null) {
            if (ac.containsKey(xOxOoo.f15470o00) || ac.containsKey("time")) {
                this.n.i().setVisibility(0);
            }
            com.baidu.platform.comapi.wnplatform.p.s.a().a(ac.getInt("time"), ac.getInt(xOxOoo.f15470o00));
            StringBuilder sb = new StringBuilder();
            sb.append("全程剩余：");
            if (com.baidu.platform.comapi.wnplatform.p.s.a().c() != null) {
                sb.append(com.baidu.platform.comapi.wnplatform.p.s.a().c() + " ");
            }
            if (com.baidu.platform.comapi.wnplatform.p.s.a().b() != null) {
                sb.append(com.baidu.platform.comapi.wnplatform.p.s.a().b() + " ");
            }
            this.n.i().setText(sb.toString());
            this.h.a().setText(sb.toString());
            this.h.b().setText(sb.toString());
        }
        com.baidu.platform.comapi.walknavi.segmentbrowse.widget.e.a(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(this.l));
        a("---- UI LOG ");
        this.ai = (LinearLayout) this.m.findViewById(R.id.top_hint_layout);
        this.ag = (TextView) this.m.findViewById(R.id.top_hint_tv);
        this.ah = (ImageView) this.m.findViewById(R.id.top_hint_iv);
        ImageView imageView = (ImageView) this.m.findViewById(R.id.mid_dlg);
        this.aj = imageView;
        imageView.setBackgroundResource(R.drawable.wsdk_phone_down_anim);
        this.T = false;
        this.U = false;
    }

    private void Q() {
        if (this.s) {
            return;
        }
        WalkNaviDisplayOption o = com.baidu.platform.comapi.walknavi.b.a().o();
        if (o != null && !o.getShowDialogEnable()) {
            return;
        }
        if (!com.baidu.platform.comapi.walknavi.b.a().X().c()) {
            R();
        } else {
            S();
        }
    }

    private void R() {
        if (this.l == null) {
            return;
        }
        try {
            if (this.p == null) {
                com.baidu.platform.comapi.walknavi.widget.b b = new com.baidu.platform.comapi.walknavi.widget.b(this.l).b(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.l, R.string.wsdk_string_rg_nav_title_tip)).a(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.l, R.string.wsdk_string_rg_gps_not_open_and_set)).c(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.l, R.string.wsdk_string_rg_alert_setting)).a().a(new k(this)).d(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.l, R.string.wsdk_string_rg_nav_dialog_cancel)).b(new j(this));
                this.p = b;
                b.setOnCancelListener(new l(this));
            }
            Activity activity = this.l;
            if (activity != null && !activity.isFinishing()) {
                this.p.show();
            }
        } catch (Exception unused) {
        }
    }

    private void S() {
        Activity activity;
        try {
            if (this.p != null && (activity = this.l) != null && !activity.isFinishing()) {
                if (this.p.isShowing()) {
                    this.p.dismiss();
                }
                this.p = null;
            }
        } catch (Exception unused) {
        }
    }

    private void T() {
        if (this.u == null) {
            return;
        }
        com.baidu.platform.comapi.walknavi.widget.a aVar = this.K;
        if (aVar != null && aVar.a()) {
            this.x = com.baidu.platform.comapi.walknavi.segmentbrowse.c.q();
            com.baidu.platform.comapi.wnplatform.d.a.a("xxxx", "1 setwidth:" + this.x);
            if (this.K != null) {
                WalkPlan m = m();
                String v = com.baidu.platform.comapi.walknavi.b.a().K().v();
                if (m != null && !TextUtils.isEmpty(v)) {
                    StringBuilder sb = new StringBuilder();
                    if (!TextUtils.isEmpty(v) && !TextUtils.equals(v, "null")) {
                        sb.append("当前所在:" + v + "   ");
                    }
                    String a2 = com.baidu.platform.comapi.wnplatform.p.g.a(m);
                    if (!TextUtils.isEmpty(a2)) {
                        sb.append("目的地:" + a2);
                    }
                    this.K.a(sb.toString());
                    return;
                }
                this.K.a("");
                return;
            }
            return;
        }
        this.u.removeAllViews();
        com.baidu.platform.comapi.walknavi.widget.a aVar2 = new com.baidu.platform.comapi.walknavi.widget.a(this.l, 1);
        this.K = aVar2;
        a.InterfaceC0539a interfaceC0539a = this.k;
        if (interfaceC0539a != null) {
            aVar2.a(interfaceC0539a);
        }
        GuideContainerLinearLayout guideContainerLinearLayout = this.z;
        if (guideContainerLinearLayout != null) {
            guideContainerLinearLayout.removeAllViews();
            this.z.addView(this.K);
        }
        GuideContainerLinearLayout guideContainerLinearLayout2 = this.z;
        if (guideContainerLinearLayout2 != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) guideContainerLinearLayout2.getLayoutParams();
            layoutParams.setMargins(20, 0, 20, 0);
            this.z.setLayoutParams(layoutParams);
            this.u.addView(this.z);
        }
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
    }

    private void U() {
        Runnable runnable;
        Handler handler = this.r;
        if (handler != null && (runnable = this.ap) != null) {
            handler.removeCallbacks(runnable);
            this.r.postDelayed(this.ap, 3000L);
        }
    }

    private void V() {
        com.baidu.platform.comapi.walknavi.b.a().J().a(this);
        com.baidu.platform.comapi.walknavi.b.a().L().a((com.baidu.platform.comapi.wnplatform.i.a) this);
        com.baidu.platform.comapi.walknavi.b.a().L().a((com.baidu.platform.comapi.wnplatform.i.b) this);
        com.baidu.platform.comapi.walknavi.b.a().X().a(this);
    }

    private void W() {
        com.baidu.platform.comapi.walknavi.b.a().J().b(this);
        com.baidu.platform.comapi.walknavi.b.a().L().b((com.baidu.platform.comapi.wnplatform.i.a) this);
        com.baidu.platform.comapi.walknavi.b.a().L().b((com.baidu.platform.comapi.wnplatform.i.b) this);
        com.baidu.platform.comapi.walknavi.b.a().X().b(this);
    }

    private void X() {
        com.baidu.platform.comapi.walknavi.h.c.c cVar = this.n;
        if (cVar != null) {
            cVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.r();
        Activity activity = this.l;
        if (activity != null) {
            com.baidu.platform.comapi.walknavi.h.d.a.a(activity, com.baidu.platform.comapi.wnplatform.p.a.a.b(activity, R.string.wsdk_string_rg_open_gps));
        }
        C();
    }

    public void A() {
        View view = this.ae;
        if (view != null) {
            view.setVisibility(8);
        }
        AnimationDrawable animationDrawable = this.af;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public void B() {
        LinearLayout linearLayout = this.ai;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public void C() {
        com.baidu.platform.comapi.walknavi.h.c.a aVar = this.q;
        if (aVar != null) {
            aVar.E();
            this.q = null;
        }
    }

    public void D() {
        com.baidu.platform.comapi.wnplatform.m.a.a().a("FootNaviAutoComplete");
        com.baidu.platform.comapi.walknavi.h.c.c cVar = this.n;
        if (cVar != null) {
            cVar.f();
        }
    }

    public void E() {
        Runnable runnable;
        Handler handler = this.r;
        if (handler != null && (runnable = this.am) != null) {
            handler.removeCallbacks(runnable);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.g
    public void a(int i) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void d(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void f(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public int l() {
        return 12;
    }

    public com.baidu.platform.comapi.walknavi.h.c.c o() {
        return this.n;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public int p() {
        WalkNaviDisplayOption o = com.baidu.platform.comapi.walknavi.b.a().o();
        if (o != null && o.getCustomBottomView() != null) {
            return o.getBottomViewHeight();
        }
        return 0;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public int q() {
        com.baidu.platform.comapi.walknavi.h.c.c cVar;
        if (this.u != null && (cVar = this.n) != null && cVar.k() != null) {
            return this.u.getHeight() + this.n.k().getHeight();
        }
        return 50;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void r() {
        Runnable runnable;
        Handler handler = this.r;
        if (handler != null && (runnable = this.al) != null) {
            handler.removeCallbacks(runnable);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a, com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        V();
        a(this.l);
        return true;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a, com.baidu.platform.comapi.walknavi.a
    public void release() {
        W();
        Handler handler = this.r;
        if (handler != null) {
            handler.removeCallbacks(this.j);
            this.r = null;
        }
        com.baidu.platform.comapi.walknavi.h.c.c cVar = this.n;
        if (cVar != null) {
            cVar.j();
        }
        M();
        N();
        this.E = null;
    }

    public void s() {
        if (com.baidu.platform.comapi.wnplatform.f.a().b()) {
            com.baidu.platform.comapi.walknavi.b.a().N().a().showScaleControl(true);
            com.baidu.platform.comapi.walknavi.b.a().N().a().showZoomControls(false);
            com.baidu.platform.comapi.walknavi.b.a().N().a().getMap().getUiSettings().setAllGesturesEnabled(true);
            a(this.l, com.baidu.platform.comapi.walknavi.b.a().N().a(), 60, 0, 0, 75);
            return;
        }
        if (com.baidu.platform.comapi.wnplatform.f.a().c()) {
            com.baidu.platform.comapi.walknavi.b.a().N().a().showScaleControl(false);
            com.baidu.platform.comapi.walknavi.b.a().N().a().showZoomControls(false);
            com.baidu.platform.comapi.walknavi.b.a().N().a().getMap().getUiSettings().setAllGesturesEnabled(false);
            a(this.l, com.baidu.platform.comapi.walknavi.b.a().N().a(), 0, 0, 0, 0);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void t() {
        WalkNaviDisplayOption o;
        Activity activity;
        Runnable runnable;
        com.baidu.platform.comapi.walknavi.h.c.c cVar = this.n;
        if (cVar != null) {
            cVar.m();
        }
        Handler handler = this.W;
        if (handler != null && (runnable = this.Z) != null) {
            handler.removeCallbacks(runnable);
        }
        com.baidu.platform.comapi.walknavi.widget.b bVar = this.o;
        if (bVar != null && bVar.isShowing() && (activity = this.l) != null && !activity.isFinishing()) {
            this.o.dismiss();
        }
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.r();
        C();
        View view = this.m;
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
            this.m = null;
        }
        Activity activity2 = this.l;
        if (activity2 != null && !activity2.isFinishing() && ((o = com.baidu.platform.comapi.walknavi.b.a().o()) == null || !o.isIsRunInFragment())) {
            this.l.finish();
        }
        com.baidu.platform.comapi.walknavi.b.a().p();
        this.l = null;
        com.baidu.platform.comapi.wnplatform.a.a().h();
        com.baidu.platform.comapi.wnplatform.a.a().i();
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public float u() {
        return this.G;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void v() {
        this.d.c();
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void w() {
        if (com.baidu.platform.comapi.walknavi.b.a().ad()) {
            com.baidu.platform.comapi.walknavi.h.c.a aVar = this.q;
            if (aVar != null) {
                aVar.F();
                return;
            }
            return;
        }
        a(false, R.string.wsdk_string_rg_nav_gps_exit);
    }

    public ao x() {
        return this.ac;
    }

    public void y() {
        View view = this.ae;
        if (view != null) {
            view.setVisibility(0);
        }
        AnimationDrawable animationDrawable = this.af;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public Handler z() {
        return this.W;
    }

    private void g(int i) {
        this.r.postDelayed(new u(this, i), 200L);
    }

    public static WalkPlan m() {
        return com.baidu.platform.comapi.walknavi.b.a().Z().a().b();
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void a(String str) {
    }

    public void e(int i) {
        Handler handler;
        if (i != 1 || (handler = this.r) == null) {
            if (i == 0) {
                this.e = i;
                return;
            }
            return;
        }
        this.e = i;
        Runnable runnable = this.Y;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        com.baidu.platform.comapi.walknavi.h.c cVar = new com.baidu.platform.comapi.walknavi.h.c(this);
        this.Y = cVar;
        this.r.postDelayed(cVar, 4000L);
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public int h() {
        return (int) (com.baidu.platform.comapi.wnplatform.p.b.b.a().d() * 155.0f);
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public int i() {
        return (int) (com.baidu.platform.comapi.wnplatform.p.b.b.a().d() * 30.0f);
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public View j() {
        return this.m;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void k() {
        X();
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void n() {
        Runnable runnable;
        com.baidu.platform.comapi.walknavi.h.c.c cVar = this.n;
        if (cVar != null) {
            cVar.f();
        }
        Handler handler = this.r;
        if (handler == null || (runnable = this.j) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
        this.r.postDelayed(this.j, 20000L);
    }

    private void c(int i, boolean z) {
        if (this.u != null) {
            if (com.baidu.platform.comapi.wnplatform.f.a().c()) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, K());
                int i2 = R.id.walk_navi_youdao_inner_empty_top;
                layoutParams.addRule(3, i2);
                this.u.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, K() + a((Context) this.l));
                layoutParams2.addRule(3, i2);
                this.I.setLayoutParams(layoutParams2);
                this.u.setBackgroundResource(R.drawable.wsdk_newar_guide_bg);
            } else {
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, J());
                int i3 = R.id.walk_navi_youdao_inner_empty_top;
                layoutParams3.addRule(3, i3);
                this.u.setLayoutParams(layoutParams3);
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, J() + a((Context) this.l));
                layoutParams4.addRule(3, i3);
                this.I.setLayoutParams(layoutParams4);
                this.I.setBackgroundColor(0);
                this.u.setPadding(0, 0, 0, 0);
                this.u.setBackgroundResource(R.drawable.wsdk_guide_bar_bg);
            }
        }
        if (this.z != null) {
            if (com.baidu.platform.comapi.wnplatform.f.a().c()) {
                this.z.setVisibility(8);
            } else {
                this.z.setVisibility(0);
            }
        }
        GuideContainerLinearLayout guideContainerLinearLayout = this.A;
        if (guideContainerLinearLayout != null) {
            guideContainerLinearLayout.setVisibility(8);
        }
        this.d.b();
        com.baidu.platform.comapi.walknavi.b.a().H();
        com.baidu.platform.comapi.walknavi.h.c.c cVar = this.n;
        if (cVar != null) {
            cVar.a(i, z);
            if (com.baidu.platform.comapi.wnplatform.f.a().c()) {
                this.n.d();
            }
        }
        com.baidu.platform.comapi.walknavi.widget.a.z zVar = this.h;
        if (zVar != null) {
            zVar.b(i);
        }
        I();
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a(byte[] bArr) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void f() {
        this.s = false;
        if (com.baidu.platform.comapi.walknavi.b.a().Q() != 4) {
            Q();
        }
        com.baidu.platform.comapi.walknavi.h.c.c cVar = this.n;
        if (cVar != null) {
            cVar.h();
            this.n.e();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void g() {
        this.s = true;
    }

    public void b(boolean z) {
        ImageView imageView = this.aj;
        if (imageView == null) {
            return;
        }
        if (z) {
            AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
            animationDrawable.start();
            this.r.postDelayed(new g(this, animationDrawable), 1800L);
            this.aj.setVisibility(0);
            return;
        }
        ((AnimationDrawable) imageView.getBackground()).stop();
        this.aj.setVisibility(8);
    }

    public com.baidu.platform.comapi.walknavi.widget.a.z d() {
        return this.h;
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void g(Message message) {
        if (com.baidu.platform.comapi.walknavi.b.a().K().t()) {
            D();
            if (com.baidu.platform.comapi.walknavi.b.a().o() == null || com.baidu.platform.comapi.walknavi.b.a().o().isShowDialogWithExitNavi()) {
                U();
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void d(Message message) {
        com.baidu.platform.comapi.wnplatform.m.a.a().a("FootNaviPG.reRoute");
        if (!this.s) {
            com.baidu.platform.comapi.walknavi.b.a().M().run(RGFSMTable.FsmEvent.MSG_YAWING_REROUTED);
        }
        H();
        com.baidu.platform.comapi.walknavi.h.c.c cVar = this.n;
        if (cVar != null) {
            cVar.a(4);
        }
        com.baidu.platform.comapi.walknavi.widget.a aVar = this.K;
        if (aVar != null) {
            aVar.a("偏航规划成功");
        }
    }

    public RelativeLayout a(z.a aVar) {
        return this.h.a(aVar);
    }

    public void a(int i, boolean z) {
        s();
        if (com.baidu.platform.comapi.wnplatform.f.a().c()) {
            if (z) {
                e(1);
            }
            if (this.ac == null && com.baidu.platform.comapi.wnplatform.a.a().g() != NavigationType.ARCore && com.baidu.platform.comapi.wnplatform.a.a().g() != NavigationType.AREngine && com.baidu.platform.comapi.wnplatform.a.a().g() == NavigationType.ARIMU) {
                this.ac = new com.baidu.platform.comapi.walknavi.widget.a.a(this.l, (ViewGroup) this.m, this);
            }
            ao aoVar = this.ac;
            if (aoVar != null) {
                aoVar.c(z);
                this.ac.f();
            }
            this.u.setVisibility(4);
            this.J.setVisibility(4);
            com.baidu.platform.comapi.walknavi.b.a().O().b("WALKNAVI_FIRST_AR", false);
            if (!com.baidu.platform.comapi.walknavi.b.a().O().a("WALKNAVI_AR_HINT_HAS_SHOW", false)) {
                this.W.postDelayed(this.ab, 10000L);
            }
            c(i, z);
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
            com.baidu.platform.comapi.walknavi.b.a().K().j();
            this.W.postDelayed(new x(this), 500L);
            return;
        }
        if (com.baidu.platform.comapi.wnplatform.f.a().b()) {
            com.baidu.platform.comapi.walknavi.b.a().N().a().onResume();
            ao aoVar2 = this.ac;
            if (aoVar2 != null) {
                aoVar2.f();
            }
            if (z) {
                e(0);
            }
            com.baidu.platform.comapi.wnplatform.a.a().h();
            this.u.setVisibility(0);
            this.W.removeCallbacks(this.ab);
            this.W.removeCallbacks(this.aa);
            c(i, z);
            com.baidu.platform.comapi.wnplatform.p.e.a(true);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public boolean e() {
        return this.m == null || this.l == null;
    }

    public void f(int i) {
        Runnable runnable = this.am;
        if (runnable != null) {
            runnable.run();
        }
        q qVar = new q(this);
        this.am = qVar;
        this.r.postDelayed(qVar, i);
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void e(Bundle bundle) {
        com.baidu.platform.comapi.wnplatform.d.a.b("onCompassInfoUpdate" + bundle.toString());
        if (com.baidu.platform.comapi.walknavi.b.a().Q() == 4 && bundle.containsKey("uid")) {
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.b(bundle.getInt("uid"));
            com.baidu.platform.comapi.walknavi.segmentbrowse.a aVar = new com.baidu.platform.comapi.walknavi.segmentbrowse.a();
            aVar.f(bundle.getInt("uid"));
            aVar.c(com.baidu.platform.comapi.walknavi.segmentbrowse.widget.e.a(bundle, "compass"));
            aVar.a(com.baidu.platform.comapi.walknavi.segmentbrowse.widget.e.a(bundle, false));
            aVar.b(com.baidu.platform.comapi.walknavi.segmentbrowse.widget.e.a(bundle));
            if (bundle.containsKey("usGuideText")) {
                aVar.b(bundle.getString("usGuideText"));
            }
            if (bundle.containsKey("maneuverKind")) {
                aVar.a(com.baidu.platform.comapi.wnplatform.i.c.a(RouteGuideKind.values()[bundle.getInt("maneuverKind")]));
            }
            if (bundle.containsKey("nParagraphLength")) {
                aVar.e(bundle.getInt("nParagraphLength"));
            }
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(aVar);
            this.u.removeAllViews();
            new Handler().postDelayed(new r(this), 500L);
            com.baidu.platform.comapi.walknavi.b.a().K().a(true);
            com.baidu.platform.comapi.walknavi.segmentbrowse.widget.g gVar = new com.baidu.platform.comapi.walknavi.segmentbrowse.widget.g(this.l, this);
            this.v = gVar;
            this.u.addView(gVar);
        }
    }

    public void b(int i, boolean z) {
        if (i == 0) {
            this.ag.setText("GPS信号弱");
            this.ah.setBackgroundResource(R.drawable.wsdk_warning_hint);
        } else if (i == 1) {
            this.ag.setText("重新规划路线");
            this.ah.setBackgroundResource(R.drawable.wsdk_ok_hint);
        } else if (i != 2) {
            if (i == 3) {
                this.ag.setText("通过路口后再看手机");
                this.ah.setBackgroundResource(R.drawable.wsdk_warning_hint);
            } else if (i == 4) {
                this.ag.setText("即将通过人行天桥");
                this.ah.setBackgroundResource(R.drawable.wsdk_warning_hint);
            } else if (i == 5) {
                this.ag.setText("即将通过地下通道");
                this.ah.setBackgroundResource(R.drawable.wsdk_warning_hint);
            }
        }
        this.ai.setVisibility(0);
        Runnable runnable = this.ak;
        if (runnable != null) {
            this.r.removeCallbacks(runnable);
        }
        if (z) {
            h hVar = new h(this);
            this.ak = hVar;
            this.r.postDelayed(hVar, 3000L);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.a
    public void d(int i) {
        Q();
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void f(Message message) {
        if (com.baidu.platform.comapi.walknavi.b.a().K().t()) {
            com.baidu.platform.comapi.walknavi.b.a().a(false);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void b(int i) {
        Runnable runnable;
        Handler handler = this.r;
        if (handler == null || (runnable = this.al) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
        this.r.postDelayed(this.al, i);
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void b(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (bundle.containsKey("floor") && !TextUtils.isEmpty(bundle.getString("floor"))) {
            bundle.getString("floor");
            if (!TextUtils.isEmpty(bundle.getString("building"))) {
                bundle.getString("building");
            } else {
                com.baidu.platform.comapi.walknavi.b.a().K().u();
            }
        }
        int i = bundle.getInt("simpleUpdateType");
        if (i == e.a.f9918a || i == e.a.d) {
            return;
        }
        com.baidu.platform.comapi.walknavi.h.b.a.a(bundle, 1, bundle.getInt("nRemainDist"), bundle.getInt("nStartDist"));
        if (bundle.containsKey("uid")) {
            int i2 = bundle.getInt("uid");
            if (bundle.containsKey("usGuideText") && bundle.getString("usGuideText").equals("到达目的地")) {
                bundle.putInt("uid", com.baidu.platform.comapi.walknavi.segmentbrowse.c.g());
                i2 = com.baidu.platform.comapi.walknavi.segmentbrowse.c.g();
            }
            if (i2 == com.baidu.platform.comapi.walknavi.segmentbrowse.c.b() || com.baidu.platform.comapi.walknavi.segmentbrowse.c.b() == -1 || com.baidu.platform.comapi.walknavi.segmentbrowse.c.s() == com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE) {
                com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(a(i2, bundle));
                if (com.baidu.platform.comapi.walknavi.segmentbrowse.c.j() != -1.0d) {
                    this.x = (int) (com.baidu.platform.comapi.walknavi.segmentbrowse.c.j() * com.baidu.platform.comapi.walknavi.segmentbrowse.c.f9832a);
                }
            }
        }
        T();
        ImageView imageView = this.J;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.wsdk_gps_ok);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void e(Message message) {
        if (com.baidu.platform.comapi.walknavi.b.a().K().t()) {
            com.baidu.platform.comapi.walknavi.b.a().a(true, false);
            return;
        }
        D();
        if (com.baidu.platform.comapi.walknavi.b.a().o() == null || com.baidu.platform.comapi.walknavi.b.a().o().isShowDialogWithExitNavi()) {
            U();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void c(int i) {
        com.baidu.platform.comapi.walknavi.h.c.c cVar = this.n;
        if (cVar != null) {
            cVar.b(i);
        }
    }

    public static int a(Context context) {
        Resources resources;
        int identifier;
        if (context != null && (identifier = (resources = context.getResources()).getIdentifier("status_bar_height", "dimen", "android")) > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void c(Bundle bundle) {
        if (bundle.getInt("updatetype") == e.a.c) {
            a(bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalDist), bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalTime));
        }
    }

    private void a(Activity activity) {
        BaiduMap map;
        com.baidu.platform.comapi.wnplatform.walkmap.d N = com.baidu.platform.comapi.walknavi.b.a().N();
        if (N == null || N.a() == null || (map = N.a().getMap()) == null) {
            return;
        }
        map.setOnBaseIndoorMapListener(new d(this));
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void c(Message message) {
        com.baidu.platform.comapi.walknavi.h.c.c cVar = this.n;
        if (cVar != null) {
            cVar.a(3);
        }
        com.baidu.platform.comapi.walknavi.widget.e eVar = this.C;
        if (eVar != null) {
            eVar.a(R.drawable.wn_reroute, "偏航规划中...");
        }
        com.baidu.platform.comapi.walknavi.b.a().J().c();
    }

    public void a(boolean z, int i) {
        String b;
        Activity activity;
        System.out.println("WalkUIController showQuitDialog");
        try {
            Activity activity2 = this.l;
            if (activity2 != null && !activity2.isFinishing()) {
                WalkNaviDisplayOption o = com.baidu.platform.comapi.walknavi.b.a().o();
                if (o != null && !o.getShowDialogEnable()) {
                    t();
                    return;
                }
                com.baidu.platform.comapi.walknavi.widget.b b2 = new com.baidu.platform.comapi.walknavi.widget.b(this.l).a(true).b(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.l, R.string.wsdk_string_rg_nav_title_tip));
                if (com.baidu.platform.comapi.walknavi.h.b.b.f9767a == 2) {
                    b = com.baidu.platform.comapi.wnplatform.p.a.a.b(this.l, R.string.wsdk_string_rg_nav_gps_demo_exit);
                } else {
                    b = com.baidu.platform.comapi.wnplatform.p.a.a.b(this.l, i);
                }
                this.o = b2.a(b).d(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.l, R.string.wsdk_string_rg_exit_check)).b().b(new f(this)).c(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.l, R.string.wsdk_string_rg_nav_dialog_cancel)).a(new e(this));
                if (z) {
                    a aVar = new a(ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME, 1000L, this.l, this.o);
                    this.t = aVar;
                    aVar.start();
                }
                if (this.o.isShowing() || (activity = this.l) == null || activity.isFinishing()) {
                    return;
                }
                this.o.show();
                return;
            }
            com.baidu.platform.comapi.wnplatform.m.a.a().a("FootNaviPG.exitNavi");
            C();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.g
    public void c() {
        g(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        GuideContainerLinearLayout guideContainerLinearLayout;
        Runnable runnable;
        try {
            Handler handler = this.W;
            if (handler != null && (runnable = this.Z) != null) {
                handler.removeCallbacks(runnable);
            }
            GuideContainerLinearLayout guideContainerLinearLayout2 = this.A;
            if (guideContainerLinearLayout2 != null) {
                guideContainerLinearLayout2.setVisibility(0);
            }
            com.baidu.platform.comapi.wnplatform.m.a.a().a("FootNaviPG.segment");
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE);
            com.baidu.platform.comapi.walknavi.b.a().M().run("强诱导转到分段");
            com.baidu.platform.comapi.walknavi.b.a().K().k();
            this.u.removeAllViews();
            com.baidu.platform.comapi.walknavi.segmentbrowse.widget.h hVar = this.w;
            if (hVar != null) {
                hVar.a();
            }
            com.baidu.platform.comapi.walknavi.h.c.c cVar = this.n;
            if (cVar != null) {
                cVar.a(false);
            }
            int b = com.baidu.platform.comapi.walknavi.segmentbrowse.c.b();
            if (str.equals("next")) {
                com.baidu.platform.comapi.wnplatform.d.a.a("chang view", "next");
                com.baidu.platform.comapi.walknavi.segmentbrowse.c.b(b + 1);
            } else if (str.equals("last")) {
                com.baidu.platform.comapi.wnplatform.d.a.a("chang view", "last");
                com.baidu.platform.comapi.walknavi.segmentbrowse.c.b(b - 1);
            }
            GuideContainerLinearLayout guideContainerLinearLayout3 = this.A;
            if (guideContainerLinearLayout3 != null) {
                this.u.addView(guideContainerLinearLayout3);
            }
            com.baidu.platform.comapi.walknavi.segmentbrowse.widget.g gVar = new com.baidu.platform.comapi.walknavi.segmentbrowse.widget.g(this.l, this);
            this.v = gVar;
            gVar.a(this.an);
            if (this.v == null || (guideContainerLinearLayout = this.A) == null) {
                return;
            }
            guideContainerLinearLayout.removeAllViews();
            this.A.addView(this.v);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void a(com.baidu.platform.comapi.walknavi.h.c.a aVar) {
        this.q = aVar;
    }

    public void a(IWNaviStatusListener iWNaviStatusListener) {
        this.D = iWNaviStatusListener;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void a(boolean z) {
        com.baidu.platform.comapi.walknavi.h.c.c cVar = this.n;
        if (cVar != null) {
            cVar.a(z);
        }
    }

    private com.baidu.platform.comapi.walknavi.segmentbrowse.a a(int i, Bundle bundle) {
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.b(i);
        com.baidu.platform.comapi.walknavi.segmentbrowse.a aVar = new com.baidu.platform.comapi.walknavi.segmentbrowse.a();
        aVar.f(bundle.getInt("uid"));
        aVar.c(com.baidu.platform.comapi.walknavi.segmentbrowse.widget.e.a(bundle, "walk"));
        if (bundle.containsKey("enGuideType")) {
            aVar.c(((Integer) bundle.get("enGuideType")).intValue());
        }
        if (bundle.containsKey("nDistance2GP")) {
            aVar.d(((Integer) bundle.get("nDistance2GP")).intValue());
            StringBuilder sb = new StringBuilder();
            sb.append(aVar.d());
            sb.append("\n");
        }
        if (bundle.containsKey("usGuideText")) {
            aVar.b(bundle.getString("usGuideText"));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(bundle.getString("usGuideText"));
            sb2.append("\n");
        }
        if (bundle.containsKey("enSpliceType")) {
            aVar.a(((Integer) bundle.get("enSpliceType")).intValue());
        }
        if (bundle.containsKey("maneuverKind")) {
            int intValue = ((Integer) bundle.get("maneuverKind")).intValue();
            String a2 = com.baidu.platform.comapi.wnplatform.i.c.a(RouteGuideKind.values()[intValue]);
            aVar.b(intValue);
            aVar.a(a2);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(intValue);
            sb3.append("\n");
        }
        if (i == com.baidu.platform.comapi.walknavi.segmentbrowse.c.g()) {
            aVar.e(20);
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(20);
        } else if (bundle.containsKey("nParagraphLength")) {
            aVar.e(bundle.getInt("nParagraphLength"));
            if (bundle.containsKey("nRemainDist")) {
                if (bundle.getInt("nRemainDist") == bundle.getInt("nParagraphLength")) {
                    com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(bundle.getInt("nRemainDist") - 1);
                } else {
                    com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(bundle.getInt("nRemainDist"));
                }
            }
        }
        if (com.baidu.platform.comapi.wnplatform.f.a().c() && aVar.c() == 0) {
            com.baidu.platform.comapi.wnplatform.a.a().a(aVar.d());
        }
        return aVar;
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void b(Message message) {
        com.baidu.platform.comapi.wnplatform.m.a.a().a("FootNaviPG.farAway");
        this.u.removeAllViews();
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.r();
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
        com.baidu.platform.comapi.walknavi.widget.e eVar = this.C;
        if (eVar != null) {
            eVar.a(R.drawable.wn_faraway_route_blue, "您已偏离路线");
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.g
    public void b() {
        com.baidu.platform.comapi.walknavi.b.a().N().a(1);
        if (com.baidu.platform.comapi.walknavi.b.a().Q() == 4) {
            com.baidu.platform.comapi.walknavi.b.a().M().setInitialState("Entry");
        }
        X();
        com.baidu.platform.comapi.walknavi.b.a().K().r();
        com.baidu.platform.comapi.walknavi.b.a().K().h();
    }

    public void a(RouteGuideKind routeGuideKind) {
        if (com.baidu.platform.comapi.walknavi.e.j.a().a(routeGuideKind)) {
            com.baidu.platform.comapi.walknavi.e.j.a().c();
        }
        if (com.baidu.platform.comapi.walknavi.e.j.a().b(routeGuideKind)) {
            com.baidu.platform.comapi.walknavi.e.j.a().d();
        }
    }

    public void a(int i, int i2) {
        com.baidu.platform.comapi.wnplatform.p.s.a().a(i2, i);
        StringBuilder sb = new StringBuilder();
        sb.append("全程剩余:");
        sb.append(com.baidu.platform.comapi.wnplatform.p.s.a().c());
        sb.append(com.baidu.platform.comapi.wnplatform.p.s.a().b());
        com.baidu.platform.comapi.walknavi.h.c.c cVar = this.n;
        if (cVar != null && cVar.i() != null) {
            this.n.i().setText(sb.toString());
        }
        this.h.a(i);
        this.h.b().setText(sb.toString());
        this.h.a().setText(sb.toString());
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a(Bundle bundle) {
        double d = OOXIXo.f3760XO;
        float f = 0.0f;
        try {
            this.G = bundle.getFloat("curSpeed");
            this.ao = bundle.getInt("AddDist");
            d = new BigDecimal(bundle.getInt("AddDist") / 1000.0f).setScale(1, 4).doubleValue();
            f = bundle.getInt("RouteDist") / 1000.0f;
            float f2 = bundle.getFloat("calorie");
            com.baidu.platform.comapi.wnplatform.d.a.b("walk cal:" + f2 + "or:" + bundle.getFloat("calorie"));
            new BigDecimal((double) f2).setScale(1, 4).doubleValue();
        } catch (Exception e) {
            com.baidu.platform.comapi.wnplatform.d.a.b(MqttServiceConstants.TRACE_EXCEPTION + e.getMessage());
        }
        this.H = d / f;
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.a
    public void a(Message message) {
        if (message.arg1 == 0 && this.l != null && this.u != null) {
            ArrayList arrayList = new ArrayList();
            if (com.baidu.platform.comapi.wnplatform.f.a().d()) {
                arrayList.add("室内定位信号弱 ");
                arrayList.add("室内导航暂时无法使用");
            } else {
                arrayList.add("卫星信号弱 ");
                arrayList.add("请步行到开阔地带");
            }
            this.u.removeAllViews();
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.r();
            this.V = new com.baidu.platform.comapi.walknavi.segmentbrowse.widget.a(this.l, arrayList, R.drawable.wn_gps_white, 0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.z.getLayoutParams();
            layoutParams.height = com.baidu.platform.comapi.walknavi.segmentbrowse.widget.b.a(this.l, 95.0f);
            layoutParams.gravity = 16;
            this.V.setLayoutParams(layoutParams);
            this.u.addView(this.V);
            I();
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
            if (com.baidu.platform.comapi.wnplatform.f.a().c()) {
                b(0, true);
            }
        }
        ImageView imageView = this.J;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.wsdk_gps_weak);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.g
    public void a() {
        com.baidu.platform.comapi.walknavi.b.a().K().i();
    }
}
