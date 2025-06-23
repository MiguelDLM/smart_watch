package com.baidu.mapapi.map;

import com.baidu.mapapi.map.MyLocationConfiguration;

/* loaded from: classes7.dex */
/* synthetic */ class d {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f5896a;
    static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[com.baidu.mapsdkplatform.comapi.map.v.values().length];
        b = iArr;
        try {
            iArr[com.baidu.mapsdkplatform.comapi.map.v.TextureView.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[com.baidu.mapsdkplatform.comapi.map.v.GLSurfaceView.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[MyLocationConfiguration.LocationMode.values().length];
        f5896a = iArr2;
        try {
            iArr2[MyLocationConfiguration.LocationMode.COMPASS.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f5896a[MyLocationConfiguration.LocationMode.FOLLOWING.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f5896a[MyLocationConfiguration.LocationMode.NORMAL.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
