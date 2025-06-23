package com.baidu.navisdk.ui.routeguide.model;

import android.os.Bundle;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;

/* loaded from: classes8.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public int f8945a = 0;
    public int b = 0;
    public int c = 0;
    public long d = 0;
    private Bundle e = new Bundle();

    public void a(int i, int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDestinationEtaModel", "updateRemainDistAndTime nDist=" + i + ", nTime=" + i2);
        }
        this.f8945a = i;
        this.b = i2;
        this.d = System.currentTimeMillis() + (i2 * 1000);
        this.e.putInt("updatetype", 2);
        this.e.putInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalDist, i);
        this.e.putInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalTime, i2);
    }

    public void b() {
        this.b = 0;
        this.f8945a = 0;
        this.d = 0L;
        this.e.clear();
    }

    public String toString() {
        return "RGDestinationEtaModel{remainDist=" + this.f8945a + ", remainTime=" + this.b + ", trafficLights=" + this.c + ", arriveTime=" + this.d + ", mTotalInfoBundle=" + this.e + '}';
    }

    public Bundle a() {
        return this.e;
    }
}
