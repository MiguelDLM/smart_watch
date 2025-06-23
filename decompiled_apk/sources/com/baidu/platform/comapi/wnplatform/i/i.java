package com.baidu.platform.comapi.wnplatform.i;

import android.os.Bundle;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class i implements com.baidu.platform.comapi.wnplatform.c.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f9922a;

    public i(f fVar) {
        this.f9922a = fVar;
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.b
    public void a(WLocData wLocData) {
        if (wLocData == null) {
            return;
        }
        com.baidu.platform.comapi.walknavi.b.a().K().a(wLocData.longitude, wLocData.latitude, wLocData.speed, wLocData.direction, wLocData.accuracy, (float) wLocData.altitude, wLocData.buildingId, wLocData.floorId, wLocData.getLocType(), wLocData.coordType, wLocData.indoorState, wLocData.type, wLocData.networkLocType, wLocData.satellitesNum);
        Bundle bundle = new Bundle();
        bundle.putFloat("gpsSpeed", wLocData.speed);
        bundle.putFloat("gpsDirection", wLocData.direction);
        bundle.putDouble("gpsLongitude", wLocData.longitude);
        bundle.putDouble("gpsLatitude", wLocData.latitude);
        com.baidu.platform.comapi.wnplatform.model.f.a().a(7777, 0, 0, bundle);
    }
}
