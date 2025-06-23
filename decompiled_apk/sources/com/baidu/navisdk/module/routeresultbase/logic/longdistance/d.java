package com.baidu.navisdk.module.routeresultbase.logic.longdistance;

import XIXIX.OOXIXo;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.baidunavis.maplayer.i;
import com.baidu.mapframework.widget.MProgressDialog;
import com.baidu.mapframework.widget.MToast;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.j;
import com.baidu.navisdk.model.datastruct.h;
import com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.e;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.f;
import com.baidu.navisdk.util.worker.g;

/* loaded from: classes7.dex */
public class d {
    private i f;
    public int h;
    private f<String, String> y;
    private com.baidu.navisdk.util.worker.lite.b z;
    public int g = 4;
    public boolean i = false;
    public boolean j = false;
    public boolean k = false;
    public boolean l = true;
    public boolean m = false;
    public String n = "";
    public double o = OOXIXo.f3760XO;
    public int p = 1;
    public int q = 0;
    public boolean r = false;
    public int[] s = new int[5];
    private com.baidu.navisdk.module.routeresultbase.logic.longdistance.service.a t = null;
    private com.baidu.navisdk.module.routeresultbase.logic.longdistance.checkpoint.a u = null;
    public int v = 0;
    public int w = 0;
    public boolean x = true;
    private InterfaceC0288d A = null;

    /* renamed from: a, reason: collision with root package name */
    private final com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.b f7515a = new com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.b(this);
    private final com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.b b = new com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.b(this);
    private final com.baidu.navisdk.module.routeresultbase.logic.longdistance.service.b c = new com.baidu.navisdk.module.routeresultbase.logic.longdistance.service.b(this);
    private final com.baidu.navisdk.module.routeresultbase.logic.longdistance.weather.a d = new com.baidu.navisdk.module.routeresultbase.logic.longdistance.weather.a(this);
    private final com.baidu.navisdk.module.routeresultbase.logic.longdistance.checkpoint.b e = new com.baidu.navisdk.module.routeresultbase.logic.longdistance.checkpoint.b(this);

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f7516a;

