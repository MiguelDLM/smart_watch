package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.map.BaiduMap;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class j implements com.baidu.mapsdkplatform.comapi.map.l {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaiduMap f5902a;

    public j(BaiduMap baiduMap) {
        this.f5902a = baiduMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public Bundle a(int i, int i2) {
        Lock lock;
        Lock lock2;
        HeatMap heatMap;
        Lock lock3;
        BaiduMap.OnHeatMapDrawFrameCallBack onHeatMapDrawFrameCallBack;
        HeatMap heatMap2;
        Lock lock4;
        Lock lock5;
        BaiduMap.OnHeatMapDrawFrameCallBack onHeatMapDrawFrameCallBack2;
        lock = this.f5902a.U;
        lock.lock();
        try {
            heatMap = this.f5902a.T;
            if (heatMap != null) {
                onHeatMapDrawFrameCallBack = this.f5902a.Q;
                if (onHeatMapDrawFrameCallBack != null) {
                    onHeatMapDrawFrameCallBack2 = this.f5902a.Q;
                    onHeatMapDrawFrameCallBack2.frameIndex(i);
                }
                heatMap2 = this.f5902a.T;
                HeatMapData data = heatMap2.getData(i, i2);
                if (data == null) {
                    lock5 = this.f5902a.U;
                    lock5.unlock();
                    return null;
                }
                Bundle bundle = data.toBundle();
                lock4 = this.f5902a.U;
                lock4.unlock();
                return bundle;
            }
            lock3 = this.f5902a.U;
            lock3.unlock();
            return null;
        } catch (Throwable th) {
            lock2 = this.f5902a.U;
            lock2.unlock();
            throw th;
        }
    }
}
