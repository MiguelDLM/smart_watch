package com.baidu.mapsdkplatform.comjni.tools;

import android.os.Bundle;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comjni.tools.ParcelItem;
import com.garmin.fit.xOxOoo;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class a {
    public static com.baidu.platform.comapi.basestruct.a a(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("strkey", str);
        JNITools.TransGeoStr2ComplexPt(bundle);
        com.baidu.platform.comapi.basestruct.a aVar = new com.baidu.platform.comapi.basestruct.a();
        Bundle bundle2 = bundle.getBundle("map_bound");
        if (bundle2 != null) {
            Bundle bundle3 = bundle2.getBundle("ll");
            if (bundle3 != null) {
                aVar.b = new Point((int) bundle3.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTX), (int) bundle3.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTY));
            }
            Bundle bundle4 = bundle2.getBundle("ru");
            if (bundle4 != null) {
                aVar.c = new Point((int) bundle4.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTX), (int) bundle4.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTY));
            }
        }
        for (ParcelItem parcelItem : (ParcelItem[]) bundle.getParcelableArray("poly_line")) {
            if (aVar.d == null) {
                aVar.d = new ArrayList<>();
            }
            Bundle bundle5 = parcelItem.getBundle();
            if (bundle5 != null) {
                ParcelItem[] parcelItemArr = (ParcelItem[]) bundle5.getParcelableArray("point_array");
                ArrayList<Point> arrayList = new ArrayList<>();
                for (ParcelItem parcelItem2 : parcelItemArr) {
                    Bundle bundle6 = parcelItem2.getBundle();
                    if (bundle6 != null) {
                        arrayList.add(new Point((int) bundle6.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTX), (int) bundle6.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTY)));
                    }
                }
                arrayList.trimToSize();
                aVar.d.add(arrayList);
            }
        }
        aVar.d.trimToSize();
        aVar.f9538a = (int) bundle.getDouble("type");
        return aVar;
    }

    public static void b() {
        JNITools.initClass(new Bundle(), 0);
    }

    public static double a(Point point, Point point2) {
        Bundle bundle = new Bundle();
        bundle.putDouble("x1", point.x);
        bundle.putDouble("y1", point.y);
        bundle.putDouble("x2", point2.x);
        bundle.putDouble("y2", point2.y);
        JNITools.GetDistanceByMC(bundle);
        return bundle.getDouble(xOxOoo.f15470o00);
    }

    public static String a() {
        return JNITools.GetToken();
    }

    public static void a(boolean z, int i) {
        JNITools.openLogEnable(z, i);
    }
}