        public a(boolean z) {
            this.f7516a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            boolean a2;
            d.this.y = null;
            if (d.this.A != null) {
                if (this.f7516a) {
                    d dVar = d.this;
                    i = dVar.w;
                    if (i != 0) {
                        dVar.w = 0;
                        dVar.r = false;
                    }
                    a2 = true;
                } else {
                    d dVar2 = d.this;
                    i = dVar2.w;
                    a2 = dVar2.a();
                }
                if (e.c()) {
                    if (i != 4) {
                        if (j.d()) {
                            MProgressDialog.dismiss();
                        }
                        d.this.A.a(i, a2, this.f7516a);
                    }
                } else {
                    if (j.d()) {
                        MProgressDialog.dismiss();
                    }
                    d.this.A.a(i, a2, this.f7516a);
                }
            }
            d.this.w = 0;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("NavLongDistanceController", "onMeteorDataArrive notify callback!!!");
            }
            if (d.this.A != null && e.c()) {
                d.this.A.a(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends com.baidu.navisdk.util.worker.lite.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7518a;
        final /* synthetic */ com.baidu.nplatform.comapi.basestruct.c b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, Context context, com.baidu.nplatform.comapi.basestruct.c cVar) {
            super(str);
            this.f7518a = context;
            this.b = cVar;
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            int c = com.baidu.baidunavis.maplayer.e.k().c();
            d dVar = d.this;
            if (c != dVar.g) {
                dVar.r();
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e(g.TAG, "showLongDistanceLayer --> type = " + d.this.v);
            }
            d dVar2 = d.this;
            int i = dVar2.v;
            if (i == 1) {
                dVar2.f7515a.a(this.f7518a, this.b);
                return;
            }
            if (i == 2) {
                dVar2.b.a(this.f7518a, this.b);
                return;
            }
            if (i == 3) {
                dVar2.t = dVar2.c.a(this.b);
                d.this.c.a(this.f7518a, this.b);
                return;
            }
            if (i == 4) {
                if (e.c()) {
                    d.this.d.a(this.f7518a, this.b);
                    return;
                } else {
                    d.this.d.a(this.f7518a, this.b, d.this.f7515a.b);
                    return;
                }
            }
            if (i == 5) {
                dVar2.u = dVar2.e.a(this.b);
                d.this.e.a(this.f7518a, this.b);
            } else {
                dVar2.d.b(this.f7518a, this.b);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.module.routeresultbase.logic.longdistance.d$d, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0288d {
        void a(int i, boolean z, boolean z2);

        void a(boolean z);
    }

    private boolean q() {
        if (!e.c()) {
            return n();
        }
        if (this.j && this.i) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("NavLongDistanceController", "updateDataByLevel --> mRouteNumber = " + this.p);
        }
        if (!this.i) {
            return;
        }
        double d = com.baidu.baidunavis.maplayer.e.k().d();
        if (d == OOXIXo.f3760XO) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("NavLongDistanceController", "updateDataByLevel units " + d);
        }
        this.f7515a.c.clear();
        this.b.c.clear();
        this.c.c.clear();
        this.e.c.clear();
        for (int i = 0; i < this.p; i++) {
            this.o = this.s[i] / d;
            if (LogUtil.LOGGABLE) {
                LogUtil.e("NavLongDistanceController", "updateDataByLevel --> routeIndex = " + i + ", routeDistance = " + this.s[i] + ", units = " + d + ", mCurrentLevelLength = " + this.o);
            }
            this.f7515a.a(i, this.d.b);
            this.b.a(i);
            this.c.a(i);
            this.d.a(i, this.g);
            this.d.b(i, this.g);
            this.e.a(i);
        }
        this.g = com.baidu.baidunavis.maplayer.e.k().c();
    }

    private void s() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("NavLongDistanceController", "updateOnlyDataByLevelChange --> mRouteNumber = " + this.p);
        }
        if (!this.i || com.baidu.baidunavis.maplayer.e.k().c() == this.g) {
            return;
        }
        this.f7515a.c.clear();
        this.b.c.clear();
        this.c.c.clear();
        this.e.c.clear();
        double d = com.baidu.baidunavis.maplayer.e.k().d();
        if (d == OOXIXo.f3760XO) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("NavLongDistanceController", "updateOnlyDataByLevelChange units is " + d);
        }
        for (int i = 0; i < this.p; i++) {
            this.o = this.s[i] / d;
            if (LogUtil.LOGGABLE) {
                LogUtil.e("NavLongDistanceController", "updateOnlyDataByLevelChange --> routeIndex = " + i + ", routeDistance = " + this.s[i] + ", units = " + d + ", mCurrentLevelLength = " + this.o);
            }
            this.f7515a.a(i, this.d.b);
            this.b.a(i);
            this.c.a(i);
            this.d.a(i, this.g);
            this.d.b(i, this.g);
            this.e.a(i);
        }
        this.g = com.baidu.baidunavis.maplayer.e.k().c();
    }

    public com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.b h() {
        return this.b;
    }

    public com.baidu.nplatform.comapi.basestruct.c i() {
        h d = this.d.d();
        if (d == null) {
            return null;
        }
        return d.c.d;
    }

    public com.baidu.navisdk.module.routeresultbase.logic.longdistance.service.b j() {
        return this.c;
    }

    public i k() {
        return this.f;
    }

    public com.baidu.navisdk.module.routeresultbase.logic.longdistance.weather.a l() {
        return this.d;
    }

    public void m() {
        com.baidu.navisdk.util.worker.lite.b bVar = this.z;
        if (bVar != null) {
            com.baidu.navisdk.util.worker.lite.a.a(bVar);
            this.z = null;
        }
        com.baidu.baidunavis.maplayer.e.k().f();
    }

    public boolean n() {
        if (this.k && this.i) {
            return true;
        }
        return false;
    }

    public void o() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("NavLongDistanceController", "onMeteorDataArrive()");
        }
        this.j = true;
        int c2 = com.baidu.baidunavis.maplayer.e.k().c();
        this.g = c2;
        this.d.a(this.i, c2);
        if (this.A == null) {
            return;
        }
        com.baidu.navisdk.module.routeresultbase.framework.utils.a.a("NavLongDistanceController-onMeteorDataArrive", new b());
    }

    public void p() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("NavLongDistanceController", "updateDataByRP --> mRouteNumber = " + this.p);
        }
        if (!this.i) {
            return;
        }
        this.f7515a.c.clear();
        this.b.c.clear();
        this.c.c.clear();
        this.e.c.clear();
        double d = com.baidu.baidunavis.maplayer.e.k().d();
        if (d == OOXIXo.f3760XO) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("NavLongDistanceController", "updateDataByRP --> units is " + d);
        }
        for (int i = 0; i < this.p; i++) {
            this.o = this.s[i] / d;
            if (LogUtil.LOGGABLE) {
                LogUtil.e("NavLongDistanceController", "updateDataByRP --> routeIndex = " + i + ", routeDistance = " + this.s[i] + ", units = " + d + ", mCurrentLevelLength = " + this.o);
            }
            this.f7515a.a(i, this.d.b);
            this.b.a(i);
            this.c.a(i);
            this.e.a(i);
        }
    }

    private void b(Context context, com.baidu.baidunavis.maplayer.d dVar) {
        com.baidu.nplatform.comapi.basestruct.c a2 = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(dVar);
        this.u = this.e.a(a2);
        this.e.a(context, a2);
    }

    private void g(Context context, com.baidu.baidunavis.maplayer.d dVar) {
        com.baidu.nplatform.comapi.basestruct.c a2 = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(dVar);
        this.t = this.c.a(a2);
        this.c.a(context, a2);
    }

    private void h(Context context, com.baidu.baidunavis.maplayer.d dVar) {
        this.d.a(context, com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(dVar), this.f7515a.b);
    }

    public com.baidu.navisdk.module.routeresultbase.logic.longdistance.checkpoint.b c() {
        return this.e;
    }

    public com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.b d() {
        return this.f7515a;
    }

    public com.baidu.navisdk.module.routeresultbase.logic.longdistance.checkpoint.a e() {
        return this.u;
    }

    public com.baidu.navisdk.module.routeresultbase.logic.longdistance.service.a f() {
        return this.t;
    }

    private void c(Context context, com.baidu.baidunavis.maplayer.d dVar) {
        this.f7515a.a(context, com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(dVar));
    }

    private void d(Context context, com.baidu.baidunavis.maplayer.d dVar) {
        com.baidu.nplatform.comapi.basestruct.c a2 = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(dVar);
        h a3 = this.d.a(a2);
        if (a3 != null) {
            if (a3.e()) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("2.f.7.2", "2", null, null);
            } else {
                com.baidu.navisdk.util.statistic.userop.b.r().a("2.f.7.2", "3", null, null);
            }
        }
        this.d.a(context, a2);
    }

    private void e(Context context, com.baidu.baidunavis.maplayer.d dVar) {
        com.baidu.navisdk.util.statistic.userop.b.r().a("2.f.7.2", "2", null, null);
        this.d.b(context, com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(dVar));
    }

    private void f(Context context, com.baidu.baidunavis.maplayer.d dVar) {
        this.b.a(context, com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(dVar));
    }

    public void a(i iVar) {
        this.f = iVar;
    }

    public void b(Context context) {
        int c2;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("NavLongDistanceController", "onMapLevelChanged --> context = " + context + ", mBrightTitle = " + this.n);
        }
        if (this.i) {
            if ((this.r || e.c()) && (c2 = com.baidu.baidunavis.maplayer.e.k().c()) != this.g) {
                LogUtil.e("LongDistanceNaviModel", "onMapLevelChanged mapchange is " + c2);
                s();
                com.baidu.nplatform.comapi.basestruct.c b2 = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.b(this.n);
                if (this.v == 3 && TextUtils.isEmpty(this.n)) {
                    b2 = null;
                }
                a(context, b2);
            }
        }
    }

    public String g() {
        h d = this.d.d();
        if (d == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String str = d.c.f6929a;
        String str2 = d.f.f6931a;
        h.c cVar = d.e;
        String str3 = cVar.b;
        String str4 = cVar.d;
        String str5 = cVar.e;
        if (d.f6927a == 0) {
            sb.append("途经");
            sb.append(str);
            sb.append("时有");
            sb.append(str2);
            sb.append("，请谨慎驾驶");
            return sb.toString();
        }
        boolean g = d.g();
        boolean f = d.f();
        if (g && f) {
            sb.append("预计途径");
            sb.append(str3);
            sb.append("时有");
            sb.append(str2);
            sb.append("，");
            if (!TextUtils.isEmpty(str4)) {
                sb.append(str4);
            }
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
                sb.append("且");
            }
            if (!TextUtils.isEmpty(str5)) {
                sb.append(str5);
            }
            if (!TextUtils.isEmpty(str4) || !TextUtils.isEmpty(str5)) {
                sb.append("，");
            }
            sb.append("请谨慎驾驶");
            return sb.toString();
        }
        if (g) {
            sb.append("途经");
            sb.append(str3);
            sb.append("时有");
            sb.append(str2);
            sb.append("，请谨慎驾驶");
            return sb.toString();
        }
        if (!f) {
            return "";
        }
        if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5)) {
            return "";
        }
        sb.append("预计途径");
        sb.append(str3);
        sb.append("时");
        if (!TextUtils.isEmpty(str4)) {
            sb.append(str4);
            sb.append("，");
        }
        if (!TextUtils.isEmpty(str5)) {
            sb.append(str5);
            sb.append("，");
        }
        sb.append("请谨慎驾驶");
        return sb.toString();
    }

    public void a(com.baidu.navisdk.module.routeresultbase.logic.longdistance.service.a aVar) {
        this.t = aVar;
    }

    public void a(Context context, com.baidu.baidunavis.maplayer.d dVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("NavLongDistanceController", "handleItemUpdate --> type = " + this.v + ", item = " + dVar);
        }
        int i = this.v;
        if (i == 1) {
            c(context, dVar);
            com.baidu.navisdk.util.statistic.userop.b.r().a("2.f.6", "2", null, null);
            return;
        }
        if (i == 2) {
            f(context, dVar);
            com.baidu.navisdk.util.statistic.userop.b.r().a("2.f.6", "3", null, null);
            return;
        }
        if (i == 3) {
            g(context, dVar);
            com.baidu.navisdk.util.statistic.userop.b.r().a("2.f.6", "1", null, null);
        } else {
            if (i == 4) {
                if (e.c()) {
                    d(context, dVar);
                } else {
                    h(context, dVar);
                }
                com.baidu.navisdk.util.statistic.userop.b.r().a("2.f.6", "4", null, null);
                return;
            }
            if (i == 5) {
                b(context, dVar);
            } else {
                e(context, dVar);
            }
        }
    }

    public boolean b() {
        boolean z = this.i && q();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("NavLongDistanceController", "canShowMeteorAfterArrive --> ret = " + z);
        }
        return z;
    }

    public void a(int i, Context context) {
        a(i, context, true);
    }

    public void a(int i, Context context, boolean z) {
        LogUtil.e("LongDistanceNaviModel", "onPassIconCLicked " + i + "," + this.r);
        int i2 = this.v;
        if (i2 != 4 && i2 != 0) {
            this.n = "";
        }
        com.baidu.nplatform.comapi.basestruct.c cVar = null;
        if (!this.r) {
            this.v = i;
            a(context, (com.baidu.nplatform.comapi.basestruct.c) null);
            return;
        }
        if (i2 == i && z) {
            this.v = 0;
            this.r = false;
            m();
            return;
        }
        this.v = i;
        if (i == 4 && this.d.a(this.q)) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("2.f.7.3", "2", null, null);
            cVar = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.b(this.n);
            if (this.d.b(cVar) == null) {
                cVar = i();
            }
        }
        a(context, cVar);
    }

    public void a(boolean z) {
        this.k = true;
        this.g = com.baidu.baidunavis.maplayer.e.k().c();
        p();
        if (this.A == null) {
            return;
        }
        f<String, String> fVar = this.y;
        if (fVar != null) {
            com.baidu.navisdk.module.routeresultbase.framework.utils.a.a((g<String, String>) fVar, false);
        }
        this.y = com.baidu.navisdk.module.routeresultbase.framework.utils.a.a("NavLongDistanceController-onRoutePlanArrive", new a(z));
    }

    public void a(Context context, int i) {
        com.baidu.nplatform.comapi.basestruct.c cVar;
        a(context);
        s();
        this.b.a(i);
        if (this.v == 4 && e.c()) {
            cVar = i();
            a(cVar);
        } else {
            cVar = null;
        }
        a(context, cVar);
        if (this.v == 3) {
            this.n = "";
        }
    }

    public void a(com.baidu.nplatform.comapi.basestruct.c cVar) {
        if (cVar != null) {
            this.n = cVar.d() + "," + cVar.c();
        }
    }

    public void a(Context context) {
        int i = this.v;
        if (i == 1) {
            if (this.f7515a.c()) {
                return;
            }
            if (j.d()) {
                MToast.show("沿途没有大中型城市");
                return;
            } else {
                TipTool.toast("沿途没有大中型城市");
                return;
            }
        }
        if (i == 2) {
            if (this.b.c()) {
                return;
            }
            if (j.d()) {
                MToast.show(context, "沿途没有高速");
                return;
            } else {
                TipTool.toast("沿途没有高速");
                return;
            }
        }
        if (i != 3 || this.c.c()) {
            return;
        }
        if (j.d()) {
            MToast.show(context, "沿途没有服务区");
        } else {
            TipTool.toast("沿途没有服务区");
        }
    }

    public void a(Context context, com.baidu.nplatform.comapi.basestruct.c cVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("NavLongDistanceController", "showLongDistanceLayer --> ctx = " + context + ", point = " + cVar);
            LogUtil.printCallStack();
        }
        if (BNRoutePlaner.getInstance().B()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("NavLongDistanceController", "showLongDistanceLayer --> offline route plan, force hide long distance layer!");
            }
            m();
            return;
        }
        com.baidu.navisdk.util.worker.lite.b bVar = this.z;
        if (bVar != null) {
            com.baidu.navisdk.util.worker.lite.a.a(bVar);
            this.z = null;
        }
        c cVar2 = new c("NavLongDistanceController::showLayerRunnable", context, cVar);
        this.z = cVar2;
        com.baidu.navisdk.util.worker.lite.a.c(cVar2);
    }

    public boolean a() {
        boolean z = this.i && n() && this.m;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("NavLongDistanceController", "canShowAfterArrive --> ret = " + z);
        }
        return z;
    }

    public void a(InterfaceC0288d interfaceC0288d) {
        this.A = interfaceC0288d;
    }
}
