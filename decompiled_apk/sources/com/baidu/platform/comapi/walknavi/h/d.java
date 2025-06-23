package com.baidu.platform.comapi.walknavi.h;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class d implements BaiduMap.OnBaseIndoorMapListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9799a;

    public d(b bVar) {
        this.f9799a = bVar;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnBaseIndoorMapListener
    public void onBaseIndoorMapMode(boolean z, MapBaseIndoorMapInfo mapBaseIndoorMapInfo) {
        if (z && mapBaseIndoorMapInfo != null) {
            if (com.baidu.platform.comapi.wnplatform.f.a().d()) {
                this.f9799a.d.a(mapBaseIndoorMapInfo);
                return;
            }
            return;
        }
        this.f9799a.d.c();
    }
}
