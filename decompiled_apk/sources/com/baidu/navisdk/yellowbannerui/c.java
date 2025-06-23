package com.baidu.navisdk.yellowbannerui;

import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.internal.bn;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.yellowbannerui.config.f;
import com.baidu.navisdk.yellowtipdata.model.data.d;
import com.baidu.navisdk.yellowtipdata.model.data.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private int f9436a;
    private int b;
    private int c;
    private String d;
    private boolean e;
    private boolean f;
    private final ArrayList<ArrayList<d>> g;
    private final ArrayList<ArrayList<d>> h;
    private volatile d[] i;
    private final HashMap<Integer, String> j;
    private boolean k;
    private boolean l;
    private boolean[] m;
    private boolean[] n;
    private boolean o;
    private boolean p;
    private SparseIntArray q;
    private final a r;
    private d s;
    private d t;
    private boolean u;

    @NonNull
    private final com.baidu.navisdk.yellowbannerui.interfaces.a v;
    private com.baidu.navisdk.yellowtipdata.interfaces.a w;
    private f x;
    private final int y;
    private final int z;

    /* loaded from: classes8.dex */
    public static class a implements Comparator<d> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            return dVar.b() - dVar2.b();
        }
    }

    public c(int i, @NonNull com.baidu.navisdk.yellowbannerui.interfaces.a aVar) {
        this(i, 0, aVar);
    }

    private void A() {
        d[] dVarArr = new d[3];
        for (int i = 0; i < 3; i++) {
            dVarArr[i] = h(i);
        }
        this.i = dVarArr;
    }

    private void B() {
        d[] dVarArr = this.i;
        for (int i = 0; i < 3; i++) {
            d dVar = dVarArr[i];
            if (dVar != null && dVar.e()) {
                ArrayList<d> arrayList = this.h.get(i);
                int i2 = 0;
                while (true) {
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    if (!arrayList.get(i2).e()) {
                        d dVar2 = arrayList.get(i2);
                        arrayList.remove(dVar2);
                        arrayList.add(0, dVar2);
                        break;
                    }
                    i2++;
                }
                if (!arrayList.isEmpty()) {
                    d dVar3 = arrayList.get(0);
                    if (dVar3 != null && !dVar3.e()) {
                        dVarArr[i] = dVar3;
                    } else {
                        dVarArr[i] = null;
                    }
                } else {
                    dVarArr[i] = null;
                }
            }
        }
    }

    private void C() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("YellowBannerManager", "updateYBannerData()");
        }
        this.o = true;
        com.baidu.navisdk.yellowbannerui.controller.a.c().b();
        w();
        q();
        if (!n()) {
            this.s = null;
        }
        u();
        t();
        z();
    }

    private boolean b(int i, d dVar) {
        return false;
    }

    private int f(int i) {
        if (this.q == null) {
            s();
        }
        try {
            return this.q.get(i, 1);
        } catch (Exception unused) {
            return 1;
        }
    }

    private boolean g(int i) {
        return (i == 4 || i == 5 || i == 7 || i == 24 || i == 25 || i == 31 || i == 35) ? false : true;
    }

    private void q() {
        A();
        y();
    }

    private void r() {
        if (this.h.size() > 0) {
            return;
        }
        for (int i = 0; i < 3; i++) {
            this.h.add(new ArrayList<>());
        }
        for (int i2 = 0; i2 < 3; i2++) {
            this.g.add(new ArrayList<>());
        }
        this.c = this.v.b();
        this.d = this.v.a();
    }

    private void s() {
        SparseIntArray sparseIntArray = new SparseIntArray();
        this.q = sparseIntArray;
        sparseIntArray.put(1, 0);
        this.q.put(2, 0);
        this.q.put(8, 1);
        this.q.put(11, 2);
        this.q.put(12, 1);
        this.q.put(16, 0);
        this.q.put(17, 1);
    }

    private void t() {
        if (this.n == null) {
            this.n = new boolean[3];
        }
        for (int i = 0; i < 3; i++) {
            this.n[i] = false;
        }
    }

    private void u() {
        if (this.m == null) {
            this.m = new boolean[3];
        }
        for (int i = 0; i < 3; i++) {
            this.m[i] = true;
        }
    }

    private boolean v() {
        d dVar;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("YellowBannerManager", "isMixYBannerData(), curCarBannerDataArr = " + Arrays.toString(this.i));
        }
        d[] dVarArr = this.i;
        if (dVarArr == null) {
            return false;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < 3 && (dVar = dVarArr[i]) != null; i++) {
            if (dVar.e()) {
                z = true;
            } else {
                z2 = true;
            }
        }
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    private void w() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("YellowBannerManager", "removeExcessYellowBanner localCountTime:" + this.c);
        }
        for (int i = 0; i < this.h.size(); i++) {
            if (this.h.get(i) != null) {
                Iterator<d> it = this.h.get(i).iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    int a2 = next.a();
                    if (a2 == 55 && System.currentTimeMillis() - this.v.e() < bn.d) {
                        it.remove();
                    } else if (a2 == 3) {
                        if (this.c >= 3) {
                            String a3 = next.c().a();
                            String e = next.c().e();
                            if (e != null && e.equals(this.d) && "1".equals(a3)) {
                                it.remove();
                                this.s = null;
                            }
                        }
                    } else if (a2 == 54) {
                        it.remove();
                    }
                }
                if (LogUtil.LOGGABLE) {
                    LogUtil.printList("YellowBannerManager", "removeExcessYellowBanner", "第" + i + "条路线过滤之后的黄条list", this.h.get(i));
                }
            }
        }
    }

    private void x() {
        Iterator<ArrayList<d>> it = this.h.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        Iterator<ArrayList<d>> it2 = this.g.iterator();
        while (it2.hasNext()) {
            it2.next().clear();
        }
    }

    private void y() {
        if (v()) {
            B();
        }
    }

    private void z() {
        d[] dVarArr = this.i;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("YellowBannerManager", "setGlobalType(), curCarBannerDataArr = " + Arrays.toString(dVarArr));
        }
        if (dVarArr == null) {
            return;
        }
        for (int i = 0; i < this.f9436a; i++) {
            try {
                if (dVarArr[i] == null) {
                    this.f = false;
                    return;
                }
            } catch (Exception e) {
                g gVar = g.ROUTE_RESULT;
                if (gVar.d()) {
                    gVar.a("YellowBannerManager setGlobalType exception!", (Throwable) e, false);
                    return;
                }
                return;
            }
        }
        int a2 = dVarArr[0].a();
        for (int i2 = 1; i2 < this.f9436a; i2++) {
            if (a2 != dVarArr[i2].a()) {
                this.f = false;
                return;
            }
        }
        this.f = dVarArr[0].e();
    }

    @NonNull
    public com.baidu.navisdk.yellowbannerui.interfaces.a a() {
        return this.v;
    }

    public boolean c(int i) {
        d dVar;
        d[] dVarArr = this.i;
        if (dVarArr == null || dVarArr.length <= 0 || (dVar = dVarArr[0]) == null || dVar.a() != i) {
            return false;
        }
        this.i = new d[3];
        return true;
    }

    public void d(int i) {
        this.b = i;
    }

    public void e(int i) {
        this.c = i;
    }

    public int h() {
        return this.y;
    }

    public f i() {
        return this.x;
    }

    @Nullable
    public d j() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("YellowBannerManager", "getYBannerModelForBubble --> mYBannerModelForBubble = " + this.s);
        }
        return this.s;
    }

    public boolean k() {
        return this.o;
    }

    public boolean l() {
        return this.f;
    }

    public boolean m() {
        return this.e;
    }

    public boolean n() {
        ArrayList arrayList = new ArrayList(this.h);
        for (int i = 0; i < arrayList.size(); i++) {
            ArrayList arrayList2 = new ArrayList((Collection) arrayList.get(i));
            if (!arrayList2.isEmpty()) {
                d dVar = (d) arrayList2.get(0);
                if (dVar.a() != 3 && dVar.a() != 4) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("YellowBannerManager", "isLocalYBannerHighestPriorityInAllRoute : false!!!");
                    }
                    return false;
                }
            }
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("YellowBannerManager", "isLocalYBannerHighestPriorityInAllRoute : true!!!");
            return true;
        }
        return true;
    }

    public d o() {
        return b(this.b);
    }

    public synchronized void p() {
        LogUtil.e("YellowBannerManager", "reset()");
        x();
        this.j.clear();
        this.k = false;
        this.l = false;
        this.f = false;
        this.i = null;
        this.f9436a = 1;
        this.b = 0;
        this.m = null;
        this.n = null;
        this.e = false;
        this.u = false;
        this.s = null;
        this.t = null;
    }

    public c(int i, int i2, @NonNull com.baidu.navisdk.yellowbannerui.interfaces.a aVar) {
        this.f9436a = 1;
        this.b = 0;
        this.c = 0;
        this.d = null;
        this.e = false;
        this.f = false;
        this.g = new ArrayList<>();
        this.h = new ArrayList<>();
        this.i = null;
        this.j = new HashMap<>();
        this.k = false;
        this.l = false;
        this.m = null;
        this.n = null;
        this.o = true;
        this.p = false;
        this.r = new a();
        this.u = false;
        this.y = i;
        this.z = i2;
        this.v = aVar;
        r();
    }

    private d h(int i) {
        if (this.h.size() <= i || i < 0 || this.h.get(i) == null || this.h.get(i).size() <= 0) {
            return null;
        }
        ArrayList<d> arrayList = this.h.get(i);
        Collections.sort(arrayList, this.r);
        return arrayList.get(0);
    }

    public synchronized void a(ArrayList<ArrayList<d>> arrayList, boolean z, boolean z2) {
        try {
            p();
            this.u = z2;
            this.f9436a = arrayList == null ? 1 : arrayList.size();
            a(arrayList, z, this.w);
            C();
            if (LogUtil.LOGGABLE) {
                StringBuilder sb = new StringBuilder();
                sb.append("parseRouteYBannerData --> 筛完小黄条type --------------------------------\n第一条路线：");
                sb.append(b(0) == null ? "null" : Integer.valueOf(b(0).a()));
                sb.append("\n第二条路线：");
                sb.append(b(1) == null ? "null" : Integer.valueOf(b(1).a()));
                sb.append("\n第三条路线：");
                sb.append(b(2) == null ? "null" : Integer.valueOf(b(2).a()));
                LogUtil.e("YellowBannerManager", sb.toString());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized d b(int i) {
        try {
            if (this.i == null) {
                q();
            }
            d[] dVarArr = this.i;
            if (dVarArr != null && i < this.i.length && i >= 0) {
                return dVarArr[i];
            }
            return null;
        } finally {
        }
    }

    public int d() {
        return this.c;
    }

    public boolean[] e() {
        return this.m;
    }

    public int g() {
        return this.z;
    }

    public String f() {
        return this.d;
    }

    private boolean c(int i, d dVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("YellowBannerManager", "isShowNotifyInsteadBanner(), routeCarYBannerModel=" + dVar + ", type=" + i);
        }
        if (dVar == null || dVar.c() == null) {
            return false;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("YellowBannerManager", "isShowNotifyInsteadBanner(), isFutureTripCal()=" + BNRoutePlaner.getInstance().y());
        }
        if (BNRoutePlaner.getInstance().y()) {
            return false;
        }
        if (i == 21) {
            this.t = dVar;
            return true;
        }
        if (i == 49) {
            this.t = dVar;
            return true;
        }
        if (i != 64) {
            return false;
        }
        if (this.t == null) {
            this.t = dVar;
        }
        return true;
    }

    private void b(d dVar) {
        if (dVar == null || dVar.a() == -1 || dVar.c() == null || this.l) {
            return;
        }
        this.l = true;
        if (this.h.get(0).size() == 0) {
            dVar.c().a(f(dVar.a()));
            a(dVar);
            return;
        }
        Iterator<d> it = this.h.get(0).iterator();
        while (it.hasNext()) {
            if (it.next().a() != dVar.a()) {
                dVar.c().a(f(dVar.a()));
                a(dVar);
                return;
            }
        }
    }

    public synchronized void a(int i, String str) {
        try {
            this.s = null;
            com.baidu.navisdk.yellowtipdata.model.data.g gVar = new com.baidu.navisdk.yellowtipdata.model.data.g();
            gVar.d(i);
            gVar.p(str);
            d a2 = e.a(gVar);
            if (a2.h()) {
                c(a2);
                this.o = true;
                com.baidu.navisdk.yellowbannerui.controller.a.c().b();
                u();
                t();
                z();
            }
            if (a2.d()) {
                b(a2);
                C();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void c(d dVar) {
        if (dVar == null || dVar.a() == -1 || dVar.c() == null) {
            return;
        }
        this.j.clear();
        com.baidu.navisdk.yellowtipdata.model.data.g c = dVar.c();
        int a2 = dVar.a();
        if (a2 == 2) {
            LogUtil.e("YellowBannerManager", "addGlobleYBanner YBannerType.Net_error " + this.k);
            c.c(257);
        } else if (a2 == 8) {
            c.c(258);
        } else if (a2 == 17) {
            c.c(261);
        } else if (a2 == 11) {
            c.c(259);
        } else if (a2 != 12) {
            c = null;
        } else {
            c.c(260);
        }
        if (c != null) {
            d[] dVarArr = new d[3];
            c.a(f(dVar.a()));
            for (int i = 0; i < 3; i++) {
                dVarArr[i] = dVar;
            }
            this.i = dVarArr;
        }
    }

    public void b(boolean z) {
        this.e = z;
    }

    public d[] b() {
        return this.i;
    }

    private void a(ArrayList<ArrayList<d>> arrayList, boolean z, com.baidu.navisdk.yellowtipdata.interfaces.a aVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("YellowBannerManager", "parseRouteYBannerDataFromCars --> cars = " + arrayList);
        }
        if (this.h.size() == 0) {
            r();
        }
        if (arrayList == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        int min = Math.min(arrayList2.size(), 3);
        for (int i = 0; i < min; i++) {
            ArrayList arrayList3 = (ArrayList) arrayList2.get(i);
            this.g.get(i).addAll(arrayList3);
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar != null && (aVar == null || !aVar.a(dVar))) {
                    f fVar = this.x;
                    if (fVar == null) {
                        if (dVar.a() == 4) {
                            b.a(dVar.c(), true, z);
                        }
                        a(i, dVar);
                    } else {
                        fVar.a(dVar.a());
                        throw null;
                    }
                }
            }
        }
    }

    public boolean[] c() {
        return this.n;
    }

    public void c(boolean z) {
        this.p = z;
    }

    private void a(int i, d dVar) {
        if (this.h.size() == 0) {
            r();
        }
        if (dVar == null || dVar.c() == null || TextUtils.isEmpty(dVar.c().o())) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            StringBuilder sb = new StringBuilder();
            sb.append("addYBannerToSingleRoute --> routeIndex:");
            sb.append(i);
            sb.append(",id:");
            sb.append(dVar.a());
            sb.append(",iconType:");
            sb.append(dVar.c().h());
            sb.append(",title:");
            sb.append(dVar.c().o());
            sb.append(",subTitle:");
            sb.append(dVar.c().m());
            sb.append(",assistInfo:");
            sb.append(dVar.c().a());
            sb.append(",priority:");
            sb.append(dVar.b());
            sb.append(",backGroundId:");
            sb.append(dVar.c().b());
            sb.append(",end_button_info:");
            sb.append(dVar.c().j() != null ? Integer.valueOf(dVar.c().j().size()) : "0");
            LogUtil.e("YellowBannerManager", sb.toString());
        }
        if (dVar.a() == 33 && this.u) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("YellowBannerManager", "addYBannerToSingleRoute --> poi is from baidu map, should not add openapi yellow banner!!!");
                return;
            }
            return;
        }
        if (BNRoutePlaner.getInstance().y()) {
            if (g(dVar.a())) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("YellowBannerManager", "addYBannerToSingleRoute --> future tip page can not show this yellow tip!!!");
                    return;
                }
                return;
            } else if (this.v.c() && dVar.a() == 35) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("YellowBannerManager", "addYBannerToSingleRoute --> showed common future trip tip in future tip page");
                    return;
                }
                return;
            }
        }
        b(dVar.a(), dVar);
        if (c(dVar.a(), dVar)) {
            return;
        }
        if (dVar.a() == 3 && this.p) {
            LogUtil.e("YellowBannerManager", "Already clicked QuickCloseBtn,will not show car plate setting yaw");
        } else {
            if (dVar.a() < 0) {
                return;
            }
            this.h.get(i).add(dVar);
        }
    }

    private void a(d dVar) {
        for (int i = 0; i < 3; i++) {
            a(i, dVar);
        }
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(boolean z) {
        this.o = z;
    }

    public int a(int i) {
        ArrayList arrayList = new ArrayList(this.h);
        if (arrayList.size() <= i || i < 0) {
            return -1;
        }
        ArrayList arrayList2 = new ArrayList((Collection) arrayList.get(i));
        if (arrayList2.isEmpty()) {
            return -1;
        }
        int size = arrayList2.size();
        if (size == 1 && (((d) arrayList2.get(0)).d() || ((d) arrayList2.get(0)).h())) {
            return -1;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("YellowBannerManager", "getYellowBannerCountInOneRoute --> count = " + size);
        }
        return size;
    }
}
