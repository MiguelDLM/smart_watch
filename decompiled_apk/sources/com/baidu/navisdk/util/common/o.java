package com.baidu.navisdk.util.common;

import XIXIX.OOXIXo;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comjni.tools.JNITools;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.garmin.fit.xOxOoo;

/* loaded from: classes8.dex */
public class o {
    public static Bundle a(int i, int i2) {
        try {
            Bundle Bd09mcToGcj02 = JNITools.Bd09mcToGcj02(i, i2);
            if (Bd09mcToGcj02 != null) {
                return Bd09mcToGcj02;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("LLx", OOXIXo.f3760XO);
        bundle.putDouble("LLy", OOXIXo.f3760XO);
        return bundle;
    }

    public static Bundle b(double d, double d2) {
        try {
            Bundle Gcj02ToBd09mc = JNITools.Gcj02ToBd09mc(d, d2);
            if (Gcj02ToBd09mc != null) {
                return Gcj02ToBd09mc;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("MCx", 0);
        bundle.putInt("MCy", 0);
        return bundle;
    }

    public static Bundle c(int i, int i2) {
        try {
            Bundle Gcj02ToBd09mc = JNITools.Gcj02ToBd09mc(i / 100000.0d, i2 / 100000.0d);
            if (Gcj02ToBd09mc != null) {
                return Gcj02ToBd09mc;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Bundle bundle = new Bundle();
        bundle.putInt("MCx", 0);
        bundle.putInt("MCy", 0);
        return bundle;
    }

    public static Bundle d(double d, double d2) {
        Bundle Gcj02ToWgs84 = JNITools.Gcj02ToWgs84(d, d2);
        if (Gcj02ToWgs84 == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("LLx", 0);
            bundle.putInt("LLy", 0);
            return bundle;
        }
        return Gcj02ToWgs84;
    }

    public static GeoPoint e(double d, double d2) {
        GeoPoint geoPoint = new GeoPoint();
        Bundle Wgs84ToGcj02 = JNITools.Wgs84ToGcj02(d, d2);
        if (Wgs84ToGcj02 == null) {
            return geoPoint;
        }
        int i = (int) (Wgs84ToGcj02.getDouble("LLx") * 100000.0d);
        geoPoint.setLatitudeE6((int) (Wgs84ToGcj02.getDouble("LLy") * 100000.0d));
        geoPoint.setLongitudeE6(i);
        return geoPoint;
    }

    public static GeoPoint a(double d, double d2) {
        GeoPoint geoPoint = new GeoPoint();
        Bundle Bd09llToGcj02 = JNITools.Bd09llToGcj02(d, d2);
        if (Bd09llToGcj02 == null) {
            return geoPoint;
        }
        int i = (int) (Bd09llToGcj02.getDouble("LLx") * 100000.0d);
        geoPoint.setLatitudeE6((int) (Bd09llToGcj02.getDouble("LLy") * 100000.0d));
        geoPoint.setLongitudeE6(i);
        return geoPoint;
    }

    public static Bundle b(int i, int i2) {
        Bundle a2 = a(i, i2);
        if (a2 == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("LLx", 0);
            bundle.putInt("LLy", 0);
            return bundle;
        }
        int i3 = (int) (a2.getDouble("LLx") * 100000.0d);
        int i4 = (int) (a2.getDouble("LLy") * 100000.0d);
        a2.putInt("LLx", i3);
        a2.putInt("LLy", i4);
        return a2;
    }

    public static String c(double d, double d2) {
        Bundle b;
        if (d == -2.147483648E9d || d2 == -2.147483648E9d || (b = b(d, d2)) == null) {
            return null;
        }
        return b.getInt("MCx") + "," + b.getInt("MCy");
    }

    public static GeoPoint a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("strkey", str);
        JNITools.TransGeoStr2Pt(bundle);
        GeoPoint geoPoint = new GeoPoint();
        int i = bundle.getInt(MapBundleKey.MapObjKey.OBJ_SL_PTX, Integer.MIN_VALUE);
        int i2 = bundle.getInt(MapBundleKey.MapObjKey.OBJ_SL_PTY, Integer.MIN_VALUE);
        if (i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE) {
            Bundle b = b(i, i2);
            geoPoint.setLongitudeE6(b.getInt("LLx"));
            geoPoint.setLatitudeE6(b.getInt("LLy"));
        }
        return geoPoint;
    }

    public static double a(double d, double d2, double d3, double d4) {
        Bundle bundle = new Bundle();
        bundle.putDouble("x1", d);
        bundle.putDouble("y1", d2);
        bundle.putDouble("x2", d3);
        bundle.putDouble("y2", d4);
        JNITools.GetDistanceByMC(bundle);
        if (bundle.containsKey(xOxOoo.f15470o00)) {
            return bundle.getDouble(xOxOoo.f15470o00);
        }
        return -1.0d;
    }

    public static GeoPoint a(@Nullable com.baidu.nplatform.comapi.basestruct.c cVar) {
        if (cVar == null) {
            return new GeoPoint();
        }
        if (cVar.c() == 0 && cVar.d() == 0) {
            return new GeoPoint();
        }
        Bundle b = b(cVar.c(), cVar.d());
        GeoPoint geoPoint = new GeoPoint();
        geoPoint.setLongitudeE6(b.getInt("LLx", Integer.MIN_VALUE));
        geoPoint.setLatitudeE6(b.getInt("LLy", Integer.MIN_VALUE));
        return geoPoint;
    }

    public static com.baidu.nplatform.comapi.basestruct.c a(@Nullable GeoPoint geoPoint) {
        if (geoPoint == null) {
            return new com.baidu.nplatform.comapi.basestruct.c();
        }
        if (!geoPoint.isValid()) {
            return new com.baidu.nplatform.comapi.basestruct.c();
        }
        Bundle c = c(geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6());
        com.baidu.nplatform.comapi.basestruct.c cVar = new com.baidu.nplatform.comapi.basestruct.c();
        cVar.a(c.getInt("MCx", 0));
        cVar.b(c.getInt("MCy", 0));
        return cVar;
    }
}
