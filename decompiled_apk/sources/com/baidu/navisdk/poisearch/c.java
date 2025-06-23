package com.baidu.navisdk.poisearch;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.navisdk.cmdrequest.i;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.jni.nativeif.JNISearchControl;
import com.baidu.navisdk.model.datastruct.f;
import com.baidu.navisdk.model.datastruct.s;
import com.baidu.navisdk.model.datastruct.t;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class c implements JNISearchConst {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7634a = "c";

    public static boolean a(t tVar, int i, Handler handler) {
        if (tVar == null) {
            return false;
        }
        g.SEARCH.a("asynSearchWithPager1() -- " + LogUtil.getCallStack());
        i iVar = new i((Class<? extends com.baidu.navisdk.cmdrequest.a>) CmdSearchWithPager.class, 1, handler, 1005, i);
        CmdSearchWithPager.a(iVar, tVar);
        com.baidu.navisdk.cmdrequest.b.a().a(iVar);
        return true;
    }

    public static f b(int i) {
        return JNISearchControl.sInstance.getParentDistrict(i);
    }

    private static int c() {
        return JNISearchControl.sInstance.GetNetModeOfLastResult();
    }

    public static boolean b() {
        int i;
        try {
            i = JNISearchControl.sInstance.clearPoiCache();
        } catch (Throwable th) {
            LogUtil.e(f7634a, "clearPoiCache throwable: " + th);
            i = -1;
        }
        return i == 0;
    }

    public static int c(int i) {
        int c = c();
        if (i == 3) {
            return (c == 2 || c == 0) ? 3 : 1;
        }
        if (i == 2) {
            return (c == 3 || c == 1) ? 4 : 2;
        }
        return 1;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.length() <= 127) {
            return str;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(f7634a, "trimKeywordByLength() to trim.  input=" + str);
        }
        return str.substring(0, 127);
    }

    public static f a(GeoPoint geoPoint, int i) {
        LogUtil.e("PoiSearch", "getDistrictByPoint");
        return JNISearchControl.sInstance.getDistrictByPoint(geoPoint, i);
    }

    public static boolean a(GeoPoint geoPoint, int i, int i2, Handler handler) {
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e(f7634a, "asynGetPoiByPoint: " + geoPoint);
        }
        if (geoPoint == null) {
            return false;
        }
        i iVar = new i((Class<? extends com.baidu.navisdk.cmdrequest.a>) CmdSearchByPoint.class, 1, handler, 1003, i2);
        CmdSearchByPoint.a(iVar, 1, geoPoint, i);
        com.baidu.navisdk.cmdrequest.b.a().a(iVar);
        return true;
    }

    public static boolean a(GeoPoint geoPoint, int i, Handler handler) {
        if (geoPoint == null || !geoPoint.isValid()) {
            return false;
        }
        if (!com.baidu.navisdk.module.init.a.a()) {
            LogUtil.e("PoiSearch", "engine is not onCreateView succ...");
            return false;
        }
        i iVar = new i((Class<? extends com.baidu.navisdk.cmdrequest.a>) CmdSearchByPoint.class, 1, handler, 1003, i);
        CmdSearchByPoint.a(iVar, 2, geoPoint);
        com.baidu.navisdk.cmdrequest.b.a().a(iVar);
        return true;
    }

    public static f a(int i) {
        return JNISearchControl.sInstance.getDistrictById(i);
    }

    public static boolean a(ArrayList<GeoPoint> arrayList, int i, int i2, int i3) {
        if (arrayList == null) {
            return false;
        }
        LogUtil.e(f7634a, "updateBkgCacheInfo: GeoPoint --> type: " + i + ", source: " + i2);
        try {
            ArrayList<Bundle> arrayList2 = new ArrayList<>();
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                GeoPoint geoPoint = arrayList.get(i4);
                Bundle bundle = new Bundle();
                bundle.putInt("Id", i4);
                bundle.putInt(JNISearchConst.JNI_LONGITUDE, geoPoint.getLongitudeE6());
                bundle.putInt("Latitude", geoPoint.getLatitudeE6());
                arrayList2.add(bundle);
            }
            com.baidu.navisdk.poisearch.model.a.k().b(i);
            if (i2 == 2) {
                i2 = 1;
            }
            return JNISearchControl.sInstance.updateBkgCache(arrayList2, i, i2, i3) == 0;
        } catch (Exception e) {
            LogUtil.e(f7634a, "updateBkgCache() --> e = " + e);
            return false;
        }
    }

    public static boolean a(List<s> list, int i, int i2, int i3) {
        if (list == null) {
            return false;
        }
        LogUtil.e(f7634a, "updateBkgCacheInfo: SearchPoi --> type: " + i + ", source: " + i2);
        ArrayList<Bundle> arrayList = new ArrayList<>();
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            try {
                s sVar = list.get(i4);
                GeoPoint geoPoint = sVar.k;
                Bundle bundle = new Bundle();
                bundle.putInt("Id", i4);
                bundle.putInt(JNISearchConst.JNI_LONGITUDE, geoPoint.getLongitudeE6());
                bundle.putInt("Latitude", geoPoint.getLatitudeE6());
                bundle.putInt(JNISearchConst.JNI_POI_BRAND_ID, sVar.s);
                bundle.putInt(JNISearchConst.JNI_SHOP_OPEN_TIME_COLOR, sVar.x);
                if (!TextUtils.isEmpty(sVar.e)) {
                    bundle.putString("Name", sVar.e);
                }
                if (!TextUtils.isEmpty(sVar.t)) {
                    bundle.putString(JNISearchConst.JNI_POI_TAG, sVar.t);
                }
                if (!TextUtils.isEmpty(sVar.u)) {
                    bundle.putString(JNISearchConst.JNI_ROUTE_COST, sVar.u);
                }
                if (!TextUtils.isEmpty(sVar.y)) {
                    bundle.putString(JNISearchConst.JNI_SHOP_OPEN_TIME, sVar.y);
                }
                arrayList.add(bundle);
            } catch (Exception unused) {
                LogUtil.e(f7634a, "exception for android system : java.lang.String cannot be cast to java.lang.Object[]");
            }
        }
        com.baidu.navisdk.poisearch.model.a.k().b(i);
        if (i2 == 2) {
            i2 = 1;
        }
        return JNISearchControl.sInstance.updateBkgCache(arrayList, i, i2, i3) == 0;
    }

    public static boolean a() {
        int i;
        try {
            i = JNISearchControl.sInstance.clearBkgCache();
        } catch (Throwable th) {
            LogUtil.e(f7634a, "clearBkgCache throwable: " + th);
            i = -1;
        }
        return i == 0;
    }

    public static int a(String str) {
        if (str == null) {
            return -1;
        }
        String[] split = str.split("_");
        if (split.length != 3) {
            return -2;
        }
        try {
            return Integer.parseInt(split[0]);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static void a(int i, boolean z) {
        if (!z) {
            com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410315", "410315");
            return;
        }
        if (i == 1) {
            com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410311", "410311");
            return;
        }
        if (i == 2) {
            com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410312", "410312");
        } else if (i == 3) {
            com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410314", "410314");
        } else {
            if (i != 4) {
                return;
            }
            com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410313", "410313");
        }
    }
}
