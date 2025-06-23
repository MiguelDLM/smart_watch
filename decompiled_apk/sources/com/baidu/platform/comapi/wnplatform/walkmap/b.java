package com.baidu.platform.comapi.wnplatform.walkmap;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class b implements BaiduMap.OnMapStatusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f9973a;

    public b(a aVar) {
        this.f9973a = aVar;
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChange(MapStatus mapStatus) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeFinish(MapStatus mapStatus) {
        f fVar;
        f fVar2;
        fVar = this.f9973a.d;
        if (fVar != null) {
            fVar2 = this.f9973a.d;
            fVar2.a();
        }
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus) {
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener
    public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
    }
}
