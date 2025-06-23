package com.baidu.location.c;

import com.baidu.location.c.k;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public /* synthetic */ class l {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f5712a;

    static {
        int[] iArr = new int[k.a.values().length];
        f5712a = iArr;
        try {
            iArr[k.a.ONLY_CELL_MODE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f5712a[k.a.ONLY_WIFI_MODE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f5712a[k.a.GET_ALL_DATA.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
