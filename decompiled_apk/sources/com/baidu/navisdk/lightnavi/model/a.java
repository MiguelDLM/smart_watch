package com.baidu.navisdk.lightnavi.model;

import android.os.Bundle;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f6890a;
    private int b;
    private int[] c = new int[2];
    private int[] d = new int[2];
    private int[] e = new int[3];
    private String[] f = new String[2];
    private String[] g = new String[2];
    private int h;
    private int i;
    private int j;

    public static a a(Bundle bundle) {
        a aVar = new a();
        if (bundle.containsKey("remainDis")) {
            aVar.a(bundle.getInt("remainDis"));
        }
        if (bundle.containsKey("remainTime")) {
            aVar.b(bundle.getInt("remainTime"));
        }
        if (bundle.containsKey("remaining_traffic_lights")) {
            aVar.c(bundle.getIntArray("remaining_traffic_lights"));
        }
        if (bundle.containsKey("auxiliary_remaining_distance")) {
            aVar.a(bundle.getIntArray("auxiliary_remaining_distance"));
        }
        if (bundle.containsKey("auxiliary_remaining_time")) {
            aVar.b(bundle.getIntArray("auxiliary_remaining_time"));
        }
        if (bundle.containsKey("auxiliary_label")) {
            aVar.a(bundle.getStringArray("auxiliary_label"));
        }
        bundle.containsKey("auxiliary_toll_info");
        return aVar;
    }

    public void b(int[] iArr) {
        this.c = iArr;
    }

    public int[] c() {
        return this.c;
    }

    public int d() {
        return this.f6890a;
    }

    public int e() {
        return this.b;
    }

    public int[] f() {
        return this.e;
    }

    public int g() {
        int i = 1;
        for (int i2 = 0; i2 < 2; i2++) {
            if (this.d[i2] > 0) {
                i++;
            }
        }
        return i;
    }

    public String toString() {
        return "RouteTabInfo{mCurrentRouteRemainingDistance=" + this.f6890a + ", mCurrentRouteRemainingTime=" + this.b + ", mAuxiliaryRemainingTimeArr=" + Arrays.toString(this.c) + ", mAuxiliaryRemainingDistanceArr=" + Arrays.toString(this.d) + ", mRemainingrafficTLightsArr=" + Arrays.toString(this.e) + ", mAuxLabelInfoArr=" + Arrays.toString(this.f) + ", mAuxTollInfoArr=" + Arrays.toString(this.g) + ", mCurRealRouteIndex=" + this.h + ", mRouteHideBitNum=" + this.i + ", mRemainRouteCount=" + this.j + '}';
    }

    public int[] b() {
        return this.d;
    }

    public void c(int[] iArr) {
        this.e = iArr;
    }

    public void b(int i) {
        this.b = i;
    }

    public void a(int[] iArr) {
        this.d = iArr;
    }

    public void a(int i) {
        this.f6890a = i;
    }

    public String[] a() {
        return this.f;
    }

    public void a(String[] strArr) {
        this.f = strArr;
    }
}
