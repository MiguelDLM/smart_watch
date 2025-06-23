package com.baidu.navisdk.module.nearbysearch.model;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.j;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.c;
import com.baidu.navisdk.model.modelfactory.f;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes7.dex */
public enum b {
    INSTANCE;


    /* renamed from: a, reason: collision with root package name */
    private ArrayList<a> f7211a;
    private ArrayList<a> b;
    private a c;
    private a d = null;
    private int e = -1;

    b() {
    }

    private ArrayList<a> g(a aVar) {
        if (f(this.f7211a)) {
            return null;
        }
        GeoPoint geoPoint = aVar.getGeoPoint();
        ArrayList<a> arrayList = new ArrayList<>();
        Iterator<a> it = this.f7211a.iterator();
        long j = Long.MAX_VALUE;
        while (it.hasNext()) {
            a next = it.next();
            if (!TextUtils.isEmpty(aVar.mUID) && TextUtils.equals(next.mUID, aVar.mUID)) {
                arrayList.add(next);
                j = Long.MIN_VALUE;
            } else if (next.getGeoPoint().approximate(geoPoint)) {
                long a2 = a(next.getGeoPoint(), geoPoint);
                if (a2 < j) {
                    arrayList.clear();
                    arrayList.add(next);
                    j = a2;
                } else if (a2 == j) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    private void h() {
        if (((f) c.a().a("RoutePlanModel")) == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNApproachPoiManager", "updateRoutePlanList --> routePlanModel is null!!!");
                return;
            }
            return;
        }
        ArrayList<RoutePlanNode> arrayList = new ArrayList<>();
        ArrayList<Bundle> arrayList2 = new ArrayList<>();
        BNRoutePlaner.getInstance().b(arrayList2);
        if (LogUtil.LOGGABLE) {
            LogUtil.printList("BNApproachPoiManager", "updateRoutePlanList", "routePlanNodeBundleList", arrayList2);
        }
        if (arrayList2.size() >= 2) {
            for (int i = 1; i < arrayList2.size() - 1; i++) {
                Bundle bundle = arrayList2.get(i);
                double d = bundle.getDouble("x", -2.147483648E9d);
                double d2 = bundle.getDouble("y", -2.147483648E9d);
                String string = bundle.getString("uid", "");
                int i2 = bundle.getInt("nodeId", 0);
                int i3 = bundle.getInt("iconType", 0);
                int i4 = (int) (d * 100000.0d);
                int i5 = (int) (d2 * 100000.0d);
                a a2 = a(new GeoPoint(i4, i5), string, i2);
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BNApproachPoiManager", "updateRoutePlanList --> i = " + i + ", bundle = " + bundle + ", routePlanNode = " + a2);
                }
                if (a2 != null) {
                    boolean z = bundle.getBoolean("isPassed", false);
                    a2.setGeoPoint(new GeoPoint(i4, i5));
                    a2.setFrom(1);
                    a2.setPassed(z);
                    a2.setUID(string);
                    a2.setIconType(i3);
                    arrayList.add(a2);
                }
            }
        }
        a(arrayList);
    }

    public void a(ArrayList<RoutePlanNode> arrayList) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNApproachPoiManager", "updateApproachListByApproachNodes --> routePlanNodes = " + arrayList);
        }
        if (arrayList != null && arrayList.size() >= 1) {
            ArrayList<a> arrayList2 = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList2.add(new a(arrayList.get(i)));
            }
            c(arrayList2);
            return;
        }
        c((ArrayList<a>) null);
    }

    public void b(ArrayList<RoutePlanNode> arrayList) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNApproachPoiManager", "updateApproachListByRoutePlanNodes --> routePlanNodes = " + arrayList);
        }
        if (arrayList != null && arrayList.size() >= 3) {
            ArrayList<a> arrayList2 = new ArrayList<>();
            for (int i = 1; i < arrayList.size() - 1; i++) {
                arrayList2.add(new a(arrayList.get(i)));
            }
            c(arrayList2);
            return;
        }
        c((ArrayList<a>) null);
    }

    public synchronized void c(ArrayList<a> arrayList) {
        try {
            if (LogUtil.LOGGABLE) {
                a("updateApproachPoiList", "newApproachList", arrayList);
                a("updateApproachPoiList", "mUnPassedApproachPoiList", this.f7211a);
                a("updateApproachPoiList", "mAllApproachPoiList", this.b);
            }
            if (f(arrayList)) {
                this.f7211a = null;
                this.b = null;
                return;
            }
            ArrayList<a> e = e(arrayList);
            if (f(e)) {
                return;
            }
            Iterator<a> it = e.iterator();
            while (it.hasNext()) {
                f(it.next());
            }
            if (LogUtil.LOGGABLE) {
                a("updateApproachPoiList", "mApproachPoiList after update", e);
            }
            this.b = e;
            ArrayList<a> d = d(e);
            this.f7211a = d;
            if (d != null) {
                Iterator<a> it2 = d.iterator();
                while (it2.hasNext()) {
                    a next = it2.next();
                    if (next != null && next.isPassed) {
                        it2.remove();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean d(a aVar) {
        return c(aVar) != null;
    }

    @NonNull
    public synchronized ArrayList<a> e() {
        h();
        if (f(this.f7211a)) {
            LogUtil.e("BNApproachPoiManager", "getUnPassedApproachPoiList --> mUnPassedApproachPoiList is null!!!");
            return new ArrayList<>();
        }
        if (LogUtil.LOGGABLE) {
            a("getUnPassedApproachPoiList", "mUnPassedApproachPoiList", this.f7211a);
        }
        return d(this.f7211a);
    }

    public int f() {
        ArrayList<a> arrayList = this.f7211a;
        if (arrayList == null) {
            return -1;
        }
        return arrayList.size();
    }

    private ArrayList<a> d(ArrayList<a> arrayList) {
        if (f(arrayList)) {
            return new ArrayList<>();
        }
        return new ArrayList<>(arrayList);
    }

    private void f(a aVar) {
        if (this.b == null) {
            this.b = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList(this.b);
        a aVar2 = this.c;
        if (aVar2 != null) {
            arrayList.add(aVar2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a aVar3 = (a) it.next();
            if (a(aVar.getUID(), aVar3.getUID())) {
                a(aVar, aVar3);
                return;
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            a aVar4 = (a) it2.next();
            if (aVar.getGeoPoint().approximate(aVar4.getGeoPoint()) && a(aVar.getName(), aVar4.getName())) {
                a(aVar, aVar4);
                return;
            }
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            a aVar5 = (a) it3.next();
            if (aVar.getGeoPoint().approximate(aVar5.getGeoPoint())) {
                if (!j.d()) {
                    if (aVar.mId == aVar5.mId) {
                        a(aVar, aVar5);
                        return;
                    }
                } else {
                    a(aVar, aVar5);
                    return;
                }
            }
        }
    }

    public int d() {
        return this.e;
    }

    private ArrayList<a> e(ArrayList<a> arrayList) {
        if (f(arrayList)) {
            return null;
        }
        ArrayList<a> arrayList2 = new ArrayList<>();
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().mo81clone());
        }
        return arrayList2;
    }

    public synchronized boolean a(a aVar, boolean z) {
        if (aVar != null) {
            if (aVar.getGeoPoint() != null) {
                ArrayList<a> arrayList = this.f7211a;
                if (arrayList != null && arrayList.size() >= 3) {
                    LogUtil.e("BNApproachPoiManager", "addApproachPoi --> mApproachPoiList size is more than 3!!!");
                    return false;
                }
                LogUtil.e("BNApproachPoiManager", "addApproachPoi --> approachPoi = " + aVar + ", isEndOfTheList = " + z);
                this.c = aVar.mo81clone();
                if (LogUtil.LOGGABLE) {
                    a("addApproachPoi", "mUnPassedApproachPoiList", this.f7211a);
                }
                return true;
            }
        }
        LogUtil.e("BNApproachPoiManager", "addApproachPoi --> addApproachPoi is false!!!");
        return false;
    }

    @NonNull
    public synchronized ArrayList<a> b() {
        h();
        if (f(this.b)) {
            LogUtil.e("BNApproachPoiManager", "getAllApproachPoiList --> mAllApproachPoiList is null!!!");
            return new ArrayList<>();
        }
        if (LogUtil.LOGGABLE) {
            a("getAllApproachPoiList", "mAllApproachPoiList", this.b);
        }
        return d(this.b);
    }

    public void e(a aVar) {
        this.d = aVar;
        if (aVar != null) {
            this.e = b(aVar);
        } else {
            this.e = -1;
        }
    }

    public void g() {
        this.e = -1;
        this.d = null;
    }

    public a b(GeoPoint geoPoint) {
        if (f(this.f7211a)) {
            LogUtil.e("BNApproachPoiManager", "getUnPassedApproachPoi --> approachPoi is null!!!");
            return null;
        }
        return c(new a(geoPoint));
    }

    public a a(GeoPoint geoPoint, String str, int i) {
        if (f(this.f7211a)) {
            LogUtil.e("BNApproachPoiManager", "getUnPassedApproachPoi --> approachPoi is null!!!");
            return null;
        }
        return c(new a(geoPoint, str, i));
    }

    public int b(a aVar) {
        a c;
        if (f(this.f7211a) || (c = c(aVar)) == null) {
            return -1;
        }
        for (int i = 0; i < this.f7211a.size(); i++) {
            if (this.f7211a.get(i).equals(c)) {
                return i;
            }
        }
        return -1;
    }

    private boolean f(ArrayList<a> arrayList) {
        return arrayList == null || arrayList.isEmpty();
    }

    public a a(String str, GeoPoint geoPoint) {
        if (f(this.f7211a)) {
            LogUtil.e("BNApproachPoiManager", "getUnPassedApproachPoi --> approachPoi is null!!!");
            return null;
        }
        return c(new a(str, geoPoint));
    }

    public a c(a aVar) {
        if (aVar != null && aVar.getGeoPoint() != null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNApproachPoiManager", "getUnPassedApproachPoi --> approachPoi using for search is " + aVar);
            }
            ArrayList<a> g2 = g(aVar);
            if (f(g2)) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BNApproachPoiManager", "getUnPassedApproachPoi --> approachPoi is null!!!");
                }
                return null;
            }
            Iterator<a> it = g2.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (a(next.getUID(), aVar.getUID())) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("BNApproachPoiManager", "getUnPassedApproachPoi --> approachPoi is " + next);
                    }
                    return next;
                }
            }
            Iterator<a> it2 = g2.iterator();
            while (it2.hasNext()) {
                a next2 = it2.next();
                if (a(next2.getName(), aVar.getName())) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("BNApproachPoiManager", "getUnPassedApproachPoi --> approachPoi is " + next2);
                    }
                    return next2;
                }
            }
            if (!j.d()) {
                Iterator<a> it3 = g2.iterator();
                while (it3.hasNext()) {
                    a next3 = it3.next();
                    int i = next3.mId;
                    if (i != 0 || aVar.mId != 0) {
                        if (i == aVar.mId) {
                            if (LogUtil.LOGGABLE) {
                                LogUtil.e("BNApproachPoiManager", "getUnPassedApproachPoi by id --> approachPoi is " + next3);
                            }
                            return next3;
                        }
                    }
                }
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNApproachPoiManager", "getUnPassedApproachPoi --> approachPoi is " + g2.get(0));
            }
            return g2.get(0);
        }
        LogUtil.e("BNApproachPoiManager", "getUnPassedApproachPoi --> approachPoi or geoPoint is null!!!");
        return null;
    }

    public a a(RoutePlanNode routePlanNode) {
        if (routePlanNode == null || routePlanNode.getGeoPoint() == null) {
            return null;
        }
        return c(new a(routePlanNode));
    }

    public boolean a(String str) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNApproachPoiManager", "isContainInUnPassedApproachPoiList uid: " + str);
        }
        if (TextUtils.isEmpty(str) || f(this.f7211a)) {
            return false;
        }
        Iterator<a> it = this.f7211a.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().mUID, str)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.equals(str2)) ? false : true;
    }

    private long a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        long longitudeE6 = geoPoint.getLongitudeE6() - geoPoint2.getLongitudeE6();
        long latitudeE6 = geoPoint.getLatitudeE6() - geoPoint2.getLatitudeE6();
        return (longitudeE6 * longitudeE6) + (latitudeE6 * latitudeE6);
    }

    public synchronized a a(GeoPoint geoPoint) {
        return a(new a(geoPoint));
    }

    public synchronized a a(a aVar) {
        LogUtil.e("BNApproachPoiManager", "deleteApproachPoi --> start delete!!!");
        if (f(this.f7211a)) {
            return null;
        }
        if (aVar != null && aVar.getGeoPoint() != null) {
            Iterator<a> it = this.f7211a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (a(next.getUID(), aVar.getUID())) {
                    it.remove();
                    if (LogUtil.LOGGABLE) {
                        a("deleteApproachPoi by uid", "mUnPassedApproachPoiList", this.f7211a);
                    }
                    return next;
                }
            }
            Iterator<a> it2 = this.f7211a.iterator();
            while (it2.hasNext()) {
                a next2 = it2.next();
                if (next2.getGeoPoint().approximate(aVar.getGeoPoint()) && a(next2.getName(), aVar.getName())) {
                    it2.remove();
                    if (LogUtil.LOGGABLE) {
                        a("deleteApproachPoi by name", "mUnPassedApproachPoiList", this.f7211a);
                    }
                    return next2;
                }
            }
            Iterator<a> it3 = this.f7211a.iterator();
            while (it3.hasNext()) {
                a next3 = it3.next();
                if (next3.getGeoPoint().approximate(aVar.getGeoPoint())) {
                    it3.remove();
                    if (LogUtil.LOGGABLE) {
                        a("deleteApproachPoi by point", "mUnPassedApproachPoiList", this.f7211a);
                    }
                    return next3;
                }
            }
            LogUtil.e("BNApproachPoiManager", "deleteApproachPoi --> deleteApproachPoi is false!!!");
            return null;
        }
        LogUtil.e("BNApproachPoiManager", "deleteApproachPoi --> approachPoi or geoPoint is null, deleteApproachPoi is false!!!");
        return null;
    }

    public boolean c(GeoPoint geoPoint) {
        boolean z = c(new a(geoPoint)) != null;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNApproachPoiManager", "isContainInUnPassedApproachPoiList --> ret is " + z);
        }
        return z;
    }

    public RoutePlanNode c() {
        return this.d;
    }

    public boolean a() {
        a aVar;
        boolean z = false;
        if (!f(this.f7211a) && !f(this.b) && (aVar = this.c) != null) {
            if (this.f7211a.remove(aVar) && this.b.remove(this.c)) {
                z = true;
            }
            LogUtil.e("BNApproachPoiManager", "deleteLatestAddedApproachPoi --> ret is " + z);
            return z;
        }
        LogUtil.e("BNApproachPoiManager", "deleteLatestAddedApproachPoi --> delete latest added approach poi failed!!!");
        return false;
    }

    private boolean a(a aVar, a aVar2) {
        if (aVar == null || aVar2 == null || !aVar.a(aVar2)) {
            return false;
        }
        if (!TextUtils.isEmpty(aVar.b())) {
            aVar2.b(aVar.b());
        }
        if (!TextUtils.isEmpty(aVar2.b())) {
            aVar.b(aVar2.b());
        }
        if (!TextUtils.isEmpty(aVar.a())) {
            aVar2.a(aVar.a());
        }
        if (TextUtils.isEmpty(aVar2.a())) {
            return true;
        }
        aVar.a(aVar2.a());
        return true;
    }

    private void a(String str, String str2, ArrayList<a> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" --> logList --> ");
            sb.append(str2);
            sb.append(" is : \n");
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append("第");
                sb.append(i);
                sb.append("个 = ");
                sb.append(arrayList.get(i).toString());
                sb.append("\n");
            }
            LogUtil.e("BNApproachPoiManager", sb.toString());
            return;
        }
        LogUtil.e("BNApproachPoiManager", str2 + " is empty");
    }
}
