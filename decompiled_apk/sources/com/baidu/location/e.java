package com.baidu.location;

import com.baidu.location.LocationClientOption;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public /* synthetic */ class e {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f5719a;

    static {
        int[] iArr = new int[LocationClientOption.LocationMode.values().length];
        f5719a = iArr;
        try {
            iArr[LocationClientOption.LocationMode.Hight_Accuracy.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f5719a[LocationClientOption.LocationMode.Battery_Saving.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f5719a[LocationClientOption.LocationMode.Device_Sensors.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f5719a[LocationClientOption.LocationMode.Fuzzy_Locating.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
