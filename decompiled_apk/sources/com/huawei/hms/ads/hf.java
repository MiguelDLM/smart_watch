package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.FriendlyObstructionPurpose;

/* loaded from: classes10.dex */
public enum hf implements hh {
    VIDEO_CONTROLS,
    CLOSE_AD,
    NOT_VISIBLE,
    OTHER;

    private static boolean B;

    /* renamed from: com.huawei.hms.ads.hf$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[hf.values().length];
            Code = iArr;
            try {
                iArr[hf.VIDEO_CONTROLS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[hf.CLOSE_AD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[hf.NOT_VISIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[hf.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        B = false;
        B = gw.Code(gw.m);
    }

    public static FriendlyObstructionPurpose Code(hf hfVar) {
        if (!B) {
            return null;
        }
        int i = AnonymousClass1.Code[hfVar.ordinal()];
        if (i == 1) {
            return FriendlyObstructionPurpose.VIDEO_CONTROLS;
        }
        if (i == 2) {
            return FriendlyObstructionPurpose.CLOSE_AD;
        }
        if (i == 3) {
            return FriendlyObstructionPurpose.NOT_VISIBLE;
        }
        if (i != 4) {
            return null;
        }
        return FriendlyObstructionPurpose.OTHER;
    }

    public static boolean Code() {
        return B;
    }
}
