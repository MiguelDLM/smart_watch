package com.baidu.navisdk.comapi.commontool;

import android.content.Context;
import android.os.Bundle;
import com.baidu.navisdk.adapter.BNaviCommonParams;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.e0;
import com.baidu.navisdk.util.db.b;
import com.baidu.navisdk.util.logic.g;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class c {
    public static int c = 1;
    public static int d = 2;
    public static int e = 3;

    /* renamed from: a, reason: collision with root package name */
    private boolean f6704a;
    private b b;

    /* loaded from: classes7.dex */
    public class a implements b.InterfaceC0494b {
        public a() {
        }

        @Override // com.baidu.navisdk.util.db.b.InterfaceC0494b
        public void a() {
            RoutePlanNode routePlanNode;
            ArrayList<RoutePlanNode> b = com.baidu.navisdk.util.db.model.a.d().b();
            if (LogUtil.LOGGABLE && b != null) {
                for (int i = 0; i < b.size(); i++) {
                    LogUtil.e("RecoverNaviHelper", "onQuerySuccess node:" + b.get(i));
                }
            }
            if (b != null && b.size() > 0) {
                GeoPoint c = g.j().c();
                if (c != null) {
                    routePlanNode = new RoutePlanNode(c, 3, "我的位置", null);
                } else {
                    routePlanNode = null;
                }
                if (routePlanNode != null) {
                    b.add(0, routePlanNode);
                    if (c.this.b != null) {
                        c.this.b.a(b, c.this.a());
                        return;
                    }
                }
            }
            if (c.this.b != null) {
                c.this.b.a(null, null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(ArrayList<RoutePlanNode> arrayList, Bundle bundle);
    }

    /* renamed from: com.baidu.navisdk.comapi.commontool.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0180c {

        /* renamed from: a, reason: collision with root package name */
        private static c f6706a = new c(null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c c() {
        return C0180c.f6706a;
    }

    public synchronized void b() {
        try {
            if (!this.f6704a) {
                try {
                    com.baidu.navisdk.util.db.b.a(com.baidu.navisdk.framework.a.c().a());
                    this.f6704a = true;
                    LogUtil.e("RecoverNaviHelper", "onCreateView db");
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private c() {
        this.f6704a = false;
        new a();
        this.b = null;
    }

    public void a(ArrayList<RoutePlanNode> arrayList, int i, int i2, int i3) {
        if (!this.f6704a) {
            b();
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RecoverNaviHelper", "addLastNaviPointsToDB vehicle:" + i + ", " + i2 + ",prefer:" + i3);
            if (arrayList != null) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    LogUtil.e("RecoverNaviHelper", "addLastNaviPointsToDB node:" + arrayList.get(i4));
                }
            }
        }
        com.baidu.navisdk.util.db.b.a(arrayList);
        e0.a(com.baidu.navisdk.framework.a.c().a()).b("pref_navi_vehicle_type", i);
        e0.a(com.baidu.navisdk.framework.a.c().a()).b("pref_navi_recover_sub_vehicle", i2);
        e0.a(com.baidu.navisdk.framework.a.c().a()).b("pref_navi_recover_prefer", i3);
        Bundle bundle = new Bundle();
        BNRoutePlaner.getInstance().c(bundle);
        e0.a(com.baidu.navisdk.framework.a.c().a()).b("pref_navi_recover_session_id", bundle.getString("session"));
        e0.a(com.baidu.navisdk.framework.a.c().a()).b("pref_navi_recover_mrsl", bundle.getString("mrsl"));
    }

    public void c(Context context) {
        e0.a(context).b("navi_bg_flag", false);
    }

    public void b(Context context) {
        e0.a(context).b("navi_bg_flag", true);
    }

    public void a(RoutePlanNode routePlanNode) {
        if (!this.f6704a) {
            b();
        }
        com.baidu.navisdk.util.db.b.a(routePlanNode);
    }

    public void a(Context context, int i) {
        if (context == null) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("NaviRecoveryManager", "setNaviFlag:" + i);
        }
        if ((i == d || i == e) && a(context) != c) {
            return;
        }
        if (i == d && a(context) == e) {
            return;
        }
        e0.a(context).b("pref_navi_flag_new", i);
    }

    public int a(Context context) {
        if (context == null) {
            return 0;
        }
        return e0.a(context).a("pref_navi_flag_new", 0);
    }

    public void a(Context context, long j) {
        if (context == null) {
            LogUtil.e("RecoverNaviHelper", "setKilledTime --> context is null!!!");
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("NaviRecoveryManager", "setKilledTime --> time is " + j);
        }
        e0.a(context).b("navi_kill_time_pref", j);
    }

    public Bundle a() {
        e0 a2 = e0.a(com.baidu.navisdk.framework.a.c().a());
        Bundle bundle = new Bundle();
        bundle.putInt("vehicle", a2.a("pref_navi_vehicle_type", 1));
        bundle.putInt(BNaviCommonParams.RoutePlanKey.SUB_VEHICLE, a2.a("pref_navi_recover_sub_vehicle", 0));
        bundle.putString("calc_session", a2.a("pref_navi_recover_session_id", ""));
        bundle.putString("calc_mrsl", a2.a("pref_navi_recover_mrsl", ""));
        if (a2.a("pref_navi_recover_prefer")) {
            bundle.putInt("prefer_value", a2.a("pref_navi_recover_prefer", 1));
        }
        return bundle;
    }
}
