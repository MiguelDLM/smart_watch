package com.baidu.navisdk.poisearch;

import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.navisdk.cmdrequest.i;
import com.baidu.navisdk.cmdrequest.j;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.jni.nativeif.JNISearchControl;
import com.baidu.navisdk.model.datastruct.f;
import com.baidu.navisdk.model.datastruct.q;
import com.baidu.navisdk.model.datastruct.s;
import com.baidu.navisdk.model.datastruct.t;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.statistic.o;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes7.dex */
public class CmdSearchWithPager extends com.baidu.navisdk.cmdrequest.a implements JNISearchConst {
    t c;

    public static void a(i iVar, t tVar) {
        iVar.d.put("param.search.pager", tVar);
    }

    private Bundle d(t tVar) {
        int min;
        q i = tVar.i();
        int e = tVar.e();
        f districtByPoint = JNISearchControl.sInstance.getDistrictByPoint(i.f6939a, e);
        if (districtByPoint != null) {
            int i2 = districtByPoint.f6925a;
            if (i2 == 2 || i2 == 3) {
                Bundle bundle = new Bundle();
                bundle.putInt("CatalogId", tVar.a());
                bundle.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(districtByPoint));
                bundle.putInt("HasCircle", 1);
                bundle.putInt("CenterX", i.f6939a.getLongitudeE6());
                bundle.putInt("CenterY", i.f6939a.getLatitudeE6());
                bundle.putInt("Radius", i.b);
                int b = tVar.b();
                if (e == 1) {
                    min = Math.min(b, 20);
                } else {
                    min = Math.min(b, 100);
                }
                bundle.putInt("PoiCount", min);
                bundle.putInt(JNISearchConst.JNI_POI_PAGERNUM, tVar.f());
                return bundle;
            }
            return null;
        }
        return null;
    }

    private Bundle e(t tVar) {
        int min;
        Bundle bundle = new Bundle();
        bundle.putInt("CatalogId", tVar.a());
        bundle.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(tVar.c()));
        bundle.putInt("HasCircle", 1);
        q i = tVar.i();
        bundle.putInt("CenterX", i.f6939a.getLongitudeE6());
        bundle.putInt("CenterY", i.f6939a.getLatitudeE6());
        bundle.putInt("Radius", i.b);
        int b = tVar.b();
        if (tVar.e() == 1) {
            min = Math.min(b, 20);
        } else {
            min = Math.min(b, 100);
        }
        bundle.putInt("PoiCount", min);
        bundle.putInt(JNISearchConst.JNI_POI_PAGERNUM, tVar.f());
        return bundle;
    }

    private Bundle f(t tVar) {
        int min;
        Bundle bundle = new Bundle();
        q i = tVar.i();
        int e = tVar.e();
        f districtByPoint = JNISearchControl.sInstance.getDistrictByPoint(i.f6939a, e);
        if (districtByPoint != null) {
            int i2 = districtByPoint.f6925a;
            if (i2 == 2 || i2 == 3) {
                bundle.putString("Name", c.b(tVar.j().toUpperCase(Locale.getDefault())));
                bundle.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(districtByPoint));
                bundle.putInt("HasCircle", 1);
                bundle.putInt("CenterX", i.f6939a.getLongitudeE6());
                bundle.putInt("CenterY", i.f6939a.getLatitudeE6());
                bundle.putInt("Radius", i.b);
                int b = tVar.b();
                if (e == 1) {
                    min = Math.min(b, 20);
                } else {
                    min = Math.min(b, 100);
                }
                bundle.putInt("PoiCount", min);
                bundle.putInt(JNISearchConst.JNI_POI_PAGERNUM, tVar.f());
                return bundle;
            }
            return null;
        }
        return null;
    }

    private Bundle g(t tVar) {
        int min;
        Bundle bundle = new Bundle();
        bundle.putString("Name", c.b(tVar.j().toUpperCase(Locale.getDefault())));
        bundle.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(tVar.c()));
        bundle.putInt("HasCircle", 1);
        q i = tVar.i();
        bundle.putInt("CenterX", i.f6939a.getLongitudeE6());
        bundle.putInt("CenterY", i.f6939a.getLatitudeE6());
        bundle.putInt("Radius", i.b);
        int b = tVar.b();
        if (tVar.e() == 1) {
            min = Math.min(b, 20);
        } else {
            min = Math.min(b, 100);
        }
        bundle.putInt("PoiCount", min);
        bundle.putInt(JNISearchConst.JNI_POI_PAGERNUM, tVar.f());
        return bundle;
    }

    @Override // com.baidu.navisdk.cmdrequest.a
    public void b(i iVar) {
        this.c = (t) iVar.d.get("param.search.pager");
    }

    @Override // com.baidu.navisdk.cmdrequest.a
    public void c() {
        com.baidu.navisdk.model.modelfactory.e eVar = (com.baidu.navisdk.model.modelfactory.e) com.baidu.navisdk.model.modelfactory.c.a().a("PoiSearchModel");
        ArrayList<s> g = this.c.g();
        if (eVar != null && g != null && g.size() > 0) {
            eVar.a(this.c);
        }
        i iVar = this.b;
        if (iVar.f) {
            return;
        }
        Message obtainMessage = iVar.e.obtainMessage(iVar.g);
        obtainMessage.arg1 = 0;
        obtainMessage.obj = new j(this.b, this.c);
        obtainMessage.sendToTarget();
        this.b.f = true;
    }

    private Bundle b(t tVar) {
        int min;
        Bundle bundle = new Bundle();
        bundle.putString("Name", c.b(tVar.j().toUpperCase(Locale.getDefault())));
        bundle.putInt("DistrictId", JNISearchControl.sInstance.getCompDistrictId(tVar.c()));
        int b = tVar.b();
        if (tVar.e() == 1) {
            min = Math.min(b, 20);
        } else {
            min = Math.min(b, 100);
        }
        bundle.putInt("PoiCount", min);
        bundle.putInt(JNISearchConst.JNI_POI_PAGERNUM, tVar.f());
        return bundle;
    }

    @Override // com.baidu.navisdk.cmdrequest.a
    public com.baidu.navisdk.cmdrequest.f a() {
        o n = o.n();
        n.l();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int a2 = a(this.c);
        if (a2 >= 0) {
            this.f6680a.c();
        } else {
            this.f6680a.a(a2);
        }
        ArrayList<s> g = this.c.g();
        if (g != null && g.size() > 0) {
            n.c(a2 >= 0);
        } else {
            n.c(false);
        }
        int c = c.c(this.c.e());
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        n.d(c);
        n.a(elapsedRealtime2);
        n.k();
        c.a(c, a2 >= 0);
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("CmdSearchWithPager", "nearby search cost " + elapsedRealtime2 + " ms!");
        }
        return this.f6680a;
    }

    private Bundle c(t tVar) {
        Bundle bundle = new Bundle();
        bundle.putString("Name", tVar.j().toUpperCase(Locale.getDefault()));
        if (tVar.q() != null) {
            bundle.putString(JNISearchConst.JNI_SUBTYPE, tVar.q().toUpperCase(Locale.getDefault()));
        }
        bundle.putInt(JNISearchConst.JNI_BRAND_ID, e.d(tVar.q()));
        bundle.putInt(JNISearchConst.JNI_MODE, tVar.k());
        bundle.putInt("Range", tVar.l());
        int p = tVar.p();
        if (p < 1 || p > 3) {
            p = 1;
        }
        bundle.putInt(JNISearchConst.JNI_SORT, p);
        bundle.putBoolean(JNISearchConst.JNI_IS_USE_NEW_CHARGE_CHANNEL, tVar.r());
        int b = tVar.b();
        if (!tVar.r()) {
            if (tVar.e() == 1) {
                b = Math.min(b, 30);
            } else {
                b = Math.min(b, 100);
            }
        }
        bundle.putInt("PoiCount", b);
        bundle.putInt(JNISearchConst.JNI_POI_PAGERNUM, tVar.f());
        LogUtil.e("CmdSearchWithPager", "getNameSearchByKeyWithRouteBundle: --> " + bundle);
        return bundle;
    }

    public int a(t tVar) {
        Bundle b;
        int searchByNameWithPager;
        if (tVar == null || !tVar.s()) {
            return -1;
        }
        Bundle bundle = null;
        switch (tVar.o()) {
            case 1:
                b = b(tVar);
                break;
            case 2:
                b = f(tVar);
                break;
            case 3:
                b = g(tVar);
                break;
            case 4:
                b = d(tVar);
                break;
            case 5:
                b = e(tVar);
                break;
            case 6:
                b = c(tVar);
                break;
            default:
                b = null;
                break;
        }
        if (b == null) {
            return -3;
        }
        ArrayList<Bundle> arrayList = new ArrayList<>();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = false;
        switch (tVar.o()) {
            case 1:
                searchByNameWithPager = JNISearchControl.sInstance.searchByNameWithPager(b, arrayList);
                break;
            case 2:
                searchByNameWithPager = JNISearchControl.sInstance.searchByNameWithPager(b, arrayList);
                break;
            case 3:
                searchByNameWithPager = JNISearchControl.sInstance.searchByNameWithPager(b, arrayList);
                break;
            case 4:
                searchByNameWithPager = JNISearchControl.sInstance.searchByCircleWithPager(b, arrayList);
                break;
            case 5:
                searchByNameWithPager = JNISearchControl.sInstance.searchByCircleWithPager(b, arrayList);
                break;
            case 6:
                bundle = new Bundle();
                searchByNameWithPager = JNISearchControl.sInstance.searchByKeyInRouteWithPager(b, bundle, arrayList);
                break;
            default:
                searchByNameWithPager = 0;
                break;
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e("CmdSearchWithPager", "nearby search engine cost " + elapsedRealtime2 + " ms!");
        }
        LogUtil.e("", "searchByName() ret: " + searchByNameWithPager);
        LogUtil.e("", "outputList count: " + arrayList.size());
        if (searchByNameWithPager < 0) {
            if (!LogUtil.LOGGABLE) {
                return -4;
            }
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "检索: ret = " + searchByNameWithPager);
            return -4;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            s parsePoiBundle = JNISearchControl.sInstance.parsePoiBundle(arrayList.get(i));
            if (parsePoiBundle != null) {
                tVar.a(parsePoiBundle);
            }
        }
        if (size > 0 && arrayList.get(0).getInt(JNISearchConst.JNI_POI_IS_LAST_PAGER, 0) > 0) {
            z = true;
        }
        tVar.a(z);
        if (bundle != null) {
            if (LogUtil.LOGGABLE) {
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "检索: enResult = " + bundle.getInt("enResult") + ", nStatus: " + bundle.getInt("nStatus"));
            }
            tVar.b(bundle.getInt("enResult"));
            tVar.c(bundle.getInt("nStatus"));
            tVar.a(bundle.getInt("enType"));
        }
        return size;
    }
}
