package com.baidu.mapapi.map;

import com.baidu.mapapi.map.InfoWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class f implements InfoWindow.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaiduMap f5898a;

    public f(BaiduMap baiduMap) {
        this.f5898a = baiduMap;
    }

    @Override // com.baidu.mapapi.map.InfoWindow.a
    public void a(InfoWindow infoWindow) {
        this.f5898a.hideInfoWindow(infoWindow);
    }

    @Override // com.baidu.mapapi.map.InfoWindow.a
    public void b(InfoWindow infoWindow) {
        this.f5898a.a(infoWindow);
    }
}
