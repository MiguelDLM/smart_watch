package com.baidu.navisdk.module.routeresultbase.logic.longdistance.city;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import com.baidu.baidunavis.maplayer.e;
import com.baidu.baidunavis.maplayer.g;
import com.baidu.navisdk.module.routeresultbase.logic.longdistance.d;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.c;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class b extends com.baidu.navisdk.module.routeresultbase.logic.longdistance.b {
    public SparseArray<ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a>> b;
    public SparseArray<ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a>> c;

    /* loaded from: classes7.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        int f7514a = 99;
        int b;
        int c;

        public a(b bVar) {
        }
    }

    public b(d dVar) {
        super(dVar);
        this.b = new SparseArray<>();
        this.c = new SparseArray<>();
    }

    public com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a a(c cVar) {
        SparseArray<ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a>> sparseArray;
        ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a> arrayList;
        if (cVar != null && (sparseArray = this.c) != null && this.f7511a.q < sparseArray.size() && (arrayList = this.c.get(this.f7511a.q)) != null && arrayList.size() > 0) {
            Iterator<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a next = it.next();
                if (next != null && cVar.a(next.e)) {
                    return next;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a> b() {
        if (this.f7511a.q < this.c.size()) {
            return this.c.get(this.f7511a.q);
        }
        return null;
    }

    public boolean c() {
        ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a> arrayList;
        SparseArray<ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a>> sparseArray = this.b;
        if (sparseArray != null) {
            int size = sparseArray.size();
            int i = this.f7511a.q;
            if (size > i && (arrayList = this.b.get(i)) != null && arrayList.size() > 0) {
                return true;
            }
        }
        return false;
    }

    public Bundle a() {
        SparseArray<ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a>> sparseArray = this.b;
        if (sparseArray == null || sparseArray.size() <= 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a> arrayList = new ArrayList<>();
        for (int i = 0; i < this.b.size(); i++) {
            ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a> arrayList2 = this.b.get(i);
            if (arrayList2 != null && arrayList2.size() > 0) {
                Iterator<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a> it = arrayList2.iterator();
                while (it.hasNext()) {
                    com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a next = it.next();
                    if (next != null && !a(next.b, arrayList)) {
                        arrayList.add(next);
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            if (arrayList.size() == 1) {
                sb.append(arrayList.get(0).b);
                sb2.append(arrayList.get(0).d);
            } else {
                for (int i2 = 0; i2 < arrayList.size() - 1; i2++) {
                    com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a aVar = arrayList.get(i2);
                    if (aVar != null) {
                        sb.append(aVar.b);
                        sb.append("|");
                        sb2.append(aVar.d);
                        sb2.append("|");
                    }
                }
                com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a aVar2 = arrayList.get(arrayList.size() - 1);
                if (aVar2 != null) {
                    sb.append(aVar2.b);
                    sb2.append(aVar2.d);
                }
            }
        }
        LogUtil.e("LongDistanceNaviModel", "getCityIdString " + sb.toString());
        LogUtil.e("LongDistanceNaviModel", "getCityEtaString " + sb2.toString());
        bundle.putString("cityId", sb.toString());
        bundle.putString("cityEta", sb2.toString());
        return bundle;
    }

    private boolean a(int i, ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a> arrayList) {
        Iterator<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().b == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x016c A[EDGE_INSN: B:37:0x016c->B:38:0x016c BREAK  A[LOOP:0: B:15:0x00a9->B:23:0x015a], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r20, android.util.SparseArray<java.util.ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a>> r21) {
        /*
            Method dump skipped, instructions count: 526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.b.a(int, android.util.SparseArray):void");
    }

    private void a(com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a aVar, int i, a aVar2, int i2) {
        aVar2.c = i2;
        aVar2.f7514a = aVar.f;
        aVar2.b = i;
    }

    public void a(Context context, c cVar) {
        boolean z;
        boolean z2;
        float c;
        float d;
        g a2;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a> b = b();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("LongDistanceNaviModel", "handlePassCityShow --> weatherList = " + b + ", point = " + cVar);
        }
        if (b != null && b.size() != 0) {
            ArrayList<g> arrayList = new ArrayList<>();
            int i = 0;
            while (true) {
                z = true;
                if (i >= b.size()) {
                    break;
                }
                com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a aVar = b.get(i);
                if (aVar != null && (a2 = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(1, aVar.e)) != null) {
                    arrayList.add(a2);
                }
                i++;
            }
            g gVar = null;
            com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a a3 = cVar != null ? a(cVar) : null;
            int i2 = 0;
            while (i2 < b.size()) {
                com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.b bVar = new com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.b(context);
                com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a aVar2 = b.get(i2);
                if (aVar2 != null) {
                    if ((cVar == null && i2 == 0) || ((cVar != null && a3 != null && aVar2.b == a3.b) || (a3 == null && i2 == 0))) {
                        bVar.a(z, aVar2, i2);
                        this.f7511a.a(aVar2.e);
                        z2 = true;
                    } else {
                        bVar.a(false, aVar2, i2);
                        z2 = false;
                    }
                    int i3 = this.f7511a.v;
                    if (i2 % 2 == 0) {
                        c = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(i3, z2);
                        d = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.b(i3, z2);
                    } else {
                        c = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.c(i3, z2);
                        d = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.d(i3, z2);
                    }
                    g a4 = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(bVar, aVar2.e, z2, c, d);
                    if (a4 != null) {
                        if (z2) {
                            gVar = a4;
                        } else {
                            arrayList.add(a4);
                        }
                    }
                }
                i2++;
                z = true;
            }
            if (gVar != null) {
                arrayList.add(gVar);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            LogUtil.e("LongDistanceNaviModel", "time 2 is " + (currentTimeMillis2 - currentTimeMillis));
            a(arrayList);
            LogUtil.e("LongDistanceNaviModel", "time 3 is " + (System.currentTimeMillis() - currentTimeMillis2));
            return;
        }
        e.k().f();
    }
}
