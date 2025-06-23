package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes8.dex */
public class BaseMapCallback {

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<Long, a> f9980a = new ConcurrentHashMap<>(2);
    private static final ConcurrentHashMap<Long, com.baidu.mapsdkplatform.comjni.a.a.a> b = new ConcurrentHashMap<>(2);

    public static void release(long j) {
        f9980a.remove(Long.valueOf(j));
        b.remove(Long.valueOf(j));
    }

    public static int reqLayerData(Bundle bundle, long j, int i) {
        ConcurrentHashMap<Long, a> concurrentHashMap = f9980a;
        if (concurrentHashMap.isEmpty()) {
            return 0;
        }
        Iterator<Map.Entry<Long, a>> it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (value != null && value.a(j)) {
                return value.a(bundle, j, i);
            }
        }
        Iterator<Map.Entry<Long, com.baidu.mapsdkplatform.comjni.a.a.a>> it2 = b.entrySet().iterator();
        while (it2.hasNext()) {
            com.baidu.mapsdkplatform.comjni.a.a.a value2 = it2.next().getValue();
            if (value2 != null && value2.a(j)) {
                return value2.a(bundle, j, i);
            }
        }
        return 0;
    }

    public static boolean setMapCallback(long j, a aVar) {
        if (aVar != null && j != 0) {
            f9980a.put(Long.valueOf(j), aVar);
            return true;
        }
        return false;
    }

    public static boolean setMapSDKCallback(long j, com.baidu.mapsdkplatform.comjni.a.a.a aVar) {
        if (aVar != null && j != 0) {
            b.put(Long.valueOf(j), aVar);
            return true;
        }
        return false;
    }
}
