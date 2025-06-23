package com.baidu.navisdk.ui.routeguide.model;

import android.os.Bundle;

/* loaded from: classes8.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private int f8960a = -1;
    private int b = -1;
    private boolean c = false;
    private int d = 0;
    private Bundle e = null;

    public void a(int i) {
        this.f8960a = i;
    }

    public int b() {
        return this.f8960a;
    }

    public void c(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGIntervalCameraModel", "setSpeedLimitValue: " + i);
        }
        this.b = i;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.b;
    }

    public String toString() {
        String bundle;
        StringBuilder sb = new StringBuilder();
        sb.append("RGIntervalCameraModel{mIntervalCameraLength=");
        sb.append(this.f8960a);
        sb.append(", mSpeedLimitValue=");
        sb.append(this.b);
        sb.append(", mIsOverspeedWarning=");
        sb.append(this.c);
        sb.append(", mProgress=");
        sb.append(this.d);
        sb.append(", mLastdata=");
        Bundle bundle2 = this.e;
        if (bundle2 == null) {
            bundle = "null";
        } else {
            bundle = bundle2.toString();
        }
        sb.append(bundle);
        sb.append('}');
        return sb.toString();
    }

    public void a(boolean z) {
        this.c = z;
    }

    public void b(int i) {
        this.d = i;
    }

    public void a(Bundle bundle) {
        this.e = bundle;
    }

    public void a() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGIntervalCameraModel", "clear: ");
        }
        this.f8960a = -1;
        this.b = -1;
        this.c = false;
        this.d = 0;
        this.e = null;
    }

    public Bundle c() {
        return this.e;
    }
}
