package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.pronavi.model.g;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.a;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.z;
import com.baidu.navisdk.ui.routeguide.subview.widget.CircleProgressImageView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.o0;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class i extends com.baidu.navisdk.ui.routeguide.widget.d implements com.baidu.navisdk.ui.routeguide.mapmode.iview.b {
    private m1 A;
    private com.baidu.navisdk.pronavi.data.vm.h B;
    private LifecycleOwner C;
    private CircleProgressImageView[] D;
    private final com.baidu.navisdk.ui.routeguide.mapmode.presenter.d E;
    private com.baidu.navisdk.ui.routeguide.asr.view.a F;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.c G;
    private final com.baidu.navisdk.ui.routeguide.collisions.a H;
    private View I;
    private a.q0 J;
    private Runnable K;
    private Observer L;
    private Observer M;
    private Observer N;
    private Observer O;
    private TextView P;
    com.baidu.navisdk.util.worker.loop.a Q;
    private ViewGroup i;
    private RelativeLayout j;
    private a0 k;
    private a1 l;
    private boolean m;
    private n1 n;
    private ViewGroup o;
    private boolean p;
    private RelativeLayout q;
    private boolean r;
    private ViewGroup s;
    private View t;
    private TextView u;
    private ImageView v;
    private ViewGroup w;
    private com.baidu.nplatform.comapi.map.h x;
    private i1 y;
    private boolean z;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.F != null) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.o.5", null, null, "0");
                i.this.F.setVoiceTipsVisibility(8);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements o0.b {
        public b() {
        }

        @Override // com.baidu.navisdk.util.common.o0.b
        public void a(int i, boolean z, ArrayList<String> arrayList) {
            if (i == 2 && z && i.this.F != null) {
                i.this.F.h();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements z.i {
        public c() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.z.i
        public void a(int i, z.h hVar) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMMAssistGuideView", "setIntervalCameraVisibility->animationEnd callback,animType=" + hVar);
            }
            if (hVar == z.h.EXIT) {
                if (i.this.k != null) {
                    i.this.k.c();
                }
                if (i.this.Q != null) {
                    Message obtain = Message.obtain();
                    obtain.what = 10086;
                    i.this.Q.sendMessageDelayed(obtain, 500L);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends com.baidu.navisdk.util.worker.loop.a {
        public d(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            super.onMessage(message);
            if (message.what == 10086) {
                i.this.b(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.g();
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f8777a;

        public f(boolean z) {
            this.f8777a = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00b6  */
        /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r5 = this;
                com.baidu.navisdk.ui.routeguide.mapmode.subview.i r0 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.this
                com.baidu.navisdk.ui.routeguide.mapmode.presenter.d r0 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.h(r0)
                if (r0 != 0) goto L9
                return
            L9:
                com.baidu.navisdk.ui.routeguide.mapmode.subview.i r0 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.this
                com.baidu.navisdk.ui.routeguide.mapmode.presenter.d r0 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.h(r0)
                com.baidu.navisdk.ui.routeguide.mapmode.subview.i r1 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.this
                android.widget.RelativeLayout r1 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.n(r1)
                android.graphics.Rect r0 = r0.a(r1)
                int r1 = r0.right
                java.lang.String r2 = "RGMMAssistGuideViewCollision"
                if (r1 != 0) goto L54
                int r1 = r0.bottom
                if (r1 != 0) goto L54
                int r1 = r0.top
                if (r1 != 0) goto L54
                int r0 = r0.left
                if (r0 != 0) goto L54
                boolean r0 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE
                if (r0 == 0) goto L46
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "updateLeftTopLayoutMarginTop -> 未获取到正确的范围，重新获取！"
                r0.append(r1)
                boolean r1 = r5.f8777a
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                com.baidu.navisdk.util.common.LogUtil.e(r2, r0)
            L46:
                boolean r0 = r5.f8777a
                if (r0 == 0) goto L53
                com.baidu.navisdk.ui.routeguide.mapmode.subview.i r0 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.this
                r1 = 0
                r2 = 1
                r3 = 100
                com.baidu.navisdk.ui.routeguide.mapmode.subview.i.a(r0, r3, r1, r2)
            L53:
                return
            L54:
                com.baidu.navisdk.ui.routeguide.mapmode.subview.i r0 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.this
                com.baidu.navisdk.ui.routeguide.mapmode.presenter.d r0 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.h(r0)
                com.baidu.navisdk.ui.routeguide.mapmode.subview.i r1 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.this
                android.widget.RelativeLayout r1 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.n(r1)
                com.baidu.navisdk.ui.routeguide.mapmode.subview.i r3 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.this
                android.content.Context r3 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.c(r3)
                int r0 = r0.a(r1, r3)
                com.baidu.navisdk.ui.routeguide.mapmode.subview.i r1 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.this
                android.widget.RelativeLayout r1 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.n(r1)
                android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
                if (r1 == 0) goto L8d
                boolean r3 = r1 instanceof android.view.ViewGroup.MarginLayoutParams
                if (r3 == 0) goto L8d
                r3 = r1
                android.view.ViewGroup$MarginLayoutParams r3 = (android.view.ViewGroup.MarginLayoutParams) r3
                int r4 = r3.topMargin
                if (r4 == r0) goto L8d
                r3.topMargin = r0
                com.baidu.navisdk.ui.routeguide.mapmode.subview.i r1 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.this
                android.widget.RelativeLayout r1 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.n(r1)
                r1.requestLayout()
                goto Lae
            L8d:
                boolean r3 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE
                if (r3 == 0) goto Lae
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "updateLeftTopLayoutMarginTop -> layoutParams= "
                r3.append(r4)
                r3.append(r1)
                java.lang.String r1 = ","
                r3.append(r1)
                r3.append(r0)
                java.lang.String r1 = r3.toString()
                com.baidu.navisdk.util.common.LogUtil.e(r2, r1)
            Lae:
                com.baidu.navisdk.ui.routeguide.mapmode.subview.i r1 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.this
                android.widget.TextView r1 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.d(r1)
                if (r1 == 0) goto Le0
                com.baidu.navisdk.ui.routeguide.mapmode.subview.i r1 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.this
                android.widget.TextView r1 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.d(r1)
                android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
                boolean r2 = r1 instanceof android.view.ViewGroup.MarginLayoutParams
                if (r2 == 0) goto Le0
                com.baidu.navisdk.ui.routeguide.mapmode.subview.i r2 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.this
                android.content.Context r2 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.e(r2)
                if (r2 == 0) goto Le0
                int r2 = com.baidu.navisdk.embed.R.dimen.navi_dimens_11dp
                int r2 = com.baidu.navisdk.ui.util.b.e(r2)
                android.view.ViewGroup$MarginLayoutParams r1 = (android.view.ViewGroup.MarginLayoutParams) r1
                int r0 = r0 + r2
                r1.topMargin = r0
                com.baidu.navisdk.ui.routeguide.mapmode.subview.i r0 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.this
                android.widget.TextView r0 = com.baidu.navisdk.ui.routeguide.mapmode.subview.i.d(r0)
                r0.requestLayout()
            Le0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.mapmode.subview.i.f.run():void");
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public g() {
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002f A[Catch: Exception -> 0x0018, TRY_ENTER, TryCatch #0 {Exception -> 0x0018, blocks: (B:2:0x0000, B:4:0x000b, B:8:0x0025, B:11:0x002f, B:12:0x006b, B:14:0x0076, B:16:0x0080, B:18:0x008a, B:20:0x0094, B:24:0x00a1, B:27:0x00ae, B:29:0x00b4, B:30:0x00ba, B:32:0x00c0, B:33:0x00d4, B:34:0x00e8, B:36:0x00ee, B:37:0x0102, B:39:0x0110, B:40:0x011e, B:42:0x0128, B:44:0x0132, B:46:0x013d, B:47:0x0142, B:51:0x001b), top: B:1:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00b4 A[Catch: Exception -> 0x0018, TryCatch #0 {Exception -> 0x0018, blocks: (B:2:0x0000, B:4:0x000b, B:8:0x0025, B:11:0x002f, B:12:0x006b, B:14:0x0076, B:16:0x0080, B:18:0x008a, B:20:0x0094, B:24:0x00a1, B:27:0x00ae, B:29:0x00b4, B:30:0x00ba, B:32:0x00c0, B:33:0x00d4, B:34:0x00e8, B:36:0x00ee, B:37:0x0102, B:39:0x0110, B:40:0x011e, B:42:0x0128, B:44:0x0132, B:46:0x013d, B:47:0x0142, B:51:0x001b), top: B:1:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00c0 A[Catch: Exception -> 0x0018, TryCatch #0 {Exception -> 0x0018, blocks: (B:2:0x0000, B:4:0x000b, B:8:0x0025, B:11:0x002f, B:12:0x006b, B:14:0x0076, B:16:0x0080, B:18:0x008a, B:20:0x0094, B:24:0x00a1, B:27:0x00ae, B:29:0x00b4, B:30:0x00ba, B:32:0x00c0, B:33:0x00d4, B:34:0x00e8, B:36:0x00ee, B:37:0x0102, B:39:0x0110, B:40:0x011e, B:42:0x0128, B:44:0x0132, B:46:0x013d, B:47:0x0142, B:51:0x001b), top: B:1:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00ee A[Catch: Exception -> 0x0018, TryCatch #0 {Exception -> 0x0018, blocks: (B:2:0x0000, B:4:0x000b, B:8:0x0025, B:11:0x002f, B:12:0x006b, B:14:0x0076, B:16:0x0080, B:18:0x008a, B:20:0x0094, B:24:0x00a1, B:27:0x00ae, B:29:0x00b4, B:30:0x00ba, B:32:0x00c0, B:33:0x00d4, B:34:0x00e8, B:36:0x00ee, B:37:0x0102, B:39:0x0110, B:40:0x011e, B:42:0x0128, B:44:0x0132, B:46:0x013d, B:47:0x0142, B:51:0x001b), top: B:1:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0110 A[Catch: Exception -> 0x0018, TryCatch #0 {Exception -> 0x0018, blocks: (B:2:0x0000, B:4:0x000b, B:8:0x0025, B:11:0x002f, B:12:0x006b, B:14:0x0076, B:16:0x0080, B:18:0x008a, B:20:0x0094, B:24:0x00a1, B:27:0x00ae, B:29:0x00b4, B:30:0x00ba, B:32:0x00c0, B:33:0x00d4, B:34:0x00e8, B:36:0x00ee, B:37:0x0102, B:39:0x0110, B:40:0x011e, B:42:0x0128, B:44:0x0132, B:46:0x013d, B:47:0x0142, B:51:0x001b), top: B:1:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x013d A[Catch: Exception -> 0x0018, TryCatch #0 {Exception -> 0x0018, blocks: (B:2:0x0000, B:4:0x000b, B:8:0x0025, B:11:0x002f, B:12:0x006b, B:14:0x0076, B:16:0x0080, B:18:0x008a, B:20:0x0094, B:24:0x00a1, B:27:0x00ae, B:29:0x00b4, B:30:0x00ba, B:32:0x00c0, B:33:0x00d4, B:34:0x00e8, B:36:0x00ee, B:37:0x0102, B:39:0x0110, B:40:0x011e, B:42:0x0128, B:44:0x0132, B:46:0x013d, B:47:0x0142, B:51:0x001b), top: B:1:0x0000 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 334
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.mapmode.subview.i.g.run():void");
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public h(i iVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMMAssistGuideView", "updateDestArrivalTimeMarginTop(), handleArrivalTimeViewCollision");
            }
            com.baidu.navisdk.ui.routeguide.control.x.b().v0();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.i$i, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0458i implements Observer<Double> {
        public C0458i() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Double d) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMAssistGuideView", "bindRoadConditionVM: carProgress = " + d);
            }
            if (i.this.A != null) {
                i.this.A.a(d.doubleValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements Observer<List<com.baidu.navisdk.model.datastruct.m>> {
        public j() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<com.baidu.navisdk.model.datastruct.m> list) {
            if (i.this.A != null) {
                i.this.A.c(list);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements Observer<List<com.baidu.navisdk.module.pronavi.model.c>> {
        public k() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<com.baidu.navisdk.module.pronavi.model.c> list) {
            if (i.this.A != null) {
                i.this.A.b(list);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements Observer<com.baidu.navisdk.module.pronavi.model.c> {
        public l() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.baidu.navisdk.module.pronavi.model.c cVar) {
            if (i.this.A != null) {
                if (cVar == null) {
                    i.this.A.r0();
                } else {
                    i.this.A.a(cVar);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m implements a.q0 {
        public m() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.a.q0
        public void a() {
            com.baidu.navisdk.ui.routeguide.control.x.b().d(i.this.I);
        }
    }

    /* loaded from: classes8.dex */
    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.E.h();
        }
    }

    /* loaded from: classes8.dex */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.y != null) {
                i.this.y.P();
            }
            if (i.this.E != null) {
                i.this.E.a(((com.baidu.navisdk.ui.routeguide.widget.d) i.this).f9165a);
            }
            if (i.this.y != null) {
                i.this.y.p0();
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.e.2", null, null, null);
        }
    }

    /* loaded from: classes8.dex */
    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.E.i();
        }
    }

    /* loaded from: classes8.dex */
    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.y0();
        }
    }

    public i(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.m = false;
        this.p = false;
        this.r = false;
        this.z = false;
        this.L = new C0458i();
        this.M = new j();
        this.N = new k();
        this.O = new l();
        this.Q = new d("RGMMAssistGuideView");
        com.baidu.navisdk.framework.interfaces.k k2 = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k2 != null) {
            this.m = k2.p();
            this.p = k2.z();
            this.r = k2.v();
            this.z = k2.U();
        }
        this.H = new com.baidu.navisdk.ui.routeguide.collisions.a();
        B(false);
        com.baidu.navisdk.ui.routeguide.mapmode.presenter.d dVar = new com.baidu.navisdk.ui.routeguide.mapmode.presenter.d();
        this.E = dVar;
        dVar.a(this);
        a(com.baidu.navisdk.ui.util.b.b());
        u0();
        z(this.m);
        A(this.p);
        if (this.r) {
            a(8);
        }
        if (this.z) {
            B(8);
        }
    }

    private void A0() {
        int i;
        ViewGroup viewGroup = (ViewGroup) this.b.findViewById(R.id.xd_voice_always_container);
        TextView textView = this.P;
        String str = null;
        if (textView != null) {
            i = textView.getVisibility();
            if (this.P.getText() != null) {
                str = this.P.getText().toString();
            }
        } else {
            i = -1;
        }
        TextView textView2 = (TextView) this.b.findViewById(R.id.xd_voice_btn_tips);
        this.P = textView2;
        com.baidu.navisdk.ui.util.b.a((View) textView2, R.drawable.nsdk_xd_btn_tips_bubble);
        this.P.setPadding(this.f9165a.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_15dp), 0, this.f9165a.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_10dp), 0);
        if (i != -1) {
            this.P.setVisibility(i);
        }
        if (!TextUtils.isEmpty(str)) {
            this.P.setText(str);
        }
        if (this.F == null) {
            this.F = new com.baidu.navisdk.ui.routeguide.asr.view.a(this.f9165a);
        }
        this.F.setVoiceAlwaysTips(this.P);
        this.F.setVoiceBtnClickListener(new q());
        this.P.setOnClickListener(new a());
        if (this.F.getParent() != null && (this.F.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.F.getParent()).removeView(this.F);
        }
        viewGroup.addView(this.F);
    }

    private void B(boolean z) {
        m1 m1Var;
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.bnav_rg_assist_panel);
        this.i = viewGroup2;
        if (this.l == null) {
            this.l = new a1(this.f9165a, viewGroup2, this.c);
        }
        this.s = (ViewGroup) this.b.findViewById(R.id.bnav_rg_intervene_info);
        this.j = (RelativeLayout) this.b.findViewById(R.id.bnav_assist_panel_top_left_layout);
        A0();
        RelativeLayout relativeLayout = (RelativeLayout) this.b.findViewById(R.id.bnav_top_right_panel_container);
        this.q = relativeLayout;
        if (this.r) {
            relativeLayout.setVisibility(8);
        }
        this.I = this.b.findViewById(R.id.bnav_rg_assist_right_bottom_layout);
        com.baidu.navisdk.ui.routeguide.control.x.b().d(this.I);
        this.J = new m();
        com.baidu.navisdk.ui.routeguide.control.x.b().a(this.J);
        this.k = null;
        m1 m1Var2 = this.A;
        if (m1Var2 != null) {
            if (Build.VERSION.SDK_INT < 28) {
                m1Var2.q0();
            }
        } else {
            this.A = new m1(this.f9165a, this.i);
            this.B = (com.baidu.navisdk.pronavi.data.vm.h) com.baidu.navisdk.ui.routeguide.b.V().s().c(com.baidu.navisdk.pronavi.data.vm.h.class);
            this.C = com.baidu.navisdk.ui.routeguide.b.V().f();
            x0();
        }
        this.v = (ImageView) this.b.findViewById(R.id.bnav_rg_cp_fullview_mode_iv);
        this.u = (TextView) this.b.findViewById(R.id.bnav_rg_cp_fullview_mode_tv);
        View findViewById = this.b.findViewById(R.id.bnav_rg_cp_fullview_mode_btn);
        this.t = findViewById;
        findViewById.setOnClickListener(new n());
        this.o = (ViewGroup) this.b.findViewById(R.id.bnav_rg_truck_avoidance_container);
        if (this.z) {
            G(8);
        }
        if (z) {
            i1 i1Var = this.y;
            if (i1Var != null) {
                i1Var.a(this.b, com.baidu.navisdk.ui.routeguide.control.x.b().d0());
            }
            n1 n1Var = this.n;
            if (n1Var != null) {
                n1Var.a(this.o, com.baidu.navisdk.ui.routeguide.control.x.b().d0());
            }
            m1 m1Var3 = this.A;
            if (m1Var3 != null) {
                m1Var3.a(this.i, com.baidu.navisdk.ui.routeguide.control.x.b().d0());
                this.A.a(this.B.f().getValue(), this.B.g().getValue(), this.B.d().getValue().doubleValue());
            }
        } else {
            if (i1.r0()) {
                i1 i1Var2 = new i1(this.f9165a, this.b);
                this.y = i1Var2;
                i1Var2.b(new o());
            } else if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMMAssistGuideView", "initViews RGMMWeatherBtnView " + i1.r0());
            }
            this.G = new com.baidu.navisdk.ui.routeguide.mapmode.subview.c(this.f9165a, this.i);
        }
        com.baidu.navisdk.ui.routeguide.collisions.a aVar = this.H;
        if (aVar != null && (m1Var = this.A) != null) {
            aVar.a(m1Var.o0());
        }
        ViewGroup viewGroup3 = (ViewGroup) this.b.findViewById(R.id.bnav_rg_cp_map_switch);
        this.w = viewGroup3;
        viewGroup3.setOnClickListener(new p());
        if (com.baidu.navisdk.ui.routeguide.control.x.b().s2() || BNCommSettingManager.getInstance().getIsShowMapSwitch() == 0) {
            f(false);
        }
        b(true);
    }

    private boolean B0() {
        return RouteGuideFSM.getInstance().isBrowseState();
    }

    private void C(int i) {
        int dimensionPixelOffset;
        if (this.f == 2) {
            if (i == 1 || com.baidu.navisdk.ui.routeguide.control.x.b().f2() || com.baidu.navisdk.ui.routeguide.control.x.b().N2()) {
                ViewGroup.LayoutParams layoutParams = this.I.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    if (com.baidu.navisdk.util.common.x.s()) {
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("RGMMAssistGuideView", "showMapSwitchOrRoadBar NE_Locate_Mode_RouteDemoGPS");
                        }
                        dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_anolog_navi_bottom_margin) + JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_control_panel_btn_height);
                    } else {
                        dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_5dp);
                    }
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = dimensionPixelOffset;
                    this.I.requestLayout();
                }
            }
        }
    }

    private boolean C0() {
        ViewGroup viewGroup = this.w;
        if (viewGroup == null || viewGroup.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    private void D(boolean z) {
        if (this.w == null) {
            return;
        }
        z0();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMAssistGuideView", "showMiniMap: " + z);
        }
        if (z) {
            this.w.setVisibility(0);
            if (this.w.getChildCount() == 0) {
                if (this.x.getParent() != null) {
                    ((ViewGroup) this.x.getParent()).removeView((View) this.x);
                }
                if (!RouteGuideFSM.getInstance().isBrowseState()) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                    ViewGroup viewGroup = this.w;
                    if (viewGroup != null) {
                        viewGroup.addView((View) this.x, layoutParams);
                        this.w.requestLayout();
                    }
                }
                if (com.baidu.navisdk.module.pronavi.a.j == 2) {
                    ViewGroup viewGroup2 = this.w;
                    if (viewGroup2 != null) {
                        viewGroup2.setVisibility(8);
                    }
                    com.baidu.nplatform.comapi.map.h hVar = this.x;
                    if (hVar != null) {
                        hVar.setVisibility(8);
                    }
                }
            }
            com.baidu.nplatform.comapi.map.h hVar2 = this.x;
            if (hVar2 == null || hVar2.getParent() == null) {
                return;
            }
            this.x.setVisibility(0);
            if (gVar.d()) {
                gVar.e("RGMMAssistGuideView", "showMiniMap: mMapSwitchSurfaceView - VISIBLE");
                return;
            }
            return;
        }
        this.w.setVisibility(8);
        this.x.setVisibility(8);
    }

    private void D0() {
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.z.3", null, null, "0");
        if (Build.VERSION.SDK_INT >= 23) {
            if (!com.baidu.navisdk.util.common.n0.a(com.baidu.navisdk.framework.a.c().a(), "android.permission.RECORD_AUDIO")) {
                com.baidu.navisdk.util.common.o0.b().a(2, new b());
                return;
            } else {
                com.baidu.navisdk.asr.d.B().A();
                return;
            }
        }
        com.baidu.navisdk.asr.d.B().A();
    }

    private void E(int i) {
        View view = this.t;
        if (view != null) {
            view.setVisibility(i);
        }
        m1 m1Var = this.A;
        if (m1Var != null) {
            m1Var.w(i);
        }
    }

    private void E0() {
        Runnable runnable;
        RelativeLayout relativeLayout = this.j;
        if (relativeLayout != null && (runnable = this.K) != null) {
            relativeLayout.removeCallbacks(runnable);
        }
        this.K = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        RelativeLayout relativeLayout;
        if (!com.baidu.navisdk.ui.routeguide.control.x.b().s2() && (relativeLayout = this.q) != null) {
            relativeLayout.post(new h(this));
        }
    }

    private void G(int i) {
        E(i);
        ViewGroup viewGroup = this.w;
        if (viewGroup != null) {
            viewGroup.setVisibility(i);
        }
    }

    private void x0() {
        this.B.d().observe(this.C, this.L);
        this.B.f().observe(this.C, this.M);
        this.B.g().observe(this.C, this.N);
        this.B.h().observe(this.C, this.O);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        D0();
    }

    private void z0() {
        if (this.x == null) {
            this.x = com.baidu.nplatform.comapi.map.b.f9495a.a(this.f9165a);
        }
    }

    public void A(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMAssistGuideView", "showAssistGuideView-> entry=" + i);
        }
        if (com.baidu.navisdk.ui.routeguide.b.V().x()) {
            y();
            if (i == 1) {
                b(0);
                return;
            }
            if (i == 0) {
                b(0);
                a(0, true);
                a(com.baidu.navisdk.module.pronavi.model.g.o().e(), com.baidu.navisdk.module.pronavi.model.g.o().d());
                ViewGroup viewGroup = this.s;
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                }
                b(true);
                u0();
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void F() {
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public Rect U() {
        if (this.A != null) {
            Rect rect = new Rect();
            this.A.a(rect);
            return rect;
        }
        return null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void Z() {
        com.baidu.navisdk.ui.routeguide.subview.a aVar = this.c;
        if (aVar != null) {
            aVar.a(3, 0, 0, null);
        }
    }

    public com.baidu.navisdk.ui.routeguide.mapmode.presenter.d n0() {
        return this.E;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void o() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMAssistGuideView", "show3DCarLogoBubbleView: " + this.G);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.subview.c cVar = this.G;
        if (cVar != null) {
            cVar.y();
        }
    }

    public com.baidu.navisdk.ui.routeguide.asr.view.a o0() {
        return this.F;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void onResume() {
        super.onResume();
        if (a()) {
            r();
        }
    }

    public void p0() {
        LogUtil.e("RGMMAssistGuideView", "hideVoiceAlwaysView");
        com.baidu.navisdk.ui.routeguide.asr.view.a aVar = this.F;
        if (aVar != null) {
            aVar.setVisibility(8);
            d(8);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void q() {
        a1 a1Var = this.l;
        if (a1Var != null) {
            a1Var.q();
        }
    }

    public void q0() {
        Object obj;
        ViewGroup viewGroup = this.w;
        if (viewGroup != null && (obj = this.x) != null) {
            viewGroup.removeView((View) obj);
        }
        t0();
        LogUtil.e("RGMMAssistGuideView", "releaseMiniMap");
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void r() {
        a(0L, true, true);
    }

    public void r0() {
        LogUtil.e("RGMMAssistGuideView", "showFullViewByFuzzy->RoadConditionBar");
        D(false);
        E(0);
        m1 m1Var = this.A;
        if (m1Var != null) {
            m1Var.w(8);
        }
        View view = this.t;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void s(boolean z) {
        if (this.t == null) {
            return;
        }
        int a2 = com.baidu.navisdk.module.newguide.a.e().a(z, this.f == 1);
        if (z) {
            this.u.setTextSize(0, a2);
            this.u.setText("退出全览");
        } else {
            this.u.setTextSize(0, a2);
            this.u.setText("全览");
        }
    }

    public void s0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMAssistGuideView", "showVoiceAliwaysView: ");
        }
        if (this.F != null) {
            if (!com.baidu.navisdk.ui.routeguide.asr.c.n().b()) {
                this.F.setVisibility(0);
                d(0);
                return;
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("XDVoice", "showVoiceAliwaysView-> 当前不允许展示小度常驻按钮, isCloseByCloud=" + com.baidu.navisdk.ui.routeguide.asr.c.n().b());
            }
            p0();
        }
    }

    public void t0() {
        com.baidu.nplatform.comapi.map.h hVar = this.x;
        if (hVar != null) {
            hVar.unInit();
            this.x = null;
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void u() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMAssistGuideView", "hideTruckAvoidanceReminderPanel");
        }
        n1 n1Var = this.n;
        if (n1Var != null) {
            n1Var.c();
        }
    }

    public void u0() {
        this.E.n();
    }

    public void v(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMAssistGuideView", "hideAssistGuideView-> entry=" + i);
        }
        if (i == 0) {
            c();
            return;
        }
        if (i == 2) {
            com.baidu.navisdk.ui.routeguide.control.x.b().W0();
        }
        if (i != 1) {
            b(8);
            a(8, false);
        }
        y(false);
        u();
        b(false);
        ViewGroup viewGroup = this.s;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        a(8);
        m();
    }

    public void w(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMAssistGuideView", "moveLeftViews = " + i);
        }
        if (i != 2) {
            if (C(false)) {
                a(0L, true, false);
            }
        } else if (!D(i)) {
            if (gVar.d()) {
                gVar.e("RGMMAssistGuideView", "moveLeftViews: leftViewsAlreadyMove");
            }
        } else {
            b(i, false);
            if (com.baidu.navisdk.ui.routeguide.control.x.b().p2()) {
                a(0L, true, false);
            }
        }
    }

    public void w0() {
        com.baidu.navisdk.ui.routeguide.asr.view.a aVar = this.F;
        if (aVar != null) {
            aVar.h();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void x(boolean z) {
        com.baidu.navisdk.ui.routeguide.asr.view.a aVar;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMAssistGuideViewCollision", "onCollisionExceedMaxLine -> isCollision= " + z);
        }
        if (z && (aVar = this.F) != null) {
            aVar.setVoiceTipsVisibility(8);
        }
        boolean z2 = true;
        if (z && !com.baidu.navisdk.ui.routeguide.control.x.b().s2() && this.j != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.j.getChildCount(); i2++) {
                View childAt = this.j.getChildAt(i2);
                int measuredHeight = childAt.getMeasuredHeight();
                if (childAt.getVisibility() == 0 && measuredHeight > 10) {
                    i++;
                }
            }
            r0 = i >= 2;
            z2 = !r0;
            if (LogUtil.LOGGABLE) {
                StringBuilder sb = new StringBuilder();
                sb.append("onCollisionExceedMaxLine ->");
                sb.append(r0 ? "左上角3元素发生碰撞，隐藏上报、景点、迎团圆按钮" : "左上角3元素未发生碰撞，允许展示上报、景点、迎团圆按钮");
                LogUtil.e("RGMMAssistGuideViewCollision", sb.toString());
            }
        }
        com.baidu.navisdk.module.pronavi.model.g.o().d(r0);
        com.baidu.navisdk.ui.routeguide.control.x.b().J().h(r0);
        com.baidu.navisdk.ui.routeguide.control.x.b().M(z2);
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        LogUtil.e("RGMMAssistGuideView", "RGMMAssistGuideView - show");
        super.y();
        ViewGroup viewGroup = this.i;
        if (viewGroup == null) {
            return true;
        }
        viewGroup.setVisibility(0);
        return true;
    }

    public void z(int i) {
        m1 m1Var = this.A;
        if (m1Var != null) {
            m1Var.w(i);
        }
    }

    private void F(int i) {
        m1 m1Var = this.A;
        if (m1Var == null || !m1Var.v(i)) {
            return;
        }
        F();
    }

    private void b(int i, g.a aVar) {
        CircleProgressImageView[] circleProgressImageViewArr = this.D;
        if (circleProgressImageViewArr == null || i < 0 || i >= circleProgressImageViewArr.length || aVar == null || aVar.e <= 0) {
            return;
        }
        circleProgressImageViewArr[i].setMainProgress(aVar.d);
        if (RouteGuideParams.NavState.NAV_STATE_NAVING.equals(com.baidu.navisdk.ui.routeguide.model.g.h().b())) {
            this.D[i].setVisibility(0);
        } else {
            this.D[i].setVisibility(8);
        }
        int i2 = aVar.b;
        if (i2 == 8) {
            this.D[i].setBeamHeight(0);
            this.D[i].setText((aVar.c / 1000) + "");
        } else if (i2 == 11) {
            this.D[i].setBeamHeight(0);
            this.D[i].setText((aVar.c / 1000) + "");
        } else {
            this.D[i].setBeamHeight(0);
            this.D[i].setText("");
        }
        this.D[i].setImageDrawable(com.baidu.navisdk.ui.util.b.f(aVar.e));
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        LogUtil.e("RGMMAssistGuideView", "RGMMAssistGuideView - hide");
        ViewGroup viewGroup = this.i;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        b(8);
        y(false);
        b(false);
        m();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void d(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("XDVoice", "setVoiceBtnDisplay visibility=" + i);
        }
        if (i == 0 && com.baidu.navisdk.ui.routeguide.asr.c.n().i() && com.baidu.navisdk.ui.routeguide.asr.c.n().d()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("XDVoice", "setVoiceBtnDisplay 正在场景化引导，不允许显示小度常驻按钮");
                return;
            }
            return;
        }
        com.baidu.navisdk.ui.routeguide.asr.view.a aVar = this.F;
        if (aVar != null) {
            boolean a2 = aVar.a(i);
            if (i == 0 && a2) {
                this.F.e();
                this.F.h();
            } else {
                this.F.f();
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public boolean e() {
        return C0();
    }

    public void f(String str) {
        com.baidu.navisdk.ui.routeguide.asr.view.a aVar = this.F;
        if (aVar != null && aVar.getVisibility() == 0 && this.F.c()) {
            this.F.a(str);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void g() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMAssistGuideView", "initRoadConditionBarMarginLocation: ");
        }
        F(this.E.c());
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        q0();
        E0();
        com.baidu.navisdk.ui.routeguide.mapmode.presenter.d dVar = this.E;
        if (dVar != null) {
            dVar.b();
        }
        com.baidu.navisdk.util.worker.loop.a aVar = this.Q;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages(null);
        }
        com.baidu.navisdk.ui.routeguide.collisions.a aVar2 = this.H;
        if (aVar2 != null) {
            aVar2.a();
        }
        m1 m1Var = this.A;
        if (m1Var != null) {
            m1Var.i();
            this.A = null;
        }
        i1 i1Var = this.y;
        if (i1Var != null) {
            i1Var.i();
        }
        com.baidu.navisdk.ui.routeguide.asr.view.a aVar3 = this.F;
        if (aVar3 != null) {
            aVar3.a();
            this.F = null;
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().b(this.J);
        super.i();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public boolean j() {
        if (BNCommSettingManager.getInstance().getIsShowMapSwitch() != 1 || this.A == null || this.I == null) {
            return false;
        }
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("isRoadConditionBarShown, mRoadConditionView.isShown()=");
            sb.append(this.A.p0() == 0);
            sb.append(", mRightBottomLayout= ");
            sb.append(this.I.getVisibility() == 0);
            LogUtil.e("RGMMAssistGuideView", sb.toString());
        }
        return this.I.getVisibility() == 0 && this.A.p0() == 0;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void k() {
        RelativeLayout relativeLayout = this.q;
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.post(new g());
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void m() {
        if (this.G != null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMMAssistGuideView", "hide3DCarLogoBubbleView: ");
            }
            this.G.c();
            this.G = null;
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        Object obj;
        super.a(viewGroup, i);
        E0();
        ViewGroup viewGroup2 = this.w;
        if (viewGroup2 != null && (obj = this.x) != null) {
            viewGroup2.removeView((View) obj);
        }
        B(true);
        a1 a1Var = this.l;
        if (a1Var != null) {
            a1Var.a(this.i, i);
        }
        a(com.baidu.navisdk.ui.util.b.b());
        u0();
        com.baidu.navisdk.ui.routeguide.mapmode.subview.c cVar = this.G;
        if (cVar != null) {
            cVar.a(this.i, i);
        }
        LogUtil.d("RGMMAssistGuideView", "orientationChanged, orien=" + i);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public boolean z() {
        com.baidu.navisdk.ui.routeguide.subview.a aVar = this.c;
        boolean b2 = aVar != null ? aVar.b(true) : false;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMAssistGuideView", "onFullViewAction: " + b2);
        }
        return b2;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void f(boolean z) {
        int dimensionPixelOffset;
        RelativeLayout.LayoutParams layoutParams;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMAssistGuideView", "refreshTopRightMarginRight moveLeft = " + z);
        }
        if (this.q == null) {
            LogUtil.e("RGMMAssistGuideView", "refreshTopRightMarginRight return mContentLayout is null");
            return;
        }
        if (z) {
            dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_road_condition_bar_width) + JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_5dp);
        } else {
            dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_guide_panel_shadow_left);
        }
        if (this.q.getLayoutParams() != null) {
            layoutParams = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            if (layoutParams.rightMargin == dimensionPixelOffset) {
                if (gVar.d()) {
                    gVar.e("RGMMAssistGuideView", "refreshTopRightMarginRight serviceLp.rightMargin == marginRight, return! ");
                    return;
                }
                return;
            }
            layoutParams.rightMargin = dimensionPixelOffset;
        } else {
            int dimensionPixelOffset2 = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_hw_simple_board_margin_right);
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.setMargins(dimensionPixelOffset2, dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2);
        }
        this.q.setLayoutParams(layoutParams);
        k();
    }

    public void y(boolean z) {
        if (this.D != null) {
            int i = 0;
            int i2 = z ? 0 : 8;
            while (true) {
                CircleProgressImageView[] circleProgressImageViewArr = this.D;
                if (i >= circleProgressImageViewArr.length) {
                    break;
                }
                circleProgressImageViewArr[i].setVisibility(i2);
                i++;
            }
            if (z) {
                com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410284", "410284");
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void g(boolean z) {
        i1 i1Var = this.y;
        if (i1Var != null) {
            i1Var.g(z);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public View s() {
        return this.q;
    }

    public void z(boolean z) {
        this.m = z;
        if (z) {
            a(8, false);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void c(boolean z) {
        i1 i1Var = this.y;
        if (i1Var != null) {
            i1Var.c(z);
        }
    }

    public void y(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMAssistGuideView", "resetViewsLocationWithHideEnlargeView:" + i);
        }
        if (i != 2) {
            if (C(false)) {
                a(0L, true, false);
            }
        } else {
            b(i, false);
            if (com.baidu.navisdk.ui.routeguide.control.x.b().p2()) {
                a(0L, true, false);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void d(Bundle bundle) {
        this.E.b(bundle);
    }

    private void d(int i, int i2) {
        CircleProgressImageView circleProgressImageView;
        CircleProgressImageView[] circleProgressImageViewArr = this.D;
        if (circleProgressImageViewArr == null || (circleProgressImageView = circleProgressImageViewArr[i]) == null) {
            return;
        }
        circleProgressImageView.setMainProgress(i2);
    }

    public void A(boolean z) {
        this.p = z;
        if (z) {
            u();
        } else if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMAssistGuideView", "用户已开启货车避让面板显示");
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void a(CircleProgressImageView[] circleProgressImageViewArr) {
        this.D = circleProgressImageViewArr;
    }

    private boolean C(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMAssistGuideView", "isNeedMoveLeftTopLayout4Portrait: " + z);
        }
        if (this.j == null) {
            return false;
        }
        int a2 = u.a(this.f9165a);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.j.getLayoutParams();
        if (gVar.d()) {
            gVar.e("RGMMAssistGuideView", "isNeedMoveLeftTopLayout4Portrait: " + z + "," + marginLayoutParams.topMargin + "," + a2);
        }
        return z ? marginLayoutParams.topMargin < a2 : marginLayoutParams.topMargin >= a2;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        View view = this.t;
        if (view != null) {
            view.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_rg_selector_common_control_btn_bg));
        }
        ImageView imageView = this.v;
        if (imageView != null) {
            imageView.setImageDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_drawable_common_ic_fullview_mode));
        }
        TextView textView = this.u;
        if (textView != null) {
            textView.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_text_h));
        }
        a0 a0Var = this.k;
        if (a0Var != null) {
            a0Var.a(z);
        }
        a1 a1Var = this.l;
        if (a1Var != null) {
            a1Var.a(z);
        }
        i1 i1Var = this.y;
        if (i1Var != null) {
            i1Var.a(z);
        }
        m1 m1Var = this.A;
        if (m1Var != null) {
            m1Var.a(z);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void d() {
        if (this.I == null) {
            return;
        }
        LogUtil.e("RGMMAssistGuideView", "updateRoadConditionBarMarginTop->");
        this.I.post(new e());
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void b(boolean z) {
        if (z && (RouteGuideFSM.getInstance().isBrowseState() || com.baidu.navisdk.ui.routeguide.control.x.b().b2() || com.baidu.navisdk.ui.routeguide.model.a0.I().D() || com.baidu.navisdk.ui.routeguide.model.a0.I().r() || com.baidu.navisdk.ui.routeguide.asr.c.n().f())) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMAssistGuideView", "showMapSwitchOrRoadBar-> return ! isBrowseState: " + RouteGuideFSM.getInstance().isBrowseState() + ", isEnlargeOrColladaShow:" + com.baidu.navisdk.ui.routeguide.control.x.b().b2() + ", isYawing: " + com.baidu.navisdk.ui.routeguide.model.a0.I().D() + ", isFakeYawing: " + com.baidu.navisdk.ui.routeguide.model.a0.I().r() + ", isRoused: " + com.baidu.navisdk.ui.routeguide.asr.c.n().f());
                return;
            }
            return;
        }
        if (!com.baidu.navisdk.ui.routeguide.b.V().x()) {
            if (this.w != null) {
                D(false);
            }
            E(8);
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGMMAssistGuideView", "showMapSwitchOrRoadBar: hasCalcRoute not ok");
                return;
            }
            return;
        }
        int isShowMapSwitch = BNCommSettingManager.getInstance().getIsShowMapSwitch();
        boolean z2 = z && isShowMapSwitch == 0;
        boolean z3 = z && isShowMapSwitch == 1;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMAssistGuideView", "元素碰撞 showMapSwitchOrRoadBar-> show= " + z + ", isMapSwitchShow= " + z2 + ", isRoadBarShow= " + z3 + ", hasCalcRouteOk=" + com.baidu.navisdk.ui.routeguide.b.V().x());
        }
        C(isShowMapSwitch);
        if (z && com.baidu.navisdk.ui.routeguide.control.x.b().f2()) {
            r0();
            return;
        }
        if (z && com.baidu.navisdk.ui.routeguide.control.x.b().N2()) {
            r0();
            return;
        }
        if (this.w != null) {
            D(z2);
        }
        if (this.A != null) {
            if (z3) {
                E(0);
                boolean a2 = com.baidu.navisdk.ui.routeguide.model.g.h().a();
                LogUtil.e("RGMMAssistGuideView", "showMapSwitchOrRoadBar-> isFullViewState= " + a2);
                z(a2 ? 8 : 0);
                g();
            } else {
                E(8);
            }
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().v0();
    }

    public void x(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMAssistGuideView", "moveRightViews, mTopLeftLayout = " + i);
        }
        if (i != 2) {
            if (C(true)) {
                a(0L, true, false);
                return;
            }
            return;
        }
        if (D(i)) {
            if (gVar.d()) {
                gVar.e("RGMMAssistGuideView", "moveRightViews: leftViewsAlreadyMove = " + i);
                return;
            }
            return;
        }
        int R = com.baidu.navisdk.ui.routeguide.control.x.b().R() - com.baidu.navisdk.ui.routeguide.control.x.b().V();
        if (gVar.d()) {
            gVar.e("RGMMAssistGuideView", "moveViewsWithEnlargeShow: 0->" + R);
        }
        if (R < 0) {
            return;
        }
        com.baidu.navisdk.ui.routeguide.utils.b.a(this.j, R, "left", false);
        if (com.baidu.navisdk.ui.routeguide.control.x.b().p2()) {
            a(0L, true, false);
        }
    }

    private boolean D(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMAssistGuideView", "leftTopViewsAlreadyMove: " + i);
        }
        RelativeLayout relativeLayout = this.j;
        if (relativeLayout == null || relativeLayout.getLayoutParams() == null) {
            return false;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.j.getLayoutParams();
        return i == 2 ? marginLayoutParams.leftMargin > JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_cp_icon_edge_margin) : marginLayoutParams.topMargin > JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_cp_icon_edge_margin);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void a(int i, g.a aVar) {
        CircleProgressImageView[] circleProgressImageViewArr = this.D;
        if (circleProgressImageViewArr == null || i < 0 || i >= circleProgressImageViewArr.length) {
            y(false);
            return;
        }
        if (aVar == null) {
            return;
        }
        int i2 = aVar.f7468a;
        if (i2 == 1) {
            LogUtil.e("RGMMAssistGuideView", "AssistantIconUpdate UPDATE_TYPE_SHOW! nAssistType:" + aVar.b + ",nSpeed:" + aVar.c);
            b(i, aVar);
            return;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                return;
            }
            LogUtil.e("RGMMAssistGuideView", "AssistantIconUpdate UPDATE_TYPE_HIDE! nAssistType:" + aVar.b + ",nSpeed:" + aVar.c);
            this.D[i].setVisibility(8);
            return;
        }
        LogUtil.e("RGMMAssistGuideView", "AssistantIconUpdate UPDATE_TYPE_UPDATE! nAssistType:" + aVar.b + ",nSpeed:" + aVar.c);
        d(i, aVar.d);
        if (RouteGuideParams.NavState.NAV_STATE_NAVING.equals(com.baidu.navisdk.ui.routeguide.model.g.h().b())) {
            this.D[i].setVisibility(0);
        } else {
            this.D[i].setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void a(int i, boolean z) {
        a0 a0Var;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMAssistGuideView", "setIntervalCameraVisibility, visibility = " + i + ", withAnim = " + z);
        }
        if (!this.m && BNSettingManager.isMeasurementEnable()) {
            if (this.i == null || this.f9165a == null) {
                if (gVar.c()) {
                    gVar.c("RGMMAssistGuideView", "setIntervalCameraVisibility, mAssistPanel == " + this.i + ", mContext == " + this.f9165a);
                    return;
                }
                return;
            }
            if (i != 0) {
                if (i != 8 || (a0Var = this.k) == null) {
                    return;
                }
                if (z) {
                    if (!a0Var.a()) {
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("RGMMAssistGuideView", "setIntervalCameraVisibility->is Gone,return!");
                            return;
                        }
                        return;
                    }
                    this.k.a(new c());
                    return;
                }
                a0Var.c();
                b(0);
                return;
            }
            if (!com.baidu.navisdk.module.pronavi.model.g.o().g()) {
                if (gVar.d()) {
                    gVar.e("RGMMAssistGuideView", "setIntervalCameraVisibility, 此时没有间测速");
                    return;
                }
                return;
            }
            if (this.k == null) {
                this.k = new a0(this.f9165a, this.i);
            }
            if (!RouteGuideFSM.getInstance().isEqualCurrentState(RGFSMTable.FsmState.SimpleGuide, RGFSMTable.FsmState.EnlargeRoadmap)) {
                if (gVar.d()) {
                    gVar.e("RGMMAssistGuideView", "setIntervalCameraVisibility, 不是简易诱导状态，getCurrentState：" + RouteGuideFSM.getInstance().getCurrentState());
                    return;
                }
                return;
            }
            b(8);
            this.k.y();
            r();
            this.k.x0();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void b(int i) {
        a1 a1Var = this.l;
        if (a1Var != null ? a1Var.b(i) : false) {
            r();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void b(int i, int i2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMAssistGuideView", "updateTruckAvoidanceReminderPanel type=" + i + ", dist=" + i2);
        }
        n1 n1Var = this.n;
        if (n1Var != null) {
            n1Var.d(i, i2);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d, com.baidu.navisdk.framework.interfaces.y
    public View[] B() {
        View n0;
        ArrayList arrayList = new ArrayList(5);
        m1 m1Var = this.A;
        if (m1Var != null && (n0 = m1Var.n0()) != null && n0.isShown()) {
            arrayList.add(n0);
        }
        View view = this.t;
        if (view != null && view.isShown()) {
            arrayList.add(this.t);
        }
        ViewGroup viewGroup = this.w;
        if (viewGroup != null && viewGroup.isShown()) {
            arrayList.add(this.w);
        }
        RelativeLayout relativeLayout = this.j;
        if (relativeLayout != null && relativeLayout.isShown()) {
            arrayList.add(this.j);
        }
        i1 i1Var = this.y;
        if (i1Var != null && i1Var.o0()) {
            arrayList.add(this.y.n0());
        }
        return (View[]) arrayList.toArray(new View[arrayList.size()]);
    }

    private void b(int i, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMAssistGuideView", "resetLeftViewsLocation:" + i);
        }
        com.baidu.navisdk.ui.routeguide.utils.b.a(this.j, 0, "left", z);
    }

    public void B(int i) {
        G(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2, boolean z, boolean z2) {
        if (this.j == null) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMAssistGuideViewCollision", "updateLeftTopLayoutMarginTop -> delayTime= " + j2 + " isRetry=" + z + "," + z2);
        }
        Runnable runnable = this.K;
        if (runnable == null) {
            this.K = new f(z);
        } else {
            this.j.removeCallbacks(runnable);
        }
        if (z2) {
            this.j.postDelayed(this.K, j2);
        } else {
            this.K.run();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void a(Bundle bundle) {
        if (this.k != null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMAssistGuideView", "updateIntervalCameraData, data = " + bundle.toString());
            }
            this.k.d(bundle);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void a(int i) {
        if (this.r) {
            i = 8;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMAssistGuideView", "setTopRightLayoutVisibility->" + i);
        }
        RelativeLayout relativeLayout = this.q;
        if (relativeLayout == null || relativeLayout.getVisibility() == i) {
            return;
        }
        if (i == 0) {
            if (B0()) {
                return;
            }
            this.q.setVisibility(0);
            return;
        }
        this.q.setVisibility(8);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.b
    public void a(int i, int i2) {
        if (this.p) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMMAssistGuideView", "用户主动关闭货车避让面板");
                return;
            }
            return;
        }
        if (com.baidu.navisdk.module.vehiclemanager.b.i().b() != 3) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMMAssistGuideView", "showTruckAvoidanceReminderPanel false!Vehicle=" + com.baidu.navisdk.module.vehiclemanager.b.i().b());
                return;
            }
            return;
        }
        if (!com.baidu.navisdk.module.pronavi.model.g.o().h()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMMAssistGuideView", "showTruckAvoidanceReminderPanel false!当前没有货车避让信息");
                return;
            }
            return;
        }
        if (!RouteGuideFSM.getInstance().getCurrentState().equals(RGFSMTable.FsmState.SimpleGuide)) {
            LogUtil.e("RGMMAssistGuideView", "showTruckAvoidanceReminderPanel, 不是简易诱导状态，getCurrentState：" + RouteGuideFSM.getInstance().getTopState());
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMMAssistGuideView", "showTruckAvoidanceReminderPanel->type=" + i + ", dist=" + i2);
        }
        if (this.n == null && this.o != null) {
            this.n = new n1(this.f9165a, this.o);
        }
        if (this.n == null || !BNSettingManager.isAvoidanceReminderVisible()) {
            return;
        }
        this.n.y();
        this.n.d(i, i2);
    }
}
