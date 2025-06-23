package com.baidu.nplatform.comjni.map.basemap;

import android.os.Bundle;
import android.util.SparseArray;

/* loaded from: classes8.dex */
public class BaseMapCallback {
    private static SparseArray<a> mCallbacks = new SparseArray<>(2);

    public static int ReqLayerData(Bundle bundle, int i, int i2) {
        int size = mCallbacks.size();
        if (size == 0) {
            return 0;
        }
        for (int i3 = 0; i3 < size; i3++) {
            a valueAt = mCallbacks.valueAt(i3);
            if (valueAt != null && valueAt.a(i)) {
                return valueAt.a(bundle, i, i2);
            }
        }
        return 0;
    }

    public boolean SetMapCallback(a aVar) {
        if (aVar == null) {
            return false;
        }
        mCallbacks.put(0, aVar);
        return true;
    }
}
