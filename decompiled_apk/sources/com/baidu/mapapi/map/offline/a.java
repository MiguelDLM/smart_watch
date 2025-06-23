package com.baidu.mapapi.map.offline;

import com.baidu.mapsdkplatform.comapi.map.n;
import com.baidu.mapsdkplatform.comapi.map.r;
import java.util.ArrayList;

/* loaded from: classes7.dex */
class a implements r {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MKOfflineMap f5908a;

    public a(MKOfflineMap mKOfflineMap) {
        this.f5908a = mKOfflineMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.r
    public void a(int i, int i2) {
        MKOfflineMapListener mKOfflineMapListener;
        MKOfflineMapListener mKOfflineMapListener2;
        MKOfflineMapListener mKOfflineMapListener3;
        MKOfflineMapListener mKOfflineMapListener4;
        n nVar;
        if (i != 4) {
            if (i == 6) {
                mKOfflineMapListener2 = this.f5908a.c;
                mKOfflineMapListener2.onGetOfflineMapState(6, i2);
                return;
            }
            if (i != 8) {
                if (i == 10) {
                    mKOfflineMapListener4 = this.f5908a.c;
                    mKOfflineMapListener4.onGetOfflineMapState(2, i2);
                    return;
                } else {
                    if (i == 12) {
                        nVar = this.f5908a.b;
                        nVar.a(true, false);
                        return;
                    }
                    return;
                }
            }
            int i3 = i2 >> 8;
            mKOfflineMapListener3 = this.f5908a.c;
            mKOfflineMapListener3.onGetOfflineMapState(0, i3);
            return;
        }
        ArrayList<MKOLUpdateElement> allUpdateInfo = this.f5908a.getAllUpdateInfo();
        if (allUpdateInfo != null) {
            for (MKOLUpdateElement mKOLUpdateElement : allUpdateInfo) {
                if (mKOLUpdateElement.update) {
                    mKOfflineMapListener = this.f5908a.c;
                    mKOfflineMapListener.onGetOfflineMapState(4, mKOLUpdateElement.cityID);
                }
            }
        }
    }
}
