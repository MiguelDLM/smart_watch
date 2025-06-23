package com.baidu.platform.core.f;

import com.baidu.platform.base.SearchType;

/* loaded from: classes8.dex */
/* synthetic */ class l {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f10003a;

    static {
        int[] iArr = new int[SearchType.values().length];
        f10003a = iArr;
        try {
            iArr[SearchType.TRANSIT_ROUTE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f10003a[SearchType.DRIVE_ROUTE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f10003a[SearchType.WALK_ROUTE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
