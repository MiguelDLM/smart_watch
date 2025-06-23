package com.baidu.navisdk.ui.routeguide.utils;

import OX00o0X.oO;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.behavrules.scene.c;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.g0;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.h1;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.i0;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.l;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.ui.routeguide.utils.d;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.garmin.fit.OxXXx0X;
import com.google.android.exoplayer2.ExoPlayer;
import com.sma.smartv3.initializer.IXxxXO;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static String f9154a = "DebugGate";
    private static SoftReference<TextView> c;
    private static int p;
    private static WeakReference<com.baidu.navisdk.module.vmsr.b> u;
    public static boolean b = LogUtil.LOGGABLE;
    private static int d = 0;
    private static int e = 5;
    private static int f = 1;
    private static boolean g = false;
    private static int h = 0;
    private static int i = 0;
    private static boolean j = false;
    private static h1 k = null;
    private static com.baidu.navisdk.ui.routeguide.mapmode.subview.u l = null;
    private static TextView m = null;
    private static f1<String, com.baidu.navisdk.ui.routeguide.utils.e> n = new f1<>();
    public static int o = 0;
    private static int q = 0;
    private static boolean r = false;
    private static int s = 1;
    private static int t = 0;

    /* loaded from: classes8.dex */
    public class a implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            int i = c.q % 2;
            c.r();
            com.baidu.navisdk.vi.b.a(4623, i, -3456);
        }
    }

    /* loaded from: classes8.dex */
    public class a0 implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            com.baidu.navisdk.framework.interfaces.pronavi.i iVar;
            com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
            if (h != null) {
                iVar = h.C();
            } else {
                iVar = null;
            }
            if (iVar != null) {
                iVar.n();
                iVar.k();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a1 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.y();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            if (RGLaneInfoModel.getModel(false).needDisplay == 0) {
                RGLaneInfoModel.getModel(false).needDisplay = 1;
            } else {
                RGLaneInfoModel.getModel(false).needDisplay = 0;
            }
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "车道线云控--- " + RGLaneInfoModel.getModel(false).needDisplay);
        }
    }

    /* loaded from: classes8.dex */
    public class b0 implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            Context a2 = com.baidu.navisdk.framework.a.c().a();
            com.baidu.navisdk.util.logic.c.k().i();
            com.baidu.navisdk.util.logic.j.r().n();
            com.baidu.navisdk.util.logic.c.k().a(a2);
        }
    }

    /* loaded from: classes8.dex */
    public class b1 implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            Bundle bundle = new Bundle();
            bundle.putInt("key_type_show_views", 7);
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.ENTRY_DYNAMIC_LAYER, bundle);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.utils.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0486c implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            if (BNSettingManager.isArRecordEnable()) {
                BNSettingManager.setArRecord(false);
            } else {
                BNSettingManager.setArRecord(true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c0 implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
        }
    }

    /* loaded from: classes8.dex */
    public class c1 implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            BNMapController.getInstance().setACEParkViewMode(c.p);
            if (c.p == 1) {
                int unused = c.p = 2;
            } else {
                int unused2 = c.p = 1;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            if (BNSettingManager.isArMockEnable()) {
                BNSettingManager.setArMock(false);
            } else {
                BNSettingManager.setArMock(true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d0 implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            com.baidu.navisdk.module.vmsr.c.f().a(true);
        }
    }

    /* loaded from: classes8.dex */
    public class d1 implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            com.baidu.navisdk.vi.b.a(4504, 1, -3456);
        }
    }

    /* loaded from: classes8.dex */
    public class e implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            boolean z = !com.baidu.navisdk.module.cloudconfig.a.b().a("NAVI_SUPPORT_NEW_BTN", true);
            com.baidu.navisdk.module.cloudconfig.a.b().c("NAVI_SUPPORT_NEW_BTN", z);
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "按钮集云控--- " + z);
        }
    }

    /* loaded from: classes8.dex */
    public class e0 implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            TTSPlayerControl.playTTSText("嗒嗒嗒", null, 1);
        }
    }

    /* loaded from: classes8.dex */
    public class e1 implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            com.baidu.navisdk.ui.routeguide.control.d.e.b(null);
        }
    }

    /* loaded from: classes8.dex */
    public class f implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            String str;
            com.baidu.navisdk.vi.b.a(4500, c.s, 2252);
            com.baidu.navisdk.module.cloudconfig.f.c().r.f7116a = !com.baidu.navisdk.module.cloudconfig.f.c().r.f7116a;
            com.baidu.navisdk.module.cloudconfig.a.b().c("NAVI_SUPPORT_NEW_BTN", com.baidu.navisdk.module.cloudconfig.f.c().r.f7116a);
            Context a2 = com.baidu.navisdk.framework.a.c().a();
            StringBuilder sb = new StringBuilder();
            if (c.s == 1) {
                str = "进入";
            } else {
                str = "退出";
            }
            sb.append(str);
            sb.append("---智慧高速");
            TipTool.onCreateToastDialog(a2, sb.toString());
            if (c.s == 1) {
                int unused = c.s = 2;
            } else {
                int unused2 = c.s = 1;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f0 implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                com.baidu.navisdk.ui.routeguide.model.a0.F = !com.baidu.navisdk.ui.routeguide.model.a0.F;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class f1<StringT, DebugLogicT> extends HashMap {

        /* renamed from: a, reason: collision with root package name */
        ArrayList<String> f9155a = new ArrayList<>();

        @Nullable
        public Object a(String str, Object obj) {
            if (str != null && !this.f9155a.contains(str)) {
                this.f9155a.add(str);
            }
            return super.put(str, obj);
        }
    }

    /* loaded from: classes8.dex */
    public class g implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            String str;
            com.baidu.navisdk.ui.routeguide.model.d.f = !com.baidu.navisdk.ui.routeguide.model.d.f;
            Context a2 = com.baidu.navisdk.framework.a.c().a();
            StringBuilder sb = new StringBuilder();
            sb.append("充电站提示条--- ");
            if (com.baidu.navisdk.ui.routeguide.model.d.f) {
                str = "开";
            } else {
                str = "关";
            }
            sb.append(str);
            TipTool.onCreateToastDialog(a2, sb.toString());
        }
    }

    /* loaded from: classes8.dex */
    public class g0 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes8.dex */
    public class h implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            com.baidu.navisdk.vi.b.a(OxXXx0X.Xx0OXIoI, 10, -3456);
        }
    }

    /* loaded from: classes8.dex */
    public class h0 implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            com.baidu.navisdk.vi.b.a(4172, 14, 100);
        }
    }

    /* loaded from: classes8.dex */
    public class i implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            TTSPlayerControl.stopVoiceTTSOutput();
        }
    }

    /* loaded from: classes8.dex */
    public class i0 implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            String str;
            boolean z = com.baidu.navisdk.ui.routeguide.control.n.h;
            com.baidu.navisdk.ui.routeguide.control.n.h = !z;
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                Context a2 = com.baidu.navisdk.framework.a.c().a();
                StringBuilder sb = new StringBuilder();
                sb.append("车道线--- ");
                if (!z) {
                    str = "开";
                } else {
                    str = "关";
                }
                sb.append(str);
                TipTool.onCreateToastDialog(a2, sb.toString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            String str;
            if (!c.r) {
                com.baidu.navisdk.vi.b.a(4405, 10, -3456);
            } else {
                com.baidu.navisdk.vi.b.a(4405, -1, -3456);
            }
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                Context a2 = com.baidu.navisdk.framework.a.c().a();
                StringBuilder sb = new StringBuilder();
                sb.append("限速值--- ");
                if (c.r) {
                    str = "关";
                } else {
                    str = "10";
                }
                sb.append(str);
                TipTool.onCreateToastDialog(a2, sb.toString());
            }
            boolean unused = c.r = !c.r;
        }
    }

    /* loaded from: classes8.dex */
    public class j0 implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            String str;
            com.baidu.navisdk.ui.routeguide.model.t.v = !com.baidu.navisdk.ui.routeguide.model.t.v;
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                Context a2 = com.baidu.navisdk.framework.a.c().a();
                StringBuilder sb = new StringBuilder();
                sb.append("极端天气面板--- ");
                if (com.baidu.navisdk.ui.routeguide.model.t.v) {
                    str = "开";
                } else {
                    str = "关";
                }
                sb.append(str);
                TipTool.onCreateToastDialog(a2, sb.toString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements d.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.ui.routeguide.utils.d f9156a;

        public k(com.baidu.navisdk.ui.routeguide.utils.d dVar) {
            this.f9156a = dVar;
        }

        @Override // com.baidu.navisdk.ui.routeguide.utils.d.b
        public void a(View view, int i) {
            this.f9156a.a().get(this.f9156a.b().get(i)).a();
        }
    }

    /* loaded from: classes8.dex */
    public class k0 implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            BNRoutePlaner.getInstance().i = true;
        }
    }

    /* loaded from: classes8.dex */
    public class l implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            com.baidu.navisdk.pronavi.test.a.d.a().a();
        }
    }

    /* loaded from: classes8.dex */
    public class l0 implements com.baidu.navisdk.ui.routeguide.utils.e {

        /* loaded from: classes8.dex */
        public class a implements l.j {
            public a(l0 l0Var) {
            }

            @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.l.j
            public void a() {
            }

            @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.l.j
            public void b() {
                com.baidu.navisdk.ui.routeguide.control.s.T().c(108);
            }

            @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.l.j
            public void a(int i) {
            }

            @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.l.j
            public void a(int i, l.i iVar) {
            }
        }

        /* loaded from: classes8.dex */
        public class b extends g0.f {
            public b(l0 l0Var) {
            }

            @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
            public void a() {
                com.baidu.navisdk.ui.routeguide.control.x.b().I().a(8);
            }

            @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
            public void b() {
                com.baidu.navisdk.ui.routeguide.control.x.b().I().a(0);
            }

            @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
            public void c() {
            }

            @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
            public void d() {
                com.baidu.navisdk.ui.routeguide.control.x.b().I().a(8);
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            ArrayList arrayList = new ArrayList();
            Resources resources = JarUtils.getResources();
            int i = R.drawable.nsdk_type_default_dangerous;
            arrayList.add(new l.i(resources.getDrawable(i), null, "正常"));
            arrayList.add(new l.i(JarUtils.getResources().getDrawable(i), null, "长长长长长长长长长长长长长长长长长长长长长长长长长长长长长长"));
            arrayList.add(new l.i(JarUtils.getResources().getDrawable(i), null, "凑数"));
            com.baidu.navisdk.ui.routeguide.mapmode.subview.l a2 = com.baidu.navisdk.ui.routeguide.control.x.b().a(new com.baidu.navisdk.ui.routeguide.model.e().c(108).d(10000).b("测试拥堵面板UI").a(arrayList).a(new a(this)));
            a2.a(new b(this));
            a2.y();
        }
    }

    /* loaded from: classes8.dex */
    public class m implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            int i = c.q % 4;
            c.r();
            if (i == 3) {
                i = 2;
            }
            com.baidu.navisdk.vi.b.a(4483, i, -3456);
        }
    }

    /* loaded from: classes8.dex */
    public class m0 implements com.baidu.navisdk.ui.routeguide.utils.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f9157a;
        final /* synthetic */ ViewGroup b;

        public m0(Context context, ViewGroup viewGroup) {
            this.f9157a = context;
            this.b = viewGroup;
        }

        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            com.baidu.navisdk.ui.routeguide.control.x.b().E1();
            int i = c.h % 3;
            if (c.l == null) {
                com.baidu.navisdk.ui.routeguide.mapmode.subview.u unused = c.l = new com.baidu.navisdk.ui.routeguide.mapmode.subview.u(this.f9157a, this.b, null);
            }
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        c.l.x0();
                        com.baidu.navisdk.ui.routeguide.control.x.b().E4();
                    }
                } else {
                    c.l.y();
                    c.l.f("长长长长长长长长长得不得了");
                }
            } else {
                c.l.y();
                c.l.f("第一次，还没想好测啥");
            }
            c.f();
        }
    }

    /* loaded from: classes8.dex */
    public class n implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            com.baidu.navisdk.vi.b.a(4444, 0, 0);
        }
    }

    /* loaded from: classes8.dex */
    public class n0 implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            if (!c.g) {
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().k5();
            } else {
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().j5();
            }
            boolean unused = c.g = !c.g;
        }
    }

    /* loaded from: classes8.dex */
    public class o implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), c.b("close"));
        }
    }

    /* loaded from: classes8.dex */
    public class o0 implements com.baidu.navisdk.ui.routeguide.utils.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f9158a;
        final /* synthetic */ ViewGroup b;

        public o0(Context context, ViewGroup viewGroup) {
            this.f9158a = context;
            this.b = viewGroup;
        }

        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            com.baidu.navisdk.ui.routeguide.control.x.b().E1();
            int i = c.i % 3;
            if (c.k == null) {
                h1 unused = c.k = new h1(this.f9158a, this.b, null);
            }
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        c.k.c();
                        com.baidu.navisdk.ui.routeguide.control.x.b().E4();
                    }
                } else {
                    c.k.y();
                    c.k.f("路名我太长了太长了太长了太长了");
                }
            } else {
                c.k.y();
                c.k.f("第一次点击");
            }
            c.j();
        }
    }

    /* loaded from: classes8.dex */
    public class p implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), c.b("all_scene"));
        }
    }

    /* loaded from: classes8.dex */
    public class p0 implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            String str;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d() && gVar.e()) {
                com.baidu.navisdk.module.roadcondition.a.f = !com.baidu.navisdk.module.roadcondition.a.f;
                Context a2 = com.baidu.navisdk.framework.a.c().a();
                StringBuilder sb = new StringBuilder();
                sb.append("路况条--- ");
                if (com.baidu.navisdk.module.roadcondition.a.f) {
                    str = "开";
                } else {
                    str = "关";
                }
                sb.append(str);
                TipTool.onCreateToastDialog(a2, sb.toString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            c.B();
        }
    }

    /* loaded from: classes8.dex */
    public class q0 implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d() && gVar.e()) {
                int i = c.o + 1;
                c.o = i;
                c.o = i % 5;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            com.baidu.navisdk.ui.routeguide.control.s.T().a("测试", "123456");
        }
    }

    /* loaded from: classes8.dex */
    public class r0 implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            com.baidu.navisdk.framework.a.c().b().startActivityForResult(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), 4109);
        }
    }

    /* loaded from: classes8.dex */
    public class s implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            c.F();
        }
    }

    /* loaded from: classes8.dex */
    public class s0 implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            String str;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d() && gVar.e()) {
                boolean unused = c.j = !c.j;
                com.baidu.navisdk.vi.b.a(4621, c.j ? 1 : 0, 10001);
                Context a2 = com.baidu.navisdk.framework.a.c().a();
                StringBuilder sb = new StringBuilder();
                sb.append("高精导航--- ");
                if (c.j) {
                    str = "开";
                } else {
                    str = "关";
                }
                sb.append(str);
                TipTool.onCreateToastDialog(a2, sb.toString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            com.baidu.navisdk.ui.routeguide.control.s.T().a(false);
        }
    }

    /* loaded from: classes8.dex */
    public class t0 implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            String str;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d() && gVar.e()) {
                com.baidu.navisdk.ui.routeguide.control.x.b().d(!com.baidu.navisdk.ui.routeguide.model.a0.I().A() ? 1 : 0);
                Context a2 = com.baidu.navisdk.framework.a.c().a();
                StringBuilder sb = new StringBuilder();
                sb.append("驶出诱导面板--- ");
                if (com.baidu.navisdk.ui.routeguide.model.a0.I().A()) {
                    str = "开";
                } else {
                    str = "关";
                }
                sb.append(str);
                TipTool.onCreateToastDialog(a2, sb.toString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class u implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            com.baidu.navisdk.ui.routeguide.control.i.g().a(new com.baidu.navisdk.ui.routeguide.mapmode.subview.d(null));
        }
    }

    /* loaded from: classes8.dex */
    public class u0 implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d() && gVar.e()) {
                com.baidu.navisdk.ui.routeguide.control.a.d().a("前方存在事故吗？", "12345", 127, (com.baidu.navisdk.ui.routeguide.mapmode.subview.l) null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class v implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f9159a;
        final /* synthetic */ Button b;

        public v(ViewGroup viewGroup, Button button) {
            this.f9159a = viewGroup;
            this.b = button;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f9159a.getVisibility() == 8) {
                this.f9159a.setVisibility(0);
                this.b.setText("Debug收起");
            } else {
                this.f9159a.setVisibility(8);
                this.b.setText("Debug");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class v0 implements i0.f {
        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
        }
    }

    /* loaded from: classes8.dex */
    public class w implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            c.A();
        }
    }

    /* loaded from: classes8.dex */
    public class w0 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.navisdk.vi.b.a(4172, 7, 100);
        }
    }

    /* loaded from: classes8.dex */
    public class x implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            c.C();
        }
    }

    /* loaded from: classes8.dex */
    public class x0 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.navisdk.vi.b.a(oO.f1954oIX0oI, c.e, -113);
            if (c.e == 5) {
                int unused = c.e = 1;
                return;
            }
            if (c.e == 1) {
                int unused2 = c.e = 2;
                return;
            }
            if (c.e == 2) {
                int unused3 = c.e = 3;
                return;
            }
            if (c.e == 3) {
                int unused4 = c.e = 4;
            } else if (c.e == 4) {
                int unused5 = c.e = 0;
            } else if (c.e == 0) {
                int unused6 = c.e = 5;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class y implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            com.baidu.navisdk.module.pronavi.model.g.o().e(false);
            com.baidu.navisdk.ui.routeguide.control.x.b().I().u();
        }
    }

    /* loaded from: classes8.dex */
    public class y0 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            int i = 2;
            if (c.d % 2 == 0) {
                i = 1;
            }
            com.baidu.navisdk.vi.b.a(4420, i, 7);
            c.o();
        }
    }

    /* loaded from: classes8.dex */
    public class z implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            c.z();
        }
    }

    /* loaded from: classes8.dex */
    public class z0 implements com.baidu.navisdk.ui.routeguide.utils.e {
        @Override // com.baidu.navisdk.ui.routeguide.utils.e
        public void a() {
            if (c.t > 7) {
                int unused = c.t = 0;
            }
            if (c.t == 0) {
                com.baidu.navisdk.vi.b.a(4500, 1, 2251);
            } else if (c.t == 1) {
                com.baidu.navisdk.vi.b.a(4500, 3, 0);
                com.baidu.navisdk.vi.b.a(4501, 3, 99);
                com.baidu.navisdk.vi.b.a(4502, 20, 100);
            } else if (c.t == 2) {
                com.baidu.navisdk.vi.b.a(4501, 3, 0);
            } else if (c.t == 3) {
                com.baidu.navisdk.vi.b.a(4501, 4, 10);
            } else if (c.t == 4) {
                com.baidu.navisdk.vi.b.a(4501, 2, 9);
            } else if (c.t == 5) {
                com.baidu.navisdk.vi.b.a(4500, 4, 0);
            } else if (c.t == 6) {
                com.baidu.navisdk.vi.b.a(4500, 2, 2251);
            }
            c.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void A() {
        com.baidu.navisdk.util.common.n.d().a().postDelayed(new w0(), 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void B() {
        com.baidu.navisdk.util.common.n.d().a().postDelayed(new x0(), 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void C() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.c a2 = com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.c.a(BNRouteGuider.getInstance().getDestRecommendInfo());
        BNRoutePlaner.getInstance().o();
        com.baidu.navisdk.ui.routeguide.control.x.b().m1();
        BNRouteGuider.getInstance().stopRouteGuide();
        com.baidu.navisdk.ui.routeguide.asr.c.n().l();
        com.baidu.navisdk.module.powersavemode.f.o().h();
        if (RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.Voice)) {
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.VOICE_STATE_EXIT);
        }
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_ENTER_ARRIVE_DEST);
        com.baidu.navisdk.ui.routeguide.control.x.b().l3();
        com.baidu.navisdk.ugc.interaction.c.a().a(2);
        BNRoutePlaner.getInstance().p(10);
        com.baidu.navisdk.ui.routeguide.control.i.g().a(new com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.b(com.baidu.navisdk.ui.routeguide.b.V().c(), a2));
    }

    public static void D() {
        com.baidu.navisdk.module.vmsr.b bVar;
        WeakReference<com.baidu.navisdk.module.vmsr.b> weakReference = u;
        if (weakReference != null && (bVar = weakReference.get()) != null) {
            bVar.hide();
        }
    }

    public static void E() {
        com.baidu.navisdk.module.vmsr.b bVar;
        WeakReference<com.baidu.navisdk.module.vmsr.b> weakReference = u;
        if (weakReference == null) {
            bVar = null;
        } else {
            bVar = weakReference.get();
        }
        if (bVar == null) {
            bVar = new com.baidu.navisdk.module.vmsr.b(com.baidu.navisdk.ui.routeguide.b.V().b());
            u = new WeakReference<>(bVar);
        }
        bVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void F() {
        com.baidu.navisdk.ui.routeguide.control.x.b().k(115).d(JarUtils.getResources().getDrawable(R.drawable.nsdk_notification_scenic_broadcast)).D(100).v(20000).a("播报景区简介将暂停导航播报，仅播提示音").z(2).b("点击播放开始播报终点景区介绍").g("开始播放").f("取消").a(new v0()).y();
    }

    public static /* synthetic */ int b() {
        int i2 = t;
        t = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int f() {
        int i2 = h;
        h = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int j() {
        int i2 = i;
        i = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int o() {
        int i2 = d;
        d = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int r() {
        int i2 = q;
        q = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void y() {
        com.baidu.navisdk.behavrules.sp.b.a(com.baidu.navisdk.framework.a.c().a()).a();
        for (com.baidu.navisdk.behavrules.scene.c cVar : com.baidu.navisdk.behavrules.c.c().b()) {
            cVar.a(c.a.TIME_DIFF);
            cVar.a(c.a.BY_SCENESET);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void z() {
        com.baidu.navisdk.util.common.n.d().a().postDelayed(new y0(), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    public static void e(int i2) {
        TextView textView = m;
        if (textView != null) {
            textView.setText("发热等级: " + i2);
        }
    }

    public static void f(int i2) {
        f = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        com.baidu.navisdk.pronavi.hd.normal.i.a aVar;
        com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b bVar;
        com.baidu.navisdk.ui.routeguide.navicenter.c j2 = com.baidu.navisdk.ui.routeguide.b.V().j();
        String str2 = null;
        if (j2 != null) {
            bVar = j2.c(true);
            aVar = j2.d(true);
        } else {
            aVar = null;
            bVar = null;
        }
        int c2 = com.baidu.navisdk.ui.routeguide.model.a0.I().c();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(f9154a, "action : " + str + ", curRoadGrade:" + c2);
        }
        if (c2 == 0 || c2 == 1) {
            if (bVar != null) {
                str2 = bVar.a(str);
            }
        } else if (aVar != null) {
            str2 = aVar.a(str);
        }
        return TextUtils.isEmpty(str2) ? "当前路段暂不支持，请稍后再试" : str2;
    }

    public static void c(String str) {
        SoftReference<TextView> softReference;
        if (!b || (softReference = c) == null || softReference.get() == null) {
            return;
        }
        c.get().setText(f + str);
    }

    public static void a(Activity activity, ViewGroup viewGroup, int... iArr) {
        if (b && viewGroup != null) {
            ViewStub viewStub = (ViewStub) viewGroup.findViewById(R.id.open_the_door_for_me);
            if (viewStub == null) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e(f9154a, "debug: stub == null");
                    return;
                }
                return;
            }
            viewStub.inflate();
            Button button = (Button) viewGroup.findViewById(R.id.debug_gate_btn);
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.debug_gate_layout);
            a((Context) activity, viewGroup, iArr);
            RecyclerView recyclerView = (RecyclerView) viewGroup.findViewById(R.id.debug_recyclerview);
            com.baidu.navisdk.ui.routeguide.utils.d dVar = new com.baidu.navisdk.ui.routeguide.utils.d(n);
            recyclerView.setAdapter(dVar);
            recyclerView.setLayoutManager(new LinearLayoutManager(viewGroup.getContext()));
            dVar.a(new k(dVar));
            button.setOnClickListener(new v(viewGroup2, button));
            if (a(iArr, 3)) {
                TextView textView = (TextView) viewGroup.findViewById(R.id.open_the_door);
                textView.setVisibility(b ? 0 : 8);
                textView.setOnClickListener(new g0());
            }
            if (a(iArr, 11)) {
                a(viewGroup);
            }
            m = (TextView) viewGroup.findViewById(R.id.hot_level);
        }
    }

    private static void a(Context context, ViewGroup viewGroup, int[] iArr) {
        n.a("TrackMock", new r0());
        n.a("智能交通变！", new z0());
        n.a("强推智能停车", new b1());
        n.a("切换地图视角", new c1());
        n.a("临近停车场", new d1());
        n.a("智能终点页", new e1());
        n.a("普通路车道级", new a());
        n.a("车道线云控", new b());
        n.a("记录AR", new C0486c());
        n.a("MockAR", new d());
        n.a("按钮集云控", new e());
        n.a("智慧高速", new f());
        if (com.baidu.navisdk.ui.routeguide.b.V().D()) {
            n.a("充电站提示条开关", new g());
        }
        n.a("主线改变消息", new h());
        if (a(iArr, 1)) {
            n.a(IXxxXO.f20863oI0IIXIo, new i());
        }
        n.a("限速值10开关", new j());
        n.a("区间测速开关", new l());
        n.a("车道级导航", new m());
        n.a("护航提示", new n());
        n.a("关闭车道级", new o());
        n.a("全屏车道级", new p());
        n.a("测试VDR", new q());
        n.a("通知型消息", new r());
        n.a("操作面板", new s());
        n.a("选择型面板", new t());
        n.a("Show Card", new u());
        if (a(iArr, 2)) {
            n.a("show route", new w());
            if (a(iArr, 7)) {
                n.a("到达目的地", new x());
            }
            n.a("ugc no route", new y());
            n.a("dynamicUgcEvent", new z());
        }
        n.a("重启GPS", new a0());
        n.a("重启GPS-2", new b0());
        if (a(iArr, 4)) {
            n.a("simpleGuide", new c0());
        }
        if (a(iArr, 6)) {
            n.a("debug_卫星定位", new d0());
        }
        if (a(iArr, 8)) {
            n.a("嗒嗒嗒", new e0());
        }
        n.a("诱导路名折行", new f0());
        n.a("事故面板弹出", new h0());
        n.a("车道线", new i0());
        n.a("极端天气面板", new j0());
        n.a("IndoorParkLoc", new k0());
        n.a("测试拥堵面板UI", new l0());
        n.a("放大图UI查看", new m0(context, viewGroup));
        n.a("放大图关闭开启接口测试", new n0());
        n.a("小度语音头部信息UI查看", new o0(context, viewGroup));
        n.a("路况条", new p0());
        n.a("路况条-避开", new q0());
        n.a("高精导航", new s0());
        n.a("驶出诱导面板", new t0());
        n.a("纯语音上报", new u0());
    }

    public static void a(com.baidu.navisdk.uiframe.framework.a aVar) {
        new WeakReference(aVar);
    }

    private static boolean a(int[] iArr, int i2) {
        if (i2 == 0) {
            return true;
        }
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    private static void a(ViewGroup viewGroup) {
        TextView textView = (TextView) viewGroup.findViewById(R.id.voice_aidResponse);
        textView.setVisibility(b ? 0 : 8);
        textView.setOnClickListener(new a1());
    }
}
