package com.baidu.navisdk.module.routeresultbase.logic.longdistance.route;

import android.content.Context;
import android.util.SparseArray;
import com.baidu.baidunavis.maplayer.e;
import com.baidu.baidunavis.maplayer.g;
import com.baidu.navisdk.module.routeresultbase.logic.longdistance.d;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class b extends com.baidu.navisdk.module.routeresultbase.logic.longdistance.b {
    public SparseArray<ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a>> b;
    public SparseArray<ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a>> c;

    /* loaded from: classes7.dex */
    public class a implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a f7520a;
        com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a b;

        public a(b bVar) {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a aVar = (com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a) obj;
            this.f7520a = aVar;
            com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a aVar2 = (com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a) obj2;
            this.b = aVar2;
            int i = aVar.i;
            int i2 = aVar2.i;
            if (i < i2) {
                return -1;
            }
            if (i > i2) {
                return 1;
            }
            return 0;
        }
    }

    public b(d dVar) {
        super(dVar);
        this.b = new SparseArray<>();
        this.c = new SparseArray<>();
    }

    public com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a a(c cVar) {
        SparseArray<ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a>> sparseArray;
        ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a> arrayList;
        if (cVar != null && (sparseArray = this.c) != null && this.f7511a.q < sparseArray.size() && (arrayList = this.c.get(this.f7511a.q)) != null && arrayList.size() > 0) {
            Iterator<com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a next = it.next();
                if (next != null && cVar.equals(next.f)) {
                    return next;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a> b() {
        if (this.f7511a.q < this.c.size()) {
            return this.c.get(this.f7511a.q);
        }
        return null;
    }

    public boolean c() {
        ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a> arrayList;
        SparseArray<ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a>> sparseArray = this.b;
        if (sparseArray != null) {
            int size = sparseArray.size();
            int i = this.f7511a.q;
            if (size > i && (arrayList = this.b.get(i)) != null && arrayList.size() > 0) {
                return true;
            }
        }
        return false;
    }

    public void a(int i) {
        int rint = (int) Math.rint(this.f7511a.o / 2.0d);
        ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a> arrayList = new ArrayList<>();
        ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a> arrayList2 = this.b.get(i);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("LongDistanceNaviModel", "updatePassRouteByLevel --> routeIndex = " + i + ", totalList = " + arrayList2);
            StringBuilder sb = new StringBuilder();
            sb.append("updatePassRouteByLevel count is ");
            sb.append(rint);
            sb.append(",");
            sb.append(arrayList2 == null ? 0 : arrayList2.size());
            LogUtil.e("LongDistanceNaviModel", sb.toString());
        }
        if (arrayList2 != null && arrayList2.size() > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                if (arrayList2.get(i3) != null) {
                    com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a aVar = new com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a();
                    aVar.a((com.baidu.navisdk.module.routeresultbase.logic.longdistance.a) arrayList2.get(i3));
                    arrayList.add(aVar);
                    i2++;
                    if (i2 >= rint) {
                        break;
                    }
                }
            }
            Collections.sort(arrayList, new a(this));
            if (LogUtil.LOGGABLE) {
                LogUtil.e("LongDistanceNaviModel", "updatePassRouteByLevel --> routeIndex = " + i + ", showList = " + arrayList);
            }
            this.c.append(i, arrayList);
            return;
        }
        this.c.append(i, arrayList);
    }

    public String a() {
        ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a> arrayList;
        SparseArray<ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a>> sparseArray = this.b;
        if (sparseArray == null || sparseArray.size() <= 0 || this.f7511a.q >= this.b.size() || (arrayList = this.b.get(this.f7511a.q)) == null || arrayList.size() <= 0) {
            return null;
        }
        Iterator<com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a next = it.next();
            if (next != null && next.e) {
                i += next.d;
            }
        }
        d dVar = this.f7511a;
        int i2 = dVar.q;
        int i3 = i2 < 5 ? dVar.s[i2] - i : 0;
        if (i < 1000 && i3 < 1000) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer("途经");
        if (i >= 1000) {
            stringBuffer.append("高速路段" + (i / 1000) + "公里");
            if (i3 >= 1000) {
                stringBuffer.append("，");
            }
        }
        if (i3 >= 1000) {
            stringBuffer.append("非高速路段" + (i3 / 1000) + "公里");
        }
        return stringBuffer.toString();
    }

    public void a(Context context, c cVar) {
        boolean z;
        c cVar2;
        float c;
        float d;
        ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a> b = b();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("LongDistanceNaviModel", "handlePassRouteShow --> weatherList = " + b + ", point = " + cVar);
        }
        if (b != null && b.size() > 0) {
            ArrayList<g> arrayList = new ArrayList<>();
            g gVar = null;
            com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a a2 = cVar != null ? a(cVar) : null;
            for (int i = 0; i < b.size(); i++) {
                com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.c cVar3 = new com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.c(context);
                com.baidu.navisdk.module.routeresultbase.logic.longdistance.route.a aVar = b.get(i);
                if (aVar != null) {
                    if ((i == 0 && cVar == null) || ((cVar != null && a2 != null && (cVar2 = aVar.f) != null && cVar2.equals(a2.f)) || (a2 == null && i == 0 && cVar != null))) {
                        this.f7511a.a(aVar.f);
                        z = true;
                        cVar3.a(true, aVar, i);
                    } else {
                        cVar3.a(false, aVar, i);
                        z = false;
                    }
                    if (i % 2 == 0) {
                        c = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(2, z);
                        d = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.b(2, z);
                    } else {
                        c = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.c(2, z);
                        d = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.d(2, z);
                    }
                    g a3 = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(cVar3, aVar.f, z, c, d);
                    if (a3 != null) {
                        if (z) {
                            gVar = a3;
                        } else {
                            arrayList.add(a3);
                        }
                    }
                }
            }
            if (gVar != null) {
                arrayList.add(gVar);
            }
            a(arrayList);
            return;
        }
        e.k().f();
    }
}
