package com.baidu.platform.core.d;

import com.baidu.platform.base.SearchType;

/* loaded from: classes8.dex */
/* synthetic */ class h {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f10002a;

    static {
        int[] iArr = new int[SearchType.values().length];
        f10002a = iArr;
        try {
            iArr[SearchType.POI_NEAR_BY_SEARCH.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f10002a[SearchType.POI_IN_CITY_SEARCH.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f10002a[SearchType.POI_IN_BOUND_SEARCH.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
