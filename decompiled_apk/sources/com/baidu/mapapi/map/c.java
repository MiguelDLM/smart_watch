package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import com.baidu.mapapi.map.BaiduMap;

/* loaded from: classes7.dex */
class c implements com.baidu.platform.comapi.map.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaiduMap f5895a;

    public c(BaiduMap baiduMap) {
        this.f5895a = baiduMap;
    }

    @Override // com.baidu.platform.comapi.map.c
    public void a(Bitmap bitmap) {
        BaiduMap.SnapshotReadyCallback snapshotReadyCallback;
        snapshotReadyCallback = this.f5895a.K;
        snapshotReadyCallback.onSnapshotReady(bitmap);
    }
}
