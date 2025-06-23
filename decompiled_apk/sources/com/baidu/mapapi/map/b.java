package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import com.baidu.mapapi.map.BaiduMap;

/* loaded from: classes7.dex */
class b implements com.baidu.platform.comapi.map.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaiduMap f5894a;

    public b(BaiduMap baiduMap) {
        this.f5894a = baiduMap;
    }

    @Override // com.baidu.platform.comapi.map.c
    public void a(Bitmap bitmap) {
        BaiduMap.SnapshotReadyCallback snapshotReadyCallback;
        snapshotReadyCallback = this.f5894a.K;
        snapshotReadyCallback.onSnapshotReady(bitmap);
    }
}
