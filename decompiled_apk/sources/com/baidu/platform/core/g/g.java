package com.baidu.platform.core.g;

import com.baidu.platform.base.SearchType;

/* loaded from: classes8.dex */
/* synthetic */ class g {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f10004a;

    static {
        int[] iArr = new int[SearchType.values().length];
        f10004a = iArr;
        try {
            iArr[SearchType.POI_DETAIL_SHARE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f10004a[SearchType.LOCATION_SEARCH_SHARE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
