package com.baidu.mapapi.map;

import com.baidu.mapapi.map.PolylineOptions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public /* synthetic */ class aa {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f5877a;
    static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[PolylineOptions.LineCapType.values().length];
        b = iArr;
        try {
            iArr[PolylineOptions.LineCapType.LineCapButt.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[PolylineOptions.LineCapType.LineCapRound.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[PolylineOptions.LineJoinType.values().length];
        f5877a = iArr2;
        try {
            iArr2[PolylineOptions.LineJoinType.LineJoinBevel.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f5877a[PolylineOptions.LineJoinType.LineJoinMiter.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f5877a[PolylineOptions.LineJoinType.LineJoinRound.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
