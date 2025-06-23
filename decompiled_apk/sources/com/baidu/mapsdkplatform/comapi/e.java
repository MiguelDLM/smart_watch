package com.baidu.mapsdkplatform.comapi;

import com.baidu.mapsdkplatform.comapi.NativeLoader;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public /* synthetic */ class e {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f6162a;

    static {
        int[] iArr = new int[NativeLoader.a.values().length];
        f6162a = iArr;
        try {
            iArr[NativeLoader.a.ARM64.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f6162a[NativeLoader.a.ARMV7.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f6162a[NativeLoader.a.ARMEABI.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f6162a[NativeLoader.a.X86_64.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f6162a[NativeLoader.a.X86.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
