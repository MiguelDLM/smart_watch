package com.baidu.navisdk.ui.routeguide.model;

import XIXIX.OOXIXo;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.model.datastruct.h;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes8.dex */
public class t {
    public static boolean v = false;

    /* renamed from: a, reason: collision with root package name */
    private Context f8970a;
    private int b;
    private int c;
    private String d;
    private volatile int e;
    private int f;
    private int g;
    private boolean h;
    private com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.b i;
    private final com.baidu.navisdk.module.routeresultbase.logic.longdistance.d j;
    private com.baidu.navisdk.model.datastruct.i k;
    private com.baidu.navisdk.model.datastruct.h l;
    private com.baidu.navisdk.model.datastruct.h m;
    private com.baidu.navisdk.model.datastruct.h n;
    private ArrayList<com.baidu.navisdk.model.datastruct.h> o;
    private ArrayList<com.baidu.navisdk.model.datastruct.h> p;
    private ArrayList<com.baidu.navisdk.model.datastruct.h> q;
    private final SparseArray<ArrayList<com.baidu.navisdk.model.datastruct.h>> r;
    private final SparseArray<ArrayList<com.baidu.navisdk.model.datastruct.h>> s;
    private final com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.c t;
    private final com.baidu.baidunavis.maplayer.i u;

    /* loaded from: classes8.dex */
    public class a implements com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.c {
        public a() {
        }

        @Override // com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.c
        public void a(com.baidu.navisdk.model.datastruct.i iVar) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMeteorModel", "onDataChanged --> meteorsAllRoute = " + iVar);
            }
            synchronized (t.this) {
                try {
                    t.this.v();
                    t.this.k = iVar;
                    if (t.this.k != null && !t.this.k.c()) {
                        t.this.e = BNRouteGuider.getInstance().getAddDist();
                    }
                    t tVar = t.this;
                    tVar.a(tVar.e, false);
                    if (com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.a.c().b() && t.this.f8970a != null) {
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("RGMeteorModel", "onDataChanged --> mBrightTitle = " + t.this.j.n);
                        }
                        t.this.w();
                        com.baidu.nplatform.comapi.basestruct.c b = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.b(t.this.j.n);
                        t tVar2 = t.this;
                        tVar2.a(tVar2.f8970a, t.this.b, b);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements com.baidu.baidunavis.maplayer.i {
        public b() {
        }

        @Override // com.baidu.baidunavis.maplayer.i
        public boolean a(int i) {
            return false;
        }

        @Override // com.baidu.baidunavis.maplayer.i
        public boolean a(com.baidu.nplatform.comapi.basestruct.c cVar) {
            return false;
        }

        @Override // com.baidu.baidunavis.maplayer.i
        public boolean a(int i, int i2, com.baidu.nplatform.comapi.basestruct.c cVar) {
            t.this.a(com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.a.c().a(i));
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.e.3", null, null, null);
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f8973a;

        public c(t tVar, Bundle bundle) {
            this.f8973a = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.navisdk.ui.routeguide.control.s.T().o();
            com.baidu.navisdk.ui.routeguide.control.s.T().a(this.f8973a);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8974a;

        public d(t tVar, String str) {
            this.f8974a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.e.6", "1", null, null);
            TTSPlayerControl.playTTS(this.f8974a, 0);
        }
    }

    /* loaded from: classes8.dex */
    public class e extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8975a;
        final /* synthetic */ boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, String str2, int i, boolean z) {
            super(str, str2);
            this.f8975a = i;
            this.b = z;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            t.this.b(this.f8975a, this.b);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private static final t f8976a = new t(null);
    }

    public /* synthetic */ t(a aVar) {
        this();
    }

    public static t s() {
        return f.f8976a;
    }

    private com.baidu.navisdk.model.datastruct.h t() {
        com.baidu.navisdk.model.datastruct.i iVar = this.k;
        if (iVar == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMeteorModel", "getSeriousMeteorTips --> mMeteorsAllRoute is null, return null!!!");
            }
            return null;
        }
        ArrayList<com.baidu.navisdk.model.datastruct.h> b2 = iVar.b(this.b);
        if (b2 != null && !b2.isEmpty()) {
            Iterator<com.baidu.navisdk.model.datastruct.h> it = b2.iterator();
            while (it.hasNext()) {
                com.baidu.navisdk.model.datastruct.h next = it.next();
                if (next != null && next.e()) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("RGMeteorModel", "getSeriousMeteorTips --> seriousMeteorList = " + next);
                    }
                    return next;
                }
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMeteorModel", "getSeriousMeteorTips --> no serious meteor, return null!!!");
            }
            return null;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMeteorModel", "getSeriousMeteorTips --> seriousMeteorList is empty, return null!!!");
        }
        return null;
    }

