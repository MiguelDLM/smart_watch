package com.baidu.platform.comapi.wnplatform.p;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;

/* loaded from: classes8.dex */
public class e {
    public static void a(String str, String str2, boolean z) {
        BaiduMap map;
        com.baidu.platform.comapi.wnplatform.walkmap.d N = com.baidu.platform.comapi.walknavi.b.a().N();
        if (N != null && N.a() != null && (map = N.a().getMap()) != null) {
            map.switchBaseIndoorMapFloor(str, str2);
            MapStatus mapStatus = map.getMapStatus();
            if (mapStatus != null && mapStatus.overlook != 0.0f) {
                map.setMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder(mapStatus).overlook(0.0f).build()));
            }
        }
        if (z) {
            com.baidu.platform.comapi.walknavi.b.a().K().a(str2, str);
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.GUIDING_TO_SEGMENTBROWSE);
            com.baidu.platform.comapi.walknavi.b.a().M().run("强诱导转到分段");
            com.baidu.platform.comapi.walknavi.b.a().K().k();
        }
    }

    public static void a(boolean z) {
        BaiduMap map;
        com.baidu.platform.comapi.wnplatform.walkmap.d N = com.baidu.platform.comapi.walknavi.b.a().N();
        if (N == null || N.a() == null || (map = N.a().getMap()) == null) {
            return;
        }
        map.setIndoorEnable(z);
    }
}
