package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import com.baidu.mapapi.map.BaiduMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class m implements com.baidu.platform.comapi.map.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaiduMap f5905a;

    public m(BaiduMap baiduMap) {
        this.f5905a = baiduMap;
    }

    @Override // com.baidu.platform.comapi.map.c
    public void a(Bitmap bitmap) {
        BaiduMap.SnapshotReadyCallback snapshotReadyCallback;
        snapshotReadyCallback = this.f5905a.K;
        snapshotReadyCallback.onSnapshotReady(bitmap);
    }
}