    private boolean u() {
        if (LogUtil.LOGGABLE) {
            LogUtil.printList("RGMeteorModel", "isHasWeatherData", "mCurRouteAllMeteors", this.q);
        }
        ArrayList<com.baidu.navisdk.model.datastruct.h> arrayList = this.q;
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        if (this.q.size() == 1 && this.q.get(0).f6927a == 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        Bundle bundle = new Bundle();
        BNRoutePlaner.getInstance().c(bundle);
        this.d = bundle.getString("mrsl");
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMeteorModel", "refreshCurRouteMrsl --> bundle = " + bundle + ", mainRouteMrsl = " + this.d);
        }
        com.baidu.navisdk.model.datastruct.i iVar = this.k;
        if (iVar != null) {
            this.c = iVar.a(this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void w() {
        try {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMeteorModel", "updateDataByDataChanged!!!");
            }
            com.baidu.navisdk.model.datastruct.i iVar = this.k;
            if (iVar == null) {
                return;
            }
            ArrayList<com.baidu.navisdk.model.datastruct.j> b2 = iVar.b();
            if (b2 != null && !b2.isEmpty()) {
                int c2 = com.baidu.baidunavis.maplayer.e.k().c();
                double d2 = com.baidu.baidunavis.maplayer.e.k().d();
                this.s.clear();
                if (d2 == OOXIXo.f3760XO) {
                    return;
                }
                for (int i = 0; i < b2.size(); i++) {
                    com.baidu.navisdk.model.datastruct.j jVar = b2.get(i);
                    if (jVar != null) {
                        a(i, d2, c2, jVar);
                    }
                }
                this.g = c2;
            }
        } finally {
        }
    }

    private synchronized void x() {
        try {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMeteorModel", "updateDataByLevel!!!");
            }
            if (com.baidu.baidunavis.maplayer.e.k().c() == this.g) {
                return;
            }
            w();
        } catch (Throwable th) {
            throw th;
        }
    }

    private void y() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMeteorModel", "updateWeatherPanel mCurRoadGrade: " + this.f);
        }
        if (this.f != 0) {
            return;
        }
        if (k()) {
            com.baidu.navisdk.ui.routeguide.control.x.b().Y4();
        } else {
            com.baidu.navisdk.ui.routeguide.control.x.b().w1();
        }
    }

    public boolean h() {
        com.baidu.navisdk.model.datastruct.i iVar = this.k;
        if (iVar != null && !iVar.c()) {
            return false;
        }
        return true;
    }

    public boolean i() {
        ArrayList<com.baidu.navisdk.model.datastruct.h> arrayList = this.o;
        if (arrayList != null && !arrayList.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean j() {
        return com.baidu.baidunavis.maplayer.e.k().i();
    }

    public boolean k() {
        com.baidu.navisdk.model.datastruct.h hVar;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMeteorModel", "isNeedShowWeatherPanel mCurRoadGrade:" + this.f + ", mNearestSeriousPavementMeteor: " + this.l);
        }
        if (this.f == 0 && (hVar = this.l) != null && hVar.f() && this.l.b() <= 20000 && this.l.b() > 0) {
            return true;
        }
        return false;
    }

    public boolean l() {
        return f.q.b();
    }

    public void m() {
        this.d = "";
        this.c = 0;
        this.e = 0;
        this.f = -1;
        this.q = null;
        this.o = null;
        this.p = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.j.n = "";
    }

    public void n() {
        Context context = this.f8970a;
        if (context != null) {
            a(context);
        }
    }

    public void o() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMeteorModel", "showMeteorNotification() --> isShouldShowMeteorNotification = " + this.h);
        }
        if (this.h) {
            this.h = false;
            Bundle bundle = new Bundle();
            ArrayList<Bundle> arrayList = new ArrayList<>();
            JNIGuidanceControl.getInstance().getNotificationYBarMsg(bundle, arrayList);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMeteorModel", "showMeteorNotification(), outBundle=" + bundle);
                if (arrayList.size() < 1) {
                    LogUtil.e("RGMeteorModel", "showMeteorNotification(), childList invalid");
                } else {
                    Iterator<Bundle> it = arrayList.iterator();
                    while (it.hasNext()) {
                        LogUtil.e("RGMeteorModel", "showMeteorNotification(), childList b:" + it.next());
                    }
                }
            }
            if (!bundle.isEmpty()) {
                int i = bundle.getInt("tipId", -1);
                String string = bundle.getString("mainTitle", "");
                if (!TextUtils.isEmpty(string) && i == 46) {
                    com.baidu.navisdk.module.routeresultbase.framework.utils.a.a("RGMeteorModel-showMeteorNotification", new c(this, bundle));
                    com.baidu.navisdk.module.routeresultbase.framework.utils.a.a("RGMeteorModel-playMeteorTTS", 5000L, new d(this, string));
                }
            }
        }
    }

    public void p() {
        String str;
        String str2;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMeteorModel", "showNearestSeriousMeteorNotification --> mNearestSeriousMeteor = " + this.m + ", mLastBroadcastMeteor = " + this.n);
        }
        com.baidu.navisdk.model.datastruct.h hVar = this.m;
        if (hVar == null || hVar.equals(this.n)) {
            return;
        }
        com.baidu.navisdk.model.datastruct.h hVar2 = this.m;
        int i = hVar2.d.d;
        if (i <= 50000 && i > 0 && !hVar2.equals(this.n)) {
            com.baidu.navisdk.model.datastruct.h hVar3 = this.m;
            this.n = hVar3;
            if (hVar3.f()) {
                if (!TextUtils.isEmpty(this.n.e.d)) {
                    str = this.n.e.d;
                } else {
                    if (!TextUtils.isEmpty(this.n.e.e)) {
                        str = this.n.e.e;
                    }
                    str = null;
                }
            } else {
                if (this.n.e()) {
                    str = this.n.f.f6931a;
                }
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String format = String.format("预计即将进入%s区域", str);
            if (i < 1000) {
                str2 = i + "米";
            } else {
                str2 = (i / 1000) + "公里";
            }
            String format2 = String.format("预计即将进入%s区域行驶%s，请谨慎驾驶", str, str2);
            com.baidu.navisdk.ui.routeguide.control.s.T().b(format, R.drawable.nsdk_notification_white_red_exclamation_mark);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.e.6", "2", null, null);
            TTSPlayerControl.playTTS(format2, 1);
        }
    }

    public void q() {
        f();
        m();
        this.i = null;
        this.f8970a = null;
        this.h = false;
    }

    public void r() {
        boolean l = l();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMeteorModel", "updateDataByNewData --> isOpen = " + l);
        }
        com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.b bVar = this.i;
        if (bVar != null && l) {
            bVar.a();
        }
    }

    private t() {
        this.b = -1;
        this.e = 0;
        this.f = -1;
        this.h = false;
        this.r = new SparseArray<>();
        this.s = new SparseArray<>();
        this.t = new a();
        this.u = new b();
        this.j = new com.baidu.navisdk.module.routeresultbase.logic.longdistance.d();
    }

    private void c(int i, boolean z) {
        if (z && this.k != null) {
            p();
        }
        if (com.baidu.navisdk.util.common.g.PRO_NAV.d() && v) {
            b(i);
        }
        d(i, z);
    }

    private void d(int i, boolean z) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            b(i, z);
        } else {
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new e("RGMeteorModel-updateView", null, i, z), new com.baidu.navisdk.util.worker.e(0, 2));
        }
    }

    public void b(int i, boolean z) {
        boolean z2 = com.baidu.navisdk.ui.routeguide.b.V().i().c() != null && com.baidu.navisdk.ui.routeguide.b.V().i().c().p();
        if (!z || !z2) {
            com.baidu.navisdk.ui.routeguide.control.x.b().R4();
        }
        y();
        com.baidu.navisdk.ui.routeguide.control.x.b().V(u());
    }

    public String e() {
        String str;
        com.baidu.navisdk.model.datastruct.i iVar = this.k;
        if (iVar != null) {
            str = iVar.a();
        } else {
            str = "";
        }
        return JarUtils.getResources().getString(R.string.nsdk_string_exterem_weather_update_time, str);
    }

    public void f() {
        if (j()) {
            com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.a.c().a();
            BNMapController.getInstance().showLayer(35, true);
        }
    }

    public void g() {
        if (l()) {
            com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.b bVar = new com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.b();
            this.i = bVar;
            bVar.a(this.t);
            r();
        }
    }

    public void a(boolean z) {
        this.h = z;
    }

    public synchronized void a(int i, boolean z) {
        ArrayList<com.baidu.navisdk.model.datastruct.h> a2;
        try {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMeteorModel", "updateDataByCarPoint --> carPointDistance = " + i);
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.e = i;
            com.baidu.navisdk.model.datastruct.i iVar = this.k;
            if (iVar != null) {
                Iterator<com.baidu.navisdk.model.datastruct.j> it = iVar.b().iterator();
                while (it.hasNext()) {
                    com.baidu.navisdk.model.datastruct.j next = it.next();
                    if (next != null && (a2 = next.a()) != null) {
                        Iterator<com.baidu.navisdk.model.datastruct.h> it2 = a2.iterator();
                        while (it2.hasNext()) {
                            com.baidu.navisdk.model.datastruct.h next2 = it2.next();
                            next2.b(next2.a() - i);
                            if (next2.b() <= 0) {
                                it2.remove();
                            }
                        }
                        next.a(a2);
                    }
                }
                this.q = this.k.b(this.d);
                this.o = this.k.d(this.d);
                this.p = this.k.c(this.d);
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.printList("RGMeteorModel", "updateDataByCarPoint", "mCurRouteAllMeteors", this.q);
            }
            if (com.baidu.baidunavis.maplayer.e.k().i()) {
                x();
            }
            if (this.k != null && this.q != null) {
                ArrayList<com.baidu.navisdk.model.datastruct.h> arrayList = this.o;
                if (arrayList != null && !arrayList.isEmpty()) {
                    this.l = this.o.get(0);
                } else {
                    this.l = null;
                }
                ArrayList<com.baidu.navisdk.model.datastruct.h> arrayList2 = this.p;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    this.m = this.p.get(0);
                } else {
                    this.m = null;
                }
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RGMeteorModel", "updateDataByCarPoint --> costTime = " + (System.currentTimeMillis() - currentTimeMillis));
                }
                if (LogUtil.LOGGABLE) {
                    LogUtil.printList("RGMeteorModel", "updateDataByCarPoint", "mCurRouteAllMeteors", this.q);
                    LogUtil.printList("RGMeteorModel", "updateDataByCarPoint", "mCurRouteSeriousPavementMeteors", this.o);
                    LogUtil.printList("RGMeteorModel", "updateDataByCarPoint", "mCurRouteSeriousMeteors", this.p);
                    LogUtil.e("RGMeteorModel", "updateDataByCarPoint --> mNearestSeriousPavementMeteor = " + this.l);
                    LogUtil.e("RGMeteorModel", "updateDataByCarPoint --> mNearestSeriousMeteor = " + this.m);
                }
                c(i, z);
                return;
            }
            this.q = null;
            this.o = null;
            this.p = null;
            this.l = null;
            this.r.clear();
            this.s.clear();
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMeteorModel", "updateDataByCarPoint --> mCurRouteAllMeteors is null!!!");
                LogUtil.e("RGMeteorModel", "updateDataByCarPoint --> costTime = " + (System.currentTimeMillis() - currentTimeMillis));
            }
            c(i, z);
        } catch (Throwable th) {
            throw th;
        }
    }

    public String d() {
        return f.q.a();
    }

    public com.baidu.navisdk.model.datastruct.h c() {
        return this.l;
    }

    public void b(Context context) {
        if (!com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.a.c().b() || com.baidu.baidunavis.maplayer.e.k().c() == this.g) {
            return;
        }
        x();
        a(context, this.b, com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.b(this.j.n));
    }

    public ArrayList<com.baidu.navisdk.model.datastruct.h> b() {
        ArrayList<com.baidu.navisdk.model.datastruct.h> arrayList = this.o;
        com.baidu.navisdk.model.datastruct.h hVar = null;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        ArrayList<com.baidu.navisdk.model.datastruct.h> arrayList2 = new ArrayList<>(this.o.size());
        Iterator<com.baidu.navisdk.model.datastruct.h> it = this.o.iterator();
        while (it.hasNext()) {
            com.baidu.navisdk.model.datastruct.h next = it.next();
            if (!a(hVar, next)) {
                arrayList2.add(next);
                hVar = next;
            }
        }
        return arrayList2;
    }

    private void b(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMeteorModel", "testWeatherPanel: ");
        }
        this.f = 0;
        com.baidu.navisdk.model.datastruct.h hVar = this.l;
        if (hVar == null) {
            com.baidu.navisdk.model.datastruct.h hVar2 = new com.baidu.navisdk.model.datastruct.h();
            this.l = hVar2;
            hVar2.d = new h.a();
            com.baidu.navisdk.model.datastruct.h hVar3 = this.l;
            h.a aVar = hVar3.d;
            aVar.f6928a = i + FeatureCodes.SKY_SEG;
            aVar.d = FeatureCodes.SKY_SEG;
            aVar.b = "1.9";
            aVar.c = "km";
            hVar3.e = new h.c();
            com.baidu.navisdk.model.datastruct.h hVar4 = this.l;
            h.c cVar = hVar4.e;
            cVar.f6930a = 1234L;
            cVar.d = "路面严重积雪";
            cVar.b = "大广高速";
            cVar.c = 4;
            hVar4.f = new h.d();
            com.baidu.navisdk.model.datastruct.h hVar5 = this.l;
            hVar5.f.b = "-10℃";
            h.a aVar2 = hVar5.d;
            if (aVar2 != null) {
                aVar2.a(i);
                return;
            }
            return;
        }
        h.a aVar3 = hVar.d;
        if (aVar3 != null) {
            aVar3.a(i);
        }
    }

    public int a() {
        return this.e;
    }

    private void a(int i, double d2, int i2, com.baidu.navisdk.model.datastruct.j jVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMeteorModel", "updateDataByLevel!!!");
        }
        if (jVar == null || d2 == OOXIXo.f3760XO) {
            return;
        }
        this.s.put(i, com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.e.a(jVar.a(), i2, (jVar.b() - this.e) / d2));
    }

    public void a(Context context) {
        if (this.k == null) {
            return;
        }
        v();
        w();
        a(context, this.c, null);
    }

    public void a(com.baidu.baidunavis.maplayer.d dVar) {
        a(this.f8970a, this.b, com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(dVar));
    }

    public void a(Context context, int i, com.baidu.nplatform.comapi.basestruct.c cVar) {
        com.baidu.navisdk.model.datastruct.h a2;
        com.baidu.nplatform.comapi.basestruct.c cVar2;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGMeteorModel", "showRouteMeteorLayer --> context = " + context + ", routeIndex = " + i + ", curHighLightRouteIndex = " + this.b + ", size = " + this.s.size() + ", point = " + cVar);
        }
        this.f8970a = context;
        this.b = i;
        if (i >= 0 && i < this.s.size()) {
            this.j.n = "";
            ArrayList<com.baidu.navisdk.model.datastruct.h> arrayList = this.s.get(i);
            if (cVar == null) {
                a2 = t();
            } else {
                a2 = a(cVar);
            }
            com.baidu.nplatform.comapi.basestruct.c cVar3 = a2 != null ? a2.c.d : cVar;
            if (a2 == null || arrayList == null || arrayList.isEmpty() || arrayList.contains(a2)) {
                cVar2 = cVar3;
            } else {
                int i2 = 0;
                while (true) {
                    if (i2 >= arrayList.size()) {
                        i2 = 0;
                        break;
                    }
                    com.baidu.navisdk.model.datastruct.h hVar = arrayList.get(i2);
                    if (hVar != null && hVar.d.f6928a - a2.d.f6928a > 0) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 <= 0) {
                    arrayList.add(a2);
                } else {
                    arrayList.add(i2, a2);
                }
                com.baidu.nplatform.comapi.basestruct.c cVar4 = a2.c.d;
                com.baidu.navisdk.util.statistic.userop.b.r().b("3.u.e.4");
                cVar2 = cVar4;
            }
            BNMapController.getInstance().showLayer(35, false);
            com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.a.c().a(context, arrayList, cVar2, this.j, this.u, true);
            return;
        }
        com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.a.c().a(context, new ArrayList<>(), null, this.j, this.u, true);
    }

    private com.baidu.navisdk.model.datastruct.h a(com.baidu.nplatform.comapi.basestruct.c cVar) {
        com.baidu.navisdk.model.datastruct.i iVar;
        ArrayList<com.baidu.navisdk.model.datastruct.h> a2;
        if (cVar != null && (iVar = this.k) != null && (a2 = iVar.a(this.b)) != null && a2.size() > 0) {
            Iterator<com.baidu.navisdk.model.datastruct.h> it = a2.iterator();
            while (it.hasNext()) {
                com.baidu.navisdk.model.datastruct.h next = it.next();
                if (cVar.a(next.c.d)) {
                    return next;
                }
            }
        }
        return null;
    }

    private boolean a(com.baidu.navisdk.model.datastruct.h hVar, com.baidu.navisdk.model.datastruct.h hVar2) {
        if (hVar == null && hVar2 == null) {
            return true;
        }
        return hVar != null && hVar2 != null && TextUtils.equals(hVar.f.f6931a, hVar2.f.f6931a) && TextUtils.equals(hVar.e.b, hVar2.e.b) && TextUtils.equals(hVar.e.d, hVar2.e.d) && TextUtils.equals(hVar.e.e, hVar2.e.e);
    }

    public void a(int i) {
        if (l()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGMeteorModel", "roadGradeChange: " + i + ", lastRoadGrade: " + this.f);
            }
            int i2 = this.f;
            if (i2 == 0 && i != 0) {
                this.f = i;
                com.baidu.navisdk.ui.routeguide.control.x.b().w1();
            } else if (i2 != 0 && i == 0) {
                this.f = i;
                y();
            } else {
                this.f = i;
            }
        }
    }
}
