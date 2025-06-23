package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.map.OverlayItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public /* synthetic */ class ac {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f9630a;
    static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[OverlayItem.AnimationSubType.values().length];
        b = iArr;
        try {
            iArr[OverlayItem.AnimationSubType.RADAR.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[OverlayItem.AnimationSubType.NONE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[OverlayItem.AnimEffect.values().length];
        f9630a = iArr2;
        try {
            iArr2[OverlayItem.AnimEffect.GROWTH.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f9630a[OverlayItem.AnimEffect.WAVE.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f9630a[OverlayItem.AnimEffect.SHRINK.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f9630a[OverlayItem.AnimEffect.FADE_OUT.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f9630a[OverlayItem.AnimEffect.FADE_IN.ordinal()] = 5;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f9630a[OverlayItem.AnimEffect.GROWTH_FADE_IN.ordinal()] = 6;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f9630a[OverlayItem.AnimEffect.SHRINK_FADE_OUT.ordinal()] = 7;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f9630a[OverlayItem.AnimEffect.GROWTH_REBOUND.ordinal()] = 8;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f9630a[OverlayItem.AnimEffect.ALPHA.ordinal()] = 9;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f9630a[OverlayItem.AnimEffect.ANCHOR_GROUTH.ordinal()] = 10;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f9630a[OverlayItem.AnimEffect.ROTATE.ordinal()] = 11;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            f9630a[OverlayItem.AnimEffect.NONE.ordinal()] = 12;
        } catch (NoSuchFieldError unused14) {
        }
    }
}
