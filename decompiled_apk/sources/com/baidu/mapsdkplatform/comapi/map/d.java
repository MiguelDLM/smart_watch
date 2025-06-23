package com.baidu.mapsdkplatform.comapi.map;

import com.baidu.mapapi.map.MapLayer;

/* loaded from: classes7.dex */
/* synthetic */ class d {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f6180a;

    static {
        int[] iArr = new int[MapLayer.values().length];
        f6180a = iArr;
        try {
            iArr[MapLayer.MAP_LAYER_LOCATION.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f6180a[MapLayer.MAP_LAYER_OVERLAY.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f6180a[MapLayer.BM_LAYER_OVERLAY.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f6180a[MapLayer.MAP_LAYER_HEATMAP.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f6180a[MapLayer.MAP_LAYER_INDOOR_POI.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f6180a[MapLayer.MAP_LAYER_POI_MARKER.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
