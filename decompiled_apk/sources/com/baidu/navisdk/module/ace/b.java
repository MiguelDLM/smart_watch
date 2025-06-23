package com.baidu.navisdk.module.ace;

import android.os.Bundle;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.o;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public List<com.baidu.nplatform.comapi.basestruct.c> f6966a = new ArrayList();

    public static List<b> a(Bundle bundle) {
        g gVar = g.MAP;
        if (gVar.d()) {
            gVar.e("ACEAoiModel", "parseData(), bundle = " + bundle);
        }
        if (bundle == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Bundle[] bundleArr = (Bundle[]) bundle.getParcelableArray("area_array");
        if (bundleArr == null) {
            return null;
        }
        for (Bundle bundle2 : bundleArr) {
            b bVar = new b();
            bundle2.getLong("id");
            Bundle[] bundleArr2 = (Bundle[]) bundle2.getParcelableArray("point_array");
            if (bundleArr2 != null) {
                for (Bundle bundle3 : bundleArr2) {
                    Bundle b = o.b(bundle3.getDouble("pointX"), bundle3.getDouble("pointY"));
                    bVar.f6966a.add(new com.baidu.nplatform.comapi.basestruct.c(b.getInt("MCx"), b.getInt("MCy")));
                }
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }
}
