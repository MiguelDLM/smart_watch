package com.baidu.navisdk.module.routeresultbase.logic.longdistance.weather;

import XIXIX.OOXIXo;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.baidunavis.maplayer.g;
import com.baidu.navisdk.j;
import com.baidu.navisdk.model.datastruct.h;
import com.baidu.navisdk.module.routeresultbase.logic.longdistance.b;
import com.baidu.navisdk.module.routeresultbase.logic.longdistance.d;
import com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.d;
import com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.e;
import com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.CarPassWeatherView;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.c;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class a extends b {
    public SparseArray<ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a>> b;
    public SparseArray<ArrayList<h>> c;
    public SparseArray<ArrayList<h>> d;
    public SparseArray<ArrayList<h>> e;
    public SparseArray<ArrayList<h>> f;

    public a(d dVar) {
        super(dVar);
        this.b = new SparseArray<>();
        this.c = new SparseArray<>();
        this.d = new SparseArray<>();
        this.e = new SparseArray<>();
        this.f = new SparseArray<>();
    }

    private com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a c(c cVar) {
        ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a> arrayList = this.b.get(this.f7511a.q);
        if (cVar == null || arrayList == null || arrayList.size() == 0) {
            return null;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) != null && arrayList.get(i).e != null && arrayList.get(i) != null && arrayList.get(i).e.a(cVar)) {
                return arrayList.get(i);
            }
        }
        return null;
    }

    public com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a a(c cVar, SparseArray<ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a>> sparseArray) {
        ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a> arrayList = sparseArray.get(this.f7511a.q);
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        return cVar != null ? c(cVar) : b(arrayList);
    }

    public com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a b(SparseArray<ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a>> sparseArray) {
        ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a> arrayList = sparseArray.get(this.f7511a.q);
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        return b(arrayList);
    }

    public h d() {
        SparseArray<ArrayList<h>> sparseArray = this.c;
        if (sparseArray != null && sparseArray.size() != 0 && this.f7511a.q < this.c.size()) {
            SparseArray<ArrayList<h>> sparseArray2 = this.e;
            if (sparseArray2 != null && sparseArray2.size() > 0) {
                int size = this.e.size();
                int i = this.f7511a.q;
                if (size > i) {
                    ArrayList<h> arrayList = this.e.get(i);
                    if (arrayList != null && !arrayList.isEmpty()) {
                        Iterator<h> it = arrayList.iterator();
                        while (it.hasNext()) {
                            h next = it.next();
                            if (next != null && next.e()) {
                                if (LogUtil.LOGGABLE) {
                                    LogUtil.e("LongDistanceNaviModel", "getSeriousMeteor --> info = " + next);
                                }
                                return next;
                            }
                        }
                    } else {
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("LongDistanceNaviModel", "getSeriousMeteor --> seriousMeteorList is empty, return null!!!");
                        }
                        return null;
                    }
                }
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("LongDistanceNaviModel", "getSeriousMeteor --> no serious meteor, return null!!!");
            }
            return null;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("LongDistanceNaviModel", "getSeriousMeteor --> mPassMeteorArr is empty, return null!!!");
        }
        return null;
    }

    private com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a b(ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int i = -1;
        if (arrayList.size() != 0) {
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a aVar = arrayList.get(i3);
                if (aVar != null && aVar.j && e.a(aVar.g) && a(aVar.g) < i2) {
                    i2 = a(aVar.g);
                    i = i3;
                }
            }
        }
        if (i < 0 || i >= arrayList.size()) {
            return null;
        }
        return arrayList.get(i);
    }

    public int a(String str) {
        if (TextUtils.equals("暴雨", str)) {
            return 1000;
        }
        if (TextUtils.equals("大雪", str)) {
            return 2000;
        }
        if (TextUtils.equals("大雨", str)) {
            return 3000;
        }
        if (TextUtils.equals("雷阵雨", str)) {
            return 4000;
        }
        if (TextUtils.equals("冰雹", str)) {
            return 5000;
        }
        if (TextUtils.equals("雨夹雪", str)) {
            return 6000;
        }
        return TextUtils.equals("雾", str) ? 7000 : Integer.MAX_VALUE;
    }

    public boolean c(SparseArray<ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a>> sparseArray) {
        if (sparseArray != null && sparseArray.size() > 0) {
            ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a> arrayList = sparseArray.get(this.f7511a.q);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("LongDistanceNaviModel", "isWeatherDataAvailable --> cityList = " + arrayList);
            }
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            Iterator<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a next = it.next();
                if (next != null && e.a(next.g)) {
                    return true;
                }
            }
            return false;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("LongDistanceNaviModel", "isWeatherDataAvailable --> mPassCityArr is empty!!!");
        }
        return false;
    }

    public void a(d.f fVar, SparseArray<ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a>> sparseArray, SparseArray<ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a>> sparseArray2) {
        SparseArray<d.c> sparseArray3;
        ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a> arrayList;
        d.c cVar;
        d.c cVar2;
        if (sparseArray == null || sparseArray.size() <= 0 || (sparseArray3 = fVar.d) == null || sparseArray3.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.f7511a.p; i++) {
            ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a> arrayList2 = sparseArray.get(i);
            if (arrayList2 != null && arrayList2.size() > 0) {
                Iterator<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a> it = arrayList2.iterator();
                while (it.hasNext()) {
                    com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a next = it.next();
                    if (next != null && (cVar2 = sparseArray3.get(next.b)) != null) {
                        next.j = cVar2.f;
                        next.g = cVar2.c;
                        next.h = cVar2.d;
                        next.i = cVar2.e;
                        next.k = true;
                    }
                }
                if (sparseArray2 != null && i < sparseArray2.size() && (arrayList = sparseArray2.get(i)) != null) {
                    Iterator<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a next2 = it2.next();
                        if (next2 != null && (cVar = sparseArray3.get(next2.b)) != null) {
                            next2.j = cVar.f;
                            next2.g = cVar.c;
                            next2.h = cVar.d;
                            next2.i = cVar.e;
                            next2.k = true;
                        }
                    }
                }
            }
        }
    }

    public void b(int i, int i2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("LongDistanceNaviModel", "updatePavementMeteorByLevel --> routeIndex = " + i);
        }
        if (i < 0 || i >= this.e.size()) {
            return;
        }
        this.f.put(i, e.b(this.e.get(i), i2, this.f7511a.o));
    }

    public ArrayList<h> c() {
        if (this.f7511a.q < this.f.size()) {
            return this.f.get(this.f7511a.q);
        }
        return null;
    }

    public ArrayList<h> b() {
        if (this.f7511a.q < this.d.size()) {
            return this.d.get(this.f7511a.q);
        }
        return null;
    }

    public h b(c cVar) {
        if (cVar != null && this.f7511a.q < this.e.size()) {
            Iterator<h> it = this.e.get(this.f7511a.q).iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (cVar.a(next.c.d)) {
                    return next;
                }
            }
        }
        return null;
    }

    public void b(Context context, c cVar) {
        ArrayList<h> c = c();
        com.baidu.navisdk.module.routeresultbase.logic.longdistance.d dVar = this.f7511a;
        boolean z = dVar != null && dVar.x;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("LongDistanceNaviModel", "handlePavementMeteorShow --> ctx = " + context + ", point = " + cVar + ", isShowPavementMeteorLayer = " + z);
            LogUtil.printList("LongDistanceNaviModel", "handlePavementMeteorShow", "pavementMeteorList", c);
        }
        if (z && c != null && !c.isEmpty()) {
            if (j.d()) {
                com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.a c2 = com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.a.c();
                com.baidu.navisdk.module.routeresultbase.logic.longdistance.d dVar2 = this.f7511a;
                c2.a(context, c, cVar, dVar2, dVar2.k(), false);
                return;
            }
            return;
        }
        com.baidu.baidunavis.maplayer.e.k().f();
    }

    public void a(boolean z, int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("LongDistanceNaviModel", "updateMeteorDataByRP --> mRouteNumber = " + this.f7511a.p);
        }
        if (!z) {
            return;
        }
        this.d.clear();
        this.f.clear();
        double d = com.baidu.baidunavis.maplayer.e.k().d();
        if (d == OOXIXo.f3760XO) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("LongDistanceNaviModel", "updateMeteorDataByRP --> units is " + d);
        }
        int i2 = 0;
        while (true) {
            com.baidu.navisdk.module.routeresultbase.logic.longdistance.d dVar = this.f7511a;
            if (i2 >= dVar.p) {
                return;
            }
            dVar.o = dVar.s[i2] / d;
            if (LogUtil.LOGGABLE) {
                LogUtil.e("LongDistanceNaviModel", "updateMeteorDataByRP --> routeIndex = " + i2 + ", routeDistance = " + this.f7511a.s[i2] + ", units = " + d + ", mCurrentLevelLength = " + this.f7511a.o);
            }
            a(i2, i);
            b(i2, i);
            i2++;
        }
    }

    public void a(int i, int i2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("LongDistanceNaviModel", "updatePassMeteorByLevel --> routeIndex = " + i);
        }
        if (i < 0 || i >= this.c.size()) {
            return;
        }
        this.d.put(i, e.a(this.c.get(i), i2, this.f7511a.o));
    }

    public ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a> a() {
        if (this.f7511a.q < this.b.size()) {
            return this.b.get(this.f7511a.q);
        }
        return null;
    }

    public h a(c cVar) {
        if (cVar != null && this.f7511a.q < this.c.size()) {
            Iterator<h> it = this.c.get(this.f7511a.q).iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (cVar.a(next.c.d)) {
                    return next;
                }
            }
        }
        return null;
    }

    public String a(SparseArray<ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a>> sparseArray) {
        ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a> arrayList;
        com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a b;
        if (sparseArray == null || sparseArray.size() <= 0 || this.f7511a.q >= sparseArray.size() || (arrayList = sparseArray.get(this.f7511a.q)) == null || arrayList.size() <= 0 || (b = b(arrayList)) == null || !e.a(b.g)) {
            return null;
        }
        return "途经" + b.f7513a + "时有" + b.g + "，请小心驾驶";
    }

    public boolean a(int i) {
        ArrayList<h> arrayList;
        try {
            SparseArray<ArrayList<h>> sparseArray = this.c;
            if (sparseArray == null || sparseArray.size() == 0 || i < 0 || i >= sparseArray.size() || (arrayList = sparseArray.get(i)) == null) {
                return false;
            }
            return !arrayList.isEmpty();
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("LongDistanceNaviModel", "isHasMeteorData --> e = " + e);
            }
            return false;
        }
    }

    public void a(Context context, c cVar, SparseArray<ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a>> sparseArray) {
        ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a> arrayList;
        com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a aVar;
        boolean z;
        float c;
        float d;
        g a2;
        com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a aVar2;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a> a3 = a();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("LongDistanceNaviModel", "handlePassWeatherShow --> weatherList = " + a3 + ", point = " + cVar);
        }
        if (a3 != null && a3.size() != 0) {
            ArrayList<g> arrayList2 = new ArrayList<>();
            com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a a4 = a(cVar, sparseArray);
            com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a b = b(sparseArray);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("LongDistanceNaviModel", "handlePassWeatherShow --> detailWeather = " + a4 + ", worstWeather = " + b);
            }
            boolean z2 = cVar != null ? !(b == null || !b.e.a(cVar)) : !(b == null || !b.equals(a4));
            boolean z3 = false;
            for (int i = 0; i < a3.size(); i++) {
                if (a3.get(i).equals(a4) && (aVar2 = a3.get(i)) != null && e.a(aVar2.g)) {
                    g a5 = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(1, aVar2.e);
                    if (a5 != null) {
                        arrayList2.add(a5);
                    }
                    if (z2) {
                        z3 = true;
                    }
                }
            }
            boolean z4 = z2 && !z3;
            if (z4 && b != null && e.a(b.g) && (a2 = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(1, b.e)) != null) {
                arrayList2.add(a2);
            }
            g gVar = null;
            int i2 = 0;
            int i3 = 0;
            while (i2 < a3.size()) {
                CarPassWeatherView carPassWeatherView = new CarPassWeatherView(context);
                com.baidu.navisdk.module.routeresultbase.logic.longdistance.city.a aVar3 = a3.get(i2);
                if (aVar3 == null || !e.a(aVar3.g)) {
                    arrayList = a3;
                    aVar = a4;
                } else {
                    if (a3.get(i2).equals(a4)) {
                        carPassWeatherView.a(aVar3, true, i2);
                        arrayList = a3;
                        this.f7511a.a(aVar3.e);
                        z = true;
                    } else {
                        arrayList = a3;
                        i3++;
                        carPassWeatherView.a(aVar3, false, i3);
                        z = false;
                    }
                    int i4 = this.f7511a.v;
                    if (i3 % 2 != 0) {
                        c = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(i4, z);
                        d = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.b(i4, z);
                    } else {
                        c = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.c(i4, z);
                        d = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.d(i4, z);
                    }
                    float f = c;
                    aVar = a4;
                    g a6 = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(carPassWeatherView, aVar3.e, z, f, d);
                    if (a6 != null) {
                        if (z) {
                            gVar = a6;
                        } else {
                            arrayList2.add(a6);
                        }
                    }
                }
                i2++;
                a3 = arrayList;
                a4 = aVar;
            }
            if (z4 && b != null && e.a(b.g)) {
                CarPassWeatherView carPassWeatherView2 = new CarPassWeatherView(context);
                carPassWeatherView2.a(b, true, -1);
                this.f7511a.a(b.e);
                int i5 = this.f7511a.v;
                g a7 = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(carPassWeatherView2, b.e, true, com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(i5, true), com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.b(i5, true));
                if (a7 != null) {
                    gVar = a7;
                }
            }
            if (gVar != null) {
                arrayList2.add(gVar);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            LogUtil.e("LongDistanceNaviModel", "time 2 is " + (currentTimeMillis2 - currentTimeMillis));
            a(arrayList2);
            LogUtil.e("LongDistanceNaviModel", "time 3 is " + (System.currentTimeMillis() - currentTimeMillis2));
            return;
        }
        com.baidu.baidunavis.maplayer.e.k().f();
    }

    public void a(Context context, c cVar) {
        ArrayList<h> b = b();
        if (LogUtil.LOGGABLE) {
            LogUtil.printList("LongDistanceNaviModel", "handleMeteorShow", "meteorList", b);
        }
        if (b != null && !b.isEmpty()) {
            h a2 = a(cVar);
            if (a2 != null && !b.contains(a2)) {
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i2 < b.size()) {
                        h hVar = b.get(i2);
                        if (hVar != null && hVar.d.f6928a - a2.d.f6928a > 0) {
                            i = i2;
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
                if (i <= 0) {
                    b.add(a2);
                } else {
                    b.add(i, a2);
                }
            }
            com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.a c = com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.a.c();
            com.baidu.navisdk.module.routeresultbase.logic.longdistance.d dVar = this.f7511a;
            c.a(context, b, cVar, dVar, dVar.k(), false);
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("LongDistanceNaviModel", "handleMeteorShow --> meteor is empty!!!");
        }
        TipTool.onCreateToastDialog(context, "沿途天气获取异常");
        com.baidu.baidunavis.maplayer.e.k().f();
    }
}
