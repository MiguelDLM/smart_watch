package com.baidu.mapapi.map;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class k implements com.baidu.mapsdkplatform.comapi.map.aa {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaiduMap f5903a;

    public k(BaiduMap baiduMap) {
        this.f5903a = baiduMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.aa
    public Bundle a(int i, int i2, int i3, Context context) {
        Lock lock;
        Lock lock2;
        TileOverlay tileOverlay;
        Lock lock3;
        TileOverlay tileOverlay2;
        boolean z;
        lock = this.f5903a.V;
        lock.lock();
        try {
            tileOverlay = this.f5903a.S;
            if (tileOverlay != null) {
                tileOverlay2 = this.f5903a.S;
                Tile a2 = tileOverlay2.a(i, i2, i3);
                StringBuilder sb = new StringBuilder();
                sb.append("mapLayerDataReq tile t == null = ");
                if (a2 == null) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                Log.e("SDKTileLayer", sb.toString());
                if (a2 != null) {
                    return a2.toBundle();
                }
            }
            lock3 = this.f5903a.V;
            lock3.unlock();
            return null;
        } finally {
            lock2 = this.f5903a.V;
            lock2.unlock();
        }
    }
}
